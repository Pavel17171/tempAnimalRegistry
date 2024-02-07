package org.example.Control;

import org.example.Model.StructureZoo.Zoo;


import static org.example.Control.Methods.*;

public class Answer_01 {
    public static void answer_01(Zoo zoo) {
        boolean flag = true;
        while (flag) {
            System.out.println("""

                    Введите команду:
                    1 - вывести список всех животных
                    2 - вывести список классов животных
                    3 - вывести список видов животных
                    4 - вывести список животных определенного класса
                    5 - вывести список животных определенного вида
                    0 - выход в главное меню
                    """);
            switch (answer()) {
                case 0 -> {
                    flag = false;
                    System.out.println("Главное меню\n");
                }
                case 1 -> {
                    System.out.println("Список всех животных");
                    System.out.println(zoo);
                }
                case 2 -> {
                    System.out.println("Классы в реестре");
                    classOfAnimals(zoo);
                }
                case 3 -> {
                    System.out.println("Список видов животных");
                    subTypeOfAnimals(zoo);
                }
                case 4 -> {
                    System.out.println("Список животных определенного класса");
                    System.out.println(getAnimalSomeType(zoo));
                }
                case 5 -> {
                    System.out.println("Список животных определенного вида");
                    try {
                        System.out.println(getAnimalSomeSub(zoo));
                    } catch (Exception e) {
                        System.out.println();
                    }
                }
                default -> System.out.println("Команда не распознана");
            }
        }
    }
}
