<nav class="navbar page-header">
    <a href="#" class="btn btn-link sidebar-mobile-toggle d-md-none mr-auto">
        <i class="fa fa-bars"></i>
    </a>

    <a class="navbar-brand" href="#">
        <#--<img src="../../imgs/logo.png" alt="logo">-->
        <h1>Admin</h1>
    </a>

    <a href="#" class="btn btn-link sidebar-toggle d-md-down-none">
        <i class="fa fa-bars"></i>
    </a>

    <ul class="navbar-nav ml-auto">
        <#if noReadMessageCount??>

            <li class="nav-item d-md-down-none">
            <a href="/userMessage/list?state=1"> <i class="fa fa-envelope-open"></i>
            <span class="badge badge-pill badge-danger">${noReadMessageCount}</span>
            </a>
            </li>
        <#else>
            <li class="nav-item d-md-down-none">
                <a href="/userMessage/list?state=1">
                    <div id="blink" style="padding-right: 6px">[我的消息]</div>
                    <script language="javascript">
                        function changeColor() {
                            var color = "#f00|#0f0|#00f|#880|#808|#088|yellow|green|blue|gray";
                            color = color.split("|");
                            document.getElementById("blink").style.color = color[parseInt(Math.random() * color.length)];
                        }
                        setInterval("changeColor()", 200);
                    </script>
                </a>
            </li>

        </#if>


        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true"
               aria-expanded="false">

                <img src="../../imgs/avatar-1.png" class="avatar avatar-sm" alt="logo">
                <#if Session.user?exists>
                    <span class="small ml-1 d-md-down-none"> 欢迎你:${Session.user.username}</span>
                </#if>
            </a>

            <div class="dropdown-menu dropdown-menu-right">
                <div class="dropdown-header">账号信息</div>

                <a href="#" class="dropdown-item">
                    <i class="fa fa-user"></i> 个人资料
                </a>

                <a href="/logout" class="dropdown-item">
                    <i class="fa fa-lock"></i> 注销
                </a>
            </div>
        </li>
    </ul>
</nav>