import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Google Code Jam 2014
 * Qualification Round: 
 * 	A. Magic Trick
 * 
 * @autor: Juan J. 
 *  12/04/2014
 */

public class MagicTrick {
	
	public static void solve(int testCase, String r1, String r2){
		int success = 0, res = 0, times = 0, pos = 0;
		boolean solution = true, bad = false;
		Scanner sc1 = new Scanner(r1);
		Scanner sc2 = new Scanner(r2);
		int[] row1 = new int[4];
		int[] row2 = new int[4];
		
		for(int i = 1; i <= 4; i++){
			row1[i-1] = sc1.nextInt();
			row2[i-1] = sc2.nextInt();
		}
		
		sc1.close();
		sc2.close();
		
		while(solution && times < 4){
			while(pos < 4 && success <= 1){
				if(row1[times] == row2[pos]){
					success++;
					res = row1[times];
				}
				pos++;
			}
			
			pos = 0;
			times++;
			
			if(success > 1){
				solution = false;
			}else if(times == 4 && success == 0){
				solution = false;
			}
		}
		
		if(!solution){
			if(success > 1){
				bad = true;
			}
		}
		
		
		
		System.out.println("Case #"+testCase+": "+(solution ? res : (bad ? "Bad magician!" : "Volunteer cheated!")));
	}
	
	public static void main(String[] args) throws IOException{
		FileReader fr = new FileReader("A-small-attempt1.in");
		BufferedReader bf = new BufferedReader(fr);
		String row1 = "", row2 = "";
		String cases = bf.readLine();
		
		for(int i = 0; i < Integer.parseInt(cases); i++){
			
			int r1 = Integer.parseInt(bf.readLine());
			for(int j = 1; j <= 4; j++){
				
				if(j == r1){
					row1 = bf.readLine();
				}else{
					bf.readLine();
				}
			}
			
			int r2 = Integer.parseInt(bf.readLine());
			for(int j = 1; j <= 4; j++){
				
				if(j == r2){
					row2 = bf.readLine();
				}else{
					bf.readLine();
				}
				
			}
		
			solve(i+1, row1, row2);
		}
		
		bf.close();
	}
}
