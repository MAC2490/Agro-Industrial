
package ModuloAdmin;

import ModuloSuperAdmin.PanelCultivos;
import Principal.Login;
import javax.swing.JPanel;


public class DashBoardAdmin extends javax.swing.JFrame {

    Login ventanaLogin;
    String SesionUsuario;
    
    public DashBoardAdmin(Login ventanaLogin, String DatosUsuario) {
        this.ventanaLogin=ventanaLogin;
        this.SesionUsuario=DatosUsuario;
        System.out.println(DatosUsuario);
        initComponents();
        initAlternComponents();
        this.defaultPanel();
    }

    public void initAlternComponents(){
        System.out.println("Iniciando el DashBoard Admin");
        setLocationRelativeTo(null);
        setIconImage( getToolkit().createImage( ClassLoader.getSystemResource("img/LogoLOGIN.png") ) );
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        PanelFooter = new javax.swing.JPanel();
        etqDevelopers = new javax.swing.JLabel();
        PanelHeaderA = new javax.swing.JPanel();
        etqDashBoard = new javax.swing.JLabel();
        etqRol = new javax.swing.JLabel();
        PanelHeaderB = new javax.swing.JPanel();
        LogoGestor = new javax.swing.JLabel();
        etqGestor = new javax.swing.JLabel();
        etqAgroIndustrial = new javax.swing.JLabel();
        PanelPrincipal = new javax.swing.JPanel();
        panelSideBar = new javax.swing.JPanel();
        btnFincas = new javax.swing.JButton();
        btnPerfil = new javax.swing.JButton();
        separador = new javax.swing.JSeparator();
        btnCultivos = new javax.swing.JButton();
        btnInsumos = new javax.swing.JButton();
        btnRegistros = new javax.swing.JButton();
        btnCerrarSession = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("DashBoard Admin - Gestor AgroIndustrial");
        setUndecorated(true);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel1.add(PanelFooter, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 540, 780, 40));

        PanelHeaderA.setBackground(new java.awt.Color(0, 0, 0));

        etqDashBoard.setFont(new java.awt.Font("Tw Cen MT", 0, 36)); // NOI18N
        etqDashBoard.setForeground(new java.awt.Color(255, 255, 255));
        etqDashBoard.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etqDashBoard.setText("DASHBOARD");

        etqRol.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        etqRol.setForeground(new java.awt.Color(255, 255, 255));
        etqRol.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etqRol.setText("Admin");

        javax.swing.GroupLayout PanelHeaderALayout = new javax.swing.GroupLayout(PanelHeaderA);
        PanelHeaderA.setLayout(PanelHeaderALayout);
        PanelHeaderALayout.setHorizontalGroup(
            PanelHeaderALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(etqDashBoard, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(etqRol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelHeaderALayout.setVerticalGroup(
            PanelHeaderALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHeaderALayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etqDashBoard)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etqRol)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        jPanel1.add(PanelHeaderA, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 0, 250, 90));

        PanelHeaderB.setBackground(new java.awt.Color(0, 0, 0));

        LogoGestor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LogoDashboard.png"))); // NOI18N

        etqGestor.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        etqGestor.setForeground(new java.awt.Color(255, 255, 255));
        etqGestor.setText("GESTOR");

        etqAgroIndustrial.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        etqAgroIndustrial.setForeground(new java.awt.Color(255, 255, 255));
        etqAgroIndustrial.setText("AGRO-INDUSTRIAL");

        javax.swing.GroupLayout PanelHeaderBLayout = new javax.swing.GroupLayout(PanelHeaderB);
        PanelHeaderB.setLayout(PanelHeaderBLayout);
        PanelHeaderBLayout.setHorizontalGroup(
            PanelHeaderBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelHeaderBLayout.createSequentialGroup()
                .addContainerGap(471, Short.MAX_VALUE)
                .addGroup(PanelHeaderBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etqGestor, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(etqAgroIndustrial, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LogoGestor)
                .addGap(43, 43, 43))
        );
        PanelHeaderBLayout.setVerticalGroup(
            PanelHeaderBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LogoGestor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelHeaderBLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(etqGestor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etqAgroIndustrial)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(PanelHeaderB, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 0, 780, 90));

        PanelPrincipal.setBackground(new java.awt.Color(222, 222, 222));

        javax.swing.GroupLayout PanelPrincipalLayout = new javax.swing.GroupLayout(PanelPrincipal);
        PanelPrincipal.setLayout(PanelPrincipalLayout);
        PanelPrincipalLayout.setHorizontalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PanelPrincipalLayout.setVerticalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );

        jPanel1.add(PanelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 84, 780, 460));

        panelSideBar.setBackground(new java.awt.Color(0, 0, 153));
        panelSideBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnFincas.setBackground(new java.awt.Color(0, 0, 102));
        btnFincas.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        btnFincas.setForeground(new java.awt.Color(255, 255, 255));
        btnFincas.setText("MI FINCA");
        btnFincas.setBorderPainted(false);
        btnFincas.setFocusable(false);
        btnFincas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFincasActionPerformed(evt);
            }
        });
        panelSideBar.add(btnFincas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 240, 45));

        btnPerfil.setBackground(new java.awt.Color(0, 0, 153));
        btnPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ProfileButton.png"))); // NOI18N
        btnPerfil.setBorderPainted(false);
        btnPerfil.setFocusable(false);
        btnPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerfilActionPerformed(evt);
            }
        });
        panelSideBar.add(btnPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, 240, -1));

        separador.setBackground(new java.awt.Color(255, 255, 255));
        separador.setForeground(new java.awt.Color(255, 255, 255));
        panelSideBar.add(separador, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 82, 238, 10));

        btnCultivos.setBackground(new java.awt.Color(0, 0, 102));
        btnCultivos.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        btnCultivos.setForeground(new java.awt.Color(255, 255, 255));
        btnCultivos.setText("CULTIVOS");
        btnCultivos.setBorderPainted(false);
        btnCultivos.setFocusable(false);
        btnCultivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCultivosActionPerformed(evt);
            }
        });
        panelSideBar.add(btnCultivos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 240, 45));

        btnInsumos.setBackground(new java.awt.Color(0, 0, 102));
        btnInsumos.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        btnInsumos.setForeground(new java.awt.Color(255, 255, 255));
        btnInsumos.setText("INSUMOS");
        btnInsumos.setBorderPainted(false);
        btnInsumos.setFocusable(false);
        btnInsumos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsumosActionPerformed(evt);
            }
        });
        panelSideBar.add(btnInsumos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 251, 240, 45));

        btnRegistros.setBackground(new java.awt.Color(0, 0, 102));
        btnRegistros.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        btnRegistros.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistros.setText("PRODUCCIÓN");
        btnRegistros.setBorderPainted(false);
        btnRegistros.setFocusable(false);
        btnRegistros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrosActionPerformed(evt);
            }
        });
        panelSideBar.add(btnRegistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 240, 45));

        btnCerrarSession.setBackground(new java.awt.Color(0, 0, 102));
        btnCerrarSession.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        btnCerrarSession.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrarSession.setText("CERRAR SESSION");
        btnCerrarSession.setBorderPainted(false);
        btnCerrarSession.setFocusable(false);
        btnCerrarSession.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSessionActionPerformed(evt);
            }
        });
        panelSideBar.add(btnCerrarSession, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 411, 240, 40));

        jPanel1.add(panelSideBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 90, 250, 490));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void btnPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerfilActionPerformed
        PanelPrincipal.removeAll();

        PanelPerfil temporal = new PanelPerfil(SesionUsuario);
        temporal.setSize(PanelPrincipal.getSize());
        temporal.setPreferredSize(PanelPrincipal.getPreferredSize());
        PanelPrincipal.add(temporal);
        repaint();
        revalidate();
    }//GEN-LAST:event_btnPerfilActionPerformed

    private void btnRegistrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrosActionPerformed
        this.defaultPanel();
    }//GEN-LAST:event_btnRegistrosActionPerformed

    private void btnCultivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCultivosActionPerformed
        PanelPrincipal.removeAll();

        PanelCultivosAdmin temporal = new PanelCultivosAdmin(this.SesionUsuario);
        temporal.setSize(PanelPrincipal.getSize());
        temporal.setPreferredSize(PanelPrincipal.getPreferredSize());
        PanelPrincipal.add(temporal);
        repaint();
        revalidate();
    }//GEN-LAST:event_btnCultivosActionPerformed

    private void btnInsumosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsumosActionPerformed
        PanelPrincipal.removeAll();

        PanelInsumos temporal = new PanelInsumos(this.SesionUsuario);
        temporal.setSize(PanelPrincipal.getSize());
        temporal.setPreferredSize(PanelPrincipal.getPreferredSize());
        PanelPrincipal.add(temporal);
        repaint();
        revalidate();
    }//GEN-LAST:event_btnInsumosActionPerformed

    public void defaultPanel(){
        PanelPrincipal.removeAll();

        PanelProduccion temporal = new PanelProduccion(this.SesionUsuario);
        temporal.setSize(PanelPrincipal.getSize());
        temporal.setPreferredSize(PanelPrincipal.getPreferredSize());
        PanelPrincipal.add(temporal);
        repaint();
        revalidate();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LogoGestor;
    private javax.swing.JPanel PanelFooter;
    private javax.swing.JPanel PanelHeaderA;
    private javax.swing.JPanel PanelHeaderB;
    private javax.swing.JPanel PanelPrincipal;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panelSideBar;
    private javax.swing.JSeparator separador;
    // End of variables declaration//GEN-END:variables
}