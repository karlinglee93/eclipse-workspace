/**
 * 遍历table 中radio 的name，并用checked() 方法判断用户是否选中必填项。
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