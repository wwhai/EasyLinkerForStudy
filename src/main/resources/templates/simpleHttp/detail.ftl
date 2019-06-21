<!doctype html>
<html lang="en">

<#include "../common/html_common_head.ftl">

<body class="sidebar-fixed header-fixed">

<div class="page-wrapper">
    <#include "../common/nav.ftl">

    <#--client-->

    <div class="main-container">
        <#include "../common/left_menu.ftl">

        <div class="content">
            <div class="row">
                <div class="col-md-12">
                    <div class="card">
                        <div class="card-body">
                            <div id="main" style="width: 100%;height:400px;"></div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <div class="card">
                        <div class="card-header bg-light">
                            原始数据
                        </div>

                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>数据字段名</th>
                                        <th>值</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>1</td>
                                        <td class="text-nowrap">温度</td>
                                        <td>19</td>

                                    </tr>
                                    <tr>
                                        <td>1</td>
                                        <td class="text-nowrap">湿度</td>
                                        <td>23</td>

                                    </tr>
                                    <tr>
                                        <td>1</td>
                                        <td class="text-nowrap">温度</td>
                                        <td>19</td>

                                    </tr>
                                    <tr>
                                        <td>1</td>
                                        <td class="text-nowrap">湿度</td>
                                        <td>23</td>

                                    </tr>
                                    <tr>
                                        <td>1</td>
                                        <td class="text-nowrap">温度</td>
                                        <td>19</td>

                                    </tr>
                                    <tr>
                                        <td>1</td>
                                        <td class="text-nowrap">湿度</td>
                                        <td>23</td>

                                    </tr>
                                    <tr>
                                        <td>1</td>
                                        <td class="text-nowrap">温度</td>
                                        <td>19</td>

                                    </tr>
                                    <tr>
                                        <td>1</td>
                                        <td class="text-nowrap">湿度</td>
                                        <td>23</td>

                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


        </div>
    </div>
</div>
<script type="text/javascript" src="/vendor/echarts/echarts.min.js"></script>
<script type="text/javascript" src="/vendor/jquery/jquery.js"></script>

<script>
    // 基于准备好的dom，初始化echarts实例
    let myChart = echarts.init(document.getElementById('main'));

    $.get("/data/api/dataList/1/0/10", function (data) {
        console.log("Data: " + JSON.parse(JSON.stringify(data.data)));
    });

    // 指定图表的配置项和数据
    let option = {
        color: ['#c23531', '#2f4554', '#61a0a8', '#d48265', '#91c7ae', '#749f83', '#ca8622', '#bda29a', '#6e7074', '#546570', '#c4ccd3'],
        title: {
            text: '温湿度变化曲线'
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data: ['温度', '湿度', '温度指数', '湿度指数']
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        toolbox: {
            feature: {
                saveAsImage: {}
            }
        },
        xAxis: {
            type: 'category',
            // data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
        },
        yAxis: {
            type: 'value'
        },
        series: [
            {
                name: '温度',
                data: [25, 52, 33, 38, 21, 44, 1],
                type: 'line'
            },
            {
                name: '湿度',
                type: 'line',
                data: [10, 12, 13, 14, 12, 11, 9]
            },
            {
                name: '湿度指数',
                type: 'line',
                data: [11, 12, 16, 1, 2, 3, 9]
            },
            {
                name: '湿度指数',
                type: 'line',
                data: [4, 6, 13, 1, 25, 17, 9]
            }]
    };


    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);

</script>
<#include "../common/html_common_footer.ftl">
</body>
</html>
