package main.model.Gameplay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import main.model.Gameplay.Tree.Tree;
import main.model.Gameplay.Tree.BaseTrees.Chandra;
import main.model.Gameplay.Tree.BaseTrees.Eclipsara;
import main.model.Gameplay.Tree.BaseTrees.Everguard;
import main.model.Gameplay.Tree.BaseTrees.Heartroot;
import main.model.Gameplay.Tree.BaseTrees.Huolu;
import main.model.Gameplay.Tree.BaseTrees.IllumisSprout;
import main.model.Gameplay.Tree.BaseTrees.Luckybloom;
import main.model.Gameplay.Tree.BaseTrees.Mindspire;
import main.model.Gameplay.Tree.BaseTrees.SilentisShade;
import main.model.Gameplay.Tree.BaseTrees.Voxspire;
import main.model.Gameplay.Tree.BaseTrees.bloodvalorTree;

public class SubQuestGenerator {
    private BasicCombineTree basicCombineTree;
    private Map<Integer, ArrayList<Tree>> dayList;
    private Random random;
    private String hint1,hint2;

    public SubQuestGenerator(){
        basicCombineTree = new BasicCombineTree();
        dayList = new HashMap<>();
        random = new Random();
        ArrayList<Tree> day1 = new ArrayList<>();
        ArrayList<Tree> day2 = new ArrayList<>();
        ArrayList<Tree> day3 = new ArrayList<>();
        ArrayList<Tree> day4 = new ArrayList<>();
        ArrayList<Tree> day5 = new ArrayList<>();
        day1.add(new Luckybloom());
        day1.add(new bloodvalorTree());
        day1.add(new Everguard());
        day1.add(new Chandra());
        
        day2.add(new Luckybloom());
        day2.add(new bloodvalorTree());
        day2.add(new Everguard());
        day2.add(new Chandra());
        day2.add(new Huolu()); // buy form mainquest d1
        day2.add(new Mindspire()); // อยากให้ซื้อ

        day3.add(new Luckybloom());
        day3.add(new bloodvalorTree());
        day3.add(new Everguard());
        day3.add(new Chandra());
        day3.add(new Huolu()); // buy form mainquest d1
        day3.add(new Mindspire()); // อยากให้ซื้อ
        day3.add(new SilentisShade()); // buy form mainquest d2

        day4.add(new Luckybloom());
        day4.add(new bloodvalorTree());
        day4.add(new Everguard());
        day4.add(new Chandra());
        day4.add(new Huolu()); // buy form mainquest d1
        day4.add(new SilentisShade()); // buy form mainquest d2
        day4.add(new Mindspire()); // buy form mainquest d3
        day4.add(new IllumisSprout()); //buy form mainquest d3
        day4.add(new Voxspire()); //อยากให้ซื้อ

        day5.add(new Luckybloom());
        day5.add(new bloodvalorTree());
        day5.add(new Everguard());
        day5.add(new Chandra());
        day5.add(new Huolu()); // buy form mainquest d1
        day5.add(new SilentisShade()); // buy form mainquest d2
        day5.add(new Mindspire()); // buy form mainquest d3
        day5.add(new IllumisSprout()); //buy form mainquest d3
        day5.add(new Voxspire()); //อยากให้ซื้อ
        day5.add(new Heartroot()); //mq d4
        day5.add(new Eclipsara()); // mqd4

        dayList.put(1,day1);
        dayList.put(2,day2);
        dayList.put(3,day3);
        dayList.put(4,day4);
        dayList.put(5,day5);
    }

    public Tree generatorSubQuestTree(int day){
        ArrayList<Tree> tree = dayList.get(day);
        if (tree != null && tree.size() >= 2) {
            Tree tree1, tree2;
            int attempts = 0; // ตัวนับจำนวนครั้งที่สุ่ม
    
            do {
                tree1 = tree.get(random.nextInt(tree.size()));
                tree2 = tree.get(random.nextInt(tree.size()));
                attempts++;
    
                // ป้องกันการสุ่มซ้ำต้นไม้ต้นเดิม
            } while ((tree1 == tree2 || !basicCombineTree.canCombine(tree1, tree2)) && attempts < 100);
    
            System.out.println(tree1.getName() + " + " + tree2.getName());
    
            // ถ้าสุ่มเจอคู่ที่ผสมได้ return ต้นไม้ที่ผสมแล้ว
            if (basicCombineTree.canCombine(tree1, tree2)) {
                hint1 = tree1.getHintList().get(random.nextInt(tree1.getHintList().size()));
                hint2 = tree2.getHintList().get(random.nextInt(tree2.getHintList().size()));
                return basicCombineTree.combine(tree1, tree2);
            }
        }
        return null;
    }

    public String gethintString1(){
        return hint1;
    }
    public String gethintString2(){
        return hint2;
    }
    
    public static void main(String[] args) {
        SubQuestGenerator s = new SubQuestGenerator();
        System.out.println(s.generatorSubQuestTree(5));
    }
}
