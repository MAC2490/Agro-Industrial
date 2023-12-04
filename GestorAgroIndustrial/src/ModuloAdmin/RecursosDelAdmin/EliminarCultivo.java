
package ModuloAdmin.RecursosDelAdmin;

import Clases.Cultivos;
import ModuloAdmin.PanelCultivosAdmin;
import Principal.Alert;
import Principal.ConsumoAPI;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Map;


public class EliminarCultivo extends javax.swing.JFrame {

    PanelCultivosAdmin ventanaDashboard;
    ConsumoAPI ejemplo = new ConsumoAPI();
    Gson gson = new Gson();
    Cultivos DatosCultivo;
    
    public EliminarCultivo(PanelCultivosAdmin ventanaDashboard, Cultivos temp) {       
        this.ventanaDashboard = ventanaDashboard;
        this.DatosCultivo = temp;
 
        initComponents();
        initAlternComponents();
    }

    public void initAlternComponents(){
        setLocationRelativeTo(null);
        setIconImage( getToolkit().createImage( ClassLoader.getSystemResource("img/LogoLOGIN.png") ) );
        etqInfoEliminar1.setText("¿Desea eliminar al cultivo "+DatosCultivo.getNombre());
        etqInfoEliminar2.setText("de la finca "+DatosCultivo.getId_finca()+"?");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelHeader = new javax.swing.JPanel();
        etqEliminar = new javax.swing.JLabel();
        etqCultivo = new javax.swing.JLabel();
        LogoGestor = new javax.swing.JLabel();
        PanelInfo = new javax.swing.JPanel();
        etqInfoEliminar1 = new javax.swing.JLabel();
        etqInfoEliminar2 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Eliminar Cultivo - Gestor AgroIndustrial");
        setResizable(false);

        PanelHeader.setBackground(new java.awt.Color(0, 0, 0));

        etqEliminar.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        etqEliminar.setForeground(new java.awt.Color(255, 255, 255));
        etqEliminar.setText("ELIMINAR");

        etqCultivo.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        etqCultivo.setForeground(new java.awt.Color(255, 255, 255));
        etqCultivo.setText("CULTIVO");

        LogoGestor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LogoDashboard.png"))); // NOI18N

        javax.swing.GroupLayout PanelHeaderLayout = new javax.swing.GroupLayout(PanelHeader);
        PanelHeader.setLayout(PanelHeaderLayout);
        PanelHeaderLayout.setHorizontalGroup(
            PanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHeaderLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(PanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etqCultivo)
                    .addComponent(etqEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LogoGestor)
                .addGap(21, 21, 21))
        );
        PanelHeaderLayout.setVerticalGroup(
            PanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHeaderLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(etqEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etqCultivo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LogoGestor, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );

        PanelInfo.setBackground(new java.awt.Color(255, 255, 255));

        etqInfoEliminar1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        etqInfoEliminar1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etqInfoEliminar1.setText("¿Desea eliminar el cultivo");

        etqInfoEliminar2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        etqInfoEliminar2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etqInfoEliminar2.setText("de la finca");

        btnCancelar.setBackground(new java.awt.Color(204, 204, 204));
        btnCancelar.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(0, 0, 153));
        btnEliminar.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelInfoLayout = new javax.swing.GroupLayout(PanelInfo);
        PanelInfo.setLayout(PanelInfoLayout);
        PanelInfoLayout.setHorizontalGroup(
            PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etqInfoEliminar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(etqInfoEliminar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(PanelInfoLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );
        PanelInfoLayout.setVerticalGroup(
            PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInfoLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(etqInfoEliminar1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etqInfoEliminar2)
                .addGap(47, 47, 47)
                .addGroup(PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (DatosCultivo.getId_cultivo() != null){
            
            Map<String, String> deleteData = new HashMap<>();
            deleteData.put("id_cultivo", DatosCultivo.getId_cultivo());
            
            String respuesta = ejemplo.consumoPOST("http://localhost/ApiPhp-AgroGestor/cultivos/DeleteCultivoEnFinca.php", deleteData);
            System.out.println(respuesta);
            
            JsonObject jsonObject = gson.fromJson(respuesta, JsonObject.class);
            String status = jsonObject.get("status").getAsString();  
            
            if (status.equals("true")){
                Alert alerta = new Alert("Borrado Exitoso!", "El usuario se elimino correctamente", "success");
                this.ventanaDashboard.cargarDatos();
                dispose();
            }else if(status.equals("false")){
                Alert alerta = new Alert("Borrado Erroneo!", "El usuario NO se elimino correctamente", "error");    
            }
        }
        
        
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LogoGestor;
    private javax.swing.JPanel PanelHeader;
    private javax.swing.JPanel PanelInfo;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel etqCultivo;
    private javax.swing.JLabel etqEliminar;
    private javax.swing.JLabel etqInfoEliminar1;
    private javax.swing.JLabel etqInfoEliminar2;
    // End of variables declaration//GEN-END:variables
}
