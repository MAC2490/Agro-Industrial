
package ModuloAdmin.RecursosDelAdmin;

import ModuloAdmin.PanelPerfil;
import Principal.Alert;
import Principal.ConsumoAPI;
import com.google.gson.JsonObject;
import com.google.gson.Gson;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

public final class EditarPerfil extends javax.swing.JFrame {

    PanelPerfil ventanaDashboard;
    ConsumoAPI ejemplo = new ConsumoAPI();
    Gson gson = new Gson();
    String DatosPersona;
    

    public EditarPerfil(PanelPerfil ventanaDashboard, String SessionUsuario) {
        this.ventanaDashboard = ventanaDashboard;
        this.DatosPersona = SessionUsuario;
        
        initComponents();
        initAlternComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelHeader = new javax.swing.JPanel();
        etqEditar = new javax.swing.JLabel();
        etqPerfil = new javax.swing.JLabel();
        LogoGestor = new javax.swing.JLabel();
        PanelFormulario = new javax.swing.JPanel();
        etqCedula = new javax.swing.JLabel();
        campo_cedula = new javax.swing.JTextField();
        etqNombre = new javax.swing.JLabel();
        campo_nombre = new javax.swing.JTextField();
        etqApellido = new javax.swing.JLabel();
        campo_apellido = new javax.swing.JTextField();
        etqEstado = new javax.swing.JLabel();
        etqRol = new javax.swing.JLabel();
        campo_estado = new javax.swing.JComboBox<>();
        campo_rol = new javax.swing.JComboBox<>();
        btnCancelar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Editar Perfil - Gestor AgroIndustrial");
        setResizable(false);

        PanelHeader.setBackground(new java.awt.Color(0, 0, 0));

        etqEditar.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        etqEditar.setForeground(new java.awt.Color(255, 255, 255));
        etqEditar.setText("EDITAR");

        etqPerfil.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        etqPerfil.setForeground(new java.awt.Color(255, 255, 255));
        etqPerfil.setText("MI PERFIL");

        LogoGestor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LogoDashboard.png"))); // NOI18N

        javax.swing.GroupLayout PanelHeaderLayout = new javax.swing.GroupLayout(PanelHeader);
        PanelHeader.setLayout(PanelHeaderLayout);
        PanelHeaderLayout.setHorizontalGroup(
            PanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHeaderLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etqPerfil)
                    .addComponent(etqEditar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LogoGestor)
                .addGap(19, 19, 19))
        );
        PanelHeaderLayout.setVerticalGroup(
            PanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHeaderLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(etqEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etqPerfil)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LogoGestor, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
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

        etqEstado.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        etqEstado.setText("ESTADO");

        etqRol.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        etqRol.setText("ROL");

        campo_estado.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        campo_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ACTIVO", "INACTIVO" }));

        campo_rol.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        campo_rol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADMIN", "SUPER ADMIN" }));

        btnCancelar.setBackground(new java.awt.Color(204, 204, 204));
        btnCancelar.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        btnCancelar.setFocusable(false);
        btnCancelar.setPreferredSize(new java.awt.Dimension(155, 35));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnModificar.setBackground(new java.awt.Color(153, 255, 51));
        btnModificar.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        btnModificar.setText("MODIFICAR");
        btnModificar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        btnModificar.setFocusable(false);
        btnModificar.setPreferredSize(new java.awt.Dimension(155, 35));
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelFormularioLayout = new javax.swing.GroupLayout(PanelFormulario);
        PanelFormulario.setLayout(PanelFormularioLayout);
        PanelFormularioLayout.setHorizontalGroup(
            PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFormularioLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PanelFormularioLayout.createSequentialGroup()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelFormularioLayout.createSequentialGroup()
                        .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(PanelFormularioLayout.createSequentialGroup()
                                    .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(etqCedula)
                                        .addComponent(etqNombre))
                                    .addGap(27, 27, 27))
                                .addGroup(PanelFormularioLayout.createSequentialGroup()
                                    .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(etqApellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(etqEstado))
                                    .addGap(18, 18, 18)))
                            .addGroup(PanelFormularioLayout.createSequentialGroup()
                                .addComponent(etqRol)
                                .addGap(76, 76, 76)))
                        .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campo_nombre, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(campo_cedula, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(campo_apellido, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(campo_estado, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(campo_rol, 0, 205, Short.MAX_VALUE))))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        PanelFormularioLayout.setVerticalGroup(
            PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFormularioLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campo_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etqCedula))
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
                    .addComponent(campo_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etqEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campo_rol, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etqRol))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
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

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    
    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        String cedula = campo_cedula.getText();
        String nombre = campo_nombre.getText();
        String apellido = campo_apellido.getText();
        String estado = (String) campo_estado.getSelectedItem();
        String rol = (String) campo_rol.getSelectedItem();

        if(!cedula.equals("") && !nombre.equals("") && !apellido.equals("") && !estado.equals("") && !rol.equals("")){
        
            Map<String, String> updateData = new HashMap<>();            
            JsonObject ObjetoPersona = gson.fromJson(DatosPersona, JsonObject.class);
            String id_Usuario = ObjetoPersona.get("id_usuario").getAsString();
            String passwordUsuario = ObjetoPersona.get("password").getAsString();
            
            updateData.put("id_usuario", id_Usuario);
            updateData.put("cedula", campo_cedula.getText());
            updateData.put("nombre", campo_nombre.getText());
            updateData.put("apellido", campo_apellido.getText());
            updateData.put("estado", estado);
            updateData.put("rol", rol);
            updateData.put("password", passwordUsuario);

            System.out.println("Consumo UPDATE: " + ejemplo.consumoPOST("http://localhost/ApiPhp-AgroGestor/usuarios/Update.php", updateData));
            
            String respuesta = ejemplo.consumoPOST("http://localhost/ApiPhp-AgroGestor/usuarios/Update.php", updateData);
            JsonObject jsonObject = gson.fromJson(respuesta, JsonObject.class);
            String status = jsonObject.get("status").getAsString();  
            
            if (status.equals("true")){
                Alert alerta = new Alert("Modificacion Exitosa!", "Tus datos se actualizaron correctamente", "success");   
                dispose();
            }else if(status.equals("false")){
                Alert alerta = new Alert("Modificacion Incorrecta!", "La cedula esta repetida", "warning");   
            }
            
        }else{
            Alert alerta = new Alert("Error", "Faltan campos por llenar", "error");
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    
    public void initAlternComponents(){
        setLocationRelativeTo(null);
        setIconImage( getToolkit().createImage( ClassLoader.getSystemResource("img/LogoLOGIN.png") ) );
        
        JsonObject ObjetoPersona = gson.fromJson(DatosPersona, JsonObject.class);
        String cedulaUsuario = ObjetoPersona.get("cedula").getAsString();
        String nombreUsuario = ObjetoPersona.get("nombre").getAsString();
        String apellidoUsuario = ObjetoPersona.get("apellido").getAsString();
        String estadoUsuario = ObjetoPersona.get("estado").getAsString();
        String rolUsuario = ObjetoPersona.get("rol").getAsString();

        campo_cedula.setText(cedulaUsuario);
        campo_nombre.setText(nombreUsuario);
        campo_apellido.setText(apellidoUsuario);
        campo_estado.setSelectedItem(estadoUsuario);
        campo_rol.setSelectedItem(rolUsuario);
        
        
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
    private javax.swing.JButton btnModificar;
    private javax.swing.JTextField campo_apellido;
    private javax.swing.JTextField campo_cedula;
    private javax.swing.JComboBox<String> campo_estado;
    private javax.swing.JTextField campo_nombre;
    private javax.swing.JComboBox<String> campo_rol;
    private javax.swing.JLabel etqApellido;
    private javax.swing.JLabel etqCedula;
    private javax.swing.JLabel etqEditar;
    private javax.swing.JLabel etqEstado;
    private javax.swing.JLabel etqNombre;
    private javax.swing.JLabel etqPerfil;
    private javax.swing.JLabel etqRol;
    // End of variables declaration//GEN-END:variables
}
