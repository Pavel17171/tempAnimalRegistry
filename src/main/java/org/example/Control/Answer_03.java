package org.example.Control;

import org.example.Model.StructureZoo.AnimalType;
import org.example.Model.StructureZoo.ArrayAnimals;
import org.example.Model.StructureZoo.Zoo;

import static org.example.Control.Methods.*;

public class Answer_03 {
    public static void editAnimal(Zoo zoo) {
        boolean flag = true;
        while (flag) {
            System.out.println("""
                                                            
                    1. Редактировать название класса
                    2. Редактировать название вида
                    3. Редактировать данные по животному
                    0. Выход в главное меню
                    """);
            switch (answer()) {
                case 0 -> {
                    flag = false;
                    System.out.println("Главное меню\n");
                }
                case 1 -> {
                    answer_03_01(zoo);
                }
                case 2 -> {
                    answer_03_02(zoo);
                }
                case 3 -> {
                    answer_03_03(zoo);
                }
                default -> System.out.println("Команда не известна");
            }
        }
    }


    // написать выход из метода

    /**
     * Переименование класса животного
     *
     * @param zoo реестр животых
     */
    public static void answer_03_01(Zoo zoo) {
        boolean flag = true;
        System.out.println("Классы в реестре");
        classOfAnimals(zoo);
        System.out.println("0. Выход в предыдущее меню\n");
        System.out.println("Какой класс переименовать? ");
        System.out.println("(введите номер класса)\n");
        while (flag) {
            int answ = answer();
            if (answ == 0) {
                flag = false;
            } else if (answ > 0 && answ <= zoo.getAnimalType().size()) {
                System.out.println("Введите название нового класса:");
                String newName = answerString();
                zoo.getAnimalType().get(answ - 1).setType(capitalize(removeSpaces(newName)));
                flag = false;
            } else {
                System.out.println("Такого номера нет");
            }
        }
    }


    /**
     * Редактирование названия вида животного
     *
     * @param zoo реестр животных
     */
    public static void answer_03_02(Zoo zoo) {
        boolean flag = true;
        System.out.println("Виды в реестре:");
        subTypeOfAnimals(zoo);
        while (flag) {
            System.out.println("Введите название редактируемого вида");
            String answ = answerString().toLowerCase();
            if (answ.equals("0")) {
                flag = false;
            } else {
                for (AnimalType animalType : zoo.getAnimalType()) {
                    if (flag) {
                        for (ArrayAnimals arrayAnimals : animalType.getArrayAnimals()) {
                            if (arrayAnimals.getSubType().toLowerCase().equals(answ)) {
                                System.out.println("Введите новое название вида:");
                                arrayAnimals.setSubType(capitalize(removeSpaces(answerString())));
                                flag = false;
                                break;
                            }
                        }
                    } else {
                        break;
                    }
                }
                if (flag) {
                    System.out.println("Такой вид не найден\n" +
                                       "Какой вид редактировать?");
                }
            }
        }
    }




    public static void answer_03_03(Zoo zoo) {
        System.out.println("1. Вывести список всех животных");
        System.out.println("2. Вывести список животных определенного класса");
        System.out.println("3. Вывести список животных определенного вида");
        System.out.println("4. Найти животное по имени/ID");
        System.out.println("0. Выход в предыдущее меню");
        boolean flag = true;
        while (flag) {
            switch (answer()) {
                case 0 -> {
                    flag = false;
                }
                case 1 -> {
                    editAnimalInList(getListOfAllAnimalsInZoo(zoo));
                    flag = false;
                }
                case 2 -> {
                    editAnimalInList(getListOfAnimalsInSomeClass(zoo));
                    flag = false;
                }
                case 3 -> {
                    editAnimalInList(getListOfAnimalsInSomeSub(zoo));
                    flag = false;
                }
                case 4 -> {
                    editAnAnimalByNicknameOrID(zoo);
                    flag = false;
                }
                default -> {
                    System.out.println("Команда не распознана");
                }
            }
        }
    }


}


