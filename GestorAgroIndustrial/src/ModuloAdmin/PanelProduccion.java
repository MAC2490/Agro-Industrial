package ModuloAdmin;

import Principal.ConsumoAPI;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.awt.Color;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import Principal.AlertMauricio;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.FileOutputStream;
import javax.swing.border.MatteBorder;

public class PanelProduccion extends javax.swing.JPanel {
    private ConsumoAPI apiConsumption = new ConsumoAPI();
    private String id_farm;
    private String farm_name;
    private DefaultTableModel modal;
    private DefaultTableCellRenderer renderer;
    private NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.getDefault());
    private Object[] header = {"Nombre Cultivo", "Nombre Insumo", "Valor Insumo", "Cantidad Insumo", "Cantidad Producto", "Total Vendido", "Ganancias", "Fecha"};
    private Object[][] allData;
    Gson gson = new Gson();
    private boolean firstClick = true;
    private String user;
    
    public PanelProduccion(String user) {
        initComponents();
        this.user = user;
        this.renderer = new DefaultTableCellRenderer();
        this.modal = (DefaultTableModel) table.getModel();
        JsonObject jsonObject = gson.fromJson(user, JsonObject.class);
        String id_user = jsonObject.get("id_usuario").getAsString();
        this.getFarm(id_user);
        this.cleanSearch();
        this.back.setVisible(false);
        this.jButton1.setOpaque(false);
        this.jButton1.setContentAreaFilled(false);
        this.jButton1.setBorderPainted(false);
        this.jButton1.setForeground(Color.WHITE);
    }
   
    public void getFarm(String id_user){
        Map<String, String> getData = new HashMap<>();
        getData.put("id_usuario", id_user);
        String farm = this.apiConsumption.consumoGET("http://localhost/ApiPhp-AgroGestor/cultivos/GetMyFinca.php", getData);
        if (farm != null || farm.length() != 0) {
            JsonObject jsonObject = this.gson.fromJson(farm, JsonObject.class);
            this.id_farm = jsonObject.get("id_finca").getAsString();
            this.getData(true);
            this.id_farm = jsonObject.get("id_finca").getAsString();
            this.farm_name = jsonObject.get("nombre").getAsString();
            this.getData(true);
        }else{
            this.alert("ERROR", "El usuario no tien finca", "error");
        }
    }
    
    public void getData(boolean typeList){
        String response = "";
        if (typeList) {
            Map<String, String> farm_id = new HashMap<>();
            farm_id.put("id", this.id_farm);
            response = this.apiConsumption.consumoPOST("http://localhost/ApiPhp-AgroGestor/Produccion/ProduccionFinca/getProductionFarm.php", farm_id);
        }else{
            Map<String, String> searchFarm = new HashMap<>();
            searchFarm.put("dataSearch", this.search.getText());
            response = this.apiConsumption.consumoPOST("http://localhost/ApiPhp-AgroGestor/Produccion/ProduccionFinca/getSearch.php", searchFarm);
        }
        this.renderer.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < this.table.getColumnCount(); i++) {
            this.table.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }
        
        this.modal.setNumRows(0);
        if (response != null && response.length() != 0) {
            JsonObject objectJson = JsonParser.parseString(response).getAsJsonObject();
            JsonArray dataArray = objectJson.get("list_prod").getAsJsonArray();
            if (dataArray.size() != 0) {
                
                if (dataArray.size() == 0 && !typeList) {
                    this.back.setVisible(false);
                    this.alert("Busqueda fallida", "Sin resultados", "error");
                }else if (!typeList){
                    this.back.setVisible(true);
                }
                if (dataArray.size() == 0) {
                    this.getData(true);
                    this.firstClick = true;
                    this.search.setText("Buscar...");
                }
                this.allData = new Object[dataArray.size() + 1][];
                this.allData[0] = this.header;
                for (int i = 0; i < dataArray.size(); i++) {
                    JsonObject temp = dataArray.get(i).getAsJsonObject();

                    JsonElement crop_name = temp.get("nombre_cultivo");
                    JsonElement supplies_name = temp.get("nombre_insumo");
                    JsonElement value_supplies = temp.get("valor_aprox");
                    JsonElement amount_supplies = temp.get("cantidad_pro");
                    JsonElement unit_measurement = temp.get("unidad_medida"); // Unidad de medida
                    JsonElement amount_product = temp.get("cantidad");
                    JsonElement date = temp.get("fecha");
                    JsonElement total = temp.get("total");
                    JsonElement sale_price = temp.get("precio_venta");
                    float profits = (sale_price.getAsInt()*total.getAsFloat())-value_supplies.getAsInt(); // Ganancias 
                    String value_sup = this.currencyFormat.format(value_supplies.getAsInt());
                    String formatted = this.currencyFormat.format(profits);
                    Object [] data ={
                                      crop_name.getAsString(),
                                      supplies_name.getAsString(),
                                      value_sup,
                                      amount_supplies.getAsString()+" "+unit_measurement.getAsString(),
                                      amount_product.getAsString(),
                                      total.getAsString(),
                                      formatted,
                                      date.getAsString(),
                                    };
                    this.modal.addRow(data);
                    this.allData[i + 1] = new Object[]  {
                                                            crop_name.getAsString(),
                                                            supplies_name.getAsString(),
                                                            value_supplies.getAsString(),
                                                            amount_supplies.getAsString()+" "+unit_measurement.getAsString(),
                                                            amount_product.getAsString(),
                                                            total.getAsString(),
                                                            formatted,
                                                            date.getAsString(),
                                                        };
                }
            }else{
                this.jScrollPane1.setVisible(false);
                this.table.setVisible(false);
                this.search.setVisible(false);
                this.jButton1.setVisible(false);
                this.jButton3.setVisible(false);
                this.back.setVisible(false);
            }
        }else{
            this.jScrollPane1.setVisible(false);
            this.table.setVisible(false);
            this.search.setVisible(false);
            this.jButton1.setVisible(false);
            this.jButton3.setVisible(false);
            this.back.setVisible(false);
        }
    }
    
    public void cleanSearch(){
        this.search.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                if (firstClick) {
                    search.setText("");
                    firstClick = false;
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (search.getText().equals("")) {
                    search.setText("Buscar...");
                    firstClick = true;
                }
            }
        });
    }
    
    public void dowloadPdf(String fileName, Object[][] data){
        Document document = new Document();

        try {
            String userHome = System.getProperty("user.home");
            String downloadsPath = userHome + File.separator + "Downloads" + File.separator;

            // Asegúrate de que el directorio de descargas exista
            File downloadsDir = new File(downloadsPath);
            if (!downloadsDir.exists()) {
                downloadsDir.mkdirs();
            }
            File file = new File(fileName);
            if (file.exists()) {
                file.delete();
            }
            String filePath = downloadsPath + fileName;

            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.setMargins(3, 3, 5, 0);
            document.open();

            PdfPTable pdfTable = new PdfPTable(data[0].length);
            pdfTable.setWidthPercentage(100); // La tabla ocupa el 100% del ancho del documento

           // Título
            BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
            Font font = new Font(bf, 10);
            Paragraph titleParagraph = new Paragraph("Reportes de ganancias de la finca "+this.farm_name);
            titleParagraph.setAlignment(Element.ALIGN_CENTER);
            document.add(titleParagraph);

            // Espacio entre título y tabla
            document.add(new Paragraph(" "));
            
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[i].length; j++) {
                    PdfPCell cell = new PdfPCell(new Phrase(data[i][j].toString(), font));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER); // Centrar el contenido de la celda

                    // Establecer fondo gris claro para la primera celda (encabezado)
                    if (i == 0) {
                        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    }
                    cell.setPadding(5);
                    pdfTable.addCell(cell);
                }
            }
            document.add(pdfTable);
            this.alert("EXITO", "El reporte se descargo", "success");
            } catch (Exception e) {
                e.printStackTrace();
                this.alert("ERROR", "Parece que algo salio mal", "error");
            } finally {
            document.close();   
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        firstPanel = new imgPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        search = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        title = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        table.setForeground(new java.awt.Color(0, 0, 0));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cultivo", "insumo", "Valor insumo", "Cantidad insumos", "Cantidad Producto", "Total vendido", "Ganancias", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setEnabled(false);
        table.setGridColor(new java.awt.Color(255, 255, 255));
        table.setName(""); // NOI18N
        table.setSelectionBackground(new java.awt.Color(255, 255, 255));
        table.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setResizable(false);
            table.getColumnModel().getColumn(1).setResizable(false);
            table.getColumnModel().getColumn(2).setResizable(false);
            table.getColumnModel().getColumn(3).setResizable(false);
            table.getColumnModel().getColumn(4).setResizable(false);
            table.getColumnModel().getColumn(5).setResizable(false);
            table.getColumnModel().getColumn(6).setResizable(false);
            table.getColumnModel().getColumn(7).setResizable(false);
        }

        search.setBackground(new java.awt.Color(255, 255, 255));
        search.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        search.setForeground(new java.awt.Color(0, 0, 0));
        search.setText("Buscar...");
        search.setCaretColor(new java.awt.Color(0, 0, 0));
        search.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(51, 175, 230));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setText("Buscar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        back.setBackground(new java.awt.Color(51, 175, 230));
        back.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        back.setForeground(new java.awt.Color(0, 0, 0));
        back.setText("Volver");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pdf.png"))); // NOI18N
        jButton1.setOpaque(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 175, 230));
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mas.png"))); // NOI18N
        jButton2.setText("Registrar Ventas  ");
        jButton2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        title.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        title.setForeground(new java.awt.Color(0, 0, 0));
        title.setText("PRODUCCIÓN FINCAS");

        javax.swing.GroupLayout firstPanelLayout = new javax.swing.GroupLayout(firstPanel);
        firstPanel.setLayout(firstPanelLayout);
        firstPanelLayout.setHorizontalGroup(
            firstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(firstPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(firstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(firstPanelLayout.createSequentialGroup()
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jButton3)
                        .addGap(4, 4, 4)
                        .addComponent(back)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, firstPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(title)
                .addGap(249, 249, 249))
        );
        firstPanelLayout.setVerticalGroup(
            firstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(firstPanelLayout.createSequentialGroup()
                .addGroup(firstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(firstPanelLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(237, 237, 237)
                        .addGroup(firstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(firstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, firstPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(firstPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(firstPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed

    }//GEN-LAST:event_searchActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (this.search.getText().equals("") || this.search.getText().equals("Buscar...")) {
            this.alert("Error", "La busqueda esta vacia", "error");
            this.getData(true);
        }else{
            this.getData(false);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        this.getData(true);
        this.search.setText("Buscar...");
        this.firstClick = true;
        this.back.setVisible(false);
    }//GEN-LAST:event_backActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dowloadPdf("Reporte de la finca "+this.farm_name+".pdf", this.allData);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.firstPanel.removeAll();
        RegistrarProduccion temporal = new RegistrarProduccion(this.user, this);
        temporal.setSize(this.firstPanel.getSize());
        temporal.setPreferredSize(this.firstPanel.getPreferredSize());
        this.firstPanel.add(temporal);
        repaint();
        revalidate();
    }//GEN-LAST:event_jButton2ActionPerformed

    public void alert(String title, String mesage, String type){
        AlertMauricio alert = new AlertMauricio(title, mesage, type, true);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JPanel firstPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField search;
    private javax.swing.JTable table;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
