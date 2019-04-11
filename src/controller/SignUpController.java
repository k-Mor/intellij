/*
 * Multiline comment the top of the file.
 */
package controller;

import Model.NewUser;
import animatefx.animation.FadeIn;
import animatefx.animation.FadeOut;
import animatefx.animation.FadeOutDown;
import animatefx.animation.LightSpeedOut;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import view.SceneChanger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * This class is the controller for the SignUpView.FXML file.
 *
 * @author : Kaleb
 * @version : 2019-04-10
 */
public class SignUpController implements Initializable {

    /**
     * This is the user textfield that is used for sign up.
     */
    @FXML private TextField myUsr;

    /**
     * This is the password that is generated by the user.
     */
    @FXML private TextField myPass;

    /**
     * This is the pasword text field that is used to compare
     * against the myPass field.
     */
    @FXML private TextField myConfirmPass;

    /**
     * This is a label for the user.
     */
    @FXML private Label myLbl;

    /**
     * This is the actual sign up button.
     */
    @FXML private Button myBtnSignUp;

    /**
     * This is a message label that displays wether or not
     * something has gone wrong during sign up.
     */
    @FXML private Label myMessageLabel;


    /**
     * This method is responsible for controlling the sign up button,
     * and ensures that the password input matches exactly.
     * This method is also responsible for creating a new user from the
     * data input in the textfields.
     *
     * @param theEvent : This is the event from the pushed buton
     * @throws IOException : In the event that the file can not be found.
     */
    public void signUpButtonPushed(ActionEvent theEvent) throws IOException{

        try {
            if (!myPass.getText().equals(myConfirmPass.getText())) {
                throw  new IllegalArgumentException("Passwords must match");
            }
            // Create a new user
            NewUser user = new NewUser(myUsr.getText(), myPass.getText());

            // Insert user into the DB
            user.insertUserIntoDB();

        } catch (Exception e) {
            myMessageLabel.setText(e.getMessage());
            new FadeIn(myMessageLabel).play();
        }

        // Play the animations
        playTheAnimations();

         //Change the scene
        SceneChanger sceneChanger = new SceneChanger();
        sceneChanger.changeScene(theEvent, "LogInView.fxml", "Log In Page");
    }

    /**
     * This method houses the animations from AnimateFX
     */
    public void playTheAnimations() {

        //TODO

        // Animation styles
        new LightSpeedOut(myUsr).play();
        new FadeOut(myLbl).play();
        new LightSpeedOut(myPass).play();
        new LightSpeedOut(myConfirmPass).play();
        new FadeOutDown(myBtnSignUp).play();
    }

    /**
     * This method is the overridden method from the super class and
     * handles the initialization of the view.
     *
     * @param theUrl : This is a required parameter that is unused.
     * @param theRb : This is a required parameter that is unused.
     */
    @Override
    public void initialize(URL theUrl, ResourceBundle theRb) {
        myMessageLabel.setText("");

    }
}