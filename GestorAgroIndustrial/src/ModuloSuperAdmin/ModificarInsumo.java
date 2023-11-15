package ModuloSuperAdmin;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import Clases.insumos;
import ModuloSuperAdmin.PanelInsumos;
import Principal.Alert;
import Principal.ConsumoAPI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ModificarInsumo extends javax.swing.JFrame {

    // aqui le mandamos los insumos con el id
    // recibimos tambien la ventana para poder hacer la actualizacion de los datos si se modifican
    insumos insumo = null;
    PanelInsumos ventana;
    ConsumoAPI conexion = new ConsumoAPI();

    public ModificarInsumo(PanelInsumos ventana, insumos datos) {
        //  le mandamos los insumos a la varible que creamos en esta clase
        this.insumo = datos;
        this.ventana = ventana;
        initComponents();
        initAlternComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentTitulo = new javax.swing.JPanel();
        etqTitulo = new javax.swing.JLabel();
        contentPrincipal = new javax.swing.JPanel();
        etqNombres = new javax.swing.JLabel();
        nombreM = new javax.swing.JTextField();
        etqApellidos = new javax.swing.JLabel();
        SerialM = new javax.swing.JTextField();
        etqcantidad = new javax.swing.JLabel();
        cantidadM = new javax.swing.JTextField();
        etqFecha = new javax.swing.JLabel();
        unindadM = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        tipoM = new javax.swing.JTextField();
        etqFecha1 = new javax.swing.JLabel();
        costoM = new javax.swing.JTextField();
        label_provedor = new javax.swing.JLabel();
        etqFecha5 = new javax.swing.JLabel();
        provedorM = new javax.swing.JTextField();
        etqFecha6 = new javax.swing.JLabel();
        fecha = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Modificar Producto");
        setUndecorated(true);

        contentTitulo.setBackground(new java.awt.Color(0, 153, 153));

        etqTitulo.setFont(new java.awt.Font("Arial Narrow", 1, 28)); // NOI18N
        etqTitulo.setForeground(new java.awt.Color(255, 255, 255));
        etqTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etqTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/modificar.png"))); // NOI18N
        etqTitulo.setText("MODIFICAR INSUMO");

        contentPrincipal.setBackground(new java.awt.Color(102, 255, 0));

        etqNombres.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        etqNombres.setForeground(new java.awt.Color(51, 51, 51));
        etqNombres.setText("Nombres:");
        etqNombres.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        nombreM.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nombreM.setMargin(new java.awt.Insets(2, 5, 2, 5));

        etqApellidos.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        etqApellidos.setForeground(new java.awt.Color(51, 51, 51));
        etqApellidos.setText("Serial");
        etqApellidos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        SerialM.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        SerialM.setMargin(new java.awt.Insets(2, 5, 2, 5));

        etqcantidad.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        etqcantidad.setForeground(new java.awt.Color(51, 51, 51));
        etqcantidad.setText("tipo:");
        etqcantidad.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        cantidadM.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cantidadM.setMargin(new java.awt.Insets(2, 5, 2, 5));
        cantidadM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cantidadMKeyTyped(evt);
            }
        });

        etqFecha.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        etqFecha.setForeground(new java.awt.Color(51, 51, 51));
        etqFecha.setText("fecha compra");
        etqFecha.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        unindadM.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        unindadM.setMargin(new java.awt.Insets(2, 5, 2, 5));

        btnCancelar.setBackground(new java.awt.Color(153, 153, 153));
        btnCancelar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.setFocusable(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnRegistrar.setBackground(new java.awt.Color(0, 0, 153));
        btnRegistrar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("MODIFICAR");
        btnRegistrar.setFocusable(false);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        tipoM.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tipoM.setMargin(new java.awt.Insets(2, 5, 2, 5));

        etqFecha1.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        etqFecha1.setForeground(new java.awt.Color(51, 51, 51));
        etqFecha1.setText("unidad medida");
        etqFecha1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        costoM.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        costoM.setMargin(new java.awt.Insets(2, 5, 2, 5));
        costoM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                costoMKeyTyped(evt);
            }
        });

        label_provedor.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        label_provedor.setForeground(new java.awt.Color(51, 51, 51));
        label_provedor.setText("provedor");
        label_provedor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        etqFecha5.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        etqFecha5.setForeground(new java.awt.Color(51, 51, 51));
        etqFecha5.setText("cantidad");
        etqFecha5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        provedorM.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        provedorM.setMargin(new java.awt.Insets(2, 5, 2, 5));
        provedorM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                provedorMKeyTyped(evt);
            }
        });

        etqFecha6.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        etqFecha6.setForeground(new java.awt.Color(51, 51, 51));
        etqFecha6.setText("costo compra");
        etqFecha6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        fecha.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout contentPrincipalLayout = new javax.swing.GroupLayout(contentPrincipal);
        contentPrincipal.setLayout(contentPrincipalLayout);
        contentPrincipalLayout.setHorizontalGroup(
            contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1))
            .addGroup(contentPrincipalLayout.createSequentialGroup()
                .addGroup(contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPrincipalLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contentPrincipalLayout.createSequentialGroup()
                                .addGroup(contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(contentPrincipalLayout.createSequentialGroup()
                                        .addComponent(etqcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tipoM, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(contentPrincipalLayout.createSequentialGroup()
                                        .addComponent(etqFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(unindadM, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(28, 28, 28)
                                .addGroup(contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(etqFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(etqFecha5, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(etqFecha6, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label_provedor, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(contentPrincipalLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(etqApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SerialM, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(costoM, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(provedorM, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRegistrar)
                            .addGroup(contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(fecha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                .addComponent(cantidadM, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addGroup(contentPrincipalLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(etqNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(nombreM, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(contentPrincipalLayout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(btnCancelar)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        contentPrincipalLayout.setVerticalGroup(
            contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPrincipalLayout.createSequentialGroup()
                            .addComponent(etqNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(etqApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPrincipalLayout.createSequentialGroup()
                            .addGroup(contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(nombreM, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(etqFecha5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(SerialM, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(etqFecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(contentPrincipalLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(cantidadM, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(contentPrincipalLayout.createSequentialGroup()
                            .addGroup(contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(etqcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tipoM, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(etqFecha6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(28, 28, 28)
                            .addGroup(contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(etqFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(unindadM, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(label_provedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(contentPrincipalLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(costoM, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(provedorM, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout contentTituloLayout = new javax.swing.GroupLayout(contentTitulo);
        contentTitulo.setLayout(contentTituloLayout);
        contentTituloLayout.setHorizontalGroup(
            contentTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentTituloLayout.createSequentialGroup()
                .addGroup(contentTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(contentPrincipal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(etqTitulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        contentTituloLayout.setVerticalGroup(
            contentTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentTituloLayout.createSequentialGroup()
                .addComponent(etqTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contentPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

        // aqui convertimos la fecha a string manipulable
        String fecha = ((JTextField) this.fecha.getDateEditor().getUiComponent()).getText();
        System.out.println("fecha" + fecha);
        if (!this.nombreM.getText().equals("") && !this.SerialM.getText().equals("") && !this.tipoM.getText().equals("") && !this.cantidadM.getText().equals("") && !this.unindadM.getText().equals("") && !fecha.equals("")) {
            String id = insumo.getInsumos_id();
            String nombre = nombreM.getText();
            String serial = SerialM.getText();
            String tipo = tipoM.getText();
            String unidad = unindadM.getText();
            String cantidad = cantidadM.getText();
            String costo = costoM.getText();
            String provedor = provedorM.getText();

            // actualizamos los datos del usuario 
            Map<String, String> Actualizar = new HashMap<>();
            Actualizar.put("id_insumo", id);
            Actualizar.put("nombre", nombre);
            Actualizar.put("serial", serial);
            Actualizar.put("tipo", tipo);
            Actualizar.put("unidad", unidad);
            Actualizar.put("cantidad", cantidad);
            Actualizar.put("fecha", fecha);
            Actualizar.put("costo", costo);
            Actualizar.put("provedor", provedor);

            System.out.println("Consumo Insert" + conexion.consumoPOST("http://localhost/ApiPhp-AgroGestor/insumos/UpdateInsumo.php", Actualizar));

            ventana.initAlternComponents();
            ventana.setVisible(true);
            //aqui se destruye una vez guarde los cambios
            // manndamos mensaje de que se insertaron con exito 
            Alert alerta = new Alert("Actualizado", "Datos actualizados con exito", "success");
            dispose();
        } else {
            System.out.println("Campos vacios");
            //mandamos mensaje de alerta 
            Alert alerta = new Alert("Campos vacios", "Todos los campos son obligatorios", "warning");

        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        this.ventana.initAlternComponents();
        this.ventana.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cantidadMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidadMKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9')
            evt.consume();
    }//GEN-LAST:event_cantidadMKeyTyped
    private void costoMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_costoMKeyTyped

        char c = evt.getKeyChar();
        if (c < '0' || c > '9')
            evt.consume();
    }//GEN-LAST:event_costoMKeyTyped

    private void provedorMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_provedorMKeyTyped
        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && ((c < 'A' || c > 'Z')))
            evt.consume();
    }//GEN-LAST:event_provedorMKeyTyped

    public void initAlternComponents() {
        // ahora miramos si llega los datos que son

        setLocationRelativeTo(null);
        System.out.println("Insumo" + insumo.getTipo_insumo());

        // ahora cargamos loos datos a los imputs 
        this.nombreM.setText(insumo.getName());
        this.SerialM.setText(insumo.getSerial());
        this.tipoM.setText(insumo.getTipo_insumo());
        this.unindadM.setText(insumo.getUnidada_medida());
        this.cantidadM.setText(insumo.getCantidad());
        // el try es para el manejo de errores por si el formato ingresado no es una  fecha correcta toca manejarlo bin
        try {
            // Formato de la cadena de fecha
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            // Parsear la cadena a un objeto Date
            Date fechaDate = formatoFecha.parse(insumo.getFecha_compra());
            // Establecer la fecha en el JDateChooser
            this.fecha.setDate(fechaDate);
        } catch (ParseException e) {
            e.printStackTrace();
            // Manejar la excepción de formato de fecha incorrecto
        }
        this.costoM.setText(insumo.getCosto_compra());
        this.provedorM.setText(insumo.getProveedor());
    }

    //creamos un metodo para habilitaros si los encuentra 
    public void habilitarInput(JTextField input) {
        input.setText("");
        input.setEditable(true);
        input.setEnabled(true);
    }

    //creamo metodo para deshabilitar los input sino hay nada
    public void deshabilitarInput(JTextField input) {
        input.setEditable(false);
        input.setEnabled(false);
        input.setDisabledTextColor(Color.black);
    }

    public void limpiarInput() {
        nombreM.setText("");
        SerialM.setText("");
        cantidadM.setText("");
        unindadM.setText("");

    }
    int posicion;

    public int getObtenerPosicion() {
        return this.posicion;
    }

    public void setObtenerPosicion(int posicion) {
        this.posicion = posicion;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField SerialM;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JTextField cantidadM;
    private javax.swing.JPanel contentPrincipal;
    private javax.swing.JPanel contentTitulo;
    private javax.swing.JTextField costoM;
    private javax.swing.JLabel etqApellidos;
    private javax.swing.JLabel etqFecha;
    private javax.swing.JLabel etqFecha1;
    private javax.swing.JLabel etqFecha5;
    private javax.swing.JLabel etqFecha6;
    private javax.swing.JLabel etqNombres;
    private javax.swing.JLabel etqTitulo;
    private javax.swing.JLabel etqcantidad;
    private com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel label_provedor;
    private javax.swing.JTextField nombreM;
    private javax.swing.JTextField provedorM;
    private javax.swing.JTextField tipoM;
    private javax.swing.JTextField unindadM;
    // End of variables declaration//GEN-END:variables
}
