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
import java.util.Queue;
import mainhub.MaintenanceHub.RepairJob;

public class JobQueue {
    private Queue<RepairJob> queue = new LinkedList<>();

    public void addJob(RepairJob job) {
        queue.add(job);
    }

    public RepairJob nextJob() {
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
