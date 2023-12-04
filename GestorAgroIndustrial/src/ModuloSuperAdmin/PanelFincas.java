package ModuloSuperAdmin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
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
import Principal.AlertMauricio;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.border.MatteBorder;
import ModuloSuperAdmin.Fincas.Details;

public class PanelFincas extends javax.swing.JPanel {
    
    private ConsumoAPI apiConsumption = new ConsumoAPI();
    private boolean firstClick = true;
    
    public PanelFincas() {
        initAleterComponents();
    }
    public void initAleterComponents(){
        initComponents();
        this.back.setVisible(false);
        MatteBorder bottomBorder = new MatteBorder(0, 0, 1, 0, Color.GREEN);
        this.search.setBorder(bottomBorder);
        this.card(true);
        this.cleanSearch();
    }
    public void card(boolean typeList){
        try {
            String response = "";
            if (typeList) {
                this.back.setVisible(false);
                response = this.apiConsumption.consumoGET("http://localhost/ApiPhp-AgroGestor/Fincas/getFarm.php");
            }else{
                Map<String, String> searchFarm = new HashMap<>();
                searchFarm.put("farmName", this.search.getText());
                response = this.apiConsumption.consumoPOST("http://localhost/ApiPhp-AgroGestor/Fincas/getSearch.php", searchFarm);
                this.back.setVisible(true);
            }
            this.panel_farm.removeAll();
            this.panel_farm.revalidate();
            this.panel_farm.repaint();
            
            JsonObject objetListFarm = JsonParser.parseString(response).getAsJsonObject();
            JsonArray arrayListFarm = objetListFarm.get("list_farm").getAsJsonArray();
            if (arrayListFarm.size() == 0 && !typeList) {
                this.back.setVisible(false);
                this.alert("Busqueda fallida", "No se pudo encontrar la busqueda", "error");
            }
            if (arrayListFarm.size() == 0) {
                this.card(true);
                this.firstClick = true;
                this.search.setText("Buscar...");
            }
            System.out.println("tamaño "+arrayListFarm.size());
            
            int sizeArray = arrayListFarm.size();
            int halfArray = 0;
            if (sizeArray % 3 == 0) {
                halfArray = (sizeArray/3);
            } else{
                halfArray = (sizeArray/3)+1;
            }
            System.out.println("mitad "+halfArray);
            this.totalFarms.setText("Numero total de fincas: "+sizeArray);
            LayoutManager layoutManager = this.panel_farm.getLayout();
            if (layoutManager instanceof GridLayout) {
                GridLayout gridLayout = (GridLayout) layoutManager;
                gridLayout.setRows(halfArray); // Establece el nuevo número de filas (por ejemplo, 3 filas)
                gridLayout.setColumns(3);
                this.panel_farm.revalidate();
            }
            System.out.println("tamaño "+arrayListFarm);
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

                JPanel textPanel = new JPanel(new GridBagLayout());
                GridBagConstraints restriction = new GridBagConstraints();
                // textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));

                JLabel nameLabel = new JLabel("Nombre finca: "+farm_name.getAsString());
                nameLabel.setBorder(new EmptyBorder(10, 70, 0, 0));
                restriction.gridx = 0;
                restriction.gridy = 0;
                restriction.gridheight = 1;
                restriction.gridwidth = 4;
                restriction.weighty = 2;
                restriction.weightx = 100;
                restriction.fill = GridBagConstraints.BOTH;
                textPanel.add(nameLabel, restriction);

                JLabel addressLabel = new JLabel("Direccion: "+address.getAsString());
                addressLabel.setBorder(new EmptyBorder(10, 0, 5, 0));
                restriction.gridx = 0;
                restriction.gridy = 1;
                textPanel.add(addressLabel, restriction);
                
                JLabel userLabel = new JLabel();
                userLabel.setBorder(new EmptyBorder(10, 0, 10, 0));
                restriction.gridx = 0;
                restriction.gridy = 2;
                textPanel.add(userLabel, restriction);
                
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
                btn.setBackground(new Color(20,224,71));
                btn.setPreferredSize(new Dimension(118, btn.getPreferredSize().height));
                btn.setMaximumSize(new Dimension(118,btn.getPreferredSize().height));
                
                JButton btnMore = new JButton("DETALLES");
                btnMore.setFocusable(true);
                btnMore.setBackground(new Color(153,255,204));
                btnMore.setPreferredSize(new Dimension(118, btn.getPreferredSize().height));
                btnMore.setMaximumSize(new Dimension(118,btn.getPreferredSize().height));
                
                JPanel buttonPanel = new JPanel();
                buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
                restriction.gridx = 0;
                restriction.gridy = 3;
                buttonPanel.add(btn);
                buttonPanel.add(btnMore);

                textPanel.add(buttonPanel, restriction);
                    
                cardPanel.add(textPanel, BorderLayout.SOUTH);
                final PanelFincas fincas=this;
                final String imgUrl = url;
                PanelFincas panelFarms = this;
                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String adminDocument = "";
                        if (user_name.isJsonNull()) {
                            adminDocument = "No tiene asignado";
                        }else{
                            adminDocument = user_document.getAsString();
                        }
                        RegisterFarm registerWindow = new RegisterFarm("Editar Finca",farm_name.getAsString(),address.getAsString(), adminDocument,imgUrl, "Editar", farm_id.getAsString(), panelFarms);
                        registerWindow.setVisible(true);
                    }
                });
                
                btnMore.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Details window = new Details(farm_id.getAsString(), farm_name.getAsString());
                        window.setVisible(true);
                    }
                });
                
                this.panel_farm.add(cardPanel);
            }
            
            for (int i = 0; (sizeArray%3!=0) && i<3-(sizeArray%3); i++) {
                this.panel_farm.add(new JLabel());
            }
            
            this.panel_farm.revalidate();
            this.panel_farm.repaint();
        } catch (Exception e) {
            System.out.println("error "+e);
            this.alert("ERROR", "Algo salio mal en el servidor", "error");
        }
    }
    
    public void alert(String title, String mesage, String type){
        AlertMauricio alert = new AlertMauricio(title, mesage, type, false);
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
        back = new javax.swing.JButton();

        setBackground(new java.awt.Color(222, 222, 222));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setAlignmentY(5.0F);

        panel_farm.setLayout(new java.awt.GridLayout(1, 3));
        jScrollPane1.setViewportView(panel_farm);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("FINCAS");

        jButton1.setBackground(new java.awt.Color(20, 224, 71));
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
        search.setText("Buscar...");
        search.setActionCommand("<Not Set>");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(20, 224, 71));
        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        back.setBackground(new java.awt.Color(20, 224, 71));
        back.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        back.setForeground(new java.awt.Color(0, 0, 0));
        back.setText("Volver");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
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
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(back)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(190, 190, 190)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(totalFarms, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(search)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(back))))
                        .addGap(9, 9, 9))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 36, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        search.getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        this.card(true);
        this.search.setText("Buscar...");
        this.firstClick = true;
    }//GEN-LAST:event_backActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (this.search.getText().equals("") || this.search.getText().equals("Buscar...")) {
            this.alert("Error", "La busqueda esta vacia", "error");
            this.card(true);
        }else{
            this.card(false);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed

    }//GEN-LAST:event_searchActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        RegisterFarm registerWindow = new RegisterFarm("Registrar Finca","","","","", "Registrar", "", this);
        registerWindow.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel_farm;
    private javax.swing.JTextField search;
    private javax.swing.JLabel totalFarms;
    // End of variables declaration//GEN-END:variables
}
