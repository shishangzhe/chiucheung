<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.chiucheung.cn" prefix="p" %>
<!DOCTYPE html>
<html>
<head>
    <title>物料价格管理</title>

    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">
    <jsp:include page="/common.jsp"></jsp:include>

</head>
<script type="text/javascript">
    var isQuery = false;
    $(function () {
        //将dialog中的下拉框值填充
        $("#queryForm .easyui-combobox").combobox({
            url: "${pageContext.request.contextPath}/warehouse/baseData/findAllWarBaseDataByKeyword.action",//加载数据的url
            valueField: 'dictionarieCode',//相当于select的key
            textField: 'dictionarieName',//相当于select的value
            editable: true,//允许编辑
            panelHeight: 'auto',//面板高度根据内容变化
            events: {
                keyup: fnComFixedChineseInput,
                keydown: function (event) {
                    if (event.keyCode == 13) {
                        editableComboboxAutoCompleteSelect(this);
                    }
                },
                change: function () {
                    editableComboboxAutoCompleteSelect(this);
                }
            },
            filter: function (q, row) {
                var opts = $(this).combobox('options');
                return row[opts.textField].toLowerCase().indexOf(q.toLowerCase()) == 0;
            }
        });

        $('#dg').treegrid({
            title: '物料价格管理',
            fit: true,//当设置为true的时候面板大小将自适应父容器
            //fitColumns:true,//真正的自动展开/收缩列的大小，以适应网格的宽度，防止水平滚动。与上面的fit一起自适应页面
            url: '${pageContext.request.contextPath}/purchase/materialPrice/findAllWarMaterialList.action',
            idField: 'id',
            remoteSort: true,//从服务器进行排序
            treeField: 'materialCode',
            toolbar: '#gridToolBar',
            lines: true,
            /*checkbox: true,//开启复选框
            onlyLeafCheck: true,//仅在最子节点开启复选框*/
            pagination: true,
            pageSize: 50,
            pageList: [50, 100, 200, 500],
            //rownumbers:true,//显示一个行号列。
            //lines:true,//定义是否显示treegrid行
            animate: true,//定义节点在展开或折叠的时候是否显示动画效果。
            columns: [[
                {field: 'materialCode', title: '代码', width: 120, halign: 'center', align: 'left', sortable: true},
                {field: 'materialName', title: '名称', width: 120, halign: 'center', align: 'left', sortable: true},
                {field: 'materialType', title: '类型', width: 60, halign: 'center', align: 'left', sortable: true},
                {field: 'applicableProduct',title: '适用产品',width: 100,halign: 'center',align: 'left',
                    formatter: function (value, row, index) {
                        $('#applicableProduct').combobox('setValues', value);
                        var value = $('#applicableProduct').combobox('getText');
                        $('#applicableProduct').combobox('clear');
                        return value.substring(0, value.length);
                    }
                },
                {field: 'originalPrice', title: '原价', width: 60, halign: 'center', align: 'left', sortable: true,
                    formatter: function (value) {
                        if (value != null && value != "") {
                            return value + "￥";
                        }
                    }
                },
                {field: 'newPrice', title: '新价', width: 60, halign: 'center', align: 'left', sortable: true,
                    formatter: function (value) {
                        if (value != null && value != "") {
                            return value + "￥";
                        }
                    }
                },
                {field: 'classification', title: '分类', width: 60, halign: 'center', align: 'left', sortable: true},
                {field: 'materialProperties',title: '物料属性',width: 80,halign: 'center',align: 'left',sortable: true},
                {field: 'specifications', title: '规格型号', width: 80, halign: 'center', align: 'left', sortable: true},
                {field: 'length', title: '长度', width: 80, halign: 'center', align: 'left', sortable: true},
                {field: 'height', title: '高度', width: 80, halign: 'center', align: 'left', sortable: true},
                {field: 'width', title: '宽度', width: 80, halign: 'center', align: 'left', sortable: true},
                {field: 'depth', title: '深度', width: 80, halign: 'center', align: 'left', sortable: true},
                {field: 'color', title: '颜色', width: 50, halign: 'center', align: 'left', sortable: true},
                {field: 'purchaseUnit', title: '采购单位', width: 80, halign: 'center', align: 'left', sortable: true},
                {field: 'purchaseQuantityAccuracy',title: '采购数量精度',width: 80,halign: 'center',align: 'left',sortable: true},
                {field: 'useUnit', title: '使用单位', width: 80, halign: 'center', align: 'left', sortable: true},
                {field: 'useQuantityAccuracy',title: '使用数量精度',width: 80,halign: 'center',align: 'left',sortable: true},
                {field: 'unitConversionFormula',title: '单位换算公式',width: 80,halign: 'center',align: 'left',sortable: true},
                {field: 'batch', title: '批量', width: 80, halign: 'center', align: 'left', sortable: true},
                {field: 'procurementCycle', title: '采购周期', width: 80, halign: 'center', align: 'left', sortable: true},
                {field: 'division', title: '分割数', width: 80, halign: 'center', align: 'left', sortable: true},
                {field: 'productionWorkshop',title: '生产车间',width: 80,halign: 'center',align: 'left',sortable: true},
                {field: 'lowestWarehousingQuantity',title: '最低存仓量',width: 80,halign: 'center',align: 'left',sortable: true},
                {field: 'highestWarehousingQuantity',title: '最高存仓量',width: 80,halign: 'center',align: 'left',sortable: true},
                {field: 'onceProduceQuantity',title: '<span style="font-size:8px;">一次生产/订购量</span>',width: 80,halign: 'center',align: 'left',sortable: true},
                {field: 'minProduceQuantity',title: '<span style="font-size:8px;">最少生产/订购量</span>',width: 80,halign: 'center',align: 'left',sortable: true},
                {field: 'drawingNumber', title: '图号', width: 80, halign: 'center', align: 'left'},
                {field: 'inspectionStandard', title: '检验标准', width: 80, halign: 'center', align: 'left'},
                {field: 'inspectionWay', title: '检验方式', width: 80, halign: 'center', align: 'left'},
                {field: 'warehouse', title: '仓库', width: 60, halign: 'center', align: 'left', sortable: true},
                {field: 'warehousePositions', title: '仓位', width: 60, halign: 'center', align: 'left', sortable: true},
                {field: 'fileId', title: '附件', width: 50, halign: 'center', align: 'left'},
                {field: 'remark', title: '备注', width: 200, halign: 'center', align: 'left', sortable: true}
            ]],
            onContextMenu: function (e, row) { //右键时触发事件
                //三个参数：e里面的内容很多，真心不明白，rowIndex就是当前点击时所在行的索引，rowData当前行的数据
                e.preventDefault(); //阻止浏览器捕获右键事件
                $(this).treegrid('clearSelections');
                if (row != null) {
                    $(this).treegrid("select", row.id); //根据索引选中该行
                }
                $("#menu").menu('show', {//显示右键菜单
                    left: e.pageX,//在鼠标点击处显示菜单
                    top: e.pageY
                });
            },
            onBeforeExpand: function (row) {
                //动态设置展开查询的url
                var url = '${pageContext.request.contextPath}/purchase/materialPrice/findAllWarMaterialList.action?materialCodeForExpand=' + row.materialCode + "&level=" + $(this).treegrid('getLevel', row.id);
                $(this).treegrid("options").url = url;
                return true;
            }, onExpand: function (row) {
                //展开后将url设置为原来的url，否则刷新的时候会使用更改后的url刷新
                var url = '${pageContext.request.contextPath}/purchase/materialPrice/findAllWarMaterialList.action';
                $(this).treegrid("options").url = url;
            }, onLoadError: function () {//如果报错了，同样将url设置为原来的url
                var url = '${pageContext.request.contextPath}/purchase/materialPrice/findAllWarMaterialList.action';
                $(this).treegrid("options").url = url;
            }, onLoadSuccess: function (row, data) {//如果展开后没有数据，不会执行onExpand的事件，则在这里url设置为原来的url
                var url = '${pageContext.request.contextPath}/purchase/materialPrice/findAllWarMaterialList.action';
                $(this).treegrid("options").url = url;
                if (data.query != undefined && data.query.isQuery) {//查询的时候则不以树形表格展示，则以表格的形式展示，isQuery则是标识当前展示的方式
                    $(".tree-icon,.tree-file").remove();
                    $(".tree-inden,.tree-join").remove();
                    $(".tree-inden,.tree-joinbottom").remove();
                    isQuery = data.query.isQuery;
                } else {
                    isQuery = false;
                }
            }
        });

        //给当前供应商可关联物料的搜索区添加键盘回车事件
        $("#queryForm").on("keydown", function (event) {
            if (event.keyCode == 13) {
                query();
            }
        })

    });


    //打开为物料添加价格的dialog
    function openInsertPrice() {
        $.ajax({
            type: 'POST',//post请求
            url: '${pageContext.request.contextPath}/system/user/testLoginTimeout.action',//ajax请求的url
            async: false,//同步请求
            cache: false,//不缓存此页面
            success: function (data) {//请求成功后的回调函数。data：服务器返回数据。
                $("#priceForm").form('reset');//重置表单数据
                //加载添加物料价格的dialog
                $("#priceDialog").dialog({
                    closed: false,//将该dialog的状态由不显示改成显示
                    title: '添加物料价格',//该dialog的标题
                    draggable: true//是否能够拖拽窗口
                });
                $("#priceFlag").val('add');//新增和修改用的是同一个dialog，用于区分是新增还是修改
            }
        });
    }

    //打开为已关联物料修改价格的dialog
    function openUpdatePrice() {
        var select = $("#dg").treegrid("getSelected");
        if (select == null) {
            showMessager("提示", "请选择一项进行操作");
        } else {
            if (!$.isArray(select.children)) {
                $("#priceFlag").val('update');//新增和修改用的是同一个dialog，用于区分是新增还是修改
                $("#priceForm").form('reset');//重置表单数据
                $.ajax({
                    type: 'POST',//post请求
                    url: '${pageContext.request.contextPath}/purchase/materialPrice/selectPriceByMaterialId.action',//ajax请求的url
                    data: {
                        materialId: select.id
                    },
                    async: false,//同步请求
                    cache: false,//不缓存此页面
                    success: function (data) {//请求成功后的回调函数。data：服务器返回数据。
                        if (data != null && data != "") {
                            if (data.success) {
                                $("#priceDialog").dialog({//加载一个dialog
                                    closed: false,//将该dialog的状态由不显示改成显示
                                    title: "修改物料价格"//该dialog的标题
                                });
                                $("#priceForm").form('load', data.materialPrices);//读取记录填充到表单中。
                            } else {
                                showMessager("错误", "该物料还没价格,不允许修改");
                            }
                        }
                    }
                });
            } else {
                showMessager("提示", "请选择最底层物料进行操作");
            }
        }

    }


    //新增或修改已关联物料的价格
    function saveOrUpdatePrice() {
        var flag = $("#priceFlag").val();//获取标识符，
        var url = "${pageContext.request.contextPath}/purchase/materialPrice/";
        if (flag == 'add') {//如果标识符为add，则为新增操作，拼接出新增的url
            url = url + "insertPrice.action";
        } else if (flag == 'update') {//如果标识符为updata，则为修改操作，拼接出修改的url
            url = url + "updatePriceByMaterialId.action";
        }

        $.ajax({
            type: 'POST',//post请求
            url: url,//ajax请求的url
            data: {
                materialId: $("#dg").treegrid("getSelected").id,
                newPrice: $("#priceForm #newPrice")[0].value
            },
            success: function (data) {//请求成功后的回调函数。data：服务器返回数据。
                if (data != null && data != "") {
                    if (data.success) {
                        showMessager("提示", "保存成功");
                        $("#priceDialog").dialog({//关闭这个dialog
                            closed: true
                        });
                        $("#dg").treegrid("reload");//重新加载数据，保持在当前页
                    } else {
                        showMessager("错误", '<font color="red">' + data.message + '<font/>');
                    }
                }
            }
        });

    }

    //开启审核价格的dialog
    function openAuditDialog() {
        var type = '';
        //获取当前要查询的审核状态
        var states = $("#switch").switchbutton('options').checked;
        if (states) {
            type = 'on';
        } else {
            type = 'off';
        }

        //加载物料价格审核的dialog
        $("#auditDialog").dialog({
            closed: false,//将该dialog的状态由不显示改成显示
            title: '物料价格审核',//该dialog的标题
            draggable: true,//是否能够拖拽窗口
            resizable: true//是否能改变窗口大小
        });

        //将dialog中的下拉框值填充
        $("#queryForm1 .easyui-combobox").combobox({
            url: "${pageContext.request.contextPath}/warehouse/baseData/findAllWarBaseDataByKeyword.action",//加载数据的url
            valueField: 'dictionarieCode',//相当于select的key
            textField: 'dictionarieName',//相当于select的value
            editable: true,//允许编辑
            panelHeight: 'auto',//面板高度根据内容变化
            events: {
                keyup: fnComFixedChineseInput,
                keydown: function (event) {
                    if (event.keyCode == 13) {
                        editableComboboxAutoCompleteSelect(this);
                    }
                },
                change: function () {
                    editableComboboxAutoCompleteSelect(this);
                }
            },
            filter: function (q, row) {
                var opts = $(this).combobox('options');
                return row[opts.textField].toLowerCase().indexOf(q.toLowerCase()) == 0;
            }
        });

        //根据按钮状态获取相应状态的物料价格信息
        $("#auditInfo").datagrid({
            loadMsg: '正在努力为您加载数据',
            method: "post",
            url: "${pageContext.request.contextPath }/purchase/materialPrice/findAllWarMaterialList.action",
            fit: true,//当设置为true的时候面板大小将自适应父容器
            queryParams: {switchState: type},
            toolbar: '#toolbar',
            columns: [[
                {field: 'id', title: '物料id', width: 120, halign: 'center', align: 'left', hidden: true},
                {field: 'supplierId', title: '供应商id', width: 120, halign: 'center', align: 'left', hidden: true},
                {field: 'materialCode', title: '代码', width: 120, halign: 'center', align: 'left', sortable: true},
                {field: 'materialName', title: '名称', width: 120, halign: 'center', align: 'left', sortable: true},
                {field: 'materialType', title: '类型', width: 60, halign: 'center', align: 'left', sortable: true},
                {field: 'applicableProduct',title: '适用产品',width: 100,halign: 'center',align: 'left',
                    formatter: function (value, row, index) {
                        $('#applicableProduct').combobox('setValues', value);
                        var value = $('#applicableProduct').combobox('getText');
                        $('#applicableProduct').combobox('clear');
                        return value.substring(0, value.length);
                    }
                },
                {field: 'classification', title: '分类', width: 60, halign: 'center', align: 'left', sortable: true},
                {field: 'originalPrice', title: '原价', width: 60, halign: 'center', align: 'left', sortable: true,
                    formatter: function (value) {
                        if (value != null && value != "") {
                            return value + "￥";
                        }
                    }
                },
                {field: 'newPrice', title: '新价', width: 60, halign: 'center', align: 'left', sortable: true,
                    formatter: function (value) {
                        if (value != null && value != "") {
                            return value + "￥";
                        }
                    }
                },
                {field: 'materialProperties',title: '物料属性',width: 80,halign: 'center',align: 'left',sortable: true},
                {field: 'specifications', title: '规格型号', width: 80, halign: 'center', align: 'left', sortable: true},
                {field: 'length', title: '长度', width: 80, halign: 'center', align: 'left', sortable: true},
                {field: 'height', title: '高度', width: 80, halign: 'center', align: 'left', sortable: true},
                {field: 'width', title: '宽度', width: 80, halign: 'center', align: 'left', sortable: true},
                {field: 'depth', title: '深度', width: 80, halign: 'center', align: 'left', sortable: true},
                {field: 'color', title: '颜色', width: 50, halign: 'center', align: 'left', sortable: true},
                {field: 'purchaseUnit', title: '采购单位', width: 80, halign: 'center', align: 'left', sortable: true},
                {field: 'purchaseQuantityAccuracy',title: '采购数量精度',width: 80,halign: 'center',align: 'left',sortable: true},
                {field: 'useUnit', title: '使用单位', width: 80, halign: 'center', align: 'left', sortable: true},
                {field: 'useQuantityAccuracy',title: '使用数量精度',width: 80,halign: 'center',align: 'left',sortable: true},
                {field: 'unitConversionFormula',title: '单位换算公式',width: 80,halign: 'center',align: 'left',sortable: true},
                {field: 'batch', title: '批量', width: 80, halign: 'center', align: 'left', sortable: true},
                {field: 'procurementCycle', title: '采购周期', width: 80, halign: 'center', align: 'left', sortable: true},
                {field: 'division', title: '分割数', width: 80, halign: 'center', align: 'left', sortable: true},
                {field: 'productionWorkshop',title: '生产车间',width: 80,halign: 'center',align: 'left',sortable: true},
                {field: 'lowestWarehousingQuantity',title: '最低存仓量',width: 80,halign: 'center',align: 'left',sortable: true},
                {field: 'highestWarehousingQuantity',title: '最高存仓量',width: 80,halign: 'center',align: 'left',sortable: true},
                {field: 'onceProduceQuantity',title: '<span style="font-size:8px;">一次生产/订购量</span>',width: 80,halign: 'center',align: 'left',sortable: true},
                {field: 'minProduceQuantity',title: '<span style="font-size:8px;">最少生产/订购量</span>',width: 80,halign: 'center',align: 'left',sortable: true},
                {field: 'drawingNumber', title: '图号', width: 80, halign: 'center', align: 'left'},
                {field: 'inspectionStandard', title: '检验标准', width: 80, halign: 'center', align: 'left'},
                {field: 'inspectionWay', title: '检验方式', width: 80, halign: 'center', align: 'left'},
                {field: 'warehouse', title: '仓库', width: 60, halign: 'center', align: 'left', sortable: true},
                {field: 'warehousePositions', title: '仓位', width: 60, halign: 'center', align: 'left', sortable: true},
                {field: 'fileId', title: '附件', width: 50, halign: 'center', align: 'left'},
                {field: 'remark', title: '描述', width: 200, halign: 'center', align: 'left', sortable: true}
            ]],
            onRowContextMenu: function (e, rowIndex, rowData) { //右键时触发事件
                //三个参数：e里面的内容很多，真心不明白，rowIndex就是当前点击时所在行的索引，rowData当前行的数据
                e.preventDefault(); //阻止浏览器捕获右键事件
                $(this).datagrid("clearSelections"); //取消所有选中项
                if (rowIndex >= 0) {//1.4.5的bug，1.3.5没有这个问题，在其他空白的地方也能右键，但是rowIndex=-1
                    $(this).datagrid("selectRow", rowIndex); //根据索引选中该行
                }
            }
        });

        //给当前物料价格的搜索区添加键盘回车事件
        $("#queryForm1").on("keydown", function (event) {
            if (event.keyCode == 13) {
                queryParam();
            }
        })
    }

    //审核物料价格
    function changStatue() {
        var select = $("#auditInfo").datagrid('getSelections');
        var materialIdList = [];
        for (var i = 0; i < select.length; i++) {
            materialIdList[i] = select[i].id;
        }

        if (select.length > 0) {
            $.ajax({
                type: 'POST',//post请求
                async: false,//同步请求
                cache: false,//不缓存此页面
                url: '${pageContext.request.contextPath}/purchase/materialPrice/updateStatue.action?materialIdList=' + materialIdList,//ajax请求的url

                success: function (data) {//请求成功后的回调函数。data：服务器返回数据。
                    if (data != null && data != "") {
                        if (data.success) {
                            $("#auditDialog").dialog({//加载一个dialog
                                closed: true,//将该dialog的状态由显示改成不显示
                            });
                        } else {
                            showMessager("错误", data.message);
                        }
                    }
                }
            });
        } else {
            showMessager("提示", "请至少选择一项进行操作");
        }
    }

    //刷新物料信息
    function reload() {
        $("#dg").treegrid("reload");
        $("#dg").treegrid('clearSelections');//清除所有选择的行
        $("#queryForm").form('clear');
    }

    //条件查询
    function query() {
        $("#dg").treegrid('load', $("#queryForm").serializeObject());
    }

    //审核dialog中的条件查询
    function queryParam() {
        var state = $("#switch").switchbutton('options').checked;
        //将显示审核状态数据的审核按钮禁用
        if (state) {
            $("#queryForm1 #switchState").val("on");
            $("#editButton").linkbutton('disable');
        } else {
            $("#queryForm1 #switchState").val("off");
            $("#editButton").linkbutton('enable');
        }
        $("#auditInfo").datagrid('load', $("#queryForm1").serializeObject());
    }

</script>
<body>

<table id="dg"></table>

<!-- 上面表格的toolbar按钮 -->
<div id="gridToolBar" style="padding:5px;height:auto">
    <div style="display:inline-block;">
        <p:isPrivilege pid="eb" mid="eba">
            <a class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="openInsertPrice();"
               style="float: left;">添加物料价格</a>
            <!--竖向分割线-->
            <div class="btn-separator"></div>
        </p:isPrivilege>
        <p:isPrivilege pid="eb" mid="ebb">
            <a class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="openUpdatePrice();"
               style="float: left;">修改物料价格</a>
            <div class="btn-separator"></div>
        </p:isPrivilege>
        <p:isPrivilege pid="eb" mid="ebc">
            <a class="easyui-linkbutton" iconCls="icon-man" plain="true" onclick="openAuditDialog();"
               style="float: left;">价格审核</a>
            <div class="btn-separator"></div>
        </p:isPrivilege>

        <a class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="reload();"
           style="float: left;">刷新</a>
        <div class="btn-separator"></div>

    </div>
    <div>
        <form id="queryForm">
            代码：<input id="materialCode" class="easyui-textbox" name="materialCode" style="width: 80px;">
            名称：<input id="materialName" class="easyui-textbox" name="materialName" style="width: 80px;">
            类型：<input id="materialType" class="easyui-combobox" name="materialType" style="width: 80px;"
                      data-options="queryParams: {'keyword' : '类型'}">
            适用产品：<input id="applicableProduct" class="easyui-combobox" name="applicableProduct" style="width: 80px;"
                        data-options="multiple:true,queryParams: {'keyword' : '适用产品'}">
            分类：<input id="classification" class="easyui-combobox" name="classification" style="width: 80px;"
                      data-options="queryParams: {'keyword' : '分类'}">
            物料属性：<input id="materialProperties" class="easyui-combobox" name="materialProperties" style="width: 80px;"
                        data-options="queryParams: {'keyword' : '物料属性'}">
            规格型号：<input id="specifications" class="easyui-combobox" name="specifications" style="width: 80px;"
                        data-options="queryParams: {'keyword' : '规格型号'}">
            颜色：<input id="color" class="easyui-combobox" name="color" style="width: 80px;"
                      data-options="queryParams: {'keyword' : '颜色'}">
            长度：<input id="length" class="easyui-combobox" name="length" style="width: 80px;"
                      data-options="queryParams: {'keyword' : '长度'}">
            宽度：<input id="width" class="easyui-combobox" name="width" style="width: 80px;"
                      data-options="queryParams: {'keyword' : '宽度'}">
            高度：<input id="height" class="easyui-combobox" name="height" style="width: 80px;"
                      data-options="queryParams: {'keyword' : '高度'}">
            深度：<input id="depth" class="easyui-combobox" name="depth" style="width: 80px;"
                      data-options="queryParams: {'keyword' : '深度'}">
            仓库：<input id="warehouse" class="easyui-combobox" name="warehouse" style="width: 80px;"
                      data-options="queryParams: {'keyword' : '仓库'}">
            仓位：<input id="warehousePositions" class="easyui-combobox" name="warehousePositions" style="width: 80px;"
                      data-options="queryParams: {'keyword' : '仓位'}">
            <a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="query()">查询</a>
        </form>
    </div>
</div>

<!--右键菜单区-->
<div id="menu" class="easyui-menu" style="width: 80px; display: none;">
    <p:isPrivilege pid="eb" mid="eba">
        <div data-options="iconCls:'icon-add'" onclick="openInsertPrice();">添加物料价格</div>
    </p:isPrivilege>
    <p:isPrivilege pid="eb" mid="ebb">
        <div data-options="iconCls:'icon-edit'" onclick="openUpdatePrice();">修改物料价格</div>
    </p:isPrivilege>
    <p:isPrivilege pid="eb" mid="ebc">
        <div data-options="iconCls:'icon-man'" onclick="openAuditDialog()">价格审核</div>
    </p:isPrivilege>
    <div data-options="iconCls:'icon-reload'" onclick="reload();">刷新</div>
</div>

<!--审核物料价格的dialog-->
<div id="auditDialog" class="easyui-dialog" style="width: auto;height: 800px;"
     data-options="fit:true,closed: true,draggable:false,modal:true,buttons:'#bb2'">
    <table id="auditInfo"></table>
    <div id="toolbar">
        <form id="queryForm1">
            代码：<input id="materialCodeQuery" class="easyui-textbox" name="materialCode" style="width: 80px;">
            名称：<input id="materialNameQuery" class="easyui-textbox" name="materialName" style="width: 80px;">
            类型：<input id="materialTypeQuery" class="easyui-combobox" name="materialType" style="width: 80px;"
                      data-options="queryParams: {'keyword' : '类型'}">
            适用产品：<input id="applicableProductQuery" class="easyui-combobox" name="applicableProduct"
                        style="width: 80px;"
                        data-options="multiple:true,queryParams: {'keyword' : '适用产品'}">
            分类：<input id="classificationQuery" class="easyui-combobox" name="classification" style="width: 80px;"
                      data-options="queryParams: {'keyword' : '分类'}">
            物料属性：<input id="materialPropertiesQuery" class="easyui-combobox" name="materialProperties"
                        style="width: 80px;"
                        data-options="queryParams: {'keyword' : '物料属性'}">
            规格型号：<input id="specificationsQuery" class="easyui-combobox" name="specifications" style="width: 80px;"
                        data-options="queryParams: {'keyword' : '规格型号'}">
            颜色：<input id="colorQuery" class="easyui-combobox" name="color" style="width: 80px;"
                      data-options="queryParams: {'keyword' : '颜色'}">
            长度：<input id="lengthQuery" class="easyui-combobox" name="length" style="width: 80px;"
                      data-options="queryParams: {'keyword' : '长度'}">
            宽度：<input id="widthQuery" class="easyui-combobox" name="width" style="width: 80px;"
                      data-options="queryParams: {'keyword' : '宽度'}">
            高度：<input id="heightQuery" class="easyui-combobox" name="height" style="width: 80px;"
                      data-options="queryParams: {'keyword' : '高度'}">
            深度：<input id="depthQuery" class="easyui-combobox" name="depth" style="width: 80px;"
                      data-options="queryParams: {'keyword' : '深度'}">
            仓库：<input id="warehouseQuery" class="easyui-combobox" name="warehouse" style="width: 80px;"
                      data-options="queryParams: {'keyword' : '仓库'}">
            仓位：<input id="warehousePositionsQuery" class="easyui-combobox" name="warehousePositions"
                      style="width: 80px;"
                      data-options="queryParams: {'keyword' : '仓位'}">
            是否审核：<input id="switch" class="easyui-switchbutton" data-options="onText:'审核',offText:'未审核'">
            <!--存储审核状态-->
            <input input id="switchState" name="switchState" type="hidden">
            <a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="queryParam()">查询</a>
        </form>
    </div>
</div>


<!--物料增&改价格的dialog-->
<div id="priceDialog" class="easyui-dialog" style="width:350px;height: 150px;"
     data-options="closed: true,draggable:false,modal:true,buttons:'#bb1'">
    <form id="priceForm">
        <input id="priceFlag" type="hidden" value="">
        <input id="priceId" name="id" type="hidden" value="">
        <table style="border-spacing:10px;border-bottom: 0.5px;text-align: right;">
            <tr>
                <td style="text-align: right;">价格：</td>
                <td style="text-align: left;"><input id="newPrice" class="easyui-numberbox" data-options="min:0,precision:2,suffix:'￥'" type="text" name="newPrice" style="width: 80px;"></td>
            </tr>
        </table>

    </form>
</div>

<!--priceDialog上面的dialog按钮-->
<div id="bb1" style="text-align: center;">
    <a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="saveOrUpdatePrice()">确定</a>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="closeDialog('priceDialog')">关闭</a>
</div>

<!--auditDialog上面的dialog按钮-->
<div id="bb2" style="text-align: center;">
    <a class="easyui-linkbutton" id="editButton" data-options="iconCls:'icon-ok'" onclick="changStatue()">审核</a>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="closeDialog('auditDialog')">关闭</a>
</div>

</body>
</html>
