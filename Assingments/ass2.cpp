#include <opencv2/opencv.hpp>
#include <iostream>

using namespace std;
using namespace cv;

class ImageProcessor {
private:
    Mat originalImage;
    Mat processedImage;

public:
    Mat loadImage(const string& filePath) const {
        Mat image = imread(filePath);
        if (image.empty()) {
            cerr << "Error: Could not open or find the image." << endl;
        }
        return image;
    }

    void displayImage(const Mat& image, const string& windowName) const {
        imshow(windowName, image);
        waitKey(0);
    }

    void saveImage(const Mat& image, const string& filePath) const {
        if (!image.empty()) {
            imwrite(filePath, image);
            cout << "Image saved successfully as " << filePath << endl;
        }
        else {
            cerr << "Error: Unable to save image. Input image is empty." << endl;
        }
    }

    Mat resizeImage(const Mat& inputImage, int width, int height) {
        if (inputImage.empty()) {
            cerr << "Error: Unable to resize image. Input image is empty." << endl;
            return Mat();
        }
        char response;
        Mat resizedImage;

        do {
            double aspectRatio = static_cast<double>(inputImage.cols) / static_cast<double>(inputImage.rows);
            int newHeight = static_cast<int>(width / aspectRatio);

            resize(inputImage, resizedImage, Size(width, newHeight));

            displayImage(resizedImage, "Resized Image");

            cout << "Are you okay with this image? (Y/N): ";
            cin >> response;
        } while (response != 'Y' && response != 'y');

        processedImage = resizedImage;
        return processedImage;
    }

    Mat cropImage(const Mat& inputImage, int x, int y, int width, int height) {
        if (inputImage.empty()) {
            cerr << "Error: Unable to crop image. Input image is empty." << endl;
            return Mat();
        }

        char response;
        Mat croppedImage;

        do {
            Rect roi(x, y, width, height);
            croppedImage = inputImage(roi).clone();

            displayImage(croppedImage, "Cropped Image");

            cout << "Are you okay with this image? (Y/N): ";
            cin >> response;
        } while (response != 'Y' && response != 'y');

        processedImage = croppedImage;
        return processedImage;
    }

    Mat rotateImage(const Mat& inputImage, double angle) {
        if (inputImage.empty()) {
            cerr << "Error: Unable to rotate image. Input image is empty." << endl;
            return cv::Mat();
        }

        char response;
        Mat rotatedImage;

        do {
            Point2f center(static_cast<float>(inputImage.cols) / 2, static_cast<float>(inputImage.rows) / 2);
            Mat rotationMatrix = getRotationMatrix2D(center, angle, 1.0);

            warpAffine(inputImage, rotatedImage, rotationMatrix, inputImage.size());

            displayImage(rotatedImage, "Rotated Image");

            cout << "Are you okay with this image? (Y/N): ";
            cin >> response;
        } while (response != 'Y' && response != 'y');

        processedImage = rotatedImage;
        return processedImage;
    }

    Mat applyFilter(const Mat& image) {
        char response;
        Mat filteredImage;

        do {
            cout << "Choose a filter: 1 for grayscale, 2 for blur, 3 for sharpen, 4 for color" << endl;
            int choice;
            cin >> choice;

            switch (choice) {
            case 1: {
                cvtColor(image, filteredImage, COLOR_BGR2GRAY);
                break;
            }
            case 2: {
                int kernelSize = 5;
                double sigmaX = 0;
                GaussianBlur(image, filteredImage, Size(kernelSize, kernelSize), sigmaX);
                break;
            }
            case 3: {
                Mat kernel = (Mat_<float>(3, 3) << 0, -1, 0, -1, 5, -1, 0, -1, 0);
                filter2D(image, filteredImage, image.depth(), kernel);
                break;
            }
            case 4: {
                Mat hsvImage;
                cvtColor(image, hsvImage, COLOR_BGR2HSV);

                Scalar lowerBound(30, 50, 50);
                Scalar upperBound(90, 255, 255);

                Mat mask;
                inRange(hsvImage, lowerBound, upperBound, mask);

                bitwise_and(image, image, filteredImage, mask);
                break;
            }
            default:
                cerr << "Invalid choice. No filter applied." << endl;
                return image;
            }

            displayImage(filteredImage, "Filtered Image");

            cout << "Are you okay with this image? (Y/N): ";
            cin >> response;
        } while (response != 'Y' && response != 'y');

        processedImage = filteredImage;
        return processedImage;
    }

    Mat adjustBrightness(const Mat& image) {
        char response;
        Mat adjustedImage;

        do {
            float percent;
            cout << "How much brightness do you want: ";
            cin >> percent;

            double alpha = 1.0 + (percent / 100.0);
            int beta = 0;

            adjustedImage = image.clone();

            adjustedImage.convertTo(adjustedImage, -1, alpha, beta);

            displayImage(adjustedImage, "Adjusted Brightness Image");

            cout << "Are you okay with this image? (Y/N): ";
            cin >> response;
        } while (response != 'Y' && response != 'y');

        processedImage = adjustedImage;
        return processedImage;
    }

    const Mat& getOriginalImage() const {
        return originalImage;
    }

    const Mat& getProcessedImage() const {
        return processedImage;
    }
};

int main() {
    ImageProcessor imageProcessor;

    string filePath = "OOP-Lab/Assingmentslenna.png";
    imageProcessor.loadImage(filePath);
    const Mat& originalImage = imageProcessor.getOriginalImage();

    if (!originalImage.empty()) {
        imageProcessor.displayImage(originalImage, "Original Image");

        Mat resizedImage = imageProcessor.resizeImage(originalImage, 300, 200);

        Mat croppedImage = imageProcessor.cropImage(originalImage, 50, 50, 300, 200);

        Mat rotatedImage = imageProcessor.rotateImage(originalImage, 45.0);

        Mat filteredImage = imageProcessor.applyFilter(originalImage);

        Mat brightenedImage = imageProcessor.adjustBrightness(originalImage);

        string outputPath = "OOP-Lab/Assingments/output_image.jpg";
        imageProcessor.saveImage(brightenedImage, outputPath);
    }

    return 0;
}
