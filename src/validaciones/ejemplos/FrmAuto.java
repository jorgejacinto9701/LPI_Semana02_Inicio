package validaciones.ejemplos;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import validaciones.util.Validaciones;

public class FrmAuto extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtPrecio;
	private JTextField txtPlaca;
	private JTextField txtStock;
	private JButton btnGrabar;
	private JTextArea txtDescripcion;
	private JTextField txtFecha;
	private JTextField txtCorreo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAuto frame = new FrmAuto();
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
	public FrmAuto() {
		setTitle("Auto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 487, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setBounds(10, 33, 83, 14);
		contentPane.add(lblDescripcin);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(10, 80, 46, 14);
		contentPane.add(lblPrecio);

		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setBounds(10, 111, 46, 14);
		contentPane.add(lblPlaca);

		txtPrecio = new JTextField();
		txtPrecio.setBounds(141, 77, 137, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);

		txtPlaca = new JTextField();
		txtPlaca.setBounds(141, 108, 137, 20);
		contentPane.add(txtPlaca);
		txtPlaca.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(141, 33, 279, 41);
		contentPane.add(scrollPane);

		txtDescripcion = new JTextArea();
		scrollPane.setViewportView(txtDescripcion);

		JLabel lblStock = new JLabel("Stock:");
		lblStock.setBounds(10, 143, 46, 14);
		contentPane.add(lblStock);

		txtStock = new JTextField();
		txtStock.setBounds(141, 139, 137, 20);
		contentPane.add(txtStock);
		txtStock.setColumns(10);

		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(331, 96, 89, 23);
		contentPane.add(btnGrabar);

		JLabel lblFechaDeInicio = new JLabel("Fecha de Inicio de uso");
		lblFechaDeInicio.setBounds(10, 178, 121, 20);
		contentPane.add(lblFechaDeInicio);

		txtFecha = new JTextField();
		txtFecha.setBounds(141, 175, 137, 20);
		contentPane.add(txtFecha);
		txtFecha.setColumns(10);

		JLabel lblCorreoDelCliente = new JLabel("Correo del Cliente");
		lblCorreoDelCliente.setBounds(10, 234, 103, 14);
		contentPane.add(lblCorreoDelCliente);

		txtCorreo = new JTextField();
		txtCorreo.setBounds(141, 231, 254, 20);
		contentPane.add(txtCorreo);
		txtCorreo.setColumns(10);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGrabar) {
			actionPerformedBtnGrabar(e);
		}
	}

	protected void actionPerformedBtnGrabar(ActionEvent e) {
		String des = txtDescripcion.getText().trim();
		String pre = txtPrecio.getText().trim();
		String pla = txtPlaca.getText().trim();
		String stk = txtStock.getText().trim();
		String fec = txtFecha.getText().trim();
		String cor = txtCorreo.getText().trim();

		if (!des.matches(Validaciones.DESCRIPCION)) {
			mensaje("La descripción es de 2 a 200 caracteres");
		} else if (!pre.matches(Validaciones.PRECIO_DOS_DIGITOS_DECIMALES)) {
			mensaje("El precio tiene dos decimales");
		} else if (!pla.matches(Validaciones.PLACA)) {
			mensaje("La placa tiene la forma 2 letras mayúsculas y 4 dígitos");
		} else if (!stk.matches(Validaciones.STOCK)) {
			mensaje("El Stock es un entero");
		} else if (!fec.matches(Validaciones.FECHA)) {
			mensaje("La fecha tiene formato dd/MM/yyyy");
		} else if (!cor.matches(Validaciones.CORREO)) {
			mensaje("No tiene formato de correo");
		} else {
			mensaje("Todos los datos son correctos");
		}
	}

	void mensaje(String men) {
		JOptionPane.showMessageDialog(this, men);
	}
}
