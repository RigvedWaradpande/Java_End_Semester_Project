import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlsoMain {
    public static void main(String[] args) {
        // Create a JFrame for the character creation program
        JFrame frame = new JFrame("Character Creation Program");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        // Create JPanel to hold the form components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        // Create labels and text fields for character attributes
        JLabel nameLabel = new JLabel("Name: ");
        JTextField nameField = new JTextField(20);

        JLabel classLabel = new JLabel("Class: ");
        JTextField classField = new JTextField(20);

        JLabel raceLabel = new JLabel("Race: ");
        JTextField raceField = new JTextField(20);

        // Create a button to submit the character
        JButton createButton = new JButton("Create Character");

        // Add action listener to the button
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String charClass = classField.getText();
                String race = raceField.getText();

                // Display the character's information
                String message = "Character Created:\nName: " + name + "\nClass: " + charClass + "\nRace: " + race;
                JOptionPane.showMessageDialog(frame, message);
            }
        });

        // Add components to the panel
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(classLabel);
        panel.add(classField);
        panel.add(raceLabel);
        panel.add(raceField);

        // Add the panel and button to the frame
        frame.add(panel, BorderLayout.CENTER);
        frame.add(createButton, BorderLayout.SOUTH);

        // Make the frame visible
        frame.setVisible(true);
    }
}   