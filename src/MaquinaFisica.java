import java.util.ArrayList;
import java.util.List;

public class MaquinaFisica {
	
    public Float cpuCapacity;
    public Float memCapacity;
    public List<MaquinaVirtual> allocatedVMs;
    
    public MaquinaFisica(Float cpuCapacity , Float memCapacity) {
    	this.cpuCapacity = cpuCapacity;
    	this.memCapacity = memCapacity;
    	this.allocatedVMs = new ArrayList<MaquinaVirtual>();
    }

	public Float getCpuCapacity() {
		return cpuCapacity;
	}

	public void setCpuCapacity(Float cpuCapacity) {
		this.cpuCapacity = cpuCapacity;
	}

	public Float getMemCapacity() {
		return memCapacity;
	}

	public void setMemCapacity(Float memCapacity) {
		this.memCapacity = memCapacity;
	}

	public List<MaquinaVirtual> getAllocatedVMs() {
		return allocatedVMs;
	}

	public void setAllocatedVMs(List<MaquinaVirtual> allocatedVMs) {
		this.allocatedVMs = allocatedVMs;
	}
	
	public void allocateVirtualMachine(MaquinaVirtual virtualMachine) {
		allocatedVMs.add(virtualMachine);
		
		this.memCapacity -= virtualMachine.getMemoryReq();
		this.cpuCapacity -= virtualMachine.getCpuReq();
	}

}
