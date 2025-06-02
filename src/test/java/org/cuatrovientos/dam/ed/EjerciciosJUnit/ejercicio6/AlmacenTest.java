package org.cuatrovientos.dam.ed.EjerciciosJUnit.ejercicio6;

import static org.junit.jupiter.api.Assertions.*;

import org.cuatrovientos.dam.ed.EjerciciosJUnit.ejercicio6.Almacen;
import org.cuatrovientos.dam.ed.EjerciciosJUnit.ejercicio6.Ingrediente;
import org.cuatrovientos.dam.ed.EjerciciosJUnit.ejercicio6.TipoIngrediente;
import org.junit.jupiter.api.Test;

class AlmacenTest {

	/**
	 * Test para el caso más favorable, todos los ingredientes están disponibles y
	 * son aptos para celíacos.
	 */
	@Test
	void testCantidadPizzasMargaritaOK() {
		Almacen almacen = new Almacen();
		Ingrediente masa = new Ingrediente("Fina", 100, true, TipoIngrediente.MASA, 20); // 5
		almacen.anadirIngredienteNuevo(masa);
		Ingrediente tomate = new Ingrediente("Tomate", 100, true, TipoIngrediente.SALSA, 25); // 4
		almacen.anadirIngredienteNuevo(tomate);
		Ingrediente queso = new Ingrediente("Queso", 100, true, TipoIngrediente.TOPPING, 10); // 10
		almacen.anadirIngredienteNuevo(queso);

		// Invoco el método cantidadPizzasMargarita
		int actual = almacen.cantidadPizzasMargarita(true);

		// El número de pizzas debe ser 4 (limitado por el tomate)
		assertEquals(4, actual);
	}

	/**
	 * Test para el caso en el que todos los ingredientes existen pero ninguno es
	 * apto para celíacos.
	 */
	@Test
	void testIngredientesNoAptosParaCeliacos() {
		Almacen almacen = new Almacen();
		Ingrediente masa = new Ingrediente("Fina", 100, false, TipoIngrediente.MASA, 20);
		almacen.anadirIngredienteNuevo(masa);
		Ingrediente tomate = new Ingrediente("Tomate", 100, false, TipoIngrediente.SALSA, 25);
		almacen.anadirIngredienteNuevo(tomate);
		Ingrediente queso = new Ingrediente("Queso", 100, false, TipoIngrediente.TOPPING, 10);
		almacen.anadirIngredienteNuevo(queso);

		// Invoco el método para celíacos
		int actual = almacen.cantidadPizzasMargarita(true);

		// No se puede hacer ninguna pizza
		assertEquals(0, actual);
	}

	/**
	 * Test para el caso en el que los ingredientes no son aptos, pero se permiten
	 * porque no es para celíacos.
	 */
	@Test
	void testIngredientesNoAptosPeroParaCeliacosFalse() {
		Almacen almacen = new Almacen();
		Ingrediente masa = new Ingrediente("Fina", 100, false, TipoIngrediente.MASA, 20);
		almacen.anadirIngredienteNuevo(masa);
		Ingrediente tomate = new Ingrediente("Tomate", 100, false, TipoIngrediente.SALSA, 25);
		almacen.anadirIngredienteNuevo(tomate);
		Ingrediente queso = new Ingrediente("Queso", 100, false, TipoIngrediente.TOPPING, 10);
		almacen.anadirIngredienteNuevo(queso);

		// Invoco el método sin requerir que sean aptos para celíacos
		int actual = almacen.cantidadPizzasMargarita(false);

		// Debería poder hacerse 4 pizzas
		assertEquals(4, actual);
	}

	/**
	 * Test para el caso en el que el almacén está vacío.
	 */
	@Test
	void testSinIngredientes() {
		Almacen almacen = new Almacen();

		// Invoco el método sin ingredientes en el almacén
		int actual = almacen.cantidadPizzasMargarita(false);

		// No se puede hacer ninguna pizza
		assertEquals(0, actual);
	}

	/**
	 * Test para el caso en el que falta el queso.
	 */
	@Test
	void testFaltaQueso() {
		Almacen almacen = new Almacen();
		Ingrediente masa = new Ingrediente("Fina", 100, true, TipoIngrediente.MASA, 20);
		almacen.anadirIngredienteNuevo(masa);
		Ingrediente tomate = new Ingrediente("Tomate", 100, true, TipoIngrediente.SALSA, 25);
		almacen.anadirIngredienteNuevo(tomate);

		// Invoco el método sin queso
		int actual = almacen.cantidadPizzasMargarita(true);

		// No se puede hacer ninguna pizza
		assertEquals(0, actual);
	}

	/**
	 * Test para el caso en el que falta el tomate.
	 */
	@Test
	void testFaltaTomate() {
		Almacen almacen = new Almacen();
		Ingrediente masa = new Ingrediente("Fina", 100, true, TipoIngrediente.MASA, 20);
		almacen.anadirIngredienteNuevo(masa);
		Ingrediente queso = new Ingrediente("Queso", 100, true, TipoIngrediente.TOPPING, 10);
		almacen.anadirIngredienteNuevo(queso);

		// Invoco el método sin tomate
		int actual = almacen.cantidadPizzasMargarita(true);

		// No se puede hacer ninguna pizza
		assertEquals(0, actual);
	}

	/**
	 * Test para el caso en el que falta la masa.
	 */
	@Test
	void testFaltaMasa() {
		Almacen almacen = new Almacen();
		Ingrediente tomate = new Ingrediente("Tomate", 100, true, TipoIngrediente.SALSA, 25);
		almacen.anadirIngredienteNuevo(tomate);
		Ingrediente queso = new Ingrediente("Queso", 100, true, TipoIngrediente.TOPPING, 10);
		almacen.anadirIngredienteNuevo(queso);

		// Invoco el método sin masa
		int actual = almacen.cantidadPizzasMargarita(true);

		// No se puede hacer ninguna pizza
		assertEquals(0, actual);
	}

	/**
	 * Test para confirmar que el nombre de la masa no importa.
	 */
	@Test
	void testNombreMasaIrrelevante() {
		Almacen almacen = new Almacen();
		Ingrediente masa = new Ingrediente("Normal", 100, true, TipoIngrediente.MASA, 20);
		almacen.anadirIngredienteNuevo(masa);
		Ingrediente tomate = new Ingrediente("Tomate", 100, true, TipoIngrediente.SALSA, 25);
		almacen.anadirIngredienteNuevo(tomate);
		Ingrediente queso = new Ingrediente("Queso", 100, true, TipoIngrediente.TOPPING, 10);
		almacen.anadirIngredienteNuevo(queso);

		// Invoco el método con masa de nombre distinto
		int actual = almacen.cantidadPizzasMargarita(true);

		// El nombre de la masa no importa, debe devolver 4
		assertEquals(4, actual);
	}

	/**
	 * Test para el caso en el que la salsa no es "Tomate".
	 */
	@Test
	void testNombreSalsaIncorrecto() {
		Almacen almacen = new Almacen();
		Ingrediente masa = new Ingrediente("Fina", 100, true, TipoIngrediente.MASA, 20);
		almacen.anadirIngredienteNuevo(masa);
		Ingrediente salsa = new Ingrediente("Nata", 100, true, TipoIngrediente.SALSA, 25);
		almacen.anadirIngredienteNuevo(salsa);
		Ingrediente queso = new Ingrediente("Queso", 100, true, TipoIngrediente.TOPPING, 10);
		almacen.anadirIngredienteNuevo(queso);

		// Invoco el método sin salsa de tomate
		int actual = almacen.cantidadPizzasMargarita(true);

		// No se puede hacer ninguna pizza
		assertEquals(0, actual);
	}

	/**
	 * Test para el caso en el que el topping no se llama "Queso".
	 */
	@Test
	void testNombreToppingIncorrecto() {
		Almacen almacen = new Almacen();
		Ingrediente masa = new Ingrediente("Fina", 100, true, TipoIngrediente.MASA, 20);
		almacen.anadirIngredienteNuevo(masa);
		Ingrediente tomate = new Ingrediente("Tomate", 100, true, TipoIngrediente.SALSA, 25);
		almacen.anadirIngredienteNuevo(tomate);
		Ingrediente topping = new Ingrediente("Mozzarella", 100, true, TipoIngrediente.TOPPING, 10);
		almacen.anadirIngredienteNuevo(topping);

		// Invoco el método sin topping llamado "Queso"
		int actual = almacen.cantidadPizzasMargarita(true);

		// No se puede hacer ninguna pizza
		assertEquals(0, actual);
	}

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
	 * Test para el caso en que tenemos Masas diferentes a la fina
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
	 * Test para el caso en que tenemos Salsa diferentes a la nata
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
		} catch (IllegalArgumentException ex) {
			actual = ex;
		}

		// Compruebo la exception que lanza
		assertNotNull(actual);
		assertEquals(actual.getMessage(), "La cantidad tiene que ser > 0");

	}

}
