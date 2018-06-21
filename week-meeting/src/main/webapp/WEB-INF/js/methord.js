
function getRowIndex(target){
	var tr = $(target).closest('tr.datagrid-row');
	return parseInt(tr.attr('datagrid-row-index'));
}
function editrow(target) {
	$('#month_plan').datagrid('beginEdit', getRowIndex(target));
}

function deleterow(target) {
	$.messager.confirm('Confirm', 'Are you sure?', function(r) {
		if (r) {
			$('#month_plan').datagrid('deleteRow', getRowIndex(target));
		}
	});
}

function saverow(target) {
	$('#month_plan').datagrid('endEdit', getRowIndex(target));
}

function cancelrow(target) {
	$('#month_plan').datagrid('cancelEdit', getRowIndex(target));
}
var index = 0;

function insert() {
	$('#month_plan').datagrid('appendRow', {});
	$('#month_plan').datagrid('beginEdit', index);
	index++;
}

function save() {
    var param = getSubmitData();
    if (param == ""){
        return;
    } else {
        if(param!=undefined){
        $.ajax({
            type:'post',
            data:(JSON.stringify(param)),
            url:'save',
            success:function(rdata){
                $.messager.alert("成功",rdata.code);
             for(var i=0;i<index;i++){
            	 $('#month_plan').datagrid('beginEdit', i);
             }
            },
            error: function(rdata){
                $.messager.alert("错误","数据传输错误，请重新尝试。");
            }       
        });
    }
    }
}

function getSubmitData(){
    var arr = [];
    var nodes = $('#month_plan').datagrid('getRows');
    if(nodes){
        for(var i=0;i<nodes.length;i++){
        	$('#month_plan').datagrid('endEdit', i);
            var node = nodes[i];
            arr.push(node);
        }
    }
    var lastWeek = $("#last_week").val();
    var currentWeek = $('#current_week').val();
    var problem = $('#problem').val();
   
  
    var sd ={
        userId:1,
        lastWeek:lastWeek,
        currentWeek:currentWeek,
        monthPlan:arr,
        problem:problem
    }
    return sd;
}