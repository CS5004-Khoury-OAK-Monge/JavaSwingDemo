import javax.swing.*;
import java.awt.*;

/**
 * A simple Java Swing demo showcasing:
 *   JFrame, JPanel, JLabel, JToggleButton
 *
 * Written by Claude, reviewed and updated by Alvaro Monge
 */
public class SwingDemo extends JFrame {


    JToggleButton onOffSwitch;
    JPanel display;
    JLabel status;

    /**
     * Launch paint application.
     *
     * @param args ignored
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SwingDemo app = new SwingDemo();
            app.setVisible(true);
        });
    }

    private SwingDemo() {

        // ── JFrame ────────────────────────────────────────────────────────────
        // JFrame is the top-level window (title bar, borders, close button).
        JFrame frame = new JFrame("Java Swing Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 260);
        frame.setLocationRelativeTo(null); // center on screen
        frame.setResizable(false);

        // ── JPanel ────────────────────────────────────────────────────────────
        // JPanel is an invisible container used to group and lay out components.
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(new Color(245, 245, 250));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        // ── JLabel (title) ────────────────────────────────────────────────────
        // JLabel displays a non-editable piece of text (or an icon).
        JLabel titleLabel = new JLabel("Swing Component Demo");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        titleLabel.setForeground(new Color(40, 40, 80));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // ── JLabel (description) ──────────────────────────────────────────────
        JLabel descLabel = new JLabel("Toggle the light switch below:");
        descLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        descLabel.setForeground(Color.DARK_GRAY);
        descLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // ── JPanel (display box) ──────────────────────────────────────────────
        // A nested panel acting as a "light bulb" display area.
        display = new JPanel();
        display.setPreferredSize(new Dimension(320, 60));
        display.setMaximumSize(new Dimension(320, 60));
        display.setBackground(new Color(80, 80, 80));   // starts "off" (dark gray background)
        display.setAlignmentX(Component.CENTER_ALIGNMENT);
        display.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180), 1));
        display.setLayout(new BorderLayout());

        // ── JLabel (status, inside display panel) ─────────────────────────────
        status = new JLabel("💡 OFF", SwingConstants.CENTER);
        status.setFont(new Font("SansSerif", Font.BOLD, 18));
        status.setForeground(new Color(180, 180, 180));
        display.add(status, BorderLayout.CENTER);

        // ── JToggleButton ─────────────────────────────────────────────────────
        // JToggleButton stays pressed (selected) when clicked, and unpresses on
        // the next click — it holds a true/false state.
        onOffSwitch = new JToggleButton("Turn ON");
        onOffSwitch.setFont(new Font("SansSerif", Font.BOLD, 14));
        onOffSwitch.setFocusPainted(false);
        onOffSwitch.setBackground(new Color(100, 180, 100));
        onOffSwitch.setForeground(Color.BLUE);
        onOffSwitch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        onOffSwitch.setAlignmentX(Component.CENTER_ALIGNMENT);

        // ActionListener: swap colors/text based on selected state
        onOffSwitch.addActionListener(e -> onToggle());

        // BEFORE assembling, each GUI element was created independently!

        // ── Assemble ──────────────────────────────────────────────────────────
        mainPanel.add(titleLabel);
        mainPanel.add(Box.createVerticalStrut(12));
        mainPanel.add(descLabel);
        mainPanel.add(Box.createVerticalStrut(16));
        mainPanel.add(display);
        mainPanel.add(Box.createVerticalStrut(16));
        mainPanel.add(onOffSwitch);

        frame.setContentPane(mainPanel);
        frame.setVisible(true);
    }

    private void onToggle() {
        if (onOffSwitch.isSelected()) { // turn on, so show light bulb is on setting BG to yellow
            display.setBackground(new Color(255, 240, 100));
            status.setForeground(new Color(80, 60, 0));
            status.setText("💡 ON");  // Update what switch will do next when pressed
            onOffSwitch.setText("Turn OFF");
            onOffSwitch.setBackground(new Color(200, 80, 80));

        } else {  // turn off by setting BG to dark gray
            display.setBackground(new Color(80, 80, 80));
            status.setForeground(new Color(180, 180, 180));
            status.setText("💡 OFF");
            onOffSwitch.setText("Turn ON");    // Update what switch will do next when pressed
            onOffSwitch.setBackground(new Color(100, 180, 100));
        }
    }
}