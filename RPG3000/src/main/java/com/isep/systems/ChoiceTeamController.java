package com.isep.systems;

import com.isep.entities.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static com.isep.systems.MainApplication.stage;

public class ChoiceTeamController {
    ObservableList<String> list= FXCollections.observableArrayList();
    public List<Hero> heroes = new ArrayList<Hero>();
    public Hero actualHero;

    @FXML
    public TextField inputNumberHeroes;
    @FXML
    public ChoiceBox<String> heroChoiceBox;
    @FXML
    public Button validateButton;
    @FXML
    public Button nextHeroBtn;
    @FXML
    public ImageView heroImage;
    @FXML
    public Label numberHeroLabel;
    @FXML
    public Button startButton;

    private int numberHeroes;

    public String urlImage = "file:assets/";

    @FXML
    public void initialize(){
        loadChoiceBox();
        numberHeroLabel.setText("Héro 1");
    }

    // On met les valeurs voulues dans le Choice Box
    private void loadChoiceBox(){
        list.removeAll();
        list.addAll("warrior", "mage", "healer", "hunter");
        heroChoiceBox.getItems().addAll(list);
    }

    @FXML
    public void onClickValidate(ActionEvent actionEvent) {
        String hero = heroChoiceBox.getValue();  // On récupère la valeur
        if (hero == null ){
            heroImage.setImage(new Image(urlImage + "crossed_swords.png"));
        }else{
            heroImage.setImage(new Image(urlImage + hero + ".png"));  // On met à jour l'image du héro
            setNextButton();
            switch (hero) {  // Selon ce qui a été choisi on définit l'héro
                case "warrior" -> actualHero = new Warrior();
                case "hunter" -> actualHero = new Hunter(5);
                case "mage" -> actualHero = new Mage();
                case "healer" -> actualHero = new Healer();
            }
            validateButton.setDisable(true);
        }
    }

    private void setNextButton() {
        nextHeroBtn.setDisable(false);
    }

    @FXML
    public void nextHeroAction(ActionEvent actionEvent) {

        if (heroes.size() > numberHeroes - 1){
            validateButton.setDisable(true);
            nextHeroBtn.setDisable(true);
            startButton.setDisable(false);  // Si on a choisit tous les héros on peut accèder à la page suivante
        }
        else{
            heroes.add(actualHero); // On ajoute le héro à la liste
            inputNumberHeroes.setDisable(true);
            validateButton.setDisable(false);
            nextHeroBtn.setDisable(true);
            numberHeroLabel.setText("Héro " + (heroes.size() + 1) );
        }
    }

    @FXML
    public void onSetNumber() {
        inputNumberHeroes.textProperty().addListener(new ChangeListener<String>() {
            @Override  // Si la valeur choisi n'est pas un nombre on la supprime
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    inputNumberHeroes.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        numberHeroes = Integer.parseInt(inputNumberHeroes.getText());
    }

    @FXML
    public void onClickStart(ActionEvent actionEvent) throws IOException {
        MainApplication.stage.setUserData(heroes);  // On transmet les données à l'autre controller
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("game-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 700);
        MainApplication.stage.setScene(scene);
        MainApplication.stage.show();
    }
}
