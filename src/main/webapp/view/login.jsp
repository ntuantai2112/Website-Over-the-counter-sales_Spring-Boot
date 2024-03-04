<%--<%@taglib uri="" prefix="c"%>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Form</title>
    <link rel="stylesheet" type="text/css" href="form_login/Login.css">
    <!-- Nhúng Bootstrap từ CDN -->
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style type="text/css">
        .bg-dark {
            color: black;
            background: white;
        }

        .singup {
            display: block;
            width: 100%;
            padding: 0.5rem 1rem;
            font-size: 1.25rem;
            line-height: 1.5;
            border-radius: 0.3rem;
        }

    </style>
</head>
<body>
<form action="/login" method="post">
    <section class="vh-100" style="background-color: #508bfc;">
        <div class="container py-5 h-100">
            <div
                    class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                    <div class="card shadow-2-strong" style="border-radius: 1rem;">
                        <div class="card-body p-5 text-center">

                            <h3 class="mb-5">Sign in</h3>


                            <div class="form-outline mb-4">
                                <%--                                <lable>Email</lable>--%>
                                <input type="text" id="typeEmailX-2" name="email"
                                       value="" class="form-control form-control-lg"
                                       placeholder="Email"/>
                                <%--                                <label class="text-danger">${messUserName}</label>--%>
                            </div>
                            <div class="form-outline mb-4">
                                <%--                                <lable>Password</lable>--%>
                                <input type="password" id="typePasswordX-2" name="password"
                                       value=""
                                       class="form-control form-control-lg" placeholder="Password"/>
                                <%--                                <label class="text-danger">${messPass}</label>--%>

                            </div>

                            <!-- Checkbox -->
                            <div class="form-check d-flex justify-content-start mb-4">
                                <input class="form-check-input" type="checkbox"
                                       value="" name="remember" id="form1Example3"/>

                                <label class="form-check-label" for="form1Example3">
                                    Remember me? </label>
                            </div>


                            <%--Button Đăng nhập --%>
                            <div class="mb-2">
                                <button class="btn btn-primary btn-lg btn-block" type="submit">Login</button>
                            </div>

                            <%--Button Đăng ký --%>
                            <a href="/singup" class="singup text-decoration-none btn btn-success "> Sing up new
                                Account </a>

                            <hr class="my-4">

                            <button class="btn btn-lg btn-block btn-primary"
                                    style="background-color: #dd4b39" type="submit">
                                <img src="/assets/img/social%20(1).png" alt=""> Sign in with google
                            </button>
                            <button class="btn btn-lg btn-block btn-primary mb-2"
                                    style="background-color: #3b5998;" type="submit">
                                <img src="/assets/img/facebook.png" alt=""> Sign in with facebook
                            </button>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

</form>

</body>
</html>