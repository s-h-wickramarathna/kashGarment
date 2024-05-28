/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package JPanels;

import Gui.Home;
import Model.MYSQL;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import static Gui.SignIn.logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class UserManagement extends javax.swing.JPanel {

    private static HashMap<String, String> employeeTypeMap = new HashMap<>();
    private static HashMap<String, String> employeeGenderMap = new HashMap<>();

    public UserManagement() {
        initComponents();
        loadUsers();
        loadTypes();
        loadGender();
        jButton7.setEnabled(false);
        jTextField17.setEditable(false);
    }

    private void loadUsers() {
        try {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            ResultSet resultSet = MYSQL.Search("SELECT *\n"
                    + "FROM `user` \n"
                    + "INNER JOIN `employee` ON `employee`.`emp_id` = `user`.`employee_emp_id`\n"
                    + "INNER JOIN `employee_type` ON `employee`.`employee_type_empt_id` = `employee_type`.`empt_id`\n"
                    + "INNER JOIN `status` ON `employee`.`status_s_id` = `status`.`s_id`");

            while (resultSet.next()) {
                Vector v = new Vector();
                v.add(resultSet.getString("emp_id"));
                v.add(resultSet.getString("emp_fname"));
                v.add(resultSet.getString("emp_lname"));
                v.add(resultSet.getString("emp_nic"));
                v.add(resultSet.getString("emp_mobile"));
                v.add(resultSet.getString("emp_joinDate"));
                v.add(resultSet.getString("empt_type"));
                v.add(resultSet.getString("status_s_id"));
                model.addRow(v);
            }

        } catch (Exception e) {
           logger.warning(String.valueOf(e));
        }
    }

    private void loadGender() {

        try {
            ResultSet resultSet = MYSQL.Search("SELECT * FROM `gender`");

            Vector v = new Vector();
            v.add("select");

            while (resultSet.next()) {

                v.add(resultSet.getString("g_type"));
                employeeGenderMap.put(resultSet.getString("g_type"), resultSet.getString("g_id"));

            }

            DefaultComboBoxModel model = new DefaultComboBoxModel(v);
            jComboBox2.setModel(model);

        } catch (Exception e) {
            
           logger.warning(String.valueOf(e));
        }

    }

    private void loadTypes() {

        try {
            ResultSet resultSet = MYSQL.Search("SELECT * FROM `employee_type`");

            Vector v = new Vector();
            v.add("select");

            while (resultSet.next()) {

                v.add(resultSet.getString("empt_type"));
                employeeTypeMap.put(resultSet.getString("empt_type"), resultSet.getString("empt_id"));

            }

            DefaultComboBoxModel model = new DefaultComboBoxModel(v);
            jComboBox1.setModel(model);

        } catch (Exception e) {
           logger.warning(String.valueOf(e));
        }

    }

    private void reset() {

        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jComboBox2.setSelectedIndex(0);
        jComboBox1.setSelectedIndex(0);
        jTextField7.setText("");
        jPasswordField1.setText("");

        jTextField1.grabFocus();
        jTextField2.grabFocus();
        jTextField3.grabFocus();
        jTextField4.grabFocus();
        jComboBox2.setSelectedIndex(0);
        jComboBox1.setSelectedIndex(0);
        jTextField7.grabFocus();
        jPasswordField1.grabFocus();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jTextField16 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jComboBox3 = new javax.swing.JComboBox<>();
        jTextField10 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField9 = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(680, 580));

        jLabel2.setText("First Name");

        jLabel3.setText("Last Name");

        jLabel4.setText("NIC");

        jLabel5.setText("Mobile");

        jLabel6.setText("Gender");

        jLabel7.setText("Type");

        jLabel8.setText("User Name");

        jLabel9.setText("Password");

        jButton3.setText("Add");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(26, 26, 26)
                                .addComponent(jTextField4))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(27, 27, 27)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField2)
                            .addComponent(jComboBox2, 0, 164, Short.MAX_VALUE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField3)
                            .addComponent(jComboBox1, 0, 167, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPasswordField1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jButton3)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Add User", jPanel3);

        jLabel10.setText("First Name");

        jLabel16.setText("User Name");

        jLabel13.setText("Mobile");

        jButton7.setText("Save");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel11.setText("Last Name");

        jLabel17.setText("ID");

        jLabel15.setText("Type");

        jLabel12.setText("NIC");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField12, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField17))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(26, 26, 26)
                        .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton7)))
                .addGap(3, 3, 3))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jButton7)
                .addGap(18, 18, 18))
        );

        jTabbedPane1.addTab("Update User", jPanel4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Manage User");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "User ID", "First Name", "Last Name", "NIC", "Mobile", "Joined Date", "User Type", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, true, true, true
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
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTextField9.setText("Search User ID or Name");
        jTextField9.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField9FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField9FocusLost(evt);
            }
        });
        jTextField9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField9KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jTextField9)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        try {

            String fname = jTextField1.getText();
            String lname = jTextField2.getText();
            String nic = jTextField3.getText();
            String mobile = jTextField4.getText();
            String gender = String.valueOf(jComboBox2.getSelectedItem());
            String type = String.valueOf(jComboBox1.getSelectedItem());
            String uname = jTextField7.getText();
            String password = String.valueOf(jPasswordField1.getPassword());

            if (fname.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter Employee First Name", "warning", JOptionPane.WARNING_MESSAGE);
            } else if (lname.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter Employee Last Name", "warning", JOptionPane.WARNING_MESSAGE);
            } else if (nic.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter Employee NIC", "warning", JOptionPane.WARNING_MESSAGE);
            } else if (mobile.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter Employee Mobile", "warning", JOptionPane.WARNING_MESSAGE);
            } else if (gender.equals("select")) {
                JOptionPane.showMessageDialog(this, "Please Select Employee Gender", "warning", JOptionPane.WARNING_MESSAGE);
            } else if (type.equals("select")) {
                JOptionPane.showMessageDialog(this, "Please Select Employee Type", "warning", JOptionPane.WARNING_MESSAGE);
            } else if (uname.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter Employee user name", "warning", JOptionPane.WARNING_MESSAGE);
            } else if (password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter Password", "warning", JOptionPane.WARNING_MESSAGE);
            } else {

                ResultSet resultSet = MYSQL.Search("SELECT * FROM `employee` WHERE `emp_nic`= '" + nic + "'");

                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(this, "User already Registerd", "warning", JOptionPane.WARNING_MESSAGE);
                } else {

                    System.out.println();
                    Date date = new Date();
                    SimpleDateFormat formatr = new SimpleDateFormat("yyyy-MM-dd");
                    MYSQL.Iud("INSERT INTO `employee` (`emp_fname`,`emp_lname`,`emp_nic`,`emp_mobile`,`emp_joinDate`,`employee_type_empt_id`,`status_s_id`) VALUES ('" + fname + "', '" + lname + "', '" + nic + "','" + mobile + "','" + formatr.format(date) + "', '" + employeeTypeMap.get(type) + "','1')");

                    ResultSet lastInsertedID = MYSQL.Search("SELECT LAST_INSERT_ID()");

                    if (lastInsertedID.next()) {
                        String ID = lastInsertedID.getString("LAST_INSERT_ID()");
                        MYSQL.Iud("INSERT INTO `user` (`u_password`,`employee_emp_id`) VALUES ('" + password + "','" + ID + "')");
                    } else {
                        JOptionPane.showMessageDialog(this, "Something went wrong", "warning", JOptionPane.WARNING_MESSAGE);
                    }

                    loadUsers();
                    reset();

                    JOptionPane.showMessageDialog(this, "Employee Added", "Success", JOptionPane.INFORMATION_MESSAGE);

                }
            }

        } catch (Exception e) {
          logger.warning(String.valueOf(e));
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        try {

            String fname = jTextField10.getText();
            String lname = jTextField11.getText();
            String nic = jTextField12.getText();
            String mobile = jTextField13.getText();
            String type = String.valueOf(jComboBox3.getSelectedItem());
            String uname = jTextField16.getText();

            if (fname.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter Employee First Name", "warning", JOptionPane.WARNING_MESSAGE);
            } else if (lname.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter Employee Last Name", "warning", JOptionPane.WARNING_MESSAGE);
            } else if (nic.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter Employee NIC", "warning", JOptionPane.WARNING_MESSAGE);
            } else if (mobile.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter Employee Mobile", "warning", JOptionPane.WARNING_MESSAGE);
            } else if (type.equals("select")) {
                JOptionPane.showMessageDialog(this, "Please Select Employee Type", "warning", JOptionPane.WARNING_MESSAGE);
            } else if (uname.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter Employee user name", "warning", JOptionPane.WARNING_MESSAGE);
            } else {

                ResultSet resultSet = MYSQL.Search("SELECT * FROM `employee` WHERE `emp_nic`= '" + nic + "'");

                if (resultSet.next()) {

                    Date date = new Date();
                    SimpleDateFormat formatr = new SimpleDateFormat("yyyy-MM-dd");
                    MYSQL.Iud("UPDATE `employee` SET `emp_fname`= '" + fname + "',`emp_lname`='" + lname + "',`emp_mobile`='" + mobile + "',`emp_joinDate`='" + formatr.format(date) + "',`emp_nic`='" + nic + "',`employee_type_empt_id`='" + employeeTypeMap.get(String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(), 6))) + "' WHERE `emp_id`='" + jTextField17.getText() + "'");
                    JOptionPane.showMessageDialog(this, "User Updateted", "Success", JOptionPane.INFORMATION_MESSAGE);
                    loadUsers();
                    reset();

                    jButton7.setEnabled(false);
                } else {
                    JOptionPane.showMessageDialog(this, "PSomething went to wrong", "warning", JOptionPane.WARNING_MESSAGE);
                }
            }

        } catch (Exception e) {
            logger.warning(String.valueOf(e));
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int selectedRaw = jTable1.getSelectedRow();
        if (selectedRaw != -1 && evt.getClickCount() == 2) {

            String ID = jTable1.getValueAt(selectedRaw, 0).toString();
            jTextField17.setText(ID);

            String FirstName = jTable1.getValueAt(selectedRaw, 1).toString();
            jTextField10.setText(FirstName);

            String LastName = jTable1.getValueAt(selectedRaw, 2).toString();
            jTextField11.setText(LastName);

            String NIC = jTable1.getValueAt(selectedRaw, 3).toString();
            jTextField12.setText(NIC);
            setEnabled(false);

            String Mobile = jTable1.getValueAt(selectedRaw, 4).toString();
            jTextField13.setText(Mobile);

            String UserName = jTable1.getValueAt(selectedRaw, 5).toString();
            jTextField16.setText(UserName);

            String Type = jTable1.getValueAt(selectedRaw, 6).toString();
            ComboBoxModel<String> model = jComboBox3.getModel();
            jComboBox3.setSelectedItem(Type);
            model.setSelectedItem(Type);

            jButton7.setEnabled(true);

        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyReleased

        String text = jTextField9.getText();
    }//GEN-LAST:event_jTextField9KeyReleased

    private void jTextField9FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField9FocusGained
        // TODO add your handling code here:
        if (jTextField9.getText().equals("Search User ID Or Name ....")) {
            jTextField9.setText("");
        }
    }//GEN-LAST:event_jTextField9FocusGained

    private void jTextField9FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField9FocusLost
        // TODO add your handling code here:
        if (jTextField9.getText().isEmpty()) {
            jTextField9.setText("Search User ID Or Name ....");
        }
    }//GEN-LAST:event_jTextField9FocusLost

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_jTable1KeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
