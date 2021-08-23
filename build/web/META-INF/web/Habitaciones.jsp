<%@page import="Logica.Controladora"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Hotel</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="Cleaning Company Website Template" name="keywords">
        <meta content="Cleaning Company Website Template" name="description">

        <!-- Favicon -->
        <link href="img/favicon.ico" rel="icon">

        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@100;300;400&display=swap" rel="stylesheet">
        
        <!-- CSS Libraries -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
        <link href="lib/lightbox/css/lightbox.min.css" rel="stylesheet">
    
        <!-- Template Stylesheet -->
        <link href="css/style.css" rel="stylesheet">
          
    </head>

    <body>
        <div class="wrapper">
            <!-- Header Start -->
            <div class="header home">
                <div class="container-fluid">
                    <div class="header-top row align-items-center">
                        <div class="col-lg-3">
                            <div class="brand"><a>Hotel</a>
                            </div>
                        </div>
                        <div class="col-lg-9">                           
                            <div class="navbar navbar-expand-lg bg-light navbar-light">
                                <a href="#" class="navbar-brand">MENU</a>   
                                <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse"> <span class="navbar-toggler-icon"></span></button>
                                    <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                                        <div class="navbar-nav ml-auto">
                                            <div class="nav-item dropdown">
                                                <a class="nav-link dropdown-toggle" data-toggle="dropdown">Huesped</a>
                                                    <div class="dropdown-menu">
                                                        <a href="ConsultarH.jsp" class="dropdown-item">Consultar Huesped</a>
                                                        <a href="Huesped.jsp" class="dropdown-item">Cargar Huesped</a>
                                                    </div>
                                            </div>
                                            <div class="nav-item dropdown">
                                                <a class="nav-link dropdown-toggle" data-toggle="dropdown">Reserva</a>
                                                    <div class="dropdown-menu">
                                                        <a href="ConsultarR.jsp" class="dropdown-item">Consultar Reserva</a>
                                                        <a href="Reserva.jsp" class="dropdown-item">Crear Reserva</a>
                                                    </div>
                                            </div>
                                        <a href="Habitaciones.jsp" class="nav-item nav-link">Habitaciones</a>
                                        </div>
                                    </div>
                            </div>
                        </div>
                    </div>
                </div>
                    <div class="page-header">
                        <div class="container">
                            <div class="row">
                                <div class="col-12">
                                    <h2>HABITACIONES</h2>
                                </div>
                            </div>
                        </div>
                    </div>
                                        
            <!-- Service Start -->
            <div class="service">
                <div class="container">
                    <div class="section-header">
                        <p>Our Rooms</p>
                        <h2>Provide by Polo</h2>
                    </div>
                    <div class="row">
                        <div class="col-lg-3 col-md-6">
                            <div class="service-item">
                                <img src="img/Habitacion1.jpg" alt="Service">
                                <h3>Room N1</h3>
                                 <div class="col-md-4">
                            <div class="price-item">
                                <div class="price-header">
                                    <div class="price-icon">
                                        <i class="fa fa-home"></i>
                                    </div>
                                    <div class="price-title">
                                        <h2>Standard</h2>
                                    </div>
                                    <div class="price-pricing">
                                        <h2><small>$</small>99</h2>
                                    </div>
                                </div>
                                <div class="price-body">
                                    <div class="price-des">
                                        <ul>
                                            <li>3 Bedrooms cleaning</li>
                                            <li>2 Bathrooms cleaning</li>
                                            <li>1 Living room Cleaning</li>
                                            <li>Vacuum Cleaning</li>
                                            <li>Within 6 Hours</li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="price-footer">
                                    <div class="price-action">
                                        <a href=""><i class="fa fa-shopping-cart"></i>Book Now</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                                <p>
                                   Habitacion para 4 Personas, matrimoneal + 2 cuchetas  
                                   Lorem ipsum dolor sit amet elit. Phasellus nec pretium mi. Curabitur facilisis ornare 
                                </p>
                                <a class="btn" href="index.jsp">Reservar</a>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-6">
                            <div class="service-item">
                                <img src="img/Habitacion2.jpg" alt="Service">
                                <h3>Room N2</h3>
                                <p>
                                    Habitacion para 2 Personas, matrimoneal
                                    Lorem ipsum dolor sit amet elit. Phasellus nec pretium mi. Curabitur facilisis ornare
                                </p>
                                <a class="btn" href="index.jsp">Reservar</a>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-6">
                            <div class="service-item">
                                <img src="img/Habitacion3.jpg" alt="Service">
                                <h3>Room N3</h3>
                                <p>
                                    Habitacion para 2 Personas, dos Camas Simples
                                    Lorem ipsum dolor sit amet elit. Phasellus nec pretium mi. Curabitur facilisis ornare
                                </p>
                                <a class="btn" href="index.jsp">Reservar</a>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-6">
                            <div class="service-item">
                                <img src="img/Habitacion4.jpg" alt="Service">
                                <h3>Room N4</h3>
                                <p>
                                    Habitacion para 4 Personas, 2 Matrimoneales
                                    Lorem ipsum dolor sit amet elit. Phasellus nec pretium mi. Curabitur facilisis ornare
                                </p>
                                <a class="btn" href="index.jsp">Reservar</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
         JavaScript Libraries 
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <script src="lib/easing/easing.min.js"></script>
        <script src="lib/owlcarousel/owl.carousel.min.js"></script>
        <script src="lib/isotope/isotope.pkgd.min.js"></script>
        <script src="lib/lightbox/js/lightbox.min.js"></script>
        <script>
            $("#datepicker").datepicker();
        </script>
         Template Javascript 
        <script src="js/main.js"></script>
    </body>
</html>
