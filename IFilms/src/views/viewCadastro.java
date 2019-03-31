package views;
import classes.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSpinner;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButtonMenuItem;

public class viewCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JPasswordField txtSenha;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {	
					viewCadastro frame = new viewCadastro();
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
	
	public viewCadastro() {
		getContentPane().setBackground(Color.WHITE);
		TListaPessoa listaPessoa =  new TListaPessoa();
		Arquivo arq = new Arquivo();
		arq.carregaCadastrados(listaPessoa);
		listaPessoa.imprimePessoas();
		getContentPane().setFont(new Font("Palatino Linotype", Font.PLAIN, 14));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Cadastro - iFilms");
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblCadastro = new JLabel("Cadastre-se");
		lblCadastro.setBounds(21, 11, 348, 66);
		getContentPane().add(lblCadastro);
		lblCadastro.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCadastro.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastro.setForeground(new Color(255, 102, 0));
		lblCadastro.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 48));
		lblCadastro.setBackground(Color.BLUE);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(60, 99, 75, 29);
		lblNome.setFont(new Font("Palatino Linotype", Font.PLAIN, 18));
		getContentPane().add(lblNome);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(60, 187, 75, 28);
		lblEmail.setFont(new Font("Palatino Linotype", Font.PLAIN, 18));
		getContentPane().add(lblEmail);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setBounds(60, 354, 46, 24);
		lblIdade.setFont(new Font("Palatino Linotype", Font.PLAIN, 18));
		getContentPane().add(lblIdade);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(60, 276, 75, 24);
		lblSenha.setFont(new Font("Palatino Linotype", Font.PLAIN, 18));
		getContentPane().add(lblSenha);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(267, 354, 46, 24);
		lblSexo.setFont(new Font("Palatino Linotype", Font.PLAIN, 18));
		getContentPane().add(lblSexo);
		
		txtNome = new JTextField();
		txtNome.setBounds(60, 128, 285, 31);
		txtNome.setFont(new Font("Palatino Linotype", Font.PLAIN, 14));
		getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(60, 214, 285, 31);
		txtEmail.setFont(new Font("Palatino Linotype", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		getContentPane().add(txtEmail);
		
		JSpinner txtIdade = new JSpinner(new SpinnerNumberModel(Long.valueOf(0), Long.valueOf(0), null, Long.valueOf(1)));
		txtIdade.setBounds(60, 385, 56, 23);
		txtIdade.setFont(new Font("Palatino Linotype", Font.PLAIN, 14));
		txtIdade.setValue(0);
		getContentPane().add(txtIdade);
		
		ButtonGroup buttonGroup1 =  new ButtonGroup();
		JRadioButton txtMasc = new JRadioButton("Masculino");
		txtMasc.setBounds(236, 385, 109, 23);
		txtMasc.setFont(new Font("Palatino Linotype", Font.PLAIN, 14));
		
		JRadioButton txtFem = new JRadioButton("Feminino");
		txtFem.setBounds(236, 414, 109, 23);
		txtFem.setFont(new Font("Palatino Linotype", Font.PLAIN, 14));
		
		buttonGroup1.add(txtMasc);
		buttonGroup1.add(txtFem);
		
		getContentPane().add(txtFem);
		getContentPane().add(txtMasc);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(89, 461, 224, 38);
		btnCadastrar.setBackground(new Color(58,65,84));
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setFocusPainted(false);
		btnCadastrar.setBorderPainted(false);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadastrar.setFocusPainted(false);
		btnCadastrar.setBorderPainted(false);
		btnCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCadastrar.setBackground(new Color(235,235,235));
				btnCadastrar.setForeground(new Color(58,65,84));
				btnCadastrar.setBorderPainted(true);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnCadastrar.setBackground(new Color(58,65,84));
				btnCadastrar.setForeground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
					
				TInfoPessoa item = new TInfoPessoa();
					item.setNome(txtNome.getText().toString());
					item.setSenha( new String(txtSenha.getPassword()));
					item.setEmail(txtEmail.getText().toString());
					item.setIdade(Integer.parseInt(txtIdade.getValue().toString()));
					if(txtMasc.isSelected())
				         item.setSexo("Masculino") ;
					if(txtFem.isSelected())
						 item.setSexo("Feminino");
					System.out.println("\n\n----inserindo------------");
					
					listaPessoa.InsereFinal(item);
					listaPessoa.imprimePessoas();
					arq.salvarArquivo(listaPessoa);
					
					TListaPessoa ListaUsuario = new TListaPessoa();
					Arquivo arquivo =  new Arquivo();
					arquivo.carregaCadastrados(ListaUsuario);
					TNodoPessoa user = ListaUsuario.pesquisaUsuario(txtEmail.getText(), new String(txtSenha.getPassword()));
					if (user!=null) {
						viewInicio tela =  new viewInicio(user);
						setVisible(false);
						tela.setVisible(true);
					
					}
					
			}
		});
		
		
	
		btnCadastrar.setFont(new Font("Palatino Linotype", Font.PLAIN, 14));
		getContentPane().add(btnCadastrar);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(60, 301, 285, 31);
		txtSenha.setFont(new Font("Palatino Linotype", Font.PLAIN, 14));
		getContentPane().add(txtSenha);
		setSize(new Dimension(411, 559));//tamanho do formulário 1000 / 700
		setLocationRelativeTo(null);//centralizado
		JLabel lblBemVindo = new JLabel("bem vindo ");

	}
	

}
