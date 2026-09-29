package uo.cpm.examen.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import uo.cpm.examen.model.Cliente;
import uo.cpm.examen.model.Pelicula;

public class FileUtil {
// ADAPTAR PARA LOS DATOS IMPLEMENTADOS EN EL EXAMEN

// M�todo que lee un fichero y lo carga en una lista
	public static void loadFile(String nombreFicheroEntrada, List<Pelicula> listaPeliculas) {
		String linea;
		String[] datosArticulo = null;
		try {
			BufferedReader fichero = new BufferedReader(new FileReader(nombreFicheroEntrada));
			while (fichero.ready()) {
				linea = fichero.readLine();
				datosArticulo = linea.split(";");
				listaPeliculas.add(new Pelicula(datosArticulo[0], datosArticulo[1], datosArticulo[2],
						Float.parseFloat(datosArticulo[3])));
			}
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha encontrado.");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida.");
		}
	}

	public static void loadVips(String nombreFicheroEntrada, List<Cliente> listaVips) {
		String linea;
		String[] datosArticulo = null;
		try {
			BufferedReader fichero = new BufferedReader(new FileReader(nombreFicheroEntrada));
			while (fichero.ready()) {
				linea = fichero.readLine();
				datosArticulo = linea.split(";");
				listaVips.add(new Cliente(true, datosArticulo[0]));
			}
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha encontrado.");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida.");
		}
	}
}