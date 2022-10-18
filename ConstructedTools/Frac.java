package ConstructedTools;

import java.util.Objects;

/**
 * 分数类
 */
public class Frac {
    public int denominator;
    public int numerator;

    public Frac(int denominator, int numerator) {
        this.denominator = denominator;
        this.numerator = numerator;
    }

    public Frac(int x) {
        this.denominator = 1;
        this.numerator = x;
    }

    /**
     * @return 分数转为浮点，便于判断范围
     */
    public double getValue() {
        return (double) this.numerator / this.denominator;
    }

    @Override
    public String toString() {
        if (this.denominator == 1) return String.valueOf(this.numerator);
        if (this.numerator == 0) return "0";
        return "(" + this.numerator + "/" + this.denominator + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Frac frac = (Frac) o;
        return denominator == frac.denominator && numerator == frac.numerator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(denominator, numerator);
    }

    /**
     * @return 判定是否合法，其中规则可能存在隐藏的错误
     */
    public boolean isLegal() {
        if (denominator == 1) {
            return (this.numerator <= Settings.maxInt)
                    && (this.numerator > 0);
        }
        return (denominator < Settings.maxDenominator)
                && (this.getValue() <= Settings.maxFrac)
                && (this.getValue() >= 0);
    }

    /**
     * 约分
     */
    public void divide() {
        if (this.numerator == 0) {
            if(this.denominator!=0){
                this.denominator = 1;
            }
            return;
        }
        int gcd = Settings.getGcd(this.denominator, this.numerator);
        this.numerator /= gcd;
        this.denominator /= gcd;
    }

    /**
     * @param frac 加数
     * @return 和
     */
    public Frac fracAdd(Frac frac) {
        return new Frac(this.denominator * frac.denominator,
                this.numerator * frac.denominator + this.denominator * frac.numerator);
    }

    /**
     * @param frac 被减数
     * @return 差
     */
    public Frac fracSub(Frac frac) {
        return new Frac(this.denominator * frac.denominator,
                this.numerator * frac.denominator - this.denominator * frac.numerator);
    }

    /**
     * @param frac 乘数
     * @return 积
     */
    public Frac fracMul(Frac frac) {
        return new Frac(this.denominator * frac.denominator,
                this.numerator * frac.numerator);
    }

    /**
     * @param frac 除数
     * @return 商
     * @throws RuntimeException 除数不可为零
     */
    public Frac fracDiv(Frac frac) throws RuntimeException {
        if (frac.numerator == 0) {
            throw new RuntimeException("Illegal num!");
        }
        return new Frac(this.denominator * frac.numerator,
                this.numerator * frac.denominator);
    }

}
