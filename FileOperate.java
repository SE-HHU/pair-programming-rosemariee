
/*
 * 传入List实现对文件的输入
 * */

import ConstructedTools.Frac;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class FileOperate {
    /**
     * @param list 题目或答案列表
     * @param name 生成.txt文件的名字
     * @throws Exception 将题目或答案写入文件
     */
    public static void fileWriter(List<String> list, String name) throws Exception {

        BufferedWriter bw;
        bw = new BufferedWriter(new FileWriter(new String(name + ".txt")));
        int j = 1;

        for (String i : list) {
            try {
                bw.write(String.valueOf(j) + ".  " + i);
                bw.flush();
                bw.newLine();
                j++;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * @param list 题目或答案列表
     * @param name 生成.txt文件的名字
     * @throws Exception *
     *                   * 将题目或答案写入文件
     */
    public static void fileWriterFrac(List<Frac> list, String name) throws Exception {

        BufferedWriter bw;
        bw = new BufferedWriter(new FileWriter(new String(name + ".txt")));
        int j = 1;

        for (Frac i : list) {
            try {
                bw.write(String.valueOf(j) + ".  " + i);
                bw.flush();
                bw.newLine();
                j++;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }


    /**
     * @param fe 传入File类型文件地址
     * @return 返回去重后的文件
     * @throws Exception 读入文件并分析重复，控制台输出重复的题目
     */
    public static List<String> fileReader(File fe) throws Exception {
        BufferedReader bfr = new BufferedReader(new FileReader(fe));
        List<String> questions = new ArrayList<>();
        String s;
        while ((s = bfr.readLine()) != null) {
            questions.add(s);
        }
        return questions;
    }
}

