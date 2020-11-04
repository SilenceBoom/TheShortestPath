import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TheShortestPath {

	public static void main(String[] args) throws IOException{
		String path="地铁线路信息.txt";
		File f =new File(path);
		Scanner input=new Scanner(System.in);
		
	    ArrayList<Line> map = new ArrayList();//所有线路及站
	    ArrayList<Station> all=new ArrayList();//所有站，不重复
	    try {
	    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f),"UTF-8"));
	    String str=null;
	    while((str=br.readLine())!=null) {
	    	String[] st=str.split(" ");
	    	Line line=new Line();
	    	line.setName(st[0]);
	    	for(int i=1;i<st.length;i++) {
	    		Station station=new Station();
	    		station.addLine(st[0]);
	    		station.setName(st[i]);
	    		line.addStation(station);
	    	}
	    	map.add(line);
	    }
	    for(int i=0;i<map.size();i++) {
	    	for(Station j:map.get(i).getLine()) {
	    		int n=0;
	    		for(n=0;n<all.size();n++) {
	    			if((all.get(n).getName()).compareTo(j.getName())==0) {
	    				all.get(n).addLine(j.getLineName(0));
	    				break;
	    			}
	    		}
	    		if(n>=all.size()) {
	    			all.add(j);
	    		}
	    	}
	    }
//	    for(int i=0;i<all.size();i++) {
//	    	System.out.println(all.get(i).getName());
//	    	for(String n:all.get(i).getLine()) {
//	    		System.out.print(n+" ");
//	    	}
//	    	System.out.println();
//	    }
	    br.close();
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	    System.out.print("请输入起始站：");
	    String start=input.next();
	    System.out.print("请输入终点站：");
	    String end=input.next();
	    Shortest(start,end,all,map);
		     
	}
	public static void Shortest(String start,String end,ArrayList<Station> all,ArrayList<Line> map) {
		Station startStation =new Station();
		Station endStation =new Station();
		boolean isSame=false;
		String lineName=" ";
		int line=-1;
		//获取两个站的信息
		for(int i=0;i<all.size();i++) {
			if((all.get(i).getName()).compareTo(start)==0) {
				startStation=all.get(i);
			}
			else if((all.get(i).getName()).compareTo(end)==0) {
				endStation=all.get(i);
			}
		}
		//判断是否从属一条线
		for(String i:startStation.getLine()) {
			if(endStation.getLine().contains(i)) {
				isSame=true;
				lineName=i;
			}
		}
		if(isSame) {
			for(int i=0;i<map.size();i++) {
				if(map.get(i).getName().compareTo(lineName)==0) {
					line=i;
				}
			}
		
			int isOut=-1;
		for(Station i:map.get(line).getLine()) {
			if(i.getName().compareTo(start)==0||i.getName().compareTo(end)==0)
			{
				System.out.print(i.getName()+" ");
				isOut=-isOut;
			}
				
			else if(isOut==1) {

				System.out.print(i.getName()+" ");
			}
		}
		}
	else {
			List<String> sameline=new ArrayList();
			
		}
		
	    	
	    	
	    
		
	}

}
