package com.example.badc.service;

import com.example.badc.model.Farmer;

import java.util.ArrayList;
import java.util.List;

public class FarmerService {

    private static final String FILE = "farmers.bin";

    public static boolean registerFarmer(Farmer f) {
        if (f.getName() == null || f.getName().isEmpty()) return false;
        if (!f.getNid().matches("\\d{10}")) return false;
        if (f.getLandSize() <= 0) return false;
        if (f.getPhone() == null || f.getPhone().isEmpty()) return false;
        if (farmerExists(f.getNid())) return false;
        FileService.appendObject(FILE, f);
        return true;
    }

    public static Farmer findByNid(String nid) {
        List<Farmer> list = FileService.loadList(FILE);
        for (Farmer f : list) {
            if (f.getNid().equals(nid)) {
                return f;
            }
        }
        return null;
    }

    public static List<Farmer> getAllFarmers() {
        return FileService.loadList(FILE);
    }

    public static List<Farmer> getByDistrict(String district) {
        List<Farmer> all = getAllFarmers();
        List<Farmer> result = new ArrayList<>();
        for (Farmer f : all) {
            if (f.getDistrict().equalsIgnoreCase(district)) {
                result.add(f);
            }
        }
        return result;
    }

    public static boolean farmerExists(String nid) {
        return findByNid(nid) != null;
    }
}
