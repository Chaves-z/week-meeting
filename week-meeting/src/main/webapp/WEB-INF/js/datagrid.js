$(function() {
	$('#month_plan').datagrid({
		iconCls : 'icon-edit',
		width : 850,
		singleSelect : true,
		idField : 'itemid',
		url : '',
		columns : [ [ {
			field : 'userid',
			hidden : true
		}, {
			field : 'date',
			hidden : true
		}, {
			field : 'projectname',
			title : '项目名',
			width : 205,
			align : 'center',
			editor : 'text'
		}, {
			field : 'messioncontent',
			title : '任务内容',
			align : 'center',
			width : 240,
			editor : 'text'
		}, {
			field : 'messionstate',
			title : '任务状态',
			align : 'center',
			width : 80,
			formatter : function(value) {
				for (var i = 0; i < products.length; i++) {
					if (products[i].productid == value)
						return products[i].name;
				}
				return value;
			},
			editor : {
				type : 'combobox',
				options : {
					valueField : 'productid',
					textField : 'name',
					data : products,
					required : false
				}
			}
		}, {
			field : 'messionprogress',
			title : '任务进度',
			align : 'center',
			width : 80,
			editor : 'text'
		}, {
			field : 'deadline',
			title : '时间节点',
			align : 'center',
			width : 80,
			editor : 'text'
		}, {
			field : 'accomplishtime',
			title : '实际完成时间',
			align : 'center',
			width : 80,
			editor : 'text'
		},
		{field:'action',title:'Action',width:80,align:'center',
			formatter:function(value,row,index){
					var d = '<a href="#" onclick="deleterow(this)">Delete</a>';
					return d;
			}
		}

		] ],
		onBeforeEdit : function(index, row) {
			row.editing = true;
			updateActions(index);
		},
		onAfterEdit : function(index, row) {
			row.editing = false;
			updateActions(index);
		},
		onCancelEdit : function(index, row) {
			row.editing = false;
			updateActions(index);
		}
	});
});
function updateActions(index) {
	$('#month_plan').datagrid('updateRow', {
		index : index,
		row : {}
	});
}