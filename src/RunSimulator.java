import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class RunSimulator {
	
	public static List<MaquinaVirtual> traces = new ArrayList<MaquinaVirtual>();
	final public static int QUANT_MAQ_FISICAS = 10;

	
	public static void main(String[] args) {
		float MEM_CAP_MF = Float.parseFloat(args[1]);
		float CPU_CAP_MF = Float.parseFloat(args[1]);
		float MV_RESOURCE_REQ = Float.parseFloat(args[2]);
		int quantRequisicoes = 0;

		Servidor servidor = new Servidor(QUANT_MAQ_FISICAS, CPU_CAP_MF, MEM_CAP_MF);
		
        Fit algoritmo;
		if(args[0].equals("first-fit")) {
			algoritmo = new FirstFit(servidor.getAvailablePMs());
		} else if (args[0].equals("worst-fit")) {
			algoritmo = new WorstFit(servidor.getAvailablePMs());
		} else {
			algoritmo = new BestFit(servidor.getAvailablePMs());
		}

		String task_02csv = "task_02.csv";
		String task_1csv = "task_1.csv";
		String task_4csv = "task_4.csv";
        String line = "";
        
        try  {
        	BufferedReader task;
        	if (MV_RESOURCE_REQ == 0.02) {
            	task = new BufferedReader(new FileReader(task_02csv));
        	} else if (MV_RESOURCE_REQ == 0.1) {
            	task = new BufferedReader(new FileReader(task_1csv));
        	} else {
        		task = new BufferedReader(new FileReader(task_4csv));	
        	}        	
       		while ((line = task.readLine()) != null) {
               	String[] params = line.split(";");
                Float cpuReq = Float.parseFloat(params[8]);
                Float memoryReq = Float.parseFloat(params[9]);
                MaquinaVirtual iniciarVM = new MaquinaVirtual(cpuReq, memoryReq);
                traces.add(iniciarVM);
                quantRequisicoes++;
        	}

        } catch (IOException e) {
            e.printStackTrace();
        }
        
		algoritmo.alocar(traces);
        logResult(MV_RESOURCE_REQ, servidor,algoritmo, MEM_CAP_MF, CPU_CAP_MF, args[0], quantRequisicoes);
	}
	
	public static void logResult(float MV_RESOURCE_REQ, Servidor server, Fit algoritmoExecutado, float capacidadeMemoria, float capacidadeCPU, String fileName, int quantRequisicoes) {
		
		Float fragmentacaoMemoria = 0.0f;
		Float cpuFragmentation = 0.0f;

        for (int i = 0; i < server.getAvailablePMs().size(); i++) {
        	cpuFragmentation += server.getAvailablePMs().get(i).getCpuCapacity();
        	fragmentacaoMemoria += server.getAvailablePMs().get(i).getMemCapacity();
		}
        
		try{
			String s = System.lineSeparator();
		    FileWriter writer = new FileWriter("../log_result.txt", true);
		    
		    writer.append("Recurso requisitado por VM: " + MV_RESOURCE_REQ);
		    writer.append(s);
		    writer.append("Quantidade de máquinas físicas: " + server.getAvailablePMs().size());
		    writer.append(s);
		    writer.append("Capacidade de CPU: " + capacidadeCPU + "\n");
		    writer.append(s);
		    writer.append("Capacidade de memória: " + capacidadeMemoria + "\n");
		    writer.append(s);
		    writer.append("Algoritmo executado: " + algoritmoExecutado.toString() + "\n");
		    writer.append(s);
		    writer.append("Fragmentação de CPU: " + fragmentacaoMemoria + "\n");
		    writer.append(s);		    
		    writer.append("Fragmentação de memória: " + fragmentacaoMemoria + "\n");
		    writer.append(s);
		    writer.append("Quantidade de requisições " + quantRequisicoes + "\n");
		    writer.append(s);
		    writer.append("Quantidade de VMs alocadas: " + algoritmoExecutado.getQuantVMsAlocadas() + "\n");
		    writer.append(s);
		    writer.append("Quantidade de VMs rejeitadas: " + algoritmoExecutado.getQuantVMsRejeitadas() + "\n");
		    writer.append(s);
		    writer.append("-----------------------------------------------------------------------------");
		    writer.append(s);

		    writer.close();
		} catch (IOException e) {
            e.printStackTrace();
		}
	}
}
