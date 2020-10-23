package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Venda extends JFrame {

	private JPanel contentPane;
	private JTextField txtCliente;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Venda frame = new Venda();
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
	public Venda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Desktop.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVenda = new JButton("REALIZAR VENDA");
		btnVenda.setBackground(Color.WHITE);
		btnVenda.setHorizontalTextPosition(SwingConstants.CENTER);
		btnVenda.setBounds(158, 232, 125, 40);
		contentPane.add(btnVenda);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(120, 64, 240, 30);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(6, 6, 44, 16);
		panel.add(lblCliente);
		
		txtCliente = new JTextField();
		txtCliente.setBounds(62, 4, 172, 20);
		panel.add(txtCliente);
		txtCliente.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(120, 106, 240, 30);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblDataVenda = new JLabel("Data da Venda");
		lblDataVenda.setBounds(6, 6, 95, 16);
		panel_1.add(lblDataVenda);
		
		textField = new JTextField();
		textField.setBounds(104, 4, 130, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(120, 148, 240, 30);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblSituacao = new JLabel("Situação");
		lblSituacao.setBounds(6, 6, 61, 16);
		panel_2.add(lblSituacao);
		
		textField_1 = new JTextField();
		textField_1.setBounds(79, 4, 155, 20);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(120, 190, 240, 30);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblProduto = new JLabel("Produto");
		lblProduto.setBounds(6, 8, 61, 16);
		panel_3.add(lblProduto);
		
		textField_2 = new JTextField();
		textField_2.setBounds(79, 6, 155, 20);
		panel_3.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Vendas");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setBounds(199, 6, 61, 30);
		contentPane.add(lblNewLabel);
	}

}
