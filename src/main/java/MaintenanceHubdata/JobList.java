/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MaintenanceHubdata;

/**
 *
 * @author Tiyko
 */

import java.util.LinkedList;
import mainhub.MaintenanceHub.RepairJob;

public class JobList {
    private LinkedList<RepairJob> jobs = new LinkedList<>();

    public void addJob(RepairJob job) {
        jobs.add(job);
    }

    public LinkedList<RepairJob> getAllJobs() {
        return jobs;
    }

    public void removeJob(RepairJob job) {
        jobs.remove(job);
    }
}

