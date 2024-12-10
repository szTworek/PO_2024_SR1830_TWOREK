package agh.ics.oop.presenter;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import agh.ics.oop.model.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.awt.*;
import java.util.List;

public class SimulationPresenter implements MapChangeListener{

    @FXML
    public Button startButton;
    @FXML
    public GridPane mapGrid;
    private WorldMap map;

    @FXML
    private Label infoLabel;
    @FXML
    private Label messageLabel;
    @FXML
    private TextField textField;


    public void setWorldMap(WorldMap worldMap) {

        map = worldMap;
    }
    public void drawMap(){
        infoLabel.setVisible(false);
        clearGrid();
        Boundary boundaries= map.getCurrentBounds();
        Vector2d lowerLeft=boundaries.LowerLeft();
        Vector2d upperRight=boundaries.UpperRight();


        int CELL_SIZE = 40;
        int gridWidth = upperRight.getX() - lowerLeft.getX() + 1;
        int gridHeight = upperRight.getY() - lowerLeft.getY() + 1;

        mapGrid.getColumnConstraints().clear();
        mapGrid.getRowConstraints().clear();

        for (int i = 0; i < gridWidth+1; i++) {
            mapGrid.getColumnConstraints().add(new ColumnConstraints(CELL_SIZE));

        }
        for (int i = 0; i < gridHeight+1; i++) {
            mapGrid.getRowConstraints().add(new RowConstraints(CELL_SIZE));
        }
        for (int i =1; i<gridHeight+1; i++) {
            Label num = new Label(String.valueOf(upperRight.getY()-i+1));
            mapGrid.add(num,0,i);
            GridPane.setHalignment(num, HPos.CENTER);
        }
        for (int i=1; i<gridWidth+1; i++){
            Label num = new Label(String.valueOf(lowerLeft.getX()+i-1));
            mapGrid.add(num,i,0);
            GridPane.setHalignment(num, HPos.CENTER);
        }
        Label signature=new Label("y/x");
        mapGrid.add(signature,0,0);
        GridPane.setHalignment(signature, HPos.CENTER);
        for (int y = lowerLeft.getY(); y <= upperRight.getY(); y++) {
            for (int x = lowerLeft.getX(); x <= upperRight.getX(); x++) {
                Label label = new Label();
                Object object = map.objectAt(new Vector2d(x, y));
                if (object != null) {
                    label.setText(object.toString());
                }
                mapGrid.add(label, x - lowerLeft.getX()+1, upperRight.getY() - y+1);
                GridPane.setHalignment(label, HPos.CENTER);

            }
        }}
    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        Platform.runLater(() -> {
            drawMap();
            messageLabel.setText(message);
            // ewentualny inny kod zmieniający kontrolki
        });
    }

    public void onSimulationStartClicked(ActionEvent actionEvent) {
        String[] moves = textField.getText().split(" ");
        java.util.List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(5, 3), new Vector2d(3, 7));
        Simulation simulation1 = new Simulation(positions, OptionsParser.parse(moves), map);
        SimulationEngine engine = new SimulationEngine(List.of(simulation1));

        engine.runAsync();
    }
    private void clearGrid() {
        mapGrid.getChildren().retainAll(mapGrid.getChildren().get(0)); // hack to retain visible grid lines
        mapGrid.getColumnConstraints().clear();
        mapGrid.getRowConstraints().clear();
    }
}
