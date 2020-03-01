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

public class RegularExpresion extends JFrame{

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
	public RegularExpresion() {
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
				getCadena(editExpresion.getText());
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
	
	
	
	public String getCadena(String expresion) {
		if(parenthesis(expresion) == 0)
			JOptionPane.showMessageDialog(null, "Cierre los paréntesis que abra");
		else  if(parenthesis(expresion) == 1)
			JOptionPane.showMessageDialog(null, "Muy bien");
		
		if(methodOr(expresion) == 0)
			JOptionPane.showMessageDialog(null, "Falta una letra (ya sea A o B) antes del or (|)");
		
		else if(methodOr(expresion) == -1)
			JOptionPane.showMessageDialog(null, "Falta una letra (ya sea A o B) despues del or (|)");
		
		else if(methodOr(expresion) == 1)
			JOptionPane.showMessageDialog(null, "Muy bien");
		return "";
	}
	
	public int parenthesis(String expresion) {
		int parenthesisLeftLeng = 0;
		int parenthesisRightLeng = 0;
		for(int i = 0; i < expresion.length(); i++) {
			if(expresion.charAt(i) == '(') {
				parenthesisLeftLeng++;
			}
			else if(expresion.charAt(i) == ')') {
				parenthesisRightLeng++;
			}
		}
		if(parenthesisRightLeng != parenthesisLeftLeng) 
			return 0;
		else 
			return 1;
	}
	
	public int methodOr(String expresion) {
		for(int i = 0; i < expresion.length(); i++) {
			if(expresion.charAt(i) == '|') {
				if(expresion.charAt(i - 1) != 'a' || expresion.charAt(i - 1) != 'b') {
					return 0;
				}
			}
			else if(expresion.charAt(i + 1) != 'a' || expresion.charAt(i + 1) != 'b') {
				return -1;
			}
			else
				return 1;
		}
		return 0;
	}
}
