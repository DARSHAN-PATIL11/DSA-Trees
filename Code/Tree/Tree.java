import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

}

class Tree {
    private Node root;

    public Tree() {
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
    static void printTree(Node root){
        if(root==null){
            return;
        }        
        printTree(root.left);
        System.out.print(root.data+" ");
        printTree(root.right);
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

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Tree tree = new Tree();

        int choice;
        do{
            System.out.println("1.add into tree");
            System.out.println("2.traverse tree");
            System.out.println("3.search into tree");
            System.out.println("4.exit");
        

            System.out.print("Enter your choice:");
            choice=sc.nextInt();

            switch (choice) {
                case 1:
                    tree.insert();
                    break;
                case 2:
                    printTree(tree.root);
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Enter number:");
                    int data=sc.nextInt();
                    boolean result=tree.search(data);
                    String message=result ? "Number found" : "Number not found";
                    System.out.println(message);
                    break;
                case 4:
                    System.out.print("exit");
                    break;
                default:
                    System.out.println("Enter valid input!");
                    break;
            }

        }while (choice!=4);

        tree.insert();
    }

}