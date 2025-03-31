package main.model.Gameplay;

import java.util.HashMap;
import java.util.Map;

import main.model.Gameplay.Tree.Tree;
import main.model.Gameplay.Tree.BaseTrees.Chandra;
import main.model.Gameplay.Tree.BaseTrees.Eclipsara;
import main.model.Gameplay.Tree.BaseTrees.Luckybloom;
import main.model.Gameplay.Tree.CombineTrees.AurelianWhisper;
import main.model.Gameplay.Tree.CombineTrees.CrimsonWard;
import main.model.Gameplay.Tree.CombineTrees.Cryptara;
import main.model.Gameplay.Tree.CombineTrees.Emberveil;
import main.model.Gameplay.Tree.CombineTrees.FortunaeVine;
import main.model.Gameplay.Tree.CombineTrees.Harmonspire;
import main.model.Gameplay.Tree.CombineTrees.HeartEclipse;
import main.model.Gameplay.Tree.CombineTrees.LuminousFinder;
import main.model.Gameplay.Tree.CombineTrees.MoonfortuneBloom;
import main.model.Gameplay.Tree.CombineTrees.Rootten;
import main.model.Gameplay.Tree.CombineTrees.SilentGuardian;
import main.model.Gameplay.Tree.CombineTrees.Valorvine;

public class BasicCombineTree implements Combinable {
    private static final Map<String, Map<String, Tree>> COMBINATIONS = new HashMap<>();

    static {
        addCombination("Chandra", "Luckybloom", new MoonfortuneBloom());
        addCombination("BloodValor Blossom", "Everguard", new AurelianWhisper());
        addCombination("BloodValor Blossom", "Luckybloom", new Valorvine());
        addCombination("Mindspire", "Luckybloom", new FortunaeVine());
        addCombination("Huolu", "Everguard", new CrimsonWard());
        addCombination("Huolu", "Silentis Shade", new Emberveil());
        addCombination("Everguard", "Silentis Shade", new SilentGuardian());
        addCombination("Illumis Sprout", "Mindspire", new LuminousFinder());
        addCombination("Silentis Shade", "Voxspire", new Harmonspire());
        addCombination("Heartroot", "Eclipsara", new HeartEclipse());
        addCombination("Eclipsara", "Lunacrypta", new Cryptara());
    }

    private static void addCombination(String tree1, String tree2, Tree result) {
        COMBINATIONS.computeIfAbsent(tree1, k -> new HashMap<>()).put(tree2, result);
        COMBINATIONS.computeIfAbsent(tree2, k -> new HashMap<>()).put(tree1, result);
    }

    @Override
    public boolean canCombine(Tree t1, Tree t2) {
        if (t1 == null || t2 == null) return false;
        return COMBINATIONS.containsKey(t1.getName()) && COMBINATIONS.get(t1.getName()).containsKey(t2.getName());
    }

    @Override
    public Tree combine(Tree t1, Tree t2) {
        if (!canCombine(t1, t2)) return new Rootten();
        
        return COMBINATIONS.get(t1.getName()).get(t2.getName());
    }

/*     @Override
    public boolean canCombine(Tree tree1, Tree tree2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'canCombine'");
    }

    @Override
    public Tree combine(Tree tree1, Tree tree2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'combine'");
    } */

    /* public static void main(String[] args) {
        BasicCombineTree combiner = new BasicCombineTree();
        System.out.println(combiner.canCombine(new Chandra(), new Eclipsara()));
        if(combiner.canCombine(new Chandra(), new Luckybloom())){
            System.out.println(combiner.combine(new Chandra(), new Eclipsara()));
        }
    } */
}

