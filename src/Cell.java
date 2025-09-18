import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class Cell extends Rectangle implements Terrain {
  public static final int SIZE = 35;

  public Cell(int x, int y) {
    super(x, y, SIZE, SIZE);
  }

  // --- Terrain (default) ---
  @Override public boolean isWalkable() { return true; }
  @Override public int moveCost() { return 1; }

  /** Default terrain colour; subclasses override. */
  protected Color baseColor() { return Color.WHITE; }

  /** Paints the cell; highlights when the mouse is over it. */
  public void paint(Graphics g, Point mousePos) {
    g.setColor(contains(mousePos) ? Color.GRAY : baseColor());
    g.fillRect(x, y, width, height);
    g.setColor(Color.BLACK);
    g.drawRect(x, y, width, height);
  }

  /** Null-safe contains check (Rectangle.contains throws on null). */
  @Override
  public boolean contains(Point p) {
    return p != null && super.contains(p);
  }
}

