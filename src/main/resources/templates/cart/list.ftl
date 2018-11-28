<html>
<head>
    <#include "../common/header.ftl">
</head>
<body>

<div id="wrapper" class="toggled">

<#--侧边栏sidebar-->
    <#include "../common/nav.ftl">
<#--主要内容content-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table table-hover table-bordered table-condensed">
                        <thead>
                        <tr>
                            <th>商品号</th>
                            <th>数量</th>
                            <th>创建时间</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>

                    <#list cartInfoList as cart>
                    <tr>
                        <td>${cart.productId}</td>
                        <td>${cart.productQuantity}</td>
                        <td>${cart.createTime}</td>
                        <td width="70"><a href="javascript:deleteCart(${cart.cartId})">删除</a></td>
                    </tr>
                    </#list>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

</div>

<script>

    var deleteCart = function (cartId) {
        var postForm = document.createElement('form');
        postForm.method = 'post';
        postForm.action = '/sell/cart/delete';

        var formInput = document.createElement('input');
        formInput.setAttribute('name', 'cartId');
        formInput.setAttribute('value', cartId);

        postForm.appendChild(formInput);
        document.body.appendChild(postForm);
        postForm.submit();
        document.body.removeChild(postForm);
    }
</script>
</body>
</html>

