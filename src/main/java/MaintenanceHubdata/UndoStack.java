/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MaintenanceHubdata;
import java.util.Stack;
import mainhub.MaintenanceHub.RepairJob;
import mainhub.MaintenanceHub.JobStatus;

/**
 *
 * @author Tiyko
 */

public class UndoStack {

    // For undoing created jobs
    private Stack<RepairJob> createdJobs = new Stack<>();

    // For undoing deleted jobs
    private Stack<RepairJob> deletedJobs = new Stack<>();

    // For undoing updated jobs (status changes)
    private Stack<RepairJob> updatedJobs = new Stack<>();
    private Stack<JobStatus> oldStatuses = new Stack<>();


    // -------------------------
    // CREATE JOB UNDO
    // -------------------------
    public void pushCreatedJob(RepairJob job) {
        createdJobs.push(job);
    }

    public RepairJob undoCreate() {
        if (createdJobs.isEmpty()) return null;
        return createdJobs.pop();
    }


    // -------------------------
    // DELETE JOB UNDO
    // -------------------------
    public void pushDeletedJob(RepairJob job) {
        deletedJobs.push(job);
    }

    public RepairJob undoDelete() {
        if (deletedJobs.isEmpty()) return null;
        return deletedJobs.pop();
    }


    // -------------------------
    // UPDATE JOB UNDO
    // -------------------------
    public void pushUpdatedJob(RepairJob job, JobStatus oldStatus) {
        updatedJobs.push(job);
        oldStatuses.push(oldStatus);
    }

    public RepairJob undoUpdate() {
        if (updatedJobs.isEmpty()) return null;
        return updatedJobs.pop();
    }

    public JobStatus undoOldStatus() {
        if (oldStatuses.isEmpty()) return null;
        return oldStatuses.pop();
    }
}