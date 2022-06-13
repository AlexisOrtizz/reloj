package Ejercicio003;

public class Reloj {
	private int hora, minuto, segundo;

	
	// constructores
	public Reloj(int hora, int min, int seg) {
		this.hora = hora;
		this.minuto = min;
		this.segundo = seg;
	}
	
	public Reloj() {
		this(12, 0, 0);
	}
	
	public Reloj(int seg) {
		final int HORA_EN_SEGUNDOS = 3600;
		
		/* cantidad de horas */
		this.hora = seg / HORA_EN_SEGUNDOS;
		
		/* cantidad de minutos */
		seg -= (this.hora * HORA_EN_SEGUNDOS);
		this.minuto = seg / 60;
		
		/* cantidad de segundos */
		seg -= (this.minuto * 60);
		this.segundo = seg;
	}
	
	
	// getters
	public int getHoras() {
		return this.hora;
	}
	
	public int getMinutos() {
		return this.minuto;
	}
	
	public int getSegundos() {
		return this.segundo;
	}
	
	
	// setters
	public void setHoras(int hora) {
		if(hora < 0 || hora > 23) {
			System.out.println("Error. El valor ingresado es invalido.");
			return;
		}
		this.hora = hora;
	}
	
	public void setMinutos(int min) {
		if(min < 0 || min > 59) {
			System.out.println("Error. El valor ingresado es invalido.");
			return;
		}
		this.minuto = min;
	}
	
	public void setSegundos(int segundo) {
		if(segundo < 0 || segundo > 59) {
			System.out.println("Error. El valor ingresado es invalido.");
			return;
		}
		this.segundo = segundo;
	}
	
	
	// metodos
	public void setReloj(int seg) {
		/* meotodo setReloj() con un parametro, que es el valor del
		 * tiempo en segundos desde la medianoche
		 * */
		final int HORA_EN_SEGUNDOS = 3600;
		int hora, minuto, segundo;
		
		/* cantidad de horas */
		hora = seg / HORA_EN_SEGUNDOS;
		
		/* cantidad de minutos */
		seg -= (hora * HORA_EN_SEGUNDOS);
		minuto = seg / 60;
		
		/* cantidad de segundos */
		seg -= (minuto * 60);
		segundo = seg;
		
		if( !esValido(hora, minuto, segundo) ) {
			System.out.println("Error. La fecha introducida es invalida.");
			return;
		}
		
		setHoras(hora);
		setMinutos(minuto);
		setSegundos(segundo);
	}
	
	
	public void addTick() {
		/* metodo tick(), este debe incrementar el tiempo de los
		 * segundos en 1
		 * */
		if(esValido(this.hora, this.minuto, this.segundo + 1)) {
			setSegundos(getSegundos() + 1);
			return;
		}
		
		segundo = 0;
	}
	
	public void tickDecrement() {
		/* metodo tickDecrement(), este debe decrementar el tiempo
		 * de los segundos en 1
		 * */
		if(esValido(this.hora, this.minuto, this.segundo - 1)) {
			setSegundos(getSegundos() - 1);
			return;
		}
		
		segundo = 59;
	}
	
	public void addReloj(Reloj t) {
		/* metodo addReloj() acepta un parametro del tipo Reloj. El
		 * metodo debe agregar la hora representada por el objeto en la clase
		 * actual.
		 * */
		final int DIA_SEGUNDOS = getReloj(23, 59, 59);
		final int dia1 = getReloj(this.hora, this.minuto, this.segundo);
		final int dia2 = getReloj(t.hora, t.minuto, t.segundo);
		int suma = dia1 + dia2;
		
		if(suma > DIA_SEGUNDOS) suma -= DIA_SEGUNDOS; // para que sea circular
		
		setReloj(suma);
	}
	
	
	public void restaReloj(Reloj t) {
		/* metodo restaReloj() que toma un parametro tipo Reloj y
		 * returna la diferencia de tiempo representada en el objeto de reloj
		 * actual y el representado en el parametro. 
		 * */
		int seg1, seg2, diferencia;
		
		if(this.esMayor(t)) {
			seg1 = getReloj(this.hora, this.minuto, this.segundo);
			seg2 = getReloj(t.hora, t.minuto, t.segundo);
		} else {
			seg2 = getReloj(this.hora, this.minuto, this.segundo);
			seg1 = getReloj(t.hora, t.minuto, t.segundo);
		}
		
		diferencia = seg1 - seg2;
		setReloj(diferencia);
	}
	
	
	private boolean esValido(int hora, int minuto, int segundo) {
		return ( (hora >= 0 && hora <= 23) && (minuto >= 0 && minuto <= 59) && 
				  (segundo >= 0 && segundo <= 59) );
	}
	
	private boolean esMayor(Reloj t) {
		if(this.getHoras() > t.getHoras()) {
			return true;
		} else if(this.getHoras() < t.getHoras()) {
			return false;
		}
		
		if(this.getMinutos() > t.getMinutos()) {
			return true;
		} else if(this.getMinutos() < t.getMinutos()) {
			return false;
		}
		
		if(this.getSegundos() > t.getSegundos()) {
			return true;
		} else {
			return false;
		}
	}
	
	
	private int getReloj(int hora, int min, int seg) {
		/* convierte la hora, min y seg del parametro en segundos.
		 * */
		final int HORA_EN_SEGUNDOS = 3600;
		int segundo;
		
		/* cantidad de horas */
		segundo = hora * HORA_EN_SEGUNDOS;
		
		/* cantidad de minutos */
		segundo += min * 60;
		
		/* cantidad de segundos */
		segundo += seg;
		
		return segundo;
	}
	
	
	@Override
	public String toString() {
		return String.format("[%02d", this.hora) + ":" + 
			   String.format("%02d", this.minuto) + ":" +
			   String.format("%02d]", this.segundo);
	}
}
