package org.example.Model;

import org.example.Model.Parser.ReadFile;
import org.example.Model.StructureZoo.Zoo;

public class JsonParser {

    public static void main(String[] args) {

        Zoo zoo = ReadFile.readFile("DB_Task_13-15.json");

        //System.out.println(zoo);
        System.out.println(zoo.getAnimalType().get(0).getArrayAnimals().get(0).getSubArrayAnimals().get(0).getBirthday());
    }
}

