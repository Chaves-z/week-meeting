$(function() {
	$('#month_plan').datagrid({
		iconCls : 'icon-edit',
		width : 850,
		singleSelect : true,
		idField : 'itemid',
		url : '',
		columns : [ [ {
			field : 'itemid',
			title : '项目名',
			width : 260,
			align : 'center',
			editor : 'text'
		}, {
			field : 'itemid',
			title : '任务内容',
			align : 'center',
			width : 260,
			editor : 'text'
		}, {
			field : 'productid',
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
			field : 'listprice',
			title : '任务进度',
			align : 'center',
			width : 80,
			editor : 'text'
		}, {
			field : 'unitcost',
			title : '时间节点',
			align : 'center',
			width : 80,
			editor : 'text'
		}, {
			field : 'attr1',
			title : '实际完成时间',
			align : 'center',
			width : 80,
			editor : 'text'
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
	$('#tt').datagrid('updateRow', {
		index : index,
		row : {}
	});
}