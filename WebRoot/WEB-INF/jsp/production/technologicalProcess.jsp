<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.chiucheung.cn" prefix="p" %>
<!DOCTYPE html>
<html>
  <head>
    <title>产品数据</title>
	<jsp:include page="/common.jsp"></jsp:include>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/go.js"></script>
  </head>
  <script type="text/javascript">
	var myPalette;
	var graphLinksModel = [];
	var originalGraphLinksModel = {};
  	$(function () {
		var $$ = go.GraphObject.make;  // for conciseness in defining templates
	    myDiagram =
	      $$(go.Diagram, "myDiagramDiv",  // must name or refer to the DIV HTML element
	        {
	          initialContentAlignment: go.Spot.Center,
              //必须为true才能接受调色板中的放置
	          allowDrop: true,
	          allowCopy: false,
	          allowClipboard: false,
	          //allowUndo: false,//不允许撤销
              //链接绘制
	          "LinkDrawn": showLinkLabel,  // this DiagramEvent listener is defined below
              //链接重新链接
	          "LinkRelinked": showLinkLabel,
	          scrollsPageOnFocus: false,
	          //"undoManager.isEnabled": true  // enable undo & redo
	        });
	    // when the document is modified, add a "*" to the title and enable the "Save" button
	    /* myDiagram.addDiagramListener("Modified", function(e) {
	      var button = document.getElementById("SaveButton");
	      if (button) button.disabled = !myDiagram.isModified;
	      var idx = document.title.indexOf("*");
	      if (myDiagram.isModified) {
	        if (idx < 0) document.title += "*";
	      } else {
	        if (idx >= 0) document.title = document.title.substr(0, idx);
	      }
	    }); */
	    
	    
		
		//从外部拖放到图表中的事件
	    myDiagram.addDiagramListener("ExternalObjectsDropped", function(e) {
	    	/* var select = myPalette.selection.sd;
	    	for(var key in select){
	    		var dropData = select[key].value.Yd;
	    	}//获取到了key，然后debug取值 */
	    	myPalette.selection.each(function(node) {
	    		var dropData = node.data;
	    		for (var i=0;i<graphLinksModel.length;i++){
	    			if (dropData.category == "process"){
			    		if (dropData.proProcessId == graphLinksModel[i].proProcessId){
			    			graphLinksModel.splice(i,1);
			    			break;
			    		}
	    			}else{
	    				if (dropData.category == graphLinksModel[i].category){
			    			graphLinksModel.splice(i,1);
			    			break;
			    		}
	    			}
		    	}
	    		
	    	});
	    	//设置加载的停止未来的动画
	    	myPalette.animationManager.isEnabled = false;
	    	//重新设置
	    	myPalette.model = new go.GraphLinksModel(graphLinksModel);
	    });
		
		//删除时候的事件
	    myDiagram.addDiagramListener("SelectionDeleting", function(e) {
	    	/* e.subject.each(function(node) {
	            var data = node.data;
	          }); */
	    	myDiagram.selection.each(function(node) {
	    		var deleteData = node.data;
	    		if(deleteData.category == "Start"){
	    			graphLinksModel.push({ category: "Start", text: "开始" });
		    	}else if (deleteData.category == "End"){
					graphLinksModel.push({ category: "End", text: "结束" });
		    	}else if (deleteData.category == "process"){
		    		var b = true;
		    		for (var i=0;i<graphLinksModel.length;i++){
		    			if (graphLinksModel[i].proProcessId == deleteData.proProcessId){
		    				b = false;
		    				if (graphLinksModel[i].totalTime*1 + deleteData.totalTime*1 == 0){
		    					graphLinksModel.splice(i,1);
		    				}else{
		    					myPalette.model.setDataProperty(graphLinksModel[i], "totalTime", numberToFixed(graphLinksModel[i].totalTime*1 + deleteData.totalTime*1,2));
		    				}
		    				break;
		    			}
		    		}
		    		if (b){
		    			graphLinksModel.push(deleteData);	
		    		}
		    	}
	    	});
	    	//设置加载的停止未来的动画
	    	myPalette.animationManager.isEnabled = false;
	    	//重新设置
	    	myPalette.model = new go.GraphLinksModel(graphLinksModel);
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
	      return $$(go.Shape, "Circle",
	               {
	                   //填充属性:透明
	                  fill: "transparent",
                       //边框属性
	                  stroke: null,  // 在ShowPorts方法中将此更改为“白色”
                       //尺寸属性
	                  desiredSize: new go.Size(8, 8),
                       //对齐属性和对齐焦点属性
	                  alignment: spot, alignmentFocus: spot,  // 将端口与主形状对齐
	                  portId: name,  // 将此对象声明为“端口”
	                  fromSpot: spot, toSpot: spot,  // 声明链接在此端口的连接位置
	                  fromLinkable: output, toLinkable: input,  // 声明用户是否可以从此处绘制链接
	                  cursor: "pointer"  // 显示不同的光标以指示潜在的链接点
	               });
	    }
	    // define the Node templates for regular nodes
	    var lightText = 'whitesmoke';
	    myDiagram.nodeTemplate =
	        $$(go.Node, "Auto", nodeStyle(),
	          $$(go.Shape, "Rectangle",
	            { fill: '#00a9c9', stroke: null },
	            // Shape.fill is bound to Node.data.color
	            new go.Binding("fill", "color")),
	          $$(go.Panel, "Table",
	            $$(go.RowColumnDefinition, { row: 0}),
	            $$(go.RowColumnDefinition, { row: 1}),
	            $$(go.RowColumnDefinition, { row: 2, background: "#90dcea" }),
	            
	            $$(go.TextBlock, "",
	              { row: 0,
	                wrap: go.TextBlock.None, margin: 1, width: 60,
	                isMultiline: false, editable: false, textAlign: 'center',
	                font: '8pt  Segoe UI,sans-serif', stroke: 'white' },
	              new go.Binding("text","processName").makeTwoWay()),
	              
				$$(go.TextBlock, "",
   	              { row: 1,
   	                wrap: go.TextBlock.None, margin: 1, width: 60,
   	                isMultiline: false, editable: false, textAlign: 'center',
   	                font: '8pt  Segoe UI,sans-serif', stroke: 'white' },
   	              new go.Binding("text","processCategory").makeTwoWay()),
	              
	            $$(go.TextBlock, "",
	              { row: 2,
	                wrap: go.TextBlock.None, margin: 1, width: 60,
	                isMultiline: false, editable: true, textAlign: 'center',
	                font: '10pt  Segoe UI,sans-serif', stroke: 'black',
	                textValidation: function(textBlock, oldstr, newstr){
	                	var editData = textBlock.part.data;
	                	if (!/^[0-9]+([.]{1}[0-9]{1,2})?$/.test(newstr)){
	                		return false;
	                	}
	                	
	                	var nodeDataArray = myDiagram.model.nodeDataArray;//myDiagram里所有的part
	                	
	                	var totalTime = 0;//记录myDiagram所有当前编辑的工序工时总和
	                	var b = true;//用来记录只有一次
	                	for (var i=0;i<nodeDataArray.length;i++){
	                		if (nodeDataArray[i].proProcessId == editData.proProcessId){
	                			if (oldstr == nodeDataArray[i].totalTime && b){//这里的nodeDataArray还是没更改的数据，所以当proProcessId相同，并且totalTime和oldstr相同，应该是加newstr
	                				b = false;//只会进来一次
	                				totalTime = totalTime + newstr*1;
	                			}else{
	                				totalTime = totalTime + nodeDataArray[i].totalTime*1;
	                			}
	                		}
	                	}
	                	
	                	if (totalTime*1 > originalGraphLinksModel[editData.proProcessId].totalTime*1 || newstr*1 <= 0){
	                		return false;
	                	}
	                	return true;//返回校验的结果
	                },
	                textEdited: function(textBlock, previousText, currentText){
	                	var editData = textBlock.part.data;
	                	var originalData = originalGraphLinksModel[editData.proProcessId];
	                	var copyOriginalData = JSON.parse(JSON.stringify(originalData));//深度克隆，为了不改变原始的数据
	                	var nodeDataArray = myDiagram.model.nodeDataArray;//myDiagram里所有的part
	                	
	                	var paletteData = null;//存储palette里存在编辑的数据
	                	for (var i=0;i<graphLinksModel.length;i++){
	                		if (graphLinksModel[i].proProcessId == editData.proProcessId){
	                			paletteData = graphLinksModel[i];
	                			break;
	                		}
	                	}
	                	var totalTime = 0;//记录myDiagram所有当前编辑的工序工时总和
	                	for (var i=0;i<nodeDataArray.length;i++){
	                		if (nodeDataArray[i].proProcessId == editData.proProcessId){
	                			totalTime = totalTime + nodeDataArray[i].totalTime*1;
	                		}
	                	}
	                	
	                	if (paletteData == null){
		                	if (copyOriginalData.totalTime - totalTime > 0){
		                		copyOriginalData.totalTime = numberToFixed(copyOriginalData.totalTime - totalTime, 2);
			                	graphLinksModel.push(copyOriginalData);
			                	myPalette.model = new go.GraphLinksModel(graphLinksModel);
		                	}
	                	}else{
	                		if (copyOriginalData.totalTime == totalTime){//则左边有的需要删除,因为右边已经设置了所有的时间
	                			for (var i=0;i<graphLinksModel.length;i++){
	    	                		if (graphLinksModel[i].proProcessId == editData.proProcessId){
	    	                			graphLinksModel.splice(i,1);
	    				    			break;
	    	                		}
	    	                	}
	                			myPalette.model = new go.GraphLinksModel(graphLinksModel);
	                		}else if (copyOriginalData.totalTime > totalTime){//则左边的设置为copyOriginalData.totalTime - totalTime
			                	myPalette.model.setDataProperty(paletteData, "totalTime", numberToFixed(originalData.totalTime - totalTime, 2));
		                	}
	                	}
	                	myDiagram.model.setDataProperty(editData, "totalTime", numberToFixed(currentText, 2));
	                }},
	              new go.Binding("text","totalTime").makeTwoWay())
	          ),
	          
	          makePort("T", go.Spot.Top, false, true),
	          makePort("L", go.Spot.Left, true, true),
	          makePort("R", go.Spot.Right, true, true),
	          makePort("B", go.Spot.Bottom, true, false)
	        );

	    myDiagram.nodeTemplateMap.add("Start",
	      $$(go.Node, "Spot", nodeStyle(),
	        $$(go.Panel, "Auto",
	          $$(go.Shape, "Circle",
	            { minSize: new go.Size(40, 40), fill: "#79C900", stroke: null }),
	          $$(go.TextBlock, "Start",
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
	      $$(go.Node, "Spot", nodeStyle(),
	        $$(go.Panel, "Auto",
	          $$(go.Shape, "Circle",
	            { minSize: new go.Size(40, 40), fill: "#DC3C00", stroke: null }),
	          $$(go.TextBlock, "End",
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
	      $$(go.Link,  // the whole link panel
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
	        $$(go.Shape,  // the highlight shape, normally transparent
	          { isPanelMain: true, strokeWidth: 8, stroke: "transparent", name: "HIGHLIGHT" }),
	        $$(go.Shape,  // the link path shape
	          { isPanelMain: true, stroke: "gray", strokeWidth: 2 }),
	        $$(go.Shape,  // the arrowhead
	          { toArrow: "standard", stroke: null, fill: "gray"}),
	        $$(go.Panel, "Auto",  // the link label, normally not visible
	          { visible: false, name: "LABEL", segmentIndex: 2, segmentFraction: 0.5},
	          new go.Binding("visible", "visible").makeTwoWay(),
	          $$(go.Shape, "RoundedRectangle",  // the label shape
	            { fill: "#F8F8F8", stroke: null }),
	          $$(go.TextBlock, "Yes",  // the label
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
	    
	    
	    $.ajax({
			type:'POST',//post请求
			url: '${pageContext.request.contextPath}/production/productTechnologyWorkHours/getAllProcessToalTimes.action?id=${id}',//ajax请求的url
			async: false,//同步请求
			cache: false,//不缓存此页面
			success: function(data){//请求成功后的回调函数。data：服务器返回数据。
				if (data.success){
					for (var i=0;i<data.original.length;i++){
						originalGraphLinksModel[data.original[i].proProcessId] = data.original[i];
					}
					/* graphLinksModel.push({ category: "Start", text: "开始" });
					graphLinksModel = graphLinksModel.concat(data.data);
					graphLinksModel.push({ category: "End", text: "结束" }); */
					graphLinksModel = data.data;
					myPalette =
					      $$(go.Palette, "myPaletteDiv",  // must name or refer to the DIV HTML element
					        {
					          scrollsPageOnFocus: false,
					          nodeTemplateMap: myDiagram.nodeTemplateMap,  // share the templates used by myDiagram
					          model: new go.GraphLinksModel(data.data)
					        });
					load(data.nodeDataArray,data.linkDataArray);
				}else{
					showMessager("错误",data.message);
				}
			}
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
	    //alert(myDiagram.model.toJson());
	    var json = {};
	    if(myPalette.model.nodeDataArray.length > 0){
	    	json.success = false;
	    	json.message = "请将所有的节点拖入，并连线";
	    	return json;
	    }
	    if (myDiagram.model.nodeDataArray.length < 3){
	    	json.success = false;
	    	json.message = "当前节点数少于三个，至少拥有一个开始节点、一个工序节点、一个结束节点";
	    	return json;
	    }
	    if (myDiagram.model.nodeDataArray.length > myDiagram.model.linkDataArray.length + 1){
	    	json.success = false;
	    	json.message = "有节点没有连线";
	    	return json;
	    }
	    
	    json.success = true;
	    
	    var data = myDiagram.model.toJson();
	    
	    data = JSON.parse(data);
	    data.proProductTechnologyWorkHoursId = '${id}';
	    data.image = myDiagram.makeImageData({
	        scale: 1
	      });
	    json.data = JSON.stringify(data);
	    
	    return json;
	    //myDiagram.isModified = false;
	  }
	  function load(nodeDataArray, linkDataArray) {
	    myDiagram.model = go.Model.fromJson({"class": "go.GraphLinksModel",
			"linkFromPortIdProperty": "fromPort",
			"linkToPortIdProperty": "toPort",
			"nodeDataArray": nodeDataArray,
			"linkDataArray": linkDataArray});
	    /* "linkFromPortIdProperty": "fromPort",
	    * "linkToPortIdProperty": "toPort",
	    * 主要是要加载这个，其他默认都有，加载了这个才会记录连线的两端，分别是两个part的T(上)、L(左)、R(右)、B(下)，的哪个位置，可以多点连线
	    */
	  }
	  // add an SVG rendering of the diagram at the end of this page
	  function makeSVG() {
		  var image = myDiagram.makeImage({
		        scale: 1
		      });
		  document.getElementById("SVGArea").appendChild(image);
	    /* var svg = myDiagram.makeSvg({
	        scale: 1
	      });
	    svg.style.border = "1px solid black";
	    obj = document.getElementById("SVGArea");
	    obj.appendChild(svg);
	    if (obj.children.length > 0) {
	      obj.replaceChild(svg, obj.children[0]);
	    } */
	  }
	  
	  function numberToFixed(obj,num){//如果小数点后面不是两位，则截取两位小数点
		  	obj = parseFloat(obj);
			obj = obj.toFixed(num);
			return obj;
		}
  </script>
  <body>
	<div style="text-align: center;"></div>
	  <div style="width: 100%; display: flex; justify-content: space-between">
	    <div id="myPaletteDiv" style="width: 300px; margin-right: 2px; background-color: whitesmoke; border: solid 1px black"></div>
	    <div id="myDiagramDiv" style="width: 100%; height: 503px; border: solid 1px black"></div>
	  </div>
  </body>
</html>
