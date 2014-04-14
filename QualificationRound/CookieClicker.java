import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 * Google Code Jam 2014
 * Qualification Round: 
 * 	B. Coockie Cliker Alpha
 * 
 * @author: Juan J.
 * 	12/04/2014
 */

public class CookieClicker {
	private static final double INI_PRODUCTION = 2.0;
	
	public static void solve(int testCase, double c, double f, double x, PrintWriter pw){
		double sum = 0.0, totalCockies = 0.0;
		double p = INI_PRODUCTION;
		//DecimalFormat df = new DecimalFormat("0.0000000");
		//df.getNumberInstance(Locale.ENGLISH);
		NumberFormat nf = NumberFormat.getNumberInstance(Locale.ENGLISH);
		DecimalFormat df = (DecimalFormat)nf;
		df.applyPattern("0.0000000");
		if(Double.compare(c, x) > 0){
			sum = x / p;
		}else{
			while(Double.compare(totalCockies, x) != 0){
				double temp1 = x / p;
				double temp2 = (c / p) + (x / (p + f));
				
				if(Double.compare(temp1, temp2) < 0){
					sum += temp1;
					totalCockies = x;
				}else{
					sum += c / p;
					p += f;
				}
				
			}
			
		}
		
		pw.format(Locale.ENGLISH, "Case #%d: %s%n", testCase, df.format(sum));	
		
	}
	
	public static void main(String[] args) throws IOException{
		FileReader fr = new FileReader("B-large.in");
		PrintWriter pw = new PrintWriter("out.txt");
		BufferedReader bf = new BufferedReader(fr);
		
		try{
			int testCases = Integer.parseInt(bf.readLine());
			
			for(int i = 0; i < testCases; i++){
				String line = bf.readLine();
				Scanner sc = new Scanner(line);
				sc.useLocale(Locale.ENGLISH);
				solve(i + 1, sc.nextDouble(), sc.nextDouble(), sc.nextDouble(), pw);
				sc.close();
			}
			
			
			
		}catch(IOException e){
			e.printStackTrace();
			
		}
		
		bf.close();
		pw.close();
	
	}
}
