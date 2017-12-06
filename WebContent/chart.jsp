<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<title>HTML5制作动态人物关系结构图</title>

<script src="js/esl.js"></script>

</head>

<body>

	<div id="demo1"
		style="height: 800px; border: 1px solid #ccc; padding: 1px;"></div>

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

			title : {

				text : '人物关系：乔布斯',

				subtext : '数据来自人立方',

				x : 'right',

				y : 'bottom'

			},

			tooltip : {

				trigger : 'item',

				formatter : '{a} : {b}'

			},

			legend : {

				x : 'left',

				selected : {
					'朋友' : true,
					'家人' : true
				},

				data : [ '家人', '朋友' ]

			},

			isShowScrollBar : false,

			series : [

			{

				type : 'kforce',

				categories : [

				{

					name : '人物',

					itemStyle : {

						normal : {

							color : '#ff7f50'

						}

					}

				},

				{

					name : '家人',

					itemStyle : {

						normal : {

							color : '#ff7f50'

						}

					}

				},

				{

					name : '朋友',

					itemStyle : {

						normal : {

							color : '#87cdfa'

						}

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

							lineWidth : 2

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
				for(int i = 0; i < author.length - 1; i++)
					out.print("{category : 2, name : '" + author[i] + "', value : 1}, ");
				out.print("{category : 2, name : '" + author[author.length - 1] + "', value : 1}");
				%>
				],

				links : [
				<% 
				int i;
				for(i = 1; i < author.length - 1; i++)
					out.print("{source : " + i + " , target : 0, weight : 1}, ");
				out.print("{source : " + i + " , target : 0, weight : 1}");
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

</body>

</html>