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
        .layui-row .layui-content{
            width: 1000px;
            min-height: 600px;
            margin: 0 auto;
            padding: 20px 0;
            box-sizing: border-box;
        }
        .layui-row .layui-content .layui-table {
            margin-bottom: 30px;
        }
        .layui-row .layui-content .layui-table td {
            text-align: center;
        }
        .layui-row .layui-content .layui-table th {
            text-align: center;
            background-color: seagreen;
            color: #fff;
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
        .layui-row .layui-table-box .layui-table .black{
            color:black;
        }
        .layui-row .layui-table-box .layui-table .blue{
            color:deepskyblue;
        }
        .layui-row .layui-table-box .layui-table .link {
            color: mediumblue;
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
                    <col>
                    <col>
                    <col>
                </colgroup>
                <thead>
                    <tr>
                    <th>创建时间</th>
                    <th>信息采集</th>
                    <th>初试缴费状态</th>
                    <th>复试缴费状态</th>
                    <th>初试报名状态</th>
                    <th>复试报名状态</th>
                    <th>准考证</th>
                    <th>合格证</th>
                    <th>初试入围状态查询</th>
                    <th>复试入围状态查询</th>
                    </tr> 
                </thead>
                <tbody>
                    <tr>
                    <td>${DQtime}</td>
                    <td>${audit.info_collect_status}</td>
                    <td class="blue" onclick="location.href='${re.contextPath}/studentInformation/getPayFees';">${audit.pay_status}</td>
                    <td class="black">${audit.re_pay_status}</td>
                    <td class="black">${audit.audit_status}</td>
                        <td class="black">${audit.re_audit_status}</td>
                    <td class="link" onclick="location.href='${re.contextPath}/studentInformation/getAdmissionTicket';">查看</td>
                    <td class="link" onclick="location.href='${re.contextPath}/studentInformation/getCertificateQualification';">查看</td>
                    <td class="link">${audit.qualified_mark}</td>
                    <td class="link">${audit.re_qualified_mark}</td>
                    </tr>
                </tbody>
                <thead>
                    <tr>
                    <th>考试名称</th>
                    <th>专业名称</th>
                    <th>初试考试金额</th>
                    <th>复试考试金额</th>
                    <th>专业代码</th>
                    <th>初试考试成绩</th>
                    <th>初试考试成绩排名</th>
                    <th>复试考试成绩</th>
                    <th>复试考试成绩排名</th>
                        <th></th>
                    </tr> 
                </thead>
                <tbody>
                    <tr>
                    <td>${a_sum.exam_name}</td>
                    <td>${a_sum.professional_name}</td>
                    <td>${ex2.prcie}</td>
                    <td>${ex2.retestPrcie}</td>
                    <td>${a_sum.professional_code}</td>
                    <td class="link">${a_sum.first_subjects_total}</td>
                    <td class="link">${a_sum.provincial_ranking}</td>
                    <td class="link">${a_sum.total_score}</td>
                    <td class="link">${a_sum.re_provincial_ranking}</td>
                        <td class="link"></td>
                    </tr>
                </tbody>
            </table>
<#--              <table class="layui-table">-->
<#--                <colgroup>-->
<#--                    <col>-->
<#--                    <col>-->
<#--                    <col>-->
<#--                </colgroup>-->
<#--                <thead>-->
<#--                    <tr>-->
<#--                    <th>创建时间</th>-->
<#--                    <th>信息采集</th>-->
<#--                    <th>初试缴费状态</th>-->
<#--                    <th>复试缴费状态</th>-->
<#--                    <th>报名状态</th>-->
<#--                    <th>准考证</th>-->
<#--                    <th>合格证</th>-->
<#--                    <th>入围名单查询</th>-->
<#--                    <th></th>-->
<#--                    </tr> -->
<#--                </thead>-->
<#--                <tbody>-->
<#--                    <tr>-->
<#--                    <td>2019/01/01/ 14:59:00</td>-->
<#--                    <td>审核成功</td>-->
<#--                    <td class="red">待审核</td>-->
<#--                    <td class="blue">待支付</td>-->
<#--                    <td class="green">报名完成</td>-->
<#--                    <td class="link">查看</td>-->
<#--                    <td class="link">查看</td>-->
<#--                    <td class="link">查看</td>-->
<#--                    <td></td>-->
<#--                    </tr>-->
<#--                </tbody>-->
<#--                <thead>-->
<#--                    <tr>-->
<#--                    <th>考试名称</th>-->
<#--                    <th>专业名称</th>-->
<#--                    <th>初试考试金额</th>-->
<#--                    <th>复试考试金额</th>-->
<#--                    <th>专业代码</th>-->
<#--                    <th>初试考试成绩</th>-->
<#--                    <th>初试考试成绩排名</th>-->
<#--                    <th>复试考试成绩</th>-->
<#--                    <th>复试考试成绩排名</th>-->
<#--                    </tr> -->
<#--                </thead>-->
<#--                <tbody>-->
<#--                    <tr>-->
<#--                    <td>体育</td>-->
<#--                    <td>篮球</td>-->
<#--                    <td>100</td>-->
<#--                    <td>200</td>-->
<#--                    <td>8866</td>-->
<#--                    <td class="link">显示成绩</td>-->
<#--                    <td class="link">显示排名</td>-->
<#--                    <td class="link">显示成绩</td>-->
<#--                    <td class="link">显示排名</td>-->
<#--                    </tr>-->
<#--                </tbody>-->
<#--            </table>-->
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
