<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>

    <title>Manager Bill</title>


    <script>
        // Check if the paymentSuccessful parameter is present in the URL
        const urlParams = new URLSearchParams(window.location.search);
        const paymentSuccessful = urlParams.get('paymentSuccessful');

        // Display an alert if paymentSuccessful is true
        if (paymentSuccessful === 'true') {
            alert('Đặt hàng thành công!');
        }
    </script>
</head>
<body>
<%--Header--%>
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
                            <li><a class="dropdown-item" href="/san-pham-chi-tiet/show-product-detail">Manager Product Detail</a></li>
                            <li><a class="dropdown-item" href="/hoa-don/show-bill">Manager Bill</a></li>
                            <li><a class="dropdown-item" href="/hoa-don-chi-tiet/show-billDetail">Manager Bill Detail</a></li>
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



<%--Body--%>

<div class="container">


    <%--            Table--%>
    <h1 class="text-center">Detail Bill</h1>

    <div class="float-end">
        <a href="/hoa-don/create-bill">
            <button type="button" class="btn btn-success">Create</button>
        </a>

    </div>
    <table class="table mt-5">
        <thead>
        <tr>
            <th scope="col">STT</th>
            <th scope="col">ID Hóa Đơn</th>
            <th scope="col">Nhân Viên</th>
            <th scope="col">Khách Hàng</th>
            <th scope="col">Tên Sản Phẩm</th>
            <th scope="col">Số Lượng</th>
            <th scope="col">Đơn giá</th>
            <th scope="col">Tổng tiền</th>
            <th scope="col">Ngày Mua Hàng</th>
            <th scope="col">Trạng thái</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>



        <c:forEach items="${pageHoaDon.content}" varStatus="hoaDon" var="hd">
            <tr>
                <th scope="row">${hoaDon.index+1}</th>
                <td>${hd.id}</td>
                <td>${hd.idNhanVien.ten}</td>
                <td>${hd.idKhachHang.ten}</td>
                <td>
                    <fmt:formatDate value="${hd.ngayMuaHang}" pattern="dd/MM/yyyy " />
                </td>
                <td>${hd.trangThai == 0 ? "Inactive" : "Active" }</td>
                <div class="float-end">
                    <td>
                        <a href="/hoa-don/edit-bill/${hd.id}">
                            <button type="button" class="btn btn-success">Edit</button>
                        </a>
                        <a href="/hoa-don/delete-bill/${hd.id}">
                            <button type="button" class="btn btn-danger" onclick="return confirm('Are you sure you want to delete this Bill?')">Remove</button>
                        </a>
                        <a href="/hoa-don/bill-detail/${hd.id}">
                            <button type="button" class="btn btn-warning">Detail</button>
                        </a>

                    </td>
                </div>
            </tr>
        </c:forEach>
        </tbody>
    </table>


        <div>
            <nav aria-label="Page navigation example">
                <ul class="pagination">
                    <li class="page-item">
                        <c:if test="${pageHoaDon.number > 0}">
                            <a class="page-link" href="/hoa-don/show-bill?page=${pageHoaDon.number - 1}">Previous</a>
                        </c:if>
                    </li>
                    <li class="page-item"><a class="page-link disabled active-page" onclick="return false;"   href="#">${pageHoaDon.number + 1}</a></li>
                    <li class="page-item">
                        <c:if test="${pageHoaDon.number + 1 < pageHoaDon.totalPages}">
                            <a class="page-link" href="/hoa-don/show-bill?page=${pageHoaDon.number + 1}">Next</a>
                        </c:if>
                    </li>
                </ul>
            </nav>
        </div>
</div>


</body>
</html>

