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
    <title>选择报考</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <link rel="stylesheet" href="${re.contextPath}/plugin/layui/css/layui.css">
    <link rel="stylesheet" href="${re.contextPath}/plugin/layui/extend/steps/style.css">
    <script type="text/javascript" src="${re.contextPath}/plugin/jquery/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${re.contextPath}/plugin/layui/layui.all.js" charset="utf-8"></script>
    <script type="text/javascript" src="${re.contextPath}/plugin/tools/tool.js"></script>
    <script type="text/javascript" src="${re.contextPath}/plugin/layui/config.js"></script>
    <style>
        html, body {
            height: 100%;
        }
        .layui-row .layui-content{
            width: 1000px;
            flex: 1;
            margin: 0 auto;
            padding: 20px 0;
            box-sizing: border-box;
            min-height: 560px;
        }
        .haeader-content {
            width: 100%;
            background-color: #009688;
            color: #333;
            text-align: center;
        }
        .footer-content {
            width: 100%;
            background-color: #009688;
            color: #333;
            height: 120px;
            text-align: center;
            padding: 15px 0;
            box-sizing: border-box;
        }
        .footer-content .footer {
            width: 666px;
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
        .layui-content .about_content {
            margin: 0 auto;
        }
        .layui-content .about_content h1 {
            text-align: center;
        }
        .layui-content .about_content .enrolment_charter {
            margin-top: 20px;
        }
        .layui-content .about_content .details {
            height: 50px;
            border-bottom: 1px solid black;
            display: flex;
            justify-content: space-between;
            align-items: center;
            align-self: center;

        }
        .layui-content .about_content .more {
            margin-top: 20px;
            text-align: right;
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
    <div class="layui-content">
        <div style="height: 4%;margin-bottom: 100px;">
            <button style="width: 150px;height: 40px;" type="button" class="layui-btn layui-btn-primary" onclick="location.href='${re.contextPath}/studentIndex'">返回首页</button>
        </div>
        <div class="about_content">
            <h1>报名公告</h1>
            <div>
                <#list appList as spe>
                    <div class="enrolment_charter">
                        <div class="details">
                            <div>
                                ${spe.caption}
                            </div>
                            <div>
                                <#--<input type="text" class="layui-input" id="createTime" value="${spe.createTime}" placeholder="yyyy-MM-dd HH:mm:ss">-->
                                ${(spe.createTime)?string("yyyy-MM-dd HH:mm:ss")}
                            </div>
                        </div>
                    </div>
                </#list>
            </div>
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
</div>

<script>



</script>
</body>

</html>
