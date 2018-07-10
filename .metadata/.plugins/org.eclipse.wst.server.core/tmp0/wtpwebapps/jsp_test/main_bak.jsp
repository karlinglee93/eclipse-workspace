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
<li><p><b>1) 电子文件的定密时间classifiedTime:</b>
	<% String classifiedTime = new String((request.getParameter("classifiedTime")).getBytes("ISO-8859-1"),"UTF-8"); %>
	<%=classifiedTime%>
</p></li>
<li><p><b>2) 保密的时间长度period:</b>
	<% String period = new String((request.getParameter("period")).getBytes("ISO-8859-1"),"UTF-8"); %>
	<%=period%>
</p></li>
<li><p><b>3) 应在此日期前解密declassifiedTime:</b>
	<% String declassifiedTime = new String((request.getParameter("declassifiedTime")).getBytes("ISO-8859-1"),"UTF-8"); %>
	<%=declassifiedTime%>
</p></li>
<li><p><b>4) 解密的具体条件condition:</b>
	<% String condition = new String((request.getParameter("condition")).getBytes("ISO-8859-1"),"UTF-8"); %>
	<%=condition%>
</p></li>

<li><p><b>管理状态status:</b>
	<% String status = new String((request.getParameter("status")).getBytes("ISO-8859-1"),"UTF-8"); %>
	<%=status%>
</p></li>

<li><p><b>文件起草人drafter:</b>
<li><p><b>1) 标识id:</b>
	<% String id = new String((request.getParameter("id")).getBytes("ISO-8859-1"),"UTF-8"); %>
	<%=id%>
</p></li>
<li><p><b>2) 名称name:</b>
	<% String name = new String((request.getParameter("name")).getBytes("ISO-8859-1"),"UTF-8"); %>
	<%=name%>
</p></li>

<li><p><b>定密责任人authority:</b>
<li><p><b>1) 标识id_authority:</b>
	<% String id_authority = new String((request.getParameter("id_authority")).getBytes("ISO-8859-1"),"UTF-8"); %>
	<%=id_authority%>
</p></li>
<li><p><b>2) 名称name_authority:</b>
	<% String name_authority = new String((request.getParameter("name_authority")).getBytes("ISO-8859-1"),"UTF-8"); %>
	<%=name_authority%>
</p></li>

<li><p><b>文件签发人issuer:</b>
<li><p><b>1) 标识id_issuer:</b>
	<% String id_issuer = new String((request.getParameter("id_issuer")).getBytes("ISO-8859-1"),"UTF-8"); %>
	<%=id_issuer%>
</p></li>
<li><p><b>2) 名称name_issuer:</b>
	<% String name_issuer = new String((request.getParameter("name_issuer")).getBytes("ISO-8859-1"),"UTF-8"); %>
	<%=name_issuer%>
</p></li>

<li><p><b>定密单位organs:</b>
<li><p><b>1) 标识id_organs:</b>
	<% String id_organs = new String((request.getParameter("id_organs")).getBytes("ISO-8859-1"),"UTF-8"); %>
	<%=id_organs%>
</p></li>
<li><p><b>2) 名称name_organs:</b>
	<% String name_organs = new String((request.getParameter("name_organs")).getBytes("ISO-8859-1"),"UTF-8"); %>
	<%=name_organs%>
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

<li><p><b>管理历史histories:</b>
<li><p><b>1) 操作时间time:</b>
	<% String time = new String((request.getParameter("time")).getBytes("ISO-8859-1"),"UTF-8"); %>
	<%=time%>
</p></li>
<li><p><b>2) 操作人员姓名staff:</b>
	<% String staff = new String((request.getParameter("staff")).getBytes("ISO-8859-1"),"UTF-8"); %>
	<%=staff%>
</p></li>
<li><p><b>3) 变更操作的具体描述description_histories:</b>
	<% String description_histories = new String((request.getParameter("description_histories")).getBytes("ISO-8859-1"),"UTF-8"); %>
	<%=description_histories%>
</p></li>
<li><p><b>4) 解密原因decryptReason:</b>
	<% String decryptReason = new String((request.getParameter("decryptReason")).getBytes("ISO-8859-1"),"UTF-8"); %>
	<%=decryptReason%>
</p></li>
<li><p><b>5) 变更类型type:</b>
	<% String type_histories = new String((request.getParameter("type_histories")).getBytes("ISO-8859-1"),"UTF-8"); %>
	<%=type_histories%>
</p></li>
<li><p><b>6) 变更前密级levelBefore:</b>
	<% String levelBefore = new String((request.getParameter("levelBefore")).getBytes("ISO-8859-1"),"UTF-8"); %>
	<%=levelBefore%>
</p></li>
<li><p><b>7) 变更前保密期限durationBefore:</b>
	<% String durationBefore = new String((request.getParameter("durationBefore")).getBytes("ISO-8859-1"),"UTF-8"); %>
	<%=durationBefore%>
</p></li>

<li><p><b>关键字列表keys:</b>
	<% String keys = new String((request.getParameter("keys")).getBytes("ISO-8859-1"),"UTF-8"); %>
	<%=keys%></p></li>

</ul>
</body>
</html>