package views;
import classes.*;
import views.viewCadastro;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class viewLogin extends JFrame {

	private JPanel contentPane;
	private JPasswordField txtSenha;
	private JFormattedTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewLogin frame = new viewLogin();
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
	public viewLogin() {
		
		JButton btnCadastrese = new JButton("Cadastre-se");
		btnCadastrese.setBounds(35, 372, 309, 37);
		JButton btnEntrar = new JButton("Entrar");
		
		btnEntrar.setBounds(35, 303, 309, 37);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Login - iFilms");
		getContentPane().setLayout(new FlowLayout());//tipo de layout
		setSize(new Dimension(404, 471));//tamanho do formulário 1000 / 700
		setLocationRelativeTo(null);//centralizado
		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panelFormLogin = new JPanel();
		panelFormLogin.setBounds(0, 0, 399, 442);
		panelFormLogin.setBackground(new Color(255, 255, 255));
		contentPane.setLayout(null);
		panelFormLogin.setLayout(null);
		panelFormLogin.add(btnEntrar);
		
		
		btnCadastrese.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnCadastrese.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadastrese.setBackground(new Color(217,81,51));
		btnCadastrese.setForeground(Color.WHITE);
		btnCadastrese.setBorderPainted(false);
		btnCadastrese.setFocusPainted(false);
		panelFormLogin.add(btnCadastrese);
	
		
		btnEntrar.setFont(new Font("SansSerif", Font.BOLD, 18));
		
		btnEntrar.setBackground(new Color(58,65,84));
		btnEntrar.setForeground(Color.WHITE);
		btnEntrar.setFocusPainted(false);
		btnEntrar.setBorderPainted(false);
		
		
		
		
		
		btnCadastrese.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnCadastrese.setBackground(new Color(235,235,235));
				btnCadastrese.setForeground(new Color(217,81,51));
				btnEntrar.setBorderPainted(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnCadastrese.setBackground(new Color(217,81,51));
				btnCadastrese.setForeground(Color.WHITE);

				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				viewCadastro cadastro =  new viewCadastro();
				cadastro.setVisible(true);
			}
		});
		
		btnEntrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnEntrar.setBackground(new Color(235,235,235));
				btnEntrar.setForeground(new Color(58,65,84));
				btnEntrar.setBorderPainted(true);

			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnEntrar.setBackground(new Color(58,65,84));
				btnEntrar.setForeground(Color.WHITE);

				
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				TListaPessoa ListaUsuario = new TListaPessoa();
				Arquivo arquivo =  new Arquivo();
				arquivo.carregaCadastrados(ListaUsuario);
				TNodoPessoa user = ListaUsuario.pesquisaUsuario(txtEmail.getText(), new String(txtSenha.getPassword()));
				if (user!=null) {
					viewInicio tela =  new viewInicio(user);
					setVisible(false);
					tela.setVisible(true);
				
				}
				else
					JOptionPane.showMessageDialog(null,"E-mail ou senha estão incorretos!","iFilms - Login",JOptionPane.YES_NO_CANCEL_OPTION    , null);			
			}
		});

		
		txtEmail = new JFormattedTextField();
		txtEmail.setBounds(35, 165, 307, 37);
		panelFormLogin.add(txtEmail);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(35, 238, 307, 37);
		panelFormLogin.add(txtSenha);
		txtSenha.setToolTipText("senha\r\n");
		contentPane.add(panelFormLogin);
		
		
	
		
		
		JLabel msgLogin = new JLabel("Forneça seus dados para acessar o sistema");
		msgLogin.setBounds(68, 99, 275, 17);
		msgLogin.setForeground(new Color(91,95,99));
		msgLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelFormLogin.add(msgLogin);
		
		JLabel lblEMail = new JLabel("E- mail");
		lblEMail.setBounds(35, 138, 85, 28);
		lblEMail.setFont(new Font("SansSerif", Font.PLAIN, 15));
		panelFormLogin.add(lblEMail);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(35, 214, 85, 28);
		lblSenha.setFont(new Font("SansSerif", Font.PLAIN, 15));
		panelFormLogin.add(lblSenha);
		
		JLabel lblLogo = new JLabel("Films");
		lblLogo.setBounds(121, 8, 141, 66);
		panelFormLogin.add(lblLogo);
		lblLogo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setForeground(new Color(255, 102, 0));
		lblLogo.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 48));
		lblLogo.setBackground(Color.BLUE);
		
		JLabel lblLogo2 = new JLabel("i");
		lblLogo2.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo2.setBounds(85, 21, 79, 56);
		lblLogo2.setFont(new Font("Monotype Corsiva", Font.BOLD, 48));
		lblLogo2.setForeground(new Color(58,65,84));
		panelFormLogin.add(lblLogo2);
	}
	
	public JFormattedTextField getFrmtdtxtfldMeuemailemailcom() {
		return txtEmail;
	}
}
