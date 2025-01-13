<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="it.example.jpa_jboss_servlet_ejb.model.User" %>
<%@ page import="java.util.List" %>
<!doctype html>
<html lang="it">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>JPA_SERVLET</title>
    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/album/">
    <link rel="apple-touch-icon" sizes="180x180" href="./assets/favicon/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="./assets/favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="./assets/favicon/favicon-16x16.png">
    <link rel="manifest" href="./assets/favicon/site.webmanifest">
    <!-- Bootstrap core CSS -->
    <link href="./assets/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>

</head>
<body>

<header>
    <div class="collapse bg-dark" id="navbarHeader">
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-md-7 py-4">
                    <h4 class="text-white">INFO</h4>
                    <p class="text-muted">Esempio di CRUD su utenti</p>
                </div>
            </div>
        </div>
    </div>
    <div class="navbar navbar-dark bg-dark shadow-sm">
        <div class="container">
            <a href="#" class="navbar-brand d-flex align-items-center">
                <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="none" stroke="currentColor"
                     stroke-linecap="round" stroke-linejoin="round" stroke-width="2" aria-hidden="true" class="me-2"
                     viewBox="0 0 24 24">
                    <path d="M23 19a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2V8a2 2 0 0 1 2-2h4l2-3h6l2 3h4a2 2 0 0 1 2 2z"/>
                    <circle cx="12" cy="13" r="4"/>
                </svg>
                <strong>CRUD JPA SERVLET</strong>
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarHeader"
                    aria-controls="navbarHeader" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
        </div>
    </div>
</header>

<main>

    <section class="py-5 text-center container">
        <div class="row py-lg-5">
            <div class="col-lg-6 col-md-8 mx-auto">
                <h1 class="fw-light">JPA_SERVLET example</h1>
                <p class="lead text-muted">Utilizzo di JPA e delle servlet in Jboss/Wildfly </p>
                <button type="button" class="btn btn-primary"  data-bs-toggle="modal" data-bs-target="#exampleModal">
                    AGGIUNGI
                </button>
                <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel aria-hidden=true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h1 class="modal-title fs-5" id="exampleModalLabel">Aggiorna user</h1>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <form action="create-user" method="post" class="row g-3">
                                    <input hidden="hidden"  name="id" value="">
                                    <div class="col-md-6">
                                        <label for="inputName" class="form-label">Name</label>
                                        <input name="name"  value="" type="text" class="form-control" id="inputName">
                                    </div>
                                    <div class="col-md-6">
                                        <label for="inputEmail" class="form-label">Email</label>
                                        <input name="email" value="" type="text" class="form-control" id="inputEmail">
                                    </div>
                                    <div class="col-md-6">
                                        <label for="inputState" class="form-label">Country</label>
                                        <select name="country" id="inputState" class="form-select">
                                            <option value="Italia"  selected>Italia</option>
                                            <option value="Francia">Francia</option>
                                            <option value="Spagna" >Spagna</option>
                                            <option value="Germania">Germania</option>
                                        </select>
                                    </div>
                                    <div class="col-12">
                                        <button type="submit" class="btn btn-primary">Salva</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <div class="album py-5 bg-light">
        <div class="container">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Nome</th>
                    <th scope="col">Email</th>
                    <th scope="col">Country</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>
                <%
                    List<User> users = (List<User>) request.getAttribute("users");
                    if (users != null) {
                        for (User user : users) {
                %>
                <tr>
                    <th scope="row"><%= user.getId() %>
                    </th>
                    <td><%= user.getName()%>
                    </td>
                    <td><%= user.getEmail()%>
                    </td>
                    <td><%= user.getCountry()%>
                    </td>
                    <td>
                        <button type="button" class="btn btn-primary"  data-bs-toggle="modal" data-bs-target="#exampleModal<%= user.getId() %>">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                 class="bi bi-arrow-clockwise" viewBox="0 0 16 16">
                                <path fill-rule="evenodd"
                                      d="M8 3a5 5 0 1 0 4.546 2.914.5.5 0 0 1 .908-.417A6 6 0 1 1 8 2z"/>
                                <path d="M8 4.466V.534a.25.25 0 0 1 .41-.192l2.36 1.966c.12.1.12.284 0 .384L8.41 4.658A.25.25 0 0 1 8 4.466"/>
                            </svg>
                        </button>
                        <div class="modal fade" id="exampleModal<%= user.getId() %>" tabindex="-1" aria-labelledby="exampleModalLabel<%= user.getId() %>" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h1 class="modal-title fs-5" id="exampleModalLabel<%= user.getId() %>">Aggiorna user</h1>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        <form action="update-user" method="post" class="row g-3">
                                            <input hidden="hidden"  name="id" value="<%= user.getId() %>">
                                            <div class="col-md-6">
                                                <label for="inputName" class="form-label">Name</label>
                                                <input name="name"  value="<%= user.getName() %>" type="text" class="form-control" id="inputName">
                                            </div>
                                            <div class="col-md-6">
                                                <label for="inputEmail" class="form-label">Email</label>
                                                <input name="email" value="<%= user.getEmail() %>" type="text" class="form-control" id="inputEmail">
                                            </div>
                                            <div class="col-md-6">
                                                <label for="inputState" class="form-label">Country</label>
                                                <select name="country" id="inputState" class="form-select">
                                                    <option value="Italia" <%=  user.getCountry().equals("Italia") ? "selected" : "" %>>Italia</option>
                                                    <option value="Francia" <%=  user.getCountry().equals("Francia") ? "selected" : "" %>>Francia</option>
                                                    <option value="Spagna" <%=  user.getCountry().equals("Spagna") ? "selected" : "" %>>Spagna</option>
                                                    <option value="Germania" <%=  user.getCountry().equals("Germania") ? "selected" : "" %>>Germania</option>
                                                </select>
                                            </div>
                                            <div class="col-12">
                                                <button type="submit" class="btn btn-primary">Salva</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <a class="text-decoration-none" href="<%= request.getContextPath()%>/delete-user?id=<%= user.getId()%>">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                 class="bi bi-file-earmark-minus" viewBox="0 0 16 16">
                                <path d="M5.5 9a.5.5 0 0 1 .5-.5h4a.5.5 0 0 1 0 1H6a.5.5 0 0 1-.5-.5"/>
                                <path d="M14 4.5V14a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V2a2 2 0 0 1 2-2h5.5zm-3 0A1.5 1.5 0 0 1 9.5 3V1H4a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h8a1 1 0 0 0 1-1V4.5z"/>
                            </svg>
                        </a>
                    </td>
                </tr>
                <%
                    }
                } else {
                %>
                <tr>
                    <td colspan="5" class="text-center">Nessun utente presente</td>
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>

</main>



<footer class="text-muted py-5">
    <div class="container">
        <p class="float-end mb-1">
            <a href="#">Back to top</a>
        </p>
    </div>
</footer>


<script src="./assets/dist/js/bootstrap.bundle.min.js"></script>


</body>
</html>
