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
    public List<Hero> heroes = new ArrayList<Hero>();;
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

    private void loadChoiceBox(){
        list.removeAll();
        list.addAll("warrior", "mage", "healer", "hunter");
        heroChoiceBox.getItems().addAll(list);
    }

    @FXML
    public void onClickValidate(ActionEvent actionEvent) {
        System.out.println("Le clic fonctionne smr");
        String hero = heroChoiceBox.getValue();
        if (hero == null ){
            heroImage.setImage(new Image(urlImage + "crossed_swords.png"));
        }else{
            heroImage.setImage(new Image(urlImage + hero + ".png"));
            setNextButton();
            switch (hero) {
                case "warrior" -> actualHero = new Warrior();
                case "hunter" -> actualHero = new Hunter(5);
                case "mage" -> actualHero = new Mage();
                case "healer" -> new Healer();
            }
            validateButton.setDisable(true);
        }
    }

    private void setNextButton() {
        nextHeroBtn.setDisable(false);
    }

    @FXML
    public void nextHeroAction(ActionEvent actionEvent) {

        if (heroes.size() > numberHeroes){
            validateButton.setDisable(true);
            nextHeroBtn.setDisable(true);
            startButton.setDisable(false);
        }
        else{
            heroes.add(actualHero);
            inputNumberHeroes.setDisable(true);
            validateButton.setDisable(false);
            nextHeroBtn.setDisable(true);
            numberHeroLabel.setText("Héro " + (heroes.size() + 1) );
        }
        System.out.println(heroes);
        System.out.println(heroes.size());
        System.out.println(numberHeroes + inputNumberHeroes.getText());
    }

    @FXML
    public void onSetNumber() {
        inputNumberHeroes.textProperty().addListener(new ChangeListener<String>() {
            @Override
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
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("game-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 700);
        MainApplication.stage.setUserData(heroes);
        MainApplication.stage.setScene(scene);
        MainApplication.stage.show();
    }
}
