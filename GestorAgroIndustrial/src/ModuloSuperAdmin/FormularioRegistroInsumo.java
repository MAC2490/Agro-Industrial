package ModuloSuperAdmin;

import Clases.insumos;
import Principal.Alert;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import Principal.ConsumoAPI;
import jdk.jfr.Event;

public class FormularioRegistroInsumo extends javax.swing.JFrame {

    insumos insumos[] = null;
    PanelInsumos ventana;
    ConsumoAPI conexion = new ConsumoAPI();

    // conexion a consumo api
    public FormularioRegistroInsumo(PanelInsumos ventana, insumos[] insumos) {
        this.ventana = ventana;
        this.insumos = insumos;
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        serial = new javax.swing.JTextField();
        tipo = new javax.swing.JTextField();
        unidad = new javax.swing.JTextField();
        cantidad = new javax.swing.JTextField();
        nombre_insumo = new javax.swing.JTextField();
        provedor = new javax.swing.JTextField();
        costo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        registrar = new javax.swing.JButton();
        atras = new javax.swing.JButton();
        fecha = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(102, 204, 0));

        titulo.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        titulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/registro.png"))); // NOI18N
        titulo.setText("REGISTRO DE INSUMO");

        serial.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        tipo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        unidad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        cantidad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cantidadKeyTyped(evt);
            }
        });

        nombre_insumo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        provedor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        provedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                provedorKeyTyped(evt);
            }
        });

        costo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        costo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                costoKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user.png"))); // NOI18N
        jLabel2.setText("NOMBRE");

        jLabel3.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/llave.png"))); // NOI18N
        jLabel3.setText("SERIAL");

        jLabel4.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tipo.png"))); // NOI18N
        jLabel4.setText("TIPO DE INSUMO");

        jLabel5.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/unidad.png"))); // NOI18N
        jLabel5.setText("UNIDAD MEDIDAD");

        jLabel6.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/producto.png"))); // NOI18N
        jLabel6.setText("CANTIDAD");

        jLabel7.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fecha.png"))); // NOI18N
        jLabel7.setText("FECHA COMPRA");

        jLabel8.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/costo.png"))); // NOI18N
        jLabel8.setText("COSTO COMPRA");

        jLabel9.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/usuario.png"))); // NOI18N
        jLabel9.setText("PROVEDOR");

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

        atras.setBackground(new java.awt.Color(102, 204, 0));
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)))
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(atras, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(27, 27, 27)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(costo)
                    .addComponent(serial)
                    .addComponent(tipo)
                    .addComponent(unidad)
                    .addComponent(cantidad)
                    .addComponent(provedor)
                    .addComponent(nombre_insumo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fecha, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE))
                .addGap(27, 27, 27))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(125, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(titulo)
                        .addGap(62, 62, 62))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(titulo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(atras, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre_insumo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serial, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(unidad, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(costo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(provedor, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarActionPerformed
        String nombre = this.nombre_insumo.getText();
        String serial = this.serial.getText().trim();
        String tipo = this.tipo.getText();
        String unidad = this.unidad.getText();
        String cantidad = this.cantidad.getText();
        String fecha = ((JTextField) this.fecha.getDateEditor().getUiComponent()).getText();
        String costo = this.costo.getText();
        String provedor = this.provedor.getText();

        // validamos que el codigo seria no este repetido
        System.out.println("Tamaño" + insumos.length);

        boolean serial_valido = true;
        for (int i = 0; i < insumos.length; i++) {
            if (insumos[i].getSerial().equalsIgnoreCase(serial)) {
                serial_valido = false;
                break;

            }
        }

        if (serial_valido) {
            // validamos que todos los campos no esten vacios
            if (!nombre.equals("") && !serial.equals("") && !tipo.equals("") && !unidad.equals("") && !cantidad.equals("") && !fecha.equals("") && !costo.equals("") && !provedor.equals("")) {
                System.out.println("Todos los campos estas llenos");

                // ahora insertamos los datos a la base de datos
                Map<String, String> insertar = new HashMap<>();
                insertar.put("nombre", nombre);
                insertar.put("serial", serial);
                insertar.put("tipo", tipo);
                insertar.put("unidad", unidad);
                insertar.put("cantidad", cantidad);
                insertar.put("fecha", fecha);
                insertar.put("costo", costo);
                insertar.put("provedor", provedor);

                System.out.println("Consumo Insert" + conexion.consumoPOST("http://localhost/ApiPhp-AgroGestor/insumos/InsertInsumo.php", insertar));

                this.ventana.initAlternComponents();
                this.ventana.setVisible(true);
                dispose();
                Alert alerta = new Alert("Insertado con exito", "Insumo registrado con exito", "success");
            } else {
                System.out.println("Faltan campos por llenas");
                Alert alerta = new Alert("Campos Vacios", "Todos los campos son obligatorios", "warning");
                validarInputs();
            }
        } else {
            Alert alerta = new Alert("Serial Duplicado", "El serial ya existe en la base de datos", "error");

        }
    }//GEN-LAST:event_registrarActionPerformed

   
    public void validarInputs() {
        validarInput(this.nombre_insumo);
        validarInput(this.serial);
        validarInput(this.tipo);
        validarInput(this.unidad);
        validarInput(this.costo);
        validarInput(fecha);
        validarInput(this.provedor);
    }

    // metodo para validar los inputs
    public void validarInput(JTextField campo) {
        if (campo.getText().equals("")) {
            Border borderColor = new LineBorder(Color.RED, 1, true);
            Border borderPadding = new EmptyBorder(2, 5, 2, 5);
            Border borderRojo = new CompoundBorder(borderColor, borderPadding);
            campo.setBorder(borderRojo);
            campo.requestFocus();
        } else {
            JTextField referencia = new JTextField();
            campo.setBorder(referencia.getBorder());
        }
    }

    // este metodo solo se encarga de validar la fecha que no se encuentre vacia
    public void validarInput(JDateChooser dateChooser) {
        if (dateChooser.getDate() == null) {
            // No se ha seleccionado una fecha, aplicar el borde rojo
            Border borderColor = new LineBorder(Color.RED, 1, true);
            dateChooser.setBorder(borderColor);
            dateChooser.requestFocus();
        } else {
            // Se ha seleccionado una fecha, restablecer el borde
            JDateChooser referencia = new JDateChooser();
            dateChooser.setBorder(referencia.getBorder());
        }
    }

    // creamos un metodo que se encargara de validar los inputs
    private void atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasActionPerformed
        // SE DESTRUYE y se le manda de nuevo la vista del panel de insumos
        //this.ventana.initAlternComponents();
        this.ventana.setVisible(true);

        dispose();
        System.out.println("CLIK BOTON ATRAS INSUMOS REGISTRO");
        // abrimos una nueva ventana para que se me actulize la tabla

    }//GEN-LAST:event_atrasActionPerformed

    private void cantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidadKeyTyped
        // este metodo es para validar que solo se ingreses numeros 

        char c = evt.getKeyChar();
        if (c < '0' || c > '9')
            evt.consume();
    }//GEN-LAST:event_cantidadKeyTyped

    private void costoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_costoKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9')
            evt.consume();
    }//GEN-LAST:event_costoKeyTyped

    private void provedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_provedorKeyTyped
        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && ((c < 'A' || c > 'Z'))) evt.consume();
    }//GEN-LAST:event_provedorKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atras;
    private javax.swing.JTextField cantidad;
    private javax.swing.JTextField costo;
    private com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nombre_insumo;
    private javax.swing.JTextField provedor;
    private javax.swing.JButton registrar;
    private javax.swing.JTextField serial;
    private javax.swing.JTextField tipo;
    private javax.swing.JLabel titulo;
    private javax.swing.JTextField unidad;
    // End of variables declaration//GEN-END:variables
}
