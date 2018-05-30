package leetcode;

import java.util.HashMap;

public class No_0001_TowSum {
    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        int length = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>(length);

        for (int i = 0; i < length; i++) {
            int val = nums[i];
            Integer diff = Integer.valueOf(target - val);
            Integer existIdx = map.get(Integer.valueOf(val));
            if (null == existIdx) {
                map.put(diff, Integer.valueOf(i));
            } else {
                ret[0] = existIdx.intValue();
                ret[1] = i;
                return ret;
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 7, 11, 15};
        int target = 22;
        int[] ret = new No_0001_TowSum().twoSum(nums, target);
        System.out.println(ret[0]);
        System.out.println(ret[1]);
    }

}
