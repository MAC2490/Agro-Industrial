
package ModuloAdmin.RecursosDelAdmin;
        
import Clases.Cultivos;
import ModuloAdmin.PanelCultivosAdmin;
import Principal.Alert;
import Principal.ConsumoAPI;
import com.google.gson.JsonObject;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

public class EditarCultivo extends javax.swing.JFrame {

    PanelCultivosAdmin ventanaDashboard;
    ConsumoAPI ejemplo = new ConsumoAPI();
    Gson gson = new Gson();
    Cultivos DatosCultivo;
    
    public EditarCultivo(PanelCultivosAdmin ventanaDashboard, Cultivos temp) {
        this.ventanaDashboard = ventanaDashboard;
        this.DatosCultivo = temp;
        
        initComponents();
        initAlternComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelHeader = new javax.swing.JPanel();
        etqEditar = new javax.swing.JLabel();
        etqCultivo = new javax.swing.JLabel();
        LogoGestor = new javax.swing.JLabel();
        PanelFormulario = new javax.swing.JPanel();
        etqID = new javax.swing.JLabel();
        etqNombre = new javax.swing.JLabel();
        campo_nombre = new javax.swing.JTextField();
        etqDescripcion = new javax.swing.JLabel();
        campo_descripcion = new javax.swing.JTextField();
        etqTiempoCosecha = new javax.swing.JLabel();
        campo_tiempo = new javax.swing.JTextField();
        etqEstado = new javax.swing.JLabel();
        campo_estado = new javax.swing.JComboBox<>();
        btnCancelar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Modificar Cultivo - Gestor AgroIndustrial");
        setResizable(false);

        PanelHeader.setBackground(new java.awt.Color(0, 0, 0));

        etqEditar.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        etqEditar.setForeground(new java.awt.Color(255, 255, 255));
        etqEditar.setText("EDITAR");

        etqCultivo.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        etqCultivo.setForeground(new java.awt.Color(255, 255, 255));
        etqCultivo.setText("CULTIVO");

        LogoGestor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LogoDashboard.png"))); // NOI18N

        javax.swing.GroupLayout PanelHeaderLayout = new javax.swing.GroupLayout(PanelHeader);
        PanelHeader.setLayout(PanelHeaderLayout);
        PanelHeaderLayout.setHorizontalGroup(
            PanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHeaderLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(PanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etqCultivo)
                    .addComponent(etqEditar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LogoGestor, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        PanelHeaderLayout.setVerticalGroup(
            PanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHeaderLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(etqEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etqCultivo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LogoGestor, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );

        PanelFormulario.setBackground(new java.awt.Color(255, 255, 255));

        etqID.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        etqID.setText("ID CULTIVO");

        etqNombre.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        etqNombre.setText("NOMBRE");

        campo_nombre.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N

        etqDescripcion.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        etqDescripcion.setText("DESCRIPCION");

        campo_descripcion.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N

        etqTiempoCosecha.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        etqTiempoCosecha.setText("TIEMPO COSECHA");
        etqTiempoCosecha.setToolTipText("");

        campo_tiempo.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N

        etqEstado.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        etqEstado.setText("ESTADO");

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

        btnModificar.setBackground(new java.awt.Color(0, 0, 153));
        btnModificar.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setText("MODIFICAR");
        btnModificar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
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
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PanelFormularioLayout.createSequentialGroup()
                        .addComponent(etqID)
                        .addGap(289, 289, 289))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelFormularioLayout.createSequentialGroup()
                        .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PanelFormularioLayout.createSequentialGroup()
                                .addComponent(etqNombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(campo_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelFormularioLayout.createSequentialGroup()
                                .addComponent(etqDescripcion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                                .addComponent(campo_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelFormularioLayout.createSequentialGroup()
                                .addComponent(etqTiempoCosecha)
                                .addGap(18, 18, 18)
                                .addComponent(campo_tiempo))
                            .addGroup(PanelFormularioLayout.createSequentialGroup()
                                .addComponent(etqEstado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(campo_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(47, 47, 47))))
            .addGroup(PanelFormularioLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelFormularioLayout.setVerticalGroup(
            PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFormularioLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(etqID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campo_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etqNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campo_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etqDescripcion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campo_tiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etqTiempoCosecha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campo_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etqEstado))
                .addGap(54, 54, 54)
                .addGroup(PanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
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

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        
        String id = DatosCultivo.getId_cultivo();
        String nombre = campo_nombre.getText();
        String descripcion = campo_descripcion.getText();
        String estado = (String) campo_estado.getSelectedItem();
        String tiempocosecha = campo_tiempo.getText();
        
        if(!nombre.equals("") && !descripcion.equals("") && !estado.equals("") && !tiempocosecha.equals("")){
            
            Map<String, String> updateData = new HashMap<>();
            updateData.put("id_cultivo", DatosCultivo.getId_cultivo());
            updateData.put("nombreCultivo", campo_nombre.getText());
            updateData.put("descripcionCultivo", campo_descripcion.getText());
            updateData.put("tiempoCosecha", campo_tiempo.getText());
            updateData.put("estado", estado);
            
            String respuesta = ejemplo.consumoPOST("http://localhost/ApiPhp-AgroGestor/cultivos/Update.php", updateData);
            System.out.println(respuesta);
            
            JsonObject jsonObject = gson.fromJson(respuesta, JsonObject.class);
            String status = jsonObject.get("status").getAsString();  
            

            if (status.equals("true")){
                Alert alerta = new Alert("Modificacion Exitosa!", "El cultivo se modifico correctamente", "success");  
                
                this.ventanaDashboard.cargarDatos();
                dispose();
            }else if(status.equals("false")){
                Alert alerta = new Alert("Modificacion Incorrecta!", "El cultivo no se modifico", "warning");   
            }
        }else{
            Alert alerta = new Alert("Error", "Faltan campos por llenar", "error");
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    public void initAlternComponents(){
        setLocationRelativeTo(null);
        setIconImage( getToolkit().createImage( ClassLoader.getSystemResource("img/LogoLOGIN.png") ) ); 
        
        etqID.setText("ID CULTIVO - "+DatosCultivo.getId_cultivo());
        campo_nombre.setText(DatosCultivo.getNombre());
        campo_descripcion.setText(DatosCultivo.getDescripcion());
        campo_estado.setSelectedItem(DatosCultivo.getEstado());
        campo_tiempo.setText(DatosCultivo.getTiempo_cosecha());
    }
    
    
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
       dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LogoGestor;
    private javax.swing.JPanel PanelFormulario;
    private javax.swing.JPanel PanelHeader;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JTextField campo_descripcion;
    private javax.swing.JComboBox<String> campo_estado;
    private javax.swing.JTextField campo_nombre;
    private javax.swing.JTextField campo_tiempo;
    private javax.swing.JLabel etqCultivo;
    private javax.swing.JLabel etqDescripcion;
    private javax.swing.JLabel etqEditar;
    private javax.swing.JLabel etqEstado;
    private javax.swing.JLabel etqID;
    private javax.swing.JLabel etqNombre;
    private javax.swing.JLabel etqTiempoCosecha;
    // End of variables declaration//GEN-END:variables
}
