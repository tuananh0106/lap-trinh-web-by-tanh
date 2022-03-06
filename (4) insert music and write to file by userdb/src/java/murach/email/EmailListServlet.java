package murach.email;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import murach.business.User;
import murach.data.UserDB;
import org.apache.tomcat.util.descriptor.web.WebXml;
public class EmailListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, 
                        HttpServletResponse response) 
                        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
        String url = "/index.html";
        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "join"; // default action
        }
        // perform action and set URL to appropriate page
        if (action.equals("join")) {
           url = "/index.html"; // the "join" page
        }
        else if (action.equals("add")) { 
            // get parameters from the request
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String sex = request.getParameter("sex");
            String edu = request.getParameter("education");
            String music[] = request.getParameterValues("music");
            // store data in User object and save User object in db
            User user = new User(firstName, lastName, email, sex, edu, music);
            
//            get real path
            String path = getServletContext().getRealPath("/WEB-INF/EmailList.txt");
            UserDB.insert(user,path);
            // set User object in request object and set URL
            request.setAttribute("user", user);
            url = "/thanks.jsp"; // the "thanks" page
        }

        // forward request and response objects to specified URL
        getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);
        } 
    @Override
    protected void doGet(HttpServletRequest request, 
                        HttpServletResponse response) 
                        throws ServletException, IOException {
        doPost(request, response);
    } 
}
