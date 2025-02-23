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
	String strA=request.getParameter("a");
	int valueA=Integer.parseInt(strA);
	String strB=request.getParameter("b");
	int valueB=Integer.parseInt(strB);
	String operation=request.getParameter("operator");
	 
	switch(operation){
	case "+": out.append(valueA +"+"+ valueB +" = "+ (valueA + valueB));
	break;
	
	case "-": out.append(valueA +"-"+  valueB +" = "+ (valueA - valueB));
	break;
	
	case "*": out.append(valueA +"*"+  valueB +" = "+ (valueA * valueB));
	break;
	
	case "/": 
		if(valueB!=0){
		out.append(valueA +"/"+  valueB +" = "+(valueA/valueB));}
		else out.print("Lỗi");
	break;
	
	}
	%>
</body>
</html>