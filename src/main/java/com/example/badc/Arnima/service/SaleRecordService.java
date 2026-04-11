package com.example.badc.Arnima.service;

import com.example.badc.model.SaleRecord;
import java.io.*;
import java.util.ArrayList;

public class SaleRecordService {
    private String filename = "data/sale_records.bin";

    public boolean save(SaleRecord sale) {
        try {
            ArrayList<SaleRecord> list = getAll();
            list.add(sale);
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
            return false;
        }
    }

    public ArrayList<SaleRecord> getByDealerNid(String nid) {
        ArrayList<SaleRecord> res = new ArrayList<SaleRecord>();
        try {
            ArrayList<SaleRecord> all = getAll();
            for (int i = 0; i < all.size(); i++) {
                if (all.get(i).getDealerNid().equals(nid)) {
                    res.add(all.get(i));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public ArrayList<SaleRecord> getAll() {
        ArrayList<SaleRecord> list = new ArrayList<SaleRecord>();
        try {
            File f = new File(filename);
            if (!f.exists()) return list;
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
            while (true) {
                try {
                    SaleRecord s = (SaleRecord) ois.readObject();
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

    public double getTotalCommission(String dealerNid) {
        double t = 0;
        try {
            ArrayList<SaleRecord> all = getAll();
            for (int i = 0; i < all.size(); i++) {
                if (all.get(i).getDealerNid().equals(dealerNid)) {
                    t += all.get(i).getCommission();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    public ArrayList<SaleRecord> getByDealerNidAndMonth(String nid, String month) {
        ArrayList<SaleRecord> res = new ArrayList<SaleRecord>();
        try {
            ArrayList<SaleRecord> all = getAll();
            for (int i = 0; i < all.size(); i++) {
                if (all.get(i).getDealerNid().equals(nid) && all.get(i).getSaleDate().startsWith(month)) {
                    res.add(all.get(i));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
