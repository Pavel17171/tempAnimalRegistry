package org.example.Control;

import org.example.Model.StructureZoo.Zoo;

import static org.example.Control.Answer_01.answer_01;
import static org.example.Control.Answer_02.addNewAnimal;
import static org.example.Control.Methods.*;
import static org.example.Model.Parser.ReadFile.readFile;

public class Control {
    public static void main(String[] args) {

        Zoo zoo = readFile("DB_Task_13-15.json");
//        Scanner scanner = new Scanner(System.in);

        // Запуск программы
        start(zoo);

    }

    public static void start(Zoo zoo) {
        boolean flag = true;
        while (flag) {
            System.out.println("""
                    Введите команду:
                    1 - показать реестр животных
                    2 - добавить новое животное
                    3 - редактировать данные о животном
                    4 - удалить данные о животном из реестра
                    0 - выход
                    """);
            switch (answer()) {
                case 0 -> {
                    System.out.println("EXIT");
                    flag = false;
                }
                case 1 -> answer_01(zoo);
                case 2 -> {
                    System.out.println("Добавить новое животное");
                    addNewAnimal(zoo);
                }
                case 3 -> {
                    System.out.println("Редактировать животное");
                    Answer_03.editAnimal(zoo);
                }
                case 4 -> {
                    System.out.println("Удалить животное");
                    Answer_04.deleteInformation(zoo);
                }
                case 9 -> System.out.println("Menu");
                default -> System.out.println("Команда не распознана");
            }
        }
    }

}

