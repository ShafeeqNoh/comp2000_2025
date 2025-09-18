import java.awt.Color;
import java.awt.Graphics;
import java.util.Objects;

public abstract class Actor {
  // Keep fields protected so subclasses can read them if needed.
  protected Color color;
  protected Cell loc;

  /**
   * Force every Actor to have a location and a color.
   */
  protected Actor(Cell loc, Color color) {
    this.loc = Objects.requireNonNull(loc, "loc (Cell) must not be null");
    this.color = Objects.requireNonNull(color, "color must not be null");
  }

  /** Current grid cell the actor occupies. */
  public Cell getLocation() {
    return loc;
  }

  /** Change the actor's location (useful when we add movement). */
  public void setLocation(Cell newLoc) {
    this.loc = Objects.requireNonNull(newLoc, "new location must not be null");
  }

  /** Actor's display color. */
  public Color getColor() {
    return color;
  }

  /** Allow changing color if a subclass/game rule needs it later. */
  public void setColor(Color newColor) {
    this.color = Objects.requireNonNull(newColor, "new color must not be null");
  }

  /** Convenience: does this actor sit on the given cell? */
  public boolean occupies(Cell c) {
    return c != null && c == this.loc;
  }

  /**
   * Default rendering (a filled square with a gray border).
   * Subclasses may override to draw different shapes if desired.
   */
  public void paint(Graphics g) {
    g.setColor(color);
    g.fillRect(loc.x + 5, loc.y + 5, loc.width - 10, loc.height - 10);
    g.setColor(Color.GRAY);
    g.drawRect(loc.x + 5, loc.y + 5, loc.width - 10, loc.height - 10);
  }
}
