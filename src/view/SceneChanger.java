/*
 * Multiline comment at the top of the file
 */
package view;

import animatefx.animation.FadeInDown;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This class is a scene changing class where upon instantiation, access to the
 * necessary method is gained.
 *
 * @author Kaleb
 * @version 2019-04-08
 */
public class SceneChanger {

    /**
     * This method handles all of the scene changes with the different FXML files
     *
     * @param theEvent
     * @param theViewName
     * @param theSceneTitle
     */
    public void changeScene(ActionEvent theEvent, String theViewName, String theSceneTitle) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(theViewName));
        Parent parent = null;
        try {
            parent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) theEvent.getSource()).getScene().getWindow();
        stage.setTitle(theSceneTitle);
        stage.setScene(scene);
        new FadeInDown(parent).play();
        stage.show();
    }
}