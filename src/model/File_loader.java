package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class File_loader {
	//cargar archivos
	// esta funcion carga un archivo de texto y devuelve un array con los datos sin procesar
	public static String[] Cargar_archivo(File filepath) throws IOException 
	{
		String text="";
		String[] result = null;
		try {
			BufferedReader reader =new BufferedReader(new FileReader(filepath));
			String linea = reader.readLine();
			while(linea != null) 
			{
				text+=";"+linea;
				linea = reader.readLine();
			}
			reader.close();
			result = text.split(";");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
