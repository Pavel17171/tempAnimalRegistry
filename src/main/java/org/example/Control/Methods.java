package org.example.Control;

import org.example.Model.StructureZoo.AnimalType;
import org.example.Model.StructureZoo.ArrayAnimals;
import org.example.Model.StructureZoo.SubArrayAnimal;
import org.example.Model.StructureZoo.Zoo;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static java.time.LocalTime.now;


public class Methods {


    //*************************
    //*************************
    //** Используемые методы **
    //*************************
    //*************************




    //************************************
    //* Получение данных от пользователя *
    //************************************




    /**
     * Получение целочисленого значения от пользователя
     *
     * @return возвращает целое число int
     */
    public static Integer answer() {
        int result = -99999;
        try {
            Scanner sc = new Scanner(System.in);
            result = sc.nextInt();
        } catch (InputMismatchException e) {
            //} catch (Exception e) {
            System.out.println("Команда не известна");
            answer();
        }
        return result;
    }


    /**
     * Получение текстового ответа от пользователя
     *
     * @return возвращает текст String
     */
    public static String answerString() {
        String text = "";
        try {
            Scanner sc = new Scanner(System.in);
            text = sc.nextLine();
            //} catch (InputMismatchException e) {
        } catch (Exception e) {
            System.out.println("Команда не известна");
            answerString();
        }
        return text;
    }




    //********************
    //* Вывод информации *
    //********************




    /**
     * Показывает список классов животных
     *
     * @param zoo реестр животных
     */
    public static void classOfAnimals(Zoo zoo) {
        for (AnimalType animalType : zoo.getAnimalType()) {
            System.out.println(animalType.getIdType()
                               + ". "
                               + animalType.getType());
        }
    }


    /**
     * Показывает список видов животных
     *
     * @param zoo реестр животных
     */
    public static void subTypeOfAnimals(Zoo zoo) {
        for (AnimalType animalType : zoo.getAnimalType()) {
            System.out.println(animalType.getIdType()
                               + ". "
                               + animalType.getType()
                               + ":");
            for (ArrayAnimals arrayAnimals : animalType.getArrayAnimals()) {
                System.out.println("  " + arrayAnimals.getIdSubType()
                                   + ". "
                                   + arrayAnimals.getSubType());
            }
        }
    }




    //******************
    //* Возврат данных *
    //******************






    /**
     * Ответ на вопрос да/нет
     * @return true - если "да" / false - если "нет"
     */
    public static boolean yesOrNo() {
        boolean flag = true;
        boolean flagYesOrNo = false;
        System.out.println("1. Да\n"
                           + "2. Нет");
        String[] yes = {"1", "да", "yes"};
        String[] no = {"2", "нет", "no"};
        while (flag) {
            String yesOrNo = answerString().toLowerCase();
            if (enteringTheList(yesOrNo, yes)) {
                flag = false;
                flagYesOrNo = true;
            } else if (enteringTheList(yesOrNo, no)) {
                flag = false;
            } else {
                System.out.println("Команда не распознана");
            }
        }
        return flagYesOrNo;
    }

    /**
     * Выбор определенного класса животных
     * @param zoo реестр животных
     * @return возвращает выбранный класс
     */
    public static AnimalType getAnimalSomeType (Zoo zoo) {
        System.out.println("Какой класс показать? Введите номер:");
        classOfAnimals(zoo);
        int len = zoo.getAnimalType().size();
        int id = answer();
        while (id < 1 || id > len) {
            System.out.println("Нет такого класса. Попробуйте еще раз.");
            id = answer();
        }
        return zoo.getAnimalType().get(id - 1);
    }


    /**
     * Возвращает список животных определенного вида
     * @param zoo реестр животных
     * @return список животных определенного вида (ArrayAnimals)
     */
    public static ArrayAnimals getAnimalSomeSub(Zoo zoo) {
        System.out.println("Какаой вид показать? Введите название:");
        System.out.println("--------");
        subTypeOfAnimals(zoo);
        System.out.println("--------");
        boolean flag = true;
        while (flag) {
            String answer = answerString().toLowerCase();
            for (AnimalType animalType : zoo.getAnimalType()) {
                for (ArrayAnimals arrAn : animalType.getArrayAnimals()) {
                    if (((arrAn.getSubType()).toLowerCase()).equals(answer)) {
                        return arrAn;
                    }
                }
            }
            System.out.println("Такой вид не найден\n" +
                               "Попробовать еще раз?");
            if (!yesOrNo()) {
                flag = false;
            }
        }
        return new ArrayAnimals();
    }


    /**
     * Метод проверки вхождения текста в список
     *
     * @param input какой текст надо найти
     * @param list  список, где искать
     * @return результат true если найдено, иначе false
     */
    public static boolean enteringTheList(String input, String[] list) {
        for (String element : list) {
            if (input.equals(element)) {
                return true;
            }
        }
        return false;
    }


    /**
     * Делает первую букву строки заглавной,
     * остальные прописными
     *
     * @param text строка для редактирования
     * @return возвращает обработанную строку
     */
    public static String capitalize(String text) {
        if (text.length() == 1) {
            text = text.toUpperCase();
        } else if (text.length() > 1) {
            text = text.substring(0, 1).toUpperCase()
                   + text.substring(1).toLowerCase();
        }
        return text;
    }


    /**
     * Удаление лишних пробелов в строке
     *
     * @param text текст для обработки
     * @return обработанный текст
     */
    public static String removeSpaces(String text) {
        text = text.trim();
        text = text.replaceAll("\\s+", " ");
        return text;
    }


    /**
     * Преобразует строку в список чисел
     *
     * @param id id в формате строки
     * @return список чисел из строки
     */
    public static List<Integer> idList(String id) {
        List<String> numberString = Arrays.asList(id.split("-"));
        return numberString
                .stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }


    /**
     * Преобразует строку в список чисел
     *
     * @param id id в формате строки
     * @return список чисел из строки
     */
    public static Integer newId(String id) {
        List<String> numberString = Arrays.asList(id.split("-"));
        return Integer
                .parseInt(numberString
                        .get(numberString
                                     .size() - 1));
    }


    /**
     * Увеличивает id на 1
     *
     * @param id последний существующий id
     *           в формате String
     * @return новый id в формате String
     */
    public static String newIdString(String id) {
        List<Integer> listId = idList(id);
        String newIdSubType = "";
        for (int i = 0; i < listId.size() - 1; i++) {
            newIdSubType += listId.get(i) + "-";
        }
        newIdSubType += newId(id) + 1;
        return newIdSubType;
    }


    /**
     * Создание дня рождения животного
     *
     * @return день рождения в формате String гггг-мм-дд
     */
    public static String newBirthday() {
        String bithday = "";

        //Текущая дата
        LocalDate localDate = LocalDate.now();
        int currentYear = localDate.getYear();
        int currentMonth = localDate.getMonthValue();
        int currentDay = localDate.getDayOfMonth();

        //Ввод года рождения
        System.out.println("Введите год рождения:");
        int year = answer();
        while (year > currentYear) {
            System.out.println("Год рождения не может быть "
                               + "больше текущего \n"
                               + "(сейчас "
                               + currentYear
                               + " год)");
            ;
            year = answer();
        }
        bithday += year + "-";

        //Ввод месяца рождения
        System.out.println("Введите месяц рождения (номер от 1 до 12)");
        int month = answer();
        while ((month < 1 || month > 12) || (year == currentYear && month > currentMonth)) {
            System.out.println("Введен не корректный номер месяца");
            System.out.println("Повторите попытку");
            month = answer();
        }
        if (month < 10) {
            bithday += "0" + month + "-";
            ;
        } else {
            bithday += month + "-";
        }

        //Ввод дня рождения
        System.out.println("Введите день рождения");
        int day = answer();
        while (day < 1
               || !testDay(year, month, day)
               || (year == currentYear
                   && month == currentMonth
                   && day > currentDay)) {
            System.out.println("Введен не корректный день");
            System.out.println("Повторите попытку");
            day = answer();
        }
        if (day < 10) {
            bithday += "0" + day;
        } else {
            bithday += day;
        }
        return bithday;
    }


    /**
     * Проверка корректности введенного дня месяца
     *
     * @param year  год (в формате int)
     * @param month месяц (в формате int)
     * @param day   день (в формате int)
     * @return возвращает true, если введеный день есть в данном месяце
     */
    public static Boolean testDay(int year, int month, int day) {
        boolean flag = false;
        if (month >= 1 && month <= 12 && day >= 1) {
            boolean leapYear = (year % 4 == 0 && year % 100 != 0 || year % 400 == 0);
            Integer[][] listOfMonths = new Integer[][]{{1, 3, 5, 7, 8, 10, 12}, {4, 6, 9, 11}};
            if (Arrays.asList(listOfMonths[0]).contains(month)) {
                if (day <= 31) {
                    flag = true;
                } else {
                    System.out.println("В указанном месяце 31 день");
                }
            } else if (Arrays.asList(listOfMonths[1]).contains(month)) {
                if (day <= 30) {
                    flag = true;
                } else {
                    System.out.println("В указанном месяце 30 дней");
                }
            } else {
                if (leapYear) {
                    if (day <= 29) {
                        flag = true;
                    } else {
                        System.out.println("В указанном месяце 29 дней");
                    }
                } else {
                    if (day <= 28) {
                        flag = true;
                    } else {
                        System.out.println("В указанном месяце 28 дней");
                    }
                }
            }
        }
        return flag;
    }


    /**
     * Возвращает список всех животных по порядку
     * @param zoo реестр животных
     * @return список животных по порядку
     */
    public static List<SubArrayAnimal> getListOfAllAnimalsInZoo(Zoo zoo) {
        List<SubArrayAnimal> listOfAnimal = new ArrayList<>();
        for (AnimalType animalType : zoo.getAnimalType()) {
            System.out.println("\n    " + animalType.getType());
            for (ArrayAnimals arrayAnimals : animalType.getArrayAnimals()) {
                System.out.println("  " + arrayAnimals.getSubType());
                listOfAnimal.addAll(getListOfAnimals(listOfAnimal.size(), arrayAnimals));
            }
        }
        return listOfAnimal;
    }


    /**
     * Возвращает список животных определенного класса по порядку
     * @param zoo реестр животных
     * @return список животных класса по порядку
     */
    public static List<SubArrayAnimal> getListOfAnimalsInSomeClass(Zoo zoo) {
        List<SubArrayAnimal> listOfAnimal = new ArrayList<>();
        for (ArrayAnimals arrayAnimals : getAnimalSomeType(zoo).getArrayAnimals()) {
            System.out.println("  " + arrayAnimals.getSubType());
            listOfAnimal.addAll(getListOfAnimals(listOfAnimal.size(), arrayAnimals));
        }
        return listOfAnimal;
    }


    /**
     * Возвращает список животных определенного вида по порядку
     * @param zoo реестр животных
     * @return список животных вида по порядку
     */
    public static List<SubArrayAnimal> getListOfAnimalsInSomeSub(Zoo zoo){
        ArrayAnimals arrayAnimals = getAnimalSomeSub(zoo);
        return new ArrayList<>(getListOfAnimals(0, arrayAnimals));
    }


    /**
     * Возвращает спикок животных и выводит с порядковым номером
     * @param count начальный номер животного -1
     * @param arrayAnimals список животных одного вида
     * @return список животных вида с порядковыми номерами
     */
    public static List<SubArrayAnimal> getListOfAnimals (int count, ArrayAnimals arrayAnimals) {
        List<SubArrayAnimal> listOfAnimals = new ArrayList<>();
        for (SubArrayAnimal animal : arrayAnimals.getSubArrayAnimals()) {
            listOfAnimals.add(animal);
            System.out.println(++count + ". " + animal);
        }
        return listOfAnimals;
    }



    //***********************************************************
    //* Работа с информацией о животном (добавление / удаление) *
    //***********************************************************



    /**
     * Добавление нового класса животных
     *
     * @param zoo реестр животных
     */
    public static void newAnimalClass(Zoo zoo) {
        int id = 1;
        for (AnimalType animType : zoo.getAnimalType()) {
            if (id == newId(animType.getIdType())) {
                id++;
            }
        }
        String idString = Integer.toString(id);
        boolean flag = true;
        String text = "";
        while (flag) {
            text = capitalize(removeSpaces(answerString()));

            //Проверка на ввод пустой строки
            // и наличие данного названия класса в реестре
            if (removeSpaces(text).equals("")) {
                System.out.println("Введена пустая строка");
            } else {
                int count = 0;
                for (AnimalType animalType : zoo.getAnimalType()) {
                    if (animalType.getType().equals(text)) {
                        System.out.println("Такой класс уже существует");
                        count += 1;
                    }
                }
                if (count == 0) {
                    flag = false;
                }
            }
        }

        List<ArrayAnimals> listOfAnimals = new ArrayList<>();
        AnimalType newAT = new AnimalType(text, idString, listOfAnimals);
        zoo.getAnimalType().add(newAT);
    }


    /**
     * Нахождение и редактирование животного по его ID или имени
     * @param zoo реестр животных
     */
    public static void editAnAnimalByNicknameOrID(Zoo zoo) {
        boolean flag = true;
        while (flag) {
            int count = 0;
            System.out.println("Введите имя животного или его ID");
            String answer = answerString().toLowerCase();
            for (AnimalType animalType : zoo.getAnimalType()) {
                for (ArrayAnimals arrayAnimals : animalType.getArrayAnimals()) {
                    for (SubArrayAnimal animal : arrayAnimals.getSubArrayAnimals()) {
                        if (((animal.getNickname()).toLowerCase()).equals(answer)
                            || (animal.getId().toLowerCase()).equals(answer)) {
                            System.out.println(animal);
                            System.out.println("Редактировать данное животное?");
                            if (yesOrNo()) {
                                editAnimal(animal);
                            }
                            count += 1;
                        }
                    }
                }
            }
            if (count > 0) {
                flag = false;
            } else {
                System.out.println("Такое животное не найдено");
                System.out.println("Повторить попытку?");
                flag = yesOrNo();
            }
        }
        System.out.println("Для выхода в предыдущее меню нажмите 0");
    }


    /**
     * Редактирование животного
     * @param animal выбранное животное
     */
    public static void editAnimal(SubArrayAnimal animal) {
        boolean flag = true;
        while (flag) {
            System.out.println("""
                    Редактировать параметры животного:
                    1. Имя
                    2. День рождения
                    3. Команды
                    0. Завершить редактирование
                    """);
            switch (answer()) {
                case 0 -> {
                    flag = false;
                }
                case 1 -> {
                    System.out.println("Введите новое имя:");
                    animal.setNickname(capitalize(removeSpaces(answerString())));
                }
                case 2 -> {
                    System.out.println("Дата рождения");
                    animal.setBirthday(newBirthday());
                }
                case 3 -> {
                    animal.setCommand(editCommand(animal.getCommand()));
                }
                default -> {
                    System.out.println("Команда не распознана");
                }
            }
        }
    }


    /**
     * Добавление новых команд животного
     *
     * @return возвращает команды в формате String
     */
    public static String newCommand() {
        boolean flag = true;
        String commands = "";
        while (flag) {
            System.out.println("Введите команду животного");
            commands += answerString().toLowerCase();
            System.out.println("Добавить команду?");
            flag = yesOrNo();
            if (flag) {
                commands += ", ";
            }
        }
        return commands;
    }


    /**
     * Редактирование команд животного
     *
     * @param command исходные команды
     * @return новые команды в формате String
     */
    public static String editCommand(String command) {
        boolean flagCase3 = true;

        List<String> arrayOfCommands = new ArrayList<>(List.of(command.split(", ")));
        while (flagCase3) {
            System.out.println("Какую команду редактировать (введите номер)?");
            int count = 0;
            for (String text : arrayOfCommands) {
                System.out.println(++count + ". " + text);
            }
            System.out.println("--------------------------");
            System.out.println(++count + ". Добавить новую команду");
            System.out.println("0. Выход в предыдущее меню");
            int answ = answer() - 1;
            if (answ >= 0 && answ < count - 1) {
                System.out.println("Введите новую команду:");
                arrayOfCommands.set(answ, capitalize(removeSpaces(answerString())));
            } else if (answ == -1) {
                flagCase3 = false;
            } else if (answ == count - 1) {
                System.out.println("Введите новую команду:");
                arrayOfCommands.add(capitalize(removeSpaces(answerString())));
            } else {
                System.out.println("Команда не распознана");
            }
        }
        return String.join(", ", arrayOfCommands);
    }


    /**
     * Редактирование животного в списке
     * @param listOfAnimals список животных
     */
    public static void editAnimalInList (List<SubArrayAnimal> listOfAnimals) {
        boolean flag = true;
        while (flag) {
            System.out.println("\nВведите порядковый номер животного для редактирования:");
            int answ = answer() - 1;
            if (answ == -1) {
                flag = false;
            } else if (answ >= 0 && answ < listOfAnimals.size()) {
                editAnimal(listOfAnimals.get(answ));
                System.out.println("Выбрать другое животное?");
                if (!yesOrNo()) {
                    flag = false;
                }
            } else {
                System.out.println("Нет животного под таким номером");
            }
        }
    }



    public static void delAnimal (ArrayAnimals arrayAnimals, int index) {
        System.out.println(arrayAnimals);
        System.out.println("-----------");
        arrayAnimals.getSubArrayAnimals().remove(index);
        System.out.println("-----------");
        System.out.println(arrayAnimals);
    }

}



