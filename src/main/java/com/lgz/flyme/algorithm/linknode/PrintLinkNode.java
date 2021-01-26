package com.lgz.flyme.algorithm.linknode;

import com.lgz.flyme.common.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author: liguangzhi01
 * @date: 2021/1/25
 */
public class PrintLinkNode {

    /**
     * 利用栈， 单链表从尾到头打印节点
     * @param listNode 链表头节点
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

    /**
     * 递归实现， 单链表从尾到头打印节点
     * @param node
     * @param result
     */
    public void addVal(ListNode node, ArrayList<Integer> result) {
        if (node == null) {
            return;
        }
        addVal(node.next, result);
        result.add(node.val);
    }

}
