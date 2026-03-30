package com.example.badc.service;

import com.example.badc.model.StockRecord;

import java.util.ArrayList;
import java.util.List;

public class StockService {

    private static final String FILE = "stock_records.bin";

    public static boolean checkEligibility(String farmerNid) {
        return FarmerService.farmerExists(farmerNid);
    }

    public static boolean distributeItem(StockRecord r) {
        if (!FarmerService.farmerExists(r.getFarmerNid())) return false;
        if (r.getQuantity() <= 0) return false;
        if (r.getItemName() == null || r.getItemName().isEmpty()) return false;
        r.setRecordId("STK" + System.currentTimeMillis());
        FileService.appendObject(FILE, r);
        return true;
    }

    public static List<StockRecord> getAllRecords() {
        return FileService.loadList(FILE);
    }

    public static List<StockRecord> getByFarmerNid(String nid) {
        List<StockRecord> all = getAllRecords();
        List<StockRecord> result = new ArrayList<>();
        for (StockRecord r : all) {
            if (r.getFarmerNid().equals(nid)) {
                result.add(r);
            }
        }
        return result;
    }
}
