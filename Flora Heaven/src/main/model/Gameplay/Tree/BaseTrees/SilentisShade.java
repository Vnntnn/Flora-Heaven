package main.model.Gameplay.Tree.BaseTrees;

import main.model.Gameplay.Tree.Tree;
import main.view.AssetsLoader.trees.basetrees.SilenttisshadePanel;

public class SilentisShade extends Tree {
    public SilentisShade() {
        super("Silentis Shade", 740, 1, new SilenttisshadePanel());
        addHintList("ป้องกันเสียงรบกวน");
        addHintList("ช่วยระงับอารมณ์");
        addHintList("บรรเทาความวุ่นวาย");
    }
}
