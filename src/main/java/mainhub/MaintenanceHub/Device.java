/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainhub.MaintenanceHub;

/**
 *
 * @author Tiyko
 */

public abstract class Device {
    protected String deviceID;
    protected String ownerName;
    protected String model;
    protected String issue;

    public Device(String deviceID, String ownerName, String model, String issue) {
        this.deviceID = deviceID;
        this.ownerName = ownerName;
        this.model = model;
        this.issue = issue;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getModel() {
        return model;
    }

    public String getIssue() {
        return issue;
    }

    public abstract String getType();

    public abstract double calcCost();
}

