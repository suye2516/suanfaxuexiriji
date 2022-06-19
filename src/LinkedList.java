public class LinkedList {
    //单链表
    public static class node{
        public int value;
        public node next;
        public node(int data){
            this.value=data;
        }

    }
    //单链表逆序
    public static node reverseLinkedList(node head){
        node pre=null;
        node next=null;
        while (head!=null){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }
    //双链表
    public static class doublenode{
        public int value;
        public doublenode last;
        public doublenode next;
        public doublenode(int data){
            this.value=data;
        }
    }
    public static doublenode reverseDoubleLinkedList(doublenode head){
        doublenode pre=null;
        doublenode next=null;
        while (head!=null){
            next=head.next;
            head.last=next;
            head.next=pre;
            next.last=head;
            pre=head;
            head=next;
        }
        return pre;
    }
    public static void main(String[] args) {
        node n1=new node(1);
        n1.next=new node(2);
        n1.next.next=new node(3);
        n1.next.next.next=new node(4);
        node n2=reverseLinkedList(n1);
        while (n2!=null){
            System.out.print(n2.value+" ");
            n2=n2.next;
        }
    }
}
