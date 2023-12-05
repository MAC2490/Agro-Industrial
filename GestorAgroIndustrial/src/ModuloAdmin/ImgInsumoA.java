package ModuloAdmin;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImgInsumoA extends JPanel {
    
    private Image image;

    public ImgInsumoA() {
        // Cargar la imagen en el constructor
        this.image = new ImageIcon(getClass().getResource("/img/casa.jpeg")).getImage();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibujar la imagen en el panel
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
}
