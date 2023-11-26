package ventanas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VentanaOperar extends JFrame implements ActionListener, WindowListener, KeyListener, FocusListener {

	private static final long serialVersionUID = 1L;
	public static String origen = "";
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private String tipoHabitacion = "";
	private String numPersonas = "";
	private String contenido = "";

	// Botones
	private JCheckBox chckbxReservaVuelo;
	private JCheckBox chckbxReservarHabitacion;
	private JRadioButton rdbtnIndividual;
	private JRadioButton rdbtnDoble;
	private JRadioButton rdbtnMultiple;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JButton btnCheckVuelos;
	private JButton btnAddNuevoVuelos;
	

	// Campos
	private JTextField textFieldMultiple;
	private JLabel LabelHSalida;
	private JLabel LabelHLlegada;
	private JTextField textFieldHSalida;
	private JTextField textFieldHLlegada;

	//Listas
	private JComboBox comboBoxOrigen;
	
	//Otros
	String si = "Sí", no = "No"; 
	Object opciones[] = {si,no};
	private JTextField textFieldErrores;
	
	

	/**
	 * Create the frame.
	 */
	public VentanaOperar() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(this);
		setBounds(100, 100, 650, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		inicializarControles();

	}

	private void inicializarControles() {

		// Botones
		chckbxReservaVuelo = new JCheckBox("Reservar Vuelo");
		chckbxReservaVuelo.setBounds(32, 51, 123, 23);
		contentPane.add(chckbxReservaVuelo);
		chckbxReservaVuelo.addActionListener(this);

		chckbxReservarHabitacion = new JCheckBox("Reservar Habitación");
		chckbxReservarHabitacion.setBounds(373, 51, 143, 23);
		contentPane.add(chckbxReservarHabitacion);
		chckbxReservarHabitacion.addActionListener(this);

		rdbtnIndividual = new JRadioButton("Individual");
		rdbtnIndividual.setEnabled(false);
		buttonGroup.add(rdbtnIndividual);
		rdbtnIndividual.setBounds(407, 87, 109, 23);
		contentPane.add(rdbtnIndividual);
		rdbtnIndividual.addActionListener(this);

		rdbtnDoble = new JRadioButton("Doble");
		rdbtnDoble.setEnabled(false);
		buttonGroup.add(rdbtnDoble);
		rdbtnDoble.setBounds(407, 124, 109, 23);
		contentPane.add(rdbtnDoble);
		rdbtnDoble.addActionListener(this);

		rdbtnMultiple = new JRadioButton("Múltiple");
		rdbtnMultiple.setEnabled(false);
		buttonGroup.add(rdbtnMultiple);
		rdbtnMultiple.setBounds(407, 158, 109, 23);
		contentPane.add(rdbtnMultiple);
		rdbtnMultiple.addActionListener(this);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setEnabled(false);
		btnAceptar.setBounds(427, 377, 89, 23);
		contentPane.add(btnAceptar);
		btnAceptar.addActionListener(this);

		btnCancelar = new JButton(LogIn.lenguajeSeleccionado[1]);
		btnCancelar.setBounds(535, 377, 89, 23);
		contentPane.add(btnCancelar);
		btnCancelar.addActionListener(this);
		
		btnAddNuevoVuelos = new JButton("Añadir nuevos vuelos");
		btnAddNuevoVuelos.setBounds(29, 338, 207, 23);
		contentPane.add(btnAddNuevoVuelos);
		btnAddNuevoVuelos.addActionListener(this);
		

		// Campos
		textFieldMultiple = new JTextField();
		textFieldMultiple.setEnabled(false);
		textFieldMultiple.setBounds(522, 159, 86, 20);
		contentPane.add(textFieldMultiple);
		textFieldMultiple.setColumns(10);
		textFieldMultiple.addActionListener(this);
		textFieldMultiple.addFocusListener(this);
		textFieldMultiple.addKeyListener(this);
		
		comboBoxOrigen = new JComboBox();
		comboBoxOrigen.setEnabled(false);
		comboBoxOrigen.setModel(new DefaultComboBoxModel(new String[] {"Barcelona", "Bilbao", "Valencia"}));
		comboBoxOrigen.setBounds(31, 87, 113, 22);
		contentPane.add(comboBoxOrigen);
		comboBoxOrigen.addActionListener(this);
		comboBoxOrigen.addFocusListener(this);
		
		btnCheckVuelos = new JButton(LogIn.lenguajeSeleccionado[0]);
		btnCheckVuelos.setBounds(20, 262, 148, 23);
		contentPane.add(btnCheckVuelos);
		
		LabelHSalida = new JLabel("Hora Salida");
		LabelHSalida.setBounds(41, 146, 77, 14);
		contentPane.add(LabelHSalida);
		
		LabelHLlegada = new JLabel("Hora llegada");
		LabelHLlegada.setBounds(41, 198, 77, 14);
		contentPane.add(LabelHLlegada);
		
		textFieldHSalida = new JTextField();
		textFieldHSalida.setEnabled(false);
		textFieldHSalida.setBounds(135, 143, 86, 20);
		contentPane.add(textFieldHSalida);
		textFieldHSalida.setColumns(10);
		
		textFieldHLlegada = new JTextField();
		textFieldHLlegada.setEnabled(false);
		textFieldHLlegada.setBounds(135, 195, 86, 20);
		contentPane.add(textFieldHLlegada);
		textFieldHLlegada.setColumns(10);
		
		textFieldErrores = new JTextField();
		textFieldErrores.setEditable(false);
		textFieldErrores.setEnabled(false);
		textFieldErrores.setBounds(407, 231, 201, 20);
		contentPane.add(textFieldErrores);
		textFieldErrores.setColumns(10);
		
		
		
		
//		comboBoxOrigen.addActionListener(this);
		btnCheckVuelos.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (chckbxReservaVuelo == e.getSource()) {
			if (chckbxReservaVuelo.isSelected()) {
				btnAceptar.setEnabled(true);
				comboBoxOrigen.setEnabled(true);
				
			} else {
				
				comboBoxOrigen.setEnabled(false);
				if (!chckbxReservarHabitacion.isSelected()) {
					btnAceptar.setEnabled(false);
				}
			}
		}

		if (chckbxReservarHabitacion == e.getSource()) {
			if (chckbxReservarHabitacion.isSelected()) {
				rdbtnIndividual.setEnabled(true);
				rdbtnDoble.setEnabled(true);
				rdbtnMultiple.setEnabled(true);
				btnAceptar.setEnabled(true);
			} else {
				rdbtnIndividual.setEnabled(false);
				rdbtnDoble.setEnabled(false);
				rdbtnMultiple.setEnabled(false);
				if (!chckbxReservaVuelo.isSelected()) {
					btnAceptar.setEnabled(false);
				}
			}
		}

		if (rdbtnMultiple.isSelected()) {
			textFieldMultiple.setEnabled(true);
			if(textFieldMultiple.getText().equals("")) {
				btnAceptar.setEnabled(false);
			}
			

		} else if (rdbtnDoble.isSelected() || rdbtnIndividual.isSelected()) {
			textFieldMultiple.setEnabled(false);
			textFieldErrores.setText("");
			btnAceptar.setEnabled(true);

		}
		
		if(rdbtnIndividual.isSelected() && (!rdbtnDoble.isSelected() || (!rdbtnMultiple.isSelected()))){
			tipoHabitacion = "Individual";
			numPersonas = "1";
			System.out.println(tipoHabitacion + " " + numPersonas);
		}else if(rdbtnDoble.isSelected() && (!rdbtnIndividual.isSelected() || (!rdbtnMultiple.isSelected()))) {
			tipoHabitacion = "Doble";
			numPersonas = "2";
			System.out.println(tipoHabitacion + " " + numPersonas);
		}
		
		if(textFieldMultiple == e.getSource()) {
			
			tipoHabitacion = "Multiple";
			numPersonas = textFieldMultiple.getText();
			System.out.println(tipoHabitacion + " " + numPersonas);
			
		}
		
//		if(rdbtnMultiple.isSelected() && (!rdbtnIndividual.isSelected() || (!rdbtnDoble.isSelected()))) {
//			tipoHabitacion = "Multiple";
//			numPersonas = "X";
//			System.out.println(tipoHabitacion + " " + numPersonas);
//		}
		
		if(btnCancelar == e.getSource()) {
			System.exit(0);
		}
		
		if(btnCheckVuelos == e.getSource()) {
			VSeleccionVuelos ventanaSeleccion = new VSeleccionVuelos();
			ventanaSeleccion.setVisible(true);
		}
		
		if(comboBoxOrigen == e.getSource()) {
		origen = (String) comboBoxOrigen.getSelectedItem();
			
		}
		
		if(btnAceptar == e.getSource()) {
			
			JOptionPane.showMessageDialog(rootPane, "Has reservado un vuelo desde " + origen + " a las " + textFieldHSalida.getText() + " y una habitación \n" +
			tipoHabitacion + " para " + numPersonas + " personas");
			
		}
		
		if(comboBoxOrigen == e.getSource()) {
			System.out.println("Prueba");
			String ciudad = (String)comboBoxOrigen.getSelectedItem();
			if(origen.equals(ciudad)) {
				textFieldHLlegada.setText("");
				textFieldHSalida.setText("");
			}
		}
		
		if(btnAddNuevoVuelos == e.getSource()) {
			
			AddNuevosVuelos nv = new AddNuevosVuelos();
			nv.setVisible(true);
		}

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		int option = JOptionPane.showOptionDialog(null, "¿Desea cerrar la ventana?", "Confirmar cierre", 
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, null);
        if (option == JOptionPane.YES_OPTION) {
            dispose(); // Cierra la ventana
        } //revisar
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		textFieldHLlegada.setText(VSeleccionVuelos.hLlegada);
		textFieldHSalida.setText(VSeleccionVuelos.hSalida);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		String tecla;
		
		if(textFieldMultiple == e.getSource()) {
			tecla = String.valueOf(e.getKeyChar());
			if(tecla.equals("\b")) {
				if(contenido.length() >0) {
				contenido = contenido.substring(0, contenido.length()-1);
				System.out.println(contenido);
				}else {
					
				}
			}else {
				contenido += tecla;
			}
			
			
			System.out.println(contenido);
			if(contenido.matches("^[0-9]+$")) {
				
				textFieldMultiple.setForeground(Color.BLACK);
				textFieldErrores.setText("");
				System.out.println("correcto");
				btnAceptar.setEnabled(true);
			}else {
				textFieldErrores.setForeground(Color.RED);
				textFieldMultiple.setForeground(Color.RED);
				textFieldErrores.setText("El campo múltiple solo puede contener números");
				btnAceptar.setEnabled(false);
			}
			
			
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		if(textFieldMultiple == e.getSource()) {
			tipoHabitacion = "Multiple";
			numPersonas = textFieldMultiple.getText();
			System.out.println(tipoHabitacion + " " + numPersonas);
		}
		
		
	}
}
