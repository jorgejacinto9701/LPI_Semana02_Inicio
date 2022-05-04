package validaciones.ejemplos;

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

import validaciones.util.Validaciones;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class FrmCliente extends JFrame implements ActionListener, KeyListener {

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
		txtDni.addKeyListener(this);
		txtDni.setBounds(66, 77, 86, 20);
		contentPane.add(txtDni);
		txtDni.setColumns(10);

		txtHijos = new JTextField();
		txtHijos.addKeyListener(this);
		txtHijos.setBounds(66, 108, 86, 20);
		contentPane.add(txtHijos);
		txtHijos.setColumns(10);

		txtSueldo = new JTextField();
		txtSueldo.addKeyListener(this);
		txtSueldo.setBounds(66, 139, 86, 20);
		contentPane.add(txtSueldo);
		txtSueldo.setColumns(10);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(320, 27, 89, 23);
		contentPane.add(btnRegistrar);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(e);
		}
	}

	protected void actionPerformedBtnRegistrar(ActionEvent e) {
		String nom = txtNombre.getText().trim();
		String ape = txtApellido.getText().trim();
		String dni = txtDni.getText().trim();
		String hij = txtHijos.getText().trim();
		String sue = txtSueldo.getText().trim();
		
		if (!nom.matches(Validaciones.TEXTO)) {
			mensaje("El nombre es de 2 a 2 caracteres");
		}else if(!ape.matches(Validaciones.TEXTO)) {
			mensaje("El apellido es de 2 a 2 caracteres");
		}else if(!dni.matches(Validaciones.DNI)) {
			mensaje("El dni es de 8 dígitos");
		}else if(!hij.matches(Validaciones.NUM_HIJOS)) {
			mensaje("El número de hijos es 0 a 10");
		}else if(!sue.matches(Validaciones.SUELDO)) {
			mensaje("El sueldo es entero o decimal con 1 o 2 dígitos");
		}else {
			mensaje("Cumple todas las validaciones");
		}
	
	}
	

	void mensaje(String men) {
		JOptionPane.showMessageDialog(null, men);
	}
	
	
	
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtSueldo) {
			do_txtSueldo_keyTyped(e);
		}
		if (e.getSource() == txtHijos) {
			do_txtHijos_keyTyped(e);
		}
		if (e.getSource() == txtDni) {
			do_txtDni_keyTyped(e);
		}
	}
	protected void do_txtDni_keyTyped(KeyEvent e) {
		System.out.println(e.getKeyChar());
		if (!Character.isDigit(e.getKeyChar())) {
			e.consume();
		}
		
		String dniGenerado = txtDni.getText() + e.getKeyChar();
		if (dniGenerado.length()>8) {
			e.consume();
		}
	}
	
	protected void do_txtHijos_keyTyped(KeyEvent e) {
		if (!Character.isDigit(e.getKeyChar())) {
			e.consume();
		}
		if (Character.isDigit(e.getKeyChar())) {
			String hijosGenerado = txtHijos.getText() + e.getKeyChar();
			int hijos = Integer.parseInt(hijosGenerado);
			if (hijos>10) {
				e.consume();
			}	
		}
		
	}
	protected void do_txtSueldo_keyTyped(KeyEvent e) {
	}
}
