package ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class VSeleccionVuelos extends JDialog implements ActionListener, WindowListener, MouseListener{

	private static final long serialVersionUID = 1L;
	public static String hSalida = "";
	public static String hLlegada = "";
	private int filaPulsadaActual = -1;
	private final JPanel contentPanel = new JPanel();
	private JButton btnAceptar;
	private JButton btnCancelar;
	public static JTable table;
	private JPanel buttonPane;
	private JScrollPane scrollPane;
	private String[][] tablaVuelos;
	private int numFilas = VentanaOperar.vuelos.length, numColumnas = 4;
	private JTextField textFieldOrigenVuelo;
	private JLabel labelOrigenVuelo;
	private int filaSeleccionada;

	

	/**
	 * Create the dialog.
	 */
	public VSeleccionVuelos() {
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		addWindowListener(this);
		setBounds(100, 100, 425, 363);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		labelOrigenVuelo = new JLabel("Seleccione un vuelo con origen: ");
		labelOrigenVuelo.setBounds(50, 24, 166, 26);
		contentPanel.add(labelOrigenVuelo);
		
		textFieldOrigenVuelo = new JTextField();
		textFieldOrigenVuelo.setEditable(false);
		textFieldOrigenVuelo.setBounds(214, 27, 86, 20);
		contentPanel.add(textFieldOrigenVuelo);
		textFieldOrigenVuelo.setColumns(10);
		textFieldOrigenVuelo.setText(VentanaOperar.origen);
		
		
		generarTablaScrollPane();
		table.addMouseListener(this);
		generarInferior();
		
		

		
	
		
		
		
		
		
		
		
		
	}
	
	public void generarTablaScrollPane() {
	
		scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 72, 326, 84);
		contentPanel.add(scrollPane);
		
		//TABLA
		{
			
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
				},
				new String[] {
					"Hora Salida", "Hora Llegada", "Clase", "Eur"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
			scrollPane.setViewportView(table);
		}
		
		
		
		
		
		
		addVuelos();
		rellenarTabla();
		
	}
	
	public void generarInferior() {

		// PANEL INFERIOR
		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnAceptar = new JButton("Aceptar");
				btnAceptar.setEnabled(false);
				btnAceptar.setActionCommand("OK");
				buttonPane.add(btnAceptar);
				getRootPane().setDefaultButton(btnAceptar);
				btnAceptar.addActionListener(this);
			}
			{
				btnCancelar = new JButton("Cancel");
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
				btnCancelar.addActionListener(this);
			}
		}
	}
	
	private void addVuelos() {
		

		
		rellenarTabla();
			
	}
	
	private void rellenarTabla() {
		int filaListaVuelos = 0;
		for(int i = 0; i < numFilas; i++) {
			
			if(VentanaOperar.vuelos[i][0].equals(textFieldOrigenVuelo.getText())) {
			for(int j = 0; j <numColumnas; j++) {
				table.setValueAt(VentanaOperar.vuelos[i][j+1], filaListaVuelos, j);
			}
			filaListaVuelos ++;
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
		
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println(hSalida);
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
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int filaseleccionada = table.getSelectedRow();
		
		if(e.getClickCount() == 2) {
			hSalida = (String) table.getValueAt(filaseleccionada, 0);
			hLlegada = (String) table.getValueAt(filaseleccionada, 1);
			System.out.println("hopa" + hSalida );
			dispose();
		}
		
		//Si no hay nada seleccionado (lo sabemos porque las horas son vacías), agrega las horas y da valor a la fila que se ha pulsado
		//Si hay algo seleccionado se comprueba que no fuera lo pulsado anteriormente (guardado en filaPulsadaActual). En caso de que fuera igual se vacían las horas y se resetea filaPulsadaActual
		//en caso de que fueran diferentes, se agregan las horas y se guarda la filaSeleccionada en la filaPulsada
		if(hSalida == "" && hLlegada == "") {
		hSalida = (String) table.getValueAt(filaseleccionada, 0);
		hLlegada = (String) table.getValueAt(filaseleccionada, 1);
		 filaPulsadaActual = filaseleccionada;
		 btnAceptar.setEnabled(true);
		 System.out.println("if" + hSalida );
		}
		else {
			if(filaseleccionada == filaPulsadaActual) {
				hSalida = "";
				hLlegada = "";
				table.removeRowSelectionInterval(filaseleccionada, filaseleccionada);
				filaPulsadaActual = -1;
				btnAceptar.setEnabled(false);
				System.out.println("else if" + hSalida );
			}else {
				hSalida = (String) table.getValueAt(filaseleccionada, 0);
				hLlegada = (String) table.getValueAt(filaseleccionada, 1);
				filaPulsadaActual = filaseleccionada;
				 btnAceptar.setEnabled(true);
				 System.out.println("else else" + hSalida );
			}
			
			
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == btnAceptar) {
			dispose();
		}else if(e.getSource() == btnCancelar) {
			hSalida = "";
			hLlegada = "";
			dispose();
		}
	}
	
	
	
	
	

	
	

}
