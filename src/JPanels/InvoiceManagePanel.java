/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package JPanels;

import Common.GenerateUID;
import static Gui.SignIn.logger;
import JDIalogs.LoadClientDialog;
import JDIalogs.LoadInvoiceProductDialog;
import Model.ClientBean;
import Model.InvoiceProductBean;
import Model.MYSQL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Lenovo
 */
public class InvoiceManagePanel extends javax.swing.JPanel {

    private String user_id;
    private JFrame parent;
    public ClientBean clientBean = null;
    public InvoiceProductBean productBean = null;

    public InvoiceManagePanel(JFrame parent, String user_id) {
        initComponents();
        this.parent = parent;
        this.user_id = user_id;

        loadDate();
        loadInvoiceID();
    }

    private void loadDate() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String today = format.format(date);

        jTextField3.setText(today);
    }

    private void loadInvoiceID() {
        jTextField4.setText(new GenerateUID().generateUniqueId());
    }

    private void calculateinvoicetable() {

        double total = 0;

        for (int i = 0; i < jTable1.getRowCount(); i++) {
            double qty = Double.parseDouble(jTable1.getValueAt(i, 4).toString());
            double uprice = Double.parseDouble(jTable1.getValueAt(i, 5).toString());
            total = qty * uprice;
        }

        jLabel10.setText(String.valueOf(jTable1.getRowCount()));
        jLabel11.setText(String.valueOf(total));
    }

    private void resetFields() {
        jTextField2.setText("Select");
        jTextField5.setText("");
    }

    private void resetAllFields() {
        jTextField1.setText("Select");
        resetFields();
        jTextField3.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        jTextField4.setText(new GenerateUID().generateUniqueId());
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        jLabel10.setText("");
        jLabel11.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(680, 580));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Make Payment");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Client");

        jTextField1.setText("Select");
        jTextField1.setEnabled(false);

        jButton1.setText("...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField3.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Date");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Invoice ID");

        jTextField4.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Product");

        jTextField2.setText("Select");
        jTextField2.setEnabled(false);

        jButton2.setText("...");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextField5.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Name");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Stock ID", "Product ID", "Product Name", "Product Description", "Quentity", "Unit Price", "Damage", "Start", "End"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton3.setText("Cancel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Add");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Item Count");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 0, 0));
        jLabel9.setText("Grand Total");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("0");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 0, 0));
        jLabel11.setText("0");

        jButton5.setText("Cancel");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Make Payment");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton4)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton6)
                                .addGap(18, 18, 18)
                                .addComponent(jButton5))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)
                                .addGap(19, 19, 19)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)
                                .addGap(23, 23, 23)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField5))
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(jLabel1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addGap(21, 21, 21))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        LoadClientDialog loadClientDialog = new LoadClientDialog(parent, true, this);
        loadClientDialog.setVisible(true);

        if (clientBean != null) {
            jTextField1.setText(clientBean.getEmail());
            jButton2.setEnabled(true);

        } else {
            jTextField1.setText("Select");
            jButton2.setEnabled(false);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        LoadInvoiceProductDialog loadInvoiceProductDialog = new LoadInvoiceProductDialog(parent, true, clientBean.getEmail(), this);
        loadInvoiceProductDialog.setVisible(true);

        if (productBean != null) {
            jTextField2.setText(productBean.getId());
            jTextField5.setText(productBean.getName());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if (jTextField1.getText().equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please Select Client", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (jTextField2.getText().equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please Select Product", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            boolean isFound = false;

            for (int i = 0; i < jTable1.getRowCount(); i++) {
                String sid = jTable1.getValueAt(i, 2).toString();
                if (sid.equals(productBean.getStock_Id())) {
                    isFound = true;
                    break;
                }
            }
            if (!isFound) {
                Vector v = new Vector();
                v.add(productBean.getStock_Id());
                v.add(productBean.getId());
                v.add(productBean.getName());
                v.add(productBean.getDescription());
                v.add(productBean.getQuentity());
                v.add(productBean.getUnitPrice());
                v.add(productBean.getDamage());
                v.add(productBean.getStart());
                v.add(productBean.getEnd());

                model.addRow(v);
            } else {
                JOptionPane.showMessageDialog(this, "Product Already Selected", "Error", JOptionPane.ERROR_MESSAGE);
            }

            jTextField2.setText("Select");
            jTextField5.setText("");
            calculateinvoicetable();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        resetFields();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        resetAllFields();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        if (jTable1.getRowCount() != 0) {
            String invoice_ID = jTextField4.getText();
            String date = jTextField3.getText();
            String total = jLabel11.getText();
            String item_Count = jLabel10.getText();

            MYSQL.Iud("INSERT INTO `invoice`(`in_id`,`in_purchesed_date`,`in_total_price`,`user_u_id`) "
                    + "VALUES('" + invoice_ID + "','" + date + "','" + total + "','" + user_id + "')");

            for (int i = 0; i < jTable1.getRowCount(); i++) {
                String sp_id = jTable1.getValueAt(i, 0).toString();
                MYSQL.Iud("UPDATE `product_details`SET `shipping_status_ship_id`='2' WHERE `pd_id`='" + sp_id + "' ");
                MYSQL.Iud("INSERT INTO `invoice_item`(`product_details_pd_id`,`invoice_in_id`) VALUES('" + sp_id + "','" + invoice_ID + "') ");

            }

// Jasper Report
            HashMap<String, Object> parameters = new HashMap<>();
            parameters.put("Parameter1", clientBean.getFname() + " " + clientBean.getLname());
            parameters.put("Parameter2", clientBean.getEmail());
            parameters.put("Parameter3", clientBean.getMobile());
            parameters.put("Parameter5", date);
            parameters.put("Parameter4", total);
            parameters.put("IMAGE_PATH", "src/Resources/kash.png");

            JRTableModelDataSource dataSource = new JRTableModelDataSource(jTable1.getModel());
            String reportPath = "src//Reports//kash.jasper";

            try {
                JasperPrint report = JasperFillManager.fillReport(reportPath, parameters, dataSource);
                JasperViewer.viewReport(report, false);

            } catch (Exception e) {
                logger.warning(String.valueOf(e));
            }

// Jasper Report
            resetAllFields();
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            int row = jTable1.getSelectedRow();

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.removeRow(row);
        }
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}