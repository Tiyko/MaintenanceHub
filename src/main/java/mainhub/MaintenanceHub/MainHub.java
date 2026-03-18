/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package mainhub.MaintenanceHub;

import MaintenanceHubUI.Mainframe;

/**
 *
 * @author Tiyko
 */
public class MainHub {

    public static void main(String[] args) {
        // Launch the UI
        java.awt.EventQueue.invokeLater(() -> {
            new Mainframe().setVisible(true);
        });
    }
}
