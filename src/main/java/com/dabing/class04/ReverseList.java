package com.dabing.class04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReverseList {

    //单链表
    public static class ListNode{
        public int value;
        public ListNode next;

        public ListNode(int data){
            value=data;
        }
    }

    //双链表
    public static class DoubleNode{
        public int value;
        public DoubleNode next;
        public DoubleNode last;

        public DoubleNode(int data){
            value=data;
        }
    }

    //单链表反转
    public static ListNode reverseListNode(ListNode head){
        ListNode next=null;
        ListNode pre=null;
        while (head!=null){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }


    //双链表反转
    public static DoubleNode reverseDoubleNode(DoubleNode head){
        DoubleNode pre=null;
        DoubleNode next=null;
        while(head != null){
            next=head.next;
            head.next=pre;
            head.last=next;
            pre=head;
            head=next;
        }
        return pre;
    }


    //for test
    //随机单链表
    public static ListNode randomListNode(int maxLen, int maxVal){
        int size=(int)(Math.random()*(maxLen+1));
        if(size==0){
            return null;
        }
        ListNode head=new ListNode((int)(Math.random()*(maxVal+1)));
        ListNode cur=head;
        for (;size>1;size--){
            ListNode next = new ListNode((int)(Math.random()*(maxVal+1)));
            cur.next=next;
            cur=next;
        }
        return head;
    }

    //for test
    //用数组记录链表数据
    public static List<Integer> getLinkedListOriginOrder(ListNode head){
        List<Integer> list=new ArrayList<>();
        while (head != null){
            list.add(head.value);
            head=head.next;
        }
        return list;
    }

    //for test
    //测试反转单链表是否正确
    public static boolean checkReverseListNode(List<Integer> origin,ListNode node){
        for(int i= origin.size()-1;i>=0;i--){
            if(!(origin.get(i).equals(node.value))){
                return false;
            }
            node=node.next;
        }
        return true;
    }

    public static void main(String[] args) {
        int maxLen=10;
        int maxVal=100;
        int times=1000000;
        for (int i = 0; i < times; i++) {
            ListNode node = randomListNode(maxLen, maxVal);
            List<Integer> list = getLinkedListOriginOrder(node);
            ListNode node1 = reverseListNode(node);//反转后
            if(!checkReverseListNode(list,node1)){
                System.out.println("Oops!");
                System.out.println("出错了！");
                break;
            }
        }
        System.out.println("通过啦~");
    }
}
