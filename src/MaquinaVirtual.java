
public class MaquinaVirtual {
	public Float cpuReq;
	public Float memoryReq;

	public MaquinaVirtual(Float cpuReq, Float memoryReq){
		this.cpuReq = cpuReq;
		this.memoryReq = memoryReq;
	}
	
	public Float getCpuReq() {
		return cpuReq;
	}

	public void setCpuReq(Float cpuReq) {
		this.cpuReq = cpuReq;
	}

	public Float getMemoryReq() {
		return memoryReq;
	}

	public void setMemoryReq(Float memoryReq) {
		this.memoryReq = memoryReq;
	}
}
