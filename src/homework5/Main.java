package homework5;

import homework5.add_task.Cat;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {

    public static void main(String[] args) {

        Main main = new Main();
        main.startTask2();
        main.startTask3();
        main.add_Task();
    }

    void startTask2() {
        System.out.println("\n\n/*----------TASK 2---------*/");
        classInfo("java.util.ArrayList");
    }

    void startTask3() {
        System.out.println("\n\n/*----------TASK 3---------*/");
        classInfo("homework5.task3.MyClass");
    }

    void add_Task() {
        System.out.println("\n\n/*----------ADD_TASK---------*/");
        Cat cat = new Cat();
        cat.modifyAnimal();
    }

    static void classInfo(String className) {
        Class<?> cl = null;
        try {
            cl = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("\nПоля:");
        Field[] fields = cl.getDeclaredFields();
        for (Field field : fields) {
            int mods = field.getModifiers();
            if (Modifier.isPrivate(mods)) {
                System.out.print("private ");
            }
            if (Modifier.isAbstract(mods)) {
                System.out.print("abstract ");
            }
            if (Modifier.isStatic(mods)) {
                System.out.print("static ");
            }
            if (Modifier.isFinal(mods)) {
                System.out.print("final ");
            }
            System.out.println(field.getType() + " " +  field.getName());
        }

        System.out.println("\nКонструкторы:");
        Constructor<?>[] constructors = cl.getDeclaredConstructors();
        int i = 0;
        for (Constructor<?> ctr : constructors) {
            System.out.print("Constructor " + (++i) + ": ");
            Class<?>[] paramTypes = ctr.getParameterTypes();
            for (Class<?> paramType : paramTypes) {
                System.out.print(paramType.getName());
            }
            System.out.println();
        }

        System.out.println("\nМетоды:");
        Method[] methods = cl.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }
}
