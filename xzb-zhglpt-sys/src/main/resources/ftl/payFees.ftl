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
    <title>报名缴费</title>
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
        .layui-row .layui-content .step-body {
            margin: 30px 0;
        }
        .layui-row .layui-content .layui-table {
            margin-top: 80px;
        }
        .layui-row .layui-form .layui-header {
            background-color: #dedede;
            color: red;
            padding: 10px;
            box-sizing: border-box;
        }
        .pad {
            min-height: 200px;
            padding: 20px 10px;
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
        .footbuttom {
            width: 80%;
            margin: 30px auto;
            display: flex;
            justify-content: space-around;
        }
        #buttonSub {
            cursor: pointer;
            width: 150px;
            height: 50px;
            background-color: dodgerblue;
            border: none;
            outline: none;
            color: #fff;
            border-radius: 5px;
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
            <div style="height: 8%;">
                <button style="width: 150px;height: 40px;" type="button" class="layui-btn layui-btn-primary" onclick="location.href='${re.contextPath}/studentInformation/getStudentIndex';">返回首页</button>
            </div>
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
            <table class="layui-table">
                <colgroup>
                    <col width="350">
                    <col width="400">
                    <col>
                </colgroup>
                <thead>
                    <tr>
                    <th>报考考试名称</th>
                    <th>报考专业</th>
                    <th>报名费/￥</th>
                    </tr> 
                </thead>
                <tbody>
                    <tr>
                    <td>艺术考试</td>
                    <td>钢琴</td>
                    <td>500</td>
                    </tr>
                </tbody>
            </table>
            <div>
                <div class="footbuttom">
                    <button style="width: 150px;height: 40px;" type="button" class="layui-btn" onclick="location.href='${re.contextPath}/studentInformation/getPayment';">去支付</button>
                </div>
                <#--  <button style="width: 150px;height: 40px;" type="button" class="layui-btn">去支付</button>  -->
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

    layui.use(['jquery', 'steps', 'form'], function(){

        var $ = layui.$;
        var $step= $("#step_demo").step();
        $step.goStep(4);//到指定步
        var form = layui.form
        form.render();

        
        $.ajax({
            type:"post",
            data:{
                id: 142
            },
            url:"http://fw135.com:8084/creaUserTemplate/outUserZFsj",
            error:function(){
                //alert("执行失败了!");
            },
            success:function(data){
                alert("成功啦？");
            }
        });
    });


</script>
</body>
</html>
