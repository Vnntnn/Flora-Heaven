package main.model.Gameplay.Tree.CombineTrees;

import main.model.Gameplay.Tree.Tree;
import main.view.AssetsLoader.trees.basetrees.LunacryptaPanel;
import main.view.AssetsLoader.trees.treescombine.CryptaraPanel;

public class Cryptara extends Tree{
    public Cryptara(){
        super("Cryptara",999,4,new CryptaraPanel());
    }
}
