package ModuloSuperAdmin;
import Principal.ConsumoAPI;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.text.NumberFormat;
import java.util.Locale;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPCell;
import java.io.File;
import java.io.FileOutputStream;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;
import Principal.AlertMauricio;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.HashMap;
import java.util.Map;
import Principal.AlertMauricio;
import java.awt.Color;
import javax.swing.border.MatteBorder;


public class PanelProduccion extends javax.swing.JPanel {
    private ConsumoAPI apiConsumption = new ConsumoAPI();
    private DefaultTableModel modal;
    private DefaultTableCellRenderer renderer;
    private NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.getDefault());
    private Object[] header = {"Nombre Cultivo", "Nombre Finca", "Nombre Insumo", "Valor Insumo", "Cantidad Insumo", "Cantidad Producto", "Total Vendido", "Ganancias", "Fecha"};
    private Object[][] allData;
    private boolean firstClick = true;
    public PanelProduccion() {
        initComponents();
        this.jButton1.setOpaque(false);
        this.jButton1.setContentAreaFilled(false);
        this.jButton1.setBorderPainted(false);
        this.jButton1.setForeground(Color.WHITE);
        this.back.setVisible(false);
        this.renderer = new DefaultTableCellRenderer();
        this.modal = (DefaultTableModel) table.getModel();
        this.cleanSearch();
        this.getData(true);
    }
    
    public void getData(boolean typeList){
        String response = "";
        if (typeList) {
            response = this.apiConsumption.consumoGET("http://localhost/ApiPhp-AgroGestor/Produccion/getProduction.php");
        }else{
            Map<String, String> searchFarm = new HashMap<>();
            searchFarm.put("dataSearch", this.search.getText());
            response = this.apiConsumption.consumoPOST("http://localhost/ApiPhp-AgroGestor/Produccion/getSearchProduction.php", searchFarm);
        }
        this.renderer.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < this.table.getColumnCount(); i++) {
            this.table.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }
        
        this.modal.setNumRows(0);
        if (response != null) {
            JsonObject objectJson = JsonParser.parseString(response).getAsJsonObject();
            JsonArray dataArray = objectJson.get("list_crop").getAsJsonArray();
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
                    JsonElement farm_name = temp.get("nombre_finca");
                    JsonElement supplies_name = temp.get("nombre_insumo");
                    JsonElement value_supplies = temp.get("valor_aprox");
                    JsonElement amount_supplies = temp.get("cantidad_pro");
                    JsonElement unit_measurement = temp.get("unidad_medida"); // Unidad de medida
                    JsonElement amount_product = temp.get("cantidad");
                    JsonElement date = temp.get("fecha");
                    JsonElement total = temp.get("total");
                    JsonElement sale_price = temp.get("precio_venta");
                    float profits = (sale_price.getAsInt()*total.getAsFloat()); // Ganancias 
                    String value_sup = this.currencyFormat.format(value_supplies.getAsInt());
                    String formatted = this.currencyFormat.format(profits);
                    Object [] data ={
                                      crop_name.getAsString(),
                                      farm_name.getAsString(),
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
                                                            farm_name.getAsString(),
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
            
        }
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
            Paragraph titleParagraph = new Paragraph("Reportes de ganancias");
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
    
    public void alert(String title, String mesage, String type){
        AlertMauricio alert = new AlertMauricio(title, mesage, type, false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new ImgPanel();
        title = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        search = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        back = new javax.swing.JButton();

        setOpaque(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        title.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        title.setForeground(new java.awt.Color(0, 0, 0));
        title.setText("PRODUCCIÓN FINCAS");

        jButton1.setBackground(new java.awt.Color(255, 153, 153));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pdf.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        table.setForeground(new java.awt.Color(0, 0, 0));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cultivo", "Finca", "insumo", "Valor insumo", "Cantidad insumos", "Cantidad Producto", "Total vendido", "Ganancias", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
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
            table.getColumnModel().getColumn(8).setResizable(false);
        }

        search.setBackground(new java.awt.Color(255, 255, 255));
        search.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        search.setForeground(new java.awt.Color(0, 0, 0));
        search.setText("Buscar...");
        search.setCaretColor(new java.awt.Color(0, 0, 0));
        search.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        search.setOpaque(true);
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(10, 214, 61));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setText("Buscar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        back.setBackground(new java.awt.Color(10, 214, 61));
        back.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        back.setForeground(new java.awt.Color(0, 0, 0));
        back.setText("Volver");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(back)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 44, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(title)
                .addGap(258, 258, 258))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(back)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        search.getAccessibleContext().setAccessibleParent(this);

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dowloadPdf("Reportes.pdf", this.allData);
    }//GEN-LAST:event_jButton1ActionPerformed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField search;
    private javax.swing.JTable table;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables

}

