package dsaVisualizer;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class VisualizerPane extends Canvas {

    public VisualizerPane(double width, double height) {
        super(width, height);
    }
    
    public void drawArray(int[] array, int currentIndex, int nextIndex) {
        GraphicsContext gc = this.getGraphicsContext2D();
        double width = getWidth();
        double height = getHeight();
        gc.clearRect(0, 0, width, height);
        
        int n = array.length;
        double barWidth = width / n;
        
        for (int i = 0; i < n; i++) {
            if (i == currentIndex || i == nextIndex) {
                gc.setFill(Color.RED);
            } else {
                gc.setFill(Color.DODGERBLUE);
            }
            double barHeight = array[i];
            double x = i * barWidth;
            double y = height - barHeight;
            gc.fillRect(x, y, barWidth - 2, barHeight);
        }
    }
}
