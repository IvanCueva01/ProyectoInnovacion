<%@page import="java.util.Iterator"%>
<%@ page import="java.text.DecimalFormat" %>
<%@page import="java.util.Collections"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.*"%>
<%@page import="ModeloDAO.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Gruvitec System</title>

        <!-- Custom fonts for this template-->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="css/sb-admin-2.min.css" rel="stylesheet">

        <!-- Custom styles for this page -->
        <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
    </head>

    <body id="page-top">

        <!-- validacion de sesion -->
        <%
            HttpSession misession = request.getSession();
            String usuario = (String) request.getSession().getAttribute("usuario");
            if (usuario == null) {
                response.sendRedirect("login.jsp");
            }
        %>


        <!-- Page Wrapper -->
        <div id="wrapper">

            <!-- Sidebar -->
            <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

                <!-- Sidebar - Brand -->
                <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.jsp">
                    <div class="sidebar-brand-icon rotate-n-15">
                        <i class="fas fa-solid fa-laptop"></i>
                    </div>
                    <div class="sidebar-brand-text mx-3">Gruvitec System </div>
                </a>

                <!-- Divider -->
                <hr class="sidebar-divider my-0">

                <!-- Nav Item - Dashboard -->
                <li class="nav-item active">
                    <a class="nav-link" href="index.jsp">
                        <i class="fas fa-solid fa-bars"></i>
                        <span>Menú</span></a>
                </li>

                <!-- Divider -->
                <hr class="sidebar-divider">

                <!-- Heading -->
                <div class="sidebar-heading">
                    Gestión
                </div>

                <!-- Nav Item - Pages Collapse Menu -->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
                       aria-expanded="true" aria-controls="collapseTwo">
                        <i class="fa-solid fa-user"></i>
                        <span>Colaboradores</span>
                    </a>
                    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Acciones:</h6>
                            <a class="collapse-item" href="ControladorEmpleado?accion=listar">Listar Empleados</a>
                            <a class="collapse-item" href="ControladorEmpleado?accion=mostraragregar">Registrar Empleados</a>   
                        </div>
                    </div>
                </li


                <!-- Nav Item - Utilities Collapse Menu -->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"
                       aria-expanded="true" aria-controls="collapseUtilities">
                        <i class="fas fa-solid fa-person-booth"></i>
                        <span>Clientes</span>
                    </a>
                    <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities"
                         data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Acciones:</h6>
                            <a class="collapse-item" href="ControladorCliente?accion=listar">Listar Clientes</a>
                            <a class="collapse-item" href="ControladorCliente?accion=mostraragregar">Registrar Clientes</a>
                        </div>
                    </div>
                </li>

                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseServices"
                       aria-expanded="true" aria-controls="collapseServices">
                        <i class="fas fa-solid fa-list"></i>
                        <span>Servicios</span>
                    </a>
                    <div id="collapseServices" class="collapse" aria-labelledby="headingServices"
                         data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Acciones:</h6>
                            <a class="collapse-item" href="ControladorIncidencias?accion=listar">Listar Incidencias</a>
                            <a class="collapse-item" href="ControladorIncidencias?accion=mostraragregar">Registrar Incidencias</a>
                            <a class="collapse-item" href="ControladorServicio?accion=listar">Listar Servicios</a>
                        </div>
                    </div>
                </li>

                <!-- Nav Item - Utilities Collapse Menu -->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUsers"
                       aria-expanded="true" aria-controls="collapseUtilities">
                        <i class="fas fa-solid fa-person-booth"></i>
                        <span>Usuarios</span>
                    </a>
                    <div id="collapseUsers" class="collapse" aria-labelledby="headingUtilities"
                         data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Acciones:</h6>
                            <a class="collapse-item" href="ControladorUsuario?accion=listar">Listar Usuarios</a>
                            <a class="collapse-item" href="ControladorUsuario?accion=mostraragregar">Registrar usuarios</a>
                            <a class="collapse-item" href="ControladorFactura?accion=listar">Lista de Facturaciones</a>
                            <a class="collapse-item" href="SvArticulo?accion=listar">Base de Conocimiento</a>
                        </div>
                    </div>
                </li>

                <!-- Divider -->
                <hr class="sidebar-divider">
            </ul>
            <!-- End of Sidebar -->

            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column">

                <!-- Main Content -->
                <div id="content">

                    <!-- Topbar -->
                    <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                        <!-- Sidebar Toggle (Topbar) -->
                        <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                            <i class="fa fa-bars"></i>
                        </button>

                        <!-- Topbar Navbar -->
                        <ul class="navbar-nav ml-auto">
                            <div class="topbar-divider d-none d-sm-block"></div>

                            <!-- Nav Item - User Information -->
                            <li class="nav-item dropdown no-arrow">
                                <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <span class="mr-2 d-none d-lg-inline text-gray-600 small"><%=request.getSession().getAttribute("usuario")%></span>
                                    <img class="img-profile rounded-circle"
                                         src="img/undraw_profile.svg">
                                </a>
                                <!-- Dropdown - User Information -->
                                <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                     aria-labelledby="userDropdown">
                                    <a class="dropdown-item" href="#">
                                        <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Profile
                                    </a>
                                    <a class="dropdown-item" href="#">
                                        <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Settings
                                    </a>
                                    <a class="dropdown-item" href="#">
                                        <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Activity Log
                                    </a>
                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                        <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Logout
                                    </a>
                                </div>
                            </li>
                        </ul>
                    </nav>
                    <!-- End of Topbar -->

                    <!--Begin Page Content-->    
                    <div class="container-fluid">

                        <!--page heading-->
                        <div class="d-sm-flex align-items-center justify-content-between mb-4">
                            <h1 class="h3 mb-0 text-gray-800">GRUPO VICENTE</h1>
                        </div>
                        <%
                            FacturaDAO facturaDAO = new FacturaDAO();
                            List<Factura> facturas = facturaDAO.listar();
                            double montoTotal = 0;
                            DecimalFormat formatoDecimal = new DecimalFormat("#,##0.00");
                            for (Factura factura : facturas) {
                                montoTotal += factura.getTotal();
                            }
                            String montoMensual = formatoDecimal.format(montoTotal*0.07);
                            String montoAnual = formatoDecimal.format(montoTotal);
                        %>

                        <div class="row">

                            <!-- Earnings (Monthly) Card Example -->
                            <div class="col-xl-3 col-md-6 mb-4">
                                <div class="card border-left-primary shadow h-100 py-2">
                                    <div class="card-body">
                                        <div class="row no-gutters align-items-center">
                                            <div class="col mr-2">
                                                <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                                    Ganancias Mensuales</div>
                                                <div class="h5 mb-0 font-weight-bold text-gray-800">S/.<%=montoMensual%></div>
                                            </div>
                                            <div class="col-auto">
                                                <i class="fas fa-calendar fa-2x text-gray-300"></i>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- Earnings (Annual) Card Example -->
                            <div class="col-xl-3 col-md-6 mb-4">
                                <div class="card border-left-success shadow h-100 py-2">
                                    <div class="card-body">
                                        <div class="row no-gutters align-items-center">
                                            <div class="col mr-2">
                                                <div class="text-xs font-weight-bold text-success text-uppercase mb-1">
                                                    Ganancias Anuales</div>
                                                <div class="h5 mb-0 font-weight-bold text-gray-800">S/.<%=montoAnual%></div>
                                            </div>
                                            <div class="col-auto">
                                                <i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!-- Pending Requests Card Example -->
                            <div class="col-xl-3 col-md-6 mb-4">
                                <div class="card border-left-warning shadow h-100 py-2">
                                    <div class="card-body">
                                        <div class="row no-gutters align-items-center">
                                            <div class="col mr-2">
                                                <div class="text-xs font-weight-bold text-warning text-uppercase mb-1">
                                                    Tareas Pendientes</div>
                                                <div class="h5 mb-0 font-weight-bold text-gray-800">5</div>
                                            </div>
                                            <div class="col-auto">
                                                <i class="fas fa-comments fa-2x text-gray-300"></i>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="d-sm-flex align-items-center justify-content-between mb-4">
                            <h1 class="h3 mb-0 text-gray-800">NOTAS</h1>
                            <a href="SvRecordatorio?accion=mostraragregar" class="btn btn-secondary btn-user btn-link "
                               style="color:white; margin-left:5px">
                                <b>Agregar Recordatorio</b></a> 
                        </div>

                        <div class="row">
                            <div class="col-lg-6 d-lg-inline-block">
                                <%
                                    RecordatorioDAO recordatorioDAO = new RecordatorioDAO();
                                    List<Recordatorio> mensajes = recordatorioDAO.listar();
                                    Iterator<Recordatorio> iter = mensajes.iterator();
                                    Recordatorio rec = null;
                                    Collections.reverse(mensajes);
                                    while (iter.hasNext()) {
                                        rec = iter.next();
                                %>
                                <!-- Dropdown Card Example -->

                                <div class="card shadow mb-4">

                                    <!-- Card Header - Dropdown -->
                                    <div
                                        class="card-header py-3 align-items-center justify-content-between">
                                        <h6 class="m-0 font-weight-bold text-primary"><%=rec.getAutor()%></h6>

                                    </div>
                                    <!-- Card Body -->
                                    <div class="card-body">
                                        <p class="card-text"><%=rec.getMensaje()%></p>
                                        <p class="blockquote-footer"><%=rec.getFecha()%></p>
                                        <a href="SvRecordatorio?accion=editar&id=<%=rec.getId()%>" class="card-link">Editar</a>
                                        <a href="SvRecordatorio?accion=eliminar&id=<%=rec.getId()%>" class="card-link">Eliminar</a>
                                    </div>
                                </div>
                                <%}%>
                            </div>
                        </div>

                        <!-- Footer -->     
                        <footer class="sticky-footer bg-white">
                            <div class="container my-auto">
                                <div class="copyright text-center my-auto">
                                    <span>Copyright &copy; Your Website 2021</span>
                                </div>
                            </div>
                        </footer>
                        <!-- End of Footer -->

                    </div>
                    <!-- End of Content Wrapper -->

                </div>
                <!-- End of Page Wrapper -->

                <!-- Scroll to Top Button-->
                <a class="scroll-to-top rounded" href="#page-top">
                    <i class="fas fa-angle-up"></i>
                </a>

                <!-- Logout Modal-->
                <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Desea salir de sesión?</h5>
                                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true"></span>
                                </button>
                            </div>
                            <div class="modal-body">Selecciona "Logout" si quieres salir de sesión.</div>
                            <div class="modal-footer">
                                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>
                                <a class="btn btn-primary" href="login.jsp">Logout</a>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Bootstrap core JavaScript-->
                <script src="vendor/jquery/jquery.min.js"></script>
                <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

                <!-- Core plugin JavaScript-->
                <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

                <!-- Custom scripts for all pages-->
                <script src="js/sb-admin-2.min.js"></script>

                <!-- Page level plugins -->
                <script src="vendor/chart.js/Chart.min.js"></script>

                <!-- Page level custom scripts -->
                <script src="js/demo/chart-area-demo.js"></script>
                <script src="js/demo/chart-pie-demo.js"></script>

                <!--ultimos añadidos -->

                <!-- Page level plugins -->
                <script src="vendor/datatables/jquery.dataTables.min.js"></script>
                <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

                <!-- Page level custom scripts -->
                <script src="js/demo/datatables-demo.js"></script>
                </body>
                </html>


