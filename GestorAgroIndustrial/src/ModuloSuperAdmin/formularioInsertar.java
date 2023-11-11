package ModuloSuperAdmin;

import Principal.ConsumoAPI;
import java.util.HashMap;
import java.util.Map;

public class formularioInsertar extends javax.swing.JPanel {

    private ConsumoAPI consumoAPI;
    boolean modoEdicion = false;
    String id = "";
    
    public formularioInsertar() {
        consumoAPI = new ConsumoAPI();
        initComponents();
    }
    
    // Getter para el campo nombre
    public String getNombre() {
        return nombreJ.getText();
    }

    // Getter para el campo descripcion
    public String getDescripcion() {
        return descripcionJ.getText();
    }

    // Getter para el campo tiempo de cosecha
    public String getTiempoCosecha() {
        return tiempoCosechaJ.getText();
    }

    // Getter para el campo estado
    public String getEstado() {
        return estadoJ.getText();
    }

    public void setDatos (String id ,String nombre, String descripcion, String tiempoCosecha, String estado) {
        // Establece los valores en los campos del formulario de edición
        this.id = id;
        nombreJ.setText(nombre);
        descripcionJ.setText(descripcion);
        tiempoCosechaJ.setText(tiempoCosecha);
        estadoJ.setText(estado);
        this.modoEdicion = true;
    }
    
    public void editarCultivo(String nombreCultivo, String descripcionCultivo, String tiempoCosecha, String estado) {
        String urlEditarCultivo = "http://localhost/ApiPhp-AgroGestor/cultivos/Update.php";   
    
        Map<String, String> postData = new HashMap<>();
        postData.put("nombreCultivo", nombreCultivo);
        postData.put("descripcionCultivo", descripcionCultivo);
        postData.put("tiempoCosecha", tiempoCosecha);
        postData.put("estado", estado);
        postData.put("id_cultivo", this.id);

        String respuesta = consumoAPI.consumoPOST(urlEditarCultivo, postData);

        if (respuesta != null) {
            if (respuesta.contains("OK")) {
                System.out.println("La edición se ha realizado exitosamente");
            } else {
                System.out.println("La edición ha fallado");
                System.out.println(respuesta); 
            }
        } else {
            System.out.println("Error al conectarse a la API de edición");  
        }
    }
    
    public void registro(String nombre, String descripcion, String tiempoCosecha, String estado) {
        // Crear un mapa con los datos a enviar a la API
        Map<String, String> postData = new HashMap<>();
        postData.put("nombre", nombre);
        postData.put("descripcion", descripcion);
        postData.put("tiempoCosecha", tiempoCosecha);
        postData.put("estado", estado);

        // URL de la API para el registro de cultivos (reemplaza con tu URL real)
        String apiUrl = "http://localhost/ApiPhp-AgroGestor-copia/cultivos/Insert.php";

        // Realizar la solicitud POST a la API
        ConsumoAPI api = new ConsumoAPI();
        String respuestaAPI = api.consumoPOST(apiUrl, postData);
        System.out.println(respuestaAPI);

        // Procesar la respuesta de la API aquí y mostrar un mensaje al usuario si es necesario
        // Puedes verificar si la inserción fue exitosa revisando el contenido de respuestaAPI
        if (respuestaAPI.contains("OK")) {
            // La inserción fue exitosa
            System.out.print("indertado exitosamente");
            // Muestra un mensaje al usuario o realiza alguna acción adicional
        } else {
            System.out.print("la insersion ha fallado");
            // Hubo un error en la inserción
            // Muestra un mensaje de error al usuario o maneja la situación de error
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nombreJ = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        descripcionJ = new javax.swing.JTextField();
        tiempoCosechaJ = new javax.swing.JTextField();
        estadoJ = new javax.swing.JTextField();
        enviar = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 204, 0));

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registro Cultivos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        nombreJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreJActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Descripcion");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tiempo Cosecha");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Estado");

        descripcionJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descripcionJActionPerformed(evt);
            }
        });

        tiempoCosechaJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tiempoCosechaJActionPerformed(evt);
            }
        });

        estadoJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estadoJActionPerformed(evt);
            }
        });

        enviar.setBackground(new java.awt.Color(255, 51, 102));
        enviar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        enviar.setForeground(new java.awt.Color(255, 255, 255));
        enviar.setText("ENVIAR");
        enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombreJ, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descripcionJ, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tiempoCosechaJ, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(estadoJ, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
            .addGroup(layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(enviar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nombreJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(descripcionJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tiempoCosechaJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(estadoJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(enviar)
                .addGap(21, 21, 21))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nombreJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreJActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreJActionPerformed

    private void descripcionJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descripcionJActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descripcionJActionPerformed

    private void tiempoCosechaJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tiempoCosechaJActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tiempoCosechaJActionPerformed

    private void estadoJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estadoJActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_estadoJActionPerformed

    private void enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarActionPerformed
        String nombreCultivo = nombreJ.getText();
        String descripcionCultivo = descripcionJ.getText();
        String tiempoCosecha= tiempoCosechaJ.getText();
        String estado = estadoJ.getText();

        if (modoEdicion) {
            editarCultivo(nombreCultivo, descripcionCultivo, tiempoCosecha, estado);
            System.out.print("edicion activada");
        } else {
            registro(nombreCultivo, descripcionCultivo, tiempoCosecha, estado);
            System.out.print("edicion no activada");
        }
    }//GEN-LAST:event_enviarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField descripcionJ;
    private javax.swing.JButton enviar;
    private javax.swing.JTextField estadoJ;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nombreJ;
    private javax.swing.JTextField tiempoCosechaJ;
    // End of variables declaration//GEN-END:variables

}
