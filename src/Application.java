import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Application {

    private JFrame frame;
    private JTextField NameFile;
    private JLabel label;
    private JButton ButtonCreateFile;

    Application() {
        frame = new JFrame("WINDOW");
        label = new JLabel("Enter name file");
        label.setBounds(150, 6, 200, 30);
        frame.add(label);

        NameFile = new JTextField();
        NameFile.setBounds(100, 40, 200, 30);
        frame.add(NameFile);

        ButtonCreateFile = new JButton("Create File");
        ButtonCreateFile.setBounds(150, 100, 100, 20);
        frame.add(ButtonCreateFile);

        frame.setSize(new Dimension(400, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);

        ButtonCreateFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateFile();
            }
        });
    }

    public void CreateFile() {
        String name_file = String.valueOf(NameFile.getText());
        File Directory = new File("FileFolder");

        if (!Directory.exists()) {
            Directory.mkdir();
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("FileFolder/" + name_file));
            writer.write("");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}