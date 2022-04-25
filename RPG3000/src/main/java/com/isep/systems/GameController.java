package com.isep.systems;

import com.isep.entities.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GameController {

    public List<Hero> heroes = (List<Hero>) MainApplication.stage.getUserData();
    Game game = new Game(heroes, 0);

    @FXML
    public ImageView imageHero;
    @FXML
    public ImageView imageEnemy;
    @FXML
    public Label lifePointsEnemyLabel;
    @FXML
    public Button attackButton;
    @FXML
    public Button lembasButton;
    @FXML
    public Button potionButton;
    @FXML
    public Button healButton;
    @FXML
    public ImageView vsImage;
    @FXML
    public Label lifePointsLabel;
    @FXML
    public Label armorLabel;
    @FXML
    public Label distanceAttackLabel;
    @FXML
    public Label lembasLabel;
    @FXML
    public Label potionsLabel;
    @FXML
    public Button nextHeroButton;
    @FXML
    public ListView<ArrayList<String>> heroListView;
    @FXML
    public Label nameHeroLabel;
    @FXML
    public Label nameEnemyLabel;
    @FXML
    public Label enemyAttackLabel;
    @FXML
    public Label deathHeroLabel;
    @FXML
    public Label roundLabel;

    public String urlImage = "file:assets/";
    public String nameHero;
    List<ArrayList<String>> listHeroes = new ArrayList<ArrayList<String>>();
    Hero hero = game.getHero();
    Enemy enemy = game.generateCombat();

    public void initialize(){
        System.out.println("Your heroes : " + heroes);
        vsImage.setImage(new Image(urlImage + "crossed_swords.png"));
        updateScreen();
        setListHeroes();
        heroListView.getItems().addAll(listHeroes);
        game.setNumberOfRounds(1);
    }

    @FXML
    public void attackOnClick(ActionEvent actionEvent) throws InterruptedException {
        enemy.receiveAttack(hero);
        System.out.println(enemy.getLifePoints());
        updateScreen();
        updateButtons();
        enemyAttack();
    }

    @FXML
    public void lembasOnClick(ActionEvent actionEvent) {
    }

    @FXML
    public void potionsOnClick(ActionEvent actionEvent) {
    }

    @FXML
    public void healOnClick(ActionEvent actionEvent) {
    }

    @FXML
    public void nextHeroOnClick(ActionEvent actionEvent) {
        if (hero.getLifePoints() <= 0){
            heroes.remove(hero);
            hero = heroes.get(0);
            heroListView.getItems().clear();
            setListHeroes();
            heroListView.getItems().addAll(listHeroes);
        }else{
            game.setPlayerTurn(game.getPlayerTurn() + 1 );
            if (game.getPlayerTurn() >= heroes.size()){
                game.setPlayerTurn(0);
            }
            hero = heroes.get(game.getPlayerTurn());
        }

        if (enemy.getLifePoints() <= 0){
            enemy = game.generateCombat();
            game.setNumberOfRounds(game.getNumberOfRounds() + 1);
        }

        updateScreen();
        nextHeroButton.setDisable(true);
        attackButton.setDisable(false);
        lembasButton.setDisable(false);
        potionButton.setDisable(false);

    }

    // Displaying data of the heroes and enemies on screen
    private void updateScreen(){
        nameEnemyLabel.setText(enemy.getName());
        nameHeroLabel.setText(hero.getName());
        deathHeroLabel.setVisible(false);

        imageHero.setImage(new Image(urlImage + hero.getName().toLowerCase() + ".png"));
        imageEnemy.setImage(new Image(urlImage + enemy.getName().toLowerCase() + ".png"));

        if (hero.getLifePoints() <= 0 ){
            lifePointsLabel.setText("PV : 0");
            imageHero.setImage(new Image(urlImage + "death.png"));
            deathHeroLabel.setVisible(true);
        }else{
            lifePointsLabel.setText("PV : " + hero.getLifePoints());
        }

        if (enemy.getLifePoints() < 0){
            lifePointsEnemyLabel.setText("PV : 0");
        }else{
            lifePointsEnemyLabel.setText("PV : " + enemy.getLifePoints());
        }

        if (hero.getArmor() <= 0 ){
            armorLabel.setText("Armure : 0");
        }else{
            armorLabel.setText("Armure : " + hero.getArmor());
        }

        // We change the distanceAttackLabel according to the current hero
        if (hero.getName().equals("Hunter")){
            distanceAttackLabel.setText("Flèches disponibles : " + ((Hunter) hero).getArrows());
        }else if (hero.getName().equals("Mage") || hero.getName().equals("Healer")){
            distanceAttackLabel.setText("Mana disponible : " + ((SpellCaster) hero).getManaPoints());
        }else{
            distanceAttackLabel.setVisible(false);
        }

        // Set HealButton visible only for the Healer
        healButton.setVisible(hero.getName().equals("Healer"));

        nextHeroButton.setDisable(true);

        lembasLabel.setText("Lembas : " + hero.getLembas().size());
        potionsLabel.setText("Potions : " + hero.getPotions().size());
    }

    private void updateButtons(){
        if (nextHeroButton.isDisable()){
            nextHeroButton.setDisable(false);
            attackButton.setDisable(true);
            lembasButton.setDisable(true);
            potionButton.setDisable(true);
        }else{
            nextHeroButton.setDisable(true);
            attackButton.setDisable(false);
            lembasButton.setDisable(false);
            potionButton.setDisable(false);
        }
    }

    private void setListHeroes(){
        for (Hero hero : heroes) {
            ArrayList<String> heroData = new ArrayList<String>();
            heroData.add(hero.getName());
            heroData.add("PV : " + hero.getLifePoints());
            heroData.add("Dégats : " + hero.getWeaponDamage());
            listHeroes.add(heroData);
        }
    }

    private void enemyAttack() throws InterruptedException {
        enemyAttackLabel.setVisible(true);
        hero.receiveAttack(enemy);
        Thread.sleep(2000);
        updateScreen();
        updateButtons();
    }
}
