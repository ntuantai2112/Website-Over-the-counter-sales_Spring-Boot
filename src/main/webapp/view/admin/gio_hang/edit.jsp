<%@page pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Edit Product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</head>
<body>
<div>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Navbar</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/kich-thuoc/show">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Link</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Dropdown
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="#">Action</a></li>
                            <li><a class="dropdown-item" href="#">Another action</a></li>
                            <li><hr class="dropdown-divider"></li>
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
<h1 class="text-center">Edit Size</h1>
<div>

    <div class="container">
        <sf:form action="/san-pham/edit-product/${id}" method="post" modelAttribute="product">
            <div class="mb-3">
                <label  class="form-label">ID Product</label>
                <sf:input path="id" disabled="true" type="text" name="id" placeholder="Id Product" class="form-control"  aria-describedby="emailHelp" />
                <sf:errors path="id" cssStyle="color:red"></sf:errors>
            </div>

            <div class="mb-3">
                <label  class="form-label">Ma </label>
                <sf:input path="ma" type="text"  name="ma" placeholder="Ma Product" class="form-control"  aria-describedby="emailHelp" />
                <sf:errors path="ma" cssStyle="color:red"></sf:errors>
            </div>

            <div class="mb-3">
                <label  class="form-label">Tên </label>
                <sf:input path="ten" type="text" name="ten" placeholder="Name Product" class="form-control"  aria-describedby="emailHelp"/>
                <sf:errors path="ten" cssStyle="color:red"></sf:errors>

            </div>

            <div class="mb-3">
                <label  class="form-label">Trạng Thái </label>
                <sf:input path="trangThai" type="text" name="ten" placeholder="Name Product" class="form-control" aria-describedby="emailHelp" />
                <sf:errors path="trangThai" cssStyle="color:red"></sf:errors>

            </div>

            <button type="submit" class="btn btn-primary">Submit</button>
        </sf:form>
    </div>
</div>
</body>
</html>