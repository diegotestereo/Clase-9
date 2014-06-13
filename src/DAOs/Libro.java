package DAOs;

public class Libro {
	
	int cantidadHojas;
	String nombre;
	String autor;
	int precio;
	boolean activo;
	
	
  public void setActivo(boolean Activo){
	  this.activo=Activo;
  }	
  
  
  public String getActivo(){
	
	  if (activo) return "1";
	  else return "0";
 
  }

	public Libro()
	{
		// es el constructor... mismo nombre que
		
		// que la clase y no devuelve nada.
		
	}


	public int getCantidadHojas() {
		return cantidadHojas;
	}


	public void setCantidadHojas(int CantidadHojas) {
		this.cantidadHojas = CantidadHojas;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String Nombre) {
		this.nombre = Nombre;
	}


	public String getAutor() {
		return autor;
	}


	public void setAutor(String Autor) {
		this.autor = Autor;
	}


	public int getPrecio() {
		return precio;
	}


	public void setPrecio(int Precio) {
		this.precio = Precio;
	}
	
	
	
	
	

}
