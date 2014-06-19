package com.example.clase9;

import DAOs.DAOs_Libros;
import DAOs.Libro;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class lista_libros extends Activity
{
	
	 ListView ListaLibros;
	 DAOs_Libros dao ;
	 Libro oLibro;
	String[] equipos;
	Adapter adaptador_elementos;
	
	
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.lista_libros);
	levantarXML();
	 ///////instancio las clases DAO y Libro//////////////
    dao =new DAOs_Libros(this, "BaseDatos", null, 1);
    oLibro=new Libro() ;
    equipos = new String[]{"Velez","Boca","River","Otro"};
          
     /////////////////////////////////////////////////////
    LevantarDatos();
}

private void LevantarDatos() {
	//ArrayAdapter<String> adaptador_elementos = new ArrayAdapter<String>(this,android.R.layout.activity_list_item,equipos);
    //ListaLibros.setAdapter(adaptador_elementos);  
	
}

private void levantarXML() {
	
	ListaLibros= (ListView) findViewById(R.id.listView1);
}
}
