
package ModuloAdmin;

import Principal.Login;


public class DashBoardAdmin extends javax.swing.JFrame {

    Login ventanaLogin;
    String SesionUsuario;
    
    public DashBoardAdmin(Login ventanaLogin, String DatosUsuario) {
        this.ventanaLogin=ventanaLogin;
        this.SesionUsuario=DatosUsuario;
        
        initComponents();
        initAlternComponents();
    }

    public void initAlternComponents(){
        System.out.println("Iniciando el DashBoard Admin");
        setLocationRelativeTo(null);
        setIconImage( getToolkit().createImage( ClassLoader.getSystemResource("img/LogoLOGIN.png") ) );
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelHeaderB = new javax.swing.JPanel();
        LogoGestor = new javax.swing.JLabel();
        etqGestor = new javax.swing.JLabel();
        etqAgroIndustrial = new javax.swing.JLabel();
        panelSideBar = new javax.swing.JPanel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("DashBoard Admin - Gestor AgroIndustrial");
        setResizable(false);

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
                .addContainerGap(477, Short.MAX_VALUE)
                .addGroup(PanelHeaderBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etqGestor, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(etqAgroIndustrial, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LogoGestor)
                .addGap(43, 43, 43))
        );
        PanelHeaderBLayout.setVerticalGroup(
            PanelHeaderBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LogoGestor, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
            .addGroup(PanelHeaderBLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(etqGestor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etqAgroIndustrial)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelSideBar.setBackground(new java.awt.Color(0, 0, 153));

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

        btnPerfil.setBackground(new java.awt.Color(0, 0, 153));
        btnPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ProfileButton.png"))); // NOI18N
        btnPerfil.setBorderPainted(false);
        btnPerfil.setFocusable(false);
        btnPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerfilActionPerformed(evt);
            }
        });

        separador.setBackground(new java.awt.Color(255, 255, 255));
        separador.setForeground(new java.awt.Color(255, 255, 255));

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

        btnInsumos.setBackground(new java.awt.Color(0, 0, 102));
        btnInsumos.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        btnInsumos.setForeground(new java.awt.Color(255, 255, 255));
        btnInsumos.setText("INSUMOS");
        btnInsumos.setBorderPainted(false);
        btnInsumos.setFocusable(false);

        btnRegistros.setBackground(new java.awt.Color(0, 0, 102));
        btnRegistros.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        btnRegistros.setForeground(new java.awt.Color(255, 255, 255));
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
            .addComponent(btnFincas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSideBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(separador)
                .addContainerGap())
            .addComponent(btnCultivos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnInsumos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnRegistros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnCerrarSession, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
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
                .addComponent(btnFincas, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCultivos, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnInsumos, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
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

    private void btnCultivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCultivosActionPerformed
        PanelPrincipal.removeAll();
        
        PanelCultivosAdmin temporal = new PanelCultivosAdmin(SesionUsuario);
        temporal.setSize(PanelPrincipal.getSize());
        temporal.setPreferredSize(PanelPrincipal.getPreferredSize());
        PanelPrincipal.add(temporal);
        repaint();
        revalidate();
    }//GEN-LAST:event_btnCultivosActionPerformed

    

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
    private javax.swing.JPanel panelSideBar;
    private javax.swing.JSeparator separador;
    // End of variables declaration//GEN-END:variables
}
