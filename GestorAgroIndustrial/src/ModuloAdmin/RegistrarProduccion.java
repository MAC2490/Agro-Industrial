package ModuloAdmin;

import Principal.Alert;
import Principal.AlertMauricio;
import Principal.ConsumoAPI;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class RegistrarProduccion extends javax.swing.JPanel {
    private ConsumoAPI apiConsumption = new ConsumoAPI();
    Gson gson = new Gson();
    private String id_farm;
    private DefaultTableModel modal;
    private DefaultTableCellRenderer renderer;
    private String [] id_production = new String [0];
    private int positionId = 0;
    private String [] cantCrop = new String [0];
    private String user;
    private PanelProduccion window;
    
    public RegistrarProduccion(String user, PanelProduccion window) {
        initComponents();
        this.window = window;
        this.user = user;
        JsonObject jsonObject = gson.fromJson(user, JsonObject.class);
        String id_user = jsonObject.get("id_usuario").getAsString();
        this.renderer = new DefaultTableCellRenderer();
        this.modal = (DefaultTableModel) table.getModel();
        this.date.setDate(new Date());
        this.initAlert();
        this.getFarm(id_user);
    }
    
    public void initAlert(){
        this.crop.setEditable(false);
        this.date.setEnabled(false);
        this.total.setEditable(false);
        this.sale_price.setEditable(false);
        this.jButton1.setEnabled(false);
        this.table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());
                int col = table.columnAtPoint(e.getPoint());
                crop.setEditable(true);
                date.setEnabled(true);
                total.setEditable(true);
                sale_price.setEditable(true);
                jButton1.setEnabled(true);
                searchCrop(row, col);
            }
        });
    }
    
    public void searchCrop(int row, int col){
        int numRow = this.modal.getRowCount();
        int numColum = this.modal.getColumnCount();
        String data[][] = new String[numRow][numColum];
        for (int i = 0; i < numRow; i++) {
            for (int j = 0; j < numColum; j++) {
                Object value = modal.getValueAt(i, j);
                data [i][j] = value.toString(); 
                if (i == row) {
                    this.positionId = i;
                    this.crop.setText(data[i][0]);
                    break;
                }
            }
        }
    }
    
    public void getFarm(String id_user){
        Map<String, String> getData = new HashMap<>();
        getData.put("id_usuario", id_user);
        String farm = this.apiConsumption.consumoGET("http://localhost/ApiPhp-AgroGestor/cultivos/GetMyFinca.php", getData);
        JsonObject jsonObject = this.gson.fromJson(farm, JsonObject.class);
        this.id_farm = jsonObject.get("id_finca").getAsString();
        this.getData(true);
    }
    
    public void getData(boolean typeList){
        String response = "";
        Map<String, String> farm_id = new HashMap<>();
        farm_id.put("id", this.id_farm);
        response = this.apiConsumption.consumoPOST("http://localhost/ApiPhp-AgroGestor/Produccion/ProduccionFinca/getProductionTable.php", farm_id);
        System.out.println(response);
        /*if (typeList) {
            Map<String, String> farm_id = new HashMap<>();
            farm_id.put("id", this.id_farm);
            response = this.apiConsumption.consumoPOST("http://localhost/ApiPhp-AgroGestor/Produccion/ProduccionFinca/getProductionFarm.php", farm_id);
        }else{
            Map<String, String> searchFarm = new HashMap<>();
            searchFarm.put("dataSearch", this.search.getText());
            response = this.apiConsumption.consumoPOST("http://localhost/ApiPhp-AgroGestor/Produccion/ProduccionFinca/getSearch.php", searchFarm);
        }*/
        this.renderer.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < this.table.getColumnCount(); i++) {
            this.table.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }
        
        this.modal.setNumRows(0);
        if (response != null) {
            JsonObject objectJson = JsonParser.parseString(response).getAsJsonObject();
            JsonArray dataArray = objectJson.get("list_prod").getAsJsonArray();
            /* if (dataArray.size() == 0 && !typeList) {
                this.back.setVisible(false);
                this.alert("Busqueda fallida", "Sin resultados", "error");
            }else if (!typeList){
                this.back.setVisible(true);
            }
            if (dataArray.size() == 0) {
                this.getData(true);
                this.firstClick = true;
                this.search.setText("Buscar...");
            } */
            this.cantCrop = new String[dataArray.size()];
            this.id_production = new String[dataArray.size()];
            for (int i = 0; i < dataArray.size(); i++) {
                JsonObject temp = dataArray.get(i).getAsJsonObject();
                
                JsonElement crop_name = temp.get("nombre_cultivo");
                JsonElement supplies_name = temp.get("nombre_insumo");
                JsonElement value_supplies = temp.get("valor_aprox");
                JsonElement amount_supplies = temp.get("cantidad_pro");
                JsonElement unit_measurement = temp.get("unidad_medida"); // Unidad de medida
                JsonElement amount_product = temp.get("cantidad");
                this.id_production[i] = temp.get("id_produccion").getAsString();
                this.cantCrop[i] = amount_product.getAsString();
                Object [] data ={
                                  crop_name.getAsString(),
                                  supplies_name.getAsString(),
                                  value_supplies.getAsString(),
                                  amount_supplies.getAsString()+" "+unit_measurement.getAsString(),
                                  amount_product.getAsString(),
                                };
                this.modal.addRow(data);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPrincipal = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        crop = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        sale_price = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        date = new com.toedter.calendar.JDateChooser();

        PanelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        PanelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table.setForeground(new java.awt.Color(0, 0, 0));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Cultivo", "Insumo", "Valor insumo", "Cantidad insumo", "Cantida producto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setGridColor(new java.awt.Color(255, 255, 255));
        table.setOpaque(false);
        table.setRequestFocusEnabled(false);
        table.setSelectionBackground(new java.awt.Color(204, 204, 255));
        table.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setResizable(false);
            table.getColumnModel().getColumn(1).setResizable(false);
            table.getColumnModel().getColumn(2).setResizable(false);
            table.getColumnModel().getColumn(3).setResizable(false);
            table.getColumnModel().getColumn(4).setResizable(false);
        }

        PanelPrincipal.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 128, 540, 326));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Cultivo");
        PanelPrincipal.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(635, 128, -1, -1));
        PanelPrincipal.add(crop, new org.netbeans.lib.awtextra.AbsoluteConstraints(552, 150, 206, -1));

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Fecha venta");
        PanelPrincipal.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(621, 188, -1, -1));

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Total venta");
        PanelPrincipal.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(624, 248, -1, -1));
        PanelPrincipal.add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(552, 270, 206, -1));

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Precio venta");
        PanelPrincipal.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(624, 302, -1, -1));
        PanelPrincipal.add(sale_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(552, 324, 206, -1));

        jButton1.setBackground(new java.awt.Color(51, 175, 230));
        jButton1.setText("REGISTRAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        PanelPrincipal.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(552, 389, -1, -1));

        jButton2.setBackground(new java.awt.Color(51, 175, 230));
        jButton2.setText("CANCELAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        PanelPrincipal.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 390, -1, -1));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        title.setForeground(new java.awt.Color(0, 0, 0));
        title.setText("REGISTRAR PRODUCCIÓN FINCA");
        jPanel2.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 22, -1, -1));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 780, 20));

        PanelPrincipal.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -1, 780, 90));
        PanelPrincipal.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(552, 211, 200, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 786, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.changeWindow();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(this.date.getDate());
        Map<String, String> crop_production = new HashMap<>();
        crop_production.put("id", this.id_production[this.positionId]);
        crop_production.put("date", formattedDate);
        crop_production.put("total", this.total.getText());
        crop_production.put("price", this.sale_price.getText());
        crop_production.put("crop", this.cantCrop[this.positionId]);
        String response = this.apiConsumption.consumoPOST("http://localhost/ApiPhp-AgroGestor/Produccion/ProduccionFinca/RegisterProduction.php", crop_production);

        if (response.equals("1")) {
            this.alert("EXITO", "Se registro correctamente", "success");
            this.changeWindow();
        }else if(response.equals("2")){
            this.alert("ERROR", "Algo salio mal", "error");
        }else if(response.equals("303")){
            this.alert("ERROR", "La cantida no esta disponible", "error");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public void changeWindow(){
        removeAll();
        PanelProduccion temporal = new PanelProduccion(this.user);
        temporal.setSize(this.getSize());
        temporal.setPreferredSize(this.getPreferredSize());
        this.add(temporal);
        repaint();
        revalidate();
    }
    
    public void alert(String title, String mesage, String type){
        AlertMauricio alert = new AlertMauricio(title, mesage, type, true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JTextField crop;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField sale_price;
    private javax.swing.JTable table;
    private javax.swing.JLabel title;
    private javax.swing.JTextField total;
    // End of variables declaration//GEN-END:variables
}
