/**
 * 在form 中添加div 标签，
 * 通过JS 判断选取的level 值定位div 的id
 * 将此JS 中字符串中的HTML内容放在div 标签中，用于显示在HTML 页面上
 */
var context="<table border=1><tr><th>单选</th><th>定密依据</th><th>秘密等级</th><th>保密期限</th><th>悉知范围</th></tr>"
	context+="<tr><td><input type='radio' name='choose' value='1'></td><td>全国药用罂粟的年度生产计划及相关数据</td><td>150</td><td>长期</td><td>有关领导、相关部门及承办人员</td></tr>	"
	context+="<tr><td><input type='radio' name='choose' value='2'></td><td>全国麻醉药品特需计划及相关数据</td><td>150</td><td>长期</td><td>有关领导、相关部门及承办人员</td></tr>"
	context+="<tr><td><input type='radio' name='choose' value='3'></td><td>涉及食品药品监管工作重大改革的内部考虑、对策建议等</td><td>150</td><td>20年</td><td>有关领导、相关部门及承办人员</td></tr>"
	context+="<tr><td><input type='radio' name='choose' value='4'></td><td>食品药品研制、生产中涉及产业整体安全和国家重大利益的科学技术</td><td>150</td><td>长期</td><td>有关企业、单位相关人员，监管部门相关领导及承办人</td></tr></table>"
	context+="<button type='submit'>提交";
var context1="<table border=1 ><tr><th>单选</th><th>定密依据</th><th>秘密等级</th><th>保密期限</th><th>悉知范围</th></tr>"
	context1+="<tr><td><input type='radio' name='choose' value='5'></td><td>全国药用罂粟的年度生产计划及相关数据</td><td>180</td><td>长期</td><td>有关领导、相关部门及承办人员</td></tr>	"
	context1+="<tr><td><input type='radio' name='choose' value='6'></td><td>全国麻醉药品特需计划及相关数据</td><td>180</td><td>长期</td><td>有关领导、相关部门及承办人员</td></tr>"
	context1+="<tr><td><input type='radio' name='choose' value='7'></td><td>涉及食品药品监管工作重大改革的内部考虑、对策建议等</td><td>180</td><td>20年</td><td>有关领导、相关部门及承办人员</td></tr>"
	context1+="<tr><td><input type='radio' name='choose' value='8'></td><td>食品药品研制、生产中涉及产业整体安全和国家重大利益的科学技术</td><td>180</td><td>长期</td><td>有关企业、单位相关人员，监管部门相关领导及承办人</td></tr></table>"
	context1+="<button type='submit'>提交";
	
function showbasises(){
	var v;
	v=document.getElementById("level").value;
	if(v==150){
		document.getElementById("table_context").innerHTML = context;
	}else if(v==180){
		document.getElementById("table_context").innerHTML = context1;
	}
}