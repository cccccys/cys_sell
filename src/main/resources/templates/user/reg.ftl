<html>
<head>
    <#include "../common/header.ftl">
    <link rel="stylesheet" href="/sell/css/login.css">
</head>
<body>
<div class="container-fluid">
    <div class="row clearfix">

        <div class="login">
            <div class="col-md-12 column">
                <h3>注册新用户</h3>
                <form role="form" method="post" action="/sell/reg">
                    <div class="form-group">
                        <label for="inputUsername">用户名</label>
                        <input name="username" class="form-control" id="inputUsername" type="text"/>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword">密码</label>
                        <input name="password" class="form-control" id="inputPassword" type="password"/>
                    </div>
                    <div class="form-group">
                        <label for="inputPasswordAck">确认密码</label>
                        <input name="passwordAck" class="form-control" id="inputPasswordAck" type="password"/>
                    </div>
                    <button type="submit" class="btn btn-primary">注册</button>
                </form>
                <button class="btn btn-warning"><a href="/sell/index">返回</a></button>
            </div>
        </div>
    </div>
</div>

</body>
</html>