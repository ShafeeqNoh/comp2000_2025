import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

public class Grid {
  public static final int COLS = 20;
  public static final int ROWS = 20;
  public static final int OFFSET = 10;

  private final Cell[][] cells = new Cell[COLS][ROWS];

  public Grid() {
    Random rnd = new Random(1); // fixed seed for deterministic output
    for (int c = 0; c < COLS; c++) {
      for (int r = 0; r < ROWS; r++) {
        int x = OFFSET + c * Cell.SIZE;
        int y = OFFSET + r * Cell.SIZE;
        // ~15% water, rest grass (tweak as you like)
        cells[c][r] = rnd.nextDouble() < 0.15 ? new WaterCell(x, y) : new GrassCell(x, y);
      }
    }
  }

  public void paint(Graphics g, Point mousePos) {
    for (int c = 0; c < COLS; c++) {
      for (int r = 0; r < ROWS; r++) {
        cells[c][r].paint(g, mousePos);
      }
    }
  }

  /** Returns the cell at (column, row). */
  public Cell cellAtColRow(int c, int r) {
    if (c < 0 || c >= COLS || r < 0 || r >= ROWS) return null;
    return cells[c][r];
  }

  public int cols() { return COLS; }
  public int rows() { return ROWS; }
}
