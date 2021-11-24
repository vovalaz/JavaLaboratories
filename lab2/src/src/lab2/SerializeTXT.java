package lab2;

import java.io.*;

public class SerializeTXT {
    public void serializer(Animal obj, File file) throws IOException {
        try(FileWriter fw = new FileWriter(file)){
            String str = "ID = " + obj.getId() + ", Alias = " + obj.getAlias() + ", Height = " + obj.getHeight() + ", Weight = " + obj.getWeight() + ", Age = " + obj.getAge();
            fw.write(str);
        }
        catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Animal deserializer(File file) throws IOException {
        try (BufferedReader fr = new BufferedReader(new FileReader(file))) {
            String[] fields = fr.readLine().split(", ");
            Animal.Builder a = new Animal.Builder();
            a.setId(Integer.parseInt(fields[0].split(" ")[2]));
            a.setAlias(fields[1].split(" ")[2]);
            a.setHeight(Double.parseDouble(fields[2].split(" ")[2]));
            a.setWeight(Double.parseDouble(fields[3].split(" ")[2]));
            a.setAge(Integer.parseInt(fields[4].split(" ")[2]));
            return a.build();
        }
        catch (IOException e) {
            throw new RuntimeException("File is empty");
        }
    }
}
