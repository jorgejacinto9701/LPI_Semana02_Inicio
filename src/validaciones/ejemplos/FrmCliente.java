package validaciones.ejemplos;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FrmCliente extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JTextField txtHijos;
	private JTextField txtSueldo;
	private JButton btnRegistrar;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCliente frame = new FrmCliente();
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
		setTitle("Empleado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 228);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNombres = new JLabel("Nombres:");
		lblNombres.setBounds(10, 11, 64, 14);
		contentPane.add(lblNombres);

		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(10, 49, 64, 14);
		contentPane.add(lblApellidos);

		JLabel lblHijos = new JLabel("Hijos:");
		lblHijos.setBounds(10, 111, 46, 14);
		contentPane.add(lblHijos);

		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(10, 80, 46, 14);
		contentPane.add(lblDni);

		JLabel lblSueldo = new JLabel("Sueldo:");
		lblSueldo.setBounds(10, 142, 46, 14);
		contentPane.add(lblSueldo);

		txtNombre = new JTextField();
		txtNombre.setBounds(66, 8, 221, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setBounds(66, 46, 221, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);

		txtDni = new JTextField();
		txtDni.setBounds(66, 77, 86, 20);
		contentPane.add(txtDni);
		txtDni.setColumns(10);

		txtHijos = new JTextField();
		txtHijos.setBounds(66, 108, 86, 20);
		contentPane.add(txtHijos);
		txtHijos.setColumns(10);

		txtSueldo = new JTextField();
		txtSueldo.setBounds(66, 139, 86, 20);
		contentPane.add(txtSueldo);
		txtSueldo.setColumns(10);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(320, 27, 89, 23);
		contentPane.add(btnRegistrar);
	}

	
}
