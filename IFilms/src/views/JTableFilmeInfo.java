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

public class JTableFilmeInfo extends JFrame {


	private JPanel contentPane;
	private JTextField txtBusca;
	public JButton btnFechar;
	public boolean clicado = false;
	
	public JTableFilmeInfo(TNodo filme, JDialog dialog) {
		setAlwaysOnTop(true);
		setTitle("Descrição");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setBounds(600, 200, 500, 300);
		
		JLabel lblNewLabel = new JLabel("Título: " + filme.Item.Title);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblNewLabel.setBounds(10, 11, 304, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblContedo = new JLabel("<html>Descrição: " + filme.Item.Overview + "</html>");
		lblContedo.getAutoscrolls();
		lblContedo.setHorizontalAlignment(SwingConstants.LEFT);
		//lblContedo.setLineWrap(true);
		
		lblContedo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblContedo.setBounds(10, 36, 304, 149);
		getContentPane().add(lblContedo);
		
		JLabel lblNewLabel_1 = new JLabel("Generos:" + filme.Item.Genres);
		lblNewLabel_1.setBounds(10, 196, 387, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNota = new JLabel("Nota: " + filme.Item.VoteAvarage);
		lblNota.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNota.setBounds(332, 50, 65, 14);
		getContentPane().add(lblNota);
		
		JLabel lblProdutora = new JLabel("Produtora: " + filme.Item.ProductionCompanies);
		lblProdutora.setBounds(10, 212, 387, 14);
		getContentPane().add(lblProdutora);
		
		JLabel lblPopularidade = new JLabel("Popularidade " + filme.Item.Popularity);
		lblPopularidade.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblPopularidade.setBounds(332, 76, 152, 14);
		getContentPane().add(lblPopularidade);
		
		JLabel lblArrecadao = new JLabel("Arrecadação: " + filme.Item.Revenue);
		lblArrecadao.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblArrecadao.setBounds(332, 101, 152, 14);
		getContentPane().add(lblArrecadao);
		
		btnFechar = new JButton("Fechar");
		btnFechar.setBounds(199, 237, 89, 23);
		btnFechar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {
		       setVisible(false);
		       dialog.setVisible(true);
		    }
		});
		getContentPane().add(btnFechar);
		
		getContentPane().setVisible(true);
	}
	}