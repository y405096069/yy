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
    <title>新增考试</title>
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
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
                <legend style="font-size:16px;font-weight: 700;">考试信息</legend>
            </fieldset>
            <div class="layui-inline">
                <label for="exam" class="layui-form-label">
                    <span class="x-red">*</span>考试名称
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="exam" name="exam" lay-verify="exam"
                           autocomplete="off" class="layui-input" placeholder="请输入考试名称">
                </div>
            </div>
            <div class="layui-inline">
                <label for="exam_time" class="layui-form-label w-16">
                    <span class="x-red">*</span>报名开始时间
                </label>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input" id="exam_time" name="exam_time" placeholder="yyyy-MM-dd HH:mm:ss">
                </div>
            </div>
            <div class="layui-inline">
                <label for="end_time" class="layui-form-label w-16">
                    <span class="x-red">*</span>报名截止时间
                </label>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input" id="end_time" name="end_time" placeholder="yyyy-MM-dd HH:mm:ss">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
                <legend style="font-size:16px;font-weight: 700;">报考专业</legend>
                <#--  <i class="layui-icon layui-icon-add-1"></i>    -->
            </fieldset>
            <div class="layui-inline">
                <label for="specialty_id" class="layui-form-label">
                    <span class="x-red">*</span>报考专业
                </label>
               <#-- <div class="layui-input-inline">
                    <input type="text" id="uname" name="username" lay-verify="username"
                           autocomplete="off" class="layui-input" placeholder="请输入报考专业">
                </div>-->
              <#--  <div class="layui-input-inline">
                    <select name="specialty_id" id="specialty_id" lay-verify="specialty_id"
                            lay-filter="specialty_id">
                        <option value="">报考专业</option>
                        <option value="1">模板1</option>
                        <option value="2">模板2</option>
                        <option value="3">模板3</option>
                    </select>
                </div>-->
                <div class="layui-input-inline">
                    <select name="specialty_id" id="specialty_id" lay-verify="specialty_id"
                            lay-filter="specialty_id">
                        <option value="">报考专业</option>
                        <#list specList as deptData>
                            <option value="${deptData.id}">${deptData.name}</option>
                        </#list>
                    </select>
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label for="uname" class="layui-form-label">
                    <span class="x-red">*</span>考试场次
                </label>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input" id="create_start_time" name="create_start_time" placeholder="请输入考试开始时间">
                </div>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input" id="create_end_time" name="create_end_time" placeholder="请输入考试结束时间">
                </div>
                <div class="layui-input-inline">
                    <input type="text" id="number_limitation" name="number_limitation" lay-verify="number_limitation"
                           autocomplete="off" class="layui-input" placeholder="请输入报考人数">
                </div>
                <div class="layui-input-inline">
                    <input type="text" id="build" name="build" lay-verify="build"
                           autocomplete="off" class="layui-input" placeholder="请输入考场位置">
                </div>
                <button type="button" class="layui-btn" onclick="addAction()">新增</button>
            </div>
        </div>
        <div class="active" style="margin-left: 110px;">
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">
                    <span class="x-red">*</span>兼报设置
                </label>
                <div class="layui-input-block">
                    <input type="checkbox" lay-filter="switchTest" name="close" lay-skin="switch" lay-text="是|否" id="report_setting">
                </div>
            </div>
        </div>
        <div class="major">
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label for="specialty_name" class="layui-form-label">
                        <span class="x-red">*</span>兼报专业
                    </label>
                   <#-- <div class="layui-input-inline">
                        <select name="specialty_name" id="specialty_name" lay-verify="specialty_name"
                                lay-filter="specialty_id">
                            <option value="">请选择兼报专业</option>
                            <option value="1">美术</option>
                            <option value="2">音乐</option>
                        </select>
                    </div>-->
                    <div class="layui-input-inline">
                        <select name="specialty_name" id="specialty_name" lay-verify="specialty_name"
                                lay-filter="specialty_name">
                            <option value="">请选择兼报专业</option>
                            <#list specList as deptData>
                                <option value="${deptData.id}">${deptData.name}</option>
                            </#list>
                        </select>
                    </div>

                    <button type="button" class="layui-btn" onclick="majorAcion()">新增</button>
                </div>
            </div>
        </div>

     <#--   <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">
                    <span class="x-red">*</span>互斥设置
                </label>

                <div class="layui-input-block">
                    <input type="checkbox" lay-filter="switchTest" name="close" lay-skin="switch" lay-text="是|否" id="huchi">
                </div>
            </div>
        </div>-->

       <#-- <div class="major">
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label for="specialtyId" class="layui-form-label">
                        <span class="x-red">*</span>互斥专业
                    </label>
                    <div class="layui-input-inline">
                        <select name="specialtyId" id="specialtyId" lay-verify="specialtyId"
                                lay-filter="specialtyId">
                            <option value="">请选择互斥专业</option>
                            <option value="1">美术</option>
                            <option value="2">音乐</option>
                        </select>
                    </div>

                    <button type="button" class="layui-btn" onclick="huchiAction()">新增</button>
                </div>
            </div>
        </div>-->

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label w-16">审核资料环节</label>
                <div class="layui-input-inline" style="min-width: 300px">
                    <input type="radio" name="check_pay" value="0" title="交费前">
                    <input type="radio" name="check_pay" value="1" title="交费后">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label w-16">科类限制</label>
                <div class="layui-input-inline" style="min-width: 300px">
                    <input type="radio" name="subject_stint" value="文科" title="文科">
                    <input type="radio" name="subject_stint" value="理科" title="理科">
                </div>
            </div>
        </div>

        <div class="layui-form-item">

            <label for="prcie" class="layui-form-label">
                <span class="x-red">*</span>报名费
            </label>
            <div class="layui-input-inline">
                <input type="text" id="prcie" name="prcie" lay-verify="prcie" autocomplete="off" class="layui-input" placeholder="请输入报名费">
            </div>
            <label for="retestPrcie" class="layui-form-label">
                <span class="x-red">*</span>复试报名费
            </label>
            <div class="layui-input-inline">
                <input type="checkbox" lay-filter="switchFee" name="retest_type" lay-skin="switch" lay-text="是|否">
            </div>
            <div class="layui-input-inline Fee show">
                <input type="text" id="retestPrcie" name="retestPrcie" lay-verify="retestPrcie"
                       autocomplete="off" class="layui-input" placeholder="请输入复试报名费">
            </div>
        </div>
        <div class="layui-form-item">
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
                <legend>生源地限制</legend>
            </fieldset>
            <div id="province_id" class="demo-transfer"></div>
            <div id="ms" class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span><span id="ums">选择表示只有该地区考生可以报名该考试</span>
            </div>
        </div>
        <div class="layui-form-item">
            <label for="subject_q_fen" class="layui-form-label">
                <span class="x-red">*</span>初试
            </label>
            <div class="layui-input-inline">
                <input type="text" id="subject_q_fen" name="subject_q_fen" lay-verify="subject_q_fen"
                       autocomplete="off" class="layui-input" placeholder="请输入初始科目权重分值">
            </div>
            <div id="ms" class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span><span id="ums">分值为0-100</span>
            </div>
            <button type="button" class="layui-btn" onclick="subjectAction()">新增</button>
        </div>
        <div class="subject">
        </div>
       <#-- <div class="layui-form-item">
            <label for="father_q_fen" class="layui-form-label">
                <span class="x-red">*</span>复试
            </label>
            <div class="layui-input-inline">
                <input type="text" style="cursor: not-allowed;" disabled id="father_q_fen" name="father_q_fen" lay-verify="father_q_fen"
                       autocomplete="off" class="layui-input" placeholder="请输入复试科目权重分值">
            </div>
            <div id="ms" class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span><span id="ums">与初试科目权重分值合计为100</span>
            </div>
            <button type="button" class="layui-btn" onclick="father_q_fenAction()">新增</button>
        </div>-->
        <#--<div class="father_q_fen">
        </div>-->

        <div class="layui-form-item">
            <div class="layui-inline">
                <label for="gathering_id" class="layui-form-label w-16">
                    <span class="x-red">*</span>信息采集模板
                </label>
                <div class="layui-input-inline">
                    <select name="gathering_id" id="gathering_id" lay-verify="gathering_id"
                            lay-filter="gathering_id">
                        <option value="">请选择信息采集模板</option>
                        <#list info_list as deptData>
                            <option value="${deptData.id}">${deptData.template_name}</option>
                        </#list>
                    </select>
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
                <legend style="font-size:16px;font-weight: 700;">准考证</legend>
            </fieldset>
            <div class="layui-inline">
                <label for="prologue" class="layui-form-label">
                    <span class="x-red">*</span>准考证前序
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="prologue" name="prologue" lay-verify="prologue"
                           autocomplete="off" class="layui-input" placeholder="请输入准考证前序">
                </div>
                <div id="ms" class="layui-form-mid layui-word-aux">
                    <span class="x-red">*</span><span id="ums">准考证前序为4位数</span>
                </div>
            </div>
            <div class="layui-inline">
                <label for="prologue_tem" class="layui-form-label">
                    <span class="x-red">*</span>准考证模板
                </label>
                <div class="layui-input-inline">
                    <select name="prologue_tem" id="prologue_tem" lay-verify="prologue_tem"
                            lay-filter="gathering_id">
                        <option value="">请选择准考证模板</option>
                        <option value="1">模板1</option>
                        <option value="2">模板2</option>
                        <option value="3">模板3</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label for="prologue_remarks" class="layui-form-label">
                <span class="x-red">*</span>准考证备注
            </label>
            <div class="layui-input-block">
                <textarea name="prologue_remarks" placeholder="请输入准考证备注" class="layui-textarea"></textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
                <legend style="font-size:16px;font-weight: 700;">免责声明</legend>
            </fieldset>
            <div class="layui-input-inline">
                <button type="button" class="layui-btn" id="test5">
                    <i class="layui-icon">&#xe67c;</i>点击上传
                </button>
            </div>
            <div id="ms" class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span><span id="ums">仅支持pdf、word、txt
                    文件，大小不超过10M</span>
            </div>
        </div>
        <div class="layui-form-item">
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
                <legend style="font-size:16px;font-weight: 700;">其他附件</legend>
            </fieldset>
            <div class="layui-input-inline">
                <button type="button" class="layui-btn" id="test6">
                    <i class="layui-icon">&#xe67c;</i>点击上传
                </button>
            </div>
            <div id="ms" class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span><span id="ums">仅支持pdf、word、txt
                    文件，大小不超过10M</span>
            </div>
        </div>
       <#-- <div>
            <button style="width: 150px;height: 40px;" type="button" class="layui-btn">确认</button>
            <button style="width: 150px;height: 40px;" type="button" class="layui-btn layui-btn-danger">返回</button>
        </div>-->

        <div style="width: 100%;height: 55px;background-color: white;border-top:1px solid #e6e6e6;
  position: fixed;bottom: 0px;margin-left:-20px;">
            <div class="layui-form-item" style=" float: right;margin-right: 30px;margin-top: 8px">

                <button class="layui-btn layui-btn-normal" lay-filter="add" lay-submit="">
                    添加
                </button>
                <button class="layui-btn layui-btn-primary" id="close">
                    取消
                </button>
            </div>
        </div>
    </form>
</div>
<script>
    layui.use(['form', 'laydate','transfer'], function () {
        var form = layui.form
            ,laydate = layui.laydate
            ,transfer = layui.transfer
            ,upload = layui.upload;
        form.render();

        //模拟数据
        var data1 = [
            {"value": "1", "title": "北京市"}
            ,{"value": "2", "title": "天津市"}
            ,{"value": "3", "title": "广东省"}
            ,{"value": "4", "title": "福建省"}
            ,{"value": "5", "title": "广西省"}
            ,{"value": "6", "title": "湖南省"}
            ,{"value": "7", "title": "湖北省"}
            ,{"value": "8", "title": "江西省"}
        ];
        //基础效果
        transfer.render({
            elem: '#province_id',
            data: data1,
            title: ['全国省份', '可报省份'],
            showSearch: true
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#exam_time' //指定元素
            ,type: 'datetime'
        });
        //日期时间选择器
        laydate.render({
            elem: '#end_time'
            ,type: 'datetime'
        });
        laydate.render({
            elem: '#create_start_time'
            ,type: 'datetime'
        });
        laydate.render({
            elem: '#create_end_time'
            ,type: 'datetime'
        });


        //执行实例
        var uploadInst = upload.render({
            elem: '#test5' //绑定元素
            ,url: '/upload/' //上传接口
            ,done: function(res){
                //上传完毕回调
            }
            ,error: function(){
                //请求异常回调
            }
        });
        //执行实例
        var uploadInst = upload.render({
            elem: '#test6' //绑定元素
            ,url: '/upload/' //上传接口
            ,done: function(res){
                //上传完毕回调
            }
            ,error: function(){
                //请求异常回调
            }
        });

        form.on('switch(switchFee)', function (data) {
            var contexts;
            var x = data.elem.checked;//判断开关状态
            if (x==true) {
                contexts = "你确定要启动么";
                $('.Fee').show()
            } else {
                contexts = "你确定要关闭么";
                $('.Fee').hide()
            }
            return false;
        });

        //监听提交
        form.on('submit(add)', function (data) {
            layerAjax('addExamination', data.field, 'examinationList');
            return false;
        });
        form.render();
    });

    $(function(){
        $("input[name='subject_q_fenVal']").change(function(){
            var text = $(this).val();
            var two = 100 - text;
            $("input[name='father_q_fenVal']").val(two);
        });
    })

    function addAction() {
        $('.active').append(
            `<div class="layui-form-item one">
                    <div class="layui-input-inline">
                        <input type="text" class="layui-input" id="create_start_time" placeholder="请输入考试开始时间">
                    </div>
                    <div class="layui-input-inline">
                        <input type="text" class="layui-input" id="create_end_time" placeholder="请输入考试结束时间">
                    </div>
                    <div class="layui-input-inline">
                        <input type="text" id="uname" name="username" lay-verify="username"
                                autocomplete="off" class="layui-input" placeholder="请输入报考人数">
                    </div>
                     <div class="layui-input-inline">
                    <input type="text" id="uname" name="username" lay-verify="username"
                            autocomplete="off" class="layui-input" placeholder="请输入考场位置">
                </div>
                    <button type="button" class="layui-btn layui-btn-danger" onclick="removeAction(this)">删除</button>
            </div>`)
        console.log(111)
    }
    function removeAction(obj) {
        $(obj).parent().remove();
    }

    function majorAcion() {
        $('.major').append(
            `<div class="layui-form-item">
                <div class="layui-inline">
                    <label for="gathering_id" class="layui-form-label">
                        <span class="x-red">*</span>兼报专业
                    </label>
                    <div class="layui-input-inline">
                        <select name="gathering_id" id="gathering_id" lay-verify="gathering_id"
                                lay-filter="gathering_id">
                            <option value="">请选择兼报专业</option>
                            <option value="1">美术</option>
                            <option value="2">音乐</option>
                        </select>
                    </div>
                    <button type="button" class="layui-btn layui-btn-danger" onclick="removeMajorAction(this)">删除</button>
                </div>
            </div>`)
        layui.use(['form', 'laydate'], function () {
            var form = layui.form;
            form.render();
        });
    }

    function huchiAction() {
        $('.huchi').append(
            `<div class="layui-form-item">
                <div class="layui-inline">
                    <label for="gathering_id" class="layui-form-label">
                        <span class="x-red">*</span>互斥专业
                    </label>
                    <div class="layui-input-inline">
                        <select name="gathering_id" id="gathering_id" lay-verify="gathering_id"
                                lay-filter="gathering_id">
                            <option value="">请选择互斥专业</option>
                            <option value="1">美术</option>
                            <option value="2">音乐</option>
                        </select>
                    </div>
                    <button type="button" class="layui-btn layui-btn-danger" onclick="removeMajorAction(this)">删除</button>
                </div>
            </div>`)
        layui.use(['form', 'laydate'], function () {
            var form = layui.form;
            form.render();
        });
    }
    function removeMajorAction(obj) {
        $(obj).parent().remove();
    }

    function subjectAction() {
        $('.subject').append(
            `<div class="layui-form-item">
                <div class="layui-input-inline">
                <select name="gathering_id" id="gathering_id" lay-verify="gathering_id"
                            lay-filter="gathering_id">
                    <option value="">请选择初始科目</option>
                    <option value="1">跑步</option>
                    <option value="2">跳远</option>
                    <option value="3">画画</option>
                </select>
                </div>
                <div class="layui-input-inline">
                    <input type="text" id="uname" name="username" lay-verify="username"
                        autocomplete="off" class="layui-input" placeholder="请输入科目总分">
                </div>
                <div class="layui-input-inline">
                    <input type="text" id="uname" name="username" lay-verify="username"
                        autocomplete="off" class="layui-input" placeholder="请输入科目权重分值">
                </div>
                <div id="ms" class="layui-form-mid layui-word-aux">
                    <span class="x-red">*</span><span id="ums">多个科目分值合计为100</span>
                </div>
                <button type="button" class="layui-btn layui-btn-danger" onclick="removeSubjectAction(this)">删除</button>
            </div>`)
        layui.use(['form'], function () {
            var form = layui.form;
            form.render();
        });
    }
    function removeSubjectAction(obj) {
        $(obj).parent().remove();
    }

    function father_q_fenAction() {
        $('.father_q_fen').append(
            ` <div class="layui-form-item">
            <div class="layui-input-inline">
                <select name="gathering_id" id="gathering_id" lay-verify="gathering_id"
                        lay-filter="gathering_id">
                    <option value="">请选择复试科目</option>
                    <option value="1">跑步</option>
                    <option value="2">跳远</option>
                    <option value="3">画画</option>
                </select>
            </div>
            <div class="layui-input-inline">
                <input type="text" id="uname" name="username" lay-verify="username"
                    autocomplete="off" class="layui-input" placeholder="请输入科目总分">
            </div>
            <div class="layui-input-inline">
                <input type="text" id="uname" name="username" lay-verify="username"
                    autocomplete="off" class="layui-input" placeholder="请输入科目权重分值">
            </div>
            <div id="ms" class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span><span id="ums">多个科目分值合计为100</span>
            </div>
            <button type="button" class="layui-btn layui-btn-danger" onclick="removefather_q_fenAction(this)">删除</button>
        </div>`)
        layui.use(['form'], function () {
            var form = layui.form;
            form.render();
        });
    }
    function removefather_q_fenAction(obj) {
        $(obj).parent().remove();
    }

</script>
</body>

</html>
