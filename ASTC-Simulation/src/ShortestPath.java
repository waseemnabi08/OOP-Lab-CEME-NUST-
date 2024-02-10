import java.util.*;

public class ShortestPath {
    private final Map<String, Map<String, Integer>> adjacencyMap;

    public ShortestPath(Graph graph) {
        adjacencyMap = graph.getAdjacencyMap();
    }




    public int shortestDistance(String source, String destination) {
        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> previous = new HashMap<>();
        PriorityQueue<String> queue = new PriorityQueue<>(Comparator.comparingInt(distances::get));

        for (String vertex : adjacencyMap.keySet()) {
            if (vertex.equals(source)) {
                distances.put(vertex, 0);
                queue.offer(vertex);
            } else {
                distances.put(vertex, Integer.MAX_VALUE);
            }
            previous.put(vertex, null);
        }

        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (current.equals(destination)) {
                break;
            }
            for (Map.Entry<String, Integer> neighbor : adjacencyMap.get(current).entrySet()) {
                int newDistance = distances.get(current) + neighbor.getValue();
                if (newDistance < distances.get(neighbor.getKey())) {
                    distances.put(neighbor.getKey(), newDistance);
                    previous.put(neighbor.getKey(), current);
                    queue.offer(neighbor.getKey());
                }
            }
        }

        return distances.get(destination);
    }

    public List<String> shortestPath(String source, String destination) {
        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> previous = new HashMap<>();
        PriorityQueue<String> queue = new PriorityQueue<>(Comparator.comparingInt(distances::get));

        for (String vertex : adjacencyMap.keySet()) {
            if (vertex.equals(source)) {
                distances.put(vertex, 0);
                queue.offer(vertex);
            } else {
                distances.put(vertex, Integer.MAX_VALUE);
            }
            previous.put(vertex, null);
        }

        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (current.equals(destination)) {
                break;
            }
            for (Map.Entry<String, Integer> neighbor : adjacencyMap.get(current).entrySet()) {
                int newDistance = distances.get(current) + neighbor.getValue();
                if (newDistance < distances.get(neighbor.getKey())) {
                    distances.put(neighbor.getKey(), newDistance);
                    previous.put(neighbor.getKey(), current);
                    queue.offer(neighbor.getKey());
                }
            }
        }

        List<String> path = new ArrayList<>();
        String current = destination;
        while (current != null) {
            path.add(0, current);
            current = previous.get(current);
        }

        return path;
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex( "A");
        graph.addVertex( "B");
        graph.addVertex( "C");
        graph.addVertex( "D");
        graph.addVertex( "E");
        graph.addVertex( "F");
        graph.addVertex("G");
        graph.addVertex( "H");
        graph.addVertex( "I");
        graph.addVertex( "J");
        graph.addVertex( "K");
        graph.addVertex( "L");
        graph.addVertex( "M");
        graph.addVertex( "N");
        graph.addVertex( "O");
        graph.addVertex( "P");
        graph.addVertex( "Q");
        graph.addVertex( "R");
        graph.addVertex( "S");
        graph.addVertex( "T");
        graph.addVertex( "Z");
        graph.addEdge("A","B", 2);
        graph.addEdge("A","C", 4);
        graph.addEdge("A","D", 1);
        graph.addEdge("B","E", 1);
        graph.addEdge("C", "E", 2);
        graph.addEdge("C", "F", 2);
        

    }

    


}
