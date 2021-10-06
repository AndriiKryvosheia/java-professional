package homework4;

import java.io.*;
import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        Main main = new Main();
        main.startTask2();
        main.startTask3();
        main.add_Task();
    }

    void startTask2() {
        System.out.println("\n\n/*----------TASK 2---------*/");

        // Сохраняем предлоги из файла в ArrayList
        ArrayList<String> prepositions = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream("src/homework4/Предлоги.txt"), "UTF-8"))) {
            String temp;
            while ((temp = br.readLine()) != null) {
                prepositions.add(temp);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        // Считываем оригинальный текст, разбиваем его на слова и записываем в файл измененный текст
        try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/homework4/Оригинальный текст.txt"), "UTF-8"));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/homework4/Новый текст.txt"), "UTF-8"))) {

            StringBuffer sb = new StringBuffer();
            String line;
            String ls = System.getProperty("line.separator");
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append(ls);
            }
            sb.deleteCharAt(sb.length()-1);

            String[] words = sb.toString().split("\\b");
            for (String word: words) {
                if (prepositions.contains(word.toLowerCase())) {
                    bw.write("Java");
                } else {
                    bw.write(word);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    void startTask3() {
        System.out.println("\n\n/*----------TASK 3---------*/");

        LocalDate currentDate = LocalDate.now();
        LocalDate birthDate = LocalDate.of(1983, 12, 11);

        Period period = Period.between(birthDate, currentDate);
        LocalTime currentTime = LocalTime.now();
        System.out.println("Вам исполнилось "
                + period.getYears() + " лет, "
                + period.getMonths() + " месяцев, "
                + period.getDays() + " дней, "
                + currentTime.getHour() + " часов,"
                + currentTime.getMinute() + " минут,"
                + currentTime.getSecond() + " секунд.");
    }

    void add_Task() {
        System.out.println("\n\n/*----------ADD_TASK---------*/");

        Pattern pLogin = Pattern.compile("[A-Za-z]+");
        Pattern pPassword = Pattern.compile("\\w+");

        Scanner in = new Scanner(System.in);
        System.out.print("Введите логин: ");
        String login = in.next();
        System.out.print("Введите пароль: ");
        String password = in.next();

        if (!pLogin.matcher(login).matches()) {
            System.out.println("login: \"" + login + "\" должен состоять только из символов латинского алфавита");
        }
        if (!pPassword.matcher(password).matches()) {
            System.out.println("password: \"" + password + "\" должен состоять из цифр и символов");
        }
    }
}
