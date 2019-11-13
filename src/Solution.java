/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Long sum,l1Num,l2Num;
        l1Num = listToNum(l1);
        l2Num = listToNum(l2);
        sum = l1Num + l2Num;
        ListNode result = numberToList(sum);
        ListNode tmp = result;
        while(tmp != null){
            System.out.print(tmp.val + " ");
            tmp = tmp.next;
        }
        return result;
    }
    public Long listToNum(ListNode l){
        ListNode tmp = l;
        if (l == null){
            return -1L;
        }
        Long number = 0L;
        ListNode p = l;
        while(l != null){
            number = number*10 + l.val;
            p = l;
            l = l.next;
        }
        if(p.val == 0){
            return 0L;
        }
        number = reversalOfNum(number);
        while(tmp.val == 0){
            number = number * 10;
            tmp = tmp.next;
        }
        return number;
    }
    public Long reversalOfNum(Long number){
        Long tmp = number;
        Long p = 0L;
        while(tmp != 0){
            p = p*10 + tmp%10;
            tmp = tmp/10;
        }
        return p;
    }
    public ListNode numberToList(Long num){
        Long yu = num % 10;
        ListNode p = new ListNode(yu.intValue());
        num = num/10;
        ListNode l = p;
        while(num != 0){
            Long yu1 = num % 10;
            l.next = new ListNode(yu1.intValue());
            num = num/10;
            l = l.next;
        }
        return p;
    }
}