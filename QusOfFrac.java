import ConstructedTools.CalStr;
import ConstructedTools.GetRandom;

public class QusOfFrac extends Question{
    /**
     * @param n 含有运算符的个数，1或2，以免超时与题目单一
     * @throws Exception 除数为零异常
     */
    public QusOfFrac(int n) throws Exception {
        if(n > 2 || n < 1){
            throw new RuntimeException("Illegal parameter");
        }


        do{
            this.qus = GetRandom.getRandomFrac().toString();
            for(int i = 0;i<n;i++){
                qus = qus + GetRandom.getRandomOpe() + GetRandom.getRandomFrac();
            }
        }while (!(CalStr.cal(CalStr.parseToSuffixExpression(CalStr.expressionToList(qus))).isLegal()));
    }
}
