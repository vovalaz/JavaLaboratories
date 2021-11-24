package lab3;

import lab3.Animal;
import lab3.AnimalComparator;

import java.util.ArrayList;
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

    public List<Animal> sortByAlias() {
        animalList.sort(new AnimalComparator());
        return animalList;
    }

    public List<Animal> sortByAliasStream() {
        return animalList.stream().sorted(new AnimalComparator()).toList();
    }

    public List<Animal> filterWeightMoreThan(double min_weight) {
        List<Animal> res = new ArrayList<Animal>();
        for (var anm : animalList) {
            if (anm.getWeight() >= min_weight) {
                res.add(anm);
            }
        }
        return res;
    }

    public List<Animal> filterWeightMoreThanStream(double min_weight) {
        return animalList.stream().filter(a -> a.getWeight() >= min_weight).toList();
    }

    public List<Animal> getAnimalListOfAge(int age) {
        List<Animal> res = new ArrayList<Animal>();
        for (var anm : animalList) {
            if (anm.getAge() == age) {
                res.add(anm);
            }
        }
        return res;
    }

    public List<Animal> getAnimalListOfAgeStream(int age) {
        return animalList.stream().filter(a->a.age == age).toList();
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
