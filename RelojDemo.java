package Ejercicio003;

import java.util.Scanner;

public class RelojDemo {

	public static void main(String[] args) {
		/* 
		 * * instanciar un objeto Reloj, con el constructor de segundos (que 
		 * pida al usuario ingresar por el teclado)
		 * * utilizar las funcion tick 10 veces y mostrar la hora cada vez que
		 * se ejecuta
		 * * crear otro objeto reloj y restar la hora con el método
		 * restaReloj()
		 * */
		Scanner scan = new Scanner(System.in);
		Reloj reloj;
		int segundos;
		
		System.out.print("Ingrese los segundos: ");
		segundos = scan.nextInt(); // 7322 >> 2h 2m 2s
		
		reloj = new Reloj(segundos);
		
		System.out.println(reloj);
		
		for(int i = 0; i < 10; i ++) {
			reloj.addTick();
		}
		
		System.out.println("10 doritos despues >>> " + reloj);
		
		Reloj reloj2 = new Reloj(1, 1, 11);
		
		System.out.print(reloj + " - " + reloj2 + " = ");
		reloj.restaReloj(reloj2);
		System.out.print(reloj);
		
		System.out.print("\n" + reloj + " + " + reloj2 + " = ");
		reloj.addReloj(reloj2);
		System.out.print(reloj);

		Reloj reloj3=new Reloj();
		System.out.println("\n\nHora local: "+reloj3.horaLocal());

	}

}
