import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class WebCrawler {
    private static final int THREAD_POOL_SIZE = 4;
    private static final int MAX_DEPTH = 3; // Maximum depth for crawling

    private static final Set<String> visitedURLs = ConcurrentHashMap.newKeySet();
    private static final BlockingQueue<String> urlQueue = new LinkedBlockingQueue<>();

    private static final String CSV_FILE_PATH = "crawled_data.csv";

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        try {
            crawl("http://www.nust.edu.pk", 0, executorService);

            executorService.shutdown();
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void crawl(String url, int depth, ExecutorService executorService) {
        if (depth > MAX_DEPTH || visitedURLs.contains(url)) {
            return;
        }

        visitedURLs.add(url);

        executorService.submit(() -> {
            try {
                String pageContent = downloadPage(url);
                System.out.println("Crawled: " + url);

                saveToCsv(url);

                List<String> links = getLinks(pageContent);

                for (String link : links) {
                    urlQueue.offer(link);
                    crawl(link, depth + 1, executorService);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private static String downloadPage(String url) throws IOException {
        URL pageUrl = new URL(url);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(pageUrl.openStream()))) {
            StringBuilder pageContent = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                pageContent.append(line);
                pageContent.append(System.lineSeparator());
            }
            return pageContent.toString();
        }
    }

    private static List<String> getLinks(String pageContent) {
        List<String> links = new ArrayList<>();
        Matcher matcher = Pattern.compile("<a\\s+(?:[^>]*?\\s+)?href=([\"'])(.*?)\\1", Pattern.DOTALL).matcher(pageContent);
        while (matcher.find()) {
            links.add(matcher.group(2));
        }
        return links;
    }

    private static void saveToCsv(String... data) {
        try (FileWriter csvWriter = new FileWriter(CSV_FILE_PATH, true)) {
            for (String value : data) {
                csvWriter.append(value);
                csvWriter.append(",");
            }
            csvWriter.append("\n");
            csvWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
