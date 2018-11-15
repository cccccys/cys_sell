<html>
<head>
    <#include "../common/header.ftl">
</head>
<body>
<#--<div id="wrapper" class="toggled">-->
<div class="container-fluid">
    <div class="row clearfix">
        <div class="col-md-12 column">

            <form role="form" method="post" action="/sell/login">
                <div class="form-group">
                    <label for="inputUsername">用户名</label>
                    <input name="username" class="form-control" id="inputUsername" type="username"/>
                </div>
                <div class="form-group">
                    <label for="inputPassword">密码</label>
                    <input name="password" class="form-control" id="inputPassword" type="password"/>
                </div>
                <button type="submit" class="btn btn-default">登录</button>
            </form>

        </div>
    </div>
</div>

<#--</div>-->
</body>
</html>