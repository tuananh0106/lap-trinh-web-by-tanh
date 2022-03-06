<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Murach's Java Servlets and JSP</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
    </head>
    <body>
        <h1>Thanks for joining our email list</h1>
        <p>Here is the information that you entered:</p>
        <label>Email:</label>
        <span>${user.email}</span><br>
        <label>First Name:</label>
        <span>${user.firstName}</span><br>
        <label>Last Name:</label>
        <span>${user.lastName}</span><br>
        <label>Sex:</label>
        <span>${user.sex}</span><br>
        <label>Education:</label>
        <span>${user.education}</span><br>
        We ‘ll use this email to notify you whenever we have new releases for these types of music:<br>
        <c:forEach items="${user.music}" var="item">
            ${item}<br>
            <!--để làm được cái này cần thêm thư viện jstl-1.2 nhé-->
        </c:forEach>
        <p>To enter another email address, click on the Back 
        button in your browser or the Return button shown 
        below.</p>
        <form action="" method="get">
            <input type="hidden" name="action" value="join">
            <input type="submit" value="Return">
        </form>
   </body>
</html>
