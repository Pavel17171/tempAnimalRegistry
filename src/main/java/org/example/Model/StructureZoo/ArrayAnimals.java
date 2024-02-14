package org.example.Model.StructureZoo;
import java.util.List;

public class ArrayAnimals {
    private String subType;
    private String idSubType;
    private List<Animal> animals;

    public ArrayAnimals(String subType, String idSubType, List<Animal> animals) {
        this.subType = subType;
        this.idSubType = idSubType;
        this.animals = animals;
    }

    public ArrayAnimals() {}
    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getIdSubType() {
        return idSubType;
    }

    public void setIdSubType(String idSubType) {
        this.idSubType = idSubType;
    }

    public List<Animal> getAnimal() {
        return animals;
    }

    public void setAnimal(List<Animal> animals) {
        this.animals = animals;
    }


    public static void printSubType (Zoo zoo, int answer) {
        for (ArrayAnimals arrayAnimals : zoo.getAnimalType().get(answer).getArrayAnimals()) {
            System.out.println(arrayAnimals.getSubType());
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Animal animal : animals) {
            result.append(animal)
                    .append("\n");
        }
        return result.toString();
    }
}
