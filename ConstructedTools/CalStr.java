package ConstructedTools;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CalStr {

    /**
     * @param list List<String> list，处理后的后缀表达式
     * @return Frac 计算结果
     * @throws Exception 除数不能为零
     */
    public static Frac cal(List<String> list) throws Exception {
        Stack<Frac> stack = new Stack<>();
        /*
        ***
        * index out of range

         */
        if (list.size()<=0)
        {
            throw new RuntimeException("no input in list");
        }
        for (String item : list) {
            if (item.matches("\\d+")) {
                stack.push(new Frac(Integer.parseInt(item)));
            } else {
                // 是操作符，取出栈顶元素和次顶元素
                Frac num2 = stack.pop();
                Frac num1 = stack.pop();
                Frac result = new Frac(1);
                switch (item) {
                    case "+":
                        result = num1.fracAdd(num2);
                        break;
                    case "-":
                        result = num1.fracSub(num2);
                        break;
                    case "*":
                        result = num1.fracMul(num2);
                        break;
                    case "/":
                        if(num2.numerator==0){
                            return new Frac(0);
                        }//！！！
                        result = num1.fracDiv(num2);
                        break;
                    default: {
                        throw new RuntimeException("disabled char");
                    }
                }
                stack.push(result);
            }
        }
        stack.peek().divide();
        return stack.pop();
    }

    /**
     * @param expression 待处理表达式
     * @return 方便处理的字符串列表
     */
    public static List<String> expressionToList(String expression) {

        List<String> list = new ArrayList<>();
        int index = 0;
        /*
        ***
        **   action use do-while will make index out of range
        */
        if(expression.length()<=0)
        {
            return list;
        }

        do {
            char ch = expression.charAt(index);
            if (ch < 48 || ch > 57) {
                index++;
                list.add(ch + "");
            } else if (ch >= 48 && ch <= 57) {
                String keepNum = "";
                while (index < expression.length()
                        && expression.charAt(index) >= 48
                        && expression.charAt(index) <= 57) {
                    keepNum += expression.charAt(index);
                    index++;
                }
                list.add(keepNum);
            }
        } while (index < expression.length());
        return list;
    }

    /**
     * @param expressionList 字符串列表
     * @return 后缀表达式
     * 中缀表达式转换为后缀表达式
     *      * 转换规则:
     *  1)我们使用一个stack栈结构存储操作符，用一个List结构存储后缀表达式结果
     *  2)首先读取到数字，直接存入list中
     *  3)当读取到左括号"("时，直接压栈，当读取到运算符时，分两种情况讨论
     *     a.当运算符栈为空或者栈顶操作符的优先级小于当前运算符优先级时(如+和-的优先级低于 * 和 /)，直接入栈
     *     b.当运算符不为空时且栈顶操作符的优先级大于或等于当前运算符优先级时，循环执行出栈操作并加入list中，
     * 直到遇到优先级小于当前运算符的元素为止。
     * 循环执行完后再将当前运算符压栈。另外需要注意的是，只有遇到右括号时，左括号才出栈
     *  4) 当遇到右括号")"时，循环执行出栈操作并加入到list中，直到遇到左括号为止。并将左括号弹出，但不加入list中
     *  5) 表达式的值读取完后，将操作符栈中的所有元素弹出并加入到list中
     * 执行完上面步骤后，list中存储的顺序即为我们转换后的后缀表达式的结果
     */
    public static List<String> parseToSuffixExpression(List<String> expressionList) {
        //创建一个栈用于保存操作符
        Stack<String> opStack = new Stack<>();
        //创建一个list用于保存后缀表达式
        List<String> suffixList = new ArrayList<>();
        for (String item : expressionList) {
            //得到数或操作符
            if (isOperator(item)) {
                //是操作符 判断操作符栈是否为空
                if (opStack.isEmpty() || "(".equals(opStack.peek()) || priority(item) > priority(opStack.peek())) {
                    //为空或者栈顶元素为左括号或者当前操作符大于栈顶操作符直接压栈
                    opStack.push(item);
                } else {
                    //否则将栈中元素出栈入队，直到遇到大于当前操作符或者遇到左括号时
                    while (!opStack.isEmpty() && !"(".equals(opStack.peek())) {
                        if (priority(item) <= priority(opStack.peek())) {
                            suffixList.add(opStack.pop());
                        }
                    }
                    //当前操作符压栈
                    opStack.push(item);
                }
            } else if (isNumber(item)) {
                //是数字则直接入队
                suffixList.add(item);
            } else if ("(".equals(item)) {
                //是左括号，压栈
                opStack.push(item);
            } else if (")".equals(item)) {
                //是右括号 ，将栈中元素弹出入队，直到遇到左括号，左括号出栈，但不入队
                while (!opStack.isEmpty()) {
                    if ("(".equals(opStack.peek())) {
                        opStack.pop();
                        break;
                    } else {
                        suffixList.add(opStack.pop());
                    }
                }
            } else {
                throw new RuntimeException("有非法字符！");
            }
        }
        //循环完毕，如果操作符栈中元素不为空，将栈中元素出栈入队
        while (!opStack.isEmpty()) {
            suffixList.add(opStack.pop());
        }
        return suffixList;
    }

    /**
     * 判断字符串是否为操作符
     */
    public static boolean isOperator(String op) {
        return op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/");
    }

    /**
     * 判断是否为数字
     */
    public static boolean isNumber(String num) {
        return num.matches("\\d+");
    }

    /**
     * 获取操作符的优先级
     */
    public static int priority(String op) {
        if (op.equals("*") || op.equals("/")) {
            return 1;
        } else if (op.equals("+") || op.equals("-")) {
            return 0;
        }
        return -1;
    }

}