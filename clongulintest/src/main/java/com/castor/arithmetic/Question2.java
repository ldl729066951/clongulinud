package com.castor.arithmetic;

public class Question2 {

    public static void main(String[] args) {

        //ListNode l13 =new ListNode(3);
        ListNode l14 =new ListNode(9);
        ListNode l234 =new ListNode(9);
        //l14.next = l13;
        l234.next = l14;

        //ListNode l24 =new ListNode(4);
        //ListNode l26 =new ListNode(6);
        ListNode l564 =new ListNode(1);
        //l26.next = l24;
        //l564.next = l26;

        addTwoNumbers(l564, l234);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int jinwei = 0;
        ListNode res = l1;
        ListNode tmp = l1;
        do {
            int total = l1.val + l2.val + jinwei;
            if(jinwei != 0) jinwei = 0;
            l1.val = total % 10;
            if(total >= 10){
                jinwei = total / 10;
            }
            tmp = l1;
            l1 = l1.next;
            l2 = l2.next;
        } while(l1 != null && l2 != null);
        if(l2 != null){
            tmp.next = l2;
            l1 = l2;
        }
        if(l1 != null || jinwei > 0){
            do {
                if(l1 == null){
                    l1 = new ListNode(jinwei);
                    tmp.next = l1;
                    jinwei = 0;
                    l1 = l1.next;
                }else {
                    int total = l1.val + jinwei;
                    if (jinwei != 0) jinwei = 0;
                    if (total >= 10) {
                        jinwei = total / 10;
                    }
                    l1.val = total % 10;
                    tmp = l1;
                    l1 = l1.next;
                }
            } while(l1 != null || jinwei > 0);
        }
        return res;

    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}