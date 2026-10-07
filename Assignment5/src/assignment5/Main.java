package assignment5;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea resultArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Select File");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    JFileChooser fileChooser = new JFileChooser();

			    int result = fileChooser.showOpenDialog(Main.this);

			    if (result == JFileChooser.APPROVE_OPTION) {

			        File file = fileChooser.getSelectedFile();
			        NumberLinkedList list = new NumberLinkedList();

			        try {
			            Scanner scanner = new Scanner(file);
			            int invalidCount = 0;

			            while (scanner.hasNextLine()) {
			                String line = scanner.nextLine().trim();

			                if (line.isEmpty()) {
			                    continue;
			                }

			                try {
			                    double number = Double.parseDouble(line);
			                    list.add(number);
			                } catch (NumberFormatException ex) {
			                    invalidCount++;
			                }
			            }

			            scanner.close();

			            double mean = list.getMean();
			            double standardDeviation = list.getStandardDeviation();

			            resultArea.setText(
			                "Mean: " + mean +
			                "\nStandard Deviation: " + standardDeviation +
			                "\nInvalid inputs: " + invalidCount
			            );

			        } catch (FileNotFoundException ex) {
			            resultArea.setText("File not found.");
			        }
			    }
			}
		});
		btnNewButton.setBounds(165, 61, 117, 29);
		contentPane.add(btnNewButton);
		
		
		resultArea = new JTextArea();
		resultArea.setEditable(false);
		resultArea.setBounds(70, 122, 316, 83);
		contentPane.add(resultArea);

	}

}
