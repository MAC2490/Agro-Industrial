package ModuloSuperAdmin;

import javax.swing.table.*;
import Principal.ConsumoAPI;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import Clases.*;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

public class PanelInsumos extends javax.swing.JPanel {

    insumos[] Insumos = null;
    // formateamos la tabla
    DefaultTableModel tabla;
    // hacemos llamado a la clase consumo api
    ConsumoAPI API = new ConsumoAPI();

    public PanelInsumos() {
        initComponents();
        initAlternComponents();
    }

    public void initAlternComponents() {
        this.tabla = (DefaultTableModel) this.tabla_insumos.getModel();
        this.tabla_insumos.getColumn("ELIMINAR").setCellRenderer(new ButtonRenderer());
        this.tabla_insumos.getColumn("ELIMINAR").setCellEditor(new ButtonEditor(new JCheckBox()));
        this.tabla_insumos.getColumn("MODIFICAR").setCellRenderer(new ButtonRenderer());
        this.tabla_insumos.getColumn("MODIFICAR").setCellEditor(new ButtonEditor(new JCheckBox()));

        tabla.setNumRows(0);

        // hacemos conexion. a la base de datos 
        String respuestaInsumos = API.consumoGET("http://localhost/ApiPhp-AgroGestor/insumos/ObtenerInsumos.php");

        //verificamos que las respuesta no venga nulla
        if (respuestaInsumos != null) {
            JsonObject objetoJson = JsonParser.parseString(respuestaInsumos).getAsJsonObject();
            JsonArray insumosArray = objetoJson.get("datos").getAsJsonArray();

            // creamos el for para recorer los datos que vienen 
            Insumos = new insumos[insumosArray.size()];
            for (int i = 0; i < insumosArray.size(); i++) {
                JsonObject temp = insumosArray.get(i).getAsJsonObject();
                // ahora pasamos los datos a laa clase de insumos para hacer la manipulacion de datos mas facil
                Gson gson = new Gson();
                Insumos[i] = (insumos) gson.fromJson((JsonElement) insumosArray.get(i).getAsJsonObject(), insumos.class);

                String name = Insumos[i].getName();
                String serial = Insumos[i].getSerial();
                String tipo_insumo = Insumos[i].getTipo_insumo();
                String unidada_medida = Insumos[i].getUnidada_medida();
                String cantidad = Insumos[i].getCantidad();
                String fecha_compra = Insumos[i].getFecha_compra();
                String costo_compra = Insumos[i].getCosto_compra();
                String proveedor = Insumos[i].getProveedor();

                // creamos los botones para hacer la eliminacion o actulalizacion de datos 
                JButton btnEliminar = new JButton();
                JButton btnModificar = new JButton();

                ImageIcon iconEliminar = new ImageIcon(getClass().getResource("/img/eliminar.png"));
                ImageIcon iconModificar = new ImageIcon(getClass().getResource("/img/actualizar.png"));

                btnEliminar.setIcon(iconEliminar);
                btnModificar.setIcon(iconModificar);

                btnEliminar.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cambiar cursor a mano
                btnModificar.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cambiar cursor a mano

                btnEliminar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Has dado clik en eliminar");
                    }
                }
                );

                btnModificar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Has dado clik en actualizar");
                    }
                }
                );
                Object[] temporal = new Object[]{serial, name, cantidad, fecha_compra, costo_compra, proveedor, btnEliminar, btnModificar};

                this.tabla.addRow(temporal);
                // ahora mostramos los datos en la tabla

                System.out.println(
                        "NOMBRE:" + temp.get("name"));
            }
        } else {
            System.out.println("NO hay datos para mostrar");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_insumos = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        title.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        title.setText("GESTION DE INSUMOS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(248, 248, 248)
                .addComponent(title)
                .addContainerGap(252, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
        );

        jButton1.setBackground(new java.awt.Color(153, 255, 51));
        jButton1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mas.png"))); // NOI18N
        jButton1.setText("ADD INSUMO ");
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tabla_insumos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "SERIAL", "NOMBRE", "CANTIDAD", "FECHA", "COSTO", "PROVEDOR", "ELIMINAR", "MODIFICAR"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_insumos.setFocusable(false);
        tabla_insumos.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tabla_insumos);
        if (tabla_insumos.getColumnModel().getColumnCount() > 0) {
            tabla_insumos.getColumnModel().getColumn(0).setResizable(false);
            tabla_insumos.getColumnModel().getColumn(1).setResizable(false);
            tabla_insumos.getColumnModel().getColumn(2).setResizable(false);
            tabla_insumos.getColumnModel().getColumn(3).setResizable(false);
            tabla_insumos.getColumnModel().getColumn(4).setResizable(false);
            tabla_insumos.getColumnModel().getColumn(5).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // AQUI mandamos las vista a el nuevo jframe del formulario
        //  le enviamos la ventanaa de nuevo para que cargue los nuevos datos a laa hora de agregar uno nuevo 

        setVisible(false);
        FormularioRegistroInsumo ventana = new FormularioRegistroInsumo(this, Insumos);
        ventana.setVisible(true);

        System.out.println("CLIK BOTON REGISTRAR INSUMO");
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabla_insumos;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
