import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadJSONExample 
{
	@SuppressWarnings("unchecked")
	public static void main(String[] args) 
	{
		//JSON parser object to parse read file
		JSONParser jsonParser = new JSONParser();
		JSONObject declare = new JSONObject();
		JSONObject declareObject = new JSONObject();
		JSONObject globalObject = new JSONObject();
		JSONObject localObject = new JSONObject();


		try (FileReader reader = new FileReader("regex.json"))
		{
			//Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray regexList = (JSONArray) obj;
            System.out.println(regexList);
            
            //Iterate over employee array
			regexList.forEach( emp -> parseEmployeeObject( (JSONObject) emp ) );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
	}

	private static void parseEmployeeObject(JSONObject declare)
	{
		//Get Global Dcelarations
		JSONObject g_declaration = (JSONObject) declare.get("Global Dcelarations");
		
		//Get employee first name
		String struct = (String) g_declaration.get("struct");
		System.out.println(struct);
		
		//Get employee website name
		String union = (String) g_declaration.get("union");
		System.out.println(union);

		String enumm = (String) g_declaration.get("enum");
		System.out.println(enumm);
	}

}
