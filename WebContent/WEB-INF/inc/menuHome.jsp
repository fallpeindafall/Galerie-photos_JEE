<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
            <div class="container">
<!--                 <a class="navbar-brand js-scroll-trigger" href="#page-top"><img src="assets/img/navbar-logo.svg" alt="" /></a>
 -->                <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    Menu
                    <i class="fas fa-bars ml-1"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav text-uppercase ml-auto">
                        
                        <li class="nav-item"><a class="nav-link js-scroll-trigger" href="<c:url value='/'/>">Home</a></li>
                        <li class="nav-item"><a class="nav-link js-scroll-trigger" href="<c:url value='/AddImages'/>">Publish</a></li>
                        <li class="nav-item"><a class="nav-link js-scroll-trigger" href="#portfolio">Pictures</a></li>
                        <li class="nav-item"><a class="nav-link js-scroll-trigger" href="#images">My Gallery</a></li>
                        <li class="nav-item"><a class="nav-link js-scroll-trigger" href="#">Sign Out</a></li>
                        
                    </ul>
                </div>
            </div>
        </nav>