package regex;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextPane;
import java.awt.Color;

public class ExpresionesRegulares extends JFrame{

	private JPanel contentPane;
	private JTextField editExpresion;
	private JButton buttonGenerar;
	private JTextPane editResultados;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegularExpresion frame = new RegularExpresion();
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
	public ExpresionesRegulares() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 404);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		editExpresion = new JTextField();
		editExpresion.setBounds(144, 26, 256, 27);
		contentPane.add(editExpresion);
		editExpresion.setColumns(10);
		
		buttonGenerar = new JButton("Generar");
		buttonGenerar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				editExpresion.getText().toLowerCase();
//				getCadena(editExpresion.getText());
			}
		});
		buttonGenerar.setBounds(434, 28, 98, 27);
		contentPane.add(buttonGenerar);
		
		JLabel lblEscribaLaExpresin = new JLabel("Escriba la expresión");
		lblEscribaLaExpresin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEscribaLaExpresin.setHorizontalAlignment(SwingConstants.CENTER);
		lblEscribaLaExpresin.setBounds(10, 32, 124, 14);
		contentPane.add(lblEscribaLaExpresin);
		
		editResultados = new JTextPane();
		editResultados.setBounds(23, 64, 509, 290);
		contentPane.add(editResultados);
	}
}
