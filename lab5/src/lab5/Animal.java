package lab5;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;

public class Animal {

    protected int _id;
    protected String _Alias;
    protected double _height;
    protected double _weight;
    protected int _age;

    public Animal() {
        _id = 0;
        _Alias = new String();
        _height = 0;
        _weight = 0;
        _age = 0;
    }

    private Animal(Builder obj) {
        this._age = obj.age;
        this._weight = obj.weight;
        this._Alias = obj.alias;
        this._height = obj.height;
        this._id = obj.id;
    }

    public int get_id() {
        return _id;
    }

    public String get_Alias() {
        return _Alias;
    }

    public double get_height() {
        return _height;
    }

    public double get_weight() {
        return _weight;
    }

    public int get_age() {
        return _age;
    }

    public static class Builder {

        @Min(value = 1, message = "Id must be > 0")
        private int id;

        @Pattern(regexp = "[A-Z][a-zA-Z]+", message = "Alias must start with capital letter")
        private String alias;

        @Min(value = 0, message = "height can't be < 0")
        @Max(value = 2000, message = "height must be between 0 and 2000")
        private double height;

        @Min(value = 0, message = "weight can't be < 0")
        @Max(value = 10000, message = "weight must be between 0 and 10000")
        private double weight;

        @Min(value = 0, message = "age can't be < 0")
        @Max(value = 100, message = "age must be between 0 and 2000")
        private int age;

        public Builder() {
            id = 1;
            height = 0;
            weight = 0;
            age = 0;
            alias = "Alias";
        }

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setAlias(String alias) {
            this.alias = alias;
            return this;
        }

        public Builder setHeight(double height) {
            this.height = height;
            return this;
        }

        public Builder setWeight(double weight) {
            this.weight = weight;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public void validate(Animal anm) {
            ValidatorFactory fct = Validation.buildDefaultValidatorFactory();
            Validator validator = fct.getValidator();
            Set<ConstraintViolation<Builder>> constraintViolationSet = validator.validate(this);

            String err = new String();
            err = "";

            for (var cv : constraintViolationSet) {
                err += "Error on (" + cv.getInvalidValue() + ") with message: " + cv.getMessage() + "\n";
            }

            if (err != "") {
                throw new IllegalArgumentException(err);
            }
        }

        public Animal build() {
            Animal anm = new Animal(this);
            validate(anm);
            return anm;
        }
    }

    @Override
    public String toString() {
        return "Animal [" + _id +
                "]\n{Alias: " + _Alias + "| Height: " + _height + "| Weight: " + _weight + "| Age: " + _age + "|}";
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
        return _id == a._id && Objects.equals(_Alias, a._Alias) && _height == a._height && _weight == a._weight && _age == a._age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, _Alias, _height, _weight, _age);
    }
}
