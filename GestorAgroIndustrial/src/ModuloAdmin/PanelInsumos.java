package ModuloAdmin;

import Principal.ConsumoAPI;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

public class PanelInsumos extends javax.swing.JPanel {

    DefaultTableModel tabla;
    ConsumoAPI API = new ConsumoAPI();
    String usuario;
    Gson gson = new Gson();
    String id_finca;
    public PanelInsumos(String usuario) {
        this.usuario = usuario;
        initComponents();
        initAlternComponents();
    }

    public void initAlternComponents() {
        this.tabla = (DefaultTableModel) this.tabla_insumos.getModel();

        // quitamos las tabla que tiene a cero
        this.tabla.setNumRows(0);
        // ahora hacemos consumo de la api para mostrar dicha informacion
        JsonObject jsonObject = gson.fromJson(usuario, JsonObject.class);
        String id_usuario = jsonObject.get("id_usuario").getAsString();
        System.out.println("ID USUARIO" + id_usuario);
        Map<String, String> user = new HashMap<>();
        user.put("id", id_usuario);

        // este primero es para obtener el id de la finca y ya poder traer los demas datos relacionados con esa finca y ese usuario
        String datosPersona = API.consumoGET("http://localhost/ApiPhp-AgroGestor/insumos/FincaUsuario.php", user);
        // aqui obtenemos los datos de la finca 
        JsonObject jsonDatos = gson.fromJson(datosPersona, JsonObject.class);

        String finca;
        // Trabaja con el array de datos
        
        finca = jsonDatos.get("id_finca").getAsString();
        id_finca=finca;
        // Resto del código
        Map<String, String> getData = new HashMap<>();
        getData.put("id", finca);

        // aqui ya tenemos los  datos de la finca del usuario a la cual esta afiliado 
        String datosInsumos = API.consumoGET("http://localhost/ApiPhp-AgroGestor/insumos/InsumosFinca.php", getData);
        // verificamos que la respuesta no venga vacia 
        if (datosInsumos != null) {
            // convertimos a un json manipulable
            JsonObject datosJson = gson.fromJson(datosInsumos, JsonObject.class);
            JsonArray insumosArray = datosJson.get("datos").getAsJsonArray();
            // recorremos el arreglo 
            for (int i = 0; i < insumosArray.size(); i++) {
                // aquí imprimimos los datos que necesitamos
                JsonObject insumo = insumosArray.get(i).getAsJsonObject();

                // creamos las variables que vamos a mostrar 
                String cultivo = insumo.get("name").getAsString();
                String insumoU = insumo.get("nombre").getAsString();
                String valor = insumo.get("valor_aprox").getAsString();
                String cantidad = insumo.get("cantidad_pro").getAsString();
                String unidad_medida = insumo.get("unidad_medida").getAsString();
                String fecha = insumo.get("fecha").getAsString();
                // ahora insertamos los datos en la tabla

                System.out.println("valor:" + valor);
                Object[] temporal = new Object[]{cultivo, insumoU, valor, cantidad, unidad_medida, fecha};
                // lo añadimos a la tabla 
                this.tabla.addRow(temporal);
            }

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new ImgInsumoA();
        table = new javax.swing.JScrollPane();
        tabla_insumos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        nuevo_insumo = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 204));

        tabla_insumos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Cultivo", "Insumo", "Valor ", "Cantidad", "Unidad de medida", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_insumos.setRowSelectionAllowed(false);
        tabla_insumos.getTableHeader().setReorderingAllowed(false);
        table.setViewportView(tabla_insumos);
        if (tabla_insumos.getColumnModel().getColumnCount() > 0) {
            tabla_insumos.getColumnModel().getColumn(0).setResizable(false);
            tabla_insumos.getColumnModel().getColumn(1).setResizable(false);
            tabla_insumos.getColumnModel().getColumn(2).setResizable(false);
            tabla_insumos.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel1.setBackground(new java.awt.Color(51, 175, 230));
        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MIS INSUMOS:");

        nuevo_insumo.setBackground(new java.awt.Color(51, 175, 230));
        nuevo_insumo.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        nuevo_insumo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mas.png"))); // NOI18N
        nuevo_insumo.setText("Agregar Insumo");
        nuevo_insumo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        nuevo_insumo.setFocusable(false);
        nuevo_insumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevo_insumoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(table, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nuevo_insumo)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
                .addComponent(nuevo_insumo)
                .addGap(64, 64, 64)
                .addComponent(table, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nuevo_insumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevo_insumoActionPerformed
        //aqui vamos agregarle un insumo al la finca del usuario
        InsumoAdmin ventana = new InsumoAdmin(id_finca,this);
        ventana.setVisible(true);
       
    }//GEN-LAST:event_nuevo_insumoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton nuevo_insumo;
    private javax.swing.JTable tabla_insumos;
    private javax.swing.JScrollPane table;
    // End of variables declaration//GEN-END:variables
}
