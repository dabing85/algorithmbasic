package com.dabing.class04;

public class ReverseNodesInKGroup {
    // ��Ҫ�ύ�����
    public static class ListNode {
        public int val;
        public ListNode next;
    }

    //ʵ���� k�鷴ת
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head;
        ListNode end=getKGroupEnd(start,k);
        if(end == null){
            return head;
        }

        //��һ��ȫ���룬��ת֮��head�Ͳ�����
        head=end;
        reverse(start,end);

        // ��һ��Ľ�β�ڵ�
        ListNode lastEnd = start;
        while (lastEnd.next !=null){
            start=lastEnd.next;
            end=getKGroupEnd(start,k);
            //����ղ���һ�飬��ֱ�ӷ���
            if(end==null){
                return head;
            }
            //�չ�����ת
            reverse(start,end);
            lastEnd.next=end;
            lastEnd=start;
        }

        return head;

    }

    //��ȡ��start�ڵ㿪ʼ�ĵ�k�����
    public static ListNode getKGroupEnd(ListNode start, int k) {
        while(--k != 0 && start != null ){
            start=start.next;
        }
        return start;
    }

    //����ת
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
