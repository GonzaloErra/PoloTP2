<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Logica.Huesped"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Date"%>
<%@page import="Logica.Persona"%>
<%@page import="java.util.List"%>
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
        <a href="single.html"></a>
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
//            VALIDACION DE USUARIO
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
                <div class="container-fluid">
                    <div class="header-top row align-items-center">
                        <div class="col-lg-3   ">
                            <div class="brand">
                                <a>Hotel</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="hero row align-items-center">
                    <div class="col-md-7">
                        <h2>LOGIN</h2>
                        <h2><span>HOTEL</span> POLO</h2>
                    </div>
                </div>
                            <table class="table table-bordered">
                                <thead>
                                    <tr class="row100 head">    
                                        <th>Personas</th>
                                        <th>Documento</th>
                                        <th>Fecha de Nacimiento</th>
                                        <th>Direccion</th>
                                        <th>Profesion</th>
                                        <th>Eliminacion</th>
                                        <th>Modificacion</th>
                                    </tr>
                                </thead>
                                
                                    <% 
//                                    HttpSession misession = request.getSession();
//                                    List <Huesped> listaHuesped = (List) request.getSession().getAttribute("listaHuesped"));
                                    Controladora control = new Controladora();
                                    List<Huesped>listaHuesped = control.traerHuespedes();
                                    for (Huesped hus : listaHuesped){   
                                    
                                    System.out.println(hus.getApellido()    );  %>                                  
                                    <tr>
                                        <%String nombreComp = hus.getNombre() + " " + hus.getApellido();%>
                                        <td> <%=nombreComp%> </td>
                                        <%String Dni = hus.getDni();%>
                                        <td><%=Dni%></td>
                                        <%  Date Nacimiento = hus.getFechaNacimiento();
                                            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                                            String strDate= formatter.format(Nacimiento);
                                        %>
                                        <td><%=strDate%></td>
                                        <%String Direccion = hus.getDireccion();%>
                                        <td><%=Direccion%></td>
                                        <%String Profesion = hus.getProfesion();%>
                                        <td><%=Profesion%></td>
                                        <%int id = hus.getId_alumno();%>
                                      
                                        <td class="cell100 column7">
                                        <form name="formModificarHuesped" action="Eliminar" method="post" style="display: inline">
                                        <input type="hidden" name="id" value="<%=id%>">
                                        <button type="submit" class="btn btn-danger btn-xs" data-title="Edit" style="display: inline">Eliminar</button>
                                        </form>
                                         <td class="cell100 column7">
                                        
                                        <form name="formModificarHuesped" action="Modificar" method="post" style="display: inline">
                                        <input type="hidden" name="id" value="<%=id%>">
                                        <button type="submit" class="btn btn-primary btn-xs" data-title="Edit" style="display: inline">Modificar</button>
                                        </form>
                                        
                                    </tr>
                                    <%}
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
        <%}      %>            
    </body>
</html>
