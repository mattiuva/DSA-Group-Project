public class PostfixEvaluator {
 
    // ---------- Custom array-based Stack ----------
    static class Stack {
        private double[] data;
        private int top;
 
        Stack(int capacity) {
            data = new double[capacity];
            top = -1;
        }
 
        void push(double value) {
            if (top == data.length - 1) {
                throw new RuntimeException("Stack overflow");
            }
            data[++top] = value;
        }
 
        double pop() {
            if (isEmpty()) {
                throw new RuntimeException("Stack underflow - cannot pop an empty stack");
            }
            return data[top--];
        }
 
        double peek() {
            if (isEmpty()) {
                throw new RuntimeException("Stack is empty - nothing to peek");
            }
            return data[top];
        }
 
        boolean isEmpty() {
            return top == -1;
        }
 
        // Readable snapshot of the stack, bottom -> top
        String display() {
            if (isEmpty()) return "[ empty ]";
            StringBuilder sb = new StringBuilder("[ ");
            for (int i = 0; i <= top; i++) {
                sb.append(formatNumber(data[i]));
                if (i < top) sb.append(", ");
            }
            sb.append(" ]  (rightmost = top)");
            return sb.toString();
        }
    }
 
    // ---------- Postfix evaluation ----------
    public static double evaluatePostfix(String expression) {
        Stack stack = new Stack(100);
        String[] tokens = expression.trim().split("\\s+");
 
        System.out.println("Expression: " + expression);
        System.out.println("Initial stack: " + stack.display());
 
        for (String token : tokens) {
            if (isOperator(token)) {
                double rightOperand = stack.pop();
                double leftOperand = stack.pop();
                double result = applyOperator(leftOperand, rightOperand, token);
                stack.push(result);
                System.out.printf("Popped %s and %s, applied '%s' -> pushed %s%n",
                        formatNumber(leftOperand), formatNumber(rightOperand),
                        token, formatNumber(result));
            } else {
                double value = Double.parseDouble(token);
                stack.push(value);
                System.out.println("Read operand " + formatNumber(value) + " -> pushed");
            }
            System.out.println("Stack: " + stack.display());
        }
 
        double finalResult = stack.pop();
        System.out.println("Final result = " + formatNumber(finalResult));
        return finalResult;
    }
 
    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*")
                || token.equals("/") || token.equals("x") || token.equals("\u00d7") || token.equals("\u00f7");
    }
 
    private static double applyOperator(double a, double b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
            case "x":
            case "\u00d7":
                return a * b;
            case "/":
            case "\u00f7":
                if (b == 0) throw new ArithmeticException("Division by zero");
                return a / b;
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }
 
    private static String formatNumber(double d) {
        if (d == (long) d) return String.valueOf((long) d);
        return String.valueOf(d);
    }
 
    // ---------- Demo / main ----------
    public static void main(String[] args) {
        System.out.println("=== Task A3: Postfix Expression Evaluation (Stack) ===\n");
        evaluatePostfix("5 3 + 2 *");
 
        System.out.println("\n--- Second example ---");
        evaluatePostfix("17 5 - 8 4 / *");
    }
}
