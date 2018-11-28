<html>
<head>
    <#include "../common/header.ftl">
    <link rel="stylesheet" href="/sell/css/login.css">
</head>
<body>
<#--<div id="wrapper" class="toggled">-->
<div class="container-fluid">
    <div class="row clearfix">

        <div class="login">
            <div class="col-md-12 column">
                <h3>四喜宠物之家</h3>
                <form role="form" method="post" action="/sell/login">
                    <div class="form-group">
                        <label for="inputUsername">用户名</label>
                        <input name="username" class="form-control" id="inputUsername" type="username"/>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword">密码</label>
                        <input name="password" class="form-control" id="inputPassword" type="password"/>
                    </div>
                    <button type="submit" class="btn btn-primary">登录</button>
                </form>
                <button class="btn btn-primary"><a href="/sell/logon">新用户注册</a></button>
            </div>
        </div>
    </div>
</div>

<#--</div>-->
</body>
</html>