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
    <title>考生复试成绩管理</title>
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
        考试名称：
        <div class="layui-inline">
            <select class="layui-input" height="20px" id="exam_id" autocomplete="off">
                <option value="">全部</option>
                <#list list as list>
                    <option value="${list.id}">${list.exam}</option>
                </#list>
            </select>
        </div>
        专业：
        <div class="layui-inline">
            <select class="layui-input" height="20px" id="specialty_id" autocomplete="off">
                <option value="">全部</option>
                <#list list2 as list2>
                    <option value="${list2.id}">${list2.name}</option>
                </#list>
            </select>
        </div>
        <#--生源地：
        <div class="layui-inline">
            <select class="layui-input" height="20px" id="province_id" autocomplete="off">
                <option value="0">全部</option>
                <option value="1">北京</option>
                <option value="2">上海</option>
                <option value="3">深圳</option>
            </select>
        </div>-->
        考试搜索：
        <div class="layui-inline">
            <input class="layui-input" height="20px" id="exam" autocomplete="off">
        </div>
        <#--考试：
        <div class="layui-inline">
            <input class="layui-input" height="20px" id="uname" autocomplete="off">
        </div>
        电话：
        <div class="layui-inline">
            <input class="layui-input" height="20px" id="email" autocomplete="off">
        </div>-->
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

        <button class="layui-btn layui-btn-normal" data-type="quanxuan" lay-filter="quanxuan">
            <i class="layui-icon">&#xe605;</i>全选
        </button>

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
<table id="achievementLastList" class="layui-hide" lay-filter="achieve"></table>

<script type="text/html" id="ChaxunDemo">
    <a class="layui-btn layui-btn-xs  layui-btn-normal" lay-event="opening">开启</a>
    <a class="layui-btn layui-btn-xs  layui-btn-normal" lay-event="closing">关闭</a>
</script>

<script type="text/html" id="hgzDemo">
    <a class="layui-btn layui-btn-xs  layui-btn-normal" lay-event="openinghgz">开启</a>
    <a class="layui-btn layui-btn-xs  layui-btn-normal" lay-event="closinghgz">关闭</a>
</script>

<script type="text/html" id="barDemo">
    <#---->
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-xs  layui-btn-normal" id="intoing" lay-event="intoing">导入</a>
    <a class="layui-btn layui-btn-xs  layui-btn-normal" lay-event="inout">导出</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="deling">删除</a>
    <#--<@shiro.hasPermission name="user:update">
      <a class="layui-btn layui-btn-xs  layui-btn-normal" lay-event="edit">编辑</a>
    </@shiro.hasPermission>
    <@shiro.hasPermission name="user:del">
      <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    </@shiro.hasPermission>-->
</script>
<script type="text/html" id="switchTpl">
    <input type="checkbox" name="sex" lay-skin="switch" lay-text="女|男" lay-filter="sexDemo">
</script>
<script>
    document.onkeydown = function (e) { // 回车提交表单
        var theEvent = window.event || e;
        var code = theEvent.keyCode || theEvent.which;
        if (code == 13) {
            $(".select .select-on").click();
        }
    }
    layui.use(['table', 'upload'], function () {
        var table = layui.table,upload = layui.upload;



        //方法级渲染
        table.render({
            id: 'achievementLastList',
            elem: '#achievementLastList'
            , url: 'showachievementLastList'
            , cols: [[
                {checkbox: true, fixed: true, width: '5%'}
                , {
                    type: 'numbers',
                    fixed: true,
                    title: '序号',
                    width: '5%'
                }
                , {field: 'exam', title: '考试名称', width: '20%'}
                , {field: 'specialty_id', title: '专业', width: '15%'}
                , {field: 'grade2', title: '成绩开关状态', width: '10%',sort: true}
                , {fixed: 'right', field: 'right',title: '开关操作',toolbar: "#ChaxunDemo"}
                , {field: 'certificate', title: '合格证开关状态', width: '10%',sort: true}
                , {fixed: 'right', field: 'right',title: '开关操作',toolbar: "#hgzDemo"}
                , {fixed: 'right', field: 'right', title: '操作', toolbar: "#barDemo"}
            ]],
            done: function(res, curr, count) {
                $("[data-field='grade2']").children().each(function () {
                    if ($(this).text() == "1") {
                        $(this).text("开启");
                    } else if($(this).text() == "0") {
                        $(this).text("关闭");
                    }
                });
                $("[data-field='certificate']").children().each(function () {
                    if ($(this).text() == "1") {
                        $(this).text("开启");
                    } else if($(this).text() == "0") {
                        $(this).text("关闭");
                    }
                });
                $("[data-field='specialty_id']").children().each(function () {
                    if($(this).text()!="专业"){
                        var name;
                        $.ajax({
                            url: "selectSpecialty_NameById",
                            type: "post",
                            data: {"id": $(this).text()},
                            async: false,
                            success: function (d) {
                                name=d;
                            }, error: function () {
                                alert('error');
                            }
                        });
                        $(this).text(name);
                    }
                });
            }
            , page: true

        });

        var flagqx = 1;
        var $ = layui.$, active = {
            select: function () {
                var exam_id = $('#exam_id').val();
                var specialty_id = $('#specialty_id').val();
                var exam = $('#exam').val();

                table.reload('achievementLastList', {
                    where: {
                        id: exam_id,
                        specialty_id: specialty_id,
                        exam: exam
                    }
                });
            },
            reload: function () {
                $('#exam_id').val('');
                $('#specialty_id').val('');
                $('#exam').val('');
                table.reload('achievementLastList', {
                    where: {
                        id: null,
                        specialty_id: null,
                        exam: null
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
                add('新建信息采集模板', 'achievementFirstGradeList',900, 680);
            },

            batch: function () {
                var checkStatus = table.checkStatus('achievementLastList')
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
                    batchUpdateAudit(id,status, 'achievementLastList');  //批量审核
                });

                //layerAjax('batchUpdateAudit', data.field, 'auditList');
            },
            update: function () {
                var checkStatus = table.checkStatus('achievementLastList')
                    , data = checkStatus.data;
                if (data.length != 1) {
                    layer.msg('请选择一行编辑,已选[' + data.length + ']行', {icon: 5});
                    return false;
                }
                update('编辑用户', 'updateUser?id=' + data[0].id, 700, 450);
            },
            detail: function () {
                var checkStatus = table.checkStatus('achievementLastList')
                    , data = checkStatus.data;
                if (data.length != 1) {
                    layer.msg('请选择一行查看,已选[' + data.length + ']行', {icon: 5});
                    return false;
                }
                detail('查看用户信息', 'updateUser?id=' + data[0].id, 700, 450);
            }

        };

        //监听表格复选框选择
        table.on('checkbox(achieve)', function (obj) {
            console.log(obj)
        });

        //监听工具条
        table.on('tool(achieve)', function (obj) {
            var data = obj.data;
            var name;
            $.ajax({
                url: "selectSpecialty_NameById",
                type: "post",
                data: {"id": data.specialty_id},
                async: false,
                success: function (d) {
                    name=d;
                }, error: function () {
                    alert('error');
                }
            });
            if (obj.event === 'detail') {
                detail("[  " + data.exam + "  ] "+ name + " 专业"+ '  复试成绩', 'achievementLastGradeList?id=' + data.id, 1200, 680);
            } else if (obj.event === 'opening') {
                if (data.grade2 === 0) {
                    layer.confirm('确定开启?', {
                        btn: ['确认', '取消']
                    }, function (index) {
                        layer.close(index);
                        $.ajax({
                            url: "updateGrade_switch2",
                            type: "post",
                            data: {"id": data.id, "status": "1"},
                            success: function (d) {
                                if (d.flag) {
                                    window.layui.table.reload('achievementLastList');
                                    window.top.layer.msg(d.msg, {
                                        icon: 6,
                                        offset: 'rb',
                                        area: ['120px', '80px'],
                                        anim: 2
                                    });
                                } else {
                                    window.top.layer.msg(d.msg, {
                                        icon: 6,
                                        offset: 'rb',
                                        area: ['120px', '80px'],
                                        anim: 2
                                    });
                                }
                            }, error: function () {
                                alert('error');
                            }
                        });
                    });
                } else {
                    window.top.layer.msg('已开启', {icon: 5, offset: 'rb', area: ['120px', '80px'], anim: 2});
                }
            } else if (obj.event === 'closing') {
                if (data.grade2 === 1) {
                    layer.confirm('确定关闭?', {
                        btn: ['确认', '取消']
                    }, function (index) {
                        layer.close(index);
                        $.ajax({
                            url: "updateGrade_switch2",
                            type: "post",
                            data: {"id": data.id, "status": "0"},
                            success: function (d) {
                                if (d.flag) {
                                    window.layui.table.reload('achievementLastList');
                                    window.top.layer.msg(d.msg, {
                                        icon: 6,
                                        offset: 'rb',
                                        area: ['120px', '80px'],
                                        anim: 2
                                    });
                                } else {
                                    window.top.layer.msg(d.msg, {
                                        icon: 6,
                                        offset: 'rb',
                                        area: ['120px', '80px'],
                                        anim: 2
                                    });
                                }
                            }, error: function () {
                                alert('error');
                            }
                        });
                    });
                } else {
                    window.top.layer.msg('已关闭', {icon: 5, offset: 'rb', area: ['120px', '80px'], anim: 2});
                }
            } else if (obj.event === 'deling') {
                layer.confirm('确认删除[  '+data.exam + ' ] '+ name + ' 专业的所有成绩?', {
                    btn: ['确认', '取消']
                }, function (index) {
                    layer.close(index);
                    $.ajax({
                        url: "delLastGradeById",
                        type: "post",
                        data: {"id": data.id},
                        success: function (d) {
                            if (d.flag) {
                                window.layui.table.reload('achievementLastList');
                                window.top.layer.msg(d.msg, {icon: 6, offset: 'rb', area: ['120px', '80px'], anim: 2});
                            } else {
                                window.top.layer.msg(d.msg, {icon: 6, offset: 'rb', area: ['120px', '80px'], anim: 2});
                            }
                        }, error: function () {
                            alert('error');
                        }
                    });
                });
            } else if (obj.event === 'intoing') {
                add("[  " + data.exam + "  ] "+ name + " 专业——导入", 'achievementLastInto?id=' + data.id, 700, 300);
            } else if (obj.event === 'inout') {
                layer.confirm('确认导出 [' + data.exam + ']'+name+' 专业 学生信息表?', {
                    btn: ['确认', '取消']
                }, function (index) {
                    layer.close(index);
                    location.href="inout_achieveLastGrade?id="+data.id+"&name="+data.exam;
                });
            } else if (obj.event === 'openinghgz') {
                if (data.certificate === 0) {
                    layer.confirm('确定开启?', {
                        btn: ['确认', '取消']
                    }, function (index) {
                        layer.close(index);
                        $.ajax({
                            url: "updateGrade_Hgswitch",
                            type: "post",
                            data: {"id": data.id, "status": "1"},
                            success: function (d) {
                                if (d.flag) {
                                    window.layui.table.reload('achievementLastList');
                                    window.top.layer.msg(d.msg, {
                                        icon: 6,
                                        offset: 'rb',
                                        area: ['120px', '80px'],
                                        anim: 2
                                    });
                                } else {
                                    window.top.layer.msg(d.msg, {
                                        icon: 6,
                                        offset: 'rb',
                                        area: ['120px', '80px'],
                                        anim: 2
                                    });
                                }
                            }, error: function () {
                                alert('error');
                            }
                        });
                    });
                } else {
                    window.top.layer.msg('已开启', {icon: 5, offset: 'rb', area: ['120px', '80px'], anim: 2});
                }
            } else if (obj.event === 'closinghgz') {
                if (data.certificate === 1) {
                    layer.confirm('确定关闭?', {
                        btn: ['确认', '取消']
                    }, function (index) {
                        layer.close(index);
                        $.ajax({
                            url: "updateGrade_Hgswitch",
                            type: "post",
                            data: {"id": data.id, "status": "0"},
                            success: function (d) {
                                if (d.flag) {
                                    window.layui.table.reload('achievementLastList');
                                    window.top.layer.msg(d.msg, {
                                        icon: 6,
                                        offset: 'rb',
                                        area: ['120px', '80px'],
                                        anim: 2
                                    });
                                } else {
                                    window.top.layer.msg(d.msg, {
                                        icon: 6,
                                        offset: 'rb',
                                        area: ['120px', '80px'],
                                        anim: 2
                                    });
                                }
                            }, error: function () {
                                alert('error');
                            }
                        });
                    });
                } else {
                    window.top.layer.msg('已关闭', {icon: 5, offset: 'rb', area: ['120px', '80px'], anim: 2});
                }
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
        var index =layer.open({
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
        layer.full(index);
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
