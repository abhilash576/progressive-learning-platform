/*
    Copyright 2011 David Fritz, Brian Gordon, Wira Mulia

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.

 */

package plptool.gui.frames;

import plptool.Constants;
import plptool.PLPToolbox;
import plptool.gui.ProjectDriver;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.DefaultCellEditor;
import javax.swing.JOptionPane;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;

/**
 *
 * @author wira
 */
public class Watcher extends javax.swing.JFrame {

    ProjectDriver plp;

    /** Creates new form Watcher */
    public Watcher(ProjectDriver plp) {
        this.plp = plp;
        initComponents();

        CustomCellTextField textField = new CustomCellTextField(plp);
        CustomCellEditor ce = new CustomCellEditor(textField);
        tblEntries.setDefaultEditor(String.class, ce);

        cmbType.addItem("Bus");
        cmbType.addItem("Register");

        //plp.g_simsh.attachOptionSynchronizer(this, Constants.PLP_TOOLFRAME_WATCHER);
    }

    public DefaultTableModel getEntries() {
        return (DefaultTableModel) tblEntries.getModel();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAdd = new javax.swing.JLabel();
        cmbType = new javax.swing.JComboBox();
        lblAddr = new javax.swing.JLabel();
        txtAddr = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEntries = new javax.swing.JTable();
        btnRemoveSelected = new javax.swing.JButton();
        btnRemoveAll = new javax.swing.JButton();

        ;
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        ;
        setResizable(true);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(plptool.gui.PLPToolApp.class).getContext().getResourceMap(Watcher.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N

        lblAdd.setText(resourceMap.getString("lblAdd.text")); // NOI18N
        lblAdd.setName("lblAdd"); // NOI18N

        cmbType.setName("cmbType"); // NOI18N

        lblAddr.setText(resourceMap.getString("lblAddr.text")); // NOI18N
        lblAddr.setName("lblAddr"); // NOI18N

        txtAddr.setText(resourceMap.getString("txtAddr.text")); // NOI18N
        txtAddr.setName("txtAddr"); // NOI18N

        btnAdd.setText(resourceMap.getString("btnAdd.text")); // NOI18N
        btnAdd.setName("btnAdd"); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        tblEntries.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Type", "Address", "Hex Value", "Dec Value"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEntries.setName("tblEntries"); // NOI18N
        jScrollPane1.setViewportView(tblEntries);
        tblEntries.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("tblEntries.columnModel.title0")); // NOI18N
        tblEntries.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("tblEntries.columnModel.title1")); // NOI18N
        tblEntries.getColumnModel().getColumn(2).setHeaderValue(resourceMap.getString("tblEntries.columnModel.title2")); // NOI18N
        tblEntries.getColumnModel().getColumn(3).setHeaderValue(resourceMap.getString("tblEntries.columnModel.title3")); // NOI18N

        btnRemoveSelected.setText(resourceMap.getString("btnRemoveSelected.text")); // NOI18N
        btnRemoveSelected.setName("btnRemoveSelected"); // NOI18N
        btnRemoveSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveSelectedActionPerformed(evt);
            }
        });

        btnRemoveAll.setText(resourceMap.getString("btnRemoveAll.text")); // NOI18N
        btnRemoveAll.setName("btnRemoveAll"); // NOI18N
        btnRemoveAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbType, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblAddr)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAddr, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnRemoveAll)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(btnRemoveSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAdd)
                    .addComponent(cmbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAddr)
                    .addComponent(txtAddr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemoveSelected)
                    .addComponent(btnRemoveAll))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        long addr = PLPToolbox.parseNum(txtAddr.getText());
        DefaultTableModel entries = getTblValues();
                
        switch(cmbType.getSelectedIndex()) {
            case 0:
                if(plp.sim.bus.isMapped(addr)) {
                    Long data = (Long) plp.sim.bus.read(addr);
                    Object[] row = {"Bus", String.format("0x%08x", addr),
                                    (data != null) ? String.format("0x%08x", data) : "Uninitialized",
                                    (data != null) ? String.format("%d", data) : "Uninitialized"};
                    entries.addRow(row);
                    tblEntries.setModel(entries);
                }

                break;
            case 1:
                if(plp.getArch().equals("plpmips")) {
                    plptool.mips.SimCore mipsSim = (plptool.mips.SimCore) plp.sim;
                    if(addr >= 0 && addr <= mipsSim.regfile.endAddr()) {
                        Long data = (Long) mipsSim.regfile.read(addr);
                        Object[] row = {"Register", String.format("0x%08x", addr),
                                        (data != null) ? String.format("0x%08x", data) : "Uninitialized",
                                        (data != null) ? String.format("%d", data) : "Uninitialized"};
                        entries.addRow(row);
                        tblEntries.setModel(entries);
                    }
                }

                break;
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRemoveSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveSelectedActionPerformed
        DefaultTableModel entries = getTblValues();
        int rowToDelete = tblEntries.getSelectedRow();
        entries.removeRow(rowToDelete);
    }//GEN-LAST:event_btnRemoveSelectedActionPerformed

    private void btnRemoveAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveAllActionPerformed
        DefaultTableModel entries = getTblValues();
        while(tblEntries.getRowCount() > 0)
            entries.removeRow(0);
    }//GEN-LAST:event_btnRemoveAllActionPerformed

    public void updateWatcher() {
        DefaultTableModel entries = getTblValues();

        for(int i = 0; i < entries.getRowCount(); i++) {
            if(entries.getValueAt(i, 0).equals("Bus") && plp.sim.bus.isInitialized(PLPToolbox.parseNum((String) entries.getValueAt(i, 1)))) {
                Long data = (Long) plp.sim.bus.read(PLPToolbox.parseNum((String) entries.getValueAt(i, 1)));
                entries.setValueAt((data != null) ? String.format("0x%08x", data) : "Uninitialized", i, 2);
                entries.setValueAt((data != null) ? String.format("%d", data) : "Uninitialized", i, 3);
            }
            else if(entries.getValueAt(i, 0).equals("Register") && plp.getArch().equals("plpmips")) {
                plptool.mips.SimCore mipsSim = (plptool.mips.SimCore) plp.sim;
                Long data = (Long) mipsSim.regfile.read(PLPToolbox.parseNum((String) entries.getValueAt(i, 1)));
                entries.setValueAt((data != null) ? String.format("0x%08x", data) : "Uninitialized", i, 2);
                entries.setValueAt((data != null) ? String.format("%d", data) : "Uninitialized", i, 3);
            }
        }
    }

    public DefaultTableModel getTblValues() {
        return (DefaultTableModel) tblEntries.getModel();
    }

    public javax.swing.JTable getTable() {
        return tblEntries;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnRemoveAll;
    private javax.swing.JButton btnRemoveSelected;
    private javax.swing.JComboBox cmbType;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAdd;
    private javax.swing.JLabel lblAddr;
    private javax.swing.JTable tblEntries;
    private javax.swing.JTextField txtAddr;
    // End of variables declaration//GEN-END:variables

    class CustomCellTextField extends JTextField {
       
        public CustomCellTextField(ProjectDriver plp) {
            super();
            
            addFocusListener(
                new CellFocusListener(plp)
            );
        }        
    }
    
    class CustomCellEditor extends DefaultCellEditor {
        CustomCellTextField textField;
        
        public CustomCellEditor(CustomCellTextField textField) {
            super(textField);
            this.textField = textField;
        }
    }
    
    class CellFocusListener implements FocusListener {
        
        private ProjectDriver plp;
        private DefaultTableModel values;
        private int row;
        private int col;
        Object oldVal;
        
        public CellFocusListener(ProjectDriver plp) {
            this.plp = plp;
        }
        
        public void focusGained(FocusEvent e) {
            row = plp.g_watcher.getTable().getSelectedRow();
            col = plp.g_watcher.getTable().getSelectedColumn();
            oldVal = plp.g_watcher.getTblValues().getValueAt(row, col);
        }
        
        public void focusLost(FocusEvent e) {
            // update simulator state
            values = plp.g_watcher.getTblValues();

            String type = (String) values.getValueAt(row, 0);
            
            long newVal = PLPToolbox.parseNum((String) values.getValueAt(row, col));
            long address = PLPToolbox.parseNum((String) values.getValueAt(row, 1));

            if(newVal == -1) {
                values.setValueAt(oldVal, row, col);
                plp.g_watcher.getTable().setModel(values);
                return;

            }  else {
                if(type.equals("Bus")) {
                    plp.sim.bus.write(address, newVal, false);
                } else if(type.equals("Register")) {
                    if(plp.getArch().equals("plpmips")) {
                        ((plptool.mips.SimCore) (plp.sim)).regfile.write(address, newVal, false);
                    }
                }
            }

            plp.updateComponents();
        }
    }
}
