/*
 * BuggyMasterCodeView.java
 */

package buggymastercode;

import java.io.IOException;
import java.util.logging.Logger;
import org.jdesktop.application.Action;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.TaskMonitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import javax.swing.filechooser.FileFilter;
import java.util.ArrayList;
import java.util.logging.Level;
import javax.swing.DefaultListModel;
import javax.swing.Timer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import org.fife.ui.rtextarea.*;
import org.fife.ui.rsyntaxtextarea.*;


/**
 * The application's main frame.
 */
public class BuggyMasterCodeView extends FrameView {

    public BuggyMasterCodeView(SingleFrameApplication app) {
        super(app);

        initComponents();

        ResourceMap resourceMap = getResourceMap();
        getFrame().setIconImage(resourceMap.getImageIcon("app.icon").getImage());

        cbFiles.removeAllItems();
        cbProject.removeAllItems();
        cmdCancel.setEnabled(false);

        // status bar initialization - message timeout, idle icon and busy animation, etc
        int messageTimeout = resourceMap.getInteger("StatusBar.messageTimeout");
        messageTimer = new Timer(messageTimeout, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusMessageLabel.setText("");
            }
        });
        messageTimer.setRepeats(false);
        int busyAnimationRate = resourceMap.getInteger("StatusBar.busyAnimationRate");
        for (int i = 0; i < busyIcons.length; i++) {
            busyIcons[i] = resourceMap.getIcon("StatusBar.busyIcons[" + i + "]");
        }
        busyIconTimer = new Timer(busyAnimationRate, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                busyIconIndex = (busyIconIndex + 1) % busyIcons.length;
                statusAnimationLabel.setIcon(busyIcons[busyIconIndex]);
            }
        });
        idleIcon = resourceMap.getIcon("StatusBar.idleIcon");
        statusAnimationLabel.setIcon(idleIcon);
        progressBar.setVisible(false);

        // connecting action tasks to status bar via TaskMonitor
        TaskMonitor taskMonitor = new TaskMonitor(getApplication().getContext());
        taskMonitor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                String propertyName = evt.getPropertyName();
                if ("started".equals(propertyName)) {
                    if (!busyIconTimer.isRunning()) {
                        statusAnimationLabel.setIcon(busyIcons[0]);
                        busyIconIndex = 0;
                        busyIconTimer.start();
                    }
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(true);
                } else if ("done".equals(propertyName)) {
                    busyIconTimer.stop();
                    statusAnimationLabel.setIcon(idleIcon);
                    progressBar.setVisible(false);
                    progressBar.setValue(0);
                } else if ("message".equals(propertyName)) {
                    String text = (String)(evt.getNewValue());
                    statusMessageLabel.setText((text == null) ? "" : text);
                    messageTimer.restart();
                } else if ("progress".equals(propertyName)) {
                    int value = (Integer)(evt.getNewValue());
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(false);
                    progressBar.setValue(value);
                }
            }
        });

        cbFiles.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent ie) {
                showFiles(cbFiles.getSelectedIndex());
            }
        });
    }

    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = BuggyMasterCodeApp.getApplication().getMainFrame();
            aboutBox = new BuggyMasterCodeAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        BuggyMasterCodeApp.getApplication().show(aboutBox);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        cmdChooseFile = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbProject = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        lbPackage = new javax.swing.JLabel();
        cbFiles = new javax.swing.JComboBox();
        cmdTranslate = new javax.swing.JButton();
        cmdCancel = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cmdChooseFolderOutput = new javax.swing.JButton();
        txOutputFolder = new javax.swing.JTextField();
        tabMain = new javax.swing.JTabbedPane();
        pnProgress = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lsFiles = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        lsJavaSource = new javax.swing.JList();
        jScrollPane4 = new javax.swing.JScrollPane();
        lsVbSource = new javax.swing.JList();
        pnCode = new javax.swing.JSplitPane();
        txSourceCode = new RSyntaxTextArea();
        txSourceCode.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_VB);
        jScrollPane1 = new RTextScrollPane(txSourceCode);
        txSourceCodeJava = new RSyntaxTextArea();
        txSourceCodeJava.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
        jScrollPane2 = new RTextScrollPane(txSourceCodeJava);
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        toolMenu = new javax.swing.JMenu();
        dictionaryMenu = new javax.swing.JMenuItem();
        preferencesMenu = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();
        statusPanel = new javax.swing.JPanel();
        javax.swing.JSeparator statusPanelSeparator = new javax.swing.JSeparator();
        statusMessageLabel = new javax.swing.JLabel();
        statusAnimationLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(buggymastercode.BuggyMasterCodeApp.class).getContext().getResourceMap(BuggyMasterCodeView.class);
        mainPanel.setBackground(resourceMap.getColor("mainPanel.background")); // NOI18N
        mainPanel.setName("mainPanel"); // NOI18N
        mainPanel.setLayout(new java.awt.BorderLayout());

        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 120));

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(buggymastercode.BuggyMasterCodeApp.class).getContext().getActionMap(BuggyMasterCodeView.class, this);
        cmdChooseFile.setAction(actionMap.get("showChooseFileDialog")); // NOI18N
        cmdChooseFile.setText(resourceMap.getString("cmdChooseFile.text")); // NOI18N
        cmdChooseFile.setName("cmdChooseFile"); // NOI18N

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        cbProject.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbProject.setName("cbProject"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setMinimumSize(new java.awt.Dimension(44, 22));
        jLabel2.setName("jLabel2"); // NOI18N
        jLabel2.setPreferredSize(new java.awt.Dimension(44, 22));

        lbPackage.setFont(resourceMap.getFont("lbPackage.font")); // NOI18N
        lbPackage.setText(resourceMap.getString("lbPackage.text")); // NOI18N
        lbPackage.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbPackage.setMinimumSize(new java.awt.Dimension(4, 22));
        lbPackage.setName("lbPackage"); // NOI18N
        lbPackage.setPreferredSize(new java.awt.Dimension(4, 22));

        cbFiles.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbFiles.setName("cbFiles"); // NOI18N

        cmdTranslate.setAction(actionMap.get("translateFromList")); // NOI18N
        cmdTranslate.setText(resourceMap.getString("cmdTranslate.text")); // NOI18N
        cmdTranslate.setName("cmdTranslate"); // NOI18N

        cmdCancel.setAction(actionMap.get("cancelTranslate")); // NOI18N
        cmdCancel.setText(resourceMap.getString("cmdCancel.text")); // NOI18N
        cmdCancel.setName("cmdCancel"); // NOI18N

        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setMinimumSize(new java.awt.Dimension(44, 22));
        jLabel4.setName("jLabel4"); // NOI18N
        jLabel4.setPreferredSize(new java.awt.Dimension(44, 22));

        cmdChooseFolderOutput.setAction(actionMap.get("showChooseFolderDialog")); // NOI18N
        cmdChooseFolderOutput.setText(resourceMap.getString("cmdChooseFolderOutput.text")); // NOI18N
        cmdChooseFolderOutput.setName("cmdChooseFolderOutput"); // NOI18N

        txOutputFolder.setText(resourceMap.getString("txOutputFolder.text")); // NOI18N
        txOutputFolder.setName("txOutputFolder"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel1)
                                .addGap(49, 49, 49)
                                .addComponent(cbProject, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txOutputFolder, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmdChooseFile)
                            .addComponent(cmdChooseFolderOutput))
                        .addGap(13, 13, 13)
                        .addComponent(cmdTranslate, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(lbPackage, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbFiles, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cbProject, txOutputFolder});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmdTranslate)
                        .addComponent(cmdCancel)
                        .addComponent(cmdChooseFile))
                    .addComponent(cbProject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txOutputFolder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdChooseFolderOutput))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPackage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbFiles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90))
        );

        mainPanel.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        tabMain.setName("tabMain"); // NOI18N

        pnProgress.setName("pnProgress"); // NOI18N

        jScrollPane3.setName("jScrollPane3"); // NOI18N

        lsFiles.setName("lsFiles"); // NOI18N
        jScrollPane3.setViewportView(lsFiles);

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        jSplitPane1.setName("jSplitPane1"); // NOI18N

        jScrollPane5.setName("jScrollPane5"); // NOI18N

        lsJavaSource.setName("lsJavaSource"); // NOI18N
        jScrollPane5.setViewportView(lsJavaSource);

        jSplitPane1.setRightComponent(jScrollPane5);

        jScrollPane4.setName("jScrollPane4"); // NOI18N

        lsVbSource.setName("lsVbSource"); // NOI18N
        jScrollPane4.setViewportView(lsVbSource);

        jSplitPane1.setLeftComponent(jScrollPane4);

        javax.swing.GroupLayout pnProgressLayout = new javax.swing.GroupLayout(pnProgress);
        pnProgress.setLayout(pnProgressLayout);
        pnProgressLayout.setHorizontalGroup(
            pnProgressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnProgressLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnProgressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
                    .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        pnProgressLayout.setVerticalGroup(
            pnProgressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnProgressLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabMain.addTab(resourceMap.getString("pnProgress.TabConstraints.tabTitle"), pnProgress); // NOI18N

        pnCode.setName("pnCode"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        txSourceCode.setColumns(20);
        txSourceCode.setRows(5);
        txSourceCode.setName("txSourceCode"); // NOI18N
        jScrollPane1.setViewportView(txSourceCode);

        pnCode.setLeftComponent(jScrollPane1);

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        txSourceCodeJava.setColumns(20);
        txSourceCodeJava.setRows(5);
        txSourceCodeJava.setName("txSourceCodeJava"); // NOI18N
        jScrollPane2.setViewportView(txSourceCodeJava);

        pnCode.setRightComponent(jScrollPane2);

        tabMain.addTab(resourceMap.getString("pnCode.TabConstraints.tabTitle"), pnCode); // NOI18N

        mainPanel.add(tabMain, java.awt.BorderLayout.CENTER);

        menuBar.setName("menuBar"); // NOI18N

        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N

        exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        toolMenu.setText(resourceMap.getString("toolMenu.text")); // NOI18N
        toolMenu.setName("toolMenu"); // NOI18N

        dictionaryMenu.setAction(actionMap.get("showDictionary")); // NOI18N
        dictionaryMenu.setText(resourceMap.getString("dictionaryMenu.text")); // NOI18N
        dictionaryMenu.setName("dictionaryMenu"); // NOI18N
        toolMenu.add(dictionaryMenu);

        preferencesMenu.setAction(actionMap.get("showPreferences")); // NOI18N
        preferencesMenu.setText(resourceMap.getString("preferencesMenu.text")); // NOI18N
        preferencesMenu.setName("preferencesMenu"); // NOI18N
        toolMenu.add(preferencesMenu);

        menuBar.add(toolMenu);

        jMenu1.setText(resourceMap.getString("jMenu1.text")); // NOI18N
        jMenu1.setName("jMenu1"); // NOI18N

        jMenuItem1.setAction(actionMap.get("showClassView")); // NOI18N
        jMenuItem1.setText(resourceMap.getString("jMenuItem1.text")); // NOI18N
        jMenuItem1.setName("jMenuItem1"); // NOI18N
        jMenu1.add(jMenuItem1);

        menuBar.add(jMenu1);

        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
        helpMenu.setName("helpMenu"); // NOI18N

        aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        statusPanel.setName("statusPanel"); // NOI18N

        statusPanelSeparator.setName("statusPanelSeparator"); // NOI18N

        statusMessageLabel.setName("statusMessageLabel"); // NOI18N

        statusAnimationLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        statusAnimationLabel.setName("statusAnimationLabel"); // NOI18N

        progressBar.setName("progressBar"); // NOI18N

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statusPanelSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusMessageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 630, Short.MAX_VALUE)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusAnimationLabel)
                .addContainerGap())
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addComponent(statusPanelSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusMessageLabel)
                    .addComponent(statusAnimationLabel)
                    .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        setComponent(mainPanel);
        setMenuBar(menuBar);
        setStatusBar(statusPanel);
    }// </editor-fold>//GEN-END:initComponents

    @Action
    public void showChooseFileDialog() {
        if (chooserFile == null) {
            chooserFile = new JFileChooser();
            chooserFile.setCurrentDirectory(new java.io.File("."));
            FileFilter filter = new ExtensionFileFilter("VBP and VBG", new String[] { "VBP", "VBG" });
            chooserFile.setFileFilter(filter);
            chooserFile.setDialogTitle("Select the vbp or vbg file to be translated");
            chooserFile.setFileSelectionMode(JFileChooser.FILES_ONLY);
            chooserFile.setAcceptAllFileFilterUsed(false);
        }
        JFrame mainFrame = BuggyMasterCodeApp.getApplication().getMainFrame();

        int returnVal = chooserFile.showOpenDialog(mainFrame);

        if (returnVal == JFileChooser.APPROVE_OPTION) {

            File file = chooserFile.getSelectedFile();
            cbProject.addItem(file.getAbsolutePath());
            OpenRecent or = new OpenRecent();
            or.addOpenRecent(file.getAbsolutePath());
            translate(file.getAbsolutePath(), file.getName());

        } else {
            txSourceCode.append("Open command cancelled by user." + newline);
        }
        txSourceCode.setCaretPosition(0);
    }

    private void translate(String filePath, String fileName) {
        setEnabledCtrls(false);
        try {
            if (isVbGroup(fileName)) {
                translateGroup(filePath);
                setEnabledCtrls(true);
            }
            else {
                m_cancel = false;
                String vbpFile = filePath;
                m_collFiles.removeAll(m_collFiles);
                m_vbpFile = vbpFile;
                m_path = vbpFile.substring(0, vbpFile.length() - fileName.length());
                lbPackage.setText(getVbName(vbpFile));
                cbFiles.removeAllItems();

                if (!busyIconTimer.isRunning()) {
                    statusAnimationLabel.setIcon(busyIcons[0]);
                    busyIconIndex = 0;
                    busyIconTimer.start();
                }
                progressBar.setVisible(true);
                progressBar.setIndeterminate(true);

                tabMain.setSelectedComponent(pnProgress);

                TranslatorWorker tw = new TranslatorWorker(this, m_path, vbpFile, m_collFiles);
                tw.execute();
            }
        }
        catch (Exception ex) {
            String msg = "the translate execution has failed";
            BuggyMasterCodeApp.getLogger().log(Level.WARNING, msg, ex);
            G.showInfo(msg);
            setEnabledCtrls(true);
        }
    }

    private void translateGroup(String vbgFile) {
        // Parse
        //
        int line = 1;
        ByRefString value = new ByRefString();
        ArrayList<Project> projects = new ArrayList<Project>();

        if (G.getToken(vbgFile, "Project", line, value)) {
            while (!value.text.isEmpty()) {
                // stop if the user wants to cancel
                //
                if (m_cancel)
                    return;
                Project project = new Project();
                project.setName(getFileName(value.text));
                String path = getFilePath(vbgFile);
                String filePath = getFilePath(value.text);
                if (!filePath.isEmpty())
                    path += "\\" + filePath;
                project.setPath(path);
                if (!project.save())
                    return;
                if (!project.loadReferences())
                    return;
                projects.add(project);
                line++;
                if (!G.getToken(vbgFile, "Project", line, value)) {
                    break;
                }
                //progressBar.setValue(line);
            }
        }

        if (G.getToken(vbgFile, "StartupProject", 1, value)) {
            if (!value.text.isEmpty()) {
                Project project = new Project();
                project.setName(getFileName(value.text));
                String path = getFilePath(vbgFile);
                String filePath = getFilePath(value.text);
                if (!filePath.isEmpty())
                    path += "\\" + filePath;
                project.setPath(path);
                if (!project.save())
                    return;
                if (!project.loadReferences())
                    return;
                projects.add(project);
            }
        }

        for (int i = 0; i < projects.size(); i++) {
            projects.get(i).getLevelFromReferences();
        }

        if (vbGroup == null) {
            JFrame mainFrame = BuggyMasterCodeApp.getApplication().getMainFrame();
            vbGroup = new VbGroup(mainFrame, false);
            vbGroup.setLocationRelativeTo(mainFrame);
        }
        vbGroup.setCaller(this);
        vbGroup.loadGrid(projects);
        BuggyMasterCodeApp.getApplication().show(vbGroup);
    }

    public void translateProjects(ArrayList<Project> projects) {
        m_projects.removeAll(projects);

        for (int i = 0; i < projects.size(); i++) {
            Project project = projects.get(i);
            if (project.getSelected()) {
                m_projects.add(project);
            }
        }
        translate();
    }

    private void translate() {
        if (m_cancel) {
            m_cancel = false;
            m_projects.removeAll(m_projects);
            setEnabledCtrls(true);
        }
        else {
            if (m_projects.size() > 0) {
                Project project = m_projects.get(0);
                String name = project.getName();
                String path = G.getFileForOS(project.getPath() + "\\" + name);
                m_projects.remove(0);
                translate(path, name);
            }
        }
    }

    private boolean isVbGroup(String fileName) {
        return G.endLike(fileName, ".vbg");
    }

    public void workDone() {
        for (int i = 0; i < m_collFiles.size(); i++) {
            saveFile(m_collFiles.get(i));
            cbFiles.addItem(m_collFiles.get(i).getFileName());
        }
        if (thereIsProjectsInQueue())
                translate();
        else {
            progressBar.setVisible(false);
            busyIconTimer.stop();
            tabMain.setSelectedComponent(pnCode);
            setEnabledCtrls(true);
        }
    }

    private boolean thereIsProjectsInQueue() {
        return m_projects.size() > 0;
    }

    public void initProgress() {
        lsFiles.setModel(new DefaultListModel());
        lsVbSource.setModel(new DefaultListModel());
        lsJavaSource.setModel(new DefaultListModel());
    }

    public void addMessage(String message) {
        DefaultListModel model = (DefaultListModel)lsFiles.getModel();
        model.add(0, message);
    }

    public void updateLastMessage(String message) {
        DefaultListModel model = (DefaultListModel)lsFiles.getModel();
        model.setElementAt(message, 0);
    }

    public boolean getCancel() {
        return m_cancel;
    }

    public synchronized void addVbLine(String message) {
        if (message.isEmpty())
            return;
        DefaultListModel model = (DefaultListModel)lsVbSource.getModel();
        if (model.size() > 200)
            model.removeElementAt(0);
        model.addElement(message);
    }

    public synchronized void addJavaLine(String message) {
        if (message.isEmpty())
            return;
        DefaultListModel model = (DefaultListModel)lsJavaSource.getModel();
        if (model.size() > 200)
            model.removeElementAt(0);
        model.addElement(message);
    }

    private void saveFile(SourceFile source) {
        if (txOutputFolder.getText().isEmpty())
            return;
        Writer output = null;
        String folder = getFileName(m_vbpFile);
        createFolderIfNotExists(G.getFileForOS(txOutputFolder.getText()
                                                + "\\"
                                                + folder));
        String fileName = G.getFileForOS(txOutputFolder.getText()
                                            + "\\"
                                            + folder
                                            + "\\"
                                            + source.getJavaName()
                                            + ".java");
        File file = new File(fileName);
        try {
            output = new BufferedWriter(new FileWriter(file));
            output.write(source.getJavaSource());
            output.close();
        } catch (IOException ex) {
            Logger.getLogger(BuggyMasterCodeView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void createFolderIfNotExists(String folder) {
        File f = new File(folder);
        if (!f.exists())
            f.mkdir();
    }

    private String getVbName(String vbpFile) {
        ByRefString value = new ByRefString();
        if (G.getToken(vbpFile, "Name", 1, value)) {
            return value.text;
        }
        else {
            return "";
        }
    }

    private void setEnabledCtrls(boolean enabled) {
        cbFiles.setEnabled(enabled);
        cbProject.setEnabled(enabled);
        cmdTranslate.setEnabled(enabled);
        cmdChooseFile.setEnabled(enabled);
        cmdCancel.setEnabled(!enabled);
        cmdChooseFolderOutput.setEnabled(enabled);
        txOutputFolder.setEnabled(enabled);
    }

    public void showFiles(int index) {
        if (index >= 0) {
            SourceFile sourceFile = m_collFiles.get(index);
            txSourceCode.setText(sourceFile.getVbSource());
            txSourceCodeJava.setText(sourceFile.getJavaSource());
        }
    }

    @Action
    public void showDictionary() {
        if (dictionary == null) {
            JFrame mainFrame = BuggyMasterCodeApp.getApplication().getMainFrame();
            dictionary = new Dictionary(mainFrame);
            dictionary.setLocationRelativeTo(mainFrame);
        }
        if (!dictionary.initDialog()) {return;}
        BuggyMasterCodeApp.getApplication().show(dictionary);
    }

    @Action
    public void showClassView() {
        if (classView == null) {
            JFrame mainFrame = BuggyMasterCodeApp.getApplication().getMainFrame();
            classView = new ClassView(mainFrame, false);
            classView.setLocationRelativeTo(mainFrame);
        }
        classView.loadTree(m_collFiles, m_vbpFile);
        BuggyMasterCodeApp.getApplication().show(classView);
    }

    @Action
    public void translateFromList() {
        String fullPath = cbProject.getSelectedItem().toString();
        if (!fullPath.isEmpty()) {
            String fileName = getFileName(fullPath);
            translate(fullPath, fileName);
        }
    }

    private String getFileName(String fullPath) {
        String fileName = fullPath;
        for (int i = fullPath.length() - 1; i > 0; i--) {
            if (fullPath.charAt(i) == '\\' || fullPath.charAt(i) == '/') {
                fileName = fullPath.substring(i + 1);
                break;
            }
        }
        return fileName;
    }

    private String getFilePath(String fullPath) {
        String path = "";
        for (int i = fullPath.length() - 1; i > 0; i--) {
            if (fullPath.charAt(i) == '\\' || fullPath.charAt(i) == '/') {
                path = fullPath.substring(0, i);
                break;
            }
        }
        return path;
    }

    public void fillOpenRecentList() {
        String[] openRecentList = OpenRecent.getOpenRecentList();
        if (openRecentList != null) {
            for (int i = 0; i < openRecentList.length; i++) {
                cbProject.addItem(openRecentList[i]);
            }
        }
    }

    @Action
    public void cancelTranslate() {
        m_cancel = true;
    }

    @Action
    public void showChooseFolderDialog() {
        if (chooserFolder == null) {
            chooserFolder = new JFileChooser();
            chooserFolder.setCurrentDirectory(new java.io.File("."));
            chooserFolder.setFileFilter(null);
            chooserFolder.setDialogTitle("Select the output folder where java files will be saved");
            chooserFolder.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            chooserFolder.setAcceptAllFileFilterUsed(false);
        }
        JFrame mainFrame = BuggyMasterCodeApp.getApplication().getMainFrame();

        int returnVal = chooserFolder.showOpenDialog(mainFrame);

        if (returnVal == JFileChooser.APPROVE_OPTION) {

            File file = chooserFolder.getSelectedFile();
            txOutputFolder.setText(file.getAbsolutePath());

        }
    }

    @Action
    public void showPreferences() {
        if (preferences == null) {
            JFrame mainFrame = BuggyMasterCodeApp.getApplication().getMainFrame();
            preferences = new PreferencesDialog(mainFrame);
            preferences.setLocationRelativeTo(mainFrame);
        }
        if (!preferences.initDialog()) {return;}
        BuggyMasterCodeApp.getApplication().show(preferences);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbFiles;
    private javax.swing.JComboBox cbProject;
    private javax.swing.JButton cmdCancel;
    private javax.swing.JButton cmdChooseFile;
    private javax.swing.JButton cmdChooseFolderOutput;
    private javax.swing.JButton cmdTranslate;
    private javax.swing.JMenuItem dictionaryMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private RTextScrollPane jScrollPane1;
    private RTextScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel lbPackage;
    private javax.swing.JList lsFiles;
    private javax.swing.JList lsJavaSource;
    private javax.swing.JList lsVbSource;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JSplitPane pnCode;
    private javax.swing.JPanel pnProgress;
    private javax.swing.JMenuItem preferencesMenu;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JLabel statusAnimationLabel;
    private javax.swing.JLabel statusMessageLabel;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JTabbedPane tabMain;
    private javax.swing.JMenu toolMenu;
    private javax.swing.JTextField txOutputFolder;
    private RSyntaxTextArea txSourceCode;
    private RSyntaxTextArea txSourceCodeJava;
    // End of variables declaration//GEN-END:variables

    private final Timer messageTimer;
    private final Timer busyIconTimer;
    private final Icon idleIcon;
    private final Icon[] busyIcons = new Icon[15];
    private int busyIconIndex = 0;

    private JDialog aboutBox;
    private Dictionary dictionary;
    private PreferencesDialog preferences;
    private ClassView classView;
    private VbGroup vbGroup;
    private JFileChooser chooserFile;
    private JFileChooser chooserFolder;

    private String m_path = "";
    private String m_vbpFile = "";
    private boolean m_cancel = false;
    private ArrayList<SourceFile> m_collFiles = new ArrayList<SourceFile>();
    private ArrayList<Project> m_projects = new ArrayList<Project>();

    static private final String newline = "\n";
}
