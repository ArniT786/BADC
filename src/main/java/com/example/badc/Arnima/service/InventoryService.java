package com.example.badc.Arnima.service;

import com.example.badc.model.InventoryItem;
import java.io.*;
import java.util.ArrayList;

public class InventoryService {
    private String filename = "data/dealer_inventory.bin";

    public void initDummyInventory() {
        try {
            File f = new File(filename);
            if (f.exists()) return;
            ArrayList<InventoryItem> list = new ArrayList<InventoryItem>();
            list.add(new InventoryItem("INV001","1234567890","Rice Seed",120.0));
            list.add(new InventoryItem("INV002","1234567890","Wheat Seed",45.0));
            list.add(new InventoryItem("INV003","1234567890","Jute Seed",0.0));
            list.add(new InventoryItem("INV004","0987654321","Rice Seed",80.0));
            list.add(new InventoryItem("INV005","0987654321","Maize Seed",30.0));
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

    public ArrayList<InventoryItem> getByDealerNid(String nid) {
        ArrayList<InventoryItem> res = new ArrayList<InventoryItem>();
        try {
            ArrayList<InventoryItem> all = getAll();
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

    public boolean updateQuantity(String itemId, double newQty) {
        try {
            ArrayList<InventoryItem> list = getAll();
            boolean found = false;
            for (int i = 0; i < list.size(); i++) {
                InventoryItem item = list.get(i);
                if (item.getItemId().equals(itemId)) {
                    item.setQuantity(newQty);
                    if (newQty <= 0) item.setStockStatus("Out of Stock");
                    else if (newQty < 50) item.setStockStatus("Low Stock");
                    else item.setStockStatus("Available");
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

    public ArrayList<InventoryItem> getAll() {
        ArrayList<InventoryItem> list = new ArrayList<InventoryItem>();
        try {
            File f = new File(filename);
            if (!f.exists()) return list;
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
            while (true) {
                try {
                    InventoryItem r = (InventoryItem) ois.readObject();
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
}
