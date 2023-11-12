
package ModuloAdmin.RecursosDelAdmin;

import ModuloAdmin.PanelPerfil;
import Principal.Alert;
import Principal.ConsumoAPI;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Map;


public class CambiarPassword extends javax.swing.JFrame {

    PanelPerfil ventanaDashboard;
    ConsumoAPI ejemplo = new ConsumoAPI();
    Gson gson = new Gson();
    String DatosPersona;
    
    public CambiarPassword(PanelPerfil ventanaDashboard, String SessionUsuario) {
        this.ventanaDashboard = ventanaDashboard;
        this.DatosPersona = SessionUsuario;
        initComponents();
        initAlternComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelHeader = new javax.swing.JPanel();
        etqCambiar = new javax.swing.JLabel();
        etqContrasena = new javax.swing.JLabel();
        LogoGestor = new javax.swing.JLabel();
        PanelFormulario = new javax.swing.JPanel();
        etqContraseñaActual = new javax.swing.JLabel();
        campo_passwordActual = new javax.swing.JTextField();
        Separator = new javax.swing.JSeparator();
        etqContraseñaNueva = new javax.swing.JLabel();
        campo_passwordNueva = new javax.swing.JTextField();
        etqContraseñaConfirmar = new javax.swing.JLabel();
        campo_passwordConfirmar = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Cambiar Contraseña - Gestor AgroIndustrial");
        setResizable(false);

        PanelHeader.setBackground(new java.awt.Color(0, 0, 0));

        etqCambiar.setBackground(new java.awt.Color(255, 255, 255));
        etqCambiar.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        etqCambiar.setForeground(new java.awt.Color(255, 255, 255));
        etqCambiar.setText("CAMBIAR");

        etqContrasena.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        etqContrasena.setForeground(new java.awt.Color(255, 255, 255));
        etqContrasena.setText("CONTRASEÑA");

        LogoGestor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LogoDashboard.png"))); // NOI18N
        LogoGestor.setText("jLabel3");

        javax.swing.GroupLayout PanelHeaderLayout = new javax.swing.GroupLayout(PanelHeader);
        PanelHeader.setLayout(PanelHeaderLayout);
        PanelHeaderLayout.setHorizontalGroup(
            PanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHeaderLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(PanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etqCambiar)
                    .addComponent(etqContrasena))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LogoGestor, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        PanelHeaderLayout.setVerticalGroup(
            PanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHeaderLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(etqCambiar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etqContrasena)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LogoGestor, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );

        PanelFormulario.setBackground(new java.awt.Color(255, 255, 255));

        etqContraseñaActual.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        etqContraseñaActual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etqContraseñaActual.setText("CONTRASEÑA ACTUAL");

        campo_passwordActual.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        campo_passwordActual.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        Separator.setBackground(new java.awt.Color(50, 50, 50));
        Separator.setForeground(new java.awt.Color(50, 50, 50));

        etqContraseñaNueva.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        etqContraseñaNueva.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etqContraseñaNueva.setText("NUEVA CONTRASEÑA");

        campo_passwordNueva.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        campo_passwordNueva.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        etqContraseñaConfirmar.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        etqContraseñaConfirmar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etqContraseñaConfirmar.setText("CONFIRMAR CONTRASEÑA");

        campo_passwordConfirmar.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        campo_passwordConfirmar.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnCancelar.setBackground(new java.awt.Color(204, 204, 204));
        btnCancelar.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        btnCancelar.setFocusable(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnActualizar.setBackground(new java.awt.Color(153, 255, 51));
        btnActualizar.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        btnActualizar.setFocusable(false);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelFormularioLayout = new javax.swing.GroupLayout(PanelFormulario);
        PanelFormulario.setLayout(PanelFormularioLayout);
        PanelFormularioLayout.setHorizontalGroup(
            PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFormularioLayout.createSequentialGroup()
                .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelFormularioLayout.createSequentialGroup()
                        .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelFormularioLayout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(campo_passwordActual, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelFormularioLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(Separator, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelFormularioLayout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(campo_passwordNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 13, Short.MAX_VALUE))
                    .addGroup(PanelFormularioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etqContraseñaActual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(etqContraseñaNueva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(etqContraseñaConfirmar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(PanelFormularioLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(campo_passwordConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelFormularioLayout.createSequentialGroup()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelFormularioLayout.setVerticalGroup(
            PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFormularioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etqContraseñaActual)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campo_passwordActual, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Separator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etqContraseñaNueva)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campo_passwordNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(etqContraseñaConfirmar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campo_passwordConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PanelFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        JsonObject jsonObject = gson.fromJson(DatosPersona, JsonObject.class);
        
        String cedulaUsuario = jsonObject.get("cedula").getAsString();
        String passwordUsuario = jsonObject.get("password").getAsString();
        
        String passwordActual = campo_passwordActual.getText();
        String newPassword =  campo_passwordNueva.getText();
        String confirmPassword =  campo_passwordConfirmar.getText();
        
        if(!passwordActual.equals("") && !newPassword.equals("") && !confirmPassword.equals("")){
            if(passwordUsuario.equals(passwordActual)){
                if(newPassword.equals(confirmPassword)){
                    
                    Map<String, String> updateData = new HashMap<>();            
                    updateData.put("cedula", cedulaUsuario);
                    updateData.put("password", campo_passwordConfirmar.getText());

                    System.out.println("Consumo UPDATE: " + ejemplo.consumoPOST("http://localhost/ApiPhp-AgroGestor/usuarios/UpdatePass.php", updateData));

                    String respuesta = ejemplo.consumoPOST("http://localhost/ApiPhp-AgroGestor/usuarios/UpdatePass.php", updateData);
                    JsonObject JsonRespuesta = gson.fromJson(respuesta, JsonObject.class);
                    String status = JsonRespuesta.get("status").getAsString();  

                    if (status.equals("true")){
                        Alert alerta = new Alert("Modificacion Exitosa!", "Tus contraseña se actualizo correctamente", "success");   
                        dispose();
                    }else if(status.equals("false")){
                        Alert alerta = new Alert("Modificacion Erronea!", "La contraseña no se actualizo", "error");   
                    }
                        
                }else{
                    Alert alerta = new Alert("Error En Datos", "La nueva contraseña no coincide con la confirmacion", "warning");
                }
            }else{
                Alert alerta = new Alert("Error", "La contraseña ingresada es incorrecta", "error");
            }
        }else{
            Alert alerta = new Alert("Error", "Faltan campos por llenar", "error");
        }
        
        
        
    }//GEN-LAST:event_btnActualizarActionPerformed

    public void initAlternComponents(){
        setLocationRelativeTo(null);
        setIconImage( getToolkit().createImage( ClassLoader.getSystemResource("img/LogoLOGIN.png") ) );
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LogoGestor;
    private javax.swing.JPanel PanelFormulario;
    private javax.swing.JPanel PanelHeader;
    private javax.swing.JSeparator Separator;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JTextField campo_passwordActual;
    private javax.swing.JTextField campo_passwordConfirmar;
    private javax.swing.JTextField campo_passwordNueva;
    private javax.swing.JLabel etqCambiar;
    private javax.swing.JLabel etqContrasena;
    private javax.swing.JLabel etqContraseñaActual;
    private javax.swing.JLabel etqContraseñaConfirmar;
    private javax.swing.JLabel etqContraseñaNueva;
    // End of variables declaration//GEN-END:variables
}
