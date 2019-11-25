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
                <label for="uname" class="layui-form-label">
                        <span class="x-red">*</span>考试名称
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="exam" name="exam" lay-verify="required|exam"
                            autocomplete="off" class="layui-input" placeholder="请输入考试名称">
                </div>
            </div>
            <div class="layui-inline">
                <label for="uname" class="layui-form-label w-16">
                        <span class="x-red">*</span>报名开始时间
                </label>
                <div class="layui-input-inline">
                   <input type="text" class="layui-input" id="exam_time" name="exam_time" lay-verify="required|exam_time" placeholder="请输入报名开始时间">
                </div>
            </div>
             <div class="layui-inline">
                <label for="uname" class="layui-form-label w-16">
                        <span class="x-red">*</span>报名截止时间
                </label>
                <div class="layui-input-inline">
                   <input type="text" class="layui-input" id="end_time"  name="end_time" lay-verify="required|end_time" placeholder="请输入报名截止时间">
                </div>
            </div>
        </div>
          <div class="layui-form-item">
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
                <legend style="font-size:16px;font-weight: 700;">报考专业</legend>
                <#--  <i class="layui-icon layui-icon-add-1"></i>    -->
            </fieldset>
            <div class="layui-inline">
                <label for="uname" class="layui-form-label">
                        <span class="x-red">*</span>报考专业
                </label>
                <div class="layui-input-inline">
                    <select name="specialty_id" id="specialty_id" class="spec_id" lay-verify="spec_id"
                            lay-filter="specialty_id">
                        <option value="0">请选择专业</option>
                        <#list specList as spe>
                            <option value="${spe.id}">${spe.name}</option>
                        </#list>

                    </select>
                </div>


                <#--<div class="layui-input-inline">
                    <input type="text" id="specialty_name" name="specialty_name" lay-verify="username"
                            autocomplete="off" class="layui-input" placeholder="请输入报考专业">
                </div>-->
            </div>
        </div>
        <div class="layui-form-item" id="active">
            <div class="layui-inline" >
                <label for="uname" class="layui-form-label">
                        <span class="x-red">*</span>考试场次
                </label>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input datetime" id="create_time"  lay-verify="required|create_time" name="create_time" placeholder="请输入考试开始时间">
                </div>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input datetime2" id="update_time" lay-verify="required|update_time" name="update_time" placeholder="请输入考试结束时间">
                </div>
                <div class="layui-input-inline">
                    <input type="text" id="number_limitation" name="number_limitation" lay-verify="required|number_limitation"
                            autocomplete="off" class="layui-input" placeholder="请输入报考人数">
                </div>
                 <div class="layui-input-inline">
                    <input type="text" id="build" name="build" lay-verify="required|build"
                            autocomplete="off" class="layui-input" placeholder="请输入考场位置">
                </div>
                    <button type="button" class="layui-btn addBtn  ">新增</button>
            </div>
        </div>
       <div class="" style="margin-left: 110px;">
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">
                    <span class="x-red">*</span>兼报
                </label>
                <div class="layui-input-block">
                    <input type="checkbox" id="report_setting" lay-filter="report_setting" name="report_setting" lay-skin="switch" lay-text="是|否">
                </div>
            </div>
        </div>
        <div class="major">
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label for="majorId" class="layui-form-label">
                        <span class="x-red">*</span>兼报专业
                    </label>
                    <div class="layui-input-inline">
                    <select name="zspecialty_id" id="zspecialty_id" class="spec_id" lay-verify="spec_id"
                            lay-filter="zspecialty_id">
                        <option value="0">请选择兼报专业</option>
                        <#list specList as spe>
                            <option value="${spe.id}">${spe.name}</option>
                        </#list>
                    </select>
                </div>
                <#--<div class="layui-input-inline">
                    <select name="specialty_id" id="majorId" class="majorId" lay-verify="majorId"
                            lay-filter="majorId">
                        <option value="0">请选择兼报专业</option>
                        <option value="1">美术</option>
                        <option value="2">音乐</option>
                    </select>
                </div>-->
                <button type="button" class="layui-btn" onclick="majorAcion()">新增</button>
            </div>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label w-16" "><span class="x-red" style="width:100px">*</span>审核环节</label>
            <div class="layui-input-inline" style="min-width: 300px">
                <input type="radio" name="check_pay" se value="1" title="交费后">
                <input type="radio" name="check_pay" value="0" title="交费前">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label w-16">科类限制</label>
            <div class="layui-input-inline" style="min-width: 300px">
                <input type="radio" name="subject_stint" lay-filter="subject_stint" value="1" title="文科">
                <input type="radio" name="subject_stint" lay-filter="subject_stint" value="0" title="理科">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="uname" class="layui-form-label">
                <span class="x-red">*</span>报名费
            </label>
            <div class="layui-input-inline">
                <input type="text" id="prcie" name="prcie" lay-verify="required|prcie"
                        autocomplete="off" class="layui-input" placeholder="请输入报名费">
            </div>
                <label for="uname" class="layui-form-label">
                <span class="x-red" style="width:100px">*</span>复试报名费
            </label>
            <div class="layui-input-inline">
                    <input type="checkbox" lay-filter="switchFee" name="close" lay-skin="switch" lay-text="是|否">
            </div>
            <div class="layui-input-inline Fee show">
                <input type="text" id="retestPrcie" name="retestPrcie" lay-verify="username"
                        autocomplete="off" class="layui-input" placeholder="请输入复试报名费">
            </div>
        </div>
        <div class="layui-form-item">
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
                <legend>生源地限制</legend>
                <div>全国省份&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;限制可报省份</div>
            </fieldset>
            <div id="test7" class="demo-transfer"></div>
             <div id="ms" class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span><span id="ums">选择表示只有该地区考生可以报名该考试</span>
            </div>
        </div>
        <div class="layui-form-item">
            <label for="uname" class="layui-form-label">
                <span class="x-red">*</span>初试
            </label>
            <div class="layui-input-inline">
                <input type="text" id="preliminary" name="subject_q_fen" lay-verify="username"
                    autocomplete="off" class="layui-input" placeholder="请输入初始科目权重分值">
            </div>
            <div id="ms" class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span><span id="ums">分值为0-100</span>
            </div>
            <button type="button" class="layui-btn" onclick="subjectAction()">新增</button>
        </div>
        <div class="subject">
        </div>
       <div class="layui-form-item">
            <label for="uname" class="layui-form-label">
                <span class="x-red">*</span>复试
            </label>
            <div class="layui-input-inline">
                <input type="text" style="cursor: not-allowed;" disabled id="reexamine" name="father_q_fen" lay-verify="username"
                    autocomplete="off" class="layui-input" placeholder="请输入复试科目权重分值">
            </div>
            <div id="ms" class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span><span id="ums">与初试科目权重分值合计为100</span>
            </div>
            <button type="button" class="layui-btn" onclick="reexamineAction()">新增</button>
        </div>
        <div class="reexamine">
        </div>

         <div class="layui-form-item">
          <div class="layui-inline">
                <label for="uname" class="layui-form-label w-16">
                    <span class="x-red">*</span>信息采集模板
                </label>
         <div class="layui-input-inline">
             <select name="gathering_id" id="gathering_id" class="spec_id" lay-verify="spec_id"
                                lay-filter="spec_id">
                 <option value="">请选择信息采集模板</option>
                 <#list info_list as spe>
                     <option value="${spe.id}">${spe.template_name}</option>
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
            <label for="uname" class="layui-form-label">
                <span class="x-red">*</span>准考证标题
            </label>
            <div class="layui-input-inline">
                <input type="text" id="uname" name="prologue_title" lay-verify="gfhfh"
                       autocomplete="off" class="layui-input" placeholder="请输入准考证标题">
            </div>
            </div>
            <div class="layui-inline">
                <label for="uname" class="layui-form-label">
                    <span class="x-red">*</span>准考证前序
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="uname" name="prologue" lay-verify="zhun"
                        autocomplete="off" class="layui-input" placeholder="请输入准考证前序">
                </div>
                <div id="ms" class="layui-form-mid layui-word-aux">
                    <span class="x-red">*</span><span id="ums">准考证前序为4位数</span>
                </div>
            </div>
            <div class="layui-inline">
            <#--    <label for="uname" class="layui-form-label">

                </label>-->
                <#--<div class="layui-input-inline">
                    <select name="departmentId" id="departmentId" lay-verify="departmentId"
                            lay-filter="departmentId">
                        <option value="">请选择准考证模板</option>
                        <option value="1">模板1</option>
                        <option value="2">模板2</option>
                        <option value="3">模板3</option>
                    </select>
                </div>-->
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label for="uname" class="layui-form-label"style="width: 100px>
                <span class="x-red" style="width: 100px">*</span>准考证备注
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
         <div class="layui-form-item" style="margin-top: 10px;">
            <fieldset class="layui-elem-field layui-field-title">
                    <legend style="font-size:16px;font-weight: 700;">其他附件</legend>
            </fieldset>
            <div class="layui-input-inline" style="margin-bottom: 40px;">

                <button type="button" class="layui-btn" id="test6">
                    <i class="layui-icon">&#xe67c;</i>点击上传
                </button>
            </div>
             <div id="ms" class="layui-form-mid layui-word-aux">
                    <span class="x-red">*</span><span id="ums">仅支持pdf、word、txt
                    文件，大小不超过10M</span>
            </div>
        </div>
        <div style="width: 100%;height: 55px;background-color: white;border-top:1px solid #e6e6e6;
  position: fixed;bottom: 0px;margin-left:-40px;">
            <div class="layui-form-item" style=" float: right;margin-right: 30px;margin-top: 8px">

                <button class="layui-btn layui-btn-normal" lay-filter="add" lay-submit="">
                    增加
                </button>
                <button class="layui-btn layui-btn-primary" id="close">
                    取消
                </button>
            </div>
        </div>
    </form>
</div>
<script>


    layui.use(['form', 'laydate', 'transfer'], function () {
        var form = layui.form
        ,laydate = layui.laydate
        ,upload = layui.upload
        ,transfer = layui.transfer;
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
        var province_id = []
        //监听提交
        var specialty = 0;
        var zspecialty = 0;
        form.on('select(specialty_id)', function (data) {
            specialty = data.value;
            console.log(specialty)
            <#--for(var i =0; i < ${specList}.length; i++) {-->
                // console.log(i)
            // }
            layui.use(['form', 'layer'], function () {
                var form = layui.form;
                var layer = layui.layer;
                if(data.value === zspecialty) {
                    layer.msg('所选专业重复!请重新选择!')
                }
                form.render();
            });
        });

        form.on('select(zspecialty_id)', function (data) {
            zspecialty = data.value;
            if(data.value !== '') {
                console.log(data)
                $("input[name='report_setting']").attr('checked', 'checked');
            }
            if(data.value === '') {
                console.log(data)
                $("input[name='report_setting']").removeAttr('checked');
            }
            layui.use(['form', 'layer'], function () {
                var form = layui.form;
                var layer = layui.layer;
                if(data.value === specialty) {
                    layer.msg('所选专业重复!请重新选择!')
                }
                form.render();
            });
        form.on('submit(add)', function (data) {
            /*var r = document.getElementsByName("role");
            var role = [];
            for (var i = 0; i < r.length; i++) {
                if (r[i].checked) {
                    console.info(r[i].value);
                    role.push(r[i].value);
                }
            }*/

            var obj= data.field;
            var kc= [];
            var csqz=[];
            var fsqz=[];

            var txt2 = $('#active').find(':text'); // 获取所有文本框
            if (txt2.length>0){
                for (var i = 0; i < txt2.length; i++) {

                    kc.push(txt2.eq(i).val());
                }
            }

            // 获取所有文本框
            txt2 = $('.subject').find(':text');
            if (txt2.length>0){
                if(txt2.length==1){
                    if(txt2.eq(1).val()!='100'){
                        alert('权重要为100')
                    }

                }
                if(txt2.length==2){
                    if(parseInt(txt2.eq(2).val())+parseInt(txt2.eq(1).val())!=100){
                        alert('权重加起来要为100')
                    }

                }
              /*  if(txt2.length==3){
                    if(txt2.eq(1).val()!='100'){
                        alert('权重要为100')
                    }

                }
                if(txt2.length==1){
                    if(txt2.eq(1).val()!='100'){
                        alert('权重要为100')
                    }

                }*/
                for (var i = 0; i < txt2.length; i++) {

                    console.log(txt2.eq(i).val())
                    csqz.push(txt2.eq(i).val());
                }
            }


            txt2 = $('.reexamine').find(':text');    // 获取所有文本框
            if (txt2.length>0){

                for (var i = 0; i < txt2.length; i++) {
                    fsqz.push(txt2.eq(i).val());
                }
            }
/*
            txt2 = $('.reexamine').find(':text');    // 获取所有文本框
            if (txt2.length>0){
                for (var i = 0; i < txt2.length; i++) {

                    kc.push(txt2.eq(i).val());
                }
            }*/
           var kca = '';
           var cs = '';
           var fs = '';
            var provinceTit = ''
            for(var i = 0; i < province_id.length; i++) {
                if(i==province_id.length-1){
                    provinceTit+=province_id[i].title;
                }else{
                    provinceTit+=province_id[i].title + ',';
                }
            }
            for(var i = 0; i < kc.length; i++) {
                if(i==kc.length-1){
                    kca+=kc[i];
                }else{
                    kca+=kc[i] + ',';
                }
            }
            for(var i = 0; i < csqz.length; i++) {
                if(i==csqz.length-1){
                    cs+=csqz[i];
                }else{
                    cs+=csqz[i] + ',';
                }
            }
            for(var i = 0; i < fsqz.length; i++) {
                if(i==fsqz.length-1){
                    fs+=fsqz[i];
                }else{
                    fs+=fsqz[i] + ',';
                }
            }
            console.log(fsqz)
            data.field.province_id = provinceTit;
            data.field.kca=kca;
            data.field.cskm=cs;
            data.field.fskm=fs;
            layerAjax('addExamination',data.field ,'examinationList');

            return false;
        });

        form.render();
        //基础效果
        transfer.render({
            elem: '#test7',
            data: data1,
            title: ['全选', '全选'],
            showSearch: true,
            id: 'demo1',
            onchange: function(obj, index){
                var getData = transfer.getData('demo1');
                console.log(getData)
                province_id = getData
            }
        })


        //执行一个laydate实例
        laydate.render({
            elem: '#create_time' //指定元素
            ,type: 'datetime'
        });

        //日期时间选择器
        laydate.render({
            elem: '#create_start_time'
            ,type: 'datetime'
        });
        //日期时间选择器
        laydate.render({
            elem: '#update_time'
            ,type: 'datetime'
        });
         laydate.render({
            elem: '#exam_time'
            ,type: 'datetime'
        });
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
            ,url: '/xzb-zhglpt/examination/uploadFile?id=1' //上传接口
            ,done: function(res){
            //上传完毕回调
                alert("上传成功");
            }
            ,error: function(){
            //请求异常回调
                alert("上传失败");
            }
        });
         //执行实例
        var uploadInst = upload.render({
            elem: '#test6' //绑定元素
            ,url: '/xzb-zhglpt/examination/uploadFile?id=2' //上传接口
            ,done: function(res){
            //上传完毕回调
                alert("上传成功");
            }
            ,error: function(){
            //请求异常回调
                alert("上传失败");
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
     form.verify({
         zhun:function (value) {
             if(value.length>4){
                 return '准考证前序不能超过4位';
             }
         }
     })


        });
        //核心方法
        function timeAdd(){
            lay('.datetime').each(function() {
                laydate.render({
                    elem : this,
                    type: 'datetime',
                    trigger : 'click',
                    fontmat:"YYYY-MM-dd HH:MM:SS",
                    done:function(val) {
                        console.log('第一个:' + val)
                    }
                });
            });
            lay('.datetime2').each(function() {
                laydate.render({
                    elem : this,
                    type: 'datetime',
                    trigger : 'click',
                    fontmat:"YYYY-MM-dd HH:MM:SS",
                    done:function(val) {
                        console.log('第二个:' +  val)
                    }
                });
            });
        }
        //初始化时先调用一次，确保静态的那一行可点
        timeAdd();

        $('.addBtn').click(function(){
            var tableHtml =
                `<div class="layui-form-item one">
                    <div class="layui-input-inline">
                        <input type="text" class="layui-input datetime" id="test3" name="test3" lay-verify="required|test3" placeholder="请输入考试开始时间">
                    </div>
                    <div class="layui-input-inline">
                        <input type="text" class="layui-input datetime2" id="test4" lay-verify="required|test4"  placeholder="请输入考试结束时间">
                    </div>
                    <div class="layui-input-inline">
                        <input type="text" id="uname" name="bkrsa" lay-verify="required|bkrsa"
                                autocomplete="off" class="layui-input" placeholder="请输入报考人数">
                    </div>
                     <div class="layui-input-inline">
                    <input type="text" id="uname" name="kcwz" lay-verify="required|kcwz"
                            autocomplete="off" class="layui-input" placeholder="请输入考场位置">
                </div>
                    <button type="button" class="layui-btn layui-btn-danger" onclick="removeAction(this)">删除</button>
            </div>`

            if($('.one').length>2){
                return layer.msg('不能再多了');
            }else{
                $('#active').append(tableHtml)
            }
            form.render();

            timeAdd()
        })
    });


    $(function(){
        var one = 0;
        console.log($("input[name='subject_stint'][value=0]"))
        $("input[name='subject_stint'][value=0]").attr("checked", 'checked');
        layui.use(['form', 'laydate'], function () {
            var form = layui.form;
            form.render();
        });
        $("input[name='subject_q_fen']").change(function(){
            var text = $(this).val();
            var two = 100 - text;
            $("input[name='father_q_fen']").val(two);
        });

    })




    function removeAction(obj) {
        $(obj).parent().remove();
    }

    function majorAcion() {
        $('.major').append(
            `<div class="layui-form-item">
                <div class="layui-inline">
                    <label for="majorId" class="layui-form-label">
                        <span class="x-red">*</span>兼报专业
                    </label>
                    <div class="layui-input-inline">
                        <select name="majorId" id="majorId" class="majorId" lay-verify="required|majorId"
                                lay-filter="majorId">
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
        console.log(111)
    }
    function removeMajorAction(obj) {
        $(obj).parent().remove();
    }

    function subjectAction() {
       var tableHtml =
            `<div class="layui-form-item Subject">
                <div class="layui-input-inline">
                   <select name="gathering_id" id="gathering_id" class="spec_id" lay-verify="spec_id"
                                lay-filter="spec_id">
                     <option value="">请选择初试科目</option>
                     <#list subjectList as spe>
                         <option value="${spe.id}">${spe.subject_name}</option>
                     </#list>
                    </select>
                </div>
                <div class="layui-input-inline">
                    <input type="text" id="ninad" name="ninad" lay-verify="required|ninad"
                        autocomplete="off" class="layui-input" placeholder="请输入科目总分">
                </div>
                <div class="layui-input-inline">
                    <input type="text" id="awefa" name="awefa" lay-verify="required|awefa"
                        autocomplete="off" class="layui-input" placeholder="请输入科目权重分值">
                </div>
                <div id="ms" class="layui-form-mid layui-word-aux">
                    <span class="x-red">*</span><span id="ums">多个科目分值合计为100</span>
                </div>
                <button type="button" class="layui-btn layui-btn-danger" onclick="removeSubjectAction(this)">删除</button>
            </div>`
        if($('.Subject').length>3){
            return layer.msg('不能再多了');
        }else{
            $('.subject').append(tableHtml)
        }
        layui.use(['form'], function () {
            var form = layui.form;
            form.render();
        });
    }
    function removeSubjectAction(obj) {
        $(obj).parent().remove();
    }

    function reexamineAction() {
        $('.reexamine').append(
            ` <div class="layui-form-item">
            <div class="layui-input-inline">
                <select name="gathering_id" id="gathering_id" class="spec_id" lay-verify="spec_id"
                                lay-filter="spec_id">
                 <option value="">请选择初试科目</option>
                 <#list subjectList as spe>
                     <option value="${spe.id}">${spe.subject_name}</option>
                 </#list>
             </select>
            </div>
            <div class="layui-input-inline">
                <input type="text" id="nina" name="kma" lay-verify="required|kma"
                    autocomplete="off" class="layui-input" placeholder="请输入科目总分">
            </div>
            <div class="layui-input-inline">
                <input type="text" id="uname" name="nina" lay-verify="required|nina"
                    autocomplete="off" class="layui-input" placeholder="请输入科目权重分值">
            </div>
            <div id="ms" class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span><span id="ums">多个科目分值合计为100</span>
            </div>
            <button type="button" class="layui-btn layui-btn-danger" onclick="removeReexamineAction(this)">删除</button>
        </div>`)
        layui.use(['form'], function () {
            var form = layui.form;
            form.render();
        });
    }
    function removeReexamineAction(obj) {
        $(obj).parent().remove();
    }

</script>
</body>

</html>
