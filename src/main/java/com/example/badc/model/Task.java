package com.example.badc.model;

import java.io.Serializable;

public class Task implements Serializable {
    private static final long serialVersionUID = 1L;

    private String taskId;
    private String assignedToNid;
    private String description;
    private String deadline;
    private String status;

    public Task(String taskId, String assignedToNid, String description,
                String deadline, String status) {
        this.taskId = taskId;
        this.assignedToNid = assignedToNid;
        this.description = description;
        this.deadline = deadline;
        this.status = status;
    }

    public String getTaskId() { return taskId; }
    public void setTaskId(String taskId) { this.taskId = taskId; }

    public String getAssignedToNid() { return assignedToNid; }
    public void setAssignedToNid(String assignedToNid) { this.assignedToNid = assignedToNid; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getDeadline() { return deadline; }
    public void setDeadline(String deadline) { this.deadline = deadline; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Task{taskId='" + taskId + "', assignedToNid='" + assignedToNid +
               "', description='" + description + "', deadline='" + deadline +
               "', status='" + status + "'}";
    }
}
