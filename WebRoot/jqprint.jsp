<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jquery打印插件</title>
    <script src="${pageContext.request.contextPath}/jquery-easyui-1.4.5/jquery.min.js"></script>
    <script src="./js/jQuery.print.js"></script>
</head>
<body>
<div id="print-area">
    <form id="ff">
        <div>
            <label>Name:</label>
            <input class="easyui-validatebox" type="text" name="name" data-options="required:true" />
        </div>
        <div>
            <label>Email:</label>
            <input class="easyui-validatebox" type="text" name="email" data-options="validType:'email'" />
        </div>
    </form>
</div>
<input type="button" onclick="print()" value="打印"/>
</body>

<script type="text/javascript">
    function print() {
        $("#print-area").print();
    }
</script>

</body>
</html>
