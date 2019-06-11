<#compress >
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="/static/bootstrap-3.3.7/css/bootstrap.css">
    <link rel="stylesheet" href="/static/plugins/animate/animate.min.css">
    <link rel="stylesheet" href="/static/plugins/toast/css/jquery.toast.min.css">
    <link rel="stylesheet" href="/static/css/style.css">
    <style>
        body {
            background-color: #f5f5f5
        }

        * {
            outline: 0
        }

        label {
            color: #4b1c0f
        }

        .loginForm {
            max-width: 380px;
            margin-top: 10%
        }

        .loginLogo {
            font-size: 56px;
            text-align: center;
            margin-bottom: 25px;
            font-weight: 500;
            color: #444;
            text-shadow: #b2baba .1em .1em .2em
        }

        .loginBody {
            padding: 20px;
            background-color: #fff;
            -o-box-shadow: -4px 7px 46px 2px rgba(0, 0, 0, .1);
            box-shadow: -4px 7px 46px 2px rgba(0, 0, 0, .1)
        }

        .login-button {
            background-color: #fff;
            border-radius: 0;
            border: 1px solid #000;
            transition: all .5s ease-in-out
        }

        .login-button:hover {
            border: 1px solid #fff;
            background-color: #000;
            color: #fff
        }

        .form-group {
            padding-bottom: 25px
        }

        #loginName, #loginPwd {
            border-radius: 0
        }

        .control {
            padding-bottom: 5px
        }
    </style>
</head>
<body>
<div class="container loginForm">
    <div class="loginLogo animated fadeInUp">
        ProSayJ
    </div>
    <div class="loginBody animated">
        <form>
            <div class="form-group animated fadeInUp" style="animation-delay: 0.1s">
                <input type="text" class="form-control" name="loginName" id="loginName" autocomplete="username">
            </div>
            <div class="form-group animated fadeInUp" style="animation-delay: 0.2s">
                <input type="password" class="form-control" name="loginPwd" id="loginPwd"
                       autocomplete="current-password">
            </div>
            <div class="row control animated fadeInUp" style="animation-delay: 0.3s">
                <div class="col-xs-6">
                    <label for="remember"><input type="checkbox" id="remember"> <span
                            style="color: #000;font-weight: lighter">记住我</span></label>
                </div>
                <div class="col-xs-6 pull-right text-right">
                    <a href="#" style="color: #000;">忘记密码？</a>
                </div>
            </div>
            <button type="button" id="btnLogin" class="btn btn-block login-button animated fadeInUp" onclick="doLogin()"
                    style="animation-delay: 0.4s;outline: none;">注册
            </button>
        </form>
    </div>
</div>
</body>
<script src="/static/js/jquery-3.1.1.min.js"></script>
<script src="/static/bootstrap-3.3.7/js/bootstrap.min.js"></script>
<script src="/static/plugins/toast/js/jquery.toast.min.js"></script>
<script src="/static/js/halo.js"></script>
<script src="/static/js/login.js"></script>
<script src="/static/js/move.js"></script>
</html>
</#compress>
