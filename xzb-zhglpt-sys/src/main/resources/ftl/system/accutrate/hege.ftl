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
    <title>合格证</title>
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
        .pupop {
            position: relative;
            overflow: hidden;
            width: 700px;
            margin: 0 auto;
            padding: 40px 40px 0 40px;
            min-height:480px;
            border: 1px solid #000;
            box-sizing: border-box;
            background-color: #fff;
        }
        .pupop-box {
            position: relative;
            z-index: 11;
        }
        .pupop_content{
            display: flex;
            align-items: center;
            justify-content: space-between;
            padding: 0 10px;
            box-sizing: border-box;
        }

        .pupop_content .content_left{
            box-sizing: border-box;
            display: flex;
            flex-direction: column;
            height: 200px;
        }
        .pupop_content .content_left p {
            line-height: 30px;
        }
        .pupop_content .content_left p span {
            min-width: 120px;
            display: inline-block;
        }
        .pupop_content .content_right {
            display: flex;
            flex-direction: column;
        }
        .pupop_content .content_right_top, .content_right_bottom{
            width: 100px;
            height: 100px;
            border: 1px solid #000;
            text-align:center;
            line-height: 100px;
            margin-top: 20px;
        }
        .pupop .matter {
            margin-top: 10px;
            padding: 20px 10px 20px 10px;
        }
        .pupop .matter ul li {
            line-height: 25px;
        }
        .pupop .layui-table td {
            padding: 20px 13px;
        }
        .pupop .layui-table th {
            text-align: center;
        }
    </style>
</head>
<body style="background-color:#f2f2f2;">
<div class="layui-row layui-form-pane">
    <div style="text-align: center;width: 700px; margin: 0 auto;">
        <input type="text" value="广州大学2019年语文类校考合格证" style="width: 60%;height:50px;text-align:center;font-size: 20px;border: none;margin: 0 auto;"/>
    </div>

    <div class="pupop" style="background-size: 50%;">
        <div class="pupop-box">
            <div style="text-align: center;width: 100%;">
                <input type="text" value="广州大学2019年语文类校考合格证" style="background: center;width: 60%;height:50px;text-align:center;size:32px;border: 1px dashed #000;margin: 0 auto;"/>
            </div>
            <div class="pupop_content">
                <div class="content_left">
                    <p><span>姓名: xx</span><span style="margin-left: 100px;">生源地: xxx省</span></p>
                    <p><span>报考专业: 语文</span><span style="margin-left: 100px;">考试时间: 2019-01-01</span></p>
                    <p><span>准考证号: xxxxxxxxxxx</span></p>
                    <p><span>身份证号: xxxxxxxxxxx</span></p>
                    <p><span>考生号: xxxxxxxxxxx</span></p>
                    <p><span>合格情况: 合格</span></p>
                </div>
                <div class="content_right">
                    <div class="content_right_top">
                        <p>正面照</p>
                    </div>
                    <div class="content_right_bottom" style="margin-top: 10px;margin-bottom: 10px;">
                        <p> 二维码</p>
                    </div>
                </div>
            </div>
            <div class="matter">
                <ul>
                    <li>备注说明: </li>
                    <li>（1）xxxxxxxxxxxxxxxxxxxxxxxxxx</li>
                    <li>（2）xxxxxxxxxxxxxxxxxxxxxxxxxx</li>
                    <li>（3）xxxxxxxxxxxxxxxxxxxxxxxxxx</li>
                </ul>
            </div>
        </div>

    </div>
        <div style="display: flex;justify-content: center;align-items: center;min-height: 60px;">
            <button id="btn" style="width: 150px;height: 40px;margin-left: 0px;" type="button" class="layui-btn">打印合格证</button>
        </div>
</div>
<script>
    layui.use('upload', function(){
        var form = layui.form
        ,upload = layui.upload
        form.render();

        upload.render({
            elem: '#test10'
            , url: ''
            ,success: function(res) { //上传成功后的回调
                console.log(res)
            },
            error: function(res) {
                console.log(res)
            }
        });

    })

</script>
</body>

</html>
