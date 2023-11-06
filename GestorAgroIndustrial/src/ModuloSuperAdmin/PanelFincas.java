
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
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelFincas extends javax.swing.JPanel {
    
    private ConsumoAPI apiConsumption = new ConsumoAPI();
    
    public PanelFincas() {
        initComponents();
        this.card();
    }
    
    public void card(){
        String farms = this.apiConsumption.consumoGET("http://localhost/ApiPhp-AgroGestor/Fincas/getFarm.php");
        JsonObject objetListFarm = JsonParser.parseString(farms).getAsJsonObject();
        JsonArray arrayListFarm = objetListFarm.get("list_farm").getAsJsonArray();
        
        int sizeArray = arrayListFarm.size();
        int halfArray = 0;
        if (sizeArray % 2 == 0) {
            halfArray = (sizeArray/2)-1;
        } else if(sizeArray % 2 != 0){
            halfArray = (sizeArray/2);
        }
        this.totalFarms.setText("Numero total de fincas: "+sizeArray);
        System.out.println("numero filas "+ halfArray);
        LayoutManager layoutManager = this.panel_farm.getLayout();
        if (layoutManager instanceof GridLayout) {
            GridLayout gridLayout = (GridLayout) layoutManager;
            gridLayout.setRows(halfArray); // Establece el nuevo número de filas (por ejemplo, 3 filas)
            this.panel_farm.revalidate();
        }
        
        for (int i = 0; i < arrayListFarm.size(); i++) {
            JsonObject dataFarms = arrayListFarm.get(i).getAsJsonObject();
            
            JsonElement farm_id = dataFarms.get("id_finca");
            JsonElement farm_name = dataFarms.get("nombre");
            JsonElement user_name = dataFarms.get("user_name");
            JsonElement user_document = dataFarms.get("document");
            JsonElement address = dataFarms.get("direccion");
            JsonElement url_img = dataFarms.get("img");
            System.out.println("nombre "+ url_img);
            
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
            cardPanel.add(imgLabel, BorderLayout.NORTH);
            
            JPanel textPanel = new JPanel();
            textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));

            
            JLabel nameLabel = new JLabel("Nombre finca: "+farm_name.getAsString());
            nameLabel.setBorder(new EmptyBorder(10, 70, 0, 0));
            textPanel.add(nameLabel);

            
            JLabel addressLabel = new JLabel("Direccion: "+address.getAsString());
            addressLabel.setBorder(new EmptyBorder(10, 0, 5, 0));
            textPanel.add(addressLabel);
            
            JLabel userLabel = new JLabel("Administrador: "+user_name.getAsString());
            userLabel.setBorder(new EmptyBorder(10, 0, 10, 0));
            textPanel.add(userLabel);
            
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
                    RegisterFarm registerWindow = new RegisterFarm("Editar Finca",farm_name.getAsString(),address.getAsString(),user_document.getAsString(),imgUrl, "Editar", farm_id.getAsString());
                    registerWindow.setVisible(true);
                }
            });
            this.panel_farm.add(cardPanel);
        }
        this.panel_farm.revalidate();
        this.panel_farm.repaint();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        panel_farm = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        totalFarms = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setAlignmentY(5.0F);

        panel_farm.setLayout(new java.awt.GridLayout(1, 3));
        jScrollPane1.setViewportView(panel_farm);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("FINCAS");

        jButton1.setBackground(new java.awt.Color(102, 255, 102));
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Registrar Finca");
        jButton1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        totalFarms.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(totalFarms, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(133, 133, 133)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 279, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(totalFarms, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        RegisterFarm registerWindow = new RegisterFarm("Registra Finca","","","","", "Registrar", "");
        registerWindow.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel_farm;
    private javax.swing.JLabel totalFarms;
    // End of variables declaration//GEN-END:variables
}
