import java.util.Stack;

public class ValidParentheses {

    // determine if char is a open or close
    private static boolean isOpen(char c){
        if(c == '(' || c == '[' || c == '{')
            return true;
        return false;
    }

    // convert ( ) [ ] { } into an integer
    private static int convert(char c){
        if(c == '(' || c == ')')
            return 1;
        if(c == '[' || c == ']')
            return 2;
        if(c == '{' || c == '}')
            return 3;
        // should not get here
        return -1;
    }

    private static boolean isValid(String s) {
        // check for empty string
        if(s.length() == 0)
            return true;

        // only hold open parantheses
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            // if is an opening character, push onto stack
            if(isOpen(c))
                stack.push(convert(c));
            // closing character so pop from stack
            else{
                // nothing on stack but have closing character so return false
                if(stack.isEmpty())
                    return false;
                int recent = stack.pop();
                // not matching parantheses so return false
                if(recent != convert(c))
                    return false;
            }
        }

        // should have none left since all should be matched
        if(stack.isEmpty())
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        // expected true
        String s0 = "";
        System.out.println(s0 + " : " + isValid(s0));
        // expected true
        String s1 = "()";
        System.out.println(s1 + " : " + isValid(s1));
        // expected true
        String s2 = "()[]{}";
        System.out.println(s2 + " : " + isValid(s2));
        // expected false
        String s3 = "(]";
        System.out.println(s3 + " : " + isValid(s3));
        // expected false
        String s4 = "([)]";
        System.out.println(s4 + " : " + isValid(s4));
        // expected true
        String s5 = "{[]}";
        System.out.println(s5 + " : " + isValid(s5));
        // expected false
        String s6 = "((((())";
        System.out.println(s6 + " : " + isValid(s6));
    }
}
