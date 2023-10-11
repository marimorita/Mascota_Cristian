package Gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Clases.Procesos;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class Ventana extends JFrame implements ActionListener{
	private JTextField txtPeso;
	private JTextField txtNombre;
	private JTextField txtNombreM;
	private JButton btnCalcular;
	private JButton btnLimpiar;
	JLabel lblResultado;

	
	Procesos misProcesos;

	
	public Ventana() {
		misProcesos = new Procesos();
		setTitle("Promedio alimento mascota");
		setSize(700,366);
		setLayout(null);
		setLocationRelativeTo(null);
		
		iniciarComponentes();
		
	}

	private void iniciarComponentes() {

		JLabel lblTitulo = new JLabel("Sistema promedio alimento para mascotas");
		lblTitulo.setFont(new Font("Verdana", Font.BOLD, 25));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(10, 46, 610, 59);
		
		JLabel lblPeso = new JLabel("Peso (kg):");
		lblPeso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPeso.setBounds(348, 117, 72, 22);
		
		txtPeso = new JTextField();
		txtPeso.setBounds(410, 120, 180, 19);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(90, 120, 201, 19);
				
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setBounds(24, 117, 72, 22);
		
		txtNombreM = new JTextField();
		txtNombreM.setColumns(10);
		txtNombreM.setBounds(126, 162, 96, 19);

		JLabel lblNombreM = new JLabel("Nombre Mascota:");
		lblNombreM.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombreM.setBounds(24, 159, 120, 22);
		
		JLabel lblResultado = new JLabel("Resultado:");
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblResultado.setBounds(24, 215, 586, 22);

		btnCalcular = new JButton("Calcular");
		btnCalcular.setBounds(106, 276, 201, 21);
		btnCalcular.addActionListener(this);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(409, 276, 201, 21);
		btnLimpiar.addActionListener(this);
		
		add(lblTitulo);
		add(lblPeso);
		add(txtPeso);
		add(btnLimpiar);
		add(btnCalcular);
		add(lblNombreM);
		add(txtNombreM);
		add(lblNombre);
		add(txtNombre);
		add(lblResultado);
		
	}
	
	public void calcular() {
			
			String nombre=txtNombre.getText();
			String nombreM=txtNombreM.getText();	
			double Peso=Double.parseDouble(txtPeso.getText());
	
			double promedio=misProcesos.CalcularPromedio(Peso);
			
			
			if (promedio!=0) {
				lblResultado.setText("Resultado: Hola "+nombre+" la cantidade de alimento que debes darle a "+nombreM+" es:" + promedio);
			}else {
				lblResultado.setText("¡OH NO! "+ nombre +"me temo que "+nombreM+ " murio de hambre 💀");
				lblResultado.setForeground(Color.red);
			}
	}
		
	private void limpiar() {
		txtNombre.setText("");
		txtNombreM.setText("");
		txtPeso.setText("");
		lblResultado.setText("Resultado: ");
		limpiar();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnCalcular) {
			System.out.println("Calcular");
			calcular();
		}else if(e.getSource()==btnLimpiar) {
			System.out.println("Limpiar");
			limpiar();
		}		
	}

}