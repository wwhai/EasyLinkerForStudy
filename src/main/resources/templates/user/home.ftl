<!doctype html>
<html lang="en">

<#include "../common/html_common_head.ftl">

<body class="sidebar-fixed header-fixed">
<div class="page-wrapper">
    <#include "../common/nav.ftl">


    <div class="main-container">
        <#include "../common/left_menu.ftl">

        <div class="content">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body p-0">
                                <hr class="my-5">
                                <div class="row pb-5 p-5">
                                    <div class="col-md-6">
                                        <#if Session.user?exists>
                                            <span><img src="/imgs/avatar-1.png" class="avatar" alt="logo" width="100px"
                                                       height="100px">
                                            <h3>${Session.user.username}</h3>
                                            </span>
                                        </#if>


                                        <p class="mb-1">用户名:${Session.user.username}></p>
                                        <p class="mb-1">Email:${Session.user.email}></p>
                                        <p class="mb-1">昵称:${Session.user.nickname}></p>
                                        <p class="mb-1">角色:${Session.user.roles}></p>
                                        <p class="mb-1">Token:${Session.user.token}></p>

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
