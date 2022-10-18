import ConstructedTools.CalStr;
import ConstructedTools.GetRandom;
import ConstructedTools.PairCal;
import ConstructedTools.TriCal;

public class QusOfInt extends Question {
    /**
     * @param x 题目包含运算符个数，containBr为false时只可为1或2，为true时可取1，2，3
     * @param containBr 是否包含括号
     * @throws Exception 除数为零异常
     */
    public QusOfInt(int x, boolean containBr) throws Exception {
        if (!containBr) {
            if(x > 2 || x < 1){
                throw new RuntimeException("Illegal parameter");
            }
            do {
                this.qus = String.valueOf((GetRandom.getRandomNum()));
                for (int i = 1; i <= x; i++) {
                    qus = qus + GetRandom.getRandomOpe() + GetRandom.getRandomNum();
                }
            } while (!(CalStr.cal(CalStr.parseToSuffixExpression(CalStr.expressionToList(qus))).isLegal()));
            return;
        }
        switch (x) {
            case 2: {
                do {
                    PairCal pairCal = new PairCal();
                    this.qus = Math.random() > 0.5 ? (pairCal + GetRandom.getRandomOpe() + GetRandom.getRandomNum())
                            : (GetRandom.getRandomNum() + GetRandom.getRandomOpe() + pairCal);
                } while (!(CalStr.cal(CalStr.parseToSuffixExpression(CalStr.expressionToList(qus))).isLegal()));
                return;
            }
            case 3: {
                do {
                    PairCal pairCal1 = new PairCal();
                    PairCal pairCal2 = new PairCal();
                    double d = Math.random();
                    if (d > 0.8) {
                        this.qus = pairCal1 + GetRandom.getRandomOpe() + pairCal2;
                    } else if (d > 0.6) {
                        this.qus = GetRandom.getRandomNum()
                                + GetRandom.getRandomOpe()
                                + pairCal1
                                + GetRandom.getRandomOpe()
                                + GetRandom.getRandomNum();
                    } else if (d > 0.4) {
                        this.qus = pairCal2
                                + GetRandom.getRandomOpe()
                                + GetRandom.getRandomNum()
                                + GetRandom.getRandomOpe()
                                + GetRandom.getRandomNum();
                    } else if (d > 0.2) {
                        TriCal t = new TriCal();
                        this.qus = GetRandom.getRandomNum() + GetRandom.getRandomOpe() + t;
                    } else {
                        TriCal t = new TriCal();
                        this.qus = t + GetRandom.getRandomOpe() + GetRandom.getRandomNum();
                    }
                } while (!(CalStr.cal(CalStr.parseToSuffixExpression(CalStr.expressionToList(qus))).isLegal()));
                return;
            }
            default:
                throw new RuntimeException("Nums of opes < 4");
        }
    }
}
