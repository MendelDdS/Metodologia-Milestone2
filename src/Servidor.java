import java.util.ArrayList;
import java.util.List;

public class Servidor {
	
	public List<MaquinaFisica> availablePMs;
	
	public Servidor(int numberOfPMs, Float PMCpuCapacity, Float PMMemCapacity) {
		this.availablePMs = new ArrayList<MaquinaFisica>();
		for(int i=0; i < numberOfPMs; i++) {
			this.availablePMs.add(new MaquinaFisica(PMCpuCapacity, PMMemCapacity));
		}
	};
	
	public List<MaquinaFisica> getAvailablePMs() {
		return availablePMs;
	}

}
