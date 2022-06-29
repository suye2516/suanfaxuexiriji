package binaryTree;

import java.util.Stack;

public class BinaryTree {
    public static class Node{
        int value;
        Node left;
        Node right;
        public Node(){

        }
        public Node(int data){
            this.value=data;
        }
    }
    //递归先序遍历
    public static void pre(Node head){
        System.out.print(head.value+" ");
        pre(head.left);
        pre(head.right);
    }
    //栈实现先序遍历
    public static void pre_Stack(Node head){
        Stack<Node> s=new Stack<>();
        if(head!=null){
            s.add(head);
            while (!s.isEmpty()) {
                head=s.pop();
                System.out.print(head.value + " ");
                if(head.right!=null){
                    s.push(head.right);
                }
                if(head.left!=null){
                    s.push(head.left);
                }
            }
        }
    }
    //递归后序遍历
    public static void pos(Node head){
        pos(head.left);
        pos(head.right);
        System.out.print(head.value+" ");
    }
    //栈实现后序遍历
    public static void pos_Stack(Node head){
        Stack<Node> s1=new Stack<>();
        Stack<Node> s2=new Stack<>();
        if(head!=null){
            s1.add(head);
            while (!s1.isEmpty()) {
                head=s1.pop();
                s2.push(head);
                if(head.left!=null){
                    s1.push(head.left);
                }
                if(head.right!=null){
                    s1.push(head.right);
                }
            }
            while (!s2.isEmpty()){
                System.out.print(s2.pop().value+" ");
            }
        }
    }
    //递归中序
    public static void in(Node head){
        in(head.left);
        System.out.print(head.value+" ");
        in(head.right);
    }
    //非递归中序
    public static void in_stack(Node head){
        if(head!=null){
            Stack<Node> s=new Stack<>();
            while (!s.isEmpty()||head!=null){
                if(head!=null){
                    s.push(head);
                    head=head.left;
                }
                else {
                    head=s.pop();
                    System.out.print(head.value+" ");
                    head=head.right;
                }
            }
        }
    }
    public static void main(String[] args) {
       Node head = new Node(((int)Math.random()*100));
        head.left = new Node((int)Math.random()*100);
        head.right = new Node((int)Math.random()*100);
        head.left.left = new Node((int)Math.random()*100);
        head.right.left = new Node((int)Math.random()*100);
        head.right.right = new Node((int)Math.random()*100);
        head.left.left.right = new Node((int)Math.random()*100);
    }
}
