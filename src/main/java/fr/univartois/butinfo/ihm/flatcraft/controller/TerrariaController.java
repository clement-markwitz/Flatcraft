package fr.univartois.butinfo.ihm.flatcraft.controller;

import fr.univartois.butinfo.ihm.flatcraft.model.AbstractMovable;
import fr.univartois.butinfo.ihm.flatcraft.model.FlatcraftGame;
import fr.univartois.butinfo.ihm.flatcraft.model.GameMap;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;

public class TerrariaController implements TerrariaInterface {

    @FXML
    private GridPane grilleFond;

    @FXML
    private GridPane grillePerso;
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    private ImageView[][] grilleViewPerso;
    private ImageView[][] grilleViewFond;
    @FXML
    void initialize() {
        grilleViewPerso=new ImageView[grillePerso.getRowCount()][grillePerso.getColumnCount()];
        grilleViewFond=new ImageView[grilleFond.getRowCount()][grilleFond.getColumnCount()];
        for (int i = 0; i < grillePerso.getRowCount(); i++) {
            for (int j = 0; j < grillePerso.getColumnCount(); j++) {
                grilleViewPerso[i][j]=new ImageView();
            }
        }
        for (int i = 0; i < grilleFond.getRowCount(); i++) {
            for (int j = 0; j < grilleFond.getColumnCount(); j++) {
                grilleViewFond[i][j]=new ImageView();
            }
        }

    }
    private Image loadImage(String name) {
        URL urlImage = getClass().getResource("./images/" + name + ".gif");
        assert urlImage != null;
        return new Image(urlImage.toExternalForm(), 12, 12, true, false);
    }
    private void afficher() {
        for (int i = 0; i < grilleFond.getRowCount(); i++) {
            for (int j = 0; j < grilleFond.getColumnCount(); j++) {
               grilleViewPerso[i][j]=new ImageView();
               grilleFond.add(grilleViewPerso[i][j],i,j);
            }
        }
    }

    @Override
    public void setGame(FlatcraftGame game) {

    }

    @Override
    public void initializeView(GameMap gameMap) {

    }

    @Override
    public void addMovableObject(AbstractMovable movableObject) {

    }

    @Override
    public void removeMovableObject(AbstractMovable movableObject) {

    }
}
