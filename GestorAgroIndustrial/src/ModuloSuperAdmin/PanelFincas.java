package ModuloSuperAdmin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Principal.ConsumoAPI;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import ModuloSuperAdmin.Fincas.RegisterFarm;
import Principal.Alert;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.border.MatteBorder;

public class PanelFincas extends javax.swing.JPanel {
    
    private ConsumoAPI apiConsumption = new ConsumoAPI();
    private boolean firstClick = true;
    
    public PanelFincas() {
        initAleterComponents();
    }
    public void initAleterComponents(){
        initComponents();
        MatteBorder bottomBorder = new MatteBorder(0, 0, 1, 0, Color.GREEN);
        this.search.setBorder(bottomBorder);
        this.card(true);
        this.cleanSearch();
    }
    public void card(boolean typeList){
        try {
            String response = "";
            if (typeList) {
                response = this.apiConsumption.consumoGET("http://localhost/ApiPhp-AgroGestor/Fincas/getFarm.php");
            }else{
                Map<String, String> searchFarm = new HashMap<>();
                searchFarm.put("farmName", this.search.getText());
                response = this.apiConsumption.consumoPOST("http://localhost/ApiPhp-AgroGestor/Fincas/getSearch.php", searchFarm);
            }
            this.panel_farm.removeAll();
            this.panel_farm.revalidate();
            this.panel_farm.repaint();
            
            JsonObject objetListFarm = JsonParser.parseString(response).getAsJsonObject();
            JsonArray arrayListFarm = objetListFarm.get("list_farm").getAsJsonArray();
            
            if (arrayListFarm.size() == 0) {
                this.card(true);
                this.firstClick = true;
                this.search.setText("Buscar...");
                this.alert("Error :(", "No pudimos encontrar tu busqueda", "warning");
            }
            System.out.println("tamaño "+arrayListFarm.size());
            
            int sizeArray = arrayListFarm.size();
            int halfArray = 0;
            if (sizeArray % 2 == 0) {
                halfArray = (sizeArray/2)-1;
            } else if(sizeArray % 2 != 0){
                halfArray = (sizeArray/2);
            }
            System.out.println("mitad "+halfArray);
            this.totalFarms.setText("Numero total de fincas: "+sizeArray);
            LayoutManager layoutManager = this.panel_farm.getLayout();
            if (layoutManager instanceof GridLayout) {
                GridLayout gridLayout = (GridLayout) layoutManager;
                gridLayout.setRows(halfArray); // Establece el nuevo número de filas (por ejemplo, 3 filas)
                this.panel_farm.revalidate();
            }
            System.out.println("tamaño "+arrayListFarm.size());
            for (int i = 0; i < arrayListFarm.size(); i++) {
                JsonObject dataFarms = arrayListFarm.get(i).getAsJsonObject();
                JsonElement farm_id = dataFarms.get("id_finca");
                JsonElement farm_name = dataFarms.get("nombre");
                JsonElement user_name = dataFarms.get("user_name");
                JsonElement user_document = dataFarms.get("document");
                JsonElement address = dataFarms.get("direccion");
                JsonElement url_img = dataFarms.get("img");
                
                JPanel cardPanel = new JPanel();
                cardPanel.setLayout(new BorderLayout());
                cardPanel.setBorder(new EmptyBorder(3, 4, 30, 1));
                
                ImageIcon img = new ImageIcon();
                String url = "";
                if (url_img.isJsonNull() || "/img/finca 1.png".equals(url_img.getAsString())) {
                    img = new ImageIcon(getClass().getResource("/img/finca 1.png"));
                    url = "/img/finca 1.png";
                }else{
                    img = new ImageIcon(url_img.getAsString());
                    url = url_img.getAsString();
                }
                
                int widtch = 250;
                int height = 150;

                Image newImage = img.getImage().getScaledInstance(widtch, height, Image.SCALE_SMOOTH);

                ImageIcon icon = new ImageIcon(newImage);

                JLabel imgLabel = new JLabel(icon);
                cardPanel.add(imgLabel, BorderLayout.WEST);

                JPanel textPanel = new JPanel();
                textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));

                JLabel nameLabel = new JLabel("Nombre finca: "+farm_name.getAsString());
                nameLabel.setBorder(new EmptyBorder(10, 70, 0, 0));
                textPanel.add(nameLabel);


                JLabel addressLabel = new JLabel("Direccion: "+address.getAsString());
                addressLabel.setBorder(new EmptyBorder(10, 0, 5, 0));
                textPanel.add(addressLabel);
                
                JLabel userLabel = new JLabel();
                userLabel.setBorder(new EmptyBorder(10, 0, 10, 0));
                textPanel.add(userLabel);
                
                String nameAdmin = "";
                if (user_name.isJsonNull()) {
                    nameAdmin = "No tiene asignado";
                    String adminText = "<html><font color='black'>Administrador: </font><font color='green'><b>"+nameAdmin+"</b></font></html>";
                    userLabel.setText(adminText);
                }else{
                    nameAdmin = user_name.getAsString();
                    String adminText = "<html><font color='black'>Administrador: </font><font color='black'>"+nameAdmin+"</font></html>";
                    userLabel.setText(adminText);
                }
                
                JButton btn = new JButton("EDITAR");
                btn.setFocusable(true);
                btn.setBackground(Color.GREEN);
                btn.setPreferredSize(new Dimension(250, btn.getPreferredSize().height));
                btn.setMaximumSize(new Dimension(250,btn.getPreferredSize().height));
                textPanel.add(btn);

                cardPanel.add(textPanel, BorderLayout.SOUTH);
                final String imgUrl = url;
                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String adminDocument = "";
                        if (user_name.isJsonNull()) {
                            adminDocument = "No tiene asignado";
                        }else{
                            adminDocument = user_document.getAsString();
                        }
                        RegisterFarm registerWindow = new RegisterFarm("Editar Finca",farm_name.getAsString(),address.getAsString(), adminDocument,imgUrl, "Editar", farm_id.getAsString());
                        registerWindow.setVisible(true);
                    }
                });
                this.panel_farm.add(cardPanel);
            }
            this.panel_farm.revalidate();
            this.panel_farm.repaint();
        } catch (Exception e) {
            System.out.println("error "+e);
            this.alert("ERROR", "Algo salio mal en el servidor", "error");
        }
    }
    
    public void alert(String title, String mesage, String type){
        Alert alert = new Alert(title, mesage, type);
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        panel_farm = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        totalFarms = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setAlignmentY(5.0F);

        panel_farm.setLayout(new java.awt.GridLayout(1, 3));
        jScrollPane1.setViewportView(panel_farm);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("FINCAS");

        jButton1.setBackground(new java.awt.Color(153, 255, 51));
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mas.png"))); // NOI18N
        jButton1.setText("Registrar Finca");
        jButton1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        totalFarms.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        search.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        search.setForeground(new java.awt.Color(0, 0, 0));
        search.setText("Buscar...");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(153, 255, 51));
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalFarms, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addGap(66, 66, 66)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 261, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(17, 17, 17))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(totalFarms, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(search)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(9, 9, 9)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        RegisterFarm registerWindow = new RegisterFarm("Registrar Finca","","","","", "Registrar", "");
        registerWindow.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        
    }//GEN-LAST:event_searchActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (this.search.getText().equals("") || this.search.getText().equals("Buscar...")) {
            this.alert("Error", "La busqueda esta vacia", "error");
            this.card(true);
        }else{
            this.card(false);
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel_farm;
    private javax.swing.JTextField search;
    private javax.swing.JLabel totalFarms;
    // End of variables declaration//GEN-END:variables
}
