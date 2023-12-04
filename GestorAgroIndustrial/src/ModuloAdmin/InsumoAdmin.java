package ModuloAdmin;

import Clases.insumos;
import Principal.AlertAlberth;
import Principal.ConsumoAPI;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.sound.midi.SysexMessage;
import javax.swing.JTextField;

public class InsumoAdmin extends javax.swing.JFrame {

    ConsumoAPI API = new ConsumoAPI();

    // Declarar un mapa para almacenar la relación entre nombres e IDs de insumos
    Map<Integer, String> idInsumoMap = new HashMap<>();
    // Declarar un mapa para almacenar la relación entre nombres e IDs
    Map<Integer, String> idNombreMap = new HashMap<>();

    Map<Integer, String> cantidadInsumo = new HashMap<>();

    // aqui recibimos el id de la finca
    PanelInsumos ventana;
    String finca;
    Gson gson = new Gson();

    public InsumoAdmin(String finca, PanelInsumos ventana) {
        this.ventana = ventana;
        this.finca = finca;
        initComponents();
        initAlternComponents();
    }

    public void initAlternComponents() {
        setLocationRelativeTo(null);
        llenandoSelects();

        // Ahora registramos los insumos x cultivos 
    }

    // Metodo para rellenar los insumos
    public void llenandoSelects() {

        String respuestaInsumos = API.consumoGET("http://localhost/ApiPhp-AgroGestor/insumos/ObtenerInsumos.php");

        //verificamos que las respuesta no venga nulla
        if (respuestaInsumos != null) {
            JsonObject objetoJson = JsonParser.parseString(respuestaInsumos).getAsJsonObject();
            JsonArray insumosArray = objetoJson.get("datos").getAsJsonArray();

            // Creamos el for para recorrer los datos que vienen 
            for (int i = 0; i < insumosArray.size(); i++) {
                JsonObject temp = insumosArray.get(i).getAsJsonObject();

                // Almacena la relación en el mapa
                int idInsumo = temp.get("insumos_id").getAsInt();
                String nombreInsumo = temp.get("name").getAsString();

                // Verificamos que el estado este activo  para mostrarlo 
                String estado_Insumo = temp.get("estado").getAsString();
                
                if (estado_Insumo.equals("ACTIVO")) {
                    int cantidadI = temp.get("cantidad").getAsInt();

                    cantidadInsumo.put(cantidadI, nombreInsumo);
                    idInsumoMap.put(idInsumo, nombreInsumo);

                    // Añade el nombre al JComboBox
                    insumo.addItem(nombreInsumo);
                }else{
                    System.out.println("El insumo"+nombreInsumo+"Esta  deshabilidato comuniquese con su superAdministrador");
                }
                // aqui obtenemos la cantidad del insumo seleccionado

            }
        }

        String respuestaCultivos = API.consumoGET("http://localhost/ApiPhp-AgroGestor/insumos/ObtenerCultivos.php");

        //verificamos que las respuesta no venga nulla
        if (respuestaCultivos != null) {
            JsonObject objetoJson = JsonParser.parseString(respuestaCultivos).getAsJsonObject();
            JsonArray insumosArray = objetoJson.get("datos").getAsJsonArray();

            // creamos el for para recorer los datos que vienen 
            for (int i = 0; i < insumosArray.size(); i++) {
                JsonObject temp = insumosArray.get(i).getAsJsonObject();
                cultivos.addItem(temp.get("nombre").getAsString());

                int idCultivo = temp.get("id_cultivo").getAsInt();
                String nombreCultivo = temp.get("nombre").getAsString();
                idNombreMap.put(idCultivo, nombreCultivo);
            }
        }
    }

    // Método para obtener el ID seleccionado a partir del nombre
    private int obtenerIdSeleccionado(String nombre) {
        for (Map.Entry<Integer, String> entry : idNombreMap.entrySet()) {
            if (entry.getValue().equals(nombre)) {
                return entry.getKey();
            }
        }
        return -1; // Valor predeterminado si no se encuentra el nombre
    }

    // metodo para obtener la cantidad del insumo para mirar si se puede gastar 
    private int obtenerCantidadInsumo(String nombre) {
        for (Map.Entry<Integer, String> entry : cantidadInsumo.entrySet()) {
            if (entry.getValue().equals(nombre)) {
                return entry.getKey();
            }

        }
        return -1;
    }
    // Método para obtener el ID de insumo seleccionado a partir del nombre

    private int obtenerIdInsumoSeleccionado(String nombre) {
        for (Map.Entry<Integer, String> entry : idInsumoMap.entrySet()) {
            if (entry.getValue().equals(nombre)) {
                return entry.getKey();
            }
        }
        return -1; // Valor predeterminado si no se encuentra el nombre
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        valor = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cantidad = new javax.swing.JTextField();
        registrar = new javax.swing.JButton();
        atras = new javax.swing.JButton();
        fecha = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        insumo = new javax.swing.JComboBox<>();
        cultivos = new javax.swing.JComboBox<>();
        medida = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setFocusable(false);

        jLabel3.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/llave.png"))); // NOI18N
        jLabel3.setText("INSUMO");

        jLabel4.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tipo.png"))); // NOI18N
        jLabel4.setText("VALOR");

        titulo.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        titulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/registro.png"))); // NOI18N
        titulo.setText("REGISTRO DE INSUMO");

        jLabel5.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/unidad.png"))); // NOI18N
        jLabel5.setText("UNIDAD MEDIDA");

        jLabel6.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/producto.png"))); // NOI18N
        jLabel6.setText("CANTIDAD");

        valor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        valor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                valorKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fecha.png"))); // NOI18N
        jLabel7.setText("FECHA COMPRA");

        cantidad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cantidadKeyTyped(evt);
            }
        });

        registrar.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mas.png"))); // NOI18N
        registrar.setText("REGISTRAR");
        registrar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        registrar.setFocusable(false);
        registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarActionPerformed(evt);
            }
        });

        atras.setBackground(new java.awt.Color(0, 153, 153));
        atras.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/atras.png"))); // NOI18N
        atras.setBorder(null);
        atras.setFocusable(false);
        atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasActionPerformed(evt);
            }
        });

        fecha.setDateFormatString("yyyy-MM-dd");

        jLabel2.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user.png"))); // NOI18N
        jLabel2.setText("CULTIVO");

        medida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "KILOS", "ARROBA", "GRAMOS", "LIBRAS" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(atras, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addComponent(titulo)
                        .addGap(34, 34, 34))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cantidad)
                            .addComponent(valor)
                            .addComponent(insumo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(registrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fecha, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                            .addComponent(cultivos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(medida, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(atras, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titulo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cultivos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insumo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(valor, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(medida))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidadKeyTyped
        // este metodo es para validar que solo se ingreses numeros

        char c = evt.getKeyChar();
        if (c < '0' || c > '9')
            evt.consume();
    }//GEN-LAST:event_cantidadKeyTyped

    private void registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarActionPerformed

        // aqui es para enviarle los datos a la tabla intemedia
        //datos del cultivo id
        String nombreCultivo = (String) cultivos.getSelectedItem();
        int idcultivo = obtenerIdSeleccionado(nombreCultivo);
        // datos del insumo id
        String nombreInsumo = (String) insumo.getSelectedItem();
        int idInsumo = obtenerIdInsumoSeleccionado(nombreInsumo);
        String valor = this.valor.getText();
        String fecha = ((JTextField) this.fecha.getDateEditor().getUiComponent()).getText();
        String medida = (String) this.medida.getSelectedItem();
        String cantidad = this.cantidad.getText();

        // verificamos que la cantidad no sea mayor a la que tienee insumos
        if (nombreCultivo != null && !nombreCultivo.isEmpty()
                && nombreInsumo != null && !nombreInsumo.isEmpty()
                && valor != null && !valor.isEmpty()
                && fecha != null && !fecha.isEmpty()
                && medida != null && !medida.isEmpty()
                && cantidad != null && !cantidad.isEmpty()) {

            int cantidadIngresada = Integer.parseInt(cantidad);
            int InsumoCantidad = obtenerCantidadInsumo(nombreInsumo);
            System.out.println("cantidad: " + InsumoCantidad);
            if (cantidadIngresada > InsumoCantidad) {
                // mensaje que no se puede ingresar
                AlertAlberth alerta = new AlertAlberth("Cantidad", "CANTIDAD NO DISPONIBLE", "error");
            } else {
                // AQUI MANDAMOS LOS DATOS A LA TABLA PARA HACER EL REGISTRO
                Map<String, String> getData = new HashMap<>();
                getData.put("cultivo", String.valueOf(idcultivo));
                getData.put("finca", finca);
                getData.put("insumo", String.valueOf(idInsumo));
                getData.put("valor", valor);
                getData.put("fecha", fecha);
                getData.put("unidad", medida);
                getData.put("cantidad", cantidad);
                // ahora enviamos eso datos a la base de datos

                Map<String, String> restCant = new HashMap<>();
                restCant.put("cantidad", String.valueOf(cantidad));
                restCant.put("insumo", String.valueOf(idInsumo));

                String insertInsumo = API.consumoPOST("http://localhost/ApiPhp-AgroGestor/insumos/InsertInsumosCultivos.php", getData);
                // creamos otra solicitus para llenar en la tabla insumo por finca 

                String restaInsumo = API.consumoPOST("http://localhost/ApiPhp-AgroGestor/insumos/RestarCantidadInsumo.php", restCant);

                JsonObject repRestarInsumo = gson.fromJson(restaInsumo, JsonObject.class);
                // Analizar la respuesta JSON
                JsonObject respuestaJson = gson.fromJson(insertInsumo, JsonObject.class);

                // Verificar el estado de la inserción
                if (respuestaJson.has("status") && repRestarInsumo.has("status")) {
                    boolean exitoso = respuestaJson.get("status").getAsBoolean();
                    boolean eliminacion = repRestarInsumo.get("status").getAsBoolean();

                    if (exitoso && eliminacion) {
                        System.out.println("Inserción en insumos_x_cultivos exitosa.");
                        System.out.println("Mensaje del servidor: " + respuestaJson.get("mesagge").getAsString());
                        System.err.println("Mensaje de restar Insumo" + repRestarInsumo.get("mesagge").getAsString());
                        this.ventana.initAlternComponents();
                        this.ventana.setVisible(true);
                        dispose();
                        AlertAlberth alerta = new AlertAlberth("Insertado con exito", "Insumo registrado con exito", "success");
                    } else {
                        System.out.println("La inserción en insumo_x_cultivos  no fue exitosa. Mensaje del servidor: " + respuestaJson.get("mesagge").getAsString());
                        System.out.println("la resta del insumo no exitosa: " + repRestarInsumo.get("mesagge").getAsString());
                    }
                } else {
                    System.out.println("La respuesta no tiene la clave 'status'.");
                }

                /*
            Map<String, String> insumoFinca = new HashMap<>();
            insumoFinca.put("id_finca", this.finca);
            insumoFinca.put("id_insumo", String.valueOf(idInsumo));
            
            System.out.println("ID INSUMO"+String.valueOf(idInsumo));
            // Enviar datos al servidor y obtener la respuesta
            String insertInsumoFinca = API.consumoPOST("http://localhost/ApiPhp-AgroGestor/insumos/InsertInsumoFinca.php", insumoFinca);
            // Analizar la respuesta JSON
            JsonObject respuestaJsonI = gson.fromJson(insertInsumoFinca, JsonObject.class);

            // Verificar el estado de la inserción
            if (respuestaJsonI.has("status")) {
                boolean exitoso = respuestaJson.get("status").getAsBoolean();

                if (exitoso) {
                    System.out.println("Inserción en insumo_x_finca exitosa.");
                    System.out.println("Mensaje del servidor: " + respuestaJsonI.get("mesagge").getAsString());

                    // Continuar con el resto de tu código aquí...
                } else {
                    System.out.println("La inserción en insumo_x_finca no fue exitosa. Mensaje del servidor: " + respuestaJsonI.get("mesagge").getAsString());
                }
            } else {
                System.out.println("La respuesta no tiene la clave 'status'.");
            }
                 */
            }
        } else {
            // Manejar el caso donde al menos una variable está vacía
            System.out.println("Al menos una variable está vacía.");
        }


    }//GEN-LAST:event_registrarActionPerformed

    private void valorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valorKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9')
            evt.consume();
    }//GEN-LAST:event_valorKeyTyped

    private void atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasActionPerformed
        // aqui la mandamos atras
        dispose();
        ventana.initAlternComponents();
        ventana.setVisible(true);
    }//GEN-LAST:event_atrasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atras;
    private javax.swing.JTextField cantidad;
    private javax.swing.JComboBox<String> cultivos;
    private com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JComboBox<Object> insumo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> medida;
    private javax.swing.JButton registrar;
    private javax.swing.JLabel titulo;
    private javax.swing.JTextField valor;
    // End of variables declaration//GEN-END:variables
}
