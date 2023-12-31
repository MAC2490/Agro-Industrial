
package Principal;

import java.awt.Color;
import static java.awt.Color.blue;
import javax.swing.ImageIcon;

public class AlertMauricio extends javax.swing.JFrame {

    public AlertMauricio(String titulo, String mensaje, String tipo, boolean color) {
        initComponents();
        
        if (color) {
            Color colorPanel = new Color(51,70,191);
            this.contentPrincipal.setBackground(colorPanel);
            this.etqImagen.setBackground(colorPanel);
            this.etqMensaje.setBackground(colorPanel);
            this.etqTitulo.setBackground(colorPanel);
            Color colorBtn = new Color(51,121,210);
            this.btnAceptar.setBackground(colorBtn);
        }
        
        String textoIcono = "";
        if (tipo.equals("success")) {
            textoIcono = "verificado.gif";
        } else if (tipo.equals("error")) {
            textoIcono = "warning.gif";
        } else if (tipo.equals("warning")) {
            textoIcono = "giphy.gif";
        }

        ImageIcon gifIcon = new ImageIcon(ClassLoader.getSystemResource("Gif/" + textoIcono));
        etqImagen.setIcon(gifIcon);

        etqTitulo.setText(titulo);
        etqMensaje.setText(mensaje);
        setLocationRelativeTo(null);
        setTitle("Alerta");
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentPrincipal = new javax.swing.JPanel();
        etqTitulo = new javax.swing.JLabel();
        etqImagen = new javax.swing.JLabel();
        etqMensaje = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        contentPrincipal.setBackground(new java.awt.Color(153, 255, 153));

        etqTitulo.setBackground(new java.awt.Color(153, 255, 153));
        etqTitulo.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        etqTitulo.setForeground(new java.awt.Color(0, 0, 0));
        etqTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etqTitulo.setText("XXXXXx");
        etqTitulo.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        etqTitulo.setOpaque(true);

        etqImagen.setBackground(new java.awt.Color(153, 255, 153));
        etqImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etqImagen.setOpaque(true);

        etqMensaje.setBackground(new java.awt.Color(153, 255, 153));
        etqMensaje.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        etqMensaje.setForeground(new java.awt.Color(0, 0, 0));
        etqMensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etqMensaje.setText("XXXXXXXXXXXXxxx");
        etqMensaje.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        etqMensaje.setOpaque(true);

        btnAceptar.setBackground(new java.awt.Color(153, 255, 51));
        btnAceptar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(0, 0, 0));
        btnAceptar.setText("Aceptar");
        btnAceptar.setFocusable(false);
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contentPrincipalLayout = new javax.swing.GroupLayout(contentPrincipal);
        contentPrincipal.setLayout(contentPrincipalLayout);
        contentPrincipalLayout.setHorizontalGroup(
            contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102))
            .addGroup(contentPrincipalLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(etqImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPrincipalLayout.createSequentialGroup()
                        .addComponent(etqTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(etqMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        contentPrincipalLayout.setVerticalGroup(
            contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(contentPrincipalLayout.createSequentialGroup()
                        .addComponent(etqTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(etqMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(etqImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JPanel contentPrincipal;
    private javax.swing.JLabel etqImagen;
    private javax.swing.JLabel etqMensaje;
    private javax.swing.JLabel etqTitulo;
    // End of variables declaration//GEN-END:variables
}
