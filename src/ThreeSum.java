import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (!(i != 0 && nums[i - 1] == nums[i])) {
                int j = i + 1, k = nums.length - 1;
                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == 0) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        do {
                            j++;
                        }
                        while (j <= k && nums[j - 1] == nums[j]);
                        do {
                            k--;
                        }
                        while(k >= j && nums[k+1]==nums[k]);
                    } else if (sum < 0) {
                        do {
                            j++;
                        }
                        while (j <= k && nums[j - 1] == nums[j]);
                    }else {
                        do {
                            k--;
                        }
                        while(k >= j && nums[k+1]==nums[k]);
                    }
                }
            }
        }
        return result;
    }

}
