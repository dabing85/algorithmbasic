package com.dabing.class04;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 1. �õ�����ʵ�ֶ��нṹ
 2. �õ�����ʵ��ջ�ṹ
 */
public class LinkedListToQueueAndStack {
    //������
    public static class ListNode<E>{
        public E value;
        public ListNode<E> next;

        public ListNode(E data){
            value=data;
        }
    }

    //����
    public static class MyQueue<E>{
        public int size;
        public ListNode<E> head;
        public ListNode<E> tail;

        public MyQueue(){
            head=null;
            tail=null;
            size=0;
        }

        public int size(){
            return size;
        }

        //�п�
        public boolean isEmpty(){
            return size==0;
        }

        //�����
        public boolean offer(E e){
            ListNode<E> node=new ListNode<E>(e);
            if(size==0){
                head=node;
                tail=node;
            }else {
                tail.next=node;
                tail=node;
            }
            size++;
            return true;
        }

        //������ �Ӷ�β
        public E poll(){
            E ans=null;
            if(head!=null){
                ans=head.value;
                head=head.next;
                size--;
            }
            if(head==null){
                tail=null;
            }
            return ans;
        }

        //ȡԪ��  ��ɾ��Ԫ��
        public E peek(){
            E ans=null;
            if(head!=null){
                ans=head.value;
            }
            return ans;
        }

    }

    //ջ
    public static class MyStack<V> {
        private ListNode<V> head;
        private int size;

        public MyStack() {
            head = null;
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        public void push(V value) {
            ListNode<V> cur = new ListNode<>(value);
            if (head == null) {
                head = cur;
            } else {
                cur.next = head;
                head = cur;
            }
            size++;
        }

        public V pop() {
            V ans = null;
            if (head != null) {
                ans = head.value;
                head = head.next;
                size--;
            }
            return ans;
        }

        public V peek() {
            return head != null ? head.value : null;
        }

    }

    //for test
    public static void testQueue() {
        MyQueue<Integer> myQueue = new MyQueue<>();
        Queue<Integer> test = new LinkedList<>();
        int testTime = 5000000;
        int maxValue = 200000000;
        System.out.println("���Կ�ʼ��");
        for (int i = 0; i < testTime; i++) {
            if (myQueue.isEmpty() != test.isEmpty()) {
                System.out.println("Oops!");
            }
            if (myQueue.size() != test.size()) {
                System.out.println("Oops!");
            }
            double decide = Math.random();
            if (decide < 0.33) {
                int num = (int) (Math.random() * maxValue);
                myQueue.offer(num);
                test.offer(num);
            } else if (decide < 0.66) {
                if (!myQueue.isEmpty()) {
                    int num1 = myQueue.poll();
                    int num2 = test.poll();
                    if (num1 != num2) {
                        System.out.println("Oops!");
                    }
                }
            } else {
                if (!myQueue.isEmpty()) {
                    int num1 = myQueue.peek();
                    int num2 = test.peek();
                    if (num1 != num2) {
                        System.out.println("Oops!");
                    }
                }
            }
        }
        if (myQueue.size() != test.size()) {
            System.out.println("Oops!");
        }
        while (!myQueue.isEmpty()) {
            int num1 = myQueue.poll();
            int num2 = test.poll();
            if (num1 != num2) {
                System.out.println("Oops!");
            }
        }
        System.out.println("���Խ�����");
    }

    public static void testStack() {
        MyStack<Integer> myStack = new MyStack<>();
        Stack<Integer> test = new Stack<>();
        int testTime = 5000000;
        int maxValue = 200000000;
        System.out.println("���Կ�ʼ��");
        for (int i = 0; i < testTime; i++) {
            if (myStack.isEmpty() != test.isEmpty()) {
                System.out.println("Oops!");
            }
            if (myStack.size() != test.size()) {
                System.out.println("Oops!");
            }
            double decide = Math.random();
            if (decide < 0.33) {
                int num = (int) (Math.random() * maxValue);
                myStack.push(num);
                test.push(num);
            } else if (decide < 0.66) {
                if (!myStack.isEmpty()) {
                    int num1 = myStack.pop();
                    int num2 = test.pop();
                    if (num1 != num2) {
                        System.out.println("Oops!");
                    }
                }
            } else {
                if (!myStack.isEmpty()) {
                    int num1 = myStack.peek();
                    int num2 = test.peek();
                    if (num1 != num2) {
                        System.out.println("Oops!");
                    }
                }
            }
        }
        if (myStack.size() != test.size()) {
            System.out.println("Oops!");
        }
        while (!myStack.isEmpty()) {
            int num1 = myStack.pop();
            int num2 = test.pop();
            if (num1 != num2) {
                System.out.println("Oops!");
            }
        }
        System.out.println("���Խ�����");
    }

    public static void main(String[] args) {
        testQueue();
        testStack();
    }
}
