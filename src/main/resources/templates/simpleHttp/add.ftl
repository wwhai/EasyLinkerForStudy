<!doctype html>
<html lang=" ">

<#include "../common/html_common_head.ftl">

<body class="sidebar-fixed header-fixed">

<div class="page-wrapper">
    <#include "../common/nav.ftl">


    <div class="main-container">
        <#include "../common/left_menu.ftl">

        <div class="content">
            <div class="row">
                <div class="col-md-5">
                    <div class="card p-4">
                        <div class="card-header text-center text-uppercase h4 font-weight-light">
                            <h1>添加设备</h1>
                            <#if tip_message??>
                            <h4 style="color: red"><strong>${tip_message}</strong></h4>
                            </#if>
                        </div>


                        <div class="card-body py-5">
                            <form method="post" action="/simpleHttpClient/add" >
                                <div class="form-group">
                                    <label class="form-control-label">设备名称</label>
                                    <input type="text" name="name" class="form-control">
                                </div>

                                <div class="form-group">
                                    <label class="form-control-label">设备描述</label>
                                    <input type="text" name="deviceDescribe" class="form-control">
                                </div>

                                <div class="card-footer">
                                    <button type="submit" class="btn btn-success btn-block">创建设备</button>
                                </div>
                            </form>

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
