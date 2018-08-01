<!-- 初始页面一定要放在WebContent 目录下，因为WEB-INF 目录下的页面不允许直接访问 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="addApple">
		
		产品类型: <input type="text" name="kind" value=""><br />
		产品名称: <input type="text" name="name" value=""><br />
		产品价格: <input type="text" name="price" value=""><br />
		
		<input type="submit" value="增加Apple">
	</form>
</body>
</html>