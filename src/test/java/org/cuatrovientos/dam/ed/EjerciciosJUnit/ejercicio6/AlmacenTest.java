package org.cuatrovientos.dam.ed.EjerciciosJUnit.ejercicio6;

import static org.junit.jupiter.api.Assertions.*;

import org.cuatrovientos.dam.ed.EjerciciosJUnit.ejercicio6.Almacen;
import org.cuatrovientos.dam.ed.EjerciciosJUnit.ejercicio6.Ingrediente;
import org.cuatrovientos.dam.ed.EjerciciosJUnit.ejercicio6.TipoIngrediente;
import org.junit.jupiter.api.Test;

class AlmacenTest {

	
	/**
	 * Test para el caso más favorable
	 */
	@Test
	void testTenemosPizzaCarbonaraOK() {

		// Creo el almacen con los ingredientes necesarios
		Almacen almacen = new Almacen();
		Ingrediente masa = new Ingrediente("Fina", 2, true, TipoIngrediente.MASA, 20);
		almacen.anadirIngredienteNuevo(masa);
		Ingrediente salsaTomate = new Ingrediente("Nata", 2, true, TipoIngrediente.SALSA, 20);
		almacen.anadirIngredienteNuevo(salsaTomate);
		Ingrediente queso = new Ingrediente("Queso", 2, true, TipoIngrediente.TOPPING, 16);
		almacen.anadirIngredienteNuevo(queso);
		Ingrediente bacon = new Ingrediente("Bacon", 2, true, TipoIngrediente.TOPPING, 14);
		almacen.anadirIngredienteNuevo(bacon);
		Ingrediente champis = new Ingrediente("Champis", 2, true, TipoIngrediente.TOPPING, 16);
		almacen.anadirIngredienteNuevo(champis);
		
		// Invoco el metodo cantidadPizzasMargarita
		boolean actual = almacen.tenemosPizzaCarbonara(7);
		
		// Compruebo que tenemos las pizzas necesarias
		assertTrue(actual);
		
		
	}
	
	/**
	 * Test para el caso en que tenemos el almacen vacio
	 */
	@Test
	void testTenemosPizzaCarbonaraConAlmacenVacio() {

		// Creo el almacen con los ingredientes necesarios
		Almacen almacen = new Almacen();
		
		// Invoco el metodo cantidadPizzasMargarita
		boolean actual = almacen.tenemosPizzaCarbonara(7);
		
		// Compruebo que tenemos las pizzas necesarias
		assertFalse(actual);
		
		
	}
	
	
	/**
	 * Test para el caso en que no tenemos Ingredientes suficientes
	 */
	@Test
	void testTenemosPizzaCarbonaraSinIngredientesSuficientes() {

		// Creo el almacen con los ingredientes necesarios
		Almacen almacen = new Almacen();
		Ingrediente masa = new Ingrediente("Fina", 2, true, TipoIngrediente.MASA, 10);
		almacen.anadirIngredienteNuevo(masa);
		Ingrediente salsaTomate = new Ingrediente("Nata", 2, true, TipoIngrediente.SALSA, 10);
		almacen.anadirIngredienteNuevo(salsaTomate);
		Ingrediente queso = new Ingrediente("Queso", 2, true, TipoIngrediente.TOPPING, 10);
		almacen.anadirIngredienteNuevo(queso);
		Ingrediente bacon = new Ingrediente("Bacon", 2, true, TipoIngrediente.TOPPING, 10);
		almacen.anadirIngredienteNuevo(bacon);
		Ingrediente champis = new Ingrediente("Champis", 2, true, TipoIngrediente.TOPPING, 10);
		almacen.anadirIngredienteNuevo(champis);
		
		// Invoco el metodo cantidadPizzasMargarita
		boolean actual = almacen.tenemosPizzaCarbonara(7);
		
		// Compruebo que tenemos las pizzas necesarias
		assertFalse(actual);
		
		
	}
	
	/**
	 * Test para el caso en que  tenemos Masas diferentes a la fina
	 */
	@Test
	void testTenemosPizzaCarbonaraSinMasas() {

		// Creo el almacen con los ingredientes necesarios
		Almacen almacen = new Almacen();
		Ingrediente masa = new Ingrediente("Normal", 2, true, TipoIngrediente.MASA, 10);
		almacen.anadirIngredienteNuevo(masa);
		Ingrediente salsaTomate = new Ingrediente("Nata", 2, true, TipoIngrediente.SALSA, 10);
		almacen.anadirIngredienteNuevo(salsaTomate);
		Ingrediente queso = new Ingrediente("Queso", 2, true, TipoIngrediente.TOPPING, 10);
		almacen.anadirIngredienteNuevo(queso);
		Ingrediente bacon = new Ingrediente("Bacon", 2, true, TipoIngrediente.TOPPING, 10);
		almacen.anadirIngredienteNuevo(bacon);
		Ingrediente champis = new Ingrediente("Champis", 2, true, TipoIngrediente.TOPPING, 10);
		almacen.anadirIngredienteNuevo(champis);
		
		// Invoco el metodo cantidadPizzasMargarita
		boolean actual = almacen.tenemosPizzaCarbonara(1);
		
		// Compruebo que tenemos las pizzas necesarias, o sea ninguna
		assertFalse(actual);
		
		
	}
	
	/**
	 * Test para el caso en que  tenemos Salsa diferentes a la nata
	 */
	@Test
	void testTenemosPizzaCarbonaraSinSalsa() {

		// Creo el almacen con los ingredientes necesarios
		Almacen almacen = new Almacen();
		Ingrediente masa = new Ingrediente("Fina", 2, true, TipoIngrediente.MASA, 10);
		almacen.anadirIngredienteNuevo(masa);
		Ingrediente salsaTomate = new Ingrediente("Tomate", 2, true, TipoIngrediente.SALSA, 10);
		almacen.anadirIngredienteNuevo(salsaTomate);
		Ingrediente queso = new Ingrediente("Queso", 2, true, TipoIngrediente.TOPPING, 10);
		almacen.anadirIngredienteNuevo(queso);
		Ingrediente bacon = new Ingrediente("Bacon", 2, true, TipoIngrediente.TOPPING, 10);
		almacen.anadirIngredienteNuevo(bacon);
		Ingrediente champis = new Ingrediente("Champis", 2, true, TipoIngrediente.TOPPING, 10);
		almacen.anadirIngredienteNuevo(champis);
		
		// Invoco el metodo cantidadPizzasMargarita
		boolean actual = almacen.tenemosPizzaCarbonara(1);
		
		// Compruebo que tenemos las pizzas necesarias, o sea ninguna
		assertFalse(actual);
		
		
	}
	
	@Test
	void testTenemosPizzaCarbonaraSinToppingsSinBacon() {

		// Creo el almacen con los ingredientes necesarios
		Almacen almacen = new Almacen();
		Ingrediente masa = new Ingrediente("Fina", 2, true, TipoIngrediente.MASA, 10);
		almacen.anadirIngredienteNuevo(masa);
		Ingrediente salsaTomate = new Ingrediente("Nata", 2, true, TipoIngrediente.SALSA, 10);
		almacen.anadirIngredienteNuevo(salsaTomate);
		Ingrediente queso = new Ingrediente("Queso", 2, true, TipoIngrediente.TOPPING, 10);
		almacen.anadirIngredienteNuevo(queso);
		Ingrediente champis = new Ingrediente("Champis", 2, true, TipoIngrediente.TOPPING, 10);
		almacen.anadirIngredienteNuevo(champis);
		
		// Invoco el metodo cantidadPizzasMargarita
		boolean actual = almacen.tenemosPizzaCarbonara(1);
		
		// Compruebo que tenemos las pizzas necesarias, o sea ninguna
		assertFalse(actual);
		
		
	}
	
	@Test
	void testTenemosPizzaCarbonaraSinQueso() {

		// Creo el almacen con los ingredientes necesarios
		Almacen almacen = new Almacen();
		Ingrediente masa = new Ingrediente("Fina", 2, true, TipoIngrediente.MASA, 10);
		almacen.anadirIngredienteNuevo(masa);
		Ingrediente salsaTomate = new Ingrediente("Nata", 2, true, TipoIngrediente.SALSA, 10);
		almacen.anadirIngredienteNuevo(salsaTomate);
		Ingrediente bacon = new Ingrediente("Bacon", 2, true, TipoIngrediente.TOPPING, 10);
		almacen.anadirIngredienteNuevo(bacon);
		Ingrediente champis = new Ingrediente("Champis", 2, true, TipoIngrediente.TOPPING, 10);
		almacen.anadirIngredienteNuevo(champis);
		
		// Invoco el metodo cantidadPizzasMargarita
		boolean actual = almacen.tenemosPizzaCarbonara(1);
		
		// Compruebo que tenemos las pizzas necesarias, o sea ninguna
		assertFalse(actual);
		
		
	}
	
	
	@Test
	void testTenemosPizzaCarbonaraSinChampis() {

		// Creo el almacen con los ingredientes necesarios
		Almacen almacen = new Almacen();
		Ingrediente masa = new Ingrediente("Fina", 2, true, TipoIngrediente.MASA, 10);
		almacen.anadirIngredienteNuevo(masa);
		Ingrediente salsaTomate = new Ingrediente("Nata", 2, true, TipoIngrediente.SALSA, 10);
		almacen.anadirIngredienteNuevo(salsaTomate);
		Ingrediente bacon = new Ingrediente("Bacon", 2, true, TipoIngrediente.TOPPING, 10);
		almacen.anadirIngredienteNuevo(bacon);
		Ingrediente champis = new Ingrediente("Queso", 2, true, TipoIngrediente.TOPPING, 10);
		almacen.anadirIngredienteNuevo(champis);
		
		// Invoco el metodo cantidadPizzasMargarita
		boolean actual = almacen.tenemosPizzaCarbonara(1);
		
		// Compruebo que tenemos las pizzas necesarias, o sea ninguna
		assertFalse(actual);
		
		
	}
	
	@Test
	void testTenemosPizzaCarbonaraException() {

		// Creo el almacen con los ingredientes necesarios, en este caso ninguno
		Almacen almacen = new Almacen();
		
		// Invoco el metodo cantidadPizzasMargarita
		IllegalArgumentException actual = null;
		try {
			almacen.tenemosPizzaCarbonara(0);
		}
		catch (IllegalArgumentException ex) {
			actual = ex;
		}
	
		// Compruebo la exception que lanza
		assertNotNull(actual);
		assertEquals(actual.getMessage(), "La cantidad tiene que ser > 0");
		
	}
	
	

}
