package classes;


public class ConverteTipo {
	public static int strToInt(String s)
	{
		try
		{
			s=s.trim();
			return Integer.valueOf(s);
		}
		catch(NumberFormatException e)
		{
			//e.printStackTrace();
			return -1;
		}
	}
	public static long strToLong(String s)
	{
		try
		{
			s=s.trim();
			return Long.valueOf(s);
		}
		catch(NumberFormatException e)
		{
			//e.printStackTrace();
			return -1l;
		}
	}
	public static float strToFloat(String s)
	{
		try
		{
			s=s.trim();
			return Float.valueOf(s);
		}
		catch(NumberFormatException e)
		{
			//e.printStackTrace();
			return -1f;
		}
	}
}
