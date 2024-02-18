<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

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

    <title>Sell</title>
</head>
<body>
    <%--Header--%>
    <div class="mb-5">
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
                            <a class="nav-link" href="#">Purchase history</a>
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


       <div class="container">

<%--          Giao diện Bán Hàng  --%>

           <div class="row">

               <c:if test="${not empty successMessage}">
                   <div class="alert alert-success">
                       <strong> ${successMessage}</strong>
                   </div>
               </c:if>



               <h1 class="text-center mb-5">BÁN HÀNG</h1>

               <div class="col-8" >
<%--                Bảng Hóa đơn chờ --%>
                   <div class="card mb-4">
                       <div class="card-header">
                            Hóa Đơn
                           <div class="float-end">
                               <a href="/ban-hang/add-hoa-don">
                                   <button type="button" class="btn btn-success">Create</button>
                               </a>
                           </div>

                       </div>
                           <div class="card-body">

                               <table class="table">
                                   <thead>
                                   <tr>
                                       <th scope="col">STT</th>
                                       <th scope="col">ID Hóa Đơn</th>
                                       <th scope="col">Nhân Viên</th>
                                       <th scope="col">Ngày Mua Hàng</th>
                                       <th scope="col">Trạng Thái</th>
                                       <th scope="col">Action</th>
                                   </tr>
                                   </thead>

                                   <tbody>
                                   <c:forEach items="${listHD}" varStatus="hoaDon" var="hd">
                                           <tr   class="${hd.id == idHoaDon ? 'table-primary' : ''}">
                                               <th scope="row">${hoaDon.index+1}</th>
                                               <td>${hd.id}</td>
                                               <td>${hd.idNhanVien.ten}</td>
                                               <td>
                                                   <fmt:formatDate value="${hd.ngayMuaHang}" pattern="dd/MM/yyyy " />
                                               </td>

                                               <td>${hd.trangThai == 0 ? "Chờ Thanh Toán" : "Đã Thanh Toán" }</td>
                                               <td>
                                                   <a href="/ban-hang/detail/${hd.id}"><button type="button" class="btn btn-primary">Chọn</button></a>
                                                   <a href="/ban-hang/delete-bill/${hd.id}"><button type="button" class="btn btn-primary">Delete</button></a>
                                               </td>
                                           </tr>

                                   </c:forEach>

                                   <%-- Hiển thị lỗi vượt quá 5 bản ghi--%>
                                   <c:if test="${not empty error}">
                                       <div style="color: red;">
                                           <p><strong>${error}</strong></p>
                                       </div>
                                   </c:if>


                                   </tbody>

                               </table>

                           </div>
                   </div>

                   <div class="card mb-4">
                       <div class="card-header">Giỏ Hàng</div>
                       <div class="card-body">
                           <table class="table">
                               <thead>
                               <tr>
                                   <th scope="col">STT</th>
                                   <th scope="col">Mã Sản Phẩm</th>
                                   <th scope="col">Tên Sản Phẩm</th>
                                   <th scope="col">Số Lượng</th>
                                   <th scope="col">Đơn Giá</th>
                                   <th scope="col">Thành Tiền</th>
                                   <th scope="col">Action</th>
                               </tr>
                               </thead>

                               <tbody>

                               <c:forEach var="hoaDonChiTiet" items="${listHDCT}" varStatus="loop">
                                   <tr>
                                       <td>${loop.index + 1}</td>
                                       <td>${hoaDonChiTiet.idSanPhamChiTiet.idSanPham.ma}</td>
                                       <td>${hoaDonChiTiet.idSanPhamChiTiet.idSanPham.ten}</td>
                                       <td><input type="number" value="${hoaDonChiTiet.soLuong}"></td>
                                       <td>${hoaDonChiTiet.donGia}</td>
                                       <td>${hoaDonChiTiet.soLuong * hoaDonChiTiet.donGia}</td>
                                       <td>
<%--                                           Xóa sản phẩm khỏi giỏ hàng--%>
                                           <a href="/ban-hang/gio-hang/remove-from-cart/${hoaDonChiTiet.idSanPhamChiTiet.id}">
                                               <button type="button" class="btn btn-danger" onclick="return confirm('Are you sure you want to delete this product?')">Remove</button>
                                           </a>
                                       </td>
                                   </tr>
                               </c:forEach>

                               </tbody>
                           </table>
                       </div>
                   </div>


<%--                   Thông báo lỗi sản phẩm trong kho đã hết hàng--%>
                   <c:if test="${not empty errorMessage}">
                       <div class="alert alert-danger">
                           <strong>Lỗi!</strong> ${errorMessage}
                       </div>
                   </c:if>

<%--                    Bảng Sản Phẩm--%>
                   <div class="card mb-4">
                       <div class="card-header">Sản phẩm</div>
                       <div class="card-body">
                           <table class="table">
                               <thead>
                               <tr>
                                   <th scope="col">STT</th>
                                   <th scope="col">Mã Sản Phẩm</th>
                                   <th scope="col">Tên Sản Phẩm</th>
                                   <th scope="col">Kích Thước</th>
                                   <th scope="col">Màu Sắc</th>
                                   <th scope="col">Số Lượng</th>
                                   <th scope="col">Đơn Giá</th>
                                   <th scope="col">Action</th>
                               </tr>
                               </thead>

                               <tbody>
                               <c:forEach items="${pageSanPhamChiTiet.content}" varStatus="sanPham" var="sp">
                               <tr>
                                   <th scope="row">${sanPham.index + 1}</th>
                                   <td>${sp.idSanPham.ma}</td>
                                   <td>${sp.idSanPham.ten}</td>
                                   <td>${sp.idKichThuoc.ten}</td>
                                   <td>${sp.idMauSac.ten}</td>
                                   <td>${sp.soLuong}</td>
                                   <td>${sp.donGia}</td>
                                   <td>

                                       <a href="/ban-hang/gio-hang/add-to-cart/${sp.id}"><button   type="button" class="btn btn-primary" onclick="return validateBeforeAddToCart()">Add To Cart</button></a>
                                   </td>
                               </tr>
                               </c:forEach>
                               </tbody>



                           </table>
                           <div>
                               <nav aria-label="Page navigation example">
                                   <ul class="pagination">
                                       <li class="page-item">
                                           <c:if test="${pageSanPhamChiTiet.number > 0}">
                                               <a class="page-link" href="/ban-hang/sell?page=${pageSanPhamChiTiet.number - 1}">Previous</a>
                                           </c:if>
                                       </li>
                                       <li class="page-item"><a class="page-link disabled active-page" onclick="return false;"   href="#">${pageSanPhamChiTiet.number + 1}</a></li>
                                       <li class="page-item">
                                           <c:if test="${pageSanPhamChiTiet.number + 1 < pageSanPhamChiTiet.totalPages}">
                                               <a class="page-link" href="/ban-hang/sell?page=${pageSanPhamChiTiet.number + 1}">Next</a>
                                           </c:if>
                                       </li>
                                   </ul>
                               </nav>
                           </div>
                       </div>
                   </div>

               </div>

                   <!-- Right side columns  -->
<%--               Bản Hóa Đơn--%>
                   <div class="col-lg-4">
                       <div class="card">
                           <div class="card-body">
                               <h5 class="card-title">HÓA ĐƠN</h5>


                               <sf:form method="POST" action="/ban-hang/thanh-toan/${data.id}" modelAttribute="data"
                                        onsubmit="return validatePayment()">
                                   <div class="row mb-3">
                                       <label class="col-sm-4 col-form-label">ID hóa đơn</label>
                                       <div class="col-sm-8">
                                           <sf:input type="text" value="" name="idHoaDon"  class="form-control" path="id"/>
                                           <sf:errors path="id" cssStyle="color: red"></sf:errors>
                                       </div>
                                   </div>
                                   <div class="row mb-3">
                                       <label class="col-sm-4 col-form-label">Ngày tạo</label>
                                       <div class="col-sm-8">
                                           <input type="text" class="form-control" path="ngayMuaHang"
                                                  value="<fmt:formatDate value="${data.ngayMuaHang}" pattern="dd-MM-yyyy "/>"/>
                                           <sf:errors path="ngayMuaHang" cssStyle="color: red"></sf:errors>
                                       </div>
                                   </div>
                                   <div class="row mb-3">
                                       <label class="col-sm-4 col-form-label">Sđt khách hàng</label>
                                       <div class="col-sm-6">
                                           <sf:select path="idKhachHang" class="form-select">
                                               <sf:options items="${listKH}" itemLabel="sdt" itemValue="id" />
                                           </sf:select>
<%--&lt;%&ndash;                                     --%>
                                       </div>
                                       <a class="col-sm-2" data-bs-toggle="modal" data-bs-target="#exampleModal" href="#">
                                           <i class=" bi bi-folder-plus col-3" style="font-size: 25px;"></i>
                                       </a>
                                   </div>
                                   <div class="row mb-3">
                                       <label class="col-sm-4 col-form-label">Tổng tiền</label>
                                       <div class="col-sm-8">
                                           <input id="tongTien" name="tongTien"  type="number" class="form-control" value="${tongTien}"
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
                               </sf:form>
                               <!-- End General Form Elements -->
                           </div>
                       </div><!-- End Recent Activity -->
                   </div><!-- End Right side columns -->





           </div>
       </div>

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