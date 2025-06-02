package org.cuatrovientos.dam.ed.EjerciciosJUnit.ejercicio6;

import java.util.ArrayList;
import java.util.List;

public class Almacen {

	private List<Ingrediente> ingredientesEnAlmacen = new ArrayList<>();

	/**
	 * Añade un ingrediente al almacen. No hay control de ingredientes repetidos,
	 * sirve para ingredientes nuevos
	 * 
	 * @param miIngrediente
	 */
	public void anadirIngredienteNuevo(Ingrediente miIngrediente) {
		ingredientesEnAlmacen.add(miIngrediente);
	}

	/**
	 * Calcula el numero de pizzas margarita que puedo realizar Cumpliendo las
	 * siguientes reglas:
	 * 
	 * Tiene una base cualquiera Tiene salsa de nombre "Tomate" Tiene "Queso" como
	 * topping
	 * 
	 * @param paraCeliacos Si ponemos un true significa que queremos ver si todos
	 *                     los ingredientes son aptos para celiacos
	 * @return El numero de Pizzas. 0 indica que no hay pizzas disponibles
	 */
	public int cantidadPizzasMargarita(boolean paraCeliacos) {

		// En el caso en que ni hay ingredientes esta claro que no puedo hacer pizzas
		if (ingredientesEnAlmacen.isEmpty()) {
			return 0;
		}

		// Realizamos contadores para los ingredientes necesarios
		int cantidadMasas = 0;
		int cantidadTomate = 0;
		int cantidadQueso = 0;

		for (Ingrediente ingrediente : ingredientesEnAlmacen) {

			// Una persona que no es celiaco puede tomar cualquier ingrediente
			boolean aptoCeliaquia = !paraCeliacos || ingrediente.esAptoCeliacos();

			// Miro las masas
			if (ingrediente.getTipo() == TipoIngrediente.MASA && aptoCeliaquia) {
				int numeroPizzasPosibles = (int) Math
						.floor(ingrediente.getGramosEnAlmacen() / ingrediente.getGramosPizza());
				cantidadMasas = cantidadMasas + numeroPizzasPosibles;
			}

			// Miro la salsa
			if (ingrediente.getTipo() == TipoIngrediente.SALSA && ingrediente.getNombre().equals("Tomate")
					&& aptoCeliaquia) {
				int numeroPizzasPosibles = (int) Math
						.floor(ingrediente.getGramosEnAlmacen() / ingrediente.getGramosPizza());
				cantidadTomate = cantidadTomate + numeroPizzasPosibles;
			}

			// Miro el queso
			if (ingrediente.getTipo() == TipoIngrediente.TOPPING && ingrediente.getNombre().equals("Queso")
					&& aptoCeliaquia) {
				int numeroPizzasPosibles = (int) Math
						.floor(ingrediente.getGramosEnAlmacen() / ingrediente.getGramosPizza());
				cantidadQueso = cantidadQueso + numeroPizzasPosibles;
			}
		}

		// Ahora quiero recoger el minimo de las 3 cantidades, pero no se utilizar
		// Math.min!!!, y me lo he hecho por mi cuenta
		// TODO a lo mejor puedo explorar API para recoger el min o pasarlo a un metodo
		// privado
		if (cantidadMasas < cantidadTomate) {
			if (cantidadMasas < cantidadQueso) {
				return cantidadMasas;
			} else {
				return cantidadQueso;
			}
		} else if (cantidadTomate < cantidadQueso) {
			return cantidadTomate;
		} else {
			return cantidadQueso;
		}

	}

	/**
	 * En este caso vamos a ver si tenemos pizza carbonara
	 * 
	 * La pizza Carbonara, tiene una base "Fina" Tiene 1 salsa de "Nata" Tiene como
	 * Topping, "Bacon", "Queso", "Champis"
	 * 
	 * OJO que esta pizza no la pueden tomar celiacos!!!, O sea me da igual que los
	 * ingredientes no sean aptos para celiacos
	 * 
	 * @param cantidad La cantidad de pizzas que queremos
	 * @return Devulve si es posible o no.
	 */
	public boolean tenemosPizzaCarbonara(int cantidad) throws IllegalArgumentException {
		if (cantidad <= 0) {
			throw new IllegalArgumentException("La cantidad tiene que ser > 0");
		}

		boolean hayMasaFina = false;
		boolean hayNata = false;
		boolean hayQueso = false;
		boolean hayBacon = false;
		boolean hayChampis = false;

		for (Ingrediente ingrediente : this.ingredientesEnAlmacen) {

			if (ingrediente.getNombre().equalsIgnoreCase("Fina") && ingrediente.getTipo() == TipoIngrediente.MASA) {
				if (ingrediente.getGramosEnAlmacen() / ingrediente.getGramosPizza() >= cantidad) {
					hayMasaFina = true;
				}
				continue;
			}

			if (ingrediente.getNombre().equalsIgnoreCase("Nata") && ingrediente.getTipo() == TipoIngrediente.SALSA) {
				if (ingrediente.getGramosEnAlmacen() / ingrediente.getGramosPizza() >= cantidad) {
					hayNata = true;
				}
				continue;
			}

			if (ingrediente.getNombre().equalsIgnoreCase("Queso") && ingrediente.getTipo() == TipoIngrediente.TOPPING) {
				if (ingrediente.getGramosEnAlmacen() / ingrediente.getGramosPizza() >= cantidad) {
					hayQueso = true;
				}
				continue;
			}

			if (ingrediente.getNombre().equalsIgnoreCase("Bacon") && ingrediente.getTipo() == TipoIngrediente.TOPPING) {
				if (ingrediente.getGramosEnAlmacen() / ingrediente.getGramosPizza() >= cantidad) {
					hayBacon = true;
				}
				continue;
			}

			if (ingrediente.getNombre().equalsIgnoreCase("Champis")
					&& ingrediente.getTipo() == TipoIngrediente.TOPPING) {
				if (ingrediente.getGramosEnAlmacen() / ingrediente.getGramosPizza() >= cantidad) {
					hayChampis = true;
				}
				continue;
			}
		}

		return hayMasaFina && hayNata && hayQueso && hayBacon && hayChampis;
	}

}
