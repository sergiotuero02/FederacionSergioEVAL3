package Principal_SergioTuero;

import entidades.*;
import utils.ConexBD;
import utils.Datos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;

public class PrincipalExam10 {
	public static void main(String[] args) {

		List<Patrocinador> patrocinadores = new LinkedList<Patrocinador>();

		Responsable r1 = new Responsable(1, "902422202", LocalTime.of(00, 00), LocalTime.of(23, 59),
				Datos.buscarPersonaPorId(1011));
		Patrocinador p1 = new Patrocinador(1, "ALSA", 500.00, "www.alsa.es", r1);
		patrocinadores.add(p1);

		Responsable r2 = new Responsable(2, "985181105", LocalTime.of(9, 00), LocalTime.of(18, 00),
				Datos.buscarPersonaPorId(1012));
		Patrocinador p2 = new Patrocinador(2, "Ayto.Gijon", 250.00, "www.gijon.es", r2);
		patrocinadores.add(p2);

		Responsable r3 = new Responsable(3, "985103000", LocalTime.of(8, 30), LocalTime.of(20, 00),
				Datos.buscarPersonaPorId(1012));
		Patrocinador p3 = new Patrocinador(3, "Universidad de Oviedo", 350.00, "www.uniovi.es", r3);
		patrocinadores.add(p3);

		Responsable r4 = new Responsable(4, "985185503", LocalTime.of(8, 30), LocalTime.of(18, 00),
				Datos.buscarPersonaPorId(1012));
		Patrocinador p4 = new Patrocinador(4, "CIFP la Laboral", 255.99, "www.cifplalaboral.es", r3);
		patrocinadores.add(p4);

	}
}