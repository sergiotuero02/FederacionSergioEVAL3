package entidades;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

import utils.Datos;

public class ComparadorAlfabetico implements Comparator<DatosPersona> {
//Examen 9, ejercicio 2.
	@Override
	public int compare(DatosPersona o1, DatosPersona o2) {
		return Integer.compare(o1.getNombre().charAt(0), o2.getNombre().charAt(0));
	}
	public ComparadorAlfabetico() {
		
	}

	public static void personasOrdenadas() {
		LinkedList<DatosPersona> ret = new LinkedList<DatosPersona>();
		for (DatosPersona dp : Datos.PERSONAS) {
			ret.add(dp);
		}
		Collections.sort(ret, new ComparadorAlfabetico());
		System.out.println("La lista ordenada de todas las personas es:");
		Iterator<DatosPersona> it = ret.iterator();
		int i = 1;
		while (it.hasNext()) {
			System.out.println(i + ": " + ((DatosPersona) it.next()).toString() + " ");
			i++;
		}
	}
}
