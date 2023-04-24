// Изменить класс Settings следующим образом. В качестве ключа в хэш таблице используется элемент class KeyPair { String group; String name; }
// Теперь можно хранить переменные с одинаковым именем, но в разных группах, например { "Menu": "color" } и  {"Button", "color"}. Измените соответсвующим образом все функции класса.
package ru.labs.lab07.dop;


import ru.labs.lab07.dop.NewSettings;

import java.io.IOException;

public class DopMain {
    public static void main(String[] args) {
        NewSettings settings = new NewSettings();

        // Test put and get methods
        settings.put("Group1", "Name1", 10);
        assert(settings.get("Group1", "Name1") == 10);

        // Test delete method
        settings.delete("Group1", "Name1");

        // Test load and save binary files
        try {
            settings.put("Group2", "Name2", 20);
            settings.saveToBinaryFile("settings.bin");
            settings.delete("Group2", "Name2");
            settings.loadFromBinaryFile("settings.bin");
            assert(settings.get("Group2", "Name2") == 20);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Test load and save text files
        try {
            settings.put("Group3", "Name3", 30);
            settings.saveToTextFile("settings.txt");
            settings.delete("Group3", "Name3");
            settings.loadFromTextFile("settings.txt");
            assert(settings.get("Group3", "Name3") == 30);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Test toString and equals methods
        NewSettings settingsCopy = new NewSettings();
        settingsCopy.put("Group2", "Name2", 20);
        settingsCopy.put("Group3", "Name3", 30);
        assert(settings.toString().equals(settingsCopy.toString()));
        assert(settings.equals(settingsCopy));

        try {
            settingsCopy.saveToBinaryFile("test.bin");
            settingsCopy.saveToTextFile("test.txt");
        } catch (IOException e){
            e.printStackTrace();
        }

        NewSettings openedBinSettings = new NewSettings();
        NewSettings openedTxtSettings = new NewSettings();
        try {
            openedTxtSettings.loadFromTextFile("test.txt");
            openedBinSettings.loadFromBinaryFile("test.bin");

        } catch (IOException e){
            e.printStackTrace();
        }

        System.out.println(openedTxtSettings);
        System.out.println(openedBinSettings);
    }
}
