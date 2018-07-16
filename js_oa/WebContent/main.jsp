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
<ul>

	<% String level = new String((request.getParameter("level")).getBytes("ISO-8859-1"),"UTF-8"); %>

	<% String period = new String((request.getParameter("period")).getBytes("ISO-8859-1"),"UTF-8"); %>
	<% String condition = new String((request.getParameter("condition")).getBytes("ISO-8859-1"),"UTF-8"); %>

	<% String status = new String((request.getParameter("status")).getBytes("ISO-8859-1"),"UTF-8"); %>

	<% String id = new String((request.getParameter("id")).getBytes("ISO-8859-1"),"UTF-8"); %>
	<% String name = new String((request.getParameter("name")).getBytes("ISO-8859-1"),"UTF-8"); %>

	<% String id_organs = new String((request.getParameter("id_organs")).getBytes("ISO-8859-1"),"UTF-8"); %>
	<% String name_organs = new String((request.getParameter("name_organs")).getBytes("ISO-8859-1"),"UTF-8"); %>

	<% String description = new String((request.getParameter("description")).getBytes("ISO-8859-1"),"UTF-8"); %>

	<% String type = new String((request.getParameter("type")).getBytes("ISO-8859-1"),"UTF-8"); %>
	<% String description_basises = new String((request.getParameter("description_basises")).getBytes("ISO-8859-1"),"UTF-8"); %>
	<% String id_normalItems = new String((request.getParameter("id_normalItems")).getBytes("ISO-8859-1"),"UTF-8"); %>
	<% String name_normalItems = new String((request.getParameter("name_normalItems")).getBytes("ISO-8859-1"),"UTF-8"); %>
	<% String id_normalItems_1 = new String((request.getParameter("id_normalItems_1")).getBytes("ISO-8859-1"),"UTF-8"); %>
	<% String name_normalItems_1 = new String((request.getParameter("name_normalItems_1")).getBytes("ISO-8859-1"),"UTF-8"); %>

String label =
				"{\"algoSpecId\":1,\"algoSpecVersion\":1,\"authority\":{},\"basises\":{\"description\":\"<%=description_basises%>\","
				+ "\"normalItems\":[{\"duration\":{\"period\":\"<%=period%>\"},\"id\":\"<%=id_normalItems%>\","
				+ "\"level\":<%=level%>,\"name\":\" <%=name_normalItems%>\"},"
				+ "{\"duration\":{\"period\":\"<%=period%>\"},\"id\":\"<%=id_normalItems_1%>\","
				+ "\"level\":<%=level%>,\"name\":\"<%=name_normalItems_1%>\"}],"
				+ "\"type\":<%=type%>},\"drafter\":{\"id\":\"<%=id%>\",\"name\":\"<%=name%>\"},"
				+ "\"duration\":{\"condition\":\"<%=condition%>\",\"period\":\"<%=period%>\"},\"fileAssetId\":\"\",\"fileContentId\":\"\","
				+ "\"fileUniqueId\":\"\",\"issuer\":{},\"labelSpecId\":1,\"labelSpecVersion\":1,\"level\":180,"
				+ "\"organs\":[{\"id\":\"<%=id_organs%>\",\"name\":\"<%=name_organs%>\"}],"
				+ "\"scope\":{\"description\":\"<%=description%>\"},\"status\":<%=status%>}";
				
<!-- 
	// "{\"algoSpecId\":1,\"algoSpecVersion\":1,
	// \"fileAssetId\":\"\",\"fileContentId\":\"\"," + "\"fileUniqueId\":\"\"
	//\"labelSpecId\":1,\"labelSpecVersion\":1,\"level\":180,"
 -->

</ul>
</body>
</html>