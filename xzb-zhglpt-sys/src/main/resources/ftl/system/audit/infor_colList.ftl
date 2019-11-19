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
    <title>信息采集模板管理</title>
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
        已配置考试：
        <div class="layui-inline">
            <select class="layui-input" height="20px" id="exam_id" name="exam_id" autocomplete="off">
                <option value="0">全部</option>
                <option value="2">篮球考试</option>
                <option value="1">美术考试</option>
                <option value="3">33000</option>
            </select>
        </div>
        状态：
        <div class="layui-inline">
            <select class="layui-input" height="20px" id="template_status" name="template_status" autocomplete="off">
                <option value="">全部</option>
                <option value="开启">开启</option>
                <option value="关闭">关闭</option>
            </select>
        </div>
        管理员：
        <div class="layui-inline">
            <select class="layui-input" height="20px" id="founder" name="founder" autocomplete="off">
                <option value="">全部</option>
                <option value="acfc0e9232f54732a5d9ffe9071bf572">管理员</option>
                <option value="超级管理员">超级管理员</option>
                <option value="学生">学生</option>
            </select>
        </div>
        模板搜索：
        <div class="layui-inline">
            <input class="layui-input" height="20px" id="template_name" name="template_name" autocomplete="off">
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

        <button class="layui-btn layui-btn-normal" data-type="add">
            <i class="layui-icon">&#xe608;</i>新增
        </button>

    </div>
</div>
<table id="inforList" class="layui-hide" lay-filter="infor"></table>
<script type="text/html" id="barDemo">
    <#---->
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-xs  layui-btn-normal" lay-event="opening">开启</a>
    <a class="layui-btn layui-btn-xs  layui-btn-normal" lay-event="closing">关闭</a>
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
    layui.use('table', function () {
        var table = layui.table;
        //方法级渲染
        table.render({
            id: 'inforList',
            elem: '#inforList'
            , url: 'showinfor_collectList'
            , cols: [[
                {checkbox: true, fixed: true, width: '5%'}
                , {
                    field: 'id',
                    title: '序号',
                    width: '5%'
                }
                , {field: 'template_name', title: '模板名称', width: '25%', sort: true}
                , {field: 'template_status', title: '模板状态', width: '10%'}
                , {field: 'founder_name', title: '管理员', width: '10%'}
                , {field: 'create_time', title: '创建时间', width: '20%', sort: true}
                , {fixed: 'right', field: 'right', title: '操作', toolbar: "#barDemo"}
            ]]
            , page: true
        });
        var flagqx = 1;
        var $ = layui.$, active = {
            select: function () {
                var exam_id = $('#exam_id').val();
                var founder = $('#founder').val();
                var template_name = $('#template_name').val();
                var template_status = $('#template_status').val();
                table.reload('inforList', {
                    where: {
                        exam_id: exam_id,
                        template_status: template_status,
                        founder: founder,
                        template_name: template_name
                    }
                });
            },
            reload: function () {
                $('#exam_id').val('0');
                $('#founder').val('');
                $('#template_name').val('');
                $('#template_status').val('');
                table.reload('inforList', {
                    where: {
                        exam_id: '0',
                        template_status: null,
                        founder: null,
                        template_name: null
                    }
                });
            },
            quanxuan: function () {
                $("body").find("input[type='checkbox']").next().click();
            },

            add: function () {
                add('新建信息采集模板', 'addinfor_collect',900, 680);
            },

            batch: function () {
                var checkStatus = table.checkStatus('inforList')
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
                    batchUpdateAudit(id,status, 'auditList');  //批量审核
                });

                //layerAjax('batchUpdateAudit', data.field, 'auditList');
            },
            update: function () {
                var checkStatus = table.checkStatus('inforList')
                        , data = checkStatus.data;
                if (data.length != 1) {
                    layer.msg('请选择一行编辑,已选[' + data.length + ']行', {icon: 5});
                    return false;
                }
                update('编辑用户', 'updateUser?id=' + data[0].id, 700, 450);
            },
            detail: function () {
                var checkStatus = table.checkStatus('auditList')
                        , data = checkStatus.data;
                if (data.length != 1) {
                    layer.msg('请选择一行查看,已选[' + data.length + ']行', {icon: 5});
                    return false;
                }
                detail('查看用户信息', 'updateUser?id=' + data[0].id, 700, 450);
            }

        };

        //监听表格复选框选择
        table.on('checkbox(infor)', function (obj) {
            console.log(obj)
        });
        //监听工具条
        table.on('tool(infor)', function (obj) {
            var data = obj.data;
            if (obj.event === 'detail') {
                detail('查看用户', 'updinfor_collect?id=' + data.id, 900, 680);
            } else if (obj.event === 'opening') {
                if(data.template_status === '关闭'){
                    layer.confirm('确定开启?', {
                        btn: ['确认', '取消']
                    }, function (index) {
                        layer.close(index);
                        $.ajax({
                            url: "updateTemplate_status",
                            type: "post",
                            data: {"id":data.id,"status":"开启"},
                            success: function (d) {
                                if (d.flag) {
                                    window.layui.table.reload('inforList');
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
                if(data.template_status === '开启'){
                    layer.confirm('确定关闭?', {
                        btn: ['确认', '取消']
                    }, function (index) {
                        layer.close(index);
                        $.ajax({
                            url: "updateTemplate_status",
                            type: "post",
                            data: {"id":data.id,"status":"关闭"},
                            success: function (d) {
                                if (d.flag) {
                                    window.layui.table.reload('inforList');
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
                                window.layui.table.reload('inforList');
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
