package com.dabing.class04;

public class AddTwoNumbers {
    // 不要提交这个类
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1=listLength(l1);
        int len2=listLength(l2);
        ListNode nodeL = len1 >= len2 ? l1 : l2;  //长链
        ListNode nodeS = nodeL==l1 ? l2 : l1 ;//短链

        int carry = 0;
        ListNode curS=nodeS;//当前短链数据
        ListNode curL=nodeL;//当前长链数据
        ListNode last=nodeL;//记录最后结尾的结点（最后一位需进位时使用）
        int curNum=0;


        while (curS != null){
            curNum=curL.val+curS.val+carry;
            curL.val=curNum%10;
            carry=curNum/10;
            last=curL;
            curL=curL.next;
            curS=curS.next;
        }
        while (curL != null){
            curNum=curL.val+carry;
            curL.val=curNum%10;
            carry=curNum/10;
            last=curL;
            curL=curL.next;
        }
        if(carry != 0){
            last.next=new ListNode(1);
        }
        return nodeL;
    }


    //求链表长度
    public static int listLength(ListNode node){
        int len=0;
        while (node != null){
            len++;
            node=node.next;
        }
        return len;
    }




}
