<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.chiucheung.cn" prefix="p" %>
<!DOCTYPE html>
<html>
<head>
    <title>菜单管理页面</title>
    <jsp:include page="/common.jsp"></jsp:include>
</head>

<script type="text/javascript">

    $(function() {
        $("#myTable").treegrid({
            url : "${pageContext.request.contextPath }/system/menu/getAllMenuInfo.action",
            title:"菜单管理",
            method : "post",
            rownumbers : false,//设置为true.则显示带有行号的列
            fitColumns : true,//设置为true,则会自动扩大或缩小列的尺寸以适应网络的宽度并且防止水平滚动
            idField : 'mid',//关键字段标识树节点
            treeField : 'name',//树节点字段
            animate : false,//是否显示动画效果
            striped : false,//隔行变色
            pagination : true,//底部分页控件
            pageList : [ 5, 10, 15, 20 ],//选择一页显示多少数据
            pageSize : 10,//默认每页显示的条数
            singleSelect:false,
            ctrlSelect:true,
            columns : [ [
                {field : 'mid',title : 'mID',width : 100,halign : 'center',align : "center",hidden : true},
                {field : 'pid',title : '父类ID',width : 100,halign : 'center',align : "center",hidden : true},
                {field : 'name',title : '名称',width : 300,halign : 'center',align : "left",sortable : true,editor : "text"},
                {field : 'isparent',title : '是否是父类',width : 100,halign : 'center',align : "center",
                    formatter : function(value, row) {
                        if (value) {
                            return "<img src='${pageContext.request.contextPath }/jquery-easyui-1.5.5.4/themes/icons/ok.png'>";
                        } else {
                            return "<img src='${pageContext.request.contextPath }/jquery-easyui-1.5.5.4/themes/icons/no.png'>";
                        }
                    }
                },
                {field : 'ismenu',title : '是否是菜单',width : 100,halign : 'center',align : "center",
                    formatter : function(value, row) {
                        if (value) {
                            return "<img src='${pageContext.request.contextPath }/jquery-easyui-1.5.5.4/themes/icons/ok.png'>";
                        } else {
                            return "<img src='${pageContext.request.contextPath }/jquery-easyui-1.5.5.4/themes/icons/no.png'>";
                        }
                    }
                },
                {field : 'icon',title : '图标',width : 300,halign : 'center',align : "center",
                    formatter:function(value,row){
                        if(value != "" && value != null){
                            return "<button style='font-size:16px;font-family:Arial' onclick=\"getImg('"+value+"')\">图标详情</button>";

                        }else{
                            return "<font color='#FF0000'>无图标</font>";
                        }
                    }
                },
            ] ],

            onContextMenu : function(e, row) {
                //屏蔽浏览器的菜单
                e.preventDefault();
                //获取当前选择对象
                var id = $('#myTable').treegrid('getSelected');
                //当选择对象不为空时再获取当前选择对象的id值
                if (id != null){
                    //获取当前点击对象的选中项
                    $(this).treegrid('select',id.mid);
                }
                //点击出现菜单页面后所在的位置
                if ($("#mm > div").size() > 1) {
                    $('#mm').menu('show', {
                        left : e.pageX,
                        top : e.pageY
                    });
                }
            },
        });

        //将后台获取到的菜单信息加载到select下拉框中
        $('#pid').combotreegrid({
            width:'140px',
            panelWidth:500,
            url:'${pageContext.request.contextPath }/system/menu/getMenuInfo.action',
            idField : 'mid',//关键字段标识树节点
            treeField:'name',
            fitColumns : true,
            onShowPanel:setValue,
            columns : [ [
                {field : 'mid',title : 'mID',width : 100,halign : 'center',align : "center",hidden : true},
                {field : 'pid',title : '父类ID',width : 100,halign : 'center',align : "center",hidden : true},
                {field : 'name',title : '名称',width : 300,halign : 'center',align : "left",sortable : true,editor : "text"},
            ] ]
        });

        //给搜索表单框添加键盘的回车事件
        $("#query").on("keydown", function(event){
            if (event.keyCode == 13){
                searchInfo();
            }
        })

    })

    //开启新增页面开始操作新增方法
    function append() {
        $("#imgDiv")[0].setAttribute("hidden",true);
        $('#userDialog').dialog({ //打开新增框
            title : '新增菜单信息', //名称
            closed : false
        });
        //重置
        $('#userForm').form('clear');
        $("#userForm").get(0).reset();
        $("#flag").val("add");

        //渲染"是否是父类"项的数据显示内容
        $('#isparent').combobox({
            valueField : 'id',
            textField : 'text',
            data : [ {
                id : true,
                text : '是'
            }, {
                id : false,
                text : '否'
            } ]
        });
        //渲染"是否是菜单"项的数据显示内容
        $('#ismenu').combobox({
            valueField:'id',
            textField : 'text',
            data : [ {
                id : true,
                text : '是'
            }, {
                id : false,
                text : '否'
            } ]
        })
    };

    //开启修改页面开始操作修改方法
    function openEdit() {
        $("#imgDiv")[0].setAttribute("hidden",true);
        var arr = $('#myTable').treegrid('getSelections');
        //将文件框的数据清除
        $("#userForm #fileupdate").val("");
        if (arr.length != 1) { //如果选中的不是一行
            $.messager.show({
                title : '提示',
                msg : '只能选择一行进行编辑'
            });
        } else {
            mid = arr[0].mid;
            pid = arr[0].pid;
            $('#userDialog').dialog({ //打开修改框
                title : '修改菜单信息', //名称
                closed : false
            });

            $.ajax({
                url : "${pageContext.request.contextPath }/system/menu/selectById.action",
                dataType : "json",
                data : {
                    mid : mid,
                    pid : pid
                },
                success : function(data) {
                    $('#userForm').form('load', data.data);
                    $("#flag").val("update");
                }
            });

        }

        //渲染"是否是父类"项的数据显示内容
        $('#isparent').combobox({
            valueField : 'id',
            textField : 'text',
            data : [ {
                id : true,
                text : '是'
            }, {
                id : false,
                text : '否'
            } ]
        });
        //渲染"是否是菜单"项的数据显示内容
        $('#ismenu').combobox({
            valueField:'id',
            textField : 'text',
            data : [ {
                id : true,
                text : '是'
            }, {
                id : false,
                text : '否'
            } ]
        })
    };

    //提交新增(修改)的数据的方法
    function comitInfo(){
        var isValid = $("#userForm").form('validate');//做表单字段验证
        var form = new FormData($("#userForm")[0]);
        if(isValid){
            var url = "${pageContext.request.contextPath }/system/menu/";
            if ($("#flag").val() == "add") {
                url += "insert.action";
            } else if ($("#flag").val() == "update") {
                url += "update.action";
            }
            $.ajax({
                type: "post",
                url : url,
                dataType:"json",
                data :form,
                contentType:false,
                processData:false,
                success : function(data) {
                    if (data.success){
                        $.messager.show({
                            title : '提示',
                            msg : '操作成功'
                        });
                        $("#userDialog").dialog('close');//关闭新增框
                        update();
                    }else{
                        $.messager.show({
                            title : '提示',
                            msg : '操作失败:' + data.errorMsg
                        });
                    }
                }
            });
        }
    }

    //删除数据操作
    function remove() {
        var arr = $('#myTable').treegrid('getSelections');
        if (arr.length > 0) {
            $.messager.confirm("确认", "确实要删除吗？", function(r) {
                if (r) {
                    var mids = [];
                    var pids = [];
                    var icons = [];
                    for (var i = 0; i < arr.length; i++) {
                        mids[i] = arr[i].mid;
                        pids[i] = arr[i].pid;
                        icons[i] = arr[i].icon;
                    }
                    $.ajax({
                        url : "${pageContext.request.contextPath }/system/menu/delete.action",
                        dataType : "json",
                        type : "post",
                        traditional : true,
                        data : {
                            mid : mids,
                            pid : pids,
                            icon : icons,
                        },
                        success : function(data) {
                            if (data.success) {
                                $.messager.show({
                                    title : '提示',
                                    msg : '操作成功'
                                });
                                update();
                            } else {
                                $.messager.show({
                                    title : '提示',
                                    msg : '操作失败,'+data.message
                                });
                            }
                        }
                    });
                }
            });
        }
    };

    //刷新页面
    function update(){
        $("#myTable").treegrid('load',{});
        $('#pid').combotreegrid('grid').treegrid('load',{});
        $("#imgDiv")[0].setAttribute("hidden",true);
    }

    //搜索框搜素数据方法
    function searchInfo() {
        /**$("#myTable").treegrid('options').pageNumber动态获取当前分页信息
         * 该方法可以实现通过不同地址获取值后不影响treegrid本身的访问地址
         *$.post(url,{},function(data){$("#myTable").treegrid('loadData',data)},'json');
         * */
        $.post("${pageContext.request.contextPath }/system/menu/select.action",
            {
                name:$("#query").serializeObject().name,
                page:$("#myTable").treegrid('options').pageNumber,
                rows:$("#myTable").treegrid('options').pageSize

            },
            function (data) {
                var d = data;
                $("#myTable").treegrid('loadData',d);
            },'json');

    };

    function setValue(){
        var arr = $('#myTable').treegrid('getSelections');
        if(arr.length==1){
            $('#pid').combotreegrid('setValue',arr[0].pid);
        }
    }

    function getImg(url){
        console.log(url);
        $("#imgDiv")[0].removeAttribute("hidden");
        $("#previewImg").attr("src", "${pageContext.request.contextPath }/"+url);
    }

</script>

<body>
<div style="margin:20px 0;"></div>

<!--菜单栏-->
<div data-options="region:'north',title:''" style="height:25px; padding:5px">
    <p:isPrivilege mid="bhb" pid="bh">
        <a class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onclick="openEdit()">修改</a>
    </p:isPrivilege>
    <p:isPrivilege mid="bha" pid="bh">
        <a class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="append()">新增</a>
    </p:isPrivilege>
    <p:isPrivilege mid="bhc" pid="bh">
        <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="remove()">删除</a>
    </p:isPrivilege>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-reload'" onclick="update()">刷新</a>
</div>
<!--输入搜索框-->
<div style="float:left;">
    <form id="query">
        <input id="info" type="search" class="easyui-searchbox" name="name" data-options="prompt:'Please Input Value',searcher:searchInfo" style="width:200px"></input>
    </form>
</div>

<!-- menu区 -->
<div id="mm" class="easyui-menu" style="width:120px">
    <p:isPrivilege mid="bha" pid="bh">
        <div data-options="iconCls:'icon-add'" onclick="append()">新增</div>
    </p:isPrivilege>
    <p:isPrivilege mid="bhb" pid="bh">
        <div data-options="iconCls:'icon-edit'" onclick="openEdit()">修改</div>
    </p:isPrivilege>
    <p:isPrivilege mid="bhc" pid="bh">
        <div data-options="iconCls:'icon-cancel'" onclick="remove()">删除</div>
    </p:isPrivilege>
    <div data-options="iconCls:'icon-reload'" onclick="update()">刷新</div>
</div>

<!--表格显示-->
<table id="myTable" title="Folder Browser" class="easyui-treegrid"
       style="width:100%">
</table>

<!--增改菜单的dialog-->
<div id="userDialog" class="easyui-dialog" closed="true" style="width:620px;top:150px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true">
    <form enctype="multipart/form-data" id="userForm" method="post">
        <input type="hidden" id="flag">
        <table class="tableStyle"
               style="width: 100%;height:96%; font-size: 14px" height="100px">
            <tr class="tableStyle" height="40px">
                <td width="15%" class="tableStyle">父类ID：</td>
                <td>
                    <input id="pid" name="pid" style="width: 100px">
                </td>

                <td width="15%" class="tableStyle">mid：</td>
                <td><input id="mid" name="mid" class="easyui-textbox" style="width: 150px" required="true" missingMessage="该项为必填!"></td>
            </tr>

            <tr class="tableStyle" height="40px">
                <td width="15%" class="tableStyle">名称：</td>
                <td><input id="name" name="name" class="easyui-textbox" style="width: 150px" required="true" missingMessage="该项为必填!"></td>

                <td width="15%" class="tableStyle">点击路径：</td>
                <td><input id="clickurl" name="clickurl" class="easyui-textbox" style="width: 150px">
                </td>
            </tr>

            <tr class="tableStyle" height="40px">
                <td width="15%" class="tableStyle" height="40px">是否是父类：</td>
                <td><input id="isparent" class="easyui-combobox" name="isparent" style="width:80px;"></td>

                <td width="15%" class="tableStyle">是否是菜单：</td>
                <td><input id="ismenu" class="easyui-combobox" name="ismenu" style="width:80px;"></td>
            </tr>

            <tr class="tableStyle" height="40px">
                <td width="15%" class="tableStyle">请选择图标：</td>
                <td><input multiple="true" type="file" accept="image/*" id="iconImg" name="iconImg" style="width:300px;"></td>
                <td><input id="icon" name="icon" style="width:200px;" hidden : true></td>
            </tr>

        </table>
        <br>
        <center>
            <a id="confirm" class="easyui-linkbutton" align='center'
               style="width: 80px" onclick="comitInfo()">确定</a>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a id="cancel" class="easyui-linkbutton" align='center'
               style="width: 80px" onclick="closeDialog('userDialog');">取消</a>
        </center>

    </form>
</div>
<!--图片显示div-->
<div id="imgDiv" hidden : true>
    <img style="height: 100px;width: 150px" id="previewImg">
</div>
</body>

</html>
