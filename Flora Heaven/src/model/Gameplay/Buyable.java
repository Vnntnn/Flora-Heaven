package model.Gameplay;

import model.Player.Player;
import model.Gameplay.Tree.Tree;

public interface Buyable {
    public void buy(Player player, Tree tree);
}
