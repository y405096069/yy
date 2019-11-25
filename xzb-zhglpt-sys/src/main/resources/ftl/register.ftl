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
            width: 153px;
            height: 48px;
            margin: 0px;
            border-radius: 3px;
        }

        .login .layui-form #register_box {
            display: inline-block;
            font-size: 9px;
            line-height: 14px;
            text-align: center;
            white-space: nowrap;
            vertical-align: middle;
            cursor: pointer;
            margin: 0px;
            padding: 10px 20px;
            border-radius: 3px;
        }
    </style>
</head>
<body class="login-bg">
<div class="login">
    <div class="message">广州大学考试管理系统</div>
    <div id="darkbannerwrap"></div>

    <form method="post" action="${re.contextPath}/register" class="layui-form">
        <input name="username" id="username" placeholder="手机号" autocomplete="off" type="text" lay-verify="username"
               class="layui-input">
        <hr class="hr15">
        <input name="password" lay-verify="password" placeholder="密码" autocomplete="off" type="password"
               class="layui-input">
        <hr class="hr15">
        <input name="verifyPassword" lay-verify="verifyPassword" placeholder="确认密码" autocomplete="off" type="password"
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
                <input type="button" id="register_box" value="发送验证码"/>
            </div>
        </div>
        <hr class="hr15">
        <div style="display: flex;justify-content: space-between;">
            <input value="注册" lay-submit lay-filter="login" style="width:45%;" type="submit">
            <input type="button" id="register" class="layui-btn layui-btn-primary"
                   onclick="window.location.href='${re.contextPath}/login'" value="返回登录"/>
        </div>
        <hr class="hr20">
    </form>
</div>
<script>
    var layer;
    $(function () {
        layui.use(['form', 'layer'], function () {
            $ = layui.jquery;
            var form = layui.form;

            form.verify({
                username: [/^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$/, '手机号码格式有误']
                , password: [/(.+){6,12}$/, '密码必须6到12位']
                , verifyPassword: function (value) {
                    if ($('#password').val() != $('#verifyPassword').val()) {
                        return '两次密码不一致';
                    }
                }, code: function (v) {
                    if (v.trim() == '') {
                        return '验证码不能为空';
                    }
                }
            });


            $('#register_box').click(function () {
                var username = $("#username").val();
                if(/^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$/.test(username)){
                    sendMessage();
                }else{
                    layer.msg("手机号码格式有误", {icon: 5, anim: 6, offset: 't'});
                }

            });

            form.render();
        });

        layer = layui.layer;
        var msg = '${message}';
        if (msg.trim() != "") {
            layer.msg(msg, {icon: 5, anim: 6, offset: 't'});
        }
    });

    //验证码发送
    var InterValObj; //timer变量，控制时间
    var count = 60; //间隔函数，1秒执行
    var curCount;//当前剩余秒数
    function sendMessage() {
        curCount = count;
        var dealType; //验证方式
        //设置button效果，开始计时
        $("#register_box").attr("disabled", "true");
        $("#register_box").val(+curCount + "秒再获取");
        InterValObj = window.setInterval(SetRemainTime, 1000); //启动计时器，1秒执行一次
        var username = $("#username").val();
        //处理验证
        $.post({
            url: '${re.contextPath}/sendSms',
            contentType: 'application/json',
            data: JSON.stringify({username: username}),
            success: function (data) {
                layer.msg(data.msg, {icon: 6, anim: 6, offset: 't'});
            }, error: function () {
                layer.msg("系统错误", {icon: 5, anim: 6, offset: 't'});
            }
        });
    }

    //timer处理函数
    function SetRemainTime() {
        if (curCount == 0) {
            window.clearInterval(InterValObj);//停止计时器
            $("#register_box").removeAttr("disabled");//启用按钮
            $("#register_box").val("重新发送验证码");
        } else {
            curCount--;
            $("#register_box").val(+curCount + "秒再获取");
        }
    }

    /*var countdown = 60;

    function settime(obj) { //发送验证码倒计时
        if (countdown == 0) {
            obj.attr('disabled', false);
            //obj.removeattr("disabled");
            obj.val("发送验证码");
            countdown = 60;
            var username = $("#username").val();
            $.ajax({
                url: "${re.contextPath}/sendSms",
                date: JSON.stringify({username: username}),
                type: "post",
                dateType: "json",
                cusses: function (data) {
                    if (data == '1') {
                        alert("发送成功");
                    }
                }
            });
            return;
        } else {
            obj.attr('disabled', true);
            obj.val("已发送(" + countdown + ")");
            countdown--;
        }
        setTimeout(function () {
                settime(obj)
            }
            , 1000)
    }*/
</script>


<!-- 底部结束 -->
</body>
</html>
