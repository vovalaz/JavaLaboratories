package lab4;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Objects;

public class LabTest {
    @Test
    public void AnimalIdTest() {
        new Animal.Builder().setId(10).build();
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void AnimalIdFailTest() {
        new Animal.Builder().setId(-5).build();
    }

    @Test
    public void AnimalAliasTest() {
        new Animal.Builder().setAlias("Sigma").build();
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void AnimalAliasFailTest() {
        new Animal.Builder().setAlias("sigma").build();
    }

    @Test
    public void AnimalHeightTest() {
        new Animal.Builder().setHeight(200).build();
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void AnimalHeightFailTest() {
        new Animal.Builder().setHeight(6500).build();
    }
}
