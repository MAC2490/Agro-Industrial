package ModuloSuperAdmin.Fincas;

import Principal.ConsumoAPI;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import ModuloSuperAdmin.PanelFincas;

public class RegisterFarm extends javax.swing.JFrame {
    
    private ConsumoAPI apiConsumption = new ConsumoAPI();
    private String url_img;
    private JsonArray arrayAdmins;
    private String textTitle;
    private String farm_id;
    
    public RegisterFarm(String title,String name, String address, String user, String url_img, String textButton, String farm_id) {
        initComponents();
        this.textTitle = title;
        this.farm_id = farm_id;
        this.setLocationRelativeTo(null);
        String api = apiConsumption.consumoGET("http://localhost/ApiPhp-AgroGestor/Fincas/getAdmins.php");
        JsonObject objectAdmins = JsonParser.parseString(api).getAsJsonObject();
        this.arrayAdmins = objectAdmins.get("admins").getAsJsonArray();
        this.data(title, name, address, user, url_img, textButton);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        farm_name = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        addres = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        show_img = new javax.swing.JLabel();
        register = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        documentLable = new javax.swing.JLabel();
        img_save = new javax.swing.JButton();
        admins = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Registar Finca");
        setAutoRequestFocus(false);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        title.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        title.setForeground(new java.awt.Color(0, 0, 0));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nombre Finca");

        farm_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                farm_nameActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Direccion");

        addres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addresActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Imagen de la finca (Opcional)");

        show_img.setForeground(new java.awt.Color(0, 0, 0));

        register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerActionPerformed(evt);
            }
        });

        cancel.setText("Cancelar");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        documentLable.setForeground(new java.awt.Color(0, 0, 0));
        documentLable.setText("Documento Responsable");

        img_save.setText("Subir imagen");
        img_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                img_saveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(116, 116, 116))
                        .addComponent(jLabel2)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(addres)
                            .addGap(33, 33, 33)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(farm_name, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(documentLable, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(admins, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(img_save, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(show_img, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(register)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img_save)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(show_img, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(farm_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(documentLable)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(admins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(register, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cancel))
                        .addGap(24, 24, 24))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void farm_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_farm_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_farm_nameActionPerformed

    private void addresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addresActionPerformed

    private void img_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_img_saveActionPerformed
        this.img_save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de Imagen", "jpg", "png", "jpeg", "gif");
                fileChooser.setFileFilter(filter);

                int returnValue = fileChooser.showOpenDialog(null);
                
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    url_img = selectedFile.getAbsolutePath();
                }
                
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    String filePath = selectedFile.getAbsolutePath();

                    // Aquí puedes procesar el archivo de imagen seleccionado (por ejemplo, mostrarlo en un JLabel)
                    ImageIcon imageIcon = new ImageIcon(filePath);
                    int widtch = 200;
                    int height = 200;
                    Image newImage = imageIcon.getImage().getScaledInstance(widtch, height, Image.SCALE_SMOOTH);
                    ImageIcon icon = new ImageIcon(newImage);
                    
                    show_img.setIcon(icon);
                    
                    revalidate();
                    repaint();
                }
            }
        });
    }//GEN-LAST:event_img_saveActionPerformed

    private void registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerActionPerformed
        if (this.url_img == null) {
            this.url_img = "/img/finca 1.png";
        }
        String id_user = this.searchIdUser(this.admins.getText());
        if (this.textTitle.equalsIgnoreCase("Registra Finca")) {
            if (id_user != null) {
                Map<String, String> insertData = new HashMap<>();
                insertData.put("name", this.farm_name.getText());
                insertData.put("address", this.addres.getText());
                insertData.put("url_img", this.url_img);
                insertData.put("user", id_user);
                String register = this.apiConsumption.consumoPOST("http://localhost/ApiPhp-AgroGestor/Fincas/InsertFarm.php", insertData);
                System.out.println("Confirmacio: "+register);
                PanelFincas windowFarm = new PanelFincas();
                setVisible(false);
                windowFarm.card();
            }else{
                // Alerta de que el administrador no existe
            }
        }else if(this.textTitle.equalsIgnoreCase("Editar Finca")){
            if (id_user != null) {
                Map<String, String> updateData = new HashMap<>();
                updateData.put("farm_id", this.farm_id);
                updateData.put("name", this.farm_name.getText());
                updateData.put("address", this.addres.getText());
                updateData.put("url_img", this.url_img);
                updateData.put("user", id_user);
                String register = this.apiConsumption.consumoPOST("http://localhost/ApiPhp-AgroGestor/Fincas/Update.php", updateData);
                System.out.println("Confirmacio Editar : "+register);
                PanelFincas windowFarm = new PanelFincas();
                setVisible(false);
                windowFarm.card();
            }else{
                // Alerta de que el administrador no existe
            }
        }
    }//GEN-LAST:event_registerActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        this.farm_name.setText("");
        this.addres.setText("");
        this.url_img = "";
        setVisible(false);
    }//GEN-LAST:event_cancelActionPerformed

    public static void main(String args[]) {
     
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegisterFarm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterFarm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterFarm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterFarm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold
    }
    
    public String searchIdUser(String document){
        String id = null;
        for (int i = 0; i < this.arrayAdmins.size(); i++) {
            JsonObject dataAdmins = this.arrayAdmins.get(i).getAsJsonObject();
            JsonElement document_usuario = dataAdmins.get("cedula");
            if (document.equalsIgnoreCase(document_usuario.getAsString())) {
                JsonElement id_usuario = dataAdmins.get("id_usuario");
                id = id_usuario.getAsString();
                break;
            }
        }
        return id;
    }
    
    public void data(String title,String name, String address, String user, String url_img, String textButton){
        this.title.setText(title);
        this.register.setText(textButton);
        this.farm_name.setText(name);
        this.addres.setText(address);
        this.admins.setText(user);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addres;
    private javax.swing.JTextField admins;
    private javax.swing.JButton cancel;
    private javax.swing.JLabel documentLable;
    private javax.swing.JTextField farm_name;
    private javax.swing.JButton img_save;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton register;
    private javax.swing.JLabel show_img;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
