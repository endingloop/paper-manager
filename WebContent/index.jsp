
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
<script src="jqueryUI/js/jquery-ui-1.9.2.custom.min.js"></script>
  <script>
  </script>
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="jqueryUI/css/custom-theme/jquery-ui-1.10.0.custom.css">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/bootstrap.css">
<title>Paper Manager System</title>
</head>
<body>
<header>
<a href="<s:url action="index" />" id="index">论文管理器</a>
<a href="<s:url action="Login_input" />" id="right">登录</a>
<a href="<s:url action="Registration_input" />" id="left">注册</a>
</header>
<div id="container" style="background-image:url(img/11.png);">
<div>

<br>
</div>
<div id="WebDecription">
<span>服务于大学校园的论文管理平台</span>
</div>
<div id="SearchMenu">
<ul class="nav">  
        <li>  
            <a href="${pageContext.request.contextPath }/sort1.action?firstID=1"  target="_blank">  基础学科</a>  
            <ul>  
                <li><a href="${pageContext.request.contextPath }/sort2.action?secondID=1"  target="_blank"> 地质学</a>  
                    <ul>  
<li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=1">岩石学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=2">矿物学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=3">古生物学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=4">动力地质学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=5">地质力学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=6">构造地质学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=7">宇宙地质学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=8">环境地质学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=9">海洋地质学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=10">地球化学</a></li>
 </ul>  
                </li>  
                <li><a href="${pageContext.request.contextPath }/sort2.action?secondID=2"  target="_blank"> 数学</a>  
                    <ul>  
<li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=11">数学概论</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=12">古典数学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=13">数理逻辑</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=14">数学分析</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=15">初、高等数学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=16">金融数学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=17">代数、数论</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=18">应用数学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=19">计算数学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=20">运筹学</a></li>
                    </ul>  
                </li>  
                <li><a href="${pageContext.request.contextPath }/sort2.action?secondID=3"  target="_blank"> 资源科学</a>  
                    <ul>  
<li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=21">资源管理与利用</a></li>
<li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=22">各种资源的开发与利用</a></li>
                    </ul>  
                </li>  
                <li><a href="${pageContext.request.contextPath }/sort2.action?secondID=4"  target="_blank"> 力学</a>
                    <ul>  
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=23">力学概论</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=24">理论力学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=25">固体力学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=26">流体力学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=27">爆炸力学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=28">振动理论</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=29">流变学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=30">应用力学</a></li>  
                    </ul>  
                </li>  
                <li><a href="${pageContext.request.contextPath }/sort2.action?secondID=5"  target="_blank"> 物理学</a>
                    <ul>  
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=31">声学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=32">光学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=33">电磁学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=34">热学与热分子运动论</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=35">固体物理学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=36">半导体物理学</a></li>  
                    </ul>  
                </li>  
                <li><a href="${pageContext.request.contextPath }/sort2.action?secondID=6"  target="_blank"> 生物学</a>
  
                    <ul>  
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=37">植物学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=38">动物学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=39">昆虫学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=40">人类学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=41">生物工程学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=42">生理学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=43">遗传学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=44">细胞学</a></li> 
                    </ul>  
                </li>
                 <li><a href="${pageContext.request.contextPath }/sort2.action?secondID=7"  target="_blank"> 天文学</a>

  
                    <ul>  
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=45">天体测量学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=46">射电天文学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=47">天体力学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=48">天体物理学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=49">太阳系</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=50">空间天文学</a></li>
                    </ul>  
                </li>  
                 <li><a href="${pageContext.request.contextPath }/sort2.action?secondID=8"  target="_blank"> 地理学</a>

  
                    <ul>  
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=51">地貌学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=52">土壤学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=53">应用及分类地理学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=54">一般理论与方法</a></li> 
                    </ul>  
                </li>  
                 <li><a href="${pageContext.request.contextPath }/sort2.action?secondID=9"  target="_blank"> 气象学</a>

  
                    <ul>  
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=55">气候学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=56">动力气象学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=57">应用气象学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=58">气象灾难学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=59">大气勘测</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=60">气象基础学科</a></li>  
                    </ul>  
                </li>  
                 <li><a href="${pageContext.request.contextPath }/sort2.action?secondID=10"  target="_blank"> 海洋学</a>

  
                    <ul>  
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=61">区域海洋学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=62">海洋气象学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=63">海洋水文学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=64">海洋化学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=65">海洋物理学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=66">海洋工程</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=67">海洋灾害</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=68">海洋生物学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=69">海洋学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=70">海洋资源与开发</a></li> 
                    </ul>  
                </li>    
            </ul>  
        </li>  
         <li>  
            <a href="${pageContext.request.contextPath }/sort1.action?firstID=2" target="_blank">  工程科技</a>  
            <ul>  
            <li><a href="${pageContext.request.contextPath }/sort2.action?secondID=11"  target="_blank"> 化学</a><ul>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=71">有机化学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=72">无机化学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=73">高分子化学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=74">物理化学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=75">分析化学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=76">应用化学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=77">晶体学</a></li>
</ul></li>
<li><a href="${pageContext.request.contextPath }/sort2.action?secondID=12"  target="_blank"> 材料科学</a><ul>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=78">金属材料</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=79">非金属材料</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=80">复合材料</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=81">功能材料</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=82">仿生材料</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=83">超导材料</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=84">耐高温、低温材料</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=85">耐腐蚀材料</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=86">智能材料</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=87">特种结构材料</a></li>
</ul></li>
<li><a href="${pageContext.request.contextPath }/sort2.action?secondID=13"  target="_blank"> 矿业工程</a><ul>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=88">矿山开采工程学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=89">矿测量与勘测工程学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=90">矿山安全与劳动保护</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=91">矿山电工</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=92">矿山运输与设备</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=93">选矿</a></li>
</ul></li>
<li><a href="${pageContext.request.contextPath }/sort2.action?secondID=14"  target="_blank"> 一般服务业</a><ul>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=94">美食学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=95">居住管理</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=96">烹饪法</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=97">洗染、缝补</a></li>
</ul></li>
<li><a href="${pageContext.request.contextPath }/sort2.action?secondID=15"  target="_blank"> 机械工业</a><ul>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=98">机械学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=99">机械制造工业</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=100">起重机械与运输机械</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=101">机械工厂</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=102">气体压缩与运输机械</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=103">机械零件及其传动装置</a></li>
</ul></li>
<li><a href="${pageContext.request.contextPath }/sort2.action?secondID=16"  target="_blank"> 汽车工业</a><ul>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=104">汽车结构部件</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=105">汽车驾驶与使用</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=106">汽车保养与修理</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=107">汽车制造厂</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=108">汽车发动机</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=109">汽车理论</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=110">汽车制造工艺</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=112">汽车试验</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=113">汽车材料</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=114">汽车工业经济</a></li>
</ul></li>
<li><a href="${pageContext.request.contextPath }/sort2.action?secondID=17"  target="_blank"> 铁路运输</a><ul>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=115">铁路运输经济</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=116">电气化铁路</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=117">特种铁路</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=118">机车工程</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=119">车辆工程</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=120">铁路通信、信号</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=121">铁路运输管理工程</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=122">环境地质学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=123">海洋地质学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=124">地球化学</a></li>
</ul></li>
<li><a href="${pageContext.request.contextPath }/sort2.action?secondID=18"  target="_blank"> 船舶工业</a><ul>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=125">船舶原理</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=126">船舶材料</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=127">船舶机械</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=128">船舶建造工艺</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=129">船舶结构</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=130">船舶驾驶、航海学</a></li>
</ul></li>
<li><a href="${pageContext.request.contextPath }/sort2.action?secondID=19"  target="_blank"> 动力工程</a><ul>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=131">热力工程、热机</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=132">内燃机</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=133">水能</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=134">蒸汽动力工程</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=135">动力工业经济</a></li>
</ul></li>
<li><a href="${pageContext.request.contextPath }/sort2.action?secondID=20"  target="_blank"> 核科学技术</a><ul>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=136">加速器</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=137">原子能技术经济</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=138">核反应堆工程，核电厂</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=139">辐射防护</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=140">核爆炸，放射性物质</a></li>
</ul></li>
             </ul>   
        </li>  
        <li><a href="${pageContext.request.contextPath }/sort1.action?firstID=3">农业科技</a>  
            <ul>  
<li><a href="${pageContext.request.contextPath }/sort2.action?secondID=21"  target="_blank"> 林业</a><ul>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=141">林业基础科学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=142">绿化建设</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=143">森林工程</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=144">森林树种</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=145">森林计测学</a></li>
</ul></li>
<li><a href="${pageContext.request.contextPath }/sort2.action?secondID=22"  target="_blank"> 园艺</a><ul>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=146">设施园艺</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=147">蔬菜园艺</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=148">瓜果园艺</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=149">果树园艺</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=150">观赏园艺</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=151">病虫害及其防治</a></li>
</ul></li>
<li><a href="${pageContext.request.contextPath }/sort2.action?secondID=23"  target="_blank"> 农作物</a><ul>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=152">禾谷类作物</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=153">豆类作物</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=154">经济作物</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=155">绿肥作物</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=156">饲料作物、牧草</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=157">野生植物及其他</a></li>
</ul></li>
<li><a href="${pageContext.request.contextPath }/sort2.action?secondID=24"  target="_blank"> 农业工程</a><ul>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=158">农业机械及农具</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=159">农田水利及水污染防治</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=160">农业建筑</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=161">农业动力、农村能源</a></li>
</ul></li>
<li><a href="${pageContext.request.contextPath }/sort2.action?secondID=25"  target="_blank"> 水产和渔业</a><ul>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=162">水产经济</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=163">渔捞</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=164">水产养殖技术</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=165">水产保护学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=166">水产工程</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=167">水产物运输、存储保鲜</a></li>
</ul></li>
<li><a href="${pageContext.request.contextPath }/sort2.action?secondID=26"  target="_blank"> 畜牧与动物医学</a><ul>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=168">普通畜牧学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=169">家畜</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=160">家禽</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=171">兽医学</a></li>
</ul></li>
            </ul>  
        </li>  
        <li>
        <a href="${pageContext.request.contextPath }/sort1.action?firstID=4"  target="_blank"> 医药卫生科技</a>  
            <ul>  
<li><a href="${pageContext.request.contextPath }/sort2.action?secondID=27"  target="_blank"> 医药方针法规研究</a><ul>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=172">卫生事业总论</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=173">医疗保险</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=174">医药、卫生政策法规</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=175">医疗服务、制度及改革</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=176">医疗与法</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=177">医疗器械</a></li>
</ul></li>
<li><a href="${pageContext.request.contextPath }/sort2.action?secondID=28"  target="_blank"> 中医学</a><ul>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=178">中国医学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=179">中医基础理论</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=180">中医临床学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=181">中医内科</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=182">中医外科</a></li>
</ul></li>
<li><a href="${pageContext.request.contextPath }/sort2.action?secondID=29"  target="_blank"> 中药学</a><ul>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=183">本草</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=184">中药材</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=185">中药药理学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=186">中药炮制、制剂</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=187">中药化学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=188">中药药事组织</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=189">方剂学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=190">其他各国生药学</a></li>
</ul></li>
<li><a href="${pageContext.request.contextPath }/sort2.action?secondID=30"  target="_blank"> 中西医结合</a><ul>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=191">中西医结合基础</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=192">中西医结合临床</a></li>
</ul></li>                    
            </ul>  
        </li>  
        <li>  
            <li><a href="${pageContext.request.contextPath }/sort1.action?firstID=5" >哲学与人文科学</a>
            <ul>
 <li><a href="${pageContext.request.contextPath }/sort2.action?secondID=31"  target="_blank"> 中国文学</a><ul>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=193">小说</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=194">散文</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=195">诗歌、韵文</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=196">儿童文学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=197">戏剧文学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=198">报告文学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=199">少数民族文学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=200">文学评论和研究</a></li>
</ul></li>
<li><a href="${pageContext.request.contextPath }/sort2.action?secondID=32"  target="_blank"> 音乐舞蹈</a><ul>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=201">音乐</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=202">舞蹈</a></li>
</ul></li>
<li><a href="${pageContext.request.contextPath }/sort2.action?secondID=33"  target="_blank"> 书法雕塑</a><ul>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=203">绘画</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=204">书法、篆刻</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=205">雕塑</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=206">摄影艺术</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=207">工艺美术</a></li>
</ul></li>
<li><a href="${pageContext.request.contextPath }/sort2.action?secondID=34"  target="_blank"> 影视戏曲艺术</a><ul>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=208">戏剧艺术</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=209">电影艺术</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=210">电视艺术</a></li>
</ul></li>
<li><a href="${pageContext.request.contextPath }/sort2.action?secondID=35"  target="_blank"> 中国古代史</a><ul>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=211">原始社会</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=212">奴隶社会</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=213">封建社会</a></li>
</ul></li>
<li><a href="${pageContext.request.contextPath }/sort2.action?secondID=36"  target="_blank"> 中国近现代史</a><ul>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=214">半封建半殖民地社会</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=215">中华人民共和国史</a></li>
</ul></li>
<li><a href="${pageContext.request.contextPath }/sort2.action?secondID=37"  target="_blank"> 考古</a><ul>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=216">考古学理论与方法</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=217">世界考古</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=218">中国考古</a></li>
</ul></li>
<li><a href="${pageContext.request.contextPath }/sort2.action?secondID=38"  target="_blank"> 哲学</a><ul>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=219">哲学理论</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=220">世界哲学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=221">中国哲学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=222">思维科学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=223">自然辨证发</a></li>
</ul></li>
<li><a href="${pageContext.request.contextPath }/sort2.action?secondID=39"  target="_blank"> 心理学</a><ul>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=224">心理学</a></li>
</ul></li>
<li><a href="${pageContext.request.contextPath }/sort2.action?secondID=40"  target="_blank"> 宗教</a><ul>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=225">综合</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=226">佛教</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=227">道教</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=228">伊斯兰教</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=229">基督教</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=220">天主教</a></li>
</ul></li>           
            </ul>  
        </li>  
        <li><a href="${pageContext.request.contextPath }/sort1.action?firstID=6" >社会科学</a>  
            <ul>  
<li><a href="${pageContext.request.contextPath }/sort2.action?secondID=41"  target="_blank"> 马克思主义</a><ul>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=231">马克思、恩格斯、列宁、毛泽东等著作</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=232">马克思、恩格斯、列宁、毛泽东等生平传记</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=233">马原、毛概、邓理、列宁主义的学习和研究</a></li>
</ul></li>
<li><a href="${pageContext.request.contextPath }/sort2.action?secondID=42"  target="_blank"> 中国共产党</a><ul>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=234">建党理论、党章</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=235">党的组织、会议、文献</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=236">党的总路线和总政策</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=237">党的建设</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=238">党的领导</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=239">中国共产党与各国共产党的关系</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=240">中国共产主义青年团</a></li>
</ul></li>
<li><a href="${pageContext.request.contextPath }/sort2.action?secondID=43"  target="_blank"> 思想政治教育</a><ul>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=241">思想政治教育与精神文明建设</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=242">革命传统教育</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=243">形式教育，国情教育</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=244">道德教育</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=245">国际主义，爱国主义教育</a></li>
</ul></li>
<li><a href="${pageContext.request.contextPath }/sort2.action?secondID=44"  target="_blank"> 军事</a><ul>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=246">军事理论与军史</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=247">军事组织与管理</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=248">战略、战役、战术</a></li>
</ul></li>
<li><a href="${pageContext.request.contextPath }/sort2.action?secondID=45"  target="_blank"> 宪法</a><ul>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=249">国家法、宪法</a></li>
</ul></li>
<li><a href="${pageContext.request.contextPath }/sort2.action?secondID=46"  target="_blank"> 国际法</a><ul>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=250">国际法理论</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=251">国际经济法</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=252">国际私法</a></li>
</ul></li>
<li><a href="${pageContext.request.contextPath }/sort2.action?secondID=47"  target="_blank"> 民族学</a><ul>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=253">民族法</a></li>
</ul></li>
<li><a href="${pageContext.request.contextPath }/sort2.action?secondID=48"  target="_blank"> 学前教育</a><ul>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=254">幼教理论</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=255">思想品德教育</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=256">幼儿教学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=257">学校管理</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=258">世界各国幼教概况</a></li>
</ul></li>
<li><a href="${pageContext.request.contextPath }/sort2.action?secondID=49"  target="_blank"> 初等教育</a>
<ul>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=259">教学理论与教学方法</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=260">教材、课本、辅助教材、参考书</a></li>
</ul>
</li>
<li><a href="${pageContext.request.contextPath }/sort2.action?secondID=50"  target="_blank"> 高等教育</a><ul>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=261">研究生教育</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=262">各类型高等学校</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=263">高等教育理论</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=264">教学理论、教学方法</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=265">思想政治教育、德育</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=266">科学研究工作</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=267">教师与学生</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=268">中国及地方高等教育</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=269">世界各国教育</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=270">师范教育</a></li>
</ul></li>               
            </ul>  
        </li>   
        <li>  
            <a href="${pageContext.request.contextPath }/sort1.action?firstID=7">信息科学</a>  
            <ul>  
<li><a href="${pageContext.request.contextPath }/sort2.action?secondID=51"  target="_blank"> 无线电电子学</a><ul class="nav1">
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=271">电子工业</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=272">真空电子技术</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=273">光电子技术、激光技术</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=274">半导体技术</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=275">电子元件、组件</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=276">基本电子电路</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=277">微电子学，集成电路</a></li>
</ul></li>
<li><a href="${pageContext.request.contextPath }/sort2.action?secondID=52"  target="_blank"> 计算机硬件技术</a><ul class="nav1">
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=278">电子计算机</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=279">微信计算机</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=280">其他计算机</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=281">一般性问题</a></li>
</ul></li>
<li><a href="${pageContext.request.contextPath }/sort2.action?secondID=53"  target="_blank"> 自动化技术</a><ul class="nav1">
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=282">自动化基础理论</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=283">自动化技术及设备</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=284">射流技术（流控技术）</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=285">遥感技术</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=286">远动技术</a></li>
</ul></li>
<li><a href="${pageContext.request.contextPath }/sort2.action?secondID=54"  target="_blank"> 新闻与传媒</a><ul class="nav1">
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=287">信息与传播理论</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=288">新闻学、新闻事业</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=289">广播电视</a></li>
</ul></li>
<li><a href="${pageContext.request.contextPath }/sort2.action?secondID=55"  target="_blank"> 数字情报与数字图书馆</a><ul class="nav1">
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=290">图书馆学、图书馆事业</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=291">情报学、情报工作</a></li>
</ul></li>
<li><a href="${pageContext.request.contextPath }/sort2.action?secondID=56"  target="_blank"> 档案及博物馆</a><ul class="nav1">
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=292">档案学、档案事业</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=293">博物馆学、博物馆事业</a></li>
</ul></li>
<li><a href="${pageContext.request.contextPath }/sort2.action?secondID=57"  target="_blank"> 互联网技术</a><ul class="nav1">
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=294">计算机网络理论</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=295">网络结构与设计</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=296">通信协议</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=297">通信设备与线路</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=298">网络管理与运行</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=299">网络安全</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=300">网络应用程序</a></li>
</ul></li>               
            </ul>  
        </li>  
         <li>  
            <a href="${pageContext.request.contextPath }/sort1.action?firstID=8">经济与管理学科</a>  
            <ul>  
             <li><a href="${pageContext.request.contextPath }/sort2.action?secondID=58"  target="_blank"> 农业经济</a><ul class="nav1">
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=301">农业经济理论</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=302">世界农业经济</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=303">中国农业经济</a></li>
</ul></li>
<li><a href="${pageContext.request.contextPath }/sort2.action?secondID=59"  target="_blank"> 经济理论及经济思想史</a><ul class="nav1">
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=304">经济概论</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=305">社会生产方式</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=306">经济学分支科学及各科经济学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=307">经济思想史</a></li>
</ul></li>
<li><a href="${pageContext.request.contextPath }/sort2.action?secondID=60"  target="_blank"> 经济体制改革</a><ul class="nav1">
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=308">世界经济</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=309">中国经济</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=310">其他各国经济</a></li>
</ul></li>
<li><a href="${pageContext.request.contextPath }/sort2.action?secondID=61"  target="_blank"> 经济统计</a><ul class="nav1">
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=311">经济统计概述</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=312">经济统计方法</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=313">专门经济统计</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=314">国籍经济统计</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=315">经济统计组织与工作</a></li>
</ul></li>
<li><a href="${pageContext.request.contextPath }/sort2.action?secondID=62"  target="_blank"> 工业经济</a><ul class="nav1">
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=316">工业经济理论</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=317">世界工业经济</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=318">中国工业经济</a></li>
</ul></li>
<li><a href="${pageContext.request.contextPath }/sort2.action?secondID=63"  target="_blank"> 交通运输经济</a><ul class="nav1">
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=319">铁路运输经济</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=320">陆路、公路运输经济</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=321">水路运输经济</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=322">航空运输经济</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=323">城市交通运输经济</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=324">交通运输经济理论及概况</a></li>
</ul></li>
<li><a href="${pageContext.request.contextPath }/sort2.action?secondID=64"  target="_blank"> 旅游</a><ul class="nav1">
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=325">旅游经济理论与方法</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=326">旅游事业</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=327">旅游资源</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=328">旅游文化</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=329">旅游与商业</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=330">旅游标准、旅游投诉</a></li>
</ul></li>
<li><a href="${pageContext.request.contextPath }/sort2.action?secondID=65"  target="_blank"> 信息经济与邮政经济</a><ul class="nav1">
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=331">信息产业经济</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=332">电信</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=333">邮政</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=334">邮电经济理论</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=335">世界各国邮电事业</a></li>
</ul></li>
<li><a href="${pageContext.request.contextPath }/sort2.action?secondID=66"  target="_blank"> 服务于经济</a><ul class="nav1">
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=336">服务业经济概论</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=337">旅馆业</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=338">餐饮业</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=339">娱乐业</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=340">其他服务业</a></li>
</ul></li>
<li><a href="${pageContext.request.contextPath }/sort2.action?secondID=67"  target="_blank"> 金融</a><ul class="nav1">
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=341">货币</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=342">金融、银行</a></li>
</ul></li>
<li><a href="${pageContext.request.contextPath }/sort2.action?secondID=68"  target="_blank"> 证券</a><ul class="nav1">
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=343">证券学理论</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=344">世界证券学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=345">中国证券学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=346">各国证券学</a></li>
</ul></li>
<li><a href="${pageContext.request.contextPath }/sort2.action?secondID=69"  target="_blank"> 保险</a><ul class="nav1">
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=347">保险学理论</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=348">世界保险业</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=349">中国保险业</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=350">各国保险业</a></li>
</ul></li>
<li><a href="${pageContext.request.contextPath }/sort2.action?secondID=70"  target="_blank"> 领导学和决策学</a><ul class="nav1">
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=351">领导学</a></li>
 <li><a href="${pageContext.request.contextPath }/sort3.action?thirdID=352">决策学</a></li>
</ul></li>
            </ul>  
        </li>  
    </ul>
</div>
<div  id="SearchInput" style="margin-left:36%;">
<s:form name="form2" action="chooseSearch" method="post" enctype="multipart/form-data">
    <div>
    <select name="selectchoice"  style="width:6.7em;">
        <option value="1">论文主题</option>
        <option value="2">论文题目</option>
        <option value="3">作者姓名</option>
        <option value="4">发表时间</option>
        <option value="5">刊物名称</option>
    </select>
    </div>

    <s:textfield key="keyword" style="margin-top: -30%;margin-left: 45%;" />   

    <div>
    <s:submit class="btn btn-default" value="搜索" style="margin-top: -54%;margin-right: -72%;"/>
    </div>

  </s:form>
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

