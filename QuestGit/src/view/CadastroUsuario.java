package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroUsuario extends JFrame {

	private JPanel contentPane;
	private JPasswordField txtSenha;
	private JTextField txtEmail;
	private JTextField txtNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroUsuario frame = new CadastroUsuario();
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
	public CadastroUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Desktop.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(118, 59, 220, 30);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(6, 6, 45, 16);
		panel.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(52, 4, 162, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(118, 101, 220, 30);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(6, 6, 45, 16);
		panel_1.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(50, 4, 164, 20);
		panel_1.add(txtEmail);
		txtEmail.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(118, 143, 220, 30);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(6, 6, 50, 16);
		panel_2.add(lblSenha);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(53, 4, 161, 20);
		panel_2.add(txtSenha);
		
		JButton btnCadastroUsuario = new JButton("CADASTRAR");
		btnCadastroUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnCadastroUsuario.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCadastroUsuario.setBounds(166, 232, 120, 40);
		contentPane.add(btnCadastroUsuario);
		
		JLabel lblCadastroUsuario = new JLabel("Cadastro de Usuário");
		lblCadastroUsuario.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCadastroUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroUsuario.setBounds(144, 6, 150, 30);
		contentPane.add(lblCadastroUsuario);
	}
}
