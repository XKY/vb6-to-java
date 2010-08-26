/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Dictionary.java
 *
 * Created on Apr 19, 2010, 10:23:45 AM
 */

package buggymastercode;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.logging.Level;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.beanutils.DynaBean;
import org.jdesktop.application.Action;

/**
 *
 * @author jalvarez
 */
public class Dictionary extends javax.swing.JDialog {

    /** Creates new form Dictionary */
    public Dictionary(java.awt.Frame parent) {
        super(parent, true);
        initComponents();

        // Events for jTable
        this.tblClasses.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if (e.getClickCount() == 2)
                {
                    Point p = e.getPoint();
                    int row = tblClasses.rowAtPoint(p);
                    int id = Db.getId(tblClasses.getValueAt(row, 0));
                    editClass(id);
                    G.setRowSelectedById(tblClasses, id);
                }
            }
        });
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        cmdNew = new javax.swing.JButton();
        cmdDelete = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClasses = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbPackages = new javax.swing.JLabel();
        lbClasses = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbFunctions = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbVariables = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(buggymastercode.BuggyMasterCodeApp.class).getContext().getResourceMap(Dictionary.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setMinimumSize(new java.awt.Dimension(600, 300));
        setName("Form"); // NOI18N

        jToolBar1.setRollover(true);
        jToolBar1.setName("jToolBar1"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(buggymastercode.BuggyMasterCodeApp.class).getContext().getActionMap(Dictionary.class, this);
        cmdNew.setAction(actionMap.get("newClass")); // NOI18N
        cmdNew.setIcon(resourceMap.getIcon("cmdNew.icon")); // NOI18N
        cmdNew.setText(resourceMap.getString("cmdNew.text")); // NOI18N
        cmdNew.setFocusable(false);
        cmdNew.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmdNew.setName("cmdNew"); // NOI18N
        cmdNew.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(cmdNew);

        cmdDelete.setAction(actionMap.get("deleteClass")); // NOI18N
        cmdDelete.setIcon(resourceMap.getIcon("cmdDelete.icon")); // NOI18N
        cmdDelete.setText(resourceMap.getString("cmdDelete.text")); // NOI18N
        cmdDelete.setFocusable(false);
        cmdDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmdDelete.setName("cmdDelete"); // NOI18N
        cmdDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(cmdDelete);

        jPanel1.setBackground(resourceMap.getColor("jPanel1.background")); // NOI18N
        jPanel1.setName("jPanel1"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        tblClasses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Packages", "Vb Class", "Java Class", "Functions", "Variables"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblClasses.setName("tblClasses"); // NOI18N
        jScrollPane1.setViewportView(tblClasses);
        tblClasses.getColumnModel().getColumn(0).setMinWidth(60);
        tblClasses.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("tblClasses.columnModel.title4")); // NOI18N
        tblClasses.getColumnModel().getColumn(1).setMinWidth(100);
        tblClasses.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("tblClasses.columnModel.title5")); // NOI18N
        tblClasses.getColumnModel().getColumn(2).setMinWidth(100);
        tblClasses.getColumnModel().getColumn(2).setPreferredWidth(3000);
        tblClasses.getColumnModel().getColumn(2).setHeaderValue(resourceMap.getString("tblClasses.columnModel.title0")); // NOI18N
        tblClasses.getColumnModel().getColumn(3).setMinWidth(100);
        tblClasses.getColumnModel().getColumn(3).setPreferredWidth(3000);
        tblClasses.getColumnModel().getColumn(3).setHeaderValue(resourceMap.getString("tblClasses.columnModel.title1")); // NOI18N
        tblClasses.getColumnModel().getColumn(4).setMinWidth(100);
        tblClasses.getColumnModel().getColumn(4).setPreferredWidth(800);
        tblClasses.getColumnModel().getColumn(4).setHeaderValue(resourceMap.getString("tblClasses.columnModel.title2")); // NOI18N
        tblClasses.getColumnModel().getColumn(5).setMinWidth(100);
        tblClasses.getColumnModel().getColumn(5).setPreferredWidth(800);
        tblClasses.getColumnModel().getColumn(5).setHeaderValue(resourceMap.getString("tblClasses.columnModel.title3")); // NOI18N

        jPanel2.setBackground(resourceMap.getColor("jPanel2.background")); // NOI18N
        jPanel2.setName("jPanel2"); // NOI18N

        jLabel1.setBackground(resourceMap.getColor("jLabel1.background")); // NOI18N
        jLabel1.setFont(resourceMap.getFont("jLabel1.font")); // NOI18N
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        lbPackages.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbPackages.setText(resourceMap.getString("lbPackages.text")); // NOI18N
        lbPackages.setName("lbPackages"); // NOI18N

        lbClasses.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbClasses.setText(resourceMap.getString("lbClasses.text")); // NOI18N
        lbClasses.setName("lbClasses"); // NOI18N

        jLabel2.setFont(resourceMap.getFont("jLabel2.font")); // NOI18N
        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        lbFunctions.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbFunctions.setText(resourceMap.getString("lbFunctions.text")); // NOI18N
        lbFunctions.setName("lbFunctions"); // NOI18N

        jLabel3.setFont(resourceMap.getFont("jLabel3.font")); // NOI18N
        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        lbVariables.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbVariables.setText(resourceMap.getString("lbVariables.text")); // NOI18N
        lbVariables.setName("lbVariables"); // NOI18N

        jLabel4.setFont(resourceMap.getFont("jLabel4.font")); // NOI18N
        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(lbVariables, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(lbFunctions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(lbClasses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(lbPackages, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(403, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lbClasses, lbFunctions, lbPackages, lbVariables});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbPackages))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbClasses))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbFunctions))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lbVariables))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(492, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdDelete;
    private javax.swing.JButton cmdNew;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lbClasses;
    private javax.swing.JLabel lbFunctions;
    private javax.swing.JLabel lbPackages;
    private javax.swing.JLabel lbVariables;
    private javax.swing.JTable tblClasses;
    // End of variables declaration//GEN-END:variables

    public boolean initDialog () {
        loadClasses();
        return true;
    }

    private boolean loadClasses() {
        try {
            lbPackages.setText("0");
            lbClasses.setText("0");
            lbFunctions.setText("0");
            lbVariables.setText("0");

            DefaultTableModel model = (DefaultTableModel)this.tblClasses.getModel();
            model.getDataVector().removeAllElements();

            String sqlstmt = "select cl_id, cl_packagename, cl_vbname, cl_javaname from tclass order by cl_packagename, cl_javaname";

            DBRecordSet rs = new DBRecordSet();
            if (!Db.db.openRs(sqlstmt, rs)) {return false;}

            // print the results
            for (Iterator<DynaBean> i = rs.getRows().iterator(); i.hasNext();) {
                DynaBean row = i.next();
                model.addRow(new Object[]{row.get("cl_id").toString(),
                                          row.get("cl_packagename").toString(),
                                          row.get("cl_vbname").toString(),
                                          row.get("cl_javaname").toString()});
            }

            //------------------------------------------------------------------
            // packages
            sqlstmt = "select count(distinct cl_packagename) as count from tclass";
            rs = new DBRecordSet();
            if (!Db.db.openRs(sqlstmt, rs)) {return false;}
            if (!rs.getRows().isEmpty()) {
                lbPackages.setText(rs.getRows().get(0).get("count").toString());
            }            
            //------------------------------------------------------------------
            // classes
            sqlstmt = "select count(cl_id) as count from tclass";
            rs = new DBRecordSet();
            if (!Db.db.openRs(sqlstmt, rs)) {return false;}
            if (!rs.getRows().isEmpty()) {
                lbClasses.setText(rs.getRows().get(0).get("count").toString());
            }
            //------------------------------------------------------------------
            // function
            sqlstmt = "select count(fun_id) as count from tfunction";
            rs = new DBRecordSet();
            if (!Db.db.openRs(sqlstmt, rs)) {return false;}
            if (!rs.getRows().isEmpty()) {
                lbFunctions.setText(rs.getRows().get(0).get("count").toString());
            }            
            //------------------------------------------------------------------
            // variables
            sqlstmt = "select count(var_id) as count from tvariable";
            rs = new DBRecordSet();
            if (!Db.db.openRs(sqlstmt, rs)) {return false;}
            if (!rs.getRows().isEmpty()) {
                lbVariables.setText(rs.getRows().get(0).get("count").toString());
            }            
            //------------------------------------------------------------------
            return true;
        }
        catch(Exception ex) {
            BuggyMasterCodeApp.getLogger().log(Level.WARNING, "loading classes failed", ex);
            return false;
        }
    }

    public void editClass(int id) {
        if (classDialog == null) {
            JFrame mainFrame = BuggyMasterCodeApp.getApplication().getMainFrame();
            classDialog = new ClassDialog(mainFrame);
            classDialog.setLocationRelativeTo(mainFrame);
        }
        classDialog.edit(id);
        BuggyMasterCodeApp.getApplication().show(classDialog);
        loadClasses();
    }

    @Action
    public void newClass() {
        if (classDialog == null) {
            JFrame mainFrame = BuggyMasterCodeApp.getApplication().getMainFrame();
            classDialog = new ClassDialog(mainFrame);
            classDialog.setLocationRelativeTo(mainFrame);
        }
        classDialog.edit(Db.CS_NO_ID);
        BuggyMasterCodeApp.getApplication().show(classDialog);
        loadClasses();
        G.setRowSelectedById(tblClasses, classDialog.getId());
    }

    @Action
    public void deleteClass() {
        if (this.tblClasses.getRowCount() > 0) {
            int indexRow = this.tblClasses.getSelectedRow();
            Integer id = Db.getId(this.tblClasses.getValueAt(indexRow, 0));

            ClassObject cl = new ClassObject();
            cl.setId(id);
            if (cl.deleteClass()) {
                DefaultTableModel model = (DefaultTableModel)this.tblClasses.getModel();
                model.removeRow(indexRow);
            }
        }
    }

    private ClassDialog classDialog;

}
