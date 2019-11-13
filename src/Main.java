import java.util.ArrayList;

class Main {

/*
* [[0,8,6,5,6,8,3,5,7]
[6,7,8,0,8,5,8,9,7]*/
    public static void main(String[] args) {
        Solution s =  new Solution();
        int[] a1= {0,8,6,5,6,8,3,5,7};
        int[] a2= {6,7,8,0,8,5,8,9,7};
        char[] sar = {'a','b'};
        String[] asb = {"asd"};

        ArrayList<Character> aryL = new ArrayList<Character>();
        aryL.add(sar[1]);
        aryL.get(0).equals(sar[0]);
        ListNode l1 = new ListNode(a1[0]);
        aryL.clear();
        ListNode tmp = l1;
        for(int i = 1; i < a1.length; i++){
            tmp.next = new ListNode(a1[i]);
            tmp = tmp.next;
        }

        ListNode l2 = new ListNode(a2[0]);
        ListNode tmp2 = l2;
        for(int i = 1; i < a2.length; i++){
            tmp2.next = new ListNode(a2[i]);
            tmp2 = tmp2.next;
        }

//        int s1 = 753865680;
//        int s2 = 798580876;
//        System.out.println(s1+s2);
        s.addTwoNumbers(l1,l2);

    }

}
