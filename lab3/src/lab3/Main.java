package lab3;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Animal a1 = new Animal.Builder().setAge(10).setAlias("Murzik").setHeight(90).setId(1).setWeight(30).build();
        Animal a2 = new Animal.Builder().setAge(14).setAlias("Bobik").setHeight(80).setId(2).setWeight(15).build();
        Animal a3 = new Animal.Builder().setAge(8).setAlias("Tom").setHeight(70).setId(3).setWeight(20).build();
        Animal a4 = new Animal.Builder().setAge(10).setAlias("Murzyak").setHeight(90).setId(4).setWeight(30).build();
        Animal a5 = new Animal.Builder().setAge(8).setAlias("Jerry").setHeight(10).setId(5).setWeight(30).build();

        List<Animal> animals = new ArrayList<Animal>();
        animals.add(a1);
        animals.add(a2);
        animals.add(a3);
        animals.add(a4);
        animals.add(a5);

        Zoo z1 = new Zoo.Builder().setAnimalList(animals).setCapacity(30).setName("abc").build();

        String sorted = new String();
        sorted = "";
        for (var an : z1.sortByAlias()) {
            sorted += an.toString() + "\n";
        }
        System.out.println(sorted + "\n");

        String sortedStream = new String();
        sortedStream = "";
        for (var an : z1.sortByAliasStream()) {
            sortedStream += an.toString() + "\n";
        }
        System.out.println(sortedStream + "\n");

        String filtered = new String();
        filtered = "";
        for (var an : z1.filterWeightMoreThan(21)) {
            filtered += an.toString() + "\n";
        }
        System.out.println(filtered + "\n");

        String filteredStream = new String();
        filteredStream = "";
        for (var an : z1.filterWeightMoreThanStream(19)) {
            filteredStream += an.toString() + "\n";
        }
        System.out.println(filteredStream + "\n");

        String find = new String();
        find = "";
        for (var an : z1.getAnimalListOfAge(10)) {
            find += an.toString() + "\n";
        }
        System.out.println(find + "\n");

        String findStream = new String();
        findStream = "";
        for (var an : z1.getAnimalListOfAgeStream(8)) {
            findStream += an.toString() + "\n";
        }
        System.out.println(findStream + "\n");
    }
}
