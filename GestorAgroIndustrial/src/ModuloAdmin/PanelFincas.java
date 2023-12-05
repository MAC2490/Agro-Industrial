package ModuloAdmin;

import Principal.ConsumoAPI;
import Principal.Alert;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Map;

public class PanelFincas extends javax.swing.JPanel {

    String SesionUsuario;
    ConsumoAPI ejemplo = new ConsumoAPI();
    Gson gson = new Gson();

    public PanelFincas(String SesionUsuario) {
        this.SesionUsuario = SesionUsuario;
        initComponents();
        miFinca();
    }

    public void miFinca() {
        JsonObject jsonUsuario = gson.fromJson(SesionUsuario, JsonObject.class);

        String id_usuario = jsonUsuario.get("id_usuario").getAsString();

        Map<String, String> getData = new HashMap<>();
        getData.put("id_usuario", id_usuario);
        String ConsultaIndividual = ejemplo.consumoGET("http://localhost/ApiPhp-AgroGestor/Fincas/GetMyFinca.php", getData);
        System.out.println(id_usuario);
        System.out.println(ConsultaIndividual);

        if (!ConsultaIndividual.equals("[]")) {
            JsonObject jsonFinca = gson.fromJson(ConsultaIndividual, JsonObject.class);

            JsonObject jsonObject = gson.fromJson(SesionUsuario, JsonObject.class);

            String nombreUsuario = jsonObject.get("nombre").getAsString();
            String apellidoUsuario = jsonObject.get("apellido").getAsString();

            String nombreFinca = jsonFinca.get("nombre").getAsString();
            String direccionFinca = jsonFinca.get("direccion").getAsString();

            etqNombreFinca.setText(nombreFinca);
            etqDireccionFinca.setText(direccionFinca);
            etqNombreUsuario.setText(nombreUsuario);
            etqApellidoUsuario.setText(apellidoUsuario);
        } else {
            etqNombreFinca.setText("");
            etqDireccionFinca.setText("");
            etqNombreUsuario.setText("");
            etqApellidoUsuario.setText("");
            Alert alerta = new Alert("No Tienes Finca Asignada", "Finca No Asignada", "error");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        etqNombreFinca = new javax.swing.JLabel();
        etqDireccionFinca = new javax.swing.JLabel();
        etqNombreUsuario = new javax.swing.JLabel();
        etqApellidoUsuario = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 0, 36)); // NOI18N
        jLabel1.setText("MI FINCA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(311, 311, 311)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(323, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        etqNombreFinca.setFont(new java.awt.Font("Tw Cen MT", 0, 36)); // NOI18N
        etqNombreFinca.setText("Nombre Finca");

        etqDireccionFinca.setFont(new java.awt.Font("Tw Cen MT", 0, 36)); // NOI18N
        etqDireccionFinca.setText("Direccion Finca");

        etqNombreUsuario.setFont(new java.awt.Font("Tw Cen MT", 0, 36)); // NOI18N
        etqNombreUsuario.setText("Nombre Usuario");

        etqApellidoUsuario.setFont(new java.awt.Font("Tw Cen MT", 0, 36)); // NOI18N
        etqApellidoUsuario.setText("Apellido Usuario");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etqApellidoUsuario)
                    .addComponent(etqDireccionFinca)
                    .addComponent(etqNombreFinca)
                    .addComponent(etqNombreUsuario))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(etqNombreFinca)
                .addGap(32, 32, 32)
                .addComponent(etqDireccionFinca)
                .addGap(27, 27, 27)
                .addComponent(etqNombreUsuario)
                .addGap(27, 27, 27)
                .addComponent(etqApellidoUsuario)
                .addGap(0, 79, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel etqApellidoUsuario;
    private javax.swing.JLabel etqDireccionFinca;
    private javax.swing.JLabel etqNombreFinca;
    private javax.swing.JLabel etqNombreUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
