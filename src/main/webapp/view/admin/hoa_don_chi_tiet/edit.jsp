<%@page pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Edit BillDetail</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>

</head>
<body>
<div>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Navbar</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/ban-hang/sell">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Link</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                           data-bs-toggle="dropdown" aria-expanded="false">
                            Dropdown
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="/kich-thuoc/show-size">Manager Size</a></li>
                            <li><a class="dropdown-item" href="/mau-sac/store">Manager Color</a></li>
                            <li><a class="dropdown-item" href="/san-pham/show-product">Manager Product</a></li>
                            <li><a class="dropdown-item" href="/nhan-vien/show-employee">Manager Employee</a></li>
                            <li><a class="dropdown-item" href="/khach-hang/show-customer">Manager Customer</a></li>
                            <li><a class="dropdown-item" href="/san-pham-chi-tiet/show-product-detail">Manager Product
                                Detail</a></li>
                            <li><a class="dropdown-item" href="/hoa-don/show-bill">Manager Bill</a></li>
                            <li><a class="dropdown-item" href="/hoa-don-chi-tiet/show-billDetail">Manager Bill
                                Detail</a></li>
                            <li>
                                <hr class="dropdown-divider">
                            </li>
                            <li><a class="dropdown-item" href="#">Something else here</a></li>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
                    </li>
                </ul>
                <form class="d-flex">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
            </div>
        </div>
    </nav>
</div>

<%--        body--%>
<h1 class="text-center">Edit Bill Detail</h1>
<div>

    <div class="container">
        <sf:form action="/hoa-don-chi-tiet/update-billDetail/${billDetail.id}" method="post"
                 modelAttribute="billDetail">


            <div class="mb-3">
                <label class="form-label">Hóa Đơn</label>
                <sf:select path="idHoaDon" class="form-select">
                    <sf:options items="${listBill}" itemLabel="id" itemValue="id"/>
                </sf:select>
            </div>

            <div class="mb-3">
                <label class="form-label"> Sản Phẩm </label>
                <sf:select path="idSanPhamChiTiet" class="form-select">
                    <sf:options items="${listProductDetail}" itemLabel="id" itemValue="id"/>
                </sf:select>

            </div>

            <div class="mb-3">
                <label class="form-label">Số lượng</label>
                <sf:input path="soLuong" type="text" name="" placeholder="Status Product" class="form-control"
                          aria-describedby="emailHelp"/>
                <sf:errors path="soLuong" cssStyle="color: red"></sf:errors>

            </div>


            <div class="mb-3">
                <label class="form-label">Đơn giá</label>
                <sf:input path="donGia" type="text" name="" placeholder="Unit Price Product" class="form-control"
                          aria-describedby="emailHelp"/>
                <sf:errors path="donGia" cssStyle="color: red"></sf:errors>

            </div>


            <div class="mb-3">
                <label class="form-label">Thời gian </label>
                <sf:input path="thoiGian" type="date" name="" placeholder="Status Product" class="form-control"
                          aria-describedby="emailHelp"/>
                <sf:errors path="thoiGian" cssStyle="color: red"></sf:errors>
            </div>


            <div class="mb-3">
                <label class="form-label">Trạng Thái </label>
                <sf:input path="trangThai" type="text" name="ten" placeholder="Status Product" class="form-control"
                          aria-describedby="emailHelp"/>
                <sf:errors path="trangThai" cssStyle="color: red"></sf:errors>

            </div>


            <button type="submit" class="btn btn-primary">Submit</button>
        </sf:form>
    </div>
</div>
</body>
</html>