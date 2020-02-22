package joker.ds.queue;

public class Solution1 {

    static int downToZero(int n) {
        int moves = 0;
        if(n == 0) return 0;
        while(n > 0) {
            int max = maxTill(n);
            if(max != -1){
                n = max;
            } else {
                --n;
            }
            ++moves;
        }

        return moves;
    }

    private static int maxTill(int n){
        int maxtill = -1;
        int min = -1;
        int h = n/2;
        for(int i=2;i<=h;i++) {
            for(int j= 2; j<=h ;j++) {
                if(i*j == n) {
                    maxtill = Math.max(i,j);
                    min = min == -1 ? maxtill : Math.min(maxtill, min);
                }
                if(i*j > n) {
                    break;
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(downToZero(812849));
    }
}
