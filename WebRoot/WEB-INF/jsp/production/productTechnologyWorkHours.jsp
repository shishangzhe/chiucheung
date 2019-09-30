<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.chiucheung.cn" prefix="p" %>
<!DOCTYPE html>
<html>
<head>
    <title>产品工艺工时</title>
    <jsp:include page="/common.jsp"></jsp:include>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.edatagrid.js"></script>
</head>

<style>
    .noselect{
        -moz-user-select: none;
        cursor: default;
    }
</style>
<script type="text/javascript">
    //让dialog随着窗口大小的改变而居中
    window.onload=window.onresize = function(){
        //当浏览器小于这个窗口时，将该窗口设置成浏览器大小
        if ($(document.body).width()<$("#dialog1").width()){
            $("#dialog1").dialog({
                closed:$("#dialog1").dialog("options").closed,
                width: $(document.body).width()
            });
        }else{
            $("#dialog1").dialog({
                closed:$("#dialog1").dialog("options").closed,
                width: 1200
            });
        }

        dialog1Resize();

        dialog2Resize();

        $("#dialog4").dialog({//加载一个dialog
            closed:$("#dialog4").dialog("options").closed,
            left:($(document.body).width()-$("#dialog4").width())/2,
            top:($(document.body).height()-74-$("#dialog4").height())/2
        });

        processResize();
        standardAccessoriesIdResize();
        standardAccessoriesResize();

    }

    function dialog1Resize(){
        $("#dialog1").dialog('resize',{
            maxHeight:$(document.body).height(),
            minHeight:400 > $(document.body).height() ? $(document.body).height() : 400
        });
        $("#dialog1").dialog({//加载一个dialog
            closed:$("#dialog1").dialog("options").closed,
            left:($(document.body).width()-$("#dialog1").width())/2,
            top:($(document.body).height()-74-$("#dialog1").height())/2
        });
    }

    function dialog2Resize(){
        $("#dialog2").dialog({//加载一个dialog
            closed:$("#dialog2").dialog("options").closed,
            left:($(document.body).width()-$("#dialog2").width())/2,
            top:($(document.body).height()-74-$("#dialog2").height())/2,
        });
    }

    function processResize(){
        $('#process').combotreegrid('grid').treegrid('resize',{
            maxHeight:$(document.body).height()-100
        });
    }

    function standardAccessoriesIdResize(){
        $('#standardAccessoriesId').combogrid('grid').datagrid('resize',{
            maxHeight:$(document.body).height()-50
        });
    }

    function standardAccessoriesResize(){
        $('#standardAccessories').combogrid('grid').datagrid('resize',{
            maxHeight:$(document.body).height()-100
        });
    }

    $(function () {

        //加载类型的combobox
        $('#accessoriesType_query').combobox({
            url:"${pageContext.request.contextPath}/warehouse/baseData/findAllWarBaseDataByKeyword.action",//加载数据的url
            queryParams: {//url的参数
                "keyword" : "类型"
            },
            valueField:'dictionarieCode',//相当于select的key
            textField:'dictionarieName',//相当于select的value
            editable:false,//不允许编辑
            onLoadSuccess:function(){
                $('#accessoriesType_query2,#accessoriesType_query3').combobox({
                    valueField:'dictionarieCode',//相当于select的key
                    textField:'dictionarieName',//相当于select的value
                    editable:false,//不允许编辑
                });
                $('#accessoriesType_query2').combobox('loadData',$('#accessoriesType_query').combobox('getData'));
                $('#accessoriesType_query3').combobox('loadData',$('#accessoriesType_query').combobox('getData'));
            }
        });
        //加载适用产品的combobox
        $('#product_query').combobox({
            url:"${pageContext.request.contextPath}/warehouse/baseData/findAllWarBaseDataByKeyword.action",//加载数据的url
            queryParams: {//url的参数
                "keyword" : "适用产品"
            },
            valueField:'dictionarieCode',//相当于select的key
            textField:'dictionarieName',//相当于select的value
            editable:false,//不允许编辑
            onLoadSuccess:function(){
                $('#product_query2,#product_query3').combobox({
                    valueField:'dictionarieCode',//相当于select的key
                    textField:'dictionarieName',//相当于select的value
                    editable:false,//不允许编辑
                });
                $('#product_query2').combobox('loadData',$('#product_query').combobox('getData'));
                $('#product_query3').combobox('loadData',$('#product_query').combobox('getData'));

                $('#product').combobox({
                    valueField:'dictionarieCode',//相当于select的key
                    textField:'dictionarieName',//相当于select的value
                    editable:false,//不允许编辑
                    multiple:true
                });
                $('#product').combobox('loadData',$('#product_query').combobox('getData'));
                $('#productDiv').hide();
            }
        });
        //加载分类的combobox
        $('#classification_query').combobox({
            url:"${pageContext.request.contextPath}/warehouse/baseData/findAllWarBaseDataByKeyword.action",//加载数据的url
            queryParams: {//url的参数
                "keyword" : "分类"
            },
            valueField:'dictionarieCode',//相当于select的key
            textField:'dictionarieName',//相当于select的value
            editable:false//不允许编辑
        });
        //加载物料属性的combobox
        $('#materialProperties_query').combobox({
            url:"${pageContext.request.contextPath}/warehouse/baseData/findAllWarBaseDataByKeyword.action",//加载数据的url
            queryParams: {//url的参数
                "keyword" : "物料属性"
            },
            valueField:'dictionarieCode',//相当于select的key
            textField:'dictionarieName',//相当于select的value
            editable:false//不允许编辑
        });
        //加载规格型号的combobox
        $('#specifications_query').combobox({
            url:"${pageContext.request.contextPath}/warehouse/baseData/findAllWarBaseDataByKeyword.action",//加载数据的url
            queryParams: {//url的参数
                "keyword" : "规格型号"
            },
            valueField:'dictionarieCode',//相当于select的key
            textField:'dictionarieName',//相当于select的value
            editable:false//不允许编辑
        });
        //加载高度的combobox
        $('#height_query').combobox({
            url:"${pageContext.request.contextPath}/warehouse/baseData/findAllWarBaseDataByKeyword.action",//加载数据的url
            queryParams: {//url的参数
                "keyword" : "高度"
            },
            valueField:'dictionarieCode',//相当于select的key
            textField:'dictionarieName',//相当于select的value
            editable:false//不允许编辑
        });
        //加载宽度的combobox
        $('#width_query').combobox({
            url:"${pageContext.request.contextPath}/warehouse/baseData/findAllWarBaseDataByKeyword.action",//加载数据的url
            queryParams: {//url的参数
                "keyword" : "宽度"
            },
            valueField:'dictionarieCode',//相当于select的key
            textField:'dictionarieName',//相当于select的value
            editable:false//不允许编辑
        });
        //加载深度的combobox
        $('#depth_query').combobox({
            url:"${pageContext.request.contextPath}/warehouse/baseData/findAllWarBaseDataByKeyword.action",//加载数据的url
            queryParams: {//url的参数
                "keyword" : "深度"
            },
            valueField:'dictionarieCode',//相当于select的key
            textField:'dictionarieName',//相当于select的value
            editable:false//不允许编辑
        });
        //加载颜色的combobox
        $('#color_query').combobox({
            url:"${pageContext.request.contextPath}/warehouse/baseData/findAllWarBaseDataByKeyword.action",//加载数据的url
            queryParams: {//url的参数
                "keyword" : "颜色"
            },
            valueField:'dictionarieCode',//相当于select的key
            textField:'dictionarieName',//相当于select的value
            editable:false//不允许编辑
        });





        $('#dg1').treegrid({
            title:'组件表',
            fit:true,//当设置为true的时候面板大小将自适应父容器
            //fitColumns:true,//真正的自动展开/收缩列的大小，以适应网格的宽度，防止水平滚动。与上面的fit一起自适应页面
            url:'${pageContext.request.contextPath}/production/productTechnologyWorkHours/findAllProductTechnologyWorkHoursList.action',
            idField:'id',
            treeField:'accessoriesCode',
            toolbar: '#gridToolBar1',
            pagination:true,
            pageSize:50,
            pageList:[50,100,200,500],
            animate:true,//定义节点在展开或折叠的时候是否显示动画效果。
            columns:[[
                {field:'accessoriesCode',title:'K3代码',width:180,align:'center',sortable:true,formatter: function(value,row,index){
                        return "<a onmouseover='showImage(\""+row.id+"\")' onmouseout='hideImage()'>"+value+"</a>";
                    }
                },
                {field:'accessoriesType',title:'类型',width:44,align:'center',sortable:true},
                {field:'accessoriesName',title:'配件名称',width:120,align:'center',sortable:true},
                {field:'unit',title:'单位',width:44,align:'center',sortable:true},
                {field:'product',title:'适用产品',width:100,align:'center',sortable:true,formatter: function(value,row,index){
                        $('#product').combobox('setValues',value);
                        var value = $('#product').combobox('getText');
                        return value.substring(0,value.length);
                    }
                },
                {field:'classification',title:'分类',width:80,align:'center',sortable:true},
                {field:'materialProperties',title:'物料属性',width:70,align:'center',sortable:true},
                {field:'specifications',title:'规格型号',width:70,align:'center',sortable:true},
                {field:'height',title:'高度',width:50,align:'center',sortable:true},
                {field:'width',title:'宽度',width:50,align:'center',sortable:true},
                {field:'depth',title:'深度',width:50,align:'center',sortable:true},
                {field:'color',title:'颜色',width:44,align:'center',sortable:true},
                {field:'fileId',title:'附件',width:40,align:'center'},
                {field:'drawingNumber',title:'图号',width:80,align:'center'},
                {field:'remark',title:'备注',width:44,align:'center'},
                {field:'processCoefficient',title:'工序系数',width:60,align:'center'},
                {field:'accessoriesCoefficient',title:'配件系数',width:60,align:'center'},
                {field:'processName',title:'工序',width:80,align:'center'},
                {field:'processCategory',title:'类别',width:80,align:'center'},
                {field:'eachNumber',title:'数量',width:40,align:'center'},
                {field:'totalTime',title:'总工时',width:50,align:'center'},
                {field:'totalArtificialTime',title:'总人工工时',width:70,align:'center'},
                {field:'calculationMethod',title:'计算方法',width:180,align:'center',formatter: function(value,row,index){
                        if (value != "" && value != undefined){
                            return "<a herf='#' title='"+value.split("<br>")[1]+"'>"+value.split("<br>")[0]+"</a>";
                        }
                    },
                    styler: function(value,row,index){
                        if (!row.calculationFormulaIsChange){
                            return 'background-color:#ff0000;color:fff;';
                        }
                    }
                },
            ]],
            onContextMenu: function(e, row) { //右键时触发事件
                //三个参数：e里面的内容很多，真心不明白，rowIndex就是当前点击时所在行的索引，rowData当前行的数据
                e.preventDefault(); //阻止浏览器捕获右键事件
                $(this).treegrid('clearSelections');
                if (row!=null){
                    $(this).treegrid("select", row.id); //根据索引选中该行
                }
                $("#menu1").menu('show', {//显示右键菜单
                    left: e.pageX,//在鼠标点击处显示菜单
                    top: e.pageY
                });
            },
            onBeforeExpand:function(row){
                var url = "";
                //动态设置展开查询的url
                if ($(this).treegrid('getLevel',row.id) == 1){
                    url = '${pageContext.request.contextPath}/production/productTechnologyWorkHours/findAllProductTechnologyWorkHoursSubsidiaryListById.action';
                }else{
                    url = '${pageContext.request.contextPath}/production/productTechnologyWorkHours/findAllProductTechnologyWorkHoursSubsidiaryListByProProductTechnologyAccessoriesWorkHoursId.action?proProductTechnologyWorkHoursId='+row.proProductTechnologyWorkHoursId;
                }
                $(this).treegrid("options").url = url;
                return true;
            },onExpand : function(row){
                //展开后将url设置为原来的url，否则刷新的时候会使用更改后的url刷新
                var url = '${pageContext.request.contextPath}/production/productTechnologyWorkHours/findAllProductTechnologyWorkHoursList.action';
                $(this).treegrid("options").url = url;
            },onLoadError : function(){//如果报错了，同样将url设置为原来的url
                var url = '${pageContext.request.contextPath}/production/productTechnologyWorkHours/findAllProductTechnologyWorkHoursList.action';
                $(this).treegrid("options").url = url;
            },onLoadSuccess : function(){//如果展开后没有数据，不会执行onExpand的事件，则在这里url设置为原来的url
                var url = '${pageContext.request.contextPath}/production/productTechnologyWorkHours/findAllProductTechnologyWorkHoursList.action';
                $(this).treegrid("options").url = url;
            }
        });



        $('#standardAccessoriesId').combogrid({
            panelWidth:850,//下拉选框的宽度
            panelHeight:'auto',
            idField:'id',//下列表的标识id
            textField:'accessoriesName',//下拉框文本显示的字段
            //rownumbers:true,//显示行号,如果显示行号，下拉框会选择的时候，会自动跳到第一个选择的
            editable:false,//下拉框文本不可以编辑
            pagination:true,
            pageSize:50,
            pageList:[50,100,200,500],
            toolbar:'#gridToolBar2',
            columns:[[
                {field:'ck',title:'',checkbox:true},
                {field:'accessoriesCode',title:'K3代码',align:'center',sortable:true},
                {field:'accessoriesType',title:'类型',align:'center',sortable:true},
                {field:'accessoriesName',title:'配件名称',align:'center',sortable:true},
                {field:'unit',title:'单位',align:'center',sortable:true},
                {field:'product',title:'适用产品',align:'center',formatter: function(value,row,index){
                        $('#product').combobox('setValues',value);
                        var value = $('#product').combobox('getText');
                        return value.substring(1,value.length);
                    }
                },
                {field:'classification',title:'分类',align:'center',sortable:true},
                {field:'materialProperties',title:'物料属性',align:'center',sortable:true},
                {field:'specifications',title:'规格型号',align:'center',sortable:true},
                {field:'height',title:'高度',align:'center',sortable:true},
                {field:'width',title:'宽度',align:'center',sortable:true},
                {field:'depth',title:'深度',align:'center',sortable:true},
                {field:'color',title:'颜色',align:'center',sortable:true},
                {field:'fileId',title:'附件',align:'center'}
            ]],
            onShowPanel:function(){//显示combogrid下拉框事件
                standardAccessoriesIdResize();
                /* $(this).combogrid('grid').datagrid('options').url='${pageContext.request.contextPath}/engineering/standardBom/findAllWarMaterialList.action?relationStartandBomQuery=true'; */
                $(this).combogrid('grid').datagrid('options').url='${pageContext.request.contextPath}/production/productTechnologyWorkHours/findIsAssociatedWarStandardAccessoriesList.action?isAssociated=true';
                $("#queryForm2").form('clear');
                $(this).combogrid('grid').datagrid('load',{});
            },
            onChange:function(newValue, oldValue){//隐藏combogrid下拉框的事件
                var selected = $(this).combogrid('grid').datagrid('getSelected');
                var data = $("#accessoriesType_query").combobox("getData");
                var dictionarieCode;
                for (var i = 0; i < data.length; i++){
                    if (data[i].dictionarieName == selected.accessoriesType){
                        dictionarieCode = data[i].dictionarieCode;
                    }
                }
                $("#accessoriesTypeDictionarieCode").val(dictionarieCode);
                if (dictionarieCode == 1){
                    $('#standardAccessories').combogrid('disable');
                    $('#accessoriesCoefficient').numberbox('disable');
                    $('#accessoriesCoefficient').numberbox('setValue',"1");
                    $('#dg1-2').datagrid('loadData', {"total":0,"rows":[]});//清除表格数据
                }else{
                    $('#standardAccessories').combogrid('enable');
                    $('#accessoriesCoefficient').numberbox('enable');
                }
            }
        });


        //var title = "工序工时计算";
        $('#dg2').treegrid({
            title:'工时统计',
            fit:true,//当设置为true的时候面板大小将自适应父容器
            //fitColumns:true,//真正的自动展开/收缩列的大小，以适应网格的宽度，防止水平滚动。与上面的fit一起自适应页面
            idField:'id',
            treeField:'processName',
            animate:true,//定义节点在展开或折叠的时候是否显示动画效果。
            columns:[[
                {field:'processName',title:'工序',width:140,align:'left',sortable:true},
                {field:'processCategory',title:'类别',width:100,align:'left',sortable:true},
                {field:'totalTime',title:'总工时',width:50,align:'center'},
                {field:'totalArtificialTime',title:'总人工工时',width:70,align:'center'}
            ]],
            toolbar: [{
                text: '展开所有节点',
                iconCls: 'icon-ok',
                handler: function(){
                    expandAllNode('dg2');
                }
            },{
                text: '折叠所有节点',
                iconCls: 'icon-no',
                handler: function(){
                    collapseAllNode('dg2');
                }
            },'-']
        });



        $('#process').combotreegrid({
            panelWidth:550,
            panelHeight:'auto',//下拉选框的高度
            multiple:true,
            idField:'id',
            treeField:'id',
            loadMsg:'数据加载中，请稍后。。。',
            columns:[[
                {field:'id',title:'',align:'center',resizable:false,formatter:function(value,row,index){return ""}},
                {field:'processNumber',title:'序号',align:'center',resizable:false},
                {field:'parentProcessNumber',title:'父序号',align:'center',resizable:false},
                {field:'processName',title:'工序',align:'center',resizable:false},
                {field:'processCategory',title:'类别',align:'center',resizable:false},
                {field:'machineGroupNumber',title:'机&组数',align:'center',resizable:false},
                {field:'perMachineGroupPeopleNumber',title:'人数/(机&组)',align:'center',resizable:false}
            ]],
            onShowPanel:function(){//显示combogrid下拉框事件
                processResize();
                var rows = $("#dg1-1").datagrid('getRows');//获取表格dg1-1的所有行
                var id = "";
                for (var i=0;i<rows.length;i++){//拼接重新加载不包含的processId
                    if (i == rows.length-1){
                        id = id + rows[i].id;
                    }else{
                        id = id + rows[i].id + ",";
                    }
                }
                $('#process').combotreegrid('grid').treegrid('options').url='${pageContext.request.contextPath}/production/productTechnologyWorkHours/findAllProProcessListForCombotreegrid.action';
                $('#process').combotreegrid('grid').treegrid('load',{notInId:id});//重新加载数据，加载的数据不包含dg1-1里的数据
            },
            onHidePanel:function(){//隐藏combogrid下拉框的事件
                // 获取数据表格对象
                var g = $('#process').combotreegrid('grid');
                // 获取选择的行
                var check = g.treegrid('getCheckedNodes');
                for (var i=0;i<check.length;i++){
                    if (check[i].calculationFormula != ""){
                        $("#dg1-1").datagrid('appendRow',
                            {
                                "id":check[i].id,
                                "processCategory":check[i].processCategory,
                                "calculationFormula":check[i].calculationFormula,
                                "processName":check[i].processName,
                                "machineGroupNumber":check[i].machineGroupNumber,
                                "perMachineGroupPeopleNumber":check[i].perMachineGroupPeopleNumber,
                                "processNumber":check[i].processNumber,
                                "parentProcessNumber":check[i].parentProcessNumber
                            });//追加数据到dg1-1的表格中
                    }
                    dialog1Resize();
                    $('#dg1-1').datagrid('enableDnd');//开启拖放
                    g.treegrid('uncheckNode',check[i].id);
                }
                $("#process").combotreegrid('setText');//清空选择的值
            }
        });


        //加载数据表格dg1-1
        $("#dg1-1").datagrid({
            title:"工序",//表格的标题
            //width:400,//表格的宽度
            fit:false,//当设置为true的时候面板大小将自适应父容器
            fitColumns:false,//真正的自动展开/收缩列的大小，以适应网格的宽度，防止水平滚动。与上面的fit一起自适应页面
            striped:true,//是否显示斑马线效果。在easyui.css里的.datagrid-row-alt更改背景颜色
            singleSelect:false,//单选
            ctrlSelect:true,
            idField:'id',//指明哪一个字段是标识字段。
            loadMsg:'数据加载中，请稍后...',//在从远程站点加载数据的时候显示提示消息。
            rownumbers:true,//显示一个行号列。
            columns:[[
                {field:'processName',title:'工序',width:80,align:'center'},
                {field:'processCategory',title:'类别',width:80,align:'center'},
                {field:'machineGroupNumber',title:'机&<br>组数',width:40,align:'center'},
                {field:'perMachineGroupPeopleNumber',title:'人数/<br>(机&组)',width:60,align:'center'},
                {field:'totalTime',title:'工序工时<br>/单机组',width:70,align:'center',editor:{type:'numberbox',options:{required:true,missingMessage:'工艺工时不能为 空'}}},
                {field:'totalArtificialTime',title:'人工工时<br>/单机组',width:70,align:'center',editor:{type:'numberbox',options:{required:true,missingMessage:'人工工时不能为 空'}}},
                {field:'calculationMethod',title:'计算方法',width:120,align:'center',formatter: function(value,row,index){
                        if (value != "" && value != undefined){
                            return "<a herf='#' title='"+value.split("<br>")[1]+"'>"+value.split("<br>")[0]+"</a>";
                        }
                    },
                    styler: function(value,row,index){
                        if (row.calculationMethod != undefined){
                            if (row.calculationFormula != row.calculationMethod.split("&#10;")[1]){
                                return 'background-color:#ff0000;color:fff;';
                            }
                        }
                    }
                }
            ]],//表格的各个字段
            toolbar: [{
                text: '删除',
                iconCls: 'icon-remove',
                handler: function(){
                    deleteDg11Data();
                }
            },{
                text: '计算',
                iconCls: 'icon-sum',
                handler: function(){
                    openCalculationDialog();
                }
            },'-'],
            onDblClickCell : function(index, field, value){
                openCalculationDialog();
            },
            onRowContextMenu: function(e, rowIndex, rowData) { //右键时触发事件
                //三个参数：e里面的内容很多，真心不明白，rowIndex就是当前点击时所在行的索引，rowData当前行的数据
                e.preventDefault(); //阻止浏览器捕获右键事件
                $("#menu1-1").menu('show', {//显示右键菜单
                    left: e.pageX,//在鼠标点击处显示菜单
                    top: e.pageY
                });
            },onBeforeSelect: function(index, row){//让下面的获取焦点，是为了可以使用del删除行
                $("#menu1-1").menu('hide');//因为这里有bug，点击菜单不隐藏菜单
                $("#dg1-1").datagrid('getPanel').panel('panel').focus();
            }
        });


        $('#standardAccessories').combogrid({
            panelWidth:900,//下拉选框的宽度
            panelHeight:'auto',//下拉选框的高度
            idField:'id',//下列表的标识id
            textField:'accessoriesName',//下拉框文本显示的字段
            //rownumbers:true,//显示行号,如果显示行号，下拉框会选择的时候，会自动跳到第一个选择的
            multiple:true,//允许多选
            editable:false,//下拉框文本不可以编辑
            pagination:true,
            pageSize:50,
            pageList:[50,100,200,500],
            toolbar:'#gridToolBar3',
            columns:[[
                {field:'ck',title:'',checkbox:true},
                {field:'accessoriesCode',title:'K3代码',align:'center',sortable:true},
                {field:'accessoriesType',title:'类型',align:'center',sortable:true},
                {field:'accessoriesName',title:'配件名称',align:'center',sortable:true},
                {field:'unit',title:'单位',align:'center',sortable:true},
                {field:'product',title:'适用产品',align:'center',formatter: function(value,row,index){
                        $('#product').combobox('setValues',value);
                        var value = $('#product').combobox('getText');
                        return value.substring(1,value.length);
                    }
                },
                {field:'classification',title:'分类',align:'center',sortable:true},
                {field:'materialProperties',title:'物料属性',align:'center',sortable:true},
                {field:'specifications',title:'规格型号',align:'center',sortable:true},
                {field:'height',title:'高度',align:'center',sortable:true},
                {field:'width',title:'宽度',align:'center',sortable:true},
                {field:'depth',title:'深度',align:'center',sortable:true},
                {field:'color',title:'颜色',align:'center',sortable:true},
                {field:'eachNumber',title:'每套数量',align:'center',sortable:true},
                {field:'fileId',title:'附件',align:'center'}
            ]],
            onShowPanel:function(){//显示combogrid下拉框事件
                standardAccessoriesResize();
                var rows = $("#dg1-2").datagrid('getRows');//获取表格dg1-1的所有行
                //获取第一个选择配件的选中项
                var selected = $("#standardAccessoriesId").combogrid('grid').datagrid('getSelected');
                console.log(selected);
                //获取类型选项框中返回的全部数据
                var data = $("#accessoriesType_query").combobox("getData");
                var dictionarieCode;
                for (var i = 0; i < data.length; i++){
                    if (data[i].dictionarieName == selected.accessoriesType){
                        dictionarieCode = data[i].dictionarieCode;
                    }
                }

                var id = "";
                for (var i=0;i<rows.length;i++){//拼接重新加载不包含的processId
                    if (i == rows.length-1){
                        id = id + rows[i].id;
                    }else{
                        id = id + rows[i].id + ",";
                    }
                }
                id = id == "" ? $("#orWarStandardAccessoriesId").val() : id + "," + $("#orWarStandardAccessoriesId").val();
                $(this).combogrid('grid').datagrid('options').url='${pageContext.request.contextPath}/production/productTechnologyWorkHours/findIsAssociatedWarStandardAccessoriesList.action?isAssociated=false&dictionarieCode='+dictionarieCode;
                $(this).combogrid('grid').datagrid('load',{notInId:id});//重新加载数据，加载的数据不包含dg1-1里的数据
                $(this).combogrid('grid').datagrid('clearSelections');//清除所有选择的行

                $("#queryForm3").form('clear');
            },
            onHidePanel:function(){//隐藏combogrid下拉框的事件
                var g = $('#standardAccessories').combogrid('grid');	// 获取数据表格对象
                var check = g.datagrid('getSelections');	// 获取选择的行
                for (var i=0;i<check.length;i++){
                    $("#dg1-2").datagrid('appendRow',check[i]);//追加数据到dg1-1的表格中
                }
                dialog1Resize();
                $("#standardAccessories").combobox('setText');//清空选择的值
            },
            onBeforeSelect:function(index,row){
                var dictionarieCode = $("#accessoriesTypeDictionarieCode").val();

                var data = $("#accessoriesType_query").combobox("getData");
                for (var i = 0; i < data.length; i++){
                    if (data[i].dictionarieName == row.accessoriesType){
                        if (data[i].dictionarieCode >= dictionarieCode){
                            return false;
                        }
                    }
                }
            },
            onBeforeCheck:function(index,row){
                var dictionarieCode = $("#accessoriesTypeDictionarieCode").val();

                var data = $("#accessoriesType_query").combobox("getData");
                for (var i = 0; i < data.length; i++){
                    if (data[i].dictionarieName == row.accessoriesType){
                        if (data[i].dictionarieCode >= dictionarieCode){
                            return false;
                        }
                    }
                }
            },
            onCheckAll:function(rows){
                var dictionarieCode = $("#accessoriesTypeDictionarieCode").val();

                var data = $("#accessoriesType_query").combobox("getData");
                var g = $('#standardAccessories').combogrid('grid');
                for (var i = 0; i<rows.length; i++){
                    for (var j = 0; j < data.length; j++){
                        if (data[j].dictionarieName == rows[i].accessoriesType){
                            if (data[j].dictionarieCode >= dictionarieCode){
                                g.datagrid('unselectRow', g.datagrid('getRowIndex',rows[i]));
                            }
                        }
                    }
                }
            }
        });

        //加载数据表格dg1-2
        $("#dg1-2").edatagrid({
            title:"配件",//表格的标题
            //width:400,//表格的宽度
            fit:false,//当设置为true的时候面板大小将自适应父容器
            fitColumns:false,//真正的自动展开/收缩列的大小，以适应网格的宽度，防止水平滚动。与上面的fit一起自适应页面
            striped:true,//是否显示斑马线效果。在easyui.css里的.datagrid-row-alt更改背景颜色
            singleSelect:false,//单选
            ctrlSelect:true,//按住ctrl才多选
            idField:'id',//指明哪一个字段是标识字段。
            loadMsg:'数据加载中，请稍后...',//在从远程站点加载数据的时候显示提示消息。
            rownumbers:true,//显示一个行号列。
            columns:[[
                {field:'accessoriesCode',title:'K3代码',width:100,align:'center'},
                {field:'accessoriesType',title:'类型',width:40,align:'center'},
                {field:'materialProperties',title:'物料属性',width:60,align:'center'},
                {field:'accessoriesName',title:'配件名称',width:80,align:'center'},
                {field:'specifications',title:'规格型号',width:80,align:'center'},
                {field:'color',title:'颜色',width:50,align:'center'},
                {field:'eachNumber',title:'数量',width:30,align:'center',editor:{type:'numberbox',options:{required:true,missingMessage:'数量不能为空'}}},
                {field:'unit',title:'单位',width:30,align:'center'},
                {field:'product',title:'适用产品',width:90,align:'center',formatter: function(value,row,index){
                        $('#product').combobox('setValues',value);
                        var value = $('#product').combobox('getText');
                        return value.substring(1,value.length);
                    }
                },
                {field:'classification',title:'分类',width:60,align:'center'},
                {field:'height',title:'高度',width:80,align:'center'},
                {field:'width',title:'宽度',width:80,align:'center'},
                {field:'depth',title:'深度',width:80,align:'center'},
                {field:'fileId',title:'附件',width:50,align:'center'}
            ]],//表格的各个字段
            toolbar: [{
                text: '删除',
                iconCls: 'icon-remove',
                handler: function(){
                    deleteDg12Data();
                }
            },{
                text: '开启拖放',
                iconCls: 'icon-sum',
                handler: function(){
                    enableDndDg12();
                }
            },'-'],
            onEdit: function (index,row){
                $('#dg1-2').datagrid('disableDnd');//禁用拖放
            },
            onRowContextMenu: function(e, rowIndex, rowData) { //右键时触发事件
                //三个参数：e里面的内容很多，真心不明白，rowIndex就是当前点击时所在行的索引，rowData当前行的数据
                e.preventDefault(); //阻止浏览器捕获右键事件
                $("#menu1-2").menu('show', {//显示右键菜单
                    left: e.pageX,//在鼠标点击处显示菜单
                    top: e.pageY
                });
            },onBeforeSelect: function(index, row){//让下面的获取焦点，是为了可以使用del删除行
                $("#dg1-2").datagrid('getPanel').panel('panel').focus();
            }
        });


        //shift/ctrl多选的时，禁止选择文本
        var KEY = { SHIFT:16, CTRL:17, ALT:18, DOWN:40, RIGHT:39, UP:38, LEFT:37};
        document.onkeydown = function (event){
            if (event.keyCode == KEY.SHIFT || event.keyCode == KEY.CTRL){
                $("#accessoriesCode_query2").textbox('textbox').focus();
                $("#accessoriesCode_query2").textbox('textbox').blur();
                $("body").addClass("noselect");
                document.onselectstart=function(){return false;};
            }
        };
        document.onkeyup = function (event){
            if (event.keyCode == KEY.SHIFT || event.keyCode == KEY.CTRL){
                $("body").removeClass("noselect");
                document.onselectstart=function(){return true;};
            }
        };


        //加载单位的combobox
        $('#companyId').combobox({
            url:"${pageContext.request.contextPath}/warehouse/baseData/findAllWarBaseDataByKeyword.action",//加载数据的url
            queryParams: {//url的参数
                "keyword" : "单位"
            },
            valueField:'dictionarieCode',//相当于select的key
            textField:'dictionarieName',//相当于select的value
            editable:false//不允许编辑
        });
        //form表单的回车事件，回车提交
        $("#form1").keydown(function (event){
            if (event.keyCode == 13){
                saveOrUpdateDg1Data();
            }
        });

        $("#form2").keydown(function (event){
            if (event.keyCode == 13){
                calculation();
            }
        });
        //产品搜索输入框的回车事件
        $("#queryForm").keydown(function (event){
            if (event.keyCode == 13){
                query();
            }
        });
        $("#queryForm2").keydown(function (event){
            if (event.keyCode == 13){
                query2();
            }
        });
        $("#queryForm3").keydown(function (event){
            if (event.keyCode == 13){
                query3();
            }
        });

        $("#dg1-1").datagrid('getPanel').panel('panel').attr('tabindex', 1).css('outline','none').bind('keydown', function (event) {//必须在datagrid的onBeforeSelect，添加获取焦点
            if (event.keyCode == 46){
                deleteDg11Data();
            }
        });

        $("#dg1-2").datagrid('getPanel').panel('panel').attr('tabindex', 1).css('outline','none').bind('keydown', function (event) {//必须在datagrid的onBeforeSelect，添加获取焦点
            if (event.keyCode == 46){
                deleteDg12Data();
            }
        });
    });






    //打开新增产品零件工序的dialog
    function addDg1DataDialog(){
        $.ajax({
            type:'POST',//post请求
            url: '${pageContext.request.contextPath}/system/user/testLoginTimeout.action',//ajax请求的url
            async: false,//同步请求
            cache: false,//不缓存此页面
            success: function(data){//请求成功后的回调函数。data：服务器返回数据。
                $("#form1").form('reset');//重置表单数据
                $("#orWarStandardAccessoriesId").val("");
                $('#standardAccessoriesId').combogrid('setValue','');
                $('#standardAccessoriesId').combogrid('enable');
                $('#standardAccessories').combogrid('disable');
                $('#accessoriesCoefficient').numberbox('disable');
                $('#dg1-1').datagrid('loadData', {"total":0,"rows":[]});//清除表格数据
                $('#dg1-1').datagrid('clearSelections');//清除所有的选择
                $('#dg1-2').datagrid('loadData', {"total":0,"rows":[]});//清除表格数据
                $('#dg1-1').datagrid('clearSelections');//清除所有的选择

                $("#dialog1").dialog({//加载一个dialog
                    closed:false,//将该dialog的状态由不显示改成显示
                    title:'新增产品工艺工时'//该dialog的标题
                });
                dialog1Resize();
                $("#flag1").val('add');//新增和修改用的是同一个dialog，用于区分是新增还是修改
            }
        });
    }

    //打开修改产品零件工序的dialog
    function editDg1DataDialog(){
        $("#form1").form('reset');//重置表单数据
        $('#dg1-1').datagrid('loadData', {"total":0,"rows":[]});//清除表格数据
        $('#dg1-1').datagrid('clearSelections');//清除所有的选择
        $('#dg1-2').datagrid('loadData', {"total":0,"rows":[]});//清除表格数据
        $('#dg1-2').datagrid('clearSelections');//清除所有的选择
        $("#flag1").val('update');//新增和修改用的是同一个dialog，用于区分是新增还是修改
        var selected = $("#dg1").treegrid('getSelected');//取得选中的行
        if (selected!=null){
            var id = "";
            while (id == ""){
                if (selected._parentId == undefined){//根节点
                    id = selected.id;
                }else{//子节点，则选择将selected变成选择的父节点，直到selected变成根节点
                    selected = $('#dg1').treegrid('getParent',selected.id);
                }
            }

            var data = "id=" + id;
            $.ajax({
                type:'post',
                url:'${pageContext.request.contextPath}/production/productTechnologyWorkHours/findProductTechnologyWorkHoursById.action',
                data:data,
                success:function(data){
                    if (data.success){
                        $("#dialog1").dialog({//加载一个dialog
                            closed:false,//将该dialog的状态由不显示改成显示
                            title:'修改组件'//该dialog的标题
                        });
                        dialog1Resize();

                        $("#standardAccessoriesId").combogrid('grid').datagrid('loadData',data.datas.row);

                        $("#form1").form('load',data.datas.productTechnologyWorkHours);

                        $('#standardAccessoriesId').combogrid('disable');

                        $("#orWarStandardAccessoriesId").val(data.datas.productTechnologyWorkHours.warStandardAccessoriesId);

                        $("#dg1-1").datagrid('loadData',data.datas.processDatas);

                        $("#dg1-2").datagrid('loadData',data.datas.standardAccessoriesDatas);
                    }else{
                        showMessager("提示",data.message);
                    }
                }
            });
        }else{
            showMessager("提示","请选择一条记录进行修改");
        }
    }


    function deleteDg1Data(){
        var selected = $("#dg1").treegrid('getSelected');//取得选中的行
        if (selected!=null){
            $.messager.confirm('确认对话框', '确定要删除吗？', function(b){
                if (b){
                    var id = "";
                    while (id == ""){
                        if (selected._parentId == undefined){//根节点
                            id = selected.id;
                        }else{//子节点，则选择将selected变成选择的父节点，直到selected变成根节点
                            selected = $('#dg1').treegrid('getParent',selected.id);
                        }
                    }

                    var data = "id=" + id;
                    $.ajax({
                        type:'post',
                        url:'${pageContext.request.contextPath}/production/productTechnologyWorkHours/deleteProductTechnologyWorkHoursById.action',
                        data:data,
                        success: function(data){//请求成功后的回调函数。data：服务器返回数据。
                            if (data.success){
                                showMessager("提示","删除成功");
                                $("#dg1").treegrid('reload');//重载行。等同于'load'方法，但是它将保持在当前页。
                                $("#dg1").treegrid('clearSelections');//清除所有选择的行
                            }else{
                                showMessager("错误",data.message);
                            }
                        }
                    });
                }
            });
        }else{
            showMessager("提示","请选择一条记录进行删除");
        }
    }


    function saveOrUpdateDg1Data(){
        if ($("#form1").form('validate')){//判断表单验证是否通过
            var processRows = $('#dg1-1').datagrid('getRows');//获取所有的行
            var standardAccessoriesRows = $('#dg1-2').datagrid('getRows');//获取所有的行
            if (processRows.length>0 || standardAccessoriesRows.length>0){//判断是否有添加数据,没有任何数据不能保存
                for (var i=0;i<processRows.length;i++){//将所有可编辑框结束，否则无法传值
                    processRows[i].number = i;
                    if (processRows[i].totalTime == undefined || processRows[i].totalTime == ""){
                        alert("工序的第"+(i+1)+"行没有计算工时");
                        return;
                    }
                }

                $("#dg1-2").datagrid('endEdit',$("#dg1-2").datagrid("getRowIndex",$("#dg1-2").datagrid("getSelected")));

                for (var i=0;i<standardAccessoriesRows.length;i++){//将所有可编辑框结束，否则无法传值
                    standardAccessoriesRows[i].number = i;
                }
                endEdit
                var flag = $("#flag1").val();//获取标识符，
                var url = "${pageContext.request.contextPath}/production/productTechnologyWorkHours/";
                if (flag == 'add'){//如果标识符为add，则为新增操作，拼接出新增的url
                    url = url + "saveProductTechnologyWorkHours.action";
                }else if (flag == 'update'){//如果标识符为updata，则为修改操作，拼接出修改的url
                    url = url + "updateProductTechnologyWorkHours.action";
                }
                var id = '"id":' + '"' + $("#id").val() + '"';
                var warStandardAccessoriesId = '"warStandardAccessoriesId":' + '"' + $("#standardAccessoriesId").combogrid('getValue') + '"';
                var processCoefficient = '"processCoefficient":' + '"' + $("#processCoefficient").val() + '"';
                var accessoriesCoefficient = '"accessoriesCoefficient":' + '"' + $("#accessoriesCoefficient").val() + '"';
                var data =  '"productTechnologyWorkHours":{' + id + "," + warStandardAccessoriesId + "," + processCoefficient + "," + accessoriesCoefficient + "}";
                var processDatas = JSON.stringify($('#dg1-1').datagrid('getRows'));//将选中的数据转换成json字符串
                var standardAccessoriesDatas = JSON.stringify($('#dg1-2').datagrid('getRows'));//将选中的数据转换成json字符串
                var datas = "{" + data + ',"standardAccessoriesDatas":' + standardAccessoriesDatas + ',"processDatas":' + processDatas + "}";//将零件的信息插入到json字符串中
                //alert(datas);//查看拼接的json字符串是否正确
                $.ajax({
                    type:'POST',//post请求
                    url: url,//ajax请求的url
                    data: datas,//传的参数,序列化表单
                    async: false,//同步请求
                    cache: false,//不缓存此页面
                    contentType: 'application/json;charset=utf-8',
                    success: function(data){//请求成功后的回调函数。data：服务器返回数据。
                        if (data.success){
                            showMessager("提示","保存成功");
                            $("#dialog1").dialog({//关闭这个dialog
                                closed:true
                            });
                            $("#dg1").treegrid('reload');//重新加载数据，保持在当前页

                            if (flag == 'update'){
                                $.messager.confirm('确认对话框', '更新了数据，是否立即更新所有数据吗？', function(b){
                                    if (b){
                                        updateAllDatas();
                                    }
                                });
                                $("div[class='messager-icon messager-question']").attr('tabindex', 1).focus();//为了让焦点在弹出框的左边的图片上，而不是确定的按钮上，否则按回车修改的时候，立刻弹出的选择框，也会被按确定
                            }
                        }else{
                            showMessager("错误",data.message);
                        }
                    }
                });
            }else{
                showMessager("提示",'<font color="red">' + "没有添加任何工序或配件，不能保存" + '<font/>');
            }
        }
    }

    //设置图形
    function setTechnologyProcessFlowChart(){
        var selected = $("#dg1").treegrid('getSelected');//取得选中的行
        if (selected!=null){
            var id = "";
            var title = "";
            while (id == ""){
                if (selected._parentId == undefined){//根节点
                    id = selected.id;
                    title = selected.accessoriesName;
                }else{//子节点，则选择将selected变成选择的父节点，直到selected变成根节点
                    selected = $('#dg1').treegrid('getParent',selected.id);
                }
            }
            //window.open('${pageContext.request.contextPath}/production/productTechnologyWorkHours/technologyProcessFlowChart.action?id=' + id);

            $("#iframe").attr('src','${pageContext.request.contextPath}/production/productTechnologyWorkHours/technologyProcessFlowChart.action?id=' + id);
            $("#dialog3").dialog({//加载一个dialog
                closed:false,//将该dialog的状态由不显示改成显示
                title:'工艺流程图'//该dialog的标题
            });
        }else{
            showMessager("提示","请选择一条记录进行计算");
        }
    }

    function saveTechnologyProcessFlowChart(){
        var json = iframe.window.save();
        if (json.success){
            $.ajax({
                type:'post',
                url:'${pageContext.request.contextPath}/production/productTechnologyWorkHours/saveTechnologyProcessFlowChart.action',
                data : json.data,
                async: false,//同步请求
                cache: false,//不缓存此页面
                contentType: 'application/json;charset=utf-8',
                success: function(data){//请求成功后的回调函数。data：服务器返回数据。
                    if (data.success){
                        showMessager("提示","保存成功");
                        $("#dialog3").dialog({//加载一个dialog
                            closed:true,//将该dialog的状态由不显示改成显示
                        });
                    }else{
                        showMessager("错误",data.message);
                    }
                },
            });
        }else{
            showMessager("提示",json.message);
        }
    }

    function updateAllDatas(){
        //显示加载层
        load("所有数据更新中。。。");
        $.ajax({
            type:'post',
            url:'${pageContext.request.contextPath}/production/productTechnologyWorkHours/updateAllProductTechnologyWorkHours.action',
            success: function(data){//请求成功后的回调函数。data：服务器返回数据。
                if (data.success){
                    showMessager("提示",data.message);
                    $("#dg1").treegrid('reload');//重载行。等同于'load'方法，但是它将保持在当前页。
                    $("#dg1").treegrid('clearSelections');//清除所有选择的行
                }else{
                    showMessager("错误",data.message);
                }
            },
            complete: function(XMLHttpRequest, textStatus){
                //取消加载层
                disLoad();
            }
        });
    }

    function reloadDg1Data(){
        $("#dg1").treegrid('reload');
    }

    function query(){
        $("#dg1").treegrid('load',$("#queryForm").serializeObject());
    }
    function query2(){
        $("#standardAccessoriesId").combogrid('grid').datagrid('load',$("#queryForm2").serializeObject());//重新加载数据，加载的数据不包含dg1-1和条件查找的数据
    }

    function query3(){
        var rows = $("#dg1-2").datagrid('getRows');//获取表格dg1-2的所有行
        var id = "";
        for (var i=0;i<rows.length;i++){//拼接重新加载不包含的processId
            if (i == rows.length-1){
                id = id + rows[i].id;
            }else{
                id = id + rows[i].id + ",";
            }
        }
        id = id == "" ? $("#orWarStandardAccessoriesId").val() : id + "," + $("#orWarStandardAccessoriesId").val();
        $("#standardAccessories").combogrid('grid').datagrid('load',{
                notInId:id,
                accessoriesCode:$("#accessoriesCode_query3").val(),
                accessoriesType:$("#accessoriesType_query3").combobox('getValue'),
                accessoriesName:$("#accessoriesName_query3").val(),
                product:$("#product_query3").combobox('getValue')
            }
        );//重新加载数据，加载的数据不包含dg1-2和条件查找的数据
        $("#standardAccessories").combogrid('grid').datagrid('clearSelections');//清除所有选择的行
    }

    //flag为true表示按类别计算，为false表为按工序计算（分类别计算更精细）
    function loadDg2Data(flag){
        var selected = $("#dg1").treegrid('getSelected');//取得选中的行
        if (selected!=null){
            var id = "";
            var title = "";
            while (id == ""){
                if (selected._parentId == undefined){//根节点
                    id = selected.id;
                    title = selected.accessoriesName;
                }else{//子节点，则选择将selected变成选择的父节点，直到selected变成根节点
                    selected = $('#dg1').treegrid('getParent',selected.id);
                }
            }

            var url = "${pageContext.request.contextPath}/production/productTechnologyWorkHours/calculateProcessTimes.action?id="+id;
            $.ajax({
                type:'POST',//post请求
                url: url,//ajax请求的url
                async: false,//同步请求
                cache: false,//不缓存此页面
                contentType: 'application/json;charset=utf-8',
                success: function(data){//请求成功后的回调函数。data：服务器返回数据。
                    if (data.success){
                        $("#dg2").treegrid("getPanel").panel("setTitle",title);
                        $("#dg2").treegrid('loadData',data.datas);
                        $("#dg2").treegrid('unselectAll');//取消选择所有行
                    }else{
                        showMessager("错误",data.message);
                    }
                }
            });
        }else{
            showMessager("提示","请选择一条记录进行计算");
        }
    }



    function deleteDg11Data(){
        var selections = $('#dg1-1').datagrid('getSelections');//获取选择的行
        var copySelections = [];
        if (selections != null && selections.length > 0){//如果选择了
            for (var i=0; i<selections.length; i++){
                copySelections.push(selections[i]);
            }
            for (var i=0; i<copySelections.length; i++){
                var index = $('#dg1-1').datagrid('getRowIndex',copySelections[i]);//获取选择行的行号
                $('#dg1-1').datagrid('deleteRow',index);//删除该行
            }
            dialog1Resize();
            $('#dg1-1').datagrid('unselectAll');//取消选择
        }else{//如果没有选择
            showMessager('提示','请选择一行进行删除');
        }
    }


    function openCalculationDialog(){
        var selected = $('#dg1-1').datagrid('getSelected');//获取选择的行
        if (selected!=null){//如果选择了
            var parm;
            if (selected.calculationMethod != "" && selected.calculationMethod != null && selected.calculationMethod != undefined){
                parm = {processId:selected.id,calculationMethod:selected.calculationMethod};
            }else{
                parm = {processId:selected.id};
            }
            $.ajax({
                type:'post',
                url:'${pageContext.request.contextPath}/production/productTechnologyWorkHours/findProcessTechnologyByProcessId.action',
                data:parm,
                success:function(data){
                    if (data.success){
                        $("#table").html("");
                        $("#dialog2").dialog({//加载一个dialog
                            closed:false,//将该dialog的状态由不显示改成显示
                            title:'计算公式('+selected.processCategory+')',//该dialog的标题
                        });
                        for (var i=0;i<data.datas.length;i++){
                            var select = [];
                            select.push("<select id='" + data.datas[i].technologyIdentification + "Select' class='easyui-combobox' style='width:180px;' data-options='editable:false,panelHeight:\"auto\"'>");
                            var readonly = true;
                            var defaultValue = 0;
                            for (var j=0;j<data.datas[i].technologyWorkHoursBasicDatas.length;j++){
                                if (j == 0){//第一条记录，也就是默认选中的记录
                                    defaultValue = data.datas[i].value == "" ? data.datas[i].technologyWorkHoursBasicDatas[j].technologyTime : data.datas[i].value;
                                    if (data.datas[i].technologyWorkHoursBasicDatas[j].technologyDescription.indexOf("手录") != -1){
                                        readonly = false;
                                    }
                                }

                                var isSelected = "";
                                if (data.datas[i].technologyWorkHoursBasicDatas[j].selected){
                                    isSelected = "selected='" + data.datas[i].technologyWorkHoursBasicDatas[j].selected + "'";
                                    if (data.datas[i].technologyWorkHoursBasicDatas[j].technologyDescription.indexOf("手录") != -1){
                                        readonly = false;
                                    }
                                }
                                select.push("<option value='" + data.datas[i].technologyWorkHoursBasicDatas[j].technologyTime + "'" + isSelected + ">" + data.datas[i].technologyWorkHoursBasicDatas[j].technologyDescription + "</option>");
                            }
                            select.push("</select>");
                            var tr = "<tr>" +
                                "<td style='text-align:right;'>" + data.datas[i].technology + "</td>" +
                                "<td>" +
                                select.join() +
                                "</td>" +
                                "<td>" +
                                "<input id='" + data.datas[i].technologyIdentification + "' class='easyui-numberbox' data-options='readonly:" + readonly + ",min:0,precision:0,required:true,missingMessage:\"该项为必填项\"' style='width:80px' value='" + defaultValue + "'>" +
                                "</td>" +
                                "<td>" +
                                data.datas[i].technologyIdentification +
                                "</td>" +
                                "</tr>";
                            $("#table").append(tr);
                        }
                        $("#table").find(".easyui-combobox").combobox({
                            onChange: function(newValue, oldValue){
                                var textbox = $(this).parent().next().children(":first");
                                if ($(this).combobox('getText').indexOf("手录")  != -1){
                                    textbox.numberbox('readonly',false);
                                }else{
                                    textbox.numberbox('readonly',true);
                                }
                                textbox.numberbox('setValue',newValue);
                            }
                        });
                        $("#table").find(".easyui-numberbox").numberbox();
                        if (data.calculationFormulaIsChange){//计算公式是否有变更
                            $("#table").append("<tr><td style='text-align:right;'>计算公式" + "<a title='"+data.oldCalculationFormu+"'>(查看旧公式)</a>" + "：</td><td colspan='3' style='text-align:left;'>" + data.process.calculationFormula + "</td></tr>");
                        }else{
                            $("#table").append("<tr><td style='text-align:right;'>计算公式：</td><td colspan='3' style='text-align:left;'>" + data.process.calculationFormula + "</td></tr>");
                        }
                        dialog2Resize();
                    }else{
                        showMessager('提示',data.message);
                    }
                }
            });
        }else{//如果没有选择
            showMessager('提示','请选择一行进行计算');
        }
    }

    function calculation(){
        if ($("#form2").form('validate')){
            var calculationFormula = $("#table").children(":last").children(":last").children(":last").text();
            var calculationMethod = $("#table").children(":last").children(":last").children(":last").text();
            var trs = $("#table").children(":last").children();
            for (var i=0;i<trs.length-1;i++){
                var id = $(trs[i]).children(":last").text();
                var technology = $(trs[i]).children(":first").text();
                calculationFormula = calculationFormula.replace(new RegExp(id,'g'), $("#"+id).numberbox('getValue'));
                calculationMethod = calculationMethod.replace(new RegExp(id,'g'), technology);
            }
            //alert(eval(calculationFormula));

            var selected = $('#dg1-1').datagrid('getSelected');
            $('#dg1-1').datagrid('updateRow',{
                index:$('#dg1-1').datagrid('getRowIndex',selected),
                row:{
                    totalTime : numberToFixed(eval(calculationFormula),2),
                    totalArtificialTime : numberToFixed(numberToFixed(eval(calculationFormula),2)*selected.perMachineGroupPeopleNumber,2),
                    calculationMethod : calculationFormula+"<br>"+calculationMethod+"&#10;"+$("#table").children(":last").children(":last").children(":last").text(),
                }
            });

            $("#dialog2").dialog({//加载一个dialog
                closed:true,//将该dialog的状态由不显示改成显示
            });
        }
    }


    function deleteDg12Data(){
        var selections = $('#dg1-2').datagrid('getSelections');//获取选择的行
        var copySelections = [];
        if (selections != null && selections.length > 0){//如果选择了
            for (var i=0; i<selections.length; i++){
                copySelections.push(selections[i]);
            }
            for (var i=0; i<copySelections.length; i++){
                var index = $('#dg1-2').datagrid('getRowIndex',copySelections[i]);//获取选择行的行号
                $('#dg1-2').datagrid('deleteRow',index);//删除该行
            }
            dialog1Resize();
            $('#dg1-2').datagrid('unselectAll');//取消选择
        }else{//如果没有选择
            showMessager('提示','请选择一行进行删除');
        }
    }

    function enableDndDg12(){
        var selected = $('#dg1-2').datagrid('getSelected');
        if (selected != null){
            $('#dg1-2').datagrid('endEdit',$('#dg1-2').datagrid('getRowIndex',selected));
        }
        $('#dg1-2').datagrid('enableDnd');//开启拖放
    }

    function openExportExcelDialog(){
        var selected = $('#dg1').treegrid("getSelected");
        if (selected != null){
            var id = "";
            while (id == ""){
                if (selected._parentId == undefined){//根节点
                    id = selected.id;
                    title = selected.accessoriesName;
                }else{//子节点，则选择将selected变成选择的父节点，直到selected变成根节点
                    selected = $('#dg1').treegrid('getParent',selected.id);
                }
            }
            $("#exportExcelId").val(id);
            $("#dialog4").dialog({//加载一个dialog
                closed:false,//将该dialog的状态由不显示改成显示
                title:'请选择计时单位'//该dialog的标题
            });
        }else{
            showMessager("提示","请选择一条记录进行导出");
        }
    }

    function exportExcel(){
        $("#form4").submit();//提交表单
        $("#dialog4").dialog({//加载一个dialog
            closed:true,//将该dialog的状态由不显示改成显示
        });
    }

    function numberToFixed(obj,num){//如果小数点后面不是两位，则截取两位小数点
        if (!(obj.toFixed(num) == obj)){
            obj = obj.toFixed(num);
        }
        return obj;
    }
    /*firefox*/function __firefox(){    HTMLElement.prototype.__defineGetter__("runtimeStyle", __element_style);    window.constructor.prototype.__defineGetter__("event", __window_event);    Event.prototype.__defineGetter__("srcElement", __event_srcElement);}function __element_style(){    return this.style;}function __window_event(){    return __window_event_constructor();}function __event_srcElement(){    return this.target;}function __window_event_constructor(){    if(document.all){        return window.event;    }    var _caller = __window_event_constructor.caller;    while(_caller!=null){        var _argument = _caller.arguments[0];        if(_argument){            var _temp = _argument.constructor;            if(_temp.toString().indexOf("Event")!=-1){                return _argument;            }        }        _caller = _caller.caller;    }    return null;}if(window.addEventListener){    __firefox();}/*end firefox*/

    function showImage(id){
        if ($("#dg1").treegrid('getLevel',id) == 1){
            var url = "${pageContext.request.contextPath}/production/productTechnologyWorkHours/readProductTechnologyProcessFlowChartImageById.action?id=" + id + "&time=" + new Date().toString();
            var errorUrl = "${pageContext.request.contextPath}/jquery-easyui-1.5.5.4/themes/icons/blank.gif";
            try{
                //var e=event||window.event;
                var showInfoWindow=document.getElementById("showInfomation");
                showInfoWindow.style.visibility="visible";
                var x=document.body.scrollLeft+event.clientX+10;
                var y=event.clientY+document.body.scrollTop+10;//+document.documentElement.scrollTop;
                showInfoWindow.style.left=x+"px";
                showInfoWindow.style.top=y+"px";
                showInfoWindow.innerHTML="<img src='" + url + "' onerror='onerror=null;src=\"" + errorUrl + "\"'>";
            }catch(e){alert("showInfoWithPanel:"+e.message);}
        }
    }

    function hideImage(){
        try{
            var showInfoWindow=document.getElementById("showInfomation");
            if(showInfoWindow || typeof(showInfoWindow)!='undefined'){
                showInfoWindow.innerHTML="";
                showInfoWindow.style.visibility="hidden";
            }
        }catch(e){alert("hiddenInfoPanel:"+e.message);}
    }
</script>
<!-- onselectstart="return false" 禁止选取 -->
<body class="easyui-layout">

<div region="center" class="center" style="text-align: center;">

    <table id="dg1"

           data-options="onDblClickRow:function (row){
													    	<p:isPrivilege pid="ac" mid="acb">
													    		editDg1DataDialog();//是子节点则开始
													    }"编辑
    </p:isPrivilege>
    ></table>
</div>

<!-- 上面表格的toolbar按钮 -->
<div id="gridToolBar1" style="padding:5px;height:auto">
    <div style="display:inline-block;">
        <p:isPrivilege pid="ac" mid="aca">
            <a class="easyui-linkbutton" iconCls="icon-add" plain="true" onClick="addDg1DataDialog()" style="float: left;">新增</a><div class="btn-separator"></div>
        </p:isPrivilege>
        <p:isPrivilege pid="ac" mid="acb">
            <a class="easyui-linkbutton" iconCls="icon-edit" plain="true" onClick="editDg1DataDialog();" style="float: left;">修改</a> <div class="btn-separator"></div>
        </p:isPrivilege>
        <p:isPrivilege pid="ac" mid="acc">
            <a class="easyui-linkbutton" iconCls="icon-remove" plain="true" onClick="deleteDg1Data();" style="float: left;">删除</a><div class="btn-separator"></div>
        </p:isPrivilege>
        <a class="easyui-linkbutton" iconCls="icon-reload" plain="true" onClick="reloadDg1Data();" style="float: left;">刷新</a><div class="btn-separator"></div>
        <p:isPrivilege pid="ac" mid="acd">
            <a class="easyui-linkbutton" iconCls="icon-large-chart" plain="true" onClick="setTechnologyProcessFlowChart();" style="float: left;">设置工艺流程图</a><div class="btn-separator"></div>
        </p:isPrivilege>
        <a class="easyui-linkbutton" iconCls="icon-ok" plain="true" onClick="expandAllNode('dg1');" style="float: left;">展开所有节点</a><div class="btn-separator"></div>
        <a class="easyui-linkbutton" iconCls="icon-no" plain="true" onClick="collapseAllNode('dg1');" style="float: left;">折叠所有节点</a><div class="btn-separator"></div>
        <p:isPrivilege pid="ac" mid="acb">
            <a class="easyui-linkbutton" iconCls="icon-sum" plain="true" onClick="updateAllDatas()" style="float: left;">更新所有</a><div class="btn-separator"></div>
        </p:isPrivilege>
        <p:isPrivilege pid="ac" mid="ace">
            <a class="easyui-linkbutton" iconCls="icon-sum" plain="true" onClick="loadDg2Data()" style="float: left;">计算工序工时</a><div class="btn-separator"></div>
        </p:isPrivilege>
        <p:isPrivilege pid="ac" mid="acf">
            <a class="easyui-linkbutton" iconCls="icon-redo" plain="true" onclick="openExportExcelDialog();" style="float: left;">导出Excel</a><div class="btn-separator"></div>
        </p:isPrivilege>
    </div>
    <div>
        <form id="queryForm">
            K3代码：<input id="accessoriesCode_query" class="easyui-textbox" name="accessoriesCode" style="width: 80px;">
            类型：<input id="accessoriesType_query" class="clearButton" name="accessoriesType" style="width: 100px;">
            配件名称：<input id="accessoriesName_query" class="easyui-textbox" name="accessoriesName" style="width: 80px;">
            适用产品：<input id="product_query" class="clearButton" name="product" style="width: 80px;">
            分类：<input id="classification_query" class="clearButton" name="classification" style="width: 80px;">
            物料属性：<input id="materialProperties_query" class="clearButton" name="materialProperties" style="width: 80px;">
            规格型号：<input id="specifications_query" class="clearButton" name="specifications" style="width: 80px;">
            高度：<input id="height_query" name="height" class="clearButton" style="width: 80px;">
            宽度：<input id="width_query" name="width" class="clearButton" style="width: 80px;">
            深度：<input id="depth_query" name="depth" class="clearButton" style="width: 80px;">
            颜色：<input id="color_query" name="color" class="clearButton" style="width: 80px;">
            公式变更检查：<input id="calculationFormulaIsChange_query" name="calculationFormulaIsChange" class="easyui-switchbutton" data-options="onText:'开启',offText:'关闭'">
            <a class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="query()">查询</a>
        </form>
    </div>
</div>
<!-- 上面表格的右键菜单 -->
<div id="menu1" class="easyui-menu" style="width: 80px; display: none;">
    <!--放置一个隐藏的菜单Div-->
    <p:isPrivilege pid="ac" mid="aca">
        <div data-options="iconCls:'icon-add'" onclick="addDg1DataDialog()">新增</div>
    </p:isPrivilege>
    <!--具体的菜单事件请自行添加，跟toolbar的方法是基本一样的-->
    <p:isPrivilege pid="ac" mid="acb">
        <div data-options="iconCls:'icon-edit'" onclick="editDg1DataDialog()">修改</div>
    </p:isPrivilege>
    <p:isPrivilege pid="ac" mid="acc">
        <div data-options="iconCls:'icon-remove'" onclick="deleteDg1Data()">删除</div>
    </p:isPrivilege>
    <div data-options="iconCls:'icon-reload'" onclick="reloadDg1Data()">刷新</div>
    <p:isPrivilege pid="ac" mid="acd">
        <div data-options="iconCls:'icon-large-chart'" onclick="setTechnologyProcessFlowChart()">设置工艺流程图</div>
    </p:isPrivilege>
    <div data-options="iconCls:'icon-ok'" onclick="expandAllNode('dg1')">展开所有节点</div>
    <div data-options="iconCls:'icon-no'" onclick="collapseAllNode('dg1')">折叠所有节点</div>
    <p:isPrivilege pid="ac" mid="acb">
        <div data-options="iconCls:'icon-sum'" onclick="updateAllDatas()">更新所有</div>
    </p:isPrivilege>
    <p:isPrivilege pid="ac" mid="ace">
        <div data-options="iconCls:'icon-sum'" onclick="loadDg2Data()">计算工序工时</div>
    </p:isPrivilege>
    <p:isPrivilege pid="ac" mid="acf">
        <div data-options="iconCls:'icon-redo'" onclick="openExportExcelDialog();">导出Excel</div>
    </p:isPrivilege>
</div>
<!-- 增&改的dialog -->
<div id="dialog1" class="easyui-dialog" style="width: 1200px;height: 'atuo';text-align: center;"
     data-options="closed: true,draggable:true,modal:true,buttons:'#bb1'">
    <form id="form1" style="height: 100%">
        <input id="flag1" type="hidden" value="">
        <input id="id" name="id" type="hidden">
        <input id="orWarStandardAccessoriesId" type="hidden">
        <input id="accessoriesTypeDictionarieCode" type="hidden">

        <div id="productDiv">
            <input id="product" style="width: 80px;">
        </div>
        <table style="border-spacing:10px;border-bottom: 0.5px;">
            <tr>
                <td style="text-align: right;">
                    请选择配件：
                </td>
                <td colspan="7" style="text-align:left;">
                    <select id="standardAccessoriesId" name="warStandardAccessoriesId" style="width: 350px;" data-options="required:true,missingMessage:'请选择配件'"></select>
                </td>
            </tr>
            <tr>
                <td style="text-align: right;">
                    请选择工序：
                </td>
                <td style="text-align: left;">
                    <select id="process" style="width: 150px;" ></select>
                </td>
                <td style="text-align: right;">
                    工序系数：
                </td>
                <td style="text-align:left;">
                    <input id="processCoefficient" name="processCoefficient" value="1" class="easyui-numberbox" data-options="min:0,precision:2">
                </td>
                <td style="text-align: right;">
                    请选择配件：
                </td>
                <td style="text-align: left;">
                    <select id="standardAccessories" style="width: 150px;" ></select>
                </td>
                <td style="text-align: right;">
                    配件系数：
                </td>
                <td style="text-align:left;">
                    <input id="accessoriesCoefficient" name="accessoriesCoefficient" value="1" class="easyui-numberbox" data-options="min:0,precision:2">
                </td>
            </tr>
            <tr>
                <td colspan="4" style="vertical-align: top; text-align: center;width: 500px">
                    <table id="dg1-1"></table>
                </td>
                <td colspan="4" style="vertical-align: top; text-align: center; width: 650px;">
                    <table id="dg1-2"></table>
                </td>
            </tr>
        </table>
    </form>
</div>
<!-- dialog上面dialog的按钮 -->
<div id="bb1" style="text-align: center;">
    <a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="saveOrUpdateDg1Data()">保存</a>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="closeDialog('dialog1')">关闭</a>
</div>


<div region="east" style="width: 400px;" split=true>
    <table id="dg2" name="rows"></table>


</div>


<div id="gridToolBar2" style="padding:5px;height:auto">
    <form id="queryForm2">
        K3代码：<input id="accessoriesCode_query2" class="easyui-textbox" name="accessoriesCode" style="width: 80px;">
        类型：<input id="accessoriesType_query2" class="clearButton" name="accessoriesType" style="width: 100px;">
        配件名称：<input id="accessoriesName_query2" class="easyui-textbox" name="accessoriesName" style="width: 80px;">
        适用产品：<input id="product_query2" class="clearButton" name="product" style="width: 80px;">
        <a class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="query2()">查询</a>
    </form>
</div>

<div id="gridToolBar3" style="padding:5px;height:auto">
    <form id="queryForm3">
        K3代码：<input id="accessoriesCode_query3" class="easyui-textbox" name="accessoriesCode" style="width: 80px;">
        类型：<input id="accessoriesType_query3" class="clearButton" name="accessoriesType" style="width: 100px;">
        配件名称：<input id="accessoriesName_query3" class="easyui-textbox" name="accessoriesName" style="width: 80px;">
        适用产品：<input id="product_query3" class="clearButton" name="product" style="width: 80px;">
        <a class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="query3()">查询</a>
    </form>
</div>



<div id="dialog2" class="easyui-dialog" style="text-align: center;"
     data-options="closed: true,draggable:true,modal:true,zIndex:9001,buttons:'#bb2',width:'500',height:'auto'">
    <form id="form2">
        <table id="table" style="border-spacing:10px;border-bottom: 0.5px;">

        </table>
    </form>
</div>
<!-- dialog上面dialog的按钮 -->
<div id="bb2" style="text-align: center;">
    <a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="calculation()">确定</a>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="closeDialog('dialog2')">关闭</a>
</div>

<div id="dialog3" class="easyui-dialog" style="text-align: center;"
     data-options="closed: true,draggable:true,modal:true,buttons:'#bb3',width:'800',height:'600',
	  	onBeforeClose:function(){
	  							$('#iframe').removeAttr('src');
	  						}
	  						">
    <iframe id="iframe" name="iframe" style="width: 100%;height: 99%;border: none;"></iframe>
</div>
<!-- dialog上面dialog的按钮 -->
<div id="bb3" style="text-align: center;">
    <a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="saveTechnologyProcessFlowChart();">保存</a>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="closeDialog('dialog3');$('#iframe').removeAttr('src');">关闭</a>
</div>

<div id="dialog4" class="easyui-dialog" style="text-align: center;"
     data-options="closed: true,draggable:true,modal:true,buttons:'#bb4',width:'200',height:'auto'">
    <form id="form4" action="${pageContext.request.contextPath}/production/productTechnologyWorkHours/exportExcelById.action" method="post" target="_blank">
        <input id="exportExcelId" type="hidden" name="id">
        <label><input type="radio" name="divisor" value="1" checked="checked">秒</label>
        <label><input type="radio" name="divisor" value="60">分</label>
        <label><input type="radio" name="divisor" value="3600">时</label>
    </form>
</div>
<!-- dialog上面dialog的按钮 -->
<div id="bb4" style="text-align: center;">
    <a class="easyui-linkbutton" data-options="iconCls:'icon-redo'" onclick="exportExcel()">导出</a>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="closeDialog('dialog4')">关闭</a>
</div>


<div id="menu1-1" class="easyui-menu" style="width: 80px; display: none;">
    <div data-options="iconCls:'icon-remove'" onclick="deleteDg11Data()">删除</div>
    <div data-options="iconCls:' icon-sum'" onclick="openCalculationDialog()">计算</div>
</div>

<div id="menu1-2" class="easyui-menu" style="width: 80px; display: none;">
    <div data-options="iconCls:'icon-remove'" onclick="deleteDg12Data()">删除</div>
    <div data-options="iconCls:' icon-sum'" onclick="enableDndDg12()">开启拖放</div>
</div>

<div id="showInfomation" style="visibility: hidden;z-index: 101;position: absolute;"></div>

</body>
<style>
    .switchbutton-on {
        background: #FF0000;
    }  /*开时的样式*/
    .panel-title{
        text-align: center;
        font-size: 14px;
    }
    div .btn-separator {  float: left;  height: 24px;  border-left: 1px solid LightGrey;  border-right: 0px solid LightGrey;  margin: 1px 1px;}
</style>
</html>
