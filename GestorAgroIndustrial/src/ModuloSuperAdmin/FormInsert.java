package ModuloSuperAdmin;

import Principal.AlertGarcia;
import Principal.ConsumoAPI;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FormInsert extends javax.swing.JFrame {

    private ConsumoAPI consumoAPI;
    boolean modoEdicion = false;
    String id = "";
    int i = 0;

    public FormInsert() {
        initComponents();
        consumoAPI = new ConsumoAPI();
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
        return (String) estadoJ.getSelectedItem();
    }

    public void setDatos(String id, String nombre, String descripcion, String tiempoCosecha, String estado) {
        // Establece los valores en los campos del formulario de edición
        if (id != "") {
            this.id = id;
            nombreJ.setText(nombre);
            descripcionJ.setText(descripcion);
            tiempoCosechaJ.setText(tiempoCosecha);
            estadoJ.setSelectedItem(estado);
            this.titulo.setText("EDITAR");
            this.modoEdicion = true;
        } else {
            nombreJ.setText("");
            descripcionJ.setText("");
            tiempoCosechaJ.setText("");
            estadoJ.setSelectedItem("");
            this.titulo.setText("REGISTRAR");
        }
        i++;
        System.out.println("prueba " + this.i);
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
                AlertGarcia alerta = new AlertGarcia("Datos Editados", "Datos Editados Correctamente", "success");
                System.out.println("La edición se ha realizado exitosamente");
                dispose();
            } else {
                System.out.println("La edición ha fallado");
                AlertGarcia alerta = new AlertGarcia("Error DE Edicion", "Datos No Editados", "error");
                System.out.println(respuesta);
            }
        } else {
            System.out.println("Error al conectarse a la API de edición");
        }
    }

    public void registro(String nombre, String descripcion, String tiempoCosecha, String estado) {
        //mapa con los datos a enviar a la API
        Map<String, String> postData = new HashMap<>();
        postData.put("nombre", nombre);
        postData.put("descripcion", descripcion);
        postData.put("tiempoCosecha", tiempoCosecha);
        postData.put("estado", estado);
        
        // URL de la API
        String apiUrl = "http://localhost/ApiPhp-AgroGestor/cultivos/Insert.php";

        // solicitud POST a la API
        ConsumoAPI api = new ConsumoAPI();
        String respuestaAPI = api.consumoPOST(apiUrl, postData);
        System.out.println(respuestaAPI);

        System.out.println("Respuesta de la API: " + respuestaAPI);
        if (respuestaAPI.contains("OK")) {
            AlertGarcia alerta = new AlertGarcia("Datos Insertados", "Datos Insertados Correctamente", "success");
            System.out.print("insertado exitosamente");
            dispose();
        } else {
            AlertGarcia alerta = new AlertGarcia("Datos NO Insertados", "Insercion Fallida", "error");
            System.out.print("la insersion ha fallado");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        etqCultivos = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nombreJ = new javax.swing.JTextField();
        descripcionJ = new javax.swing.JTextField();
        tiempoCosechaJ = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        estadoJ = new javax.swing.JComboBox<>();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Formulario Cultivo - Gestor AgroIndustrial");
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        titulo.setBackground(new java.awt.Color(255, 255, 255));
        titulo.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));

        etqCultivos.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        etqCultivos.setForeground(new java.awt.Color(255, 255, 255));
        etqCultivos.setText("CULTIVOS");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LogoDashboard.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etqCultivos)
                    .addComponent(titulo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(16, 16, 16))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(titulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(etqCultivos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(14, 14, 14))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        jLabel2.setText("NOMBRE");

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        jLabel3.setText("DESCRIPCION");

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        jLabel4.setText("TIEMPO COSECHA");

        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        jLabel5.setText("ESTADO");

        nombreJ.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N

        descripcionJ.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N

        tiempoCosechaJ.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N

        jButton1.setBackground(new java.awt.Color(153, 255, 51));
        jButton1.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setText("REGISTRAR");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        estadoJ.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        estadoJ.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DISPONIBLE", "NO DISPONIBLE" }));

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2))
                    .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tiempoCosechaJ, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(estadoJ, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(descripcionJ, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombreJ, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreJ, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(descripcionJ, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tiempoCosechaJ, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(estadoJ, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String nombreCultivo = nombreJ.getText();
        String descripcionCultivo = descripcionJ.getText();
        String tiempoCosecha = tiempoCosechaJ.getText();
        String estado = (String) estadoJ.getSelectedItem();

        if (!nombreCultivo.equals("") && !descripcionCultivo.equals("") && !tiempoCosecha.equals("") && !estado.equals("")) {
            // Todos los campos están llenos, puedes realizar la acción deseada

            if (modoEdicion) {
                editarCultivo(nombreCultivo, descripcionCultivo, tiempoCosecha, estado);
                System.out.println("Edición activada");
            } else {
                registro(nombreCultivo, descripcionCultivo, tiempoCosecha, estado);
                System.out.println("Edición no activada");
            }
        } else {
            // Al menos un campo está vacío, muestra un mensaje de error o realiza alguna acción
            AlertGarcia alerta = new AlertGarcia("Campos Vacios", "Campos Vacios", "warning");
            System.out.println("No se pueden dejar campos vacíos");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JTextField descripcionJ;
    private javax.swing.JComboBox<String> estadoJ;
    private javax.swing.JLabel etqCultivos;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField nombreJ;
    private javax.swing.JTextField tiempoCosechaJ;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
