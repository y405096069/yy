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
    <title>准考证</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <link rel="stylesheet" href="${re.contextPath}/plugin/layui/css/layui.css">
    <script type="text/javascript" src="${re.contextPath}/plugin/jquery/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${re.contextPath}/plugin/tools/tool.js"></script>
    <script type="text/javascript" src="${re.contextPath}/plugin/layui/layui.all.js" charset="utf-8"></script>
    <style>
        html, body {
            height: 100%;
        }

        .layui-row {
            display: flex;
            height: 100%;
            flex-direction: column;
        }

        .pupop {
            width: 700px;
            margin: 0 auto;
            padding: 40px 40px 0 40px;
            min-height: 680px;
            border: 1px solid #000;
            box-sizing: border-box;
            background-color: #fff;
        }

        .pupop_content {
            display: flex;
            align-items: center;
            justify-content: space-between;
            padding: 0 10px;
            box-sizing: border-box;
        }

        .pupop_content .content_left {
            box-sizing: border-box;
            display: flex;
            flex-direction: column;
            height: 200px;
        }

        .pupop_content .content_left p {
            line-height: 50px;
        }

        .pupop_content .content_right {
            display: flex;
            flex-direction: column;
        }

        .pupop_content .content_right_top, .content_right_bottom {
            width: 100px;
            height: 100px;
            border: 1px solid #000;
            text-align: center;
            line-height: 100px;
            margin-top: 20px;
        }

        .pupop .layui-table {
        }

        .pupop .matter {
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

<form class="layui-form layui-form-pane" style="margin: 20px;">
    <div class="layui-row layui-form-pane">
        <div style="text-align: center;width: 700px; margin: 0 auto;">
            <div class="layui-form-item"><input type="text" id="templateName" autocomplete="off" class="layui-input"
                                                lay-verify="templateName" name="templateName" value="模板名称"
                                                style="width: 60%;height:50px;text-align:center;font-size: 20px;border: none;margin: 0 auto;"/>
            </div>
        </div>

        <div class="pupop"
             style="background-size: 30%; background-image: url('https://weiliicimg6.pstatp.com/weili/l/435288750761836547.webp'">
            <div style="text-align: center;width: 100%;">
                <div class="layui-form-item"><input type="text" autocomplete="off" class="layui-input" id="templateRise"
                                                    lay-verify="templateRise" name="templateRise" value="广州大学2019年语文类校考准考证"
                                                    style="background: center;width: 60%;height:50px;text-align:center;size:32px;border: 1px dashed #000;margin: 0 auto;"/>
                </div>
            </div>
            <div class="pupop_content">
                <div class="content_left">
                    <p><span>姓名: xx</span><span style="margin-left: 60px;">性别: 男</span></p>
                    <p><span>身份证号: xxxxxxxxxxx</span></p>
                    <p><span>省份: xxx省</span></p>
                    <p><span>考点: 广州【广州大学大学城校区】</span></p>
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
            <table class="layui-table" style="background-color: rgba(0,0,0,0);pointer-events: none;">
                <colgroup>
                    <col width="120">
                    <col width="150">
                    <col>
                    <col>
                </colgroup>
                <thead>
                <tr style="background-color: rgba(0,0,0,0);">
                    <th>报考专业</th>
                    <th>准考证号</th>
                    <th>考试时间</th>
                    <th>考场</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td rowspan="3">A专业名称</td>
                    <td>xxxxxx</td>
                    <td>xxxx年-xx月-xx日 xx时:xx分 - xxxx年-xx月-xx日 xx时:xx分</td>
                    <td>第一考场</td>
                </tr>
                <tr>
                    <td colspan="3">
                        <p>考试科目</p>
                        <p>初试科目: A科目， B科目</p>
                        <p>考试科目: C科目， D科目</p>
                    </td>
                </tr>
                </tbody>
            </table>
            <div class="matter">
                <ul>
                    <li>准考证备注：</li>
                    <li>xxxxxxxxxxxxxxxxxxxxxxxxxx</li>
                </ul>
            </div>

        </div>
        <div style="display: flex;justify-content: center;align-items: center;min-height: 80px;">
        <#--<button id="test10" style="width: 150px;height: 40px;margin-right: 10px;" type="file"-->
        <#--class="layui-btn layui-btn-primary">上传水印-->
        <#--</button>-->
        <#--<button onclick="removeAction()" style="width: 150px;height: 40px;margin-left: 0px;" type="button"-->
        <#--class="layui-btn layui-btn-danger">撤销水印-->
        <#--</button>-->
            <div class="layui-form-item">
                <#--<button style="width: 150px;height: 40px;" lay-submit="" lay-filter="add"-->
                        <#--class="layui-btn layui-btn-normal">提交-->
                <#--</button>-->
                    <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
            </div>
        </div>
    </div>
</form>
<script>
    layui.use(['form', 'layer'], function () {
        $ = layui.jquery;
        var form = layui.form
                , layer = layui.layer;

        form.on('submit(formDemo)', function (data) {
            layerAjax('${re.contextPath}/creaUserTemplate/student/mouldboardAdd', data.field, 'summaryList');
            layer.msg('添加成功！')
            layerAjax('${re.contextPath}/stutemplate/select')
            return false;
        });
        form.render();
    });

    function removeAction() {
        $('.pupop').css('background-image', '');
    }

</script>
</body>

</html>
