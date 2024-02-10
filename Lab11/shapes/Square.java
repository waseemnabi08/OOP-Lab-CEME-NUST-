import java.awt.*;
import javax.swing.*;

public class Square extends Shape implements Drawable {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    // Getters
    public double getSide() {
        return this.side;
    }

    @Override
    public double calculateArea() {
        return this.side * this.side;
    }

    @Override
    public double calculatePerimeter() {
        return 4 * this.side;
    }



    @Override
    public void draw() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Draw Square");
            frame.setSize(300, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new SquarePanel(this.side));
            frame.setVisible(true);
        });
    }

    public void display(){
        System.out.println("Square: ");
        draw();
        super.display();
    }

    private static class SquarePanel extends JPanel {
        private double side;

        public SquarePanel(double side) {
            this.side = side;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawSquare(g);
        }

        private void drawSquare(Graphics g) {
            int x = getWidth() / 2 - (int) (side / 2);
            int y = getHeight() / 2 - (int) (side / 2);

            g.drawRect(x, y, (int) side, (int) side);
        }
    }
}
