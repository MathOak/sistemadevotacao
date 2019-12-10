<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.web.bean.Eleitor" %>
<%@page import="com.web.bean.Candidato" %>
<%@page import="com.web.bean.User" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

User teste = new User();
Eleitor t1 = new Eleitor();
Candidato votos1 = new Candidato();
//GRIS Candidato cand1 = new Candidato();
//GRIS cand1 = request.getAttribute("candidato11");
//List <Eleitor> list= (ArrayList) request.getAttribute("list");
//List<Eleitor> eleitorList = new ArrayList<Eleitor>();
//t1 = (Eleitor) request.getSession().getAttribute("user");
//list.add(list.get(list.size()-1));
teste = (User) request.getSession().getAttribute("user");
t1 = teste.getEleitor();
String banco = (String) request.getAttribute("banco");
String servlet = (String) request.getAttribute("servlet");
String texto = (String) request.getSession().getAttribute("texto");
//request.getSession().getAttribute("user");
//votos1 = (Candidato) request.getAttribute("candidato11");
int votos2 = (int) request.getAttribute("candidato22");
int votos3 = (int) request.getAttribute("candidato33");
int votos4 = (int) request.getAttribute("candidato44");
int votos5 = (int) request.getAttribute("candidato55");
%>
<h1><%=teste.getEleitor()%><%//t1.getNome_eleitor()%>
</h1>
<h1><%=t1.getHora()%></h1>

----------------------<br>
<h1><%=banco%></h1>
<h1><%=servlet%></h1>
<h2><%=texto%></h2>
<%=votos1.getVotos() %><br>
<%=votos2 %><br>
<%=votos3 %><br>
<%=votos4 %><br>
<%=votos5 %><br>
</body>
</html>