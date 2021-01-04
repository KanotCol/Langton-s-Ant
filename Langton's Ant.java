import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader (isr);
		String line = br.readLine();
		
		while (line != null)
		{
			int n = 0;
			int X = 0;
			int Y = 0;
			String D = "N";
			int pos = 0;
			
			String [] data = line.split(" ");
			n = Integer.parseInt(data[0]);
			X = Integer.parseInt(data[3]);
			Y = Integer.parseInt(data[2]);
			
        	if (X == n && Y == n && n != 0)
        	{
            	System.out.println("Yes");
        	}
        	else if (X != 0 && Y != 0 && n != 0)
        	{
    			BigInteger c = new BigInteger(data[1]);
    			String binary = c.toString(2);
    			
    			X -= 1;
    			Y -= 1;
    			pos = 0;
    	        boolean flag = true;
    	        
    	        if (binary.length() < (n * n))
    	        {
    	        	int len = (n * n) - binary.length();
    	        	for (int i = 1; i <= len; i++)
    	        	{
    	        		binary = "0" + binary;
    	        	}
    	        }
    	        
    	        binary.substring(binary.length() - (n * n));
    	        
    	        while(flag)
    	        {
    	        	pos = X * n + Y;
    	        	
					if (Integer.parseInt(binary.substring(pos, pos + 1)) == 0)
    	            {
						if (pos == 0)
							binary = "1" + binary.substring(pos + 1);
						else if (pos == binary.length())
						    binary = binary.substring(0, pos) + "1";
						else
							binary = binary.substring(0, pos) + "1" + binary.substring(pos + 1);
    	        		
    					switch (D)
						{
							case "N":
								D = "W";
								Y -= 1;
								break;
							case "S":
								D = "E";
								Y += 1;
								break;
							case "E":
								D = "N";
								X += 1;
								break;
							case "W":
								D = "S";
								X -= 1;
								break;
						}
    	            }
    	            else
    	            {
    	            	if (pos == 0)
							binary = "0" + binary.substring(pos + 1);
						else if (pos == binary.length())
						    binary = binary.substring(0, pos) + "0";
						else
							binary = binary.substring(0, pos) + "0" + binary.substring(pos + 1);
    	        		
    					switch (D)
						{
							case "N":
								D = "E";
								Y += 1;
								break;
							case "S":
								D = "W";
								Y -= 1;
								break;
							case "E":
								D = "S";
								X -= 1;
								break;
							case "W":
								D = "N";
								X += 1;
								break;
						}
    	            }
    	            
    	            if(X == n - 1 && Y == n - 1)
    	            {
    	            	System.out.println("Yes");
    	            	flag = false;
    	            }
    	            else if(X < 0 || Y < 0 || X >= n || Y >= n)
    	            {
    	            	System.out.println("Kaputt!");
    	            	flag = false;
    	            }
    	        }
	        }
	        
			line = br.readLine();
		}
	}
}