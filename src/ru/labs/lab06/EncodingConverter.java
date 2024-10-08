package ru.labs.lab06;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;

import java.io.*;

// As in formatted input
// Реализовать программу EncodingConverter для перекодирования текстовых файл из одной кодировки в другую. Программа должна получать параметры из командной строки и контролировать их корректность.
//
//Пример вызова: java EncodingConverter in.txt out.txt utf8 cp1251
public class EncodingConverter {
    public static void main(String[] args) {
        // check if args length is 4
        if (args.length != 4) {
            System.out.println("Invalid number of arguments");
            return;
        }

        // endswith analog
        if (!args[0].matches(".*\\.txt") || !args[1].matches(".*\\.txt")) {
            System.out.println("Invalid file path");
            return;
        }

        // Create a list of all encodings supported by the JVM, including aliases.
        String[] encodings = Charset.availableCharsets().keySet().toArray(new String[0]);
        ArrayList<String> charsets = new ArrayList<String>(Arrays.asList(encodings));
        for (String encoding : encodings) {
            charsets.addAll(Charset.availableCharsets().get(encoding).aliases());
        }

        // Check if args[2] and args[3] are valid encodings. Use the original
        // names for encodings (case-insensitive -> case-sensitive).
        for (int i = 2; i < 4; i++) {
            final int j = i;
            try {
                args[j] = charsets.stream().filter(charset -> charset.equalsIgnoreCase(args[j])).findFirst().get();
            } catch (Exception e) {
                System.out.println("Invalid encoding");
                return;
            }
        }

        try {
            convert(new File(args[0]), new File(args[1]), args[2], args[3]);
        } catch (IOException e) {
            System.out.println("Error while converting file");
        }
    }

    public static void convert(File source, File target, String fromEncoding, String toEncoding) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(source), fromEncoding));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(target), toEncoding));) {
            char[] buffer = new char[1024];
            int read;
            while ((read = br.read(buffer)) != -1) {
                bw.write(buffer, 0, read);
            }
        }
    }
}
