$(function() {
	$('#cc').combobox({
		url : '/test',
		valueField : 'id',
		textField : 'username',
		onSelect : select
	});
});

function select(record) {
	
	$("#last_week").val("1");
	$("#current_week").val("2");
	$("#problem").val("3");
}

