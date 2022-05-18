package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

import dao.AtletaDAO;
import dao.MetalDAO;
import dao.PatrocinadorDAO;
import dao.PruebaDAO;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

import entidades.*;
import utils.ConexBD;
import validaciones.Validaciones;

import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JCheckBox;

public class CerrarPrueba1 extends JFrame {

	/**
	*
	*/
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNombre;
	private final ButtonGroup buttonGroupTipo = new ButtonGroup();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					int idprueba = 1;
					CerrarPrueba1 frame = new CerrarPrueba1(idprueba);
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
	public CerrarPrueba1(int idprueba) {
		PruebaDAO pDAO = new PruebaDAO(ConexBD.getCon());
		Prueba prueba = pDAO.buscarPorID(idprueba);
		if (prueba != null) {
			setTitle("Cerrar Prueba" + idprueba);
		} else
			setTitle("Cerrar Prueba INDETERMINADA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 707, 676);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(
				new TitledBorder(null, "Datos de la prueba", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 21, 424, 199);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblIdPrueba = new JLabel("IdPrueba:");
		lblIdPrueba.setBounds(22, 21, 77, 14);
		panel_1.add(lblIdPrueba);

		textField = new JTextField("" + prueba.getId());
		textField.setBounds(86, 14, 86, 20);
		panel_1.add(textField);
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(22, 48, 77, 14);
		panel_1.add(lblNombre);

		textFieldNombre = new JTextField(prueba.getNombre());
		textFieldNombre.setBounds(86, 41, 261, 20);
		panel_1.add(textFieldNombre);
		textFieldNombre.setEnabled(false);
		textFieldNombre.setEditable(false);
		textFieldNombre.setColumns(10);

		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(22, 73, 46, 14);
		panel_1.add(lblFecha);

		JLabel lblLugar = new JLabel("Lugar:");
		lblLugar.setBounds(200, 73, 46, 14);
		panel_1.add(lblLugar);

		JComboBox comboBoxLugar = new JComboBox();
		comboBoxLugar.setBounds(245, 69, 169, 22);
		panel_1.add(comboBoxLugar);
		comboBoxLugar.setEnabled(false);
		comboBoxLugar.setModel(new DefaultComboBoxModel(Lugar.values()));

		JPanel panel = new JPanel();
		panel.setBounds(22, 98, 210, 52);
		panel_1.add(panel);
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Tipo de Prueba:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		JRadioButton rbIndividual = new JRadioButton("Individual");

		rbIndividual.setEnabled(false);
		buttonGroupTipo.add(rbIndividual);
		panel.add(rbIndividual);

		JRadioButton rbEquipos = new JRadioButton("Por Equipos");
		rbEquipos.setEnabled(false);
		buttonGroupTipo.add(rbEquipos);
		panel.add(rbEquipos);
		if (prueba.isIndividual())
			rbIndividual.setSelected(true);
		else
			rbEquipos.setSelected(true);

		JLabel lblPatrocinador = new JLabel("Patrocinador:");
		lblPatrocinador.setBounds(22, 161, 87, 14);
		panel_1.add(lblPatrocinador);

		JLabel lblprimerpuesto = new JLabel("Primer puesto *:");
		lblprimerpuesto.setBounds(10, 264, 109, 14);
		contentPane.add(lblprimerpuesto);

		JLabel lblsegundopuesto = new JLabel("Segundo puesto *:");
		lblsegundopuesto.setBounds(10, 384, 109, 14);
		contentPane.add(lblsegundopuesto);

		JLabel lbltercerpuesto = new JLabel("Tercer puesto *:");
		lbltercerpuesto.setBounds(10, 488, 109, 14);
		contentPane.add(lbltercerpuesto);

		DefaultComboBoxModel<Atleta> atletasModel = new DefaultComboBoxModel<Atleta>();
		AtletaDAO aDAO = new AtletaDAO(ConexBD.getCon());
		ArrayList<Atleta> atletassList = (ArrayList<Atleta>) aDAO.buscarTodos();
		/// Pero el modelo de comboBox básico requiere Strings
		// Creo un string de 100 ya que de otra forma el programa me devueleve un fallo
		/// *No se pueder invocar .data porque this. persona es null*
		String[] atletasStr = new String[100];
		for (int i = 0; i < 100; i++) {
			atletasStr[i] = atletassList.get(i).getPersona().data();
		}
		/*
		 * Lo óptimo sería crear la clase personaDAO y buscar desde ahí los datos de la
		 * persona, pero debido a falta de tiempo, lo hago utilizando el método
		 * buscarPorId de la calse datos
		 */

		JComboBox<Atleta> comboBoxPuesto1 = new JComboBox<Atleta>();
		comboBoxPuesto1.setModel(new DefaultComboBoxModel(atletasStr));
		lblprimerpuesto.setLabelFor(comboBoxPuesto1);
		comboBoxPuesto1.setBounds(140, 260, 287, 22);
		contentPane.add(comboBoxPuesto1);

		JComboBox<Atleta> comboBoxPuesto2 = new JComboBox<Atleta>();
		comboBoxPuesto2.setModel(new DefaultComboBoxModel(atletasStr));
		lblsegundopuesto.setLabelFor(comboBoxPuesto2);
		comboBoxPuesto2.setBounds(140, 380, 287, 22);
		contentPane.add(comboBoxPuesto2);

		JComboBox<Atleta> comboBoxPuesto3 = new JComboBox<Atleta>();
		comboBoxPuesto3.setModel(new DefaultComboBoxModel(atletasStr));
		lbltercerpuesto.setLabelFor(comboBoxPuesto3);
		comboBoxPuesto3.setBounds(140, 484, 287, 22);
		contentPane.add(comboBoxPuesto3);

		LocalDate hoyMas1MesLD = LocalDate.now().plusMonths(1);
		java.util.Date hoyMas1Mes = new Date(hoyMas1MesLD.getYear() - 1900, hoyMas1MesLD.getMonthValue() - 1,
				hoyMas1MesLD.getDayOfMonth());

/// Las siguientes lineas seria lo deseable: trabajar diectamente con objetos en
/// el model del comboBox
		DefaultComboBoxModel<Patrocinador> patrocinadoresModel = new DefaultComboBoxModel<Patrocinador>();
		JComboBox<Patrocinador> comboBoxPatrocinador = new JComboBox<Patrocinador>(patrocinadoresModel);
		PatrocinadorDAO patDAO = new PatrocinadorDAO(ConexBD.getCon());
		ArrayList<Patrocinador> patrocinadoresList = (ArrayList<Patrocinador>) patDAO.buscarTodos();
		for (Patrocinador pat : patrocinadoresList)
			comboBoxPatrocinador.addItem(pat);

/// Pero el modelo de comboBox básico requiere Strings
		String[] patrocinadoresStr = new String[patrocinadoresList.size()];
		for (int i = 0; i < patrocinadoresList.size(); i++)
			patrocinadoresStr[i] = patrocinadoresList.get(i).mostrarBasico();
		comboBoxPatrocinador.setModel(new DefaultComboBoxModel(patrocinadoresStr));
		comboBoxPatrocinador.setBounds(96, 157, 261, 22);
		panel_1.add(comboBoxPatrocinador);
		comboBoxPatrocinador.setEnabled(false);

		JSpinner spinnerFecha = new JSpinner();
		spinnerFecha.setBounds(86, 69, 86, 20);
		panel_1.add(spinnerFecha);
		spinnerFecha.setEnabled(false);
		spinnerFecha.setModel(new SpinnerDateModel(hoyMas1Mes, hoyMas1Mes, null, Calendar.DAY_OF_YEAR));

		JLabel lblOro = new JLabel("IdOro *:");
		lblOro.setBounds(26, 319, 46, 14);
		contentPane.add(lblOro);

		JLabel lblPlata = new JLabel("IdPlata * :");
		lblPlata.setBounds(26, 439, 57, 14);
		contentPane.add(lblPlata);

		JLabel lblBronce = new JLabel("IdBronce *:");
		lblBronce.setBounds(26, 549, 70, 14);
		contentPane.add(lblBronce);

		JComboBox<Oro> comboBoxOro = new JComboBox<Oro>();
		comboBoxOro.setBounds(93, 315, 70, 22);

		JComboBox<Plata> comboBoxPlata = new JComboBox<Plata>();
		comboBoxPlata.setBounds(93, 435, 70, 22);

		JComboBox<Bronce> comboBoxBronce = new JComboBox<Bronce>();
		comboBoxBronce.setBounds(93, 545, 70, 22);

		MetalDAO metalDAO = new MetalDAO(ConexBD.getCon());
		ArrayList<Metal> metalesList = (ArrayList<Metal>) metalDAO.buscarTodos();
		ArrayList<Oro> oroList = new ArrayList<Oro>();
		ArrayList<Plata> plataList = new ArrayList<Plata>();
		ArrayList<Bronce> bronceList = new ArrayList<Bronce>();

		for (Metal eq : metalesList) {
			if (!eq.asignada && eq.getClass().equals(Oro.class)) {
				oroList.add((Oro) eq);
			}

			if (!eq.asignada && eq.getClass().equals(Plata.class)) {
				plataList.add((Plata) eq);
			}

			if (!eq.asignada && eq.getClass().equals(Bronce.class)) {
				bronceList.add((Bronce) eq);
			}

		}

		String[] oroStr = new String[20];
		for (int i = 0; i < oroList.size(); i++) {
			oroStr[i + 1] = oroList.get(i).toString();
		}

		String[] plataStr = new String[20];
		for (int i = 0; i < plataList.size(); i++) {
			oroStr[i + 1] = plataList.get(i).toString();
		}

		String[] bronceStr = new String[20];
		for (int i = 0; i < bronceList.size(); i++) {
			oroStr[i + 1] = bronceList.get(i).toString();
		}
		comboBoxOro.setModel(new DefaultComboBoxModel(oroStr));
		contentPane.add(comboBoxOro);
		comboBoxOro.setModel(new DefaultComboBoxModel(oroStr));
		contentPane.add(comboBoxOro);

		comboBoxPlata.setModel(new DefaultComboBoxModel(plataStr));
		contentPane.add(comboBoxPlata);

		comboBoxBronce.setModel(new DefaultComboBoxModel(bronceStr));
		contentPane.add(comboBoxBronce);

		JButton buttonAceptar = new JButton("Aceptar");
		buttonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean valido = false;
				String titulo = "";
				String msj = "";
				String errores = "";

				Resultado result = new Resultado();

				long idOro = comboBoxOro.getSelectedIndex();
				float pureza = 0.0F;
				Oro o = new Oro(idOro, pureza);
				valido = Validaciones.validarId(idOro);
				if (!valido) {
					errores += "El Id del oro no es correcto.\n";
					lblOro.setForeground(Color.RED);
				} else {
					result.setPrimero(o);
					valido = false;
				}

				long idPlata = comboBoxPlata.getSelectedIndex();
				Plata p = new Plata(idPlata, pureza);
				valido = Validaciones.validarId(idPlata);
				if (!valido) {
					errores += "El Id de la plata no es correcto.\n";
					lblPlata.setForeground(Color.RED);
				} else {
					result.setPrimero(o);
					valido = false;
				}

				long idBronce = comboBoxPlata.getSelectedIndex();
				Bronce b = new Bronce(idBronce, pureza);
				valido = Validaciones.validarId(idPlata);
				if (!valido) {
					errores += "El Id del bronce no es correcto.\n";
					lblBronce.setForeground(Color.RED);
				} else {
					result.setPrimero(o);
					valido = false;
				}
/// Tomar cada campo y validarlo. Si alguno no es correcto, avisar al usuario
// String nombre = textFieldNombre.getText();
// valido = Validaciones.validarNombrePrueba(nombre);
// if (!valido) {
// errores += "El nombre de la prueba no es válido (5-150 caracteres).\n";
// lblNombre.setForeground(Color.RED);
// } else
// nueva.setNombre(nombre);
// valido = false;
//
// java.util.Date fecha = (java.util.Date) spinnerFecha.getValue();
// valido = Validaciones.validarFechaNuevaPrueba(fecha);
// if (!valido) {
// errores += "La fecha de la prueba no es válido (posterior a 1 mes desde hoy).\n";
// lblFecha.setForeground(Color.RED);
// } else {
// LocalDate fechaLD = LocalDate.of(fecha.getYear() + 1900, fecha.getMonth() + 1, fecha.getDate());
// nueva.setFecha(fechaLD);
// }
// valido = false;
// valido = (comboBoxLugar.getSelectedIndex() != -1);
// if (!valido) {
// errores += "Debe seleccionar el lugar de celebración de la nueva prueba.\n";
// lblLugar.setForeground(Color.RED);
// } else {
// Lugar lugar = (Lugar) comboBoxLugar.getSelectedItem();
// nueva.setLugar(lugar);
// }
// valido = false;
// valido = !(!rbIndividual.isSelected() && !rbEquipos.isSelected())
// || (rbIndividual.isSelected() && rbEquipos.isSelected());
// if (!valido) {
// errores += "Debe seleccionar si la nueva prueba es individual O por equipos.\n";
// rbIndividual.setForeground(Color.RED);
// rbEquipos.setForeground(Color.RED);
// } else {
// nueva.setIndividual(rbIndividual.isSelected() ? true : false);
// }
// valido = false;
// valido = (comboBoxPatrocinador.getSelectedIndex() != -1);
// if (!valido) {
// errores += "Debe seleccionar el Patrocinador de la nueva prueba.\n";
// lblPatrocinador.setForeground(Color.RED);
// } else {
// PatrocinadorDAO patDAO = new PatrocinadorDAO(ConexBD.getCon());
// String seleccionado = (String) comboBoxPatrocinador.getSelectedItem();
// String[] aux = seleccionado.split("\\.");
// long idPat = Long.valueOf(aux[0]);
// Patrocinador patrocinador = patDAO.buscarPorID(idPat);
// ConexBD.cerrarConexion();
// if (patrocinador == null)
// valido = false;
// else
// nueva.setPatrocinador(patrocinador);
// }

				valido = errores.isEmpty();

				if (!valido) {
					titulo = "ERROR: Campos inválidos";
					msj = "ERROR: los siguientes campos NO son válidos:\n\n";
					if (!errores.isEmpty())
						msj += errores + "\n";
					JOptionPane.showMessageDialog(null, msj, titulo, JOptionPane.ERROR_MESSAGE);
					return;
				}

/// Si todos los datos son correctos, llamar a PruebaDAO para insertar en la BD
				PruebaDAO pruebadao = new PruebaDAO(ConexBD.establecerConexion());
				boolean correcto = pruebadao.modificar(prueba);
/// Tanto si la inserción de la nueva prueba tiene éxito como si no, avisar al
/// usuario
				if (!correcto) {
// hubo error al insertar en BD y no se generó la nueva prueba
					titulo = "ERROR al cerrar la Prueba en la BD";
					msj = "Hubo un error y NO se ha cerrado la prueba en la BD.";
					JOptionPane.showMessageDialog(null, msj, titulo, JOptionPane.ERROR_MESSAGE);
				} else {
					titulo = "Prueba " + prueba.getId() + " cerrada en la BD";
					msj = "Se ha cerrado correctamente la prueba:\n" + prueba.toString();
					JOptionPane.showMessageDialog(null, msj, titulo, JOptionPane.INFORMATION_MESSAGE);
/// Aqui se redirigiría al usuario hacia la pantalla principal
/// TODO
				}
			}
		});
		buttonAceptar.setBounds(480, 591, 89, 23);
		contentPane.add(buttonAceptar);

		JButton buttonCancelar = new JButton("Cancelar");
		buttonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titulo = "Cerrar ventana";
				String msj = "¿Realmente desea cerrar la ventana?";
				int opcion = JOptionPane.showConfirmDialog(null, msj, titulo, JOptionPane.OK_CANCEL_OPTION);
				if (opcion == JOptionPane.YES_OPTION) {
/// Aqui se redirigiría al usuario hacia la pantalla principal o se saldria
					System.exit(0); /// SALIR directamente
				}

			}
		});
		buttonCancelar.setBounds(580, 591, 89, 23);
		contentPane.add(buttonCancelar);

		JLabel lblHoras = new JLabel("Horas:");
		lblHoras.setBounds(26, 288, 46, 14);
		contentPane.add(lblHoras);

		JSpinner spinner = new JSpinner();
		spinner.setBounds(66, 286, 30, 20);
		contentPane.add(spinner);

		JLabel lblHoras_1 = new JLabel("Minutos:");
		lblHoras_1.setBounds(140, 288, 46, 14);
		contentPane.add(lblHoras_1);

		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(184, 286, 30, 20);
		contentPane.add(spinner_1);

		JLabel lblHoras_2 = new JLabel("Segundos:");
		lblHoras_2.setBounds(261, 288, 68, 14);
		contentPane.add(lblHoras_2);

		JSpinner spinner_2 = new JSpinner();
		spinner_2.setBounds(320, 286, 30, 20);
		contentPane.add(spinner_2);

		JLabel lblCentsimas = new JLabel("Centésimas:");
		lblCentsimas.setBounds(404, 288, 68, 14);
		contentPane.add(lblCentsimas);

		JSpinner spinner_3 = new JSpinner();
		spinner_3.setBounds(465, 286, 30, 20);
		contentPane.add(spinner_3);

		JLabel lblHoras_3 = new JLabel("Horas:");
		lblHoras_3.setBounds(20, 410, 46, 14);
		contentPane.add(lblHoras_3);

		JSpinner spinner_4 = new JSpinner();
		spinner_4.setBounds(60, 408, 30, 20);
		contentPane.add(spinner_4);

		JLabel lblHoras_1_1 = new JLabel("Minutos:");
		lblHoras_1_1.setBounds(134, 410, 46, 14);
		contentPane.add(lblHoras_1_1);

		JSpinner spinner_1_1 = new JSpinner();
		spinner_1_1.setBounds(178, 408, 30, 20);
		contentPane.add(spinner_1_1);

		JLabel lblHoras_2_1 = new JLabel("Segundos:");
		lblHoras_2_1.setBounds(255, 410, 68, 14);
		contentPane.add(lblHoras_2_1);

		JSpinner spinner_2_1 = new JSpinner();
		spinner_2_1.setBounds(314, 408, 30, 20);
		contentPane.add(spinner_2_1);

		JLabel lblCentsimas_1 = new JLabel("Centésimas:");
		lblCentsimas_1.setBounds(398, 410, 68, 14);
		contentPane.add(lblCentsimas_1);

		JSpinner spinner_3_1 = new JSpinner();
		spinner_3_1.setBounds(459, 408, 30, 20);
		contentPane.add(spinner_3_1);

		JLabel lblHoras_4 = new JLabel("Horas:");
		lblHoras_4.setBounds(20, 514, 46, 14);
		contentPane.add(lblHoras_4);

		JSpinner spinner_5 = new JSpinner();
		spinner_5.setBounds(60, 512, 30, 20);
		contentPane.add(spinner_5);

		JLabel lblHoras_1_2 = new JLabel("Minutos:");
		lblHoras_1_2.setBounds(134, 514, 46, 14);
		contentPane.add(lblHoras_1_2);

		JSpinner spinner_1_2 = new JSpinner();
		spinner_1_2.setBounds(178, 512, 30, 20);
		contentPane.add(spinner_1_2);

		JLabel lblHoras_2_2 = new JLabel("Segundos:");
		lblHoras_2_2.setBounds(255, 514, 68, 14);
		contentPane.add(lblHoras_2_2);

		JSpinner spinner_2_2 = new JSpinner();
		spinner_2_2.setBounds(314, 512, 30, 20);
		contentPane.add(spinner_2_2);

		JLabel lblCentsimas_2 = new JLabel("Centésimas:");
		lblCentsimas_2.setBounds(398, 514, 68, 14);
		contentPane.add(lblCentsimas_2);

		JSpinner spinner_3_2 = new JSpinner();
		spinner_3_2.setBounds(459, 512, 30, 20);
		contentPane.add(spinner_3_2);

		JLabel lblEstablecerComoDefinitivo = new JLabel("ESTABLECER COMO DEFINITIVO *:");
		lblEstablecerComoDefinitivo.setBounds(10, 595, 171, 14);
		contentPane.add(lblEstablecerComoDefinitivo);

		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setBounds(184, 592, 93, 21);
		contentPane.add(chckbxNewCheckBox);

	}
}