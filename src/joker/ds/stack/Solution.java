package joker.ds.stack;


import java.util.Scanner;
import java.util.Stack;

public class Solution {
    final static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder("12345");
        s.delete(s.length()-2, s.length());
        System.out.println(s);
        /*String s = "";
        Stack<String> stack = new Stack<String>();
        int op = scanner.nextInt();
        for(int i =0;i<op;i++) {
            String cmd = scanner.nextLine();

            String[] arr = cmd.split(" ");

            switch (Integer.parseInt(arr[0])) {
                case 1:
                    s += arr[1];
                    stack.push(s);
                case 2:
                    s = s.substring(0, s.length() - Integer.parseInt(arr[1]));
                    stack.push(s);
                case 3:
                    System.out.println(s.charAt(Integer.parseInt(arr[1]) - 1));
                case 4:
                    s = stack.pop();
                default:
                    System.out.println("wrong input" + arr[0]);
            }
        }*/
    }
}
