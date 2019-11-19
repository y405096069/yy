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

      <#--  <div class="layui-form-item">
            <div class="layui-inline">
                <label for="user_id" class="layui-form-label" style="width: 200px;">
                    <span class="x-red">*</span>发布人
                </label>
                <div class="layui-input-inline" style="width: 250px;">
                    <input type="text" id="user_id" name="user_id"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
-->
        <#--<div class="layui-inline">
            <label for="create_time" class="layui-form-label w-16">
                <span class="x-red">*</span>发布时间
            </label>
            <div class="layui-input-inline">
                <input type="text" class="layui-input" id="create_time" placeholder="yyyy-MM-dd HH:mm:ss">
            </div>
        </div>
-->
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
    layui.use(['form', 'layer','laydate'], function () {
        var form = layui.form
            ,laydate = layui.laydate
            ,upload = layui.upload
            ,layer = layui.layer;
        form.render();

        //执行一个laydate实例
        laydate.render({
            elem: '#create_time' //指定元素
            ,type: 'datetime'
        });

        //关闭
        $('#close').click(function () {
            var index = parent.layer.getFrameIndex(window.name);
            parent.layer.close(index);
        });

        //监听提交
        form.on('submit(add)', function (data) {
            var r = document.getElementsByName("role");
            var role = [];
            layerAjax('addNotice', data.field, 'noticeList');
            return false;
        });
        form.render();

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

    var num=0;
    function addPicture() {     //上传图片
        var str=``;
        if(num==0){
            str+=`<fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
                    <legend style="font-size:16px;">上传图片</legend>
                </fieldset>`;
        }
        str+=`<div class="layui-form-item"><div class="layui-inline">
                <label for="uname" class="layui-form-label">
                    <span class="x-red">*</span>描述：
                </label>
                <div class="layui-input-inline" style="width: 250px;">
                    <input type="hidden" id="temp_norms_name" name="temp_norms_name" value="上传图片">
                    <input type="text" id="temp_norms_desc" name="temp_norms_desc" lay-verify="required"
                           autocomplete="off" class="layui-input" placeholder="请输入上传图片描述(必填)">
                </div>
                <div id="ms" class="layui-form-mid layui-word-aux">
                    <span class="x-red">*</span><span id="ums">只能上传jpg/png文件，且不超过1M</span>
                </div>
            </div>
            <button type="button" class="layui-btn layui-btn-danger" onclick="removeTemp(this)">删除</button>
            </div>`;
        num++;
        $('#addPicture').append(str);
    }
    function removeTemp(obj) {
        num--;
        if (num==0){
            $(obj).parent().prev().remove();
        }
        $(obj).parent().remove();
    }


    var num2=0;
    function addVideo() {     //上传视频
        var str="";
        if(num2==0){
            str+=`<fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
                    <legend style="font-size:16px;">上传视频</legend>
                </fieldset>`;
        }
        str+=`<div class="layui-form-item"><div class="layui-inline">
                <label for="uname" class="layui-form-label">
                    <span class="x-red">*</span>描述：
                </label>
                <div class="layui-input-inline" style="width: 250px;">
                    <input type="hidden" id="temp_norms_name" name="temp_norms_name" value="上传视频">
                    <input type="text" id="temp_norms_desc" name="temp_norms_desc" lay-verify="required"
                           autocomplete="off" class="layui-input" placeholder="请输入上传视频描述(必填)">
                </div>
                <div id="ms" class="layui-form-mid layui-word-aux">
                    <span class="x-red">*</span><span id="ums">可上传mp4、flv、wmv等视频，且不超过100MB</span>
                </div>
            </div>
            <button type="button" class="layui-btn layui-btn-danger" onclick="removeTemp2(this)">删除</button>
            </div>`;
        num2++;
        $('#addVideo').append(str);
    }
    function removeTemp2(obj) {
        num2--;
        if (num2==0){
            $(obj).parent().prev().remove();
        }
        $(obj).parent().remove();
    }


    var num3=0;
    function addFile() {     //上传文件
        var str="";
        if(num3==0){
            str+=`<fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
                    <legend style="font-size:16px;">上传文件</legend>
                </fieldset>`;
        }
        str+=`<div class="layui-form-item"><div class="layui-inline">
                <label for="uname" class="layui-form-label">
                    <span class="x-red">*</span>描述：
                </label>
                <div class="layui-input-inline" style="width: 250px;">
                    <input type="hidden" id="temp_norms_name" name="temp_norms_name" value="上传文件">
                    <input type="text" id="temp_norms_desc" name="temp_norms_desc" lay-verify="required"
                           autocomplete="off" class="layui-input" placeholder="请输入上传文件描述(必填)">
                </div>
                <div id="ms" class="layui-form-mid layui-word-aux">
                    <span class="x-red">*</span><span id="ums">仅支持excel、word、txt文件，大小不超过10M</span>
                </div>
            </div>
            <button type="button" class="layui-btn layui-btn-danger" onclick="removeTemp3(this)">删除</button>
            </div>`;
        num3++;
        $('#addFile').append(str);
    }
    function removeTemp3(obj) {
        num3--;
        if (num3==0){
            $(obj).parent().prev().remove();
        }
        $(obj).parent().remove();
    }


    var num4=0;
    function addMusic() {     //上传音乐
        var str="";
        if(num4==0){
            str+=`<fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
                    <legend style="font-size:16px;">上传音乐</legend>
                </fieldset>`;
        }
        str+=`<div class="layui-form-item"><div class="layui-inline">
                <label for="uname" class="layui-form-label">
                    <span class="x-red">*</span>描述：
                </label>
                <div class="layui-input-inline" style="width: 250px;">
                    <input type="hidden" id="temp_norms_name" name="temp_norms_name" value="上传音乐">
                    <input type="text" id="temp_norms_desc" name="temp_norms_desc" lay-verify="required"
                           autocomplete="off" class="layui-input" placeholder="请输入上传音乐描述(必填)">
                </div>
                <div id="ms" class="layui-form-mid layui-word-aux">
                    <span class="x-red">*</span><span id="ums">只能上传mp3格式，且不超过10M</span>
                </div>
            </div>
            <button type="button" class="layui-btn layui-btn-danger" onclick="removeTemp4(this)">删除</button>
            </div>`;
        num4++;
        $('#addMusic').append(str);
    }
    function removeTemp4(obj) {
        num4--;
        if (num4==0){
            $(obj).parent().prev().remove();
        }
        $(obj).parent().remove();
    }




</script>
</body>

</html>
