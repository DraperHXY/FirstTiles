<%--
  Created by IntelliJ IDEA.
  User: draper
  Date: 2018/11/2
  Time: 下午7:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div ui-view="" class="main">

    <div class="container">
        <div class="login-box row">
            <div class="login-img col-lg-7 col-md-6">
                <img class="img-responsive"
                     src="http://jns.img.bucket.ks3-cn-beijing.ksyun.com/skill/skill_html/images/login-ad_03.png">
            </div>
            <div class="user-border col-lg-5 col-md-6">

                <form class="login-form" name="login" action="/FirstTiles/v1/user" method="post">

                    <i></i><input
                        class="form-control"
                        name="account" type="text" placeholder="请输入手机号"
                        ng-pattern="/\d{11}/" maxlength="11" numberic-input="">
                    <input class="form-control"
                           name="password" type="password" placeholder="请输入登录密码" required=""
                           minlength="6" maxlength="16">

                    <input type="submit" value="登录"/>
                </form>
            </div>
        </div>
    </div>

</div>