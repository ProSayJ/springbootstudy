<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org" xmlns:http="http://www.w3.org/1999/xhtml"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity4" xmlns="http://www.w3.org/1999/html">
<header>
    <link href="/static/bootstrap-3.3.7/css/bootstrap.css" rel="stylesheet"/>
    <link href="/static/bootstrap-select-1.13.9/css/bootstrap-select.min.css" rel="stylesheet"/>
    <style>
        body {
            background: url("../../static/images/bg.jpeg");
            animation-name: myfirst;
            animation-duration: 12s;
            /*变换时间*/
            animation-delay: 2s;
            /*动画开始时间*/
            animation-iteration-count: infinite;
            /*下一周期循环播放*/
            animation-play-state: running;
            /*动画开始运行*/
        }

        @keyframes myfirst {
            0% {
                background: url("../../static/images/bg_new.jpg");
            }
            34% {
                background: url("../../static/images/bg_web.jpg");
            }
            67% {
                background: url("../../static/images/bg.jpeg");
            }
            100% {
                background: url("../../static/images/bg.jpeg");
            }
        }

        .form {
            background: rgba(255, 255, 255, 0.2);
            width: 400px;
            margin: 120px auto;
        }

        /*阴影*/
        .fa {
            display: inline-block;
            top: 27px;
            left: 6px;
            position: relative;
            color: #ccc;
        }

        input[type="text"], input[type="password"] {
            padding-left: 26px;
        }

        .checkbox {
            padding-left: 21px;
        }
    </style>
</header>
<body>
<div class="container">
    <div class="form row">
        <div class="form-horizontal col-md-offset-3" id="login_form">
            <h3 class="form-title">登录</h3>
            <div class="col-md-9">
                <div class="form-group">
                    <i class="fa fa-user fa-lg"></i>
                    <input class="form-control required" type="text" placeholder="请输入账号" id="username"
                           name="username" autofocus="autofocus" maxlength="20"/>
                </div>
                <div class="form-group">
                    <i class="fa fa-lock fa-lg"></i>
                    <input class="form-control required" type="password" placeholder="请输入密码" id="password"
                           name="password" maxlength="8"/>
                </div>
                <div class="form-group">
                    <label class="checkbox">
                        <input type="checkbox" name="remember-me" value="1"/>记住我
                    </label>
                </div>
                <div class="form-group col-md-offset-9">
                    <button type="submit" class="btn btn-success pull-right" name="submit">登录</button>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

</html>