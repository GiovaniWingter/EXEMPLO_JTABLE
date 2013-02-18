package br.com.lab.telas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;

public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tabela;
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
					Principal frame = new Principal();
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
	public Principal() {
		setTitle("Exemplo de utiliza\u00E7\u00E3o JTable");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(10, 191, 564, 159);
		contentPane.add(scroll);

		//dados da tabela
		String[][] dados = new String[][] {
				{"Helvetica", "25", "Feminino"},
				{"Joca", "15", "Masculino"}
			};
		String[] colunas = new String[] {
				"Nome", "Idade", "Sexo"
			};
		
		
		tabela = new JTable();
		tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		DefaultTableModel model = new DefaultTableModel(dados,colunas);
		tabela.setModel(model);

		
		scroll.setViewportView(tabela);
		
		tabela.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int linha = tabela.getSelectedRow();
				if(linha != -1 ){
					textField.setText((String) tabela.getValueAt(linha, 0));
					textField_1.setText((String) tabela.getValueAt(linha, 1));
					textField_2.setText((String) tabela.getValueAt(linha, 2));
				}
				
			}
		});
		
		
		JLabel lblExemploDeUtilizao = new JLabel("Formul\u00E1rio de cadastro");
		lblExemploDeUtilizao.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblExemploDeUtilizao.setBounds(10, 11, 301, 26);
		contentPane.add(lblExemploDeUtilizao);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setFont(new Font("Arial", Font.BOLD, 12));
		lblNome.setBounds(20, 48, 80, 14);
		contentPane.add(lblNome);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdade.setFont(new Font("Arial", Font.BOLD, 12));
		lblIdade.setBounds(20, 73, 80, 14);
		contentPane.add(lblIdade);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSexo.setFont(new Font("Arial", Font.BOLD, 12));
		lblSexo.setBounds(20, 98, 80, 14);
		contentPane.add(lblSexo);
		
		textField = new JTextField();
		textField.setBounds(110, 46, 200, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(110, 71, 50, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(110, 96, 100, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField.getText().equals("") || textField_1.getText().equals("") || textField_2.getText().equals("")){
					JOptionPane.showMessageDialog(rootPane, "Campo Vazio!");
				}else{
					String[] novaLinha = new String[]{textField.getText(),textField_1.getText(),textField_2.getText()};
					DefaultTableModel model = (DefaultTableModel)tabela.getModel();
					model.addRow(novaLinha);
					JOptionPane.showMessageDialog(rootPane, "OK!");
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
				}
			}
		});
		btnNewButton.setBounds(110, 127, 100, 23);
		contentPane.add(btnNewButton);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model = (DefaultTableModel)tabela.getModel();
				int numLinha  = tabela.getSelectedRow();
				if(numLinha != -1){
					model.removeRow(numLinha);
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					JOptionPane.showMessageDialog(rootPane, "OK!");
				}else{
					JOptionPane.showMessageDialog(rootPane, "Selecione a linha primeiro!");
				}
			}
		});
		btnRemover.setBounds(321, 127, 89, 23);
		contentPane.add(btnRemover);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				DefaultTableModel model = (DefaultTableModel)tabela.getModel();
				int linha = tabela.getSelectedRow();
				if(linha != -1){
					model.setValueAt(textField.getText(), linha, 0);
					model.setValueAt(textField_1.getText(), linha, 1);
					model.setValueAt(textField_2.getText(), linha, 2);
					JOptionPane.showMessageDialog(rootPane, "OK!");
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					tabela.clearSelection();
				}else{
					JOptionPane.showMessageDialog(rootPane, "Selecione uma linha primeiro!");
				}
			}
		});
		btnAlterar.setBounds(222, 127, 89, 23);
		contentPane.add(btnAlterar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Principal.class.getResource("/br/com/images/logoJava.png")));
		label.setBounds(414, 0, 170, 168);
		contentPane.add(label);
		
		JLabel lblUsuriosCadastrados = new JLabel("Usu\u00E1rios cadastrados");
		lblUsuriosCadastrados.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblUsuriosCadastrados.setBounds(10, 161, 301, 26);
		contentPane.add(lblUsuriosCadastrados);
	}
}