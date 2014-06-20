package DAOs;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

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
	db.execSQL("CREATE TABLE libros(cantidadHojas INTEGER,nombre TEXT,autor TEXT,precio INTEGER)");
		
	}
	//nmetodo actualizar base
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
		db.execSQL("DROP TABLE IF EXIST libros");
		db.execSQL("CREATE TABLE libros (cantidadHojas INTEGER,nombre TEXT,autor TEXT,precio INTEGER)");
			
	}
	
	public void insertarDatos(Libro oLibro){
	// abro base de datos
		SQLiteDatabase BaseDatos = getWritableDatabase();
		//inserto
		BaseDatos.execSQL("INSERT INTO libros (cantidadHojas,nombre,autor,precio) VALUES ("+
		+oLibro.getCantidadHojas()+",'"+oLibro.getNombre()+"','"+oLibro.getAutor()+"',"+oLibro.getPrecio() +")");
	// cierro bbdd
		BaseDatos.close();		
		
	}
	
	public ArrayList<Libro> RecuperarDatos(){
		//creo base de datos
		SQLiteDatabase basedatos =getWritableDatabase();
		//Creo string que almacena instruccion sql
		String SQL ="SELECT * FROM libros";
		//creo un cursor para seleccionar
		Cursor cursor =basedatos.rawQuery(SQL, null);
		// creo arreglo(libros) con objetos del tipo Libro y lo instancio
		ArrayList<Libro> libros = new ArrayList<Libro>();
		
		while (cursor.moveToNext()){
			/*cargo en el cursor todas las filas de la base 
			 * de datos para luego recorrerlas
			 * y cargarlas en cada objeto libro
			 * de esta forma
			 * 
			 */
			Libro oLibro=new Libro();
			oLibro.setCantidadHojas(cursor.getInt(0));
			oLibro.setNombre(cursor.getString(1));
			oLibro.setAutor(cursor.getString(2));
			oLibro.setPrecio(cursor.getInt(3));
			libros.add(oLibro);
			
		}
		/*luego cierro la base de datos y el cursor 
		 * lo antes posible
		 * 
		 */
		cursor.close();
		basedatos.close();		
		
		return libros;
	}
	
	public ArrayList<String> RecuperarNombresLibros(){
		//creo base de datos
		SQLiteDatabase basedatos =getWritableDatabase();
		//Creo string que almacena instruccion sql
		String SQL ="SELECT * FROM libros";
		//creo un cursor para seleccionar
		Cursor cursor =basedatos.rawQuery(SQL, null);
		// creo arreglo(libros) con objetos del tipo Libro y lo instancio
		ArrayList<String> libros = new ArrayList<String>();
		
		while (cursor.moveToNext()){
			/*cargo en el cursor todas las filas de la base 
			 * de datos para luego recorrerlas
			 * y cargarlas en cada objeto libro
			 * de esta forma
			 * 
			 */
						
			libros.add(cursor.getString(1));
			
			
		}
		/*luego cierro la base de datos y el cursor 
		 * lo antes posible
		 * 
		 */
		cursor.close();
		basedatos.close();		
		
		return libros;
	}
	
	public int recuperarCantidad(){
			
		SQLiteDatabase basedatos=getWritableDatabase();
		String SQL ="SELECT * FROM libros";
		Cursor cursor = basedatos.rawQuery(SQL, null);
		int  cantidad=cursor.getCount();// cantidad de elementos	
		cursor.close();
		basedatos.close();	
		return cantidad;
		
	}
	
	
	public void borrarlibro(Libro oLibro){//ingreso con el nombre dle objetolibro uque quiero borrar
		SQLiteDatabase basedatos=getWritableDatabase();
		String SQL="DELETE FROM libros WHERE nombre='"+oLibro.getNombre()+"'";
		basedatos.execSQL(SQL);
		
		
	}
	
	public void actualizarLibro(Libro olibro)
	{
		 SQLiteDatabase baseDatos = getWritableDatabase();
		 baseDatos.execSQL("UPDATE libros set precio ="+olibro.getPrecio()+" where nombre = '"+olibro.getNombre()+"';" );
		 baseDatos.close(); 
	}
	
}
