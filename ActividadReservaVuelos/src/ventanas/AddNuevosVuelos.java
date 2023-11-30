package ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class AddNuevosVuelos extends JDialog implements ActionListener, WindowListener, FocusListener, KeyListener{

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
	private String si = LogIn.lenguajeSeleccionado[28], no = LogIn.lenguajeSeleccionado[29]; 
	private Object opciones[] = {si,no};
	private JButton cancelButton;



	/**
	 * Create the dialog.
	 */
	public AddNuevosVuelos() {
		setResizable(false);
		setTitle(LogIn.lenguajeSeleccionado[32]);
		addKeyListener(this);
		setModal(true);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(this);
		setBounds(100, 100, 319, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		textFieldOrigen = new JTextField();
		textFieldOrigen.setBounds(181, 27, 86, 20);
		contentPanel.add(textFieldOrigen);
		textFieldOrigen.setColumns(10);
		textFieldOrigen.addFocusListener(this);
		textFieldOrigen.addKeyListener(this);
		
		textFieldSalida = new JTextField();
		textFieldSalida.setColumns(10);
		textFieldSalida.setBounds(181, 58, 86, 20);
		contentPanel.add(textFieldSalida);
		textFieldSalida.addFocusListener(this);
		textFieldSalida.addKeyListener(this);
		
		textFieldLlegada = new JTextField();
		textFieldLlegada.setColumns(10);
		textFieldLlegada.setBounds(181, 89, 86, 20);
		contentPanel.add(textFieldLlegada);
		textFieldLlegada.addFocusListener(this);
		textFieldLlegada.addKeyListener(this);
		
		textFieldClase = new JTextField();
		textFieldClase.setColumns(10);
		textFieldClase.setBounds(181, 120, 86, 20);
		contentPanel.add(textFieldClase);
		textFieldClase.addFocusListener(this);
		textFieldClase.addKeyListener(this);
		
		textFieldPrecio = new JTextField();
		textFieldPrecio.setColumns(10);
		textFieldPrecio.setBounds(181, 151, 86, 20);
		contentPanel.add(textFieldPrecio);
		textFieldPrecio.addFocusListener(this);
		textFieldPrecio.addKeyListener(this);
		
		JLabel LabelOrigen = new JLabel(LogIn.lenguajeSeleccionado[19]);
		LabelOrigen.setBounds(10, 30, 127, 14);
		contentPanel.add(LabelOrigen);
		
		JLabel LabelHSalida = new JLabel(LogIn.lenguajeSeleccionado[20]);
		LabelHSalida.setBounds(10, 61, 127, 14);
		contentPanel.add(LabelHSalida);
		
		JLabel LabelHLlegada = new JLabel(LogIn.lenguajeSeleccionado[21]);
		LabelHLlegada.setBounds(10, 92, 127, 14);
		contentPanel.add(LabelHLlegada);
		
		JLabel LabelClase = new JLabel(LogIn.lenguajeSeleccionado[22]);
		LabelClase.setBounds(10, 123, 127, 14);
		contentPanel.add(LabelClase);
		
		JLabel LabelPrecio = new JLabel(LogIn.lenguajeSeleccionado[23]);
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
				btnAceptar = new JButton(LogIn.lenguajeSeleccionado[24]);
				btnAceptar.setEnabled(false);
				buttonPane.add(btnAceptar);
				getRootPane().setDefaultButton(btnAceptar);
				btnAceptar.addActionListener(this);
			}
			{
				cancelButton = new JButton(LogIn.lenguajeSeleccionado[25]);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				cancelButton.addActionListener(this);
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
				
			}
			
		}
		
		if(cancelButton == e.getSource()) {
			dispose();
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
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent e) {
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
		
		if(comprobacionCamposRellenos()) {
			btnAceptar.setEnabled(true);
		}
	}
	
	private boolean comprobacionCamposRellenos() {
		boolean check = true;
		if(textFieldOrigen.getText().equals("") || textFieldLlegada.getText().equals("") || textFieldSalida.getText().equals("") || textFieldClase.getText().equals("") || textFieldPrecio.getText().equals("")) {
			check = false;
		}
		
		return check;
		 
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			btnAceptar.doClick();
			
		}
		
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			cancelButton.doClick();
			
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
