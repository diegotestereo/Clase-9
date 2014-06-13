package DAOs;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DAOs_Libros extends SQLiteOpenHelper {

	
	//constructor
	public DAOs_Libros(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
	
	}

	//metodo crear base
	@Override
	public void onCreate(SQLiteDatabase db) {
		// creo la tabla
	db.execSQL("CREATE TABLE libros(id INTEGER,nombre TEXT,autor TEXT)");
		
	}
	//nmetodo actualizar base
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
		db.execSQL("DROP TABLE IF EXIST libros");
		db.execSQL("CREATE TABLE libros(id INTEGER,nombre TEXT,autor TEXT)");
			
	}
	
	public void insertarDatos(Libro oLibro){
	// abro base de datos
		SQLiteDatabase BaseDatos = getWritableDatabase();
		//inserto
		BaseDatos.execSQL("INSERT INTO libros (cantidadHojas,nombre,autor) VALUES ("+oLibro.getCantidadHojas()+","+oLibro.getNombre()+","+oLibro.getAutor()+")");
	// cierro bbdd
		BaseDatos.close();		
		
	}
	
	public ArrayList<Libro> RecuperarDatos(){
		//creo base de datos
		SQLiteDatabase basedatos =getWritableDatabase();
		//Creo string que almacena instruccion sql
		String SQL ="SELECT FROM * libros";
		//creo un cursor para seleccionar
		Cursor cursor =basedatos.rawQuery(SQL, null);
		// creo arreglo(libros) con objetos del tipo Libro y lo instancio
		ArrayList<Libro> libros = new ArrayList<Libro>();
			
		
		
		
		
		
		return libros;
	}
	
	
}
