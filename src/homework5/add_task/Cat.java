package homework5.add_task;

import java.lang.reflect.Field;

public class Cat {

    public void modifyAnimal() {
        Animal animal = new Animal();

        Class<?> cl = Animal.class;

        Field field = null;
        try {
            field = cl.getDeclaredField("age");
            field.setAccessible(true);
            // У класса Field, есть различные методы get
            System.out.println("Private field value: " + field.getInt(animal));
            field.setInt(animal, 8);
            System.out.println("New private field value: " + field.getInt(animal));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
