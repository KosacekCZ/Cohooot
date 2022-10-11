import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class GUI {
    QuestionManager qm = new QuestionManager();
    JFrame frame = new JFrame("Cohooot");
    JPanel qCont = new JPanel();
    JPanel ansCont = new JPanel();
    JButton start = new JButton("Start");
    JButton a1 = new JButton("1");
    JButton a2 = new JButton("2");
    JButton a3 = new JButton("3");
    Font bogus = new Font("Arial", Font.PLAIN, 32);
    int pos = 0;
    int points = 0;

    public void initComponents() {
        frame.setSize(1920, 1080);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);
        qm.parseFileToArray();

        repaint();
    }

    public void drawMenu() {
        start.setBounds(frame.getWidth() / 4, frame.getHeight() / 3, frame.getWidth() / 2, frame.getHeight() / 3);
        start.addActionListener(e -> {
            play();
        });
        frame.add(start);

    }

    public void play() {
        if (qm.questions.get(pos) != null) {
            Question q = qm.questions.get(pos);
            System.out.println("question " + (pos + 1));
            drawQuestion(q.q, q.a1, q.a2, q.a3, q.a);
        } else {
            drawResults();
        }
    }

    //TODO: zjistit, proč se nevykresluje

    public void drawQuestion(String q, String an1, String an2, String an3, String a) {
        AtomicReference<String> answer = new AtomicReference<>("");
        AtomicBoolean correct = new AtomicBoolean(false);
        frame.removeAll();
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
        a1.addActionListener(r -> {
            if (an1.equals(a)) {
                points++;
                play();
            } else {
                points --;
                play();
            }
        });
        a2.addActionListener(r -> {
            if (an2.equals(a)) {
                points++;
                play();
            } else {
                points --;
                play();
            }
        });
        a3.addActionListener(r -> {
            if (an3.equals(a)) {
                points++;
                play();
            } else {
                points --;
                play();
            }
        });

        frame.add(qCont);
        frame.add(ansCont);
        ansCont.add(a1);
        ansCont.add(a2);
        ansCont.add(a3);

        repaint();
    }

    public void drawResults() {
        frame.removeAll();
        JLabel jl = new JLabel();
        jl.setBounds(frame.getWidth() / 4, frame.getHeight() / 3, frame.getWidth() / 2, frame.getHeight() / 3);
        jl.setText("Skóre: " + points);
        frame.add(jl);
        frame.repaint();
    }

    private void repaint() {
        frame.repaint();
    }

}