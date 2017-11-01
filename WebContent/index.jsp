<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<!--  <meta name="viewport" content="width=device-width, initial-scale=1"/> -->
<script src="js/jquery-3.2.1.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/bootstrap.css">
<title>Paper Manager System</title>
</head>
<body>
<header>
<a href="index.jsp" id="index">论文管理器</a>
<a href="#" id="right">登录</a>
<a href="#" id="left">注册</a>
</header>
<div id="container" style="background-image:url(img/11.png);">
<div>

<br>
</div>
<div id="WebDecription">
<span>服务于大学校园的论文管理平台</span>
</div>
<div id="SearchMenu">
<ul class="nav nav-tabs nav-justified "  >
 <li role="presentation" class="active"><a href="#">文献主题</a></li>
 <li role="presentation"><a href="#">论文名称</a></li>
 <li role="presentation"><a href="#">作者姓名</a></li>
 <li role="presentation"><a href="#">刊物名称</a></li>
 <li role="presentation"><a href="#">发表时间</a></li>
 <li role="presentation"><a href="#">文献类别</a></li>
</ul>
</div>
<div class="input-group" id="SearchInput"> 
  <input type="text" class="form-control" id="Search1" aria-describedby="basic-addon1">
  <span class="input-group-addon " id="basic-addon1"><a href="#">Search</a></span>
</div>
</div>

<div class="content1" >
  <br>
  <span>热点</span><small>  |  HotSpot</small>
  <hr>


   <div id="content2" >

   <ul>
    <li><a href="#" target="_blank">| 人性展现与环境奠基--巴尔扎克笔下环境的描写意义</a></li>
    <li><a href="#" target="_blank">| 红色荧光体增强型硅基光电二极管的频谱响应研究</a></li>
    <li><a href="#" target="_blank">| 1ZL5型马铃薯中耕机的设计与试验</a></li>
    <li><a href="#" target="_blank">| 触土曲面准线曲率特征及其减阻性能分析</a></li>
    <li><a href="#" target="_blank">| 星形齿刀防堵式小麦免耕播种机设计与试验</a></li>
    <li><a href="#" target="_blank">| 美国利用公开情报的新进展及我国的对策</a></li>
  </ul>

 
  <ul>
    <li><a href="#" target="_blank">| 人性展现与环境奠基--巴尔扎克笔下环境的描写意义</a></li>
    <li><a href="#" target="_blank">| 红色荧光体增强型硅基光电二极管的频谱响应研究</a></li>
    <li><a href="#" target="_blank">| 1ZL5型马铃薯中耕机的设计与试验</a></li>
    <li><a href="#" target="_blank">| 触土曲面准线曲率特征及其减阻性能分析</a></li>
    <li><a href="#" target="_blank">| 星形齿刀防堵式小麦免耕播种机设计与试验</a></li>
    <li><a href="#" target="_blank">| 美国利用公开情报的新进展及我国的对策</a></li>
  </ul>

  </div>
 </div>
<div class="content1" >
  <span>推荐</span><small>  |  Recommendation</small>
  <hr>
<div id="content3" >
    <div class="thumbnail">
      <img src="img/c1.jpg" alt="c1">
      <div class="caption">
        <h4>Antroid软件开发</h4>
        <p>Android早期由“Android之父”之称的Andy Rubin创办，Google于2005年并购了成立仅22个月的高科技企业Android</p>
        <a href="#">Know more >></a>
      </div>
    </div>
    
      <div class="thumbnail">
      <img src="img/c2.jpg" alt="c2">
      <div class="caption">
        <h4>Antroid软件开发</h4>
        <p>Android早期由“Android之父”之称的Andy Rubin创办，Google于2005年并购了成立仅22个月的高科技企业Android</p>
        <a href="#">Know more >></a>
      </div>
    </div>
    
      <div class="thumbnail">
      <img src="img/c3.jpg" alt="c3">
      <div class="caption">
        <h4>Antroid软件开发</h4>
        <p>Android早期由“Android之父”之称的Andy Rubin创办，Google于2005年并购了成立仅22个月的高科技企业Android</p>
        <a href="#">Know more >></a>
      </div>
    </div>
    <div class="thumbnail">
      <img src="img/c4.jpg" alt="c4">
      <div class="caption">
        <h4>Antroid软件开发</h4>
        <p>Android早期由“Android之父”之称的Andy Rubin创办，Google于2005年并购了成立仅22个月的高科技企业Android</p>
        <a href="#">Know more >></a>
      </div>
    </div>
 </div>
  </div>
<footer>
<br/>
<span>Created by Group YST</span>
<br/>
<br/>
</footer>

</body>
</html>

