import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Task2Frame extends JFrame {
    private JButton staticButton;
    private JButton movableButton;
    private JLabel label;

    public Task2Frame(String title) throws HeadlessException {
        super(title);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(new Dimension(500,500));

        createItems();
        addMouseEvent();
        add(label);
        add(staticButton);
        add(movableButton);
    }

    private void createItems()
    {
        setLayout(new FlowLayout(FlowLayout.LEFT));

        label = new JLabel("Do you like your salary?");
        staticButton = new JButton("Yes!");
        movableButton = new JButton("No!");
    }
    private void addMouseEvent()
    {
        MouseAdapter movableButtonAdapter = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Random random = new Random();
                movableButton.setLocation((int)(random.nextInt(getWidth()) * 0.9) ,(int)(random.nextInt(getHeight()) * 0.9));
            }
        };

        MouseAdapter staticButtonAdapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "I known");
            }
        };
        movableButton.addMouseListener(movableButtonAdapter);
        staticButton.addMouseListener(staticButtonAdapter);
    }
}
