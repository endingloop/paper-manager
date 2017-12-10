<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
    <%@ page import="java.util.*,model.Paper.*,action.*" %> 
 
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="css/operation1.css">
<script src="js/esl.js"></script>
<title>Paper Manager System</title>

</head>
<body>
	<div class="container">
		<header>
			<s:if test="user == null">
			<a href="<s:url action="index" />" id="index">论文管理器</a> 
			<a href="<s:url action="Login_input" />" id="right">登录</a>
			<a href="<s:url action="Registration_input" />" id="left">注册</a>
			</s:if>
			<s:else>
			<a href="<s:url action="index" />" id="index">论文管理器</a> 
			<a href="<s:url action="Logout" />" id="right">注销</a> 
			<a href="<s:url action='MainMenu' />" id="left">
				<s:property	value="user.username" /></a> 
			</s:else>
		</header>
		<div class="content1" style="background-image: url(images/11.jpg);">

			<ul id="SearchInput" style="margin-left: 34%;">
				<s:form name="form2" action="chooseSearch">
					<li>
						<select name="selectchoice"
							style="width: 7em; margin-left: 0px; margin-bottom: -4.5em;">
							<option value="1">论文主题</option>
							<option value="2">论文题目</option>
							<option value="3">作者姓名</option>
							<option value="4">发表时间</option>
							<option value="5">刊物名称</option>
							<option value="6">论文分类</option>						
						</select>
					</li>
					<li><s:textfield style="width:12em; margin-left: 8em;margin-top:0.6em;"  key="keyword" /></li>
					<li>
						<s:submit class="btn btn-info" value="搜索"
							style="margin-left:22em;margin-top: -5.1em;" />
					</li>
				</s:form>
			</ul>
		</div>
		<div class="content2">
			<div id="content2_center">
				<div class="shownum">
					<span style="color:grey;"><s:property value="#session.authorname" /></span><span>共发表了<s:property value="#session.papernum" />篇论文
					</span>
				</div>
				<table class="table table-hover">
					<tr>
						<td>编号</td>
						<td>标题</td>
						<td>第一作者</td>
						<td>第二作者</td>
						<td>出版社</td>
						<td>发表日期</td>
						<td>关键词</td>
						<td>下载</td>
					</tr>

					 <s:iterator value="#session.list" status="index">
						<tr>
						   
							<td><s:property value="#index.index+1" /></td>
							<td><a
								href="showDetail.action?keyword=<s:property value="paperID"/>&selectchoice=0"><s:property
										value="title" /></a></td>
							<td><a
								href="searchAuthor.action?keyword=<s:property value="author"/>"><s:property
										value="author" /></a></td>
							<td><s:iterator value="secondAuthorList" status="index">
									<a href="searchAuthor.action?keyword=<s:property/>"><s:property /></a>
								</s:iterator></td>
							<td><a
								href="chooseSearch.action?selectchoice=5&keyword=<s:property value="publication"/>"><s:property
										value="publication" /> </a></td>
							<td><a
								href="chooseSearch.action?selectchoice=4&keyword=<s:property value="date"/>"><s:property
										value="date" /></a></td>
							<td><s:iterator value="keywordList" status="index">
									<a href="chooseSearch.action?selectchoice=1&keyword=<s:property/>"><s:property /></a>
								</s:iterator></td>

							<td><a	href="<s:url action="fileDownload"><s:param name="paperID" value="paperID"/></s:url>">下载<span style="color:grey;"><s:property value="clickTime"/></span></a></td>
						 
						</tr>
				</s:iterator>

				</table>
				<a href="fileDownloads.action?tip=2" class="btn btn-info" style="margin-bottom:1%;float:right;">导出为excel表格</a>
 

			</div>
   <div style="margin-top:5%;  margin-bottom:2%;color:grey;font-size:1.2em;"><s:property value="#session.authorname" />的论文关系图：</div>
	<div id="demo1"
		style="height: 600px;  border: 1px solid #ccc; padding: 1px;"></div>
	<script type="text/javascript">
		require.config({

			packages : [ {

				name : 'echarts',

				location : './echarts/src',

				main : 'echarts'

			}, {

				name : 'zrender',

				location : './zrender/src',

				main : 'zrender'

			} ]

		});

		var option = {



			tooltip : {

				trigger : 'item',

				formatter : '{a} : {b}'

			},



			isShowScrollBar : false,

			series : [

			{

				type : 'kforce',

				categories : [

				{

					name : '自己',

					itemStyle : {

						normal : {

							color : '#ff7f50'

						}

					}

				},

				{

					name : '共同创作者',

					itemStyle : {

						normal : {

							color : '#87cdfa'

						}

					}

				},

				{

					name : '共同创作者',

					itemStyle : {

						normal : {

							color : '#87cdfa'							

						},				

					}

				}

				],

				itemStyle : {

					normal : {

						label : {

							show : true,

							textStyle : {

								color : '#000000'

							}

						},

						nodeStyle : {

							brushType : 'both',

							strokeColor : 'rgba(255,215,0,0.4)',

							lineWidth : 2,
							
							shapeType:'ellipse'


						}

					},
					emphasis : {

						linkStyle : {
							strokeColor : '#5182AB'
						}

					}

				},

				minRadius : 15,

				maxRadius : 25,

				density : 0.8,

				attractiveness : 0.8,

				nodes : [
				<% 
				String[] author = (String [])session.getAttribute("author");
				int[] count = (int [])session.getAttribute("count");
				for(int i = 0; i < author.length - 1; i++)
					out.print("{category : "+ (i==0?0:1) + ", name : '" + author[i] + "', value : 1, shapeType:'ellipse', itemStyle:{ normal:{a:40, b:20}}}, ");
				out.print("{category : 1, name : '" + author[author.length - 1] + "', value : 1, shapeType:'ellipse', itemStyle:{ normal:{a:40, b:20}}}");
				%>
				],

				links : [
				<% 
				int i;
				for(i = 0; i < author.length - 1; i++)
					out.print("{source : " + i + " , target : 0, weight : 1"
							+ ", itemStyle:{normal:{text:'"+count[i]+
					"',textColor:'#030303',textFont:'bold 15px verdana',textPosition:'inside'}}}, ");
				out.print("{source : " + i + " , target : 0, weight : 1"
						+ ", itemStyle:{normal:{text:'"+count[i]+
						"',textColor:'#030303',textFont:'bold 15px verdana',textPosition:'inside'}}}");
				%>
				]

			}

			]

		};

		require(

		[

		'echarts',

		'echarts/chart/kforce',

		],

		function(ec) {

			var myChart = ec.init(document.getElementById('demo1'));

			myChart.setOption(option);

		}

		)
	</script>
			
		</div>
		<!--  for  content2 -->


		<footer>
			<br /> <span>Created by Group YST</span> <br /> <br />
		</footer>
	</div>
</body>
</html>