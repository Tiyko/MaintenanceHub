/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package MaintenanceHubUI;

import java.util.UUID;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import MaintenanceHubdata.JobList;
import MaintenanceHubdata.UndoStack;
import mainhub.MaintenanceHub.Desktop;
import mainhub.MaintenanceHub.Device;
import mainhub.MaintenanceHub.JobStatus;
import mainhub.MaintenanceHub.Laptop;
import mainhub.MaintenanceHub.OtherDevice;
import mainhub.MaintenanceHub.Phone;
import mainhub.MaintenanceHub.RepairJob;
import mainhub.MaintenanceHub.ServiceType;
import mainhub.MaintenanceHub.SmartWatch;
import mainhub.MaintenanceHub.Tablet;

/**
 *
 * @author Tiyko
 */
public class CreateJobPanel extends javax.swing.JPanel {

    /**
     * Creates new form CreateJobPanel
     */
    private final JobList jobList;
    private final UndoStack undoStack;

    public CreateJobPanel(JobList jobList, UndoStack undoStack) {
        this.jobList = jobList;
        this.undoStack = undoStack;

        initComponents();
        loadComboBoxes();
        jButtonCreate.addActionListener(e -> createJob());
        jButtonClear.addActionListener(e -> clearForm());
    }

    private void loadComboBoxes() {
        jComboDeviceType.setModel(new DefaultComboBoxModel<>(new String[]{
                "Laptop", "Phone", "Tablet", "Desktop", "SmartWatch", "Other"
        }));

        jComboServiceType.setModel(new DefaultComboBoxModel<>(ServiceType.values()));
        jComboStatus.setModel(new DefaultComboBoxModel<>(JobStatus.values()));
    }

    private void createJob() {
        try {
            String deviceType = jComboDeviceType.getSelectedItem().toString();
            String owner = jTextOwnerName.getText().trim();
            String model = jTextModel.getText().trim();
            String issue = jTextAreaIssue.getText().trim();
            ServiceType service = (ServiceType) jComboServiceType.getSelectedItem();
            JobStatus status = (JobStatus) jComboStatus.getSelectedItem();

            if (owner.isEmpty() || model.isEmpty() || issue.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields.");
                return;
            }

            Device device;

            switch (deviceType) {
                case "Laptop" -> device = new Laptop(UUID.randomUUID().toString(), owner, model, issue);
                case "Phone" -> device = new Phone(UUID.randomUUID().toString(), owner, model, issue);
                case "Tablet" -> device = new Tablet(UUID.randomUUID().toString(), owner, model, issue);
                case "Desktop" -> device = new Desktop(UUID.randomUUID().toString(), owner, model, issue);
                case "SmartWatch" -> device = new SmartWatch(UUID.randomUUID().toString(), owner, model, issue);
                default -> device = new OtherDevice(UUID.randomUUID().toString(), owner, model, issue);
            }

            RepairJob job = new RepairJob(UUID.randomUUID().toString(), device, service, status);

            jobList.addJob(job);

            // NEW: store job for undo
            undoStack.pushCreatedJob(job);

            JOptionPane.showMessageDialog(this, "Job created successfully!");

            clearForm();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error creating job: " + ex.getMessage());
        }
    }

    private void undoCreate() {
        RepairJob job = undoStack.undoCreate();

        if (job == null) {
            JOptionPane.showMessageDialog(this, "Nothing to undo.");
            return;
        }

        jobList.removeJob(job);
        JOptionPane.showMessageDialog(this, "Undo successful. Removed job: " + job.getJobID());
    }


    private void clearForm() {
        jTextOwnerName.setText("");
        jTextModel.setText("");
        jTextAreaIssue.setText("");
        jComboDeviceType.setSelectedIndex(0);
        jComboServiceType.setSelectedIndex(0);
        jComboStatus.setSelectedIndex(0);
    }
    
    private void initComponents() {

        jComboDeviceType = new javax.swing.JComboBox<>();
        jLabelDeviceType = new javax.swing.JLabel();
        jLabelOwnerName = new javax.swing.JLabel();
        jLabelModel = new javax.swing.JLabel();
        jLabelIssue = new javax.swing.JLabel();
        jLabelServiceType = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextOwnerName = new javax.swing.JTextField();
        jTextModel = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaIssue = new javax.swing.JTextArea();
        jComboServiceType = new javax.swing.JComboBox<>();
        jComboStatus = new javax.swing.JComboBox<>();
        jButtonCreate = new javax.swing.JButton();
        jButtonClear = new javax.swing.JButton();

        jComboDeviceType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabelDeviceType.setText(" Device Type");

        jLabelOwnerName.setText("Owner Name");

        jLabelModel.setText("Model");

        jLabelIssue.setText("Issue");

        jLabelServiceType.setText("Service Type");

        jLabel6.setText("Label Status");

        jTextModel.addActionListener(this::jTextModelActionPerformed);

        jTextAreaIssue.setColumns(20);
        jTextAreaIssue.setRows(5);
        jScrollPane1.setViewportView(jTextAreaIssue);

        jComboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(JobStatus.values()));

        jButtonCreate.setText("Create");

        jButtonClear.setText("Clear");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelModel)
                            .addComponent(jLabelOwnerName)
                            .addComponent(jLabelDeviceType)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelServiceType)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelIssue)
                                    .addComponent(jLabel6))))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jTextOwnerName)
                            .addComponent(jTextModel)
                            .addComponent(jComboServiceType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboDeviceType, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jButtonCreate)
                        .addGap(68, 68, 68)
                        .addComponent(jButtonClear)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDeviceType)
                    .addComponent(jComboDeviceType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelOwnerName)
                    .addComponent(jTextOwnerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelModel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboServiceType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelServiceType))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelIssue)
                        .addGap(166, 166, 166)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonCreate)
                            .addComponent(jButtonClear))))
                .addGap(19, 19, 19))
        );
    }

    private void jTextModelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextModelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextModelActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonCreate;
    private javax.swing.JComboBox<String> jComboDeviceType;
    private javax.swing.JComboBox<ServiceType> jComboServiceType;
    private javax.swing.JComboBox<JobStatus> jComboStatus;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelDeviceType;
    private javax.swing.JLabel jLabelIssue;
    private javax.swing.JLabel jLabelModel;
    private javax.swing.JLabel jLabelOwnerName;
    private javax.swing.JLabel jLabelServiceType;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaIssue;
    private javax.swing.JTextField jTextModel;
    private javax.swing.JTextField jTextOwnerName;
    // End of variables declaration//GEN-END:variables
}
