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
    <title>新增报告通知</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <link rel="stylesheet" href="${re.contextPath}/plugin/layui/css/layui.css">
    <script type="text/javascript" src="${re.contextPath}/plugin/jquery/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${re.contextPath}/plugin/layui/layui.all.js" charset="utf-8"></script>
    <script type="text/javascript" src="${re.contextPath}/plugin/tools/tool.js"></script>
    <style>
        .layui-row{
            padding: 20px;
        }
        .layui-row .layui-form-item h2{
            font-size: 24px;
            color: #009688;
        }
        .layui-row .layui-form-item .w-16{
            width: 140px;
        }
        .layui-row .layui-form-item .layui-inline {
            min-width: 295px;
        }
        .show {
            display: none;
        }
    </style>
</head>
<body style="background-color:#f2f2f2;">
<div class="layui-row layui-form-pane" style="margin-left: 20px;">
    <form class="layui-form" action="">
        <div class="layui-form-item">
            <div class="layui-inline">
                <label for="caption" class="layui-form-label" style="width: 200px;">
                    <span class="x-red">*</span>标题名称
                </label>
                <div class="layui-input-inline" style="width: 250px;">
                    <input type="text" id="caption" name="caption"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>


        <div class="layui-form-item">
            <div class="layui-inline">
                <label for="content" class="layui-form-label" style="width: 200px;">
                    <span class="x-red">*</span>通知内容
                </label>
                <div class="layui-input-inline" style="width: 250px;">

                    <textarea id="content" name="content" rows="8" cols="50">

                    </textarea>
                </div>
            </div>

        </div>

        <div style="width: 100%;height: 55px;background-color: white;border-top:1px solid #e6e6e6;
  position: fixed;bottom: 1px;margin-left:-20px;">
            <div class="layui-form-item" style=" float: right;margin-right: 30px;margin-top: 8px">

                <button  class="layui-btn layui-btn-normal" lay-filter="add" lay-submit>
                    确认
                </button>
                <button  class="layui-btn layui-btn-primary" id="close">
                    取消
                </button>
            </div>
        </div>
    </form>
</div>
<script>
    layui.use(['form', 'layer'], function () {
        $ = layui.jquery;
        var form = layui.form, layer = layui.layer;

        //自定义验证规则
        form.verify({
            caption: function (value) {
                if (value.trim() == "") {
                    return "主题不能为空";
                }
            }
        });

        $('#close').click(function () {
            var index = parent.layer.getFrameIndex(window.name);
            parent.layer.close(index);
        });
        //监听提交
        form.on('submit(add)', function (data) {
            layerAjax('addOnlineExercisesList', data.field, 'onlineExercises');
            return false;
        });
        form.render();
    });
</script>
</body>

</html>
