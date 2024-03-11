package com.github.bearboy.array.List;

public class SimpleList {
    private Node head = null;

    /**
     * 通过value 查询node 节点
     *
     * @param value
     * @return
     */
    public Node findByValue(int value) {
        Node p = head;
        while (p != null && p.data != value) {
            p = p.next;
        }
        return p;
    }

    //无头结点
    //表头部插入
    //这种操作将于输入的顺序相反，逆序
    public void InsertToHead(int data) {
        Node node = new Node(null, data);
        insertToHead(node);
    }

    /**
     * 插入节点到Head
     */
    public void insertToHead(Node node) {
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    /**
     * 将数据插入到链表尾部
     *
     * @param data
     */
    public void insertToTail(int data) {
        Node node = new Node(null, data);
        //如果list没有数据
        if (head == null) {
            head = node;
        } else {
            Node p = this.head;
            while (p.next != null) {
                p = p.next;
            }
            node.next = null;
            p.next = node;
        }
    }

    public void insertAfter(Node node, int data) {
        if (node == null) return;
        Node newNode = new Node(null, data);
        newNode.next = node.next;
        node.next = newNode;
    }

    public void insertBefore(Node preNode, int data) {
        if (preNode == null) return;
        Node newNode = new Node(null, data);
        //判断preNode是否为head
        if (head == preNode) {
            newNode.next = preNode;
            head = newNode;
        } else {
            //指向preNode的Node
            Node p = head;
            while (p != null && p.next != preNode) {
                p = p.next;
            }
            //如果没有找到直接返回
            if (p == null) {
                return;
            }
            p.next = newNode;
            newNode.next = preNode;
        }
    }

    public void deleteNode(Node node){
        if (head == null) return;
        //如果node = head
        if (head == node){
            head = node.next;
            return;
        }
        Node p = head;
        while (p!= null && p.next != node){
            p= p.next;
        }
        if (p == null){
            return;
        }
        p.next = node.next;
    }
    public static class Node {
        private Node next;
        private int data;

        public Node(Node next, int data) {
            this.next = next;
            this.data = data;
        }

        public int getData() {
            return data;
        }
    }
    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.println(p.data + " " + p.next);
            p = p.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SimpleList list = new SimpleList();
        int data[] = {1,2,5,3,1};
        for(int i =0; i < data.length; i++){
            list.insertToHead(new Node(null,data[i]));
            list.insertToTail(data[i]);
        }
        Node node = list.findByValue(3);
        list.insertAfter(node,100);
        list.insertBefore(node,200);
        list.printAll();
    }
}
