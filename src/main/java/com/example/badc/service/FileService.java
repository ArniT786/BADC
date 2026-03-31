package com.example.badc.service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    public static final String DATA_DIR = "data/";

    public static void ensureDataDir() {
        new File(DATA_DIR).mkdirs();
    }

    public static <T> void saveList(String filename, List<T> list) {
        ensureDataDir();
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(DATA_DIR + filename))) {
            oos.writeObject(list);
        } catch (IOException e) {
            System.err.println("Error saving file: " + filename);
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> List<T> loadList(String filename) {
        File file = new File(DATA_DIR + filename);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(file))) {
            return (List<T>) ois.readObject();
        } catch (Exception e) {
            System.err.println("Error loading file: " + filename);
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static <T> void appendObject(String filename, T obj) {
        List<T> list = loadList(filename);
        list.add(obj);
        saveList(filename, list);
    }
}
