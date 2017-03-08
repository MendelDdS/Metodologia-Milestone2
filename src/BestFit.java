import java.util.List;

public class BestFit extends Fit {

	public BestFit(List<MaquinaFisica> maquinasFisicas) {
		super(maquinasFisicas);
	}

	@Override
	public void alocar(List<MaquinaVirtual> virtualMachines) {
		boolean isAllocated = false;
		MaquinaFisica pm;
		MaquinaVirtual vm;
		for(int i = 0; i < virtualMachines.size(); i++) {
			vm = virtualMachines.get(i);
			int bestIndex = -1;
			for(int j = 0; j < maquinasFisicas.size(); j++) {
				pm = maquinasFisicas.get(j);
				if (pm.getMemCapacity() >= vm.getMemoryReq() &&
						vm.getCpuReq() < pm.getCpuCapacity()) {
						if (bestIndex == -1) {
							bestIndex = j;
						} else if (maquinasFisicas.get(bestIndex).getMemCapacity() > pm.getMemCapacity()) {
							bestIndex = j;
						}
					}
				}
				if (bestIndex != -1) {
					pm = maquinasFisicas.get(bestIndex);
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
		return "Best Fit";
	}
}
