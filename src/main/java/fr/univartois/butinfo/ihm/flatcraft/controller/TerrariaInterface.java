package fr.univartois.butinfo.ihm.flatcraft.controller;

import fr.univartois.butinfo.ihm.flatcraft.model.AbstractMovable;
import fr.univartois.butinfo.ihm.flatcraft.model.FlatcraftGame;
import fr.univartois.butinfo.ihm.flatcraft.model.GameMap;

public interface TerrariaInterface {
    void setGame(FlatcraftGame game);
    void initializeView(GameMap gameMap);
    void addMovableObject(AbstractMovable movableObject);
    void removeMovableObject(AbstractMovable movableObject);
}
