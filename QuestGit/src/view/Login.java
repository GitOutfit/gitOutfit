package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {
	
	//private Image img_logo = new ImageIcon(Login.class.getResource("res/fashion.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);

	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Desktop.background"));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(104, 109, 250, 35);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtUser = new JTextField();
		txtUser.setText("Usuário");
		txtUser.setBackground(Color.WHITE);
		txtUser.setBounds(74, 6, 170, 25);
		panel.add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblUser = new JLabel("Usuário");
		lblUser.setBounds(6, 11, 61, 16);
		panel.add(lblUser);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(104, 156, 250, 35);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtPassword = new JPasswordField();
		txtPassword.setText("Senha");
		txtPassword.setToolTipText("");
		txtPassword.setBounds(74, 6, 170, 25);
		panel_1.add(txtPassword);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(6, 11, 61, 16);
		panel_1.add(lblSenha);
		
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnLogin.setFont(new Font("Arial", Font.PLAIN, 12));
		btnLogin.setBackground(Color.WHITE);
		btnLogin.setBounds(167, 232, 120, 40);
		contentPane.add(btnLogin);
		
		JLabel lblLogo = new JLabel("GIT OUTFIT");
		lblLogo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLogo.setBounds(197, 57, 100, 40);
		contentPane.add(lblLogo);
		setLocationRelativeTo(null);
	}
}
