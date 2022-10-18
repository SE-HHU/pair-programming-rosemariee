package ConstructedTools;

/**
 * 为静态变量赋值以决定设置
 */
public class Settings {
    /**
     * 最大自然数
     */
    public static int maxInt;
    /**
     * 最大分数
     */
    public static double maxFrac;
    /**
     * 最大分母
     */
    public static int maxDenominator;


    /**
     * 设置参数范围
     * @param maxInt 最大自然数
     * @param maxFrac 最大分数，建议设为1
     * @param maxDenominator 最大分母
     */
    public static void setSettings(int maxInt,double maxFrac,int maxDenominator) {
        Settings.maxInt = maxInt;
        Settings.maxFrac = maxFrac;
        Settings.maxDenominator = maxDenominator;
    }

    /**
     * @param x x
     * @param y y
     * @return x, y的最大公约数
     */
    public static int getGcd(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        if (y > x) {
            int temp = y;
            y = x;
            x = temp;
        }
        if(y == 0){
            throw new RuntimeException("0!");
        }
        if (x % y == 0) {
            return y;
        } else
            return getGcd(y, x % y);
    }

}
