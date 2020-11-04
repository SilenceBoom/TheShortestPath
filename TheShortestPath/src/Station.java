import java.util.ArrayList;
import java.util.List;

public class Station{
	private String name;//վ��
	private List<String> line = new ArrayList<String>();//���ڵ���·
	private List<Station> linkStation =new ArrayList<Station>();//ǰ��վ
	public Station(){
		
	}
	public Station(String name,List<String> line,List<Station> linkStation) {
		this.name=name;
		this.line=line;
		this.linkStation=linkStation;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void addLine(String name) {
		line.add(name);
	}
	public String getLineName(int index) {
		return line.get(index);
	}
	public List<String> getLine(){
		return line;
	}
	public void setLine(String name) {
		line.add(name);
	}
	public List<Station> getLinkStation() {
		return linkStation;
	}
	public void setLinkStation(List<Station> linkStation) {
		this.linkStation = linkStation;
	}
	public void addLinkStation(Station station) {
		linkStation.add(station);
	}
	
}
