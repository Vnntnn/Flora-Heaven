package main.model.Gameplay;

// ***
// Author: Vnntnn
// ***

import main.model.Gameplay.Tree.Tree;

public interface Combinable {
    public boolean canCombine(Tree tree1, Tree tree2);
    
    public Tree combine(Tree tree1, Tree tree2);
}
