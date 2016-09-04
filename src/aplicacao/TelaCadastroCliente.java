package aplicacao;

import java.awt.EventQueue;
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
import modelo.Cliente;
import java.awt.Font;

public class TelaCadastroCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNome;
	private JLabel lblTelefone;
	private JLabel lblEndereco;
	private JButton btnCriar;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroCliente frame = new TelaCadastroCliente();
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
	public TelaCadastroCliente() {
		setTitle("Cadastrar Cliente");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 387, 199);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(72, 11, 171, 27);
		contentPane.add(textField);
		textField.setColumns(10);

		lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNome.setBounds(10, 17, 52, 21);
		contentPane.add(lblNome);

		lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTelefone.setBounds(10, 89, 62, 21);
		contentPane.add(lblTelefone);

		lblEndereco = new JLabel("Endereço");
		lblEndereco.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEndereco.setBounds(10,55,65,27);
		contentPane.add(lblEndereco);
		
		textField_2 = new JTextField();
		textField_2.setBounds(72, 49, 171, 27);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		
		textField_1 = new JTextField();
		textField_1.setBounds(72, 87, 171, 27);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		btnCriar = new JButton("Cadastrar");
		btnCriar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String nome = textField.getText();
					String telefone = textField_1.getText();
					String endereco = textField_2.getText();
					Cliente cliente = Sistema.cadastroCliente(nome,telefone,endereco);
					JOptionPane.showMessageDialog(null,"cadastrado "+cliente.getNome());
					
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField.requestFocus();
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(null,erro.getMessage());
				}
			}
		});
		btnCriar.setBounds(256, 136, 115, 23);
		contentPane.add(btnCriar);
		
	}
}
