package main.model.Gameplay.Tree.CombineTrees;

import main.model.Gameplay.Tree.Tree;
import main.view.AssetsLoader.trees.basetrees.LuckybloomPanel;
import main.view.AssetsLoader.trees.treescombine.RoottenPanel;

public class Rootten extends Tree{
    public Rootten(){
        super("Rootten",0,0, new RoottenPanel());
    }
}
