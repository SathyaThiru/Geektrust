import java.io.*;
import java.util.*;

public class Geektrust {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(args[0]);
		LinkedHashMap <String,String> Messages= new LinkedHashMap <String,String>();
		LinkedHashSet <String> kingdomWon=new LinkedHashSet<String>();
		LinkedHashMap <String,String> keyMap= new LinkedHashMap <String,String>();
		keyMap.put("LAND","PANDA");
		keyMap.put("WATER","OCTOPUS");
		keyMap.put("ICE","MAMMOTH");
		keyMap.put("AIR","OWL");
		keyMap.put("FIRE","DRAGON");
		try {
		      File myObj = new File(args[0]);
		      Scanner myReader = new Scanner(myObj);  
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        String[] arr = data.split(" ",2); 
		        Messages.put(arr[0], decrypt(arr[1],keyMap.get(arr[0]).length()).toString());
		        //System.out.println(sendMessage(keyMap.get(arr[0]),Messages.get(arr[0])));
		        if(sendMessage(keyMap.get(arr[0]),Messages.get(arr[0]))) {
		        	kingdomWon.add(arr[0]);
		        }
		      }
		        if(kingdomWon.size()>=3)
		        {
		        	System.out.print("SPACE ");
		        	for(String str:kingdomWon)
		        		System.out.print(str+" ");
		        }
		        else
		        	System.out.println("NONE");
		            myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    } 
	}
	public static StringBuffer decrypt(String text, int s)	{
		StringBuffer result= new StringBuffer(); 
		  
        for (int i=0; i<text.length(); i++) 
        { 
            if (Character.isUpperCase(text.charAt(i))) 
            { 
                char ch = (char)(65+((int)text.charAt(i) -
                                  s + 65) % 26); 
                result.append(ch); 
            } 
            else if(Character.isLowerCase(text.charAt(i)))
            { 
                char ch = (char)(97+((int)text.charAt(i) - 
                                  s + 97) % 26); 
                result.append(ch); 
            }
            else 
            	result.append(text.charAt(i));
            
        } 
       
        return result;
	}
	
	public static boolean sendMessage(String emblem, String Message) {
		int[] embMap = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		int[] msgMap = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		
		for(int i=0;i<emblem.length();i++)
		{
			if(Character.isUpperCase(emblem.charAt(i)))
				embMap[(int)emblem.charAt(i)-65]++;
			else if(Character.isLowerCase(emblem.charAt(i)))
				embMap[(int)emblem.charAt(i)-97]++;
		}
		
		for(int i=0;i<Message.length();i++)
		{
			if(Character.isUpperCase(Message.charAt(i)))
				msgMap[(int)Message.charAt(i)-65]++;
			else if(Character.isLowerCase(Message.charAt(i)))
				msgMap[(int)Message.charAt(i)-97]++;
		}
		
		for(int i=0;i<26;i++)
		{
			if(msgMap[i]<embMap[i])
				return false;
		}
		
		return true;
	}
	
}
