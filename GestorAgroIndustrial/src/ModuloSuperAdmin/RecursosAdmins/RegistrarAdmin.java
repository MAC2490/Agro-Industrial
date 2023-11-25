
package ModuloSuperAdmin.RecursosAdmins;

import ModuloSuperAdmin.PanelUsuarios;
import Principal.Alert;
import Principal.ConsumoAPI;
import com.google.gson.Gson;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

public class RegistrarAdmin extends javax.swing.JFrame {

    ConsumoAPI ejemplo = new ConsumoAPI();
    Gson gson = new Gson();
    
    PanelUsuarios ventanaDashboard;
    
    public RegistrarAdmin(PanelUsuarios ventanaDashboard) {        
        this.ventanaDashboard = ventanaDashboard;
        initComponents();
        initAlternComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelHeader = new javax.swing.JPanel();
        LogoGestor = new javax.swing.JLabel();
        etqRegistrar = new javax.swing.JLabel();
        etqAdministrador = new javax.swing.JLabel();
        PanelFormulario = new javax.swing.JPanel();
        etqCedula = new javax.swing.JLabel();
        campo_cedula = new javax.swing.JTextField();
        etqNombre = new javax.swing.JLabel();
        campo_nombre = new javax.swing.JTextField();
        etqApellido = new javax.swing.JLabel();
        campo_apellido = new javax.swing.JTextField();
        campo_estado = new javax.swing.JComboBox<>();
        etqEstado = new javax.swing.JLabel();
        etqRol = new javax.swing.JLabel();
        campo_rol = new javax.swing.JComboBox<>();
        etqPassword = new javax.swing.JLabel();
        campo_password = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Registrar Usuario - Gestor AgroIndustrial");

        PanelHeader.setBackground(new java.awt.Color(0, 0, 0));

        LogoGestor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LogoDashboard.png"))); // NOI18N

        etqRegistrar.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        etqRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        etqRegistrar.setText("REGISTRAR");

        etqAdministrador.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        etqAdministrador.setForeground(new java.awt.Color(255, 255, 255));
        etqAdministrador.setText("ADMINISTRADOR");

        javax.swing.GroupLayout PanelHeaderLayout = new javax.swing.GroupLayout(PanelHeader);
        PanelHeader.setLayout(PanelHeaderLayout);
        PanelHeaderLayout.setHorizontalGroup(
            PanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelHeaderLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(PanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etqRegistrar)
                    .addComponent(etqAdministrador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 178, Short.MAX_VALUE)
                .addComponent(LogoGestor)
                .addGap(20, 20, 20))
        );
        PanelHeaderLayout.setVerticalGroup(
            PanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LogoGestor, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(PanelHeaderLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(etqRegistrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etqAdministrador)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelFormulario.setBackground(new java.awt.Color(255, 255, 255));

        etqCedula.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        etqCedula.setText("CEDULA");

        campo_cedula.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N

        etqNombre.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        etqNombre.setText("NOMBRE");

        campo_nombre.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N

        etqApellido.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        etqApellido.setText("APELLIDO");

        campo_apellido.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N

        campo_estado.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        campo_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ACTIVO", "INACTIVO" }));

        etqEstado.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        etqEstado.setText("ESTADO");

        etqRol.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        etqRol.setText("ROL");

        campo_rol.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        campo_rol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SUPER ADMIN", "ADMIN" }));

        etqPassword.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        etqPassword.setText("PASSWORD");

        campo_password.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N

        btnRegistrar.setBackground(new java.awt.Color(153, 255, 51));
        btnRegistrar.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        btnRegistrar.setFocusable(false);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout PanelFormularioLayout = new javax.swing.GroupLayout(PanelFormulario);
        PanelFormulario.setLayout(PanelFormularioLayout);
        PanelFormularioLayout.setHorizontalGroup(
            PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFormularioLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelFormularioLayout.createSequentialGroup()
                        .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etqNombre)
                            .addComponent(etqCedula)
                            .addComponent(etqApellido)
                            .addComponent(etqEstado)
                            .addComponent(etqRol))
                        .addGap(23, 23, 23)
                        .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campo_rol, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(campo_apellido)
                                .addComponent(campo_cedula)
                                .addComponent(campo_nombre)
                                .addComponent(campo_estado, 0, 205, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelFormularioLayout.createSequentialGroup()
                        .addComponent(etqPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campo_password, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelFormularioLayout.createSequentialGroup()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        PanelFormularioLayout.setVerticalGroup(
            PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFormularioLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etqCedula)
                    .addComponent(campo_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campo_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etqNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campo_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etqApellido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etqEstado)
                    .addComponent(campo_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campo_rol, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etqRol))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etqPassword)
                    .addComponent(campo_password, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(38, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        String cedula = campo_cedula.getText();
        String nombre = campo_nombre.getText();
        String apellido = campo_apellido.getText();
        String estado = (String) campo_estado.getSelectedItem();
        String rol = (String) campo_rol.getSelectedItem();
        String password = campo_password.getText();
        
        if(!cedula.equals("") && !nombre.equals("") && !apellido.equals("") && !estado.equals("") && !rol.equals("") && !password.equals("")){
            
            Map<String, String> getData = new HashMap<>();
            getData.put("cedula", campo_cedula.getText());
            String validarCedulaRepetida = ejemplo.consumoGET("http://localhost/ApiPhp-AgroGestor/usuarios/getPersona.php", getData);
            
            if(validarCedulaRepetida.equals("[]")){
                
                Map<String, String> insertData = new HashMap<>();
                insertData.put("cedula", campo_cedula.getText());
                insertData.put("nombre", campo_nombre.getText());
                insertData.put("apellido", campo_apellido.getText());
                insertData.put("rol", rol);
                insertData.put("estado", estado);
                insertData.put("password", campo_password.getText());
                System.out.println("Consumo INSERT: " + ejemplo.consumoPOST("http://localhost/ApiPhp-AgroGestor/usuarios/Insert.php", insertData));

                campo_cedula.setText("");
                campo_nombre.setText("");
                campo_apellido.setText("");
                campo_password.setText("");

                dispose();   
                Alert alerta = new Alert("Registro Exitoso!", "El usuario se registro correctamente", "success");
                this.ventanaDashboard.cargarDatos();
                
            }else if(!validarCedulaRepetida.equals("[]")){
                Alert alerta = new Alert("Dato Repetido", "La cedula ingresada ya esta registrada", "warning");
            }
            
        }else{
            Alert alerta = new Alert("Error", "Faltan campos por llenar", "error");
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
        this.ventanaDashboard.setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    public void initAlternComponents(){
        setLocationRelativeTo(null);
        setIconImage( getToolkit().createImage( ClassLoader.getSystemResource("img/LogoLOGIN.png") ) );
        
        campo_cedula.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Verificar si el carácter es un número
                if (!Character.isDigit(e.getKeyChar())) {
                    e.consume(); // Consumir el evento para evitar que se ingrese el carácter no deseado
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // No se necesita implementar en este caso
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // No se necesita implementar en este caso
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LogoGestor;
    private javax.swing.JPanel PanelFormulario;
    private javax.swing.JPanel PanelHeader;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JTextField campo_apellido;
    private javax.swing.JTextField campo_cedula;
    private javax.swing.JComboBox<String> campo_estado;
    private javax.swing.JTextField campo_nombre;
    private javax.swing.JTextField campo_password;
    private javax.swing.JComboBox<String> campo_rol;
    private javax.swing.JLabel etqAdministrador;
    private javax.swing.JLabel etqApellido;
    private javax.swing.JLabel etqCedula;
    private javax.swing.JLabel etqEstado;
    private javax.swing.JLabel etqNombre;
    private javax.swing.JLabel etqPassword;
    private javax.swing.JLabel etqRegistrar;
    private javax.swing.JLabel etqRol;
    // End of variables declaration//GEN-END:variables
}
