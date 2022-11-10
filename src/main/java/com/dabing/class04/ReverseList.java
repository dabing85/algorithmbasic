package com.dabing.class04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReverseList {

    //������
    public static class ListNode{
        public int value;
        public ListNode next;

        public ListNode(int data){
            value=data;
        }
    }

    //˫����
    public static class DoubleNode{
        public int value;
        public DoubleNode next;
        public DoubleNode last;

        public DoubleNode(int data){
            value=data;
        }
    }

    //������ת
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


    //˫����ת
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
    //���������
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
    //�������¼��������
    public static List<Integer> getLinkedListOriginOrder(ListNode head){
        List<Integer> list=new ArrayList<>();
        while (head != null){
            list.add(head.value);
            head=head.next;
        }
        return list;
    }

    //for test
    //���Է�ת�������Ƿ���ȷ
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
            ListNode node1 = reverseListNode(node);//��ת��
            if(!checkReverseListNode(list,node1)){
                System.out.println("Oops!");
                System.out.println("�����ˣ�");
                break;
            }
        }
        System.out.println("ͨ����~");
    }
}
