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
                        <div class="card-header bg-light">
                            图形数据
                        </div>

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

<script>
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
    var option = {
        xAxis: {
            type: 'category',
            data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            name: '温度',
            data: [25, 52, 35, 38, 40, 44, 47],
            type: 'line'
        },
            {
                name: '湿度',
                type: 'line',
                data: [10, 12, 13, 14, 12, 11, 9]
            }]
    };


    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);

</script>
<#include "../common/html_common_footer.ftl">
</body>
</html>
