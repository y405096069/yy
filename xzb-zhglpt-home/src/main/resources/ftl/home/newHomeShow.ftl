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
    <title>首页</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <link rel="stylesheet" href="${re.contextPath}/plugin/layui/css/layui.css">
    <script type="text/javascript" src="${re.contextPath}/plugin/jquery/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${re.contextPath}/plugin/tools/tool.js"></script>
    <!--<script type="text/javascript" src="${re.contextPath}/plugin/common/js/echarts.js"></script>
    <script type="text/javascript" src="${re.contextPath}/ftl/section/layui/layui.js"
            charset="utf-8"></script>-->
    <script type="text/javascript" src="${re.contextPath}/plugin/layui/layui.all.js"
            charset="utf-8"></script>
    <style>
        tbody td {
            cursor: pointer;
        }

        .overflow {
            table-layout: fixed;
        }

        .overflow td {
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
        }
        .layui-content{
            padding: 40px 40px;
            display: flex;
            justify-content: space-around;
            align-items: center;
        }
        .layui-table{
            text-align: center;
            width: 30%;
        }
         .layui-table thead tr th {
            text-align: center;
            background-color: #009688;
            color: #fff;
         }
    </style>
</head>
<body style="background-color:#f2f2f2;">
<div class="layui-row">
    <div class="layui-content">
         <table class="layui-table">
            <thead>
                <tr>
                    <th>最新考生注册账号</th>
                </tr> 
            </thead>
            <tbody>
                <tr>
                    <td>张政</td>
                </tr>
                  <tr>
                    <td>李家凡</td>
                </tr>
                  <tr>
                    <td>林子成</td>
                </tr>
                  <tr>
                    <td>王怡志</td>
                </tr>
                  <tr>
                    <td>林文雨</td>
                </tr>
            </tbody>
        </table>
         <table class="layui-table">
            <thead>
                <tr>
                    <th>最新待审核信息采集的报考考生</th>
                </tr> 
            </thead>
            <tbody>
                <tr>
                    <td>王峻熙</td>
                </tr>
                <tr>
                    <td>李煜城</td>
                </tr>
                <tr>
                    <td>严正明</td>
                </tr>
                <tr>
                    <td>张伶边</td>
                </tr>
                <tr>
                    <td> 张素珍</td>
                </tr>
            </tbody>
        </table>
         <table class="layui-table">
            <thead>
                <tr>
                    <th>最新缴费报名成功的考生</th>
                </tr> 
            </thead>
            <tbody>
                <tr>
                    <td>车路</td>
                </tr>
                <tr>
                    <td>何云霞</td>
                </tr>
                <tr>
                    <td>吴莎莎</td>
                </tr>
                <tr>
                    <td>李明杰</td>
                </tr>
                <tr>
                    <td>吴娟</td>
                </tr>
            </tbody>
        </table>
    </div>
     <div class="layui-content">
         <table class="layui-table">
            <thead>
                <tr>
                    <th>最新管理员通知公告</th>
                </tr> 
            </thead>
            <tbody>
                <tr>
                    <td>通知1</td>
                </tr>
                  <tr>
                    <td>通知2</td>
                </tr>
                  <tr>
                    <td>通知3</td>
                </tr>
                  <tr>
                    <td>通知4</td>
                </tr>
                  <tr>
                    <td>通知5</td>
                </tr>
            </tbody>
        </table>
         <table class="layui-table">
            <thead>
                <tr>
                    <th>最新的考试</th>
                </tr> 
            </thead>
            <tbody>
                <tr>
                    <td>体育考试</td>
                </tr>
                <tr>
                    <td>美术考试</td>
                </tr>
                <tr>
                    <td>语文考试</td>
                </tr>
                <tr>
                    <td>高数考试</td>
                </tr>
                <tr>
                    <td>英语考试</td>
                </tr>
            </tbody>
        </table>
         <table class="layui-table">
            <thead>
                <tr>
                    <th>我的日志</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><a href="">2020年节假日安排</a></td>
                </tr>
                <tr>
                    <td><a href="http://www.w3school.com.cn">江疏影跪地合影</a></td>
                </tr>
                <tr>
                    <td>值班日志的主要内容</td>
                </tr>
                <tr>
                    <td>生产技术部对值班日志记录内容的统一要求</td>
                </tr>
                <tr>
                    <td>值班日志</td>
                </tr>
            </tbody>
        </table>
    </div>
</div>

</body>
<script type="text/javascript">

</script>
</html>
