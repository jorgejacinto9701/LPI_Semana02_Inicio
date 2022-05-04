package validaciones.ejemplos;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class FrmSimulacro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblFormularioDeRegistro;
	private JLabel lblNombre;
	private JLabel lblEdad;
	private JLabel lblSexo;
	private JLabel lblDni;
	private JTextField txtNombre;
	private JTextField txtEdad;
	private JTextField txtSexo;
	private JTextField txtDNI;
	private JButton btnRegistrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmSimulacro frame = new FrmSimulacro();
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
	public FrmSimulacro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 327);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblFormularioDeRegistro = new JLabel("Formulario de Registro");
		lblFormularioDeRegistro.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFormularioDeRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		lblFormularioDeRegistro.setBounds(10, 11, 414, 39);
		contentPane.add(lblFormularioDeRegistro);

		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(82, 79, 63, 14);
		contentPane.add(lblNombre);

		lblEdad = new JLabel("Edad");
		lblEdad.setBounds(82, 115, 63, 14);
		contentPane.add(lblEdad);

		lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(82, 155, 63, 14);
		contentPane.add(lblSexo);

		lblDni = new JLabel("DNI");
		lblDni.setBounds(82, 193, 63, 14);
		contentPane.add(lblDni);

		txtNombre = new JTextField();
		txtNombre.setBounds(214, 76, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		txtEdad = new JTextField();
		txtEdad.setBounds(214, 112, 86, 20);
		contentPane.add(txtEdad);
		txtEdad.setColumns(10);

		txtSexo = new JTextField();
		txtSexo.setBounds(214, 152, 86, 20);
		contentPane.add(txtSexo);
		txtSexo.setColumns(10);

		txtDNI = new JTextField();
		txtDNI.setBounds(214, 190, 86, 20);
		contentPane.add(txtDNI);
		txtDNI.setColumns(10);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(143, 235, 89, 23);
		contentPane.add(btnRegistrar);
	}

	
}








