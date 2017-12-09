<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="css/operation1.css">
<title>Paper Manager System</title>
</head>
<body>
<div class="container">
 <header>
			<a href="<s:url action="index" />" id="index">论文管理器</a> 
			<a href="<s:url action="Logout" />" id="right">注销</a> 
			<a href="<s:url action='Admin_welcome' />" id="left">
				<s:property	value="user.username" />(管理员)</a> 
 </header>
  <hr>
   <div class="content2" >
  
  <div id="content2_top" >
  <ul class="nav nav-tabs nav-justified">
  <li role="presentation"><a href="<s:url action="Admin_welcome" />">欢迎页面</a></li>
  <li role="presentation"><a href="<s:url action="Admin_audit" />">待审核文章</a></li>
  <li role="presentation" class="active"><a href="Admin_user">用户管理</a></li>
  </ul>
  </div>
<br>
			<div id="content2_center">
				<table class="table table-hover">
					<tr>
						<th align="center" width="20%">用户名</th>
						<th align="center" width="15%">密码</th>
						<th align="center" width="20%">Email</th>
						<th align="center" width="15%">真实姓名</th>
						<th align="center" width="5%">用户状态</th>
						<th align="center" width="30%">操作</th>
					</tr>
					<s:iterator value="userList">
						<tr>
							<td align="left"><s:property value="username" /></td>
							<s:if test="task=='seePassword'+username">
								<td align="left"><s:property value="password" /></td>
							</s:if>
							<s:else>
								<td align="left">*******</td>
							</s:else>
							<td align="center"><s:property value="email" /></td>
							<td align="center"><s:property value="realName" /></td>
							<td align="center">
							<s:if test="authority<0">
		                  <span>冻结</span>
                        </s:if>
						<s:if test="authority>0">
		                  <span>正常</span>
                        </s:if>
                        
							
							</td>
							<td align="center">
							<s:if test="task=='seePassword'+username">
								<a href="<s:url action="Admin_hidePass"><s:param name="username" value="username"/></s:url>">隐藏密码</a>
							</s:if>
							<s:else>
								<a href="<s:url action="Admin_seePass"><s:param name="username" value="username"/></s:url>">查看密码</a>
							</s:else>
								&nbsp; 
							<a href="<s:url action="Admin_deleteUser"><s:param name="username" value="username"/></s:url>">冻结用户</a>
								&nbsp; 
							
							<a href="<s:url action="Admin_addAdmin"><s:param name="username" value="username"/></s:url>">设为管理员</a>
							</td>
						</tr>
					</s:iterator>
				</table>
			</div>
		</div>   <!--  for  content2 -->

<footer>
<br/>
<span>Created by Group YST</span>
<br/>
<br/>
</footer>
</div>
</body>
</html>

