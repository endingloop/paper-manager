<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<link href="css/index-style.css" rel="stylesheet" type="text/css" media="all" />
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html;url=action/index.action;charset=utf-8" />
<meta name="keywords" content="Pixelx  Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--webfont-->
<!--  
<link href='#css?family=Source+Sans+Pro:200,300,400,600,700,900' rel='stylesheet' type='text/css'>
<link href='#css?family=Raleway:400,800,300,100,500,700,600,900' rel='stylesheet' type='text/css'>
-->
<!--animated-css-->
<link href="css/animate.css" rel="stylesheet" type="text/css" media="all">
<script src="js/wow.min.js"></script>
<script src="js/ChooseSort.js"></script>
<link href="css/owl.carousel.css" rel="stylesheet">
<script>
 new WOW().init();
</script>
<!--/animated-css-->
<link href="css/index-style.css" rel="stylesheet" type="text/css" media="all" />
<!--script-->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<!--/script-->
<script type="text/javascript">
			jQuery(document).ready(function($) {
				$(".scroll").click(function(event){		
					event.preventDefault();
					$('html,body').animate({scrollTop:$(this.hash).offset().top},900);
				});
			});
		 
			$(document).ready(function(){  
			    $("#nav li").hover(  
			    function(){  
			        $(this).children('ul').hide();  
			        $(this).children('ul').slideDown('fast');  
			    },  
			    function () {  
			        $('ul', this).slideUp('fast');              
			    });  
			});  
		
</script>
<title>Paper Manager System</title>
</head>
<body>
<s:action name="action/index.action" namespace="/"></s:action>
	<!---->
<div class="banner">
	 <div class="container">
		 <div class="header">	 
			 <div class="logo wow fadeInLeft" data-wow-delay="0.5s">
			 <a href="<s:url action="index" />" style="font-size:2em; color:grey;">论文管理器</a>
			 </div>	
			 <div class="top-menu">
				 <span class="menu"></span> 
				 <ul>
				 	<s:if test="user == null">
						<li><a href="<s:url action="Login_input" />" id="right">登录</a>
						<li><a href="<s:url action="Registration_input" />" id="left">注册</a>
					</s:if>
					<s:else>
						<li><a href="<s:url action='MainMenu' />" id="left">
							<s:property	value="user.username" /></a> 
						<li><a href="<s:url action="Logout" />" id="right">注销</a> 
					</s:else>
				 </ul>
			 </div>
			 <div class="clearfix"></div>
			 <!-- script-for-menu -->
		 <script>					
					$("span.menu").click(function(){
						$(".top-menu ul").slideToggle("slow" , function(){
						});
					});
		 </script>
		 <!-- script-for-menu -->			 
		 </div>
		 <div class="banner-text wow fadeInUp" data-wow-delay="0.5s">
		      <h1>服务于大学校园的<label>论文管理</label>平台</h1>
		 </div> 
		 <div class="banner-form">
			 <s:form name="form2" action="chooseSearch" method="post" enctype="multipart/form-data" theme="simple">
			        <script type="text/javascript" src="http://keleyi.com/keleyi/pmedia/jquery/jquery-1.10.2.min.js"></script>
					<script type="text/javascript">
						$(document).ready(function() {
							$("#kel" + "eyi-com-nav li").hover(function() {
								$(this).children('ul').hide();
								$(this).children('ul').slideDown('fast');
							}, function() {
								$('ul', this).slideUp('fast');
							});
						});
						</script>
						<ul id="keleyi-com-nav" >
						  <li class="wow fadeInLeft" id="firstli">文献全部分类  
	                         <ul>
	                            <s:iterator value="#session.Level1"> 
						            <li ><a href="querySort.action?selectchoice=0&keyword=<s:property/>&page=1"><s:property/></a></li>
						        </s:iterator>
	                         </ul>
						  </li> <!-- info -->
						</ul><!-- keleyi-com-nav end -->
				    <select name=sorttype>
				    <option value="1">最新发布</option>
						<option value="2">人气最高</option>
						
					</select>
					<select name="selectchoice"  class="wow fadeInLeft " data-wow-delay="0.5s" >
						<option value="1">论文主题</option>
						<option value="2">论文题目</option>
						<option value="3">作者姓名</option>
						<option value="4">发表时间</option>
						<option value="5">刊物名称</option>
						<option value="6">论文分类</option>						
					</select>
				<s:textfield class="wow fadeInRight" id="searchtext" data-wow-delay="0.5s" key="keyword" style="margin-top: -30%;margin-left: 2%;" theme="simple"/>
			   <s:submit class="wow fadeInRight" id="searchsubmit" data-wow-delay="0.5s" value="搜索" style="margin-top: -54%;margin-right: -72%;" theme="simple" />
			</s:form>
			 <div class="clearfix"></div>
		 </div>		 
	 </div>
</div>
<div id="pricing" class="pricing">
	 <div class="container">
		 <div class="pricing-text text-center">
			 <h3>Recommendation</h3>
		 </div>
		 <div class="pricing-section">
			 <div class="col-md-4 pricing-grid wow fadeInUp" data-wow-delay="0.5s">
				 <div class="pricing-top text-center">
					 <h3>Hottest Papers</h3>
				 </div>
				 <div class="pricing-offer">
					 <ul>
						<s:iterator value="#session.hotpaper"> 
						  <li class="whyt"><a href="showDetail.action?keyword=<s:property />"><s:property/></a></li>
						</s:iterator>
				     </ul>
				 </div>
			 </div>
			 <div class="col-md-4 pricing-grid wow fadeInDown" data-wow-delay="0.5s">
				 <div class="pricing-top text-center">
					 <h3>Lastest Papers</h3>
				 </div>
				 <div class="pricing-offer">
					 <ul>
						<s:iterator value="#session.lastestpaper"> 
						<li class="whyt"><a href="showDetail.action?keyword=<s:property />"><s:property/></a></li>
						</s:iterator>
				     </ul>
				 </div>
			 </div>
			 <div class="col-md-4 pricing-grid wow fadeInUp" data-wow-delay="0.5s">
				 <div class="pricing-top text-center">
					 <h3>Hottest categories</h3>  
				 </div>
				 <div class="pricing-offer">
					 <ul>
						<s:iterator value="#session.hotsort"> 
						<li class="whyt"><a href="chooseSearch.action?selectchoice=6&keyword=<s:property />"><s:property/></a></li>
						</s:iterator>
				     </ul>
				 </div>
			 </div>
			 <div class="clearfix"></div>
		 </div>
	 </div>
</div>
<div id="screenshots" class="screenshots">
	 <div class="container">
		 <div class="screen-text text-center">
			 <h3>ScreenShots</h3>
		 </div>
							    <script src="js/owl.carousel.js"></script>
							        <script>
							    $(document).ready(function() {
							      $("#owl-demo").owlCarousel({
							        items : 1,
							        lazyLoad : true,
							        autoPlay : true,
							        navigation : false,
							        navigationText :  false,
							        pagination : true,
							      });
							    });
							    </script>
			<!-- //requried-jsfiles-for owl -->
		  <div id="owl-demo" class="owl-carousel">
			  <div class="item text-center guide-sliders">
				 <div class="col-md-3 image-grid">
					 <a href="chooseSearch.action?selectchoice=6&keyword=金融、银行"><img src="images/index1.png"></a>					 
				 </div>
				 <div class="col-md-3 image-grid">
					 <a href="chooseSearch.action?selectchoice=6&keyword=中西医结合基础"><img src="images/index2.jpg"></a>					 
				 </div>
				 <div class="col-md-3 image-grid">
					 <a href="chooseSearch.action?selectchoice=6&keyword=哲学理论"><img src="images/index3.jpg"></a>					 
				 </div>		
				 <div class="col-md-3 image-grid">
					 <a href="chooseSearch.action?selectchoice=6&keyword=战略、战役、战术"><img src="images/index4.jpg"></a>					 
				 </div>			   
			  </div>			  
			  <div class="item text-center guide-sliders">
				 <div class="col-md-3 image-grid">
					 <a href="chooseSearch.action?selectchoice=6&keyword=计算机网络理论"><img src="images/index5.jpg"></a>					 
				 </div>
				 <div class="col-md-3 image-grid">
					 <a href="chooseSearch.action?selectchoice=6&keyword="><img src="images/index6.jpg"></a>					 
				 </div>
				 <div class="col-md-3 image-grid">
					 <a href="chooseSearch.action?selectchoice=6&keyword=摄影艺术"><img src="images/index7.jpg"></a>					 
				 </div>	
				 <div class="col-md-3 image-grid">
					 <a href="chooseSearch.action?selectchoice=6&keyword=书法、篆刻"><img src="images/index8.jpg"></a>					 
				 </div>						
			  </div>
			  <div class="item text-center guide-sliders">
				 <div class="col-md-3 image-grid">
					 <a href="chooseSearch.action?selectchoice=6&keyword=心理学"><img src="images/index9.jpg"></a>					 
				 </div>
				 <div class="col-md-3 image-grid">
					 <a href="chooseSearch.action?selectchoice=6&keyword=天文物理学"><img src="images/index10.jpg"></a>					 
				 </div>
				 <div class="col-md-3 image-grid">
					 <a href="chooseSearch.action?selectchoice=6&keyword=古典数学"><img src="images/index11.jpg"></a>					 
				 </div>		
				 <div class="col-md-3 image-grid">
					 <a href="chooseSearch.action?selectchoice=6&keyword=理论力学"><img src="images/index12.jpg"></a>					 
				 </div>					
			  </div>
			  
		  </div>
	 </div>
</div>


<div class="footer">
	 <div class="container">
		 <div class="ftr-logo">
			 <p class="wow bounceIn" data-wow-delay="0.5s"  style="font-size:1.5em;">Created by YST</p>
		 </div>

	 </div>
</div>
<!---->
<a href="#to-top" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
<!----> 
</body>
</html>

