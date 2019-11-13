import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author GUOJINGYUAN487
 * @since 2018/11/11 0011
 */
public class Solution1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tmp1=l1,tmp2 = l2;
        int sum = tmp1.val + tmp2.val;
        tmp1 = tmp1.next;
        tmp2 = tmp2.next;
        ListNode result = new ListNode(sum%10);
        ListNode tmpRes = result;
        int carry = sum/10;
        while(tmp1 !=null && tmp2 != null){
            int tmpSum = tmp1.val +tmp2.val+carry;
            tmpRes.next = new ListNode(tmpSum%10);
            carry = tmpSum/10;
            tmp1 = tmp1.next;
            tmp2 = tmp2.next;
            tmpRes = tmpRes.next;
        }
        while(tmp1 != null){
            int tmpSum = tmp1.val + carry;
            tmpRes.next = new ListNode(tmpSum%10);
            carry = tmpSum/10;
            tmpRes = tmpRes.next;
            tmp1 = tmp1.next;
        }
        while(tmp2 != null){
            int tmpSum = tmp2.val + carry;
            tmpRes.next = new ListNode(tmpSum%10);
            carry = tmpSum/10;
            tmpRes = tmpRes.next;
            tmp2 = tmp2.next;
        }
        if(carry != 0){
            tmpRes.next = new ListNode(carry);
        }
        return result;
    }
    public void onIsNull(ListNode l, ListNode res, int carry){
        while(l != null){
            int sum = l.val + carry;
            res.next = new ListNode(sum%10);
            carry = sum/10;
            res = res.next;
            l = l.next;
        }
    }
}


class Solution2 {
    public int numTilePossibilities(String tiles) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(){{
            put(1,1);
            put(2,2);	put(11,4);
            put(3,3);	put(12,8);	put(111,15);
            put(4,4);	put(13,13);	put(22,18);	put(112,34);	put(1111,64);
            put(5,5);	put(14,19);	put(23,33);	put(113,63);	put(122,89);	put(1112,170);	put(11111,325);
            put(6,6);	put(15,26);	put(24,54);	put(114,104);	put(33,68);	put(123,188);	put(1113,363);	put(222,270);	put(1122,522);	put(11112,1010);	put(111111,1956);
            put(7,7);	put(16,34);	put(25,82);	put(115,159);	put(34,124);	put(124,349);	put(1114,679);	put(133,447);	put(223,649);	put(1123,1265);	put(11113,2467);	put(1222,1840);	put(11122,3591);	put(111112,7012);	put(1111111,13699);
        }};
        char chars[] = {'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0'};
        for(int i=0; i<tiles.length(); i++){
            chars[tiles.charAt(i)-'A'] ++;
        }
        Arrays.sort(chars);
        return map.get(Integer.valueOf(String.valueOf(chars)));
    }
}
