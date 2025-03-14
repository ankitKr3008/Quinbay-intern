import java.util.ArrayList;
// import java.io.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
// import java.text.*;
// import java.math.*;
// import java.util.regex.*;
import java.util.Scanner;

enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis
{
    public abstract int getResult();
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
    int leavesSum = 0;
    public int getResult() {
      	return leavesSum;
    }

    public void visitNode(TreeNode node) {
      	//implement this
    }

    public void visitLeaf(TreeLeaf leaf) {
      	leavesSum += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    long prodofRed = 1;
    public int getResult() {
      	//implement this
        return (int)prodofRed;
    }

    public void visitNode(TreeNode node) {
      	//implement this
        if(node.getColor() == Color.RED){
            prodofRed = (prodofRed * node.getValue())%1000000007;
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
      	//implement this
        if(leaf.getColor() == Color.RED){
            prodofRed = (prodofRed * leaf.getValue())%1000000007;
        }
    }
}

class FancyVisitor extends TreeVis {
    int nonLeafEvenSum = 0, leafGreenSum = 0;
    public int getResult() {
      	//implement this
        if(nonLeafEvenSum > leafGreenSum){
            return nonLeafEvenSum-leafGreenSum;
        }
        else{
            return leafGreenSum-nonLeafEvenSum;
        }
    }
    public void visitNode(TreeNode node) {
    	//implement this
        if(node.getDepth()%2 == 0) nonLeafEvenSum += node.getValue();
    }

    public void visitLeaf(TreeLeaf leaf) {
    	//implement this
        if(leaf.getColor() == Color.GREEN) leafGreenSum += leaf.getValue();
    }
}

public class VisitorPattern {
    static Map<Integer, Tree> tree = new HashMap<Integer, Tree>();
    public static Tree solve() {
        //read the tree from STDIN and return its root as a return value of this function
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, Object[]> nodeAtts = new HashMap<Integer, Object[]>();

        for (int i = 0; i < n; i++){
            nodeAtts.put(i + 1, new Object[]{sc.nextInt(), null});
        }
        for (int i = 0; i < n; i++){
            nodeAtts.get(i + 1)[1] = sc.nextInt() == 0 ? Color.RED : Color.GREEN;
        }
        sc.close();
        Map<Integer, ArrayList<Integer>> edges = new HashMap<Integer, ArrayList<Integer>>();

        for (int i = 1; i <= n; i++)
            edges.put(i, new ArrayList<Integer>());

        for (int i = 1; i < n; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            edges.get(u).add(v);
            edges.get(v).add(u);
        }
        Tree root = new TreeNode((Integer) nodeAtts.get(1)[0], (Color) nodeAtts.get(1)[1], 0);
        tree.put(1, root);

        DFS(n, edges, nodeAtts);
        return tree.get(1);
    }
    private static void DFS(int n, Map<Integer, ArrayList<Integer> > edges, Map<Integer, Object[]> nodeAtts) {
        boolean[] visited = new boolean[n + 1];
        TreeNode parent = (TreeNode) tree.get(1);
        DFSUtil(parent, 1, visited, edges, nodeAtts);

    }

    private static void DFSUtil(TreeNode parent, int v, boolean[] visited, Map<Integer, ArrayList<Integer>> edges,Map<Integer, Object[]> nodeAtts) {
        visited[v] = true;
        if (edges.get(v).size() == 1 && v != 1) {
            TreeLeaf treeLeaf = new TreeLeaf((Integer) nodeAtts.get(v)[0], (Color) nodeAtts.get(v)[1],
                    parent.getDepth() + 1);
            parent.addChild(treeLeaf);
            tree.put(v, treeLeaf);
            return;
        }

        TreeNode treeNode;
        if (v != 1) {
            treeNode = new TreeNode((Integer) nodeAtts.get(v)[0], (Color) nodeAtts.get(v)[1], parent.getDepth() + 1);
            parent.addChild(treeNode);
            tree.put(v, treeNode);

        } else
            treeNode = (TreeNode) tree.get(1);

        Iterator<Integer> iterator = edges.get(v).iterator();
        while (iterator.hasNext()) {
            int n = iterator.next();
            if (!visited[n]) {
                DFSUtil(treeNode, n, visited, edges, nodeAtts);
            }
        }
    }


    public static void main(String[] args) {
      	Tree root = solve();
		SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
      	ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
      	FancyVisitor vis3 = new FancyVisitor();

      	root.accept(vis1);
      	root.accept(vis2);
      	root.accept(vis3);

      	int res1 = vis1.getResult();
      	int res2 = vis2.getResult();
      	int res3 = vis3.getResult();

      	System.out.println(res1);
     	System.out.println(res2);
    	System.out.println(res3);
	}
}
