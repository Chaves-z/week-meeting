<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<title>周会</title>
		<link href="//cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet"/>
		<script src="//cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
		<script src="//cdn.bootcss.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

		<link rel="stylesheet" type="text/css" href="http://www.jeasyui.net/Public/js/easyui/themes/default/easyui.css"/>
		<link rel="stylesheet" type="text/css" href="http://www.jeasyui.net/Public/js/easyui/themes/icon.css"/>
		<link rel="stylesheet" type="text/css" href="http://www.jeasyui.net/Public/js/easyui/demo/demo.css"/>
		<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.1.min.js"></script>
		<script type="text/javascript" src="http://www.jeasyui.net/Public/js/easyui/jquery.easyui.min.js"></script>
		
		<script type="text/javascript" charset="utf-8" src="/js/mission_type.js"></script>
	  	<script type="text/javascript" charset="utf-8" src="/js/methord.js"></script>
		<script type="text/javascript" charset="utf-8" src="/js/combox.js"></script>
		<script type="text/javascript" charset="utf-8" src="/js/datagrid.js"></script>
		<link type="text/css" rel="stylesheet" href="/css/all.css" />
	</head>

	<body data-spy="scroll" data-target="#myScrollspy">

		<div class="container">
			<div class="jumbotron">
				<h1>周会</h1>
			</div>

			<div class="row">
				<div class="col-xs-3" id="myScrollspy">
					<ul id="leftNavigation" class="nav nav-tabs nav-stacked" data-spy="affix" data-offset-top="125">
						<li class="active">
							<a href="#section-1">上周工作</a>
						</li>
						<li>
							<a href="#section-2">本周计划</a>
						</li>
						<li>
							<a href="#section-3">月计划</a>
						</li>
						<li>
							<a href="#section-4">遗留问题</a>
						</li>

						<li>
							<a ></a>	
						</li>
						<li>
							<input id="cc"  class="easyui-combobox" ></input>
						</li>
						<li>
							<button id="save"type="button" class="btn btn-primary" onclick="save()">保存</button>
						</li>

					</ul>

				</div>
				<div class="col-xs-9">
					<ul class="nav nav-pills nav-justified" id="topNavigation">
					<!-- class="active" -->
						<li >
							<a href="#"><</a>
						</li>
						<li >
							<a href="#" onclick="chooseDate()">周一</a>
						</li>
						<li>
							<a href="#">周二</a>
						</li>
						<li>
							<a href="#">周三</a>
						</li>
						<li>
							<a href="#">周四</a>
						</li>
						<li>
							<a href="#">周五</a>
						</li>
						<li>
							<a href="#">周六</a>
						</li>
						<li>
							<a href="#">周日</a>
						</li>
						<li>
							<a href="#">></a>
						</li>
					</ul>
					<hr/>
					<h2 id="section-1">上周工作</h2>
					<textarea id="last_week"  rows="10" cols="115">
						word wrapping is  a feature that makes life easier for users.
					</textarea>

					<hr/>
					<h2 id="section-2">本周计划</h2>
					<textarea id="current_week" rows="10" cols="115">
						word wrapping is  a feature that makes life easier for users.
					</textarea>

					<hr/>
					<h2 id="section-3">月计划</h2>
					<div style="margin: 10px 0">
						<a class="easyui-linkbutton" onclick="insert()">Insert Row
						</a>
					</div>

					<table id="month_plan"></table>
					<hr/>
					<h2 id="section-4">遗留问题</h2>
					<textarea id="problem" rows="10" cols="115">
						word wrapping is  a feature that makes life easier for users.
					</textarea>
					<hr/>
				</div>
			</div>
		</div>
	</body>

</html>