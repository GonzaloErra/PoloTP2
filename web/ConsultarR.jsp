<%@page import="Logica.Habitacion"%>
<%@page import="Logica.Reserva"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
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

    
        <link href="css/style.css" rel="stylesheet">
        <link href="css/login_1.css" rel="stylesheet">
    </head>
    
    <body>
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
                                        <a href="ConsultarR.jsp" class="dropdown-item">Consultar Disponibilidad</a>
                                    </div>
                            </div>
                        <a href="Habitaciones.jsp" class="nav-item nav-link">Habitaciones</a>
                        </div>
                    </div>
            </div>
        <%
            //VALIDACION DE USUARIO
        HttpSession misession = request.getSession();
        String usu = (String) misession.getAttribute("user");
        
        if (usu == null){
            response.sendRedirect("Login.jsp");
        }
        else{
        %> 
        <div class="wrapper">
            <!-- Header Start -->
            <div class="header home"> 
                <!--Header superior-->  
                <div class="hero row align-items-center">
                    <div class="col-md-7">
                        <h2>LOGIN</h2>
                        <h2><span>HOTEL</span> POLO</h2>
                        <a href="Reserva.jsp" class="btn">Reservar</a>
                    </div>
                    <div class="col-md-5">
                        <div class="form">
                        <h3>Cargar Reservas</h3>
                        <form action="consultarDisponibilidad" method="POST">
                            <h3>Check IN</h3>
                            <input  class="form-control" type="date" name="checkin">
                            <h3>Check OUT</h3>
                            <input  class="form-control" type="date" name="checkout">
                            <button type="submit" class="btn btn-block">Consultar Disponibilidad </button>
                        </form>
                        </div>
                    </div>
                </div>   
                    <table class="table table-bordered">    
                    <thead>
                        <tr class="row100 head">    
                            <th>Nombre de Habitacion</th>
                            <th>Piso</th>
                            <th>Precio</th>
                            <th>Tipo</th>

                        </tr>
                    </thead>
                        <% 
                        Controladora control = new Controladora();
                        List<Habitacion> HabDisponibles = (List<Habitacion>)request.getAttribute("HabitacionNOocupadas");
                        
                        if (HabDisponibles != null){
                        for (Habitacion hab : HabDisponibles){%>                                  
                        <tr>
                            <%String Nombre = hab.getNombre();%>
                            <td> <%=Nombre%> </td>
                            <%String Piso = hab.getPiso();%>
                            <td><%=Piso%></td>
                            <%int Precio = hab.getPrecio();%>
                            <td><%=Precio%></td>
                            <%String Tipo = hab.getTipo();%>
                            <td><%=Tipo%></td>
                        </tr>
                        <%}
                            }
                       %>
                    </table>
                     
            </div>
        </div>
            <!--         JavaScript Libraries -->
                    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
                    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
                    <script src="lib/easing/easing.min.js"></script>
                    <script src="lib/owlcarousel/owl.carousel.min.js"></script>
                    <script src="lib/isotope/isotope.pkgd.min.js"></script>
                    <script src="lib/lightbox/js/lightbox.min.js"></script>
            <!--         Template Javascript -->
                    <script src="js/main.js"></script>
        <%
            }
        %>            
    </body>
</html>
