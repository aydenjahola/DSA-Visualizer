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
    private String currentAlgorithmType; // Track selected algorithm

    public SortController(SortAlgorithm initialAlgorithm, VisualizerPane visualizer, ControlPanel controlPanel) {
        this.algorithm = initialAlgorithm;
        this.visualizer = visualizer;
        this.controlPanel = controlPanel;
        this.speed = 100; // default speed
        this.currentAlgorithmType = "Bubble Sort"; // Default algorithm
        initTimeline();
    }

    private void initTimeline() {
        timeline = new Timeline(
            new KeyFrame(
                Duration.millis(speed),
                e -> {
                    boolean sorted = algorithm.step();
                    visualizer.drawArray(
                        algorithm.getArray(),
                        algorithm.getCurrentIndex(),
                        algorithm.getNextIndex()
                    );
                    controlPanel.getStatusLabel().setText("Status: " + algorithm.getStatusMessage());
                    if (sorted) {
                        timeline.stop();
                    }
                }
            )
        );
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
        // Reinitialize the algorithm based on the current selection
        switch (currentAlgorithmType) {
            case "Bubble Sort":
                algorithm = new BubbleSort(algorithm.getArray().length, visualizer.getHeight());
                break;
            case "Selection Sort":
                algorithm = new SelectionSort(algorithm.getArray().length, visualizer.getHeight());
                break;
            default:
                algorithm = new BubbleSort(algorithm.getArray().length, visualizer.getHeight());
                break;
        }
        visualizer.drawArray(algorithm.getArray(), -1, -1); // Reset highlights
        controlPanel.getStatusLabel().setText("Status: Array reset.");
        initTimeline();
    }

    public void setSpeed(double newSpeed) {
        speed = newSpeed;
        timeline.stop();
        initTimeline();
    }
    
    public void setAlgorithmType(String algorithmType) {
        this.currentAlgorithmType = algorithmType;
    }
}