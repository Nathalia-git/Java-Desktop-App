package br.com.prog2.sh.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import br.com.prog2.sh.controller.ClienteController;
import br.com.prog2.sh.model.Cliente;
import br.com.prog2.sh.util.Util;

@SuppressWarnings("serial")
public class FrmCliente extends JFrame {

	private JPanel contentPane;
	private JTable tblConsulta;
	private MaskFormatter mascaraData = null;
	private JTextField txtCodCliente;
	private JTextField txtCidadeCliente;
	private JTextField txtBairroCliente;
	private JTextField txtNomeCliente;
	private JTextField txtCEPCliente;
	private JTextField txtRGCliente;
	private JLabel lblCodCliente;
	private JLabel lblNomeCliente;
	private JLabel lblRgCliente;
	private JLabel lblBairroCliente;
	private JLabel lblEstadoCliente;
	private JLabel lblCidadeCliente;
	private JLabel lblCEPCliente;
	private JLabel lblNascimentoCliente;
	private JFormattedTextField txtNascimentoCliente;
	private JButton btnInserir;
	private JButton btnAlterar;
	private JButton btnLimpar;
	private JButton btnPesquisar;
	private JButton btnExcluir;
	private JButton btnSair;
	private JComboBox<String> cbxEstado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCliente frame = new FrmCliente();
					frame.setTitle("Cadastro de Empregados");
					frame.pack();
					frame.setLocationRelativeTo(null);
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
	public FrmCliente() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 623, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();

		JPanel panel_1 = new JPanel();

		JPanel panel_2 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 596, Short.MAX_VALUE))
						.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)));

		lblCodCliente = new JLabel("Código:");

		lblNomeCliente = new JLabel("Nome:");

		lblRgCliente = new JLabel("RG:");

		lblBairroCliente = new JLabel("Bairro:");

		lblEstadoCliente = new JLabel("Estado:");

		lblCidadeCliente = new JLabel("Cidade:");

		lblCEPCliente = new JLabel("CEP:");

		lblNascimentoCliente = new JLabel("Data de Nascimento:");

		cbxEstado = new JComboBox<String>();
		cbxEstado.setModel(new DefaultComboBoxModel<String>(
				new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB",
						"PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

		try {
			mascaraData = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			System.err.println(e.getMessage());
		}
		txtNascimentoCliente = new JFormattedTextField(mascaraData);

		JLabel lblDdmmmmmm = new JLabel("dd/mm/mmmm");
		lblDdmmmmmm.setForeground(Color.RED);

		JLabel lblMensagem = new JLabel("Mensagem:");
		lblMensagem.setForeground(Color.BLUE);

		txtCodCliente = new JTextField();
		txtCodCliente.setColumns(10);

		txtCidadeCliente = new JTextField();
		txtCidadeCliente.setColumns(10);

		txtBairroCliente = new JTextField();
		txtBairroCliente.setColumns(10);

		txtNomeCliente = new JTextField();
		txtNomeCliente.setColumns(10);

		txtCEPCliente = new JTextField();
		txtCEPCliente.setColumns(10);

		txtRGCliente = new JTextField();
		txtRGCliente.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addComponent(lblNascimentoCliente)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtNascimentoCliente, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblDdmmmmmm).addGap(298))
				.addGroup(gl_panel.createSequentialGroup().addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup().addGap(9).addComponent(lblMensagem)
								.addPreferredGap(ComponentPlacement.RELATED, 296, Short.MAX_VALUE).addComponent(lblCep)
								.addPreferredGap(
										ComponentPlacement.RELATED)
								.addComponent(txtCEPCliente, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel
												.createSequentialGroup().addComponent(lblCodCliente)
												.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(txtCod,
														GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup().addGap(1).addGroup(gl_panel
												.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panel.createSequentialGroup().addComponent(lblNomeCliente)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 290,
																GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_panel.createSequentialGroup().addComponent(lblRg)
														.addPreferredGap(ComponentPlacement.RELATED).addComponent(txtRG,
																GroupLayout.PREFERRED_SIZE, 168,
																GroupLayout.PREFERRED_SIZE)))))
								.addGap(12)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup().addComponent(lblEstadoCliente)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(cbxEstado,
														GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
												.addGroup(gl_panel.createSequentialGroup().addComponent(lblCidadeCliente)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(txtCidadeCLiente))
												.addGroup(gl_panel.createSequentialGroup().addComponent(lblBairroCliente)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(txtBairro, GroupLayout.PREFERRED_SIZE, 158,
																GroupLayout.PREFERRED_SIZE))))))
						.addGap(148)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup().addContainerGap().addComponent(lblCodCliente)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblNomeCliente)
										.addComponent(txtNomeCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblBairroCliente).addComponent(txtBairroCliente, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup().addGap(10)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(txtCod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblCidadeCliente).addComponent(txtCidadeCliente, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGap(4)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup().addGap(7)
										.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblRg)
												.addComponent(txtRGCliente, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(19)
										.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblNascimentoCliente)
												.addComponent(txtNascimentoCliente, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblDdmmmmmm)))
								.addGroup(gl_panel.createSequentialGroup().addGap(4).addGroup(
										gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblEstadoCliente)
												.addComponent(cbxEstado, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_panel.createSequentialGroup()
										.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblCEPCliente)
												.addComponent(txtCEPCliente, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(15))
								.addGroup(gl_panel.createSequentialGroup().addComponent(lblMensagem).addGap(9)))));
		panel.setLayout(gl_panel);

		btnInserir = new JButton("Inserir");
		btnInserir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cliente cli = new Cliente();
				ClienteController cc = new ClienteController();
				cli.setCodCliente(txtCodCliente.getText());
				cli.setNomeCliente(txtNomeCliente.getText());
				cli.setRgCliente(txtRGCliente.getText());
				cli.setBairroCliente(txtBairroCliente.getText());
				cli.setCidadeCliente(txtCidadeCliente.getText());
				cli.setEstadoCliente(cbxEstadoCliente.getSelectedItem().toString());
				cli.setCEPCliente(txtCEPCliente.getText());
				int[] dataFormatada = Util.formatarDataDeGuiParaLocalDate(txtNascimentoCliente.getText());
				cli.setNascimentoCliente(LocalDate.of(dataFormatada[2], dataFormatada[1], dataFormatada[0]));
				if (cc.pesquisarPorCliente(cli.getCodCliente()) != null) {
					JOptionPane.showMessageDialog(null, "Cliente já existente", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {					
					lblMensagem.setText(cc.inserir(cli));/* Mesmo teste na Classe 'teste' */
				}
				mostrarDados();
			}
		});

		btnAlterar = new JButton("Alterar");
		btnAlterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cliente cli = new Cliente();
				ClienteController cc = new ClienteController();
				cli.setCodCliente(txtCodCliente.getText());
				cli.setNomeCliente(txtNomeCliente.getText());
				cli.setRgCliente(txtRGCliente.getText());
				cli.setBairroCliente(txtBairroCliente.getText());
				cli.setCidadeCliente(txtCidadeCliente.getText());
				cli.setEstadoCliente(cbxEstadoCliente.getSelectedItem().toString());
				cli.setCEPCliente(txtCEPCliente.getText());
				int[] dataFormatada = Util.formatarDataDeGuiParaLocalDate(txtNascimentoCliente.getText());
				cli.setDaNascimentoCliente(LocalDate.of(dataFormatada[2], dataFormatada[1], dataFormatada[0]));
				lblMensagem.setText(cc.alterar(cli));/* Mesmo teste na Classe 'teste' */
				mostrarDados();
			}
		});

		btnExcluir = new JButton("Excluir");
		btnExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cliente c = new Cliente();
				ClienteController cc = new ClienteController();
				c.setCodCliente(txtCodCliente.getText());
				c.setNomeCliente(txtNomeCliente.getText());
				Object[] opcoes = { "Sim", "Não" };
				int i = JOptionPane.showOptionDialog(null, "Deseja excluir esse cliente: " + txtNomeCliente.getText() + "?",
						"Exclusão", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

				if (JOptionPane.YES_OPTION == i) {
					lblMensagem.setText(cc.excluir(c));
				}
				mostrarDados();
			}
		});

		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarDados();
			}
		});

		btnLimpar = new JButton("Limpar");
		btnLimpar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtCodCliente.setText("");
				txtNomeCliente.setText("");
				txtRGCliente.setText("");
				txtNascimentoCliente.setText("");
				txtCidadeCliente.setText("");
				txtBairroCliente.setText("");
				txtCEPCliente.setText("");
				lblMensagem.setText("Mensagem:");
				DefaultTableModel tbm = (DefaultTableModel) tblConsulta.getModel();
				for (int i = tbm.getRowCount() - 1; i >= 0; i--) {
					tbm.removeRow(i);
				}
			}
		});

		btnSair = new JButton("Sair");
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmCliente.this.dispose();
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap().addComponent(btnInserir)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnAlterar).addGap(18)
						.addComponent(btnExcluir).addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnPesquisar).addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnLimpar).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnSair)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_panel_1.createSequentialGroup().addContainerGap(20, Short.MAX_VALUE)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(btnInserir)
								.addComponent(btnAlterar).addComponent(btnExcluir).addComponent(btnPesquisar)
								.addComponent(btnLimpar).addComponent(btnSair))
						.addContainerGap()));
		panel_1.setLayout(gl_panel_1);

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
				gl_panel_2.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_2.createSequentialGroup()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE).addContainerGap()));
		gl_panel_2.setVerticalGroup(
				gl_panel_2.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_2.createSequentialGroup()
						.addContainerGap().addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)));

		tblConsulta = new JTable();
		tblConsulta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Integer linha = tblConsulta.getSelectedRow();
				String codCliente = tblConsulta.getValueAt(linha, 0).toString();
				String nomeCliente = tblConsulta.getValueAt(linha, 1).toString();
				String rgCliente = tblConsulta.getValueAt(linha, 2).toString();
				String bairroCliente = tblConsulta.getValueAt(linha, 3).toString();
				String cidadeCliente = tblConsulta.getValueAt(linha, 4).toString();
				String estadoCliente = tblConsulta.getValueAt(linha, 5).toString();
				String cepCliente = tblConsulta.getValueAt(linha, 6).toString();
				String NascimentoCliente = tblConsulta.getValueAt(linha, 7).toString();
				
				txtCodCliente.setText(codCliente);
				txtNomeCliente.setText(nomeCliente);
				txtRGCliente.setText(rgCliente);
				txtBairroCliente.setText(bairroCliente);
				txtCidadeCliente.setText(cidadeCliente);
				cbxEstadoCliente.setSelectedItem(estadoCliente);
				txtCEPCliente.setText(cepCliente);
				txtNascimentoCliente.setText(NascimentoCliente);
			}
		});
		tblConsulta.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "C\u00F3digo", "Nome", "RG",
				"Bairro", "Cidade", "Estado", "CEP", "Data de Nascimento" }) {
			Class<?>[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, String.class,
					String.class, String.class, String.class };

			public Class<?> getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tblConsulta.getColumnModel().getColumn(7).setPreferredWidth(154);
		scrollPane.setViewportView(tblConsulta);
		panel_2.setLayout(gl_panel_2);
		contentPane.setLayout(gl_contentPane);
	}

	public void mostrarDados() {
		List<Cliente> listaCli = new ArrayList<>();
		ClienteController cc = new ClienteController();
		listaCli = cc.listarTodos();
		DefaultTableModel tbm = (DefaultTableModel) tblConsulta.getModel();

		for (int i = tbm.getRowCount() - 1; i >= 0; i--) {
			tbm.removeRow(i);
		}
		int i = 0;
		for (Cliente c : listaCli) {
			tbm.addRow(new String[1]);
			tblConsulta.setValueAt(c.getCodCliente(), i, 0);
			tblConsulta.setValueAt(c.getNomeCliente(), i, 1);
			tblConsulta.setValueAt(c.getRgCliente(), i, 2);
			tblConsulta.setValueAt(c.getBairroCliente(), i, 3);
			tblConsulta.setValueAt(c.getCidadeCliente(), i, 4);
			tblConsulta.setValueAt(c.getEstadoCliente(), i, 5);
			tblConsulta.setValueAt(c.getCEPCliente(), i, 6);
			tblConsulta.setValueAt(Util.formatarDataDeLocalDateParaGui(c.getNascimentoCliente()), i, 7);
			i++;
		}
	}

}
