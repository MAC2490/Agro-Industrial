
package ModuloAdmin.RecursosDelAdmin;

import ModuloAdmin.PanelCultivosAdmin;
import Principal.Alert;
import Principal.ConsumoAPI;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

public class AgregarCultivo extends javax.swing.JFrame {

    ConsumoAPI ejemplo = new ConsumoAPI();
    Gson gson = new Gson();
    PanelCultivosAdmin ventanaDashboard;
    String id_user;
    String id_finca;
        
    public AgregarCultivo(PanelCultivosAdmin ventanaDashboard, String id_user, String id_finca) {
        
        this.id_user=id_user;
        this.id_finca=id_finca;
        this.ventanaDashboard = ventanaDashboard;

        initComponents();
        initAlternComponents();
        
        System.out.println("El id de usuario es: "+id_user);
        System.out.println("El id de la finca es: "+id_finca);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelHeader = new javax.swing.JPanel();
        etqRegistrar = new javax.swing.JLabel();
        etqCultivos = new javax.swing.JLabel();
        Img = new javax.swing.JLabel();
        PanelFormulario = new javax.swing.JPanel();
        etqNombre = new javax.swing.JLabel();
        campo_nombre = new javax.swing.JTextField();
        etqDescripcion = new javax.swing.JLabel();
        campo_descripcion = new javax.swing.JTextField();
        etqTiempoCosecha = new javax.swing.JLabel();
        campo_tiempo = new javax.swing.JTextField();
        etqEstado = new javax.swing.JLabel();
        campo_estado = new javax.swing.JComboBox<>();
        btnCancelar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        campo_id = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Registrar Cultivo - Gestor AgroIndustrial");
        setResizable(false);

        PanelHeader.setBackground(new java.awt.Color(0, 0, 0));

        etqRegistrar.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        etqRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        etqRegistrar.setText("REGISTRAR");

        etqCultivos.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        etqCultivos.setForeground(new java.awt.Color(255, 255, 255));
        etqCultivos.setText("CULTIVO");

        Img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LogoDashboard.png"))); // NOI18N

        javax.swing.GroupLayout PanelHeaderLayout = new javax.swing.GroupLayout(PanelHeader);
        PanelHeader.setLayout(PanelHeaderLayout);
        PanelHeaderLayout.setHorizontalGroup(
            PanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHeaderLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(PanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etqCultivos)
                    .addComponent(etqRegistrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Img)
                .addGap(26, 26, 26))
        );
        PanelHeaderLayout.setVerticalGroup(
            PanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHeaderLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(etqRegistrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etqCultivos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Img, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );

        PanelFormulario.setBackground(new java.awt.Color(255, 255, 255));

        etqNombre.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        etqNombre.setText("NOMBRE");

        campo_nombre.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        campo_nombre.setToolTipText("");

        etqDescripcion.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        etqDescripcion.setText("DESCRIPCION");
        etqDescripcion.setToolTipText("");

        campo_descripcion.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N

        etqTiempoCosecha.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        etqTiempoCosecha.setText("TIEMPO COSECHA");

        campo_tiempo.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N

        etqEstado.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        etqEstado.setText("ESTADO");
        etqEstado.setToolTipText("");

        campo_estado.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        campo_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DISPONIBLE", "NO DISPONIBLE" }));

        btnCancelar.setBackground(new java.awt.Color(204, 204, 204));
        btnCancelar.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnRegistrar.setBackground(new java.awt.Color(0, 0, 153));
        btnRegistrar.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        jLabel1.setText("ID CULTIVO");
        jLabel1.setToolTipText("");

        campo_id.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N

        javax.swing.GroupLayout PanelFormularioLayout = new javax.swing.GroupLayout(PanelFormulario);
        PanelFormulario.setLayout(PanelFormularioLayout);
        PanelFormularioLayout.setHorizontalGroup(
            PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFormularioLayout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelFormularioLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelFormularioLayout.createSequentialGroup()
                        .addComponent(etqDescripcion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(campo_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelFormularioLayout.createSequentialGroup()
                        .addComponent(etqEstado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(campo_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelFormularioLayout.createSequentialGroup()
                        .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etqNombre)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campo_id, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(campo_nombre)))
                    .addGroup(PanelFormularioLayout.createSequentialGroup()
                        .addComponent(etqTiempoCosecha)
                        .addGap(18, 18, 18)
                        .addComponent(campo_tiempo)))
                .addGap(55, 55, 55))
        );
        PanelFormularioLayout.setVerticalGroup(
            PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFormularioLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campo_id, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campo_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etqNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etqDescripcion)
                    .addComponent(campo_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campo_tiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etqTiempoCosecha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etqEstado)
                    .addComponent(campo_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
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
                
        String id = campo_id.getText();
        String nombre = campo_nombre.getText();
        String descripcion = campo_descripcion.getText();
        String estado = (String) campo_estado.getSelectedItem();
        String tiempocosecha = campo_tiempo.getText();
        
        if(!id.equals("") && !nombre.equals("") && !descripcion.equals("") && !estado.equals("") && !tiempocosecha.equals("")){
            
            Map<String, String> insertData = new HashMap<>();
            insertData.put("id", campo_id.getText());
            insertData.put("nombre", campo_nombre.getText());
            insertData.put("descripcion", campo_descripcion.getText());
            insertData.put("tiempocosecha", campo_tiempo.getText());
            insertData.put("estado", estado);
            
            Map<String, String> insertCultivoFinca = new HashMap<>();
            insertCultivoFinca.put("id_cultivo", campo_id.getText());
            insertCultivoFinca.put("id_finca", this.id_finca);

            String respuesta = ejemplo.consumoPOST("http://localhost/ApiPhp-AgroGestor/cultivos/AgregarCultivo.php", insertData);
            String newrespuesta = ejemplo.consumoPOST("http://localhost/ApiPhp-AgroGestor/cultivos/AgregarCultivoEnFinca.php", insertCultivoFinca);
            
            System.out.println(respuesta);
            System.out.println(newrespuesta);
            
            JsonObject jsonObject = gson.fromJson(respuesta, JsonObject.class);
            String status = jsonObject.get("status").getAsString();  
            JsonObject newjsonObject = gson.fromJson(newrespuesta, JsonObject.class);
            String newstatus = newjsonObject.get("status").getAsString();  


            if (status.equals("true") && newstatus.equals("true")){
                Alert alerta = new Alert("Registro Exitoso!", "El cultivo se agrego correctamente en tu finca", "success");  
                dispose();   
                this.ventanaDashboard.cargarDatos();
                dispose();
            }else if(status.equals("false") && newstatus.equals("false")){
                Alert alerta = new Alert("Registro Incorrecto!", "el cultivo NO se registro", "warning");   
            }
        }else{
            Alert alerta = new Alert("Error en datos!", "hay campos vacios", "error");
        }
        
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    public void initAlternComponents(){
        setLocationRelativeTo(null);
        setIconImage( getToolkit().createImage( ClassLoader.getSystemResource("img/LogoLOGIN.png"))) ;
                
        campo_id.addKeyListener(new KeyListener() {
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
    private javax.swing.JLabel Img;
    private javax.swing.JPanel PanelFormulario;
    private javax.swing.JPanel PanelHeader;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JTextField campo_descripcion;
    private javax.swing.JComboBox<String> campo_estado;
    private javax.swing.JTextField campo_id;
    private javax.swing.JTextField campo_nombre;
    private javax.swing.JTextField campo_tiempo;
    private javax.swing.JLabel etqCultivos;
    private javax.swing.JLabel etqDescripcion;
    private javax.swing.JLabel etqEstado;
    private javax.swing.JLabel etqNombre;
    private javax.swing.JLabel etqRegistrar;
    private javax.swing.JLabel etqTiempoCosecha;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
