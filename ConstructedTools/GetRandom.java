package ConstructedTools;


/**
 * 依据Settings获取随机数
 */
public class GetRandom {
    /**
     * @return 随机整数
     */
    public static int getRandomNum() {
        return (int) (Math.random() * Settings.maxInt);
    }

    /**
     * @return 随机运算符
     */
    public static String getRandomOpe() {
        double d = Math.random();
        if (d > 0.75) {
            return "+";
        }
        if (d > 0.5) {
            return "-";
        }
        if (d > 0.25) {
            return "*";
        }
        return "/";
    }

    /**
     * @return 随机分数
     */
    public static Frac getRandomFrac() {
        Frac frac = new Frac(getRandomNum(), getRandomNum());
        while (frac.isLegal()) {
            frac = new Frac(getRandomNum(), getRandomNum());
        }
        return frac;
    }

}
