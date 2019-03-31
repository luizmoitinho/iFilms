package views;
import classes.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

public class viewInicio extends JFrame {


	private JPanel contentPane;
	private JTextField txtBusca;

	/**
	 * Launch the application.
	 */

//	public static void main(String[] args) {	
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					viewInicio frame = new viewInicio();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	public viewInicio(TNodoPessoa user) {
		
		Arquivo arquivo=new Arquivo();
		TLista lista=new TLista();
		arquivo.Carrega(lista);
		lista.MergeSort_title();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 650);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("CheckBox.interiorBackground"));
		setLocationRelativeTo(null);
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setTitle("iFilms - A Sua Plataforma de Filmes");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel perfil = new JPanel();
		perfil.setBounds(0, 0, 220, 161);
		perfil.setBackground(new Color(56, 87, 116));
		contentPane.add(perfil);
		perfil.setLayout(null);
		
		JLabel lblBoasVindas = new JLabel("Olá, "+user.Item.getNome());
		lblBoasVindas.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		lblBoasVindas.setForeground(Color.WHITE);
		lblBoasVindas.setBounds(10, 30, 200, 24);
		
		perfil.add(lblBoasVindas);
		
		JLabel lblEmail = new JLabel(user.Item.getEmail());
		lblEmail.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setBounds(10, 65, 200, 24);
		perfil.add(lblEmail);
		
		JButton btnSair = new JButton("Desconetar-se");
		btnSair.setVerticalAlignment(SwingConstants.TOP);
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				System.exit(0);
			}
		});
		btnSair.setFont(new Font("Palatino Linotype", Font.BOLD, 18));
		btnSair.setFocusPainted(false);
		btnSair.setBorderPainted(false);
		
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSair.setForeground(new Color(255, 255, 224));
		btnSair.setBackground(Color.ORANGE);
		btnSair.setBounds(10, 124, 184, 30);
		perfil.add(btnSair);
		setLocationRelativeTo(null);
		
		JPanel generos = new JPanel();
		generos.setBounds(0, 161, 220, 284);
		generos.setBorder(new LineBorder(new Color(0, 0, 0)));
		generos.setBackground(SystemColor.menu);
		contentPane.add(generos);
		generos.setLayout(null);
		
		JLabel lblFiltrar = new JLabel("Ordenar por ");
		lblFiltrar.setForeground(new Color(255, 165, 0));
		lblFiltrar.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
		lblFiltrar.setBounds(44, 25, 109, 23);
		generos.add(lblFiltrar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 48, 180, 17);
		generos.add(separator);
		
		JLabel tempoProcessamento = new JLabel("");
		tempoProcessamento.setForeground(SystemColor.activeCaption);
		tempoProcessamento.setFont(new Font("Times New Roman", Font.BOLD, 14));
		tempoProcessamento.setBounds(306, 74, 308, 17);
		contentPane.add(tempoProcessamento);
		
		JRadioButton rdGastos = new JRadioButton("Custo de Produção");
		rdGastos.setBounds(10, 198, 189, 23);
		generos.add(rdGastos);
		
		rdGastos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TLista listaLocal =  new TLista();
				
				long validaMin=0, validaMax=0;
				String  min="", max="";  
				while (min.equals("") && max.equals("")) {
					min = JOptionPane.showInputDialog("Valor mínimo: ");
					max = JOptionPane.showInputDialog("Valor máximo: ");
					
					if(min==null || min.equals("") && max.equals(""))
						break;
					if (min==null || min.equals(""))
						JOptionPane.showMessageDialog(null,"É necessário informar o valor mínimo!");
					if (max==null || max.equals("")) 
						JOptionPane.showMessageDialog(null,"É necessário informar o valor máximo!");
					if(validaMin > validaMax)
						JOptionPane.showMessageDialog(null,"O valor mínimo não pode ser maior que o máximo!!");
					else {
						validaMin = ConverteTipo.strToLong(min);validaMax =  ConverteTipo.strToLong(max);
						if(validaMin==-1 ||validaMax==-1)
							JOptionPane.showMessageDialog(null,"Informe apenas números!");

					}
				
				}
			   if(min != null && max != null){
				    long tempoInicial = System.currentTimeMillis();
				    
					listaLocal = lista.BuscaBudget(validaMin, validaMax);
					listaLocal.MergeSort_Budget();
					
					tempoProcessamento.setText("Pesquisa realizada em: " + (System.currentTimeMillis() - tempoInicial) +" milisegundos");
					TNodo aux =  listaLocal.Primeiro.Proximo;
					final String [] colunas= {"Titulo"," Gastos (Custo de Produção)"};	
					final String [][] dados = new String[listaLocal.Primeiro.Item.id][2];	
					int i=0;
					int j=0;
					while(aux!=null) {
						dados[i][j] = aux.Item.Title;
						dados[i][++j]= Long.toString(aux.Item.Budget);
						i++;j=0;
						aux=aux.Proximo;
					}
					CriarTable(dados, colunas, listaLocal);
				}
			}
		});
		

		
		JRadioButton rdNumArrecadacao = new JRadioButton("Valor Arrecadado");
		rdNumArrecadacao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TLista listaLocal =  new TLista();
				
				long validaMin=0, validaMax=0;
				String  min="", max="";  
				while (min.equals("") && max.equals("")) {
					min = JOptionPane.showInputDialog("Valor mínimo: ");
					max = JOptionPane.showInputDialog("Valor máximo: ");
					
					if(min==null || min.equals("") && max.equals(""))
						break;
					if (min==null || min.equals(""))
						JOptionPane.showMessageDialog(null,"É necessário informar o valor mínimo!");
					if (max==null || max.equals("")) 
						JOptionPane.showMessageDialog(null,"É necessário informar o valor máximo!");
					if(validaMin > validaMax)
						JOptionPane.showMessageDialog(null,"O valor mínimo não pode ser maior que o máximo!!");
					else {
						validaMin = ConverteTipo.strToLong(min);validaMax =  ConverteTipo.strToLong(max);
						if(validaMin==-1 ||validaMax==-1)
							JOptionPane.showMessageDialog(null,"Informe apenas números!");

					}
				
				}
			   if(min != null && max != null){
				    long tempoInicial = System.currentTimeMillis();
					listaLocal = lista.BuscaRevenue(validaMin, validaMax);
					listaLocal.MergeSort_Revenue();
					tempoProcessamento.setText("Pesquisa realizada em: " + (System.currentTimeMillis() - tempoInicial) +" milisegundos");
					TNodo aux =  listaLocal.Primeiro.Proximo;
					final String [] colunas= {"Titulo"," Valor Arrecadado"};	
					final String [][] dados = new String[listaLocal.Primeiro.Item.id][2];	
					int i=0;
					int j=0;
					while(aux!=null) {
						dados[i][j] = aux.Item.Title;
						dados[i][++j]= Long.toString(aux.Item.Revenue);
						i++;j=0;
						aux=aux.Proximo;
					}
					CriarTable(dados, colunas, listaLocal);
				}else {
					JOptionPane.showMessageDialog(null, "Filme não encontrado!", "A pesquisa não encontrou nenhum filme.",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		rdNumArrecadacao.setBounds(10, 164, 194, 32);
		generos.add(rdNumArrecadacao);
		ButtonGroup tiposOrdenacao =  new ButtonGroup();
		
		tiposOrdenacao.add(rdNumArrecadacao);
		tiposOrdenacao.add(rdGastos);
		
		txtBusca = new JTextField();
		txtBusca.setToolTipText("Digite um titulo");
		txtBusca.setBounds(395, 23, 409, 42);
		contentPane.add(txtBusca);
		txtBusca.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(SystemColor.menu);
		panel.setBounds(296, 23, 99, 42);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Buscar");
		lblNewLabel.setBounds(20, 11, 53, 24);
		panel.add(lblNewLabel);
		lblNewLabel.setBackground(new Color(0, 0, 139));
		lblNewLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 17));
		
		JButton btnBusca = new JButton("Ok");
		btnBusca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBusca.setForeground(Color.WHITE);
		btnBusca.setBackground(new Color(37, 59, 128));
		btnBusca.setBounds(807, 23, 63, 42);
		btnBusca.setFocusPainted(false);
		btnBusca.setBorderPainted(false);
		contentPane.add(btnBusca);
		
	

		JRadioButton rdAno = new JRadioButton("Ano");
		rdAno.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		rdAno.setBounds(10, 86, 109, 23);
		generos.add(rdAno);
		tiposOrdenacao.add(rdAno);
		
		JRadioButton rdMaiorNota = new JRadioButton("Nota");
		rdMaiorNota.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TLista listaLocal =  new TLista();
				float validaMin=0, validaMax=0;
				String  min="", max="";  
				while (min.equals("") && max.equals("")) {
					
					min = JOptionPane.showInputDialog("Valor mínimo: ");
					max = JOptionPane.showInputDialog("Valor máximo: ");
				
					if(min==null || min.equals("") && max.equals(""))
						break;
					if (min==null || min.equals(""))
						JOptionPane.showMessageDialog(null,"É necessário informar o valor mínimo!");
					if (max==null || max.equals("")) 
						JOptionPane.showMessageDialog(null,"É necessário informar o valor máximo!");
					if(validaMin > validaMax)
						JOptionPane.showMessageDialog(null,"O valor mínimo não pode ser maior que o máximo!!");
					
					else {
						validaMin = ConverteTipo.strToFloat(min);validaMax =  ConverteTipo.strToFloat(max);
						if(validaMin==-1 ||validaMax==-1)
							JOptionPane.showMessageDialog(null,"Informe apenas números!");
						
					}
				
				}
				if(min != null && max != null){
					System.out.println("valida min : "+validaMin);
					System.out.println("valida min : "+validaMax);
					long tempoInicial = System.currentTimeMillis();
					
					listaLocal = lista.BuscaNota(validaMin,validaMax);
					listaLocal.MergeSort_Nota();
					tempoProcessamento.setText("Pesquisa realizada em: " + (System.currentTimeMillis() - tempoInicial) +" milisegundos");
					TNodo aux =  listaLocal.Primeiro.Proximo;
					final String [] colunas= {"Nota"," Titulo "};	
					final String [][] dados = new String[listaLocal.Primeiro.Item.id][2];	
					int i=0;
					int j=0;
					while(aux!=null) {
						dados[i][j] = Float.toString(aux.Item.VoteAvarage);
						dados[i][++j]= aux.Item.Title;
						i++;j=0;
						aux=aux.Proximo;
					}
					CriarTable(dados, colunas, listaLocal);
				}else {
					JOptionPane.showMessageDialog(null, "Filme não encontrado!", "A pesquisa não encontrou nenhum filme.",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		rdMaiorNota.setBounds(10, 112, 153, 23);
		generos.add(rdMaiorNota);
		tiposOrdenacao.add(rdMaiorNota);
		
		JRadioButton rdPopularidade = new JRadioButton("Popularidade");
		rdPopularidade.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TLista listaLocal =  new TLista();
				
				long validaMin=0, validaMax=0;
				String  min="", max="";  
				while (min.equals("") && max.equals("")) {
					min = JOptionPane.showInputDialog("Valor mínimo: ");
					max = JOptionPane.showInputDialog("Valor máximo: ");
					
					if(min==null || min.equals("") && max.equals(""))
						break;
					if (min==null || min.equals(""))
						JOptionPane.showMessageDialog(null,"É necessário informar o valor mínimo!");
					if (max==null || max.equals("")) 
						JOptionPane.showMessageDialog(null,"É necessário informar o valor máximo!");
					if(validaMin > validaMax)
						JOptionPane.showMessageDialog(null,"O valor mínimo não pode ser maior que o máximo!!");
					
					else {
						validaMin = ConverteTipo.strToLong(min);validaMax =  ConverteTipo.strToLong(max);
						if(validaMin==-1 ||validaMax==-1)
							JOptionPane.showMessageDialog(null,"Informe apenas números!");

					}
				
				}
			 	
			if(min != null && max != null){
					long tempoInicial = System.currentTimeMillis();
					listaLocal = lista.BuscaPopularity(validaMin, validaMax);
					listaLocal.MergeSort_Popularity();
					tempoProcessamento.setText("Pesquisa realizada em: " + (System.currentTimeMillis() - tempoInicial) +" milisegundos");
					TNodo aux =  listaLocal.Primeiro.Proximo;
					final String [] colunas= {"Titulo","Popularidade (Acessos)"};	
					final String [][] dados = new String[listaLocal.Primeiro.Item.id][2];	
					int i=0;
					int j=0;
					while(aux!=null) {
						dados[i][j] = aux.Item.Title;
						dados[i][++j]= Long.toString(aux.Item.Popularity);
						i++;j=0;
						aux=aux.Proximo;
					}
					CriarTable(dados, colunas, listaLocal);
				}else {
					JOptionPane.showMessageDialog(rdPopularidade, "Não encontrado", "A pesquisa não encontrou nenhum filme.", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		rdPopularidade.setBounds(10, 138, 190, 23);
		generos.add(rdPopularidade);
		tiposOrdenacao.add(rdPopularidade);
	
		//===========================================
		btnBusca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {		
				TLista listaLocal =  new TLista();		
				if(rdAno.isSelected()) {
					long tempoInicial = System.currentTimeMillis();
					
					listaLocal = lista.BuscaAno(txtBusca.getText().toString().trim());
					listaLocal.MergeSort_Ano();
					
					tempoProcessamento.setText("Pesquisa realizada em: " + (System.currentTimeMillis() - tempoInicial) +" milisegundos");
					TNodo aux =  listaLocal.Primeiro.Proximo;
					if(aux != null) {
						final String [] colunas= {"Lancamento","Titulo"};	
						final String [][] dados = new String[listaLocal.Primeiro.Item.id][2];	
						int i=0;
						int j=0;
						while(aux!=null) {
							dados[i][j] =aux.Item.RealeseDate;
							dados[i][++j]= aux.Item.Title;
							i++;j=0;
							aux=aux.Proximo;
					}
						CriarTable(dados, colunas, listaLocal);
					}else {
						JOptionPane.showMessageDialog(null, "Filme não encontrado!", "A pesquisa não encontrou nenhum filme.",
								JOptionPane.WARNING_MESSAGE);
					}	
				}else {		
					long tempoI = System.currentTimeMillis();
					lista.searchByTitle(txtBusca.getText().toString().trim(), listaLocal);
					tempoProcessamento.setText(
							"Pesquisa realizada em: " + (System.currentTimeMillis() - tempoI) + " milisegundos");
					TNodo aux = listaLocal.Primeiro.Proximo;
					if(aux != null) {
					String[] colunas = { "Ano", "Titulo" };
					String[][] dados = new String[listaLocal.Primeiro.Item.id][2];
					System.out.println("as " + listaLocal.Primeiro.Item.id);
					int i = 0;
					int j = 0;
					while (aux != null) {
						dados[i][j] = aux.Item.RealeseDate;
						dados[i][++j] = aux.Item.Title;
						i++;
						j = 0;
						aux = aux.Proximo;
					}
					CriarTable(dados, colunas, listaLocal);
					}else {
						JOptionPane.showMessageDialog(null, "Filme não encontrado!", "A pesquisa não encontrou nenhum filme.",
								JOptionPane.WARNING_MESSAGE);
					}
				}
				txtBusca.setText("");
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnBusca.setBounds(807, 23, 63, 43);
				btnBusca.setBackground(new Color(255,255,255));
				btnBusca.setForeground(new Color(37, 59, 128));
				btnBusca.setBorderPainted(true);
				
				
			}
			public void mouseExited(MouseEvent arg0) {
				btnBusca.setForeground(Color.WHITE);
				btnBusca.setBackground(new Color(37, 59, 128));
				btnBusca.setBounds(807, 23, 63, 43);
			}
		});
		
	
	}
	
	public void CriarTable(String[][] dados, String[] colunas, TLista listaLocal) {
		JTable table = new JTable(dados,colunas);
		table.setPreferredScrollableViewportSize(new Dimension(700,100));// barra de rolagem
		table.setFillsViewportHeight(true);
		JScrollPane scrollPane =  new JScrollPane(table);//ADICIONA A TABELA UMA BARRA DE ROLAGEM
		scrollPane.setBounds(280, 90, 600, 600);
		JOptionPane exibeTabela = new JOptionPane();
		exibeTabela.setMessage(scrollPane);
		exibeTabela.setMessageType(JOptionPane.DEFAULT_OPTION);
        JDialog dialog = exibeTabela.createDialog(null, "\tiFilms - Pesquisa: " + txtBusca.getText().toString().trim());
        
		table.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int linha = table.getSelectedRow();
				TNodo aux = listaLocal.getPositionList(linha);
				JTableFilmeInfo filme = new JTableFilmeInfo(aux, dialog);
				filme.setVisible(true);
				dialog.setVisible(false);
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
		});
		
		
        dialog.setBounds(500, 170, 600, 500);
       // dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
	}
}
