package sumo;

import java.io.*;
import java.net.*;

public class TCPConnection {
	
	public void saveProtocol(String protocol, String fileName){ 
		// M�todo para gravar arquivo de sa�da
		try{
			String file = "C:\\Users\\felip.DESKTOP-V1CH0M3\\Downloads\\arquivos SUMO\\Saida Protocolo" + fileName;
			FileWriter fileWriter =
	                new FileWriter(file, true);

	            BufferedWriter bufferedWriter =
	                new BufferedWriter(fileWriter);
	            bufferedWriter.write(protocol);
                bufferedWriter.newLine();
                bufferedWriter.close();
			
			} catch (IOException ex) {
				System.out.println(
		                "Error writing to file '"
		                + fileName + "'");
		            ex.printStackTrace();
			}
	}
	
	public void connect(String protocol) {		
	    try {
	    	// Create new socket
	    	Socket skt = new Socket("localhost", 1234);
	         
	        PrintWriter out = new PrintWriter(skt.getOutputStream(), true);

	        // Saves file
	        //saveProtocol(protocol, "protocolMaps.txt");
	        
	        // Sends the protocol to Middleware
	        out.print(protocol);
	        
	        // Close communication
	        out.close();
	        skt.close();
	        
	    }catch(Exception e) {
	    	System.out.print("Sumo desconectado!\n");
	    }
	}
}
