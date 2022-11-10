package com.dabing.class04;

public class ReverseNodesInKGroup {
    // 不要提交这个类
    public static class ListNode {
        public int val;
        public ListNode next;
    }

    //实现体 k组反转
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head;
        ListNode end=getKGroupEnd(start,k);
        if(end == null){
            return head;
        }

        //第一组全凑齐，反转之后head就不变了
        head=end;
        reverse(start,end);

        // 上一组的结尾节点
        ListNode lastEnd = start;
        while (lastEnd.next !=null){
            start=lastEnd.next;
            end=getKGroupEnd(start,k);
            //如果凑不够一组，则直接返回
            if(end==null){
                return head;
            }
            //凑够，反转
            reverse(start,end);
            lastEnd.next=end;
            lastEnd=start;
        }

        return head;

    }

    //获取从start节点开始的第k个结点
    public static ListNode getKGroupEnd(ListNode start, int k) {
        while(--k != 0 && start != null ){
            start=start.next;
        }
        return start;
    }

    //链表反转
    public static void reverse(ListNode start, ListNode end){
        end = end.next;
        ListNode pre=null;
        ListNode cur=start;
        ListNode next=null;
        while (cur!=end){
            next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        start.next=end;

    }
}
