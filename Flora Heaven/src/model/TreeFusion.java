package model;

public class TreeFusion {
    private Tree tree1;
    private Tree tree2;

    public TreeFusion() {
        this(null, null);
    }

    public TreeFusion(Tree tree1, Tree tree2) {
        this.tree1 = tree1;
        this.tree2 = tree2;
    }

//    public boolean isTreeMerging() {
////        if (tree1 && tree2) {
////            return true;
////        }
////        return false;
//    }

    public Tree getTree1() {
        return tree1;
    }
    public void setTree1(Tree tree1) {
        this.tree1 = tree1;
    }

    public Tree getTree2() {
        return tree2;
    }

    public void setTree2(Tree tree2) {
        this.tree2 = tree2;
    }
}
