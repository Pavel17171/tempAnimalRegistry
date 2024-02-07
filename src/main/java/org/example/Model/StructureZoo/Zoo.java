package org.example.Model.StructureZoo;
import java.util.List;

public class Zoo {
    private String name;
    private List<AnimalType> animalType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AnimalType> getAnimalType() {
        return animalType;
    }

    public void setAnimalType(List<AnimalType> animalType) {
        this.animalType = animalType;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(name).append("\n-----\n").append("\n");
        for (AnimalType arrayType : animalType) {
            result.append(arrayType);

        }
        return result.toString();

    }
}
