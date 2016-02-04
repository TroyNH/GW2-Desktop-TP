package bigJava;

import java.awt.*;

public class Ex2_4 
{
	public static void main(String args [])
	{
		Rectangle rekt = new Rectangle(10, 10, 20, 20);
		Rectangle rekt2 = new Rectangle(20, 15, 20, 20);
		Rectangle rekt3 = rekt.intersection(rekt2);
		System.out.println("x=" + rekt3.getX() + " y=" + rekt3.getY() + " Width=" + rekt3.getWidth() + " Height=" + rekt3.getHeight());
	}
}
