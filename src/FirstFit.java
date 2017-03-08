import java.util.List;

public class FirstFit extends Fit {

	public FirstFit(List<MaquinaFisica> maquinasFisicas) {
		super(maquinasFisicas);
	}

	@Override
	public void alocar(List<MaquinaVirtual> maquinasVirtuais) {
		boolean isAllocated = false;
		
		for(int i = 0; i < maquinasVirtuais.size(); i++) {
			MaquinaVirtual vm = maquinasVirtuais.get(i);
			
			for(int j = 0; j < maquinasFisicas.size(); j++) {
				MaquinaFisica pm = maquinasFisicas.get(j);
				if(vm.getMemoryReq() < pm.getMemCapacity() &&
				   vm.getCpuReq() < pm.getCpuCapacity()) {
					pm.allocateVirtualMachine(vm);
					isAllocated = true;
					break;
				}
			}
			if(isAllocated){
				this.getQuantVMsAlocadas++;
				isAllocated = false;
			} else {
				this.getQuantVMsRejeitadas++;
			}
		}	
	}
	
	@Override
	public String toString() {
		return "First Fit";
	}
}
