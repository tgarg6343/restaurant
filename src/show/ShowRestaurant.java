package show;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@WebServlet("/showRestaurant")
public class ShowRestaurant extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ShowRestaurant() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out=response.getWriter();
		JSONParser parser=new JSONParser();
		JSONObject object=new JSONObject();
		JSONArray jsonArray=new JSONArray();
		try {
			jsonArray=(JSONArray) parser.parse(new FileReader("C:\\Users\\tgarg\\Desktop\\favourites.json"));
			String output=null;
			
			for (int i = 0; i <jsonArray.size(); i++) {
				object=(JSONObject)jsonArray.get(i);
				String id=String.valueOf((i+1));
				String fn="remove(\'"+id+"\')";
				output+="<div class=\"col-lg-4 col-md-6 col-sm-12\">";
				output="<div class=\"card\">";
				output+="<div class=\"card-block\">";
				output+="<img class=\"card-img-top\" src=\""+object.get("image_url")+"\" alt=\"Card image\">";
				output+="<h4 class=\"card-title\">"+object.get("name")+"</h4>";
				output+="<p class=\"card-text\">"+object.get("location")+"<br>"+object.get("cuisines")+"<br>"+object.get("rating")+""+object.get("votes")+"</p>";
				output+="<button type=\"button\" id=\""+id+"\"onclick=\""+fn+"\">Remove</button>";
				output+="<div id=\"div"+(i+1)+"\">division tag</div>";
				output+="</div>";
				output+="</div>";
				out.write(output);
			}
			
			
			System.out.println(output);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
