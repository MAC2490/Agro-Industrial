package ModuloSuperAdmin;

import Clases.*;
import ModuloSuperAdmin.RecursosAdmins.*;
import Principal.ConsumoAPI;
import clases.Persona;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.table.DefaultTableModel;

public class PanelUsuarios extends javax.swing.JPanel {

    ConsumoAPI ejemplo = new ConsumoAPI();
    Persona[] persona = null;
    DefaultTableModel modelo;
    Gson gson = new Gson();

    public PanelUsuarios() {
        initComponents();
        initAlternComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelHeader = new javax.swing.JPanel();
        etqAdmins = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabladatos = new javax.swing.JTable();
        btnAgregarUser = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        PanelHeader.setBackground(new java.awt.Color(222, 222, 222));

        etqAdmins.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        etqAdmins.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etqAdmins.setText("GESTION DE ADMINISTRADORES");

        javax.swing.GroupLayout PanelHeaderLayout = new javax.swing.GroupLayout(PanelHeader);
        PanelHeader.setLayout(PanelHeaderLayout);
        PanelHeaderLayout.setHorizontalGroup(
            PanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etqAdmins, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelHeaderLayout.setVerticalGroup(
            PanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHeaderLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(etqAdmins)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        tabladatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CEDULA", "NOMBRE", "APELLIDO", "ESTADO", "ROL", "PASSWORD", "EDITAR", "ELIMINAR"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabladatos.setRowHeight(30);
        jScrollPane1.setViewportView(tabladatos);
        if (tabladatos.getColumnModel().getColumnCount() > 0) {
            tabladatos.getColumnModel().getColumn(0).setResizable(false);
            tabladatos.getColumnModel().getColumn(0).setPreferredWidth(35);
            tabladatos.getColumnModel().getColumn(1).setResizable(false);
            tabladatos.getColumnModel().getColumn(2).setResizable(false);
            tabladatos.getColumnModel().getColumn(3).setResizable(false);
            tabladatos.getColumnModel().getColumn(4).setResizable(false);
            tabladatos.getColumnModel().getColumn(4).setPreferredWidth(50);
            tabladatos.getColumnModel().getColumn(5).setResizable(false);
            tabladatos.getColumnModel().getColumn(5).setPreferredWidth(60);
            tabladatos.getColumnModel().getColumn(6).setResizable(false);
            tabladatos.getColumnModel().getColumn(6).setPreferredWidth(55);
            tabladatos.getColumnModel().getColumn(7).setResizable(false);
            tabladatos.getColumnModel().getColumn(7).setPreferredWidth(60);
            tabladatos.getColumnModel().getColumn(8).setResizable(false);
            tabladatos.getColumnModel().getColumn(8).setPreferredWidth(60);
        }

        btnAgregarUser.setBackground(new java.awt.Color(153, 255, 51));
        btnAgregarUser.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        btnAgregarUser.setText("AGREGAR USUARIO");
        btnAgregarUser.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        btnAgregarUser.setFocusable(false);
        btnAgregarUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 717, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarUser, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAgregarUser, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarUserActionPerformed
        RegistrarAdmin ventana = new RegistrarAdmin(this);
        ventana.setVisible(true);
    }//GEN-LAST:event_btnAgregarUserActionPerformed

    public void initAlternComponents() {
        cargarDatos();
    }

    public void cargarDatos() {

        modelo = (DefaultTableModel) tabladatos.getModel();

        this.tabladatos.getColumn("EDITAR").setCellRenderer(new ButtonRenderer());
        this.tabladatos.getColumn("EDITAR").setCellEditor(new ButtonEditor(new JCheckBox()));

        this.tabladatos.getColumn("ELIMINAR").setCellRenderer(new ButtonRenderer());
        this.tabladatos.getColumn("ELIMINAR").setCellEditor(new ButtonEditor(new JCheckBox()));
        modelo.setNumRows(0);
        String select = ejemplo.consumoGET("http://localhost/ApiPhp-AgroGestor/usuarios/Obtener.php");
        
        
        JsonObject jsonObject = JsonParser.parseString(select).getAsJsonObject();
        JsonArray registros = jsonObject.getAsJsonArray("registros");
        
        persona = new Persona[registros.size()];
        for (int i = 0; i < registros.size(); i++) {
            Gson gson = new Gson();
            persona[i] = (Persona) gson.fromJson((JsonElement) registros.get(i).getAsJsonObject(), Persona.class);
            String id =persona[i].getId_usuario();
            String cedula = persona[i].getCedula();
            String nombre = persona[i].getNombre(); 
            String apellido =persona[i].getApellido(); 
            String estado =persona[i].getEstado();
            String rol = persona[i].getRol();
            String password = persona[i].getPassword();

           

            JButton btn_editar = new JButton("Editar");
            JButton btn_eliminar = new JButton("Borrar");

            Color BlueButton = Color.decode("#4BC8FF");
            Color RedButton = Color.decode("#FF6446");
            btn_editar.setFocusable(false);
            btn_eliminar.setFocusable(false);

            btn_editar.setBackground(BlueButton);
            btn_eliminar.setBackground(RedButton);

            final PanelUsuarios plantilla = this;
            final int posicion=i;
            btn_editar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    EditarAdmin ventana = new EditarAdmin(plantilla,persona[posicion]);
                    ventana.setVisible(true);
                }
            });

            btn_eliminar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    EliminarAdmin ventana = new EliminarAdmin(plantilla, persona[posicion]);
                    ventana.setVisible(true);
                }
            });
            Object[] temporal = new Object[]{id,cedula,nombre,apellido,estado,rol,password,btn_editar,btn_eliminar};
            modelo.addRow(temporal);
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelHeader;
    private javax.swing.JButton btnAgregarUser;
    private javax.swing.JLabel etqAdmins;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabladatos;
    // End of variables declaration//GEN-END:variables
}
