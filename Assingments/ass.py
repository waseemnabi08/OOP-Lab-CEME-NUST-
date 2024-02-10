import cv2
import numpy as np

class ImageProcessor:
    def __init__(self):
        self.original_image = None
        self.processed_image = None

    def load_image(self, file_path):
        image = cv2.imread(file_path)
        if image is None:
            print("Error: Could not open or find the image.")
        self.original_image = image
        return image

    def display_image(self, image, window_name):
        cv2.imshow(window_name, image)
        cv2.waitKey(0)

    def save_image(self, image, file_path):
        if image is not None:
            cv2.imwrite(file_path, image)
            print(f"Image saved successfully as {file_path}")
        else:
            print("Error: Unable to save image. Input image is empty.")

    def resize_image(self, input_image, width, height):
        if input_image is None:
            print("Error: Unable to resize image. Input image is empty.")
            return None
        response = 'N'
        while response not in ['Y', 'y']:
            aspect_ratio = input_image.shape[1] / input_image.shape[0]
            new_height = int(width / aspect_ratio)
            resized_image = cv2.resize(input_image, (width, new_height))
            self.display_image(resized_image, "Resized Image")
            response = input("Are you okay with this image? (Y/N): ")
        self.processed_image = resized_image
        return self.processed_image

    def crop_image(self, input_image, x, y, width, height):
        if input_image is None:
            print("Error: Unable to crop image. Input image is empty.")
            return None
        response = 'N'
        while response not in ['Y', 'y']:
            cropped_image = input_image[y:y + height, x:x + width].copy()
            self.display_image(cropped_image, "Cropped Image")
            response = input("Are you okay with this image? (Y/N): ")
        self.processed_image = cropped_image
        return self.processed_image

    def rotate_image(self, input_image, angle):
        if input_image is None:
            print("Error: Unable to rotate image. Input image is empty.")
            return None
        response = 'N'
        while response not in ['Y', 'y']:
            center = (input_image.shape[1] // 2, input_image.shape[0] // 2)
            rotation_matrix = cv2.getRotationMatrix2D(center, angle, 1.0)
            rotated_image = cv2.warpAffine(input_image, rotation_matrix, (input_image.shape[1], input_image.shape[0]))
            self.display_image(rotated_image, "Rotated Image")
            response = input("Are you okay with this image? (Y/N): ")
        self.processed_image = rotated_image
        return self.processed_image

    def apply_filter(self, image):
        response = 'N'
        while response not in ['Y', 'y']:
            print("Choose a filter: 1 for grayscale, 2 for blur, 3 for sharpen, 4 for color")
            choice = int(input())
            if choice == 1:
                filtered_image = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)
            elif choice == 2:
                kernel_size = 5
                sigma_x = 0
                filtered_image = cv2.GaussianBlur(image, (kernel_size, kernel_size), sigma_x)
            elif choice == 3:
                kernel = np.array([[0, -1, 0], [-1, 5, -1], [0, -1, 0]], dtype=np.float32)
                filtered_image = cv2.filter2D(image, -1, kernel)
            elif choice == 4:
                hsv_image = cv2.cvtColor(image, cv2.COLOR_BGR2HSV)
                lower_bound = np.array([30, 50, 50])
                upper_bound = np.array([90, 255, 255])
                mask = cv2.inRange(hsv_image, lower_bound, upper_bound)
                filtered_image = cv2.bitwise_and(image, image, mask=mask)
            else:
                print("Invalid choice. No filter applied.")
                return image
            self.display_image(filtered_image, "Filtered Image")
            response = input("Are you okay with this image? (Y/N): ")
        self.processed_image = filtered_image
        return self.processed_image

    def adjust_brightness(self, image):
        response = 'N'
        while response not in ['Y', 'y']:
            percent = float(input("How much brightness do you want: "))
            alpha = 1.0 + (percent / 100.0)
            beta = 0
            adjusted_image = np.clip(image * alpha + beta, 0, 255).astype(np.uint8)
            self.display_image(adjusted_image, "Adjusted Brightness Image")
            response = input("Are you okay with this image? (Y/N): ")
        self.processed_image = adjusted_image
        return self.processed_image

    def get_original_image(self):
        return self.original_image

    def get_processed_image(self):
        return self.processed_image


if __name__ == "__main__":
    image_processor = ImageProcessor()

    file_path = "lenna.png"
    image_processor.load_image(file_path)
    original_image = image_processor.get_original_image()

    if original_image is not None:
        image_processor.display_image(original_image, "Original Image")

        resized_image = image_processor.resize_image(original_image, 300, 200)

        cropped_image = image_processor.crop_image(original_image, 50, 50, 300, 200)

        rotated_image = image_processor.rotate_image(original_image, 45.0)

        filtered_image = image_processor.apply_filter(original_image)

        brightened_image = image_processor.adjust_brightness(original_image)

        output_path = "output_image.jpg"
        image_processor.save_image(brightened_image, output_path)
