<!doctype html>
<html lang="en">
<#include "common/html_common_head.ftl">
<body>
<div class="page-wrapper flex-row align-items-center">
    <div class="container">

    <div class="row justify-content-center">
        <div class="col-md-5">
            <div class="card p-4">
                <div class="card-header text-center text-uppercase h4 font-weight-light">
                    Login
                </div>
                <#if login_error_message??>
                <div class="alert alert-danger alert-dismissible" role="alert">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <strong>${login_error_message}</strong>.
                </div>

                 </#if>


                <#if tip_message??>
                    <div class="alert alert-success alert-dismissible" role="alert">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                                aria-hidden="true">&times;</span></button>
                    <strong>${tip_message}</strong>.
                    </div>

                </#if>

                <form action="/login" method="post">

                    <div class="card-body py-5">
                        <div class="form-group">
                            <label class="form-control-label">Email</label>
                            <input type="email" name="email" class="form-control" value="123@qq.com">
                        </div>

                        <div class="form-group">
                            <label class="form-control-label">Password</label>
                            <input type="password" name="password" class="form-control">
                        </div>

                        <div class="custom-control custom-checkbox mt-4">
                            <input type="checkbox" class="custom-control-input" id="login" value="12345678">
                            <label class="custom-control-label" for="login">记住密码</label>
                        </div>
                    </div>
                    <div class="card-footer">
                        <div class="row">
                            <div class="col-6">
                                <button type="submit" class="btn btn-primary px-5">Login</button>
                            </div>

                            <div class="col-6">
                                <a href="#" class="btn btn-link">忘记密码?</a>
                            </div>
                        </div>
                    </div>
                </form>


            </div>

        </div>
    </div>
</div>
</div>
<#include "common/html_common_footer.ftl">
</body>
</html>
