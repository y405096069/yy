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
        .haeader-content {
            width: 100%;
            background-color: #009688;
            color: #333;
            text-align: center;
        }
        .footer-content {
            width: 100%;
            background-color: #009688;
            color: #333;
            height: 120px;
            text-align: center;
            padding: 15px 0;
            box-sizing: border-box;
        }
        .footer-content .footer {
            width: 666px;
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
        .layui-row .layui-form .layui-header {
            background-color: #dedede;
            color: red;
            padding: 10px;
            box-sizing: border-box;
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
        <div style="height: 4%;">
            <button style="width: 150px;height: 40px;" type="button" class="layui-btn layui-btn-primary" onclick="location.href='${re.contextPath}/studentInformation/getStudentIndex';">返回首页</button>
            <input id="start" type="hidden" data-method="setTop" class="layui-btn" value="${rel}"></input>
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
        <form class="layui-form" method="post" action="${re.contextPath}/studentInformation/addStudentInformations" enctype="multipart/form-data">
            <input id="start" type="hidden" data-method="setTop" class="layui-btn" value="${certificate_type}"
                    <#if studentInformation.certificate_type ??>
                disabled="disabled"
                    </#if>></input>
            <div class="layui-header">
                <p>提示:</p>
                <p>(注：带*符号的项必填)</p>
            </div>
            <div class="layui-form-item">
                <fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
                    <legend style="font-size:16px;font-weight: 700;">基本信息</legend>
                </fieldset>
                <div class="layui-inline">
                    <#--  <h2>选择证件类型</h2>  -->
                    <label for="departmentId" class="layui-form-label">
                        <span class="x-red">*</span>证件类型
                    </label>
                    <div class="layui-input-inline">
                        <select name="certificate_type" id="departmentId" lay-verify="departmentId"
                                lay-filter="departmentId"  <#if studentInformation.certificate_type ??>
                            disabled="disabled"
                                </#if>>
                            <#if studentInformation.certificate_type ??>
                                <option value="${studentInformation.certificate_type}">${studentInformation.certificate_type}</option>
                            </#if>
                            <option value="">请选择证件类型</option>
                            <option value="身份证">身份证</option>
                        </select>
                    </div>
                </div>
                <div class="layui-inline">
                    <label for="uname" class="layui-form-label">
                        <span class="x-red">*</span>证件号码
                    </label>
                    <div class="layui-input-inline w-22">
                        <input type="text" id="uname" name="certificate_number" lay-verify="username"  <#if studentInformation.certificate_number ??>
                            disabled="disabled"
                        </#if>
                               autocomplete="off" class="layui-input" placeholder="请输入证件号码" value="${studentInformation.certificate_number} ">
                    </div>
                </div>
                <div class="layui-inline">
                    <label for="uname" class="layui-form-label">
                        <span class="x-red">*</span>民族
                    </label>
                    <div class="layui-input-inline">
                        <select name="nation" id="departmentId" lay-verify="departmentId"
                                lay-filter="departmentId" <#if studentInformation.nation ??>
                            disabled="disabled"
                                </#if>>
                            <#if studentInformation.nation ??>
                                <option value="${studentInformation.nation}">${studentInformation.nation}</option>
                            </#if>
                            <option value="">请选择民族</option>
                            <option value="汉族">汉族</option>
                            <option value="少数民族">少数民族</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label for="departmentId" class="layui-form-label">
                        <span class="x-red">*</span>姓名
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="uname" name="name" lay-verify="username" <#if studentInformation.name ??>
                            disabled="disabled"
                        </#if>
                               autocomplete="off" class="layui-input" placeholder="请输入姓名" value="${studentInformation.name}">
                    </div>
                </div>
                <div class="layui-inline">
                    <label for="uname" class="layui-form-label">
                        <span class="x-red">*</span>出生日期
                    </label>
                    <div class="layui-input-inline w-22">
                        <input type="text" name="birthdate" class="layui-input" id="test1" placeholder="yyyy-MM-dd" value="${studentInformation.birthdate}"
                                <#if studentInformation.birthdate ??>
                            disabled="disabled"
                                </#if>>
                    </div>
                </div>
                <div class="layui-inline">
                    <label for="uname" class="layui-form-label">
                        <span class="x-red">*</span>性别
                    </label>
                    <div class="layui-input-inline">
                        <select name="sex" id="departmentId" lay-verify="departmentId"
                                lay-filter="departmentId"  <#if studentInformation.sex ??>
                            disabled="disabled"
                                </#if>>
                            <#if studentInformation.sex ??>
                                <option value="${studentInformation.sex}">${studentInformation.sex}</option>
                            </#if>
                            <option value="">请选择性别</option>
                            <option value="男">男</option>
                            <option value="女">女</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label for="departmentId" class="layui-form-label">
                        <span class="x-red">*</span>收件人
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="uname" name="recipient" lay-verify="username"
                               autocomplete="off" class="layui-input" placeholder="请输入收件人" value="${studentInformation.recipient}"
                                <#if studentInformation.recipient ??>
                            disabled="disabled"
                                </#if>>
                    </div>
                </div>
                <div class="layui-inline">
                    <label for="uname" class="layui-form-label">
                        <span class="x-red">*</span>街道详情
                    </label>
                    <div class="layui-input-inline" style="width: 360px;">
                        <input type="text" id="uname" name="street" lay-verify="username"
                               autocomplete="off" class="layui-input" placeholder="请输入街道详情" value="${studentInformation.street}"
                                <#if studentInformation.street ??>
                            disabled="disabled"
                                </#if>>
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label for="departmentId" class="layui-form-label">
                        <span class="x-red">*</span>邮政编码
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="uname" name="postal_code" lay-verify="username"
                               autocomplete="off" class="layui-input" placeholder="请输入邮政编码" value="${studentInformation.postal_code}"
                                <#if studentInformation.postal_code ??>
                            disabled="disabled"
                                </#if>>
                    </div>
                </div>
                <div class="layui-inline">
                    <label for="email" class="layui-form-label">
                        <span class="x-red">*</span>电子邮箱
                    </label>
                    <div class="layui-input-inline w-22">
                        <input type="text" id="email" name="email" lay-verify="required|email"
                               autocomplete="off" class="layui-input" placeholder="请输入电子邮箱" value="${studentInformation.email}"
                                <#if studentInformation.email ??>
                            disabled="disabled"
                                </#if>>
                    </div>
                </div>
                <div class="layui-inline">
                    <label for="uname" class="layui-form-label">
                        <span class="x-red">*</span>本人手机
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="uname" name="phone" lay-verify="required|phone"
                               autocomplete="off" class="layui-input" placeholder="请输入本人手机" value="${studentInformation.phone}" <#if studentInformation.phone ??>
                            disabled="disabled"
                                </#if>>
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
                    <legend style="font-size:16px;font-weight: 700;">学籍信息</legend>
                </fieldset>
                <div class="layui-inline">
                    <label for="uname" class="layui-form-label">
                        <span class="x-red">*</span>考生类型
                    </label>
                    <div class="layui-input-inline">
                        <select name="examinee_type" id="departmentId" lay-verify="departmentId"
                                lay-filter="departmentId" <#if studentInformation.examinee_type ??>
                            disabled="disabled"
                                </#if>>
                            <#if studentInformation.examinee_type ??>
                                <option value="${studentInformation.examinee_type}">${studentInformation.examinee_type}</option>
                            </#if>
                            <option value="">请选择考生类型</option>
                            <option value="高中生">高中生</option>
                            <option value="大学生">大学生</option>
                        </select>
                    </div>
                </div>
                <div class="layui-inline">
                    <label for="uname" class="layui-form-label">
                        <span class="x-red">*</span>考生学历
                    </label>
                    <div class="layui-input-inline w-22">
                        <select name="examinee_education" id="departmentId" lay-verify="departmentId"
                                lay-filter="departmentId" <#if studentInformation.examinee_education ??>
                            disabled="disabled"
                                </#if>>
                            <#if studentInformation.examinee_education ??>
                                <option value="${studentInformation.examinee_education}">${studentInformation.examinee_education}</option>
                            </#if>
                            <option value="">请选择考生学历</option>
                            <option value="高中">高中</option>
                            <option value="中专">中专</option>
                            <option value="大专">大专</option>
                            <option value="本科">本科</option>
                        </select>
                    </div>
                </div>
                <div class="layui-inline">
                    <label for="uname" class="layui-form-label">
                        <span class="x-red">*</span>考生省份
                    </label>
                    <div class="layui-input-inline">
                        <select name="examinee_province" id="departmentId" lay-verify="departmentId"
                                lay-filter="departmentId" <#if studentInformation.examinee_province ??>
                            disabled="disabled"
                                </#if>>
                            <#if studentInformation.examinee_province ??>
                                <option value="${studentInformation.examinee_province}">${studentInformation.examinee_province}</option>
                            </#if>
                            <option value="">请选择考生省份</option>
                            <option value ="北京市">北京市 </option>
                            <option value ="天津市">天津市 </option>
                            <option value ="上海市">上海市 </option>
                            <option value ="重庆市">重庆市 </option>
                            <option value ="河北省">河北省 </option>
                            <option value ="山西省">山西省 </option>
                            <option value ="辽宁省">辽宁省 </option>
                            <option value ="吉林省">吉林省 </option>
                            <option value ="黑龙江省">黑龙江省</option>
                            <option value ="江苏省">江苏省 </option>
                            <option value ="浙江省">浙江省 </option>
                            <option value ="安徽省">安徽省 </option>
                            <option value ="福建省">福建省 </option>
                            <option value ="江西省">江西省 </option>
                            <option value ="山东省">山东省 </option>
                            <option value ="河南省">河南省 </option>
                            <option value ="湖北省">湖北省 </option>
                            <option value ="湖南省">湖南省 </option>
                            <option value ="广东省">广东省 </option>
                            <option value ="海南省">海南省 </option>
                            <option value ="四川省">四川省 </option>
                            <option value ="贵州省">贵州省 </option>
                            <option value ="云南省">云南省 </option>
                            <option value ="陕西省">陕西省 </option>
                            <option value ="甘肃省">甘肃省 </option>
                            <option value ="青海省">青海省 </option>
                            <option value ="台湾省">台湾省 </option>
                            <option value ="广西壮族自治区">广西壮族自治区</option>
                            <option value ="内蒙古自治区">内蒙古自治区</option>
                            <option value ="西藏自治区">西藏自治区</option>
                            <option value ="宁夏回族自治区">宁夏回族自治区 </option>
                            <option value ="新疆维吾尔自治区">新疆维吾尔自治区</option>
                            <option value ="香港特别行政区">香港特别行政区</option>
                            <option value ="澳门特别行政区">澳门特别行政区</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label for="uname" class="layui-form-label">
                        <span class="x-red">*</span>政治面貌
                    </label>
                    <div class="layui-input-inline">
                        <select name="politics_status" id="departmentId" lay-verify="departmentId"
                                lay-filter="departmentId" <#if studentInformation.politics_status ??>
                            disabled="disabled"
                                </#if>>
                            <#if studentInformation.politics_status ??>
                                <option value="${studentInformation.politics_status}">${studentInformation.politics_status}</option>
                            </#if>
                            <option value="">请选择政治面貌</option>
                            <option value="群众">群众</option>
                            <option value="团员">团员</option>
                            <option value="党员">党员</option>
                        </select>
                    </div>
                </div>
                <div class="layui-inline">
                    <label for="uname" class="layui-form-label">
                        <span class="x-red">*</span>应往届
                    </label>
                    <div class="layui-input-inline w-22">
                        <select name="graduate_type" id="departmentId" lay-verify="departmentId"
                                lay-filter="departmentId" <#if studentInformation.graduate_type ??>
                            disabled="disabled"
                                </#if>>
                            <#if studentInformation.graduate_type ??>
                                <option value="${studentInformation.graduate_type}">${studentInformation.graduate_type}</option>
                            </#if>
                            <option value="">请选择应往届</option>
                            <option value="应届生">应届生</option>
                            <option value="往届生">往届生</option>
                        </select>
                    </div>
                </div>
                <div class="layui-inline">
                    <label for="uname" class="layui-form-label">
                        <span class="x-red">*</span>毕业中学
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="uname" name="graduate_middle" lay-verify="username"
                               autocomplete="off" class="layui-input" placeholder="请输入毕业中学" value="${studentInformation.graduate_middle}"
                                <#if studentInformation.graduate_middle ??>
                            disabled="disabled"
                                </#if>>
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label for="uname" class="layui-form-label">
                        <span class="x-red">*</span>考生号
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="examineeNumber" lay-filter="inputExaminee" name="examinee_number" lay-verify="inputExaminee"
                               autocomplete="off" class="layui-input" placeholder="请输入考生号"  value="${studentInformation.examinee_number}"
                                <#if studentInformation.examinee_number ??>
                            disabled="disabled"
                                </#if>>
                    </div>
                </div>
                <div class="layui-inline">
                    <label for="uname" class="layui-form-label">
                        <span class="x-red">*</span>文理科
                    </label>
                    <div class="layui-input-inline w-22">
                        <select name="subject_type" id="departmentId" lay-verify="departmentId"
                                lay-filter="departmentId" <#if studentInformation.subject_type ??>
                            disabled="disabled"
                                </#if>>
                            <#if studentInformation.subject_type ??>
                                <option value="${studentInformation.subject_type}">${studentInformation.subject_type}</option>
                            </#if>
                            <option value="">请选择文理科</option>
                            <option value="文科">文科</option>
                            <option value="理科">理科</option>
                        </select>
                    </div>
                </div>
            </div>
            <div id="family-box">
                <fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
                    <legend style="font-size:16px;font-weight: 700;">家庭信息（至少填写一位考生监护人）<i class="layui-icon" onclick="addAction()">&#xe654;</i></legend>
                </fieldset>
                <div class="layui-form-item" id="one">
                    <div class="layui-inline">
                        <label for="uname" class="layui-form-label">
                            <span class="x-red">*</span>姓名
                        </label>
                        <div class="layui-input-inline">
                            <input type="text" id="uname" name="member_name" lay-verify="username"
                                   autocomplete="off" class="layui-input" placeholder="请输入姓名" value="${studentInformation.member_name}"
                                    <#if studentInformation.member_name ??>
                                disabled="disabled"
                                    </#if>>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label for="uname" class="layui-form-label">
                            <span class="x-red">*</span>关系
                        </label>
                        <div class="layui-input-inline w-22">
                            <input type="text" id="uname" name="member_relationship" lay-verify="username"
                                   autocomplete="off" class="layui-input" placeholder="请输入关系" value="${studentInformation.member_relationship}"
                                    <#if studentInformation.member_relationship ??>
                                disabled="disabled"
                                    </#if>>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label for="uname" class="layui-form-label">
                            <span class="x-red">*</span>职业
                        </label>
                        <div class="layui-input-inline">
                            <input type="text" id="uname" name="member_occupation" lay-verify="username"
                                   autocomplete="off" class="layui-input" placeholder="请输入职业" value="${studentInformation.member_occupation}"
                                    <#if studentInformation.member_occupation ??>
                                disabled="disabled"
                                    </#if>>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label for="uname" class="layui-form-label">
                            <span class="x-red">*</span>手机号码
                        </label>
                        <div class="layui-input-inline">
                            <input type="text" id="uname" name="member_phone" lay-verify="required|phone"
                                   autocomplete="off" class="layui-input" placeholder="请输入手机号码" value="${studentInformation.member_phone}"
                                    <#if studentInformation.member_phone ??>
                                disabled="disabled"
                                    </#if>>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label for="uname" class="layui-form-label">
                            <span class="x-red">*</span>工作单位
                        </label>
                        <div class="layui-input-inline" style="width: 360px;">
                            <input type="text" id="uname" name="member_work" lay-verify="username"
                                   autocomplete="off" class="layui-input" placeholder="请输入工作单位" value="${studentInformation.member_work}"
                                    <#if studentInformation.member_work ??>
                                disabled="disabled"
                                    </#if>>
                        </div>
                    </div>
                </div>
            </div>
            <div id="active"></div>
            <div class="layui-form-item">
                <fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
                    <legend style="font-size:16px;font-weight: 700;">正面照</legend>
                </fieldset>
                <div class="layui-input-inline">
                    <div id="demo2" style="margin-top: 20px;margin-left: 50px">
                        <img src="C:/Users/Administrator/AppData/Local/Temp/tomcat-docbase.6614518231621164549.4430/app/weixin_20191121104932.jpg" width="100px" height="100px"
                             class="layui-upload-img layui-circle">
                    </div>
                </div>
                <input type="file" name="file" id="file" accept="image/*" onchange="showPic(this)" style="visibility:hidden;position:absolute;top:0px;width:0px" />
                <input type="button" value="upload" id="upload" style="visibility:hidden;position:absolute;top:0px;width:0px"/>
            </div>
            <div>
                <div style="display: flex;justify-content: center;align-items: center;min-height: 80px;">
                    <button style="width: 150px;height: 40px;" type="submit" class="layui-btn" lay-submit="" lay-filter="submits" <#if studentInformation.student_id ??>
                        disabled="disabled"
                            </#if>>新增</button>
                    <button style="width: 150px;height: 40px;" type="button" class="layui-btn layui-btn-normal" onclick="location.href='${re.contextPath}/studentInformation/getSelectExam';">下一步</button>
                </div>
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
</div>
<script>
    $( function rel(){
        var rel=$("#start").val();
        if(rel!=""&&rel!=null){
            alert(rel);
        }
    });
    layui.use(['jquery', 'steps', 'form', 'laydate', 'upload'], function(){

        var $ = layui.$;
        var $step= $("#step_demo").step();
        $step.goStep(1);//到指定步
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

        //自定义验证规则
        form.verify({

            inputExaminee: function(value){
                if(!(/^\d{14}$/.test(value))){
                    return '请输入14位数的考生号';
                }
            },
        });

    });
    $('#demo2').click(function() {
        $('#file').click();
    })
    function showPic(source) {
        var file = source.files[0];
        if (window.FileReader) {
            var fr = new FileReader();
            fr.onloadend = function(e) {
                // submit提交
                $('#upload').click();
                console.log(e.target.result)
                $("#demo2 img").attr('src', e.target.result)
            };
            fr.readAsDataURL(file);
        }
    }

</script>
</body>

</html>
