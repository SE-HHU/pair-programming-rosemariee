package ConstructedTools;

/**
 * 含有两个数字的算式类，方便构建题目
 */
public class PairCal {
    public int a, b;
    public String ope;

    public PairCal() {
        this.a = GetRandom.getRandomNum();
        this.b = GetRandom.getRandomNum();
        this.ope = GetRandom.getRandomOpe();
    }

    @Override
    public String toString() {
        return "(" + this.a + this.ope + this.b + ")";
    }
}
