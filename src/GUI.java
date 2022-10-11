import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

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

    public boolean play(String q, String an1, String an2, String an3, String a) {
        AtomicReference<String> answer = new AtomicReference<>("");
        AtomicBoolean correct = new AtomicBoolean(false);
        frame.removeAll();
        qCont.removeAll();
        ansCont.removeAll();
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
            answer.set(an1);
            correct.set(checkAns(String.valueOf(answer), a));});
        a2.addActionListener(r -> {
            answer.set(an2);
            correct.set(checkAns(String.valueOf(answer), a));});
        a3.addActionListener(r -> {
            answer.set(an3);
            correct.set(checkAns(String.valueOf(answer), a));});

        frame.add(qCont);
        frame.add(ansCont);
        ansCont.add(a1);
        ansCont.add(a2);
        ansCont.add(a3);

        repaint();

        return correct.get();
    }

    public boolean checkAns(String answer, String correct) {
        return (answer.equals(correct));
    }

    public void drawResults() {

    }

    private void repaint() {
        frame.repaint();
    }

}