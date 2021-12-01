package lab4;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Animal a1 = new Animal.Builder().setAge(10).setAlias("Murzik").setHeight(90).setId(1).setWeight(30).build();
        Animal a2 = new Animal.Builder().setAge(14).setAlias("Bobik").setHeight(80).setId(2).setWeight(15).build();
        Animal a3 = new Animal.Builder().setAge(12).setAlias("Tom").setHeight(70).setId(3).setWeight(20).build();
        Animal a4 = new Animal.Builder().setAge(10).setAlias("Sigma").setHeight(185).setId(4).setWeight(90).build();
        Animal a5 = new Animal.Builder().setAge(8).setAlias("Jerry").setHeight(10).setId(5).setWeight(30).build();

        List<Animal> animals = new ArrayList<Animal>();
        animals.add(a1);
        animals.add(a2);
        animals.add(a3);
        animals.add(a4);
        animals.add(a5);

        Zoo z1 = new Zoo.Builder().setAnimalList(animals).setCapacity(30).setName("Abc").build();
    }
}
