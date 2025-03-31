package main.model.Gameplay.Tree.CombineTrees;

import main.model.Gameplay.Tree.Tree;
import main.view.trees.SilenttisshadePanel;
import main.view.treescombine.SilentGuardianPanel;

public class SilentGuardian extends Tree{
    public SilentGuardian(){
        super("Silent Guardian",40,2,new SilentGuardianPanel());
    }
}
