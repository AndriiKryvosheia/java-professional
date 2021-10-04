package homework3;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        Main main = new Main();
        main.startTask2();
        main.startTask3();
        main.add_Task();
    }

    void startTask2() {
        System.out.println("\n\n/*----------TASK 2---------*/");
        try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/homework3/task2.txt"), "UTF-8"))) {

            bw.write("Hello world");
        } catch (Exception e) {
            System.out.println(e);
        }

        try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/homework3/task2.txt"), "UTF-8"))) {
            String temp;
            while ((temp = br.readLine()) != null) {
                System.out.println(temp);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void startTask3() {
        System.out.println("\n\n/*----------TASK 3---------*/");

        String str = "Java — строго типизированный объектно-ориентированный язык программирования общего назначения, " +
                "разработанный компанией Sun Microsystems. " +
                "Разработка ведётся сообществом, организованным через Java Community Process; " +
                "язык и основные реализующие его технологии распространяются по лицензии GPL.";
        StringBuffer sb = new StringBuffer();
        String[] sentences  = str.split("\\.");
        for (String sentence : sentences) {
            String[] words = sentence.trim().split(" ");

            if (words == null) {
                continue;
            }
            String firstWord = words[0];
            String lastWord = words[words.length - 1];
            sb.append(lastWord + " ");
            for (int i = 1; i < words.length - 1; i++) {
                sb.append(words[i] + " ");
            }
            sb.append(firstWord);
            sb.append(". ");
        }
        System.out.println(sb.substring(0, sb.length() - 1));
    }

    void add_Task() {
        System.out.println("\n\n/*----------ADD_TASK---------*/");

        String str = "Java — строго типизированный объектно-ориентированный язык программирования общего назначения, " +
                "разработанный компанией Sun Microsystems. " +
                "Разработка ведётся сообществом, организованным через Java Community Process; " +
                "язык и основные реализующие его технологии распространяются по лицензии GPL.";
        StringBuffer sb = new StringBuffer();
        String[] sentences  = str.split("\\.");
        Arrays.sort(sentences, compareWords());
        for (String sentence : sentences) {
            sb.append(sentence + ". ");
        }
        System.out.println(sb.substring(0, sb.length() - 1));
    }

    private static Comparator<String> compareWords() {
        return (o1, o2) -> {
            int numWords_o1 = o1.trim().split(" ").length;
            int numWords_o2 = o2.trim().split(" ").length;
            return numWords_o1 - numWords_o2;
        };
    }

}
