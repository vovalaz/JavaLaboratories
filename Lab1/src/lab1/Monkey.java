package lab1;

import java.util.Objects;

public class Monkey extends Animal {
    protected String furColor;
    protected String species;

    public Monkey(Animal a) {
        id = a.id;
        Alias = a.Alias;
        height = a.height;
        weight = a.weight;
        age = a.age;
    }

    public String getFurColor() {
        return furColor;
    }

    public String getSpecies() {
        return species;
    }

    public void setFurColor(String furColor) {
        this.furColor = furColor;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    @Override
    public String toString() {
        return "Animal [" + id +
                "]\n{Alias: " + Alias + "| Height: " + height + "| Weight: " + weight + "| Age: " + age +
                "| Species: " + species + "| Fur color: " + furColor + "|}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        Monkey a = (Monkey) obj;
        return Objects.equals(furColor, a.furColor) && Objects.equals(species, a.species);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Alias, height, weight, age);
    }
}
