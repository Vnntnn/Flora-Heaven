package main.model.Gameplay.Tree.BaseTrees;

import main.model.Gameplay.Tree.Tree;
import main.view.AssetsLoader.trees.basetrees.Illumis_sproutPanel;

public class IllumisSprout extends Tree {
    public IllumisSprout() {
        super("Illumis Sprout", 770, 1, new Illumis_sproutPanel());
        addHintList("เผยให้เห็นสิ่งที่ตามหา");
        addHintList("ช่วยหาคำตอบของโจทย์ปัญหา");
        addHintList("ทำให้ค้นพบสิ่งที่หายไป");
    }
}
