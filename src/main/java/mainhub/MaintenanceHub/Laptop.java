/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainhub.MaintenanceHub;

/**
 *
 * @author Tiyko
 */

public class Laptop extends Device implements Repairable, SoftwareService, Recoverable {

    public Laptop(String deviceID, String ownerName, String model, String issue) {
        super(deviceID, ownerName, model, issue);
    }

    @Override
    public String getType() {
        return "Laptop";
    }

    @Override
    public double calcCost() {
        return 0; // placeholder
    }

    @Override
    public void performRepair() {}

    @Override
    public void installSoftware() {}

    @Override
    public void updateSoftware() {}

    @Override
    public void recoverData() {}
}
