import java.util.*;

class Node{
  int val;
  Node left;
  Node right;

  public Node(int val){
    this.val = val;
    this.left = null;
    this.right = null;
  }
}
class BST{
  Node root;
  Node crawler;
  public BST(){
    Node root = null;
  }

  public void add(int x){
    if(root == null){
      root = new Node(x);
      crawler = root;
    }
    else{
      if(x < crawler.val){
        if(crawler.left == null){
          crawler.left = new Node(x);
          return;
        }
        else{
          crawler = crawler.left;
          add(x);
        }

      }
      else{
        if(crawler.right == null){
          crawler.right = new Node(x);
          return;
        }
        else{
          crawler = crawler.right;
          add(x);
        }
      }
    }
    crawler = root;
  }

  public void inorder(){
    printInorder(root);
    System.out.println("");
  }

  public void printInorder(Node root){
    if(root == null)
      return;
    printInorder(root.left);
    System.out.println(root.val);
    printInorder(root.right);
  }

  public void preorder(){
    printpreorder(root);
    System.out.println("");
  }

  public void printpreorder(Node root){
    if(root == null)
      return;
    System.out.println(root.val);
    printpreorder(root.left);
    printpreorder(root.right);

  }
  public void postorder(){
    printpostorder(root);
    System.out.println("");
  }

  public void printpostorder(Node root){
    if(root == null)
      return;
    printpostorder(root.left);
    printpostorder(root.right);
    System.out.println(root.val);

  }

  public void min(){
    crawler = root;
    if(crawler == null)
      return;
    else{
      while(crawler.left != null)
        crawler = crawler.left;
      System.out.println(crawler.val);
    }
    crawler = root;
  }

  public void max(){
    crawler = root;
    if(crawler == null)
      return;
    else{
      while(crawler.right != null)
        crawler = crawler.right;
      System.out.println(crawler.val);
    }
    crawler = root;
  }
  public void search(int x){

    if(crawler == null){
      System.out.println("NO");
      return;
    }
    if(x < crawler.val){
      crawler = crawler.left;
      search(x);
    }

    else if(x > crawler.val){
      crawler = crawler.right;
      search(x);
    }
    else{
      System.out.println("found");
    }
      return;
  }

  public void height(){
    crawler = root;
    int x = findHeight(crawler);
    System.out.println(x);
    crawler = root;
  }
  public int findHeight(Node crawler){
    if(crawler == null)
      return -1;
    return(1+ Math.max(findHeight(crawler.left), findHeight(crawler.right)));
  }

  public void delete(int x){
    crawler = root;
    deleteElement(crawler, x);
  }

  public void deleteElement(Node root, int x){
    Node node = searchElement(root, x);
    if(node == null){
      System.out.println("ELEMENT not found");
      return;
    }
    if(node.left == null && node.right == null)
      node = null;
    else if(node.left == null){
      node = node.right;
    }

    else if(node.right == null){
      node = node.left;
    }
    else{
      int y = searchMax(node.left);
      node.val = y;
      deleteElement(node.left, y);

    }
  }
  public Node searchElement(Node root, int x){
    if(root == null)
      return null;
    if(x < root.val)
      searchElement(root.left, x);
    else if(x > root.val)
      searchElement(root.right, x);

      return root;

  }

  public int searchMax(Node root){
    while(root.right != null)
      root = root.right;
    return root.val;
  }
}
public class Demo{
  public static void main(String[] args) {
    BST bst = new BST();
    bst.add(3);
    bst.add(1);
    bst.add(5);
    bst.add(0);
    bst.add(2);
    bst.inorder();
  /*  bst.preorder();
    bst.postorder();
    bst.max();
    bst.min();
    bst.search(2);
    bst.search(10);
    bst.height(); */
    bst.delete(10);
    bst.inorder();
  }
}
