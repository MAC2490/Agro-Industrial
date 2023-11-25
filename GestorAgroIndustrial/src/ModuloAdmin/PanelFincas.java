package ModuloAdmin;

import Principal.ConsumoAPI;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import javax.swing.JLabel;

public class PanelFincas extends javax.swing.JPanel {

    private ConsumoAPI consumoAPI;

    public PanelFincas() {
        initComponents();
        consumoAPI = new ConsumoAPI();
        datosFinca();
    }

    public void datosFinca() {
        String url = "http://localhost/ApiPhp-AgroGestor/Fincas/getFarm.php";

        ConsumoAPI api = new ConsumoAPI();

        String jsonData = api.consumoGET(url);

        Gson gson = new Gson();

        JsonObject jsonObject = gson.fromJson(jsonData, JsonObject.class);

        JsonArray list_farmArray = jsonObject.getAsJsonArray("list_farm");

        for (int i = 0; i < list_farmArray.size(); i++) {
            JsonObject objeto = list_farmArray.get(i).getAsJsonObject();
            JsonElement Id = objeto.get("id_finca");
            JsonElement nombre = objeto.get("nombre");
            JsonElement direccion = objeto.get("direccion");
            JsonElement usuario = objeto.get("id_usuario");

            JLabel idLabel = new JLabel("ID: " + Id.getAsString());
            JLabel nombreLabel = new JLabel("Nombre: " + nombre.getAsString());
            JLabel direccionLabel = new JLabel("Dirección: " + direccion.getAsString());

            System.out.println("id:" + Id);
            System.out.println("nombre:" + nombre);
            System.out.println("direccion:" + direccion);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new javax.swing.JPanel();

        setBackground(new java.awt.Color(0, 204, 0));

        header.setBackground(new java.awt.Color(204, 255, 255));

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 643, Short.MAX_VALUE)
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 119, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 322, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel header;
    // End of variables declaration//GEN-END:variables
}
