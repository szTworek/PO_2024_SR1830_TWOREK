package agh.ics.oop.model;

import agh.ics.oop.presenter.SimulationPresenter;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class NewWindow {
    public void newWindow(AbstractWorldMap map,SimulationEngine engine) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("mapPage.fxml"));
        BorderPane viewRoot = loader.load();

        SimulationPresenter presenter = loader.<SimulationPresenter>getController();
        map.addListener(new ConsoleMapDisplay());
        map.addListener(presenter);
        presenter.setWorldMap(map);
        presenter.setEngine(engine);
        Stage stage = new Stage();

        Scene scene = new Scene(viewRoot);
        stage.setScene(scene);
        stage.setTitle("Map");

        viewRoot.setMinWidth(850);
        viewRoot.setMinHeight(550);
        stage.minWidthProperty().bind(viewRoot.minWidthProperty());
        stage.minHeightProperty().bind(viewRoot.minHeightProperty());

        stage.show();
    }
}
