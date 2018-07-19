<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="Receive" method="POST" onsubmit="return validateForm()">
<h1>加密属性设置</h1>
加密密级：
<select name="level" id="level" onclick="showBasises()">
<option>--未选择--</option>
<option value="150">机密</option>
<option value="180">绝密</option>
</select>
<div id="table_context"></div>
</form>
<script src="showBasises.js"></script>
<script src="validateForm.js"></script>
</body>
</html>