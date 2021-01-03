package character.count;

import java.util.Scanner;

public class Characters {

	public Characters() {
		// TODO Auto-generated constructor stub
	}
	
    public static void main(String[] args)
    {
    	int i = 0, j = 0, k = 0;
    	Scanner sc = new Scanner(System.in);
    	String s = sc.next();
    	char c = s.charAt(0);
    	while(c != '#')
    	{
	    	if (c>='A' && c<='Z' || c>='a' && c<='z')
	         	i++;     
	    	else if (c>='0' && c<='9')        
	         	j++;     
	   		else  
	        	k++;     		
	    	
	    	s = sc.next();
	    	c = s.charAt(0);	
    	}
    	
    	System.out.printf("Character:%d,Number:%d,Other:%d",i,j,k);
    	sc.close();
    }
    
}
