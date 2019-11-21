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
        .layui-row .layui-content .img01 {
            height: 80%;
            width: 80%;
        }
        .layui-row .layui-content .img01 img {
            position:absolute;
            clip: rect(138px 1200px 700px 0px);
        }

    </style>
</head>
<body style="background-color:#f2f2f2;">
<div class="layui-row layui-form-pane">
    <div class="layui-content">
        <div class="img01">
            <img src="http://images2015.cnblogs.com/blog/422101/201609/422101-20160906162047816-1209809823.png">
        </div>
        <div style="display: flex;justify-content: center;align-items: center;height: 20%;">
<#--            <button style="width: 150px;height: 40px;" type="button" class="layui-btn layui-btn-primary" onclick="informationAction()">返回</button>-->
            <button style="width: 150px;height: 40px;position: absolute;bottom: 334px;right: 209px;opacity: 0;" type="button" class="layui-btn layui-btn-primary" onclick="location.href='${re.contextPath}/studentInformation/getSucceed';">下一步</button>
        </div>
    </div>
    <form class="layui-form" id="confirm" style="display:none">
        <div style="text-align: center;font-size: 24px;padding: 20px 20px 36px 20px;">
            支付成功
        </div>
    </form>
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

    function informationAction() {
        layui.use(['layer'], function(){
             var zsjz = layer.open({
                type:1,
                area:['200px','200px'],
                title: '支付成功',
                content: $("#confirm"),
                shade: 0,
                isOutAnim: true,
                anim: -1,
                btn: '返回',
                btn1: function(index, layero){
                    layer.close(zsjz);
                },
                cancel: function(layero,index){ 
                    layer.closeAll();
                }
            }); 
        }); 
    }
</script>
</body>

</html>
