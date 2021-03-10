package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.stage.Stage;
public class button_1 extends Application {

    // launch the application
    public void start(Stage s)
    {
        // set title for the stage
        s.setTitle("This is Gurbans' Button");
        // create a label
        var np = new Label("button not pressed");
        // create a button
        var b = new Button("Gurbans' button");
        b.setOnAction((e) -> np.setText("button pressed"));
        // create a stack pane
        var t = new TilePane();
        t.getChildren().addAll(b, np);

        // create a scene
        var sc = new Scene(t, 200, 200);

        // set the scene
        s.setScene(sc);

        s.show();
    }

    public static void main(String args[])
    {
        // launch the application
        launch(args);
    }
}
