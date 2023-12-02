
package Principal;

import ModuloAdmin.DashBoardAdmin;
import ModuloSuperAdmin.DashBoard;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;


public class Login extends javax.swing.JFrame {

    ConsumoAPI ejemplo = new ConsumoAPI();
    Gson gson = new Gson();
    
    public Login() {
        initComponents();
        initAlternComponents();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelDatosApp = new javax.swing.JPanel();
        LogoAgroGestor = new javax.swing.JLabel();
        etqNombreA = new javax.swing.JLabel();
        etqNombreB = new javax.swing.JLabel();
        PanelLogin = new javax.swing.JPanel();
        ImgUser = new javax.swing.JLabel();
        etqDocumento = new javax.swing.JLabel();
        campo_documento = new javax.swing.JTextField();
        etqPassword = new javax.swing.JLabel();
        campo_password = new javax.swing.JTextField();
        btnIngresar = new javax.swing.JButton();
        DisenoInferior = new javax.swing.JLabel();
        etqInfo = new javax.swing.JLabel();
        etqLogin = new javax.swing.JLabel();
        PanelHeader = new javax.swing.JPanel();
        etqDevelopers = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Iniciar Session - Gestor AgroIndustrial");
        setResizable(false);

        PanelDatosApp.setBackground(new java.awt.Color(153, 255, 51));

        LogoAgroGestor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LogoAgroGestor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LogoLOGIN.png"))); // NOI18N

        etqNombreA.setFont(new java.awt.Font("Tw Cen MT", 0, 36)); // NOI18N
        etqNombreA.setForeground(new java.awt.Color(58, 58, 58));
        etqNombreA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etqNombreA.setText("GESTOR DE ACTIVOS");

        etqNombreB.setFont(new java.awt.Font("Tw Cen MT", 0, 36)); // NOI18N
        etqNombreB.setForeground(new java.awt.Color(58, 58, 58));
        etqNombreB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etqNombreB.setText("AGRO-INDUSTRIALES");

        javax.swing.GroupLayout PanelDatosAppLayout = new javax.swing.GroupLayout(PanelDatosApp);
        PanelDatosApp.setLayout(PanelDatosAppLayout);
        PanelDatosAppLayout.setHorizontalGroup(
            PanelDatosAppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(etqNombreB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(etqNombreA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
            .addComponent(LogoAgroGestor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelDatosAppLayout.setVerticalGroup(
            PanelDatosAppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDatosAppLayout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(LogoAgroGestor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(etqNombreA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etqNombreB)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelLogin.setBackground(new java.awt.Color(255, 255, 255));

        ImgUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ImgUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/UserIMG.png"))); // NOI18N

        etqDocumento.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        etqDocumento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etqDocumento.setText("DOCUMENTO");

        campo_documento.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        campo_documento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campo_documento.setText("1");

        etqPassword.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        etqPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etqPassword.setText("CONTRASEÑA");

        campo_password.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        campo_password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campo_password.setText("Q");

        btnIngresar.setBackground(new java.awt.Color(153, 255, 51));
        btnIngresar.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        btnIngresar.setText("INGRESAR");
        btnIngresar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        DisenoInferior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/DiseñoInferior.png"))); // NOI18N

        etqInfo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        etqInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etqInfo.setText("Ingresa tus datos para iniciar en el sistema!");

        etqLogin.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        etqLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etqLogin.setText("INICIAR SESSION");

        javax.swing.GroupLayout PanelLoginLayout = new javax.swing.GroupLayout(PanelLogin);
        PanelLogin.setLayout(PanelLoginLayout);
        PanelLoginLayout.setHorizontalGroup(
            PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLoginLayout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addGroup(PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campo_documento, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etqDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campo_password, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etqPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(107, Short.MAX_VALUE))
            .addGroup(PanelLoginLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addComponent(DisenoInferior))
            .addComponent(etqLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ImgUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(etqInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelLoginLayout.setVerticalGroup(
            PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLoginLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(etqLogin)
                .addGap(18, 18, 18)
                .addComponent(ImgUser, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(etqInfo)
                .addGap(26, 26, 26)
                .addGroup(PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etqDocumento, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(etqPassword, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLoginLayout.createSequentialGroup()
                        .addGap(18, 82, Short.MAX_VALUE)
                        .addComponent(DisenoInferior))
                    .addGroup(PanelLoginLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campo_documento, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campo_password, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        PanelHeader.setBackground(new java.awt.Color(0, 0, 0));

        etqDevelopers.setBackground(new java.awt.Color(255, 255, 255));
        etqDevelopers.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        etqDevelopers.setForeground(new java.awt.Color(255, 255, 255));
        etqDevelopers.setText("Desarrollado Por EnginnerSoft");
        etqDevelopers.setToolTipText("");

        javax.swing.GroupLayout PanelHeaderLayout = new javax.swing.GroupLayout(PanelHeader);
        PanelHeader.setLayout(PanelHeaderLayout);
        PanelHeaderLayout.setHorizontalGroup(
            PanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelHeaderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(etqDevelopers)
                .addContainerGap())
        );
        PanelHeaderLayout.setVerticalGroup(
            PanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHeaderLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(etqDevelopers)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(PanelDatosApp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PanelHeader, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(PanelDatosApp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        String documento = campo_documento.getText();
        String password = campo_password.getText();
        
        if(!documento.equals("") && !password.equals("")){
            
            Map<String, String> getData = new HashMap<>();
            getData.put("cedula", campo_documento.getText());
            String ConsultaIndividual = ejemplo.consumoGET("http://localhost/ApiPhp-AgroGestor/usuarios/getPersona.php", getData);
            
            if(!ConsultaIndividual.equals("[]")){
                JsonObject jsonObject = gson.fromJson(ConsultaIndividual, JsonObject.class);

                String documentoRegistrado = jsonObject.get("cedula").getAsString();
                String passwordRegistrado = jsonObject.get("password").getAsString();                
                String estadoRegistrado = jsonObject.get("estado").getAsString();
                String rolRegistrado = jsonObject.get("rol").getAsString();
                
                if( documento.equals(documentoRegistrado) && password.equals(passwordRegistrado)){
                    if(estadoRegistrado.equals("ACTIVO")){
                        if(rolRegistrado.equals("SUPER ADMIN")){
                            String DatosUsuario = ConsultaIndividual;
                            setVisible(false);
                            DashBoard ventana = new DashBoard(this, DatosUsuario);
                            ventana.setVisible(true);
                            campo_documento.setText("");
                            campo_password.setText("");
                            
                        }else if(rolRegistrado.equals("ADMIN")){
                            String DatosUsuario = ConsultaIndividual;
                            setVisible(false);
                            DashBoardAdmin ventana = new DashBoardAdmin(this, DatosUsuario);
                            ventana.setVisible(true);
                            campo_documento.setText("");
                            campo_password.setText("");
                        }
                    }else if(estadoRegistrado.equals("INACTIVO")){
                        Alert alerta = new Alert("Estado Inactivo", "Su estado es inactivo - Consulte a su administrador", "warning");
                    }
                    
                }else{
                    Alert alerta = new Alert("Datos Incorrectos", "La contraseña es incorrecta", "warning");
                }
            }else{
                Alert alerta = new Alert("No Encontrado", "La cedula no esta registrada", "error");
            }
        }else{
            Alert alerta = new Alert("Error", "Faltan campos por llenar", "error");
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

 
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    
    public void initAlternComponents(){
        System.out.println("Iniciando el programa");
        setLocationRelativeTo(null);
        setIconImage( getToolkit().createImage( ClassLoader.getSystemResource("img/LogoLOGIN.png") ) );
        
        campo_documento.addKeyListener(new KeyListener() {
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
    private javax.swing.JLabel DisenoInferior;
    private javax.swing.JLabel ImgUser;
    private javax.swing.JLabel LogoAgroGestor;
    private javax.swing.JPanel PanelDatosApp;
    private javax.swing.JPanel PanelHeader;
    private javax.swing.JPanel PanelLogin;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JTextField campo_documento;
    private javax.swing.JTextField campo_password;
    private javax.swing.JLabel etqDevelopers;
    private javax.swing.JLabel etqDocumento;
    private javax.swing.JLabel etqInfo;
    private javax.swing.JLabel etqLogin;
    private javax.swing.JLabel etqNombreA;
    private javax.swing.JLabel etqNombreB;
    private javax.swing.JLabel etqPassword;
    // End of variables declaration//GEN-END:variables
}
