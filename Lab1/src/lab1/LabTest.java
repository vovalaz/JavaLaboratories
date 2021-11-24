package lab1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

import lab1.Animal;
import lab1.Zoo;

public class LabTest {

    @Test(dataProvider = "animalProvider")
    public void animalTest(Animal obj1, Animal obj2) {
        assertEquals(obj1, obj2);
    }

    @DataProvider
    public Object[][] animalProvider() {
        Animal a1 = new Animal.Builder().setAge(10).setAlias("Murzik").setHeight(90).setId(1).setWeight(30).build();
        Animal a2 = new Animal.Builder().setAge(14).setAlias("Bobik").setHeight(80).setId(2).setWeight(15).build();
        Animal a3 = new Animal.Builder().setAge(8).setAlias("Tom").setHeight(70).setId(3).setWeight(20).build();
        Animal a4 = new Animal.Builder().setAge(10).setAlias("Murzik").setHeight(90).setId(1).setWeight(30).build();
        Animal a5 = new Animal.Builder().setAge(2).setAlias("Jerry").setHeight(10).setId(5).setWeight(30).build();
        return new Object[][]{{a1, a4}, {a5, a5}, {a3, a3}};
    }

    @Test(dataProvider = "animalProviderNotEq")
    public void animalTestNotEq(Animal obj1, Animal obj2) {
        assertNotEquals(obj1, obj2);
    }

    @DataProvider
    public Object[][] animalProviderNotEq() {
        Animal a1 = new Animal.Builder().setAge(10).setAlias("Murzik").setHeight(90).setId(1).setWeight(30).build();
        Animal a2 = new Animal.Builder().setAge(14).setAlias("Bobik").setHeight(80).setId(2).setWeight(15).build();
        Animal a3 = new Animal.Builder().setAge(8).setAlias("Tom").setHeight(70).setId(3).setWeight(20).build();
        Animal a4 = new Animal.Builder().setAge(10).setAlias("Murzik").setHeight(90).setId(1).setWeight(30).build();
        Animal a5 = new Animal.Builder().setAge(2).setAlias("Jerry").setHeight(10).setId(5).setWeight(30).build();
        return new Object[][]{{a1, a2}, {a2, a5}, {a4, a5}};
    }

    @Test(dataProvider = "zooProvider")
    public void ZooTest(Zoo obj1, Zoo obj2) {
        assertEquals(obj1, obj2);
    }

    @DataProvider
    public Object[][] zooProvider() {
        Animal a1 = new Animal.Builder().setAge(10).setAlias("Murzik").setHeight(90).setId(1).setWeight(30).build();
        Animal a2 = new Animal.Builder().setAge(14).setAlias("Bobik").setHeight(80).setId(2).setWeight(15).build();
        Animal a3 = new Animal.Builder().setAge(8).setAlias("Tom").setHeight(70).setId(3).setWeight(20).build();
        Animal a4 = new Animal.Builder().setAge(10).setAlias("Murzik").setHeight(90).setId(1).setWeight(30).build();
        Animal a5 = new Animal.Builder().setAge(2).setAlias("Jerry").setHeight(10).setId(5).setWeight(30).build();
        List<Animal> alst1 = new ArrayList<Animal>();
        List<Animal> alst2 = new ArrayList<Animal>();
        alst1.add(a1);
        alst1.add(a2);
        alst1.add(a3);
        alst1.add(a4);
        alst1.add(a5);
        alst2.add(a3);
        alst2.add(a2);
        alst2.add(a1);
        alst2.add(a5);
        alst2.add(a4);

        Zoo z1 = new Zoo.Builder().setAnimalList(alst1).setCapacity(30).setName("Africa").build();
        Zoo z2 = new Zoo.Builder().setAnimalList(alst2).setCapacity(40).setName("Savanna").build();

        return new Object[][] {{z1, z1}, {z2, z2}, {z2, new Zoo.Builder().setAnimalList(alst2).setCapacity(40).setName("Savanna").build()}};
    }

    @Test(dataProvider = "zooProviderNotEq")
    public void ZooTestNotEq(Zoo obj1, Zoo obj2) {
        assertNotEquals(obj1, obj2);
    }

    @DataProvider
    public Object[][] zooProviderNotEq() {
        Animal a1 = new Animal.Builder().setAge(10).setAlias("Murzik").setHeight(90).setId(1).setWeight(30).build();
        Animal a2 = new Animal.Builder().setAge(14).setAlias("Bobik").setHeight(80).setId(2).setWeight(15).build();
        Animal a3 = new Animal.Builder().setAge(8).setAlias("Tom").setHeight(70).setId(3).setWeight(20).build();
        Animal a4 = new Animal.Builder().setAge(10).setAlias("Murzik").setHeight(90).setId(1).setWeight(30).build();
        Animal a5 = new Animal.Builder().setAge(2).setAlias("Jerry").setHeight(10).setId(5).setWeight(30).build();
        List<Animal> alst1 = new ArrayList<Animal>();
        List<Animal> alst2 = new ArrayList<Animal>();
        alst1.add(a1);
        alst1.add(a2);
        alst1.add(a3);
        alst1.add(a4);
        alst1.add(a5);
        alst2.add(a3);
        alst2.add(a2);
        alst2.add(a1);
        alst2.add(a5);
        alst2.add(a4);

        Zoo z1 = new Zoo.Builder().setAnimalList(alst1).setCapacity(30).setName("Africa").build();
        Zoo z2 = new Zoo.Builder().setAnimalList(alst2).setCapacity(40).setName("Savanna").build();

        return new Object[][] {
                {z1, z2},
                {z2, new Zoo.Builder().setAnimalList(alst1).setCapacity(30).setName("Savanna").build()}
        };
    }

}
