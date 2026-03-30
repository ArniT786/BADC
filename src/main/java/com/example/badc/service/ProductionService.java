package com.example.badc.service;

import com.example.badc.model.ProductionRecord;

import java.util.ArrayList;
import java.util.List;

public class ProductionService {

    private static final String FILE = "production_records.bin";

    public static boolean saveProduction(ProductionRecord p) {
        if (!FarmerService.farmerExists(p.getFarmerNid())) return false;
        if (p.getHarvestWeight() <= 0) return false;
        if (p.getCropType() == null || p.getCropType().isEmpty()) return false;
        if (p.getSeason() == null || p.getSeason().isEmpty()) return false;
        p.setRecordId("PRD" + System.currentTimeMillis());
        FileService.appendObject(FILE, p);
        return true;
    }

    public static List<ProductionRecord> getAllRecords() {
        return FileService.loadList(FILE);
    }

    public static List<ProductionRecord> getByCropAndSeason(String crop, String season) {
        List<ProductionRecord> all = getAllRecords();
        List<ProductionRecord> result = new ArrayList<>();
        for (ProductionRecord p : all) {
            if (p.getCropType().equalsIgnoreCase(crop) && p.getSeason().equalsIgnoreCase(season)) {
                result.add(p);
            }
        }
        return result;
    }

    public static double getTotalProduction(String crop, String season) {
        List<ProductionRecord> matching = getByCropAndSeason(crop, season);
        double total = 0;
        for (ProductionRecord p : matching) {
            total += p.getHarvestWeight();
        }
        return total;
    }
}
