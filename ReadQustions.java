import ConstructedTools.CalStr;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class ReadQustions {
    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static String getLegalStr(int n, String str) {
        int res = 0;
        while (n != 0) {
            n /= 10;
            res++;
        }
        return str.substring(3 + res);
    }

    public static void main(String[] args) {
        File qusFile = new File("Exercises.txt");
        File ansFile = new File("Answers.txt");
        try {
            List<String> question = FileOperate.fileReader(qusFile);
            List<String> answers = FileOperate.fileReader(ansFile);
            List<Integer> correct_index = new ArrayList<>();
            List<Integer> wrong_index = new ArrayList<>();
            List<Pair> repeat_index = new ArrayList<>();
            for (int i = 0; i < question.size(); i++) {
                if (CalStr.cal(
                                CalStr.parseToSuffixExpression(
                                        CalStr.expressionToList(getLegalStr(i + 1, question.get(i)))))
                        .toString().equals(
                                getLegalStr(i + 1, answers.get(i)))) {
                    correct_index.add(i);
                } else {
                    wrong_index.add(i);
                }
            }
            for (int i = 0; i < question.size(); i++) {
                for (int j = 0; j < i; j++) {
                    if (getLegalStr(i + 1, question.get(i)).equals(getLegalStr(j + 1, question.get(j)))) {
                        repeat_index.add(new Pair(j + 1, i + 1));
                    }
                }
            }
            BufferedWriter bfw = new BufferedWriter(new FileWriter("Grade.txt"));
            bfw.write("Correct:" + correct_index.size() + "---");
            for (int i : correct_index) {
                bfw.write(i + 1 + ",");
            }
            bfw.flush();
            bfw.newLine();
            bfw.write("Wrong:" + wrong_index.size() + "---");
            for (int i : wrong_index) {
                bfw.write(i + 1 + ",");
            }
            bfw.flush();
            bfw.newLine();

            bfw.write("Repeat:" + repeat_index.size() + "\n" + "RepeatDetail:" + "\n");
            bfw.flush();
            int i = 1;
            for (Pair p : repeat_index) {
                bfw.write("(" + i + ")   " + question.get(p.x - 1));
                bfw.write("    Repeat  " + question.get(p.y - 1));
                i++;
                bfw.flush();
                bfw.newLine();
            }
            bfw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

