package com.example.badc.service;

import com.example.badc.model.DailyLog;

import java.util.ArrayList;
import java.util.List;

public class DailyLogService {

    private static final String FILE = "daily_logs.bin";

    public static boolean saveLog(DailyLog log) {
        if (log.getOfficerNid() == null || log.getOfficerNid().isEmpty()) return false;
        if (log.getReportDate() == null || log.getReportDate().isEmpty()) return false;
        if (log.getSummary() == null || log.getSummary().trim().length() < 20) return false;
        log.setLogId("DLG" + System.currentTimeMillis());
        FileService.appendObject(FILE, log);
        return true;
    }

    public static List<DailyLog> getAllLogs() {
        return FileService.loadList(FILE);
    }

    public static List<DailyLog> getByOfficerNid(String nid) {
        List<DailyLog> all = getAllLogs();
        List<DailyLog> result = new ArrayList<>();
        for (DailyLog log : all) {
            if (log.getOfficerNid().equals(nid)) {
                result.add(log);
            }
        }
        return result;
    }

    public static boolean updateStatus(String logId, String status) {
        List<DailyLog> list = FileService.loadList(FILE);
        boolean found = false;
        for (DailyLog log : list) {
            if (log.getLogId().equals(logId)) {
                log.setStatus(status);
                found = true;
                break;
            }
        }
        if (found) {
            FileService.saveList(FILE, list);
        }
        return found;
    }
}
