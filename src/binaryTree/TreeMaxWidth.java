package binaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TreeMaxWidth {
    //获取最大宽度
    public static int getMaxWidth(BinaryTree.Node h){
        int max=0;
        int curLevel=1;//当前正在统计那一层
        int curNodes=0;//当前curLevel层节点数
        Queue<BinaryTree.Node> q=new LinkedList<>();
        HashMap<BinaryTree.Node,Integer> m=new HashMap<>();
        if(h!=null){
            q.add(h);
            m.put(h,1);
            while (!q.isEmpty()){
                h=q.poll();
                int level=m.get(h);//当前节点所在层数
                if(h.left!=null){
                    q.add(h.left);
                    m.put(h.left,level+1);
                }
                if(h.right!=null){
                    q.add(h.right);
                    m.put(h.right,level+1);
                }
                if(curLevel==level){
                    curNodes++;
                }
                else {
                    max=Math.max(curNodes,max);
                    curNodes=1;
                    curLevel=level;
                }
            }
            max=Math.max(max,curNodes);
        }
        return max;
    }
    //获取最大宽度(不用Map)
    public static int getMaxWidth2(BinaryTree.Node h){
        int max=0;
        int curNodes=0;//当前curLevel层节点数
        BinaryTree.Node curEnd=h;//当前层最右节点
        BinaryTree.Node nectEnd=null;//下层最右节点
        Queue<BinaryTree.Node> q=new LinkedList<>();
        if(h!=null){
            q.add(h);
            while (!q.isEmpty()){
                h=q.poll();
                curNodes++;
                if(h.left!=null){
                    q.add(h.left);
                    nectEnd=h.left;
                }
                if(h.right!=null){
                    q.add(h.right);
                    nectEnd=h.right;
                }
                if(h!=curEnd){
                    curNodes++;
                }
                else {
                    max=Math.max(curNodes,max);
                    curNodes=0;
                    curEnd=nectEnd;
                }
            }
            max=Math.max(max,curNodes);
        }
        return max;
    }
    public static void main(String[] args) {
        BinaryTree.Node h=null;
    }
}
