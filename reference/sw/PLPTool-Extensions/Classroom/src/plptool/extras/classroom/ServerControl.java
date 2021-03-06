/*
    Copyright 2012 PLP Contributors

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

package plptool.extras.classroom;

import plptool.PLPToolbox;
import plptool.gui.ProjectDriver;
import javax.swing.table.*;

/**
 *
 * @author Wira
 */
public class ServerControl extends javax.swing.JFrame {
    public static final int MAX_CLIENTS = 256;
    private ProjectDriver plp;
    private ServerService service;
    private MyIP myIPFrame;
    private State state;

    public enum State {
        IDLE,
        LISTENING,
        SOLICITING,
        LIVE
    }

    /** Creates new form ServerControl */
    public ServerControl(ProjectDriver plp) {
        initComponents();
        this.plp = plp;
        setStates(false);
        state = State.IDLE;
        myIPFrame = new MyIP();
        myIPFrame.dispose();
        myIPFrame.setUndecorated(true);
        PLPToolbox.attachHideOnEscapeListener(myIPFrame);
    }

    public synchronized void update() {
        Object[][] clients = PLPToolbox.mapToArray(service.getClients());
        DefaultTableModel tbl = (DefaultTableModel) tblClients.getModel();
        ClientService c;
        while(tbl.getRowCount() > 0)
            tbl.removeRow(0);
        for(int i = 0; i < clients.length; i++) {
            c = (ClientService) clients[i][1];
            Object[] row = {c.getClientID(), c.getClientIP(),
                            c.getClientName(), false, false};
            tbl.addRow(row);
        }
        tblClients.setModel(tbl);
    }

    public void startListening() {
        service = new ServerService(this, plp,
                Integer.parseInt(txtPort.getText()), 256);
        service.start();
        state = State.LISTENING;
        setStates(true);
    }

    public void stopListening() {
        service.stopListening();
        state = State.IDLE;
        setStates(false);
    }

    public final void setStates(boolean c) {
        tabbedPane.setEnabledAt(1, c);
        tabbedPane.setEnabledAt(2, c);
        paneCollabControl.setEnabled(c);
        if(!c)
            tabbedPane.setSelectedIndex(0);
        txtPort.setEnabled(!c);
        tglGoLive.setSelected(c);
    }

    public State getServerState() {
        return state;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lblStatus = new javax.swing.JLabel();
        tabbedPane = new javax.swing.JTabbedPane();
        paneServerConfig = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtPort = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tglGoLive = new javax.swing.JToggleButton();
        btnClose = new javax.swing.JButton();
        btnShowIP = new javax.swing.JButton();
        paneClients = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClients = new javax.swing.JTable();
        btnKick = new javax.swing.JButton();
        btnKickBan = new javax.swing.JButton();
        paneCollabControl = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        radioSingleContributor = new javax.swing.JRadioButton();
        radioMultipleContributors = new javax.swing.JRadioButton();
        radioFreeForAll = new javax.swing.JRadioButton();
        txtMaximumContributors = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tglSolicit = new javax.swing.JToggleButton();
        tglLive = new javax.swing.JToggleButton();
        jLabel5 = new javax.swing.JLabel();

        setTitle("Classroom Server Control");

        lblStatus.setText("Server status :");

        jLabel1.setText("Listen on port :");

        txtPort.setText("11000");

        jLabel2.setText("Server options :");

        tglGoLive.setText("GO LIVE");
        tglGoLive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tglGoLiveActionPerformed(evt);
            }
        });

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnShowIP.setText("Show IP");
        btnShowIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowIPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paneServerConfigLayout = new javax.swing.GroupLayout(paneServerConfig);
        paneServerConfig.setLayout(paneServerConfigLayout);
        paneServerConfigLayout.setHorizontalGroup(
            paneServerConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneServerConfigLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneServerConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneServerConfigLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtPort, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE))
                    .addComponent(jLabel2)
                    .addGroup(paneServerConfigLayout.createSequentialGroup()
                        .addComponent(tglGoLive)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnShowIP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 281, Short.MAX_VALUE)
                        .addComponent(btnClose)))
                .addContainerGap())
        );
        paneServerConfigLayout.setVerticalGroup(
            paneServerConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneServerConfigLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneServerConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addGroup(paneServerConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tglGoLive)
                    .addComponent(btnClose)
                    .addComponent(btnShowIP))
                .addContainerGap())
        );

        tabbedPane.addTab("Server Config", paneServerConfig);

        tblClients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "IP Addr", "Nickname", "Muted", "LIVE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblClients.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblClientsMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblClients);

        btnKick.setText("KICK");
        btnKick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKickActionPerformed(evt);
            }
        });

        btnKickBan.setText("KICKBAN");

        javax.swing.GroupLayout paneClientsLayout = new javax.swing.GroupLayout(paneClients);
        paneClients.setLayout(paneClientsLayout);
        paneClientsLayout.setHorizontalGroup(
            paneClientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneClientsLayout.createSequentialGroup()
                .addContainerGap(362, Short.MAX_VALUE)
                .addComponent(btnKickBan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnKick)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
        );
        paneClientsLayout.setVerticalGroup(
            paneClientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneClientsLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneClientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKick)
                    .addComponent(btnKickBan))
                .addContainerGap())
        );

        tabbedPane.addTab("Clients", paneClients);

        paneCollabControl.setEnabled(false);

        jLabel3.setText("Mode :");

        buttonGroup1.add(radioSingleContributor);
        radioSingleContributor.setSelected(true);
        radioSingleContributor.setText("Single contributor");

        buttonGroup1.add(radioMultipleContributors);
        radioMultipleContributors.setText("Multiple contributors");

        buttonGroup1.add(radioFreeForAll);
        radioFreeForAll.setText("Free for All");

        jLabel4.setText("maximum contributors");

        tglSolicit.setText("SOLICIT");
        tglSolicit.setPreferredSize(new java.awt.Dimension(100, 23));
        tglSolicit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tglSolicitActionPerformed(evt);
            }
        });

        tglLive.setText("LIVE");
        tglLive.setEnabled(false);
        tglLive.setPreferredSize(new java.awt.Dimension(100, 23));
        tglLive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tglLiveActionPerformed(evt);
            }
        });

        jLabel5.setText("Currently live client ID(s):");

        javax.swing.GroupLayout paneCollabControlLayout = new javax.swing.GroupLayout(paneCollabControl);
        paneCollabControl.setLayout(paneCollabControlLayout);
        paneCollabControlLayout.setHorizontalGroup(
            paneCollabControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneCollabControlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneCollabControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneCollabControlLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(paneCollabControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radioFreeForAll)
                            .addGroup(paneCollabControlLayout.createSequentialGroup()
                                .addComponent(radioMultipleContributors)
                                .addGap(18, 18, 18)
                                .addComponent(txtMaximumContributors, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4))
                            .addComponent(radioSingleContributor)))
                    .addGroup(paneCollabControlLayout.createSequentialGroup()
                        .addComponent(tglSolicit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tglLive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5))
                .addContainerGap(147, Short.MAX_VALUE))
        );
        paneCollabControlLayout.setVerticalGroup(
            paneCollabControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneCollabControlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneCollabControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(radioSingleContributor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneCollabControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioMultipleContributors)
                    .addComponent(txtMaximumContributors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radioFreeForAll)
                .addGap(9, 9, 9)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(paneCollabControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tglSolicit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tglLive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tabbedPane.addTab("Collaboration Control", paneCollabControl);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                    .addComponent(lblStatus))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tglGoLiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tglGoLiveActionPerformed
        if(tglGoLive.isSelected())
            startListening();
        else
            stopListening();
    }//GEN-LAST:event_tglGoLiveActionPerformed

    private void tglSolicitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tglSolicitActionPerformed
        state = tglSolicit.isSelected() ? State.SOLICITING : state;
        if(state != State.SOLICITING)
            tglLive.setEnabled(false);
        else
            tglLive.setEnabled(true);
    }//GEN-LAST:event_tglSolicitActionPerformed

    private void tglLiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tglLiveActionPerformed
        state = tglLive.isSelected() ? State.LIVE : state;
    }//GEN-LAST:event_tglLiveActionPerformed

    private void tblClientsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientsMousePressed

    }//GEN-LAST:event_tblClientsMousePressed

    private void btnKickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKickActionPerformed
        int selectedRow = tblClients.getSelectedRow();
        if(selectedRow > -1) {
            int ID = (Integer) tblClients.getValueAt(selectedRow, 0);
            service.removeClient(ID);
        }
    }//GEN-LAST:event_btnKickActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        if(state == State.LISTENING &&
           !PLPToolbox.showYesNoDialog(this, "This will shut down the server. Are you sure?", "Shutting down classroom server"))
            return;
        if(state == State.LISTENING)
            stopListening();
        this.setVisible(false);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnShowIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowIPActionPerformed
        myIPFrame.setVisible(true);
    }//GEN-LAST:event_btnShowIPActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnKick;
    private javax.swing.JButton btnKickBan;
    private javax.swing.JButton btnShowIP;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JPanel paneClients;
    private javax.swing.JPanel paneCollabControl;
    private javax.swing.JPanel paneServerConfig;
    private javax.swing.JRadioButton radioFreeForAll;
    private javax.swing.JRadioButton radioMultipleContributors;
    private javax.swing.JRadioButton radioSingleContributor;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JTable tblClients;
    private javax.swing.JToggleButton tglGoLive;
    private javax.swing.JToggleButton tglLive;
    private javax.swing.JToggleButton tglSolicit;
    private javax.swing.JTextField txtMaximumContributors;
    private javax.swing.JTextField txtPort;
    // End of variables declaration//GEN-END:variables

}
