package ModuloAdmin;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

class imgPanel extends JPanel {
    private Image image;

    public imgPanel() {
        // Cargar la imagen en el constructor
        this.image = new ImageIcon(getClass().getResource("/img/finca.png")).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibujar la imagen en el panel
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
}
