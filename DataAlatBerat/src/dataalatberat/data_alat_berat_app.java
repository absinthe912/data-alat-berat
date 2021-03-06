/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataalatberat;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 *
 * @author evond_p2gd0g3
 */
public class data_alat_berat_app extends javax.swing.JFrame {
    
    static DefaultTableModel model;
    
    //14 column
    static String tanggal,alber,pabrik,hourmet,keterangan,jamKerja,olih,olit,olim,bm;
    static double solpjam,solpbk,bk;
    static int solar;

    /**
     * Creates new form data_alat_berat_app
     */
    
    //program functions
    public static double jamkerja_calc(String jk){
        int menit, jam;
        String[] cutText = jk.split("\\:");
        jam=Integer.parseInt(cutText[0]);
        menit=Integer.parseInt(cutText[1]);
        return jam+(menit/60); 
    }
    
    
    public data_alat_berat_app() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        model = new DefaultTableModel();
        
        table_daa.setModel(model);
        
        //ada 14 column= 14 variabel
        model.addColumn("Tanggal");
        model.addColumn("Alat Berat");
        model.addColumn("Pabrik");
        model.addColumn("Hour meter");
        model.addColumn("HM jam kerja");
        model.addColumn("BM");
        model.addColumn("BK");
        model.addColumn("Solar");
        model.addColumn("Oli hidrolis-10");
        model.addColumn("Oli transmisi-30");
        model.addColumn("Oli mesin-40");
        model.addColumn("Pakai solar/BK");
        model.addColumn("Pakai solar/jam");
        model.addColumn("Keterangan");
        
        //resize column
        table_daa.getColumnModel().getColumn(0).setPreferredWidth(200);
        table_daa.getColumnModel().getColumn(1).setPreferredWidth(200);
        table_daa.getColumnModel().getColumn(2).setPreferredWidth(200);
        table_daa.getColumnModel().getColumn(3).setPreferredWidth(150);
        table_daa.getColumnModel().getColumn(4).setPreferredWidth(200);
        table_daa.getColumnModel().getColumn(5).setPreferredWidth(100);
        table_daa.getColumnModel().getColumn(6).setPreferredWidth(100);
        table_daa.getColumnModel().getColumn(7).setPreferredWidth(100);
        table_daa.getColumnModel().getColumn(8).setPreferredWidth(200);
        table_daa.getColumnModel().getColumn(9).setPreferredWidth(200);
        table_daa.getColumnModel().getColumn(10).setPreferredWidth(200);
        table_daa.getColumnModel().getColumn(11).setPreferredWidth(250);
        table_daa.getColumnModel().getColumn(12).setPreferredWidth(250);
        table_daa.getColumnModel().getColumn(13).setPreferredWidth(350);
        
    }
    
    public static void input_data(int e,String tgl,String ab, String pb, String jk, String hm, String bm, double bk, int s, String oh, String ot, String om, String ket){
        solpjam=s/jamkerja_calc(jk);
        solpbk=s/bk;
        
        String data[] = {tgl,ab,pb,hm,jk,bm,String.valueOf(bk),String.valueOf(s),oh,ot,om,String.valueOf(solpbk),String.valueOf(solpjam),ket};
        if(e==-1) model.addRow(data);
        else {
            model.setValueAt(tgl, e, 0);
            model.setValueAt(ab, e, 1);
            model.setValueAt(pb, e, 2);
            model.setValueAt(hm, e, 3);
            model.setValueAt(jk, e, 4);
            model.setValueAt(bm, e, 5);
            model.setValueAt(String.valueOf(bk), e, 6);
            model.setValueAt(String.valueOf(s), e, 7);
            model.setValueAt(oh, e, 8);
            model.setValueAt(ot, e, 9);
            model.setValueAt(om, e, 10);
            model.setValueAt(String.valueOf(solpbk), e, 11);
            model.setValueAt(String.valueOf(solpjam), e, 12);
            model.setValueAt(ket, e, 13);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table_daa = new javax.swing.JTable();
        btn_add = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        export_btn = new javax.swing.JButton();
        import_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table_daa.setModel(new javax.swing.table.DefaultTableModel(
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
        table_daa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_daaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_daa);

        btn_add.setText("add");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_edit.setText("edit");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        btn_delete.setText("delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 22)); // NOI18N
        jLabel1.setText("Data Alat Berat");

        export_btn.setText("export");
        export_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                export_btnActionPerformed(evt);
            }
        });

        import_btn.setText("import");
        import_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                import_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(542, 542, 542)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(btn_add)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 272, Short.MAX_VALUE)
                        .addComponent(btn_edit)
                        .addGap(244, 244, 244)
                        .addComponent(btn_delete)
                        .addGap(250, 250, 250)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(import_btn)
                    .addComponent(export_btn))
                .addGap(135, 135, 135))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(import_btn)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(export_btn)
                            .addComponent(btn_delete)
                            .addComponent(btn_edit)
                            .addComponent(btn_add))
                        .addGap(13, 13, 13)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //inputs
    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        // TODO add your handling code here:
        new input().setVisible(true);
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        // TODO add your handling code here:
        if(table_daa.getSelectedRowCount()==1){
            tanggal=table_daa.getValueAt(table_daa.getSelectedRow(), 0).toString();
            alber=table_daa.getValueAt(table_daa.getSelectedRow(), 1).toString();
            pabrik=table_daa.getValueAt(table_daa.getSelectedRow(), 2).toString();
            hourmet=table_daa.getValueAt(table_daa.getSelectedRow(), 3).toString();
            jamKerja=table_daa.getValueAt(table_daa.getSelectedRow(), 4).toString();
            bm=table_daa.getValueAt(table_daa.getSelectedRow(), 5).toString();
            bk=Double.parseDouble(table_daa.getValueAt(table_daa.getSelectedRow(), 6).toString());
            solar=Integer.parseInt(table_daa.getValueAt(table_daa.getSelectedRow(), 7).toString());
            olih=table_daa.getValueAt(table_daa.getSelectedRow(), 8).toString();
            olit=table_daa.getValueAt(table_daa.getSelectedRow(), 9).toString();
            olim=table_daa.getValueAt(table_daa.getSelectedRow(), 10).toString();
            keterangan=table_daa.getValueAt(table_daa.getSelectedRow(), 13).toString();
            
            //get index of selected row
            int index=table_daa.getSelectedRow();

            //String tgl, String ab, String p, String jk, String k, String hm, String bm, double bk, int s, String oh, String ot, String om
            new input(index,tanggal,alber,pabrik,jamKerja,keterangan,hourmet,bm,bk,solar,olih,olit,olim).setVisible(true);
        }
        else{
            if(table_daa.getSelectedRowCount()==0)
                JOptionPane.showMessageDialog(this, "Table is not selected...");
            else 
                JOptionPane.showMessageDialog(this, "Please select a single row to edit");
        }
            
    }//GEN-LAST:event_btn_editActionPerformed

    private void import_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_import_btnActionPerformed
        // TODO add your handling code here:
        File excelFile;
        FileInputStream excelFIS = null;
        BufferedInputStream excelBIS = null;
        XSSFWorkbook excelJTableImport = null;
        //select default path
        String defaultCurrentDirectoryPath = "cd~/Desktop";
        JFileChooser excelFileChooser = new JFileChooser(defaultCurrentDirectoryPath);
        //fo;ter only excel files
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
        excelFileChooser.setFileFilter(fnef);
        //set dialogue title
        excelFileChooser.setDialogTitle("Select Excel File");
        int excelChooser = excelFileChooser.showOpenDialog(null);
        //if open button pressed
        if(excelChooser == JFileChooser.APPROVE_OPTION){
            try{
                excelFile = excelFileChooser.getSelectedFile();
                excelFIS = new FileInputStream(excelFile);
                excelBIS = new BufferedInputStream(excelBIS);

                excelJTableImport = new XSSFWorkbook(excelBIS);
                XSSFSheet excelSheet = excelJTableImport.getSheetAt(0);

                //looping through excel columns and rows
                for(int row = 0; row < excelSheet.getLastRowNum(); row++){
                    XSSFRow excelRow = excelSheet.getRow(row);
                    
                    XSSFCell excelTgl = excelRow.getCell(0);
                    XSSFCell excelAb = excelRow.getCell(1);
                    XSSFCell excelPb = excelRow.getCell(2);
                    XSSFCell excelHm = excelRow.getCell(3);
                    XSSFCell excelHmpj = excelRow.getCell(4);
                    XSSFCell excelBm = excelRow.getCell(5);
                    XSSFCell excelBk = excelRow.getCell(6);
                    XSSFCell excelS = excelRow.getCell(7);
                    XSSFCell excelOliH = excelRow.getCell(8);
                    XSSFCell excelOliT = excelRow.getCell(9);
                    XSSFCell excelOliM = excelRow.getCell(10);
                    XSSFCell excelSpbk = excelRow.getCell(11);
                    XSSFCell excelSpj = excelRow.getCell(12);
                    XSSFCell excelKet = excelRow.getCell(13);
                    
                    model.addRow(new Object[]{excelTgl, excelAb, excelPb, excelHm, excelHmpj, excelBm, excelBk, excelS, excelOliH, excelOliT, excelOliM, excelSpbk, excelSpj, excelKet});
                }
            }catch(FileNotFoundException ex){
                ex.printStackTrace();
            }catch(IOException ex){
                ex.printStackTrace();
            }finally{
                try{
                    if(excelFIS != null) excelFIS.close();
                    if(excelBIS != null) excelBIS.close();
                    if(excelJTableImport != null) excelJTableImport.close();
                }catch(IOException ex){
                    ex.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_import_btnActionPerformed

    private void export_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_export_btnActionPerformed
        // TODO add your handling code here:
        
        FileOutputStream excelFOU = null;
        BufferedOutputStream excelBOU = null;
        XSSFWorkbook excelJTableExporter = null;
            
        //choose location
        JFileChooser excelFileChooser = new JFileChooser("cd~/Desktop");
        //change dialog box title
        excelFileChooser.setDialogTitle("Save As");
        //only filters files with extension xlx etc
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
        excelFileChooser.setFileFilter(fnef);
        int excelChooser = excelFileChooser.showSaveDialog(null);
        
        //check if save button is clicked
        if(excelChooser == JFileChooser.APPROVE_OPTION){
            
            try {
                excelJTableExporter = new XSSFWorkbook();
                XSSFSheet excelSheet = excelJTableExporter.createSheet("Data Alat Berat");
                //loop to get jtable columns and rows
                for(int i = 0;i < model.getRowCount(); i++){
                    XSSFRow excelRow = excelSheet.createRow(i);
                    for(int j = 0;j < model.getColumnCount(); j++){
                        XSSFCell excelCell = excelRow.createCell(j);
                        
                        excelCell.setCellValue(model.getValueAt(i, i).toString());
                    }
                }   //append xlsx file extensions to selected files to create unique file names
                excelFOU = new FileOutputStream(excelFileChooser.getSelectedFile()+".xlsx");
                excelBOU = new BufferedOutputStream(excelFOU);
                excelJTableExporter.write(excelBOU);
                JOptionPane.showMessageDialog(null, "Exported Successfully");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                Logger.getLogger(data_alat_berat_app.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if(excelBOU !=null) excelBOU.close();
                    if(excelFOU !=null) excelFOU.close();
                    if(excelJTableExporter !=null) excelJTableExporter.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_export_btnActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
        DefaultTableModel tblmodel = (DefaultTableModel) table_daa.getModel();
        
        if(table_daa.getSelectedRowCount()>1){
            int[] index=table_daa.getSelectedRows();
            for (int i = 0; i < index.length ; i++) {
                tblmodel.removeRow(index[i]);
            }
        }
        else if(table_daa.getSelectedRowCount()==1)
            tblmodel.removeRow(table_daa.getSelectedRow());
        else
            JOptionPane.showMessageDialog(this, "choose row to delete");
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void table_daaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_daaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_table_daaMouseClicked
    
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
            java.util.logging.Logger.getLogger(data_alat_berat_app.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(data_alat_berat_app.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(data_alat_berat_app.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(data_alat_berat_app.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new data_alat_berat_app().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton export_btn;
    private javax.swing.JButton import_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_daa;
    // End of variables declaration//GEN-END:variables
}
