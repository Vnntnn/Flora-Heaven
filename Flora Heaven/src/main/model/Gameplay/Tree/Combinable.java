package main.model.Gameplay.Tree;

// ***
// Author: Vnntnn
// ***

public interface Combinable {
    public boolean canCombine(Tree tree1, Tree tree2);
    
    public Tree combine(Tree tree1, Tree tree2);
}
