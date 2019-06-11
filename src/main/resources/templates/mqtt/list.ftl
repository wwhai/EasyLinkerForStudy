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
                <div class="col-md-12">
                    <div class="card">
                        <div class="card-header border border-top-0 border-right-0 border-left-0">
                            搜索
                        </div>

                        <div class="card-body">
                            <div class="row">
                                <div class="col-md-8">
                                    <input type="text" id="input-group-2" name="input1-group2" class="form-control"
                                           placeholder="关键字:ID/UUID/客户端ID">
                                </div>
                                <div class="col-md-2">
                                    <button type="button" class="btn btn-primary">
                                        <i class="fa fa-search"></i> 搜索
                                    </button>
                                </div>
                                <div class="col-md-2">
                                    <button type="button" class="btn btn-primary">
                                        <i class="fa fa-search"></i> <a href="/mqttClient/toAdd">添加设备</a>
                                    </button>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>

            <div class="row">

                <div class="col-md-12">
                    <div class="card">
                        <div class="card-header bg-light">
                            Mqtt客户端列表
                        </div>

                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th>编号</th>
                                        <th>设备号</th>
                                        <th>名称</th>
                                        <th>详情</th>
                                        <th>经纬度</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>

                                    <#--int getNumber();-->
                                    <#--int getSize();-->
                                    <#--int getNumberOfElements();-->
                                    <#--List<T> getContent();-->
                                    <#--boolean hasContent();-->
                                    <#--Sort getSort();-->
                                    <#--boolean isFirst();-->
                                    <#--boolean isLast();-->
                                    <#--boolean hasNext();-->
                                    <#--boolean hasPrevious();-->
                                    <#--default Pageable getPageable() {-->
                                    <#--return PageRequest.of(this.getNumber(), this.getSize(), this.getSort());-->
                                    <#--}-->
                                    <#--Pageable nextPageable();-->
                                    <#--Pageable previousPageable();-->

                                    <#if mqttClientPage??>
                                        <#list mqttClientPage.content as mqttClient>

                                            <tr>
                                                <td class="text-nowrap">${mqttClient_index}</td>
                                                <td class="text-nowrap">${mqttClient.clientId}</td>
                                                <#if mqttClient.name??>
                                                    <td>${mqttClient.name}</td>
                                                <#else>
                                                    <td>暂无名称</td>
                                                </#if>


                                                <td>${mqttClient.deviceDescribe}</td>
                                                <td>[${mqttClient.latitude},${mqttClient.longitude}]</td>
                                                <td>
                                                    <a href="/mqttClient/detail?clientId=${mqttClient.id}"
                                                       class="btn-outline-primary">详情</a></td>

                                            </tr>
                                        </#list>

                                    </#if>

                                    </tbody>
                                </table>
                                <ul class="pagination">
                                    <li>
                                        <span class="label label-success"> 当前: ${mqttClientPage.number}</span>

                                    </li>
                                    <#if mqttClientPage.isFirst() && !mqttClientPage.isLast() &&(mqttClientPage.number-1>0)>
                                        <li>
                                            <a class="btn-outline-primary"
                                               href="/mqttClient/list?page=${mqttClientPage.number-1}&size=20">[上一页]</a>
                                        </li>

                                        <li>
                                            <a class="btn-outline-primary"
                                               href="/mqttClient/list?page=${mqttClientPage.number+1}&size=20">[下一页]</a>
                                        </li>
                                    </#if>


                                    <#if mqttClientPage.isFirst() && mqttClientPage.isLast()>
                                        <li>
                                            <a class="btn-outline-primary" href="#">[没有更多了]</a>
                                        </li>

                                    </#if>


                                    <#if !mqttClientPage.isFirst() && mqttClientPage.isLast()>
                                        <li>
                                            <a class="btn-outline-primary"
                                               href="/mqttClient/list?page=${mqttClientPage.number-1}&size=20">[上一页]</a>
                                        </li>
                                    </#if>

                                    <#if mqttClientPage.isFirst() && !mqttClientPage.isLast()>
                                        <li>
                                            <a class="btn-outline-primary"
                                               href="/mqttClient/list?page=${mqttClientPage.number+1}&size=20">[下一页]</a>
                                        </li>
                                    </#if>


                                </ul>
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
