package dsaVisualizer;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ControlPanel extends VBox {
    private HBox buttonRow;
    private Button startButton;
    private Button pauseButton;
    private Button resetButton;
    private Slider speedSlider;
    private ComboBox<String> algorithmSelector;
    private Label speedLabel;
    private Label statusLabel;

    public ControlPanel() {
        startButton = new Button("Start");
        pauseButton = new Button("Pause");
        resetButton = new Button("Reset");
        
        speedSlider = new Slider(10, 500, 100); // Speed range (ms per step)
        speedLabel = new Label("Speed:");
        
        algorithmSelector = new ComboBox<>();
        algorithmSelector.getItems().addAll("Bubble Sort", "Selection Sort"); //TODO add more algorithms
        algorithmSelector.getSelectionModel().selectFirst();
        
        buttonRow = new HBox(10);
        buttonRow.getChildren().addAll(startButton, pauseButton, resetButton, speedLabel, speedSlider, algorithmSelector);
        
        statusLabel = new Label("Status: Ready");
        
        this.setSpacing(10);
        this.setPadding(new Insets(10));
        this.getChildren().addAll(buttonRow, statusLabel);
    }
    
    public Button getStartButton() {
        return startButton;
    }
    
    public Button getPauseButton() {
        return pauseButton;
    }
    
    public Button getResetButton() {
        return resetButton;
    }
    
    public Slider getSpeedSlider() {
        return speedSlider;
    }
    
    public ComboBox<String> getAlgorithmSelector() {
        return algorithmSelector;
    }
    
    public Label getStatusLabel() {
        return statusLabel;
    }
}
