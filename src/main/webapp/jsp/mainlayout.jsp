<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE HTML>

<html>
<head>
<s:head/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Welcome to use ToolBox</title>
<link href="<%=request.getContextPath()%>/css/layout.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-2.1.4.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/menu.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.lightbox_me.js"></script>
<script type="text/javascript">
function changeGroup(){
	$('#sign_up').lightbox_me({
		centered: true, 
        onLoad: function() { 
            $('#sign_up').find('input:first').focus()
        }
	});
}
function changeConfirm(){
	alert("修改成功!")
}
</script>
</head>

<body>
	<div class="top"></div>
	<div id="header">
		<div class="logo">Tool Box</div>
		<div class="navigation">
			<ul>
				<li>欢迎您！</li>
				<li><s:property value="%{#session.userName}" /></li>
				<li><a href="">修改密码</a></li>
				<li><a href="javascript:changeGroup()">设置组别</a></li>
				<li><a href="">退出</a></li>
			</ul>
		</div>
	</div>
	<div id="content">
		<div class="left_menu">
			<ul id="nav_dot">
				<li>
					<h4 class="M1">
						<span></span>系统工具
					</h4>
					<div class="list-item none">
						<a href=''>分录下载</a> <a href=''>参数下载</a> <a href=''>接口下载</a>
					</div>
				</li>
				<li>
					<h4 class="M2">
						<span></span>分录管理
					</h4>
					<div class="list-item none">
						<a href='../acrl/acrlInit.action'>会计分录</a> 
						<a href='../acrl/iatInit.action'>账号序号(IAT)</a> 
						<a href='javascript:alert("此功能暂未开通!")'>金额设定(AMT)</a>
						<s:a href="../acrl/ovtInit.action">OVT管理</s:a>
						<a href="../acrl/cssInit.action">CSS管理</a>
					</div>
				</li>
				<!--
				<li>
					<h4 class="M3">
						<span></span>基础教学
					</h4>
					<div class="list-item none">
						<a href=''>基础教学1</a> <a href=''>基础教学2</a> <a href=''>基础教学3</a>
					</div>
				</li>
				<li>
					<h4 class="M4">
						<span></span>评论管理
					</h4>
					<div class="list-item none">
						<a href=''>评论管理1</a> <a href=''>评论管理2</a> <a href=''>评论管理3</a>
					</div>
				</li>
				<li>
					<h4 class="M5">
						<span></span>调研问卷
					</h4>
					<div class="list-item none">
						<a href=''>调研问卷1</a> <a href=''>调研问卷2</a> <a href=''>调研问卷3</a>
					</div>
				</li>
				<li>
					<h4 class="M6">
						<span></span>数据统计
					</h4>
					<div class="list-item none">
						<a href=''>数据统计1</a> <a href=''>数据统计2</a> <a href=''>数据统计3</a>
					</div>
				</li>
				<li>
					<h4 class="M7">
						<span></span>奖励管理
					</h4>
					<div class="list-item none">
						<a href=''>奖励管理1</a> <a href=''>奖励管理2</a> <a href=''>奖励管理3</a>
					</div>
				</li>
				<li>
					<h4 class="M8">
						<span></span>字典维护
					</h4>
					<div class="list-item none">
						<a href=''>字典维护1</a> <a href=''>字典维护2</a> <a href=''>字典维护3</a> <a
							href=''>字典维护4</a> <a href=''>字典维护5</a> <a href=''>字典维护6</a> <a
							href=''>字典维护7</a> <a href=''>字典维护8</a> <a href=''>字典维护9</a> <a
							href=''>字典维护4</a> <a href=''>字典维护5</a> <a href=''>字典维护6</a> <a
							href=''>字典维护7</a> <a href=''>字典维护8</a> <a href=''>字典维护9</a>
					</div>
				</li> 	-->
				<li>
					<h4 class="M9">
						<span></span>公共管理
					</h4>
					<div class="list-item none">
						<a href='../common/txInfoInit.action'>交易管理</a>
						<a href=''>组别管理</a> 
					</div>
				</li>
			
				<li>
					<h4 class="M10">
						<span></span>系统管理
					</h4>
					<div class="list-item none">
						<s:a href="../common/user_query.action">用户管理</s:a> 
					</div>
				</li>
			</ul>
		</div>
		<div class="m-right">
			<div class="right-nav">
				<ul>
					<li>
					    <img src="<%=request.getContextPath()%>/images/home.png" style="margin:0px auto;">
					</li>
					<li style="margin-left:25px;">您当前的位置：</li>
					<li><a href="#">系统公告</a></li>
					<li>></li>
					<li><a href="#">最新公告</a></li>
				</ul>
			</div>
			<div class="main">
			    <div class="title">
			           <tiles:insertAttribute name="title"/>
			    </div> 
			    <div style="text-align:center;">
			        <s:actionmessage/>
			        <s:actionerror/>
			    </div> 
			    <tiles:insertAttribute name="main"/>
			</div>
		</div>
	</div>
	<div class="bottom"></div>
	<div id="footer">
		<p>Copyright© 2015 All Rights Reserved</p>
	</div>
	<div id="sign_up">
        <h3>请选择一个组别</h3>
        <div id="sign_up_form">
             <input type="radio" name="txInfo.txTyp" value="K"/>贷款
             <br/>
             <input type="radio" name="txInfo.txTyp" value="K"/>活期存款
            
        </div>
         <div id="actions">
              <a class="close form_button sprited" id="cancel" href="#">取消</a>
              <a class="form_button sprited" id="log_in" href="javascript:changeConfirm()">确定</a>
         </div>
    </div>
	<script>
		navList(12);
	</script>
</body>
</html>
