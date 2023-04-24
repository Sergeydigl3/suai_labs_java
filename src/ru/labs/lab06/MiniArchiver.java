package ru.labs.lab06;
// Create mini archival. The text file contains ints from 0,15. File contain even-numbered count of int.
// For archiving we need store two of int in one byte.
// When unpack - restore source file
// Elements in text split with ", "

import java.io.*;

public class MiniArchiver {
    // Class to compress and decompress text file
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Invalid number of arguments");
            return;
        }
//        if (!args[0].matches(".txt") || !args[1].matches(".txt")) {
//            System.out.println("Invalid file path");
//            return;
//        }
        if (!args[2].equals("compress") && !args[2].equals("decompress")) {
            System.out.println("Invalid operation");
            return;
        }
        if (args[2].equals("compress")) {
            compress(args[0], args[1]);
        } else {
            decompress(args[0], args[1]);
        }
    }

    public static void compress(String source, String dest) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(source));
             DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(dest))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] numbers = line.split(", ");
                for (int i = 0; i < numbers.length; i += 2) {
                    int first = Integer.parseInt(numbers[i]);
                    int second = Integer.parseInt(numbers[i + 1]);
                    byte b = (byte) ((first << 4) | second);
                    dataOutputStream.writeByte(b);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void decompress(String source, String dest) {
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(source));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(dest))) {
            while (dataInputStream.available() > 0) {
                byte b = dataInputStream.readByte();
                int first = (b & 0xF0) >>> 4;
                int second = b & 0x0F;
                bufferedWriter.write(first + ", " + second + ", ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // read values from text file with cli
}
