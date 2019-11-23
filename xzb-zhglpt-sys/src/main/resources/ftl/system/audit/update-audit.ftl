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
            <input type="hidden" id="audit_link" name="audit_link" value="${audit.audit_link}">
            <input type="hidden" id="audit_status" name="audit_status" value="${audit.audit_status}">

            <#--<input type="hidden" id="info_collect_status" name="info_collect_status" value="${audit.info_collect_status}">-->

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
                    <label for="realName" class="layui-form-label">
                        <span class="x-red">*</span>姓名
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="name" name="name" lay-verify="name" autocomplete="off"
                               class="layui-input" value="${e_user.name}" disabled>
                    </div>
                </div>
                <div class="layui-inline">
                    <label for="realName" class="layui-form-label">
                        <span class="x-red">*</span>证件号码
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="certificate_number" name="certificate_number" lay-verify="certificate_number" autocomplete="off"
                               class="layui-input" style="width: 280px;" value="${e_user.certificate_number}" disabled>
                    </div>
                </div>
            </div>

            <div class="layui-form-item">
                <div class="layui-inline">
                    <label for="age" class="layui-form-label">
                        <span class="x-red">*</span>性别
                    </label>
                    <div class="layui-input-inline" style="width: 150px;">
                        <select name="sex" id="sex" lay-verify="gender"
                                lay-filter="sex" disabled>
                            <option value="男" <#if e_user.sex='男'>selected</#if>>男</option>
                            <option value="女" <#if e_user.sex='女'>selected</#if>>女</option>
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
                        <input type="text" id="birthdate" name="birthdate" lay-verify="birthdate" autocomplete="off"
                               class="layui-input" value="${e_user.birthdate}" disabled>
                    </div>
                </div>
                <div class="layui-inline">
                    <label for="realName" class="layui-form-label">
                        <span class="x-red">*</span>街道详情
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="street" name="street" lay-verify="street" autocomplete="off"
                               class="layui-input" style="width: 280px;" value="${e_user.street}" disabled>
                    </div>
                </div>
            </div>

            <div class="layui-form-item">
                <div class="layui-inline">
                    <label for="realName" class="layui-form-label">
                        <span class="x-red">*</span>收件人
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="recipient" name="recipient" lay-verify="recipient" autocomplete="off"
                               class="layui-input" value="${e_user.recipient}" disabled>
                    </div>
                </div>
                <div class="layui-inline">
                    <label for="age" class="layui-form-label">
                        <span class="x-red">*</span>本人手机
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="phone" name="phone" lay-verify="phone"
                               autocomplete="off" class="layui-input" value="${e_user.phone}" disabled>
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
                        <input type="text" id="email" name="email" lay-verify="email"
                               autocomplete="off" class="layui-input" value="${e_user.email}" disabled>
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label for="age" class="layui-form-label">
                        <span class="x-red">*</span>正面照
                    </label>
                    <div id="demo2" style="margin-top: 20px;margin-left: 50px;float: right">
                        <img src="${servletPath+'/'+e_user.photograph}/" width="100px" height="100px"
                             class="layui-upload-img layui-circle">
                    </div>
                </div>
            </div>



            <div class="layui-form-item">
                <fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
                    <legend style="font-size:16px;">学籍信息</legend>
                </fieldset>
            </div>

            <div class="layui-form-item">
                <div class="layui-inline">
                    <label for="age" class="layui-form-label">
                        <span class="x-red">*</span>考生类型
                    </label>
                    <div class="layui-input-inline" style="width: 150px;">
                        <select name="examinee_type" id="examinee_type" lay-verify="examinee_type" disabled>
                            <option value="初中生" <#if e_user.examinee_type='初中生'>selected</#if>>初中生</option>
                            <option value="高中生" <#if e_user.examinee_type='高中生'>selected</#if>>高中生</option>
                            <option value="大学生" <#if e_user.examinee_type='大学生'>selected</#if>>大学生</option>
                        </select>
                    </div>
                </div>
                <div class="layui-inline">
                    <label for="age" class="layui-form-label">
                        <span class="x-red">*</span>考生学历
                    </label>
                    <div class="layui-input-inline" style="width: 150px;">
                        <select name="examinee_education" id="examinee_education" lay-verify="examinee_education" disabled>
                            <option value="初中及以下" <#if e_user.examinee_education='初中及以下'>selected</#if>>初中及以下</option>
                            <option value="中专/中技" <#if e_user.examinee_education='中专/中技'>selected</#if>>中专/中技</option>
                            <option value="高中" <#if e_user.examinee_education='高中'>selected</#if>>高中</option>
                            <option value="大专" <#if e_user.examinee_education='大专'>selected</#if>>大专</option>
                            <option value="本科" <#if e_user.examinee_education='本科'>selected</#if>>本科</option>
                        </select>
                    </div>
                </div>
                <div class="layui-inline">
                    <label for="age" class="layui-form-label">
                        <span class="x-red">*</span>考生省份
                    </label>
                    <div class="layui-input-inline" style="width: 150px;">
                        <select name="examinee_province" id="examinee_province" lay-verify="examinee_province" disabled>
                            <option value ="北京市"<#if e_user.examinee_province='北京市'>selected</#if>>北京市 </option>
                            <option value ="天津市"<#if e_user.examinee_province='天津市'>selected</#if>>天津市 </option>
                            <option value ="上海市"<#if e_user.examinee_province='上海市'>selected</#if>>上海市 </option>
                            <option value ="重庆市"<#if e_user.examinee_province='重庆市'>selected</#if>>重庆市 </option>
                            <option value ="河北省"<#if e_user.examinee_province='河北省'>selected</#if>>河北省 </option>
                            <option value ="山西省"<#if e_user.examinee_province='山西省'>selected</#if>>山西省 </option>
                            <option value ="辽宁省"<#if e_user.examinee_province='辽宁省'>selected</#if>>辽宁省 </option>
                            <option value ="吉林省"<#if e_user.examinee_province='吉林省'>selected</#if>>吉林省 </option>
                            <option value ="黑龙江省"<#if e_user.examinee_province='黑龙江省'>selected</#if>>黑龙江省</option>
                            <option value ="江苏省"<#if e_user.examinee_province='江苏省'>selected</#if>>江苏省 </option>
                            <option value ="浙江省"<#if e_user.examinee_province='浙江省'>selected</#if>>浙江省 </option>
                            <option value ="安徽省"<#if e_user.examinee_province='安徽省'>selected</#if>>安徽省 </option>
                            <option value ="福建省"<#if e_user.examinee_province='福建省'>selected</#if>>福建省 </option>
                            <option value ="江西省"<#if e_user.examinee_province='江西省'>selected</#if>>江西省 </option>
                            <option value ="山东省"<#if e_user.examinee_province='山东省'>selected</#if>>山东省 </option>
                            <option value ="河南省"<#if e_user.examinee_province='河南省'>selected</#if>>河南省 </option>
                            <option value ="湖北省"<#if e_user.examinee_province='湖北省'>selected</#if>>湖北省 </option>
                            <option value ="湖南省"<#if e_user.examinee_province='湖南省'>selected</#if>>湖南省 </option>
                            <option value ="广东省"<#if e_user.examinee_province='广东省'>selected</#if>>广东省 </option>
                            <option value ="海南省"<#if e_user.examinee_province='海南省'>selected</#if>>海南省 </option>
                            <option value ="四川省"<#if e_user.examinee_province='四川省'>selected</#if>>四川省 </option>
                            <option value ="贵州省"<#if e_user.examinee_province='贵州省'>selected</#if>>贵州省 </option>
                            <option value ="云南省"<#if e_user.examinee_province='云南省'>selected</#if>>云南省 </option>
                            <option value ="陕西省"<#if e_user.examinee_province='陕西省'>selected</#if>>陕西省 </option>
                            <option value ="甘肃省"<#if e_user.examinee_province='甘肃省'>selected</#if>>甘肃省 </option>
                            <option value ="青海省"<#if e_user.examinee_province='青海省'>selected</#if>>青海省 </option>
                            <option value ="台湾省"<#if e_user.examinee_province='台湾省'>selected</#if>>台湾省 </option>
                            <option value ="广西壮族自治区"<#if e_user.examinee_province='广西壮族自治区'>selected</#if>>广西壮族自治区</option>
                            <option value ="内蒙古自治区"<#if e_user.examinee_province='内蒙古自治区'>selected</#if>>内蒙古自治区</option>
                            <option value ="西藏自治区"<#if e_user.examinee_province='西藏自治区'>selected</#if>>西藏自治区</option>
                            <option value ="宁夏回族自治区"<#if e_user.examinee_province='宁夏回族自治区'>selected</#if>>宁夏回族自治区 </option>
                            <option value ="新疆维吾尔自治区"<#if e_user.examinee_province='新疆维吾尔自治区'>selected</#if>>新疆维吾尔自治区</option>
                            <option value ="香港特别行政区"<#if e_user.examinee_province='香港特别行政区'>selected</#if>>香港特别行政区</option>
                            <option value ="澳门特别行政区"<#if e_user.examinee_province='澳门特别行政区'>selected</#if>>澳门特别行政区</option>
                        </select>
                    </div>
                </div>
             </div>

            <div class="layui-form-item">
                <div class="layui-inline">
                    <label for="age" class="layui-form-label">
                        <span class="x-red">*</span>政治面貌
                    </label>
                    <div class="layui-input-inline" style="width: 150px;">
                        <select name="politics_status" id="politics_status" lay-verify="politics_status" disabled>
                            <option value="群众" <#if e_user.politics_status='群众'>selected</#if>>群众</option>
                            <option value="团员" <#if e_user.politics_status='团员'>selected</#if>>团员</option>
                            <option value="党员" <#if e_user.politics_status='党员'>selected</#if>>党员</option>
                        </select>
                    </div>
                </div>
                <div class="layui-inline">
                    <label for="age" class="layui-form-label">
                        <span class="x-red">*</span>应往届
                    </label>
                    <div class="layui-input-inline" style="width: 150px;">
                        <select name="graduate_type" id="graduate_type" lay-verify="graduate_type"
                                lay-filter="graduate_type" disabled>
                            <option value="应届" <#if e_user.graduate_type='应届'>selected</#if>>应届</option>
                            <option value="往届" <#if e_user.graduate_type='往届'>selected</#if>>往届</option>
                        </select>
                    </div>
                </div>
                <div class="layui-inline">
                    <label for="realName" class="layui-form-label">
                        <span class="x-red">*</span>毕业中学
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="graduate_middle" name="graduate_middle" lay-verify="graduate_middle" autocomplete="off"
                               class="layui-input" value="${e_user.graduate_middle}" disabled>
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label for="realName" class="layui-form-label">
                        <span class="x-red">*</span>考生号
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="examinee_number" name="examinee_number" lay-verify="examinee_number" autocomplete="off"
                               class="layui-input"  value="${e_user.examinee_number}" disabled>
                    </div>
                </div>
                <div class="layui-inline">
                    <label for="age" class="layui-form-label">
                        <span class="x-red">*</span>文理科
                    </label>
                    <div class="layui-input-inline" style="width: 150px;">
                        <select name="subject_type" id="subject_type" lay-verify="subject_type"
                                lay-filter="subject_type" disabled>
                            <option value="文科" <#if e_user.subject_type='文科'>selected</#if>>文科</option>
                            <option value="理科" <#if e_user.subject_type='理科'>selected</#if>>理科</option>
                        </select>
                    </div>
                </div>
            </div>

            <div class="layui-form-item">
                <fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
                    <legend style="font-size:16px;">家庭联络员</legend>
                </fieldset>
            </div>


            <div class="layui-form-item">
                <div class="layui-inline">
                    <label for="realName" class="layui-form-label">
                        <span class="x-red">*</span>姓名
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="member_name" name="member_name" lay-verify="member_name" autocomplete="off"
                               class="layui-input"  value="${e_user.member_name}" disabled>
                    </div>
                </div>
                <div class="layui-inline">
                    <label for="realName" class="layui-form-label">
                        <span class="x-red">*</span>关系
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="member_relationship" name="member_relationship" lay-verify="member_relationship" autocomplete="off"
                               class="layui-input"  value="${e_user.member_relationship}" disabled>
                    </div>
                </div>
                <div class="layui-inline">
                    <label for="realName" class="layui-form-label">
                        <span class="x-red">*</span>职业
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="member_occupation" name="member_occupation" lay-verify="member_occupation" autocomplete="off"
                               class="layui-input"  value="${e_user.member_occupation}" disabled>
                    </div>
                </div>
            </div>

            <div class="layui-form-item">
                <div class="layui-inline">
                    <label for="realName" class="layui-form-label">
                        <span class="x-red">*</span>工作单位
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="member_work" name="member_work" lay-verify="member_work" autocomplete="off"
                               class="layui-input" value="${e_user.member_work}" disabled>
                    </div>
                </div>
                <div class="layui-inline">
                    <label for="realName" class="layui-form-label">
                        <span class="x-red">*</span>手机号码
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="member_phone" name="member_phone" lay-verify="member_phone" autocomplete="off"
                               class="layui-input" value="${e_user.member_phone}" disabled>
                    </div>
                </div>
            </div>


            <div class="layui-form-item">
                <fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
                    <legend style="font-size:16px;">信息采集</legend>
                </fieldset>
                <div class="layui-input-inline">
                    <#--<div id="demo2" style="margin-top: 20px;margin-left: 50px">
                        <img src="${servletPath}/xzb-zhglpt/plugin/x-admin/images/renyixu.jpg" width="100px" height="100px"
                             class="layui-upload-img layui-circle">
                    </div>-->

                </div>
            </div>

            <div class="layui-form-item">
                <fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
                    <legend style="font-size:16px;">审核信息</legend>
                </fieldset>
                <div class="layui-inline">
                    <label for="departmentId" class="layui-form-label" style="width: 140px;">
                        <span class="x-red">*</span>审核报名状态
                    </label>
                    <div class="layui-input-inline" style="width:190px;">
                        <select name="enroll_status" id="enroll_status" required>
                            <#--<option value="待审核">待审核</option>
                            <option value="报名成功" <#if audit.enroll_status='报名成功'>selected</#if>>报名成功</option>
                            <option value="报名不成功"<#if audit.enroll_status='报名不成功'>selected</#if>>报名不成功</option>-->
                            <option value="全部">全部</option>
                            <option value="审核通过">审核通过</option>
                            <option value="审核不通过">审核不通过</option>
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
                        <textarea id="audit_reason" name="audit_reason"  autocomplete="off" class="layui-input" style="width: 380px;height: 200px;">${audit.audit_reason}</textarea>
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
            if($("#enroll_status").val()=="全部"){
                layer.alert("请进行审核!");
            }else{
                layerAjax('updateAuditSave', data.field, 'auditList');
            }
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