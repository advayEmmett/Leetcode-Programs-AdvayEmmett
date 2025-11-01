class Longest_Length_Substring_Without_Repeating_Characters {
    public static void main(String[] args) {
        Longest_Length_Substring_Without_Repeating_Characters obj = new Longest_Length_Substring_Without_Repeating_Characters();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String : ");
        System.out.println(obj.lengthOfLongestSubstring("abcdfraabc"));  // You can use sc.next() here.
    }

    public int lengthOfLongestSubstring(String s) {
//      Using normal appraoch
        /* String current_substring;
        boolean flag;

//        Find first two
        String max_substring = "";

        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                current_substring = s.substring(i, j + 1);
                flag = hasNoDuplicate(current_substring.toCharArray());
                if (flag) {
                    if (current_substring.length() > max_substring.length()) max_substring = current_substring;
                }
            }
        }
        System.out.println("Max = " + max_substring);

        return max_substring.length();

         */

//      Using Sliding Window + Two Pointers
        Set<Character> chars = new HashSet<>();
        int left = 0;
        int max_length = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            while (chars.contains(c)) {
                chars.remove(s.charAt(left));
                left++;
            }
            chars.add(c);
            max_length = Math.max(max_length, i - left + 1);

        }
        return max_length;

    }

    //    Set in java automatically ignores duplicates
    //    If already present, returns false
    //    Already used inline. This method is just for understanding
    private boolean hasNoDuplicate(char[] s) {
        Set<Character> set = new HashSet<>();
        for (char c : s) {
            if (!set.add(c)) return false;
        }
        return true;
    }
}
