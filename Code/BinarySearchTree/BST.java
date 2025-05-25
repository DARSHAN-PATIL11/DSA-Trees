import java.util.Scanner;

class Node {
    int data;
    Node left,right;

    public Node(int data){
        this.data=data;
        this.left=this.right=null;
    }
}

public class BST {
    Node root=null;

    void insert(){
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
             if(temp.data > data){
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

    void printBST(Node root){
        if(root==null){
            return;
        }
        printBST(root.left);
        System.out.print(root.data+" ");
        printBST(root.right); 
    }
    // boolean _searchHelper(int data,Node root){
    //     if(root==null){
    //         return false;
    //     }
    //     if(root.data==data){
    //         return true;
    //     }
    //     return (_searchHelper(data,root.left) || _searchHelper(data,root.right) );
    // }
    boolean _searchBSTHelper(int data,Node root){
        if(root==null){
            return false;
        }
        if(root.data==data){
            return true;
        }
        if(root.data < data){
            return _searchBSTHelper(data,root.right);
        }else{
            return _searchBSTHelper(data,root.left);
        }
    }
    boolean search(int data) {
        boolean result=_searchBSTHelper(data,root);
        return result;
    }
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        BST bst=new BST();

        int choice;
        do{
            System.out.println("1. insert in BST");
            System.out.println("2. traverse BST");
            System.out.println("3. search in BST");
            System.out.println("0. exit");

            System.out.print("Enter your choice:");
            choice=sc.nextInt();

            switch (choice) {
                case 1:
                    bst.insert();
                    break;
                case 2:
                    bst.printBST(bst.root);
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Enter data to search:");
                    int data=sc.nextInt();
                    boolean result=bst.search(data);

                    String message=result ? "Number found": "Not found";
                    System.out.println(message);
                    break;
                case 0:
                    
                    break;
                default:
                    break;
            }


        }while(choice!=0);
    }
}
