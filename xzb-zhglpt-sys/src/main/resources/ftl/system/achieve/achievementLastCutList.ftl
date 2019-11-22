<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>考生复试入围成绩管理</title>
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
        考试：
        <div class="layui-inline">
            <select class="layui-input" height="20px" id="exam_id" autocomplete="off">
                <option value="0">全部</option>
                <#list list as list>
                    <option value="${list.id}">${list.exam}</option>
                </#list>
            </select>
        </div>
        专业：
        <div class="layui-inline">
            <select class="layui-input" height="20px" id="professional_name" autocomplete="off">
                <option value="">全部</option>
                <#list list2 as list2>
                    <option value="${list2.name}">${list2.name}</option>
                </#list>
            </select>
        </div>
        初步入围人数：
        <div class="layui-inline">
            <input class="layui-input" type="text" height="20px" id="cut_num" autocomplete="off">
        </div>
        高考省份：
        <div class="layui-inline">
            <input class="layui-input" type="text" height="20px" id="high_provinces" autocomplete="off" readonly style="width: 200px!important;">
        </div>
        <div class="layui-inline">
            <select class="layui-input" height="20px" id="high_prov" autocomplete="off">
                <option value="0">全部</option>
                <#list list3 as list3>
                    <option value="${list3}">${list3}</option>
                </#list>
            </select>
        </div>


        <button class="select-on layui-btn layui-btn-sm" data-type="high_prov_add"><i class="layui-icon">+</i>
        </button>
        <button class="select-on layui-btn layui-btn-sm" data-type="high_prov_qk"><i class="layui-icon">清空</i>
        </button>
        <button class="select-on layui-btn layui-btn-sm" data-type="rank" style="margin-left: 40px;"><i class="layui-icon">排名</i>
        </button>
        <button class="layui-btn layui-btn-sm icon-position-button" id="refresh" style="float: right;"
                data-type="reload">
            <i class="layui-icon">ဂ</i>
        </button>
    </div>
</div>
<div class="lenos-search">
    <div class="select">
        入围分数线：
        <div class="layui-inline">
            <input class="layui-input" type="text" height="20px" id="cut_score" autocomplete="off">
        </div>
        或       入围排名：
        <div class="layui-inline">
            <input class="layui-input" type="text" height="20px" id="cut_rank" autocomplete="off">
        </div>

        <button class="select-on layui-btn layui-btn-sm" data-type="ec_rank" style="margin-left: 40px;"><i class="layui-icon">二次排名</i>
        </button>

    </div>
</div>
<div class="layui-col-md12" style="height:40px;margin-top:3px;">
    <div class="layui-btn-group">

        <button class="layui-btn layui-btn-normal" data-type="qr_sc" lay-filter="qr_sc">
            <i class="layui-icon">&#xe605;</i>确认输出
        </button>

        <button class="layui-btn layui-btn-normal" data-type="sadsasda" lay-filter="sadsa">
            <i class="layui-icon">&#xe605;</i>导出
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
<table id="achievementLastCut" class="layui-hide" lay-filter="achieveCut"></table>

<script type="text/html" id="ChaxunDemo">
    <a class="layui-btn layui-btn-xs  layui-btn-normal" lay-event="opening">开启</a>
    <a class="layui-btn layui-btn-xs  layui-btn-normal" lay-event="closing">关闭</a>
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
            id: 'achievementLastCut',
            elem: '#achievementLastCut'
            , url: 'showachievementLastCutList'
            , cols: [[
                {checkbox: true, fixed: true, width: '5%'}
                , {
                    type: 'numbers',
                    title: '序号',
                    fixed: true,
                    width: '5%'
                }
                , {field: 'exam_name', title: '考试名称', width: '15%'}
                , {field: 'professional_name', title: '专业', width: '8%'}
                , {field: 'name', title: '姓名', width: '6%'}
                , {field: 'high_province', title: '高考省份', width: '6%'}
                , {field: 'examinee_num', title: '考生号', width: '10%'}
                , {field: 'ticket_num', title: '准考证号', width: '10%'}
                , {field: 'wl_subject', title: '文理科', width: '8%'}
                , {field: 'professional_code', title: '专业代码', width: '10%'}
                , {field: 'national_rankings', title: '全国排名', width: '8%'}
                , {field: 'national_same_name', title: '全国同名次', width: '10%'}
                , {field: 'provincial_ranking', title: '省排名', width: '8%'}
                , {field: 'provincial_same_name', title: '省同名次', width: '8%'}
                , {field: 'qualified_mark', title: '合格标志Y/N', width: '10%'}
                , {field: 'qualified_line', title: '合格线', width: '8%'}
                , {field: 'first_subjects_name1', title: '科目1名称', width: '8%'}
                , {field: 'first_subjects_achieve1', title: '科目1成绩', width: '6%'}
                , {field: 'first_subjects_achieve_ex1', title: '科目1成绩说明', width: '10%'}
                , {field: 'first_subjects_name2', title: '科目2名称', width: '8%'}
                , {field: 'first_subjects_achieve2', title: '科目2成绩', width: '6%'}
                , {field: 'first_subjects_achieve_ex2', title: '科目2成绩说明', width: '10%'}
                , {field: 'first_subjects_name3', title: '科目3名称', width: '8%'}
                , {field: 'first_subjects_achieve3', title: '科目3成绩', width: '6%'}
                , {field: 'first_subjects_achieve_ex3', title: '科目3成绩说明', width: '10%'}
                , {field: 'first_subjects_name4', title: '科目4名称', width: '8%'}
                , {field: 'first_subjects_achieve4', title: '科目4成绩', width: '6%'}
                , {field: 'first_subjects_achieve_ex4', title: '科目4成绩说明', width: '10%'}
                , {field: 'first_subjects_name5', title: '科目5名称', width: '8%'}
                , {field: 'first_subjects_achieve5', title: '科目5成绩', width: '6%'}
                , {field: 'first_subjects_achieve_ex5', title: '科目5成绩说明', width: '10%'}
                , {field: 'first_subjects_name6', title: '科目6名称', width: '8%'}
                , {field: 'first_subjects_achieve6', title: '科目6成绩', width: '6%'}
                , {field: 'first_subjects_achieve_ex6', title: '科目6成绩说明', width: '10%'}

                , {field: 'complex_subjects_name1', title: '科目1名称', width: '8%'}
                , {field: 'complex_subjects_achieve1', title: '科目1成绩', width: '6%'}
                , {field: 'complex_subjects_achieve_ex1', title: '科目1成绩说明', width: '10%'}
                , {field: 'complex_subjects_name2', title: '科目2名称', width: '8%'}
                , {field: 'complex_subjects_achieve2', title: '科目2成绩', width: '6%'}
                , {field: 'complex_subjects_achieve_ex2', title: '科目2成绩说明', width: '10%'}
                , {field: 'complex_subjects_name3', title: '科目3名称', width: '8%'}
                , {field: 'complex_subjects_achieve3', title: '科目3成绩', width: '6%'}
                , {field: 'complex_subjects_achieve_ex3', title: '科目3成绩说明', width: '10%'}
                , {field: 'complex_subjects_name4', title: '科目4名称', width: '8%'}
                , {field: 'complex_subjects_achieve4', title: '科目4成绩', width: '6%'}
                , {field: 'complex_subjects_achieve_ex4', title: '科目4成绩说明', width: '10%'}
                , {field: 'complex_subjects_name5', title: '科目5名称', width: '8%'}
                , {field: 'complex_subjects_achieve5', title: '科目5成绩', width: '6%'}
                , {field: 'complex_subjects_achieve_ex5', title: '科目5成绩说明', width: '10%'}
                , {field: 'complex_subjects_name6', title: '科目6名称', width: '8%'}
                , {field: 'complex_subjects_achieve6', title: '科目6成绩', width: '6%'}
                , {field: 'complex_subjects_achieve_ex6', title: '科目6成绩说明', width: '10%'}
                , {field: 'first_subjects_total', title: '初试总分', width: '6%'}
                , {field: 'complex_subjects_total', title: '复试总分', width: '6%'}
                , {field: 'total_score', title: '总分', width: '6%'}
                , {field: 'remarks', title: '备注', width: '10%'}
            ]],
            done: function(res, curr, count) {
                 /*$("[data-field='grade']").children().each(function () {
                     if ($(this).text() == "1") {
                         $(this).text("开启");
                     } else if($(this).text() == "0") {
                         $(this).text("关闭");
                     }
                 });*/
            }
            , page: true
        });
        var flagqx = 1;
        var $ = layui.$, active = {
            reload: function () {
                $("#exam_id").val('0');
                $("#professional_name").val('');
                $("#cut_num").val("");
                $("#high_provinces").val("");
                 $("#cut_score").val("");
                $("#cut_rank").val("");
                table.reload('achievementFirstCut', {
                    where: {
                        exam_id: null,
                        professional_name: null,
                        cut_num: null,
                        high_provinces: null,
                        cut_score: null,
                        cut_rank: null
                    }
                });
            },
            quanxuan: function () {
                $("body").find("input[type='checkbox']").next().click();
            },
            high_prov_add: function () {            //添加省份
                var high_provinces = $("#high_provinces").val();
                var high_prov = $("#high_prov").val();
                var flag=0;
                if(high_prov === "0"){
                    layer.msg('请选择一行添加', {icon: 5});
                }else{
                    if (high_provinces=="" || high_provinces==null){
                        high_provinces=high_prov;
                        $("#high_provinces").val(high_provinces);
                    }else {
                        if (high_provinces.indexOf(high_prov)<0){
                            high_provinces=high_provinces+","+high_prov;
                            $("#high_provinces").val(high_provinces);
                        }else {
                            layer.msg('当前省份已添加', {icon: 5});
                        }

                    }
                }
            },
            high_prov_qk: function () {                 //清空省份
                $("#high_province").val('');
            },
            rank: function () {                 //排名
                var exam_id = $("#exam_id").val();
                var professional_name = $("#professional_name").val();
                var cut_num = $("#cut_num").val();
                var high_provinces = $("#high_provinces").val();

                table.reload('achievementFirstCut', {
                    where: {
                        exam_id: exam_id,
                        professional_name: professional_name,
                        cut_num: cut_num,
                        high_provinces: high_provinces
                    }
                });
            },
            ec_rank: function () {                 //二次排名
                var exam_id = $("#exam_id").val();
                var professional_name = $("#professional_name").val();
                var cut_num = $("#cut_num").val();
                var high_provinces = $("#high_provinces").val();
                var cut_score = $("#cut_score").val();
                var cut_rank = $("#cut_rank").val();
                if(cut_score !="" && cut_rank !=""){
                    layer.msg('不能同时填写 [入围分数线] 和 [入围排名] ', {icon: 5});
                }else{
                    table.reload('achievementFirstCut', {
                        where: {
                            exam_id: exam_id,
                            professional_name: professional_name,
                            cut_num: cut_num,
                            high_provinces: high_provinces,
                            cut_score: cut_score,
                            cut_rank: cut_rank
                        }
                    });
                }

            },
            qr_sc: function () {                 //输出
                layer.confirm('确认进行操作?', {
                    btn: ['确认', '取消']
                }, function (index) {
                    layer.close(index);
                    var exam_id = $("#exam_id").val();
                    var professional_name = $("#professional_name").val();
                    var cut_num = $("#cut_num").val();
                    var high_provinces = $("#high_provinces").val();
                    var cut_score = $("#cut_score").val();
                    var cut_rank = $("#cut_rank").val();
                    table.reload('achievementFirstCut', {
                        where: {
                            exam_id: exam_id,
                            professional_name: professional_name,
                            cut_num: cut_num,
                            high_provinces: high_provinces,
                            cut_score: cut_score,
                            cut_rank: cut_rank
                        }
                    });
                });
            },

            add: function () {
                add('新建信息采集模板', 'achievementFirstGradeList',900, 680);
            },

            batch: function () {
                var checkStatus = table.checkStatus('achievementLastCut')
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
                    batchUpdateAudit(id,status, 'achievementFirstCut');  //批量审核
                });

                //layerAjax('batchUpdateAudit', data.field, 'auditList');
            },
            update: function () {
                var checkStatus = table.checkStatus('achievementLastCut')
                        , data = checkStatus.data;
                if (data.length != 1) {
                    layer.msg('请选择一行编辑,已选[' + data.length + ']行', {icon: 5});
                    return false;
                }
                update('编辑用户', 'updateUser?id=' + data[0].id, 700, 450);
            },
            detail: function () {
                var checkStatus = table.checkStatus('achievementFirstCut')
                        , data = checkStatus.data;
                if (data.length != 1) {
                    layer.msg('请选择一行查看,已选[' + data.length + ']行', {icon: 5});
                    return false;
                }
                detail('查看用户信息', 'updateUser?id=' + data[0].id, 700, 450);
            }

        };

        //监听表格复选框选择
        table.on('checkbox(achieveCut)', function (obj) {
            console.log(obj)
        });

        //监听工具条
        table.on('tool(achieveCut)', function (obj) {
            var data = obj.data;
            if (obj.event === 'detail') {
                detail("'" + data.exam + "'" + '  —初试成绩', 'achievementFirstGradeList?id=' + data.id, 1200, 680);
            } else if (obj.event === 'opening') {
                if (data.grade === 0) {
                    layer.confirm('确定开启?', {
                        btn: ['确认', '取消']
                    }, function (index) {
                        layer.close(index);
                        $.ajax({
                            url: "updateGrade_switch",
                            type: "post",
                            data: {"id": data.id, "status": "1"},
                            success: function (d) {
                                if (d.flag) {
                                    window.layui.table.reload('achievementFirstList');
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
                if (data.grade === 1) {
                    layer.confirm('确定关闭?', {
                        btn: ['确认', '取消']
                    }, function (index) {
                        layer.close(index);
                        $.ajax({
                            url: "updateGrade_switch",
                            type: "post",
                            data: {"id": data.id, "status": "0"},
                            success: function (d) {
                                if (d.flag) {
                                    window.layui.table.reload('achievementFirstList');
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
                layer.confirm('确定删除 [' + data.exam + '] 所有成绩?', {
                    btn: ['确认', '取消']
                }, function (index) {
                    layer.close(index);
                    $.ajax({
                        url: "delFirstGradeById",
                        type: "post",
                        data: {"id": data.id},
                        success: function (d) {
                            if (d.flag) {
                                window.layui.table.reload('achievementFirstList');
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
                add(data.exam + '——初试成绩导入', 'achievementFirstInto?id=' + data.id, 700, 300);
            } else if (obj.event === 'inout') {
                layer.confirm('确定导出 [' + data.exam + '] 所有成绩?', {
                    btn: ['确认', '取消']
                }, function (index) {
                    layer.close(index);
                    location.href="inout_achieveFirstGrade?id="+data.id+"&name="+data.exam;
                    /*$.ajax({
                        url: 'inout_achieveFirstGrade',
                        type: "post",
                        data: {"id": data.id, "name": data.exam},
                        success: function (d) {
                            if (d.flag) {
                                window.layui.table.reload('achievementFirstList');
                                window.top.layer.msg(d.msg, {icon: 6, offset: 'rb', area: ['120px', '80px'], anim: 2});
                            } else {
                                window.top.layer.msg(d.msg, {icon: 6, offset: 'rb', area: ['120px', '80px'], anim: 2});
                            }
                        }, error: function () {
                            alert('error');
                        }
                    });*/
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
