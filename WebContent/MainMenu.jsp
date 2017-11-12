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
 <a href="<s:url action='addend' />" id="left">用户</a>
 </header>
  <hr>
  <div class="content2">

   <div id="content2_center" >
     <div align="center">
        <h3>我的论文</h3>
        <a href="<s:url action="addpaper"/>">添加论文</a>
    </div>

    <table border="1" width="100%">

        <tr>
            <th align="center" width="30%">
                编号
            </th>
            <th align="center" width="25%">
                题目
            </th>
            <th align="center" width="10%">
                作者
            </th>
            <th align="center" width="10%">
                时间
            </th>
            <th align="center" width="15%">
                操作
            </th>
        </tr>

        <s:iterator value="user.papers">
            <tr>
                <td align="left">
                    <s:property value="paperID"/>
                </td>
                <td align="left">
                    <s:property value="title"/>
                </td>
                <td align="center">
                    <s:property value="author"/>
                </td>
                <td align="center">
                    <s:property value="date"/>
                </td>
                <td align="center">

                    <a href="<s:url action="Paper_delete"><s:param name="paperID" value="paperID"/></s:url>">
                        删除
                    </a>
                    &nbsp;
                     <a href="<s:url action="update"><s:param name="paperID" value="paperID"/></s:url>">
                        修改
                    </a>
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

