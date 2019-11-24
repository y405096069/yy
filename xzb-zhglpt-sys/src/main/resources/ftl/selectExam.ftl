<#-- Created by IntelliJ IDEA.
 User: Administrator
 Date: 2017/12/6
 Time: 14:00
 To change this template use File | Settings | File Templates.
 切片管理-->
<!DOCTYPE html>
<html xmlns:th=“http://www.thymeleaf.org”>
<head>
    <meta charset="UTF-8">
    <title>选择报考</title>
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
        .layui-row .layui-content .step-body {
            margin: 30px 0;
        }
        .layui-row .layui-content .layui-form {
            min-height: 200px;
        }
        .layui-row .layui-form-item .w-22 {
            width: 220px;
        }
        .layui-row .layui-form .layui-com {
            background-color: #dedede;
            color: red;
            padding: 10px;
            box-sizing: border-box;
        }
        .pad {
            min-height: 150px;
            padding: 20px 10px;
            display: flex;
        }
        .haeader-content, .footer-content {
            width: 100%;
            background-color: #009688;
            color: #333;
            height: 120px;
            text-align: center;
        }
        .footer-content .footer {
            width: 666px;
            padding-top: 15px;
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
        <div style="height: 8%;">
            <button style="width: 150px;height: 40px;" type="button" class="layui-btn layui-btn-primary" onclick="location.href='${re.contextPath}/studentInformation/getStudentIndex';">返回首页</button>
        </div>
        <div id="step_demo" class="step-body">
            <div class="step-header" style="width:80%;overflow: hidden;">
                <ul>
                    <li>
                        <span class="step-name">基本信息</span>
                    </li>
                    <li>
                        <span class="step-name">选择报考</span>
                    </li>
                    <li>
                        <span class="step-name">信息采集</span>
                    </li>
                    <li>
                        <span class="step-name">网上缴费</span>
                    </li>
                    <li>
                        <span class="step-name">报名成功</span>
                    </li>
                </ul>
            </div>
            <div class="step-content">
                <div class="step-list"></div>
                <div class="step-list"></div>
                <div class="step-list"></div>
                <div class="step-list"></div>
                <div class="step-list"></div>
            </div>
        </div>
        <form class="layui-form" action="">
            <div class="layui-com">
                <p>提示:</p>
                <p>(注：带*符号的项必填)</p>
            </div>
            <div class="layui-form-item pad">
                <div class="layui-inline">
                    <label for="uname" class="layui-form-label">
                        <span class="x-red">*</span>考试名称
                    </label>
                    <div class="layui-input-inline">
                        <select name="exam" id="exam" lay-verify="departmentId"
                                lay-filter="departmentId">
                            <option value="">请选择考试名称</option>
                            <#list examinationList as examination>
                                <option value="${examination.exam}">${examination.exam}</option>
                            </#list>
<#--                            <option th:each="list1:${typeList1}" th:value="${list1.exam}" th:text="${list1.exam }"></option>-->
                        </select>
                    </div>
                </div>
                <div class="layui-inline">
                    <label for="uname" class="layui-form-label">
                        <span class="x-red">*</span>专业名称
                    </label>
                    <div class="layui-input-inline">
                        <select name="name" id="name" lay-verify="departmentId"
                                lay-filter="departmentId">
                            <#list specList as spe>
                                <option value="${spe.id}">${spe.name}</option>
                            </#list>
                            //<option value="">请选择专业名称</option>
                        </select>
                    </div>
                </div>
                <div style="width: 323px;display: flex;flex-direction: column;">
                    <div class="layui-inline">
                        <label for="uname" class="layui-form-label">
                            <span class="x-red">*</span>考试时间
                        </label>
                        <div class="layui-input-inline">
                            <select name="create_start_time" id="create_start_time" lay-verify="departmentId"
                                    lay-filter="departmentId">
                                <option value="">请选择考试时间</option>
                            </select>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label for="uname" class="layui-form-label">
                            <span class="x-red">*</span>考试地点
                        </label>
                        <div class="layui-input-inline">
                            <select name="buiId" id="buiId" lay-verify="departmentId"
                                    lay-filter="departmentId">
                                <option value="">请选择考试地点</option>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
            <div class="layui-com">
                <p>提示:</p><span>点击附件查看</span>
                <p>
                    <span style="color: #000;cursor: pointer;" onclick="informationAction()">招生简章</span>
                </p>
            </div>
            <div style="display: flex;justify-content: center;align-items: center;min-height: 80px;">
                <button style="width: 150px;height: 40px;" type="button" class="layui-btn">确认</button>
                <button style="width: 150px;height: 40px;" type="button" class="layui-btn layui-btn-normal" onclick="openAction()">下一步</button>
            </div>
        </form>
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
    <form class="layui-form" id="test" style="display:none">
        <div style="padding: 5px 20px 36px 20px;text-indent: 2em;">本网站所展示的信息为网站所有者自行提供，内容真实性、准确性、合法性由网站所有者负责。</div>
        <div class="layui-form-item" style="position: absolute;bottom: 0;left: 0;">
            <div style="margin-left: 60px;" class="layui-input-block">
                <input id="checkboxID" lay-filter="switchFee" type="checkbox" value="1" name="like[write]" title="已阅读并同意" lay-skin="primary">
            </div>
        </div>
    </form>

    <form class="layui-form" id="lest" style="display:none">
        <div style="padding: 50px 20px 36px 20px;text-indent: 2em;">
            <p>用户在接受考试60服务之前，请务必仔细阅读本条款并同意本声明。</p>
            <p>用户直接或通过各类方式（如站外API引用等）间接使用考试60服务和数据的行为，都将被视作已无条件接受本声明所涉全部内容；若用户对本声明的任何条款有异议，请停止使用考试60所提供的全部服务。</p>
            <p>第一条</p>
            <p>用户以各种方式使用考试60服务和数据（包括但不限于发表、宣传介绍、转载、浏览及利用考试60或考试60用户发布内容）的过程中，不得以任何方式利用考试60直接或间接从事违反中国法律、以及社会公德的行为，且用户应当恪守下述承诺：</p>
            <p>1. 发布、转载或提供的内容符合中国法律、社会公德；</p>
            <p>2. 不得干扰、损害和侵犯考试60的各种合法权利与利益；</p>
            <p>3. 遵守考试i60以及与之相关的网络服务的协议、指导原则、管理细则等；</p>
            <p>考试60有权对违反上述承诺的内容予以删除。</p>
            <p>第二条</p>
            <p> 1. 考试60仅为用户发布的内容提供存储空间，考试60不对用户发表、转载的内容提供任何形式的保证：不保证内容满足您的要求，不保证考试60的服务不会中断。因网络状况、通讯线路、第三方网站或管理部门的要求等任何原因而导致您不能正常使用，考试60不承担任何法律责任。</p>
            <p>2. 用户在考试60发表的内容（包含但不限于考试60目前各产品功能里的内容）仅表明其个人的立场和观点，并不代表考试60的立场或观点。作为内容的发表者，需自行对所发表内容负责，因所发表内容引发的一切纠纷，由该内容的发表者承担全部法律及连带责任。考试60不承担任何法律及连带责任。</p>
            <p>3. 用户在考试60发布侵犯他人知识产权或其他合法权益的内容，考试60有权予以删除，并保留移交司法机关处理的权利。</p>
            <p>4. 个人或单位如认为考试60上存在侵犯自身合法权益的内容，应准备好具有法律效应的证明材料，及时与考试60取得联系，以便考试60迅速做出处理。</p>
        </div>
    </form>

    <form class="layui-form" id="confirm" style="display:none">
        <div style="padding: 50px 20px 36px 20px;text-indent: 2em;">
            <p>本网站内容部分内容转载于第三方网站，本网站转载系出于传递信息之目的，并不意味着对作品观点的正确性、合法性以及作品内容的真实性负责。如有侵权请联系QQ：130988360删除。</p>
            　　<p>事业单位招聘考试网对本网站上所有内容包括但不限于网站运营或本网站上的信息、内容、材料或产品，不提供明示或暗示的担保。由所适用法律许可，事业单位招聘考试网否认所有明示或暗示的担保，包括但不限于为特定目的做的商务暗示担保。事业单位招聘考试网对任何损失或任何由于使用本网站而引起的损失，包括但不限于直接的，间接的，偶然的、惩罚性的和引发的损失，不承担责任。</p>
            　　<p>因黑客攻击、计算机病毒入侵或发作等影响网站正常经营的不可抗力，造成的网民个人资料泄露、被盗用或被篡改等，本网站不承担任何法律责任。</p>
        </div>
    </form>
</div>
<script>
    layui.use(['jquery', 'steps', 'form', 'laydate', 'upload'], function(){

        var $ = layui.$;
        var $step= $("#step_demo").step();
        $step.goStep(2);//到指定步
        $("#preBtn").click(function(event) {
            $step.preStep();//下一步
        });
        $("#nextBtn").click(function(event) {
            $step.nextStep();//下一步
        });

        var form = layui.form
            ,laydate = layui.laydate
            ,upload = layui.upload
            ,layer = layui.layer;
        form.render();

        //执行一个laydate实例
        laydate.render({
            elem: '#test1' //指定元素
            ,type: 'date'
        });

        upload.render({
            elem: '#test10'
            , url: 'upload'
            , before: function (obj) {
                //预读，不支持ie8
                obj.preview(function (index, file, result) {
                    $('#demo2').find('img').remove();
                    $('#demo2').append('<img src="' + result + '" alt="' + file.name + '" width="100px" height="100px" class="layui-upload-img layui-circle">');
                });
            }, done: function (res) {
                if (!res.flag) {
                    layer.msg(res.msg, {icon: 5, anim: 6});
                } else {
                    $("#photo").val(res.msg);
                    console.info($('#photo').val());
                }
            }
        });
    });



    function openAction() {
        layui.use(['form', 'layer'], function(){
            var form = layui.form

            layer.open({
                type:1,
                area:['500px','300px'],
                title: '免责声明',
                content: $("#test"),
                shade: 0.7,
                btn: ['同意', '返回']
                ,btn1: function(index, layero){
                    var check = document.getElementById("checkboxID").checked;
                    if(check == true) {
                        layer.closeAll();
                        location.href='${re.contextPath}/studentInformation/getInformationGather';
                    } else {
                        layer.alert('请勾选免责声明', {
                            closeBtn: 0
                        });
                    }
                },
                btn2: function(index, layero){
                    layer.closeAll();
                },
                cancel: function(layero,index){
                    layer.closeAll();
                }
            });
        });
    }
    function informationAction() {
        layui.use(['layer'], function(){
            var zsjz = layer.open({
                type:1,
                area:['60%','80%'],
                title: '招生简章',
                content: $("#lest"),
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

    function informationActions() {
        layui.use(['layer'], function(){
            var confirm = layer.open({
                type:1,
                area:['60%','80%'],
                title: '招生简章',
                content: $("#confirm"),
                shade: 0,
                isOutAnim: true,
                anim: -1,
                btn: '返回',
                btn1: function(index, layero){
                    layer.close(confirm);
                },
                cancel: function(layero,index){
                    layer.closeAll();
                }
            });
        });
    }

    <#--form.on('select()', function (data) {-->

    <#--    var pId = data.value;// 一级列表的id-->
    <#--    $.post('${re.contextPath}/studentInformation/getSelectExam', {'exam': exam, 'name':name, 'create_start_time':create_start_time}, function (msg) {// 请求二级列表的数据-->
    <#--        // console.log(msg);-->
    <#--        $('#name').empty();// 将二级列表的内容清空-->
    <#--        for (var i in msg) {// 遍历数据赋值给二级列表的内容-->
    <#--            var $content = $('<option value="' + msg[i].name + '">' + msg[i].name + '</option>');-->
    <#--            $('#name').append($content);-->
    <#--            form.on('select(exam)', function (data1) {-->

    <#--                var pId1 = data1.value;// 一级列表的id-->
    <#--                $.post('${re.contextPath}/studentInformation/getSelectExam', {'exam': exam, 'name':name, 'create_start_time':create_start_time}, function (msg) {// 请求二级列表的数据-->
    <#--                    // console.log(msg);-->
    <#--                    $('#create_start_time').empty();// 将二级列表的内容清空-->
    <#--                    for (var j in msg) {// 遍历数据赋值给二级列表的内容-->
    <#--                        var $content = $('<option value="' + msg[j].create_start_time + '">' + msg[j].create_start_time + '</option>');-->
    <#--                        $('#create_start_time').append($content);-->
    <#--                        var $content1 = $('<option value="' + msg[j].buiId + '">' + msg[j].buiId + '</option>');-->
    <#--                        $('#buiId').append($content1);-->
    <#--                        $.post('${re.contextPath}/studentInformation/getSelectExam', {'exam': exam, 'name':name, 'create_start_time':create_start_time}, function (msg) {// 请求二级列表的数据-->
    <#--                            // console.log(msg);-->
    <#--                            $('#buiId').empty();// 将二级列表的内容清空-->
    <#--                            for (var k in msg) {// 遍历数据赋值给二级列表的内容-->
    <#--                                var $content2 = $('<option value="' + msg[k].buiId + '">' + msg[k].buiId + '</option>');-->
    <#--                                $('#buiId').append($content2);-->
    <#--                            }-->
    <#--                            form.render('select');//  注意：数据赋值完成之后必须调用该方法，进行layui的渲染，否则数据出不来-->
    <#--                        });-->
    <#--                    }-->
    <#--                    form.render('select');//  注意：数据赋值完成之后必须调用该方法，进行layui的渲染，否则数据出不来-->
    <#--                });-->
    <#--            });-->
    <#--        }-->
    <#--        form.render('select');//  注意：数据赋值完成之后必须调用该方法，进行layui的渲染，否则数据出不来-->
    <#--    });-->
    <#--});-->
    <#--layui.use(['layer', 'form'], function(){-->
    <#--    var layer = layui.layer-->
    <#--        ,form = layui.form;-->
    <#--    form.on('select(myselect)', function(data){-->
    <#--        var areaId=(data.value).replaceAll(",","");-->
    <#--        $.ajax({-->
    <#--            type: 'POST',-->
    <#--            url: '${re.contextPath}/studentInformation/getSelectExam',-->
    <#--            data: {exam:exam},-->
    <#--            dataType: 'json',-->
    <#--            success: function(data){-->
    <#--                $("#exam").html("");-->
    <#--                $.each(data, function(key, val) {-->
    <#--                    var option1 = $("<option>").val(val.exam).text(val.exam);-->
    <#--                    $("#exam").append(option1);-->
    <#--                    form.render('select');-->
    <#--                });-->
    <#--                $("#exam").get(0).selectedIndex=0;-->
    <#--            }-->
    <#--        });-->
    <#--    });-->
    <#--});-->
</script>
</body>

</html>
