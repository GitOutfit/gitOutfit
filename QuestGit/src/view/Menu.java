package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSpinner;
import java.awt.BorderLayout;
import javax.swing.JSlider;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Menu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(UIManager.getColor("Desktop.background"));
		frame.setBounds(100, 100, 554, 334);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnCadastrarUser = new JButton("CADASTRAR NOVO USUÁRIO");
		btnCadastrarUser.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCadastrarUser.setBackground(Color.WHITE);
		btnCadastrarUser.setBounds(163, 6, 250, 40);
		frame.getContentPane().add(btnCadastrarUser);
		
		JButton btnCadastrarNovoProduto = new JButton("CADASTRAR NOVO PRODUTO");
		btnCadastrarNovoProduto.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCadastrarNovoProduto.setBackground(Color.WHITE);
		btnCadastrarNovoProduto.setBounds(163, 58, 250, 40);
		frame.getContentPane().add(btnCadastrarNovoProduto);
		
		JButton btnCadastrarCliente = new JButton("CADASTRAR NOVO CLIENTE");
		btnCadastrarCliente.setBackground(Color.WHITE);
		btnCadastrarCliente.setBounds(163, 110, 250, 40);
		frame.getContentPane().add(btnCadastrarCliente);
		
		JButton btnImprimir = new JButton("IMPRIMIR RELATÓRIO DE VENDAS");
		btnImprimir.setBackground(Color.WHITE);
		btnImprimir.setBounds(163, 266, 250, 40);
		frame.getContentPane().add(btnImprimir);
		
		JButton btnPedido = new JButton("NOVO PEDIDO");
		btnPedido.setBounds(163, 162, 250, 40);
		frame.getContentPane().add(btnPedido);
		
		JButton btnNewButton = new JButton("VITRINE DE PRODUTOS");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(163, 214, 250, 40);
		frame.getContentPane().add(btnNewButton);
	}

}
