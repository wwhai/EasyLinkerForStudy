<!doctype html>
<html lang="en">

<#include "../common/html_common_head.ftl">

<body class="sidebar-fixed header-fixed">
<div class="page-wrapper">
    <#include "../common/nav.ftl">


    <div class="main-container">
        <#include "../common/left_menu.ftl">

        <div class="content">
            <div class="row">
                <div class="col-md-6">
                    <div class="card">
                        <div class="card-header bg-light">
                            Bar Charts
                        </div>

                        <div class="card-body">
                            <canvas id="bar-chart" width="100%" height="50"></canvas>
                        </div>
                    </div>
                </div>

                <div class="col-md-6">
                    <div class="card">
                        <div class="card-header bg-light">
                            Line Charts
                        </div>

                        <div class="card-body">
                            <div id="line-chart" style="width: 100%; height: 300px;"></div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
<#include "../common/html_common_footer.ftl">

<script src="/js/line-chart.js"></script>
</body>
</html>
