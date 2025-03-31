package main.model.Gameplay;

// ***
// Author: Vnntnn
// ***

import main.model.Player.Player;
import main.model.Gameplay.Tree.Tree;

public interface Buyable {
    public void buy(Player player, Tree tree);
}
