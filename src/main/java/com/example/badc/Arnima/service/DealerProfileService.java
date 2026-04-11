package com.example.badc.Arnima.service;

import com.example.badc.model.DealerProfile;
import java.io.*;
import java.util.ArrayList;

public class DealerProfileService {
    private String filename = "data/dealers.bin";

    public void initDummyProfiles() {
        try {
            File f = new File(filename);
            if (f.exists()) return;
            ArrayList<DealerProfile> list = new ArrayList<DealerProfile>();
            list.add(new DealerProfile("DP001","1234567890","Rahim Seed Store","Mirpur, Dhaka","01711111111"));
            list.add(new DealerProfile("DP002","0987654321","Karim Agro Shop","Rajshahi Sadar","01722222222"));
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

    public DealerProfile findByNid(String nid) {
        try {
            ArrayList<DealerProfile> list = getAll();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getDealerNid().equals(nid)) {
                    return list.get(i);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateProfile(DealerProfile updated) {
        try {
            ArrayList<DealerProfile> list = getAll();
            boolean found = false;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getDealerNid().equals(updated.getDealerNid())) {
                    list.set(i, updated);
                    found = true;
                }
            }
            if (found) {
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
                for (int i = 0; i < list.size(); i++) {
                    oos.writeObject(list.get(i));
                }
                oos.close();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean save(DealerProfile profile) {
        try {
            ArrayList<DealerProfile> list = getAll();
            list.add(profile);
            File d = new File("data");
            if (!d.exists()) d.mkdir();
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
            for (int i = 0; i < list.size(); i++) {
                oos.writeObject(list.get(i));
            }
            oos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<DealerProfile> getAll() {
        ArrayList<DealerProfile> list = new ArrayList<DealerProfile>();
        try {
            File f = new File(filename);
            if (!f.exists()) return list;
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
            while (true) {
                try {
                    DealerProfile p = (DealerProfile) ois.readObject();
                    list.add(p);
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
