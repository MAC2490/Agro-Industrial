package ModuloSuperAdmin;

import javax.swing.table.*;
import Principal.ConsumoAPI;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import Clases.*;
import Principal.Alert;
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
    boolean estado_insumo;
    String texto; // formateamos la tabla
    DefaultTableModel tabla;
    // hacemos llamado a la clase consumo api
    ConsumoAPI API = new ConsumoAPI();

    public PanelInsumos() {
        initComponents();
        initAlternComponents();
    }

    public void initAlternComponents() {
        this.tabla = (DefaultTableModel) this.tabla_insumos.getModel();
        this.tabla_insumos.getColumn("DESACTIVAR").setCellRenderer(new ButtonRenderer());
        this.tabla_insumos.getColumn("DESACTIVAR").setCellEditor(new ButtonEditor(new JCheckBox()));
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
                String estado = Insumos[i].getEstado();
                System.out.println("Estado se insumo" + Insumos[i].getEstado());
                // creamos los botones para hacer la eliminacion o actulalizacion de datos 
                JButton btndesactivar = new JButton();
                JButton btnModificar = new JButton();

                ImageIcon iconodesactivar = new ImageIcon(getClass().getResource("/img/disable.png"));
                ImageIcon iconModificar = new ImageIcon(getClass().getResource("/img/actualizar.png"));

                btndesactivar.setIcon(iconodesactivar);
                btnModificar.setIcon(iconModificar);

                btndesactivar.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cambiar cursor a mano
                btnModificar.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cambiar cursor a mano

                // variable que le mandamos a el jframe para saber que tipo de insumo vamos a modificaar 
                final int posicion = i;

                final PanelInsumos ventanaP = this;

                btndesactivar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // abrimos un mensaje de alerta a este
                        if (Insumos[posicion].getEstado().trim().equalsIgnoreCase("ACTIVO")) {
                            texto = "Deseas Deshabilitar este insumo ?";
                            estado_insumo = true;
                        } else if (Insumos[posicion].getEstado().trim().equalsIgnoreCase("DESHABILITADO")) {
                            texto = "Deseas Habilitar Este insumo ?";
                            estado_insumo = false;
                        }
                        EstadoInsumo estadoI = new EstadoInsumo(texto, Insumos[posicion], estado_insumo, ventanaP);
                        System.out.println("Has dado clik en desactivar");
                    }
                }
                );

                btnModificar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // aqui le mandamos el insumo con todos los datos para que los pueda modificar
                        System.out.println("Has dado clik en actualizar");
                        ModificarInsumo modificar = new ModificarInsumo(ventanaP, Insumos[posicion]);
                        modificar.setVisible(true);

                    }
                }
                );
                Object[] temporal = new Object[]{serial, name, cantidad, fecha_compra, costo_compra, proveedor, estado, btndesactivar, btnModificar};

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

        jPanel3 = new ImgInsumo();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_insumos = new javax.swing.JTable();
        title = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        tabla_insumos.setBackground(new java.awt.Color(242, 242, 242));
        tabla_insumos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "SERIAL", "NOMBRE", "CANTIDAD", "FECHA", "COSTO", "PROVEDOR", "ESTADO", "DESACTIVAR", "MODIFICAR"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true, true
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
            tabla_insumos.getColumnModel().getColumn(6).setResizable(false);
        }

        title.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        title.setText("GESTION DE INSUMOS");

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 253, Short.MAX_VALUE)
                        .addComponent(title)
                        .addGap(239, 239, 239))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jButton1)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(318, 318, 318))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // AQUI mandamos las vista a el nuevo jframe del formulario
        //  le enviamos la ventanaa de nuevo para que cargue los nuevos datos a laa hora de agregar uno nuevo

        FormularioRegistroInsumo ventana = new FormularioRegistroInsumo(this, Insumos);
        ventana.setVisible(true);

        System.out.println("CLIK BOTON REGISTRAR INSUMO");
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabla_insumos;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}