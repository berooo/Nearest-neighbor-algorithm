package operation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import entity.category;
import entity.point;

public class clustering {
	
	private List<point> ls;
	private List<category> c;
	
	public clustering(List<point> ls) {
		this.ls=ls;
	    c=new ArrayList<category>();
	}
	
	public void initial() {
		
		Random r=new Random();
		int number=Math.abs(r.nextInt()%ls.size());
		point p=ls.get(number);
		category z1=new category();
		z1.setName("Z1");
		z1.add(p);
		z1.setCenter(p);
		c.add(z1);

	}
	
	public float Euclidean(point a,point b) {
		
		int[] aValue=a.getValue();
		int[] bValue=b.getValue();
		
		float sum=0;
		for(int i=0;i<aValue.length;i++) {
			sum+=Math.pow((aValue[i]-bValue[i]), 2);
		}
		
		return (float) Math.sqrt(sum);
		
	}
	
	public void cluster(int T) {
		
		initial();
		for(int i=0;i<ls.size();i++) {
			point a=ls.get(i);
			int ind=calMin(c,a,T);
			if(ind!=-1){
				if(!c.get(ind).checkExist(a))
					c.get(ind).add(a);
			}else {
				category z=new category();
				z.add(a);
				z.setCenter(a);
				int d=c.size()+1;
				String name="Z"+d;
				z.setName(name);
				c.add(z);
			}
		}
	}
	

	
	public int calMin(List<category> ls,point a,int T) {
  
		int index=0;
		float min=Float.MAX_VALUE;
	
		for(int i=0;i<ls.size();i++) {
			point p=ls.get(i).getCenter();
			float distance=Euclidean(p,a);
			if(distance<=min){
				min=distance;
				index=i;
			}
		}
		if(min<=T){
			return index;
		}else{
		return -1;
		}
	}	

	public void printResult() {
		for(int i=0;i<c.size();i++) {
			System.out.println(c.get(i).getName());
			List<point> l=c.get(i).getList();
			for(int j=0;j<l.size();j++) {
				point p=l.get(j);
				System.out.println(Arrays.toString(p.getValue()));
			}

		}
	}

}
