/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ClassDialog.java
 *
 * Created on Apr 19, 2010, 11:23:48 AM
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
public class ClassDialog extends javax.swing.JDialog {

    /** Creates new form ClassDialog */
    public ClassDialog(java.awt.Frame parent) {
        super(parent, true);
        initComponents();

        // Events for jTable
        this.tblFunctions.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if (e.getClickCount() == 2)
                {
                    Point p = e.getPoint();
                    int row = tblFunctions.rowAtPoint(p);
                    int id = Db.getId(tblFunctions.getValueAt(row, 0));
                    editFunction(id);
                    G.setRowSelectedById(tblFunctions, id);
                }
            }
        });

        this.tblVariables.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if (e.getClickCount() == 2)
                {
                    Point p = e.getPoint();
                    int row = tblVariables.rowAtPoint(p);
                    int id = Db.getId(tblVariables.getValueAt(row, 0));
                    editVariable(id);
                    G.setRowSelectedById(tblVariables, id);
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

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txJavaName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txVbName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txPackage = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        tabbedPane = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        cmdAddVar = new javax.swing.JButton();
        cmdRemoveVar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVariables = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        cmdAddFunction = new javax.swing.JButton();
        cmdRemoveFunction = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFunctions = new javax.swing.JTable();

        jPanel4.setName("jPanel4"); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(450, 396));
        setName("Form"); // NOI18N

        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txJavaName.setName("txJavaName"); // NOI18N
        jPanel1.add(txJavaName, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 286, -1));

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(buggymastercode.BuggyMasterCodeApp.class).getContext().getResourceMap(ClassDialog.class);
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        txVbName.setText(resourceMap.getString("txVbName.text")); // NOI18N
        txVbName.setName("txVbName"); // NOI18N
        jPanel1.add(txVbName, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 286, -1));

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        txPackage.setName("txPackage"); // NOI18N
        jPanel1.add(txPackage, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 286, -1));

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jPanel3.setName("jPanel3"); // NOI18N

        jPanel5.setName("jPanel5"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(buggymastercode.BuggyMasterCodeApp.class).getContext().getActionMap(ClassDialog.class, this);
        jButton1.setAction(actionMap.get("saveClass")); // NOI18N
        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(186, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(197, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        tabbedPane.setName("tabbedPane"); // NOI18N

        jPanel6.setName("jPanel6"); // NOI18N

        jPanel8.setName("jPanel8"); // NOI18N

        cmdAddVar.setAction(actionMap.get("addVariable")); // NOI18N
        cmdAddVar.setText(resourceMap.getString("cmdAddVar.text")); // NOI18N
        cmdAddVar.setName("cmdAddVar"); // NOI18N

        cmdRemoveVar.setAction(actionMap.get("deleteVariable")); // NOI18N
        cmdRemoveVar.setText(resourceMap.getString("cmdRemoveVar.text")); // NOI18N
        cmdRemoveVar.setName("cmdRemoveVar"); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdAddVar)
                .addGap(7, 7, 7)
                .addComponent(cmdRemoveVar)
                .addContainerGap(172, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdAddVar)
                    .addComponent(cmdRemoveVar))
                .addGap(165, 165, 165))
        );

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        tblVariables.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "VB Name", "Java Name", "Data Type"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblVariables.setName("tblVariables"); // NOI18N
        jScrollPane2.setViewportView(tblVariables);
        tblVariables.getColumnModel().getColumn(0).setResizable(false);
        tblVariables.getColumnModel().getColumn(0).setPreferredWidth(0);
        tblVariables.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("tblVariables.columnModel.title2")); // NOI18N
        tblVariables.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("tblVariables.columnModel.title0")); // NOI18N
        tblVariables.getColumnModel().getColumn(2).setHeaderValue(resourceMap.getString("tblVariables.columnModel.title1")); // NOI18N
        tblVariables.getColumnModel().getColumn(3).setMinWidth(100);
        tblVariables.getColumnModel().getColumn(3).setHeaderValue(resourceMap.getString("tblVariables.columnModel.title3")); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
        );

        tabbedPane.addTab(resourceMap.getString("jPanel6.TabConstraints.tabTitle"), jPanel6); // NOI18N

        jPanel2.setName("jPanel2"); // NOI18N

        jPanel7.setName("jPanel7"); // NOI18N

        cmdAddFunction.setAction(actionMap.get("addFunction")); // NOI18N
        cmdAddFunction.setText(resourceMap.getString("cmdAddFunction.text")); // NOI18N
        cmdAddFunction.setName("cmdAddFunction"); // NOI18N

        cmdRemoveFunction.setAction(actionMap.get("deleteFunction")); // NOI18N
        cmdRemoveFunction.setText(resourceMap.getString("cmdRemoveFunction.text")); // NOI18N
        cmdRemoveFunction.setName("cmdRemoveFunction"); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdAddFunction)
                .addGap(7, 7, 7)
                .addComponent(cmdRemoveFunction)
                .addContainerGap(172, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdAddFunction)
                    .addComponent(cmdRemoveFunction))
                .addGap(165, 165, 165))
        );

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        tblFunctions.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "VB Name", "Java Name", "Data Type"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblFunctions.setName("tblFunctions"); // NOI18N
        jScrollPane1.setViewportView(tblFunctions);
        tblFunctions.getColumnModel().getColumn(0).setResizable(false);
        tblFunctions.getColumnModel().getColumn(0).setPreferredWidth(0);
        tblFunctions.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("tblFunctions.columnModel.title2")); // NOI18N
        tblFunctions.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("tblFunctions.columnModel.title0")); // NOI18N
        tblFunctions.getColumnModel().getColumn(2).setHeaderValue(resourceMap.getString("tblFunctions.columnModel.title1")); // NOI18N
        tblFunctions.getColumnModel().getColumn(3).setMinWidth(100);
        tblFunctions.getColumnModel().getColumn(3).setHeaderValue(resourceMap.getString("tblFunctions.columnModel.title3")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
        );

        tabbedPane.addTab(resourceMap.getString("jPanel2.TabConstraints.tabTitle"), jPanel2); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(tabbedPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdAddFunction;
    private javax.swing.JButton cmdAddVar;
    private javax.swing.JButton cmdRemoveFunction;
    private javax.swing.JButton cmdRemoveVar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JTable tblFunctions;
    private javax.swing.JTable tblVariables;
    private javax.swing.JTextField txJavaName;
    private javax.swing.JTextField txPackage;
    private javax.swing.JTextField txVbName;
    // End of variables declaration//GEN-END:variables

    private void initDialog () {
        loadFunctions();
        loadVariables();
    }

    public int getId() {
        return m_id;
    }

    public boolean edit(int id) {
        if (id != Db.CS_NO_ID) {
            String sqlstmt = "select cl_packagename, cl_vbname, cl_javaname from tclass where cl_id = " + ((Integer)id).toString();
            DBRecordSet rs = new DBRecordSet();
            if (!Db.db.openRs(sqlstmt, rs)) {return false;}

            if (rs.getRows().isEmpty()) {
                m_id = Db.CS_NO_ID;
                this.txPackage.setText("");
                this.txVbName.setText("");
                this.txJavaName.setText("");
            }
            else {
                m_id = id;
                this.txPackage.setText(rs.getRows().get(0).get("cl_packagename").toString());
                this.txVbName.setText(rs.getRows().get(0).get("cl_vbname").toString());
                this.txJavaName.setText(rs.getRows().get(0).get("cl_javaname").toString());
            }
        }
        else {
            m_id = Db.CS_NO_ID;
            this.txPackage.setText("");
            this.txVbName.setText("");
            this.txJavaName.setText("");
        }
        initDialog();
        return true;
    }

    public void editVariable(int id) {
        if (variableDialog == null) {
            JFrame mainFrame = BuggyMasterCodeApp.getApplication().getMainFrame();
            variableDialog = new VariableDialog(mainFrame);
            variableDialog.setLocationRelativeTo(mainFrame);
        }
        variableDialog.edit(id, m_id);
        BuggyMasterCodeApp.getApplication().show(variableDialog);
        loadVariables();
    }

    public void editFunction(int id) {
        if (functionDialog == null) {
            JFrame mainFrame = BuggyMasterCodeApp.getApplication().getMainFrame();
            functionDialog = new FunctionDialog(mainFrame);
            functionDialog.setLocationRelativeTo(mainFrame);
        }
        functionDialog.edit(id, m_id);
        BuggyMasterCodeApp.getApplication().show(functionDialog);
        loadFunctions();
    }

    @Action
    public void addVariable() {
        if (variableDialog == null) {
            JFrame mainFrame = BuggyMasterCodeApp.getApplication().getMainFrame();
            variableDialog = new VariableDialog(mainFrame);
            variableDialog.setLocationRelativeTo(mainFrame);
        }
        variableDialog.edit(Db.CS_NO_ID, m_id);
        BuggyMasterCodeApp.getApplication().show(variableDialog);
        loadVariables();
        G.setRowSelectedById(tblVariables, variableDialog.getId());
    }

    @Action
    public void addFunction() {
        if (functionDialog == null) {
            JFrame mainFrame = BuggyMasterCodeApp.getApplication().getMainFrame();
            functionDialog = new FunctionDialog(mainFrame);
            functionDialog.setLocationRelativeTo(mainFrame);
        }
        functionDialog.edit(Db.CS_NO_ID, m_id);
        BuggyMasterCodeApp.getApplication().show(functionDialog);
        loadFunctions();
        G.setRowSelectedById(tblFunctions, functionDialog.getId());
    }

    @Action
    public void saveClass() {
        if (validateClass()) {

            ClassObject cl = new ClassObject();
            cl.setId(m_id);
            cl.setPackageName(this.txPackage.getText());
            cl.setVbName(this.txVbName.getText());
            cl.setJavaName(this.txJavaName.getText());
            if (cl.saveClass()) {
                m_id = cl.getId();
            };
        }
    }

    private boolean validateClass() {
        if (this.txVbName.getText().length() == 0) {
            G.showInfo("The vb name field is required");
            return false;
        }
        if (this.txJavaName.getText().length() == 0) {
            G.showInfo("The java name field is required");
            return false;
        }
        return true;
    }

    private boolean loadFunctions() {
        try {
            DefaultTableModel model = (DefaultTableModel)this.tblFunctions.getModel();
            model.getDataVector().removeAllElements();

            String sqlstmt = "select fun_id, fun_vbname, fun_javaname, fun_datatype from tfunction where cl_id = "
                                + ((Integer)m_id).toString() ;

            DBRecordSet rs = new DBRecordSet();
            if (!Db.db.openRs(sqlstmt, rs)) {return false;}

            // print the results
            for (Iterator<DynaBean> i = rs.getRows().iterator(); i.hasNext();) {
                DynaBean row = i.next();
                model.addRow(new Object[]{row.get("fun_id").toString(),
                                          row.get("fun_vbname").toString(),
                                          row.get("fun_javaname").toString(),
                                          row.get("fun_datatype").toString()});
            }
            return true;
        }
        catch(Exception ex) {
            BuggyMasterCodeApp.getLogger().log(Level.WARNING, "loading functions failed", ex);
            return false;
        }
    }

    private boolean loadVariables() {
        try {
            DefaultTableModel model = (DefaultTableModel)this.tblVariables.getModel();
            model.getDataVector().removeAllElements();

            String sqlstmt = "select var_id, var_vbname, var_javaname, var_datatype from tvariable where fun_id = 0 and cl_id = "
                                + ((Integer)m_id).toString() ;

            DBRecordSet rs = new DBRecordSet();
            if (!Db.db.openRs(sqlstmt, rs)) {return false;}

            // print the results
            for (Iterator<DynaBean> i = rs.getRows().iterator(); i.hasNext();) {
                DynaBean row = i.next();
                model.addRow(new Object[]{row.get("var_id").toString(),
                                          row.get("var_vbname").toString(),
                                          row.get("var_javaname").toString(),
                                          row.get("var_datatype").toString()});
            }
            return true;
        }
        catch(Exception ex) {
            BuggyMasterCodeApp.getLogger().log(Level.WARNING, "loading functions failed", ex);
            return false;
        }
    }

    @Action
    public void deleteVariable() {
        if (this.tblVariables.getRowCount() > 0) {
            int indexRow = this.tblVariables.getSelectedRow();
            Integer id = Db.getId(this.tblVariables.getValueAt(indexRow, 0));

            VariableObject var = new VariableObject();
            var.setId(id);
            if (var.deleteVariable()) {
                DefaultTableModel model = (DefaultTableModel)this.tblVariables.getModel();
                model.removeRow(indexRow);
            }
        }
    }

    @Action
    public void deleteFunction() {
        if (this.tblFunctions.getRowCount() > 0) {
            int indexRow = this.tblFunctions.getSelectedRow();
            Integer id = Db.getId(this.tblFunctions.getValueAt(indexRow, 0));

            FunctionObject fun = new FunctionObject();
            fun.setId(id);
            if (fun.deleteFunction()) {
                DefaultTableModel model = (DefaultTableModel)this.tblFunctions.getModel();
                model.removeRow(indexRow);
            }
        }
    }

    private VariableDialog variableDialog;
    private FunctionDialog functionDialog;
    private int m_id;
}