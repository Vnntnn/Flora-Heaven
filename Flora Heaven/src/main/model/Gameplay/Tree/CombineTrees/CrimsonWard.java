package main.model.Gameplay.Tree.CombineTrees;

import main.model.Gameplay.Tree.Tree;
import main.view.trees.VoxspirePanel;
import main.view.treescombine.CrimsonWardPanel;

public class CrimsonWard extends Tree{
    public CrimsonWard(){
        super("Crimson Ward",40,2,new CrimsonWardPanel());
    }
}
