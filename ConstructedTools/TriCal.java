package ConstructedTools;
/**
 * 含有三个数字的算式类，方便构建题目
 */
public class TriCal {
    public int a, b, c;
    public String ope1, ope2;

    public TriCal() {
        this.a = GetRandom.getRandomNum();
        this.b = GetRandom.getRandomNum();
        this.c = GetRandom.getRandomNum();
        this.ope1 = GetRandom.getRandomOpe();
        this.ope2 = GetRandom.getRandomOpe();
    }

    @Override
    public String toString() {
        return "(" + this.a + this.ope1 + this.b + this.ope2 + this.c + ")";
    }
}
