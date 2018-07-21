import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

public class Pie {
	 public static void main(String[] args)throws Exception
	  {
	  // We need to provide file path as the parameter:
	  // double backquote is to avoid compiler interpret words
	  // like \test as \t (ie. as a escape sequence)
	  File file = new File("C:\\Users\\Vaibhav Kalakota\\eclipse-workspace\\LeetCode\\src\\input_pie.txt");
	  BufferedReader br = new BufferedReader(new FileReader(file));
		  String countShopsString=br.readLine();
	  int countShops = Integer.parseInt(countShopsString);
	  for(int i=0;i<countShops;i++) {
		  String getN_M=br.readLine();
		  String array[]=getN_M.split(" ");
		  int days = Integer.parseInt(array[0]);
		  int pies = Integer.parseInt(array[1]);
		  int costs[][] =new int[days][pies];
		  for(int day=0;day<days;day++) {
			  String arrayCosts=br.readLine();
			  String arraysofCosts[]=arrayCosts.split(" ");
			  for(int pie=0;pie<pies;pie++) {
				  costs[day][pie]=Integer.parseInt(arraysofCosts[pie]);
			  }
			  Arrays.sort(costs[day]);
		  }
		  int countArray[]=new int[days];
		  long total=0;
		  int count=0;
		  for(int pie=0;pie<days;pie++) {
			  int getDay=0;
			  int min=costs[0][0]+1;
			  for(int day=0;day<days;day++) {
				  if(costs[day][pie+countArray[day]]+2*countArray[day]+1<min) {
					  min=costs[day][pie+countArray[day]]+2*countArray[day]+1;
					  getDay=day;
				  }
			  }
				  countArray[getDay]++;		  	
				  total+=min;		  	
		  }
		  System.out.println("Case #"+i+": "+total);
		  }	   	
	  }
}	 
