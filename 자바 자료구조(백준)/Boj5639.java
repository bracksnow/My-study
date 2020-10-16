package DataStructure;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj5639 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String number = null;
        TreeNode root = new TreeNode(Integer.parseInt(bf.readLine()));
        while((number = bf.readLine()) != null && number.length() != 0){//입력이 있는 동안에는 while문 돌기
            root = root.treeAdd(root,Integer.parseInt(number));
        }
        postorder(root);
    }
    public static void postorder(TreeNode root){
        if(root.left!=null){
            postorder(root.left);
        }
        if(root.right!=null){
            postorder(root.right);
        }
        System.out.println(root.data);

    }
    public static class TreeNode{
        int data;
        TreeNode right;
        TreeNode left;

        public TreeNode(int data) {
            this.data = data;
        }

        public TreeNode treeAdd(TreeNode currentNode, int data){
            if(currentNode==null){
                return new TreeNode(data);
            }else{
                if(currentNode.data>data){
                    currentNode.left = treeAdd(currentNode.left, data);//재귀를 통하여 tree를 구성하도록 한다
                }else if(currentNode.data<data){
                    currentNode.right = treeAdd(currentNode.right, data);
                }
            }
            return currentNode;
        }
    }
}
