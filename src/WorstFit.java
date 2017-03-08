import java.util.List;

public class WorstFit extends Fit{

	public WorstFit(List<MaquinaFisica> maquinasFisicas) {
		super(maquinasFisicas);
	}

	@Override
	public void alocar(List<MaquinaVirtual> maquinasVirtuais) {
		boolean isAllocated = false;
		MaquinaFisica pm;
		MaquinaVirtual vm;
		for(int i = 0; i < maquinasVirtuais.size(); i++) {
			vm = maquinasVirtuais.get(i);
			int worstIndex = -1;
			for(int j = 0; j < maquinasFisicas.size(); j++) {
				pm = maquinasFisicas.get(j);
				if (pm.getMemCapacity() >= vm.getMemoryReq() &&
					vm.getCpuReq() < pm.getCpuCapacity()) {
					if (worstIndex == -1) {
						worstIndex = j;
					} else if (maquinasFisicas.get(worstIndex).getMemCapacity() < pm.getMemCapacity()) {
						worstIndex = j;
					}
				}
			}
			if (worstIndex != -1) {
				pm = maquinasFisicas.get(worstIndex);
				pm.allocateVirtualMachine(vm);
				isAllocated = true;
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
		return "Worst Fit";
	}
}
