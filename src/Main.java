import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Main {

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      JFrame window = new JFrame("Stage");
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      Canvas canvas = new Canvas();
      window.setContentPane(canvas);
      window.pack();
      window.setLocationRelativeTo(null);
      window.setVisible(true);

      // ~60 FPS repaint without pegging the CPU
      new Timer(16, e -> canvas.repaint()).start();
    });
  }

  static class Canvas extends JPanel {
    private final Stage stage = new Stage();

    Canvas() {
      setPreferredSize(new Dimension(720, 720));
    }

    @Override
    protected void paintComponent(Graphics g) {
      super.paintComponent(g); // clears background properly
      stage.paint(g, getMousePosition()); // safe: your code null-checks
    }
  }
}

