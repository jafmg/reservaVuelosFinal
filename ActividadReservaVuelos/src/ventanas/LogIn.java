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
				lenguajeSeleccionado = tablaslenguaEng();
				VentanaOperar vo = new VentanaOperar();
				vo.setVisible(true);
				
				System.out.println(lenguajeSeleccionado[0]);
				dispose();
			}else {
				JOptionPane.showMessageDialog(rootPane, "Error password");
			}
		}else if(formattedTextFieldUser.getText().equals(EMPLOYEE_USERNAME)) {
			if(pass.equals(EMPLOYEE_USERNAME)) {
				lenguajeSeleccionado = tablasLenguaEsp();
				VentanaOperar vo = new VentanaOperar();
				vo.setVisible(true);
				
				dispose();
			}else {
				JOptionPane.showMessageDialog(rootPane, "Error password");
			}
		}else {
			JOptionPane.showMessageDialog(rootPane, "Usuario no encontrado");
		}
	}
	
	private String[] tablasLenguaEsp() {
		
		esp = new String[] {
				"Comprobar Vuelos",
				"Cancelar"
		};
		
		return esp;
	}
	
	private String[] tablaslenguaEng() {
		eng = new String[] {
				"Check Flights",
				"Cancel"
		};
		
		return eng;
	}
	

}
