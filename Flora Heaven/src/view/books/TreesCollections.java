package view.books;

// ***
// Author: Vnntnn
// ***

import model.Tree;
import java.util.*;

public class TreesCollections {
    private ArrayList<Tree> trees;

    public TreesCollections() {
        trees = new ArrayList<Tree>();
    }

    public TreesCollections(ArrayList<Tree> trees) {
        this.trees = trees;
    }

    private void add(Tree tree) {
        trees.add(tree);
    }
}
