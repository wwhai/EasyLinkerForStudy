<!doctype html>
<html lang="en">
<#include "../common/html_common_head.ftl">

<body class="sidebar-fixed header-fixed">
<div class="page-wrapper">
    <#include "../common/nav.ftl">


    <div class="main-container">
        <#include "../common/left_menu.ftl">

        <div class="content">

            <div class="jumbotron alert-dismissable">
                <h1>欢迎进入终端管理系统!</h1>
            </div>


            <div class="panel panel-success">
                <div class="panel-heading">
                    <h3 class="panel-title">客户端数据总览</h3>
                </div>
                <div class="panel-body">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-md-3">
                                <div class="card p-4">
                                    <div class="card-body d-flex justify-content-between align-items-center">
                                        <div>
                                            <span class="h4 d-block font-weight-normal mb-2">54</span>
                                            <span class="font-weight-light">设备总数</span>
                                        </div>

                                        <div class="h2 text-muted">
                                            <i class="icon icon-settings"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="col-md-3">
                                <div class="card p-4">
                                    <div class="card-body d-flex justify-content-between align-items-center">
                                        <div>
                                            <span class="h4 d-block font-weight-normal mb-2">3200</span>
                                            <span class="font-weight-light">在线设备</span>
                                        </div>

                                        <div class="h2 text-muted">
                                            <i class="icon icon-clock"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="col-md-3">
                                <div class="card p-4">
                                    <div class="card-body d-flex justify-content-between align-items-center">
                                        <div>
                                            <span class="h4 d-block font-weight-normal mb-2">900</span>
                                            <span class="font-weight-light">离线设备</span>
                                        </div>

                                        <div class="h2 text-muted">
                                            <i class="icon icon-cloud-download"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="col-md-3">
                                <div class="card p-4">
                                    <div class="card-body d-flex justify-content-between align-items-center">
                                        <div>
                                            <span class="h4 d-block font-weight-normal mb-2">32</span>
                                            <span class="font-weight-light">活跃设备</span>
                                        </div>

                                        <div class="h2 text-muted">
                                            <i class="icon icon-badge"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>

                </div>
            </div>



        </div>
    </div>
</div>
<#include "../common/html_common_footer.ftl">

</body>
</html>
