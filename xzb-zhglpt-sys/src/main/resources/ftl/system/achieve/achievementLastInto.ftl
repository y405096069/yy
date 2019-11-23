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
    <title>新建信息采集模板</title>
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
    <form class="layui-form" action="" >



         <div class="layui-form-item">
             <fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
                 <legend style="font-size:16px;">选择文件</legend>
             </fieldset>
             <div class="layui-inline">
                 <div class="layui-upload-drag" style="" id="file" name="file">
                     <i style="font-size:30px;" class="layui-icon"></i>
                     <p style="font-size: 10px">点击上传，或将文件拖拽到此处</p>
                 </div>
             </div>

          </div>


        <div style="width: 100%;height: 55px;background-color: white;border-top:1px solid #e6e6e6;
  position: fixed;bottom: 1px;margin-left:-20px;">
            <div class="layui-form-item" style=" float: right;margin-right: 30px;margin-top: 8px">

                <button  class="layui-btn layui-btn-normal" lay-filter="add" id="fileTJ" lay-submit>
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
    layui.use(['form', 'layer','upload'], function () {
        var form = layui.form
        ,upload = layui.upload
            ,layer = layui.layer;
        form.render();

        var uploadInst = upload.render({
            elem: '#file'
            ,url: 'intoLastGrade'
            ,auto: false //选择文件后不自动上传
            ,bindAction: '#fileTJ' //指向一个按钮触发上传
            ,accept: 'file'
            ,exts: 'xls|excel|xlsx' //只允许上传压缩文件
            ,done: function (res) {
                if (res.flag) {
                    var index = parent.layer.getFrameIndex(window.name);
                    parent.layer.close(index);
                    window.parent.layui.table.reload('achievementFirstList');
                    window.top.layer.msg(res.msg, {icon: 6, offset: 'rb', area: ['200px', '80px'], anim: 2});
                } else {
                    window.top.layer.msg(res.msg, {icon: 6, offset: 'rb', area: ['120px', '80px'], anim: 2});
                }
            }
        });
        //关闭
        $('#close').click(function () {
            var index = parent.layer.getFrameIndex(window.name);
            parent.layer.close(index);
        });

        //监听提交
        form.on('submit(add)', function (data) {

            //addinfor('achievementFirstIntoSave', numArr,numArr2, 'inforList');
            return false;
        });

    });

    function addinfor(url, numArr,numArr2, tableId) {
        $.ajax({
            url: url,
            type: 'post',
            data: { "template_name": $('#template_name').val() ,"temp_norms_name": numArr,"temp_norms_desc":numArr2},
            traditional:true,
            success: function (d) {
                if (d.flag) {
                    if (tableId !== undefined && tableId !== '') {
                        var index = parent.layer.getFrameIndex(window.name);
                        //top.layui.index.close(index);
                        parent.layer.close(index);
                        window.parent.layui.table.reload(tableId);
                    }
                    window.top.layer.msg(d.msg, {icon: 6, offset: 'rb', area: ['200px', '80px'], anim: 2});
                } else {
                    layer.msg(d.msg, {icon: 5});
                }
            }, error: function (e) {
                layer.alert("发生错误", {icon: 6}, function () {
                    var index = parent.layer.getFrameIndex(window.name);
                    parent.layer.close(index);
                });
            }
        });
    }





</script>
</body>

</html>
