package ventanas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VentanaOperar extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	// Botones
	private JCheckBox chckbxReservaVuelo;
	private JCheckBox chckbxReservarHabitacion;
	private JRadioButton rdbtnIndividual;
	private JRadioButton rdbtnDoble;
	private JRadioButton rdbtnMultiple;
	private JButton btnAceptar;
	private JButton btnCancelar;

	// Campos
	private JTextField textFieldMultiple;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		VentanaOperar frame = new VentanaOperar();
		frame.setVisible(true);

	}

	/**
	 * Create the frame.
	 */
	public VentanaOperar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(535, 377, 89, 23);
		contentPane.add(btnCancelar);
		btnCancelar.addActionListener(this);

		// Campos
		textFieldMultiple = new JTextField();
		textFieldMultiple.setEnabled(false);
		textFieldMultiple.setBounds(522, 159, 86, 20);
		contentPane.add(textFieldMultiple);
		textFieldMultiple.setColumns(10);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (chckbxReservaVuelo == e.getSource()) {
			if (chckbxReservaVuelo.isSelected()) {
				btnAceptar.setEnabled(true);
			} else {
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

		} else if (rdbtnDoble.isSelected() || rdbtnIndividual.isSelected()) {
			textFieldMultiple.setEnabled(false);

		}
		
		if(e.getSource() == btnCancelar) {
			System.exit(0);
		}

	}
}
