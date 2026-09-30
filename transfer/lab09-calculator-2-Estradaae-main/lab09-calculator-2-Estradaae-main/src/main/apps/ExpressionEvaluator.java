package apps;
import java.util.regex.Pattern;
import java.util.Stack;
import java.util.Scanner;


public class ExpressionEvaluator
{
    private static final Pattern UNSIGNED_DOUBLE = Pattern.compile("((\\d+\\.?\\d*)|(\\.\\d+))([Ee][-+]?\\d+)?.*?");
    private static final Pattern CHARACTER = Pattern.compile("\\S.*?");
    public static String toPostfix(String expression) 
    {
        Stack<Character> st = new Stack<>();
        String postfix = "";
        char ch[] = expression.toCharArray();
        boolean isFirstOperand = true;
        String currentOperand = "";
        for (char c : ch) 
        {
            if (c == ' ') 
            {
                continue; 
            }
            if (Character.isDigit(c)) 
            {
                currentOperand += c; 
            } 
            else 
            {
                if (!currentOperand.isEmpty()) 
                {
                    if (!isFirstOperand) 
                    {
                        postfix += ' '; 
                    }
                    postfix += currentOperand; 
                    currentOperand = ""; 
                    isFirstOperand = false; 
                }
                if (c != '+' && c != '-' && c != '*' && c != '/' && c != '(' && c != ')') 
                {
                    if (!isFirstOperand) 
                    {
                        postfix += ' '; 
                    }
                    postfix += c; 
                    isFirstOperand = false; 
                } 
                else if (c == '(') 
                {
                    st.push(c); 
                } 
                else if (c == ')') 
                {
                    while (!st.isEmpty()) 
                    {
                        char t = st.pop();
                        if (t != '(') {
                            if (!isFirstOperand) 
                            {
                                postfix += ' '; 
                            }
                            postfix += t; 
                            isFirstOperand = false; 
                        } 
                        else 
                        {
                            break;
                        }
                    }
                } 
                else if (isOperator(c)) 
                {
                    if (st.isEmpty()) {
                        st.push(c); 
                    } 
                    else 
                    {
                        while (!st.isEmpty()) 
                        {
                            char t = st.pop();
                            if (t == '(') {
                                st.push(t);
                                break;
                            }
                            else if (isOperator(c)) 
                            {
                                if (higherPrecedence(t, c)) 
                                {
                                    st.push(t); 
                                    break;
                                } else 
                                {
                                    if (!isFirstOperand) 
                                    {
                                        postfix += ' '; 
                                    }
                                    postfix += t; 
                                    isFirstOperand = false; 
                                }
                            }
                        }
                        st.push(c); 
                    }
                }
            }
        }
        if (!currentOperand.isEmpty()) 
        {
            if (!isFirstOperand) 
            {
                postfix += ' '; 
            }
            postfix += currentOperand;
        }
        while (!st.isEmpty()) 
        {
            postfix += ' ';
            postfix += st.pop(); 
        }
        return postfix;
    }

    public static double evaluate(String postfixExpression) 
    {
        Stack<Double> stack = new Stack<>();
        Scanner input = new Scanner(postfixExpression);
        while (input.hasNext()) 
        {
            if (input.hasNext(UNSIGNED_DOUBLE)) 
            {
                String operand = input.findInLine(UNSIGNED_DOUBLE);
                double value = Double.parseDouble(operand);
                stack.push(value);
            } 
            else 
            {
                String operator = input.findInLine(Pattern.compile("[+\\-*/]"));
                if (operator != null && operator.length() == 1) 
                {
                    if (stack.size() < 2) 
                    {
                        return Double.NaN; 
                    }
                    double operand2 = stack.pop();
                    double operand1 = stack.pop();
                    double result = performOperation(operand1, operand2, operator.charAt(0));
                    stack.push(result);
                } 
                else 
                {
                    return Double.NaN; 
                }
            }
        }
        if (stack.size() == 1) 
        {
            return stack.pop(); 
        } 
        else 
        {
            return Double.NaN;
        }
    }
    private static double performOperation(double operand1, double operand2, char operator) 
    {
        switch (operator) 
        {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 == 0) 
                {
                    return Double.NaN; 
                }
                return operand1 / operand2;
            default:
                return Double.NaN; 
        }
    }
    private static boolean higherPrecedence(char current, char top)
    {
        return (current == '*' || current == '/') && (top == '+' || top == '-');
    }
    public static boolean isOperator(char c)
    {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
    public static void main(String[] args)
    {
        String expression1 = "(1)";
        String expression2 = "(1 + 2)";
        System.out.print(toPostfix(expression2));
    }
}


