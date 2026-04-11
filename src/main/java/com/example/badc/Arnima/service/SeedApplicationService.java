package com.example.badc.Arnima.service;

import com.example.badc.model.SeedApplication;
import java.io.*;
import java.util.ArrayList;

public class SeedApplicationService {
    private String filename = "data/seed_apps.bin";

    public boolean save(SeedApplication app) {
        try {
            ArrayList<SeedApplication> list = getAll();
            list.add(app);
            File d = new File("data");
            if(!d.exists()) d.mkdir();
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
            for(SeedApplication sa : list) {
                oos.writeObject(sa);
            }
            oos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public SeedApplication findByNidOrId(String input) {
        try {
            ArrayList<SeedApplication> list = getAll();
            for(int i = 0; i < list.size(); i++) {
                SeedApplication s = list.get(i);
                if(s.getAppId().equals(input) || s.getNid().equals(input)) {
                    return s;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<SeedApplication> getAll() {
        ArrayList<SeedApplication> list = new ArrayList<SeedApplication>();
        try {
            File f = new File(filename);
            if(!f.exists()) return list;
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
            while(true) {
                try {
                    SeedApplication s = (SeedApplication) ois.readObject();
                    list.add(s);
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
