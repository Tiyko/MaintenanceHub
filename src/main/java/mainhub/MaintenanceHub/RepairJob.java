/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainhub.MaintenanceHub;

/**
 *
 * @author Tiyko
 */

public class RepairJob {
    private String jobID;
    private Device device;
    private ServiceType type;
    private JobStatus status;

    public RepairJob(String jobID, Device device, ServiceType type, JobStatus status) {
        this.jobID = jobID;
        this.device = device;
        this.type = type;
        this.status = status;
    }

    public String getJobID() {
        return jobID;
    }

    public Device getDevice() {
        return device;
    }

    public ServiceType getType() {
        return type;
    }

    public JobStatus getStatus() {
        return status;
    }

    public void updateStatus(JobStatus newStatus) {
        this.status = newStatus;
    }

    public double getCost() {
        return device.calcCost();
    }
}
