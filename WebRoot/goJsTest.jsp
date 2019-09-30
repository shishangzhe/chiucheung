<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>    
    <title>goJs测试页面</title>
    <script src="${pageContext.request.contextPath}/js/go.js"></script> 
    <script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5.5.4/jquery.min.js"></script>   
  </head>
   
  <body>
    <div style="width: 100%; display: flex; justify-content: space-between">
	   <div id="myPaletteDiv" style="width: 300px; margin-right: 2px; background-color: whitesmoke; border: solid 1px black"></div>
	   <div id="myDiagramDiv" style="width: 100%; height: 503px; border: solid 1px black"></div>
	</div>
  </body>
  
  <script type="text/javascript">
	//指定调色板的内容
  var graphLinksModel = [  
        //{text: "模块内容", figure: "形状", fill: "颜色"},值可以接受变量
        {key: "接听",},
        {key: "确认身份"},
        {key: "还款提醒"},
        {key: "应答",},
        {key: "处理"},
        {key: "挂机2",}
    ];
  
	//创建画布
	var $$ = go.GraphObject.make;
	myDiagram =
	      $$(go.Diagram, "myDiagramDiv",
	        {
	          initialContentAlignment: go.Spot.Center,
	          //必须为true才能接受调色板中的放置
	          allowDrop: true,
	          allowCopy: false,
	          allowClipboard: false,
	          //allowUndo: false,//不允许撤销
	          //下面定义了此DiagrameEvent侦听器
	          /* "LinkDrawn": showLinkLabel, */
	          scrollsPageOnFocus: false,
	          //"undoManager.isEnabled": true  // enable undo & redo
	        });
	
	//创建最基本的Model对象
    var myModel = $$(go.Model);
    // model中的数据每一个js对象都代表着一个相应的模型图中的元素
    myModel.nodeDataArray = [
        { name: "工厂", fig: 'YinYang', fill2: 'blue' },
        { name: "车间", fig: 'Peace', fill2: 'red' },
        { name: "工人", fig: 'NotAllowed', fill2: 'green' },
        { name: "岗位", fig: 'Fragile', fill2: 'yellow' },
    ];
  	//将模型数据绑定到画布图上
    /* myDiagram.model = myModel; */
  	
  	//创建节点模板
  	myDiagram.nodeTemplate=
  		$$(go.Node,"Auto",
            {mouseEnter:mouseEnter,mouseLeave:mouseLeave},
  			$$(go.Shape,"RoundedRectangle",
  				//如果data.highlight值未定义,使用默认值
  				{fill:"white",stroke:"orange",strokeWidth:2,name:"SHAPE"},
  				new go.Binding("fill", "highlight", function(v) { return v ? "pink" : "lightblue"; }),
  		        new go.Binding("stroke", "highlight", function(v) { return v ? "red" : "blue"; }),
  		        new go.Binding("strokeWidth", "highlight", function(v) { return v ? 3 : 1; })),
  			$$(go.TextBlock,
  				{margin:5,name:"TEXT"},
  				new go.Binding("text","key")),
  				//从data.loc值获取node.location
  				new go.Binding("location","loc",go.Point.parse)
  			);

  	  var nodeDataArray = [
  	    { key: "Alpha", color: "lightblue", loc: "0 0",highlight:false},
  	    { key: "Beta", color: "pink", loc: "100 50",highlight:true},
  	    //highlight属性未定义:使用默认值
  	    {key:"Gamma",color:"green",loc:"0 100"}
  	  ];
  	  var linkDataArray = [
  	    { from: "Alpha", to: "Beta", color: "blue", thick: 2 }
  	  ];
  	myDiagram.model = new go.GraphLinksModel(nodeDataArray, linkDataArray);
  	
  	function flash(){
  		myDiagram.model.commit(function(m){
  			var data = m.nodeDataArray[0];
  			m.set(data,"highlight",!data.highlight);
  		},"flash");
  	}
  	
  	function loop(){
  		setTimeout(function() { flash(); loop();},500);
  	}
  	loop();

    function mouseEnter(e, obj) {
        var shape = obj.findObject("SHAPE");
        shape.fill = "#6DAB80";
        shape.stroke = "#A6E6A1";
        var text = obj.findObject("TEXT");
        text.stroke = "white";
    };

    function mouseLeave(e, obj) {
        var shape = obj.findObject("SHAPE");
        // Return the Shape's fill and stroke to the defaults
        shape.fill = obj.data.color;
        shape.stroke = null;
        // Return the TextBlock's stroke to its default
        var text = obj.findObject("TEXT");
        text.stroke = "black";
    };
  	
  	
    //创建调色板(Palette)
	myPalette =
		$$(go.Palette, "myPaletteDiv",  // must name or refer to the DIV HTML element
	        {
	    	  //控制焦点滚动事件
	          scrollsPageOnFocus: false,
	          //共享myDiagram使用的模板
	          nodeTemplateMap: myDiagram.nodeTemplateMap,
	          //指定调色板内容
	          model: new go.GraphLinksModel(graphLinksModel)
	        });
    
    //创建几何形状
   /*  var W_geometry = go.Geometry.parse("M 0,0 L 10,50 20,10 30,50 40,0",false);
    myDiagram.add(
    	$$(go.Part,"Horizontal",
    		$$(go.Shape,{geometry:W_geometry,strokeWidth:2}),
    		$$(go.Shape,{geometry:W_geometry,stroke:"blue",strokeWidth:10,
    			strokeJoin:"miter",strokeCap:"butt"}),
    		$$(go.Shape, { geometry: W_geometry, stroke: "blue", strokeWidth: 10,
                strokeJoin: "miter", strokeCap: "round" }),
            $$(go.Shape, { geometry: W_geometry, stroke: "blue", strokeWidth: 10,
                strokeJoin: "miter", strokeCap: "square" }),
            $$(go.Shape, { geometry: W_geometry, stroke: "green", strokeWidth: 10,
                strokeJoin: "bevel", strokeCap: "butt" }),
            $$(go.Shape, { geometry: W_geometry, stroke: "green", strokeWidth: 10,
                strokeJoin: "bevel", strokeCap: "round" }),
            $$(go.Shape, { geometry: W_geometry, stroke: "green", strokeWidth: 10,
                strokeJoin: "bevel", strokeCap: "square" }),
            $$(go.Shape, { geometry: W_geometry, stroke: "red", strokeWidth: 10,
                strokeJoin: "round", strokeCap: "butt" }),
            $$(go.Shape, { geometry: W_geometry, stroke: "red", strokeWidth: 10,
                strokeJoin: "round", strokeCap: "round" }),
            $$(go.Shape, { geometry: W_geometry, stroke: "red", strokeWidth: 10,
                strokeJoin: "round", strokeCap: "square" }),
            $$(go.Shape, { geometry: W_geometry, stroke: "purple", strokeWidth: 2,
                strokeDashArray: [4, 2] }),
            $$(go.Shape, { geometry: W_geometry, stroke: "purple", strokeWidth: 2,
                strokeDashArray: [6, 6, 2, 2] })
    	)		
    ); */
    
    /* var bluered = $$(go.Brush, "Linear", { 0.0: "blue", 1.0: "red" });
    var yellowgreen = $$(go.Brush, "Linear", { 0.0: "yellow", 1.0: "green" });
    var grays = $$(go.Brush, "Linear", { 0.0: "black", 1.0: "lightgray" });

    myDiagram.add(
      $$(go.Part, "Table",
        $$(go.Shape, { row: 0, column: 0,
                      figure: "Club", width: 40, height: 40, angle: 0, scale: 1.5,
                      fill: bluered,
                      background: yellowgreen,
                      areaBackground: grays
                    }),
        $$(go.Shape, { row: 0, column: 1, width: 10, fill: null, stroke: null }),
        $$(go.Shape, { row: 0, column: 2,
                      figure: "Club", width: 40, height: 40, angle: 45, scale: 1.5,
                      fill: bluered,
                      background: yellowgreen,
                      areaBackground: grays
                    })
      )); */
      
      //自定义形状
      //静态函数Shape.defineFigureGenerator可以用来定义新的图形名
     /* go.Shape.defineFigureGenerator("RoundedTopRectangle", function(shape, w, h) {
          //这个数字有一个参数，角的大小
          var p1 = 10;  //默认角大小
          if (shape !== null) {
              var param1 = shape.parameter1;
              //不能是负数或NaN
              if (!isNaN(param1) && param1 >= 0) p1 = param1;
          }
          p1 = Math.min(p1, w / 2);
          p1 = Math.min(p1, h / 2);  // 以全高或半高限制？
          var geo = new go.Geometry();
          // 由直线和四分之一圆弧组成的单个图形
          geo.add(new go.PathFigure(0, p1)
              .add(new go.PathSegment(go.PathSegment.Arc, 180, 90, p1, p1, p1, p1))
              .add(new go.PathSegment(go.PathSegment.Line, w - p1, 0))
              .add(new go.PathSegment(go.PathSegment.Arc, 270, 90, w - p1, p1, p1, p1))
              .add(new go.PathSegment(go.PathSegment.Line, w, h))
              .add(new go.PathSegment(go.PathSegment.Line, 0, h).close()));
          // 在“自动”面板中使用时，不要与两个顶角相交
          geo.spot1 = new go.Spot(0, 0, 0.3 * p1, 0.3 * p1);
          geo.spot2 = new go.Spot(1, 1, -0.3 * p1, 0);
          return geo;
      });

      go.Shape.defineFigureGenerator("RoundedBottomRectangle", function(shape, w, h) {
          // 这个数字有一个参数，角的大小
          var p1 = 5;  // 默认角大小
          if (shape !== null) {
              var param1 = shape.parameter1;
              //不能是负数或NaN
              if (!isNaN(param1) && param1 >= 0) p1 = param1;
          }
          p1 = Math.min(p1, w / 2);
          p1 = Math.min(p1, h / 2);  // 以全高或半高限制？
          var geo = new go.Geometry();
          // 由直线和四分之一圆弧组成的单个图形
          geo.add(new go.PathFigure(0, 0)
              .add(new go.PathSegment(go.PathSegment.Line, w, 0))
              .add(new go.PathSegment(go.PathSegment.Line, w, h - p1))
              .add(new go.PathSegment(go.PathSegment.Arc, 0, 90, w - p1, h - p1, p1, p1))
              .add(new go.PathSegment(go.PathSegment.Line, p1, h))
              .add(new go.PathSegment(go.PathSegment.Arc, 90, 90, p1, h - p1, p1, p1).close()));
          // 在“自动”面板中使用时，不要与两个下角相交
          geo.spot1 = new go.Spot(0, 0, 0.3 * p1, 0);
          geo.spot2 = new go.Spot(1, 1, -0.3 * p1, -0.3 * p1);
          return geo;
      });

      myDiagram.nodeTemplate =
          $$(go.Part, "Spot",
              {
                  selectionAdorned: false,  // 不显示标准选择句柄
                  resizable: true, resizeObjectName: "SHAPE",  // 用户可以调整形状的大小
                  rotatable: true, rotateObjectName: "SHAPE",  // 用户可以旋转形状
                                                               // 不旋转标签
              },
              $$(go.Shape,
                  {
                      name: "SHAPE",
                      fill: $$(go.Brush, "Linear", { 0.0: "white", 1.0: "gray" }),
                      desiredSize: new go.Size(100, 50)
                  },
                  new go.Binding("figure", "fig"),
                  new go.Binding("parameter1", "p1")),
              $$(go.Panel, "Vertical",
                  $$(go.TextBlock,
                      new go.Binding("text", "fig")),
                  $$(go.TextBlock, { stroke: "blue" },
                      new go.Binding("text", "parameter1", function(p1) { return p1; }).ofObject("SHAPE"))
              )
          );

    myDiagram.model = new go.Model([
          { fig: "RoundedTopRectangle" },
          { fig: "RoundedTopRectangle", p1: 0 },
          { fig: "RoundedTopRectangle", p1: 3 },
          { fig: "RoundedTopRectangle", p1: 10 },
          { fig: "RoundedTopRectangle", p1: 50 },
          { fig: "RoundedTopRectangle", p1: 250 },
          { fig: "RoundedBottomRectangle" },
          { fig: "RoundedBottomRectangle", p1: 0 },
          { fig: "RoundedBottomRectangle", p1: 3 },
          { fig: "RoundedBottomRectangle", p1: 10 },
          { fig: "RoundedBottomRectangle", p1: 50 },
          { fig: "RoundedBottomRectangle", p1: 250 }
      ]);*/

  </script>
  
</html>
