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
import modelo.Pagamento;
import java.awt.Font;

public class TelaCadastroPagamento extends JFrame{
	
	private JPanel contentPane;
	private JTextField textField_1;
	private JLabel lblDescricao;
	private JLabel lblValor;
	private JLabel lblServico;
	private JButton btnCriar;	
	private JTextField textField_2;
	private JTextField textField;
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
	public TelaCadastroPagamento() {
		setTitle("Cadastrar Pagamento");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 389, 211);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblDescricao = new JLabel("Cliente");
		lblDescricao.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDescricao.setBounds(11, 37, 46, 14);
		contentPane.add(lblDescricao);

		textField = new JTextField();
		textField.setBounds(86, 32, 171, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblValor = new JLabel("Funcion\u00E1rio");
		lblValor.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblValor.setBounds(3,70,73,36);
		contentPane.add(lblValor);
	
		textField_1 = new JTextField();
		textField_1.setBounds(86, 76, 171, 27);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		
		lblServico = new JLabel("Servi\u00E7o");
		lblServico.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblServico.setBounds(11, 117, 65, 27);
		contentPane.add(lblServico);
		
		textField_2 = new JTextField();
		textField_2.setBounds(86, 114, 171, 27);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		
		btnCriar = new JButton("Cadastrar");
		btnCriar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String cliente = textField.getText();
					String funcionario = textField_1.getText();
					String servico = textField_2.getText();
					Pagamento pagamento = Sistema.addPagamento(cliente,servico,funcionario);
					JOptionPane.showMessageDialog(null,"cadastrado "+pagamento);
					
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
		btnCriar.setBounds(258, 148, 115, 23);
		contentPane.add(btnCriar);
		
	

		

		
	}
}
