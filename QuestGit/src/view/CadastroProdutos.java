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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.ComponentOrientation;

public class CadastroProdutos extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtDescricao;
	private JTextField txtValor;
	private JTextField txtEstoque;
	private JTextField txtEstoqueMin;
	private JTextField textField;
	private JTextField txtMarca;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroProdutos frame = new CadastroProdutos();
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
	public CadastroProdutos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 306);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Desktop.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadastrarProduto = new JButton("CADASTRAR");
		btnCadastrarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnCadastrarProduto.setBackground(Color.WHITE);
		btnCadastrarProduto.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCadastrarProduto.setBounds(158, 232, 120, 40);
		contentPane.add(btnCadastrarProduto);
		
		JLabel lblNewLabel = new JLabel("Cadastrar produto");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(158, 6, 120, 30);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(20, 64, 190, 30);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(6, 6, 45, 16);
		panel.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(54, 1, 130, 25);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(240, 64, 190, 30);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblDescricao = new JLabel("Descrição");
		lblDescricao.setBounds(6, 6, 65, 16);
		panel_1.add(lblDescricao);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(70, 1, 114, 25);
		panel_1.add(txtDescricao);
		txtDescricao.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(20, 106, 190, 30);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(6, 6, 61, 16);
		panel_2.add(lblValor);
		
		txtValor = new JTextField();
		txtValor.setBounds(54, 4, 130, 20);
		panel_2.add(txtValor);
		txtValor.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(240, 106, 190, 30);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblEstoque = new JLabel("Estoque");
		lblEstoque.setBounds(6, 6, 61, 16);
		panel_3.add(lblEstoque);
		
		txtEstoque = new JTextField();
		txtEstoque.setBounds(74, 4, 110, 20);
		panel_3.add(txtEstoque);
		txtEstoque.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(20, 148, 190, 30);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblEstoqueMin = new JLabel("Estoque Mínimo");
		lblEstoqueMin.setBounds(6, 3, 107, 16);
		panel_4.add(lblEstoqueMin);
		
		txtEstoqueMin = new JTextField();
		txtEstoqueMin.setBounds(110, 6, 74, 20);
		panel_4.add(txtEstoqueMin);
		txtEstoqueMin.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(240, 148, 190, 30);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(6, 6, 61, 16);
		panel_5.add(lblCategoria);
		
		textField = new JTextField();
		textField.setBounds(74, 4, 110, 20);
		panel_5.add(textField);
		textField.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(20, 190, 190, 30);
		contentPane.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(6, 6, 50, 16);
		panel_6.add(lblMarca);
		
		txtMarca = new JTextField();
		txtMarca.setBounds(54, 4, 130, 20);
		panel_6.add(txtMarca);
		txtMarca.setColumns(10);
	}

}
