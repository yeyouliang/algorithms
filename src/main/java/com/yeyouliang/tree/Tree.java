package com.yeyouliang.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YEYOULIANG on 2020/4/29.
 */
public class Tree {

    @Test
    public void erCha() {
        Node n4=new Node(4,null,null);
        Node n5=new Node(5,null,null);
        Node n7=new Node(7,null,null);
        Node n2=new Node(2,n4,n5);
        Node n3=new Node(3,null,n7);
        Node n1=new Node(1,n2,n3);
        new Tree().preOrderRecur(n1);
    }

    class Node {//二叉树节点
        public int value;
        public Node left;
        public Node right;
        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    public void preOrderRecur(Node head) {//前序遍历
        if (head == null) {
            return;
        }
        System.out.print(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    public void inOrderRecur(Node head) {//中序遍历
        if (head == null) {
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.value + " ");
        inOrderRecur(head.right);
    }

    public void posOrderRecur(Node head) {//后序遍历
        if (head == null) {
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.value + " ");
    }

    class TreeNode{
        TreeNode left;
        TreeNode right;
        Integer value;

        public TreeNode(TreeNode left, TreeNode right, Integer value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return ""+value;
        }
    }

    public static List<TreeNode> treeNodes=new ArrayList<>();
    public void before(TreeNode treeNode){
        if (treeNode==null){
            return;
        }
        treeNodes.add(treeNode);
        before(treeNode.getLeft());
        before(treeNode.getRight());
    }

    public void middle(TreeNode treeNode){
        if (treeNode==null){
            return;
        }
        middle(treeNode.getLeft());
        treeNodes.add(treeNode);
        middle(treeNode.getRight());
    }

    public void after(TreeNode treeNode){
        if (treeNode==null){
            return;
        }
        after(treeNode.getLeft());
        after(treeNode.getRight());
        treeNodes.add(treeNode);
    }

    @Test
    public void ttn(){//success
        TreeNode t0=new TreeNode(null,null,0);
        TreeNode t2=new TreeNode(null,null,2);
        TreeNode t8=new TreeNode(null,null,8);
        TreeNode t10=new TreeNode(null,null,10);
        TreeNode t4=new TreeNode(null,null,4);
        TreeNode t6=new TreeNode(null,null,6);
        TreeNode t9=new TreeNode(t8,t10,9);
        TreeNode t1=new TreeNode(t0,t2,1);
        TreeNode t7=new TreeNode(t6,t9,7);
        TreeNode t3=new TreeNode(t1,t4,3);
        TreeNode t5=new TreeNode(t3,t7,5);
        //before(t5);
        //middle(t5);
        after(t5);
        System.out.println("dfgdf");
    }

    /*public boolean isBalanced(TreeNode root) {

    }*/

    public static int ltc=0;
    public static int rtc=0;
    public void ltn(TreeNode root){

    }
}
