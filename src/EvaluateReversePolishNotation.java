import java.util.Stack;

public class EvaluateReversePolishNotation {

    private static int evalRPN(String[] tokens) {
        // everytime encounter an operator, pop 2 off of stack and evaluate
        Stack<String> stack = new Stack<>();
        for(String s : tokens){
            if(isOperator(s)){
                String num2 = stack.pop();
                String num1 = stack.pop();
                stack.push(evalOperation(num1, num2, s));
            }
            else{
                stack.push(s);
            }
        }
        // should only have a single string left on stack
        return Integer.parseInt(stack.pop());
    }

    // determine if s is a valid math operator: +, -, *, /
    private static boolean isOperator(String s){
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    private static String evalOperation(String num1, String num2, String operator){
        int x = Integer.parseInt(num1);
        int y = Integer.parseInt(num2);

        if(operator.equals("+"))
            return Integer.toString(x + y);
        if(operator.equals("-"))
            return Integer.toString(x - y);
        if(operator.equals("*"))
            return Integer.toString(x * y);
        if(operator.equals("/"))
            return Integer.toString(x / y);

        // should not get here
        return "";
    }

    public static void main(String[] args) {
        String[] exp1 = new String[]{"2", "1", "+", "3", "*"};
        // expected 9
        System.out.println(evalRPN(exp1));

        String[] exp2 = new String[]{"4", "13", "5", "/", "+"};
        // expected 6
        System.out.println(evalRPN(exp2));

        String[] exp3 = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        // expected 22
        System.out.println(evalRPN(exp3));
    }
}
