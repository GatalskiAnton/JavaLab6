import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class Task1Frame extends JFrame {
    private JButton btn;
    private JTextField coordinatesLabel;
    private JPanel panel;


    public Task1Frame(String title) throws HeadlessException {
        super(title);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(new Dimension(500, 500));

        createItems();
        addMouseEvent();
        addKeyboardEvent();
    }

    private void createItems() {
        btn = new JButton("button");
        btn.setPreferredSize(new Dimension(120, 70));
        coordinatesLabel = new JTextField("Coords: ");
        coordinatesLabel.setEditable(false);

        panel = new JPanel();
        panel.setBorder(BorderFactory.createLineBorder(Color.blue));
        panel.add(btn, BorderLayout.CENTER);

        add(panel, BorderLayout.CENTER);
        add(coordinatesLabel, BorderLayout.SOUTH);
    }

    private void addMouseEvent() {
        MouseAdapter panelAdapter = new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                btn.setLocation(e.getX() - btn.getWidth() / 2, e.getY() - btn.getHeight() / 2);
                coordinatesLabel.setText("Coords: " + "(" + e.getX() + "; " + e.getY() + ")");
            }
        };
        panel.addMouseListener(panelAdapter);
        panel.addMouseMotionListener(panelAdapter);
        MouseAdapter buttonAdapter = new MouseAdapter() {
            int x;
            int y;

            @Override
            public void mousePressed(MouseEvent e) {
                if (e.isControlDown()) {
                    x = e.getX();
                    y = e.getY();
                }
            }
            @Override
            public void mouseDragged(MouseEvent e) {
                if (e.isControlDown()) {
                    btn.setLocation(btn.getX() + e.getX() - x, btn.getY() + e.getY() - y);
                    coordinatesLabel.setText("Coords: " + "(" + (int)(e.getXOnScreen() - panel.getLocationOnScreen().getX())  + "; " + (int)(e.getYOnScreen() -  panel.getLocationOnScreen().getY()) + ")");
                }
            }
        };
        btn.addMouseMotionListener(buttonAdapter);
        btn.addMouseListener(buttonAdapter);
    }

    private void addKeyboardEvent() {
        KeyAdapter adapter = new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE)
                    btn.setText(btn.getText().substring(0, btn.getText().length() - 1));
                if (Character.isDefined(e.getKeyChar()))
                    btn.setText(btn.getText() + e.getKeyChar());
            }
        };
        btn.addKeyListener(adapter);
    }
}
