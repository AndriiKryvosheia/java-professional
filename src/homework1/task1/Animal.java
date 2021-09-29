package homework1.task1;

public class Animal implements Comparable { // <Animal>{
    String breed;
    int speed;
    int price;
    int weight;

    public Animal(String breed, int weight, int speed, int price) {
        this.breed = breed;
        this.speed = speed;
        this.price = price;
        this.weight = weight;
    }

    public String toString() {
        return this.breed + " " + this.speed + " " + this.price + " " + this.weight;
    }

    // Сортируем по скорости/цене
    public int compareTo(Object obj) {//    public int compareTo(Animal o) {
        if (obj.getClass() != this.getClass()) {
            throw new ClassCastException();
        }

        Animal animal = (Animal) obj;
        int tmp = animal.speed - this.speed; //    int tmp = this.speed - o.speed;

        if (this.speed != animal.speed) {
            return this.speed - animal.speed;
        } else if (this.price != animal.price) {
            return this.price - animal.price;
        } else if (this.weight != animal.weight) {
            return this.weight - animal.weight;
        } else {
            return this.breed.compareTo(animal.breed);
        }
    }
}