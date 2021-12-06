package lab5;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Animal[] a = new Animal[]{
                new Animal.Builder().setAge(10).setAlias("Murzik").setHeight(90).setId(1).setWeight(30).build(),
                new Animal.Builder().setAge(14).setAlias("Bobik").setHeight(80).setId(2).setWeight(15).build(),
                new Animal.Builder().setAge(12).setAlias("Tom").setHeight(70).setId(3).setWeight(20).build(),
                new Animal.Builder().setAge(10).setAlias("Sigma").setHeight(185).setId(4).setWeight(90).build(),
                new Animal.Builder().setAge(8).setAlias("Jerry").setHeight(10).setId(5).setWeight(30).build(),
                new Animal.Builder().setAge(7).setAlias("Topa").setHeight(75).setId(6).setWeight(40).build(),
                new Animal.Builder().setAge(3).setAlias("Belka").setHeight(125).setId(7).setWeight(35).build(),
                new Animal.Builder().setAge(8).setAlias("Strelka").setHeight(70).setId(8).setWeight(20).build(),
                new Animal.Builder().setAge(14).setAlias("Suslik").setHeight(90).setId(9).setWeight(15).build(),
                new Animal.Builder().setAge(17).setAlias("Ponchyk").setHeight(130).setId(10).setWeight(30).build()};

        DBConnector cn = new DBConnector();

        cn.executeSQL("CREATE TABLE Animals (Id INT PRIMARY KEY, Alias NVARCHAR(30), Age INT, Height FLOAT, Weight FLOAT);");

        for (var anm : a) {
            cn.executeSQL("INSERT INTO Animals (Id, Alias, Age, Height, Weight) VALUES "
                    + String.format("(%d, '%s', %d, %d, %d);", anm.get_id(), anm.get_Alias(), anm.get_age(), (int)anm.get_height(), (int)anm.get_weight()));
        }

        try {
            ResultSet res = cn.executeSQLWithResult("SELECT * FROM Animals");
            System.out.println("Animals : ");
            while (res.next()) {
                System.out.println(res.getString("Id") + ", "
                        + res.getString("Alias") + ", "
                        + res.getString("Age") + ", "
                        + res.getString("Height") + ", "
                        + res.getString("Weight") + ";");
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }


}
