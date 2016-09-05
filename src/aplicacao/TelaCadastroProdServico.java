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
import modelo.Servico;

public class TelaCadastroProdServico extends JFrame{

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNome;
	private JLabel lblEndereco;
	private JButton btnCriar;
	private JTextField textField_1;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroProdServico frame = new TelaCadastroProdServico();
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
	public TelaCadastroProdServico() {
		setTitle("Adicionario Produto ao Serviço");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 387, 199);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(105, 48, 171, 27);
		contentPane.add(textField);
		textField.setColumns(10);

		lblNome = new JLabel("Produto");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNome.setBounds(15, 49, 62, 24);
		contentPane.add(lblNome);

		lblEndereco = new JLabel("Servico");
		lblEndereco.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEndereco.setBounds(12,85,65,27);
		contentPane.add(lblEndereco);

		textField_1 = new JTextField();
		textField_1.setBounds(105, 87, 171, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		btnCriar = new JButton("Cadastrar");
		btnCriar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String produto = textField.getText();
					String servico = textField_1.getText();
					Sistema.addProdutoServico(servico,produto);
					JOptionPane.showMessageDialog(null,"Produto adicionado ao servico com sucesso!");
					
					textField.setText("");
					textField_1.setText("");
					textField.requestFocus();
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(null,erro.getMessage());
				}
			}
		});
		btnCriar.setBounds(247, 136, 115, 23);
		contentPane.add(btnCriar);
		
	}
}
