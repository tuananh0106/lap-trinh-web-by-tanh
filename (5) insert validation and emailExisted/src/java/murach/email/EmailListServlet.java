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
        String url = "/index.jsp";

        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "join"; // default action
        }
        // perform action and set URL to appropriate page
        if (action.equals("join")) {
            url = "/index.jsp"; // the "join" page
        } 
        else if (action.equals("add")) {
            // get parameters from the request
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
           // store data in User object
            User user = new User(firstName, lastName, email);
            // validate the parameters
            String message_firstName="";
            String message_lastName="";
            String message_email="";
            String path = getServletContext().getRealPath("/WEB-INF/EmailList.txt");
            String path1 = getServletContext().getRealPath(getInitParameter("relativePathToFile"));
            if(email == null || email.isEmpty()){
                message_email = "Please fill out Email box";
                url = "/index.jsp";
            }
            else if(UserDB.emailExisted(email, path)){
                 message_email = "Email existed!";
             }
            else if (firstName == null || firstName.isEmpty() ){
                message_firstName = "Please fill out FirstName box";
                url = "/index.jsp";
            }
            else if(lastName == null || lastName.isEmpty()){
                message_lastName = "Please fill out LastName box";
                url = "/index.jsp";
            }
            else {
                url = "/thanks.jsp";
                UserDB.insert(user, path1);
            }
            request.setAttribute("user", user);
            request.setAttribute("message_firstName", message_firstName);
            request.setAttribute("message_lastName", message_lastName);
            request.setAttribute("message_email", message_email);
        }
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
