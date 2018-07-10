<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>密标接口文档</title>
</head>
<body>
<h1>密级标志属性模板(json字符串)</h1>
<ul>
<li><p><b>密级level:</b>
	<% String level = new String((request.getParameter("level")).getBytes("ISO-8859-1"),"UTF-8"); %>
	<%=level%>
</p></li>

<li><p><b>保密期限duration:</b>
<li><p><b>1) 保密的时间长度period:</b>
	<% String period = new String((request.getParameter("period")).getBytes("ISO-8859-1"),"UTF-8"); %>
	<%=period%>
</p></li>

<li><p><b>知悉范围scope:</b>
<li><p><b>1) 描述形式的知悉范围description:</b>
	<% String description = new String((request.getParameter("description")).getBytes("ISO-8859-1"),"UTF-8"); %>
	<%=description%>
</p></li>
<li><p><b>2) 知悉人员列表staffs:</b>
	<% String staffs = new String((request.getParameter("staffs")).getBytes("ISO-8859-1"),"UTF-8"); %>
	<%=staffs%>
</p></li>
<li><p><b>3) 知悉部门、群 组列表groups:</b>
	<% String groups = new String((request.getParameter("groups")).getBytes("ISO-8859-1"),"UTF-8"); %>
	<%=groups%>
</p></li>
<li><p><b>4) 知悉单位列表units:</b>
	<% String units = new String((request.getParameter("units")).getBytes("ISO-8859-1"),"UTF-8"); %>
	<%=units%>
</p></li>

<li><p><b>定密依据basises:</b>
<li><p><b>1) 定密依据类型type:</b>
	<% String type = new String((request.getParameter("type")).getBytes("ISO-8859-1"),"UTF-8"); %>
	<%=type%>
</p></li>
<li><p><b>2) 定密依据描述description_basises:</b>
	<% String description_basises = new String((request.getParameter("description_basises")).getBytes("ISO-8859-1"),"UTF-8"); %>
	<%=description_basises%>
</p></li>
<li><p><b>3) 具体的定密依据的说明描述列表normalItemsnormalItems:</b>
	<% String normalItems = new String((request.getParameter("normalItems")).getBytes("ISO-8859-1"),"UTF-8"); %>
	<%=normalItems%>
</p></li>
<li><p><b>4) 已定密(派生)事项列表derivedItems:</b>
	<% String derivedItems = new String((request.getParameter("derivedItems")).getBytes("ISO-8859-1"),"UTF-8"); %>
	<%=derivedItems%>
</p></li>

</ul>
</body>
</html>