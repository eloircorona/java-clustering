package clustering.db;

import java.io.*;
import java.util.ArrayList;

public class Database {
	public static final String SEPARATOR = ",";

	public static ArrayList<Integer> reading(String src, int i) {//la i es la columna de donde se saca la info
		
		ArrayList<Integer> result = new ArrayList<>(); 
		BufferedReader br = null;
		try {
			int inicio = 0;
			br = new BufferedReader(new FileReader(src));
			String line = br.readLine();

			while(line != null) {
				String[] fields = line.split(SEPARATOR);
				result.add(Integer.parseInt(fields[i]));
				line = br.readLine();
			}
		}catch(Exception e){
			System.out.println(e);
		}finally {
			if(br != null) {
				try {
					br.close();
				}catch(Exception e){}
			}
		}
		return result;
	}
}
