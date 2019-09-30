<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.chiucheung.cn" prefix="p" %>
<!DOCTYPE html>
<html style="height: 100%">
  <head>
    <title>map.html</title>
	
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">
    
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
	
	<script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/echarts.min.js"></script>
	<script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/map/js/world.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.4.5/jquery.min.js"></script>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/colorpicker/spectrum.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/colorpicker/spectrum.css">
	
	
	
  </head>
  
  <body style="height: 100%; margin: 0;">
    <div id="container" style="height: 100%;"></div>
    <form id="myForm" method="post" style="display: none;" action="${pageContext.request.contextPath}/market/map/getProjectInfo.action" target="iframe">
    	<input id="page" name="page" value="1">
    	<input id="rows" name="rows" value="50">
    	<input id="country" name="country">
    	<input id="province" name="province">
    	<input id="city" name="city">
    </form>
  </body>
  <script type="text/javascript">
	/*窗口自适应，关键代码*/
	$(window).resize(function(){
	    myChart.resize();
	    setTimeout("$(\"div[style*='z-index: 9999999;']\").css(\"display\",\"none\")", 10);//隐藏tooltip
	});
	
	$.ajaxSetup({   
		contentType:"application/x-www-form-urlencoded;charset=utf-8",   
		complete:function(XMLHttpRequest,textStatus){ 
			var sessionstatus=XMLHttpRequest.getResponseHeader("sessionstatus"); //通过XMLHttpRequest取得响应头，sessionstatus，  
			if(sessionstatus=="timeout"){ 
				//如果超时就处理 ，跳出登陆的页面
				//window.location.replace("${pageContext.request.contextPath}/logintimeout.jsp");
				/* $("#login").attr("src","${pageContext.request.contextPath}/market/map/loginIndex.action");
				$("#login").show(); */
				showLoginDialog();
			}   
     	}
	});
	
	
  	var dom = document.getElementById("container");
  	var myChart = echarts.init(dom);
  	var app = {};
  	
  	var planePath = 'path://M1705.06,1318.313v-89.254l-319.9-221.799l0.073-208.063c0.521-84.662-26.629-121.796-63.961-121.491c-37.332-0.305-64.482,36.829-63.961,121.491l0.073,208.063l-319.9,221.799v89.254l330.343-157.288l12.238,241.308l-134.449,92.931l0.531,42.034l175.125-42.917l175.125,42.917l0.531-42.034l-134.449-92.931l12.238-241.308L1705.06,1318.313z';
  	
  	var color = ['#a6c84c', '#ffa022', '#46bee9'];
  	
  	
  	var option = {
  		title:{
  			text: '照彰业务扩张地图演义',
  		    /* subtext: 'Show Data', */
  		    left: 'center',
  		    top: 'top',
  		    textStyle: {
  		        color: '#fff'
  		    }
  		},
  		tooltip : {
  	        trigger: 'item',
  	        formatter: function(params) {
  	        	if (params.seriesName == '世界' || params.seriesName == '中国' || params.seriesName == '省份'){
  		        	var result = '<span style="display:inline-block;margin-right:5px;border-radius:10px;width:9px;height:9px;background-color:' + params.color + '"></span>';
  		        	result += params.data.name+":"+params.data.value[2];
  		        	return result;
  	        	}else if (params.seriesName == '分公司'){
  	        		var result = '<span style="display:inline-block;margin-right:5px;border-radius:10px;width:9px;height:9px;background-color:' + params.color + '"></span>';
  		        	result += params.data.addr;
  		        	result += '<br>';
  		        	result += "<div style='padding-left:10px;color:white;'>"+params.data.tel+"</div>";
  		        	return result;
  	        	}
  	        }
  	    },
		legend: {
		     orient: 'vertical',
		     top: 'bottom',
		     left: 'right',
		     data: ['世界', 'world', '中国', 'china', '分公司'],
		     textStyle: {
		         color: '#fff'
		     },
		     
		},
  		backgroundColor: {
  		    type: 'linear',
  		    x: 0,
  		    y: 0,
  		    x2: 1,
  		    y2: 1,
  		    colorStops: [{
  		        offset: 0,
  		        color: '#0f2c70' // 0% 处的颜色
  		    }, {
  		        offset: 1,
  		        color: '#091732' // 100% 处的颜色
  		    }],
  		    globalCoord: false // 缺省为 false
  		},
  		geo: {
  		    map: 'world',
  		    show: true,
  		   /*  roam: true, */
  		    zoom:1.2,
  		    label: {
  		        emphasis: {
  		            show: false
  		        }
  		    },
  		    itemStyle: {
  		        normal: {
  		            areaColor: '#091632',
  		            borderColor: '#ffffff',
  		            shadowColor: '#ffffff',
  		            shadowBlur: 10
  		        }
  		    }
  		},
  		series: [{
  		        type: 'map',
  		        map: 'world',
  		        geoIndex: 1,
  		        //aspectScale: 0.75, //长宽比
  		        zoom:1.2,
  		        showLegendSymbol: false, // 控制存在legend时的显示
  		        label: {
  		            normal: {
  		                show: false,
  		            },
  		            emphasis: {
  		                show: true,
  		                textStyle: {
  		                    color: '#fff'
  		                }
  		            }
  		        },
  		        /* roam: true, */
  		        itemStyle: {
  		            normal: {
  		                /* areaColor: '#031525', */
  		                areaColor: '#031525',
  		                borderColor: '#3B5077',
  		                borderWidth: 1
  		            },
  		            emphasis: {
  		                areaColor: '#0f2c70'
  		            }
  		        },
  		        data: []
  		    }
  		]
  	};
  	
  	
  	if (option && typeof option === "object") {
  	  	
  	    $("#container").append("<iframe id='iframe' name='iframe' style='position: absolute; display: none; z-index: 2000;background-color: rgba(50, 50, 50, 0.4);padding: 0px; left: 0px; top: 0px;width:100%;height:100%;border:0px;'></iframe>");
  	    
  	    $("#container").append("<iframe id='login' name='login' style='position: absolute; display: none; z-index: 9999999;background-color: rgba(50, 50, 50, 0.4);padding: 0px; left: 0px; top: 0px;width:100%;height:100%;border:0px;'></iframe>");
  	  	
  	    getMapData("world", null);
  	    
  	    /* 颜色选择器 */
  	    $(document.getElementById("container").children[0]).append("<div style='position:absolute;z-index:1999;background-color: #fff;border-bottom:1px solid #fff;bottom:30px;left:30px;'>"+
  	    "背景颜色渐变(左)：<input id='color1'><button onclick='$(\"#color1\").spectrum(\"set\", \"#0f2c70\");option.backgroundColor.colorStops[0].color = \"#0f2c70\";myChart.showLoading();myChart.setOption(option, true);myChart.hideLoading();'>恢复</button><br/>"+
  	    "背景颜色渐变(右)：<input id='color2'><button onclick='$(\"#color2\").spectrum(\"set\", \"#091732\");option.backgroundColor.colorStops[1].color = \"#091732\";myChart.showLoading();myChart.setOption(option, true);myChart.hideLoading();'>恢复</button><br/>"+
  	    "地图板块颜色：<input id='color3'><button onclick='$(\"#color3\").spectrum(\"set\", \"#031525\");option.series[0].itemStyle.normal.areaColor = \"#031525\";option.geo.itemStyle.normal.areaColor = \"#031525\";myChart.showLoading();myChart.setOption(option, true);myChart.hideLoading();'>恢复</button><br/>"+
  	    "地图边框颜色：<input id='color4'><button onclick='$(\"#color4\").spectrum(\"set\", \"#3B5077\");option.series[0].itemStyle.normal.borderColor = \"#3B5077\";option.geo.itemStyle.normal.borderColor = \"#3B5077\";myChart.showLoading();myChart.setOption(option, true);myChart.hideLoading();'>恢复</button><br/>"+
  	    "地图高亮颜色：<input id='color5'><button onclick='$(\"#color5\").spectrum(\"set\", \"#0f2c70\");option.series[0].itemStyle.emphasis.areaColor = \"#0f2c70\";myChart.showLoading();myChart.setOption(option, true);myChart.hideLoading();'>恢复</button><br/>"+
  	    "地图散点颜色：<input id='color6'><button onclick='$(\"#color6\").spectrum(\"set\", \"red\");option.series[1].itemStyle.normal.color = \"red\";myChart.showLoading();myChart.setOption(option, true);myChart.hideLoading();'>恢复</button><br/>"+
  	    "地图飞机颜色：<input id='color7'><button onclick='$(\"#color7\").spectrum(\"set\", \"#46bee9\");option.series[2].lineStyle.normal.color = \"#46bee9\";myChart.showLoading();myChart.setOption(option, true);myChart.hideLoading();'>恢复</button><br/>"+
  	    "公司散点颜色：<input id='color8'><button onclick='$(\"#color8\").spectrum(\"set\", \"rgba(255,250,0,0.8)\");option.series[3].itemStyle.normal.color = \"rgba(255,250,0,0.8)\";myChart.showLoading();myChart.setOption(option, true);myChart.hideLoading();'>恢复</button><br/>"+
  	    "<button onclick='alert($(\"#color1\").spectrum(\"get\")+\"，\"+$(\"#color2\").spectrum(\"get\")+\"，\"+$(\"#color3\").spectrum(\"get\")+\"，\"+$(\"#color4\").spectrum(\"get\")+\"，\"+$(\"#color5\").spectrum(\"get\")+\"，\"+$(\"#color6\").spectrum(\"get\")+\"，\"+$(\"#color7\").spectrum(\"get\")+\"，\"+$(\"#color8\").spectrum(\"get\"))'>提交颜色</buttom>"+
  	    "</div>");
  		$("#color1").spectrum({
			allowEmpty:true,
			color: "#0f2c70",
			showInput: true,
			containerClassName: "full-spectrum",
			showInitial: true,
			showPalette: true,
			showSelectionPalette: true,
			showAlpha: true,
			maxPaletteSize: 10,
			preferredFormat: "hex",
			localStorageKey: "spectrum.demo",
			move: function (color) {
				
			},
			show: function () {

			},
			beforeShow: function () {

			},
			hide: function (color) {
				
			},
			change:function(color){
				color = $("span[class*='sp-thumb-active']:visible").attr('data-color');
				option.backgroundColor.colorStops[0].color = color;
				myChart.showLoading();
			    myChart.setOption(option, true);
			    myChart.hideLoading();
			},

			palette: [
						["rgb(0, 0, 0)", "rgb(67, 67, 67)", "rgb(102, 102, 102)", "rgb(153, 153, 153)","rgb(183, 183, 183)",
						"rgb(204, 204, 204)", "rgb(217, 217, 217)", "rgb(239, 239, 239)", "rgb(243, 243, 243)", "rgb(255, 255, 255)"],
						["rgb(152, 0, 0)", "rgb(255, 0, 0)", "rgb(255, 153, 0)", "rgb(255, 255, 0)", "rgb(0, 255, 0)",
						"rgb(0, 255, 255)", "rgb(74, 134, 232)", "rgb(0, 0, 255)", "rgb(153, 0, 255)", "rgb(255, 0, 255)"],
						["rgb(230, 184, 175)", "rgb(244, 204, 204)", "rgb(252, 229, 205)", "rgb(255, 242, 204)", "rgb(217, 234, 211)",
						"rgb(208, 224, 227)", "rgb(201, 218, 248)", "rgb(207, 226, 243)", "rgb(217, 210, 233)", "rgb(234, 209, 220)",
						"rgb(221, 126, 107)", "rgb(234, 153, 153)", "rgb(249, 203, 156)", "rgb(255, 229, 153)", "rgb(182, 215, 168)",
						"rgb(162, 196, 201)", "rgb(164, 194, 244)", "rgb(159, 197, 232)", "rgb(180, 167, 214)", "rgb(213, 166, 189)",
						"rgb(204, 65, 37)", "rgb(224, 102, 102)", "rgb(246, 178, 107)", "rgb(255, 217, 102)", "rgb(147, 196, 125)",
						"rgb(118, 165, 175)", "rgb(109, 158, 235)", "rgb(111, 168, 220)", "rgb(142, 124, 195)", "rgb(194, 123, 160)",
						"rgb(166, 28, 0)", "rgb(204, 0, 0)", "rgb(230, 145, 56)", "rgb(241, 194, 50)", "rgb(106, 168, 79)",
						"rgb(69, 129, 142)", "rgb(60, 120, 216)", "rgb(61, 133, 198)", "rgb(103, 78, 167)", "rgb(166, 77, 121)",
						"rgb(133, 32, 12)", "rgb(153, 0, 0)", "rgb(180, 95, 6)", "rgb(191, 144, 0)", "rgb(56, 118, 29)",
						"rgb(19, 79, 92)", "rgb(17, 85, 204)", "rgb(11, 83, 148)", "rgb(53, 28, 117)", "rgb(116, 27, 71)",
						"rgb(91, 15, 0)", "rgb(102, 0, 0)", "rgb(120, 63, 4)", "rgb(127, 96, 0)", "rgb(39, 78, 19)",
						"rgb(12, 52, 61)", "rgb(28, 69, 135)", "rgb(7, 55, 99)", "rgb(32, 18, 77)", "rgb(76, 17, 48)"]
					]
		});
  		$("#color2").spectrum({
			allowEmpty:true,
			color: "#091732",
			showInput: true,
			containerClassName: "full-spectrum",
			showInitial: true,
			showPalette: true,
			showSelectionPalette: true,
			showAlpha: true,
			maxPaletteSize: 10,
			preferredFormat: "hex",
			localStorageKey: "spectrum.demo",
			move: function (color) {
				
			},
			show: function () {

			},
			beforeShow: function () {

			},
			hide: function (color) {
				
			},
			change:function(color){
				color = $("span[class*='sp-thumb-active']:visible").attr('data-color');
				option.backgroundColor.colorStops[1].color = color;
				myChart.showLoading();
			    myChart.setOption(option, true);
			    myChart.hideLoading();
			},

			palette: [
				["rgb(0, 0, 0)", "rgb(67, 67, 67)", "rgb(102, 102, 102)", "rgb(153, 153, 153)","rgb(183, 183, 183)",
				"rgb(204, 204, 204)", "rgb(217, 217, 217)", "rgb(239, 239, 239)", "rgb(243, 243, 243)", "rgb(255, 255, 255)"],
				["rgb(152, 0, 0)", "rgb(255, 0, 0)", "rgb(255, 153, 0)", "rgb(255, 255, 0)", "rgb(0, 255, 0)",
				"rgb(0, 255, 255)", "rgb(74, 134, 232)", "rgb(0, 0, 255)", "rgb(153, 0, 255)", "rgb(255, 0, 255)"],
				["rgb(230, 184, 175)", "rgb(244, 204, 204)", "rgb(252, 229, 205)", "rgb(255, 242, 204)", "rgb(217, 234, 211)",
				"rgb(208, 224, 227)", "rgb(201, 218, 248)", "rgb(207, 226, 243)", "rgb(217, 210, 233)", "rgb(234, 209, 220)",
				"rgb(221, 126, 107)", "rgb(234, 153, 153)", "rgb(249, 203, 156)", "rgb(255, 229, 153)", "rgb(182, 215, 168)",
				"rgb(162, 196, 201)", "rgb(164, 194, 244)", "rgb(159, 197, 232)", "rgb(180, 167, 214)", "rgb(213, 166, 189)",
				"rgb(204, 65, 37)", "rgb(224, 102, 102)", "rgb(246, 178, 107)", "rgb(255, 217, 102)", "rgb(147, 196, 125)",
				"rgb(118, 165, 175)", "rgb(109, 158, 235)", "rgb(111, 168, 220)", "rgb(142, 124, 195)", "rgb(194, 123, 160)",
				"rgb(166, 28, 0)", "rgb(204, 0, 0)", "rgb(230, 145, 56)", "rgb(241, 194, 50)", "rgb(106, 168, 79)",
				"rgb(69, 129, 142)", "rgb(60, 120, 216)", "rgb(61, 133, 198)", "rgb(103, 78, 167)", "rgb(166, 77, 121)",
				"rgb(133, 32, 12)", "rgb(153, 0, 0)", "rgb(180, 95, 6)", "rgb(191, 144, 0)", "rgb(56, 118, 29)",
				"rgb(19, 79, 92)", "rgb(17, 85, 204)", "rgb(11, 83, 148)", "rgb(53, 28, 117)", "rgb(116, 27, 71)",
				"rgb(91, 15, 0)", "rgb(102, 0, 0)", "rgb(120, 63, 4)", "rgb(127, 96, 0)", "rgb(39, 78, 19)",
				"rgb(12, 52, 61)", "rgb(28, 69, 135)", "rgb(7, 55, 99)", "rgb(32, 18, 77)", "rgb(76, 17, 48)"]
			]
		});
  		$("#color3").spectrum({
			allowEmpty:true,
			color: "#031525",
			showInput: true,
			containerClassName: "full-spectrum",
			showInitial: true,
			showPalette: true,
			showSelectionPalette: true,
			showAlpha: true,
			maxPaletteSize: 10,
			preferredFormat: "hex",
			localStorageKey: "spectrum.demo",
			move: function (color) {
				
			},
			show: function () {

			},
			beforeShow: function () {

			},
			hide: function (color) {
				
			},
			change:function(color){
				color = $("span[class*='sp-thumb-active']:visible").attr('data-color');
				option.series[0].itemStyle.normal.areaColor = color;
				option.geo.itemStyle.normal.areaColor = color;
				myChart.showLoading();
			    myChart.setOption(option, true);
			    myChart.hideLoading();
			},

			palette: [
						["rgb(0, 0, 0)", "rgb(67, 67, 67)", "rgb(102, 102, 102)", "rgb(153, 153, 153)","rgb(183, 183, 183)",
						"rgb(204, 204, 204)", "rgb(217, 217, 217)", "rgb(239, 239, 239)", "rgb(243, 243, 243)", "rgb(255, 255, 255)"],
						["rgb(152, 0, 0)", "rgb(255, 0, 0)", "rgb(255, 153, 0)", "rgb(255, 255, 0)", "rgb(0, 255, 0)",
						"rgb(0, 255, 255)", "rgb(74, 134, 232)", "rgb(0, 0, 255)", "rgb(153, 0, 255)", "rgb(255, 0, 255)"],
						["rgb(230, 184, 175)", "rgb(244, 204, 204)", "rgb(252, 229, 205)", "rgb(255, 242, 204)", "rgb(217, 234, 211)",
						"rgb(208, 224, 227)", "rgb(201, 218, 248)", "rgb(207, 226, 243)", "rgb(217, 210, 233)", "rgb(234, 209, 220)",
						"rgb(221, 126, 107)", "rgb(234, 153, 153)", "rgb(249, 203, 156)", "rgb(255, 229, 153)", "rgb(182, 215, 168)",
						"rgb(162, 196, 201)", "rgb(164, 194, 244)", "rgb(159, 197, 232)", "rgb(180, 167, 214)", "rgb(213, 166, 189)",
						"rgb(204, 65, 37)", "rgb(224, 102, 102)", "rgb(246, 178, 107)", "rgb(255, 217, 102)", "rgb(147, 196, 125)",
						"rgb(118, 165, 175)", "rgb(109, 158, 235)", "rgb(111, 168, 220)", "rgb(142, 124, 195)", "rgb(194, 123, 160)",
						"rgb(166, 28, 0)", "rgb(204, 0, 0)", "rgb(230, 145, 56)", "rgb(241, 194, 50)", "rgb(106, 168, 79)",
						"rgb(69, 129, 142)", "rgb(60, 120, 216)", "rgb(61, 133, 198)", "rgb(103, 78, 167)", "rgb(166, 77, 121)",
						"rgb(133, 32, 12)", "rgb(153, 0, 0)", "rgb(180, 95, 6)", "rgb(191, 144, 0)", "rgb(56, 118, 29)",
						"rgb(19, 79, 92)", "rgb(17, 85, 204)", "rgb(11, 83, 148)", "rgb(53, 28, 117)", "rgb(116, 27, 71)",
						"rgb(91, 15, 0)", "rgb(102, 0, 0)", "rgb(120, 63, 4)", "rgb(127, 96, 0)", "rgb(39, 78, 19)",
						"rgb(12, 52, 61)", "rgb(28, 69, 135)", "rgb(7, 55, 99)", "rgb(32, 18, 77)", "rgb(76, 17, 48)"]
					]
		});
  		$("#color4").spectrum({
			allowEmpty:true,
			color: "#3B5077",
			showInput: true,
			containerClassName: "full-spectrum",
			showInitial: true,
			showPalette: true,
			showSelectionPalette: true,
			showAlpha: true,
			maxPaletteSize: 10,
			preferredFormat: "hex",
			localStorageKey: "spectrum.demo",
			move: function (color) {
				
			},
			show: function () {

			},
			beforeShow: function () {

			},
			hide: function (color) {
				
			},
			change:function(color){
				color = $("span[class*='sp-thumb-active']:visible").attr('data-color');
				option.series[0].itemStyle.normal.borderColor = color;
				option.geo.itemStyle.normal.borderColor = color;
				myChart.showLoading();
			    myChart.setOption(option, true);
			    myChart.hideLoading();
			},

			palette: [
						["rgb(0, 0, 0)", "rgb(67, 67, 67)", "rgb(102, 102, 102)", "rgb(153, 153, 153)","rgb(183, 183, 183)",
						"rgb(204, 204, 204)", "rgb(217, 217, 217)", "rgb(239, 239, 239)", "rgb(243, 243, 243)", "rgb(255, 255, 255)"],
						["rgb(152, 0, 0)", "rgb(255, 0, 0)", "rgb(255, 153, 0)", "rgb(255, 255, 0)", "rgb(0, 255, 0)",
						"rgb(0, 255, 255)", "rgb(74, 134, 232)", "rgb(0, 0, 255)", "rgb(153, 0, 255)", "rgb(255, 0, 255)"],
						["rgb(230, 184, 175)", "rgb(244, 204, 204)", "rgb(252, 229, 205)", "rgb(255, 242, 204)", "rgb(217, 234, 211)",
						"rgb(208, 224, 227)", "rgb(201, 218, 248)", "rgb(207, 226, 243)", "rgb(217, 210, 233)", "rgb(234, 209, 220)",
						"rgb(221, 126, 107)", "rgb(234, 153, 153)", "rgb(249, 203, 156)", "rgb(255, 229, 153)", "rgb(182, 215, 168)",
						"rgb(162, 196, 201)", "rgb(164, 194, 244)", "rgb(159, 197, 232)", "rgb(180, 167, 214)", "rgb(213, 166, 189)",
						"rgb(204, 65, 37)", "rgb(224, 102, 102)", "rgb(246, 178, 107)", "rgb(255, 217, 102)", "rgb(147, 196, 125)",
						"rgb(118, 165, 175)", "rgb(109, 158, 235)", "rgb(111, 168, 220)", "rgb(142, 124, 195)", "rgb(194, 123, 160)",
						"rgb(166, 28, 0)", "rgb(204, 0, 0)", "rgb(230, 145, 56)", "rgb(241, 194, 50)", "rgb(106, 168, 79)",
						"rgb(69, 129, 142)", "rgb(60, 120, 216)", "rgb(61, 133, 198)", "rgb(103, 78, 167)", "rgb(166, 77, 121)",
						"rgb(133, 32, 12)", "rgb(153, 0, 0)", "rgb(180, 95, 6)", "rgb(191, 144, 0)", "rgb(56, 118, 29)",
						"rgb(19, 79, 92)", "rgb(17, 85, 204)", "rgb(11, 83, 148)", "rgb(53, 28, 117)", "rgb(116, 27, 71)",
						"rgb(91, 15, 0)", "rgb(102, 0, 0)", "rgb(120, 63, 4)", "rgb(127, 96, 0)", "rgb(39, 78, 19)",
						"rgb(12, 52, 61)", "rgb(28, 69, 135)", "rgb(7, 55, 99)", "rgb(32, 18, 77)", "rgb(76, 17, 48)"]
					]
		});
  		$("#color5").spectrum({
			allowEmpty:true,
			color: "#0f2c70",
			showInput: true,
			containerClassName: "full-spectrum",
			showInitial: true,
			showPalette: true,
			showSelectionPalette: true,
			showAlpha: true,
			maxPaletteSize: 10,
			preferredFormat: "hex",
			localStorageKey: "spectrum.demo",
			move: function (color) {
				
			},
			show: function () {

			},
			beforeShow: function () {

			},
			hide: function (color) {
				
			},
			change:function(color){
				color = $("span[class*='sp-thumb-active']:visible").attr('data-color');
				option.series[0].itemStyle.emphasis.areaColor = color;
				myChart.showLoading();
			    myChart.setOption(option, true);
			    myChart.hideLoading();
			},

			palette: [
						["rgb(0, 0, 0)", "rgb(67, 67, 67)", "rgb(102, 102, 102)", "rgb(153, 153, 153)","rgb(183, 183, 183)",
						"rgb(204, 204, 204)", "rgb(217, 217, 217)", "rgb(239, 239, 239)", "rgb(243, 243, 243)", "rgb(255, 255, 255)"],
						["rgb(152, 0, 0)", "rgb(255, 0, 0)", "rgb(255, 153, 0)", "rgb(255, 255, 0)", "rgb(0, 255, 0)",
						"rgb(0, 255, 255)", "rgb(74, 134, 232)", "rgb(0, 0, 255)", "rgb(153, 0, 255)", "rgb(255, 0, 255)"],
						["rgb(230, 184, 175)", "rgb(244, 204, 204)", "rgb(252, 229, 205)", "rgb(255, 242, 204)", "rgb(217, 234, 211)",
						"rgb(208, 224, 227)", "rgb(201, 218, 248)", "rgb(207, 226, 243)", "rgb(217, 210, 233)", "rgb(234, 209, 220)",
						"rgb(221, 126, 107)", "rgb(234, 153, 153)", "rgb(249, 203, 156)", "rgb(255, 229, 153)", "rgb(182, 215, 168)",
						"rgb(162, 196, 201)", "rgb(164, 194, 244)", "rgb(159, 197, 232)", "rgb(180, 167, 214)", "rgb(213, 166, 189)",
						"rgb(204, 65, 37)", "rgb(224, 102, 102)", "rgb(246, 178, 107)", "rgb(255, 217, 102)", "rgb(147, 196, 125)",
						"rgb(118, 165, 175)", "rgb(109, 158, 235)", "rgb(111, 168, 220)", "rgb(142, 124, 195)", "rgb(194, 123, 160)",
						"rgb(166, 28, 0)", "rgb(204, 0, 0)", "rgb(230, 145, 56)", "rgb(241, 194, 50)", "rgb(106, 168, 79)",
						"rgb(69, 129, 142)", "rgb(60, 120, 216)", "rgb(61, 133, 198)", "rgb(103, 78, 167)", "rgb(166, 77, 121)",
						"rgb(133, 32, 12)", "rgb(153, 0, 0)", "rgb(180, 95, 6)", "rgb(191, 144, 0)", "rgb(56, 118, 29)",
						"rgb(19, 79, 92)", "rgb(17, 85, 204)", "rgb(11, 83, 148)", "rgb(53, 28, 117)", "rgb(116, 27, 71)",
						"rgb(91, 15, 0)", "rgb(102, 0, 0)", "rgb(120, 63, 4)", "rgb(127, 96, 0)", "rgb(39, 78, 19)",
						"rgb(12, 52, 61)", "rgb(28, 69, 135)", "rgb(7, 55, 99)", "rgb(32, 18, 77)", "rgb(76, 17, 48)"]
					]
		});
  		$("#color6").spectrum({
			allowEmpty:true,
			color: "red",
			showInput: true,
			containerClassName: "full-spectrum",
			showInitial: true,
			showPalette: true,
			showSelectionPalette: true,
			showAlpha: true,
			maxPaletteSize: 10,
			preferredFormat: "hex",
			localStorageKey: "spectrum.demo",
			move: function (color) {
				
			},
			show: function () {

			},
			beforeShow: function () {

			},
			hide: function (color) {
				
			},
			change:function(color){
				color = $("span[class*='sp-thumb-active']:visible").attr('data-color');
				option.series[1].itemStyle.normal.color = color;
				myChart.showLoading();
			    myChart.setOption(option, true);
			    myChart.hideLoading();
			},

			palette: [
						["rgb(0, 0, 0)", "rgb(67, 67, 67)", "rgb(102, 102, 102)", "rgb(153, 153, 153)","rgb(183, 183, 183)",
						"rgb(204, 204, 204)", "rgb(217, 217, 217)", "rgb(239, 239, 239)", "rgb(243, 243, 243)", "rgb(255, 255, 255)"],
						["rgb(152, 0, 0)", "rgb(255, 0, 0)", "rgb(255, 153, 0)", "rgb(255, 255, 0)", "rgb(0, 255, 0)",
						"rgb(0, 255, 255)", "rgb(74, 134, 232)", "rgb(0, 0, 255)", "rgb(153, 0, 255)", "rgb(255, 0, 255)"],
						["rgb(230, 184, 175)", "rgb(244, 204, 204)", "rgb(252, 229, 205)", "rgb(255, 242, 204)", "rgb(217, 234, 211)",
						"rgb(208, 224, 227)", "rgb(201, 218, 248)", "rgb(207, 226, 243)", "rgb(217, 210, 233)", "rgb(234, 209, 220)",
						"rgb(221, 126, 107)", "rgb(234, 153, 153)", "rgb(249, 203, 156)", "rgb(255, 229, 153)", "rgb(182, 215, 168)",
						"rgb(162, 196, 201)", "rgb(164, 194, 244)", "rgb(159, 197, 232)", "rgb(180, 167, 214)", "rgb(213, 166, 189)",
						"rgb(204, 65, 37)", "rgb(224, 102, 102)", "rgb(246, 178, 107)", "rgb(255, 217, 102)", "rgb(147, 196, 125)",
						"rgb(118, 165, 175)", "rgb(109, 158, 235)", "rgb(111, 168, 220)", "rgb(142, 124, 195)", "rgb(194, 123, 160)",
						"rgb(166, 28, 0)", "rgb(204, 0, 0)", "rgb(230, 145, 56)", "rgb(241, 194, 50)", "rgb(106, 168, 79)",
						"rgb(69, 129, 142)", "rgb(60, 120, 216)", "rgb(61, 133, 198)", "rgb(103, 78, 167)", "rgb(166, 77, 121)",
						"rgb(133, 32, 12)", "rgb(153, 0, 0)", "rgb(180, 95, 6)", "rgb(191, 144, 0)", "rgb(56, 118, 29)",
						"rgb(19, 79, 92)", "rgb(17, 85, 204)", "rgb(11, 83, 148)", "rgb(53, 28, 117)", "rgb(116, 27, 71)",
						"rgb(91, 15, 0)", "rgb(102, 0, 0)", "rgb(120, 63, 4)", "rgb(127, 96, 0)", "rgb(39, 78, 19)",
						"rgb(12, 52, 61)", "rgb(28, 69, 135)", "rgb(7, 55, 99)", "rgb(32, 18, 77)", "rgb(76, 17, 48)"]
					]
		});
  		$("#color7").spectrum({
			allowEmpty:true,
			color: "#46bee9",
			showInput: true,
			containerClassName: "full-spectrum",
			showInitial: true,
			showPalette: true,
			showSelectionPalette: true,
			showAlpha: true,
			maxPaletteSize: 10,
			preferredFormat: "hex",
			localStorageKey: "spectrum.demo",
			move: function (color) {
				
			},
			show: function () {

			},
			beforeShow: function () {

			},
			hide: function (color) {
				
			},
			change:function(color){
				color = $("span[class*='sp-thumb-active']:visible").attr('data-color');
				option.series[2].lineStyle.normal.color = color;
				myChart.showLoading();
			    myChart.setOption(option, true);
			    myChart.hideLoading();
			},

			palette: [
						["rgb(0, 0, 0)", "rgb(67, 67, 67)", "rgb(102, 102, 102)", "rgb(153, 153, 153)","rgb(183, 183, 183)",
						"rgb(204, 204, 204)", "rgb(217, 217, 217)", "rgb(239, 239, 239)", "rgb(243, 243, 243)", "rgb(255, 255, 255)"],
						["rgb(152, 0, 0)", "rgb(255, 0, 0)", "rgb(255, 153, 0)", "rgb(255, 255, 0)", "rgb(0, 255, 0)",
						"rgb(0, 255, 255)", "rgb(74, 134, 232)", "rgb(0, 0, 255)", "rgb(153, 0, 255)", "rgb(255, 0, 255)"],
						["rgb(230, 184, 175)", "rgb(244, 204, 204)", "rgb(252, 229, 205)", "rgb(255, 242, 204)", "rgb(217, 234, 211)",
						"rgb(208, 224, 227)", "rgb(201, 218, 248)", "rgb(207, 226, 243)", "rgb(217, 210, 233)", "rgb(234, 209, 220)",
						"rgb(221, 126, 107)", "rgb(234, 153, 153)", "rgb(249, 203, 156)", "rgb(255, 229, 153)", "rgb(182, 215, 168)",
						"rgb(162, 196, 201)", "rgb(164, 194, 244)", "rgb(159, 197, 232)", "rgb(180, 167, 214)", "rgb(213, 166, 189)",
						"rgb(204, 65, 37)", "rgb(224, 102, 102)", "rgb(246, 178, 107)", "rgb(255, 217, 102)", "rgb(147, 196, 125)",
						"rgb(118, 165, 175)", "rgb(109, 158, 235)", "rgb(111, 168, 220)", "rgb(142, 124, 195)", "rgb(194, 123, 160)",
						"rgb(166, 28, 0)", "rgb(204, 0, 0)", "rgb(230, 145, 56)", "rgb(241, 194, 50)", "rgb(106, 168, 79)",
						"rgb(69, 129, 142)", "rgb(60, 120, 216)", "rgb(61, 133, 198)", "rgb(103, 78, 167)", "rgb(166, 77, 121)",
						"rgb(133, 32, 12)", "rgb(153, 0, 0)", "rgb(180, 95, 6)", "rgb(191, 144, 0)", "rgb(56, 118, 29)",
						"rgb(19, 79, 92)", "rgb(17, 85, 204)", "rgb(11, 83, 148)", "rgb(53, 28, 117)", "rgb(116, 27, 71)",
						"rgb(91, 15, 0)", "rgb(102, 0, 0)", "rgb(120, 63, 4)", "rgb(127, 96, 0)", "rgb(39, 78, 19)",
						"rgb(12, 52, 61)", "rgb(28, 69, 135)", "rgb(7, 55, 99)", "rgb(32, 18, 77)", "rgb(76, 17, 48)"]
					]
		});
  		$("#color8").spectrum({
			allowEmpty:true,
			color: "rgba(255,250,0,0.8)",
			showInput: true,
			containerClassName: "full-spectrum",
			showInitial: true,
			showPalette: true,
			showSelectionPalette: true,
			showAlpha: true,
			maxPaletteSize: 10,
			preferredFormat: "hex",
			localStorageKey: "spectrum.demo",
			move: function (color) {
				
			},
			show: function () {

			},
			beforeShow: function () {

			},
			hide: function (color) {
				
			},
			change:function(color){
				color = $("span[class*='sp-thumb-active']:visible").attr('data-color');
				option.series[3].itemStyle.normal.color = color;
				myChart.showLoading();
			    myChart.setOption(option, true);
			    myChart.hideLoading();
			},

			palette: [
						["rgb(0, 0, 0)", "rgb(67, 67, 67)", "rgb(102, 102, 102)", "rgb(153, 153, 153)","rgb(183, 183, 183)",
						"rgb(204, 204, 204)", "rgb(217, 217, 217)", "rgb(239, 239, 239)", "rgb(243, 243, 243)", "rgb(255, 255, 255)"],
						["rgb(152, 0, 0)", "rgb(255, 0, 0)", "rgb(255, 153, 0)", "rgb(255, 255, 0)", "rgb(0, 255, 0)",
						"rgb(0, 255, 255)", "rgb(74, 134, 232)", "rgb(0, 0, 255)", "rgb(153, 0, 255)", "rgb(255, 0, 255)"],
						["rgb(230, 184, 175)", "rgb(244, 204, 204)", "rgb(252, 229, 205)", "rgb(255, 242, 204)", "rgb(217, 234, 211)",
						"rgb(208, 224, 227)", "rgb(201, 218, 248)", "rgb(207, 226, 243)", "rgb(217, 210, 233)", "rgb(234, 209, 220)",
						"rgb(221, 126, 107)", "rgb(234, 153, 153)", "rgb(249, 203, 156)", "rgb(255, 229, 153)", "rgb(182, 215, 168)",
						"rgb(162, 196, 201)", "rgb(164, 194, 244)", "rgb(159, 197, 232)", "rgb(180, 167, 214)", "rgb(213, 166, 189)",
						"rgb(204, 65, 37)", "rgb(224, 102, 102)", "rgb(246, 178, 107)", "rgb(255, 217, 102)", "rgb(147, 196, 125)",
						"rgb(118, 165, 175)", "rgb(109, 158, 235)", "rgb(111, 168, 220)", "rgb(142, 124, 195)", "rgb(194, 123, 160)",
						"rgb(166, 28, 0)", "rgb(204, 0, 0)", "rgb(230, 145, 56)", "rgb(241, 194, 50)", "rgb(106, 168, 79)",
						"rgb(69, 129, 142)", "rgb(60, 120, 216)", "rgb(61, 133, 198)", "rgb(103, 78, 167)", "rgb(166, 77, 121)",
						"rgb(133, 32, 12)", "rgb(153, 0, 0)", "rgb(180, 95, 6)", "rgb(191, 144, 0)", "rgb(56, 118, 29)",
						"rgb(19, 79, 92)", "rgb(17, 85, 204)", "rgb(11, 83, 148)", "rgb(53, 28, 117)", "rgb(116, 27, 71)",
						"rgb(91, 15, 0)", "rgb(102, 0, 0)", "rgb(120, 63, 4)", "rgb(127, 96, 0)", "rgb(39, 78, 19)",
						"rgb(12, 52, 61)", "rgb(28, 69, 135)", "rgb(7, 55, 99)", "rgb(32, 18, 77)", "rgb(76, 17, 48)"]
					]
		});
  	    
  	    myChart.on('click', function (params) {
  	    	if (params.seriesType == 'map'){//说明点击的是地图，而不是散点
  	    		if(option.series[0].map == 'world'){//世界地图
  	    			if (params.name == 'China'){
  	    				$.getJSON('${pageContext.request.contextPath}/json/china.json', function (map){
  	    					echarts.registerMap('china', map);
  	    					
  	    					getMapData("china", null);
  	    				});
  	    			}else{
  	    				if (params.data != undefined){
  	    					getProjectInfoData(params.data.engName, "", "");
  	    				}else{
  	    					alert("该区域还没有项目覆盖！");
  	    				}
  	    			}
  	    		} else if(option.series[0].map == 'china'){//中国地图
  	    			if (params.name != undefined && params.name != ""){
  	    				if (params.name == '北京' || params.name == '天津' || params.name == '上海' || params.name == '重庆' || params.name == '香港' || params.name == '澳门' || params.name == '台湾'){
  	    					getProjectInfoData("", params.name, "");
  	    				}else{
	  	    				$.getJSON('${pageContext.request.contextPath}/json/province/'+params.data.engName+'.json', function (map){
	  	    					echarts.registerMap(params.name, map);
	  	    					
	  	    					getMapData(params.name, params.data.engName);
	  	    					
  	    					});
  	    				}
  	    			}else{
  	    				alert("该区域还没有项目覆盖！");
  	    			}
  	    		}else{
  	    			if (params.name != undefined && params.name != ""){
  	    				getProjectInfoData("", "", params.name)
  	    			}else{
  	    				alert("该区域还没有项目覆盖！");
  	    			}
  	    		}
  	    	}else if (params.seriesType == 'effectScatter' && params.seriesName != "分公司"){
  	    		if (params.seriesName == "世界"){//在世界地图点散点
  	    			getProjectInfoData(params.name, "", "");
  	    		}else if (params.seriesName == "中国"){//在中国地图点散点
  	    			getProjectInfoData("", params.name, "");
  	    		}else{//在省份地图点散点
  	    			getProjectInfoData("", "", params.name);
  	    		}
  	    	}
  	    });
  	}
  	
  	
  	function jumpMap(map){
  		option.series[0].map = map;
  		option.geo.map = map;
  		if (map == 'world'){
  			getMapData("world", null);
  		}else if (map == 'china'){
  			getMapData("china", null);
  		}
  		
  		$("#"+map+"~div").remove();//删除后面所有的兄弟元素
  	}
  	
  	
  	/*获取地图数据
  	 *@params parent 要加载的地图
  	 *@params engName 当parent为省份时，需要engName，否则传null
  	 */
  	function getMapData(parent,engName){
  		var name;
  		var data;
  		if (parent == "world"){
  			name = "世界";
  			data = {parent:parent,chiaLli:[114.1733550,22.3200480],linesCoreName:'香港总部'};
  		}else if (parent == "china"){
  			name = "中国";
  			data = {parent:parent,chiaLli:[114.113077,22.761749],linesCoreName:'东莞总部'};
  		}else{
  			name = "省份";
  			data = {parent:parent};
  		}
  		$.ajax({
			type:'POST',//post请求
			url: "${pageContext.request.contextPath}/market/map/getMapData.action",//ajax请求的url
			data:data,
			traditional:true,
			async: false,//同步请求
			cache: false,//不缓存此页面
			success: function(datas){//请求成功后的回调函数。data：服务器返回数据。
				if (datas != "" && datas != null && datas != undefined){
					if (datas.success){
						
						for (var i=0;i<datas.data.length;i++){
							//有数据的单独添加样式,鼠标放到地图的时候默认显示的白色的字体背景
							datas.data[i].label = {emphasis: {
		  		                show: false
		  		            }};
						}
						option.series[0].data = datas.data;
						option.series[1] = {
				  		        name: name,
				  		        type: 'effectScatter',
				  		        coordinateSystem: 'geo',
				  		        data: datas.effectScatters,
				  		        symbolSize: function(val) {
				  		            //return val[2] / 20;
				  		            return 8;
				  		        },
				  		        showEffectOn: 'render',
				  		        rippleEffect: {
				  		        	scale:4,
				  		            brushType: 'stroke'
				  		        },
				  		        hoverAnimation: true,
				  		        label: {
				  		            normal: {
				  		                formatter: '{b}',
				  		                position: 'right',
				  		                show: true
				  		            }
				  		        },
				  		        itemStyle: {
				  		            normal: {
				  		                color: 'red',
				  		                shadowBlur: 100,
				  		                shadowColor: '#333'
				  		            }
				  		        },
				  		        zlevel: 1
				  		    };
						
						if (datas.lines != undefined){
							option.series[2] = {
							        name: parent,
							        type: 'lines',
							        coordinateSystem: 'geo',
							        zlevel: 1,
							        effect: {
							            show: true,
							            period: 6,
							            trailLength: 0,
							            symbol: planePath,
							            symbolSize: 15
							        },
							        lineStyle: {
							            normal: {
							                color: /* color[Math.floor(Math.random()*color.length)] */'#46bee9',
							                width: 1,
							                opacity: 0.4,
							                curveness: 0.2
							            }
							        },
							        data: datas.lines
							    }
						}
						
						if (parent == "world"){
							option.series[3] = {
					        	name: '分公司',
					            type: 'scatter',
					            coordinateSystem: 'geo',
					            data: [
					                   {name:'HK Headquarter',value:[114.1733550,22.3200480],addr:'香港新界荃灣海盛路9號有線電視大廈24字樓2404室',tel:'（852）24179229'},
					                  ],
					            symbol: "pin",
					            symbolSize: function (val) {
					                return 24;
					            },
					            itemStyle: {
				  		            normal: {
				  		            	color: 'rgba(255,250,0,0.8)',
				  		            }
				  		        },
					  		      label: {
					  	            normal: {
					  	                formatter: '{b}',
					  	                position: 'right',
					  	                show: true
					  	            }
					  	        },
							}
						}
						if (parent == "china"){
							option.series[3] = {
					        	name: '分公司',
					            type: 'scatter',
					            coordinateSystem: 'geo',
					            data: [
					                   {name:'东莞总部',value:[114.113077,22.761749],addr:'塘厦镇石鼓第一工业区工业大道108号',tel:'（0769）86954033'},
					                   {name:'北京分公司',value:[116.4052850,39.9049890],addr:'中国北京市朝阳区安立路洛克时代大厦C座9A05室',tel:'（010）84958982'},
					                   {name:'沈阳分公司',value:[123.4290960,41.7967670],addr:'沈阳市和平区中华路69号富丽华国际商务中心1203及1204室',tel:'（204）31502388'},
					                   {name:'广州分公司',value:[113.2806370,23.1251780],addr:'广州市天河区林和西路3-15号耀中广场B座4012室',tel:'（020）38742739'},
					                   {name:'南京分公司',value:[118.7674130,32.0415440],addr:'南京市建邺区江东中路108号万达广场C座502室',tel:'（025）85809259'},
					                   {name:'成都分公司',value:[104.0657350,30.6594620],addr:'成都市高新区天仁路387号大鼎世纪2栋2108室',tel:'（028）85222460'},
					                  ],
					            symbol: "pin",
					            symbolSize: function (val) {
					                return 24;
					            },
					            itemStyle: {
				  		            normal: {
				  		                color: 'rgba(255,250,0,0.8)',
				  		            }
				  		        },
					  		      label: {
					  	            normal: {
					  	                formatter: '{b}',
					  	                position: 'right',
					  	                show: true
					  	            }
					  	        },
					  	      zlevel: 6
							}
						}
						
						if (parent != "world" && parent != "china"){
							option.series.splice(2,3);
						}
						option.series[0].map = parent;
	    				option.geo.map = parent;
	
					  	myChart.showLoading();
					    myChart.setOption(option, true);
					    myChart.hideLoading();
					    if (parent == "world"){
					    	$(document.getElementById("container").children[0]).append("<div id='mapChooes' style='position:absolute;z-index:1999;border-top:1px solid #fff;border-bottom:1px solid #fff;top:30px;left:100px;'><div id='world' style='float:left;cursor: pointer;padding:5px;color:white;' onclick='jumpMap(\"world\")'>世界</div></div>");
					    }else if (parent == "china"){
					    	$("#mapChooes").append("<div id='china' style='float:left;cursor: pointer;padding:5px;color:white;' onclick='jumpMap(\"china\")'>中国</div'>");
					    }else{
					    	$("#mapChooes").append("<div id='" + engName + "' style='float:left;cursor: pointer;padding:5px;color:white;' onclick='jumpMap(" + engName + ")'>" + parent + "</div>");
					    }
					}else{
						alert(datas.message);
					}
				}
			}
		});
  	}
  	
  	/*
  	 * 根据国家、省份、城市获取项目信息数据
  	 */
  	function getProjectInfoData(country, province, city){
  		$.ajax({
			type:'POST',//post请求
			url: '${pageContext.request.contextPath}/market/map/testLoginTimeout.action',//ajax请求的url
			async: false,//同步请求
			cache: false,//不缓存此页面
			success: function(datas){//请求成功后的回调函数。data：服务器返回数据。
				if (datas != "" && datas != null && datas != undefined){
					$("#country").val(country);
			  		$("#province").val(province);
			  		$("#city").val(city);
			  		
			  		$("#myForm").submit();
			  		$("#iframe").show();
			  		setTimeout("$(\"div[style*='z-index: 9999999;']\").css(\"display\",\"none\")", 10);//隐藏tooltip
				}
			}
		});
  	}
  	
  	function showLoginDialog(){
  		$("#login").attr("src","${pageContext.request.contextPath}/market/map/loginIndex.action");
		$("#login").show();
  	}
  </script>
</html>
