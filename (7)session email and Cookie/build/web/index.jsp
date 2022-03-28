<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Murach's Java Servlets and JSP</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
    </head>
    <body>
        <h1>Join our email list</h1>
        <p>To join our email list, enter your name and email address below.</p>
        <p><i>${message}</i></p>
        <form action="emailList" method="post">
            <input type="hidden" name="action" value="add">
            <label> Your Email Address: </label>
            <p><i>${email_hidden}</i></p> <br>
            <label>Email:</label>
            <input type="email" name="email" value="${user.email}"><br>
            <p><i>${message_email}</i></p>
            <label>First Name:</label>
            <input type="text" name="firstName" value="${user.firstName}"><br>
            <p><i>${message_firstName}</i></p>
            <label>Last Name:</label>
            <input type="text" name="lastName" value="${user.lastName}"><br>
            <p><i>${message_lastName}</i></p>
            <label>&nbsp;</label>
            <input type="submit" value="Join Now">
        </form>
    </body>
</html>
