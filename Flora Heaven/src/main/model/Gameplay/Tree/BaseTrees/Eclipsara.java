package main.model.Gameplay.Tree.BaseTrees;

import main.model.Gameplay.Tree.Tree;
import main.view.AssetsLoader.trees.EclipsaraPanel;

public class Eclipsara extends Tree {
    public Eclipsara() {
        super("Eclipsara", 150.0, 0, new EclipsaraPanel());
        addHintList("ดูดซับอารมณ์");
        addHintList("ซึมซับความคิด");
        addHintList("ซึมซับพลังความรู้สึก");
    }
}
