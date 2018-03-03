package alter;

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

@WebServlet("/addRestaurant")
public class AddRestaurant extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int count=0;
	private static JSONArray jarray=new JSONArray();
    public AddRestaurant() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FileWriter jsonWriter=null;
		PrintWriter out=response.getWriter();
		response.setContentType("application/json");
		String name= request.getParameter("name");
		out.print("Thank you for adding <b>"+name+"</b> to your favorite restaurant");
		JSONObject object=new JSONObject();
		object.put("name", request.getParameter("name"));
		object.put("location", request.getParameter("location"));
		object.put("cuisines", request.getParameter("cuisines"));
		object.put("rating", request.getParameter("rating"));
		object.put("votes", request.getParameter("votes"));
		object.put("image_url", request.getParameter("image_url"));
		
		if(count<10) {
			jarray.add(object);
		}
		else {
			System.out.println("you have exceeded");
		}
		try {
			jsonWriter=new FileWriter("favourite.json");
			jsonWriter.write(jarray.toString());
			System.out.println(object.toString());
		} catch (Exception e) {
			System.out.println("please enetr a valid path");
		}
		finally {
			jsonWriter.flush();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
