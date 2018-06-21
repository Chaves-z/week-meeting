$(function() {

	window.onload = function() {
		var ul = document.getElementById("topNavigation")
		var li = ul.getElementsByTagName("li")
		for (i = 0; i < li.length; i++) {

			li[i].onclick = function() {
				for (j = 0; j < li.length; j++) {
					li[j].className = ""
				}
				this.className = "active"
			}
		}
	}
	$('#cc').combobox({
		url : '/getUsers',
		valueField : 'id',
		textField : 'username',
		onSelect : select
	});
	// $.messager.alert(getCookie("TT_TOKEN"));
	$('#cc').combobox('setValue', getCookie("TT_TOKEN"));

});

function select(record) {
	document.getElementsByClassName("active");
	var userId = $('#cc').combobox('getValue');
	$("#last_week").val(userId);
	$("#current_week").val("2");
	$("#problem").val("3");
}

function getCookie(name) {
	var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
	if (arr = document.cookie.match(reg))
		return unescape(arr[2]);
	else
		return null;
}