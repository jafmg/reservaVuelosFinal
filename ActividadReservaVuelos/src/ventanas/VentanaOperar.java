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
	public static String[][] vuelos;


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
	private String si = LogIn.lenguajeSeleccionado[28], no = LogIn.lenguajeSeleccionado[29]; 
	private Object opciones[] = {si,no};
	private JTextField textFieldErrores;
	
	

	/**
	 * Create the frame.
	 */
	public VentanaOperar() {
		setResizable(false);
		setTitle(LogIn.lenguajeSeleccionado[30]);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(this);
		setBounds(100, 100, 650, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		inicializarControles();

	}

	private void inicializarControles() {
		inicializarTabla();

		// Botones
		chckbxReservaVuelo = new JCheckBox(LogIn.lenguajeSeleccionado[0]);
		chckbxReservaVuelo.setBounds(32, 51, 123, 23);
		contentPane.add(chckbxReservaVuelo);
		chckbxReservaVuelo.addActionListener(this);

		chckbxReservarHabitacion = new JCheckBox(LogIn.lenguajeSeleccionado[5]);
		chckbxReservarHabitacion.setBounds(373, 51, 143, 23);
		contentPane.add(chckbxReservarHabitacion);
		chckbxReservarHabitacion.addActionListener(this);

		rdbtnIndividual = new JRadioButton(LogIn.lenguajeSeleccionado[6]);
		rdbtnIndividual.setEnabled(false);
		buttonGroup.add(rdbtnIndividual);
		rdbtnIndividual.setBounds(407, 87, 109, 23);
		contentPane.add(rdbtnIndividual);
		rdbtnIndividual.addActionListener(this);

		rdbtnDoble = new JRadioButton(LogIn.lenguajeSeleccionado[7]);
		rdbtnDoble.setEnabled(false);
		buttonGroup.add(rdbtnDoble);
		rdbtnDoble.setBounds(407, 124, 109, 23);
		contentPane.add(rdbtnDoble);
		rdbtnDoble.addActionListener(this);

		rdbtnMultiple = new JRadioButton(LogIn.lenguajeSeleccionado[8]);
		rdbtnMultiple.setEnabled(false);
		buttonGroup.add(rdbtnMultiple);
		rdbtnMultiple.setBounds(407, 158, 109, 23);
		contentPane.add(rdbtnMultiple);
		rdbtnMultiple.addActionListener(this);

		btnAceptar = new JButton(LogIn.lenguajeSeleccionado[10]);
		btnAceptar.setEnabled(false);
		btnAceptar.setBounds(427, 377, 89, 23);
		contentPane.add(btnAceptar);
		btnAceptar.addActionListener(this);

		btnCancelar = new JButton(LogIn.lenguajeSeleccionado[11]);
		btnCancelar.setBounds(535, 377, 89, 23);
		contentPane.add(btnCancelar);
		btnCancelar.addActionListener(this);
		
		btnAddNuevoVuelos = new JButton(LogIn.lenguajeSeleccionado[4]);
		btnAddNuevoVuelos.setEnabled(false);
		btnAddNuevoVuelos.setBounds(29, 338, 207, 23);
		contentPane.add(btnAddNuevoVuelos);
		if(LogIn.check) {
			btnAddNuevoVuelos.setVisible(true);
		}else {
			btnAddNuevoVuelos.setVisible(false);
		}
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
		
		btnCheckVuelos = new JButton(LogIn.lenguajeSeleccionado[3]);
		btnCheckVuelos.setEnabled(false);
		btnCheckVuelos.setBounds(20, 262, 148, 23);
		contentPane.add(btnCheckVuelos);
		
		LabelHSalida = new JLabel(LogIn.lenguajeSeleccionado[1]);
		LabelHSalida.setBounds(20, 146, 105, 14);
		contentPane.add(LabelHSalida);
		
		LabelHLlegada = new JLabel(LogIn.lenguajeSeleccionado[2]);
		LabelHLlegada.setBounds(20, 198, 98, 14);
		contentPane.add(LabelHLlegada);
		
		textFieldHSalida = new JTextField();
		textFieldHSalida.setDisabledTextColor(Color.BLACK);
		textFieldHSalida.setEnabled(false);
		textFieldHSalida.setBounds(135, 143, 86, 20);
		contentPane.add(textFieldHSalida);
		textFieldHSalida.setColumns(10);
		
		textFieldHLlegada = new JTextField();
		textFieldHLlegada.setDisabledTextColor(Color.BLACK);
		textFieldHLlegada.setEnabled(false);
		textFieldHLlegada.setBounds(135, 195, 86, 20);
		contentPane.add(textFieldHLlegada);
		textFieldHLlegada.setColumns(10);
		
		textFieldErrores = new JTextField();
		textFieldErrores.setBorder(null);
		textFieldErrores.setDisabledTextColor(Color.RED);
		textFieldErrores.setEnabled(false);
		textFieldErrores.setForeground(Color.RED);
		textFieldErrores.setEditable(false);
		textFieldErrores.setBounds(331, 231, 277, 20);
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
				btnAddNuevoVuelos.setEnabled(true);
				btnCheckVuelos.setEnabled(true);
				
			} else {
				btnAddNuevoVuelos.setEnabled(false);
				btnCheckVuelos.setEnabled(false);
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
				textFieldMultiple.setText("");
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
			textFieldMultiple.setText("");
			textFieldErrores.setText("");
			btnAceptar.setEnabled(true);

		}
		
		if(rdbtnIndividual.isSelected() && (!rdbtnDoble.isSelected() || (!rdbtnMultiple.isSelected()))){
			tipoHabitacion = "Individual";
			numPersonas = "1";
			
		}else if(rdbtnDoble.isSelected() && (!rdbtnIndividual.isSelected() || (!rdbtnMultiple.isSelected()))) {
			tipoHabitacion = "Doble";
			numPersonas = "2";
			
		}
		
		if(textFieldMultiple == e.getSource()) {
			
			tipoHabitacion = "Multiple";
			numPersonas = textFieldMultiple.getText();
			
			
		}
		

		
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
			if(!textFieldHSalida.getText().equals("") && !tipoHabitacion.equals("") && !numPersonas.equals("") ) {
			JOptionPane.showMessageDialog(rootPane, "Has reservado un vuelo desde " + origen + " a las " + textFieldHSalida.getText() + " y una habitación \n" +
			tipoHabitacion + " para " + numPersonas + " personas");
			}else {
				JOptionPane.showMessageDialog(rootPane, "Faltan campos por rellenar");
			}
			
		}
		
		if(comboBoxOrigen == e.getSource()) {
			
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
		int option = JOptionPane.showOptionDialog(null, LogIn.lenguajeSeleccionado[26] , LogIn.lenguajeSeleccionado[27], 
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, null);
        if (option == JOptionPane.YES_OPTION) {
            dispose(); 
        }else {
        	//do nothing
        }
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
				
				}else {
					
				}
			}else {
				contenido += tecla;
			}
			
			
			
			if(contenido.matches("^[0-9]+$")) {
				
				textFieldMultiple.setForeground(Color.BLACK);
				textFieldErrores.setText("");
				
				btnAceptar.setEnabled(true);
			}else {
				textFieldErrores.setForeground(Color.RED);
				textFieldMultiple.setForeground(Color.RED);
				textFieldErrores.setText(LogIn.lenguajeSeleccionado[9]);
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
			
		}
		
		
	}
	
	private void inicializarTabla() {
			vuelos = new String[][]{
			
			{"Barcelona", "6:00", "7:00", "Turista", "300"},
			{"Barcelona", "7:00", "8:00", "Turista", "300"},
			{"Barcelona", "8:00", "9:00", "Turista", "300"},
			{"Barcelona", "9:00", "10:00", "Turista", "300"},
			{"Barcelona", "10:00", "11:00", "Turista", "300"},
			{"Barcelona", "11:00", "12:00", "Business", "500"},
			{"Barcelona", "12:00", "13:00", "Business", "500"},
			{"Barcelona", "13:00", "14:00", "Business", "500"},
			{"Barcelona", "14:00", "15:00", "Business", "500"},
			{"Barcelona", "15:00", "16:00", "Business", "500"},
			{"Bilbao", "06:00", "7:00", "Turista", "200"},
			{"Bilbao", "07:00", "8:00", "Turista", "200"},
			{"Bilbao", "08:00", "9:00", "Turista", "200"},
			{"Bilbao", "09:00", "10:00", "Business", "400"},
			{"Bilbao", "10:00", "11:00", "Business", "400"},
			{"Valencia", "06:00", "7:00", "Turista", "100"},
			{"Valencia", "07:00", "8:00", "Turista", "100"},
			{"Valencia", "08:00", "9:00", "Turista", "100"},
			{"Valencia", "09:00", "10:00", "Business", "200"},
			{"Valencia", "10:00", "11:00", "Business", "200"}
		};
	}
}
