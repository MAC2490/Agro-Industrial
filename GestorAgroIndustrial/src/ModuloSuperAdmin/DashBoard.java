
package ModuloSuperAdmin;

import Principal.ConsumoAPI;
import Principal.Login;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Map;


public class DashBoard extends javax.swing.JFrame {

    ConsumoAPI ejemplo = new ConsumoAPI();
    Gson gson = new Gson();
    
    Login ventanaLogin;
    String SesionUsuario;
    
    public DashBoard(Login ventanaLogin, String DatosUsuario) {
        this.ventanaLogin=ventanaLogin;
        this.SesionUsuario=DatosUsuario;
        
        initComponents();
        initAlternComponents();
    }

    public void initAlternComponents(){
        System.out.println("Iniciando el DashBoard SuperAdmin");
        setLocationRelativeTo(null);
        setIconImage( getToolkit().createImage( ClassLoader.getSystemResource("img/LogoLOGIN.png") ) );
        
        JsonObject jsonObject = gson.fromJson(SesionUsuario, JsonObject.class);
        String nombreUsuario = jsonObject.get("nombre").getAsString();
        SessionUsuario.setText(nombreUsuario);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelHeaderB = new javax.swing.JPanel();
        LogoGestor = new javax.swing.JLabel();
        etqGestor = new javax.swing.JLabel();
        etqAgroIndustrial = new javax.swing.JLabel();
        SessionUsuario = new javax.swing.JLabel();
        panelSideBar = new javax.swing.JPanel();
        btnAdministradores = new javax.swing.JButton();
        btnFincas = new javax.swing.JButton();
        btnPerfil = new javax.swing.JButton();
        separador = new javax.swing.JSeparator();
        btnCultivos = new javax.swing.JButton();
        btnInsumos = new javax.swing.JButton();
        btnRegistros = new javax.swing.JButton();
        btnCerrarSession = new javax.swing.JButton();
        PanelFooter = new javax.swing.JPanel();
        etqDevelopers = new javax.swing.JLabel();
        PanelHeaderA = new javax.swing.JPanel();
        etqDashBoard = new javax.swing.JLabel();
        etqRol = new javax.swing.JLabel();
        PanelPrincipal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DashBoard SuperAdmin - Gestor AgroIndustrial");
        setResizable(false);

        PanelHeaderB.setBackground(new java.awt.Color(0, 0, 0));

        LogoGestor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LogoDashboard.png"))); // NOI18N

        etqGestor.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        etqGestor.setForeground(new java.awt.Color(255, 255, 255));
        etqGestor.setText("GESTOR");

        etqAgroIndustrial.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        etqAgroIndustrial.setForeground(new java.awt.Color(255, 255, 255));
        etqAgroIndustrial.setText("AGRO-INDUSTRIAL");

        SessionUsuario.setBackground(new java.awt.Color(255, 255, 255));
        SessionUsuario.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        SessionUsuario.setForeground(new java.awt.Color(255, 255, 255));
        SessionUsuario.setText("Usuario");

        javax.swing.GroupLayout PanelHeaderBLayout = new javax.swing.GroupLayout(PanelHeaderB);
        PanelHeaderB.setLayout(PanelHeaderBLayout);
        PanelHeaderBLayout.setHorizontalGroup(
            PanelHeaderBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelHeaderBLayout.createSequentialGroup()
                .addGroup(PanelHeaderBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelHeaderBLayout.createSequentialGroup()
                        .addContainerGap(477, Short.MAX_VALUE)
                        .addComponent(etqAgroIndustrial))
                    .addGroup(PanelHeaderBLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(SessionUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(etqGestor)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LogoGestor)
                .addGap(43, 43, 43))
        );
        PanelHeaderBLayout.setVerticalGroup(
            PanelHeaderBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LogoGestor, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
            .addGroup(PanelHeaderBLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(PanelHeaderBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etqGestor)
                    .addComponent(SessionUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etqAgroIndustrial)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelSideBar.setBackground(new java.awt.Color(20, 224, 71));

        btnAdministradores.setBackground(new java.awt.Color(10, 214, 61));
        btnAdministradores.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        btnAdministradores.setText("ADMINISTRADORES");
        btnAdministradores.setBorderPainted(false);
        btnAdministradores.setFocusable(false);
        btnAdministradores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdministradoresActionPerformed(evt);
            }
        });

        btnFincas.setBackground(new java.awt.Color(10, 214, 61));
        btnFincas.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        btnFincas.setText("FINCAS");
        btnFincas.setBorderPainted(false);
        btnFincas.setFocusable(false);
        btnFincas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFincasActionPerformed(evt);
            }
        });

        btnPerfil.setBackground(new java.awt.Color(20, 224, 71));
        btnPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ProfileButton.png"))); // NOI18N
        btnPerfil.setBorderPainted(false);
        btnPerfil.setFocusable(false);

        separador.setBackground(new java.awt.Color(50, 50, 50));
        separador.setForeground(new java.awt.Color(50, 50, 50));

        btnCultivos.setBackground(new java.awt.Color(10, 214, 61));
        btnCultivos.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        btnCultivos.setText("CULTIVOS");
        btnCultivos.setBorderPainted(false);
        btnCultivos.setFocusable(false);
        btnCultivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCultivosActionPerformed(evt);
            }
        });

        btnInsumos.setBackground(new java.awt.Color(10, 214, 61));
        btnInsumos.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        btnInsumos.setText("INSUMOS");
        btnInsumos.setBorderPainted(false);
        btnInsumos.setFocusable(false);
        btnInsumos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsumosActionPerformed(evt);
            }
        });

        btnRegistros.setBackground(new java.awt.Color(10, 214, 61));
        btnRegistros.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        btnRegistros.setText("REGISTROS");
        btnRegistros.setBorderPainted(false);
        btnRegistros.setFocusable(false);

        btnCerrarSession.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        btnCerrarSession.setText("CERRAR SESSION");
        btnCerrarSession.setBorderPainted(false);
        btnCerrarSession.setFocusable(false);
        btnCerrarSession.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSessionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSideBarLayout = new javax.swing.GroupLayout(panelSideBar);
        panelSideBar.setLayout(panelSideBarLayout);
        panelSideBarLayout.setHorizontalGroup(
            panelSideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAdministradores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnFincas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSideBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(separador)
                .addContainerGap())
            .addComponent(btnCultivos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnInsumos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnRegistros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnCerrarSession, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelSideBarLayout.setVerticalGroup(
            panelSideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSideBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPerfil)
                .addGap(5, 5, 5)
                .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdministradores, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFincas, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCultivos, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnInsumos, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCerrarSession, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelFooter.setBackground(new java.awt.Color(0, 0, 0));
        PanelFooter.setPreferredSize(new java.awt.Dimension(430, 40));

        etqDevelopers.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        etqDevelopers.setForeground(new java.awt.Color(255, 255, 255));
        etqDevelopers.setText("Desarrollado Por AdsoDev's");

        javax.swing.GroupLayout PanelFooterLayout = new javax.swing.GroupLayout(PanelFooter);
        PanelFooter.setLayout(PanelFooterLayout);
        PanelFooterLayout.setHorizontalGroup(
            PanelFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelFooterLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(etqDevelopers)
                .addContainerGap())
        );
        PanelFooterLayout.setVerticalGroup(
            PanelFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelFooterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etqDevelopers, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        PanelHeaderA.setBackground(new java.awt.Color(0, 0, 0));

        etqDashBoard.setFont(new java.awt.Font("Tw Cen MT", 0, 36)); // NOI18N
        etqDashBoard.setForeground(new java.awt.Color(20, 224, 71));
        etqDashBoard.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etqDashBoard.setText("DASHBOARD");

        etqRol.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        etqRol.setForeground(new java.awt.Color(20, 224, 71));
        etqRol.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etqRol.setText("SuperAdmin");

        javax.swing.GroupLayout PanelHeaderALayout = new javax.swing.GroupLayout(PanelHeaderA);
        PanelHeaderA.setLayout(PanelHeaderALayout);
        PanelHeaderALayout.setHorizontalGroup(
            PanelHeaderALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(etqDashBoard, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
            .addComponent(etqRol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelHeaderALayout.setVerticalGroup(
            PanelHeaderALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHeaderALayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etqDashBoard)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etqRol)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        PanelPrincipal.setBackground(new java.awt.Color(222, 222, 222));

        javax.swing.GroupLayout PanelPrincipalLayout = new javax.swing.GroupLayout(PanelPrincipal);
        PanelPrincipal.setLayout(PanelPrincipalLayout);
        PanelPrincipalLayout.setHorizontalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PanelPrincipalLayout.setVerticalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PanelHeaderA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelSideBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelFooter, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                    .addComponent(PanelHeaderB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PanelHeaderB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelHeaderA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PanelFooter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelSideBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdministradoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdministradoresActionPerformed
        PanelPrincipal.removeAll();
        
        PanelUsuarios temporal = new PanelUsuarios();
        temporal.setSize(PanelPrincipal.getSize());
        temporal.setPreferredSize(PanelPrincipal.getPreferredSize());
        PanelPrincipal.add(temporal);
        repaint();
        revalidate();
       
    }//GEN-LAST:event_btnAdministradoresActionPerformed

    private void btnCerrarSessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSessionActionPerformed
        dispose();
        this.ventanaLogin.setVisible(true);
    }//GEN-LAST:event_btnCerrarSessionActionPerformed

    private void btnFincasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFincasActionPerformed
        PanelPrincipal.removeAll();
        
        PanelFincas temporal = new PanelFincas();
        temporal.setSize(PanelPrincipal.getSize());
        temporal.setPreferredSize(PanelPrincipal.getPreferredSize());
        PanelPrincipal.add(temporal);
        repaint();
        revalidate();
    }//GEN-LAST:event_btnFincasActionPerformed

    private void btnCultivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCultivosActionPerformed
        PanelPrincipal.removeAll();
        
        PanelCultivos temporal = new PanelCultivos();
        temporal.setSize(PanelPrincipal.getSize());
        temporal.setPreferredSize(PanelPrincipal.getPreferredSize());
        PanelPrincipal.add(temporal);
        repaint();
        revalidate();
    }//GEN-LAST:event_btnCultivosActionPerformed

    private void btnInsumosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsumosActionPerformed
        PanelPrincipal.removeAll();
        
        PanelInsumos temporal = new PanelInsumos();
        temporal.setSize(PanelPrincipal.getSize());
        temporal.setPreferredSize(PanelPrincipal.getPreferredSize());
        PanelPrincipal.add(temporal);
        repaint();
        revalidate();
    }//GEN-LAST:event_btnInsumosActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LogoGestor;
    private javax.swing.JPanel PanelFooter;
    private javax.swing.JPanel PanelHeaderA;
    private javax.swing.JPanel PanelHeaderB;
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JLabel SessionUsuario;
    private javax.swing.JButton btnAdministradores;
    private javax.swing.JButton btnCerrarSession;
    private javax.swing.JButton btnCultivos;
    private javax.swing.JButton btnFincas;
    private javax.swing.JButton btnInsumos;
    private javax.swing.JButton btnPerfil;
    private javax.swing.JButton btnRegistros;
    private javax.swing.JLabel etqAgroIndustrial;
    private javax.swing.JLabel etqDashBoard;
    private javax.swing.JLabel etqDevelopers;
    private javax.swing.JLabel etqGestor;
    private javax.swing.JLabel etqRol;
    private javax.swing.JPanel panelSideBar;
    private javax.swing.JSeparator separador;
    // End of variables declaration//GEN-END:variables
}
