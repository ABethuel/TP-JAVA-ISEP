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
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import java.io.IOException;
import java.util.List;

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
    public ListView<Hero> heroListView;
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
    @FXML
    public Label damageLabel;
    @FXML
    public Pane fightPane;
    @FXML
    public Pane rewardPane;
    @FXML
    public ImageView imageHeroReward;
    @FXML
    public Label lifePointsRewardLabel;
    @FXML
    public Label armorRewardLabel;
    @FXML
    public Label damageRewardLabel;
    @FXML
    public Label lembasRewardLabel;
    @FXML
    public Label potionsLabelReward;
    @FXML
    public Label distanceRewardAttackLabel;
    @FXML
    public Button improveArmorButton;
    @FXML
    public Button improveWeaponButton;
    @FXML
    public Button improveConsommableButton;
    @FXML
    public Button newConsommableButton;
    @FXML
    public Button newArrowsButton;
    @FXML
    public Button costManaButton;
    @FXML
    public Button improveSpellButton;
    @FXML
    public Button newManaButton;
    @FXML
    public Button nextHeroRewardButton;

    public String urlImage = "file:assets/";
    ObservableList<Hero> listHeroes =  FXCollections.observableArrayList();

    Hero hero = game.getHero();
    Enemy enemy = game.generateCombat();
    Potion potion = hero.getPotions().get(0);
    Food lembas = hero.getLembas().get(0);

    Hero heroReward = heroes.get(0);
    int heroRewardTurn = 0;

    public void initialize(){
        System.out.println("Your heroes : " + heroes);
        vsImage.setImage(new Image(urlImage + "crossed_swords.png"));
        game.setHeroes(heroes);
        game.setNumberOfRounds(1);
        updateScreen();
        setListHeroes();
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
    public void lembasOnClick(ActionEvent actionEvent) throws InterruptedException, IOException {
        hero.useConsumable(lembas);
        hero.getLembas().remove(lembas);
        if (hero.getLembas().size() > 0){
            lembas = hero.getLembas().get(0);
        }
        updateScreen();
        updateButtons();
        enemyAttack();
    }

    @FXML
    public void potionsOnClick(ActionEvent actionEvent) throws InterruptedException, IOException {
        hero.useConsumable(potion);
        hero.getPotions().remove(potion);
        if (hero.getPotions().size() > 0){
            potion = hero.getPotions().get(0);
        }
        updateScreen();
        updateButtons();
        enemyAttack();
    }

    @FXML
    public void healOnClick(ActionEvent actionEvent) throws IOException, InterruptedException {
        attackButton.setDisable(true);
        potionButton.setDisable(true);
        lembasButton.setDisable(true);
        heroListView.setDisable(false);
        heroListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Hero>() {
            @Override
            public void changed(ObservableValue<? extends Hero> observableValue, Hero heron, Hero t1) {
                Hero selectedHero = heroListView.getSelectionModel().getSelectedItem();
                if (hero.getClass().equals(Healer.class)){
                    Healer healer = (Healer) hero;
                    healer.healHero(selectedHero);
                    heroListView.setDisable(true);
                }
            }
        });
        updateScreen();
        updateButtons();
        enemyAttack();
    }

    @FXML
    public void nextHeroOnClick(ActionEvent actionEvent) throws IOException {
        if (hero.getLifePoints() <= 0){
            heroes.remove(hero);
            if (heroes.size() <= 0 ) {
                MainApplication.stage.setUserData(game.getNumberOfRounds());
                FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("endgame-view.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 900, 700);
                MainApplication.stage.setScene(scene);
                MainApplication.stage.show();
                System.out.println(" ------ Endgame ------");
            }else{
                hero = heroes.get(0);
                setListHeroes();
            }
        }else{
            game.setPlayerTurn(game.getPlayerTurn() + 1 );
            if (game.getPlayerTurn() >= heroes.size()){
                game.setPlayerTurn(0);
            }
            hero = heroes.get(game.getPlayerTurn());
            setListHeroes();
        }

        if (enemy.getLifePoints() <= 0){
            enemy = game.generateCombat();
            game.setNumberOfRounds(game.getNumberOfRounds() + 1);
        }

        updateScreen();
        healButton.setDisable(false);
        nextHeroButton.setDisable(true);
        attackButton.setDisable(false);
        potionButton.setDisable(hero.getPotions().size() <= 0);
        lembasButton.setDisable(hero.getLembas().size() <= 0);
    }

    // Displaying data of the heroes and enemies on screen
    private void updateScreen(){
        roundLabel.setText("Tour " + game.getNumberOfRounds());
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

        if (enemy.getLifePoints() <= 0 && heroes.size() > 0){
            if (hero.getLifePoints() <= 0 ){
                heroes.remove(hero);
            }
            fightPane.setVisible(false);
            rewardPane.setVisible(true);
            heroReward = heroes.get(0);
            updateRewardScreen();
        }

        if (enemy.getLifePoints() <= 0){
            lifePointsEnemyLabel.setText("PV : 0");
        }else{
            lifePointsEnemyLabel.setText("PV : " + enemy.getLifePoints());
        }

        if (hero.getArmor() <= 0 ){
            armorLabel.setText("Armure : 0");
        }else{
            armorLabel.setText("Armure : " + hero.getArmor());
        }

        damageLabel.setText("Dégats : " + hero.getWeaponDamage());

        // We change the distanceAttackLabel according to the current hero
        if (hero.getName().equals("Hunter")){
            distanceAttackLabel.setVisible(true);
            if (((Hunter) hero).getArrows() <= 0){
                distanceAttackLabel.setText("Flèches disponibles : 0");
            }else{
                distanceAttackLabel.setText("Flèches disponibles : " + ((Hunter) hero).getArrows());
            }
        }else if (hero.getName().equals("Mage") || hero.getName().equals("Healer")){
            distanceAttackLabel.setVisible(true);
            if (((SpellCaster) hero).getManaPoints() <= 0){
                distanceAttackLabel.setText("Mana disponible : 0");
            }else{
                distanceAttackLabel.setText("Mana disponible : " + ((SpellCaster) hero).getManaPoints());
            }
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
            potionButton.setDisable(true);
            lembasButton.setDisable(true);
            healButton.setDisable(true);
        }else{
            nextHeroButton.setDisable(true);
            attackButton.setDisable(false);
            healButton.setDisable(false);
        }
    }

    private void setListHeroes(){
        listHeroes.clear();
        listHeroes.addAll(heroes);
        heroListView.setItems(listHeroes);

        heroListView.setCellFactory(param -> new ListCell<Hero>() {
            @Override
            protected void updateItem(Hero p, boolean empty){
                super.updateItem(p, empty);
                if(empty || p == null || p.getName() == null){
                    setText("");
                }
                else{
                    setText(p.getName() + "   PV : " + p.getLifePoints() + "   Dégats : " + p.getWeaponDamage());

                }
            }
        });
    }

    private void enemyAttack() throws InterruptedException {
        enemyAttackLabel.setVisible(true);
        hero.receiveAttack(enemy);
        Thread.sleep(1200);
        updateScreen();
        updateButtons();
    }

    @FXML
    public void improveArmorOnClick(ActionEvent actionEvent) {
        heroReward.setArmor(heroReward.getArmor() + 2);
        updateRewardScreen();
        updateRewardsButtons();
    }

    @FXML
    public void improveWeaponOnClick(ActionEvent actionEvent) {
        heroReward.setWeaponDamage(heroReward.getWeaponDamage() + 1);
        updateRewardScreen();
        updateRewardsButtons();
    }

    @FXML
    public void improveConsommableOnClick(ActionEvent actionEvent) {
        for (int i = 0; i < heroReward.getPotions().size(); i++){
            Consumable consumable = heroReward.getPotions().get(i);
            consumable.setEfficiency(consumable.getEfficiency() + 1);
        }
        updateRewardScreen();
        updateRewardsButtons();
    }

    @FXML
    public void newConsommableOnClick(ActionEvent actionEvent) {
        heroReward.setLembas(new Food());
        heroReward.setPotions(new Potion());
        updateRewardScreen();
        updateRewardsButtons();
    }

    @FXML
    public void newArrowsOnClick(ActionEvent actionEvent) {
        ((Hunter) heroReward).setArrows(((Hunter) heroReward).getArrows() + 2);
        updateRewardScreen();
        updateRewardsButtons();
    }

    @FXML
    public void costManaOnClick(ActionEvent actionEvent) {
        ((SpellCaster) heroReward).setManaUse(((SpellCaster) heroReward).getManaUse() - 1);
        updateRewardScreen();
        updateRewardsButtons();
    }

    @FXML
    public void improveSpellOnClick(ActionEvent actionEvent) {
        if (heroReward.getClass().equals(Mage.class)){
            ((Mage) heroReward).setMagicDamage(((Mage) heroReward).getMagicDamage() + 1);
        }else{
            ((Healer) heroReward).setManaHeal(((Healer) heroReward).getManaHeal() + 1);
        }
        updateRewardScreen();
        updateRewardsButtons();
    }

    @FXML
    public void newManaOnClick(ActionEvent actionEvent) {
        ((SpellCaster) heroReward).setManaPoints(((SpellCaster) heroReward).getManaPoints() + 2);
        updateRewardScreen();
        updateRewardsButtons();
    }

    @FXML
    public void nextHeroRewardOnClick(ActionEvent actionEvent) {
        heroRewardTurn ++;
        if (heroRewardTurn >= heroes.size()){
            fightPane.setVisible(true);
            rewardPane.setVisible(false);
            game.setPlayerTurn(game.getPlayerTurn() + 1 );
            game.setNumberOfRounds(game.getNumberOfRounds() + 1);
            enemy = game.generateCombat();
            updateScreen();
            healButton.setDisable(false);
            nextHeroButton.setDisable(true);
            attackButton.setDisable(false);
            potionButton.setDisable(false);
            lembasButton.setDisable(false);
            heroRewardTurn = 0;
        }else{
            heroReward = heroes.get(heroRewardTurn);
        }
        updateRewardScreen();
        updateRewardsButtons();
    }

    private void updateRewardScreen() {
        imageHeroReward.setImage(new Image(urlImage + heroReward.getName().toLowerCase() + ".png"));
        lifePointsRewardLabel.setText("PV : " + heroReward.getLifePoints());

        armorRewardLabel.setText(heroReward.getArmor() <= 0 ? "Armure : 0" : "Armure : " + heroReward.getArmor());

        damageRewardLabel.setText("Dégats : " + heroReward.getWeaponDamage());

        if (heroReward.getName().equals("Hunter")){
            distanceRewardAttackLabel.setVisible(true);
            newArrowsButton.setVisible(true);
            newManaButton.setVisible(false);
            costManaButton.setVisible(false);
            improveSpellButton.setVisible(false);
            if (((Hunter) heroReward).getArrows() <= 0){
                distanceRewardAttackLabel.setText("Flèches disponibles : 0");
            }else{
                distanceRewardAttackLabel.setText("Flèches disponibles : " + ((Hunter) heroReward).getArrows());
            }
        }else if (heroReward.getName().equals("Mage") || heroReward.getName().equals("Healer")){
            distanceRewardAttackLabel.setVisible(true);
            newArrowsButton.setVisible(false);
            newManaButton.setVisible(true);
            costManaButton.setVisible(true);
            improveSpellButton.setVisible(true);
            if (((SpellCaster) heroReward).getManaPoints() <= 0){
                distanceRewardAttackLabel.setText("Mana disponible : 0");
            }else{
                distanceRewardAttackLabel.setText("Mana disponible : " + ((SpellCaster) heroReward).getManaPoints());
            }
        }else{
            distanceRewardAttackLabel.setVisible(false);
            newArrowsButton.setVisible(false);
            newManaButton.setVisible(false);
            costManaButton.setVisible(false);
            improveSpellButton.setVisible(false);
        }

        lembasRewardLabel.setText("Lembas : " + heroReward.getLembas().size());
        potionsLabelReward.setText("Potions : " + heroReward.getPotions().size());
    }

    private void updateRewardsButtons(){
        if (nextHeroRewardButton.isDisable()){
            nextHeroRewardButton.setDisable(false);
            improveSpellButton.setDisable(true);
            improveArmorButton.setDisable(true);
            improveWeaponButton.setDisable(true);
            improveConsommableButton.setDisable(true);
            newManaButton.setDisable(true);
            newArrowsButton.setDisable(true);
            improveSpellButton.setDisable(true);
            newConsommableButton.setDisable(true);
            costManaButton.setDisable(true);
        }else{
            nextHeroRewardButton.setDisable(true);
            improveSpellButton.setDisable(false);
            improveArmorButton.setDisable(false);
            improveWeaponButton.setDisable(false);
            improveConsommableButton.setDisable(false);
            newManaButton.setDisable(false);
            newArrowsButton.setDisable(false);
            improveSpellButton.setDisable(false);
            newConsommableButton.setDisable(false);
            costManaButton.setDisable(false);
        }
    }

}
