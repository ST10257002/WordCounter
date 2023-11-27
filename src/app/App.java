
package app;

import com.formdev.flatlaf.intellijthemes.FlatDarkPurpleIJTheme;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class App extends javax.swing.JFrame {

    public App() {
        initComponents();
    }

    public static void main(String args[]) {
        try {
            FlatDarkPurpleIJTheme.setup();
        } catch (Exception e) {
            System.err.print(e);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new App().setVisible(true);
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupThemes = new javax.swing.ButtonGroup();
        groupControls = new javax.swing.ButtonGroup();
        textScroll = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        infoScroll = new javax.swing.JScrollPane();
        infoTable = new javax.swing.JTable();
        infoCombo = new javax.swing.JComboBox<>();
        targetLabel = new javax.swing.JLabel();
        targetBar = new javax.swing.JProgressBar();
        targetCombo = new javax.swing.JComboBox<>();
        targetSpinner = new javax.swing.JSpinner();
        toolBar = new javax.swing.JToolBar();
        themeDark = new javax.swing.JToggleButton();
        themeLight = new javax.swing.JToggleButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        onTop = new javax.swing.JToggleButton();
        menu = new javax.swing.JMenuBar();
        toolMenu = new javax.swing.JMenu();
        toolCopyText = new javax.swing.JMenuItem();
        toolCopyInfo = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        toolClear = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        helpDocumentation = new javax.swing.JMenuItem();
        helpAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("WordCounter (pre-0.1.0)");

        textArea.setColumns(20);
        textArea.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        textArea.setLineWrap(true);
        textArea.setRows(5);
        textArea.setTabSize(4);
        textArea.setWrapStyleWord(true);
        textArea.setMargin(new java.awt.Insets(6, 6, 6, 6));
        textArea.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                textAreaCaretUpdate(evt);
            }
        });
        textScroll.setViewportView(textArea);

        infoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Type", "Value"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        infoTable.setFocusable(false);
        infoTable.setShowGrid(true);
        infoTable.setShowHorizontalLines(false);
        infoTable.getTableHeader().setResizingAllowed(false);
        infoTable.getTableHeader().setReorderingAllowed(false);
        infoScroll.setViewportView(infoTable);

        infoCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Generic information", "Advanced analysis" }));
        infoCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoComboActionPerformed(evt);
            }
        });

        targetLabel.setText("Targets (optional)");

        targetBar.setValue(30);
        targetBar.setStringPainted(true);

        targetCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Words", "Characters", "Pages" }));
        targetCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                targetComboActionPerformed(evt);
            }
        });

        targetSpinner.setEditor(new javax.swing.JSpinner.NumberEditor(targetSpinner, ""));

        toolBar.setRollover(true);
        toolBar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        toolBar.setMaximumSize(new java.awt.Dimension(38, 24));
        toolBar.setMinimumSize(new java.awt.Dimension(38, 24));

        groupThemes.add(themeDark);
        themeDark.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/assets/icons8-moon-18.png"))); // NOI18N
        themeDark.setSelected(true);
        themeDark.setToolTipText("Dark theme");
        themeDark.setEnabled(false);
        themeDark.setFocusable(false);
        themeDark.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        themeDark.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(themeDark);

        groupThemes.add(themeLight);
        themeLight.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/assets/icons8-light-18.png"))); // NOI18N
        themeLight.setToolTipText("Light theme");
        themeLight.setEnabled(false);
        themeLight.setFocusable(false);
        themeLight.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        themeLight.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(themeLight);
        toolBar.add(jSeparator4);

        onTop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/assets/icons8-lock-18.png"))); // NOI18N
        onTop.setToolTipText("Always on-top");
        onTop.setAlignmentX(0.5F);
        onTop.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        onTop.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        onTop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onTopActionPerformed(evt);
            }
        });
        toolBar.add(onTop);

        toolMenu.setText("Tools");

        toolCopyText.setText("Copy (Textbox)");
        toolCopyText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toolCopyTextActionPerformed(evt);
            }
        });
        toolMenu.add(toolCopyText);

        toolCopyInfo.setText("Copy (Info)");
        toolMenu.add(toolCopyInfo);
        toolMenu.add(jSeparator2);

        toolClear.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.ALT_DOWN_MASK));
        toolClear.setText("Clear");
        toolClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toolClearActionPerformed(evt);
            }
        });
        toolMenu.add(toolClear);

        menu.add(toolMenu);

        helpMenu.setText("Help");

        helpDocumentation.setText("Documentation");
        helpDocumentation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpDocumentationActionPerformed(evt);
            }
        });
        helpMenu.add(helpDocumentation);

        helpAbout.setText("About");
        helpAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpAboutActionPerformed(evt);
            }
        });
        helpMenu.add(helpAbout);

        menu.add(helpMenu);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(infoScroll, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(infoCombo, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(targetLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(targetCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(targetSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(toolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(targetBar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(infoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(infoScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(targetLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(targetCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(targetSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(targetBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                        .addComponent(toolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(textScroll))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void toolCopyTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toolCopyTextActionPerformed
        // Copy textbox contents to system clipboard
        Toolkit.getDefaultToolkit()
                .getSystemClipboard()
                .setContents(
                        new java.awt.datatransfer.StringSelection(textArea.getText()),
                        null
                );
    }//GEN-LAST:event_toolCopyTextActionPerformed

    private void onTopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onTopActionPerformed
        // Toggle window always on-top property
        setAlwaysOnTop(onTop.isSelected());
    }//GEN-LAST:event_onTopActionPerformed

    private void infoComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoComboActionPerformed
        // 
    }//GEN-LAST:event_infoComboActionPerformed

    private void targetComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_targetComboActionPerformed
        // 
    }//GEN-LAST:event_targetComboActionPerformed

    private void toolClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toolClearActionPerformed
        // Clear textbox contents
        textArea.setText("");
    }//GEN-LAST:event_toolClearActionPerformed

    private void helpAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpAboutActionPerformed
        // Display about dialog
        JOptionPane.showMessageDialog(
                new JFrame(), 
                "© Matthew Pieterse (2023)", 
                "About", 
                JOptionPane.PLAIN_MESSAGE
        ); 
    }//GEN-LAST:event_helpAboutActionPerformed

    private void helpDocumentationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpDocumentationActionPerformed
        // Open github repo in default browser
        try {
            java.awt.Desktop
                    .getDesktop()
                    .browse(java.net.URI.create("https://github.com/ST10257002/WordCounter")
                    );
        } catch (IOException e) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_helpDocumentationActionPerformed

    private void textAreaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_textAreaCaretUpdate
        // Update table upon text update
        infoTable.setModel(new Factor().getTable(textArea.getText()));
    }//GEN-LAST:event_textAreaCaretUpdate

    // <editor-fold defaultstate="collapsed" desc="Variable Declarations">  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup groupControls;
    private javax.swing.ButtonGroup groupThemes;
    private javax.swing.JMenuItem helpAbout;
    private javax.swing.JMenuItem helpDocumentation;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JComboBox<String> infoCombo;
    private javax.swing.JScrollPane infoScroll;
    private javax.swing.JTable infoTable;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JMenuBar menu;
    private javax.swing.JToggleButton onTop;
    private javax.swing.JProgressBar targetBar;
    private javax.swing.JComboBox<String> targetCombo;
    private javax.swing.JLabel targetLabel;
    private javax.swing.JSpinner targetSpinner;
    private javax.swing.JTextArea textArea;
    private javax.swing.JScrollPane textScroll;
    private javax.swing.JToggleButton themeDark;
    private javax.swing.JToggleButton themeLight;
    private javax.swing.JToolBar toolBar;
    private javax.swing.JMenuItem toolClear;
    private javax.swing.JMenuItem toolCopyInfo;
    private javax.swing.JMenuItem toolCopyText;
    private javax.swing.JMenu toolMenu;
    // End of variables declaration//GEN-END:variables
    // </editor-fold>    
}
