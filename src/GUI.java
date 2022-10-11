import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GUI {
    JFrame frame = new JFrame("Cohooot");
    JPanel qCont = new JPanel();
    JPanel ansCont = new JPanel();
    JButton a1 = new JButton("1");
    JButton a2 = new JButton("2");
    JButton a3 = new JButton("3");
    Font bogus = new Font("Arial", Font.PLAIN, 32);
    boolean run = true;
    ArrayList<Question> qSet = new ArrayList<>();

    public void initComponents() {
        frame.setSize(1920, 1080);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);

        repaint();
    }

    public void drawMenu() {

    }

    public void play() {
        qCont.setBounds(0, 0, 1920, 780);
        qCont.setLayout(null);
        ansCont.setBounds(0, 780, 1920, 300);
        ansCont.setLayout(null);
        a1.setBounds(0, 0, 640, 300);
        a2.setBounds(640, 0, 640, 300);
        a3.setBounds(1280, 0, 640, 300);
        a1.setFont(bogus);
        a2.setFont(bogus);
        a3.setFont(bogus);
        a1.addActionListener(r -> {checkAns(1);});
        a2.addActionListener(r -> {checkAns(2);});
        a3.addActionListener(r -> {checkAns(3);});

        frame.add(qCont);
        frame.add(ansCont);
        ansCont.add(a1);
        ansCont.add(a2);
        ansCont.add(a3);

        repaint();

        while(run) {
            nextQ();
        }
    }

    public void drawResults() {

    }

    private void repaint() {
        frame.repaint();
    }

    private void checkAns(int answered) {

    }

    private void nextQ() {

    }
}