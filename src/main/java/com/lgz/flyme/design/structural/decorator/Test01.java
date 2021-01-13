package com.lgz.flyme.design.structural.decorator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @author liguangzhi
 * @date 2020/09/25 14:51
 */
public class Test01 {
    public static void main(String[] args) {

        //[[1,1,1],[1,2,2],[1,3,2],[2,1],[1,4,4],[2,2]],3

        int[][] operators = {{1, 1, 1}, {1, 2, 2}, {1, 3, 2}, {2, 1}, {1, 4, 4}, {2, 2}};




        Test01 test01 = new Test01();
        int[] lru = test01.LRU(operators, 3);
        System.out.println(lru);
    }

    private static LinkNode head = null;
    private static LinkNode tail = null;
    static HashMap<Integer, LinkNode> map = new HashMap<>();
    public  int[] LRU (int[][] operators, int k) {
        // write code here
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<operators.length; i++) {
            if(operators[i][0] == 1) {
                // set

                LinkNode nowNode = new LinkNode(operators[i][1], operators[i][2]);


                set(nowNode, k);
            }else {
                //get
                list.add(get(operators[i][1]));
            }


        }
        int[]result = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;

    }

    public static void set(LinkNode node, int k) {
        if(map.size() == k) {
            if(!map.containsKey(node.key)) {
                // 首先要移除尾部节点
                map.remove(tail.key);
                tail = tail.prev;
                tail.next = null;
                // 然后把节点放在头部
                node.next = head.next;
                node.prev = head.prev;
                head = node;
                map.put(node.key, node);

            } else {

                LinkNode nowNode = map.get(node.key);
                // 移到头部
                nowNode.prev.next = nowNode.next;
                nowNode.next.prev = nowNode.prev;
                nowNode.next = head.next;
                nowNode.prev = head.prev;
                nowNode.value = node.value;
                head = nowNode;
                if(map.size() == 0) {
                    tail = head;
                }

                map.put(node.key, node);
            }
        } else {
            if(!map.containsKey(node.key)) {

                if(head == null) {
                    head = node;
                    tail = node;
                } else {
                    // 然后把节点放在头部
                    node.next = head;
                    head.prev = node;
                    head =  node;


                }


                map.put(node.key, node);

            } else {

                LinkNode nowNode = map.get(node.key);
                // 移到头部
                nowNode.prev.next = nowNode.next;
                nowNode.next.prev = nowNode.prev;
                nowNode.next = head.next;
                nowNode.prev = head.prev;
                nowNode.value = node.value;
                head = nowNode;
                if(map.size() == 0) {
                    tail = head;
                }

                map.put(node.key, node);
            }
        }
    }

    public static int get(Integer key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        LinkNode nowNode = map.get(key);
        // 移到头部
        if(map.size() > 1) {

            if(nowNode == head) {
                return nowNode.value;
            }

            if(nowNode == tail) {
                tail = nowNode.prev;
                tail.next = null;


                nowNode.prev = null;
                head.prev = nowNode;
                nowNode.next = head;
                head = nowNode;
            }
        }

        return nowNode.value;


    }

    static class LinkNode{


        public LinkNode prev;
        public LinkNode next;
        public Integer key;
        public Integer value;

        public LinkNode(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

}
