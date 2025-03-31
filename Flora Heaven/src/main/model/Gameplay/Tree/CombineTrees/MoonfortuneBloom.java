package main.model.Gameplay.Tree.CombineTrees;

import main.model.Gameplay.Tree.Tree;
import main.view.AssetsLoader.trees.basetrees.VoxspirePanel;
import main.view.AssetsLoader.trees.treescombine.MoonfortuneBloomPanel;

public class MoonfortuneBloom extends Tree{
    public MoonfortuneBloom(){
        super("Moonfortune Bloom",45,2,new MoonfortuneBloomPanel());
    }
}
