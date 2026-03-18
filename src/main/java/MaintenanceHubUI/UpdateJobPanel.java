/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package MaintenanceHubUI;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import MaintenanceHubdata.JobList;
import MaintenanceHubdata.UndoStack;
import mainhub.MaintenanceHub.JobStatus;
import mainhub.MaintenanceHub.RepairJob;

/**
 *
 * @author Tiyko
 */
public class UpdateJobPanel extends javax.swing.JPanel {

    private final JobList jobList;
    private final UndoStack undoStack;
    private RepairJob currentJob = null;

    public UpdateJobPanel(JobList jobList, UndoStack undoStack) {
        this.jobList = jobList;
        this.undoStack = undoStack;

        initComponents();
        loadStatusCombo();
    }

    private void loadStatusCombo() {
        jComboNewStatus.setModel(new DefaultComboBoxModel<>(JobStatus.values()));
    }

    private void searchJob() {
        String id = jTextSearchID.getText().trim();

        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a Job ID.");
            return;
        }

        currentJob = null;

        for (RepairJob job : jobList.getAllJobs()) {
            if (job.getJobID().equals(id)) {
                currentJob = job;
                break;
            }
        }

        if (currentJob == null) {
            JOptionPane.showMessageDialog(this, "Job not found.");
            clearFields();
            return;
        }

        jTextJobID.setText(currentJob.getJobID());
        jTextDevice.setText(currentJob.getDevice().getType());
        jTextOwner.setText(currentJob.getDevice().getOwnerName());
        jTextService.setText(currentJob.getType().toString());
        jTextCurrentStatus.setText(currentJob.getStatus().toString());
    }

    private void updateJob() {
        if (currentJob == null) {
            JOptionPane.showMessageDialog(this, "Search for a job first.");
            return;
        }

        JobStatus newStatus = (JobStatus) jComboNewStatus.getSelectedItem();
        JobStatus oldStatus = currentJob.getStatus();

        currentJob.updateStatus(newStatus);
        undoStack.pushAction("Updated job " + currentJob.getJobID() +
                " from " + oldStatus + " to " + newStatus);

        JOptionPane.showMessageDialog(this, "Job updated successfully!");

        jTextCurrentStatus.setText(newStatus.toString());
    }

    private void clearFields() {
        jTextSearchID.setText("");
        jTextJobID.setText("");
        jTextDevice.setText("");
        jTextOwner.setText("");
        jTextService.setText("");
        jTextCurrentStatus.setText("");
        jComboNewStatus.setSelectedIndex(0);
        currentJob = null;
    }

    private void undoAction() {
        String action = undoStack.undo();

        if (action == null) {
            JOptionPane.showMessageDialog(this, "Nothing to undo.");
            return;
        }

        JOptionPane.showMessageDialog(this, "Undo: " + action);
    }

    private void initComponents() {

        jLabelSearch = new javax.swing.JLabel();
        jTextSearchID = new javax.swing.JTextField();
        jButtonSearch = new javax.swing.JButton();

        jLabelJobID = new javax.swing.JLabel();
        jLabelDevice = new javax.swing.JLabel();
        jLabelOwner = new javax.swing.JLabel();
        jLabelService = new javax.swing.JLabel();
        jLabelCurrentStatus = new javax.swing.JLabel();
        jLabelNewStatus = new javax.swing.JLabel();

        jTextJobID = new javax.swing.JTextField();
        jTextDevice = new javax.swing.JTextField();
        jTextOwner = new javax.swing.JTextField();
        jTextService = new javax.swing.JTextField();
        jTextCurrentStatus = new javax.swing.JTextField();

        jComboNewStatus = new javax.swing.JComboBox<>();

        jButtonUpdate = new javax.swing.JButton();
        jButtonClear = new javax.swing.JButton();
        jButtonUndo = new javax.swing.JButton();

        jLabelSearch.setText("Search Job ID:");
        jButtonSearch.setText("Search");
        jButtonSearch.addActionListener(e -> searchJob());

        jLabelJobID.setText("Job ID:");
        jLabelDevice.setText("Device:");
        jLabelOwner.setText("Owner:");
        jLabelService.setText("Service Type:");
        jLabelCurrentStatus.setText("Current Status:");
        jLabelNewStatus.setText("New Status:");

        jTextJobID.setEditable(false);
        jTextDevice.setEditable(false);
        jTextOwner.setEditable(false);
        jTextService.setEditable(false);
        jTextCurrentStatus.setEditable(false);

        jButtonUpdate.setText("Update");
        jButtonUpdate.addActionListener(e -> updateJob());

        jButtonClear.setText("Clear");
        jButtonClear.addActionListener(e -> clearFields());

        jButtonUndo.setText("Undo");
        jButtonUndo.addActionListener(e -> undoAction());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(20)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelSearch)
                        .addComponent(jLabelJobID)
                        .addComponent(jLabelDevice)
                        .addComponent(jLabelOwner)
                        .addComponent(jLabelService)
                        .addComponent(jLabelCurrentStatus)
                        .addComponent(jLabelNewStatus))
                    .addGap(20)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jTextSearchID, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10)
                            .addComponent(jButtonSearch))
                        .addComponent(jTextJobID)
                        .addComponent(jTextDevice)
                        .addComponent(jTextOwner)
                        .addComponent(jTextService)
                        .addComponent(jTextCurrentStatus)
                        .addComponent(jComboNewStatus, 0, 200, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButtonUpdate)
                            .addGap(10)
                            .addComponent(jButtonClear)
                            .addGap(10)
                            .addComponent(jButtonUndo)))
                    .addContainerGap(40, Short.MAX_VALUE))
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(20)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelSearch)
                        .addComponent(jTextSearchID)
                        .addComponent(jButtonSearch))
                    .addGap(15)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelJobID)
                        .addComponent(jTextJobID))
                    .addGap(15)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelDevice)
                        .addComponent(jTextDevice))
                    .addGap(15)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelOwner)
                        .addComponent(jTextOwner))
                    .addGap(15)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelService)
                        .addComponent(jTextService))
                    .addGap(15)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelCurrentStatus)
                        .addComponent(jTextCurrentStatus))
                    .addGap(15)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelNewStatus)
                        .addComponent(jComboNewStatus))
                    .addGap(20)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonUpdate)
                        .addComponent(jButtonClear)
                        .addComponent(jButtonUndo))
                    .addGap(20))
        );
    }

    // Variables declaration
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonUndo;

    private javax.swing.JComboBox<JobStatus> jComboNewStatus;

    private javax.swing.JLabel jLabelSearch;
    private javax.swing.JLabel jLabelJobID;
    private javax.swing.JLabel jLabelDevice;
    private javax.swing.JLabel jLabelOwner;
    private javax.swing.JLabel jLabelService;
    private javax.swing.JLabel jLabelCurrentStatus;
    private javax.swing.JLabel jLabelNewStatus;

    private javax.swing.JTextField jTextSearchID;
    private javax.swing.JTextField jTextJobID;
    private javax.swing.JTextField jTextDevice;
    private javax.swing.JTextField jTextOwner;
    private javax.swing.JTextField jTextService;
    private javax.swing.JTextField jTextCurrentStatus;
}
