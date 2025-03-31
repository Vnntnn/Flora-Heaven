package main.model.Gameplay.Tree.BaseTrees;

import main.model.Gameplay.Tree.Tree;
import main.view.AssetsLoader.trees.HuoluPanel;

public class Huolu extends Tree {
    public Huolu() {
        super("Huolu", 100.0, 1, new HuoluPanel());
        addHintList("ช่วยจุดไฟให้แสงสว่าง");
        addHintList("ช่วยสร้างความอบอุ่น");
        addHintList("สามารถเผาย่างอาหาร");
    }
}
