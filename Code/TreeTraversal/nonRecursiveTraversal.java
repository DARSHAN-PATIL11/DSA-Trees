import java.util.*;

import javax.swing.tree.TreeNode;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

}

class nonRecursiveTraversal {
    private Node root;

    public nonRecursiveTraversal() {
        this.root = null;
    }

    public void insert() {
        Scanner sc=new Scanner(System.in);
        
        System.out.print("Enter a number:");
        int data=sc.nextInt();

        Node newNode=new Node(data);

        if(root==null){
            root=newNode;
            return;
        }
        Node temp=root;

        while (temp!=null) {
            System.out.print("Where you wanna insert node(L/R):");
            char side=sc.next().toUpperCase().charAt(0);

            if(side=='L'){
                if(temp.left!=null){
                    temp=temp.left;
                }else{
                    temp.left=newNode;
                    break;
                }
            }
            else{
                if(temp.right!=null){
                    temp=temp.right;
                }
                else{
                    temp.right=newNode;
                    break;
                }
            }
        }

    }

    boolean _searchBSTHelper(int data,Node root){
        if(root==null){
            return false;
        }
        if(root.data==data){
            return true;
        }
        return (_searchBSTHelper(data,root.left) || _searchBSTHelper(data,root.right) );
    }
    boolean search(int data) {
        boolean result=_searchBSTHelper(data,root);
        return result;
    }

    static void inorderTraversal(Node root){
        if(root==null){
            return;
        }        
        Stack <Node> st= new Stack<Node>();
        Node node=root;

        while (true) {
            if(node != null){
                st.push(node);
                node=node.left;
            }
            else{
                if(st.isEmpty()){
                    break;
                }
                node=st.pop();
                System.out.print(node.data+" ");
                node=node.right;
            }
        }
    }

    static void preorderTraversal(Node root){
        if(root==null){
            return;
        }
        Stack <Node> st=new Stack<Node>();
        st.push(root);
        while (!st.isEmpty()) {
            root=st.pop();
            System.out.println(root.data);
            if(root.right != null){
                st.push(root.right);
            }
            if(root.left != null){
                st.push(root.left);
            }
        }
    }

    static void postorderTraversal(Node root){
        if(root==null){
            return;
        }
        Stack <Node> st1=new Stack<Node>();
        Stack <Node> st2=new Stack<Node>();

        st1.push(root);
        while (!st1.isEmpty()) {
            root =st1.pop();
            st2.add(root);

            if(root.left!=null){
                st1.push(root.left);
            }
            if(root.right!=null){
                st1.push(root.right);
            }
        }
        while (!st2.isEmpty()) {
            System.out.print(st2.pop().data+" ");
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        nonRecursiveTraversal tree = new nonRecursiveTraversal();

        int choice;
        do{
            System.out.println("1.add into tree");
            System.out.println("2.search into tree");
            System.out.println("3.preorder traversal");
            System.out.println("4.inorder traversal");
            System.out.println("5.postorder traversal");
            System.out.println("6.exit");
        

            System.out.print("Enter your choice:");
            choice=sc.nextInt();

            switch (choice) {
                case 1:
                    tree.insert();
                    break;
                case 2:
                    System.out.print("Enter number:");
                    int data=sc.nextInt();
                    boolean result=tree.search(data);
                    String message=result ? "Number found" : "Number not found";
                    System.out.println(message);
                    break;
                case 3:
                    System.out.println("Preorder Traversal");
                    preorderTraversal(tree.root);
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Inorder Traversal");
                    inorderTraversal(tree.root);
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Postorder Traversal");
                    postorderTraversal(tree.root);
                    System.out.println();
                    break;
                case 6:
                    System.out.print("exit");
                    break;
                default:
                    System.out.println("Enter valid input!");
                    break;
            }

        }while (choice!=6);

        tree.insert();
    }

}