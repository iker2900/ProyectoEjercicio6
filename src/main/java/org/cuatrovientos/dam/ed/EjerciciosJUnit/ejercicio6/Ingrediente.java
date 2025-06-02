package org.cuatrovientos.dam.ed.EjerciciosJUnit.ejercicio6;

public class Ingrediente {
	
	private String nombre;
	private TipoIngrediente tipo;
	private float gramosEnAlmacen;
	private float gramosPizza; // Son los gramos que se gasta en cada Pizza
	private boolean aptoCeliacos;
	
	
	public Ingrediente(String nombre, float gramosPizza, boolean aptoCeliacos, TipoIngrediente tipo, float gramosAlmacen) {
		super();
		this.nombre = nombre;
		this.gramosPizza = gramosPizza;
		this.aptoCeliacos = aptoCeliacos;
		this.gramosEnAlmacen = gramosAlmacen;
		this.tipo = tipo;
	}
	
		
	public String getNombre() {
		return nombre;
	}


	public TipoIngrediente getTipo() {
		return tipo;
	}
	

	public boolean esAptoCeliacos() {
		return aptoCeliacos;
	}


	public float getGramosEnAlmacen() {
		return gramosEnAlmacen;
	}


	public float getGramosPizza() {
		return gramosPizza;
	}
	
	
	/**
	 * Gastamos el producto para una pizza
	 * @return
	 */
	public boolean gastarProducto() {
		
		// En el caso en que no tengamos suficiente devolvemos un flase
		if (gramosPizza > gramosEnAlmacen)
			return false;
		
		this.gramosEnAlmacen = this.gramosEnAlmacen - this.gramosPizza;
		return true;
		
	}
	

}
