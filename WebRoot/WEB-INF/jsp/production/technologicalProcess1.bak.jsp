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
  	var flag = false;//用于标识是否是节点点击，如果是节点点击则为true（需要加载type），否则为false（自己选的process，type要重新加载，并且清空type的值），为true时，type要设置值，否则type不用设置值
	$(function () {
		var $$ = go.GraphObject.make;  // for conciseness in defining templates
	    myDiagram =
	      $$(go.Diagram, "myDiagramDiv",  // must name or refer to the DIV HTML element
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
	    
	    var data;//用于下面的方法中存放选择的object的数据，用于后面设置数据
	    //节点点击事件
	    myDiagram.addDiagramListener("ObjectSingleClicked", function(e) {
	    	$("#process").combobox('hidePanel');
    		$("#type").combobox('hidePanel');
    		
	    	//Select_Port = e.subject.part.data.key;    e.subject.part.data即获取到的data
	    	if(e.subject.part.data.category == "Start" || e.subject.part.data.category == "End"){
	    		document.getElementById("properties").style.display = "none";
	    	}else if (e.subject.part.data.key != undefined){
	    		document.getElementById("properties").style.display = "block";
	    		//e.subject.part.data.text = "1";
	    		data = e.subject.part.data;
	    		$('#process').combobox('setValue',data.processName);
	    		$('#time').textbox('setText',data.time);
	    		flag = true;
	    		//$('#type').combobox('setValue',e.subject.part.data.processId);//要放到后面type的combobox的loadSuccess里，放在这里会有问题
	    		//myDiagram.model.setDataProperty(e.subject.part.data, "text", 1);
	    		//myDiagram.model.setDataProperty(e.subject.part.data, "id", 3);
	    	}else{
	    		document.getElementById("properties").style.display = "none";
	    	}
	    });
	    
		//画布空白即背景点击事件
	    myDiagram.addDiagramListener("BackgroundSingleClicked", function(e) {
			$("#process").combobox('hidePanel');
	    	$("#type").combobox('hidePanel');
			document.getElementById("properties").style.display = "none";
	    });
		
		//从外部拖放到图表中的事件
	    myDiagram.addDiagramListener("ExternalObjectsDropped", function(e) {
	    	$("#process").combobox('hidePanel');
	    	$("#type").combobox('hidePanel');
	    	if(e.subject.Ea.value.data.category == "Start" || e.subject.Ea.value.data.category == "End"){
	    		document.getElementById("properties").style.display = "none";
	    	}else if (e.subject.Ea.value.data.category == "process"){
	    		document.getElementById("properties").style.display = "block";
	    		data = e.subject.Ea.value.data;
	    		$('#process').combobox('setValue',data.processName);
	    		$('#time').textbox('setText',data.time);
	    		/* $("#process").combobox('clear');
	    		//$("#type").combobox('unselect',$("#type").combobox('getValue'));
	    		$("#type").combobox('clear'); */
	    	}
	    });
		
		//粘贴时候的事件
	    myDiagram.addDiagramListener("ClipboardPasted", function(e) {
	    	data = e.subject.Ea.value.data;
	    });
		
		//删除时候的事件
	    myDiagram.addDiagramListener("SelectionDeleted", function(e) {
	    	$("#process").combobox('hidePanel');
	    	$("#type").combobox('hidePanel');
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
	      return $$(go.Shape, "Circle",
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
	        $$(go.Node, "Auto", nodeStyle(),
	          $$(go.Shape, "Rectangle",
	            { fill: '#00a9c9', stroke: null },
	            // Shape.fill is bound to Node.data.color
	            new go.Binding("fill", "color")),
	          $$(go.Panel, "Table",
	            $$(go.RowColumnDefinition, { column: 0, separatorStroke: "00a9c9" }),
	            $$(go.RowColumnDefinition, { column: 1, separatorStroke: "00a9c9" }),
	            $$(go.RowColumnDefinition, { column: 2, background: "#90dcea" }),
	            
	            $$(go.TextBlock, "",
	              { column: 0,
	                wrap: go.TextBlock.None, margin: 5, width: 45,
	                isMultiline: false, editable: false, textAlign: 'center',
	                font: '10pt  Segoe UI,sans-serif', stroke: 'white' },
	              new go.Binding("text","processName").makeTwoWay()),
	              
				$$(go.TextBlock, "",
   	              { column: 1,
   	                wrap: go.TextBlock.None, margin: 5, width: 45,
   	                isMultiline: false, editable: false, textAlign: 'center',
   	                font: '10pt  Segoe UI,sans-serif', stroke: 'white' },
   	              new go.Binding("text","processCategory").makeTwoWay()),
	              
	            $$(go.TextBlock, "",
	              { column: 2,
	                wrap: go.TextBlock.None, margin: 2, width: 25,
	                isMultiline: false, editable: false, textAlign: 'center',
	                font: '10pt  Segoe UI,sans-serif', stroke: 'black' },
	              new go.Binding("text","time").makeTwoWay())
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
	    load();  // load an initial diagram from some JSON text
	    // initialize the Palette that is on the left side of the page
	    myPalette =
	      $$(go.Palette, "myPaletteDiv",  // must name or refer to the DIV HTML element
	        {
	          scrollsPageOnFocus: false,
	          nodeTemplateMap: myDiagram.nodeTemplateMap,  // share the templates used by myDiagram
	          model: new go.GraphLinksModel([  // specify the contents of the Palette
	            { category: "Start", text: "开始" },
	            { category: "process",processName: "",processCategory: "",processId: "", time: ""},
	            /* { text: "???", figure: "Diamond" }, */
	            { category: "End", text: "结束" },
	            /* { category: "Comment", text: "Comment" } */
	          ])
	        });
	    
	    
	    myPalette.addDiagramListener("ObjectSingleClicked", function(e) {
	    	
	    });
	    myPalette.addDiagramListener("BackgroundSingleClicked", function(e) {
    		
	    });
	    
	    
	    $('#process').combobox({    
		    url:"${pageContext.request.contextPath}/production/technologicalProcess/findAllDistinctProcess.action",//加载数据的url
		    valueField:'processName',//相当于select的key
		    textField:'processName',//相当于select的value
		    editable:false,//不允许编辑
		    onChange:function(newValue,oldValue){
		    	myDiagram.model.setDataProperty(data, "processName", newValue);
		    	$('#type').combobox({    
				    url:"${pageContext.request.contextPath}/production/technologicalProcess/findAllProcessByProcessName.action",//加载数据的url
				    queryParams: {//url的参数
						"processName" : newValue
					}
				});
		    }
		});
	    $('#type').combobox({
	    	valueField:'id',//相当于select的key
		    textField:'processCategory',//相当于select的value
		    editable:false,//不允许编辑
		    onChange:function(newValue,oldValue){
		    	myDiagram.model.setDataProperty(data, "processId", newValue);
		    	myDiagram.model.setDataProperty(data, "processCategory", $('#type').combobox('getText'));
		    },
		    onLoadSuccess:function(){
		    	//alert(data.processId);
		    	if (flag){
		    		$('#type').combobox('select',data.processId);
		    		flag = false;
		    	}else{
		    		myDiagram.model.setDataProperty(data, "processId", "");
			    	myDiagram.model.setDataProperty(data, "processCategory", "");
		    	}
		    }
	    });
	    $('#time').textbox('textbox').bind('input propertychange', function() {
	    	if ($('#time').textbox('isValid')){
	    		myDiagram.model.setDataProperty(data, "time", $('#time').textbox('getText'));
	    	}else{
	    		myDiagram.model.setDataProperty(data, "time", "");
	    	}
	    });
	    
	    /* $('#type').combobox({    
		    url:"${pageContext.request.contextPath}/warehouse/baseData/findAllWarBaseDataByKeyword.action",//加载数据的url
		    queryParams: {//url的参数
				"keyword" : "单位"
			},
		    valueField:'dictionarieCode',//相当于select的key
		    textField:'dictionarieName',//相当于select的value
		    editable:false//不允许编辑
		}); */
	    
	    
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
	    //myDiagram.model = go.Model.fromJson(document.getElementById("mySavedModel").value);
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
  </script>
  <body>
	<div id="sample">
	<div style="text-align: center;">工艺流程</div>
	  <div style="width: 100%; display: flex; justify-content: space-between">
	    <div id="myPaletteDiv" style="width: 200px; margin-right: 2px; background-color: whitesmoke; border: solid 1px black"></div>
	    <div id="myDiagramDiv" style="width: 100%; height: 320px; border: solid 1px black"></div>
	    <div id="rightDiv" style="width: 200px; height: 320px; border: solid 1px black">
	    	<div id="properties" style="display: none;">
	    		工序：<input id="process" type="text" style="width: 100px"><br>
	    		类别：<input id="type" type="text" style="width: 100px"><br>
	    		工时：<input id="time" type="text" style="width: 100px" class="easyui-textbox" data-options="validType:'positiveDecimal'">
	    	</div>
	    </div>
	  </div>
	  <button id="SaveButton" onclick="save()">Save</button>
	  <button onclick="load()" style="display: none;">Load</button>
	  <div style="height: 20px;"></div>
	  数量：<input id="quantity" name="quantity">
	  班次：<select id="zd">
	  	<option>8</option>
	  	<option>11</option>
	  	<option>24</option>
	  </select>
	  <button onclick="generateCharts1()" style="height: 40px;">generateCharts</button>
	  <textarea id="mySavedModel" style="width:100%;height:300px;">
{ "class": "go.GraphLinksModel",
  "linkFromPortIdProperty": "fromPort",
  "linkToPortIdProperty": "toPort",
  "nodeDataArray": [ 
{"category":"Start", "text":"开始", "key":-1, "loc":"-601 227"},
{"category": "process", "processName":"工序1", "key":-2, "loc":"-471 227", "time":"8"},
{"category": "process", "processName":"工序2.1", "key":-3, "loc":"-283 169", "time":"10"},
{"category": "process", "processName":"工序2.2", "key":-4, "loc":"-285 287", "time":"5"},
{"category": "process", "processName":"工序3.1", "key":-5, "loc":"-125 140", "time":"5"},
{"category": "process", "processName":"工序3.2", "key":-6, "loc":"-126 199", "time":"4"},
{"category": "process", "processName":"工序3.3", "key":-7, "loc":"-132 287", "time":"7"},
{"category": "process", "processName":"工序4", "key":-8, "loc":"92 218", "time":"8"},
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
	<div id="main" style="width: 100%;height:1000px;"></div>
  </body>
</html>
