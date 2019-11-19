<#--Created by IntelliJ IDEA.
User:
Date: 2017/12/18
Time: 10:05
To change this template use File | Settings | File Templates.-->

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>审核管理-审核</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <link rel="stylesheet" href="${re.contextPath}/plugin/layui/css/layui.css">
    <script type="text/javascript" src="${re.contextPath}/plugin/jquery/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${re.contextPath}/plugin/layui/layui.all.js" charset="utf-8"></script>
    <script type="text/javascript" src="${re.contextPath}/plugin/tools/tool.js"></script>
    <script type="text/javascript" src="${re.contextPath}/plugin/tools/update-setting.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            var flag = '${detail}';
            if (flag) {
                $("form").disable();
            }
        });
    </script>


</head>

<body>
<div class="x-body">
    <form class="layui-form layui-form-pane" style="margin-left: 20px;">
        <div style="width:100%;height:520px;overflow: auto;margin-top: 30px;">
            <input type="hidden" id="id" name="id" value="${audit.id}">
            <input type="hidden" id="u_id" name="u_id" value="${audit.u_id}">


            <#--<div class="layui-form-item">
                <div class="layui-inline">
                    <input type="hidden" id="id" name="id" value="${audit.id}">
                    <input type="hidden" id="u_id" name="u_id" value="${audit.u_id}">
                    <a id="ksxq" class="layui-btn layui-btn-xs  layui-btn-normal" lay-event="detail" style="font-size: large;" title="查看考生详情" onclick="">基本信息</a>
                </div>
            </div>

            <div class="layui-form-item">
                <div class="layui-inline">
                    <a id="ksfj" class="layui-btn layui-btn-xs  layui-btn-normal" lay-event="detail" style="font-size: large;" title="查看考生附件" onclick="">信息采集</a>
                </div>
            </div>-->



            <div class="layui-form-item">
                <fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
                    <legend style="font-size:16px;">基本信息</legend>
                </fieldset>
            </div>

            <div class="layui-form-item">
                <div class="layui-inline">
                    <label for="age" class="layui-form-label">
                        <span class="x-red">*</span>证件类型
                    </label>
                    <div class="layui-input-inline">
                        <select name="document_type" id="document_type" lay-verify="document_type"
                                lay-filter="document_type" disabled>
                            <option value="身份证" <#if e_user.document_type='身份证'>selected</#if>>身份证</option>
                            <option value="证书" <#if e_user.document_type='证书'>selected</#if>>证书</option>
                        </select>
                    </div>
                </div>
                <div class="layui-inline">
                    <label for="realName" class="layui-form-label">
                        <span class="x-red">*</span>证件号码
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="document_num" name="document_num" lay-verify="document_num" autocomplete="off"
                               class="layui-input" style="width: 280px;" value="${e_user.document_num}" disabled>
                    </div>
                </div>
            </div>

            <div class="layui-form-item">
                <div class="layui-inline">
                    <label for="realName" class="layui-form-label">
                        <span class="x-red">*</span>姓名
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="personname" name="personname" lay-verify="personname" autocomplete="off"
                               class="layui-input" value="${e_user.personname}" disabled>
                    </div>
                </div>
                <div class="layui-inline">
                    <label for="age" class="layui-form-label">
                        <span class="x-red">*</span>性别
                    </label>
                    <div class="layui-input-inline" style="width: 150px;">
                        <select name="gender" id="gender" lay-verify="gender"
                                lay-filter="gender" disabled>
                            <option value="男" <#if e_user.gender='男'>selected</#if>>男</option>
                            <option value="女" <#if e_user.gender='女'>selected</#if>>女</option>
                        </select>
                    </div>
                </div>
                <div class="layui-inline">
                    <label for="realName" class="layui-form-label">
                        <span class="x-red">*</span>民族
                    </label>
                    <div class="layui-input-inline" style="width: 150px;">
                        <select name="nation" id="nation" lay-verify="nation"
                                lay-filter="nation" disabled>
                            <option value="汉族" <#if e_user.nation='汉族'>selected</#if>>汉族</option>
                            <option value="少数民族" <#if e_user.nation='少数民族'>selected</#if>>少数民族</option>
                        </select>
                    </div>
                </div>

            </div>

            <div class="layui-form-item">
                <div class="layui-inline">
                    <label for="realName" class="layui-form-label">
                        <span class="x-red">*</span>出生日期
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="date_birth" name="date_birth" lay-verify="date_birth" autocomplete="off"
                               class="layui-input" value="${e_user.date_birth}" disabled>
                    </div>
                </div>
                <div class="layui-inline">
                    <label for="realName" class="layui-form-label">
                        <span class="x-red">*</span>街道详情
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="street_details" name="street_details" lay-verify="street_details" autocomplete="off"
                               class="layui-input" style="width: 280px;" value="${e_user.street_details}" disabled>
                    </div>
                </div>
            </div>

            <div class="layui-form-item">
                <div class="layui-inline">
                    <label for="realName" class="layui-form-label">
                        <span class="x-red">*</span>收件人
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="addressee" name="addressee" lay-verify="addressee" autocomplete="off"
                               class="layui-input" value="${e_user.addressee}" disabled>
                    </div>
                </div>
                <div class="layui-inline">
                    <label for="age" class="layui-form-label">
                        <span class="x-red">*</span>本人手机
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="mob_phone" name="mob_phone" lay-verify="mob_phone"
                               autocomplete="off" class="layui-input" value="${e_user.mob_phone}" disabled>
                    </div>
                </div>
            </div>

            <div class="layui-form-item">
                <div class="layui-inline">
                    <label for="realName" class="layui-form-label">
                        <span class="x-red">*</span>邮政编码
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="postal_code" name="postal_code" lay-verify="postal_code" autocomplete="off"
                               class="layui-input" value="${e_user.postal_code}" disabled>
                    </div>
                </div>
                <div class="layui-inline">
                    <label for="age" class="layui-form-label">
                        <span class="x-red">*</span>电子邮件
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="e_mail" name="e_mail" lay-verify="e_mail"
                               autocomplete="off" class="layui-input" value="${e_user.e_mail}" disabled>
                    </div>
                </div>
            </div>

            <div class="layui-form-item">
                <fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
                    <legend style="font-size:16px;">信息采集</legend>
                </fieldset>
                <div class="layui-input-inline">

                    <div id="demo2" style="margin-top: 20px;margin-left: 50px">
                        <img src="${servletPath}/xzb-zhglpt/plugin/x-admin/images/renyixu.jpg" width="100px" height="100px"
                             class="layui-upload-img layui-circle">
                    </div>

                </div>
            </div>

            <div class="layui-form-item">

                <div class="layui-inline">
                    <label for="departmentId" class="layui-form-label" style="width: 140px;">
                        <span class="x-red">*</span>审核报名状态
                    </label>
                    <div class="layui-input-inline" style="width:190px;">
                        <select name="enroll_status" id="enroll_status">
                            <option value="待审核">待审核</option>
                            <option value="报名成功" <#if audit.enroll_status='报名成功'>selected</#if>>报名成功</option>
                            <option value="报名不成功"<#if audit.enroll_status='报名不成功'>selected</#if>>报名不成功</option>
                        </select>

                    </div>
                </div>

            </div>

            <div class="layui-form-item">
                <div class="layui-inline">
                    <label for="creater" class="layui-form-label" style="width: 140px;">
                        <span class="x-red">*</span>审核批注
                    </label>
                    <div class="layui-input-inline">
                        <textarea id="audit_reason" name="audit_reason"  autocomplete="off" class="layui-input" style="width: 380px;height: 200px;"></textarea>
                    </div>
                </div>
            </div>


            <div style="height: 60px"></div>
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
    var flag, msg;
    $(function () {


    });
    layui.use(['form', 'layer', 'upload'], function () {
        $ = layui.jquery;
        var form = layui.form
            , layer = layui.layer,
            upload = layui.upload;


        $('#close').click(function () {
            var index = parent.layer.getFrameIndex(window.name);
            parent.layer.close(index);
        });
        //监听提交
        form.on('submit(add)', function (data) {
            layerAjax('updateAuditSave', data.field, 'auditList');
            return false;
        });

        form.render();
    });

    function detail(title, url, w, h) {
        if (title == null || title == '') {
            title = false;
        }
        ;
        if (url == null || url == '') {
            url = "error/404";
        }
        ;
        if (w == null || w == '') {
            w = ($(window).width() * 0.9);
        }
        ;
        if (h == null || h == '') {
            h = ($(window).height() - 50);
        }
        ;
        layer.open({
            id: 'audit-detail2',
            type: 2,
            area: [w + 'px', h + 'px'],
            fix: false,
            maxmin: true,
            shadeClose: true,
            shade: 0.4,
            title: title,
            content: url ,
            // btn:['关闭']
        });
    }

</script>
</body>

</html>