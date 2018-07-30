<!-- 
index.jsp 
前端页面
主要用于创建表单、表单提交、表单验证

1. 创建表单
创建<select>下拉框，根据onclick跳转到showBasises()；
2. 表单提交
showBasises()中点击submit按钮进行提交；
3. 表单验证
根据onsubmit跳转到validateForm()，
并通过action的POST方法与后端的servlet层相关联；
 -->
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
<option value="120">秘密</option>
<option value="150">机密</option>
</select>
<div id="table_context"></div>
</form>
<script src="showBasises.js"></script>
<script src="validateForm.js"></script>
</body>
</html>