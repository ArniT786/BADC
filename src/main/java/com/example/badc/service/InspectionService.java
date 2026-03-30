package com.example.badc.service;

import com.example.badc.model.Inspection;

import java.util.ArrayList;
import java.util.List;

public class InspectionService {

    private static final String FILE = "inspections.bin";

    public static boolean saveInspection(Inspection i) {
        if (i.getFarmerNid() == null || i.getFarmerNid().isEmpty()) return false;
        if (!FarmerService.farmerExists(i.getFarmerNid())) return false;
        if (i.getInspectionDate() == null || i.getInspectionDate().isEmpty()) return false;
        if (i.getConditionDetails() == null || i.getConditionDetails().isEmpty()) return false;
        i.setInspectionId("INS" + System.currentTimeMillis());
        FileService.appendObject(FILE, i);
        return true;
    }

    public static List<Inspection> getAllInspections() {
        return FileService.loadList(FILE);
    }

    public static List<Inspection> getByFarmerNid(String nid) {
        List<Inspection> all = getAllInspections();
        List<Inspection> result = new ArrayList<>();
        for (Inspection i : all) {
            if (i.getFarmerNid().equals(nid)) {
                result.add(i);
            }
        }
        return result;
    }
}
