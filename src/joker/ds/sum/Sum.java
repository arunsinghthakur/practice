package joker.ds.sum;

import java.util.*;

public class Sum {
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 3) {
            if (nums[0] + nums[1] + nums[2] == 0) {
                List<Integer> fl = new ArrayList<>();
                fl.add(nums[0]);
                fl.add(nums[1]);
                fl.add(nums[2]);
                res.add(fl);
                return res;
            } else {
                return new ArrayList<>();
            }
        }

        Map<Integer, List<List<Integer>>> m = new HashMap<>();

        List<List<Integer>> flist = new ArrayList<>();
        List<Integer> fl = new ArrayList<>();
        fl.add(nums[0]);
        fl.add(nums[1]);
        flist.add(fl);
        m.put(nums[0] + nums[1], flist);

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 2; j < nums.length; j++) {
                int key = nums[i] + nums[j];
                if (m.containsKey(-key) || m.containsKey(0)) {
                    List<List<Integer>> list = m.get(-key);
                    for (List<Integer> lst : list) {
                        if (lst.size() < 3) {
                            lst.add(key);
                            Collections.sort(lst);
                            if (!res.contains(lst)) {
                                res.add(lst);
                            }
                        }
                    }
                } else {
                    List<List<Integer>> list = new ArrayList<>();
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[j]);
                    list.add(l);
                    m.put(key, list);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 0, 0};
        System.out.print(threeSum(arr));
    }
}
