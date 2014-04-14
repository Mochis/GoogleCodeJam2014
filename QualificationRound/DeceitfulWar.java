import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
/**
 * Google Code Jam 2014
 * Qualification Round: 
 * 	D. Deceitful War
 * 
 * @author: Juan J.
 * 	13/04/2014
 */

public class DeceitfulWar {
	
	private static boolean bigger(double max, double[] v){
		boolean ok = false;
		int i = 0;
		
		while(!ok && i < v.length){
			if((v[i] != -1) && Double.compare(max, v[i]) < 0){
				ok = true;
				v[i] = -1;
			}
			
			i++;
		}
		
		return ok;
	}
	
	private static boolean biggerBack(double max, double[] v){
		boolean ok = false;
		int i = 0;
		
		while(!ok && i < v.length){
			if((v[i] != -1) && Double.compare(max, v[i]) < 0){
				ok = true;
			}
			
			i++;
		}
		
		return ok;
	}
	
	private static double min(double[] v){
		int i = 0;
		boolean ok = false;
		double choosenKen = 0.0;
		
		while(!ok && i < v.length){
			if(v[i] != -1){
				choosenKen = v[i];
				v[i] = -1;
				ok = true;
			}
			
			i++;
		}
		
		return choosenKen;
	}
	
	private static double minMax(double max, double[] v){
		double minMax = 0.0;
		boolean ok = false;
		int i = 0;
		
		while(!ok && i < v.length){
			if(Double.compare(max, v[i]) < 0){
				minMax = v[i];
				ok = true;
				v[i] = -1;
			}
			
			i++;
		}
		
		
		return minMax;
	}
	
	private static double max(double[] v){
		double max = 0.0;
		int pos = 0;
		
		for(int i = 0; i < v.length; i++){
			if((v[i] != -1) && Double.compare(max, v[i]) < 0){
				max = v[i];
				pos = i;
			}
		}
		v[pos] = -1;
		
		return max;
	}
	
	public static int deceitful(double[] naomi, double[] ken){
		int wins = 0;
		double choosenKen = max(ken);
		
		for(int i = 0; i < naomi.length; i++){
			if(bigger(choosenKen, naomi)){
				wins++;
			}
			
			choosenKen = max(ken);
		}
		
		return wins;
		
	}
	
	public static int war(double[] naomi, double[] ken){
		int wins = 0;
		double choosenKen = 0.0, choosenNaomi = 0.0;
		Arrays.sort(ken);
		
		for(int i = 0; i < naomi.length; i++){
			choosenNaomi = naomi[i];
			if(biggerBack(choosenNaomi, ken)){
				choosenKen = minMax(choosenNaomi, ken);
			}else{
				choosenKen = min(ken);
			}
			
			if(Double.compare(choosenNaomi, choosenKen) > 0){
				wins++;
			}
		}
		
		return wins;
	}
	
	public static void main(String[] args) throws IOException{
		FileReader fr = new FileReader("D-large.in");
		PrintWriter pw = new PrintWriter("out.txt");
		BufferedReader bf = new BufferedReader(fr);
		int testCases = Integer.parseInt(bf.readLine());
		
		for(int i = 0; i < testCases; i++){
			int numWeights = Integer.parseInt(bf.readLine());
			String naomi = bf.readLine();
			String ken = bf.readLine();
			double[] n = new double[numWeights];
			double[] k = new double[numWeights];
			double[] n2 = new double[numWeights];
			double[] k2 = new double[numWeights];
			Scanner sc1 = new Scanner(naomi);
			sc1.useLocale(Locale.ENGLISH);
			Scanner sc2 = new Scanner(ken);
			sc2.useLocale(Locale.ENGLISH);
			
			for(int j = 0; j < numWeights; j++){
				n[j] = sc1.nextDouble();
				k[j] = sc2.nextDouble();
				n2[j] = n[j];
				k2[j] = k[j];
			}
			
			sc1.close();
			sc2.close();
			
			pw.format("Case #%d: %d %d%n", i+1, deceitful(n, k), war(n2, k2));
		}
		
		bf.close();
		pw.close();
	}
}
