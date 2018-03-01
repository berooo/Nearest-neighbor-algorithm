package entity;

import java.util.ArrayList;
import java.util.List;

public class category {
	
	private String name;
	private List<point> ls;
	private point center;

	
	public category() {
		// TODO Auto-generated constructor stub
		ls=new ArrayList<point>();
	}

	public void setName(String name) {
		this.name=name;
	}
	
	public String getName() {
		return name;
	}
	
	public void add(point p) {
		ls.add(p);
	}
	
	public void setCenter(point center) {
		this.center=center;
	}
	
	public point getCenter() {
		return center;
	}
	public List<point> getList(){
		return ls;
	}
	
	public boolean checkExist(point a) {
		if(ls.contains(a)) {
			return true;
		}
		return false;
	}
	
}
