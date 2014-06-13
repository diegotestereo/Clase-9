package DAOs;

public class Libro {
	
	int cantidadHojas;
	String nombre;
	String autor;
	int precio;
	boolean activo;
	
	


	public Libro()
	{
		// es el constructor... mismo nombre que
		
		// que la clase y no devuelve nada.
		
	}


	public int getCantidadHojas() {
		return cantidadHojas;
	}


	public void setCantidadHojas(int cantidadHojas) {
		this.cantidadHojas = cantidadHojas;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getAutor() {
		return autor;
	}


	public void setAutor(String autor) {
		this.autor = autor;
	}


	public int getPrecio() {
		return precio;
	}


	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	
	
	
	

}
