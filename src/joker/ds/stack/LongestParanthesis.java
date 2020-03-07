package joker.ds.stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LongestParanthesis {
    public static int longestValidParentheses(String s) {
        if (s.length() <= 1) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.print(longestValidParentheses("))))))("));
    }
}
