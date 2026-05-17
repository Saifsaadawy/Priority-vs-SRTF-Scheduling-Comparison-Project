import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class GanttPanel extends JPanel {

    private List<GanttEntry> entries   = new ArrayList<>();
    private List<Process>    processes = new ArrayList<>();

    private static final Color BAR_A = new Color(0x4A7FC1);
    private static final Color BAR_B = new Color(0x5A9A78);
    private static final Color PANEL_BG = new Color(0x1E2235);
    private static final Color TEXT_COL = new Color(0xDDE3F5);
    private static final Color TICK_COL = new Color(0x8890AA);
    private static final int BAR_H = 40;
    private static final int PAD   = 14;

    public GanttPanel() {
        setBackground(PANEL_BG);
        setPreferredSize(new Dimension(800, BAR_H + 36));
    }

    public void setEntries(List<GanttEntry> e, List<Process> p) {
        this.entries   = e;
        this.processes = p;
        int total = e.isEmpty() ? 1 : e.get(e.size() - 1).end;
        setPreferredSize(new Dimension(PAD + Math.max(total * 56, 500) + PAD, BAR_H + 36));
        revalidate(); repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (entries.isEmpty()) {
            g.setColor(TICK_COL);
            g.setFont(new Font("SansSerif", Font.ITALIC, 12));
            g.drawString("Run the simulation to see the chart.", PAD, 28);
            return;
        }
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int total = entries.get(entries.size() - 1).end;
        double scale = (double)(getWidth() - 2 * PAD) / total;

        // alternate two colors per process
        Map<String, Color> cm = new LinkedHashMap<>();
        int idx = 0;
        for (Process p : processes)
            if (!cm.containsKey(p.pid)) cm.put(p.pid, (idx++ % 2 == 0) ? BAR_A : BAR_B);

        for (GanttEntry e : entries) {
            int x = PAD + (int)(e.start * scale);
            int w = Math.max((int)((e.end - e.start) * scale) - 1, 2);
            Color c = cm.getOrDefault(e.pid, BAR_A);
            g2.setColor(c);          g2.fillRect(x, 4, w, BAR_H);
            g2.setColor(c.darker()); g2.drawRect(x, 4, w, BAR_H);
            if (w > 18) {
                g2.setColor(TEXT_COL);
                g2.setFont(new Font("SansSerif", Font.BOLD, 12));
                FontMetrics fm = g2.getFontMetrics();
                g2.drawString(e.pid, x + (w - fm.stringWidth(e.pid)) / 2,
                            4 + (BAR_H + fm.getAscent()) / 2 - 2);
            }
        }

        g2.setFont(new Font("SansSerif", Font.PLAIN, 11));
        g2.setColor(TICK_COL);
        Set<Integer> drawn = new HashSet<>();
        for (GanttEntry e : entries) {
            for (int t : new int[]{e.start, e.end}) {
                if (!drawn.add(t)) continue;
                int tx = PAD + (int)(t * scale);
                String s = String.valueOf(t);
                g2.drawLine(tx, BAR_H + 4, tx, BAR_H + 9);
                g2.drawString(s, tx - g2.getFontMetrics().stringWidth(s) / 2, BAR_H + 22);
            }
        }
    }
}
