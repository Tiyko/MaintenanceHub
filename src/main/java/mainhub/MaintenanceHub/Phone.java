/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainhub.MaintenanceHub;

/**
 *
 * @author Tiyko
 */

public class Phone extends Device implements Repairable, SoftwareService {

    public Phone(String deviceID, String ownerName, String model, String issue) {
        super(deviceID, ownerName, model, issue);
    }

    @Override
    public String getType() {
        return "Phone";
    }

    @Override
    public double calcCost() {
        return 0;
    }

    @Override
    public void performRepair() {}

    @Override
    public void installSoftware() {}

    @Override
    public void updateSoftware() {}
}

