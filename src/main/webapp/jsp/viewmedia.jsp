<%@page import="org.sumanta.bean.Media"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<%
ArrayList<Media> l=(ArrayList<Media>)request.getAttribute("mediadetails");
for(int i=0;i<l.size();i++)
{
%><tr><td>
<%=l.get(i).getId() %></td><td>
<%=l.get(i).getPath() %></td>
<td><a href="Streamer?id=<%=l.get(i).getId()%>">PLAY</a></td>
<td><a href="EditMedia?id=<%=l.get(i).getId()%>">EDIT</a></td>
<td><a href="DeleteMedia?id=<%=l.get(i).getId()%>">DELETE</a></td></tr>
<%} %>
</table>
</body>
</html>