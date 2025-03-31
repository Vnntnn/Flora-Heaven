package main.model.Gameplay.Tree.BaseTrees;

import main.model.Gameplay.Tree.Tree;
import main.view.trees.VoxspirePanel;

public class Voxspire extends Tree {
    public Voxspire() {
        super("Voxspire", 100.0, 1, new VoxspirePanel());
        addHintList("ช่วยนำเสนองานอย่างมั่นใจ");
        addHintList("ช้วยกระตุ้นจิตใจ");
        addHintList("ทำให้กล้าแสดงออก");
    }
}
