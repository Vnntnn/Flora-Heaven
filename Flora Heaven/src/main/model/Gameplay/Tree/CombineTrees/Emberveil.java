package main.model.Gameplay.Tree.CombineTrees;

import main.model.Gameplay.Tree.Tree;
import main.view.AssetsLoader.trees.basetrees.EclipsaraPanel;
import main.view.AssetsLoader.trees.treescombine.EmberveilPanel;

public class Emberveil extends Tree{
    public Emberveil(){
        super("Emberveil",80,3,new EmberveilPanel());
    }
}
