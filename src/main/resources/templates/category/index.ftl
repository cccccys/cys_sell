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
                    <form role="form" method="post" action="/sell/category/save">
                        <div class="form-group">
                            <label>类目名</label>
                            <input name="categoryName" type="text" class="form-control"
                                   value="${(category.categoryName)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>type</label>
                            <input name="categoryType" type="number" class="form-control"
                                   value="${(category.categoryType)!''}"/>
                        </div>
                        <#--隐藏字段-->
                        <input hidden type="text" name="categoryId" value="${(category.categoryId)!''}">
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>

