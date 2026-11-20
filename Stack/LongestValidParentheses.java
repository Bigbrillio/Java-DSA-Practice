import java.util.Stack;

public class LongestValidParentheses {

    public static int longestValidParentheses(String s) {

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);

        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();

                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    int currentLength = i - stack.peek();

                    if (currentLength > maxLength) {
                        maxLength = currentLength;
                    }
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {

        String s1 = "(()";
        String s2 = ")()())";
        String s3 = "";

        System.out.println(longestValidParentheses(s1));
        System.out.println(longestValidParentheses(s2));
        System.out.println(longestValidParentheses(s3));
    }
}
