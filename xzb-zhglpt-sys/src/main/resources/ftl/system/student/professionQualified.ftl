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
    <title>报名成功</title>
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
    <script type="text/javascript" src="${re.contextPath}/ftl/js/bar.js"></script>
    <script type="text/javascript" src="${re.contextPath}/ftl/js/echarts.js"></script>
    <script type="text/javascript" src="${re.contextPath}/ftl/js/jquery.js"></script>
    <style>
        html, body {
            height: 100%;
        }
        .layui-row{
            display: flex;
            height: 100%;
            flex-direction: column;
        }
        .layui-row .layui-content{
            width: 1000px;
            flex: 1;
            margin: 0 auto;
            padding: 20px 0;
            box-sizing: border-box;
        }
        .layui-row .layui-content .layui-table th,td {
            text-align: center;
        }
        .layui-row .layui-content .step-body {
            margin: 30px 0;
        }
        .layui-row .layui-content .layui-table-box {
            min-height: 200px;
        }
        .layui-row .layui-content .matter {
            width: 800px;
            font-size: 14px;
            line-height: 25px;
            margin: 20px auto;
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
    </style>
</head>
<body style="background-color:#f2f2f2;">
<div class="layui-row layui-form-pane">
    <div id="main" style="height:450px;width:900px;"></div>
    <script>
        bindData();
        var myChart = echarts.init(document.getElementById('main'));
        myChart.showLoading({
            text: '正在努力的读取数据中...',    //loading
        });
        function bindData(){
            var no= $("#officeId").val()
            var name= $("#officeName").val()
            /* console.log(no)
            console.log(name) */
            $.ajax({
                async: true,
                url: 'map',
                type: 'post',
                dataType: 'json',
                data: {
                    no1: $("#officeId").val(),
                    name1:$("#officeName").val(),
                    dateTime:$("#startDate").val()
                },
                success:function(echartData){
                    if(echartData){
                        var qualifiedAvgList=echartData.qualifiedAvgList[0]
                        var qualifiedNumberList=echartData.qualifiedNumberList[0]
                        myChart.setOption({
                            color: ['#3398DB'],
                            tooltip : {
                                trigger: 'axis',
                                axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                                    type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                                }
                            },
                            grid: {
                                left: '3%',
                                right: '4%',
                                bottom: '3%',
                                containLabel: true
                            },
                            xAxis : [
                                {
                                    type : 'category',
                                    data : ['合格平均分数', '合格人数'],
                                    axisTick: {
                                        alignWithLabel: true
                                    }
                                }
                            ],
                            yAxis : [
                                {
                                    type : 'value'
                                }
                            ],
                            series : [
                                {
                                    name:'直接访问',
                                    type:'bar',
                                    barWidth: '60%',
                                    data:[qualifiedAvgList,qualifiedNumberList],
                                    label:{
                                        normal:{
                                            show: true,
                                            position: 'inside'
                                        }
                                    }
                                }
                            ], toolbox: {
                                show : true,										//显示策略，可选为：true（显示） | false（隐藏）
                                orient:'horizontal',							//布局方式，默认为水平布局，可选为：'horizontal' | 'vertical'
                                x:'right',										//水平安放位置，默认为全图居中，可选为：'center' | 'left' | 'right' | {number}（x坐标，单位px）
                                y:'top',												//垂直安放位置，默认为全图顶端，可选为：'top' | 'bottom' | 'center' | {number}（y坐标，单位px）
                                backgroundColor:'rgba(0,0,0,0)',	//工具箱背景颜色，默认透明
                                borderColor:'#ccc',							//工具箱边框颜色
                                borderWidth:0,								//工具箱边框线宽，单位px，默认为0（无边框）
                                padding:5,										//工具箱内边距，单位px，默认各方向内边距为5，接受数组分别设定上右下左边距，同css，见下图
                                itemGap:10,									//各个item之间的间隔，单位px，默认为10，横向布局时为水平间隔，纵向布局时为纵向间隔，见下图
                                itemSize:18,										//工具箱icon大小，单位（px）
                                color:['#1e90ff','#22bb22','#4b0082','#d2691e'],//工具箱icon颜色序列，循环使用
                                showTitle:true,								//是否显示工具箱文字提示，默认启用
                                textStyle:{color: '#1e90ff'},										//工具箱提示文字样式，（详见textStyle）											//垂直安放位置，默认为全图顶端，可选为：'top' | 'bottom' | 'center' | {number}（y坐标，单位px）
                                //功能按钮
                                feature : {
                                    //数据视图
                                    dataView : {
                                        /* show : true,
                                        title : '数据视图',
                                        readOnly: true,
                                        lang : ['数据显示','关闭','刷新'] */
                                        show: true, readOnly: false,
                                        lang : ['数据显示','关闭','刷新'],
                                        optionToContent: function (opt) {
                                            var  axisData = opt.xAxis[0].data; //坐标数据
                                            var series = opt.series; //折线图数据
                                            var tdHeads = '<td  style="padding: 0 10px">分行</td>'; //表头
                                            var tdBodys = ''; //数据
                                            series.forEach(function (item) {
                                                //组装表头
                                                tdHeads += '<td style="padding: 0 10px">'+item.name+'</td>';
                                            });
                                            var table = '<table border="1" style="margin-left:20px;border-collapse:collapse;font-size:14px;text-align:center"><tbody><tr>'+tdHeads+' </tr>';
                                            for (var i = 0, l = axisData.length; i < l; i++) {
                                                for (var j = 0; j < series.length; j++) {
                                                    //组装表数据
                                                    tdBodys += '<td>'+series[j].data[i]+'</td>';
                                                }
                                                table += '<tr><td style="padding: 0 10px">'+axisData[i]+'</td>'+tdBodys+'</tr>';
                                                tdBodys = '';
                                            }
                                            table += '</tbody></table>';
                                            return table;

                                        },
                                        contentToOption: function(HTMLDomElement, opt){
                                            return opt;
                                        }//刷新事件  返回上一页面
                                    },
                                    //模式切换
                                    magicType: {
                                        show : true,
                                        title : {
                                            line : '折线图切换',
                                            bar : '柱形图切换',
                                            stack : '堆叠',
                                            tiled : '平铺'
                                        },
                                        type : ['line','bar']
                                    },
                                    //还原
                                    restore : {
                                        show : true,
                                        title : '还原'
                                    },
                                    //保存为图片
                                    saveAsImage : {
                                        show : true,
                                        title : '保存为图片',
                                        type : 'png',
                                        lang : ['点击保存']
                                    }
                                }
                            }

                        })
                        myChart.hideLoading();	//loading hidden
                    }
                }
            })
        }
    </script>
</body>

</html>
