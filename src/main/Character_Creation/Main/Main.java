import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Main{

	public static void main(String[] args){
		
		ImageIcon image = new ImageIcon("Character_Creation/Sprites/vampire.png");
		ImageIcon bgl1 = new ImageIcon("Character_Creation/Sprites/stringstar fields/example.png");

		Border border = BorderFactory.createLineBorder(Color.black, 3);

		JLabel Label = new JLabel("So fat!");
		Label.setIcon(bgl1);
		Label.setHorizontalTextPosition(JLabel.CENTER);
		//Label.setForeground(new Color(255, 255, 255));
		Label.setBorder(border);
		Label.setHorizontalAlignment(JLabel.CENTER);
		Label.setVerticalAlignment(JLabel.CENTER);
		Label.setBounds(0, 0, 450, 450);

		JLabel Label2 = new JLabel();
		Label2.setIcon(image);
		Label2.setHorizontalAlignment(JLabel.CENTER);
		Label2.setVerticalAlignment(JLabel.CENTER);

		JPanel firstPanel = new JPanel();
		firstPanel.setBackground(null);
		firstPanel.setBounds(250, 250, 100, 100);
		


		JFrame frame = new JFrame();
		frame.setTitle("Yo Mama");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setSize(420,420);
		frame.setVisible(true);
		frame.add(Label);
		frame.add(firstPanel);
		frame.setLayout(null);
		firstPanel.add(Label2);
		frame.setIconImage(image.getImage());
		frame.getContentPane().setBackground(new Color(19,41,75));

	}
}