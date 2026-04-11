package com.example.badc.Arnima.service;

import com.example.badc.model.Notice;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class NoticeService {
    private String filename = "data/notices.bin";

    public void initDummyNotices() {
        try {
            File f = new File(filename);
            if (f.exists()) return;
            ArrayList<Notice> list = new ArrayList<Notice>();
            list.add(new Notice("NOT001","Seed Price Update","2025-11-01","Price","Rice seed price increased by 5% from December 2025. All dealers must update their pricing accordingly."));
            list.add(new Notice("NOT002","New Subsidy Policy","2025-11-10","Policy","BADC announces new subsidy for wheat seed distribution. Eligible dealers will receive 10% discount on bulk orders."));
            list.add(new Notice("NOT003","Distribution Schedule Change","2025-11-15","Schedule","December distribution schedule has been revised. Please check the updated dates at your nearest BADC office."));
            list.add(new Notice("NOT004","Quality Check Reminder","2025-11-20","Reminder","All dealers must conduct quality checks on received seed batches before distribution to farmers."));
            File d = new File("data");
            if (!d.exists()) d.mkdir();
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
            for (int i = 0; i < list.size(); i++) {
                oos.writeObject(list.get(i));
            }
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Notice> getAll() {
        ArrayList<Notice> list = new ArrayList<Notice>();
        try {
            File f = new File(filename);
            if (!f.exists()) return list;
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
            while (true) {
                try {
                    Notice r = (Notice) ois.readObject();
                    list.add(r);
                } catch (EOFException e) {
                    break;
                }
            }
            ois.close();
            Collections.sort(list, new Comparator<Notice>() {
                @Override
                public int compare(Notice n1, Notice n2) {
                    return n2.getDate().compareTo(n1.getDate());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Notice findById(String id) {
        try {
            ArrayList<Notice> list = getAll();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getNoticeId().equals(id)) {
                    return list.get(i);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
