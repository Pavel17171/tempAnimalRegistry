package org.example.Control;

import org.example.Model.StructureZoo.*;

import java.util.ArrayList;

import static org.example.Control.Methods.*;


public class Answer_02 {

    public static void addNewAnimal(Zoo zoo) {
        boolean flag = true;
        while (flag) {
            System.out.println("""
                                        
                    1. Добавить новый класс животных
                    2. Добавить новый вид животных
                    3. Добавить новое животное
                    0. Выйти в главное меню
                                        
                    """);
            switch (answer()) {
                case 0 -> {
                    System.out.println("Выход в главное меню");
                    flag = false;
                }
                case 1 -> {
                    answer_02_01(zoo);
                }
                case 2 -> {
                    answer_02_02(zoo);
                }
                case 3 -> {
                    answer_02_03(zoo);
                }
                default -> {
                    System.out.println("Команда не распознана");
                }
            }
        }
    }

    /**
     * Добавление нового класса
     * @param zoo реестр животных
     */
    public static void answer_02_01(Zoo zoo) {
        System.out.println("Классы в реестре");
        classOfAnimals(zoo);
        System.out.println("Введите название нового класса:");
        newAnimalClass(zoo);
        System.out.println("Добавить ещё класс?");
        while (yesOrNo()) {
            System.out.println("Введите название нового класса:");
            newAnimalClass(zoo);
            System.out.println("Добавить ещё класс?");
        }
    }


    /**
     * Создание нового вида животных
     *
     * @param zoo реестр животных
     */
    public static void answer_02_02(Zoo zoo) {
        System.out.println("В какой класс добавить новый вид?"
                           + "\n"
                           + "(введите номер пункта)");

        // Список существующих классов
        System.out.println("Классы в реестре");
        classOfAnimals(zoo);

        // Создание пункта для нового класса
        int lastIndexOfClass = zoo.getAnimalType().size() - 1;
        String lastIdOfClass = zoo.getAnimalType().get(lastIndexOfClass).getIdType();
        int idNewClass = newId(lastIdOfClass) + 1;
        System.out.println(idNewClass + ". Создать новый класс");
        System.out.println("0. Выйти назад");

        // Выбор номера пункта
        int answ = answer();

        // Добавление в существующий класс или создание нового
        if (answ != 0) {
            answ = answ - 1;
            if (answ >= 0 && answ <= lastIndexOfClass) {
                System.out.println("Выбран класс: "
                                   + zoo
                                           .getAnimalType()
                                           .get(answ)
                                           .getType());

            } else if (answ == idNewClass - 1) {
                System.out.println("Введите название нового класса:");
                newAnimalClass(zoo);
            } else {
                System.out.println("Такого пункта нет\n");
                answer_02_02(zoo);
            }

            // Получение последнего Id выбранного вида
            int sizeOfArrayAnimals = zoo
                    .getAnimalType()
                    .get(answ)
                    .getArrayAnimals()
                    .size();

            String lastIdOfType = "0";

            if (sizeOfArrayAnimals == 0) {
                lastIdOfType = zoo
                                       .getAnimalType()
                                       .get(answ)
                                       .getIdType() + "-0";
            } else {
                lastIdOfType = zoo
                        .getAnimalType()
                        .get(answ)
                        .getArrayAnimals()
                        .get(zoo
                                     .getAnimalType()
                                     .get(answ)
                                     .getArrayAnimals()
                                     .size() - 1)
                        .getIdSubType();
            }

            // Название нового вида животных
            System.out.println("В данном классе есть следующие виды:");
            ArrayAnimals.printSubType(zoo, answ);

            System.out.println("Введите название нового вида:");

            boolean flag = true;
            String nameOfType = "";
            while (flag) {
                nameOfType = capitalize(removeSpaces(answerString()));

                //Проверка на ввод пустой строки
                // и наличие данного названия класса в реестре
                if (removeSpaces(nameOfType).equals("")) {
                    System.out.println("Введена пустая строка");
                } else {
                    int count = 0;
                    for (ArrayAnimals arrayAnimals : zoo.getAnimalType().get(answ).getArrayAnimals()) {
                        if (arrayAnimals.getSubType().equals(nameOfType)){
                            System.out.println("Такой вид уже существует");
                            count +=1;
                        }
                    }
                    if (count == 0) {
                        flag = false;
                    }
                }

            }
            // Создание id нового вида
            String newIdSubType = newIdString(lastIdOfType);

            // Присвоение id новому виду
            zoo.getAnimalType()
                    .get(answ)
                    .getArrayAnimals()
                    .add(new ArrayAnimals(nameOfType, newIdSubType, new ArrayList<>()));

            // Вывод класса с новым видом животного
            System.out.println();
            System.out.println("Теперь в классе следующие виды животных:");
            ArrayAnimals.printSubType(zoo, answ);
        }
    }


    /**
     * Добавление нового животного в реестр
     *
     * @param zoo реестр животных
     */
    public static void answer_02_03(Zoo zoo) {
        System.out.println("В какой вид добавить животное?");
        System.out.println("--------");
        subTypeOfAnimals(zoo);
        System.out.println("--------");
        System.out.println("Для выхода в предыдущее меню" +
                           " введите \"0\"");
        boolean flag = true;
        while (flag) {
            System.out.println("Введите название вида");
            String answer = answerString().toLowerCase();
            if (answer.equals("0")) {
                flag = false;
            }
            for (AnimalType animalType : zoo.getAnimalType()) {
                if (flag) {
                    for (ArrayAnimals arrAn : animalType.getArrayAnimals()) {
                        if (arrAn.getSubType().toLowerCase().equals(answer)) {

                            // Получение последнего Id выбранного вида
                            String lastIdOfType = "0";
                            int sizeOfArrayAnimals = arrAn.getAnimal().size();
                            if (sizeOfArrayAnimals == 0) {
                                lastIdOfType = arrAn.getIdSubType() + "-0";
                            } else {
                                lastIdOfType = arrAn
                                        .getAnimal()
                                        .get(sizeOfArrayAnimals - 1)
                                        .getId();
                            }

                            // Создание id нового животного
                            String newIdAnimal = newIdString(lastIdOfType);

                            // Создание имени нового животного
                            System.out.println("Введите имя нового животного:");
                            String nickname = capitalize(removeSpaces(answerString()));

                            // Создание команд нового животного
                            String commands = newCommand();

                            // Создание дня рождения нового животного
                            String birthday = newBirthday();

                            Animal newAnimal = new Animal(newIdAnimal, nickname, commands, birthday);
                            arrAn.getAnimal().add(newAnimal);

                            flag = false;
                        }
                    }
                }
            }
            if (flag) {
                System.out.println("Такого вида нет");
            }
        }
    }
}
