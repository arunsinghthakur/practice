package joker.ds.array;

public class HandShake {

    public int minSwapsCouples(int[] row) {
        int count = 0;
        int[] pos = new int[row.length];

        for (int i = 0; i < row.length; i++) {
            pos[row[i]] = i;
        }

        for (int i = 0; i < row.length; i += 2) {
            int val = row[i];
            int couple = val % 2 == 0 ? val + 1 : val - 1;
            int idx = pos[couple];
            if (idx != i + 1) {
                pos[row[i+1]]= idx;
                row[idx]=row[i+1];
                row[i+1]=couple;
                count++;
            }

        }
        return count;
    }

    public static void main(String[] args) {
        HandShake hs = new HandShake();
        int[] row = new int[]{0,2,3,1};
        System.out.println(hs.minSwapsCouples(row));
    }
}
