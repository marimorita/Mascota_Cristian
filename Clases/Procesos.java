package Clases;

public class Procesos {
	
	public double CalcularPromedio(double Peso) {
		
		double total = 0;
		if (validar(Peso)== true){
			total= Peso * 0.025; 
		}
		
		return total;
	}
	
	public boolean validar(double Peso) {	
		if (Peso<=0) {
			return true;
		}
		return false;
	}
}
