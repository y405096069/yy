<#-- Created by IntelliJ IDEA.
 User: Administrator
 Date: 2017/12/6
 Time: 14:00
 To change this template use File | Settings | File Templates.
 切片管理-->
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>学生端首页</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <link rel="stylesheet" href="${re.contextPath}/plugin/layui/css/layui.css">
    <script type="text/javascript" src="${re.contextPath}/plugin/jquery/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${re.contextPath}/plugin/layui/layui.all.js" charset="utf-8"></script>
    <script type="text/javascript" src="${re.contextPath}/plugin/tools/tool.js"></script>
    <style>
        html, body {
            height: 100%;
        }
        .layui-row{
            display: flex;
            height: 100%;
            flex-direction: column;
        }
        #home_content {
            width: 1200px;
            flex: 1;
            margin: 0 auto;
        }
        .personal {
            width: 700px;
            height: 150px;
            margin: 0 auto;
        }
         .personal .personal_content .login_user {
            font-size: 18px;
            font-weight: bold;
            display: flex;
            align-items: center;
            align-self: center;
            justify-content: space-between;
        }
        .personal .personal_content .personal_center {
            color: #009688;
            display: flex;
            align-items: center;
            align-self: center;
            justify-content: center;
        }
        .personal .personal_content .personal_center i {
            font-size: 24px;
            margin-right: 5px;
        }
        .personal_right {
            width: 500px;
            display: flex;
            align-items: center;
            align-self: center;
            justify-content: space-around;
        }
        .personal_right .notice {
            padding: 5px 10px;
            cursor: pointer;
        }
        .personal_right .youself {
            display: flex;
            align-items: center;
            align-self: center;
            justify-content: space-around;
        }
        .personal_right .youself i {
            font-size: 24px;
            color: #009688;
        }
        .personal_right .back {
            cursor: pointer;
        }
        .school_notice {
            height: 50px;
            line-height: 50px;
            text-align: left;
        }
        .main-content .main-register {
            width: 800px;
            margin: 0 auto;
            display: flex;
            align-items: center;
            align-self: center;
            justify-content: space-around;
        }

        .main-land,
        .main-enroll,
        .main-seek {
            width: 180px;
            height: 160px;
            background-color: #fff;
            box-shadow: 2px 2px 5px #888888;
            text-align: center;
            cursor: pointer;
        }
        .main-img {
            width: 80px;
            margin: 20px auto;
            background-color: #009688;
            height: 80px;
            border-radius: 50%;
            display: flex;
            justify-content: center;
            align-items: center;
            align-self: center;
        }
        .main-img i {
            color: #fff;
            font-size: 40px;
        }
        .main-img img {
            width: 100%;
        }
        .main-content .main-register p {
            color: #009688;
            font-weight: bold;
        }

        .registration-information {
            width: 700px;
            margin: 0 auto;
            padding-top: 50px;
            font-size: 14px;
            font-family: "微软雅黑";
            text-align: center;
        }
        .registration-informationh4 {
            font-size: 16px;
            margin: 15px 0 10px 0;
        }
        .registration-information div {
            line-height: 25px;
        }
        .main-button {
            width: 700px;
            margin: 30px auto;
            display: flex;
            align-items: center;
            align-self: center;
            justify-content: space-around;
        }
        .main-button button {
            color: #fff;
            background-color: #009688;
            border-radius: 25px;
            padding: 16px 25px;
            border: none;
        }
        .haeader-content, .footer-content {
            width: 100%;
            background-color: #009688;
            color: #333;
            height: 120px;
            text-align: center;
        }
        .footer-content .footer {
            width: 666px;
            padding-top: 15px;
            font-size: 14px;
            margin: 0 auto;
            color: white;
            overflow: hidden;
        }
        .footer-content p {
            text-align: left;
        }
        .haeader-content .logo {
            height: 100%;
            width: 100px;
            display: flex;
            justify-content: center;
            align-items: center;
            align-self: center;
            margin-left: 20%;
        }
        .haeader-content .title {
            line-height: 120px;
        }
        .haeader-content .title .title-name {
            font-family: "微软雅黑";
            color: white;
            font-size: 30px;
        }
    </style>
</head>
<body style="background-color:#f2f2f2;">
    <div class="layui-row layui-form-pane">
        <div class="haeader-content">
            <div class="header">
                <div class="logo">
                    <#--  <img src="./img/logo.png" alt />  -->
                </div>
                <div class="title">
                    <div class="title-name">广州大学考试管理系统</div>
                </div>
            </div>
        </div>
        <div id="home_content">
            <div class="personal">
                <div class="personal_content">
                    <div class="login_user">
                        <div class="personal_center">
                            <i class="el-icon-s-tools"></i>
                            <div style="cursor: pointer;">修改密码</div>
                        </div>
                        <div class="personal_right">
                        <div class="youself">
                            <i class="el-icon-user-solid"></i>
                            <div class="title">学生,你好！</div>
                        </div>
                            <div class="back" onclick="window.location.href='${re.contextPath}/out'">退出</div>
                        </div>
                    </div>
                    <div class="school_notice"></div>
                </div>
            </div>
            <div class="main-content">
                <div class="main-register">
                    <div class="main-enroll" onclick="internetExam()">
                        <div class="main-img" >
                        <!-- 图片选择 -->
                            <i class="layui-icon">&#xe612;</i> 
                        <#--  <img src="./img/u5.png" alt />  -->
                        </div>
                        <#--  <p>登陆</p>  -->
                        <p>基本信息</p>
                    </div>
                    <div class="main-land" onclick="informationAction()">
                        <div class="main-img">
                            <i class="layui-icon">&#xe642;</i> 
                        <#--  <img src="./img/u5.png" alt />  -->
                        </div>
                        <p>网上报考</p>
                    </div>
                    <div class="main-seek" onclick="location.href='${re.contextPath}/studentInformation/getExamQuary';">
                        <div class="main-img">
                            <i class="layui-icon">&#xe60f;</i>
                        <!-- 图标选择 -->
                        <#--  <img src="./img/u15.png" alt />  -->
                        </div>
                        <p>报考查询</p>
                    </div>
                </div>
            </div>
            <div class="registration-information">
                <h4>报考须知</h4>
                <div>本业务由广州大学招生办决定。</div>
                <div>本业务由广州大学招生办决定本业务由广州大学招生办决定。</div>
                <div>本业务由广州大学招生办决定本业务由广州大学招生办决定本业务由广州大学招。</div>
            </div>
            <div class="main-button">
                <button round style="cursor: pointer;" onclick="location.href='${re.contextPath}/enrolmentCharter/showStuEnrolmentCharter';">招生章程</button>
                <button round style="cursor: pointer;" onclick="location.href='${re.contextPath}/applicationAnnoun/showStuApplicationAnnoun'">报名公告</button>
                <button style="white-space: unset;cursor: pointer;padding:8px 25px;width:116px;" round onclick="location.href='${re.contextPath}/onlineExercises/showStuOnlineExercises'">网上报名操作实例</button>
            </div>
        </div>
        <div class="footer-content">
            <div class="footer">
                <p>其他说明：</p>
                <p>1.本业务由广州大学招生办公室决定。</p>
                <p>
                2.大学城一卡通联系电话：400-830-008，招生办电话：020-39366232.反馈邮箱：zhaosb@gzhu.edu.cn;
                </p>
                <p>
                3.其他事项请浏览招生办招生专题网站(http://zsjy.gzhu.edu.cn),或关注“广大招生”微信公众号查看历史推文。
                </p>
            </div>
        </div>
        <form class="layui-form" id="test1" style="display:none">
            <div style="line-height: 120px;text-align:center;"><h2>点击确定将开始新的报名流程</h2></div>
            <div style="display: flex;justify-content: center;align-items: center;min-height: 80px;">
                <button id="btn" style="width: 150px;height: 40px;" type="button" class="layui-btn" onclick="location.href='${re.contextPath}/studentInformation/getBasicInformation';">确认</button>
                <button style="width: 150px;height: 40px;" type="button" class="layui-btn layui-btn-primary" onclick="removeAction()">取消</button>
            </div>
        </form>
        <form class="layui-form" id="test2" style="display:none">
            <div style="line-height: 120px;text-align:center;"><h2>点击确认将进入报考流程</h2></div>
                 <div style="display: flex;justify-content: center;align-items: center;min-height: 80px;">
                <button id="btn" style="width: 150px;height: 40px;" type="button" class="layui-btn" onclick="location.href='${re.contextPath}/studentInformation/getOnlineExamination';">确认</button>
                <button style="width: 150px;height: 40px;" type="button" class="layui-btn layui-btn-primary" onclick="removeAction()">取消</button>      
            </div>
        </form>
    </div>
<script>
    function informationAction() {
        layui.use(['layer'], function(){
            layer.open({
                type:1,
                area:['500px','300px'],
                title: '报考流程',
                content: $("#test2"),
                shade: 0,
                isOutAnim: true,
                anim: -1,
                yes: function(index, layero){
                    //do something
                    layer.close(index); //如果设定了yes回调，需进行手工关闭
                },
                cancel: function(layero,index){ 
                    layer.closeAll();
                }
            }); 
        }); 
    }
    function removeAction() {
        console.log(111)
         layui.use(['layer'], function(){
                layer.closeAll();
        }); 
    }
    function internetExam() {
        layui.use(['layer'], function(){
            layer.open({
                type:1,
                area:['500px','300px'],
                content: $("#test1"),
                shade: 0,
                isOutAnim: true,
                anim: -1,
                yes: function(index, layero){
                    //do something
                    layer.close(index); //如果设定了yes回调，需进行手工关闭

                },
                cancel: function(layero,index){
                    layer.closeAll();
                }
            });
        });
    }


    function Enrol() {


    }
</script> 
</body>

</html>
