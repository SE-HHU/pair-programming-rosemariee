import ConstructedTools.Frac;
import ConstructedTools.Settings;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MakeQuestions {


    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int maxint = -1;
        while (maxint < 0 || maxint > 1000) {
            try {
                System.out.println("请输入传入最大自然数：(应在 0-1000之内)");
                maxint = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("输入格式有误，请重新输入：");
            }
        }
        double maxfrac = 0.0;
        while (maxfrac < 1 || maxfrac > 10) {
            try {
                System.out.println("请输入最大真分数：（如输入 “1” 则所有结果均为真分数）\n (应在 1-10之内)");
                maxfrac = sc.nextDouble();
            } catch (Exception e) {
                System.out.println("输入格式有误，请重新输入：");
            }
        }
        int maxDenominator = 0;
        while (maxDenominator < 1 || maxDenominator > 300) {

            try {
                System.out.println("请输入分母：(应在1-300)");
                maxDenominator = sc.nextInt();
            } catch (Exception e) {
                System.out.println("输入格式有误，请重新输入：");
            }
        }
        int n = 0;
        while (n <= 0) {
            try {
                System.out.println("生成题目的数量：");
                n = sc.nextInt();
            } catch (Exception e) {
                System.out.println("输入格式有误，请重新输入：");
            }
        }
        Settings.setSettings(maxint, maxfrac, maxDenominator);
        List<String> questions = new ArrayList<>();
        List<Frac> answers = new ArrayList<>();
        int x = 3;
        try {
            System.out.println("输入生成的题目类型：1.整数；2.分数；3.随机生成");
            x = sc.nextInt();
        } catch (Exception ignored) {
        }
        switch (x) {
            case 1 -> {
                Random intrand = new Random();
                for (int i = 0; i < n; i++) {
                    String question;
                    Frac answer;

                    int f = intrand.nextInt(2, 4);
                    Question qi = new QusOfInt(f, true);
                    question = qi.qus;
                    answer = qi.getAns();

                    questions.add(question);
                    answers.add(answer);

                }
            }
            case 2 -> {
                Random frcrand = new Random();

                for (int i = 0; i < n; i++) {
                    String question;
                    Frac answer;

                    int f = frcrand.nextInt(1, 3);
                    QusOfFrac qf = new QusOfFrac(f);
                    question = qf.qus;
                    answer = qf.getAns();

                    questions.add(question);
                    answers.add(answer);
                }
            }
            default -> {
                System.out.println("已随机生成!");
                Random int_frc = new Random();
                Random frcrand = new Random();
                Random intrand = new Random();
                for (int i = 0; i < n; i++) {
                    String question;
                    Frac answer;
                    if (int_frc.nextInt() == 0) {
                        int f = frcrand.nextInt(1, 3);
                        QusOfFrac qf = new QusOfFrac(f);
                        question = qf.qus;
                        answer = qf.getAns();
                    } else {
                        int f = intrand.nextInt(2, 4);
                        Question qi = new QusOfInt(f, true);
                        question = qi.qus;
                        answer = qi.getAns();
                    }
                    questions.add(question);
                    answers.add(answer);

                }
            }

        }
        FileOperate.fileWriter(questions, "Exercises");
        FileOperate.fileWriterFrac(answers, "Answers");
    }
}






