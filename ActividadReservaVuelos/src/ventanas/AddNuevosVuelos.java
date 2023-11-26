package ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;

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
		if(textFieldOrigen == e.getSource()) {
			origen = textFieldOrigen.getText();
		}
		
		if(textFieldSalida == e.getSource()) {
			salida = textFieldSalida.getText();
		}
		
		if(textFieldLlegada == e.getSource()) {
			llegada = textFieldLlegada.getText();
		}
		
		if(textFieldClase == e.getSource()) {
			clase = textFieldClase.getText();
		}
		
		if(textFieldPrecio == e.getSource()) {
			precio = textFieldPrecio.getText();
		}
		
		if(btnAceptar == e.getSource()) {
			if(!textFieldOrigen.getText().equals("") || !textFieldLlegada.getText().equals("") || !textFieldSalida.getText().equals("") || !textFieldClase.getText().equals("") || !textFieldPrecio.getText().equals("")) {
				addVuelo();
				dispose();
			}else {
				System.out.println("Faltan campos!");
			}
			
		}
	}
	
	private void addVuelo() {
		DefaultTableModel modelotabla = (DefaultTableModel) VSeleccionVuelos.table.getModel();
		
		Object[] datos = {salida, llegada, clase, precio };
		
		modelotabla.addRow(datos);
		
	}
}
