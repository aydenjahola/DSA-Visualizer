package dsaVisualizer;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class SortController {
    private SortAlgorithm algorithm;
    private VisualizerPane visualizer;
    private ControlPanel controlPanel;
    private Timeline timeline;
    private double speed; // Milliseconds per step
    
    public SortController(SortAlgorithm algorithm, VisualizerPane visualizer, ControlPanel controlPanel) {
        this.algorithm = algorithm;
        this.visualizer = visualizer;
        this.controlPanel = controlPanel;
        this.speed = 100; // default speed
        initTimeline();
    }
    
    private void initTimeline() {
        timeline = new Timeline(new KeyFrame(Duration.millis(speed), e -> {
            boolean sorted = algorithm.step();
            visualizer.drawArray(algorithm.getArray(), algorithm.getCurrentIndex(), algorithm.getNextIndex());
            controlPanel.getStatusLabel().setText("Status: " + algorithm.getStatusMessage());
            if (sorted) {
                timeline.stop();
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
    }
    
    public void start() {
        timeline.play();
    }
    
    public void pause() {
        timeline.pause();
    }
    
    public void reset() {
        timeline.stop();
        algorithm = new BubbleSort(algorithm.getArray().length, visualizer.getHeight());
        visualizer.drawArray(algorithm.getArray(), algorithm.getCurrentIndex(), algorithm.getNextIndex());
        controlPanel.getStatusLabel().setText("Status: Array reset.");
        initTimeline();
    }
    
    public void setSpeed(double newSpeed) {
        speed = newSpeed;
        timeline.stop();
        initTimeline();
        timeline.play();
    }
}
