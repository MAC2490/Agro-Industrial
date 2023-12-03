package ModuloSuperAdmin;

import Clases.insumos;
import Principal.ConsumoAPI;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;

public class EstadoInsumo extends javax.swing.JFrame {

    insumos insumo = null;
    boolean estado;
    PanelInsumos ventana;
    ConsumoAPI conexion = new ConsumoAPI();

    public EstadoInsumo(String titulo, insumos insumo, boolean estado, PanelInsumos ventana) {
        this.ventana = ventana;

        this.estado = estado;
        this.insumo = insumo;
        initComponents();

        ImageIcon gifIcon = new ImageIcon(ClassLoader.getSystemResource("Gif/warning.gif"));
        etqImagen.setIcon(gifIcon);

        etqMensaje.setText(titulo);
        setLocationRelativeTo(null);
        setTitle("Alerta");
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        etqMensaje = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        etqImagen = new javax.swing.JLabel();
        btnAceptar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        etqMensaje.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        etqMensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etqMensaje.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        etqMensaje.setOpaque(true);

        btnCancelar.setBackground(new java.awt.Color(0, 0, 102));
        btnCancelar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("cancelar");
        btnCancelar.setFocusable(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        etqImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etqImagen.setOpaque(true);

        btnAceptar1.setBackground(new java.awt.Color(0, 0, 102));
        btnAceptar1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnAceptar1.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptar1.setText("Aceptar");
        btnAceptar1.setFocusable(false);
        btnAceptar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(etqImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(etqMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(btnAceptar1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etqImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(etqMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAceptar1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptar1ActionPerformed
        // validamos que los campos de los insumos no venga vacios
        if (!insumo.getInsumos_id().equals("") && !insumo.getEstado().equals("")) {
            System.out.println("Entro aqui");
            // miramos si el estado es true o false

            if (this.estado) {
                System.out.println("Entro aqui true");
                // se desabilita
                Map<String, String> Actualizar = new HashMap<>();
                Actualizar.put("id_insumo", insumo.getInsumos_id());
                Actualizar.put("estado", "DESHABILITADO");

                System.out.println("Consumo Insert" + conexion.consumoPOST("http://localhost/ApiPhp-AgroGestor/insumos/UpdateEstado.php", Actualizar));
                ventana.initAlternComponents();
                ventana.setVisible(true);
                dispose();
                System.out.println("Identificador" + insumo.getInsumos_id());
            } else {
                System.out.println("Entro aqui false");
                // se habilita
                Map<String, String> Actualizar = new HashMap<>();
                Actualizar.put("id_insumo", insumo.getInsumos_id());
                Actualizar.put("estado", "ACTIVO");
                System.out.println("Identificador" + insumo.getInsumos_id());
                System.out.println("Consumo Insert" + conexion.consumoPOST("http://localhost/ApiPhp-AgroGestor/insumos/UpdateEstado.php", Actualizar));
                ventana.initAlternComponents();
                ventana.setVisible(true);
                dispose();
            }

        } else {
            System.out.println("Entro aqui vacio");
        }


    }//GEN-LAST:event_btnAceptar1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar1;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel etqImagen;
    private javax.swing.JLabel etqMensaje;
    // End of variables declaration//GEN-END:variables
}
