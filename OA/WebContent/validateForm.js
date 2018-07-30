/**
 * validateForm()
 * 主要用于表单验证
 * 
 * 遍历table中单选项radio的name值，并用checked()方法判断用户在submit时是否做出了选择。
 * 若做出选择，则submit成功；并可通过index.jsp中的action传递参数给servlet层的Receive.java，
 * 否则则发送提示给用户。
 */
function validateForm(){
	var bFlag = false;
	var gender = document.getElementsByName("choose");
	for (var i = 0; i < gender.length; i++) {
		if (gender[i].checked) {
			bFlag = true;
			break;
		}
	}

	if (bFlag == false) {
		alert('定密依据不能为空，请选择！');
		return false;
	}
}