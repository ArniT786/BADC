package com.example.badc.Arnima.service;

import com.example.badc.model.StockRequest;
import java.io.*;
import java.util.ArrayList;

public class StockRequestService {
    private String filename = "data/stock_requests.bin";

    public boolean save(StockRequest req) {
        try {
            ArrayList<StockRequest> list = getAll();
            list.add(req);
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

    public ArrayList<StockRequest> getAll() {
        ArrayList<StockRequest> list = new ArrayList<StockRequest>();
        try {
            File f = new File(filename);
            if (!f.exists()) return list;
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
            while (true) {
                try {
                    StockRequest r = (StockRequest) ois.readObject();
                    list.add(r);
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

    public StockRequest findByDealerNid(String nid) {
        try {
            ArrayList<StockRequest> list = getAll();
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
}
