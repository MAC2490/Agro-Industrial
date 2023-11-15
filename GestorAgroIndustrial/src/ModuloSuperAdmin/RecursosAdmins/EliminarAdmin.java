
package ModuloSuperAdmin.RecursosAdmins;

import clases.Persona;
import ModuloSuperAdmin.PanelUsuarios;
import Principal.Alert;
import Principal.ConsumoAPI;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Map;

public class EliminarAdmin extends javax.swing.JFrame {

    PanelUsuarios ventanaDashboard;
    ConsumoAPI ejemplo = new ConsumoAPI();
    Gson gson = new Gson();
    Persona DatosPersona;
    
    public EliminarAdmin(PanelUsuarios ventanaDashboard, Persona temp) {
        this.ventanaDashboard = ventanaDashboard;
        this.DatosPersona = temp;
        
        initComponents();
        initAlternComponents();
    }
    
    public void initAlternComponents(){
        setLocationRelativeTo(null);
        setIconImage( getToolkit().createImage( ClassLoader.getSystemResource("img/LogoLOGIN.png") ) );
        etqInfoEliminar1.setText("¿Desea eliminar al usuario "+DatosPersona.getNombre()+" "+DatosPersona.getApellido());
        etqInfoEliminar2.setText("identificado con cedula "+DatosPersona.getCedula()+"?");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelHeader = new javax.swing.JPanel();
        etqEliminar = new javax.swing.JLabel();
        etqAdmin = new javax.swing.JLabel();
        LogoGestor = new javax.swing.JLabel();
        PanelInfo = new javax.swing.JPanel();
        etqInfoEliminar1 = new javax.swing.JLabel();
        etqInfoEliminar2 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Eliminar Usuario - Gestor AgroIndustrial");
        setResizable(false);

        PanelHeader.setBackground(new java.awt.Color(0, 0, 0));

        etqEliminar.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        etqEliminar.setForeground(new java.awt.Color(255, 255, 255));
        etqEliminar.setText("ELIMINAR");

        etqAdmin.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        etqAdmin.setForeground(new java.awt.Color(255, 255, 255));
        etqAdmin.setText("ADMINISTRADOR");

        LogoGestor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LogoDashboard.png"))); // NOI18N

        javax.swing.GroupLayout PanelHeaderLayout = new javax.swing.GroupLayout(PanelHeader);
        PanelHeader.setLayout(PanelHeaderLayout);
        PanelHeaderLayout.setHorizontalGroup(
            PanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHeaderLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(PanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etqAdmin)
                    .addComponent(etqEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LogoGestor)
                .addGap(22, 22, 22))
        );
        PanelHeaderLayout.setVerticalGroup(
            PanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHeaderLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(etqEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etqAdmin)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LogoGestor, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );

        PanelInfo.setBackground(new java.awt.Color(255, 255, 255));

        etqInfoEliminar1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        etqInfoEliminar1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etqInfoEliminar1.setText("¿Desea eliminar al usuario");

        etqInfoEliminar2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        etqInfoEliminar2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etqInfoEliminar2.setText("identificado con cedula");

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

        btnEliminar.setBackground(new java.awt.Color(153, 255, 51));
        btnEliminar.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        btnEliminar.setFocusable(false);
        btnEliminar.setPreferredSize(new java.awt.Dimension(155, 35));
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
                .addGap(65, 65, 65)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
            .addGroup(PanelInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etqInfoEliminar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(etqInfoEliminar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        PanelInfoLayout.setVerticalGroup(
            PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInfoLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(etqInfoEliminar1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etqInfoEliminar2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
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

        if (DatosPersona.getCedula() != null){
            
            Map<String, String> deleteData = new HashMap<>();
            deleteData.put("cedula", DatosPersona.getCedula());
            System.out.println("Consumo DELETE: " + ejemplo.consumoPOST("http://localhost/ApiPhp-AgroGestor/usuarios/Delete.php", deleteData));
            
            String respuesta = ejemplo.consumoPOST("http://localhost/ApiPhp-AgroGestor/usuarios/Delete.php", deleteData);
            JsonObject jsonObject = gson.fromJson(respuesta, JsonObject.class);
            String status = jsonObject.get("status").getAsString();  
            
            if (status.equals("true")){
                Alert alerta = new Alert("Borrado Exitoso!", "El usuario se elimino correctamente", "success");    
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
    private javax.swing.JLabel etqAdmin;
    private javax.swing.JLabel etqEliminar;
    private javax.swing.JLabel etqInfoEliminar1;
    private javax.swing.JLabel etqInfoEliminar2;
    // End of variables declaration//GEN-END:variables
}
