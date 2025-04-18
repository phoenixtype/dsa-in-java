/**
 *
 * Think of a line of people holding hands, like kids in a school line: <br/>
 *
 * <br/>
 * John → Amy → Sam → Kate → null<br/>
 * <br/>
 *
 * Each person is only holding the hand of the person in front of them.<br/>
 *
 * Now, to reverse this line:<br/>
 *
 * 1. We start with no one behind us (prev = null) and John at the front (curr = head).<br/>
 *
 * 2. For each person (curr):<br/>
 *    - We remember who they're currently holding hands with (next = curr.next)<br/>
 *    - We tell them to let go of that hand and instead hold hands with the person behind them (curr.next = prev)<br/>
 *    - We move forward in the line: the person we just processed is now behind us (prev = curr)<br/>
 *    - We focus on the next person in the original line (curr = next)<br/>
 *
 * Let's go through it step by step:<br/>
 *
 * Initial state:<br/>
 * - prev = null<br/>
 * - curr = John<br/>
 * - Line: John → Amy → Sam → Kate → null<br/>
 *
 * Step 1:<br/>
 * - Remember who John is holding hands with: next = Amy<br/>
 * - Tell John to let go of Amy and turn around to hold hands with no one: John → null<br/>
 * - John is now behind us: prev = John<br/>
 * - Focus on Amy: curr = Amy<br/>
 * - Line becomes: John → null    Amy → Sam → Kate → null<br/>
 *
 * Step 2:<br/>
 * - Remember who Amy is holding hands with: next = Sam<br/>
 * - Tell Amy to let go of Sam and hold hands with John: Amy → John → null<br/>
 * - Amy is now behind us: prev = Amy<br/>
 * - Focus on Sam: curr = Sam<br/>
 * - Line becomes: Amy → John → null    Sam → Kate → null<br/>
 *
 * Step 3:<br/>
 * - Remember who Sam is holding hands with: next = Kate<br/>
 * - Tell Sam to let go of Kate and hold hands with Amy: Sam → Amy → John → null<br/>
 * - Sam is now behind us: prev = Sam<br/>
 * - Focus on Kate: curr = Kate<br/>
 * - Line becomes: Sam → Amy → John → null    Kate → null<br/>
 *
 * Step 4:<br/>
 * - Remember who Kate is holding hands with: next = null<br/>
 * - Tell Kate to hold hands with Sam: Kate → Sam → Amy → John → null<br/>
 * - Kate is now behind us: prev = Kate<br/>
 * - Focus on next person: curr = null (we're done!)<br/>
 * - Final line: Kate → Sam → Amy → John → null<br/>
 *
 * Since there's no one left in the original line (curr = null), we're done. The line is now led by Kate (prev), and the direction has been completely reversed.<br/>
 *
 * Does this help make more sense of the algorithm?<br/>
 */

public class ReverseSinglyLinkedLIst {

    public static void main(String[] args) {
        // Create the original list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

//        // Print original list
//        System.out.print("Original list: ");
//        printList(head);
//
//        // Reverse the list
//        ListNode reversedHead = reversedList(head);
//        System.out.println("Reversed head: " + reversedHead.value);
//
//        // Print the reversed list
//        System.out.print("Reversed list: ");
//        printList(reversedHead);

        ListNode reversedRecursiveHead = reverseListRecursive(head);
        System.out.println("Recursive Result: " + reversedRecursiveHead.value);

        printList(reversedRecursiveHead);
    }

    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.value);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }

    public static class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
            this.next = null;
        }
    }


    public static ListNode reversedList(ListNode head) {
        ListNode curr = head;    // Current node, start at head
        ListNode prev = null;    // Previous node, start as null

        while (curr != null) {
            ListNode next = curr.next;  // Save the next node
            curr.next = prev;           // Reverse the pointer
            prev = curr;                // Move prev one step forward
            curr = next;                // Move curr one step forward
        }
        return prev;  // prev is the new head of the reversed list
    }



    /**
     * Each person turns around to hold hands with the person behind them, working from back to front, until everyone is facing the opposite direction with 5 as the new leader. <br/>
     * <br/>
     * Starting:  1 → 2 → 3 → 4 → 5 <br/>
     * Step 1: 5 turns around and grabs 4: 1 → 2 → 3 → 4 ← 5 <br/>
     * Step 2: 4 turns around and grabs 3: 1 → 2 → 3 ← 4 ← 5 <br/>
     * Step 3: 3 turns around and grabs 2: 1 → 2 ← 3 ← 4 ← 5 <br/>
     * Step 4: 2 turns around and grabs 1: 1 ← 2 ← 3 ← 4 ← 5 <br/>
     * Final: 5 → 4 → 3 → 2 → 1 <br/>
     */

    public static ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseListRecursive(head.next); //  we keep walking to the end of the line until we reach the last person
        head.next.next = head; // turn around and grab the hand of the person behind you"
        head.next = null; // let go of the hand of the person in front of you
        return newHead;
    }
}

