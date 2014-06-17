package com.example.clase9;

import DAOs.DAOs_Libros;
import DAOs.Libro;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	//declaro variables globales
	
	EditText eTxt_Nombre,eTxt_Precio,eTxt_numhojas,eTxt_Autor ;
	Button btn_cantidad,btn_agregar,btn_borrar,btn_atras,btn_adelante,btn_actualizar,btn_Limpiar ;

	public SQLiteDatabase db;

	DAOs_Libros dao ;
	Libro oLibro;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ///////instancio las clases DAO y Libro//////////////
        dao =new DAOs_Libros(this, "BaseDatos", null, 1);
        oLibro=new Libro() ;
        /////////////////////////////////////////////////////
        
    	 levantarXML();
        botones();        
    }

	public void cargarLibro() {
			
		oLibro.setNombre(eTxt_Nombre.getText().toString());
		oLibro.setAutor(eTxt_Autor.getText().toString());
		oLibro.setCantidadHojas(Integer.parseInt(eTxt_numhojas.getText().toString()));
		oLibro.setPrecio(Integer.parseInt(eTxt_Precio.getText().toString()));
		Log.v("cargarlibro","Cargo el objeto Libro");
		
	}

	private void botones() {
	
		db=dao.getWritableDatabase();
		btn_agregar.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.v("onclick","cargarlibro");
				
				cargarLibro();
				Log.v("onclick","insertarDatos");
				
			dao.insertarDatos(oLibro);
			db.close();
			}
		});
		
		
		btn_Limpiar.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				eTxt_Autor.setText("");	
				eTxt_Nombre.setText("");
				eTxt_numhojas.setText("");
				eTxt_Precio.setText("");
			
			}
		});
		////// actualizar
		btn_actualizar.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				 cargarLibro();
				dao.actualizarLibro(oLibro);
				db.close();
			}
		});
		/// borrar libro
		btn_borrar.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					cargarLibro();
					dao.borrarlibro(oLibro);
					db.close();
				}
			});
		
		btn_cantidad.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				dao.recuperarCantidad();
				db.close();
				
			}
		});
		

	}

	private void levantarXML() {
		eTxt_Nombre =(EditText) findViewById(R.id.eTxt_Nombre);
		eTxt_Precio=(EditText) findViewById(R.id.eTxt_Precio);
		eTxt_numhojas=(EditText) findViewById(R.id.eTxt_NumHojas);
		eTxt_Autor=(EditText) findViewById(R.id.eTxt_Autor);
		
		btn_actualizar=(Button) findViewById(R.id.btn_Actualizar);
		btn_adelante=(Button) findViewById(R.id.btn_Adelante);
		btn_agregar=(Button) findViewById(R.id.btn_Agregar);
		btn_borrar=(Button) findViewById(R.id.btn_Borrar);
		btn_atras=(Button) findViewById(R.id.btn_Atras);
		btn_Limpiar=(Button)findViewById(R.id.btn_Limpiar);
		btn_cantidad =(Button)findViewById(R.id.btn_cantidad);
	}


    
}
