<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Label</title>
</head>
<body>
<h1>使用 GET 方法读取数据</h1>
<ul>
<li><p><b>周期:</b>
   <%= request.getParameter("period")%>
</p></li>
<li><p><b>等级:</b>
   <%= request.getParameter("level")%>
</p></li>
</ul>
</body>
</html>