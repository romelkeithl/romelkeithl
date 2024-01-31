/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lugo;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class output extends javax.swing.JFrame {

    /**
     * Creates new form output
     */
      int check=1;
 public void displayTable(ArrayList<Process> processes) {
    // Create a DefaultTableModel to hold the data
    DefaultTableModel model = new DefaultTableModel();
     
    // Add columns to the model
    model.addColumn("Process Name");
    model.addColumn("Arrival Time");
       model.addColumn("Priority");
    model.addColumn("Burst Time");
 


    // Iterate through the processes and add them to the model
    for (Process process : processes) {
        Vector<Object> row = new Vector<>();
        row.add(process.getProcess());
        row.add(process.getArrivalTime());
            row.add(process.getPriority());
        row.add(process.getTimeBurst());
    


        model.addRow(row);
    }

    // Set the model to the table
    table1.setModel(model);
}
 
  public void displayTable1(ArrayList<calculations> calculate) {
    // Create a DefaultTableModel to hold the data
    DefaultTableModel model = new DefaultTableModel();
     
    // Add columns to the model
    model.addColumn("Process Name");
    model.addColumn("Arrival Time");
    model.addColumn("Priority");
    model.addColumn("Processed Burst Time");
    model.addColumn("Processed Time");
    


    // Iterate through the processes and add them to the model
    for (calculations process : calculate) {
        Vector<Object> row = new Vector<>();
        row.add(process.getProcess());
        row.add(process.getArrivalTime());
        row.add(process.getPriority());
        row.add(process.getTimeBurst());
        row.add(process.getTurnAround());
  

        model.addRow(row);
    }

    // Set the model to the table
    table2.setModel(model);
}
  
   
  public void displayTable2(ArrayList<calculations> calculate) {
    // Create a DefaultTableModel to hold the data
    DefaultTableModel model = new DefaultTableModel();
     
    // Add columns to the model
    model.addColumn("Process Name");
    model.addColumn("Arrival Time");
    model.addColumn("Burst Time");
    model.addColumn("Turn Around Time");
    model.addColumn("Waiting Time");

    // Iterate through the processes and add them to the model
    for (calculations process : calculate) {
        Vector<Object> row = new Vector<>();
        row.add(process.getProcess());
        row.add(process.getArrivalTime());
        row.add(process.getTimeBurst());
        row.add(process.getTurnAround());
        row.add(process.getWaiting());


        model.addRow(row);
    }

    // Set the model to the table
  overview.setModel(model);
}

  int wt;
    int tat;
        
       ArrayList<Process> processes = new ArrayList<>();
               
       ArrayList<Process> processes1 = new ArrayList<>();
       ArrayList<calculations> calculations=new ArrayList<>();
            ArrayList<calculations> calculations1=new ArrayList<>();
    public output(ArrayList<Process> processes) {
        this.processes=processes;

        initComponents();
        displayTable(processes);
        for (Process process:processes){
            String processName=process.getProcess();
            int timeBurst=process.getTimeBurst();
            int arrivalTime=process.getArrivalTime();
            int priority=process.getPriority();
               	processes1.add(new Process(processName,timeBurst,arrivalTime,priority));}
        int elapsedTime=0;
   
do {
    check = 0; // Initialize check variable before the loop

    for (Process process : processes1) {
        int arrival = process.getArrivalTime();

        // Check if the process has arrived
        if (arrival > elapsedTime) {
            continue;  // Skip processes that haven't arrived yet
        }

        String name = process.getProcess();
        int burst = process.getTimeBurst() - 1;
        process.setBurst(burst);

        // Skip processes with burst time <= 0
        if (burst < 0) {
            continue;
        }

        int turnaround = elapsedTime + 1;
        int waiting = turnaround - burst;
        elapsedTime = turnaround;
        int priority=process.getPriority();
        calculations.add(new calculations(name, burst, arrival, turnaround, waiting,priority));

        // Check if any process has remaining burst time
        if (process.anyProcessHasRemainingBurst(processes)) {
            check = 1;
        }
             Collections.sort(processes1, Comparator
                .comparingInt(Process::getArrivalTime)
                .thenComparingInt(Process::getPriority)
                .thenComparingInt(Process::getTimeBurst));
           break;
    }
              
                 
} while (check == 1);
  
    for (Process process : processes) { 
            String addedName=process.getProcess();
            int addedArrival=process.getArrivalTime();
            int addedBurst=process.getTimeBurst();
         int priority=process.getPriority();
            for (calculations overview:calculations){
                if (addedName.equals(overview.getProcess())){
                           tat=overview.getTurnAround();
                wt=tat-addedBurst;
         
                }
                        
              
            }
      calculations1.add(new calculations(addedName, addedBurst, addedArrival, tat, wt,priority));
    }


         int sumTAT=0;
         int sumWT=0;
         int size=calculations1.size();
       for (calculations process : calculations1) {
           sumTAT+=process.getTurnAround();
           sumWT=process.getWaiting();
    }
         double avgTurnaround=sumTAT/size;
         double avgWaiting=sumWT/size;
         
         
String strtat = String.valueOf(avgTurnaround);
String strwt= String.valueOf(avgWaiting);

                 awt.setText(strwt + " Units");
                 atat.setText(strtat+ " Units");
    displayTable1(calculations);
      displayTable2(calculations1);
 
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        awt = new javax.swing.JLabel();
        atat = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        overview = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 51, 51));
        jPanel1.setForeground(new java.awt.Color(51, 51, 255));

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table1);

        jLabel2.setBackground(new java.awt.Color(0, 255, 102));
        jLabel2.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 255, 255));
        jLabel2.setText("PROCESSES:");

        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(table2);

        jLabel3.setBackground(new java.awt.Color(255, 0, 51));
        jLabel3.setFont(new java.awt.Font("Dubai Light", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Average Turnaround Time:");

        jLabel4.setBackground(new java.awt.Color(255, 0, 51));
        jLabel4.setFont(new java.awt.Font("Dubai Light", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Average Waiting Time:");

        awt.setBackground(new java.awt.Color(255, 0, 51));
        awt.setFont(new java.awt.Font("Dubai Medium", 1, 36)); // NOI18N
        awt.setForeground(new java.awt.Color(0, 0, 0));
        awt.setText("awt");

        atat.setBackground(new java.awt.Color(255, 0, 51));
        atat.setFont(new java.awt.Font("Dubai Medium", 1, 36)); // NOI18N
        atat.setForeground(new java.awt.Color(0, 0, 0));
        atat.setText("atat");

        jButton1.setBackground(new java.awt.Color(0, 153, 255));
        jButton1.setText("BACK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        overview.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(overview);

        jLabel6.setBackground(new java.awt.Color(0, 255, 102));
        jLabel6.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 255, 255));
        jLabel6.setText("GANTT CHART:");

        jLabel7.setBackground(new java.awt.Color(0, 255, 102));
        jLabel7.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 255, 255));
        jLabel7.setText("OVERVIEW:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel6)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel2)
                        .addContainerGap(1143, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane3))
                        .addGap(23, 23, 23))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(atat)
                            .addComponent(awt))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addGap(15, 15, 15)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(atat))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(awt)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
            new input().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(output.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(output.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(output.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(output.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel atat;
    private javax.swing.JLabel awt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable overview;
    private javax.swing.JTable table1;
    private javax.swing.JTable table2;
    // End of variables declaration//GEN-END:variables
}
