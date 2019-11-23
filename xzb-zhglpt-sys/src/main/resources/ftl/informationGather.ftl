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
   
    <style>
        html, body {
            height: 100%;
        }
        .layui-row{
            height: 100%;
        }
        .layui-row .layui-content{
            width: 1000px;
            min-height: 500px;
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
        .haeader-content, .footer-content {
            width: 100%;
            background-color: #009688;
            color: #333;
            height: 120px;
            text-align: center;
        }
        .footer-content .footer {
            width: 666px;
            padding-top: 15px;
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
          .id_img {
            width: 800px;
            margin: 20px auto;
            display: flex;
            justify-content: space-around;
        }
        .w-img {
            width: 280px;
            height: 180px;
            overflow: hidden;
            border: 1px solid #dedede;
        }
        .w-img img {
            height: 100%;
            width: 100%;
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
     <div style="height: 8%;">
            <button style="width: 150px;height: 40px;" type="button" class="layui-btn layui-btn-primary" location.href='${re.contextPath}/studentInformation/getStudentIndex';>返回首页</button>
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
       <form class="layui-form" action="">
            <div class="layui-collapse" lay-filter="collapse" lay-accordion>
                <div class="layui-colla-item">
                    <h2 class="layui-colla-title">身份证</h2>
                    <div class="layui-colla-content">
                        <div class="id_img">
                            <div class="w-img" id="img02">
                            <img
                            src=""
                                style="width:100%;height:100%;"
                                controls="controls"
                            >您的浏览器不支持音频播放/>
                            </div>
                        </div>
                        <div class="id_img">
                            <button type="button" class="layui-btn" id="demo2">点击上传</button>
                            <input type="file" name="file" id="file2" accept="image/*" onchange="showPic2(this)" style="visibility:hidden;position:absolute;top:0px;width:0px" />
                            <input type="button" value="upload" id="upload" style="visibility:hidden;position:absolute;top:0px;width:0px"/>
                        </div>
                    </div>
                </div>
                <div class="layui-colla-item">
                    <h2 class="layui-colla-title">语音</h2>
                    <div class="layui-colla-content">
                       <div class="id_img">
                            <div class="w-img" id="img03">
                            <audio
                            src=""
                                style="width:100%;height:100%;"
                                controls="controls"
                            >您的浏览器不支持音频播放</audio>
                            </div>
                        </div>
                        <div class="id_img">
                             <button type="button" class="layui-btn"  id="demo3">点击上传</button>
                            <input type="file" name="file" id="file3" accept="audio/*" capture="microphone" onchange="showPic3(this)" style="visibility:hidden;position:absolute;top:0px;width:0px" />
                            <input type="button" value="upload" id="upload" style="visibility:hidden;position:absolute;top:0px;width:0px"/>
                        </div>
                    </div>
                </div>
                <div class="layui-colla-item">
                    <h2 class="layui-colla-title">正面视频</h2>
                    <div class="layui-colla-content">
                       <div class="id_img">
                            <div class="w-img" id="img04">
                            <video
                                src=""
                                style="width:100%;height:100%;"
                                controls="controls"
                            >您的浏览器不支持音频播放</video>
                            </div>
                        </div>
                        <div class="id_img">
                            <button type="button" class="layui-btn" id="demo4">点击上传</button>
                            <input type="file" name="file" id="file4" accept="video/*" capture="camcorder" onchange="showPic4(this)" style="visibility:hidden;position:absolute;top:0px;width:0px" />
                            <input type="button" value="upload" id="upload" style="visibility:hidden;position:absolute;top:0px;width:0px"/>
                        </div>
                    </div>
                </div>
            </div>

        <div class="layui-form-item" id="addPicture"></div>
        <div class="layui-form-item" id="addVideo"></div>
        <div class="layui-form-item" id="addFile"></div>
        <div class="layui-form-item" id="addMusic"></div>
        <div id="btn1" style="display: flex;justify-content: center;align-items: center;min-height: 80px;">
            <button style="width: 150px;height: 40px;" type="button" class="layui-btn" onclick="addAction()">确认提交</button>      
        </div>
        <div id="btn2" style="display: flex;justify-content: center;align-items: center;min-height: 80px;">
            <button style="width: 150px;height: 40px;cursor: no-drop;" type="button" class="layui-btn layui-btn-primary">等待审核</button>      
            <button style="width: 150px;height: 40px;" type="button" class="layui-btn" onclick="location.href='${re.contextPath}/studentInformation/getExamQuary';">报考查询</button>
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
    <form class="layui-form" id="test" style="display:none">
        <div style="padding: 5px 20px 36px 20px;text-indent: 2em;">本网站所展示的信息为网站所有者自行提供，内容真实性、准确性、合法性由网站所有者负责。</div>
        <#--  <div style="height: 40px;text-align:center;">点击查看<a href="www.baidu.com">免责声明</a></div>  -->
    </form>

    <form class="layui-form" id="lest" style="display:none">
        <div>
              <iframe
                src="https://view.officeapps.live.com/op/view.aspx?src=http://storage.xuetangx.com/public_assets/xuetangx/PDF/1.xls"
                v-show="show"
                width="100%"
                height="700px"
                frameborder="1"
              ></iframe>
        </div>
        <div style="display: flex;justify-content: center;align-items: center;min-height: 80px;">
            <button style="width: 150px;height: 40px;" type="button" class="layui-btn layui-btn-primary" onclick="removeAction()">返回</button>      
        </div>
    </form>
</div>

 <script type="text/javascript" src="${re.contextPath}/plugin/jquery/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${re.contextPath}/plugin/layui/layui.all.js" charset="utf-8"></script>
    <script type="text/javascript" src="${re.contextPath}/plugin/tools/tool.js"></script>
    <script type="text/javascript" src="${re.contextPath}/plugin/layui/config.js"></script>
<script>
    layui.use(['jquery', 'steps', 'form', 'laydate', 'upload', 'element'], function(){

        var $ = layui.$;
        var $step= $("#step_demo").step();
        $step.goStep(3);//到指定步
        $("#preBtn").click(function(event) {
            $step.preStep();//下一步
        });
        $("#nextBtn").click(function(event) {
            $step.nextStep();//下一步
        });

        var form = layui.form
        ,laydate = layui.laydate
        ,upload = layui.upload
        ,layer = layui.layer
        ,element = layui.element;
        form.render();

        //监听折叠
        element.on('collapse(collapse)', function(data){
            console.log(222)
        });

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

    });
        $('#demo2').click(function() {
                $('#file').click();
        })
        function showPic(source) {
            var file = source.files[0];
                console.log($('#file').val())
             console.log(file)
            if (window.FileReader) {
                var fr = new FileReader();
                fr.onloadend = function(e) {
                        // submit提交
                        $('#upload').click();
                        $("#img01 img").attr('src', e.target.result)
                        convertBase64UrlToBlob(e.target.result)
                };
                fr.readAsDataURL(file);
                console.log(fr)
            }
        }
         $('#demo2').click(function() {
                $('#file2').click();
        })
        function showPic2(source) {
            var file = source.files[0];
             console.log(file)
            if (window.FileReader) {
                var fr = new FileReader();
                fr.onloadend = function(e) {
                        // submit提交
                        $("#img02 img").attr('src', e.target.result)
                        convertBase64UrlToBlob(e.target.result)
                };
                fr.readAsDataURL(file);
                console.log(fr)
            }
        }
        $('#demo3').click(function() {
                $('#file3').click();
        })
        function showPic3(source) {
            var file = source.files[0];
             console.log(file)
            if (window.FileReader) {
                var fr = new FileReader();
                fr.onloadend = function(e) {
                        // submit提交
                        $("#img03 audio").attr('src', e.target.result)
                };
                fr.readAsDataURL(file);
                console.log(fr)
            }
        }
        $('#demo4').click(function() {
                $('#file4').click();
        })
        function showPic4(source) {
            var file = source.files[0];
             console.log(file)
            if (window.FileReader) {
                var fr = new FileReader();
                fr.onloadend = function(e) {
                        // submit提交
                        $("#img04 video").attr('src', e.target.result)
                };
                fr.readAsDataURL(file);
                console.log(fr)
            }
        }

        
        function convertBase64UrlToBlob(urlData){
 
            var bytes=window.atob(urlData.split(',')[1]);        //去掉url的头，并转换为byte
 
            //处理异常,将ascii码小于0的转换为大于0
            var ab = new ArrayBuffer(bytes.length);
            var ia = new Uint8Array(ab);
            for (var i = 0; i < bytes.length; i++) {
                ia[i] = bytes.charCodeAt(i);
            }
 
            return new Blob( [ab] , {type : 'image/png'});

        }
        $(function() {
            $('#btn2').hide();
        })

        function addAction() {
            $('#btn1').hide();
            $('#btn2').show();
        }

  


</script>
</body>

</html>
