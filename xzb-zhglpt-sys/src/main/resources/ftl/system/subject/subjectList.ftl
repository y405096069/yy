<#-- Created by IntelliJ IDEA.
 subject: Administrator
 Date: 2017/12/6
 Time: 14:00
 To change this template use File | Settings | File Templates.
 用户管理-->
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>专业管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,subject-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <link rel="stylesheet" href="${re.contextPath}/plugin/layui/css/layui.css">
    <link rel="stylesheet" href="${re.contextPath}/plugin/lenos/main.css">
    <script type="text/javascript" src="${re.contextPath}/plugin/jquery/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${re.contextPath}/plugin/layui/layui.all.js"
            charset="utf-8"></script>
    <script type="text/javascript" src="${re.contextPath}/plugin/tools/tool.js"></script>

</head>

<body>

<div class="select">
    更新人：
    <div class="layui-inline">
        <select class="layui-input" height="20px" id="sub_limit" name="sub_limit" autocomplete="off">
            <option value="">全部</option>
            <option value="0">张三</option>
            <option value="1">李四</option>
        </select>
    </div>
    <button class="select-on layui-btn layui-btn-sm" data-type="select"><i class="layui-icon"></i>
    </button>
    <button class="layui-btn layui-btn-sm icon-position-button" id="refresh" style="float: right;"
            data-type="reload">
        <i class="layui-icon">ဂ</i>
    </button>
</div>
<div class="layui-col-md12" style="height:40px;margin-top:3px;">
    <div class="layui-btn-group">
        <@shiro.hasPermission name="subject:select">
            <button class="layui-btn layui-btn-normal" data-type="add">
                <i class="layui-icon">&#xe608;</i>新增
            </button>
        </@shiro.hasPermission>
        <#--<@shiro.hasPermission name="subject:select">
            <button class="layui-btn layui-btn-normal" data-type="update">
                <i class="layui-icon">&#xe642;</i>编辑
            </button>
        </@shiro.hasPermission>
        <@shiro.hasPermission name="subject:del">
            <button class="layui-btn layui-btn-normal" data-type="detail">
                <i class="layui-icon">&#xe605;</i>查看
            </button>
        </@shiro.hasPermission>
        <@shiro.hasPermission name="subject:repass">
            <button class="layui-btn layui-btn-normal" data-type="changePwd">
                <i class="layui-icon">&#xe605;</i>重置密码
            </button>
        </@shiro.hasPermission>-->q
    </div>
</div>
<table id="subList" class="layui-hide" lay-filter="subject"></table>
<script type="text/html" id="barDemo">
   <#-- <@shiro.hasPermission name="subject:select">-->
        <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
    <#--</@shiro.hasPermission>-->
    <#--<@shiro.hasPermission name="subject:update">-->
        <a class="layui-btn layui-btn-xs  layui-btn-normal" lay-event="edit">编辑</a>
    <#--</@shiro.hasPermission>-->
    <#--<@shiro.hasPermission name="subject:del">-->
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    <#--</@shiro.hasPermission>-->
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
            id: 'subList',
            elem: '#subList'
            , url: 'showSubjectList'
            , cols: [[
                {checkbox: true, fixed: true, width: '5%'}
                , {
                    field: 'id',
                    title: '序号',
                    width: '5%'
                } , {
                    field: 'subject_name',
                    title: '科目',
                    width: '10%'

                }
                , {field: 'code', title: '科目代码', width: '5%'}
                , {field: 'introduction', title: '科目介绍', width: '20%'}
                , {field: 'update_time', title: '更新时间', width: '15%'}
                , {field: 'update_name', title: '更新人', width: '15%', template: '#switchTpl'}
                , {fixed: 'right', field: 'right', title: '操作', toolbar: "#barDemo"}
            ]]
            , page: true
        });

        var $ = layui.$, active = {
            select: function () {
                var uname = $('#uname').val();
                var email = $('#email').val();
                console.info(uname);
                table.reload('subList', {
                    where: {
                        subjectname: uname,
                        email: email
                    }
                });
            },
            reload: function () {
                $('#uname').val('');
                $('#email').val('');
                table.reload('subList', {
                    where: {
                        subjectname: null,
                        email: null
                    }
                });
            },
            add: function () {
                add('添加用户', 'showAddsubject',700, 680);
            },
            update: function () {
                var checkStatus = table.checkStatus('subList')
                    , data = checkStatus.data;
                if (data.length != 1) {
                    layer.msg('请选择一行编辑,已选[' + data.length + ']行', {icon: 5});
                    return false;
                }
                update('编辑用户', 'updatesubject?id=' + data[0].id, 700, 450);
            },
            detail: function () {
                var checkStatus = table.checkStatus('subList')
                    , data = checkStatus.data;
                if (data.length != 1) {
                    layer.msg('请选择一行查看,已选[' + data.length + ']行', {icon: 5});
                    return false;
                }
                detail('查看用户信息', 'updatesubject?id=' + data[0].id, 700, 450);
            },
            /*changePwd:function(){
              var checkStatus = table.checkStatus('subList')
                  , data = checkStatus.data;
              if (data.length != 1) {
                layer.msg('请选择一个用户,已选['+data.length+']行', {icon: 5});
                return false;
              }
              rePwd('修改密码','goRePass?id='+data[0].id,500,350);
            }*/

            changePwd: function () {
                var checkStatus = table.checkStatus('subList')
                    , data = checkStatus.data;
                if (data.length != 1) {
                    layer.msg('请选择一个用户,已选[' + data.length + ']行', {icon: 5});
                    return false;
                }
                $.ajax({
                    url: 'resetPassword',
                    type: 'get',
                    data: 'id=' + data[0].id,
                    async: false, dataType: "json", traditional: true,
                    success: function (json) {
                        /*var index = parent.layer.getFrameIndex(window.name);
                        window.parent.layui.table.reload('subList');*/
                        window.top.layer.msg(json.msg, {icon: 6, offset: 'rb', area: ['120px', '100px'], anim: 2});
                    }, error: function () {
                        var index = parent.layer.getFrameIndex(window.name);
                        parent.layer.close(index);
                        window.top.layer.msg('请求失败', {icon: 5, offset: 'rb', area: ['120px', '80px'], anim: 2});
                    }
                });
                return false;
            }
        };

        //监听表格复选框选择
        table.on('checkbox(subject)', function (obj) {
            console.log(obj)
        });
        //监听工具条
        table.on('tool(subject)', function (obj) {
            var data = obj.data;
            if (obj.event === 'detail') {
                detail('查看用户', 'updatesubject?id=' + data.id, 700, 600);
            } else if (obj.event === 'del') {
                layer.confirm('确定删除用户[<label style="color: #00AA91;">' + data.subject_name + '</label>]?', {
                    btn: ['逻辑删除', '物理删除']
                }, function (index) {
                    layer.close(index);
                    toolDelByFlag(data.id, '', false, 'subList');
                }, function (index) {
                    layer.close(index);
                    toolDelByFlag(data.id, '', true, 'subList');
                });
            } else if (obj.event === 'edit') {
                update('编辑用户', 'updatesubject?id=' + data.id, 700, 600);
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
            id: 'subject-rePwd',
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
            id: 'subject-detail',
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
            id: 'subject-update',
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
            id: 'subject-add',
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
