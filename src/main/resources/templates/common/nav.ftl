<nav class="navbar navbar-inverse navbar-fixed-top" id="sidebar-wrapper" role="navigation">
    <ul class="nav sidebar-nav">
        <li class="sidebar-brand title">
            <a href="#">
                四喜宠物之家
            </a>
        </li>
        <div id="seller">
            <li>
                <a href="/sell/order/list"><i class="fas fa-clipboard-list"></i> 订单</a>
            </li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true"><i
                        class="fas fa-cube"></i> 商品
                </a>
                <ul class="dropdown-menu" role="menu">
                    <li class="dropdown-header">操作</li>
                    <li>
                        <a href="/sell/product/list">列表</a>
                    </li>
                    <li>
                        <a href="/sell/product/index">新增</a>
                    </li>
                </ul>
            </li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">
                    <i class="fas fa-boxes"></i> 类目
                </a>
                <ul class="dropdown-menu" role="menu">
                    <li class="dropdown-header">操作</li>
                    <li>
                        <a href="/sell/category/list">列表</a>
                    </li>
                    <li>
                        <a href="/sell/category/index">新增</a>
                    </li>
                </ul>
            </li>
        </div>

        <div id="buyer">
            <li>
                <a href="/sell/product/list"><i class="fas fa-cube"></i> 查看商品</a>
            </li>
            <li>
                <a href="/sell/cart/list"><i class="fas fa-shopping-cart"></i> 购物车</a>
            </li>
            <li>
                <a href="/sell/order/buyer_list"><i class="fas fa-clipboard-list"></i> 我的订单</a>
            </li>
        </div>


        <li>
            <a href="/sell/logout"><i class="fas fa-sign-out-alt"></i> 登出</a>
        </li>
    </ul>
</nav>

<script>
    var type = document.cookie.replace(/(?:(?:^|.*;\s*)type\s*=\s*([^;]*).*$)|^.*$/, "$1");

    if (type === '1') {
        document.getElementById('seller').style.display = 'none';
    }
    if (type === '0') {
        document.getElementById('buyer').style.display = 'none';
    }

</script>
