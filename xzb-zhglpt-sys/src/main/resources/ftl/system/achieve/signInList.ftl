<#-- Created by IntelliJ IDEA.
 applicationAnnoun: Administrator
 Date: 2017/12/6
 Time: 14:00
 To change this template use File | Settings | File Templates.
 用户管理-->
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,applicationAnnoun-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
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
            准考证号：
            <div class="layui-inline">
                <input class="layui-input" height="20px" id="exam" autocomplete="off">
            </div>
            考试号：
            <div class="layui-inline">
                <input class="layui-input" height="20px" id="no" autocomplete="off">
            </div>
            <button class="select-on layui-btn layui-btn-sm" data-type="select"><i class="layui-icon"></i>
            </button>
        </div>
<#--  <div class="select">
        用户名：
        <div class="layui-inline">
            <input class="layui-input" height="20px" id="exam" autocomplete="off">
        </div>
        电话：
        <div class="layui-inline">
            <input class="layui-input" height="20px" id="no" autocomplete="off">
        </div>
        <button class="select-on layui-btn layui-btn-sm" data-type="select"><i class="layui-icon"></i>
        </button>
        <button class="layui-btn layui-btn-sm icon-position-button" id="refresh" style=" float: right;"
                data-type="reload">
            <i class="layui-icon">ဂ</i>
        </button>
    </div>-->

</div>
<#--<div class="layui-col-md12" style="height:40px;margin-top:3px;">-->
    <#--<div class="layui-btn-group">-->
    <#--&lt;#&ndash;<@shiro.hasPermission name="applicationAnnoun:select">&ndash;&gt;-->
        <#--&lt;#&ndash;<button class="layui-btn layui-btn-normal" data-type="add">&ndash;&gt;-->
            <#--&lt;#&ndash;<i class="layui-icon">&#xe608;</i>新增通知&ndash;&gt;-->
        <#--&lt;#&ndash;</button>&ndash;&gt;-->
    <#--&lt;#&ndash;</@shiro.hasPermission>&ndash;&gt;-->
    <#--&lt;#&ndash;<@shiro.hasPermission name="applicationAnnoun:select">&ndash;&gt;-->
    <#--&lt;#&ndash;<button class="layui-btn layui-btn-normal" data-type="selectAll">&ndash;&gt;-->
    <#--&lt;#&ndash;<i class="layui-icon">&#xe642;</i>全选&ndash;&gt;-->
    <#--&lt;#&ndash;</button>&ndash;&gt;-->
    <#--&lt;#&ndash;</@shiro.hasPermission>&ndash;&gt;-->
    <#--&lt;#&ndash;<@shiro.hasPermission name="applicationAnnoun:del">&ndash;&gt;-->
    <#--&lt;#&ndash;<button class="layui-btn layui-btn-normal" data-type="export">&ndash;&gt;-->
    <#--&lt;#&ndash;<i class="layui-icon">&#xe605;</i>导出&ndash;&gt;-->
    <#--&lt;#&ndash;</button>&ndash;&gt;-->
    <#--&lt;#&ndash;</@shiro.hasPermission>&ndash;&gt;-->
    <#--&lt;#&ndash;<@shiro.hasPermission name="applicationAnnoun:repass">&ndash;&gt;-->
    <#--&lt;#&ndash;  <button class="layui-btn layui-btn-normal" data-type="changePwd">-->
          <#--<i class="layui-icon">&#xe605;</i>重置密码-->
      <#--</button>&ndash;&gt;-->
    <#--&lt;#&ndash;</@shiro.hasPermission>&ndash;&gt;-->
    <#--</div>-->
<#--</div>-->
<table id="applicationAnnoun" class="layui-hide" lay-filter="applicationAnnoun"></table>
<script type="text/html" id="barDemo">
    <#--<@shiro.hasPermission name="applicationAnnoun:select">-->
    <#--<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">签到</a>-->
    <#--</@shiro.hasPermission>-->
    <#--<@shiro.hasPermission name="applicationAnnoun:update">-->
    <#--<a class="layui-btn layui-btn-xs  layui-btn-normal" lay-event="edit">编辑</a>-->
    <#--</@shiro.hasPermission>-->
    <#--<@shiro.hasPermission name="applicationAnnoun:del">-->
    <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="del">签到</a>
    <#--</@shiro.hasPermission>-->
</script>
<#--<script type="text/html" id="switchTpl">-->
<#--<input type="checkbox" name="sex" lay-skin="switch" lay-text="女|男" lay-filter="sexDemo">-->
<#--</script>-->
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
            id: 'applicationAnnoun',
            elem: '#applicationAnnoun'
            , url: 'showSignInList'
            , cols: [[
                {checkbox: true, fixed: true, width: '8%'}
                , {field: 'id',title: '序号',width: '8%' }
                , {field: 'name', title: '考生姓名',width:'7%'}
                , {field: 'examineeName', title: '考试名称',width:'8%'}
                , {field: 'applyingMajor', title: '报考专业', width:'8%'}
                , {field: 'exam', title: '准考证号',width:'15%'}
                , {field: 'no', title: '考生号',width:'15%'}
                , {field: 'singInCondition', title: '签到情况', width: '12%'}
                , {fixed: 'right', field: 'right', title: '操作', toolbar: "#barDemo"}
            ]],
            done: function(res, curr, count) {
                $("[data-field='singInCondition']").children().each(function () {
                    if ($(this).text() == "0") {
                        $(this).text("未签到");
                    } else if ($(this).text() == "1") {
                        $(this).text("已签到");
                    }
                });
            }
            , page: true
        });



        var $ = layui.$, active = {
            select: function () {
                var exam = $('#exam').val();
                var no = $('#no').val();
                console.info(exam);
                table.reload('applicationAnnoun', {
                    where: {
                        exam: exam,
                        no: no
                    }
                });
            },
            reload: function () {
                $('#exam').val('');
                $('#no').val('');
                table.reload('applicationAnnoun', {
                    where: {
                        exam: null,
                        no: null
                    }
                });
            }
        };

        //监听表格复选框选择
        table.on('checkbox(applicationAnnoun)', function (obj) {
            console.log(obj)
        });
        //监听工具条
        table.on('tool(applicationAnnoun)', function (obj) {
            var data = obj.data;
            if (obj.event === 'del') {
                layer.confirm('确定签到？', {
                    btn: ['确认', '取消']
                }, function (index) {
                    layer.close(index);
                    toolDelByFlag(data.id);
                    setTimeout(function () {
                        // layer.closeAll();
                        location.reload()
                    }, 200);
                    // location.reload()
                }, function (index) {
                    layer.close(index);
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

    function rePwd(title, url, w, h) {
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
            id: 'applicationAnnoun-rePwd',
            type: 2,
            area: [w + 'px', h + 'px'],
            fix: false,
            maxmin: true,
            shadeClose: true,
            shade: 0.4,
            title: title,
            content: url,
        });
    }

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
            id: 'applicationAnnoun-detail',
            type: 2,
            area: [w + 'px', h + 'px'],
            fix: false,
            maxmin: true,
            shadeClose: true,
            shade: 0.4,
            title: title,
            content: url + '&detail=true',
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
            id: 'applicationAnnoun-update',
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
            id: 'applicationAnnoun-add',
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
