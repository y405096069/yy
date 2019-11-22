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
    <title>审核管理</title>
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
            <select class="layui-input" height="20px" id="exam_name" autocomplete="off">
                <option value="">全部</option>
                <option value="篮球考试">篮球考试</option>
                <option value="美术考试">美术考试</option>
                <option value="33000">33000</option>
            </select>
        </div>
        生源地：
        <div class="layui-inline">
            <select class="layui-input" height="20px" id="biog_land" autocomplete="off">
                <option value="">全部</option>
                <option value="上海">上海</option>
                <option value="广州">广州</option>
                <option value="香港">香港</option>
                <option value="深圳">深圳</option>
            </select>
        </div>
        报考专业：
        <div class="layui-inline">
            <select class="layui-input" height="20px" id="major" autocomplete="off">
                <option value="">全部</option>
                <option value="体育">体育类</option>
                <option value="艺术">艺术类</option>
                <option value="330">330</option>
            </select>
        </div>
        审核状态：
        <div class="layui-inline">
            <select class="layui-input" height="20px" id="audit_status" autocomplete="off">
                <option value="">全部</option>
                <option value="待审核">待审核</option>
                <option value="已审核">已审核</option>
            </select>
        </div>
        缴费状态：
        <div class="layui-inline">
            <select class="layui-input" height="20px" id="pay_status" autocomplete="off">
                <option value="">全部</option>
                <option value="支付失败">支付失败</option>
                <option value="支付成功">支付成功</option>
                <option value="待支付">待支付</option>
            </select>
        </div>
        审核资料环节：
        <div class="layui-inline">
            <select class="layui-input" height="20px" id="audit_link" autocomplete="off">
                <option value="">全部</option>
                <option value="交费前">交费前</option>
                <option value="交费后">交费后</option>
            </select>
        </div>
        报名状态：
        <div class="layui-inline">
            <select class="layui-input" height="20px" id="enroll_status" autocomplete="off">
                <option value="">全部</option>
                <option value="报名完成">报名完成</option>
                <option value="报名不完成">报名不完成</option>
            </select>
        </div>
        考生姓名：
        <div class="layui-inline">
            <input class="layui-input" height="20px" id="name" autocomplete="off">
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
        <button class="layui-btn layui-btn-normal" data-type="batch">
            <i class="layui-icon">&#xe608;</i>批量审核
        </button>
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
<table id="auditList" class="layui-hide" lay-filter="audit"></table>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs  layui-btn-normal" lay-event="detail">审核</a>
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
            id: 'auditList',
            elem: '#auditList'
            , url: 'showAuditList'
            , cols: [[
                {checkbox: true, fixed: true, width: '5%'}
                , {
                    type: 'numbers',
                    fixed: true,
                    title: '序号',
                    width: '4%'
                }
                , {field: 'name', title: '姓名',fixed: true, sort: true}
                , {field: 'biog_land', title: '生源地'}
                , {field: 'exam_name', title: '报考考试名称',}
                , {field: 'major', title: '报考专业'}
                , {field: 'audit_link', title: '审核资料环节'}

                /*, {field: 'end_time', title: '审核截止时间', width: '10%'}*/
                , {field: 'info_collect_status', title: '信息采集状态', }
                /*, {field: 'pay_status', title: '缴费状态', }*/
                , {field: 'sub_time', title: '信息提交时间',}
                /*, {field: 'audit_status', title: '审核状态', width: '6%'}
                , {field: 'audit_time', title: '审核时间', width: '10%'}
                , {field: 'pay_status', title: '缴费状态', width: '6%'}*/
                , {field: 'audit_status', title: '报名状态',fixed: 'right', }
/*                , {field: 're_audit_status', title: '复试审核状态', width: '10%'}
                , {field: 're_audit_time', title: '复试审核时间', width: '10%'}
                , {field: 're_pay_status', title: '复试缴费状态', width: '10%'}
                , {field: 're_enroll_status', title: '复试报名状态', width: '10%'}*/
                , {fixed: 'right', field: 'right', title: '操作', toolbar: "#barDemo" }
            ]]
            , page: true
        });
        var flagqx = 1;
        var $ = layui.$, active = {
            select: function () {
                var name = $('#name').val();
                var exam_name = $('#exam_name').val();
                var biog_land = $('#biog_land').val();
                var major = $('#major').val();
                var audit_status = $('#audit_status').val();
                var pay_status = $('#pay_status').val();
                var audit_link = $('#audit_link').val();
                var enroll_status = $('#enroll_status').val();
                var info_collect_status =  $('#info_collect_status').val();
                console.info(name);
                table.reload('auditList', {
                    where: {
                        exam_name: exam_name,
                        biog_land: biog_land,
                        major: major,
                        audit_status: audit_status,
                        pay_status: pay_status,
                        audit_link: audit_link,
                        enroll_status: enroll_status,
                        name: name
                    }
                });
            },
            reload: function () {
                $('#name').val('');
                $('#exam_name').val('');
                $('#biog_land').val('');
                $('#major').val('');
                $('#audit_status').val('');
                $('#pay_status').val('');
                $('#audit_link').val('');
                $('#enroll_status').val('');
                table.reload('auditList', {
                    where: {
                        exam_name: null,
                        biog_land: null,
                        major: null,
                        audit_status: null,
                        pay_status: null,
                        audit_link: null,
                        enroll_status: null,
                        name: null
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

            batch: function () {
                var checkStatus = table.checkStatus('auditList')
                    , data = checkStatus.data;
                if (data.length == 0) {
                    layer.msg('请至少选择一行编辑,已选[' + data.length + ']行', {icon: 5});
                    return false;
                }

                layer.confirm('确认 批量审核操作?', {
                    btn: ['确认', '取消']
                }, function (index) {
                    layer.close(index);
                    var id=[];
                    var status=[];
                    for (var i=0;i<data.length;i++){
                        id.push(data[i].id);
                        var num = 1;
                        if(data[i].enroll_status == "报名成功" || data[i].enroll_status == "报名不成功"){
                            num=2;
                        }
                        status.push(num);

                        //toolDelByFlag(data[i].id,true, 'auditList');
                        //batchUpdateAudit(id, 'auditList');
                    }
                    batchUpdateAudit(id,status, 'auditList');  //批量审核
                });

                //layerAjax('batchUpdateAudit', data.field, 'auditList');
            },
            update: function () {
                var checkStatus = table.checkStatus('userList')
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
            },
            /*changePwd:function(){
              var checkStatus = table.checkStatus('userList')
                  , data = checkStatus.data;
              if (data.length != 1) {
                layer.msg('请选择一个用户,已选['+data.length+']行', {icon: 5});
                return false;
              }
              rePwd('修改密码','goRePass?id='+data[0].id,500,350);
            }*/

            changePwd: function () {
                var checkStatus = table.checkStatus('userList')
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
                        window.parent.layui.table.reload('userList');*/
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
        table.on('checkbox(audit)', function (obj) {
            console.log(obj)
        });
        //监听工具条
        table.on('tool(audit)', function (obj) {
            var data = obj.data;
            if (obj.event === 'detail') {

                var oDate1 = new Date();
                var oDate2 = new Date(data.end_time);

                if (oDate1.getTime() <= oDate2.getTime()){          //是否截止
                    if(data.audit_link =='交费前'){

                        if(data.audit_status == '待审核') {
                            detail('审核考生', 'updateAudit?id=' + data.id, 1150, 620);
                        }else if(data.audit_status == '已审核') {
                            detail('审核考生', 'updateAudit?id=' + data.id, 1150, 620);
                        }else if(data.audit_status == '待缴费') {
                            window.top.layer.msg('考生未缴费', {icon: 6, offset: 'rb', area: ['120px', '80px'], anim: 2});
                        }else {
                            window.top.layer.msg('已报名成功', {icon: 6, offset: 'rb', area: ['120px', '80px'], anim: 2});
                        }

                    }else if (data.audit_link =='交费后') {
                        if (data.audit_status == '待审核'){
                            detail('审核考生', 'updateAudit?id=' + data.id, 1150, 620);
                        }else if(data.audit_status == '已审核'){
                            detail('审核考生', 'updateAudit?id=' + data.id, 1150, 620);
                        }else if(data.audit_status == '待缴费'){
                            window.top.layer.msg('考生未缴费', {icon: 6, offset: 'rb', area: ['120px', '80px'], anim: 2});
                        }else{
                            window.top.layer.msg('已成功报名', {icon: 6, offset: 'rb', area: ['120px', '80px'], anim: 2});
                        }

                    }
                }else {
                    window.top.layer.msg('审核已截止', {icon: 6, offset: 'rb', area: ['120px', '80px'], anim: 2});
                }

            } else if (obj.event === 'del') {
                layer.confirm('确定删除用户[<label style="color: #00AA91;">' + data.username + '</label>]?', {
                    btn: ['逻辑删除', '物理删除']
                }, function (index) {
                    layer.close(index);
                    toolDelByFlag(data.id, '', false, 'userList');
                }, function (index) {
                    layer.close(index);
                    toolDelByFlag(data.id, '', true, 'userList');
                });
            } else if (obj.event === 'edit') {
                update('编辑用户', 'updateAudit?id=' + data.id, 700, 600);
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
            id: 'user-rePwd',
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
            id: 'user-add',
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
