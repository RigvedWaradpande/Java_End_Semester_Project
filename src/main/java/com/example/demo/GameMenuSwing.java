package com.example.demo;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class GameMenuSwing {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Loading Screen");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            // Create the game menu panel
            GameMenuPanel menuPanel = new GameMenuPanel(frame);
            frame.add(menuPanel);

            frame.setVisible(true);
        });
    }
}

class GameMenuPanel extends JPanel {

    public GameMenuPanel(JFrame parentFrame) {
        setLayout(new GridBagLayout());

        // Load background image
        ImageIcon backgroundImage = new ImageIcon("C:\\Users\\areen\\Desktop\\college\\demo\\src\\main\\resources\\Grimdark Environments [1-300]\\[101-200]\\ezekieleastbrook_insectoid_forest_battlefield_got_0ad1281d-c580-48b3-baa2-4a227c52b6f3 (10).png");
        JLabel backgroundLabel = new JLabel(backgroundImage);

        playMusic("C:\\Users\\areen\\Desktop\\college\\demo\\src\\main\\resources\\Gwyn_WAV.wav");

        JLabel playButton = createClickableText("Play");
        //JLabel settingButton = createClickableText("Settings");
        //JLabel exitButton = createClickableText("Exit");

        playButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                openCharacterBuildingScreen();
            }

            public void mouseEntered(MouseEvent e) {
                playButton.setForeground(Color.WHITE);
            }

            public void mouseExited(MouseEvent e) {
                playButton.setForeground(Color.GRAY);
            }
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 50, 0);
        add(playButton, gbc);

        // Layer the background and button
        add(backgroundLabel, gbc);
    }

    private void playMusic(String filePath) {
        try {
            File audioFile = new File(filePath);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);

            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);

            // Start the music automatically
            clip.start();
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
            ex.printStackTrace();
        }
    }


    private JLabel createClickableText(String text) {
        JLabel label = new JLabel(text);
        try {
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\areen\\Desktop\\college\\demo\\src\\main\\resources\\DungeonFont.ttf"));
            label.setFont(customFont.deriveFont(Font.PLAIN, 50));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        label.setForeground(Color.GRAY);
        label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return label;
    }

    private void openCharacterBuildingScreen() {
        SpriteSheetAnimation.main(new String[0]);
        JFrame characterBuildingFrame = new JFrame("Character Building Screen");
        characterBuildingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        characterBuildingFrame.setSize(800, 600);

        // Load background image for the character building screen
        ImageIcon characterBuildingImage = new ImageIcon("C:\\Users\\areen\\Desktop\\college\\demo\\src\\main\\resources\\Grimdark Environments [1-300]\\[101-200]\\ezekieleastbrook_insectoid_forest_battlefield_got_0ad1281d-c580-48b3-baa2-4a227c52b6f3 (28).png");
        JLabel characterBuildingLabel = new JLabel(characterBuildingImage);
        characterBuildingLabel.setSize(800, 600);

        // Panel to hold the character building background
        JPanel characterBuildingPanel = new JPanel(new BorderLayout());
        characterBuildingPanel.add(characterBuildingLabel, BorderLayout.CENTER);

        characterBuildingFrame.add(characterBuildingPanel);
        characterBuildingFrame.setVisible(true);
    }

}
