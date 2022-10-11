import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class QuestionManager {
    public ArrayList<Question> questions = new ArrayList<>();


    public void parseFileToArray() {
        int i = 0;
        int lines = 0;

        try {
            File qFile = new File("res/Questions.txt");
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader("res/Questions.txt"));

                while (reader.readLine() != null) lines++;
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            String[] qLines = new String[lines];
            Scanner s = new Scanner(qFile);
            while (s.hasNextLine()) {
                qLines[i] = s.nextLine();
                // System.out.println(qLines[i]);
                i++;
            }
            /*for (int j = 0; j < qLines.length; j++) {
                // System.out.println(qLines[j]);
            }*/
            s.close();
            for (i = 0; i < qLines.length - 1; i += 5) {
                questions.add(new Question(qLines[i], qLines[i+1], qLines[i+2], qLines[i+3], qLines[i+4]));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);;
        }

    }

}
