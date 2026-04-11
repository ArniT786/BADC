package com.example.badc.Arnima.service;

import com.example.badc.model.Feedback;
import java.io.*;
import java.util.ArrayList;

public class FeedbackService {
    private String filename = "data/feedback.bin";

    public boolean save(Feedback fb) {
        try {
            ArrayList<Feedback> list = getAll();
            list.add(fb);
            File d = new File("data");
            if(!d.exists()) d.mkdir();
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
            for(Feedback f : list) {
                oos.writeObject(f);
            }
            oos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Feedback> getAll() {
        ArrayList<Feedback> list = new ArrayList<Feedback>();
        try {
            File f = new File(filename);
            if(!f.exists()) return list;
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
            while(true) {
                try {
                    Feedback fb = (Feedback) ois.readObject();
                    list.add(fb);
                } catch (EOFException e) {
                    break;
                }
            }
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
