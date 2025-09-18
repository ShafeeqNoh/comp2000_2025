// src/GrassCell.java
import java.awt.Color;

public class GrassCell extends Cell {
  public GrassCell(int x, int y) { super(x, y); }
  @Override protected Color baseColor() { return new Color(210, 245, 210); } // light green
  @Override public int moveCost() { return 1; }
}
