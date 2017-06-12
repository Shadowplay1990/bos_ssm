<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/include/taglibs.jsp"%>
<html>
<head>
    <title>Title</title>
    <%@include file="/include/header.jsp"%>
    <script>
        function doAdd(){
            $('#addSubareaWindow').window("open");
        }

        function doEdit(){
            var rows=$("#grid").datagrid("getSelections");
            if(rows.length==0){
                $.messager.alert("消息提示","请选择需要操作的分区信息！","warning")
            }else{
                var arry=new Array();
                for(var i=0;i<rows.length;i++){
                    var id=rows[i].id;
                    arry.push(id);
                }
                var ids=arry.join(",");
                $("input[name='ids']").attr("value",ids);

                $("#editSubareaWindow").window("open");
            }
        }

        function doDelete() {
            var rows = $("#grid").datagrid("getSelections");
            if (rows.length == 0) {
                $.messager.alert("消息提示", "请选择要删除的分区！", "warning");
            } else {
                $.messager.confirm("消息提示", "确认删除选中的分区？", function (b) {
                    var arry = new Array();
                    for (var i = 0; i < rows.length; i++) {
                        var id = rows[i].id;
                        arry.push(id);
                    }
                    var ids = arry.join(",");
                    window.location.href="${rootContext}/subarea/del/"+ids;
                });
            }
        }

        function doSearch(){
            $("#searchWindow").window("open");
        }

        //导出按钮对应的处理函数
        function doExport(){
            //发送请求，请求Action，进行文件下载
            window.location.href = "${rootContext}/subarea/exportXls";
            //$.post("subareaAction_exportXls.action");
        }

        //工具栏
        var toolbar = [ {
            id : 'button-search',
            text : '查询',
            iconCls : 'icon-search',
            handler : doSearch
        }, {
            id : 'button-add',
            text : '增加',
            iconCls : 'icon-add',
            handler : doAdd
        }, {
            id : 'button-edit',
            text : '批量修改',
            iconCls : 'icon-edit',
            handler : doEdit
        },{
            id : 'button-delete',
            text : '批量删除',
            iconCls : 'icon-cancel',
            handler : doDelete
        },{
            id : 'button-import',
            text : '导入',
            iconCls : 'icon-redo',
        },{
            id : 'button-export',
            text : '导出',
            iconCls : 'icon-undo',
            handler : doExport
        }];
        // 定义列
        var columns = [ [ {
            field : 'id',
            checkbox : true,
        }, {
            field : 'region.id',
            title : '区域编号',
            width : 120,
            align : 'center',
            formatter : function(data,row ,index){
                return row.region.id;
            }
        },{
            field : 'region.province',
            title : '省',
            width : 120,
            align : 'center',
            formatter : function(data,row ,index){
                return row.region.province;
            }
        }, {
            field : 'region.city',
            title : '市',
            width : 120,
            align : 'center',
            formatter : function(data,row ,index){
                return row.region.city;
            }
        }, {
            field : 'region.district',
            title : '区',
            width : 120,
            align : 'center',
            formatter : function(data,row ,index){
                return row.region.district;
            }
        }, {
            field : 'addresskey',
            title : '关键字',
            width : 120,
            align : 'center'
        }, {
            field : 'startnum',
            title : '起始号',
            width : 100,
            align : 'center'
        }, {
            field : 'endnum',
            title : '终止号',
            width : 100,
            align : 'center'
        } , {
            field : 'single',
            title : '单双号',
            width : 100,
            align : 'center'
        } , {
            field : 'position',
            title : '位置',
            width : 200,
            align : 'center'
        } ] ];

        $(function(){
            // 先将body隐藏，再显示，不会出现页面刷新效果
            $("body").css({visibility:"visible"});

            // 收派标准数据表格
            $('#grid').datagrid( {
                iconCls : 'icon-forward',
                fit : true,
                border : true,
                rownumbers : true,
                striped : true,
                pageList: [10],
                pagination : true,
                toolbar : toolbar,
                url : "${rootContext}/subarea/pageQuery",
                idField : 'id',
                columns : columns,
                onDblClickRow : doDblClickRow
            });

            // 添加分区
            $('#addSubareaWindow').window({
                title: '添加分区',
                width: 600,
                modal: true,
                shadow: true,
                closed: true,
                height: 400,
                resizable:false
            });

            // 添加分区
            $('#editSubareaWindow').window({
                title: '批量修改分区',
                width: 600,
                modal: true,
                shadow: true,
                closed: true,
                height: 400,
                resizable:false
            });

            // 查询分区
            $('#searchWindow').window({
                title: '查询分区',
                width: 400,
                modal: true,
                shadow: true,
                closed: true,
                height: 400,
                resizable:false
            });

            //文件上传
            $("#button-import").upload({
                action:'${rootContext}/subarea/importXls',
                name:'subareaFile'
            });

            //定义一个工具方法，用于将指定的form表单中所有的输入项转为json数据{key:value,key:value}
            $.fn.serializeJson=function(){
                var serializeObj={};
                var array=this.serializeArray();
                $(array).each(function(){
                    if(serializeObj[this.name]){
                        if($.isArray(serializeObj[this.name])){
                            serializeObj[this.name].push(this.value);
                        }else{
                            serializeObj[this.name]=[serializeObj[this.name],this.value];
                        }
                    }else{
                        serializeObj[this.name]=this.value;
                    }
                });
                return serializeObj;
            };

            $("#btn").click(function(){
                //将指定的form表单中所有的输入项转为json数据{key:value,key:value}
                var p = $("#searchForm").serializeJson();
                console.info(p);
                //调用数据表格的load方法，重新发送一次ajax请求，并且提交参数
                $("#grid").datagrid("load",p);
                //关闭查询窗口
                $("#searchWindow").window("close");
            });
        });

        function doDblClickRow(index,data){
            $("#editSubareaWindow").window("open");
            var id=data.id.toString();
            $("input[name='ids']").attr("value",id);
        }
    </script>
</head>
<body class="easyui-layout" style="visibility:hidden;">
<div region="center" border="false">
    <table id="grid"></table>
</div>
<!-- 添加分区 -->
<div class="easyui-window" title="分区添加" id="addSubareaWindow" collapsible="false" minimizable="false" maximizable="false" style="top:20px;left:200px">
    <div style="height:31px;overflow:hidden;" split="false" border="false" >
        <div class="datagrid-toolbar">
            <a id="save" icon="icon-save" href="#" class="easyui-linkbutton" plain="true" >保存</a>
            <script type="text/javascript">
                $(function(){
                    $("#save").click(function(){
                        //表单校验
                        var r = $("#addSubareaForm").form('validate');
                        if(r){
                            $("#addSubareaForm").submit();
                        }
                    });
                });
            </script>
        </div>
    </div>

    <div style="overflow:auto;padding:5px;" border="false">
        <form id="addSubareaForm" method="post" action="${rootContext}/subarea/add">
            <table class="table-edit" width="80%" align="center">
                <tr class="title">
                    <td colspan="2">分区信息</td>
                </tr>
                <tr>
                    <td>选择区域</td>
                    <td>
                        <input class="easyui-combobox" name="region.id"
                               data-options="valueField:'id',textField:'shortcode',mode:'remote',
    							url:'${rootContext}/region/ajaxList'" />
                    </td>
                </tr>
                <tr>
                    <td>关键字</td>
                    <td><input type="text" name="addresskey" class="easyui-validatebox" required="true"/></td>
                </tr>
                <tr>
                    <td>起始号</td>
                    <td><input type="text" name="startnum" class="easyui-validatebox" required="true"/></td>
                </tr>
                <tr>
                    <td>终止号</td>
                    <td><input type="text" name="endnum" class="easyui-validatebox" required="true"/></td>
                </tr>
                <tr>
                    <td>单双号</td>
                    <td>
                        <select class="easyui-combobox" name="single" style="width:150px;">
                            <option value="0">单双号</option>
                            <option value="1">单号</option>
                            <option value="2">双号</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>位置信息</td>
                    <td><input type="text" name="position" class="easyui-validatebox" required="true" style="width:250px;"/></td>
                </tr>
            </table>
        </form>
    </div>
</div>
<%--修改分区--%>
<div class="easyui-window" title="分区修改" id="editSubareaWindow" collapsible="false" minimizable="false" maximizable="false" style="top:20px;left:200px">
    <div style="height:31px;overflow:hidden;" split="false" border="false" >
        <div class="datagrid-toolbar">
            <a id="edit_save" icon="icon-save" href="#" class="easyui-linkbutton" plain="true" >保存</a>
            <script type="text/javascript">
                $(function(){
                    $("#edit_save").click(function(){
                        //表单校验
                        var r = $("#editSubareaForm").form('validate');
                        if(r){
                            $("#editSubareaForm").submit();
                        }
                    });
                });
            </script>
        </div>
    </div>
    <div style="overflow:auto;padding:5px;" border="false">
        <form id="editSubareaForm" method="post" action="${rootContext}/subarea/edit">
            <table class="table-edit" width="80%" align="center">
                <tr class="title">
                    <td colspan="2">分区信息</td>
                    <input type="hidden" name="ids"/>
                </tr>
                <tr>
                    <td>选择区域</td>
                    <td>
                        <input class="easyui-combobox" name="region.id"
                               data-options="valueField:'id',textField:'shortcode',mode:'remote',
    							url:'${rootContext}/region/ajaxList'" />
                    </td>
                </tr>
                <tr>
                    <td>关键字</td>
                    <td><input type="text" name="addresskey" class="easyui-validatebox" /></td>
                </tr>
                <tr>
                    <td>起始号</td>
                    <td><input type="text" name="startnum" class="easyui-validatebox" /></td>
                </tr>
                <tr>
                    <td>终止号</td>
                    <td><input type="text" name="endnum" class="easyui-validatebox" /></td>
                </tr>
                <tr>
                    <td>单双号</td>
                    <td>
                        <select class="easyui-combobox" name="single" style="width:150px;">
                            <option value="0">单双号</option>
                            <option value="1">单号</option>
                            <option value="2">双号</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>位置信息</td>
                    <td><input type="text" name="position" class="easyui-validatebox"  style="width:250px;"/></td>
                </tr>
            </table>
        </form>
    </div>
</div>
<!-- 查询分区 -->
<div class="easyui-window" title="查询分区窗口" id="searchWindow" collapsible="false" minimizable="false" maximizable="false" style="top:20px;left:200px">
    <div style="overflow:auto;padding:5px;" border="false">
        <form id="searchForm">
            <table class="table-edit" width="80%" align="center">
                <tr class="title">
                    <td colspan="2">查询条件</td>
                </tr>
                <tr>
                    <td>省</td>
                    <td><input type="text" name="region.province"/></td>
                </tr>
                <tr>
                    <td>市</td>
                    <td><input type="text" name="region.city"/></td>
                </tr>
                <tr>
                    <td>区（县）</td>
                    <td><input type="text" name="region.district"/></td>
                </tr>
                <tr>
                    <td>关键字</td>
                    <td><input type="text" name="addresskey"/></td>
                </tr>
                <tr>
                    <td colspan="2"><a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a> </td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>
