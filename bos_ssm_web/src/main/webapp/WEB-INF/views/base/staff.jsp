<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/include/taglibs.jsp"%>
<html>
<head>
    <title>Title</title>
    <%@include file="/include/header.jsp"%>
    <script>
        function doAdd(){
            //alert("增加...");
            $('#addStaffWindow').window("open");
        }

        function doView(){
            $("#searchStaffWindow").window("open");
        }

        function doDelete(){
            var rows=$("#grid").datagrid("getSelections");
            if(rows.length==0){
                $.messager.alert("提示消息","请选择要删除的快递员","warning");
            }else{
                $.messager.confirm("确认删除","确认删除选中的快递员？",function (s) {
                    if(s){
                        var array=new Array();

                        for(var i=0;i<rows.length;i++){
                            var staff=rows[i];
                            var id=staff.id;
                            array.push(id);
                        }
                        var ids=array.join(",");
                        location.href="${rootContext}/staff/batchDel/"+ids;
                    }
                });
            }
        }

       /* function doRestore(){
            alert("将取派员还原...");
        }*/

        //工具栏
        var toolbar = [ /*{
            id : 'button-view',
            text : '查询',
            iconCls : 'icon-search',
            handler : doView
        },*/ {
            id : 'button-add',
            text : '增加',
            iconCls : 'icon-add',
            handler : doAdd
        }, {
            id : 'button-delete',
            text : '删除',
            iconCls : 'icon-cancel',
            handler : doDelete
        }];
        //定义列
        var columns=[[{
            field:'id',
            checkbox:true
        },{
            field:'name',
            title:'姓名',
            width:120,
            align:'center'
        },{
            field:'telephone',
            title:'电话',
            width:120,
            align:'center'
        },{
            field:'haspda',
            title:'是否有pda',
            width:120,
            align:'center',
            formatter:function (data,row,index) {
                if(data=='1'){
                    return '有';
                }else{
                    return '无';
                }
            }
        },{
            field:'deltag',
            title:'作废标记',
            width:120,
            align:'center',
            formatter:function (data, row, index) {
                if (data=='0'){
                    return '正常';
                }else{
                    return '作废';
                }
            }
        },{
            field:'station',
            title:'所属单位',
            width:120,
            align:'center'
        }]];

        //获取列表数据
        $(function () {
            $('body').css({visibility:"visible"});
            $("#grid").datagrid({
                fit:true,
                border:true,
                rownumbers:true,
                striped:false,
                pageList:[10],
                pagination:true,
                toolbar:toolbar,
                url:"${rootContext}/staff/byPage",
                idField:'id',
                columns:columns,
                onDblClickRow:doDbClick
            });

            //添加快递员窗口
            $("#addStaffWindow").window({
                title:'添加快递员',
                width:400,
                modal:true,
                closed:true,
                height:400,
                resizable:false
            });

            //添加快递员窗口
            $("#editStaffWindow").window({
                title:'修改快递员',
                width:400,
                modal:true,
                closed:true,
                height:400,
                resizable:false
            });

            //查询快递员
            $("#searchStaffWindow").window({
                title:'修改快递员',
                width:400,
                modal:true,
                closed:true,
                height:400,
                resizable:false
            });
        });

        //表格双击事件
        function doDbClick(index, data) {
            $("#editStaffWindow").window("open");
            $("#editStaffForm").form("load",data);
        };
    </script>
</head>
<body class="easyui-layout" style="visibility: hidden">
     <div region="center" border="false">
         <table id="grid"></table>
     </div>
     <%--添加快递员的窗口--%>
     <div class="easyui-window" title="添加快递员" id="addStaffWindow" collapsible="false" minimizable="false" maximizable="false" style="top:20px;left:200px">
         <div region="north" style="height:31px;overflow:hidden;" splite="false" border="false">
             <div class="datagrid-toolbar">
                 <a icon="icon-save" href="#" id="saveStaff" class="easyui-linkbutton" plain="true">保存</a>
             </div>
         </div>
         <div region="center" style="overflow:auto;padding:5px;" border="false">
             <form id="addStaffForm" action="${rootContext}/staff/addStaff" method="post">
                 <table class="table-edit" width="80%" align="center">
                     <tr class="title">
                         <td colspan="2">快递员信息</td>
                     </tr>
                     <tr>
                         <td>姓名</td>
                         <td><input type="text" name="name" required="true" class="easyui-validatebox"></td>
                     </tr>
                     <tr>
                         <td>手机</td>
                         <td><input type="text" required="true" name="telephone" class="easyui-validatebox"></td>
                     </tr>
                     <tr>
                         <td>单位</td>
                         <td><input type="text" name="station" class="easyui-validatebox" required="true"></td>
                     </tr>
                     <tr>
                         <td>
                             <input type="checkbox" name="haspda" value="1">是否有pda
                         </td>
                     </tr>
                 </table>
             </form>
             <%--保存按钮绑定事件--%>
             <script>
                 $(function () {
                     $("#saveStaff").click(function () {
                        var b=$("#addStaffForm").form("validate");
                        if (b){
                            $("#addStaffForm").submit();
                        }
                     });
                 });
             </script>
         </div>
     </div>

     <%--修改快递员窗口--%>
     <div class="easyui-window" title="修改快递员" id="editStaffWindow" collapsible="false" minimizable="false" maximizable="false" style="top:20px;left:200px">
         <div region="north" style="height:31px;overflow:hidden;" splite="false" border="false">
             <div class="datagrid-toolbar">
                 <a icon="icon-save" href="#" id="editStaff" class="easyui-linkbutton" plain="true">保存</a>
             </div>
         </div>
         <div region="center" style="overflow:auto;padding:5px;" border="false">
             <form id="editStaffForm" action="${rootContext}/staff/editStaff" method="post">
                 <table class="table-edit" width="80%" align="center">
                     <tr class="title">
                         <td colspan="2">快递员信息</td>
                     </tr>
                     <tr>
                         <td>编号</td>
                         <td><input type="text" name="id" required="true" readonly="true" class="easyui-validatebox"></td>
                     </tr>
                     <tr>
                         <td>姓名</td>
                         <td><input type="text" name="name" required="true" class="easyui-validatebox"></td>
                     </tr>
                     <tr>
                         <td>手机</td>
                         <td><input type="text" required="true" name="telephone" class="easyui-validatebox"></td>
                     </tr>
                     <tr>
                         <td>单位</td>
                         <td><input type="text" name="station" class="easyui-validatebox" required="true"></td>
                     </tr>
                     <tr>
                         <td>
                             <input type="checkbox" name="haspda" value="1">是否有pda
                         </td>
                     </tr>
                 </table>
             </form>
             <%--保存按钮绑定事件--%>
             <script>
                 $(function () {
                     $("#editStaff").click(function () {
                         var b=$("#editStaffForm").form("validate");
                         if (b){
                             $("#editStaffForm").submit();
                         }
                     });
                 });
             </script>
         </div>
     </div>
     <%--查询快递员窗口--%>
     <div class="easyui-window" title="查询快递员" id="searchStaffWindow" collapsible="false" minimizable="false" maximizable="false" style="top:20px;left:200px">
         <div region="north" style="height:31px;overflow:hidden;" splite="false" border="false">
             <div class="datagrid-toolbar">
                 <a icon="icon-search" href="#" id="searchStaff" class="easyui-linkbutton" plain="true">保存</a>
             </div>
         </div>
         <div region="center" style="overflow:auto;padding:5px;" border="false">
             <form id="searchStaffForm" action="${rootContext}/staff/searchStaff" method="post">
                 <table class="table-edit" width="80%" align="center">
                     <tr class="title">
                         <td colspan="2">查询信息</td>
                     </tr>
                     <tr>
                         <td>姓名</td>
                         <td><input type="text" name="name"  class="easyui-validatebox"></td>
                     </tr>
                     <tr>
                         <td>手机</td>
                         <td><input type="text" name="telephone" class="easyui-validatebox"></td>
                     </tr>
                     <tr>
                         <td>单位</td>
                         <td><input type="text" name="station" class="easyui-validatebox"></td>
                     </tr>
                 </table>
             </form>
             <script>
                 $(function () {
                    $("#searchStaff").click(function () {
                        var b=$("#searchStaffForm").form("validate");
                        if(b){
                            $("#searchStaffForm").submit();
                        }
                    });
                 });
             </script>
         </div>
     </div>
</body>
</html>























