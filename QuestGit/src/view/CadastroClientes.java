package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroClientes extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField textField_1;
	private JTextField txtCelular;
	private JPasswordField txtSenha;
	private JTextField txtEndereco;
	private JTextField txtEmail;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroClientes frame = new CadastroClientes();
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
	public CadastroClientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Desktop.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(6, 48, 210, 30);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtNome = new JTextField();
		txtNome.setBounds(48, 6, 156, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(6, 8, 61, 16);
		panel.add(lblNome);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(234, 48, 210, 30);
		contentPane.add(panel_1);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(6, 6, 61, 16);
		panel_1.add(lblCpf);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(36, 4, 168, 20);
		panel_1.add(txtCpf);
		txtCpf.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(6, 90, 210, 30);
		contentPane.add(panel_2);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(6, 6, 60, 16);
		panel_2.add(lblTelefone);
		
		textField_1 = new JTextField();
		textField_1.setBounds(66, 4, 138, 20);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(234, 90, 210, 30);
		contentPane.add(panel_3);
		
		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setBounds(6, 6, 61, 16);
		panel_3.add(lblCelular);
		
		txtCelular = new JTextField();
		txtCelular.setBounds(58, 4, 146, 20);
		panel_3.add(txtCelular);
		txtCelular.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(6, 134, 210, 30);
		contentPane.add(panel_4);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(6, 6, 50, 16);
		panel_4.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(47, 4, 157, 20);
		panel_4.add(txtEmail);
		txtEmail.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(234, 134, 210, 30);
		contentPane.add(panel_5);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(6, 6, 50, 16);
		panel_5.add(lblSenha);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(52, 4, 152, 20);
		panel_5.add(txtSenha);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(6, 176, 210, 30);
		contentPane.add(panel_6);
		
		JLabel lblDataNascimento = new JLabel("Data de nascimento");
		lblDataNascimento.setBounds(6, 5, 125, 16);
		panel_6.add(lblDataNascimento);
		
		textField = new JTextField();
		textField.setBounds(135, 3, 69, 20);
		panel_6.add(textField);
		textField.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(234, 176, 210, 30);
		contentPane.add(panel_7);
		
		JLabel lblEndereco = new JLabel("Endereco");
		lblEndereco.setBounds(6, 6, 61, 16);
		panel_7.add(lblEndereco);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(68, 4, 136, 20);
		panel_7.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		JButton btnCadastrarCliente = new JButton("CADASTRAR");
		btnCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnCadastrarCliente.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCadastrarCliente.setBackground(Color.WHITE);
		btnCadastrarCliente.setBounds(172, 230, 120, 40);
		contentPane.add(btnCadastrarCliente);
		
		JLabel lblLogo = new JLabel("Cadastro de clientes");
		lblLogo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(154, 6, 150, 25);
		contentPane.add(lblLogo);
	}

}
