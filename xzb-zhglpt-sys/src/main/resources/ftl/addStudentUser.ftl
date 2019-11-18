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
        .login .layui-form #register_box {
            display: inline-block;
            font-size: 11px;
            line-height: 14px;
            text-align: center;
            white-space: nowrap;
            vertical-align: middle;
            cursor: pointer;
            margin: 0px;
            padding: 12px 24px;
            border-radius: 3px;
        }
    </style>
</head>
<body class="login-bg">
<div class="login">
    <div class="message">广州大学考试管理系统</div>
    <div id="darkbannerwrap"></div>

    <form class="layui-form">
        <input name="username" placeholder="用户名" autocomplete="off" type="text" lay-verify="username"
               class="layui-input">
        <hr class="hr15">
        <input name="password" lay-verify="password" placeholder="密码" autocomplete="off" type="password"
               class="layui-input">
        <hr class="hr15">
        <input name="password" lay-verify="password" placeholder="确认密码" autocomplete="off" type="password"
               class="layui-input">
        <hr class="hr15">
        <div class="layui-inline">
            <label class="layui-form-label" style="width:40px;padding: 9px 0px;">验证码&nbsp;</label>
            <div class="layui-input-inline">
                <input type="text" name="code" style="width:150px;height:35px;" autocomplete="off" lay-verify="code"
                       class="layui-input">
            </div>
            <div class="layui-input-inline" style="margin-left: 38px;">
                <#--  <button  class="layui-btn layui-btn-primary">发送验证码</button>  -->
                <#--  <input id="register" lay-submit lay-filter="login" value="发送验证码" style="width:150px;height:35px;">  -->
                <input type="button" id="register_box" value="发送验证码" onclick="sendemail()" />
            </div>
        </div>
        <hr class="hr15">
        <div style="display: flex;justify-content: space-between;">
            <input value="注册" lay-submit lay-filter="login" style="width:45%;" type="submit">
            <button id="register"  class="layui-btn layui-btn-primary">返回登录</button>
        </div>
        <hr class="hr20">
    </form>
</div>


<script>

    var countdown=60;
    function sendemail(){
        var obj = $("#register_box");
        settime(obj);

    }
    function settime(obj) { //发送验证码倒计时
        if (countdown == 0) {
            obj.attr('disabled',false);
            //obj.removeattr("disabled");
            obj.val("发送验证码");
            countdown = 60;
            return;
        } else {
            obj.attr('disabled',true);
            obj.val("已发送(" + countdown + ")");
            countdown--;
        }
        setTimeout(function() {
                settime(obj) }
            ,1000)
    }
</script>


<!-- 底部结束 -->
</body>
</html>
