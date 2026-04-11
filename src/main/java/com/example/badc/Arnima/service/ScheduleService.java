package com.example.badc.Arnima.service;

import com.example.badc.model.Schedule;
import java.io.*;
import java.util.ArrayList;

public class ScheduleService {
    private String filename = "data/schedules.bin";

    public void initDummySchedules() {
        try {
            File f = new File(filename);
            if(f.exists()) return;
            
            ArrayList<Schedule> list = new ArrayList<Schedule>();
            list.add(new Schedule("SCH001","Dhaka","2025-12-10","Mirpur BADC Office","Rice Seed"));
            list.add(new Schedule("SCH002","Dhaka","2025-12-15","Uttara Distribution Point","Wheat Seed"));
            list.add(new Schedule("SCH003","Rajshahi","2025-12-11","Rajshahi HQ","Jute Seed"));
            list.add(new Schedule("SCH004","Rajshahi","2025-12-18","Natore Center","Rice Seed"));
            list.add(new Schedule("SCH005","Chittagong","2025-12-12","Agrabad Office","Maize Seed"));
            list.add(new Schedule("SCH006","Sylhet","2025-12-20","Sylhet BADC","Wheat Seed"));
            
            File d = new File("data");
            if(!d.exists()) d.mkdir();
            
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
            for(Schedule s : list) {
                oos.writeObject(s);
            }
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Schedule> getByDistrict(String d) {
        ArrayList<Schedule> filtered = new ArrayList<Schedule>();
        try {
            ArrayList<Schedule> all = getAll();
            for(int i = 0; i < all.size(); i++) {
                Schedule s = all.get(i);
                if(s.getDistrict().equalsIgnoreCase(d)) {
                    filtered.add(s);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filtered;
    }

    public ArrayList<Schedule> getAll() {
        ArrayList<Schedule> list = new ArrayList<Schedule>();
        try {
            File f = new File(filename);
            if(!f.exists()) return list;
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
            while(true) {
                try {
                    Schedule s = (Schedule) ois.readObject();
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
