package com.keduw;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author lveex
 * @date 2020/09/24
 */
public class AddTwoNumbers {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> itemList1 = new ArrayList<Integer>();
        List<Integer> itemList2 = new ArrayList<Integer>();
        while(l1 != null || l2 != null){
            if(l1 != null){
                itemList1.add(l1.val);
                l1 = l1.next;
            }
            if(l2 != null){
                itemList2.add(l2.val);
                l2 = l2.next;
            }
        }
        Collections.reverse(itemList1);
        Collections.reverse(itemList2);
        String str1 = "";
        String str2 = "";
        for (Integer i : itemList1) {
            str1 += String.valueOf(i);
        }
        for (Integer i : itemList2) {
            str2 += String.valueOf(i);
        }
        BigDecimal decimal1 = new BigDecimal(str1);
        BigDecimal decimal2 = new BigDecimal(str2);
        BigDecimal add = decimal1.add(decimal2);
        char[] chars = String.valueOf(add.longValue()).toCharArray();
        int header = Integer.parseInt(String.valueOf(chars[chars.length - 1]));
        ListNode headNode = new ListNode(header);
        ListNode currNode = headNode;
        for (int i = chars.length - 2; i >= 0; i--) {
            int nextNum = Integer.parseInt(String.valueOf(chars[i]));
            ListNode nextNode = new ListNode(nextNum);
            currNode.next = nextNode;
            currNode = nextNode;
        }
        return headNode;
    }
}
