<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>我的第一段 JavaScript</h1>
 
<p>请输入数字。如果输入值不是数字，浏览器会弹出提示框。</p>
 
<input id="demo" type="text">
 
<script type="text/javascript">
function myFunction()
{
var x=document.getElementById("demo").value;
/* isNaN() 函数用于检查其参数是否是非数字值。 */
if(x==""||isNaN(x))
	{
	alert("Not Numeric");
	}
}
</script>
 
<button type="button" onclick="myFunction()">点击这里</button>
</body>
</html>