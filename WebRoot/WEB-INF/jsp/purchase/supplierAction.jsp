<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.chiucheung.cn" prefix="p" %>
<!DOCTYPE html>
<html>
<head>
    <title>供应商管理</title>
    <jsp:include page="/common.jsp"></jsp:include>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/verification.js"></script>
</head>

<script type="text/javascript">

    //初始化
    $(function () {
        //加载供应商的初始化数据
        $('#dg').datagrid({
            title: '供应商管理表',//表格的标题
            loadMsg: '正在努力为您加载数据',
            url: "${pageContext.request.contextPath }/purchase/warehousing/selectSupplierList.action",
            method: "post",//提交参数的方式
            fit: true,//当设置为true的时候面板大小将自适应父容器
            fitColumns: true,//表格是否自适应页面
            pagination: true,//分页控件
            pageList: [15, 20, 25, 30],//选择一页显示多少数据
            pageSize: 15,//默认每页显示的条数
            striped: true,//是否显示斑马线效果
            singleSelect: true,//单选
            //ctrlSelect:true,//设置为多选时，这个是按Ctrl可以多选
            columns: [[
                {field: 'id', title: 'id', halign: 'center', align: "center", hidden: true},
                {field: 'name', title: '供应商名称', halign: 'center', align: "center", sortable: true},
                {field: 'fullName', title: '全名', halign: 'center', align: "center"},
                {field: 'abbreviation', title: '简称', halign: 'center', align: "center"},
                {field: 'address', title: '地址', halign: 'center', align: "center", sortable: true},
                {field: 'contacts', title: '联系人', halign: 'center', align: "center", sortable: true},
                {field: 'phone', title: '手机号', halign: 'center', align: "center"},
                {field: 'telephone', title: '座机', halign: 'center', align: "center"},
                {field: 'depositBank', title: '开户银行', halign: 'center', align: "center"},
                {field: 'bankAccount', title: '银行账号', halign: 'center', align: "center"},
                {field: 'supplyLevel', title: '供应商等级', halign: 'center', align: "center", sortable: true},
                {field: 'taxRegistrationNumber', title: '税务登记号', halign: 'center', align: "center"},
                {field: 'valueAddedTaxRate', title: '增值税率', halign: 'center', align: "center",
                    formatter:function (value) {
                    if (value != null && value != ""){
                        return value+"%";
                        }
                    }
                },
                {field: 'state', title: '状态', halign: 'center', align: "center", sortable: true},
                {field: 'fax', title: '传真', halign: 'center', align: "center"},
                {field: 'postalCode', title: '邮编', halign: 'center', align: "center"},
                {field: 'mailingAddress', title: '邮编地址', halign: 'center', align: "center"},
                {field: 'paymentMethod', title: '付款方式', halign: 'center', align: "center", sortable: true},
                {field: 'invoiceType', title: '发票类型', halign: 'center', align: "center"},
                {field: 'country', title: '国家', halign: 'center', align: "center"},
                {field: 'province', title: '省', halign: 'center', align: "center"},
                {field: 'city', title: '市', halign: 'center', align: "center"},
                {
                    field: 'haveImg', title: '附件', halign: 'center', align: "center",
                    formatter: function (value, row, index) {
                        if (value != "" && value != null) {
                            if (value > 0) {

                                return "<button style='font-size:5px;font-style: normal' onclick='getImg(\"" + row.id + "\")'>图片详情</button>";
                            }

                        } else {
                            return "<font color='#FF0000'>无图片</font>";
                        }
                    }
                }
            ]],
            toolbar: '#gridToolBar',
            onRowContextMenu: function (e, rowIndex, rowData) { //右键时触发事件
                //三个参数：e里面的内容很多，真心不明白，rowIndex就是当前点击时所在行的索引，rowData当前行的数据
                e.preventDefault(); //阻止浏览器捕获右键事件
                $(this).datagrid("clearSelections"); //取消所有选中项
                if (rowIndex >= 0) {//1.4.5的bug，1.3.5没有这个问题，在其他空白的地方也能右键，但是rowIndex=-1
                    $(this).datagrid("selectRow", rowIndex); //根据索引选中该行
                }
                $("#menu").menu('show', {//显示右键菜单
                    left: e.pageX,//在鼠标点击处显示菜单
                    top: e.pageY
                });
            }
        });
        //初始化国家值
        $("#country").combobox({
            limitToList: true,
            width: 70,
            onSelect: function (rec) {
                if (rec.value == "中国") {
                    getProvince();
                    $("#province").combobox('enable');
                } else {
                    //当国家不为中国时清除禁用省市选项
                    $("#province").combobox('clear');
                    $("#province").combobox('disable');
                    $("#city").combobox('clear');
                    $("#city").combobox('disable');
                }
            }
        });

        //初始化发票类型值
        $("#invoiceType").combobox({
            url: "${pageContext.request.contextPath}/system/dictionarie/findAllDictionarieByKeyword.action",//加载数据的url
            queryParams: {//url的参数
                "keyword": "发票类型"
            },
            width: 130,
            valueField: 'dictionarieName',//相当于select的key
            textField: 'dictionarieName'//相当于select的value
        });

        //给供应商的搜索区添加键盘回车事件
        $("#queryForm").on("keydown",function (event) {
            if (event.keyCode == 13){
                query();
            }
        })

    });

    //开启查看文件详情dialog
    function getImg(id) {
        var url = "${pageContext.request.contextPath}/purchase/warehousing/selectFileBySupplierId.action?supplierId=" + id;//根据ID从后台取数据的url
        $.ajax({
            type: 'POST',//post请求
            url: url,//ajax请求的url
            async: false,//同步请求
            cache: false,//不缓存此页面
            contentType: false,
            processData: false,
            success: function (data) {//请求成功后的回调函数。data：服务器返回数据。
                if (data != null && data != "") {
                    if (data.success) {
                        $("#imgDialog").dialog({//加载一个dialog
                            closed: false,//将该dialog的状态由不显示改成显示
                            title: "文件查看"//该dialog的标题
                        });
                        if (data.supplierFiles) {
                            var fileArray = data.supplierFiles;
                            var s1 = "";
                            var s2 = "";
                            for (var i = 0; i < fileArray.length; i++) {
                                var file = fileArray[i];
                                if (file.fileType == "registered") {
                                    $("#fileDiv2").show();
                                    s2 += "<a href='getFileInfo.action?path=" + file.filePath + "' target='target_'>" + file.fileName + "</a><image src='${pageContext.request.contextPath}/image/delete.gif' title='删除' alt='删除' style='cursor: pointer;'  onclick=' deleteFile(\"" + file.id + "\"\,\"" + id + "\") '><br>";

                                }
                                if (file.fileType == "business") {
                                    $("#fileDiv1").show();
                                    s1 += "<a href='getFileInfo.action?path=" + file.filePath + "' target='target_'>" + file.fileName + "</a><image src='${pageContext.request.contextPath}/image/delete.gif' title='删除' alt='删除' style='cursor: pointer;'  onclick='deleteFile(\"" + file.id + "\"\,\"" + id + "\")'><br>"
                                }
                            }
                            //当营业执照文件为空时隐藏属于营业执照的tr标签
                            if (s1 == "") {
                                document.getElementById("tr1").style.display = "none";
                            } else {
                                document.getElementById("tr1").style.display = "";
                            }
                            //当注册商标为空时隐藏属于注册商标的tr标签
                            if (s2 == "") {
                                document.getElementById("tr2").style.display = "none";
                            } else {
                                document.getElementById("tr2").style.display = "";
                            }
                            $("#fileDiv1").html(s1);
                            $("#fileDiv2").html(s2);

                        } else {
                            //关闭dialog操作页面
                            closeDialog('imgDialog');
                            //刷新页面
                            reload();
                            //提示文件不存在信息
                            showMessager("文件不存在");
                        }
                    } else {
                        showMessager("错误", '<font color="red">' + data.message + '<font/>');
                    }
                }
            }
        });
    }

    //根据文件id删除文件
    function deleteFile(id, supplierId) {
        $.messager.confirm('确认对话框', '您确定要删除吗？', function (b) {//给用户一个删除几条信息的确认提示框
            if (b) {//如何用户点击的是确认
                $.ajax({
                    type: 'POST',//post请求
                    url: "${pageContext.request.contextPath}/purchase/warehousing/deleteFileById.action",//ajax请求的url
                    data: {id: id},//传的参数,序列化表单
                    async: false,//同步请求
                    cache: false,//不缓存此页面
                    success: function (data) {//请求成功后的回调函数。data：服务器返回数据。
                        if (data != null && data != "") {
                            if (data.success) {
                                showMessager("提示", "文件删除成功");
                                getImg(supplierId);
                            } else {
                                showMessager("错误", '<font color="red">' + data.message + '<font/>');
                            }
                        }
                    }
                });
            }
        });

    }

    //开启新增供应商dialog
    function add() {
        $.ajax({
            type: 'POST',//post请求
            url: '${pageContext.request.contextPath}/system/user/testLoginTimeout.action',//ajax请求的url
            async: false,//同步请求
            cache: false,//不缓存此页面
            success: function (data) {//请求成功后的回调函数。data：服务器返回数据。
                $("#form1").form('reset');//重置表单数据
                $("#dialog1").dialog({//加载一个dialog
                    closed: false,//将该dialog的状态由不显示改成显示
                    title: '新增供应商',//该dialog的标题,
                    draggable: true//是否能够拖拽窗口
                });
                $("#flag").val('add');//新增和修改用的是同一个dialog，用于区分是新增还是修改
            }
        });
    }

    //开启修改供应商dialog
    function edit() {
        var select = $("#dg").datagrid("getSelected");
        if (select != null) {
            var url = "${pageContext.request.contextPath}/purchase/warehousing/selectSupplierById.action?supplierId=" + select.id;//根据ID从后台取数据的url
            $("#form1").form('reset');//重置表单数据
            $("#flag").val('update');//新增和修改用的是同一个dialog，用于区分是新增还是修改
            $.ajax({
                type: 'POST',//post请求
                url: url,//ajax请求的url
                //data: new FormData($( "#form1" )[0]),//传的参数,序列化表单
                async: false,//同步请求
                cache: false,//不缓存此页面
                contentType: false,
                processData: false,
                success: function (data) {//请求成功后的回调函数。data：服务器返回数据。
                    if (data != null && data != "") {
                        if (data.success) {
                            $("#dialog1").dialog({//加载一个dialog
                                closed: false,//将该dialog的状态由不显示改成显示
                                title: "修改供应商"//该dialog的标题
                            });
                            $("#form1").form('load', data.purSupplier);//读取记录填充到表单中。
                        } else {
                            showMessager("错误", '<font color="red">' + data.message + '<font/>');
                        }
                    }
                }
            });
        } else {
            showMessager("提示", "请选择一条记录进行修改");
        }
    }

    //新增或修改操作
    function saveOrUpdate() {
        if ($("#form1").form('validate')) {//判断 验证是否通过
            var flag = $("#flag").val();//获取标识符，
            var url = "${pageContext.request.contextPath}/purchase/warehousing/";
            if (flag == 'add') {//如果标识符为add，则为新增操作，拼接出新增的url
                url = url + "insertSupplier.action";
            } else if (flag == 'update') {//如果标识符为updata，则为修改操作，拼接出修改的url
                url = url + "updateSupplier.action";
            }

            //获取上传文件的数量
            var businessLength = $("#businessLicense").filebox('getText').split(",").length;
            var registeredLength = $("#registeredTrademark").filebox('getText').split(",").length;

            if (businessLength >3 || registeredLength >3){
                alert("营业执照或注册商标上传的文件数量不能超过3张")
            }else {

                $.ajax({
                    type: 'POST',//post请求
                    url: url,//ajax请求的url
                    data: new FormData($("#form1")[0]),//传的参数,序列化表单
                    async: false,//同步请求
                    cache: false,//不缓存此页面
                    contentType: false,
                    processData: false,
                    success: function (data) {//请求成功后的回调函数。data：服务器返回数据。
                        if (data != null && data != "") {
                            if (data.success) {
                                showMessager("提示", "保存成功");
                                $("#dialog1").dialog({//关闭这个dialog
                                    closed: true
                                });
                                $("#dg").datagrid('reload');//重新加载数据，保持在当前页
                            } else {
                                showMessager("错误", '<font color="red">' + data.message + '<font/>');
                            }
                        }
                    }
                });
            }
        }
    }

    //删除操作
    function removeData() {
        var select = $("#dg").datagrid("getSelected");
        if (select != null) {
            $.messager.confirm('确认对话框', '您确定要删除吗？', function (b) {//给用户一个删除几条信息的确认提示框
                if (b) {//如何用户点击的是确认
                    $.ajax({
                        type: 'POST',//post请求
                        url: "${pageContext.request.contextPath}/purchase/warehousing/deleteSupplier.action",//ajax请求的url
                        data: {supplierId: select.id},//传的参数,序列化表单
                        async: false,//同步请求
                        cache: false,//不缓存此页面
                        success: function (data) {//请求成功后的回调函数。data：服务器返回数据。
                            if (data.success) {
                                showMessager("提示", data.message);
                                //重新加载供应商数据，保持在当前页
                                $("#dg").datagrid('reload');
                            } else {
                                showMessager("错误", data.message);
                            }
                        }
                    });
                }
            });
        } else {
            showMessager("提示", "请选择一条记录进行删除");
        }
    }

    //刷新供应商数据
    function reload() {
        //重置供应商中的查询条件的form表单数据
        $("#queryForm").form('reset');
        query();
    }

    //根据条件查询供应商数据
    function query() {
        $("#dg").datagrid('load', $("#queryForm").serializeObject());//重新加载数据
        $("#dg").datagrid('clearSelections');//清除所有选择的行
    }

    //将combobox获取到的值进行渲染
    function formatItem(row) {
        var opts = $(this).combobox('options');
        return row[opts.textField];
    }

    //获取省份的值
    function getProvince() {
        $("#province").combobox({
            valueField: 'text',
            textField: 'text',
            limitToList: true,//设置为true,输入的值只能是列表框中的值
            width: 90,
            url: '${pageContext.request.contextPath }/js/city.js',
            formatter: formatItem,
            onSelect: function (rec) {
                getCity(rec);
                $("#city").combobox('enable');
            }
        });
    }

    //获取市区的值
    function getCity(rec) {
        $("#city").combobox({
            valueField: 'text',
            textField: 'text',
            limitToList: true,
            width: 160,
            data: rec.children
        });
    };

    //开启关联物料的dialog
    function relation() {
        //获取当前选择的供应商
        var select = $("#dg").datagrid("getSelected");
        if (select != null) {
            //加载一个显示关联物料的dialog
            $("#materielDialog").dialog({
                closed: false,//将该dialog的状态由不显示改成显示
                title: '关联物料',//该dialog的标题
                draggable: true//是否能够拖拽窗口
            });
            //重置已关联物料中的查询条件的form表单数据
            $("#queryForm1").form('reset');
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
                    /* focus:function(){
                        $(this).parent().prev().combobox('showPanel')
                    }, */
                    change: function () {
                        editableComboboxAutoCompleteSelect(this);
                    }
                },
                filter: function (q, row) {
                    var opts = $(this).combobox('options');
                    return row[opts.textField].toLowerCase().indexOf(q.toLowerCase()) == 0;
                }
            });

            //显示当前供应商关联的物料信息
            $('#materialDG').datagrid({
                fit: true,//当设置为true的时候面板大小将自适应父容器
                //fitColumns:true,//真正的自动展开/收缩列的大小，以适应网格的宽度，防止水平滚动。与上面的fit一起自适应页面
                url: '${pageContext.request.contextPath}/purchase/warehousing/selectInfoBySupplierId.action',
                remoteSort: true,//从服务器进行排序
                queryParams: {supplierId: select.id},
                toolbar: '#materialGridToolBar',
                singleSelect: false,//多选
                pagination: true,
                pageSize: 50,
                pageList: [50, 100, 200, 500],
                //rownumbers:true,//显示一个行号列。
                //lines:true,//定义是否显示treegrid行
                animate: true,//定义节点在展开或折叠的时候是否显示动画效果。
                columns: [[
                    {field: 'id', title: '物料id', width: 120, halign: 'center', align: 'left', hidden: true},
                    {field: 'supplierId', title: '供应商id', width: 120, halign: 'center', align: 'left', hidden: true},
                    {field: 'materialCode', title: '代码', width: 120, halign: 'center', align: 'left', sortable: true},
                    {field: 'materialName', title: '名称', width: 120, halign: 'center', align: 'left', sortable: true},
                    {field: 'materialType', title: '类型', width: 60, halign: 'center', align: 'left', sortable: true},
                    {field: 'applicableProduct',title: '适用产品',width: 100,halign: 'center',align: 'left',
                        formatter: function (value, row, index) {
                            $('#applicableProductQuery').combobox('setValues', value);
                            var value = $('#applicableProductQuery').combobox('getText');
                            $('#applicableProductQuery').combobox('clear');
                            return value.substring(0, value.length);
                        }
                    },
                    {field: 'classification', title: '分类', width: 60, halign: 'center', align: 'left', sortable: true},
                    {field: 'originalPrice', title: '原价', width: 60, halign: 'center', align: 'left', sortable: true,
                        formatter:function (value) {
                            if (value != null && value != ""){
                                return value+"￥";
                            }
                        }
                    },
                    {field: 'newPrice', title: '新价', width: 60, halign: 'center', align: 'left', sortable: true,
                        formatter:function (value) {
                            if (value != null && value != ""){
                                return value+"￥";
                            }
                        }
                    },
                    {field: 'materialProperties',title: '物料属性',width: 80,halign: 'center',align: 'left',sortable: true},
                    {field: 'specifications',title: '规格型号',width: 80,halign: 'center',align: 'left',sortable: true},
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
                    {field: 'procurementCycle',title: '采购周期',width: 80,halign: 'center',align: 'left',sortable: true},
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
                    {field: 'warehousePositions',title: '仓位',width: 60,halign: 'center',align: 'left',sortable: true},
                    {field: 'fileId', title: '附件', width: 50, halign: 'center', align: 'left'},
                    {field: 'remark', title: '描述', width: 200, halign: 'center', align: 'left', sortable: true},
                    {field: 'createTime', title: '创建时间', width: 200, halign: 'center', align: 'left', sortable: true}
                ]],
                onLoadSuccess: function (data) {//物料加载成功后将供应商id赋值到查询框中的supplierId中
                    $("#queryForm1 #supplierIdQuery").val('');
                    var select = $("#dg").datagrid("getSelected");
                    $("#queryForm1 #supplierIdQuery").val(select.id);
                },
                onRowContextMenu: function (e, rowIndex, rowData) { //右键时触发事件
                    //三个参数：e里面的内容很多，真心不明白，rowIndex就是当前点击时所在行的索引，rowData当前行的数据
                    e.preventDefault(); //阻止浏览器捕获右键事件
                    $(this).datagrid("clearSelections"); //取消所有选中项
                    if (rowIndex >= 0) {//1.4.5的bug，1.3.5没有这个问题，在其他空白的地方也能右键，但是rowIndex=-1
                        $(this).datagrid("selectRow", rowIndex); //根据索引选中该行
                    }
                    $("#materialMenu").menu('show', {//显示右键菜单
                        left: e.pageX,//在鼠标点击处显示菜单
                        top: e.pageY
                    });
                }
            });

            //给当前供应商关联物料的搜索区添加键盘回车事件
            $("#queryForm1").on("keydown",function (event) {
                if (event.keyCode == 13){
                    queryByParam();
                }
            })
        } else {
            showMessager("提示", "请选择一条记录进行操作");
        }
    }

    //根据条件查询关联的物料数据
    function queryByParam() {
        $("#materialDG").datagrid('load', $("#queryForm1").serializeObject());//重新加载数据
        $("#materialDG").datagrid('clearSelections');//清除所有选择的行
    }

    //开启新增关联物料dialog
    function addMaterial() {
        //加载可新增关联物料dialog
        $("#materialInfoDialog").dialog({
            closed: false,//将该dialog的状态由不显示改成显示
            title: '物料',//该dialog的标题
            draggable: true//是否能够拖拽窗口
        });
        //重置物料中的查询条件的form表单数据
        $("#queryForm2").form('reset');

        //将dialog中的下拉框值填充
        $("#queryForm2 .easyui-combobox").combobox({
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
                /* focus:function(){
                    $(this).parent().prev().combobox('showPanel')
                }, */
                change: function () {
                    editableComboboxAutoCompleteSelect(this);
                }
            },
            filter: function (q, row) {
                var opts = $(this).combobox('options');
                return row[opts.textField].toLowerCase().indexOf(q.toLowerCase()) == 0;
            }
        });
        //加载物料选择页面
        $('#materialInfoDG').treegrid({//加载物料选择页面
            fit: true,//当设置为true的时候面板大小将自适应父容器
            //fitColumns:true,//真正的自动展开/收缩列的大小，以适应网格的宽度，防止水平滚动。与上面的fit一起自适应页面
            url: '${pageContext.request.contextPath}/purchase/warehousing/findAllWarMaterialList.action',
            idField: 'id',
            toolbar: "#materialInfoToolBar",
            remoteSort: true,//从服务器进行排序
            treeField: 'materialCode',
            lines: true,
            pagination: true,
            pageSize: 50,
            pageList: [50, 100, 200, 500],
            checkbox: true,//显示复选框
            onlyLeafCheck: true,//是否仅在叶子节点上显示复选框(须与复选框合用)
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
                    formatter:function (value) {
                        if (value != null && value != ""){
                            return value+"￥";
                        }
                    }
                },
                {field: 'newPrice', title: '新价', width: 60, halign: 'center', align: 'left', sortable: true,
                    formatter:function (value) {
                        if (value != null && value != ""){
                            return value+"￥";
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
            onBeforeExpand: function (row) {
                //动态设置展开查询的url
                var url = '${pageContext.request.contextPath}/warehouse/material/findAllWarMaterialList.action?materialCodeForExpand=' + row.materialCode + "&level=" + $(this).treegrid('getLevel', row.id);
                $(this).treegrid("options").url = url;
                return true;
            }, onExpand: function (row) {
                //展开后将url设置为原来的url，否则刷新的时候会使用更改后的url刷新
                var url = '${pageContext.request.contextPath}/warehouse/material/findAllWarMaterialList.action';
                $(this).treegrid("options").url = url;
            }, onLoadError: function () {//如果报错了，同样将url设置为原来的url
                var url = '${pageContext.request.contextPath}/warehouse/material/findAllWarMaterialList.action';
                $(this).treegrid("options").url = url;
            }, onLoadSuccess: function (row, data) {//如果展开后没有数据，不会执行onExpand的事件，则在这里url设置为原来的url
                var url = '${pageContext.request.contextPath}/warehouse/material/findAllWarMaterialList.action';
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
        $("#queryForm2").on("keydown",function (event) {
            if (event.keyCode == 13){
                queryMaterial();
            }
        })

    }

    //删除已关联物料的操作
    function removeMaterial() {
        //重置已关联物料中的查询条件的form表单数据
        $("#queryForm1").form('reset');

        var materials = [];
        var select = $("#materialDG").datagrid("getSelections");
        for (var i = 0; i < select.length; i++) {
            materials[i] = select[i].id;
        }

        if (select.length > 0) {
            $.messager.confirm('确认对话框', '您确定要删除吗？', function (b) {//给用户一个删除几条信息的确认提示框
                if (b) {//如何用户点击的是确认
                    $.ajax({
                        type: 'POST',//post请求
                        url: "${pageContext.request.contextPath}/purchase/warehousing/deleteBySupplierId.action?materials=" + materials,//ajax请求的url
                        async: false,//同步请求
                        cache: false,//不缓存此页面
                        success: function (data) {//请求成功后的回调函数。data：服务器返回数据。
                            if (data.success) {
                                showMessager("提示", data.message);
                                //重新加载已关联物料数据，保持在当前页
                                $("#materialDG").datagrid('reload');
                            } else {
                                showMessager("错误", data.message);
                            }
                        }
                    });
                }
            });
        } else {
            showMessager("提示", "请选择一条记录进行删除");
        }
    }

    //刷新已关联物料信息
    function reloadMaterial() {
        //重置已关联物料中的查询条件的form表单数据
        $("#queryForm1").form('reset');

        $('#materialDG').datagrid('reload');
    }

    //查询可新增关联物料信息
    function queryMaterial() {
        $("#materialInfoDG").treegrid('load', $("#queryForm2").serializeObject());//重新加载数据
        $("#materialInfoDG").treegrid('clearSelections');//清除所有选择的行
    }

    //新增关联物料
    function insertInfo() {
        //重置已关联物料中的查询条件的form表单数据
        $("#queryForm1").form('reset');
        //创建一个用来存物料id的数组对象
        var materials = [];
        //获取当前所有选择的物料
        var material = $("#materialInfoDG").treegrid("getCheckedNodes");
        var supplier = $("#dg").datagrid("getSelected");
        //循环选中的物料并将id赋值到一个数组对象中
        for (var i = 0; i < material.length; i++) {
            materials[i] = material[i].id;
        }
        if (material.length > 0) {
            var url = "${pageContext.request.contextPath}/purchase/warehousing/insertSupplierAndMaterial.action?supplierId=" + supplier.id + "&material=" + materials;//根据ID从后台取数据的url
            $.ajax({
                type: 'POST',//post请求
                url: url,//ajax请求的url
                async: false,//同步请求
                cache: false,//不缓存此页面
                contentType: false,
                processData: false,
                success: function (data) {//请求成功后的回调函数。data：服务器返回数据。
                    if (data.success) {
                        showMessager("提示", data.message);
                        //将添加物料的dialog窗口关闭
                        $("#materialInfoDialog").dialog({
                            closed: true,
                        });
                        //重新加载关联物料数据，保持在当前关联物料页面
                        $("#materialDG").datagrid('reload');
                        //清除所有选择的行
                        $("#materialDG").datagrid('clearSelections');
                    } else {
                        showMessager("错误", data.message);
                    }
                }
            });
        } else {
            showMessager("提示", "请选择一条记录进行新增");
        }
        //清除所有勾选的行
        $('#materialInfoDG').treegrid('clearChecked');

    }


</script>

<body>
<!--显示供应商-->
<table id="dg"
       data-options="onDblClickCell: function(rowIndex, field, value){edit();}"
></table>

<!-- 上面表格的toolbar按钮 -->
<div id="gridToolBar" style="padding:5px;height:auto;">
    <div style="display:inline-block;">
        <p:isPrivilege pid="ea" mid="eaa">
            <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onClick="add()" style="float: left;">新增</a>
            <div class="btn-separator"></div>
        </p:isPrivilege>
        <p:isPrivilege pid="ea" mid="eab">
            <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onClick="edit();" style="float: left;">修改</a>
            <div class="btn-separator"></div>
        </p:isPrivilege>
        <p:isPrivilege pid="ea" mid="eac">
            <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onClick="removeData()" style="float: left;">删除</a>
            <div class="btn-separator"></div>
        </p:isPrivilege>
        <p:isPrivilege mid="ea" pid="ead">
            <a class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="relation();" style="float: left;">查看关联物料</a>
            <div class="btn-separator"></div>
        </p:isPrivilege>
        <a href="#" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="reload();" style="float: left;">刷新</a>
        <div class="btn-separator"></div>
    </div>
    <div>
        <form id="queryForm">
            供应商名称：<input id="name_query" type="text" class="easyui-textbox" name="name" style="width: 70px">
            省：<input id="province_query" type="text" class="easyui-textbox" name="province" style="width: 70px">
            市：<input id="city_query" type="text" class="easyui-textbox" name="city" style="width: 70px">
            供应商等级:<input id="supplyLevel_query" name="supplyLevel" class="easyui-combobox" style="width:60px;"
                         data-options="
                                  url:'${pageContext.request.contextPath}/system/dictionarie/findAllDictionarieByKeyword.action',
                                  queryParams: {
                                     'keyword': '供应商等级'
                                    },
                                  valueField:'dictionarieName',
                                  textField:'dictionarieName',
                                  formatter: formatItem,
                                  limitToList: true,
                                  ">
            <a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="query()">查询</a>
        </form>
    </div>

</div>
<!--右键菜单区-->
<div id="menu" class="easyui-menu" style="width: 80px; display: none;">
    <p:isPrivilege pid="ea" mid="eaa">
        <div data-options="iconCls:'icon-add'" onclick="add();">新增</div>
    </p:isPrivilege>
    <p:isPrivilege pid="ea" mid="eab">
        <div data-options="iconCls:'icon-edit'" onclick="edit();">修改</div>
    </p:isPrivilege>
    <p:isPrivilege pid="ea" mid="eac">
        <div data-options="iconCls:'icon-remove'" onclick="removeData()">删除</div>
    </p:isPrivilege>
    <p:isPrivilege mid="ea" pid="ead">
        <div data-options="iconCls:'icon-mini-edit'" onclick="relation();">查看关联物料</div>
    </p:isPrivilege>
    <div data-options="iconCls:'icon-reload'" onclick="reload();">刷新</div>
</div>

<!-- 增&改用户的dialog -->
<div id="dialog1" class="easyui-dialog" style="width: 700px;height: 500px;"
     data-options="closed: true,draggable:false,modal:true,buttons:'#bb1'">
    <form id="form1">
        <input id="flag" type="hidden" value="">
        <input id="id" type="hidden" name="id" value="">
        <table style="border-spacing:10px;border-bottom: 0.5px;text-align: right;">
            <tr>

                <td style="text-align: right;">供应商名称：</td>
                <td style="text-align: left;"><input id="name" type="text" class="easyui-textbox" name="name" style="width: 80px" data-options="required:true,missingMessage:'供应商名称不能为空'"></td>
                <td style="text-align: right;">全名：</td>
                <td style="text-align: left;"><input id="fullName" type="text" class="easyui-textbox" name="fullName" style="width: 80px"></td>
                <td style="text-align: right;">简称：</td>
                <td style="text-align: left;"><input id="abbreviation" type="text" class="easyui-textbox" name="abbreviation" style="width: 80px"></td>
            </tr>
            <tr>
                <td style="text-align: right;">联系人：</td>
                <td style="text-align: left;"><input id="contacts" type="text" class="easyui-textbox" name="contacts" style="width: 80px;" data-options="required:true,missingMessage:'联系人不能为空'"></td>
                <td style="text-align: right;">手机号：</td>
                <td style="text-align: left;"><input id="phone" type="text" class="easyui-textbox" name="phone" style="width: 90px;" data-options="required:true,missingMessage:'手机号不能为空',validType:'phoneNum'">
                </td>
                <td style="text-align: right;">地址：</td>
                <td style="text-align: left;"><input id="address" type="text" class="easyui-textbox" name="address" style="width: 130px;" data-options="required:true,missingMessage:'地址不能为空'"></td>
            </tr>
            <tr>
                <td style="text-align: right;">座机：</td>
                <td style="text-align: left;"><input id="telephone" type="text" class="easyui-textbox" name="telephone" style="width: 80px;" data-options="required:false,missingMessage:'座机不能为空',validType:'telNum'">
                </td>
                <td style="text-align: right;">传真：</td>
                <td style="text-align: left;"><input id="fax" type="text" class="easyui-textbox" name="fax" style="width: 80px;" data-options="required:false,validType:'faxNum'"></td>
                <td style="text-align: right;">邮编：</td>
                <td style="text-align: left;"><input id="postalCode" type="text" class="easyui-textbox" name="postalCode" style="width: 80px;" data-options="required:false,validType:'codeNum'"></td>
            </tr>
            <tr>
                <td style="text-align: right;">银行账号：</td>
                <td style="text-align: left;"><input id="bankAccount" type="text" class="easyui-textbox" name="bankAccount" style="width: 80px;" data-options="required:false,missingMessage:'银行账号不能为空',validType:'bank_account'">
                </td>
                <td style="text-align: right;">开户银行：</td>
                <td style="text-align: left;"><input id="depositBank" type="text" class="easyui-textbox" name="depositBank" style="width: 80px;"></td>
                <td style="text-align: right;">邮件地址：</td>
                <td style="text-align: left;"><input id="mailingAddress" type="text" name="mailingAddress" style="width: 80px;"></td>
            </tr>
            <tr>
                <td style="text-align: right;">税务登记号：</td>
                <td style="text-align: left;"><input id="taxRegistrationNumber" type="text" class="easyui-textbox" name="taxRegistrationNumber" style="width: 80px;">
                </td>
                <td style="text-align: right;">增值税率：</td>
                <td style="text-align: left;"><input id="valueAddedTaxRate" class="easyui-numberbox" data-options="min:0,precision:2,suffix:'%'" type="text" name="valueAddedTaxRate" style="width: 80px;"></td>
                <td style="text-align: right;">状态：</td>
                <td style="text-align: left;"><input id="state" type="text" class="easyui-combobox" name="state" style="width: 80px;"
                                   data-options="
                                      url:'${pageContext.request.contextPath}/system/dictionarie/findAllDictionarieByKeyword.action',
                                      queryParams: {
                                         'keyword': '状态'
                                        },
                                      valueField:'dictionarieName',
                                      textField:'dictionarieName',
                                      formatter: formatItem,
                                      limitToList: true
                                   "></td>
            </tr>
            <tr>
                <td style="text-align: right;">付款方式：</td>
                <td style="text-align: left;"><input id="paymentMethod" type="text" class="easyui-textbox" name="paymentMethod" style="width: 80px;"></td>
                <td style="text-align: right;">发票类型：</td>
                <td style="text-align: left;"><input id="invoiceType" type="text" class="easyui-combobox" name="invoiceType" style="width: 130px;"></td>
                <td style="text-align: right;">供应商等级：</td>
                <td style="text-align: left;"><input id="supplyLevel" type="text" class="easyui-combobox" name="supplyLevel" style="width: 60px;"
                                  data-options="
                                      url:'${pageContext.request.contextPath}/system/dictionarie/findAllDictionarieByKeyword.action',
                                      queryParams: {
                                         'keyword': '供应商等级'
                                        },
                                      valueField:'dictionarieName',
                                      textField:'dictionarieName',
                                      formatter: formatItem,
                                      limitToList: true,
                                  "></td>
            </tr>
            <tr>
                <td style="text-align: right;">国家：</td>
                <td style="text-align: left;"><select id="country" class=easyui-combobox" name="country">
                    <option value="中国">中国</option>
                    <option value="国外">国外</option>
                </select></td>
                <td style="text-align: right;">省份：</td>
                <td style="text-align: left;"><input id="province" class="easyui-combobox" name="province"></td>
                <td style="text-align: right;">市区：</td>
                <td style="text-align: left;"><input id="city" class="easyui-combobox" name="city"></td>

            </tr>
            <tr>
                <td style="text-align: right;">营业执照：</td>
                <td colspan="3" style="text-align: left;">
                        <input id="businessLicense" name="businessLicenseFile" class="easyui-filebox" style="width: 132px;" data-options="buttonText:'浏览',buttonAlign:'left',accept:'image/*,application/pdf',multiple:true,validType:['fileSize[700,\'KB\']']">
                        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="$('#businessLicense').filebox('clear');">清空</a>
                <td style="text-align: right;">注册商标：</td>
                <td colspan="3" style="text-align: left;">
                        <input id="registeredTrademark" name="registeredTrademarkFile" class="easyui-filebox" style="width: 132px;" data-options="buttonText:'浏览',buttonAlign:'left',accept:'image/*,application/pdf',multiple:true,validType:['fileSize[700,\'KB\']']">
                        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="$('#registeredTrademark').filebox('clear');">清空</a>
            </tr>
        </table>
    </form>
</div>

<!-- 查看图片的dialog -->
<div id="imgDialog" class="easyui-dialog" style="width: 700px;height: 500px;"
     data-options="closed: true,draggable:false,modal:true,buttons:'#bb2'">
    <table style="border-spacing:10px;border-bottom: 0.5px;text-align: right;">
        <tr id="tr1">
            <td style="text-align: right;">营业执照：</td>
            <td colspan="3" style="text-align: left;">
                <div id="fileDiv1"></div>
        </tr>
        <tr id="tr2">
            <td style="text-align: right;">注册商标：</td>
            <td colspan="3" style="text-align: left;">
                <div id="fileDiv2"></div>
        </tr>
    </table>
</div>

<!--操作物料的dialog-->
<div id="materielDialog" class="easyui-dialog" style="width: 1100px;height: 800px;"
     data-options="closed: true,draggable:false,modal:true,buttons:'#bb3'">
    <table id="materialDG"></table>
    <!-- 上面表格的toolbar按钮 -->
    <div id="materialGridToolBar" style="padding:5px;height:auto">
        <div style="display:inline-block;">
            <p:isPrivilege pid="ea" mid="eae">
                <a class="easyui-linkbutton" iconCls="icon-add" plain="true" onClick="addMaterial()"
                   style="float: left;">新增关联物料</a>
                <!--竖向分割线-->
                <div class="btn-separator"></div>
            </p:isPrivilege>
            <p:isPrivilege pid="ea" mid="eaf">
                <a class="easyui-linkbutton" iconCls="icon-remove" plain="true" onClick="removeMaterial();"
                   style="float: left;">删除关联物料</a>
                <div class="btn-separator"></div>
            </p:isPrivilege>

            <a class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="reloadMaterial();"
               style="float: left;">刷新关联物料</a>
            <div class="btn-separator"></div>

        </div>
        <div>
            <form id="queryForm1">
                <input id="supplierIdQuery" name="supplierId" style="width: 80px;" hidden>
                代码：<input id="materialCodeQuery" class="easyui-textbox" name="materialCode" style="width: 80px;">
                名称：<input id="materialNameQuery" class="easyui-textbox" name="materialName" style="width: 80px;">
                类型：<input id="materialTypeQuery" class="easyui-combobox" name="materialType" style="width: 80px;"
                          data-options="queryParams: {'keyword' : '类型'}">
                适用产品：<input id="applicableProductQuery" class="easyui-combobox" name="applicableProduct"
                            style="width: 80px;" data-options="multiple:true,queryParams: {'keyword' : '适用产品'}">
                分类：<input id="classificationQuery" class="easyui-combobox" name="classification" style="width: 80px;"
                          data-options="queryParams: {'keyword' : '分类'}">
                物料属性：<input id="materialPropertiesQuery" class="easyui-combobox" name="materialProperties"
                            style="width: 80px;" data-options="queryParams: {'keyword' : '物料属性'}">
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
                          style="width: 80px;" data-options="queryParams: {'keyword' : '仓位'}">
                创建时间：<input name="createTimeBefore" class="easyui-datebox" sharedCalendar="#sc" style="width: 100px">—<input name="createTimeAfter" class="easyui-datebox" sharedCalendar="#sc" style="width: 100px">
                <a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="queryByParam()">查询</a>
            </form>
            <div id="sc" class="easyui-calendar"></div>
        </div>
    </div>

</div>

<!--操作物料的右键菜单区-->
<div id="materialMenu" class="easyui-menu" style="width: 80px; display: none;">
    <p:isPrivilege pid="ea" mid="eae">
        <div data-options="iconCls:'icon-add'" onclick="addMaterial();">新增关联物料</div>
    </p:isPrivilege>
    <p:isPrivilege pid="ea" mid="eaf">
        <div data-options="iconCls:'icon-remove'" onclick="removeMaterial()">删除关联物料</div>
    </p:isPrivilege>
    <div data-options="iconCls:'icon-reload'" onclick="reloadMaterial();">刷新关联物料</div>
</div>

<!--选择物料的dialog-->
<div id="materialInfoDialog" class="easyui-dialog" style="width:900px;height: 600px;"
     data-options="closed: true,draggable:false,modal:true,buttons:'#bb4'">
    <table id="materialInfoDG"></table>
    <div id="materialInfoToolBar" style="padding:5px;height:auto">
        <form id="queryForm2">
            <input name="supplierId" style="width: 80px;" hidden>
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
            <a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="queryMaterial()">查询</a>
        </form>
    </div>

</div>

<!-- dialog1上面dialog的按钮 -->
<div id="bb1" style="text-align: center;">
    <a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="saveOrUpdate()">保存</a>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="closeDialog('dialog1')">关闭</a>
</div>

<!-- imgDialog上面dialog的按钮 -->
<div id="bb2" style="text-align: center;">
    <a class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="closeDialog('imgDialog')">关闭</a>
</div>

<!--materielDialog上面的dialog按钮-->
<div id="bb3" style="text-align: center;">
    <a class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="closeDialog('materielDialog')">关闭</a>
</div>

<!--materialInfoDialog上面的dialog按钮-->
<div id="bb4" style="text-align: center;">
    <a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="insertInfo()">确定</a>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="closeDialog('materialInfoDialog')">关闭</a>
</div>

</body>


</html>
