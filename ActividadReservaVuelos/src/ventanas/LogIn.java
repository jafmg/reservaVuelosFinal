package ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

public class LogIn extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private static final String ADMIN_USERNAME = "22.222.222-J";
    private static final String EMPLOYEE_USERNAME = "11.111.111-H";
    public static String[] esp;
    public static String[] eng;
    public static String[] lenguajeSeleccionado = new String[2];
    public static boolean check = false;
	private final JPanel contentPanel = new JPanel();
	JFormattedTextField formattedTextFieldUser;
	JLabel LabelUser;
	JLabel LabelPassword;
	JFormattedTextField formattedTextFieldPass;
	JPanel buttonPane;
	JButton btnAceptar;
	JButton btnCancelar;
	MaskFormatter mascara;
	private JPasswordField passwordField;


	/**
	 * Create the dialog.
	 */
	public LogIn() {
		setResizable(false);
		setTitle("Log in");
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
	
		LabelUser = new JLabel("Usuario");
		LabelUser.setBounds(120, 44, 46, 14);
		contentPanel.add(LabelUser);
		
		LabelPassword = new JLabel("Contraseña");
		LabelPassword.setBounds(120, 119, 72, 14);
		contentPanel.add(LabelPassword);
		
		
		
		try {
			mascara = new MaskFormatter("##.###.###-U");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		formattedTextFieldUser = new JFormattedTextField(mascara);
		formattedTextFieldUser.setBounds(120, 69, 193, 20);
		contentPanel.add(formattedTextFieldUser);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(120, 144, 193, 20);
		contentPanel.add(passwordField);
		passwordField.addActionListener(this);
		
		addInferior();
		
	}
	
	public void addInferior() {
		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnAceptar = new JButton("Aceptar");
				btnAceptar.setActionCommand("OK");
				btnAceptar.addActionListener(this);
				buttonPane.add(btnAceptar);
				getRootPane().setDefaultButton(btnAceptar);
			}
			{
				btnCancelar = new JButton("Cancelar");
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(passwordField == e.getSource() || btnAceptar == e.getSource()) {
			String pass = new String(passwordField.getPassword());
			comprobarPass(pass);
			
			
		}
	}
	
	private void comprobarPass(String pass) {
		
		if(formattedTextFieldUser.getText().equals(ADMIN_USERNAME)) {
			if(pass.equals(ADMIN_USERNAME)) {
				check = true;
				lenguajeSeleccionado = tablaslenguaEng();
				VentanaOperar vo = new VentanaOperar();
				vo.setVisible(true);
				
				
				dispose();
			}else {
				JOptionPane.showMessageDialog(rootPane, "Contraseña incorrecta");
			}
		}else if(formattedTextFieldUser.getText().equals(EMPLOYEE_USERNAME)) {
			if(pass.equals(EMPLOYEE_USERNAME)) {
				lenguajeSeleccionado = tablasLenguaEsp();
				VentanaOperar vo = new VentanaOperar();
				vo.setVisible(true);
				
				dispose();
			}else {
				JOptionPane.showMessageDialog(rootPane, "Contraseña incorrecta");
			}
		}else {
			JOptionPane.showMessageDialog(rootPane, "Usuario no encontrado");
		}
	}
	
	private String[] tablasLenguaEsp() {
		
		esp = new String[] {
				"Reservar Vuelo",
				"Hora salida",
				"Hora llegada",
				"Comprobar vuelos",
				"Añadir un vuelo",
				"Reservar Habitación",
				"Individual",
				"Doble",
				"Múltiple",
				"El campo múltiple solo puede contener números",
				"Aceptar",
				"Cancelar",
				"Seleccione un vuelo con origen: ",
				"Hora salida",
				"Hora llegada",
				"Clase",
				"Eur",
				"Aceptar",
				"Cancelar",
				"Origen",
				"Hora salida",
				"Hora llegada",
				"Clase",
				"Precio",
				"Aceptar",
				"Cancelar",
				"¿Desea cerrar la ventana?",
				"Confirmar cierre",
				"Sí",
				"No",
				"Reserva",
				"Selección vuelos",
				"Añadir vuelos"
				
		};
		
		return esp;
	}
	
	private String[] tablaslenguaEng() {
		eng = new String[] {
				"Book flight",
				"Departure time",
				"Arrival Time",
				"Check flights",
				"Add new flight",
				"Book room",
				"Single",
				"Double",
				"Many",
				"The ‘many’ field can only contain numbers",
				"Ok",
				"Cancel",
				"Select a flight departure from: ",
				"Departure time",
				"Arrival time",
				"Type",
				"Eur",
				"Ok",
				"Cancel",
				"From",
				"Departure time",
				"Arrival time",
				"Type",
				"Cost",
				"Ok",
				"Cancel",
				"¿Do you want to close the window?",
				"Close Confirmation",
				"Yes",
				"No",
				"Book",
				"Flight Selection",
				"Add Flight",
		};
		
		return eng;
	}
	

}
