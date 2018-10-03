/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesador_algoritmos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Abraham Lugo Ramirez
 */
public class Principal extends javax.swing.JFrame {

    JFileChooser selecionar = new JFileChooser();
    File archivo;
    File archivo2;
    FileInputStream entrada;
    FileOutputStream salida;

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        setLocationRelativeTo(null);

    }

    public String AbrirArchivo(File archivo) {
        String documento = "";
        try {
            entrada = new FileInputStream(archivo);
            int ascci;
            while ((ascci = entrada.read()) != -1) {
                char caracter = (char) ascci;
                documento += caracter;

            }
        } catch (Exception e) {

        }
        return documento;

    }

    public String GuardarArchivo(File archivo, String documento) {
        String mensaje = null;
        try {
            salida = new FileOutputStream(archivo);
            byte[] bytxt = documento.getBytes();
            salida.write(bytxt);
            mensaje = "Archivo guardado";
        } catch (Exception e) {

        }
        return mensaje;
    }

    public void VerificarCorchetes(File archivo, String abrir, String cerrar, int j) {

        try {
            FileReader fr = null;
            fr = new FileReader(archivo);
            BufferedReader bf1 = new BufferedReader(fr);
            String sCadena1 = null;
            int cont1 = 0;
            int cont2 = 0;
            while ((sCadena1 = bf1.readLine()) != null) {
                //System.out.println(sCadena1);
                for (int k = 0; k < j; k++) {
                    for (int i = 0; i < sCadena1.length(); i++) {

                        if (sCadena1.charAt(i) == abrir.charAt(k)) {
                            cont1++;
                        }
                        if (sCadena1.charAt(i) == cerrar.charAt(k)) {
                            cont2++;
                        }
                    }

                }

            }
            if (cont1 == cont2) {
                if (cont1 != 0) {

                    JOptionPane.showMessageDialog(null, "Buen uso de [  ],  {  },  (  )");
                } else {

                    JOptionPane.showMessageDialog(null, "No hay  [  ],  {  }, (  )");
                }

            } else {

                JOptionPane.showMessageDialog(null, "Mal uso de [  ],  {  },  (  )", "ATENCION", JOptionPane.WARNING_MESSAGE);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException e) {

        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Archivo vacio...", "ATENCION", JOptionPane.WARNING_MESSAGE);
        }

    }

    public void verificarAlg(File archivo) {

        try {
            FileReader fr = null;
            FileReader fr2 = null;
            fr = new FileReader(archivo);
            BufferedReader bf1 = new BufferedReader(fr);
            String sCadena1 = null;
            Boolean iguales = true;
            String fin = "";
            int para = 0;
            int mq = 0;
            int si = 0;
            String nl = System.getProperty("line.separator");

            while ((sCadena1 = bf1.readLine()) != null) {

//               
                if ((sCadena1.indexOf("para(") != -1) || (sCadena1.indexOf("Para(") != -1) || (sCadena1.indexOf("PARA(") != -1) || (sCadena1.indexOf("ParA(") != -1)
                        || (sCadena1.indexOf("para (") != -1) || (sCadena1.indexOf("Para (") != -1) || (sCadena1.indexOf("PARA (") != -1) || (sCadena1.indexOf("ParA (") != -1)) {
                    para++;

                }

                if ((sCadena1.indexOf("MQ(") != -1) || (sCadena1.indexOf("Mq(") != -1) || (sCadena1.indexOf("mQ(") != -1) || (sCadena1.indexOf("mq(") != -1)
                        || (sCadena1.indexOf("MQ (") != -1) || (sCadena1.indexOf("Mq (") != -1) || (sCadena1.indexOf("mQ (") != -1) || (sCadena1.indexOf("mq (") != -1)) {
                    mq++;
                }

                if ((sCadena1.indexOf("Si(") != -1) || (sCadena1.indexOf("si(") != -1) || (sCadena1.indexOf("sI(") != -1) || (sCadena1.indexOf("SI(") != -1)
                        || (sCadena1.indexOf("si (") != -1) || (sCadena1.indexOf("sI (") != -1) || (sCadena1.indexOf("SI (") != -1) || (sCadena1.indexOf("Si (") != -1)) {
                    si++;
                }

                fin = sCadena1;
            }
            if (!fin.equals("Fin")) {
                iguales = false;
            }

            while ((sCadena1 = bf1.readLine()) != null && iguales == true) {
                System.out.println(sCadena1);

                if (!sCadena1.equals("Inicio")) {
                    iguales = false;
                }
                break;

            }

            if (iguales == true) {
                JOptionPane.showMessageDialog(null, "SI ES UN ALGORITMO," + nl + "Cantidad ciclos para: " + para + " " + nl + "Cantidad ciclos Mq: " + mq + " " + nl + "Cantidad de SI: " + si);
            } else {
                JOptionPane.showMessageDialog(null, "NO ES UN ALGORITMO", "ATENCION", JOptionPane.WARNING_MESSAGE);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException e) {

        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Archivo vacio", "ATENCION", JOptionPane.WARNING_MESSAGE);
        }

    }

    public void Verificar(File archivo, File archivo2) {

        try {
            FileReader fr = null;
            FileReader fr2 = null;
            fr = new FileReader(archivo);
            fr2 = new FileReader(archivo2);
            BufferedReader bf1 = new BufferedReader(fr);
            BufferedReader bf2 = new BufferedReader(fr2);
            String sCadena1 = null;
            String sCadena2 = null;
            Boolean iguales = true;
            int cont = 0;

            while ((sCadena1 = bf1.readLine()) != null && (sCadena2 = bf2.readLine()) != null && iguales == true) {
                System.out.println(sCadena1);
                System.out.println(sCadena2);

                if (!sCadena1.equals(sCadena2)) {
                    iguales = false;
                    cont++;
                }

            }
            if (iguales == true) {
                JOptionPane.showMessageDialog(null, "Algoritmos Iguales");
            } else {
                JOptionPane.showMessageDialog(null, "Algoritmos Diferentes en " + cont, "ATENCION", JOptionPane.WARNING_MESSAGE);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException e) {

        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Archivo vacio", "ATENCION", JOptionPane.WARNING_MESSAGE);
        }

    }

    public void guardar(File archivo) {

        if (selecionar.showDialog(null, "Abrir") == JFileChooser.APPROVE_OPTION) {
            archivo = selecionar.getSelectedFile();
            if (archivo.canRead()) {
                if (archivo.getName().endsWith("txt")) {
                    String documento = AbrirArchivo(archivo);
                    area.setText(documento);
                } else {
                    JOptionPane.showMessageDialog(null, "Archivo no compatible", "ATENCION", JOptionPane.WARNING_MESSAGE);
                }
            }
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

        Abrir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        area = new javax.swing.JTextArea();
        Guardar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        Abrir2 = new javax.swing.JButton();
        VerificarAlgotirmo = new javax.swing.JButton();
        VerificarAlgoritmo2 = new javax.swing.JButton();
        VerificarSintaxis = new javax.swing.JButton();
        VerificarSintaxis2 = new javax.swing.JButton();
        Guardar2 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        area2 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Abrir.setText("Abrir Documento");
        Abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbrirActionPerformed(evt);
            }
        });
        getContentPane().add(Abrir, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        area.setColumns(20);
        area.setRows(5);
        jScrollPane1.setViewportView(area);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 250, 360));

        Guardar.setText("Guardar");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });
        getContentPane().add(Guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, -1, -1));

        jButton3.setText("Verificar Igualdad");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 430, -1, -1));

        Abrir2.setText("Abrir Documento 2");
        Abrir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Abrir2ActionPerformed(evt);
            }
        });
        getContentPane().add(Abrir2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 70, -1, -1));

        VerificarAlgotirmo.setText("Verificar algoritmo");
        VerificarAlgotirmo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerificarAlgotirmoActionPerformed(evt);
            }
        });
        getContentPane().add(VerificarAlgotirmo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, -1, -1));

        VerificarAlgoritmo2.setText("Verificar algoritmo 2");
        VerificarAlgoritmo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerificarAlgoritmo2ActionPerformed(evt);
            }
        });
        getContentPane().add(VerificarAlgoritmo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 470, -1, -1));

        VerificarSintaxis.setText("Verifar sintaxis");
        VerificarSintaxis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerificarSintaxisActionPerformed(evt);
            }
        });
        getContentPane().add(VerificarSintaxis, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 470, -1, -1));

        VerificarSintaxis2.setText("Verificar sintaxis 2");
        VerificarSintaxis2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerificarSintaxis2ActionPerformed(evt);
            }
        });
        getContentPane().add(VerificarSintaxis2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 470, -1, -1));

        Guardar2.setText("Guardar");
        Guardar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Guardar2ActionPerformed(evt);
            }
        });
        getContentPane().add(Guardar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 70, -1, -1));

        jButton10.setBackground(new java.awt.Color(255, 0, 0));
        jButton10.setText("Cerrar");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Techno Hideo", 3, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 153, 255));
        jLabel2.setText("Procesador de Algoritmos");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 650, 40));

        area2.setColumns(20);
        area2.setRows(5);
        jScrollPane2.setViewportView(area2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 110, 260, 350));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbrirActionPerformed

         if (selecionar.showDialog(null, "Abrir") == JFileChooser.APPROVE_OPTION) {
            archivo = selecionar.getSelectedFile();
            if (archivo.canRead()) {
                if (archivo.getName().endsWith("txt")) {
                    String documento = AbrirArchivo(archivo);
                    area.setText(documento);
                } else {
                    JOptionPane.showMessageDialog(null, "Archivo no compatible", "ATENCION", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_AbrirActionPerformed

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
         if (selecionar.showDialog(null, "Guardar") == JFileChooser.APPROVE_OPTION) {
            archivo = selecionar.getSelectedFile();
            if (archivo.getName().endsWith("txt")) {
                String Documento = area.getText();
                String mensaje = GuardarArchivo(archivo, Documento);
                if (mensaje != null) {
                    JOptionPane.showMessageDialog(null, mensaje);
                } else {
                    JOptionPane.showMessageDialog(null, "Archivo no compatible", "ATENCION", JOptionPane.WARNING_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Guardar Documento de texto");
            }
        }

    }//GEN-LAST:event_GuardarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        Verificar(archivo, archivo2);

    }//GEN-LAST:event_jButton3ActionPerformed

    private void Abrir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Abrir2ActionPerformed

        if (selecionar.showDialog(null, "Abrir") == JFileChooser.APPROVE_OPTION) {
            archivo2 = selecionar.getSelectedFile();
            if (archivo2.canRead()) {
                if (archivo2.getName().endsWith("txt")) {
                    String documento = AbrirArchivo(archivo2);
                    area2.setText(documento);
                } else {
                    JOptionPane.showMessageDialog(null, "Archivo no compatible", "ATENCION", JOptionPane.WARNING_MESSAGE);
                }
            }
        }


    }//GEN-LAST:event_Abrir2ActionPerformed

    private void VerificarAlgotirmoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerificarAlgotirmoActionPerformed

        verificarAlg(archivo);


    }//GEN-LAST:event_VerificarAlgotirmoActionPerformed

    private void VerificarAlgoritmo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerificarAlgoritmo2ActionPerformed

        verificarAlg(archivo2);

    }//GEN-LAST:event_VerificarAlgoritmo2ActionPerformed

    private void VerificarSintaxisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerificarSintaxisActionPerformed
        // TODO add your handling code here:
        VerificarCorchetes(archivo, "({[", "]})", 3);

    }//GEN-LAST:event_VerificarSintaxisActionPerformed

    private void VerificarSintaxis2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerificarSintaxis2ActionPerformed
        // TODO add your handling code here:
        VerificarCorchetes(archivo2, "({[", "]})", 3);
    }//GEN-LAST:event_VerificarSintaxis2ActionPerformed

    private void Guardar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Guardar2ActionPerformed
        // TODO add your handling code here:
        if (selecionar.showDialog(null, "Guardar") == JFileChooser.APPROVE_OPTION) {
            archivo2 = selecionar.getSelectedFile();
            if (archivo2.getName().endsWith("txt")) {
                String Documento = area2.getText();
                String mensaje = GuardarArchivo(archivo2, Documento);
                if (mensaje != null) {
                    JOptionPane.showMessageDialog(null, mensaje);
                } else {
                    JOptionPane.showMessageDialog(null, "Archivo no compatible", "ATENCION", JOptionPane.WARNING_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Guardar Documento de texto");
            }
        }

    }//GEN-LAST:event_Guardar2ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton10ActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Abrir;
    private javax.swing.JButton Abrir2;
    private javax.swing.JButton Guardar;
    private javax.swing.JButton Guardar2;
    private javax.swing.JButton VerificarAlgoritmo2;
    private javax.swing.JButton VerificarAlgotirmo;
    private javax.swing.JButton VerificarSintaxis;
    private javax.swing.JButton VerificarSintaxis2;
    private javax.swing.JTextArea area;
    private javax.swing.JTextArea area2;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
