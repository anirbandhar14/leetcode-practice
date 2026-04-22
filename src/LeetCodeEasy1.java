import java.util.Arrays;
import java.util.HashMap;

public class LeetCodeEasy1 {
    public static void main(String[] args) {
        System.out.println(numberPalindrome(54345));
    }

/**
 *         int[] nums = {-5,3,2,4,5};
 *         int target = 0;
 *         System.out.println(Arrays.toString(twoSum(nums, target)));
 */
public static int[] twoSum(int[] nums, int target) {
        if (nums.length < 2 || nums.length > Math.pow(10, 4) ||
        target < Math.pow(-10, 9) || target > Math.pow(10, 9)) {
            throw new RuntimeException("Invalid input");
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        throw new RuntimeException("Invalid input");
    }

    public static Boolean numberPalindrome(int x) {
        if (x < 0 ) return false;
        int org = x;
        int rev = 0;
        int rem;
        while (x != 0) {
            rem = x % 10;
            x /= 10;
            rev = rev * 10 + rem;
        }
        return rev == org;
    }
}
