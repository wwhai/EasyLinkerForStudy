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
                                        <i class="fa fa-search"></i> 搜索
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
                            HTTP客户端列表
                        </div>

                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th>编号</th>
                                        <th>设备号</th>
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

                                    <#if clientPage??>
                                        <#list clientPage.content as client>

                                            <tr>
                                            <td class="text-nowrap">${client_index}</td>
                                            <td class="text-nowrap">${client.clientId}</td>
                                            <td>${client.deviceDescribe}</td>
                                            <td>[${client.latitude},${client.longitude}]</td>
                                            <td>
                                        <a href="/simpleHttpClient/detail?clientId=${client.id}" class="btn-outline-primary">详情</a></td>

                                            </tr>
                                        </#list>

                                    </#if>

                                    </tbody>
                                </table>
                                <ul class="pagination">
                                    <li>
                                        <span class="label label-success"> 当前: ${clientPage.number}</span>

                                    </li>
                                    <#if clientPage.isFirst() && !clientPage.isLast() &&(clientPage.number-1>0)>
                                        <li>
                                        <a class="btn-outline-primary" href="/client/list?page=${clientPage.number-1}&size=20">[上一页]</a>
                                        </li>

                                        <li>
                                        <a class="btn-outline-primary" href="/client/list?page=${clientPage.number+1}&size=20">[下一页]</a>
                                        </li>
                                    </#if>


                                    <#if clientPage.isFirst() && clientPage.isLast()>
                                        <li>
                                            <a class="btn-outline-primary" href="#">[没有更多了]</a>
                                        </li>

                                    </#if>


                                    <#if !clientPage.isFirst() && clientPage.isLast()>
                                        <li>
                                        <a class="btn-outline-primary" href="/client/list?page=${clientPage.number-1}&size=20">[上一页]</a>
                                        </li>
                                    </#if>

                                    <#if clientPage.isFirst() && !clientPage.isLast()>
                                        <li>
                                        <a class="btn-outline-primary" href="/client/list?page=${clientPage.number+1}&size=20">[下一页]</a>
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
