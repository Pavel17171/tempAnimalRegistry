package org.example.Model.StructureZoo;
import java.util.List;

public class AnimalType {
    private String type;
    private String idType;
    private List<ArrayAnimals> arrayAnimals;

    public AnimalType(String type, String idType, List<ArrayAnimals> arrayAnimals) {
        this.type = type;
        this.idType = idType;
        this.arrayAnimals = arrayAnimals;
    }

    public AnimalType() {}
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public List<ArrayAnimals> getArrayAnimals() {
        return arrayAnimals;
    }

    public void setArrayAnimals(List<ArrayAnimals> arrayAnimals) {
        this.arrayAnimals = arrayAnimals;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(idType)
                .append(". ")
                .append(type)
                .append(":\n\n");
        for (ArrayAnimals arrayAnimals : arrayAnimals) {
            result.append(arrayAnimals.getIdSubType())
                    .append(". ")
                    .append(arrayAnimals.getSubType())
                    .append(":")
                    .append("\n");
            for (int i = 0; i < arrayAnimals.getSubArrayAnimals().size(); i++) {
                result.append(arrayAnimals.getSubArrayAnimals().get(i))
                        .append("\n");
            }
            result.append("\n");
        }

        return result.toString();
    }
}
