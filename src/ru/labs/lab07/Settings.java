package ru.labs.lab07;

//Реализуйте класс для хранения настроек Settings, в котором хранятся пары «имя параметра, значение». «Имя параметра» задается строкой, а «значение» целым числом.
//        Реализация должна использовать класс HashMap. В классе Settings должны быть определены:
//        toString() и equals()
//        put(String, int)
//        int get(String)
//        delete(String)
//        loadFromBinaryFile(String filename)
//        saveToBinaryFile(String filename)
//        loadFromTextFile(String filename)
//        saveToTextFile(String filename)

import java.io.*;
import java.util.HashMap;

public class Settings {
    HashMap<String, Integer> settingsMap = new HashMap<>();

    public void put(String key, int value) {
        settingsMap.put(key, value);
    }

    public int get(String key) {
        return settingsMap.get(key);
    }

    public void delete(String key) {
        settingsMap.remove(key);
    }

    public void loadFromBinaryFile(String filename) throws IOException {
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(filename))) {
            int size = dataInputStream.readInt();
            for (int i = 0; i < size; i++) {
                String key = dataInputStream.readUTF();
                int value = dataInputStream.readInt();
                settingsMap.put(key, value);
            }
        } catch (IOException e) {
            throw new IOException("Error while reading from file", e);
        }
    }

    public void saveToBinaryFile(String filename) throws IOException {
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(filename))) {
            dataOutputStream.writeInt(settingsMap.size());
            for (String key : settingsMap.keySet()) {
                dataOutputStream.writeUTF(key);
                dataOutputStream.writeInt(settingsMap.get(key));
            }
        } catch (IOException e) {
            throw new IOException("Error while writing to file", e);
        }
    }

    public void loadFromTextFile(String filename) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] keyValue = line.split(" ");
                settingsMap.put(keyValue[0], Integer.parseInt(keyValue[1]));
            }
        } catch (IOException e) {
            throw new IOException("Error while reading from file", e);
        }
    }

    public void saveToTextFile(String filename) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename))) {
            for (String key : settingsMap.keySet()) {
                bufferedWriter.write(key + " " + settingsMap.get(key));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new IOException("Error while writing to file", e);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String key : settingsMap.keySet()) {
            stringBuilder.append(key).append(" ").append(settingsMap.get(key)).append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        Settings settings = (Settings) obj;
        return settingsMap.equals(settings.settingsMap);
    }
}
