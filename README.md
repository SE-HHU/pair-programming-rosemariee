# Pair Programming
---
## Team:
Rosemariee<br/>
## Member:
+ 2106050218_徐诚鸿(Euphocc)
+ 2106050219_李想(MrlixiangWE)
---

## 前言
    一次难忘的Pair Programming经历，
    前期编码花费约5小时；
    软件测试花费约6小时；
    经历无数问题的修改，得到了比较令人满意的成果
    受限于算法与数据结构基础，程序并不能做到十全十美地完成全部任务
    但开发流程十分规范，按照敏捷开发的规范流程进行操作，带有极限编程色彩
    形成系列文档（见Documents）
    是一次精彩的尝试与配合~！

## 闪光点
+ 流程规范，需求分析-模块设计-编码-测试-维护-发布
+ 测试完善，除不用测试的基类外，类与方法测试覆盖率均达到100%，行覆盖率达到85%
+ “领航员”与“驾驶员”轮流转换，配合高效
+ ...

## 不足之处
+ 合作经历不足，部分时候未能清楚表达自身想法
+ 代码编写水平不够，对数据结构掌握生疏，不够熟悉常用API
+ 设计存在部分问题，如题目规定的判重部分，没有用很好的算法完成，导致判重过于严格
+ 部分代码存在冗长情况
+ ...

## 功能模块
|||
|:--|:--|
|设置模块|设定题目中的数字范围|
|随机模块|根据设置模块内容得到随机数字、运算符|
|操作数统一化模块|将所有数字统一化为分数，便于计算|
|字符串处理模块|将给定字符串转为便于处理的数据类型|
|表达式计算模块|针对指定数据类型的表达式进行计算|
|生成模块|根据设置模块，使用随机模块生成合法表达式|
|IO模块|对生成的表达式与本地文件进行交互|
|测试模块|基于常用测试方法对软件进行测试|

## 具体代码实现
+ 题目参数设置类Settings，包含
```java
    // 三个主要参数
    public static int maxInt;
    public static double maxFrac;
    public static int maxDenominator;

    // 设置参数的方法
    public static void setSettings(int maxInt,double maxFrac,int maxDenominator)

    // 获得最大公约数
    public static int getGcd(int x,int y)
```

+ 随机数获取类GetRandom,包含
```java
    // 所有方法的数据范围取决于Settings
    // 获取随机整数
    public static int getRandomNum()
    // 获取随机运算符
    public static String getRandomOpe()
    // 获取随机分数
    public static Frac getRandomFrac()
```

+ 分数类Frac,包含
```java
    // 分母
    public int denominator;
    // 分子
    public int numerator;
    //构造方法
    public Frac(int denominator, int numerator)
    //将整数x转为分数类的构造方法
    public Frac(int x)

    // 得到分数的浮点值,便于判断合法性
    public double getValue()
    // 重写toString(),输出格式符合分数格式约定
    public String toString()
    
    // 根据Settings判断是否合法
    public boolean isLegal()

    //约分
    public void divide()

    // 四则运算
    public Frac fracAdd(Frac frac)
    public Frac fracSub(Frac frac)
    public Frac fracMul(Frac frac)
    //除法对除数为0抛出RuntimeException
    public Frac fracDiv(Frac frac)
```

+ 核心工具类CalStr,包含
```java
    // 将字符串形式的表达式转化为便于处理的List类型
    public static List<String> expressionToList(String expression)
    //将List转化为后缀表达式形式
    public static List<String> parseToSuffixExpression(List<String> expressionList)
    // 计算后缀表达式,返回分数形式结果
    public static Frac cal(List<String> list) throws Exception

    // 字符串处理用到的方法
    public static boolean isOperator(String op)
    public static boolean isNumber(String num)
    public static int priority(String op)
```

+ 生成模块Question,包含
```java
    // 父类Question
    // 字符串形式的题目内容
    String qus
    // 依据字符串重写判重方法
    public boolean equals(Object o)
    public int hashCode()
    // 获得本题答案
    public Frac getAns() throws Exception

    // 子类1:QusOfFrac生成带分数的题目
    // 使用带参数的构造方法进行构造
    /**
     * @param n 含有运算符的个数，1或2，以免超时与题目单一
     * @throws Exception 除数为零异常
     */
    public QusOfFrac(int n) throws Exception

    // 子类2:QusOfInt生成一般题目
    // 使用带参数的构造方法进行构造
    /**
     * @param x 题目包含运算符个数，containBr为false时只可为1或2，为true时可取1，2，3
     * @param containBr 是否包含括号
     * @throws Exception 除数为零异常
     */
    public QusOfInt(int x, boolean containBr) throws Exception

    // 随机构建过程中应用到的过渡类PairCal和TriCal
    // 仅需要测试,除构造Question外无应用意义
    public class PairCal
    public class TriCal
```

+ IO文件读写模块FileOperate,包含
```java
    
    /**
     * @param list 题目或答案列表
     * @param name 生成.txt文件的名字
     * @throws Exception
     * 
     * 将题目或答案写入文件
     */
    public static void fileWriter(List<String> list, String name) throws Exception

    /**
     * @param list  题目或答案列表
     * @param name  生成.txt文件的名字
     * @throws Exception
     * 将题目或答案写入文件
     */
    public static void fileWriterFrac(List<Frac> list, String name) throws Exception

     /**
     * @param fe 传入File类型文件地址
     * @return 返回去重后的文件
     * @throws Exception
     * 
     * 读入文件并分析重复，控制台输出重复的题目
     */
    public static Set<String> fileReader(File fe) throws Exception

```

+ 测试模块包test,包含
```java
    // 对构建工具包ConstructedTools中所有工具类进行测试
    // 对文件读写操作类FileOperate与题目生成类Question进行测试
    // 测试结果见测试报告
```

+ 顶层类MakeQuestions和ReadQustions,包含
```java
    // 客户执行方法,生成算式或批改题目
    // Answers.txt
    // Exercises.txt
    // Grade.txt
    public static void main(String args[])
```
