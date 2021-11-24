package lab2;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        Animal a1 = new Animal.Builder().setAge(10).setAlias("Murzik").setHeight(90).setId(1).setWeight(30).build();
        Animal a2 = new Animal.Builder().setAge(14).setAlias("Bobik").setHeight(80).setId(2).setWeight(15).build();
        Animal a3 = new Animal.Builder().setAge(8).setAlias("Tom").setHeight(70).setId(3).setWeight(20).build();
        SerializeTXT srzTxt = new SerializeTXT();
        SerializeJSON srzJson = new SerializeJSON();
        SerializeXML srzXml = new SerializeXML();
        File fTxt = new File("animal.txt");
        File fJson = new File("animal.json");
        File fXml = new File("animal.xml");
        try {
            srzTxt.serializer(a1, fTxt);
            srzJson.serializer(a2, fJson);
            srzXml.serializer(a3, fXml);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Animal animalTxt = new Animal();
        Animal animalJson = new Animal();
        Animal animalXml = new Animal();

        try {
            animalTxt = srzTxt.deserializer(fTxt);
            animalJson = srzJson.deserializer(fJson);
            animalXml = srzXml.deserializer(fXml);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(animalTxt);
        System.out.println(animalJson);
        System.out.println(animalXml);
    }
}
