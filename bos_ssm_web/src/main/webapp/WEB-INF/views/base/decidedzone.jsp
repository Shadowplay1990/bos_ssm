<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/include/taglibs.jsp" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/include/header.jsp" %>
    <script>
        function doAdd(){
            $('#AddDzWindow').window("open");
        }

        function doEdit(){
            alert("修改...");
        }

        function doDelete(){
            alert("删除...");
        }

        function doSearch(){
            $('#searchWindow').window("open");
        }

        function doAssociations(){
            alert("doAssociations");
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
            text : '修改',
            iconCls : 'icon-edit',
            handler : doEdit
        },{
            id : 'button-delete',
            text : '删除',
            iconCls : 'icon-cancel',
            handler : doDelete
        },{
            id : 'button-association',
            text : '关联客户',
            iconCls : 'icon-sum',
            handler : doAssociations
        }];
        // 定义列
        var columns = [ [ {
            field : 'id',
            title : '定区编号',
            width : 120,
            align : 'center'
        },{
            field : 'name',
            title : '定区名称',
            width : 120,
            align : 'center'
        }, {
            field : 'staff.name',
            title : '负责人',
            width : 120,
            align : 'center',
            formatter : function(data,row ,index){
                return row.staff.name;
            }
        }, {
            field : 'staff.telephone',
            title : '联系电话',
            width : 120,
            align : 'center',
            formatter : function(data,row ,index){
                return row.staff.telephone;
            }
        }, {
            field : 'staff.station',
            title : '所属公司',
            width : 120,
            align : 'center',
            formatter : function(data,row ,index){
                return row.staff.station;
            }
        } ] ];

        //grid数据
        $(function () {
            $("body").css({visibility:"visible"});

            $('#grid').datagrid( {
                iconCls : 'icon-forward',
                fit : true,
                border : true,
                rownumbers : true,
                striped : true,
                pageList: [30,50,100],
                pagination : true,
                toolbar : toolbar,
                url : "${rootContext}/dz/pageQuery",
                idField : 'id',
                columns : columns,
                //为数据表格绑定双击事件
                onDblClickRow : doDblClickRow
            });

            // 添加、修改定区
            $("#AddDzWindow").window({
                title: '添加修改定区',
                width: 600,
                modal: true,
                shadow: true,
                closed: true,
                height: 400,
                resizable:false
            });

            // 查询定区
            $('#searchWindow').window({
                title: '查询定区',
                width: 400,
                modal: true,
                shadow: true,
                closed: true,
                height: 400,
                resizable:false
            });
            $("#btn").click(function(){
                alert("执行查询...");
            });
        });

        function doDblClickRow(index,data){
            //将页面中table变为datagrid样式
            $('#association_subarea').datagrid( {
                fit : true,
                border : true,
                rownumbers : true,
                striped : true,
                url : "subareaAction_findListByDecidedzoneId.action?decidedzoneId="+data.id,
                columns : [ [{
                    field : 'id',
                    title : '分拣编号',
                    width : 120,
                    align : 'center'
                },{
                    field : 'province',
                    title : '省',
                    width : 120,
                    align : 'center',
                    formatter : function(data,row ,index){
                        return row.region.province;
                    }
                }, {
                    field : 'city',
                    title : '市',
                    width : 120,
                    align : 'center',
                    formatter : function(data,row ,index){
                        return row.region.city;
                    }
                }, {
                    field : 'district',
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
                } ] ]
            });

            $('#association_customer').empty();
            //创建展示客户数据的数据表格
            $('#association_customer').datagrid( {
                fit : true,
                border : true,
                rownumbers : true,
                striped : true,
                url : "decidedzoneAction_findListHasAssociation.action?id="+data.id,
                columns : [[{
                    field : 'id',
                    title : '客户编号',
                    width : 120,
                    align : 'center'
                },{
                    field : 'name',
                    title : '客户名称',
                    width : 120,
                    align : 'center'
                }, {
                    field : 'station',
                    title : '所属单位',
                    width : 120,
                    align : 'center'
                }]]
            });

        }
    </script>
</head>
<body class="easyui-layout" style="visibility: hidden">
     <div region="center" border="false">
          <table id="grid"></table>
     </div>
     <div region="south" style="height: 150px;" border="false">
         <div id="tabs" class="easyui-tabs" fit="true">
             <div title="关联分区" id="subArea" style="height:100%;width:100%">
                 <table id="association_subarea"></table>
             </div>
             <div title="关联客户" id="customers" style="height:100%;width:100%">
                 <table id="association_customers"></table>
             </div>
         </div>
     </div>

     <%--添加定区--%>
     <div class="easyui-window" id="AddDzWindow" title="添加定区" collapsible="false"
          minimizable="false" maximizable="false" style="top:20px;left:200px">
         <div style="height: 31px; overflow: hidden;" split="false" border="false">
             <div class="datagrid-toolbar">
                 <a href="" id="saveDz" icon="icon-save" class="easyui-linkbutton" plain="true">保存</a>
             </div>
             <script>
                 $(function () {
                     $("#saveDz").click(function () {
                         var b=$("#addDzForm").form("validate");
                         if(b){
                             $("#addDzForm").submit();
                         }
                     });
                 });
             </script>
         </div>

         <div style="overflow:auto;padding:5px;" border="false">
             <form id="addDzForm" method="post"
                   action="${rootContext}/dz/addDz">
                 <table class="table-edit" width="80%" align="center">
                     <tr class="title">
                         <td colspan="2">定区信息</td>
                     </tr>
                     <tr>
                         <td>定区编码</td>
                         <td><input type="text" name="id" class="easyui-validatebox" required="true"/></td>
                     </tr>
                     <tr>
                         <td>定区名称</td>
                         <td><input type="text" name="name" class="easyui-validatebox" required="true"/></td>
                     </tr>
                     <tr>
                         <td>选择取派员</td>
                         <td>
                             <input class="easyui-combobox" name="staff.id"
                                    data-options="valueField:'id',textField:'name',
    							url:'/staff/listAjax'" />
                         </td>
                     </tr>
                     <tr height="300">
                         <td valign="top">关联分区</td>
                         <td>
                             <table id="subareaGrid"  class="easyui-datagrid" border="false" style="width:300px;height:300px"
                                    data-options="url:'subareaAction_listajax.action',fitColumns:true,singleSelect:false">
                                 <thead>
                                 <tr>
                                     <th data-options="field:'subareaid',width:30,checkbox:true">编号</th>
                                     <th data-options="field:'addresskey',width:150">关键字</th>
                                     <th data-options="field:'position',width:200,align:'right'">位置</th>
                                 </tr>
                                 </thead>
                             </table>
                         </td>
                     </tr>
                 </table>
             </form>
         </div>
     </div>

     <%--查询定区--%>
     <div class="easyui-window" title="查询定区窗口" id="searchWindow" collapsible="false" minimizable="false" maximizable="false" style="top:20px;left:200px">
         <div style="overflow:auto;padding:5px;" border="false">
             <form>
                 <table class="table-edit" width="80%" align="center">
                     <tr class="title">
                         <td colspan="2">查询条件</td>
                     </tr>
                     <tr>
                         <td>定区编码</td>
                         <td><input type="text" name="id" class="easyui-validatebox" required="true"/></td>
                     </tr>
                     <tr>
                         <td>所属单位</td>
                         <td><input type="text" name="staff.station" class="easyui-validatebox" required="true"/></td>
                     </tr>
                     <tr>
                         <td colspan="2"><a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a> </td>
                     </tr>
                 </table>
             </form>
         </div>
     </div>

     <!-- 关联客户窗口 -->
     <div modal=true class="easyui-window" title="关联客户窗口" id="customerWindow" collapsible="false" closed="true" minimizable="false" maximizable="false" style="top:20px;left:200px;width: 400px;height: 300px;">
         <div style="overflow:auto;padding:5px;" border="false">
             <form id="customerForm" action="${pageContext.request.contextPath }/decidedzoneAction_assigncustomerstodecidedzone.action" method="post">
                 <table class="table-edit" width="80%" align="center">
                     <tr class="title">
                         <td colspan="3">关联客户</td>
                     </tr>
                     <tr>
                         <td>
                             <input type="hidden" name="id" id="customerDecidedZoneId" />
                             <select id="noassociationSelect" multiple="multiple" size="10"></select>
                         </td>
                         <td>
                             <input type="button" value="》》" id="toRight"><br/>
                             <input type="button" value="《《" id="toLeft">
                             <script type="text/javascript">
                                 $(function(){
                                     //为左右移动按钮绑定事件
                                     $("#toRight").click(function(){
                                         $("#associationSelect").append($("#noassociationSelect option:selected"));
                                     });
                                     $("#toLeft").click(function(){
                                         $("#noassociationSelect").append($("#associationSelect option:selected"));
                                     });

                                     //为关联客户按钮绑定事件
                                     $("#associationBtn").click(function(){
                                         var rows = $("#grid").datagrid("getSelections");
                                         var id = rows[0].id;
                                         //为隐藏域（存放定区id）赋值
                                         $("input[name=id]").val(id);
                                         //提交表单之前，需要将右侧下拉框中所有的选项选中,为option添加一个selected属性
                                         $("#associationSelect option").attr("selected","selected");
                                         $("#customerForm").submit();
                                     });
                                 });
                             </script>
                         </td>
                         <td>
                             <select id="associationSelect" name="customerIds" multiple="multiple" size="10">
                             </select>
                         </td>
                     </tr>
                     <tr>
                         <td colspan="3"><a id="associationBtn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">关联客户</a> </td>
                     </tr>
                 </table>
             </form>
         </div>
     </div>
</body>
</html>
