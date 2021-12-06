package lab5;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Zoo {
    private String _name;
    private int _capacity;
    private List<Animal> _animalList;

    public String get_name() {
        return _name;
    }

    public int get_capacity() {
        return _capacity;
    }

    public List<Animal> get_animalList() {
        return _animalList;
    }

    public Zoo(Builder bld) {
        this._name = bld.name;
        this._capacity = bld.capacity;
        this._animalList = bld.animalList;
    }

    public static class Builder {
        @Pattern(regexp = "[A-Z][a-zA-Z]+", message = "Zoo name must start with capital letter")
        private String name;
        @Min(value = 1, message = "Capacity of zoo must be between 1 and 1000!")
        @Max(value = 1000, message = "Capacity of zoo must be between 1 and 1000!")
        private int capacity;
        private List<Animal> animalList;

        public Builder() {
            name = "";
            capacity = 0;
            Animal a = new Animal();
            animalList = new ArrayList<Animal>();
            animalList.add(a);
        }

        public Builder setName(String nm) {
            this.name = nm;
            return this;
        }

        public Builder setCapacity(int cp) {
            this.capacity = cp;
            return this;
        }

        public Builder setAnimalList(List<Animal> al) {
            this.animalList = al;
            return this;
        }

        public void validate(Zoo zoo) {
            ValidatorFactory fct = Validation.buildDefaultValidatorFactory();
            Validator validator = fct.getValidator();
            Set<ConstraintViolation<Zoo.Builder>> constraintViolationSet = validator.validate(this);

            String err = new String();
            err = "";

            for (var cv : constraintViolationSet) {
                err += "Error on (" + cv.getInvalidValue() + ") with message: " + cv.getMessage() + "\n";
            }

            if (err != "") {
                throw new IllegalArgumentException(err);
            }
        }

        public Zoo build() {
            Zoo zoo = new Zoo(this);
            validate(zoo);
            return zoo;
        }
    }

    @Override
    public String toString() {
        return "Zoo {Name: " + _name + "| Capacity: " + _capacity + "| Animal list: " + _animalList + "|}";
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
        return Objects.equals(_name, a._name) && _capacity == a._capacity && _animalList.equals(a._animalList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), _name, _capacity, _animalList);
    }
}
