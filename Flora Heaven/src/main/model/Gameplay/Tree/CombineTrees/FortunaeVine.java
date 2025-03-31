package main.model.Gameplay.Tree.CombineTrees;

import main.model.Gameplay.Tree.Tree;
import main.view.AssetsLoader.trees.basetrees.VoxspirePanel;
import main.view.AssetsLoader.trees.treescombine.FortunaeVinePanel;

public class FortunaeVine extends Tree {
    public FortunaeVine(){
        super("Fortunae Vine",45,2,new FortunaeVinePanel());
    }
}
