<#-- Created by IntelliJ IDEA.
 User: Administrator
 Date: 2017/12/6
 Time: 14:00
 To change this template use File | Settings | File Templates.
 用户管理-->
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>考生初试成绩管理-查看</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <link rel="stylesheet" href="${re.contextPath}/plugin/layui/css/layui.css">
    <link rel="stylesheet" href="${re.contextPath}/plugin/lenos/main.css">
    <script type="text/javascript" src="${re.contextPath}/plugin/jquery/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${re.contextPath}/plugin/layui/layui.all.js"
            charset="utf-8"></script>
    <script type="text/javascript" src="${re.contextPath}/plugin/tools/tool.js"></script>

</head>

<body>
<div class="lenos-search">
    <div class="select">
        高考省份：
        <div class="layui-inline">
            <select class="layui-input" height="20px" id="high_province" autocomplete="off">
                <option value="">全部</option>
                <#list list as list>
                    <option value="${list}">${list}</option>
                </#list>
            </select>
        </div>
        考生姓名：
        <div class="layui-inline">
            <input class="layui-input" height="20px" id="name" autocomplete="off">
        </div>
        考生号：
        <div class="layui-inline">
            <input class="layui-input" height="20px" id="examinee_num" autocomplete="off">
        </div>
        <button class="select-on layui-btn layui-btn-sm" data-type="select"><i class="layui-icon"></i>
        </button>
        <button class="layui-btn layui-btn-sm icon-position-button" id="refresh" style="float: right;"
                data-type="reload">
            <i class="layui-icon">ဂ</i>
        </button>
    </div>

</div>
<div class="layui-col-md12" style="height:40px;margin-top:3px;">
    <div class="layui-btn-group">

        <#--<button class="layui-btn layui-btn-normal" data-type="quanxuan" lay-filter="quanxuan">
            <i class="layui-icon">&#xe605;</i>全选
        </button>-->

        <#--<button class="layui-btn layui-btn-normal" data-type="batch">
            <i class="layui-icon">&#xe608;</i>导入
        </button>

        <button class="layui-btn layui-btn-normal" data-type="batch">
            <i class="layui-icon">&#xe608;</i>导出
        </button>-->

        <#--<button class="layui-btn layui-btn-normal" data-type="batch">
            <i class="layui-icon">&#xe608;</i>批量审核
        </button>-->
      <#--<@shiro.hasPermission name="user:select">
      <button class="layui-btn layui-btn-normal" data-type="add">
          <i class="layui-icon">&#xe608;</i>新增
      </button>
      </@shiro.hasPermission>
    <@shiro.hasPermission name="user:select">
    <button class="layui-btn layui-btn-normal" data-type="update">
        <i class="layui-icon">&#xe642;</i>编辑
    </button>
    </@shiro.hasPermission>
<@shiro.hasPermission name="user:del">
    <button class="layui-btn layui-btn-normal" data-type="detail">
        <i class="layui-icon">&#xe605;</i>查看
    </button>
</@shiro.hasPermission>
    <@shiro.hasPermission name="user:repass">
    <button class="layui-btn layui-btn-normal" data-type="changePwd">
        <i class="layui-icon">&#xe605;</i>重置密码
    </button>
    </@shiro.hasPermission>-->
    </div>
</div>
<table id="achievementFirstGradeList" class="layui-hide" lay-filter="achieveFirst"></table>


<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs  layui-btn-normal" lay-event="detail">编辑</a>
</script>
<script>
    document.onkeydown = function (e) { // 回车提交表单
        var theEvent = window.event || e;
        var code = theEvent.keyCode || theEvent.which;
        if (code == 13) {
            $(".select .select-on").click();
        }
    }


    layui.use('table', function () {
        var table = layui.table;

        //方法级渲染
        table.render({
            id: 'achievementFirstGradeList',
            elem: '#achievementFirstGradeList'
            , url: 'show_achievementFirstGradeList'
            , cols: [[
                {checkbox: true, fixed: true, width: 50}
                , {type: 'numbers',fixed: true,title: '序号',width: 80 }
                , {field: 'id_card', title: '身份证号',width:196}
                , {field: 'name', title: '姓名',width:127}
                , {field: 'gender', title: '性别',width:80}
                , {field: 'high_province', title: '高考省份',width:120}
                , {field: 'examinee_num', title: '考生号',width:180}
                , {field: 'ticket_num', title: '准考证号',width:180}
                , {field: 'wl_subject', title: '文理科',width:80}
                , {field: 'professional_code', title: '专业代码',width:130}
                , {field: 'professional_name', title: '专业名称', width:160}
                , {field: 'national_rankings', title: '全国排名', width: 100}
                , {field: 'national_same_name', title: '全国同名次', width: 100}
                , {field: 'provincial_ranking', title: '省排名', width: 100}
                , {field: 'provincial_same_name', title: '省同名次', width: 100}
                , {field: 'qualified_mark', title: '合格Y/N', width: 100}
                , {field: 'qualified_line', title: '合格线', width: 100}
                , {field: 'first_subjects_name1', title: '科目1名称', width: 100}
                , {field: 'first_subjects_achieve1', title: '科目1成绩', width: 100}
                , {field: 'first_subjects_name2', title: '科目2名称', width: 100}
                , {field: 'first_subjects_achieve2', title: '科目2成绩', width: 100}
                , {field: 'first_subjects_name3', title: '科目3名称', width: 100}
                , {field: 'first_subjects_achieve3', title: '科目3成绩', width: 100}
                , {field: 'first_subjects_name4', title: '科目4名称', width: 100}
                , {field: 'first_subjects_achieve4', title: '科目4成绩', width: 100}
                , {field: 'first_subjects_name5', title: '科目5名称', width: 100}
                , {field: 'first_subjects_achieve5', title: '科目5成绩', width: 100}
                , {field: 'first_subjects_name6', title: '科目6名称', width: 100}
                , {field: 'first_subjects_achieve6', title: '科目6成绩', width: 100}
                , {field: 'first_subjects_total', title: '总分', width: 100,fixed: 'right'}
                //, {fixed: 'right', field: 'right', title: '操作', toolbar: "#barDemo",width: '6%'}
            ]],
            done: function(res, curr, count) {
                $("[data-field='national_rankings']").children().each(function () {
                    if ($(this).text() == "0")
                        $(this).text("");
                });
                $("[data-field='national_same_name']").children().each(function () {
                    if ($(this).text() == "0")
                        $(this).text("");
                });
                $("[data-field='provincial_ranking']").children().each(function () {
                    if ($(this).text() == "0")
                        $(this).text("");
                });
                $("[data-field='provincial_same_name']").children().each(function () {
                    if ($(this).text() == "0")
                        $(this).text("");
                });
                $("[data-field='qualified_line']").children().each(function () {
                    if ($(this).text() == "0")
                        $(this).text("");
                });
                $("[data-field='first_subjects_achieve1']").children().each(function () {
                    if ($(this).text() == "0")
                        $(this).text("");
                });
                $("[data-field='first_subjects_achieve2']").children().each(function () {
                    if ($(this).text() == "0")
                        $(this).text("");
                });
                $("[data-field='first_subjects_achieve3']").children().each(function () {
                    if ($(this).text() == "0")
                        $(this).text("");
                });
                $("[data-field='first_subjects_achieve4']").children().each(function () {
                    if ($(this).text() == "0")
                        $(this).text("");
                });
                $("[data-field='first_subjects_achieve5']").children().each(function () {
                    if ($(this).text() == "0")
                        $(this).text("");
                });
                $("[data-field='first_subjects_achieve6']").children().each(function () {
                    if ($(this).text() == "0")
                        $(this).text("");
                });
                $("[data-field='first_subjects_total']").children().each(function () {
                    if ($(this).text() == "0")
                        $(this).text("");
                });
            }
            , page: true

        });
        var flagqx = 1;
        var $ = layui.$, active = {
            select: function () {
                var high_province = $('#high_province').val();
                var name = $('#name').val();
                var examinee_num = $('#examinee_num').val();
                table.reload('achievementFirstGradeList', {
                    where: {
                        high_province:high_province,
                        name:name,
                        examinee_num:examinee_num
                    }
                });
            },
            reload: function () {
                $('#high_province').val('');
                $('#name').val('');
                $('#examinee_num').val('');
                table.reload('achievementFirstGradeList', {
                    where: {
                        high_province:null,
                        name:null,
                        examinee_num:null
                    }
                });
            },
            quanxuan: function () {
                $("body").find("input[type='checkbox']").next().click();
                /*if(flagqx==1){
                    $("body").find("input[type='checkbox']").next().addClass("layui-form-checked");
                    $("body").find("input[type='checkbox']").prop('checked',true);
                    flagqx = 2;
                }else{
                    $("body").find("input[type='checkbox']").next().removeClass("layui-form-checked");
                    $("body").find("input[type='checkbox']").prop('checked',false);
                    flagqx =1;
                }*/
                //form.render('checkbox');
            },

            add: function () {
                add('新建信息采集模板', 'addinfor_collect',900, 680);
            },

            batch: function () {
                var checkStatus = table.checkStatus('achievementFirstList')
                    , data = checkStatus.data;
                if (data.length == 0) {
                    layer.msg('请至少选择一行编辑,已选[' + data.length + ']行', {icon: 5});
                    return false;
                }

                layer.confirm('确认 批量审核操作?', {
                    btn: ['确认', '取消']
                }, function (index) {
                    layer.close(index);
                    //batchUpdateAudit(id, 'auditList');
                    var id=[];
                    var status=[];
                    for (var i=0;i<data.length;i++){
                        id.push(data[i].id);
                        var num = 1;
                        if(data[i].enroll_status == "报名成功" || data[i].enroll_status == "报名不成功"){
                            num=2;
                        }
                        status.push(num);
                    }
                    batchUpdateAudit(id,status, 'achievementFirstGradeList');  //批量审核
                });

                //layerAjax('batchUpdateAudit', data.field, 'auditList');
            },
            update: function () {
                var checkStatus = table.checkStatus('achievementFirstGradeList')
                        , data = checkStatus.data;
                if (data.length != 1) {
                    layer.msg('请选择一行编辑,已选[' + data.length + ']行', {icon: 5});
                    return false;
                }
                update('编辑用户', 'updateUser?id=' + data[0].id, 700, 450);
            },
            detail: function () {
                var checkStatus = table.checkStatus('achievementFirstGradeList')
                        , data = checkStatus.data;
                if (data.length != 1) {
                    layer.msg('请选择一行查看,已选[' + data.length + ']行', {icon: 5});
                    return false;
                }
                detail('查看用户信息', 'updateUser?id=' + data[0].id, 700, 450);
            }

        };

        //监听表格复选框选择
        table.on('checkbox(achieveFirst)', function (obj) {
            console.log(obj)
        });
        //监听工具条
        table.on('tool(achieveFirst)', function (obj) {
            var data = obj.data;
            if (obj.event === 'detail') {
                detail('查看用户', 'updinfor_collect?id=' + data.id, 900, 680);
            } else if (obj.event === 'opening') {
                if(data.grade === 0){
                    layer.confirm('确定开启?', {
                        btn: ['确认', '取消']
                    }, function (index) {
                        layer.close(index);
                        $.ajax({
                            url: "updateGrade_switch",
                            type: "post",
                            data: {"id":data.id,"status":"1"},
                            success: function (d) {
                                if (d.flag) {
                                    window.layui.table.reload('achievementFirstGradeList');
                                    window.top.layer.msg(d.msg, {icon: 6, offset: 'rb', area: ['120px', '80px'], anim: 2});
                                } else {
                                    window.top.layer.msg(d.msg, {icon: 6, offset: 'rb', area: ['120px', '80px'], anim: 2});
                                }
                            }, error: function () {
                                alert('error');
                            }
                        });
                    });
                }else {
                    window.top.layer.msg('已开启', {icon: 5, offset: 'rb', area: ['120px', '80px'], anim: 2});
                }

            } else if (obj.event === 'closing') {
                if(data.grade === 1){
                    layer.confirm('确定关闭?', {
                        btn: ['确认', '取消']
                    }, function (index) {
                        layer.close(index);
                        $.ajax({
                            url: "updateGrade_switch",
                            type: "post",
                            data: {"id":data.id,"status":"0"},
                            success: function (d) {
                                if (d.flag) {
                                    window.layui.table.reload('achievementFirstGradeList');
                                    window.top.layer.msg(d.msg, {icon: 6, offset: 'rb', area: ['120px', '80px'], anim: 2});
                                } else {
                                    window.top.layer.msg(d.msg, {icon: 6, offset: 'rb', area: ['120px', '80px'], anim: 2});
                                }
                            }, error: function () {
                                alert('error');
                            }
                        });
                    });
                }else {
                    window.top.layer.msg('已关闭', {icon: 5, offset: 'rb', area: ['120px', '80px'], anim: 2});
                }
            }else if (obj.event === 'deling') {
                layer.confirm('确定删除?', {
                    btn: ['确认', '取消']
                }, function (index) {
                    layer.close(index);
                    $.ajax({
                        url: "delinfor_collect",
                        type: "post",
                        data: {"id":data.id},
                        success: function (d) {
                            if (d.flag) {
                                window.layui.table.reload('achievementFirstGradeList');
                                window.top.layer.msg(d.msg, {icon: 6, offset: 'rb', area: ['120px', '80px'], anim: 2});
                            } else {
                                window.top.layer.msg(d.msg, {icon: 6, offset: 'rb', area: ['120px', '80px'], anim: 2});
                            }
                        }, error: function () {
                            alert('error');
                        }
                    });
                });
            }
        });

        $('.layui-col-md12 .layui-btn').on('click', function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
        $('.select .layui-btn').on('click', function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });

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
            id: 'audit-detail',
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

    /**
     * 更新用户
     */
    function update(title, url, w, h) {
        if (title == null || title == '') {
            title = false;
        }
        if (url == null || url == '') {
            url = "404.html";
        }
        if (w == null || w == '') {
            w = ($(window).width() * 0.9);
        }
        if (h == null || h == '') {
            h = ($(window).height() - 50);
        }
        layer.open({
            id: 'user-update',
            type: 2,
            area: [w + 'px', h + 'px'],
            fix: false,
            maxmin: true,
            shadeClose: false,
            shade: 0.4,
            title: title,
            content: url + '&detail=false'
        });
    }

    /*弹出层*/
    /*
     参数解释：
     title   标题
     url     请求的url
     id      需要操作的数据id
     w       弹出层宽度（缺省调默认值）
     h       弹出层高度（缺省调默认值）
     */
    function add(title, url, w, h) {
        if (title == null || title == '') {
            title = false;
        }
        ;
        if (url == null || url == '') {
            url = "404.html";
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
            id: 'info-add',
            type: 2,
            area: [w + 'px', h + 'px'],
            fix: false,
            maxmin: true,
            shadeClose: false,
            shade: 0.4,
            title: title,
            content: url
        });
    }
</script>
</body>

</html>
