
package ModuloAdmin;

import Clases.*;
import ModuloAdmin.RecursosDelAdmin.AgregarCultivo;
import ModuloAdmin.RecursosDelAdmin.EditarCultivo;
import ModuloAdmin.RecursosDelAdmin.EliminarCultivo;
import Principal.ConsumoAPI;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.table.DefaultTableModel;

public class PanelCultivosAdmin extends javax.swing.JPanel {

    ConsumoAPI ejemplo = new ConsumoAPI();
    Cultivos[] cultivo = null;
    DefaultTableModel modelo;
    Gson gson = new Gson();
    String SessionUsuario;
    
    String id_user;
    String id_finca;


    public PanelCultivosAdmin(String SessionUsuario) {
        this.SessionUsuario=SessionUsuario;
        
        JsonObject jsonObject = gson.fromJson(SessionUsuario, JsonObject.class);
        this.id_user = jsonObject.get("id_usuario").getAsString();
                
        initComponents();
        initAlternComponents();
        ObtenerMiFinca();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelHeader = new javax.swing.JPanel();
        etqGestionCultivos = new javax.swing.JLabel();
        btnAgregarCultivo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabladatos = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        PanelHeader.setBackground(new java.awt.Color(204, 204, 204));

        etqGestionCultivos.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        etqGestionCultivos.setText("GESTION DE CULTIVOS");
        etqGestionCultivos.setToolTipText("");

        btnAgregarCultivo.setBackground(new java.awt.Color(0, 0, 153));
        btnAgregarCultivo.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        btnAgregarCultivo.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarCultivo.setText("REGISTRAR CULTIVO");
        btnAgregarCultivo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        btnAgregarCultivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCultivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelHeaderLayout = new javax.swing.GroupLayout(PanelHeader);
        PanelHeader.setLayout(PanelHeaderLayout);
        PanelHeaderLayout.setHorizontalGroup(
            PanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHeaderLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(etqGestionCultivos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgregarCultivo, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        PanelHeaderLayout.setVerticalGroup(
            PanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHeaderLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(PanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarCultivo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etqGestionCultivos))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        tabladatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "DESCRIPCION", "TIEMPO COSECHA", "ESTADO", "EDITAR", "ELIMINAR"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabladatos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 55, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void ObtenerMiFinca(){
        Map<String, String> getData = new HashMap<>();
        getData.put("id_usuario", id_user);
        String ConsultarMiFinca = ejemplo.consumoGET("http://localhost/ApiPhp-AgroGestor/cultivos/GetMyFinca.php", getData);
        JsonObject jsonObject = gson.fromJson(ConsultarMiFinca, JsonObject.class);
        this.id_finca = jsonObject.get("id_finca").getAsString();
    }
    
    private void btnAgregarCultivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCultivoActionPerformed
        AgregarCultivo ventana = new AgregarCultivo(this, id_user, id_finca);
        ventana.setVisible(true);
        
    }//GEN-LAST:event_btnAgregarCultivoActionPerformed

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
        
        Map<String, String> getData = new HashMap<>();
        getData.put("id_usuario", id_user);
        String select = ejemplo.consumoGET("http://localhost/ApiPhp-AgroGestor/cultivos/ObtenerCultivosFinca.php", getData);
        //System.out.println(select);

        
        JsonObject jsonObject = JsonParser.parseString(select).getAsJsonObject();
        JsonArray registros = jsonObject.getAsJsonArray("registros");
        
        
        cultivo = new Cultivos[registros.size()];
        for (int i = 0; i < registros.size(); i++) {
            
            Gson gson = new Gson();
            cultivo[i] = (Cultivos) gson.fromJson((JsonElement) registros.get(i).getAsJsonObject(), Cultivos.class);
            String id = cultivo[i].getId_cultivo();
            String nombre = cultivo[i].getNombre(); 
            String descripcion = cultivo[i].getDescripcion();
            String tiempo_cosecha = cultivo[i].getTiempo_cosecha();
            String estado = cultivo[i].getEstado();

            JButton btn_editar = new JButton("Editar");
            JButton btn_eliminar = new JButton("Borrar");

            Color BlueButton = Color.decode("#C8B4D7");
            Color RedButton = Color.decode("#FF9B00");
            btn_editar.setFocusable(false);
            btn_eliminar.setFocusable(false);

            btn_editar.setBackground(BlueButton);
            btn_eliminar.setBackground(RedButton);

            final PanelCultivosAdmin plantilla = this;
            final int posicion=i;
            
            btn_editar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    EditarCultivo ventana = new EditarCultivo(plantilla,cultivo[posicion]);
                    ventana.setVisible(true);
                }
            });

            btn_eliminar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    EliminarCultivo ventana = new EliminarCultivo(plantilla, cultivo[posicion]);
                    ventana.setVisible(true);
                }
            });
            
            Object[] temporal = new Object[]{id,nombre,descripcion,tiempo_cosecha,estado,btn_editar,btn_eliminar};
            modelo.addRow(temporal);
        }

    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelHeader;
    private javax.swing.JButton btnAgregarCultivo;
    private javax.swing.JLabel etqGestionCultivos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabladatos;
    // End of variables declaration//GEN-END:variables
}
