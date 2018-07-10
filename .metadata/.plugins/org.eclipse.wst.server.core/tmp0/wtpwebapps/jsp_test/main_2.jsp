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

	<% String classifiedTime = new String((request.getParameter("classifiedTime")).getBytes("ISO-8859-1"),"UTF-8"); %>
	<% String period = new String((request.getParameter("period")).getBytes("ISO-8859-1"),"UTF-8"); %>
	<% String declassifiedTime = new String((request.getParameter("declassifiedTime")).getBytes("ISO-8859-1"),"UTF-8"); %>
	<% String condition = new String((request.getParameter("condition")).getBytes("ISO-8859-1"),"UTF-8"); %>

	<% String status = new String((request.getParameter("status")).getBytes("ISO-8859-1"),"UTF-8"); %>

	<% String id = new String((request.getParameter("id")).getBytes("ISO-8859-1"),"UTF-8"); %>
	<% String name = new String((request.getParameter("name")).getBytes("ISO-8859-1"),"UTF-8"); %>

	<% String id_authority = new String((request.getParameter("id_authority")).getBytes("ISO-8859-1"),"UTF-8"); %>
	<% String name_authority = new String((request.getParameter("name_authority")).getBytes("ISO-8859-1"),"UTF-8"); %>

	<% String id_issuer = new String((request.getParameter("id_issuer")).getBytes("ISO-8859-1"),"UTF-8"); %>
	<% String name_issuer = new String((request.getParameter("name_issuer")).getBytes("ISO-8859-1"),"UTF-8"); %>

	<% String id_organs = new String((request.getParameter("id_organs")).getBytes("ISO-8859-1"),"UTF-8"); %>
	<% String name_organs = new String((request.getParameter("name_organs")).getBytes("ISO-8859-1"),"UTF-8"); %>

	<% String description = new String((request.getParameter("description")).getBytes("ISO-8859-1"),"UTF-8"); %>
	<% String staffs = new String((request.getParameter("staffs")).getBytes("ISO-8859-1"),"UTF-8"); %>
	<% String groups = new String((request.getParameter("groups")).getBytes("ISO-8859-1"),"UTF-8"); %>
	<% String units = new String((request.getParameter("units")).getBytes("ISO-8859-1"),"UTF-8"); %>

	<% String type = new String((request.getParameter("type")).getBytes("ISO-8859-1"),"UTF-8"); %>
	<% String description_basises = new String((request.getParameter("description_basises")).getBytes("ISO-8859-1"),"UTF-8"); %>
	<% String normalItems = new String((request.getParameter("normalItems")).getBytes("ISO-8859-1"),"UTF-8"); %>
	<% String derivedItems = new String((request.getParameter("derivedItems")).getBytes("ISO-8859-1"),"UTF-8"); %>

String label =
				"{\"algoSpecId\":1,\"algoSpecVersion\":1,\"authority\":{},\"basises\":{\"description\":\"<%=description_basises%>\","
				+ "\"normalItems\":[{\"duration\":{\"period\":\"<%=period%>\"},\"id\":\"a494090c-3d3e-4b97-9304-62e05b40baca\","
				+ "\"level\":<%=level%>,\"name\":\" 绩效管理有关信息\"},"
				+ "{\"duration\":{\"period\":\"999999\"},\"id\":\"ac803f05-6d3f-4167-8884-c6b1310dc5b1\","
				+ "\"level\":<%=level%>,\"name\":\" 公 司 人 工 成 本 信 息 及 相 关 统 计 数 据\"}],"
				+ "\"type\":<%=type%>},\"drafter\":{\"id\":\"<%=id%>\",\"name\":\"<%=name%>\"},"
				+ "\"duration\":{\"condition\":\"<%=condition%>\",\"period\":\"<%=period%>\"},\"fileAssetId\":\"\",\"fileContentId\":\"\","
				+ "\"fileUniqueId\":\"\",\"issuer\":{},\"labelSpecId\":1,\"labelSpecVersion\":1,\"level\":180,"
				+ "\"organs\":[{\"id\":\"<%=id_organs%>\",\"name\":\"<%=name_organs%>\"}],"
				+ "\"scope\":{\"description\":\"<%=description%>\"},\"status\":<%=status%>}";
				
<!-- 

	// "{\"algoSpecId\":1,\"algoSpecVersion\":1,
	// \"authority\":{}, 不知道id和name的格式
	// \"id\":\"a494090c-3d3e-4b97-9304-62e05b40baca\", 不知道是谁的id
	// \"name\":\" 绩效管理有关信息\"}," 不知道是谁的name

	// + "{\"duration\":{\"period\":\"999999\"},\"id\":\"ac803f05-6d3f-4167-8884-c6b1310dc5b1\","
	// + "\"level\":<%=level%>,\"name\":\" 公 司 人 工 成 本 信 息 及 相 关 统 计 数 据\"}]," 如何重复填写

	// \"fileAssetId\":\"\",\"fileContentId\":\"\"," + "\"fileUniqueId\":\"\"
	// \"issuer\":{}, 不知道id和name的格式
	//\"labelSpecId\":1,\"labelSpecVersion\":1,\"level\":180,"
 -->

</ul>
</body>
</html>