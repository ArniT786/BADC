package com.example.badc.service;

import com.example.badc.model.VisitLog;

import java.util.ArrayList;
import java.util.List;

public class VisitService {

    private static final String FILE = "visit_history.bin";

    public static boolean saveVisit(VisitLog v) {
        if (!FarmerService.farmerExists(v.getFarmerNid())) return false;
        if (v.getVisitDate() == null || v.getVisitDate().isEmpty()) return false;
        if (v.getAdviceGiven() == null || v.getAdviceGiven().trim().length() < 10) return false;
        if (v.getNotes() == null || v.getNotes().isEmpty()) return false;
        v.setLogId("VIS" + System.currentTimeMillis());
        FileService.appendObject(FILE, v);
        return true;
    }

    public static List<VisitLog> getAllVisits() {
        return FileService.loadList(FILE);
    }

    public static List<VisitLog> getByFarmerNid(String nid) {
        List<VisitLog> all = getAllVisits();
        List<VisitLog> result = new ArrayList<>();
        for (VisitLog v : all) {
            if (v.getFarmerNid().equals(nid)) {
                result.add(v);
            }
        }
        return result;
    }
}
