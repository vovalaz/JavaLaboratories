package lab1;

import java.util.Objects;

public class Animal {
    protected int id;
    protected String Alias;
    protected double height;
    protected double weight;
    protected int age;

    public int getId() {
        return id;
    }

    public String getAlias() {
        return Alias;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public int getAge() {
        return age;
    }

    public static class Builder {
        private Animal anm;

        public Builder() {
            anm = new Animal();
        }

        public Builder setId(int id) {
            anm.id = id;
            return this;
        }

        public Builder setAlias(String alias) {
            anm.Alias = alias;
            return this;
        }

        public Builder setHeight(double height) {
            anm.height = height;
            return this;
        }

        public Builder setWeight(double weight) {
            anm.weight = weight;
            return this;
        }

        public Builder setAge(int age) {
            anm.age = age;
            return this;
        }

        public Animal build() {
            return anm;
        }
    }

    @Override
    public String toString() {
        return "Animal [" + id +
                "]\n{Alias: " + Alias + "| Height: " + height + "| Weight: " + weight + "| Age: " + age + "|}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Animal a = (Animal) obj;
        return id == a.id && Objects.equals(Alias, a.Alias) && height == a.height && weight == a.weight && age == a.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Alias, height, weight, age);
    }
}
