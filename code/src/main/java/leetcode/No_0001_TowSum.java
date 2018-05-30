package leetcode;

public class No_0001_TowSum {
    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        int length = nums.length;

        OUTER:
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    ret[0] = i;
                    ret[1] = j;
                    break OUTER;
                }
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
