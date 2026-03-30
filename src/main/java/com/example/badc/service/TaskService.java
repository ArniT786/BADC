package com.example.badc.service;

import com.example.badc.model.Task;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TaskService {

    private static final String FILE = "assignments.bin";

    public static void initDummyTasks() {
        if (new File(FileService.DATA_DIR + FILE).exists()) {
            return;
        }
        List<Task> list = new ArrayList<>();
        list.add(new Task("TSK001", "1234567890", "Visit 5 farmers in Dhaka North",
                "2025-12-01", "PENDING"));
        list.add(new Task("TSK002", "1234567890", "Distribute rice seeds in Block A",
                "2025-12-03", "PENDING"));
        list.add(new Task("TSK003", "0987654321", "Inspect crops in Rajshahi Zone 2",
                "2025-12-05", "PENDING"));
        list.add(new Task("TSK004", "0987654321", "Submit monthly yield report",
                "2025-12-07", "PENDING"));
        FileService.saveList(FILE, list);
    }

    public static List<Task> getByOfficerNid(String nid) {
        List<Task> all = FileService.loadList(FILE);
        List<Task> result = new ArrayList<>();
        for (Task t : all) {
            if (t.getAssignedToNid().equals(nid)) {
                result.add(t);
            }
        }
        return result;
    }

    public static boolean acknowledgeTask(String taskId) {
        List<Task> list = FileService.loadList(FILE);
        boolean found = false;
        for (Task t : list) {
            if (t.getTaskId().equals(taskId)) {
                t.setStatus("ACKNOWLEDGED");
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
