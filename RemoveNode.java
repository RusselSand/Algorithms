public class RemoveNode {
    public static Node remove(Node root, int key) {
        if(root == null){
            return root;
        }
        Node[] nodes = findElement(null, root, key);
        if(nodes[1] == null){
            return root;
        }
        Node nodeForReplace = null;
        if(nodes[1].getLeft() != null){
            Node[] nodesForReplace = findRight(null, nodes[1].getLeft());
            if(nodesForReplace[0] != null){
                nodesForReplace[0].setRight(nodesForReplace[1].getRight());
                nodesForReplace[1].setLeft(nodes[1].getLeft());
            }
            nodesForReplace[1].setRight(nodes[1].getRight());
            nodeForReplace = nodesForReplace[1];
        } else if(nodes[1].getRight() != null){
            Node[] nodesForReplace = findLeft(null, nodes[1].getRight());
            if(nodesForReplace[0] != null){
                nodesForReplace[0].setLeft(nodesForReplace[1].getLeft());
                nodesForReplace[1].setRight(nodes[1].getRight());
            }
            nodesForReplace[1].setLeft(nodes[1].getLeft());
            nodeForReplace = nodesForReplace[1];
        }
        if(nodes[0] == null){
            return nodeForReplace;
        }
        if(nodes[0].getLeft() == nodes[1]){
            nodes[0].setLeft(nodeForReplace);
        } else {
            nodes[0].setRight(nodeForReplace);
        }
        return root;
    }

    public static Node[] findElement(Node parent, Node root, int key){
        if(root == null){
            return new Node[]{null, null};
        }
        if(root.getValue() == key){
            return new Node[]{parent, root};
        }
        if(root.getValue() > key){
            return findElement(root, root.getLeft(), key);
        }
        else {
            return findElement(root, root.getRight(), key);
        }
    }

    public static Node[] findLeft(Node parent, Node child){
        if(child.getLeft() == null){
            return new Node[] {parent, child};
        }
        return findLeft(child, child.getLeft());
    }
    public static Node[] findRight(Node parent, Node child){
        if(child.getRight() == null){
            return new Node[] {parent, child};
        }
        return findRight(child, child.getRight());
    }

    private static void test() {
        Node node1 = new Node(null, null, 2);
        Node node2 = new Node(node1, null, 3);
        Node node3 = new Node(null, node2, 1);
        Node node4 = new Node(null, null, 6);
        Node node5 = new Node(node4, null, 8);
        Node node6 = new Node(node5, null, 10);
        Node node7 = new Node(node3, node6, 5);
        Node newHead = remove(node7, 6);
        assert newHead.getValue() == 5;
        assert newHead.getRight() == node5;
        assert newHead.getRight().getValue() == 8;
    }

    public static class Node {
        private int value;
        private Node left;
        private Node right;
        Node(Node left, Node right, int value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }
        public int getValue() {
            return value;
        }
        public Node getRight() {
            return right;
        }
        public void setRight(Node right) {
            this.right = right;
        }
        public Node getLeft() {
            return left;
        }
        public void setLeft(Node left) {
            this.left = left;
        }
        public void setValue(int value) {
            this.value = value;
        }
    }
}
