package ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class AddNuevosVuelos extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldOrigen;
	private JTextField textFieldSalida;
	private JTextField textFieldLlegada;
	private JTextField textFieldClase;
	private JTextField textFieldPrecio;
	private static String origen = "";
	private static String salida = "";
	private static String llegada = "";
	private static String clase = "";
	private static String precio = "";
	private JButton btnAceptar;
	private String[][] listaActualizada;



	/**
	 * Create the dialog.
	 */
	public AddNuevosVuelos() {

		setModal(true);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 319, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		textFieldOrigen = new JTextField();
		textFieldOrigen.setBounds(181, 27, 86, 20);
		contentPanel.add(textFieldOrigen);
		textFieldOrigen.setColumns(10);
		
		textFieldSalida = new JTextField();
		textFieldSalida.setColumns(10);
		textFieldSalida.setBounds(181, 58, 86, 20);
		contentPanel.add(textFieldSalida);
		
		textFieldLlegada = new JTextField();
		textFieldLlegada.setColumns(10);
		textFieldLlegada.setBounds(181, 89, 86, 20);
		contentPanel.add(textFieldLlegada);
		
		textFieldClase = new JTextField();
		textFieldClase.setColumns(10);
		textFieldClase.setBounds(181, 120, 86, 20);
		contentPanel.add(textFieldClase);
		
		textFieldPrecio = new JTextField();
		textFieldPrecio.setColumns(10);
		textFieldPrecio.setBounds(181, 151, 86, 20);
		contentPanel.add(textFieldPrecio);
		
		JLabel LabelOrigen = new JLabel("Origen");
		LabelOrigen.setBounds(10, 30, 127, 14);
		contentPanel.add(LabelOrigen);
		
		JLabel LabelHSalida = new JLabel("Hora salida");
		LabelHSalida.setBounds(10, 61, 127, 14);
		contentPanel.add(LabelHSalida);
		
		JLabel LabelHLlegada = new JLabel("Hora llegada");
		LabelHLlegada.setBounds(10, 92, 127, 14);
		contentPanel.add(LabelHLlegada);
		
		JLabel LabelClase = new JLabel("Clase");
		LabelClase.setBounds(10, 123, 127, 14);
		contentPanel.add(LabelClase);
		
		JLabel LabelPrecio = new JLabel("Precio");
		LabelPrecio.setBounds(10, 154, 127, 14);
		contentPanel.add(LabelPrecio);
		addInferior();
		
		
		
	}
	
	private void addInferior() {
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnAceptar = new JButton("Aceptar");
				buttonPane.add(btnAceptar);
				getRootPane().setDefaultButton(btnAceptar);
				btnAceptar.addActionListener(this);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		
		if(btnAceptar == e.getSource()) {
			if(!textFieldOrigen.getText().equals("") || !textFieldLlegada.getText().equals("") || !textFieldSalida.getText().equals("") || !textFieldClase.getText().equals("") || !textFieldPrecio.getText().equals("")) {
				origen = textFieldOrigen.getText();
				salida = textFieldSalida.getText();
				llegada = textFieldLlegada.getText();
				clase = textFieldClase.getText();
				precio = textFieldPrecio.getText();
				
				tablaVuelo();
				dispose();
			}else {
				System.out.println("Faltan campos!");
			}
			
		}
	}
	

	
	private void tablaVuelo() {
		listaActualizada = new String[VentanaOperar.vuelos.length+1][VentanaOperar.vuelos[0].length];
		
		for(int i = 0; i <VentanaOperar.vuelos.length; i ++) {
			for(int j = 0; j < VentanaOperar.vuelos[0].length; j++) {
				listaActualizada[i][j] = VentanaOperar.vuelos[i][j];
			}
		}
		
		listaActualizada[listaActualizada.length-1][0] = origen;
		listaActualizada[listaActualizada.length-1][1] = salida;
		listaActualizada[listaActualizada.length-1][2] = llegada;
		listaActualizada[listaActualizada.length-1][3] = clase;
		listaActualizada[listaActualizada.length-1][4] = precio;
		

		
		VentanaOperar.vuelos = new String[listaActualizada.length][listaActualizada[0].length];
		
		
		for(int i = 0; i <listaActualizada.length; i ++) {
			for(int j = 0; j < listaActualizada[0].length; j++) {
				VentanaOperar.vuelos[i][j] = listaActualizada[i][j];
			}
		}
		

	}
	
	
}
