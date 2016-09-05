package aplicacao;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;



import fachada.Sistema;

public class TelaAtTelCliente extends JFrame{
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNome;
	private JButton btnCriar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAtTelCliente frame = new TelaAtTelCliente();
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
	public TelaAtTelCliente() {
		setTitle("Atualizar Cliente");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 387, 199);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(22, 55, 211, 23);
		contentPane.add(textField);
		textField.setColumns(10);

		lblNome = new JLabel("Nome do cliente :");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNome.setBounds(12, 23, 309, 36);
		contentPane.add(lblNome);
		
		JLabel lblNovoTel= new JLabel("Novo Telefone:");
		lblNovoTel.setBounds(12, 102, 136, 15);
		contentPane.add(lblNovoTel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(22, 121, 211, 23);
		contentPane.add(textField_1);

		
		btnCriar = new JButton("Atualizar");
		btnCriar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String nome = textField.getText();
					String novoTel = textField_1.getText();
					Sistema.atualizaTelCliente(nome, novoTel);
					JOptionPane.showMessageDialog(null,"O telefone do cliente "+nome+" foi alterado para: " + novoTel);
					
					textField.setText("");
					textField_1.setText("");
					textField.requestFocus();
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(null,erro.getMessage());
				}
			}
		});
		btnCriar.setBounds(246, 150, 115, 23);
		contentPane.add(btnCriar);
		

		
	}
}
