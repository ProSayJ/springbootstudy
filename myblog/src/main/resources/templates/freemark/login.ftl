<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org" xmlns:http="http://www.w3.org/1999/xhtml"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity4" xmlns="http://www.w3.org/1999/html">
<body>

<div class="container blog-content-container">

    <form class="table table-condensed ">

        <h2>请登录</h2>


        <div class="form-group">
            <label for="username" class="col-form-label">账号:</label>
            <input type="text" style="width:50%" class="form-control " id="username" name="username" maxlength="50"
                   placeholder="请输入账号">
        </div>
        <div class="form-group">
            <label for="password" class="col-form-label">密码</label>
            <input type="password" style="width:50%" class="form-control" id="password" name="password" maxlength="30"
                   placeholder="请输入密码">
        </div>

        <div class="form-group">
            <input type="checkbox" value="remember-me"> 记住我
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary">登录</button>
        </div>

    </form>
</div> <!-- /container -->

</body>
</html>