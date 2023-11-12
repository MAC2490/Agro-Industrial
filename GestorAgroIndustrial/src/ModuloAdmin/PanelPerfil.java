
package ModuloAdmin;

import ModuloAdmin.RecursosDelAdmin.CambiarPassword;
import ModuloAdmin.RecursosDelAdmin.EditarPerfil;
import Principal.ConsumoAPI;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class PanelPerfil extends javax.swing.JPanel {

    String SessionUsuario;
    ConsumoAPI ejemplo = new ConsumoAPI();
    Gson gson = new Gson();

    
    public PanelPerfil(String SessionUsuario) {
        this.SessionUsuario=SessionUsuario;
        initComponents();
        initAlternComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelHeader = new javax.swing.JPanel();
        etqMiPerfil = new javax.swing.JLabel();
        ImgUser = new javax.swing.JLabel();
        etqNombreUsuario = new javax.swing.JLabel();
        etqCedulaUsuario = new javax.swing.JLabel();
        etqPermisos = new javax.swing.JLabel();
        btnEditarPerfil = new javax.swing.JButton();
        btnEditPassword = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        PanelHeader.setBackground(new java.awt.Color(222, 222, 222));

        etqMiPerfil.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        etqMiPerfil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etqMiPerfil.setText("MI PERFIL");

        javax.swing.GroupLayout PanelHeaderLayout = new javax.swing.GroupLayout(PanelHeader);
        PanelHeader.setLayout(PanelHeaderLayout);
        PanelHeaderLayout.setHorizontalGroup(
            PanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(etqMiPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelHeaderLayout.setVerticalGroup(
            PanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHeaderLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(etqMiPerfil)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        ImgUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ImgUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/UserIMG.png"))); // NOI18N

        etqNombreUsuario.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        etqNombreUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etqNombreUsuario.setText("NOMBRE USUARIO");

        etqCedulaUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        etqCedulaUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etqCedulaUsuario.setText("0000000000");

        etqPermisos.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        etqPermisos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etqPermisos.setText("ESTADO / ROL");

        btnEditarPerfil.setBackground(new java.awt.Color(0, 0, 102));
        btnEditarPerfil.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        btnEditarPerfil.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarPerfil.setText("EDITAR PERFIL");
        btnEditarPerfil.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        btnEditarPerfil.setFocusable(false);
        btnEditarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarPerfilActionPerformed(evt);
            }
        });

        btnEditPassword.setBackground(new java.awt.Color(153, 153, 255));
        btnEditPassword.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        btnEditPassword.setText("CAMBIAR CONTRASEÑA");
        btnEditPassword.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        btnEditPassword.setFocusable(false);
        btnEditPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etqCedulaUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ImgUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(etqNombreUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(etqPermisos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(169, Short.MAX_VALUE)
                .addComponent(btnEditPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnEditarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(169, 169, 169))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ImgUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(etqNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etqCedulaUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etqPermisos)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 34, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarPerfilActionPerformed
        EditarPerfil ventana = new EditarPerfil(this, SessionUsuario);
        ventana.setVisible(true);
    }//GEN-LAST:event_btnEditarPerfilActionPerformed

    private void btnEditPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditPasswordActionPerformed
        CambiarPassword ventana = new CambiarPassword(this, SessionUsuario);
        ventana.setVisible(true);
    }//GEN-LAST:event_btnEditPasswordActionPerformed

    public void initAlternComponents(){
        JsonObject jsonObject = gson.fromJson(SessionUsuario, JsonObject.class);
        
        String nombreUsuario = jsonObject.get("nombre").getAsString();
        String apellidoUsuario = jsonObject.get("apellido").getAsString();
        String cedulaUsuario = jsonObject.get("cedula").getAsString();
        String estadoUsuario = jsonObject.get("estado").getAsString();
        String rolUsuario = jsonObject.get("rol").getAsString();

        
        etqNombreUsuario.setText(nombreUsuario+" "+apellidoUsuario);
        etqCedulaUsuario.setText(cedulaUsuario);
        etqPermisos.setText(estadoUsuario+" / "+rolUsuario);
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ImgUser;
    private javax.swing.JPanel PanelHeader;
    private javax.swing.JButton btnEditPassword;
    private javax.swing.JButton btnEditarPerfil;
    private javax.swing.JLabel etqCedulaUsuario;
    private javax.swing.JLabel etqMiPerfil;
    private javax.swing.JLabel etqNombreUsuario;
    private javax.swing.JLabel etqPermisos;
    // End of variables declaration//GEN-END:variables
}
