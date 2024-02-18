<%@page pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>Chi tiết sản phẩm</title>
    <meta content="" name="description">
    <meta content="" name="keywords">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

    <!-- Google Fonts -->
    <link href="https://fonts.gstatic.com" rel="preconnect">
    <link
            href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
            rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">

    <!-- Template Main CSS File -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
</head>

<body>

<!-- ======= Header ======= -->
<header id="header" class="header fixed-top d-flex align-items-center">

    <div class="d-flex align-items-center justify-content-between">
        <a href="index.html" class="logo d-flex align-items-center">
            <img src="assets/img/logo.png" alt="">
            <span class="d-none d-lg-block">THANH TÂM</span>
        </a>
        <i class="bi bi-list toggle-sidebar-btn"></i>
    </div><!-- End Logo -->

    <div class="search-bar">
        <form class="search-form d-flex align-items-center" method="POST" action="#">
            <input type="text" name="query" placeholder="Search" title="Enter search keyword">
            <button type="submit" title="Search"><i class="bi bi-search"></i></button>
        </form>
    </div><!-- End Search Bar -->

</header><!-- End Header -->

<!-- ======= Sidebar ======= -->
<aside id="sidebar" class="sidebar">

    <ul class="sidebar-nav" id="sidebar-nav">

        <li class="nav-item">
            <a class="nav-link " href="/ban-hang/index">
                <i class="bi bi-grid"></i>
                <span>BÁN HÀNG</span>
            </a>
        </li><!-- End Dashboard Nav -->


        <li class="nav-item">
            <a class="nav-link collapsed" data-bs-target="#forms-nav" data-bs-toggle="collapse"
               href="chi-tiet-san-pham.html">
                <i class="bi bi-journal-text"></i><span>QUẢN LÝ SẢN PHẨM</span><i
                    class="bi bi-chevron-down ms-auto"></i>
            </a>
            <ul id="forms-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                <li>
                    <a href="/spct/index">
                        <i class="bi bi-circle"></i><span>Chi tiết sản phẩm</span>
                    </a>
                </li>
                <li>
                    <a href="/san-pham/index">
                        <i class="bi bi-circle"></i><span>Sản phẩm</span>
                    </a>
                </li>
                <li>
                    <a href="/mau-sac/index">
                        <i class="bi bi-circle"></i><span>Màu sắc</span>
                    </a>
                </li>
                <li>
                    <a href="/kich-thuoc/index">
                        <i class="bi bi-circle"></i><span>Kích thước</span>
                    </a>
                </li>
            </ul>
        </li><!-- End Forms Nav -->

        <li class="nav-item ">
            <a class="nav-link collapsed" href="/hoa-don/index">
                <i class="bi bi-layout-text-window-reverse"></i>
                <span>HÓA ĐƠN</span>
            </a>
        </li><!-- End Dashboard Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed" href="/nhan-vien/index">
                <i class="bi bi-person-lines-fill"></i>
                <span>NHÂN VIÊN</span>
            </a>
        </li><!-- End Dashboard Nav -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="/khach-hang/index">
                <i class="bi bi-people-fill"></i>
                <span>KHÁCH HÀNG</span>
            </a>
        </li><!-- End Dashboard Nav -->


        <li class="nav-heading">Pages</li>

        <li class="nav-item">
            <a class="nav-link collapsed" href="users-profile.html">
                <i class="bi bi-person"></i>
                <span>Profile</span>
            </a>
        </li><!-- End Profile Page Nav -->


        <li class="nav-item">
            <a class="nav-link collapsed" href="pages-register.html">
                <i class="bi bi-card-list"></i>
                <span>Register</span>
            </a>
        </li><!-- End Register Page Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed" href="pages-login.html">
                <i class="bi bi-box-arrow-in-right"></i>
                <span>Login</span>
            </a>
        </li><!-- End Login Page Nav -->


    </ul>

</aside><!-- End Sidebar-->

<main id="main" class="main">

    <div class="pagetitle">
        <h6>BÁN HÀNG</h6>
    </div><!-- End Page Title -->
    <section class="section dashboard">
        <div class="row">
            <!-- Left side columns -->
            <div class="col-lg-8">
                <div class="row">
                    <!-- HÓA ĐƠN -->
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                                <div class="d-flex justify-content-between">
                                    <i class="bi bi-receipt-cutoff" style="font-size: 25px"></i>
                                    <form action="/ban-hang/add-hoa-don" method="POST">
                                        <button type="submit" class="bi bi-plus-square-fill text-end mt-2"
                                                style="font-size: 25px; border: none; background-color: white"></button>
                                    </form>
                                </div>
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th scope="col">STT</th>
                                        <th scope="col">ID</th>
                                        <th scope="col">Ngày tạo</th>
                                        <th scope="col">Tên nhân viên</th>
                                        <th scope="col">Detail</th>
                                    </tr>
                                    </thead>
                                    <tbody>
<%--                                    <c:forEach var="i" items="${listHD}" varStatus="hd">--%>
<%--                                        <c:if test="${i.trangThai == 0}">--%>
<%--                                            <tr>--%>
<%--                                                <th scope="row">${hd.index}</th>--%>
<%--                                                <td>${i.id}</td>--%>
<%--                                                <td>--%>
<%--                                                    <fmt:formatDate value="${i.ngayMuaHang}"--%>
<%--                                                                    pattern="dd-MM-yyyy HH:mm:ss"/>--%>
<%--                                                </td>--%>
<%--                                                <td>--%>
<%--                                                    <c:forEach var="x" items="${listNV}">--%>
<%--                                                        <c:if test="${x.id == i.idNhanVien}">${x.ten}</c:if>--%>
<%--                                                    </c:forEach>--%>
<%--                                                </td>--%>
<%--                                                <td><a class="btn btn-success" href="/ban-hang/detail/${i.id}">View</a>--%>
<%--                                                </td>--%>
<%--                                            </tr>--%>
<%--                                        </c:if>--%>
<%--                                    </c:forEach>--%>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <!-- End HÓA ĐƠN -->

                    <!-- GIỎ HÀNG -->
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                                <i class="bi bi-cart3 card-title" style="font-size: 25px;"></i>
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th scope="col">STT</th>
                                        <th scope="col">Mã SP</th>
                                        <th scope="col">Tên SP</th>
                                        <th scope="col">Số lượng</th>
                                        <th scope="col">Đơn giá</th>
                                        <th scope="col">Thành tiền</th>
                                        <th scope="col"></th>
                                    </tr>
                                    </thead>
                                    <tbody>
<%--                                    <c:forEach var="hdct" items="${listHDCT}" varStatus="kt">--%>
<%--                                        <tr>--%>
<%--                                            <th scope="row">${kt.index + 1}</th>--%>
<%--                                            <td>--%>
<%--                                                <c:forEach var="ctsp" items="${listCTSP}">--%>
<%--                                                    <c:if test="${ctsp.id == hdct.idSPCT}">${ctsp.maSPCT}</c:if>--%>
<%--                                                </c:forEach>--%>
<%--                                            </td>--%>
<%--                                            <td>--%>
<%--                                                <c:forEach var="ctsp" items="${listCTSP}">--%>
<%--                                                    <c:if test="${ctsp.id == hdct.idSPCT}">--%>
<%--                                                        <c:forEach var="sp" items="${listSP}">--%>
<%--                                                            <c:if test="${sp.id == ctsp.idSanPham}">${sp.ten}</c:if>--%>
<%--                                                        </c:forEach>--%>
<%--                                                    </c:if>--%>
<%--                                                </c:forEach>--%>
<%--                                            </td>--%>
<%--                                            <td>--%>
<%--                                               ${hdct.soLuong}--%>
<%--                                            </td>--%>

<%--                                            <td>${hdct.donGia}</td>--%>
<%--                                            <td>--%>
<%--                                                <span id="totalPrice_${hdct.idSPCT}">${hdct.soLuong * hdct.donGia}</span>--%>
<%--                                            </td>--%>
<%--                                            <td>--%>
<%--                                                <form method="POST" action="/ban-hang/delete/${hdct.id}">--%>
<%--                                                    <input type="hidden" name="idHoaDon" value="${idHoaDon}"/>--%>
<%--                                                    <button type="submit" class="btn btn-link">--%>
<%--                                                        <i class="bi bi-x-square-fill" style="font-size: 20px;"></i>--%>
<%--                                                    </button>--%>
<%--                                                </form>--%>
<%--                                            </td>--%>
<%--                                        </tr>--%>
<%--                                    </c:forEach>--%>
                                    </tbody>
                                </table>
                                <!-- End GIỎ HÀNG -->
                            </div>
                        </div>
                    </div>

                    <!-- End  -->
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                                <h6 class="card-title">SẢN PHẨM</h6>
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th scope="col">STT</th>
                                        <th scope="col">Mã</th>
                                        <th scope="col">Tên SP</th>
                                        <th scope="col">Kích thước</th>
                                        <th scope="col">Màu sắc</th>
                                        <th scope="col">Số lượng</th>
                                        <th scope="col">Đơn giá</th>
                                    </tr>
                                    </thead>
                                    <tbody>
<%--                                    <c:forEach var="i" items="${listCTSP}" varStatus="a">--%>
<%--                                        <tr>--%>
<%--                                            <th scope="row">${a.index + 1}</th>--%>
<%--                                            <td>${i.maSPCT}</td>--%>
<%--                                            <td>--%>
<%--                                                <c:forEach var="x" items="${listSP}">--%>
<%--                                                    <c:if test="${x.id == i.idSanPham}">${x.ten}</c:if>--%>
<%--                                                </c:forEach>--%>
<%--                                            </td>--%>
<%--                                            <td>--%>
<%--                                                <c:forEach var="x" items="${listKT}">--%>
<%--                                                    <c:if test="${x.id == i.idKichThuoc}">${x.ten}</c:if>--%>
<%--                                                </c:forEach>--%>
<%--                                            </td>--%>
<%--                                            <td>--%>
<%--                                                <c:forEach var="x" items="${listMS}">--%>
<%--                                                    <c:if test="${x.id == i.idMauSac}">${x.ten}</c:if>--%>
<%--                                                </c:forEach>--%>
<%--                                            </td>--%>
<%--                                            <td>${i.soLuong}</td>--%>
<%--                                            <td>${i.donGia}</td>--%>
<%--                                            <td>--%>
<%--                                                <sf:form action="/ban-hang/add-hdct/${i.id}" method="POST"--%>
<%--                                                         onsubmit="return validateBeforeAddToCart();">--%>
<%--                                                    <input type="hidden" name="idHoaDon" value="${idHoaDon}"--%>
<%--                                                           id="selectedInvoiceId"/>--%>
<%--                                                    <button type="submit" class="bi bi-plus-square-fill"--%>
<%--                                                            style="font-size: 25px; border: none; background-color: white"></button>--%>
<%--                                                </sf:form>--%>
<%--                                            </td>--%>
<%--                                        </tr>--%>
<%--                                    </c:forEach>--%>
                                    </tbody>
                                </table>
                                <!-- End GIỎ HÀNG -->
                            </div>

                        </div>
                    </div>
                </div>
            </div>

            <!-- Right side columns -->
            <div class="col-lg-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">HÓA ĐƠN</h5>
                        <sf:form method="POST" action="/ban-hang/thanh-toan/${data.id}" modelAttribute="data"
                                 onsubmit="return validatePayment()">
                            <div class="row mb-3">
                                <label class="col-sm-4 col-form-label">ID hóa đơn</label>
                                <div class="col-sm-8">
                                    <sf:input type="text" class="form-control" path="id"/>
                                    <sf:errors path="id" cssStyle="color: red"></sf:errors>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label class="col-sm-4 col-form-label">Ngày tạo</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" path="ngayMuaHang"
                                           value="<fmt:formatDate value="${data.ngayMuaHang}" pattern="dd-MM-yyyy HH:mm:ss"/>"/>
                                    <sf:errors path="ngayMuaHang" cssStyle="color: red"></sf:errors>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label class="col-sm-4 col-form-label">Sđt khách hàng</label>
                                <div class="col-sm-6">
                                    <sf:select path="idKhachHang" class="form-select "
                                               aria-label="Default select example">
<%--                                        <c:forEach var="i" items="${listKH}">--%>
<%--                                            <sf:option value="${i.id}">${i.sdt}</sf:option>--%>
<%--                                        </c:forEach>--%>
                                    </sf:select>
                                </div>
                                <a class="col-sm-2" data-bs-toggle="modal" data-bs-target="#exampleModal" href="#">
                                    <i class=" bi bi-folder-plus col-3" style="font-size: 25px;"></i>
                                </a>
                            </div>
                            <div class="row mb-3">
                                <label class="col-sm-4 col-form-label">Tổng tiền</label>
                                <div class="col-sm-8">
                                    <input id="tongTien" type="number" class="form-control" value="${tongTien}"
                                           readonly/>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label class="col-sm-4 col-form-label">Tiền khách đưa</label>
                                <div class="col-sm-6">
                                    <input id="tienKhachDua" class="form-control" type="number" required>
                                </div>
                                <i id="calculateChangeButton" class=" col-sm-2 bi bi-chevron-double-down"
                                   style="font-size: 20px" onclick="calculateChange()"></i>
                            </div>

                            <div class="row mb-3">
                                <label class="col-sm-4 col-form-label">Trả lại</label>
                                <div class="col-sm-8">
                                    <input id="tienTraLai" type="number" class="form-control" required>
                                </div>
                            </div>
                            <div class="row mb-3 mt-4 justify-content-end text-end">
                                <div class="col-sm-10">
                                    <button type="submit" class="btn btn-success ">THANH TOÁN</button>
                                </div>
                            </div>
                        </sf:form><!-- End General Form Elements -->
                    </div>
                </div><!-- End Recent Activity -->
            </div><!-- End Right side columns -->
        </div>
    </section>


    <!-- Modal thêm nhanh khách hàng -->
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Thêm khách hàng</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form id="quickAddCustomerForm" action="/ban-hang/add-khach-hang" method="POST">
                        <input type="hidden" name="idHoaDon" value="${idHoaDon}"/>
                        <div class="row mb-3">
                            <label class="col-sm-4 col-form-label">Tên</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="ten"/>
                            </div>
                        </div>
                        <div class="row mb-3">
                            <label class="col-sm-4 col-form-label">Số điện thoại</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="sdt"/>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary">ADD</button>
                    </form>
                </div>

            </div>
        </div>
    </div>

</main><!-- End #main -->
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>

<script>
    function calculateChange() {
        var tongTien = parseFloat('${tongTien}');
        var tienKhachDua = parseFloat(document.getElementById('tienKhachDua').value);
        var tienTraLai = tienKhachDua - tongTien;
        if (isNaN(tienKhachDua)) {
            alert('Vui lòng nhập số tiền hợp lệ.');
            return;
        }
        if (tienKhachDua < tongTien) {
            alert('Số tiền khách đưa phải lớn hơn hoặc bằng tổng tiền.');
            return;
        }
        // Hiển thị số tiền trả lại trong trường "Trả lại"
        document.getElementById('tienTraLai').value = tienTraLai.toFixed(2);
    }

    function validatePayment() {
        var tienKhachDua = document.getElementById("tienKhachDua").value;
        var tongTien = parseFloat('${tongTien}');
        if (tienKhachDua === "" || tienKhachDua < tongTien) {
            alert("Vui lòng nhập số tiền khách đưa hợp lệ.");
            return false;
        }
        return true;
    }

    function validateBeforeAddToCart() {
        // Kiểm tra xem hóa đơn đã được chọn chưa
        var selectedInvoiceId = document.getElementById("selectedInvoiceId").value;

        if (selectedInvoiceId === "") {
            alert("Vui lòng chọn hóa đơn trước khi thêm sản phẩm vào giỏ hàng.");
            return false; // Ngăn chặn sự kiện click nút "+"
        }

        return true; // Cho phép thêm sản phẩm vào giỏ hàng nếu đã chọn hóa đơn
    }


</script>


<a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i
        class="bi bi-arrow-up-short"></i></a>

<!-- Template Main JS File -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/index.js"></script>

</body>

</html>