package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.EquipoDAO;
import entidades.Atleta;
import entidades.Equipo;
import utils.ConexBD;
import validaciones.Validaciones;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class formularioAtleta extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldPeso;
	private JTextField textFieldAltura;
	private JTextField textFieldTel;
	private JTextField textFieldNombre;
	private JTextField textFieldDoc;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					formularioAtleta frame = new formularioAtleta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public formularioAtleta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 704, 533);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 670, 464);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("DATOS PERSONALES");
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 10, 148, 13);
		panel.add(lblNewLabel);

		JLabel lblNombre = new JLabel("NOMBRE*:");
		lblNombre.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblNombre.setBounds(10, 51, 148, 13);
		panel.add(lblNombre);

		JLabel lblDocumentacin = new JLabel("DOCUMENTACIÓN*:");
		lblDocumentacin.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblDocumentacin.setBounds(10, 91, 148, 13);
		panel.add(lblDocumentacin);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("NIF");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(10, 110, 103, 21);
		panel.add(rdbtnNewRadioButton);

		JRadioButton rdbtnNie = new JRadioButton("NIE");
		buttonGroup.add(rdbtnNie);
		rdbtnNie.setBounds(115, 110, 103, 21);
		panel.add(rdbtnNie);

		JLabel lblValorDeLa = new JLabel("VALOR DE LA DOCUMENTACIÓN");
		lblValorDeLa.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblValorDeLa.setBounds(222, 91, 266, 13);
		panel.add(lblValorDeLa);

		JLabel lblTelfono = new JLabel("TELÉFONO:");
		lblTelfono.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblTelfono.setBounds(10, 150, 88, 13);
		panel.add(lblTelfono);

		JLabel lblFechaDeNacimiento = new JLabel("FECHA DE NACIMIENTO");
		lblFechaDeNacimiento.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblFechaDeNacimiento.setBounds(10, 189, 172, 13);
		panel.add(lblFechaDeNacimiento);

		JLabel lblDatosFsicos = new JLabel("DATOS FÍSICOS");
		lblDatosFsicos.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblDatosFsicos.setBounds(10, 225, 111, 13);
		panel.add(lblDatosFsicos);

		JLabel lblAltura = new JLabel("ALTURA*:");
		lblAltura.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblAltura.setBounds(10, 248, 71, 13);
		panel.add(lblAltura);

		JLabel lblPeso = new JLabel("PESO*:");
		lblPeso.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblPeso.setBounds(10, 271, 56, 13);
		panel.add(lblPeso);

		JLabel lblEquipo = new JLabel("EQUIPO:");
		lblEquipo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblEquipo.setBounds(10, 312, 66, 13);
		panel.add(lblEquipo);

		DefaultComboBoxModel<Equipo> modeloEquipo = new DefaultComboBoxModel<Equipo>();
		JComboBox<Equipo> comboBoxEquipos = new JComboBox<Equipo>(modeloEquipo);
		comboBoxEquipos.setBounds(86, 310, 109, 21);
		;
		EquipoDAO eqpDAO = new EquipoDAO(ConexBD.getCon());
		ArrayList<Equipo> equiposList = (ArrayList<Equipo>) eqpDAO.buscarTodos();
		for (Equipo equipo : equiposList) {
			comboBoxEquipos.addItem(equipo);
		}

		String[] equiposString = new String[equiposList.size()];
		for (int i = 0; i < equiposList.size(); i++)
			equiposString[i] = equiposList.get(i).toString();
		comboBoxEquipos.setModel(new DefaultComboBoxModel(equiposString));
		
		panel.add(comboBoxEquipos);

		textFieldPeso = new JTextField();
		textFieldPeso.setBounds(85, 271, 96, 19);
		panel.add(textFieldPeso);
		textFieldPeso.setColumns(10);

		textFieldAltura = new JTextField();
		textFieldAltura.setColumns(10);
		textFieldAltura.setBounds(85, 248, 96, 19);
		panel.add(textFieldAltura);

		textFieldTel = new JTextField();
		textFieldTel.setColumns(10);
		textFieldTel.setBounds(99, 149, 96, 19);
		panel.add(textFieldTel);

		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(85, 50, 202, 19);
		panel.add(textFieldNombre);

		textFieldDoc = new JTextField();
		textFieldDoc.setColumns(10);
		textFieldDoc.setBounds(224, 111, 237, 19);
		panel.add(textFieldDoc);

		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerDateModel(new Date(1652220000000L), null, null, Calendar.DAY_OF_YEAR));
		spinner.setBounds(188, 188, 88, 20);
		panel.add(spinner);

		JButton btnNewButton = new JButton("ACEPTAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Atleta nuevo = new Atleta();
				boolean valido = false;

				String titulo = "";
				String msj = "";
				String errores = "";
				String nombre = textFieldNombre.getText();
				valido = Validaciones.validarNombre(nombre);
				if (!valido) {

					errores += "El nombre del Atleta no es válido (3-50 caracteres).\n";
					lblNombre.setForeground(Color.RED);
				} else
					nuevo.getPersona().setNombre(nombre);
				valido = false;

				String docu = textFieldDoc.getText();
				valido = (Validaciones.validarNIE(docu)) || (Validaciones.validarNIF(docu));
				if (!valido) {
					errores += "El dni o nif no es valido ";
				} else
					nuevo.getPersona().getNifnie().mostrar();
				valido = false;

				String telefono = textFieldTel.getText();
				valido = Validaciones.validarTelefono(telefono);

				if (!valido) {
					errores += "el telefono no es el adecuado ";
				} else
					nuevo.getPersona().getTelefono();

				valido = false;
				float peso = 0.0F;
				try {
					peso = Float.valueOf(textFieldPeso.getText());
				} catch (NumberFormatException n) {
					n.getMessage();
				}
				float altura = 0.0F;

				try {
					altura = Float.valueOf(textFieldAltura.getText());
				} catch (NumberFormatException n) {
					n.getMessage();
				}
				

			}

		});
		btnNewButton.setBounds(10, 347, 85, 21);
		panel.add(btnNewButton);

		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBounds(133, 347, 85, 21);
		panel.add(btnCancelar);
		
		JLabel lblNewLabel_1 = new JLabel("m EN FORMATO(XX.XX)");
		lblNewLabel_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(209, 248, 182, 13);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("kg EN FORMATO(XX.XX)");
		lblNewLabel_1_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(209, 271, 182, 19);
		panel.add(lblNewLabel_1_1);

	}

}
