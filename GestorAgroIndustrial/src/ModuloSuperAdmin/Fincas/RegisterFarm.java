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
import Principal.AlertMauricio;
import java.awt.Color;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class RegisterFarm extends javax.swing.JFrame {
    
    private ConsumoAPI apiConsumption = new ConsumoAPI();
    private String url_img;
    private JsonArray arrayAdmins;
    private String textTitle;
    private String farm_id;
    private String user;
    
    private PanelFincas panelFarm;
    
    public RegisterFarm(String title,String name, String address, String user, String url_img, String textButton, String farm_id, PanelFincas panelFarm) {
        initComponents();
        setIconImage( getToolkit().createImage( ClassLoader.getSystemResource("img/LogoLOGIN.png") ) );
        this.textTitle = title;
        this.panelFarm = panelFarm;
        this.farm_id = farm_id;
        this.panelFarm = panelFarm;
        this.user = user;
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
        admins = new javax.swing.JComboBox<>();

        setTitle("Registar Finca");
        setAutoRequestFocus(false);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(20, 224, 71));

        title.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel2.setText("Nombre Finca");

        farm_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                farm_nameActionPerformed(evt);
            }
        });

        jLabel3.setText("Direccion");

        addres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addresActionPerformed(evt);
            }
        });

        jLabel4.setText("Imagen de la finca (Opcional)");

        register.setBackground(new java.awt.Color(153, 255, 153));
        register.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mas.png"))); // NOI18N
        register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerActionPerformed(evt);
            }
        });

        cancel.setBackground(new java.awt.Color(20, 224, 71));
        cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/atras.png"))); // NOI18N
        cancel.setBorder(null);
        cancel.setFocusable(false);
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        documentLable.setText("Documento Responsable");

        img_save.setBackground(new java.awt.Color(153, 255, 153));
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
                    .addComponent(farm_name, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(documentLable, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(admins, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(img_save, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(show_img, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
                .addGap(10, 10, 10))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(register, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cancel)
                        .addGap(79, 79, 79)
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addComponent(admins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img_save)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(show_img, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(register, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
                    int widtch = 180;
                    int height = 180;
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
        if (this.validatio()) {
            if (this.url_img == null) {
                this.url_img = "/img/finca 1.png";
            }
            
            String id_user = this.searchIdUser(this.admins.getSelectedItem().toString());
            System.out.println("user slected "+ id_user);
            if (id_user != null) { 
                if (this.textTitle.equalsIgnoreCase("Registrar Finca")) {
                    Map<String, String> insertData = new HashMap<>();
                    insertData.put("name", this.farm_name.getText());
                    insertData.put("address", this.addres.getText());
                    insertData.put("url_img", this.url_img);
                    insertData.put("user", id_user);
                    String response = this.apiConsumption.consumoPOST("http://localhost/ApiPhp-AgroGestor/Fincas/InsertFarm.php", insertData);
                    this.validateProcess(response, "register");
                }else if(this.textTitle.equalsIgnoreCase("Editar Finca")) {
                    Map<String, String> updateData = new HashMap<>();
                    updateData.put("farm_id", this.farm_id);
                    updateData.put("name", this.farm_name.getText());
                    updateData.put("address", this.addres.getText());
                    updateData.put("url_img", this.url_img);
                    updateData.put("user", id_user);
                    String response = this.apiConsumption.consumoPOST("http://localhost/ApiPhp-AgroGestor/Fincas/Update.php", updateData);
                    System.out.println("respuesta "+response);
                    this.validateProcess(response, "edit");
                }
            } else {
                this.alert("Error", "El administrador no fue encontrado", "error");
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
        if (document.equalsIgnoreCase("Quitar Responsable") || document.equalsIgnoreCase("No tiene asignado") || document.equalsIgnoreCase("Sin Responsable")) {
            System.out.println("document "+document);
            id = "SA"; // Sin Administrador
        } else{
            for (int i = 0; i < this.arrayAdmins.size(); i++) {
                JsonObject dataAdmins = this.arrayAdmins.get(i).getAsJsonObject();
                JsonElement document_usuario = dataAdmins.get("cedula");
                if (document.equalsIgnoreCase(document_usuario.getAsString())) {
                    JsonElement id_usuario = dataAdmins.get("id_usuario");
                    id = id_usuario.getAsString();
                    break;
                }
            }
        }
        return id;
    }
    
    public boolean validatio(){
        boolean status = true;
        if (this.farm_name.getText().equalsIgnoreCase("") || this.addres.getText().equalsIgnoreCase("") || this.admins.getSelectedItem().toString().equalsIgnoreCase("")) {
            status = false;
            this.alert("Campos vacios", "Todos los campos son obligatorios", "error");
        }
        
        Border border = new LineBorder(Color.RED, 2);
        if (this.farm_name.getText().equalsIgnoreCase("")) {
            this.farm_name.setBorder(border);
        }else{
            status = true;
            this.farm_name.setBorder(null);
        }
        
        if (this.addres.getText().equalsIgnoreCase("")) {
            this.addres.setBorder(border);
        }else{
            status = true;
            this.addres.setBorder(null);
        }
        
        if (this.admins.getSelectedItem().toString().equalsIgnoreCase("")) {
            this.admins.setBorder(border);
        }else{
            status = true;
            this.admins.setBorder(null);
        }
        return status;
    } 
    
    public void searchAdmins(){
        String response = this.apiConsumption.consumoGET("http://localhost/ApiPhp-AgroGestor/Fincas/getUserAdmins.php");
        
        JsonObject objectAdmins = JsonParser.parseString(response).getAsJsonObject();
        JsonArray arrayAdmins = objectAdmins.get("admins").getAsJsonArray();
        
        if (this.textTitle.equals("Editar Finca") && !this.user.equals("No tiene asignado")) {
            this.admins.addItem("Quitar Responsable");
        }else if(this.textTitle.equals("Registrar Finca")){
            this.admins.addItem("Sin Responsable");
        }
        if (arrayAdmins.size() != 0) {
            for (int i = 0; i < arrayAdmins.size(); i++) {
                JsonObject objectDocumen = arrayAdmins.get(i).getAsJsonObject();
                JsonElement document = objectDocumen.get("cedula");
                this.admins.addItem(document.getAsString());
            }
        }else if (this.textTitle.equals("Registrar Finca")){
            this.admins.addItem("Sin respuesta");
            this.admins.setSelectedItem("Sin respuesta");
        }  
    }
    
    public void alert(String title, String mesage, String type){
        AlertMauricio alert = new AlertMauricio(title, mesage, type, false);
    }
    
    public void validateProcess(String response, String type){
        System.out.println("response "+ response + " type "+ type);
        if (type.equals("register")) {
            if (response.equals("100")) {
                System.out.println("01");
                this.panelFarm.card(true);
                this.alert("Registro", "La finca se registro correctamente", "success");
                setVisible(false);
            }else if(response.equalsIgnoreCase("500")){
                this.alert("Error", "No se pudo registrar la finca", "error");
            }else if(response.equalsIgnoreCase("300")){
                this.alert("Error", "El servido fallo", "error");
            }else if(response.equalsIgnoreCase("404")){
                this.alert("Error", "Los datos estan vacios", "error");
            }
        } else {
            if (response.equalsIgnoreCase("100")) {
                this.panelFarm.card(true);
                this.alert("Registro", "La finca se edito correctamente", "success");
                setVisible(false);
            }else if(response.equalsIgnoreCase("500")){
                this.alert("Error", "No se pudo registrar la finca", "error");
            }else if(response.equalsIgnoreCase("300")){
                this.alert("Error", "El servido fallo", "error");
            }else if(response.equalsIgnoreCase("404")){
                this.alert("Error", "Los datos estan vacios", "error");
            }    
        }
    }
    
    public void data(String title,String name, String address, String user, String url_img, String textButton){
        this.title.setText(title);
        this.register.setText(textButton);
        this.farm_name.setText(name);
        this.addres.setText(address);
        
        if (!user.isEmpty()) {
            admins.addItem(user);
        }
        this.admins.setSelectedItem(user);
        ImageIcon img = new ImageIcon();
        String url = "";
        if ("/img/finca 1.png".equals(url_img)) {
            img = new ImageIcon(getClass().getResource("/img/finca 1.png"));
        }else{
            img = new ImageIcon(url_img);
        }
        
        int widtch = 180;
        int height = 180;
        Image newImage = img.getImage().getScaledInstance(widtch, height, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(newImage);
        this.show_img.setIcon(icon);
        this.searchAdmins();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addres;
    private javax.swing.JComboBox<String> admins;
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