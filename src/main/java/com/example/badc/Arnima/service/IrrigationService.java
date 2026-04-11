package com.example.badc.Arnima.service;

import com.example.badc.model.IrrigationRequest;
import java.io.*;
import java.util.ArrayList;

public class IrrigationService {
    private String filename = "data/irrigation_requests.bin";

    public boolean save(IrrigationRequest req) {
        try {
            ArrayList<IrrigationRequest> list = getAll();
            list.add(req);
            File d = new File("data");
            if(!d.exists()) d.mkdir();
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
            for(IrrigationRequest r : list) {
                oos.writeObject(r);
            }
            oos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public IrrigationRequest findByNidOrId(String input) {
        try {
            ArrayList<IrrigationRequest> list = getAll();
            for(int i = 0; i < list.size(); i++) {
                IrrigationRequest r = list.get(i);
                if(r.getTrackingId().equals(input) || r.getNid().equals(input)) {
                    return r;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<IrrigationRequest> getAll() {
        ArrayList<IrrigationRequest> list = new ArrayList<IrrigationRequest>();
        try {
            File f = new File(filename);
            if(!f.exists()) return list;
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
            while(true) {
                try {
                    IrrigationRequest r = (IrrigationRequest) ois.readObject();
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
