/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Alternative;
import Model.Criterion;
import Model.Promethee;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mauricio
 */
public class PrometheeWindow extends javax.swing.JFrame {
  private static final long serialVersionUID = -5823287613981396771L;

  private Promethee promethee;

  /**
   * Creates new form PrometheeWindow
   */
  public PrometheeWindow() {
    try {
      initComponents();
      promethee = new Promethee();

      List<Criterion> criteria = new ArrayList<>();
      Criterion c = new Criterion();
      c.setMax(false);
      c.setName("Costo");
      c.setType(2);
      c.addParam("l", 20000);
      c.setWeight(0.30);
      criteria.add(c);

      c = new Criterion();
      c.setMax(false);
      c.setName("Tiempo de tansporte");
      c.addParam("p", 3);
      c.addParam("q", 6);
      c.setType(4);
      c.setWeight(0.20);
      criteria.add(c);

      c = new Criterion();
      c.setMax(true);
      c.setName("Capacidad");
      c.setType(3);
      c.addParam("m", 100);
      c.setWeight(0.20);
      criteria.add(c);

      c = new Criterion();
      c.setMax(true);
      c.setName("Cumplimiento");
      c.setType(2);
      c.addParam("l", 5);
      c.setWeight(0.20);
      criteria.add(c);

      c = new Criterion();
      c.setMax(false);
      c.setName("Impacto ambiental");
      c.setType(1);
      c.setWeight(0.10);
      criteria.add(c);

      promethee.setCriteria(criteria);
      promethee.setWindow(this);

      setUpTable();
      promethee.updateView();
    } catch (Exception ex) {
      Logger
        .getLogger(PrometheeWindow.class.getName())
        .log(Level.SEVERE, null, ex);
    }
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  // <editor-fold defaultstate="collapsed" desc="Generated
  // Code">//GEN-BEGIN:initComponents
  private void initComponents() {
    jButton1 = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    jTextArea1 = new javax.swing.JTextArea();
    jPanel2 = new javax.swing.JPanel();
    jLabel7 = new javax.swing.JLabel();
    Actualizar = new javax.swing.JButton();
    jSeparator1 = new javax.swing.JSeparator();
    jLabel1 = new javax.swing.JLabel();
    nalt = new javax.swing.JTextField();
    jButton2 = new javax.swing.JButton();
    jScrollPane2 = new javax.swing.JScrollPane();
    jTable1 = new javax.swing.JTable();
    jButton3 = new javax.swing.JButton();
    jButton4 = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Promethee");

    jButton1.setText("Agregar nuevo criterio...");
    jButton1.addActionListener(
      new java.awt.event.ActionListener() {

        public void actionPerformed(java.awt.event.ActionEvent evt) {
          jButton1ActionPerformed(evt);
        }
      }
    );

    jTextArea1.setEditable(false);
    jTextArea1.setColumns(20);
    jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 15)); // NOI18N
    jTextArea1.setRows(5);
    jScrollPane1.setViewportView(jTextArea1);

    jPanel2.setBackground(new java.awt.Color(64, 72, 214));

    jLabel7.setBackground(new java.awt.Color(28, 83, 213));
    jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 48)); // NOI18N
    jLabel7.setForeground(java.awt.Color.white);
    jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel7.setText("Metodo Promethee");

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
      jPanel2
    );
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(
          jLabel7,
          javax.swing.GroupLayout.DEFAULT_SIZE,
          javax.swing.GroupLayout.DEFAULT_SIZE,
          Short.MAX_VALUE
        )
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(
          jLabel7,
          javax.swing.GroupLayout.DEFAULT_SIZE,
          88,
          Short.MAX_VALUE
        )
    );

    Actualizar.setText("Actualizar");
    Actualizar.addActionListener(
      new java.awt.event.ActionListener() {

        public void actionPerformed(java.awt.event.ActionEvent evt) {
          ActualizarActionPerformed(evt);
        }
      }
    );

    jLabel1.setText("Numero de alternativas:");

    jButton2.setText("Crear alternativas");
    jButton2.addActionListener(
      new java.awt.event.ActionListener() {

        public void actionPerformed(java.awt.event.ActionEvent evt) {
          jButton2ActionPerformed(evt);
        }
      }
    );

    jTable1.setModel(
      new javax.swing.table.DefaultTableModel(
        new Object[][] {},
        new String[] {}
      )
    );
    jScrollPane2.setViewportView(jTable1);

    jButton3.setBackground(java.awt.Color.blue);
    jButton3.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
    jButton3.setForeground(java.awt.Color.white);
    jButton3.setText("Calcular!");
    jButton3.addActionListener(
      new java.awt.event.ActionListener() {

        public void actionPerformed(java.awt.event.ActionEvent evt) {
          jButton3ActionPerformed(evt);
        }
      }
    );

    jButton4.setText("Limpiar");
    jButton4.addActionListener(
      new java.awt.event.ActionListener() {

        public void actionPerformed(java.awt.event.ActionEvent evt) {
          jButton4ActionPerformed(evt);
        }
      }
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
      getContentPane()
    );
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
          layout
            .createSequentialGroup()
            .addContainerGap()
            .addGroup(
              layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(
                  jSeparator1,
                  javax.swing.GroupLayout.Alignment.TRAILING
                )
                .addComponent(jScrollPane1)
                .addComponent(
                  jPanel2,
                  javax.swing.GroupLayout.DEFAULT_SIZE,
                  javax.swing.GroupLayout.DEFAULT_SIZE,
                  Short.MAX_VALUE
                )
                .addComponent(
                  jScrollPane2,
                  javax.swing.GroupLayout.DEFAULT_SIZE,
                  841,
                  Short.MAX_VALUE
                )
                .addGroup(
                  layout
                    .createSequentialGroup()
                    .addGroup(
                      layout
                        .createParallelGroup(
                          javax.swing.GroupLayout.Alignment.LEADING
                        )
                        .addGroup(
                          layout
                            .createSequentialGroup()
                            .addComponent(jButton1)
                            .addPreferredGap(
                              javax.swing.LayoutStyle.ComponentPlacement.UNRELATED
                            )
                            .addComponent(Actualizar)
                        )
                        .addGroup(
                          layout
                            .createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(
                              nalt,
                              javax.swing.GroupLayout.PREFERRED_SIZE,
                              28,
                              javax.swing.GroupLayout.PREFERRED_SIZE
                            )
                            .addPreferredGap(
                              javax.swing.LayoutStyle.ComponentPlacement.UNRELATED
                            )
                            .addComponent(jButton2)
                        )
                    )
                    .addGap(0, 0, Short.MAX_VALUE)
                )
                .addGroup(
                  javax.swing.GroupLayout.Alignment.TRAILING,
                  layout
                    .createSequentialGroup()
                    .addComponent(jButton4)
                    .addPreferredGap(
                      javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                      javax.swing.GroupLayout.DEFAULT_SIZE,
                      Short.MAX_VALUE
                    )
                    .addComponent(
                      jButton3,
                      javax.swing.GroupLayout.PREFERRED_SIZE,
                      135,
                      javax.swing.GroupLayout.PREFERRED_SIZE
                    )
                )
            )
            .addContainerGap()
        )
    );
    layout.setVerticalGroup(
      layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
          layout
            .createSequentialGroup()
            .addContainerGap()
            .addComponent(
              jPanel2,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              javax.swing.GroupLayout.DEFAULT_SIZE,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(
              jScrollPane1,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              180,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(
              layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton1)
                .addComponent(Actualizar)
            )
            .addGap(2, 2, 2)
            .addComponent(
              jSeparator1,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              10,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addGap(18, 18, 18)
            .addGroup(
              layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(
                  jLabel1,
                  javax.swing.GroupLayout.PREFERRED_SIZE,
                  23,
                  javax.swing.GroupLayout.PREFERRED_SIZE
                )
                .addComponent(
                  nalt,
                  javax.swing.GroupLayout.PREFERRED_SIZE,
                  javax.swing.GroupLayout.DEFAULT_SIZE,
                  javax.swing.GroupLayout.PREFERRED_SIZE
                )
                .addComponent(jButton2)
            )
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(
              jScrollPane2,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              183,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addGap(18, 18, 18)
            .addGroup(
              layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(
                  jButton3,
                  javax.swing.GroupLayout.PREFERRED_SIZE,
                  51,
                  javax.swing.GroupLayout.PREFERRED_SIZE
                )
                .addComponent(jButton4)
            )
            .addContainerGap(
              javax.swing.GroupLayout.DEFAULT_SIZE,
              Short.MAX_VALUE
            )
        )
    );

    pack();
  } // </editor-fold>//GEN-END:initComponents

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) { // GEN-FIRST:event_jButton1ActionPerformed
    // TODO add your handling code here:
    CreateCriterionWindow createCriterionWindow = new CreateCriterionWindow();
    createCriterionWindow.setPromethee(promethee);
    createCriterionWindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    createCriterionWindow.setVisible(true);
  } // GEN-LAST:event_jButton1ActionPerformed

  private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) { // GEN-FIRST:event_ActualizarActionPerformed
    promethee.updateView();
  } // GEN-LAST:event_ActualizarActionPerformed

  private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) { // GEN-FIRST:event_jButton2ActionPerformed
    setTable();
  } // GEN-LAST:event_jButton2ActionPerformed

  private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) { // GEN-FIRST:event_jButton3ActionPerformed
    List<Alternative> alternatives = new ArrayList<>();
    DefaultTableModel defaultTableModel = (DefaultTableModel) getjTable1()
      .getModel();

    for (int i = 0; i < defaultTableModel.getRowCount(); i++) {
      Alternative alternative = new Alternative();
      alternative.setName(defaultTableModel.getValueAt(i, 0).toString());
      for (int j = 1; j < defaultTableModel.getColumnCount(); j++) {
        alternative.addValue(
          Double.parseDouble(defaultTableModel.getValueAt(i, j).toString())
        );
      }
      alternatives.add(alternative);
    }
    promethee.setAlternatives(alternatives);
    SolutionVisualizer solutionVisualizer = new SolutionVisualizer(
      promethee.getTotalOrder(),
      promethee.getPartialOrder()
    );
    solutionVisualizer.setVisible(true);
    solutionVisualizer.setDefaultCloseOperation(HIDE_ON_CLOSE);
  } // GEN-LAST:event_jButton3ActionPerformed

  private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) { // GEN-FIRST:event_jButton4ActionPerformed
    promethee.getCriteria().clear();
    promethee.getAlternatives().clear();
    promethee.updateView();
    this.jTable1.setModel(new DefaultTableModel());
  } // GEN-LAST:event_jButton4ActionPerformed

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
    // (optional) ">
    /*
     * If Nimbus (introduced in Java SE 6) is not available, stay with the default
     * look and feel. For details see
     * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
     */
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java
        .util.logging.Logger.getLogger(PrometheeWindow.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java
        .util.logging.Logger.getLogger(PrometheeWindow.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java
        .util.logging.Logger.getLogger(PrometheeWindow.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java
        .util.logging.Logger.getLogger(PrometheeWindow.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    }
    // </editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(
      new Runnable() {

        public void run() {
          new PrometheeWindow().setVisible(true);
        }
      }
    );
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton Actualizar;
  private javax.swing.JButton jButton1;
  private javax.swing.JButton jButton2;
  private javax.swing.JButton jButton3;
  private javax.swing.JButton jButton4;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JSeparator jSeparator1;
  private javax.swing.JTable jTable1;
  private javax.swing.JTextArea jTextArea1;
  private javax.swing.JTextField nalt;

  // End of variables declaration//GEN-END:variables

  /**
   * @return the jTextArea1
   */
  public javax.swing.JTextArea getjTextArea1() {
    return jTextArea1;
  }

  private void setTable() {
    int numberOfAlternatives = Integer.parseInt(nalt.getText());
    int numberOfCriterion = promethee.getCriteria().size();
    DefaultTableModel defaultTableModel = new DefaultTableModel();

    defaultTableModel.addColumn("Nombre");
    for (int i = 0; i < numberOfCriterion; i++) {
      defaultTableModel.addColumn(promethee.getCriteria().get(i).getName());
    }

    for (int i = 0; i < numberOfAlternatives; i++) {
      Object[] aux = new Object[numberOfCriterion + 1];
      defaultTableModel.addRow(aux);
    }

    this.getjTable1().setModel(defaultTableModel);
  }

  private void setUpTable() {
    int numberOfAlternatives = 4;
    nalt.setText(numberOfAlternatives + "");
    int numberOfCriterion = promethee.getCriteria().size();
    DefaultTableModel defaultTableModel = new DefaultTableModel();

    defaultTableModel.addColumn("Nombre");
    for (int i = 0; i < numberOfCriterion; i++) {
      defaultTableModel.addColumn(promethee.getCriteria().get(i).getName());
    }

    Object[] aux = new Object[numberOfCriterion + 1];
    aux[0] = "CAMFRI S. A";
    aux[1] = 420000;
    aux[2] = 36;
    aux[3] = 1000;
    aux[4] = 93;
    aux[5] = 2;
    defaultTableModel.addRow(aux);

    aux = new Object[numberOfCriterion + 1];
    aux[0] = "LIANCAR ltda";
    aux[1] = 500000;
    aux[2] = 36;
    aux[3] = 2000;
    aux[4] = 96;
    aux[5] = 1;
    defaultTableModel.addRow(aux);

    aux = new Object[numberOfCriterion + 1];
    aux[0] = "AsTransportes";
    aux[1] = 400000;
    aux[2] = 48;
    aux[3] = 1500;
    aux[4] = 90;
    aux[5] = 1;
    defaultTableModel.addRow(aux);

    aux = new Object[numberOfCriterion + 1];
    aux[0] = "AGROTRANS";
    aux[1] = 450000;
    aux[2] = 40;
    aux[3] = 1600;
    aux[4] = 91;
    aux[5] = 2;
    defaultTableModel.addRow(aux);

    /*
     * for(int i=0 ; i<numberOfAlternatives ; i++){ Object [] aux = new
     * Object[numberOfCriterion+1]; aux[0] = "Proveedor " + (i+1); for(int j=1 ;
     * j<=numberOfCriterion ; j++){ aux[j] = (int)(Math.random()*limit[j-1] + 1); }
     * defaultTableModel.addRow(aux); }
     */

    this.getjTable1().setModel(defaultTableModel);
  }

  /**
   * @return the jTable1
   */
  public javax.swing.JTable getjTable1() {
    return jTable1;
  }
}
