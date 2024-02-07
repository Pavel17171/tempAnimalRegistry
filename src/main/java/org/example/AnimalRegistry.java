/* package org.example;

import org.w3c.dom.css.Counter;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class AnimalRegistry implements AutoCloseable {
    private List<Animal> animals;
    private Scanner scanner;

    public AnimalRegistry() {
        this.animals = new ArrayList<Animal>();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;
        try (Counter counter = new Counter()) {
            while (running) {
                System.out.println("Меню:");
                System.out.println("1. Завести новое животное");
                System.out.println("2. Определить животное в правильный класс");
                System.out.println("3. Увидеть список команд, которое выполняет животное");
                System.out.println("4. Обучить животное новым командам");
                System.out.println("5. Выйти");

                int choice = getChoice();
                switch (choice) {
                    case 1:
                        addAnimal();
                        counter.add();
                        break;
                    case 2:
                        classifyAnimal();
                        break;
                    case 3:
                        listCommands();
                        break;
                    case 4:
                        trainAnimal();
                        break;
                    case 5:
                        running = false;
                        break;
                    default:
                        System.out.println("Некорректный выбор.");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private int getChoice() {
        while (true) {
            try {
                System.out.print("Выберите опцию: ");
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Некорректный ввод. Пожалуйста, введите число.");
                scanner.nextLine(); // очистить буфер ввода
            }
        }
    }

    private void addAnimal() {
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();

        System.out.print("Введите вид животного: ");
        String species = scanner.nextLine();

        System.out.print("Введите возраст животного: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // очистить буфер ввода

        System.out.print("Введите команды, которые выполняет животное (через запятую): ");
        String commandsInput = scanner.nextLine();
        String[] commandsArray = commandsInput.split(",");

        Animal animal = new Animal(name, species, age);
        animal.setCommands(commandsArray);
        animals.add(animal);
        System.out.println("Животное успешно добавлено.");
    }

    private void classifyAnimal() {
        System.out.print("Введите индекс животного: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // очистить буфер ввода

        if (index >= 0 && index < animals.size()) {
            Animal animal = animals.get(index);
            String animalClass = animal.getClass().getSimpleName();
            System.out.println("Животное относится к классу: " + animalClass);
        } else {
            System.out.println("Некорректный индекс животного.");
        }
    }

    private void listCommands() {
        System.out.print("Введите индекс животного: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // очистить буфер ввода

        if (index >= 0 && index < animals.size()) {
            Animal animal = animals.get(index);
            String[] commands = animal.getCommands();
            System.out.println("Команды, которые выполняет животное:");
            for (String command : commands) {
                System.out.println("- " + command);
            }
        } else {
            System.out.println("Некорректный индекс животного.");
        }
    }

    private void trainAnimal() {
        System.out.print("Введите индекс животного: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // очистить буфер ввода

        if (index >= 0 && index < animals.size()) {
            Animal animal = animals.get(index);

            System.out.print("Введите новые команды для животного (через запятую): ");
            String commandsInput = scanner.nextLine();
            String[] commandsArray = commandsInput.split(",");

            animal.setCommands(commandsArray);
            System


 */