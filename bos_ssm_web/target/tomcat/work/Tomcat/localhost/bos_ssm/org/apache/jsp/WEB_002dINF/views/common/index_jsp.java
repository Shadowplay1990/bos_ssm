/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-06-12 20:27:47 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.common;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/include/taglibs.jsp", Long.valueOf(1494922759000L));
    _jspx_dependants.put("/include/header.jsp", Long.valueOf(1495095353000L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write('\n');
      if (_jspx_meth_c_005fset_005f1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Bos主界面</title>\n");
      out.write("    ");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${stc_res}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery-1.8.3.js\"></script>\n");
      out.write("<link id=\"easyuiTheme\" rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${stc_res}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/easyui/themes/default/easyui.css\">\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${stc_res}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/easyui/themes/icon.css\">\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${stc_res}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/easyui/ext/portal.css\">\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${stc_res}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/default.css\">\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${stc_res}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/easyui/jquery.easyui.min.js\"></script>\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${stc_res}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/easyui/ext/jquery.portal.js\"></script>\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${stc_res}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/easyui/ext/jquery.cookie.js\"></script>\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${stc_res}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/easyui/locale/easyui-lang-zh_CN.js\"></script>\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${stc_res}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/ztree/zTreeStyle.css\">\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${stc_res}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/ztree/jquery.ztree.all-3.5.js\"></script>\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${stc_res}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery.ocupload-1.1.2.js\"></script>\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${stc_res}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/highcharts/highcharts.js\"></script>\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${stc_res}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/highcharts/modules/exporting.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("    <script>\n");
      out.write("//---------------zTree---------------------\n");
      out.write("        $(function () {\n");
      out.write("            var setting={\n");
      out.write("                data:{\n");
      out.write("                    simpleData:{\n");
      out.write("                        enable:true\n");
      out.write("                    }\n");
      out.write("                },\n");
      out.write("                callback:{\n");
      out.write("                    onClick:onClick\n");
      out.write("                }\n");
      out.write("            };\n");
      out.write("\n");
      out.write("            //基本功能菜单加载\n");
      out.write("            $.ajax({\n");
      out.write("                url:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${rootContext}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/function/findParents\",\n");
      out.write("                type:'POST',\n");
      out.write("                dataType:'text',\n");
      out.write("                success:function(data){\n");
      out.write("                    var zNodes=eval(\"(\"+data+\")\");\n");
      out.write("                    $.fn.zTree.init($(\"#treeMenu\"),setting,zNodes);\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("\n");
      out.write("            //系统管理功能菜单加载\n");
      out.write("            $.ajax({\n");
      out.write("                url:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${stc_res}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/json/admin.json\",\n");
      out.write("                type:'POST',\n");
      out.write("                dataType:'text',\n");
      out.write("                success:function(data){\n");
      out.write("                    var zNodes=eval(\"(\"+data+\")\");\n");
      out.write("                    $.fn.zTree.init($(\"#adminMenu\"),setting,zNodes);\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("\n");
      out.write("            //打开页面后，弹出欢迎窗口\n");
      out.write("            window.setTimeout(function () {\n");
      out.write("                $.messager.show({\n");
      out.write("                    title:\"消息提示\",\n");
      out.write("                    msg:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.username}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(",欢迎登陆',\n");
      out.write("                    timeout:5000\n");
      out.write("                });\n");
      out.write("            },3000);\n");
      out.write("\n");
      out.write("            //改密码窗口确认按钮点击事件\n");
      out.write("            $(\"#bt_ok\").click(function () {\n");
      out.write("                var b=$(\"#editPwdForm\").form(\"validate\");\n");
      out.write("                if(b){\n");
      out.write("                    var p1=$(\"#txtNewPwd\").val();\n");
      out.write("                    var p2=$(\"#txtRePawd\").val();\n");
      out.write("                    if(p1==p2){\n");
      out.write("                        $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${rootContext}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/user/updatePwd\",{\"password\":p1},function (data) {\n");
      out.write("                            if(data=='1'){\n");
      out.write("                                $.messager.prompt(\"消息提示\",\"修改密码成功!\");\n");
      out.write("                                $(\"#editPwdWindow\").window(\"close\");\n");
      out.write("                            }else{\n");
      out.write("                                $.messager.alert(\"警告！\",\"修改密码失败！\",\"error\");\n");
      out.write("                            }\n");
      out.write("                        });\n");
      out.write("                    }else{$.messager.alert(\"警告！\",\"两次输入不一致，请重新输入！\",\"error\");}\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("\n");
      out.write("            //取消按钮点击事件\n");
      out.write("            $(\"#bt_cancel\").click(function () {\n");
      out.write("                $(\"#editPwdWindow\").window(\"close\");\n");
      out.write("            });\n");
      out.write("\n");
      out.write("        });\n");
      out.write("\n");
      out.write("        //点击打开修改密码窗口\n");
      out.write("        function editPassword() {\n");
      out.write("            $(\"#editPwdWindow\").window(\"open\");\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        //联系管理员\n");
      out.write("        function showAbout() {\n");
      out.write("            $.messager.alert(\"消息提示\",\"联系电话：18381957044\",\"info\");\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        //退出系统\n");
      out.write("        function logoutFun() {\n");
      out.write("            $.messager.confirm(\"系统提示\",\"确认退出本次登陆？\",function (b) {\n");
      out.write("                if(b){\n");
      out.write("                    location.href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${rootContext}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/user/logout\";\n");
      out.write("                }\n");
      out.write("            })\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        //更换主题\n");
      out.write("        function changeTheme(themeName) {\n");
      out.write("            var $themeLink=$(\"#easyuiTheme\");\n");
      out.write("            var url=$themeLink.attr(\"href\");\n");
      out.write("            var href=url.substring(0,url.indexOf('themes'))+'themes/'+themeName+'/easyui.css';\n");
      out.write("            $themeLink.attr('here',href);\n");
      out.write("\n");
      out.write("            var $iframe = $('iframe');\n");
      out.write("            if ($iframe.length > 0) {\n");
      out.write("                for ( var i = 0; i < $iframe.length; i++) {\n");
      out.write("                    var ifr = $iframe[i];\n");
      out.write("                    $(ifr).contents().find('#easyuiTheme').attr('href', href);\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        };\n");
      out.write("\n");
      out.write("        //右侧zTree菜单点击事件\n");
      out.write("        function onClick(event,treeId,treeNode,clickFlag) {\n");
      out.write("            if (treeNode.page!=undefined&&treeNode.page!=null){\n");
      out.write("                var content = '<div style=\"width:100%;height:100%;overflow:hidden;\">'\n");
      out.write("                    + '<iframe src=\"'+treeNode.page\n");
      out.write("                    + '\" scrolling=\"auto\" style=\"width:100%;height:100%;border:0;\" ></iframe></div>';\n");
      out.write("\n");
      out.write("                if($(\"#tabs\").tabs('exists',treeNode.name)){\n");
      out.write("                    $(\"#tabs\").tabs('select',treeNode.name);\n");
      out.write("                    var tab=$(\"#tabs\").tabs('getSelected');\n");
      out.write("                    $(\"#tabs\").tabs('update',{\n");
      out.write("                        tab:tab,\n");
      out.write("                        options:{\n");
      out.write("                            title:treeNode.name,\n");
      out.write("                            content:content\n");
      out.write("                        }\n");
      out.write("                    });\n");
      out.write("                }else{\n");
      out.write("                    $(\"#tabs\").tabs('add',{\n");
      out.write("                        title:treeNode.name,\n");
      out.write("                        content:content,\n");
      out.write("                        closable:true\n");
      out.write("                    });\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("</head>\n");
      out.write("<body class=\"easyui-layout\">\n");
      out.write("    <div data-options=\"region:'north',border:false\" style=\"height: 80px; padding: 10px;\n");
      out.write("     background-image: url('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${stc_res}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/images/header_bg.png')\">\n");
      out.write("        <div id=\"sessionInfoDiv\" style=\"position: absolute; right: 5px; top: 10px;\">\n");
      out.write("            <strong>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.username}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</strong>,欢迎您\n");
      out.write("        </div>\n");
      out.write("        <div style=\"position: absolute;right: 5px; bottom: 10px;\">\n");
      out.write("            <a href=\"javascript:void(0)\" class=\"easyui-menubutton\"\n");
      out.write("               data-options=\"menu:'#pfM',iconCls:'icon-blank'\">更换皮肤</a>\n");
      out.write("            <a href=\"javascript:void(0)\" class=\"easyui-menubutton\"\n");
      out.write("               data-options=\"menu:'#kzM',iconCls:'icon-blank'\">控制面板</a>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"pfM\" style=\"width: 120px; display: none;\">\n");
      out.write("            <div onclick=\"changeTheme('default');\">默认主题</div>\n");
      out.write("            <div onclick=\"changeTheme('gray');\">灰色主题</div>\n");
      out.write("            <div onclick=\"changeTheme('black');\">黑色主题</div>\n");
      out.write("            <div onclick=\"changeTheme('bootstrap');\">bootstrap风格</div>\n");
      out.write("            <div onclick=\"changeTheme('metro');\">metro风格</div>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"kzM\" style=\"width: 100px; display: none;\">\n");
      out.write("            <div onclick=\"editPassword();\">修改密码</div>\n");
      out.write("            <div onclick=\"showAbout();\">联系管理员</div>\n");
      out.write("            <div class=\"menu-sep\"></div>\n");
      out.write("            <div onclick=\"logoutFun();\">退出系统</div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div data-options=\"region: 'west',split:true,title:'菜单导航'\" style=\"width: 200px;\">\n");
      out.write("        <div class=\"easyui-accordion\" fit=\"true\" border=\"false\">\n");
      out.write("            <div title=\"基本功能\" data-options=\"iconCls:'icon-mini-add'\" style=\"overflow:auto\">\n");
      out.write("                <ul id=\"treeMenu\" class=\"ztree\"></ul>\n");
      out.write("            </div>\n");
      out.write("            <div title=\"系统管理\" data-options=\"iconCls:'icon-mini-add'\" style=\"overflow:auto\">\n");
      out.write("                <ul id=\"adminMenu\" class=\"ztree\"></ul>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div data-options=\"region:'center'\">\n");
      out.write("        <div id=\"tabs\" class=\"easyui-tabs\" border=\"false\">\n");
      out.write("            <div title=\"消息中心\" id=\"subWrap\" style=\"height: 100%;width: 100%;overflow: hidden\">\n");
      out.write("                <iframe src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${rootContext}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/home\" style=\"height: 100%; width: 100%;border:0\"></iframe>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div data-options=\"region:'south',border:false\" style=\"height: 50px; padding: 10px;background-color:#b3b3b3\">\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    ");
      out.write("\n");
      out.write("    <div id=\"editPwdWindow\" class=\"easyui-window\" title=\"修改密码\" collapsible=\"false\"\n");
      out.write("         minimizable=\"false\" modal=\"true\" closed=\"true\" resizable=\"false\"\n");
      out.write("         maximizable=\"false\" icon=\"icon-save\" style=\"width: 300px;\n");
      out.write("         height: 160px;padding: 5px;background: #fafafa\">\n");
      out.write("         <div class=\"easyui-layout\" fit=\"true\" style=\"padding: 10px; background: #fff; border: 1px solid #ccc;\">\n");
      out.write("             <div region=\"center\" border=\"false\" style=\"padding: 10px; background: #fff; border: 1px solid #ccc;\">\n");
      out.write("                 <from id=\"editPwdForm\">\n");
      out.write("                     <table cellpadding=3>\n");
      out.write("                         <tr>\n");
      out.write("                             <td>新密码：</td>\n");
      out.write("                             <td><input  required=\"true\" data-options=\"validType:'length[4,18]'\" id=\"txtNewPwd\" type=\"Password\" class=\"txt01 easyui-validatebox\" /></td>\n");
      out.write("                         </tr>\n");
      out.write("                         <tr>\n");
      out.write("                             <td>确认密码：</td>\n");
      out.write("                             <td><input required=\"true\" data-options=\"validType:'length[4,18]'\" id=\"txtRePawd\" type=\"Password\" class=\"txt01 easyui-validatebox\" /></td>\n");
      out.write("                         </tr>\n");
      out.write("                     </table>\n");
      out.write("                 </from>\n");
      out.write("             </div>\n");
      out.write("             <div region=\"south\" style=\"text-align: right; height: 30px; line-height: 30px;\">\n");
      out.write("                 <a id=\"bt_ok\" class=\"easyui-linkbutton\" icon=\"icon-ok\" href=\"javascript:void(0)\" >确定</a>\n");
      out.write("                 <a id=\"bt_cancel\" class=\"easyui-linkbutton\" icon=\"icon-cancel\" href=\"javascript:void(0)\">取消</a>\n");
      out.write("             </div>\n");
      out.write("         </div>\n");
      out.write("    </div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fset_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f0.setParent(null);
    // /include/taglibs.jsp(6,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setVar("rootContext");
    // /include/taglibs.jsp(6,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setValue(new org.apache.jasper.el.JspValueExpression("/include/taglibs.jsp(6,0) '${pageContext.request.contextPath}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${pageContext.request.contextPath}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
    if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f1 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f1.setParent(null);
    // /include/taglibs.jsp(7,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f1.setVar("stc_res");
    // /include/taglibs.jsp(7,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f1.setValue(new org.apache.jasper.el.JspValueExpression("/include/taglibs.jsp(7,0) '${pageContext.request.contextPath}/tangResouce'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${pageContext.request.contextPath}/tangResouce",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int _jspx_eval_c_005fset_005f1 = _jspx_th_c_005fset_005f1.doStartTag();
    if (_jspx_th_c_005fset_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f1);
    return false;
  }
}
