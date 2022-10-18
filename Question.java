import ConstructedTools.CalStr;
import ConstructedTools.Frac;

/**
 * 题目类，包含题目内容qus，重写的判重方法与getAns()方法
 */
public class Question {
    String qus;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;

        return qus.equals(question.qus);
    }

    @Override
    public int hashCode() {
        return qus.hashCode();
    }

    /**
     * @return 根据qus得到答案
     * @throws Exception 除数为零的异常
     */
    public Frac getAns() throws Exception {
        return CalStr.cal(CalStr.parseToSuffixExpression(CalStr.expressionToList(qus)));
    }
}