package main.model.Gameplay.Tree.CombineTrees;

import main.model.Gameplay.Tree.Tree;
import main.view.AssetsLoader.trees.basetrees.LunacryptaPanel;
import main.view.AssetsLoader.trees.treescombine.LuminousFinderPanel;

public class LuminousFinder extends Tree{
    public LuminousFinder(){
        super("Luminous Finder",40,2,new LuminousFinderPanel());
    }
    
}
