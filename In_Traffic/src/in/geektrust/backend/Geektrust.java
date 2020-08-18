package in.geektrust.backend;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

class Orbit
{
	double distance;
	double craters;
	double maxSpeed;
	Orbit(double distance,String Weather,double maxSpeed,double craters)
	{
		this.distance=distance;
		this.maxSpeed=maxSpeed;
		if(Weather.compareTo("SUNNY")==0)
			this.craters=craters*90/100;
		else if(Weather.compareTo("RAINY")==0)
			this.craters=craters*120/100;
		else
			this.craters=craters;
	}
	public double getDistance()
	{
		return distance;
	}
	public double getOrbMax()
	{
		return maxSpeed;
	}
	public double getcraterCount()
	{
		return craters;
	}
}

class Bike
{
	double maxSpeed =10;
	double craterTime=2;
	String[] weather= {"SUNNY","WINDY"};
	public boolean isEligibe(String Wthr)
	{
		for(String str:weather)
			if(str.compareTo(Wthr)==0)
				return true;
		return false;
	}
	public double travel(Orbit orb)
	{
		double speed=Double.min(maxSpeed,orb.getOrbMax());
		return (orb.getDistance()/speed)+(orb.getcraterCount()*craterTime)/60;
	}
}

class TukTuk
{
	double maxSpeed =12;
	double craterTime=1;
	String[] weather= {"SUNNY","RAINY"};
	public boolean isEligibe(String Wthr)
	{
		for(String str:weather)
			if(str.compareTo(Wthr)==0)
				return true;
		return false;
	}
	public double travel(Orbit orb)
	{
		double speed=Double.min(maxSpeed,orb.getOrbMax());
		return (orb.getDistance()/speed)*60+(orb.getcraterCount()*craterTime);
	}
}


class SuperCar
{
	double maxSpeed =20;
	double craterTime=3;
	String[] weather= {"SUNNY","RAINY","WINDY"};
	public boolean isEligibe(String Wthr)
	{
		for(String str:weather)
			if(str.compareTo(Wthr)==0)
				return true;
		return false;
	}
	public double travel(Orbit orb)
	{
		double speed=Double.min(maxSpeed,orb.getOrbMax());
		return (orb.getDistance()/speed)*60+(orb.getcraterCount()*craterTime);
	}
}

public class Geektrust {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.prdoubleln(args[0]);
		//double travelTime=100;
		//double craVar;
		//String Vehicle=" ",Orbit=" ";
		try {
		      File myObj = new File(args[0]);
		      Scanner myReader = new Scanner(myObj);  
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        String[] arr = data.split(" ",3); 
		        String Weather=arr[0];
		        String Orbit,Vehicle;
		        Bike Bk = new Bike();
		        TukTuk Tk= new TukTuk();
		        SuperCar Car = new SuperCar();
		        double orb1=Double.parseDouble(arr[1]);
		        double orb2=Double.parseDouble(arr[2]);
		        Orbit orbit1= new Orbit(18,Weather,orb1,20);
		        Orbit orbit2= new Orbit(20,Weather,orb2,10);
		        Map<String,Map<String,Double>> Orbits=new HashMap <String,Map<String,Double>>();
		        Map<String,Double> Orbit1Time=new HashMap <String,Double>();
		        Map<String,Double> Orbit2Time=new HashMap <String,Double>();
		        
		        System.out.println(Tk.isEligibe(Weather));
		       if(Bk.isEligibe(Weather))
		        {
		        	Orbit1Time.put("BIKE", Bk.travel(orbit1));
		        	Orbit2Time.put("BIKE", Bk.travel(orbit2));
		        }
		        if(Tk.isEligibe(Weather))
		        {
		        	Orbit1Time.put("TUKTUK", Tk.travel(orbit1));
		        	Orbit2Time.put("TUKTUK", Tk.travel(orbit2));
		        }
		        if(Car.isEligibe(Weather))
		        {
		        	Orbit1Time.put("CAR", Car.travel(orbit1));
		        	Orbit2Time.put("CAR", Car.travel(orbit2));
		        }
		        
		        Orbits.put("ORBIT1", Orbit1Time);
		        Orbits.put("ORBIT2", Orbit2Time);
		        
		        if(Collections.min(Orbit1Time.values())<Collections.min(Orbit2Time.values()))
		        {
		        	Orbit="ORBIT1";
		        	for(Map.Entry<String,Map<String,Double>> m:Orbits.entrySet()){  
		        		   if(m.getValue()==Collections.min(Orbit1Time.values()))
		        				   Vehicle=m.getKey();
		        }
		        }
		        	
		        else
				        {
				        	Orbit="ORBIT2";
				        	for(Map.Entry<String,Double> m:Orbit2Time.entrySet()){  
				        		   if(m.getValue()==Collections.min(Orbit2Time.values()))
				        				   Vehicle=m.getKey();
				        }
				        }
		        System.out.println(Vehicle+" "+Orbit);
		        
		      }
		        myReader.close();
		    
		}catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    } 
	
	}

}