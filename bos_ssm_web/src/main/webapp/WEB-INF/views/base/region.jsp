<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/include/taglibs.jsp"%>
<html>
<head>
    <title>Region</title>
    <%@include file="/include/header.jsp"%>
    <script>
        function doAdd(){
            $('#addRegionWindow').window("open");
        }

        function doView(){
            var rows=$("#grid").datagrid("getSelections");
            if (rows.length==0){
                $.messager.alert("消息提示","请选择要修改的项","warning")
            }else{
                $.messager.confirm("消息提示","确认修改选中项",function (b) {
                    if(b){
                        var ay=new Array();
                        for(var i=0;i<rows.length;i++){
                            var id=rows[i].id;
                            ay.push(id);
                        }
                        var ids=ay.join(",");
                        $("input[name='ids']").attr("value",ids);
                        $("#editRegionWindow").window("open");
                    }
                });
            }
        }

        function doDelete(){
            var rows=$("#grid").datagrid("getSelections");
            if (rows.length==0){
                $.messager.alert("消息提示","请选择要删除的项","warning")
            }else{
                $.messager.confirm("消息提示","确认删除选中项",function (b) {
                    if(b){
                        var ay=new Array();
                        for(var i=0;i<rows.length;i++){
                            var id=rows[i].id;
                            ay.push(id);
                        }
                        var ids=ay.join(",");
                        window.location.href="${rootContext}/region/delete/"+ids;
                    }
                });
            }
        }

        //工具栏
        var toolbar = [ {
            id : 'button-edit',
            text : '批量修改',
            iconCls : 'icon-edit',
            handler : doView
        }, {
            id : 'button-add',
            text : '增加',
            iconCls : 'icon-add',
            handler : doAdd
        }, {
            id : 'button-delete',
            text : '批量删除',
            iconCls : 'icon-cancel',
            handler : doDelete
        }, {
            id : 'button-import',
            text : '导入',
            iconCls : 'icon-redo'
        }];

        // 定义列
        var columns = [ [ {
            field : 'id',
            checkbox : true,
        },{
            field : 'province',
            title : '省',
            width : 120,
            align : 'center'
        }, {
            field : 'city',
            title : '市',
            width : 120,
            align : 'center'
        }, {
            field : 'district',
            title : '区',
            width : 120,
            align : 'center'
        }, {
            field : 'postcode',
            title : '邮编',
            width : 120,
            align : 'center'
        }, {
            field : 'shortcode',
            title : '简码',
            width : 120,
            align : 'center'
        }, {
            field : 'citycode',
            title : '城市编码',
            width : 200,
            align : 'center'
        } ] ];

        $(function () {
            $('body').css({visibility:"visible"});

            $("#grid").datagrid({
                iconCls : 'icon-forward',
                fit : true,
                border : false,
                rownumbers : true,
                striped : true,
                pageList: [30,50,100],
                pagination : true,
                toolbar : toolbar,
                url : "${rootContext}/region/pageList",
                idField : 'id',
                columns : columns,
                onDblClickRow : doDblClickRow
            });

            //页面加载完成后，调用OCUpload插件的方法
            $("#button-import").upload({
                action:'${rootContext}/region/importXls',
                name:'regionFile'
            });

            // 添加区域窗口
            $('#addRegionWindow').window({
                title: '添加修改区域',
                width: 400,
                modal: true,
                shadow: true,
                closed: true,
                height: 400,
                resizable:false
            });

            // 修改区域窗口
            $('#editRegionWindow').window({
                title: '添加修改区域',
                width: 400,
                modal: true,
                shadow: true,
                closed: true,
                height: 400,
                resizable:false
            });
        });

        function doDblClickRow() {
            alert('Double killed');
        }
    </script>
</head>
<body class="easyui-layout" style="visibility: hidden">
      <div region="center" border="false">
          <table id="grid"></table>
      </div>

      //区域添加窗口
      <div class="easyui-window" title="区域添加窗口" id="addRegionWindow"
           collapsible="false" minimizable="false" maximizable="false"
           style="top:20px;left:200px">
          <div region="north" border="false" style="height: 31px;overflow: hidden">
              <div class="datagrid-toolbar">
                  <a href="#" id="bt_save" icon="icon-save" class="easyui-linkbutton" plain="true">保存</a>
              </div>
          </div>
          <div region="center" style="overflow:auto;padding:5px;" border="false">
              <form action="${rootContext}/region/add" id="addRegionForm" method="post">
                  <table class="table-edit"  width="80%" align="center">
                      <tr class="title">
                          <td colspan="2">区域信息</td>
                      </tr>
                      <tr>
                          <td>省</td>
                          <td><input type="text" name="province" class="easyui-validatebox" required="true"></td>
                      </tr>
                      <tr>
                          <td>市</td>
                          <td><input type="text" name="city" class="easyui-validatebox" required="true"></td>
                      </tr>
                      <tr>
                          <td>区</td>
                          <td><input type="text" name="district" class="easyui-validatebox" required="true"></td>
                      </tr>
                      <tr>
                          <td>邮编</td>
                          <td><input type="text" name="postcode" class="easyui-validatebox" required="true"></td>
                      </tr>
                      <tr>
                          <td>简码</td>
                          <td><input type="text" name="shortcode" class="easyui-validatebox" required="true"></td>
                      </tr>
                      <tr>
                          <td>城市编码</td>
                          <td><input type="text" name="citycode" class="easyui-validatebox" required="true"></td>
                      </tr>
                  </table>
              </form>
              <script>
                  $(function () {
                      $("#bt_save").click(function () {
                          var b=$("#addRegionForm").form("validate");
                          if (b){
                              $("#addRegionForm").submit();
                          }
                      });
                  });
              </script>
          </div>
      </div>

      <%--区域修改--%>
      <div class="easyui-window" title="区域批量修改窗口" id="editRegionWindow"
           collapsible="false" minimizable="false" maximizable="false"
           style="top:20px;left:200px">
          <div region="north" border="false" style="height: 31px;overflow: hidden">
              <div class="datagrid-toolbar">
                  <a href="#" id="bt_edit" icon="icon-edit" class="easyui-linkbutton" plain="true">修改</a>
              </div>
          </div>
          <div region="center" style="overflow:auto;padding:5px;" border="false">
              <form action="${rootContext}/region/editB" method="post" id="editRegionForm">
                  <table class="table-edit"  width="80%" align="center">
                      <tr class="title">
                          <td colspan="2">区域信息</td>
                          <input name="ids" type="hidden"/>
                      </tr>
                      <tr>
                          <td>省</td>
                          <td><input type="text" name="province" class="easyui-validatebox"></td>
                      </tr>
                      <tr>
                          <td>市</td>
                          <td><input type="text" name="city" class="easyui-validatebox"></td>
                      </tr>
                      <tr>
                          <td>区</td>
                          <td><input type="text" name="district" class="easyui-validatebox"></td>
                      </tr>
                      <tr>
                          <td>邮编</td>
                          <td><input type="text" name="postcode" class="easyui-validatebox"></td>
                      </tr>
                      <tr>
                          <td>简码</td>
                          <td><input type="text" name="shortcode" class="easyui-validatebox"></td>
                      </tr>
                      <tr>
                          <td>城市编码</td>
                          <td><input type="text" name="citycode" class="easyui-validatebox"></td>
                      </tr>
                  </table>
              </form>
              <script>
                  $(function () {
                      $("#bt_edit").click(function () {
                          var b=$("#editRegionForm").form("validate");
                          if(b){
                              $("#editRegionForm").submit();
                          }
                      });
                  });
              </script>
          </div>
      </div>
</body>
</html>





















