package com.example.badc.service;

import com.example.badc.model.FieldIssue;
import java.util.ArrayList;
import java.util.List;

public class FieldIssueService {
    private static final String FILE = "field_issues.bin";

    public static boolean saveIssue(FieldIssue issue) {
        if (issue.getLocation() == null || issue.getLocation().trim().isEmpty()) {
            return false;
        }
        if (issue.getDescription() == null || issue.getDescription().trim().length() < 10) {
            return false;
        }

        String issueId = "ISS" + System.currentTimeMillis();
        issue.setIssueId(issueId);

        String desc = issue.getDescription().toLowerCase();
        if (desc.contains("flood") || desc.contains("pest") || desc.contains("disease")) {
            issue.setPriority("HIGH");
        } else if (desc.contains("delay")) {
            issue.setPriority("MEDIUM");
        } else {
            issue.setPriority("LOW");
        }

        FileService.appendObject(FILE, issue);
        return true;
    }

    public static List<FieldIssue> getAllIssues() {
        return FileService.loadList(FILE);
    }

    public static List<FieldIssue> getByPriority(String priority) {
        List<FieldIssue> all = getAllIssues();
        List<FieldIssue> filtered = new ArrayList<>();
        for (FieldIssue issue : all) {
            if (issue.getPriority().equalsIgnoreCase(priority)) {
                filtered.add(issue);
            }
        }
        return filtered;
    }

    public static List<FieldIssue> getByOfficerNid(String nid) {
        List<FieldIssue> all = getAllIssues();
        List<FieldIssue> filtered = new ArrayList<>();
        for (FieldIssue issue : all) {
            if (issue.getReportedByNid().equals(nid)) {
                filtered.add(issue);
            }
        }
        return filtered;
    }
}
