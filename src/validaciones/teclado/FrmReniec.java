package validaciones.teclado;

import java.awt.EventQueue;
import java.awt.Font;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmReniec extends JFrame implements KeyListener, ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtDNI;
	private JButton btnVerificar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmReniec frame = new FrmReniec();
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
	public FrmReniec() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblReniec = new JLabel("RENIEC");
		lblReniec.setHorizontalAlignment(SwingConstants.CENTER);
		lblReniec.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblReniec.setBounds(10, 24, 499, 46);
		contentPane.add(lblReniec);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(53, 121, 46, 14);
		contentPane.add(lblNombre);

		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(53, 159, 46, 14);
		contentPane.add(lblDni);

		btnVerificar = new JButton("Verificar");
		btnVerificar.addActionListener(this);
		btnVerificar.setBounds(214, 205, 89, 23);
		contentPane.add(btnVerificar);

		txtNombre = new JTextField();
		txtNombre.setBounds(194, 118, 256, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		txtDNI = new JTextField();
		txtDNI.addKeyListener(this);
		txtDNI.setBounds(194, 156, 136, 20);
		contentPane.add(txtDNI);
		txtDNI.setColumns(10);
	}

	
	public void mensaje(String txt) {
		JOptionPane.showMessageDialog(this, txt);
	}

	
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtDNI) {
			handle_txtDNI_keyTyped(e);
		}
	}
	protected void handle_txtDNI_keyTyped(KeyEvent e) {
		// Si no es dígito se consume el evento
		if (!Character.isDigit(e.getKeyChar())) {
			e.consume();
		}
		
		String textoQueVaGenerarse = txtDNI.getText().trim() + e.getKeyChar();
		if (textoQueVaGenerarse.length()>8) {
			e.consume();
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnVerificar) {
			handle_btnVerificar_actionPerformed(e);
		}
	}
	protected void handle_btnVerificar_actionPerformed(ActionEvent e) {
		String nom = txtNombre.getText();
		String dni = txtDNI.getText();

		if (!nom.matches(Validaciones.NOMBRE)) {
			mensaje("El nombre es de 3 a 30 caracteres");
		}else if (!dni.matches(Validaciones.DNI)) {
			mensaje("El dni empieza tiene 8 dígitos");
		} else {
			mensaje("Cumple todas las validaciones");
		}
	}
}
