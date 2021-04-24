package algorithm;

/**
 * @author: chenbowei
 * @since: 2021/4/24 09:40
 **/
public class Problem2 {

    public static void main(String[] args) {
//        [0,8,6,5,6,8,3,5,7]
//        [6,7,8,0,8,5,8,9,7]
        ListNode l1 = new ListNode(0, new ListNode(8, new ListNode(6, new ListNode(5, new ListNode(6, new ListNode(8, new ListNode(3, new ListNode(5, new ListNode(7)))))))));
        ListNode l2 = new ListNode(6, new ListNode(7, new ListNode(8, new ListNode(0, new ListNode(8, new ListNode(5, new ListNode(8, new ListNode(9, new ListNode(7)))))))));
        ListNode sum = addTwoNumbers(l1, l2);

        while (sum != null) {
            System.out.println(sum.val);
            sum = sum.next;
        }

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode start, sp, n1, n2;
        start = sp = new ListNode(0);
        n1 = l1;
        n2 = l2;
        int carry, left, tmp;

        if (l1.val == 0 && l1.next == null) {
            return l2;
        }
        if (l2.val == 0 && l2.next == null) {
            return l1;
        }

        while (n1 != null || n2 != null) {
            carry = sp.val;
            tmp = (n1 == null ? 0 : n1.val) + (n2 == null ? 0 : n2.val) + carry;
            left = tmp % 10;
            carry = tmp - 10;
            if (carry >= 0) {
                sp.next = new ListNode(1);
            } else {
                sp.next = new ListNode(0);
            }
            sp.val = left;
            n1 = n1 == null ? null : n1.next;
            n2 = n2 == null ? null : n2.next;
            if (carry < 0 && n1 == null && n2 == null) {
                sp.next = null;
            } else {
                sp = sp.next;
            }
        }
        return start;

    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
