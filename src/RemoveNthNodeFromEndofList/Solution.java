package RemoveNthNodeFromEndofList;

public class Solution {
    public static void main(String[] args) {
        ListNode f = new ListNode(5);
        ListNode four = new ListNode(4);
        four.next = f;
        ListNode three = new ListNode(3);
        three.next = four;
        ListNode two = new ListNode(2);
//        two.next = three;
        ListNode head = new ListNode(1);
        head.next = two;
        Solution solution = new Solution();
        solution.printList(head);
        ListNode result = solution.removeNthFromEnd(head, 1);
        solution.printList(head);
    }
    public void printList(ListNode head) {
        System.out.print(head.val + "->");
        ListNode next = head.next;
        while (next != null) {
            System.out.print(next.val + "->");
            next = next.next;
        }
        System.out.println();
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 1;
        int begin = 0;
        ListNode next = head.next;
        while(next != null) {
            next = next.next;
            length++;
        }
        begin = length - n;
        if (begin == 0) {
            return head.next;
        }
        ListNode beforNode = head;
        for (int nodeNum = 1; nodeNum < begin; nodeNum++) {
            beforNode = beforNode.next;
        }
        ListNode removeNode= beforNode.next;
        beforNode.next = removeNode.next;
        return  head;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
