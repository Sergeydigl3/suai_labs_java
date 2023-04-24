package ru.labs.lab07.dop;

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
import java.util.Objects;

public class NewSettings {
    public static class KeyPair {
        private final String group;
        private final String name;

        public KeyPair(String group, String name) {
            this.group = group;
            this.name = name;
        }

        public String getGroup() {
            return group;
        }

        public String getName() {
            return name;
        }

        @Override
        public int hashCode() {
            return Objects.hash(group, name);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final KeyPair other = (KeyPair) obj;
            if (!Objects.equals(this.group, other.group)) {
                return false;
            }
            if (!Objects.equals(this.name, other.name)) {
                return false;
            }
            return true;
        }
    }


    HashMap<KeyPair, Integer> settingsMap = new HashMap<>();


    public void put(String group, String name, int value) {
        settingsMap.put(new KeyPair(group, name), value);
    }

    public int get(String group, String name) {
        return settingsMap.get(new KeyPair(group, name));
    }

    public void delete(String group, String name) {
        settingsMap.remove(new KeyPair(group, name));
    }


    public void loadFromBinaryFile(String filename) throws IOException {
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(filename))) {
            int size = dataInputStream.readInt();
            for (int i = 0; i < size; i++) {
                String group = dataInputStream.readUTF();
                String name = dataInputStream.readUTF();
                int value = dataInputStream.readInt();
                settingsMap.put(new KeyPair(group, name), value);
            }
        } catch (IOException e) {
            throw new IOException("Error while reading from file", e);
        }
    }

    public void saveToBinaryFile(String filename) throws IOException {
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(filename))) {
            dataOutputStream.writeInt(settingsMap.size());
            for (KeyPair key : settingsMap.keySet()) {
                dataOutputStream.writeUTF(key.getGroup());
                dataOutputStream.writeUTF(key.getName());
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
                if (keyValue.length != 3) {
                    throw new IOException("Invalid line format");
                }
                String group = keyValue[0];
                String name = keyValue[1];
                int value = Integer.parseInt(keyValue[2]);
                KeyPair key = new KeyPair(group, name);
                settingsMap.put(key, value);
            }
        } catch (IOException e) {
            throw new IOException("Error while reading from file", e);
        }
    }

    public void saveToTextFile(String filename) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename))) {
            for (KeyPair key : settingsMap.keySet()) {
                bufferedWriter.write(key.group + " " + key.name + " " + settingsMap.get(key));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new IOException("Error while writing to file", e);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (KeyPair key : settingsMap.keySet()) {
            stringBuilder.append(key.group).append(" ").append(key.name).append(" ").append(settingsMap.get(key)).append("\n");
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
        NewSettings settings = (NewSettings) obj;
        return settingsMap.equals(settings.settingsMap);
    }
}
