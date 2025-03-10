<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Admin Page</title>
    <spring:url value="/resources/css/materialize.css" var="css"/>
    <spring:url value="/resources/js/materialize.js" var="js"/>
    <spring:url value="/resources/css/main.css" var="main"/>
    <spring:url value="/resources/js/tours.js" var="tours"/>
    <spring:url value="/resources/img/1.jpg" var="img1"/>
    <spring:url value="/resources/img/2.jpg" var="img2"/>
    <spring:url value="/resources/img/3.jpg" var="img3"/>
    <spring:url value="/resources/img/4.jpg" var="img4"/>
    <spring:url value="/resources/img/united-kingdom-flag.png" var="imgen"/>
    <spring:url value="/resources/img/russia-flag.png" var="imgru"/>
    <spring:url value="/resources/img/group.png" var="gr"/>
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="${css}" media="screen,projection"/>
    <link type="text/css" rel="stylesheet" href="${main}" media="screen,projection"/>

    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<body>
<header>
    <nav>
        <div class="nav-wrapper tab " >
            <a href="index" class="brand-logo">Tour De Team</a>
            <ul id="nav-mobile" class="right hide-on-med-and-down" style="margin-right: 20px">
                <li><a href="listoftours">Tours</a></li>
                <li><a href="addtour">Add Tour</a></li>
                <li><a href="#">Reservations</a></li>
                <li><a href="#">Clients</a></li>
                <li>
                    <button class="btn waves-effect waves-light" type="submit" name="action">
                        <a class="forButton" href="logout">Log Out</a>
                    </button>
                </li>
            </ul>
        </div>
    </nav>
</header>
<main>
        <div class="container">
            <h2>Clients</h2>
            <table>
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th></th>
                </tr>
                </thead>

                <tbody>
                <tr>
                    <td>Alvin</td>
                    <td>Eclair@gmail.com</td>
                    <td>8988888</td>
                    <td><a href="#!" class="secondary-content">
                        <i class="small material-icons">block</i>
                    </a>
                    </td>
                </tr>
                <tr>
                    <td>Alan</td>
                    <td>Jellybean@gmail.com</td>
                    <td>8988888</td>
                    <td><a href="#!" class="secondary-content">
                        <i class="small material-icons">block</i>
                    </a>
                    </td>
                </tr>
                <tr>
                    <td>Jonathan</td>
                    <td>Lollipop@gmail.com</td>
                    <td>8988888</td>
                    <td><a href="#!" class="secondary-content">
                        <i class="small material-icons">block</i>
                    </a>
                    </td>
                </tr>
                </tbody>
            </table>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
        </div>
</main>
<footer class="page-footer">
    <div class="container">
        <div class="row">
            <div class="col l6 s12">
                <h5 class="white-text">Tour de Team</h5>
                <p class="grey-text text-lighten-4"><spring:message code="footerinf"/></p>
            </div>
            <div class="col l4 offset-l2 s12">
                <h5 class="white-text"><spring:message code="footerlinks"/></h5>
                <ul>
                    <li><a class="grey-text text-lighten-3" href="index"><spring:message code="homepage"/></a></li>
                    <li><a class="grey-text text-lighten-3" href="#"><spring:message code="information"/></a></li>
                    <li><a class="grey-text text-lighten-3" href="#"><spring:message code="feedback"/></a></li>
                    <li><a class="grey-text text-lighten-3" href="#"><spring:message code="contacts"/></a></li>
                </ul>
            </div>
        </div>
    </div>
    <div class="footer-copyright">
        <div class="container">
            © 2018 Copyright Text
        </div>
    </div>
</footer>

<!--JavaScript at end of body for optimized loading-->
<script type="text/javascript" src="${js}"></script>
<script type="text/javascript" src="${tours}"></script>
</body>
</html>