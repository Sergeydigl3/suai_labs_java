package ru.labs.lab07.osnova;

import ru.labs.lab07.osnova.Settings;

import java.io.IOException;

public class TestSaveBin {
    public static void main(String[] args) {
        // Test for Settings
        Settings settings = new Settings();
        settings.put("key1", 1);
        settings.put("key2", 2);
        try {
            settings.saveToBinaryFile("src/ru/labs/lab07/settings.bin");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
