package validaciones.ejemplos;

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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import validaciones.util.Validaciones;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class FrmSimulacro extends JFrame implements ActionListener, KeyListener {

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
		txtEdad.addKeyListener(this);
		txtEdad.setBounds(214, 112, 86, 20);
		contentPane.add(txtEdad);
		txtEdad.setColumns(10);

		txtSexo = new JTextField();
		txtSexo.setBounds(214, 152, 86, 20);
		contentPane.add(txtSexo);
		txtSexo.setColumns(10);

		txtDNI = new JTextField();
		txtDNI.addKeyListener(this);
		txtDNI.setBounds(214, 190, 86, 20);
		contentPane.add(txtDNI);
		txtDNI.setColumns(10);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(143, 235, 89, 23);
		contentPane.add(btnRegistrar);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnRegistrar) {
			handleBtnRegistrarActionPerformed(arg0);
		}
	}

	protected void handleBtnRegistrarActionPerformed(ActionEvent arg0) {
		String nom = txtNombre.getText();
		String eda = txtEdad.getText();
		String sex = txtSexo.getText();
		String dni = txtDNI.getText();

		if (!nom.matches(Validaciones.NOMBRE)) {
			mensaje("El nombre es de 3 a 30 caracteres");
		} else if (!eda.matches(Validaciones.EDAD)) {
			mensaje("La edad es de 2 dígitos");
		} else if (!sex.matches(Validaciones.SEXO)) {
			mensaje("El sexo es F o M");
		} else if (!dni.matches(Validaciones.DNI_EMPIEZA_SIETE)) {
			mensaje("El dni empieza en 7");
		} else {
			mensaje("Cumple todas las validaciones");
		}
	}

	public void mensaje(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtDNI) {
			keyTypedTxtDNIJTextField(e);
		}
		if (e.getSource() == txtEdad) {
			keyTypedTxtEdadJTextField(e);
		}
	}

	protected void keyTypedTxtEdadJTextField(KeyEvent e) {
		System.out.println(e.getKeyChar());
		// Si no es dígito se consume el evento
		if (!Character.isDigit(e.getKeyChar())) {
			e.consume();
		}
		
		String textoQueVaGenerarse = txtEdad.getText().trim() + e.getKeyChar();
		if (textoQueVaGenerarse.length()>2) {
			e.consume();
		}
		
	}

	protected void keyTypedTxtDNIJTextField(KeyEvent e) {
		// Si no es dígito se consume el evento
		if (!Character.isDigit(e.getKeyChar())) {
			e.consume();
		}
		
		String textoQueVaGenerarse = txtDNI.getText().trim() + e.getKeyChar();
		if (textoQueVaGenerarse.length()>8) {
			e.consume();
		}
	}
}








