<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>后台登录</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>

    <#--  <link rel="shortcut icon" href="${re.contextPath}/plugin/x-admin/images/bizhou.ico" type="image/x-icon"/>  -->
    <link rel="stylesheet" href="${re.contextPath}/plugin/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="${re.contextPath}/plugin/x-admin/css/font.css">
    <link rel="stylesheet" href="${re.contextPath}/plugin/x-admin/css/xadmin.css">
    <script type="text/javascript" src="${re.contextPath}/plugin/layui/layui.all.js"></script>
    <script type="text/javascript" src="${re.contextPath}/plugin/jquery/jquery-3.2.1.min.js"></script>
    <style>
        .login .layui-form #one{
            width:15%;
            padding: 9px 0;
        }
        #two {
            width:45%;
        }
        #three {
            width:35%
        }
        .four {
            width:100%;height:35px;
        }
        #register {
            display: inline-block;
            font-size: 18px;
            line-height: 24px;
            text-align: center;
            white-space: nowrap;
            vertical-align: middle;
            cursor: pointer;
            width:153px;
            height: 48px;
            margin: 0px;
            border-radius: 3px;
        }
    </style>
</head>
<body class="login-bg">
<div class="login">
    <div class="message">广州大学考试管理系统</div>
    <div id="darkbannerwrap"></div>

    <form method="post" action="${re.contextPath}/login" class="layui-form">
        <input name="username" placeholder="用户名" autocomplete="off" type="text" lay-verify="username"
               class="layui-input">
        <hr class="hr15">
        <input name="password" lay-verify="password" placeholder="密码" autocomplete="off" type="password"
               class="layui-input">
        <hr class="hr15">
        <div class="layui-inline" style="display:flex;justify-content:space-between;">
            <label class="layui-form-label" id="one">验证码&nbsp;</label>
            <div class="layui-input-inline" id="two">
                <input type="text" name="code" style="width:150px;height:35px;" autocomplete="off" lay-verify="code"
                       class="layui-input">
            </div>
            <div class="layui-input-inline" id="three">
                <img src="" id="code" class="four">
            </div>
        </div>
        <#--        <div class="layui-inline">-->
        <#--            <label class="layui-form-label" style="width:40px;padding: 9px 0px;">验证码&nbsp;</label>-->
        <#--            <div class="layui-input-inline">-->
        <#--                <input type="text" name="code" style="width:150px;height:35px;" autocomplete="off" lay-verify="code"-->
        <#--                       class="layui-input">-->
        <#--            </div>-->
        <#--            <div class="layui-input-inline">-->
        <#--                <img src="" style="width:100%;height:35px;" id="code">-->
        <#--            </div>-->

        <#--        </div>-->
        <#--        <div class="layui-inline">-->
        <#--            <label class="layui-form-label" style="width: 15%;padding: 9px 0;" class="layui-form-label">验证码&nbsp;</label>-->
        <#--            <div style="width:45%;" class="layui-input-inline">-->
        <#--                <input type="text" name="code" style="width:150px;height:35px;" autocomplete="off" lay-verify="code"-->
        <#--                       class="layui-input">-->
        <#--            </div>-->
        <#--            <div style="width:35%;" class="layui-input-inline">-->
        <#--                <img src=""  style="width: 100%;height: 35px;"  id="code">-->
        <#--            </div>-->
        <#--        </div>-->
        <hr class="hr15">
        <div style="display: flex;justify-content: space-between;">
            <input value="登录" lay-submit lay-filter="login" style="width:45%;" type="submit">
            <button id="register"  class="layui-btn layui-btn-primary" type="button" onclick="window.location.href='${re.contextPath}/register'">注册</button>
            <#--  <input id="register" style="background-color: #fff;width:45%;color: #333;border: 1px solid #333;" value="注册" lay-submit lay-filter="register">  -->
        </div>
        <hr class="hr20">
    </form>
</div>

<script>
    var layer;
    $(function () {
        layui.use(['form', 'layer'], function () {
            var form = layui.form;
            form.verify({
                username: function (v) {
                    if (v.trim() == '') {
                        return "用户名不能为空";
                    }
                }
                , password: function (v) {
                    if (v.trim() == '') {
                        return "密码不能为空";
                    }
                }, code: function (v) {
                    if (v.trim() == '') {
                        return '验证码不能为空';
                    }
                }
            });

            form.render();
        });
        layer = layui.layer;
        var msg = '${message}';
        if (msg.trim() != "") {
            layer.msg(msg, {icon: 5, anim: 6, offset: 't'});
        }
        $("#code").click(function () {
            var url = "${re.contextPath}/getCode?" + new Date().getTime();
            this.src = url;
        }).click().show();
        $('#code').on('mouseover', function () {
            layer.tips('点击刷新验证码', this, {time: 1000});
        });
    })

    if (window != top){
        top.location.href = location.href;
    }

</script>


<!-- 底部结束 -->
</body>
</html>
