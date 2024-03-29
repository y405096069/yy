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
    <title>报名成功</title>
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
        .layui-row{
            display: flex;
            height: 100%;
            flex-direction: column;
        }
        .layui-row .layui-content{
            width: 1000px;
            flex: 1;
            margin: 0 auto;
            padding: 20px 0;
            box-sizing: border-box;
        }
        .layui-row .layui-content .layui-table th,td {
            text-align: center;
        }
        .layui-row .layui-content .step-body {
            margin: 30px 0;
        }
        .layui-row .layui-content .layui-table-box {
            min-height: 200px;
        }
        .layui-row .layui-content .matter {
            width: 800px;
            font-size: 14px;
            line-height: 25px;
            margin: 20px auto;
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
    <div class="layui-content">
        <div id="step_demo" class="step-body">
            <div class="step-header" style="width:80%;overflow: hidden;">
                <ul>
                    <li>
                        <span class="step-name">基本信息</span>
                    </li>
                    <li>
                        <span class="step-name">选择报考</span>
                    </li>
                    <li>
                        <span class="step-name">信息采集</span>
                    </li>
                    <li>
                        <span class="step-name">网上缴费</span>
                    </li>
                    <li>
                        <span class="step-name">报名成功</span>
                    </li>
                </ul>
            </div>
            <div class="step-content">
                <div class="step-list"></div>
                <div class="step-list"></div>
                <div class="step-list"></div>
                <div class="step-list"></div>
                <div class="step-list"></div>
            </div>
        </div>

        <#--  <button id="preBtn">上一步</button>
        <button id="nextBtn">下一步</button>
        <button id="goBtn">跳转的指定的步骤</button>  -->
        <div class="layui-table-box">
            <table class="layui-table">
                <colgroup>
                    <col width="150">
                    <col width="200">
                    <col>
                </colgroup>
                <thead>
                    <tr>
                    <th>考试名称</th>
                    <th>专业</th>
                    <th>缴费状态</th>
                    <th>报名状态</th>
                    <th>缴费金额</th>
                    </tr> 
                </thead>
                <tbody>
                    <tr>
                    <td>艺术考试</td>
                    <td>钢琴</td>
                    <td>缴费成功</td>
                    <td>报名成功</td>
                    <td>500</td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div style="display: flex;justify-content: center;align-items: center;height: 20%;">
            <button style="width: 150px;height: 40px;" type="button" class="layui-btn">报考查询</button>
            <button style="width: 150px;height: 40px;" type="button" class="layui-btn layui-btn-primary" onclick="location.href='${re.contextPath}/studentInformation/getStudentIndex';">返回首页</button>
        </div>
        <div class="matter">
            <ul>
                <li>注意事项：</li>
                <li>（1）请考生在考前5天打印准考证，最迟在考前1天完成准考证打印，勿在测试当天打印。</li>
                <li>（2）按准考证上规定时间到指定的考试地点候考，切勿走错考场。</li>
                <li>（3）请考生携带二代身份证、准考证按时到考场报到，迟到15分钟取消考试资格。</li>
            </ul>
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
    layui.use(['jquery', 'steps'], function(){

        var $ = layui.$;

        var $step= $("#step_demo").step();

        $("#preBtn").click(function(event) {
            $step.preStep();//下一步
        });

        $("#nextBtn").click(function(event) {
            $step.nextStep();//下一步
        });
            $step.goStep(5);//到指定步
    });
</script>
</body>

</html>
