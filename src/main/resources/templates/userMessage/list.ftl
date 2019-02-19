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
                <#--<div class="col-md-12">-->
                <#--<div class="card-body">-->

                <#--<div class="row mt-4">-->

                <#--<div class="col-md-4">-->
                <#--<label for="input-group-2">搜索</label>-->
                <#--<div class="input-group">-->
                <#--<input type="text" id="input-group-2" name="input1-group2" class="form-control"-->
                <#--placeholder="关键字:ID/UUID/客户端ID">-->
                <#--<span class="input-group-btn">-->
                <#--<button type="button" class="btn btn-primary"><i-->
                <#--class="fa fa-search"></i> 搜索</button>-->
                <#--</span>-->
                <#--</div>-->
                <#--</div>-->

                <#--</div>-->
                <#--</div>-->
                <#--</div>-->

                <div class="col-md-12">
                    <div class="card">
                        <div class="card-header bg-light">
                            我的消息
                        </div>

                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th>编号</th>
                                        <th>创建时间</th>
                                        <th>标题</th>
                                        <th>内容</th>
                                        <th>状态</th>
                                        <th>操作</th>

                                    </tr>
                                    </thead>
                                    <tbody>

                                    <#if userMessagePage??>
                                        <#list userMessagePage.content as userMessage>

                                            <tr>
                                            <td class="text-nowrap">${userMessage_index}</td>
                                            <td class="text-nowrap">${userMessage.createTime}</td>
                                            <td>${userMessage.title}</td>
                                            <td>${userMessage.content}</td>

                                            <#if userMessage.state==1>
                                                <th>
                                                    <button class="btn btn-rounded btn-info">未读</button>
                                                </th>

                                            <#else >
                                                <th>
                                                    <button class="btn btn-rounded btn-success">已读</button>
                                                </th>
                                            </#if>


                                            <#if userMessage.state==1>
                                                <th>
                                                    <a href="/userMessage/markRead?id=${userMessage.id}" class="btn btn-outline-primary">标记已读</a>
                                                </th>

                                            <#else >
                                                <th>
                                                    <a type="button" class="btn btn-outline-danger">删除</a>
                                                </th>
                                            </#if>

                                            </tr>

                                        </#list>

                                    </#if>

                                    </tbody>
                                </table>
                                <ul class="pagination">
                                    <li>
                                        <span class="label label-success"> 当前: ${userMessagePage.number}</span>

                                    </li>
                                    <#if userMessagePage.isFirst() && !userMessagePage.isLast() &&(userMessagePage.number-1>0)>
                                        <li>
                                        <a class="btn-outline-primary" href="/userMessage/list?page=${userMessagePage.number-1}&size=20">[上一页]</a>
                                        </li>

                                        <li>
                                        <a class="btn-outline-primary" href="/userMessage/list?page=${userMessagePage.number+1}&size=20">[下一页]</a>
                                        </li>
                                    </#if>


                                    <#if userMessagePage.isFirst() && userMessagePage.isLast()>
                                        <li>
                                            <a class="btn-outline-primary" href="#">[没有更多了]</a>
                                        </li>

                                    </#if>


                                    <#if !userMessagePage.isFirst() && userMessagePage.isLast()>
                                        <li>
                                        <a class="btn-outline-primary" href="/userMessage/list?page=${userMessagePage.number-1}&size=20">[上一页]</a>
                                        </li>
                                    </#if>

                                    <#if userMessagePage.isFirst() && !userMessagePage.isLast()>
                                        <li>
                                        <a class="btn-outline-primary" href="/userMessage/list?page=${userMessagePage.number+1}&size=20">[下一页]</a>
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
