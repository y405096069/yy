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
            margin: 70px 0 50px 0;
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
        .layui-row .layui-table-box .layui-table .red{
            color:red;
        }
        .layui-row .layui-table-box .layui-table .blue{
            color:blue;
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
        <div style="height: 4%;">
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
        <div class="layui-table-box">
            <table class="layui-table">
                <colgroup>
                    <col width="220">
                    <col width="200">
                    <col>
                </colgroup>
                <thead>
                    <tr>
                    <th>创建时间</th>
                    <th>信息采集</th>
                    <th>缴费状态</th>
                    <th>报名状态</th>
                    <th>准考证</th>
                    </tr> 
                </thead>
                <tbody>
                    <tr>
                    <td>2019/01/01/ 14：59：00</td>
                    <td>英语</td>
                    <td class="blue">缴费成功</td>
                    <td>报名成功</td>
                    <td class="red">查看</td>
                    </tr>
                </tbody>
                <thead>
                    <tr>
                    <th>考试名称</th>
                    <th>考试金额</th>
                    <th>专业名称</th>
                    <th>专业代码</th>
                    <th>考试成绩</th>
                    </tr> 
                </thead>
                <tbody>
                    <tr>
                    <td>语文考试</td>
                    <td>100</td>
                    <td>跑步</td>
                    <td>100101</td>
                    <td class="red">查看</td>
                    </tr>
                </tbody>
            </table>
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
