package operation;

import java.util.List;

import entity.point;

public class Main {
	
	public static void main(String[] args){
		
		String fileName=args[0];
		List<point> ls=readData.getData(fileName);
		int T=Integer.parseInt(args[1]);
		clustering c=new clustering(ls);
		c.cluster(T);
		c.printResult();	
	}
	
}
