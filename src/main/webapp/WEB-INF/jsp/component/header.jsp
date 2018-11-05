<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<div class="container hidden-xs">
    <div class="row header-top">
        <p class="col-xs-12 col-sm-4 col-md-6 col-lg-6">客服电话:010-594-78634</p>
        <div class="col-xs-12 col-sm-8 col-md-6 col-lg-6 text-right">
            <div>
                <a href="#" target="_blank"> <img alt="" src="/FirstTiles/img/54537.png"></a>
                <a href="#" target="_blank"><img alt="" src="/FirstTiles/img/45678678.png"></a>
                <a href="#" target="_blank"> <img alt="" src="/FirstTiles/img/54375483543.png"></a>
                <!--消息-->
                <a style="padding-right: 3px">
                    <img style="margin-top: -5px;margin-right: -5px;padding-right: 3px"
                         src="http://jns.img.bucket.ks3-cn-beijing.ksyun.com/skill/skill_html/images/user-nav-3.png">

                </a>
                <!--写日报-->
                <span class="header-dot-333">|</span>
                <a class="ng-scope" style="color: #000000">写</a><!-- end ngIf: selfData.cid > 0 -->
                <span class="header-dot-333">|</span>
                <!--日报-->
                <a class="ng-scope" style="color: #000000" href="/school/10466/daily">日报</a>
                <span class="header-dot-333">|</span>
                <!--班级-->
                <a class="ng-binding ng-scope" style="color: #000000" href="/class/712//daily">3班</a>
                <span class="header-dot-333">|</span>
                <!--报名-->
                <a class="ng-binding ng-scope" style="color: #000000" href="/occupation/5/daily">java</a>
                <span class="header-dot-333">|</span>

                <!--登录用户名-->
                <a class="header-user ng-binding" style="color: #000000" href="/school/10466/class">贺啸宇</a>
                <span class="header-dot-333 ng-scope" ng-if="selfData.nick">|</span>
                <!--退出-->
                <a class="message-color" style="color: #000000" href="">退出</a>
            </div>
        </div>
    </div>
</div>

<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <a href="#" class="navbar-brand">
                <img src="/FirstTiles/img/logo.png" alt="Brand" class="img-responsive">
            </a>
            <button data-target="#open-nav" data-toggle="collapse" class="navbar-toggle btn-primary collapsed"
                    aria-expanded="false">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div id="open-nav" class="navbar-collapse collapse" aria-expanded="false" style="height: 1px;">
            <ul class="nav navbar-nav navbar-right text-center list-inline">
                <li><a href="/FirstTiles">首页</a></li>
                <li><a href="/FirstTiles/v1/profession">职业</a></li>
                <li><a href="">推荐</a></li>
                <li><a href="">关于</a></li>
            </ul>
        </div>

    </div>
</nav>