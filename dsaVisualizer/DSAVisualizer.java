package dsaVisualizer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class DSAVisualizer extends Application {

    private SortController sortController;
    private VisualizerPane visualizerPane;
    private ControlPanel controlPanel;

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        
        visualizerPane = new VisualizerPane(800, 600);
        root.setCenter(visualizerPane);
        
        controlPanel = new ControlPanel();
        root.setBottom(controlPanel);
        
        sortController = new SortController(new BubbleSort(50, visualizerPane.getHeight()), visualizerPane, controlPanel);
        
        controlPanel.getStartButton().setOnAction(e -> sortController.start());
        controlPanel.getPauseButton().setOnAction(e -> sortController.pause());
        controlPanel.getResetButton().setOnAction(e -> sortController.reset());
        controlPanel.getSpeedSlider().valueProperty().addListener((obs, oldVal, newVal) -> {
            sortController.setSpeed(newVal.doubleValue());
        });
        controlPanel.getAlgorithmSelector().valueProperty().addListener((obs, oldVal, newVal) -> {
            sortController.setAlgorithmType(newVal);
            sortController.reset();
        });
        
        Scene scene = new Scene(root, 800, 650);
        primaryStage.setTitle("DSA Visualizer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
