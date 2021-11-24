package lab2;

import java.util.List;
import java.util.Objects;

public class Zoo {
    private String name;
    private int capacity;
    private List<Animal> animalList;

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }

    public static class Builder {
        private Zoo zoo;

        public Builder() {
            zoo = new Zoo();
        }

        public Builder setName(String nm) {
            zoo.name = nm;
            return this;
        }

        public Builder setCapacity(int cp) {
            zoo.capacity = cp;
            return this;
        }

        public Builder setAnimalList(List<Animal> al) {
            zoo.animalList = al;
            return this;
        }

        public Zoo build() {
            return zoo;
        }
    }

    @Override
    public String toString() {
        return "Zoo {Name: " + name + "| Capacity: " + capacity + "| Animal list: " + animalList + "|}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Zoo a = (Zoo) obj;
        return Objects.equals(name, a.name) && capacity == a.capacity && animalList.equals(a.animalList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, capacity, animalList);
    }
}
