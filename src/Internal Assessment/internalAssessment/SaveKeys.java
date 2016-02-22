package internalAssessment;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonWriter;
import javax.swing.JOptionPane;

public class SaveKeys 
{
	void save (String api_info, String api_key) throws IOException
	{	
		//File writer for storing saved keys
		FileWriter filew = new FileWriter ("C:\\temp_Troy\\MySavedKeys.txt", true);
		PrintWriter output = new PrintWriter(filew);
		
		try
		{
			//Read data retrieved from website
			JsonReader read = Json.createReader (new StringReader (api_info));
			JsonObject APIObject = read.readObject ();
		
			read.close();
		
			//Build new Json object to store selected data
			JsonObject generalKeyObject = Json.createObjectBuilder ()
				.add ("key", api_key)
				.add ("name", APIObject.getString ("name"))
				.build();
			
			//Write to file
			StringWriter stringwriter = new StringWriter ();
			JsonWriter writer = Json.createWriter (stringwriter);
			
			writer.writeObject (generalKeyObject);
			writer.close();
			
			output.println(stringwriter.getBuffer().toString());
		}
		catch (NullPointerException e)
		{
			JOptionPane.showMessageDialog (null, "We ran into an issue when attempting to authenticate your key, this could mean you entered an invalid key or that your computer could not connect to ArenaNet's servers.\n"
			+ "Please make sure your key is correct and you are still connected to the internet.", "Problem with API Key", JOptionPane.ERROR_MESSAGE);
		}

		
		try 
		{
			filew.close();
			output.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
