<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.chiucheung.cn" prefix="p" %>
<!DOCTYPE html>
<html>
  <head>
    <title>产品数据</title>
	<jsp:include page="/common.jsp"></jsp:include>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/go.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/echarts/echarts.min.js"></script>
  </head>
  <script type="text/javascript">
	$(function () {
		var $ = go.GraphObject.make;  // for conciseness in defining templates
	    myDiagram =
	      $(go.Diagram, "myDiagramDiv",  // must name or refer to the DIV HTML element
	        {
	          initialContentAlignment: go.Spot.Center,
	          allowDrop: true,  // must be true to accept drops from the Palette
	          "LinkDrawn": showLinkLabel,  // this DiagramEvent listener is defined below
	          "LinkRelinked": showLinkLabel,
	          scrollsPageOnFocus: false,
	          "undoManager.isEnabled": true  // enable undo & redo
	        });
	    // when the document is modified, add a "*" to the title and enable the "Save" button
	    myDiagram.addDiagramListener("Modified", function(e) {
	      var button = document.getElementById("SaveButton");
	      if (button) button.disabled = !myDiagram.isModified;
	      var idx = document.title.indexOf("*");
	      if (myDiagram.isModified) {
	        if (idx < 0) document.title += "*";
	      } else {
	        if (idx >= 0) document.title = document.title.substr(0, idx);
	      }
	    });
	    
	    //节点点击事件
	    myDiagram.addDiagramListener("ObjectSingleClicked", function(e) {
	    	//Select_Port = e.subject.part.data.key;    e.subject.part.data即获取到的data
	    	if(e.subject.part.data.category == "Start" || e.subject.part.data.category == "End"){
	    		//alert(1);
	    		document.getElementById("properties").style.display = "none";
	    	}else if (e.subject.part.data.key != undefined){
	    		//alert(2);
	    		document.getElementById("properties").style.display = "block";
	    		//e.subject.part.data.text = "1";
	    		myDiagram.model.setDataProperty(e.subject.part.data, "text", 1);
	    		myDiagram.model.setDataProperty(e.subject.part.data, "id", 3);
	    	}else{
	    		//alert(3);
	    		document.getElementById("properties").style.display = "none";
	    	}
	    });
	   	
		//画布空白即背景点击事件
	    myDiagram.addDiagramListener("BackgroundSingleClicked", function(e) {
			//alert(e);
			document.getElementById("properties").style.display = "none";
	    });
	    
	    // helper definitions for node templates
	    function nodeStyle() {
	      return [
	        // The Node.location comes from the "loc" property of the node data,
	        // converted by the Point.parse static method.
	        // If the Node.location is changed, it updates the "loc" property of the node data,
	        // converting back using the Point.stringify static method.
	        new go.Binding("location", "loc", go.Point.parse).makeTwoWay(go.Point.stringify),
	        {
	          // the Node.location is at the center of each node
	          locationSpot: go.Spot.Center,
	          //isShadowed: true,
	          //shadowColor: "#888",
	          // handle mouse enter/leave events to show/hide the ports
	          mouseEnter: function (e, obj) { showPorts(obj.part, true); },
	          mouseLeave: function (e, obj) { showPorts(obj.part, false); }
	        }
	      ];
	    }
	    // Define a function for creating a "port" that is normally transparent.
	    // The "name" is used as the GraphObject.portId, the "spot" is used to control how links connect
	    // and where the port is positioned on the node, and the boolean "output" and "input" arguments
	    // control whether the user can draw links from or to the port.
	    function makePort(name, spot, output, input) {
	      // the port is basically just a small circle that has a white stroke when it is made visible
	      return $(go.Shape, "Circle",
	               {
	                  fill: "transparent",
	                  stroke: null,  // this is changed to "white" in the showPorts function
	                  desiredSize: new go.Size(8, 8),
	                  alignment: spot, alignmentFocus: spot,  // align the port on the main Shape
	                  portId: name,  // declare this object to be a "port"
	                  fromSpot: spot, toSpot: spot,  // declare where links may connect at this port
	                  fromLinkable: output, toLinkable: input,  // declare whether the user may draw links to/from here
	                  cursor: "pointer"  // show a different cursor to indicate potential link point
	               });
	    }
	    // define the Node templates for regular nodes
	    var lightText = 'whitesmoke';
	    myDiagram.nodeTemplate =
	        $(go.Node, "Auto", nodeStyle(),
	          $(go.Shape, "Rectangle",
	            { fill: '#00a9c9', stroke: null },
	            // Shape.fill is bound to Node.data.color
	            new go.Binding("fill", "color")),
	          $(go.Panel, "Table",
	            $(go.RowColumnDefinition, { column: 0, separatorStroke: "00a9c9" }),
	            $(go.RowColumnDefinition, { column: 1, background: "#90dcea" }),
	            
	            $(go.TextBlock, "",
	              { column: 0,
	                wrap: go.TextBlock.None, margin: 5, width: 90,
	                isMultiline: false, editable: true, textAlign: 'left',
	                font: '10pt  Segoe UI,sans-serif', stroke: 'white' },
	              new go.Binding("text").makeTwoWay()),
	              
	            $(go.TextBlock, "",
	              { column: 1,
	                wrap: go.TextBlock.None, margin: 2, width: 25,
	                isMultiline: false, editable: true, textAlign: 'center',
	                font: '10pt  Segoe UI,sans-serif', stroke: 'black' },
	              new go.Binding("text","time").makeTwoWay())
	          ),
	          
	          makePort("T", go.Spot.Top, false, true),
	          makePort("L", go.Spot.Left, true, true),
	          makePort("R", go.Spot.Right, true, true),
	          makePort("B", go.Spot.Bottom, true, false)
	        );

	    myDiagram.nodeTemplateMap.add("Start",
	      $(go.Node, "Spot", nodeStyle(),
	        $(go.Panel, "Auto",
	          $(go.Shape, "Circle",
	            { minSize: new go.Size(40, 40), fill: "#79C900", stroke: null }),
	          $(go.TextBlock, "Start",
	            { font: "bold 11pt Helvetica, Arial, sans-serif", stroke: lightText },
	            new go.Binding("text"))
	        ),
	        // three named ports, one on each side except the top, all output only:
	        makePort("T", go.Spot.Top, true, false),
	        makePort("L", go.Spot.Left, true, false),
	        makePort("R", go.Spot.Right, true, false),
	        makePort("B", go.Spot.Bottom, true, false)
	      ));
	    myDiagram.nodeTemplateMap.add("End",
	      $(go.Node, "Spot", nodeStyle(),
	        $(go.Panel, "Auto",
	          $(go.Shape, "Circle",
	            { minSize: new go.Size(40, 40), fill: "#DC3C00", stroke: null }),
	          $(go.TextBlock, "End",
	            { font: "bold 11pt Helvetica, Arial, sans-serif", stroke: lightText },
	            new go.Binding("text"))
	        ),
	        // three named ports, one on each side except the bottom, all input only:
	        makePort("T", go.Spot.Top, false, true),
	        makePort("L", go.Spot.Left, false, true),
	        makePort("R", go.Spot.Right, false, true),
	        makePort("B", go.Spot.Bottom, false, true)
	      ));
	    // replace the default Link template in the linkTemplateMap
	    myDiagram.linkTemplate =
	      $(go.Link,  // the whole link panel
	        {
	          routing: go.Link.AvoidsNodes,
	          curve: go.Link.JumpOver,
	          corner: 5, toShortLength: 4,
	          relinkableFrom: true,
	          relinkableTo: true,
	          reshapable: true,
	          resegmentable: true,
	          // mouse-overs subtly highlight links:
	          mouseEnter: function(e, link) { link.findObject("HIGHLIGHT").stroke = "rgba(30,144,255,0.2)"; },
	          mouseLeave: function(e, link) { link.findObject("HIGHLIGHT").stroke = "transparent"; }
	        },
	        new go.Binding("points").makeTwoWay(),
	        $(go.Shape,  // the highlight shape, normally transparent
	          { isPanelMain: true, strokeWidth: 8, stroke: "transparent", name: "HIGHLIGHT" }),
	        $(go.Shape,  // the link path shape
	          { isPanelMain: true, stroke: "gray", strokeWidth: 2 }),
	        $(go.Shape,  // the arrowhead
	          { toArrow: "standard", stroke: null, fill: "gray"}),
	        $(go.Panel, "Auto",  // the link label, normally not visible
	          { visible: false, name: "LABEL", segmentIndex: 2, segmentFraction: 0.5},
	          new go.Binding("visible", "visible").makeTwoWay(),
	          $(go.Shape, "RoundedRectangle",  // the label shape
	            { fill: "#F8F8F8", stroke: null }),
	          $(go.TextBlock, "Yes",  // the label
	            {
	              textAlign: "center",
	              font: "10pt helvetica, arial, sans-serif",
	              stroke: "#333333",
	              editable: true
	            },
	            new go.Binding("text").makeTwoWay())
	        )
	      );
	    // Make link labels visible if coming out of a "conditional" node.
	    // This listener is called by the "LinkDrawn" and "LinkRelinked" DiagramEvents.
	    function showLinkLabel(e) {
	      var label = e.subject.findObject("LABEL");
	      if (label !== null) label.visible = (e.subject.fromNode.data.figure === "Diamond");
	    }
	    // temporary links used by LinkingTool and RelinkingTool are also orthogonal:
	    myDiagram.toolManager.linkingTool.temporaryLink.routing = go.Link.Orthogonal;
	    myDiagram.toolManager.relinkingTool.temporaryLink.routing = go.Link.Orthogonal;
	    load();  // load an initial diagram from some JSON text
	    // initialize the Palette that is on the left side of the page
	    myPalette =
	      $(go.Palette, "myPaletteDiv",  // must name or refer to the DIV HTML element
	        {
	          scrollsPageOnFocus: false,
	          nodeTemplateMap: myDiagram.nodeTemplateMap,  // share the templates used by myDiagram
	          model: new go.GraphLinksModel([  // specify the contents of the Palette
	            { category: "Start", text: "开始" },
	            { category: "process",text: "工序" },
	            /* { text: "???", figure: "Diamond" }, */
	            { category: "End", text: "结束" },
	            /* { category: "Comment", text: "Comment" } */
	          ])
	        });
	});// end init
	// Make all ports on a node visible when the mouse is over the node
	  function showPorts(node, show) {
	    var diagram = node.diagram;
	    if (!diagram || diagram.isReadOnly || !diagram.allowLink) return;
	    node.ports.each(function(port) {
	        port.stroke = (show ? "white" : null);
	      });
	  }
	  // Show the diagram's model in JSON format that the user may edit
	  function save() {
	    document.getElementById("mySavedModel").value = myDiagram.model.toJson();
	    myDiagram.isModified = false;
	  }
	  function load() {
	    myDiagram.model = go.Model.fromJson(document.getElementById("mySavedModel").value);
	  }
	  // add an SVG rendering of the diagram at the end of this page
	  function makeSVG() {
	    var svg = myDiagram.makeSvg({
	        scale: 1
	      });
	    svg.style.border = "1px solid black";
	    obj = document.getElementById("SVGArea");
	    obj.appendChild(svg);
	    if (obj.children.length > 0) {
	      obj.replaceChild(svg, obj.children[0]);
	    }
	  }
	  
	  
	  
	  
	  
	  
	  
	  function generateCharts(){
		  var quantity = document.getElementById('quantity').value;
		  var zd = document.getElementById('zd').value;
		  if (isPositiveInteger(quantity)){
			  $.ajax({
					type:'post',
					url:'${pageContext.request.contextPath}/production/technologicalProcess/generateCharts.action',
					data:{data:myDiagram.model.toJson(),quantity:quantity,zd:zd},
					success: function(data){//请求成功后的回调函数。data：服务器返回数据。
						/* var data1 = new Array();
						for (var i=0;i<data.data1.length;i++){
							var date = new Date();
							date.setTime(data.data1[i]);
							data1[i]=date;
						}
						var data11 = new Array();
						for (var i=0;i<data.data11.length;i++){
							var date = new Date();
							date.setTime(data.data11[i]);
							data11[i]=date;
						}
						
						var zd = 8;
						var series = new Array();
		
						    series[0]=
						        {
						            name: 'test',
						            type: 'bar',
						            stack: '总量',
						            itemStyle: {
						                normal: {
						                    barBorderColor: 'rgba(0,0,0,0)',
						                    color: 'rgba(0,0,0,0)'
						                },
						                emphasis: {
						                    barBorderColor: 'rgba(0,0,0,0)',
						                    color: 'rgba(0,0,0,0)'
						                }
						            },
						            //data: [0,8,8,18,18,13,23]
						            data:data11
						        };
						series[1]=
						        {
						            name: 'CJ0001-18',
						            type: 'bar',
						            stack: '总量',
						            label: {
						                normal: {
						                    show: true,
						                    position: 'insideRight'
						                }
						            },
						            //data: [8,10,5,5,4,7,8]
						            data:data1
						        }; */
						var data1 = new Array();
						for (var i=0;i<data.data1.length;i++){
							var datas = new Array();
							for (var j=0;j<data.data1[i].length;j++){
								var date = new Date();
								date.setTime(data.data1[i][j]);
								datas[j]={value:date,time:data.times[i][j]};
							}
							data1[i]=datas;
						}
						var data11 = new Array();
						for (var i=0;i<data.data11.length;i++){
							var datas = new Array();
							for (var j=0;j<data.data11[i].length;j++){
								var date = new Date();
								date.setTime(data.data11[i][j]);
								datas[j]={value:date,time:data.times[i][j]};
							}
							data11[i]=datas;
						}
						
						//var zd = 8;
						var series = new Array();
						var CJ = new Array();
						for (var i=0;i<data11.length;i++){
							var str="";
							for (var j=4;j>((i+1)+"").length;j--){
								str += "0";
							}
							CJ[i] = "CJ"+str+(i+1)+"-18";
						    series[i*2]=
						        {
						            name: 'test',
						            type: 'bar',
						            stack: '总量',
						            itemStyle: {
						                normal: {
						                    barBorderColor: 'rgba(0,0,0,0)',
						                    color: 'rgba(0,0,0,0)'
						                },
						                emphasis: {
						                    barBorderColor: 'rgba(0,0,0,0)',
						                    color: 'rgba(0,0,0,0)'
						                }
						            },
						            //data: [0,8,8,18,18,13,23]
						            data:data11[i]
						        };
						series[i*2+1]=
						        {
						            name: CJ[i],
						            type: 'bar',
						            stack: '总量',
						            label: {
						                normal: {
						                    show: true,
						                    position: 'insideRight'
						                }
						            },
						            //data: [8,10,5,5,4,7,8]
						            data:data1[i]
						        };
						}
						
						option = {
						    tooltip : {
						        trigger: 'axis',
						        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
						            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
						        },
						        formatter: function(params) {
						            var result = params[0].name + '<br/>';
						            params.forEach(function (item) {
						                //alert(JSON.stringify(item));
						                //alert(item.data.value + ":" + item.data.time);
						                if (item.seriesName != "test"){
						                	result += '<span style="display:inline-block;margin-right:5px;border-radius:10px;width:9px;height:9px;background-color:' + item.color + '"></span>';
						                	var date = item.data.value;
						                	var time = item.data.time*1;
						                	
						                	var myDate = new Date(date);
						                	
						                	var year = myDate.getFullYear();
						                	var month = myDate.getMonth()+1;
						                	var day = myDate.getDate();
						                	var hours = myDate.getHours();
						                	var minutes = myDate.getMinutes();
						                	var seconds = myDate.getSeconds();
						                	if (zd == 8){
						                		if (time == 0){
						                			myDate.setTime(myDate.getTime()-24*3600*1000+17.5*3600*1000);
						                		}else if (time <= 4){
						                			myDate.setHours(0);
						                			myDate.setMinutes(0);
						                			myDate.setSeconds(0);
						                			myDate.setTime(myDate.getTime()+(time+8)*3600*1000);
						                		}else if (time >= 4 && time < 8){
						                			myDate.setHours(0);
						                			myDate.setMinutes(0);
						                			myDate.setSeconds(0);
						                			myDate.setTime(myDate.getTime()+(time-4+13.5)*3600*1000);
						                		}
						                	}if (zd == 11){
						                		if (time == 0){
						                			myDate.setHours(0);
						                			myDate.setMinutes(0);
						                			myDate.setSeconds(0);
						                			myDate.setTime(myDate.getTime()+21.5*3600*1000);
						                		}else if (time <= 4){
						                			myDate.setHours(0);
						                			myDate.setMinutes(0);
						                			myDate.setSeconds(0);
						                			myDate.setTime(myDate.getTime()+(time+8)*3600*1000);
						                		}else if (time >= 4 && time <= 8){
						                			myDate.setHours(0);
						                			myDate.setMinutes(0);
						                			myDate.setSeconds(0);
						                			myDate.setTime(myDate.getTime()+(time-4+13.5)*3600*1000);
						                		}else{
						                			myDate.setHours(0);
						                			myDate.setMinutes(0);
						                			myDate.setSeconds(0);
						                			myDate.setTime(myDate.getTime()+(time-8+18.5)*3600*1000);
						                		}
						                	}else if (zd == 24){
						                		
						                	}
						                	
						                	
						                	year = myDate.getFullYear();
						                	month = myDate.getMonth()+1;
						                	month = month >= 10 ? month : "0" + month;
						                	day = myDate.getDate();
						                	day = day >= 10 ? day : "0" + day;
						                	hours = myDate.getHours();
						                	hours = hours >= 10 ? hours : "0" + hours;
						                	minutes = myDate.getMinutes();
						                	minutes = minutes >= 10 ? minutes: "0" + minutes;
						                	seconds = myDate.getSeconds();
						                	seconds = seconds >= 10 ? seconds : "0" + seconds;
						                    
						                    result +=item.seriesName + "：" + year + "-" +month + "-" + day + " " + hours + ":" + minutes + ":" + seconds + "<br/>"; 
						                }
						                /* if (item.seriesName != "test"){
						                    result += '<span style="display:inline-block;margin-right:5px;border-radius:10px;width:9px;height:9px;background-color:' + item.color + '"></span>';
						                    var myDate = new Date("2018-01-25 00:00:00");
						                    var itemDate = new Date(item.data);
						                    var time = item.data - myDate.getTime();
						                    time = (time/3600000)*(zd/24)/zd+"";
						                    var zs = 0;
						                    var xs = 0;
						                    
						                    if (time.indexOf(".") != -1){
						                        zs = time.split(".")[0];
						                        xs = time*1 - zs;
						                    }else{
						                        zs = time;
						                    }
						                    if (xs == 0){
						                        if (zs > 0){
						                            myDate.setTime(myDate.getTime() + (zs-1)*24*3600*1000 + 17.5*3600*1000);
						                        }
						                    }else{
						                        if (xs > 0.5){
						                            myDate.setTime(myDate.getTime() + zs*24*3600*1000 + (xs-0.5)*zd*3600*1000 + 13.5*3600*1000);
						                        }else{
						                            myDate.setTime(myDate.getTime() + zs*24*3600*1000 + xs*zd*3600*1000 + 8*3600*1000);
						                        }
						                    }
						                    var year = myDate.getFullYear();
						                    var month = myDate.getMonth()+1;
						                    month = month >= 10 ? month : "0" + month;
						                    var day = myDate.getDate();
						                    day = day >= 10 ? day : "0" + day;
						                    var hours = myDate.getHours();
						                    hours = hours >= 10 ? hours : "0" + hours;
						                    var minutes = myDate.getMinutes();
						                    minutes = minutes >= 10 ? minutes: "0" + minutes;
						                    var seconds = myDate.getSeconds();
						                    seconds = seconds >= 10 ? seconds : "0" + seconds;
						                    result +=item.seriesName + "：" + year + "-" +month + "-" + day + " " + hours + ":" + minutes + ":" + seconds + "<br/>"; 
						                    //result +=item.seriesName + "：" + itemDate + "<br/>"; 
						                } */
						            });
						        
						            return result;
						        }
						    },
						    legend: {
						        data: CJ
						    },
						    grid: {
						        left: '3%',
						        right: '4%',
						        bottom: '3%',
						        containLabel: true
						    },
						    xAxis:  {
						        type: 'time',
						        min: new Date("2018-01-25 00:00:00"),
						        interval: 3600 * 24 * 1000,
						        minInterval: 3600 * 24 * 10000,
						        //maxInterval: 3600 * 24 * 10000
						    },
						    yAxis: {
						        type: 'category',
						        data: data.yAxis
						    },
						    series: series
						};
						var myChart = echarts.init(document.getElementById('main'));
						myChart.clear();
						myChart.setOption(option);
					}
				});
		  }else{
			  alert("请输入正整数");
		  }
	  }
	  
	  
	  function isPositiveInteger(s){//是否为正整数
	     var re = /^[0-9]+$/ ;
	     return re.test(s)
	 }  
  </script>
  <body>
	<div id="sample">
	<div style="text-align: center;">工艺流程</div>
	  <div style="width: 100%; display: flex; justify-content: space-between">
	    <div id="myPaletteDiv" style="width: 160px; margin-right: 2px; background-color: whitesmoke; border: solid 1px black"></div>
	    <div id="myDiagramDiv" style="width: 80%; height: 320px; border: solid 1px black"></div>
	    <div id="rightDiv" style="width: 200px; height: 320px; border: solid 1px black">
	    	<div id="properties" style="display: none;">
	    		<input>
	    	</div>
	    </div>
	  </div>
	  <button id="SaveButton" onclick="save()" style="display: none;">Save</button>
	  <button onclick="load()" style="display: none;">Load</button>
	  <div style="height: 20px;"></div>
	  数量：<input id="quantity" name="quantity">
	  班次：<select id="zd">
	  	<option>8</option>
	  	<option>11</option>
	  	<option>24</option>
	  </select>
	  <button onclick="generateCharts()" style="height: 40px;">generateCharts</button>
	  <textarea id="mySavedModel" style="width:100%;height:300px;display: none;">
{ "class": "go.GraphLinksModel",
  "linkFromPortIdProperty": "fromPort",
  "linkToPortIdProperty": "toPort",
  "nodeDataArray": [ 
{"category":"Start", "text":"开始", "key":-1, "loc":"-601 227"},
{"category": "process", "text":"工序1", "key":-2, "loc":"-471 227", "time":"8"},
{"category": "process", "text":"工序2.1", "key":-3, "loc":"-283 169", "time":"10"},
{"category": "process", "text":"工序2.2", "key":-4, "loc":"-285 287", "time":"5"},
{"category": "process", "text":"工序3.1", "key":-5, "loc":"-125 140", "time":"5"},
{"category": "process", "text":"工序3.2", "key":-6, "loc":"-126 199", "time":"4"},
{"category": "process", "text":"工序3.3", "key":-7, "loc":"-132 287", "time":"7"},
{"category": "process", "text":"工序4", "key":-8, "loc":"92 218", "time":"8"},
{"category":"End", "text":"结束", "key":-9, "loc":"231 218"}
 ],
  "linkDataArray": [ 
{"from":-1, "to":-2, "fromPort":"R", "toPort":"L", "points":[-579.1821700805842,227,-565.7906976744185,227,-556.1453488372092,227,-556.1453488372092,227,-546.5,227,-536.5,227]},
{"from":-2, "to":-3, "fromPort":"R", "toPort":"L", "points":[-405.5,227,-395.5,227,-377,227,-377,169,-358.5,169,-348.5,169]},
{"from":-2, "to":-4, "fromPort":"R", "toPort":"L", "points":[-405.5,227,-395.5,227,-378,227,-378,287,-360.5,287,-350.5,287]},
{"from":-3, "to":-5, "fromPort":"R", "toPort":"L", "points":[-217.5,169,-207.5,169,-204,169,-204,140,-200.5,140,-190.5,140]},
{"from":-3, "to":-6, "fromPort":"R", "toPort":"L", "points":[-217.5,169,-207.5,169,-204.5,169,-204.5,199,-201.5,199,-191.5,199]},
{"from":-4, "to":-7, "fromPort":"R", "toPort":"L", "points":[-219.5,287,-209.5,287,-208.5,287,-208.5,287,-207.5,287,-197.5,287]},
{"from":-5, "to":-8, "fromPort":"R", "toPort":"L", "points":[-59.5,140,-49.5,140,-16.5,140,-16.5,218,16.5,218,26.5,218]},
{"from":-6, "to":-8, "fromPort":"R", "toPort":"L", "points":[-60.5,199,-50.5,199,-17,199,-17,218,16.5,218,26.5,218]},
{"from":-7, "to":-8, "fromPort":"R", "toPort":"L", "points":[-66.5,287,-56.5,287,-20,287,-20,218,16.5,218,26.5,218]},
{"from":-8, "to":-9, "fromPort":"R", "toPort":"L", "points":[157.5,218,167.5,218,183.82558139534882,218,183.82558139534882,218,200.15116279069767,218,210.15116279069767,218]}
 ]}
	  </textarea>
	  <button onclick="makeSVG()" style="display: none;">Render as SVG</button>
	  <div id="SVGArea"></div>
	</div>
	<div id="main" style="width: 100%;height:600px;"></div>
  </body>
</html>
