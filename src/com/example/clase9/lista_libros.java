package com.example.clase9;

import java.util.ArrayList;

import DAOs.DAOs_Libros;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class lista_libros extends Activity
{
	
	 ListView ListaLibros;
	 DAOs_Libros dao ;
	// Libro oLibro;
	ArrayList<String> equipos;
	ArrayAdapter<String> adaptador_elementos;
	
	
	
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.lista_libros);
	levantarXML();
	 ///////instancio las clases DAO y Libro//////////////
    dao =new DAOs_Libros(this, "BaseDatos", null, 1);
   // oLibro=new Libro() ;
    //equipos = new String[]{"Velez","Boca","River","Otro"};
          
     /////////////////////////////////////////////////////
    LevantarDatos();
}

private void LevantarDatos() {
	
	equipos=dao.RecuperarNombresLibros();
	adaptador_elementos = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,equipos);
	ListaLibros.setOnItemLongClickListener(new OnItemLongClickListener() {

		@Override
		public boolean onItemLongClick(AdapterView<?> parent, View view,
				int position, long id) {
		Toast.makeText(getApplicationContext(), "posicion "+position, Toast.LENGTH_SHORT).show();
			return false;
		}
	});
    ListaLibros.setAdapter(adaptador_elementos);  
	
}

private void levantarXML() {
	
	ListaLibros= (ListView) findViewById(R.id.listView1);
}
}
