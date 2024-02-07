package org.example.Model.Parser;

import com.google.gson.Gson;
import org.example.Model.StructureZoo.Zoo;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class ReadFile {



    /**
     * Чтение файла с реестром в формате ".json"
     * @param fileName имя файла
     * @return возвращает реестр для работы с ним
     */
    public static Zoo readFile(String fileName) {
        String dirWithJSON = "./src/main/java/org/example/DB/";
        String fullFileName = dirWithJSON + fileName;
        File file = new File(fullFileName);
            if (!file.exists()) {
                try {
                    Files.createFile(Paths.get(fullFileName));
                    System.out.println("JSON файл создан.");
                } catch (IOException e) {
                    System.out.println("Ошибка при создании файла: " + e.getMessage());
                }
            } else {
                System.out.println("Файл реестра загружен.");
                Gson gson = new Gson();
                try (FileReader reader = new FileReader(dirWithJSON + "DB_Task_13-15.json")) {
                    System.out.println();
                    // Парсинг JSON в объект Java
                    return gson.fromJson(reader, Zoo.class);

                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
            return new Zoo();
    }
}
