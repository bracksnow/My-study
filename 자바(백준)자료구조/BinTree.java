package DataStructure;

public class BinTree {
    Node root;

    public BinTree() {
        this.root = null;
    }


    public class Node {
        int data;
        Node right;//노드 클래스를 불러온 것?
        Node left;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public void indrder(Node node) {
        if (node != null) {
            indrder(node.left);
            System.out.println(node.data);
            indrder(node.right);
        }
    }

    public void preorder(Node node) {
        if (node != null) {
            System.out.println(node.data);
            preorder(node.left);
            preorder(node.right);
        }
    }

    public void postorder(Node node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.println(node.data);
        }
    }

    public void addNode(int data) {
        Node current;
        Node node = new Node(data);
        if(root==null){
            root = node;
            current = root;
        }
        else {
            current = root;
            while (true) {
                if (current.data < node.data) {
                    if (current.right == null) {
                        current.right = node;
                        break;
                    } else {
                        current = current.right;
                    }
                } else if (current.data > node.data) {
                    if (current.left == null) {
                        current.left = node;
                        break;
                    }
                    else{
                        current = current.left;
                    }
                }
            }
        }
    }




    public static void main(String[] args) {
        BinTree bintree = new BinTree();
        bintree.addNode(23);
        bintree.addNode(45);
        bintree.addNode(15);
        bintree.addNode(37);
        bintree.addNode(3);
        bintree.addNode(99);
        bintree.addNode(21);
        bintree.addNode(40);
        bintree.addNode(44);
        bintree.addNode(1);
        bintree.addNode(55);


        bintree.preorder(bintree.root);
        System.out.println();
        bintree.indrder(bintree.root);
        System.out.println();
        bintree.postorder(bintree.root);

    }
}