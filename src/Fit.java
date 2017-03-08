import java.util.List;

public abstract class Fit {
	
	public int getQuantVMsAlocadas;
	public int getQuantVMsRejeitadas;
	public List<MaquinaFisica> maquinasFisicas;
	
	public Fit(List<MaquinaFisica> availablePMs) {
		this.maquinasFisicas = availablePMs;
	}
	
	public int getQuantVMsAlocadas() {
		return getQuantVMsAlocadas;
	}
	
	public int getQuantVMsRejeitadas() {
		return getQuantVMsRejeitadas;
	}
	
	abstract void alocar(List<MaquinaVirtual> maquinasVirtuais);
	public abstract String toString();
}
