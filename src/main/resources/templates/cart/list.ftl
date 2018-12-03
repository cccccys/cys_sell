<html>
<head>
    <#include "../common/header.ftl">
    <style>
        .sum {
            font-size: 16px;
        }
    </style>
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
                            <th>商品单价</th>
                            <th>数量</th>
                            <th>小计</th>
                            <th>创建时间</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>

                    <#assign sum = 0>
                    <#list cartInfoList as cart>
                    <tr>
                        <td>${cart.productId}</td>
                        <td>${cart.productPrice}</td>
                        <td>${cart.productQuantity}</td>
                        <#assign productSum = cart.productPrice * cart.productQuantity>
                        <td>${productSum}</td>
                        <td>${cart.createTime}</td>
                        <td width="70"><a href="javascript:deleteCart(${cart.cartId})">删除</a></td>
                        <#assign sum = sum + productSum>
                    </tr>
                    </#list>
                        </tbody>
                    </table>
                    <div class="sum">
                        总计: ${sum}
                    </div>

                    <div>
                        <form>
                            <div class="form-group">
                                <label>收货人姓名</label>
                                <input id="name" name="buyerName" type="text" class="form-control"
                                       value=""/>
                            </div>
                            <div class="form-group">
                                <label>手机号</label>
                                <input id="phone" name="buyerPhone" type="text" class="form-control"
                                       value=""/>
                            </div>
                            <div class="form-group">
                                <label>收货地址</label>
                                <input id="address" name="buyerAddress" type="text" class="form-control"
                                       value=""/>
                            </div>
                            <button class="btn btn-primary"><a href="javascript:addOrder()">ok</a>
                            </button>
                            <#--<a href="javascript:addOrder(buyerName.value, buyerPhone.value, buyerAddress.value)"></a>-->
                        </form>

                    </div>
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

    var addOrder = function () {
        var items = [];
        <#list cartInfoList as cart>
            items.push({
                productId: ${cart.productId},
                productQuantity: ${cart.productQuantity},
            });
        </#list>
        var productDetails = JSON.stringify(items);

        var username = document.cookie.replace(/(?:(?:^|.*;\s*)username\s*=\s*([^;]*).*$)|^.*$/, "$1");

        var orderForm = document.createElement('form');
        orderForm.method = 'post';
        orderForm.action = '/sell/order/add';

        var nameInput = document.createElement('input');
        nameInput.setAttribute('name', 'name');
        nameInput.setAttribute('value', document.getElementById('name').value);
        var phoneInput = document.createElement('input');
        phoneInput.setAttribute('name', 'phone');
        phoneInput.setAttribute('value', document.getElementById('phone').value);
        var addressInput = document.createElement('input');
        addressInput.setAttribute('name', 'address');
        addressInput.setAttribute('value', document.getElementById('address').value);
        var usernameInput = document.createElement('input');
        usernameInput.setAttribute('name', 'username');
        usernameInput.setAttribute('value', username);
        var itemsInput = document.createElement('input');
        itemsInput.setAttribute('name', 'items');
        itemsInput.setAttribute('value', productDetails);

        orderForm.appendChild(nameInput);
        orderForm.appendChild(phoneInput);
        orderForm.appendChild(addressInput);
        orderForm.appendChild(usernameInput);
        orderForm.appendChild(itemsInput);

        document.body.appendChild(orderForm);
        orderForm.submit();
        document.body.removeChild(orderForm);
    };
</script>
</body>
</html>

