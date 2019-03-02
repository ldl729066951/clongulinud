package com.castor.leetcode;

public class Question_2 {

  public static void main(String[] args) {
	  //[2,4,3]
	  //[5,6,4]

	  ListNode l1 = new ListNode(1);

	  ListNode l2 = new ListNode(9);
	  ListNode l21 = new ListNode(9);
	  l2.next = l21;

	  ListNode l3 = addTwoNumbers(l1, l2);
	  System.out.println(l3);
  }

	/**
	 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	   Output: 7 -> 0 -> 8
	   Explanation: 342 + 465 = 807.
	 */
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
		ListNode l3 = l1;
		while(l1 != null){
			int sum = l1.val  + (l2 == null ? 0 : l2.val) + carry;
			int residue = sum % 10;
			carry = sum / 10;
			l1.val = residue;
			if(l1.next != null && (l2 != null && l2.next != null)){
				l2 = l2.next;
				l1 = l1.next;
			}else if(l1.next == null && (l2 != null && l2.next == null)){
				//判断 carry
				if (carry > 0){
					l1.next = new ListNode(carry);
				}
				break;
			}else {
				if(l1.next == null && (l2 != null && l2.next != null)){
					l1.next = l2.next;
					l2.next = null;
				}
				if(carry == 0){
					break;
				}
				if(l1.next == null){
					l1.next = new ListNode(carry);
					break;
				}
				if(l2 != null) l2 = l2.next;
				l1 = l1.next;
			}
		}
		return l3;
	}

	/**
	 *
	 *
	 public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	 	int carry = 0;
	 	ListNode l3 = l1;
	 	ListNode zeroNode = new ListNode(0);
	 	while(l1 != null && l2 != null){
		 int sum = l1.val  + l2.val + carry;
		 int residue = sum % 10;
		 carry = sum / 10;
		 l1.val = residue;
		 if(l1.next != null && l2.next != null){
			 l2 = l2.next;
			 l1 = l1.next;
		 }else if(l1.next == null && l2.next == null){
		 //判断 carry
			 if (carry > 0){
			 	l1.next = new ListNode(carry);
			 }
		 	break;
		 }else {
			 if(l1.next == null && l2.next != null){
				 l1.next = l2.next;
				 l2.next = zeroNode;
			 }
			 if(carry == 0){
			 	break;
			 }
			 if(l2.next == null) l2.next = zeroNode;
			 l2 = l2.next;
			 l1 = l1.next;
		 }
		 }
		 return l3;
	 }
	 *
	 */

}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}
