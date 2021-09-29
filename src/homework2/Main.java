package homework2;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {

        Main main = new Main();
        main.startTask2();
        main.startTask3();
        main.startTask4();
    }

    void startTask2() {
        System.out.println("\n\n/*----------TASK 2---------*/");

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        priorityQueue.add(10);
        priorityQueue.add(90);
        priorityQueue.add(80);
        priorityQueue.add(70);
        priorityQueue.add(20);
        priorityQueue.add(30);
        priorityQueue.add(50);
        priorityQueue.add(100);
        priorityQueue.add(40);
        priorityQueue.add(10);

        System.out.println(priorityQueue);
    }

    void startTask3() {
        System.out.println("\n\n/*----------TASK 3---------*/");

        HashMap<String, String > hashMap = new HashMap<>();
        hashMap.put("Москва", "Ивановы");
        hashMap.put("Киев", "Петровы");
        hashMap.put("Лондон", "Абрамовичи");

        System.out.println(hashMap.get("Киев"));
    }

    void startTask4() {
        System.out.println("\n\n/*----------TASK 4---------*/");

        SimpleHashMap<String, String > simpleHashMap = new SimpleHashMap<>();
        simpleHashMap.put("Москва", "Ивановы");
        simpleHashMap.put("Киев", "Петровы");
        simpleHashMap.put("Лондон", "Абрамовичи");
        System.out.println(simpleHashMap);

        simpleHashMap.put("Москва", "Тютьки");
        System.out.println("put(\"Москва\", \"Тютьки\"): " + simpleHashMap);

        simpleHashMap.remove("Киев");
        System.out.println("remove(\"Киев\"): " + simpleHashMap);

        System.out.println("get(\"Лондон\"): " + simpleHashMap.get("Лондон"));
        System.out.println("get(\"Киев\"): " + simpleHashMap.get("Киев"));
    }
}
