package alter;

import java.io.FileReader;
import java.io.FileWriter;
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



@WebServlet("/deleteRestaurant")
public class DeleteRestaurant extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteRestaurant() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FileWriter jsonWriter=null;
		JSONArray array=new JSONArray();
		JSONParser parser=new JSONParser();
		PrintWriter out=response.getWriter();
		response.setContentType("application/json");
		String id= request.getParameter("id");
		int index=Integer.parseInt(id);
		
		try {
			array=(JSONArray) parser.parse(new FileReader("favourite.json"));
			array.remove(index);
			jsonWriter=new FileWriter("favourite.json");
			jsonWriter.write(array.toString());
			out.print("restaurant is deleted");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
