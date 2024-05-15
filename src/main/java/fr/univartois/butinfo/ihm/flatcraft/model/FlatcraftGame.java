package fr.univartois.butinfo.ihm.flatcraft.model; /**
 * Ce logiciel est distribué à des fins éducatives.
 *
 * Il est fourni "tel quel", sans garantie d’aucune sorte, explicite
 * ou implicite, notamment sans garantie de qualité marchande, d’adéquation
 * à un usage particulier et d’absence de contrefaçon.
 * En aucun cas, les auteurs ou titulaires du droit d’auteur ne seront
 * responsables de tout dommage, réclamation ou autre responsabilité, que ce
 * soit dans le cadre d’un contrat, d’un délit ou autre, en provenance de,
 * consécutif à ou en relation avec le logiciel ou son utilisation, ou avec
 * d’autres éléments du logiciel.
 *
 * (c) 2023-2024 Romain Wallon - Université d'Artois.
 * Tous droits réservés.
 */

import fr.univartois.butinfo.ihm.flatcraft.controller.TerrariaInterface;
import javafx.scene.image.Image;

/**
 * La classe {@link FlatcraftGame} permet de gérer une partie du jeu Flatcraft.
 *
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public final class FlatcraftGame {
    private TerrariaInterface terInter;
    /**
     * La largeur de la carte du jeu affichée (en pixels).
     */
    private final int width;

    /**
     * La hauteur de la carte du jeu affichée (en pixels).
     */
    private final int height;

    /**
     * L'instance e {@link SpriteStore} utilisée pour créer les sprites du jeu.
     */
    private SpriteStore spriteStore;

    /**
     * L'instance de {@link CellFactory} utilisée pour créer les cellules du jeu.
     */
    private CellFactory cellFactory;

    /**
     * La carte du jeu, sur laquelle le joueur évolue.
     */
    private GameMap map;

    /**
     * La représentation du joueur.
     */
    private Player player;

    public void setTerInter(TerrariaInterface terInter) {
        this.terInter = terInter;
    }
    /**
     * Crée une nouvelle instance de FlatcraftGame.
     *
     * @param width La largeur de la carte du jeu (en pixels).
     * @param height La hauteur de la carte du jeu (en pixels).
     */
    public FlatcraftGame(int width, int height) {
        this.width = width;
        this.height = height;
        this.spriteStore = new SpriteStore();
        this.cellFactory = new CellFactory(spriteStore);
    }

    /**
     * Donne la largeur de la carte du jeu affichée (en pixels).
     *
     * @return La largeur de la carte du jeu affichée (en pixels).
     */
    public int getWidth() {
        return width;
    }

    /**
     * Donne la hauteur de la carte du jeu affichée (en pixels).
     *
     * @return La hauteur de la carte du jeu affichée (en pixels).
     */
    public int getHeight() {
        return height;
    }

    /**
     * Prépare la partie de Flatcraft avant qu'elle ne démarre.
     */
    public void prepare() {
        // TODO Préparer la partie
        map=GameMapGenerator.generateMapWithTreesAndSlagHeaps(height,width,cellFactory,10,2);
        terInter.initializeView(map);
        // Créer le joueur
        Image playerImage = spriteStore.createSprite("player");
        player = new Player(this, playerImage);
        int soilHeight = map.getSoilHeight();
        player.setRow(soilHeight);
        player.setColumn(width / 2);
        map.setAt(soilHeight, width / 2, map.getAt(5,5));

        // Informer l'interface TerrariaInterface de la préparation de la partie
        terInter.initializeView(map);
    }

    /**
     * Fait se déplacer le joueur vers la gauche.
     */
    public void moveLeft() {
        moveLeft(player);
    }

    /**
     * Fait se déplacer un objet mobile vers la gauche.
     *
     * @param movable L'objet mobile à déplacer.
     */
    public void moveLeft(AbstractMovable movable) {
        int column = movable.getColumn();
        if (((column - 1) >= 0)) {
            // TODO Retirer l'objet mobile du jeu.
            movable.setColumn(column - 1);
            // TODO Rajouter l'objet mobile dans le jeu.
        }
    }

    /**
     * Fait se déplacer le joueur vers la droite.
     */
    public void moveRight() {
        moveRight(player);
    }

    /**
     * Fait se déplacer un objet mobile vers la droite.
     *
     * @param movable L'objet mobile à déplacer.
     */
    public void moveRight(AbstractMovable movable) {
        int column = movable.getColumn();
        if (((column + 1) < map.getWidth())) {
            // TODO Retirer l'objet mobile du jeu.
            movable.setColumn(column + 1);
            // TODO Rajouter l'objet mobile dans le jeu.
        }
    }

    /**
     * Déplace un objet mobile en tenant compte de la gravité.
     *
     * @param movable L'objet à déplacer.
     */
    private void move(AbstractMovable movable) {
        // On applique la gravité.
        Cell currentCell = getCellOf(movable);
        for (int row = currentCell.getRow() + 1; row < map.getHeight(); row++) {
            Cell below = map.getAt(row, currentCell.getColumn());
            if (!below.move(movable)) {
                break;
            }
        }
    }

    /**
     * Fait creuser le joueur vers le bas.
     */
    public void digDown() {
        Cell currentCell = getCellOf(player);
        if ((currentCell.getRow() + 1) < map.getHeight()) {
            map.getAt(currentCell.getRow() + 1, currentCell.getColumn()).dig(player);
            move(player);
        }
    }

    /**
     * Fait creuser le joueur vers la gauche.
     */
    public void digLeft() {
        Cell currentCell = getCellOf(player);
        if ((currentCell.getColumn() - 1) > 0) {
            map.getAt(currentCell.getRow(), currentCell.getColumn() - 1).dig(player);
            move(player);
        }
    }

    /**
     * Fait creuser le joueur vers la droite.
     */
    public void digRight() {
        Cell currentCell = getCellOf(player);
        if ((currentCell.getColumn() + 1) < map.getWidth()) {
            map.getAt(currentCell.getRow(), currentCell.getColumn() + 1).dig(player);
            move(player);
        }
    }

    /**
     * Retire un objet mobile du jeu.
     *
     * @param movable L'objet mobile à retirer.
     */
    public void removeMovable(AbstractMovable movable) {
        // TODO Retirer l'objet mobile du jeu.
    }

    /**
     * Récupére la cellule correspondant à la position d'un objet mobile.
     *
     * @param movable L'objet mobile dont la cellule doit être récupérée.
     *
     * @return La cellule occupée par l'objet mobile.
     */
    private Cell getCellOf(AbstractMovable movable) {
        int row = movable.getRow();
        int column = movable.getColumn();
        return map.getAt(row, column);
    }

}
