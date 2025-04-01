package main.model.Gameplay.Tree.BaseTrees;

import main.model.Gameplay.Tree.Tree;
import main.view.AssetsLoader.trees.basetrees.MindspirePanel;

public class Mindspire extends Tree {
    public Mindspire() {
        super("Mindspire", 390, 1, new MindspirePanel());
        addHintList("ช่วยเพิ่มสมาธิ");
        addHintList("มีความจำที่ดี");
        addHintList("ทำให้จิตอยู่กับปัจจุบัน");
    }
}
