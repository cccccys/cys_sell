<html>
<head>
    <#include "../common/header.ftl">
    <link rel="stylesheet" href="/sell/css/product.css">
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
                            <th>商品ID</th>
                            <th>名称</th>
                            <th>图片</th>
                            <th>单价</th>
                            <th>库存</th>
                            <th>描述</th>
                            <th>类目</th>
                            <th>创建时间</th>
                            <th>修改时间</th>
                        <#--操作占了两列-->
                            <th colspan="2" >操作</th>
                        </tr>
                        </thead>
                        <tbody>

                    <#list productInfoPage.content as productInfo>
                    <tr>
                        <td>${productInfo.productId}</td>
                        <td>${productInfo.productName}</td>
                        <td><img height="100" width="100" src="${productInfo.productIcon}" alt=""></td>
                        <td>${productInfo.productPrice}</td>
                        <td>${productInfo.productStock}</td>
                        <td>${productInfo.productDescription}</td>
                        <td>${productInfo.categoryType}</td>
                        <td>${productInfo.createTime}</td>
                        <td>${productInfo.updateTime}</td>
                        <td width="70" class="seller"><a href="/sell/product/index?productId=${productInfo.productId}">修改</a>
                        </td>
                        <td width="70" class="seller">
                            <#if productInfo.getProductStatusEnum().message == "在售中">
                                <a href="/sell/product/off_sale?productId=${productInfo.productId}">下架</a>
                            <#else>
                                <a href="/sell/product/on_sale?productId=${productInfo.productId}">上架</a>
                            </#if>
                        </td>
                        <td width="70" class="buyer">
                            <div class="input-group spinner">
                                <input type="text" class="form-control" value="1">
                                <div class="input-group-btn-vertical">
                                    <button class="btn btn-default" type="button"><i class="fas fa-caret-up"></i>
                                    </button>
                                    <button class="btn btn-default" type="button"><i class="fas fa-caret-down"></i>
                                    </button>
                                </div>
                            </div>
                        </td>
                        <td width="70" class="buyer"><i class="fas fa-cart-plus"></i></td>
                    </tr>
                    </#list>
                        </tbody>
                    </table>
                </div>

            <#--分页-->
                <div class="col-md-12 column">
                    <ul class="pagination pull-right">
                    <#if currentPage lte 1>
                        <li class="disabled"><a href="#">上一页</a></li>
                    <#else>
                        <li><a href="/sell/product/list?page=${currentPage - 1}&size=${size}">上一页</a></li>
                    </#if>
                    <#--0..<x 从0到小于x的值的循环-->
                    <#list 1..productInfoPage.getTotalPages() as index>
                        <#if currentPage == index>
                            <li class="disabled"><a href="#">${index}</a></li>
                        <#else>
                            <li><a href="/sell/product/list?page=${index}&size=${size}">${index}</a></li>
                        </#if>
                    </#list>

                    <#if currentPage gte productInfoPage.getTotalPages()>
                        <li class="disabled"><a href="#">下一页</a></li>
                    <#else>
                        <li><a href="/sell/product/list?page=${currentPage + 1}&size=${size}">下一页</a></li>
                    </#if>
                    </ul>
                </div>
            </div>
        </div>
    </div>

</div>


<script>
    var type = document.cookie.replace(/(?:(?:^|.*;\s*)type\s*=\s*([^;]*).*$)|^.*$/, "$1");

    if (type === '1') {
        // document.getElementById('seller').style.display = 'none';
        var seller = document.getElementsByClassName('seller');
        for (var i = 0; i < seller.length; i++) {
            seller[i].style.display = 'none';
        }
    }
    if (type === '0') {
        // document.getElementById('buyer').style.display = 'none';
        var buyer = document.getElementsByClassName('buyer');
        for (var i = 0; i < buyer.length; i++) {
            buyer[i].style.display = 'none';
        }
    }

    (function ($) {
        $('.spinner .btn:first-of-type').on('click', function() {
            $('.spinner input').val( parseInt($('.spinner input').val(), 10) + 1);
        });
        $('.spinner .btn:last-of-type').on('click', function() {
            $('.spinner input').val( parseInt($('.spinner input').val(), 10) - 1);
        });
    })(jQuery);
</script>
</body>
</html>

