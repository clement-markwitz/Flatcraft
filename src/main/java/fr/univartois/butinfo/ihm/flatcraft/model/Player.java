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

import java.util.NoSuchElementException;

import javafx.scene.image.Image;

/**
 * La classe Player représente le personnage du joueur qui se déplace sur la carte du jeu.
 *
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public final class Player extends AbstractMovable {

    /**
     * Crée une nouvelle instance de Player.
     *
     * @param game Le jeu dans lequel le joueur évolue.
     * @param sprite Le sprite représentant le joueur.
     */
    public Player(FlatcraftGame game, Image sprite) {
        super(game, sprite, 3);
    }

    /**
     * Ajoute un objet à l'inventaire de ce joueur.
     *
     * @param resource L'objet à ajouter.
     */
    public void addToInventory(Resource resource) {
        // TODO : Ajouter l'objet à l'inventaire du joueur.
    }

    /**
     * Retire un objet de l'inventaire de ce joueur.
     *
     * @param resource L'objet à retirer.
     *
     * @throws NoSuchElementException Si l'objet n'est pas présent dans l'inventaire.
     */
    public void removeFromInventory(Resource resource) {
        // TODO : Retirer l'objet de l'inventaire du joueur.
    }

}
