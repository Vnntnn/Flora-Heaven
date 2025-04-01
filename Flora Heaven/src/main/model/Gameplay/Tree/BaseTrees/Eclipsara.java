package main.model.Gameplay.Tree.BaseTrees;

import main.model.Gameplay.Tree.Tree;
import main.view.AssetsLoader.trees.basetrees.EclipsaraPanel;

public class Eclipsara extends Tree {
    public Eclipsara() {
        super("Eclipsara", 1350, 0, new EclipsaraPanel());
        addHintList("ดูดซับอารมณ์");
        addHintList("ซึมซับความคิด");
        addHintList("ซึมซับพลังความรู้สึก");
    }
}
