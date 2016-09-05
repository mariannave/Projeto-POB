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

public class TelaRemoverServico extends JFrame{
	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNome;
	private JButton btnCriar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRemoverServico frame = new TelaRemoverServico();
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
	public TelaRemoverServico() {
		setTitle("Remover Servico");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 387, 199);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(183, 54, 171, 27);
		contentPane.add(textField);
		textField.setColumns(10);

		lblNome = new JLabel("Nome do serviço :");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNome.setBounds(12, 54, 170, 27);
		contentPane.add(lblNome);

		
		btnCriar = new JButton("Remover");
		btnCriar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String nome = textField.getText();
					Sistema.removerServico(nome);
					JOptionPane.showMessageDialog(null,"Serviço "+nome+" Removido com sucesso!");
					
					textField.setText("");
					textField.requestFocus();
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(null,erro.getMessage());
				}
			}
		});
		btnCriar.setBounds(239, 123, 115, 23);
		contentPane.add(btnCriar);
		
	}
}
