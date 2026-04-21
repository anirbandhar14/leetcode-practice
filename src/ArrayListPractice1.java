import java.util.*;

public class ArrayListPractice1 {
    public static void main(String[] args) {
//        ArrayList<Integer> list = new ArrayList<>(List.of(13, 11, 15, 14, 12, 16, 10));
//        System.out.println(sorting(list));
        System.out.println(isValidBrackets("[{}(){()}]"));
    }

    //1,2,3,3,4,4,5
    private static ArrayList<Integer> removeSortedDuplicates(ArrayList<Integer> arr) {
        if (arr.size() <= 1) return arr;
        int i = 0;
        for (int j = 1; j < arr.size(); j++) {
            if (!Objects.equals(arr.get(i), arr.get(j))) {
                i++;
                arr.set(i, arr.get(j));
            }
        }
        while (i + 1 < arr.size()) {
            arr.removeLast();
        }
        return arr;
    }
    //2, 3, 2, 4, 5, 3, 3, 5, 4, 1
    private static ArrayList<Integer> unsortedOrderedRemoveDup(ArrayList<Integer> arr) {
        if (arr.size() <= 1) return arr;

        HashSet<Integer> seen = new HashSet<>();
        int write = 0;
        for (int read = 0; read < arr.size(); read++) {
            int cur = arr.get(read);
            if (seen.add(cur)) {
                arr.set(write, cur);
                write++;
            }
        }
        while (write < arr.size()) {
            arr.removeLast();
        }
        return arr;
    }
    //0,1,0,0, 5, 5, 3, 12, 0
    private static ArrayList<Integer> moveZerosToEnd(ArrayList<Integer> arr) {
        if (arr.size() <= 1) return arr;
        //[0,1,0,3,12] → [1,3,12,0,0]
        int write = 0;
        for (int read = 0; read < arr.size(); read++) {
            if (arr.get(read) != 0) {
                arr.set(write, arr.get(read));
                write++;
            }
        }
        for (int last = arr.size() - 1; last > write - 1; last--) {
            arr.set(last, 0);
        }
        return arr;
    }
    //Move all elements < 5 to the front: [7,2,4,9,1] → [2,4,1,7,9]
    private static ArrayList<Integer> moveElementsToStart(ArrayList<Integer> arr) {
        if (arr.size() <= 1) return arr;
        int write = 0;
        for (int read = 0; read < arr.size(); read++) {
            if (arr.get(read) < 5) {
                int temp = arr.get(write);
                arr.set(write, arr.get(read));
                arr.set(read, temp);
                write++;
            }
        }
        return arr;
    }
    //Sort: [13, 11, 15, 14, 12, 16, 10]
    private static ArrayList<Integer> sorting(ArrayList<Integer> arr) {
        if (arr.size() <= 1) return arr;
        ArrayList<Integer> tempArr = new ArrayList<>();
        tempArr.add(arr.getFirst());
        int write = 0;
        for (Integer integer : arr) {
            if (integer < tempArr.get(write)) {
                int temp = tempArr.get(write);
                tempArr.set(write, integer);
                write++;
                tempArr.add(temp);
            }
        }
        return tempArr;
    }
    //Maximum sum of subarray of size k
    public static int maxSumSubarray(int[] arr, int k) {
        int maxSum = 0;
        int windowSum = 0;
        for (int i = 0; i < k; i++) { //first window
            windowSum += arr[i];
        }
        maxSum = Math.max(maxSum, windowSum);
        for (int i = k; i < arr.length; i++) {
            windowSum += (arr[i] - arr[i - k]); //shift window by 1 digit to right and removing 1 from left
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }
    //Longest substring without repeating characters
    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0, left = 0;
        HashMap<Character, Integer> charMap = new HashMap<>(); //to hold char and position
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (charMap.containsKey(ch)) {
                left = Math.max(left, charMap.get(ch) + 1); //shift left when found
            }
            charMap.put(ch, right); //keep shifting right
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static boolean isValidBrackets(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            // If opening bracket, push to stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            // If closing bracket
            else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        // If stack is empty, all brackets matched
        return stack.isEmpty();
    }
}