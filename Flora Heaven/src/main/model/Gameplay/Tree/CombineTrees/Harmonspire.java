package main.model.Gameplay.Tree.CombineTrees;

import main.model.Gameplay.Tree.Tree;
import main.view.AssetsLoader.trees.basetrees.MindspirePanel;
import main.view.AssetsLoader.trees.treescombine.HarmonspirePanel;

public class Harmonspire extends Tree{
    public Harmonspire(){
        super("Harmonspire",80,3,new HarmonspirePanel());
    }
}
