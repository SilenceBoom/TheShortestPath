import java.util.ArrayList;

public class Line {
	private String name;//ÏßÂ·Ãû
	private ArrayList<Station> stations =new ArrayList<Station>();
	private int size;
	public Line() {
		
	}
	public void addStation(Station station) {
		stations.add(station);
		size++;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public Station getStation(int index) {
		return stations.get(index);
	}
	public ArrayList<Station> getLine(){
		return stations;
	}
	public int getSize() {
		return size;
	}

}
