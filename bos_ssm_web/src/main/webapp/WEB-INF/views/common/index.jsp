<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/include/taglibs.jsp"%>
<html>
<head>
    <title>Bos主界面</title>
    <%@include file="/include/header.jsp"%>
    <script>
//---------------zTree---------------------
        $(function () {
            var setting={
                data:{
                    simpleData:{
                        enable:true
                    }
                },
                callback:{
                    onClick:onClick
                }
            };

            //基本功能菜单加载
            $.ajax({
                url:"${rootContext}/function/findParents",
                type:'POST',
                dataType:'text',
                success:function(data){
                    var zNodes=eval("("+data+")");
                    $.fn.zTree.init($("#treeMenu"),setting,zNodes);
                }
            });

            //系统管理功能菜单加载
            $.ajax({
                url:"${stc_res}/json/admin.json",
                type:'POST',
                dataType:'text',
                success:function(data){
                    var zNodes=eval("("+data+")");
                    $.fn.zTree.init($("#adminMenu"),setting,zNodes);
                }
            });

            //打开页面后，弹出欢迎窗口
            window.setTimeout(function () {
                $.messager.show({
                    title:"消息提示",
                    msg:'${user.username},欢迎登陆',
                    timeout:5000
                });
            },3000);

            //改密码窗口确认按钮点击事件
            $("#bt_ok").click(function () {
                var b=$("#editPwdForm").form("validate");
                if(b){
                    var p1=$("#txtNewPwd").val();
                    var p2=$("#txtRePawd").val();
                    if(p1==p2){
                        $.post("${rootContext}/user/updatePwd",{"password":p1},function (data) {
                            if(data=='1'){
                                $.messager.prompt("消息提示","修改密码成功!");
                                $("#editPwdWindow").window("close");
                            }else{
                                $.messager.alert("警告！","修改密码失败！","error");
                            }
                        });
                    }else{$.messager.alert("警告！","两次输入不一致，请重新输入！","error");}
                }
            });

            //取消按钮点击事件
            $("#bt_cancel").click(function () {
                $("#editPwdWindow").window("close");
            });

        });

        //点击打开修改密码窗口
        function editPassword() {
            $("#editPwdWindow").window("open");
        }

        //联系管理员
        function showAbout() {
            $.messager.alert("消息提示","联系电话：18381957044","info");
        }

        //退出系统
        function logoutFun() {
            $.messager.confirm("系统提示","确认退出本次登陆？",function (b) {
                if(b){
                    location.href="${rootContext}/user/logout";
                }
            })
        }

        //更换主题
        function changeTheme(themeName) {
            var $themeLink=$("#easyuiTheme");
            var url=$themeLink.attr("href");
            var href=url.substring(0,url.indexOf('themes'))+'themes/'+themeName+'/easyui.css';
            $themeLink.attr('here',href);

            var $iframe = $('iframe');
            if ($iframe.length > 0) {
                for ( var i = 0; i < $iframe.length; i++) {
                    var ifr = $iframe[i];
                    $(ifr).contents().find('#easyuiTheme').attr('href', href);
                }
            }
        };

        //右侧zTree菜单点击事件
        function onClick(event,treeId,treeNode,clickFlag) {
            if (treeNode.page!=undefined&&treeNode.page!=null){
                var content = '<div style="width:100%;height:100%;overflow:hidden;">'
                    + '<iframe src="'+treeNode.page
                    + '" scrolling="auto" style="width:100%;height:100%;border:0;" ></iframe></div>';

                if($("#tabs").tabs('exists',treeNode.name)){
                    $("#tabs").tabs('select',treeNode.name);
                    var tab=$("#tabs").tabs('getSelected');
                    $("#tabs").tabs('update',{
                        tab:tab,
                        options:{
                            title:treeNode.name,
                            content:content
                        }
                    });
                }else{
                    $("#tabs").tabs('add',{
                        title:treeNode.name,
                        content:content,
                        closable:true
                    });
                }
            }
        }
    </script>
</head>
<body class="easyui-layout">
    <div data-options="region:'north',border:false" style="height: 80px; padding: 10px;
     background-image: url('${stc_res}/images/header_bg.png')">
        <div id="sessionInfoDiv" style="position: absolute; right: 5px; top: 10px;">
            <strong>${user.username}</strong>,欢迎您
        </div>
        <div style="position: absolute;right: 5px; bottom: 10px;">
            <a href="javascript:void(0)" class="easyui-menubutton"
               data-options="menu:'#pfM',iconCls:'icon-blank'">更换皮肤</a>
            <a href="javascript:void(0)" class="easyui-menubutton"
               data-options="menu:'#kzM',iconCls:'icon-blank'">控制面板</a>
        </div>
        <div id="pfM" style="width: 120px; display: none;">
            <div onclick="changeTheme('default');">默认主题</div>
            <div onclick="changeTheme('gray');">灰色主题</div>
            <div onclick="changeTheme('black');">黑色主题</div>
            <div onclick="changeTheme('bootstrap');">bootstrap风格</div>
            <div onclick="changeTheme('metro');">metro风格</div>
        </div>
        <div id="kzM" style="width: 100px; display: none;">
            <div onclick="editPassword();">修改密码</div>
            <div onclick="showAbout();">联系管理员</div>
            <div class="menu-sep"></div>
            <div onclick="logoutFun();">退出系统</div>
        </div>
    </div>
    <div data-options="region: 'west',split:true,title:'菜单导航'" style="width: 200px;">
        <div class="easyui-accordion" fit="true" border="false">
            <div title="基本功能" data-options="iconCls:'icon-mini-add'" style="overflow:auto">
                <ul id="treeMenu" class="ztree"></ul>
            </div>
            <div title="系统管理" data-options="iconCls:'icon-mini-add'" style="overflow:auto">
                <ul id="adminMenu" class="ztree"></ul>
            </div>
        </div>
    </div>
    <div data-options="region:'center'">
        <div id="tabs" class="easyui-tabs" border="false">
            <div title="消息中心" id="subWrap" style="height: 100%;width: 100%;overflow: hidden">
                <iframe src="${rootContext}/home" style="height: 100%; width: 100%;border:0"></iframe>
            </div>
        </div>
    </div>
    <div data-options="region:'south',border:false" style="height: 50px; padding: 10px;background-color:#b3b3b3">
    </div>

    <%--修改密码窗口--%>
    <div id="editPwdWindow" class="easyui-window" title="修改密码" collapsible="false"
         minimizable="false" modal="true" closed="true" resizable="false"
         maximizable="false" icon="icon-save" style="width: 300px;
         height: 160px;padding: 5px;background: #fafafa">
         <div class="easyui-layout" fit="true" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
             <div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
                 <from id="editPwdForm">
                     <table cellpadding=3>
                         <tr>
                             <td>新密码：</td>
                             <td><input  required="true" data-options="validType:'length[4,18]'" id="txtNewPwd" type="Password" class="txt01 easyui-validatebox" /></td>
                         </tr>
                         <tr>
                             <td>确认密码：</td>
                             <td><input required="true" data-options="validType:'length[4,18]'" id="txtRePawd" type="Password" class="txt01 easyui-validatebox" /></td>
                         </tr>
                     </table>
                 </from>
             </div>
             <div region="south" style="text-align: right; height: 30px; line-height: 30px;">
                 <a id="bt_ok" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)" >确定</a>
                 <a id="bt_cancel" class="easyui-linkbutton" icon="icon-cancel" href="javascript:void(0)">取消</a>
             </div>
         </div>
    </div>
</body>
</html>

















