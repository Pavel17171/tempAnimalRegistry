package org.example.Control;

import org.example.Model.StructureZoo.AnimalType;
import org.example.Model.StructureZoo.ArrayAnimals;
import org.example.Model.StructureZoo.Animal;
import org.example.Model.StructureZoo.Zoo;

import java.util.ArrayList;
import java.util.List;

import static org.example.Control.Methods.*;

public class Answer_04 {
    public static void deleteInformation(Zoo zoo) {
        boolean flag = true;
        while (flag) {
            System.out.println("""
                                        
                    1. Удалить класс
                    2. Удалить вид
                    3. Удалить животное
                    0. выход в предыдущее меню
                    """);
            switch (answer()) {
                case 0 -> {
                    flag = false;
                }
                case 1 -> {
                    delClass(zoo);
                }
                case 2 -> {
                    delSubtype(zoo);
                }
                case 3 -> {
                    //delAnimalByID(zoo, "1-1-1");
                    answer_04_03(zoo);
                }
                default -> System.out.println("Команда не распознана");
            }
        }
    }

    public static void delClass(Zoo zoo) {
        System.out.println("Какой класс удалить?");
        boolean flag = true;
        while (flag) {
            classOfAnimals(zoo);
            System.out.println("0. Выход в предыдущее меню");
            int answ = answer() - 1;
            if (answ == -1) {
                flag = false;
            } else if (answ >= 0 && answ < zoo.getAnimalType().size()) {
                System.out.println("Удалить класс "
                                   + zoo.getAnimalType().get(answ).getType()
                                   + "?");
                if (yesOrNo()) {
                    zoo.getAnimalType().remove(answ);
                }
                flag = false;
            } else {
                System.out.println("Команда не распознана");
            }
        }
    }


    public static void delSubtype(Zoo zoo) {
        boolean flag = true;
        while (flag) {
            subTypeOfAnimals(zoo);
            System.out.println("Введите название удаляемого вида,\n" +
                               "либо \"0\" для выхода в предыдущее меню");
            String answer = answerString().toLowerCase();
            if (answer.equals("0")) {
                flag = false;
            } else {
                for (AnimalType animalType : zoo.getAnimalType()) {
                    int index = 0;
                    for (ArrayAnimals arrayAnimals : animalType.getArrayAnimals()) {
                        if ((arrayAnimals.getSubType().toLowerCase()).equals(answer)) {
                            System.out.println("Удалить вид " + arrayAnimals.getSubType() + "?");
                            if (yesOrNo()) {
                                animalType.getArrayAnimals().remove(index);
                                flag = false;
                                break;
                            }
                        }
                        index++;
                    }
                }
                if (flag) {
                    System.out.println("Такой вид не найден.");
                    System.out.println("Повторить поиск?");
                    if (!yesOrNo()) {
                        flag = false;
                    }
                }
            }
        }
    }





    //сделать удаление по ID!!!

    /**
     * Удаление животного из реестра по порядковому номеру
     * @param zoo
     * @param count
     */

    public static void delAnimal(Zoo zoo, int count) {
        int number = 0;
        boolean flag = true;
        while (flag) {
            for (AnimalType animalType : zoo.getAnimalType()) {
                for (ArrayAnimals arrayAnimals : animalType.getArrayAnimals()) {
                    if (flag) {
                        int index = 0;
                        for (Animal animal : arrayAnimals.getAnimal()) {
                            if (number == count) {
                                System.out.println("Удалить из реестра животное:\n"
                                                   + animal + "\n");
                                if (yesOrNo()) {
                                    arrayAnimals.getAnimal().remove(index);
                                }
                                flag = false;
                                break;
                            } else {
                                index++;
                                number++;
                            }
                        }
                    }
                }
            }
        }
    }

    public static void answer_04_03(Zoo zoo) {
        List<Animal> allAnimals = getListOfAllAnimalsInZoo(zoo);
        int countOfAnimal = allAnimals.size();
        boolean flag = true;
        while (flag) {
            System.out.println("""

                    Введите номер животного для удаления из реестра
                    (0 - выход в предыдущее меню)""");
            int number = answer() - 1;
            if (number == -1) {
                flag = false;
            } else if (number >= 0 && number <= countOfAnimal) {
                String idAnimal = allAnimals.get(number).getId();
                delAnimalByID(zoo, idAnimal);
                flag = false;
            } else {
                System.out.println("Команда не распознана");
            }
        }
    }


    /**
     * Удаленеи животного из реестра по ID
     * @param zoo реестр животных
     * @param idAnimal ID удаляемого животного
     */
    public static void delAnimalByID(Zoo zoo, String idAnimal) {
        List<Integer> listOfId = new ArrayList<>(idList(idAnimal));
        String idClass = listOfId.get(0).toString();
        String idSub = listOfId.get(0).toString() + "-" + listOfId.get(1).toString();
        int index = 0;
        for (AnimalType animalType : zoo.getAnimalType()) {
            if (animalType.getIdType().equals(idClass)) {
                for (ArrayAnimals arrayAnimals : animalType.getArrayAnimals()) {
                    if (arrayAnimals.getIdSubType().equals(idSub)) {
                        for (Animal animal : arrayAnimals.getAnimal()) {
                            if (animal.getId().equals(idAnimal)) {
                                System.out.println("Удалить животное из реестра?");
                                System.out.println(animal);
                                if (yesOrNo()) {
                                    arrayAnimals.getAnimal().remove(index);
                                }
                                break;
                            } else {
                                index++;
                            }
                        }
                        break;
                    }
                }
                break;
            }
        }
    }
}




