<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    if ("username".equals(username) && "password".equals(password)) {
        response.sendRedirect("User.html");
    } else {
        response.sendRedirect("Login.html");
    }
%>
</body>
</html>
