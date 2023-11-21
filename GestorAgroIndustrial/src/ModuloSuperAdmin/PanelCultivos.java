package ModuloSuperAdmin;

import javax.swing.JDialog;
import Principal.ConsumoAPI;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class PanelCultivos extends javax.swing.JPanel {

    private ConsumoAPI consumoAPI;
    private FormInsert formulario;
    //private JButton editar = new JButton();

    public PanelCultivos() {
        consumoAPI = new ConsumoAPI();
        initComponents();
        mostrarCultivos();
        formulario = new FormInsert(); // Inicializa el formulario
    }

    public void mostrarCultivos() {
        // URL de la API para obtener los datos de los cultivos
        String apiUrl = "http://localhost/ApiPhp-AgroGestor/cultivos/Obtener.php";

        //solicitud GET a la API
        ConsumoAPI api = new ConsumoAPI();
        String jsonData = api.consumoGET(apiUrl);

        // objeto Gson para procesar el JSON
        Gson gson = new Gson();

        // Convertir el JSON en un JsonObject
        JsonObject jsonObject = gson.fromJson(jsonData, JsonObject.class
        );

        // Obtener la matriz "registros"
        JsonArray registrosArray = jsonObject.getAsJsonArray("registros");

        //se ajusta al tamaño disponible del jpanel
        contenedor1.setLayout(new BoxLayout(contenedor1, BoxLayout.Y_AXIS));
        //3 columnas, filas automaticas
        contenedor1.setLayout(new GridLayout(0, 3));
        //color perzonalido
        Color colorPersonalizado = new Color(255, 255, 255);

        // Recorrer la matriz de registros
        for (int i = 0; i < registrosArray.size(); i++) {
            JsonObject objeto = registrosArray.get(i).getAsJsonObject();
            JsonElement id = objeto.get("id_cultivo");
            JsonElement nombre = objeto.get("nombre");
            JsonElement descripcion = objeto.get("descripcion");
            JsonElement tiempoCosecha = objeto.get("tiempo_cosecha");
            JsonElement estado = objeto.get("estado");

            //button editar
            JButton editar = new JButton("Editar");
            
            
            Color ColorBtnEditar = Color.decode("#4BC8FF");
            editar.setBackground(ColorBtnEditar);

            //evento
            editar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    // Obtén los valores de nombre, descripción, tiempoCosecha y estado correspondientes a esta tarjeta
                    String nombreEditar = nombre.getAsString();
                    String descripcionEditar = descripcion.getAsString();
                    String tiempoCosechaEditar = tiempoCosecha.getAsString();
                    String estadoEditar = estado.getAsString();

                    formulario.setDatos(id.getAsString(), nombreEditar, descripcionEditar, tiempoCosechaEditar, estadoEditar);
                    abrirFormulario(formulario);
                }
            });

            JPanel cardPanel = new JPanel();

            cardPanel.setLayout(new BoxLayout(cardPanel, BoxLayout.Y_AXIS));
            //cardPanel.setBackground(Color.WHITE);
            cardPanel.setBackground(colorPersonalizado);
            cardPanel.setBorder(new EmptyBorder(3, 4, 30, 1));
            //borde
            cardPanel.setBorder(new LineBorder(Color.BLACK, 1));

            // Agrega etiquetas y campos de texto a cardPanel para mostrar los datos
            JLabel nombreLabel = new JLabel("Nombre: " + nombre.getAsString());
            JLabel descripcionLabel = new JLabel("Descripción: " + descripcion.getAsString());
            JLabel tiempoCosechaLabel = new JLabel("Tiempo de Cosecha: " + tiempoCosecha.getAsString());
            JLabel estadoLabel = new JLabel("Estado: " + estado.getAsString());

            //padding
            int padding = 10; // Puedes ajustar el valor según tus preferencias
            nombreLabel.setBorder(new EmptyBorder(padding, padding, padding, padding));
            descripcionLabel.setBorder(new EmptyBorder(padding, padding, padding, padding));
            tiempoCosechaLabel.setBorder(new EmptyBorder(padding, padding, padding, padding));
            estadoLabel.setBorder(new EmptyBorder(padding, padding, padding, padding));

            // Agrega las etiquetas al cardPanel
            cardPanel.add(nombreLabel);
            cardPanel.add(descripcionLabel);
            cardPanel.add(tiempoCosechaLabel);
            cardPanel.add(estadoLabel);

            // Agrega cardPanel al formulario principal
            contenedor1.add(cardPanel);
            cardPanel.add(editar);
        }
    }

    private void abrirFormulario(FormInsert formulario) {

        formulario.setLocationRelativeTo(null);

        formulario.setVisible(true);
        formulario.addWindowListener(new WindowAdapter() {

        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        registrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        contenedor1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));

        registrar.setBackground(new java.awt.Color(153, 255, 51));
        registrar.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        registrar.setForeground(new java.awt.Color(51, 51, 51));
        registrar.setText("REGISTRAR CULTIVO");
        registrar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        registrar.setFocusable(false);
        registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarActionPerformed(evt);
            }
        });

        contenedor1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout contenedor1Layout = new javax.swing.GroupLayout(contenedor1);
        contenedor1.setLayout(contenedor1Layout);
        contenedor1Layout.setHorizontalGroup(
            contenedor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 664, Short.MAX_VALUE)
        );
        contenedor1Layout.setVerticalGroup(
            contenedor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 355, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(contenedor1);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("GESTION DE CULTIVOS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarActionPerformed
        this.formulario.setDatos("", "", "", "", "");
        this.abrirFormulario(formulario);
    }//GEN-LAST:event_registrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contenedor1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton registrar;
    // End of variables declaration//GEN-END:variables
}
