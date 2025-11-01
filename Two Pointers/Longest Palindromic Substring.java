class Longest_Palindromic_Substring {
    public static void main(String[] args) {
        String s = "abcbadsaasscdcdddssssssfsssssssff";
        Longest_Palindromic_Substring obj = new Longest_Palindromic_Substring();
        System.out.println("Normal : " + obj.longestPalindrome(s));
        System.out.println("Optimized : " + obj.longestPalindromeOptimized(s));
    }

    public String longestPalindrome(String s) {

        int left;
        int right;
        String longestS = String.valueOf(s.charAt(0));

        String temp;
        for (int i = 0; i < s.length(); i++) {
            temp = "";
            left = i;
            right = i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                temp = s.substring(left, right + 1);
                left--;
                right++;
                System.out.println("Odd = " + temp);
            }
            if (!temp.isBlank() && temp.length() > longestS.length()) longestS = temp;

            temp = "";
            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                temp = s.substring(left, right + 1);
                left--;
                right++;
                System.out.println("Even = " + temp);
            }
            if (!temp.isBlank() && temp.length() > longestS.length()) longestS = temp;

        }
        return longestS;
    }

    public String longestPalindromeOptimized(String s) {

        int length1, length2, maxLen, start = 0, end = 0;
        char[] chars = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            length1 = expandFromCenter(chars, i, i);
            length2 = expandFromCenter(chars, i, i + 1);
            maxLen = Math.max(length1, length2);

            if (maxLen > end - start + 1) {
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandFromCenter(char[] chars, int left, int right) {
        int length = chars.length;
        while (left >= 0 && right < length && chars[left] == chars[right]) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
