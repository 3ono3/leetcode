package changeLoc;

/**
 * @author GuoJingyuan
 * @date 2019/8/30
 */
public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode newResult = new Solution().swapPairs(head);
        ListNode p = newResult;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
    public ListNode swapPairs(ListNode head) {
        ListNode p = head;
        ListNode resultHead;
        if (head.next!=null) {
            resultHead = head.next;
        }else {
            return head;
        }
        while (p!= null && p.next != null) {
            ListNode q = p.next;
            p.next = q.next;
            q.next = p;
            p = p.next;
        }
        return resultHead;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
