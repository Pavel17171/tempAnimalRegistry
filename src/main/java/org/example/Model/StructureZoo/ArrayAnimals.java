package org.example.Model.StructureZoo;
import java.util.List;

public class ArrayAnimals {
    private String subType;
    private String idSubType;
    private List<SubArrayAnimal> subArrayAnimals;

    public ArrayAnimals(String subType, String idSubType, List<SubArrayAnimal> subArrayAnimals) {
        this.subType = subType;
        this.idSubType = idSubType;
        this.subArrayAnimals = subArrayAnimals;
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

    public List<SubArrayAnimal> getSubArrayAnimals() {
        return subArrayAnimals;
    }

    public void setSubArrayAnimals(List<SubArrayAnimal> subArrayAnimals) {
        this.subArrayAnimals = subArrayAnimals;
    }


    public static void printSubType (Zoo zoo, int answer) {
        for (ArrayAnimals arrayAnimals : zoo.getAnimalType().get(answer).getArrayAnimals()) {
            System.out.println(arrayAnimals.getSubType());
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (SubArrayAnimal subArrayAnimal : subArrayAnimals) {
            result.append(subArrayAnimal)
                    .append("\n");
        }
        return result.toString();
    }
}
