package joker.ds.heap;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int q = s.nextInt();
        PriorityQueue<Integer> p = new PriorityQueue<>();
        for(int i = 0; i < q; i++) {
            String[] ops = s.nextLine().split(" ");

            switch (ops[0]){
                case "1":
                    p.add(Integer.parseInt(ops[1]));
                    break;
                case "2":
                    p.remove(Integer.parseInt(ops[1]));
                    break;
                case "3":
                    System.out.print(p.peek());
                    break;
            }
        }
    }
}
