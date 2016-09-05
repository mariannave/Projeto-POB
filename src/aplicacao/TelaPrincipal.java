package aplicacao;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import fachada.Sistema;

public class TelaPrincipal {

	private JFrame frmPrincipal;
	private JMenuItem mntmCadastrar;
	private JMenuItem mntmListar;
	private JMenu mnProduto;
	private JMenu mnCliente;
	private JMenu mnServico;
	private JMenuItem mntmListar_1;
	private JMenuItem mntmCadastrar_2;
	private JMenuItem mntmListar_2;
	private JMenu mnFuncionrio;
	private JMenuItem mntmCadastrar_3;
	private JMenuItem mntmListar_3;
	private JMenu mnPagamento;
	private JMenuItem mntmCadastrar_4;
	private JMenuItem mntmListar_4;
	private JMenuItem mntmRemoverServico;
	private JMenuItem mntmAtualizarNome;
	private JMenuItem mntmAtualizarTelCliente;
	private JMenuItem mntmAtualizarQuantidade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frmPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPrincipal = new JFrame();
		frmPrincipal.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				Sistema.inicializar();
				JOptionPane.showMessageDialog(null, "sistema inicializado !");
			}
			@Override
			public void windowClosing(WindowEvent e) {
				Sistema.finalizar();
				JOptionPane.showMessageDialog(null, "sistema finalizado !");
			}
		});
		frmPrincipal.setTitle("Sistema de Servicos");
		frmPrincipal.setBounds(100, 100, 493, 333);
		frmPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPrincipal.getContentPane().setLayout(null);
		
		JLabel lblBemVindo = new JLabel("Bem vindo!");
		lblBemVindo.setFont(new Font("Tekton Pro", Font.PLAIN, 49));
		lblBemVindo.setBounds(129, 108, 283, 71);
		frmPrincipal.getContentPane().add(lblBemVindo);
		
		JMenuBar menuBar = new JMenuBar();
		frmPrincipal.setJMenuBar(menuBar);
			
		
		/**
		 *
		 * MENU CLIENTE *
		 * 
		 **/
		
		mnCliente = new JMenu("Cliente");
		menuBar.add(mnCliente);
		// Cadastrando Cliente
		JMenuItem mntmCadastrar_1 = new JMenuItem("Cadastrar");
		mntmCadastrar_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				TelaCadastroCliente j = new TelaCadastroCliente();
				j.setVisible(true);
			}
		});
		mnCliente.add(mntmCadastrar_1);
		
		//Listando Clientes
		mntmListar_1 = new JMenuItem("Listar");
		
		mntmListar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListagemCliente c = new TelaListagemCliente();
				c.setVisible(true);
			}
		});
		mnCliente.add(mntmListar_1);
		
		mntmAtualizarTelCliente = new JMenuItem("Atualizar Telefone");
		mntmAtualizarTelCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaAtTelCliente c = new TelaAtTelCliente();
				c.setVisible(true);
			}
		});
		mnCliente.add(mntmAtualizarTelCliente);
		
		
		/**
		 *
		 * MENU SERVI�O *
		 * 
		 **/
		mnServico = new JMenu("Servico");
		
		menuBar.add(mnServico);
		
		
		//Cadastrando Servi�o
		mntmCadastrar_2 = new JMenuItem("Cadastrar");
		mntmCadastrar_2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				TelaCadastroServico j = new TelaCadastroServico();
				j.setVisible(true);
			}
		});
		mnServico.add(mntmCadastrar_2);
		// Listando Servi�o
		mntmListar_2 = new JMenuItem("Listar");
		mntmListar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListagemServico c = new TelaListagemServico();
				c.setVisible(true);
			}
		});
		mnServico.add(mntmListar_2);
		
		//Adicionando produto ao servico
		JMenuItem mntmAdicionarProdutoservico = new JMenuItem("Adicionar Produto/Serviço");
		mntmAdicionarProdutoservico.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				TelaCadastroProdServico j = new TelaCadastroProdServico();
				j.setVisible(true);
			}
		});
		mnServico.add(mntmAdicionarProdutoservico);
		
		//Atualizar nome do servico
		
		mntmAtualizarNome = new JMenuItem("Atualizar Nome");
		mntmAtualizarNome.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				TelaAtNomeServ c = new TelaAtNomeServ();
				c.setVisible(true);
			}
		});
		
		mnServico.add(mntmAtualizarNome);
		
		/**
		 *
		 * MENU PRODUTO *
		 * 
		 **/
		
		mnProduto = new JMenu("Produto");
		menuBar.add(mnProduto);
		//Cadastrando produtos
		mntmCadastrar = new JMenuItem("Cadastrar");
		mntmCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroProduto j = new TelaCadastroProduto();
				j.setVisible(true);
			}
		});
		mnProduto.add(mntmCadastrar);
		//Listando Produtos
		mntmListar = new JMenuItem("Listar");
		mntmListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListagemProduto j = new TelaListagemProduto();
				j.setVisible(true);
			}
		});
		mnProduto.add(mntmListar);
		
		//ATUALIZAR QUANTIDADE DE PRODUTO
		mntmAtualizarQuantidade = new JMenuItem("Atualizar Quantidade");
		mntmAtualizarQuantidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaAtQtdeProduto j = new TelaAtQtdeProduto();
				j.setVisible(true);
			}
		});
		mnProduto.add(mntmAtualizarQuantidade);
		

		/**
		 *
		 * MENU FUNCIONARIO *
		 * 
		 **/
		mnFuncionrio = new JMenu("Funcion\u00E1rio");
		menuBar.add(mnFuncionrio);
		
		mntmCadastrar_3 = new JMenuItem("Cadastrar");
		mntmCadastrar_3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				TelaCadastroFuncionario j = new TelaCadastroFuncionario();
				j.setVisible(true);
			}
		});
		mnFuncionrio.add(mntmCadastrar_3);
		//Listando Funcionarios
		mntmListar_3 = new JMenuItem("Listar");
		mntmListar_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListagemFuncionario c = new TelaListagemFuncionario();
				c.setVisible(true);
			}
		});
		mnFuncionrio.add(mntmListar_3);
		
		
		/**
		 *
		 * MENU PAGAMENTO *
		 * 
		 **/
		mnPagamento = new JMenu("Pagamento");
		menuBar.add(mnPagamento);
		//Cadastrando Pagamento
		mntmCadastrar_4 = new JMenuItem("Cadastrar");
		mntmCadastrar_4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				TelaCadastroPagamento j = new TelaCadastroPagamento();
				j.setVisible(true);
			}
		});
		
		mnPagamento.add(mntmCadastrar_4);
		//Listando Pagamentos de Clientes
		mntmListar_4 = new JMenuItem("Listar Pagamentos");
		mntmListar_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListagemPagamentos c = new TelaListagemPagamentos();
				c.setVisible(true);
			}
		});
		mnPagamento.add(mntmListar_4);
		

		/**
		 *
		 * MENU REMOÇÃO *
		 * 
		 **/
		JMenu mnRemoo = new JMenu("Remoção");
		menuBar.add(mnRemoo);
		//Removendo Produto
		JMenuItem mntmRemoverProduto = new JMenuItem("Remover Produto");
		mntmRemoverProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaRemoverProduto c = new TelaRemoverProduto();
				c.setVisible(true);
			}
		});
		mnRemoo.add(mntmRemoverProduto);
		//Removendo Cliente
		JMenuItem mntmRemoverCliente = new JMenuItem("Remover Cliente");
		mntmRemoverCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaRemoverCLiente c = new TelaRemoverCLiente();
				c.setVisible(true);
			}
		});
		mnRemoo.add(mntmRemoverCliente);
		//Removendo Funcionário
		JMenuItem mntmRemoverFuncionrio = new JMenuItem("Remover Funcionário");
		mntmRemoverFuncionrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaRemoverFuncionario c = new TelaRemoverFuncionario();
				c.setVisible(true);
			}
		});
		mnRemoo.add(mntmRemoverFuncionrio);

		//REMOVENDO SERVICO
		mntmRemoverServico = new JMenuItem("Remover Serviço");
		mntmRemoverServico.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				TelaRemoverServico c = new TelaRemoverServico();
				c.setVisible(true);
			}
		});
		mnRemoo.add(mntmRemoverServico);
	}
}