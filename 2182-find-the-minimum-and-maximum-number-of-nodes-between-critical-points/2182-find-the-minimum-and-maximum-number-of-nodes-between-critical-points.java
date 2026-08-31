/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int firstIdx = -1, lastIdx = -1, minDist = Integer.MAX_VALUE, idx = 1;
        ListNode prev = head;
        ListNode curr = head.next;

        while (curr.next != null) {
            boolean isMaxima = curr.val > prev.val && curr.val > curr.next.val;
            boolean isMinima = curr.val < prev.val && curr.val < curr.next.val;

            if (isMaxima == true || isMinima == true) {
                if (firstIdx == -1) {
                    firstIdx = idx;
                } else {
                    minDist = Math.min(minDist, idx - lastIdx);
                }
                lastIdx = idx;
            }
            prev = curr;
            curr = curr.next;
            idx++;
        }

        if (firstIdx == -1 || firstIdx == lastIdx) return new int[] {-1, -1};
        return new int[] {minDist, lastIdx - firstIdx};
    }
}