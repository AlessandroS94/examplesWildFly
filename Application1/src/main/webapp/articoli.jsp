<%@ page import="it.asl.application1.model.Articolo" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ale
  Date: 03/01/25
  Time: 22:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container mt-4">
    <h2>Elenco Articoli</h2>
    <table class="table table-bordered">
        <thead class="table-light">
        <tr>
            <th>Codice</th>
            <th>Nome</th>
            <th>Descrizione</th>
            <th>Quantità</th>
            <th>ACTION</th>
        </tr>
        </thead>
        <tbody>
        <%
            // Supponiamo che l'attributo "articli" sia una List di oggetti Articolo passati dalla servlet
            List<Articolo> articli = (List<Articolo>) request.getAttribute("articoli");
            if (articli != null) {
                for (Articolo articolo : articli) {
        %>
        <tr>
            <form action="<%= request.getContextPath() %>/hello-servlet" method="post">
            <td><%= articolo.getCodice() %> <input value="<%= articolo.getCodice() %>" name="codice">
            </td>
            <td><%= articolo.getNome() %> <input value="<%= articolo.getNome() %>" name="nome">
            </td>
            <td><%= articolo.getDescrizione() %> <input value="<%= articolo.getDescrizione() %>" name="descrizione">
            </td>
            <td><%= articolo.getQuantita() %> <input value="<%= articolo.getQuantita() %>" name="quantita">
            </td>
                <td>
                    <input type="submit" value="submit">
                </td>
            </form>
        </tr>
        <%
            }
        } else {
        %>
        <tr>
            <td colspan="5" class="text-center">Nessun articolo disponibile</td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
<div class="container mt-4">
<div class="mt-5">
    <h2>Aggiungi un Articolo</h2>
    <form action="<%= request.getContextPath() %>/hello-servlet" method="post">
        <div class="mb-3">
            <label for="nome" class="form-label">Nome</label>
            <input type="text" class="form-control" id="nome" name="nome" required>
        </div>
        <div class="mb-3">
            <label for="descrizione" class="form-label">Descrizione</label>
            <textarea class="form-control" id="descrizione" name="descrizione" rows="3" required></textarea>
        </div>
        <div class="mb-3">
            <label for="quantita" class="form-label">Quantità</label>
            <input type="number" class="form-control" id="quantita" name="quantita" required>
        </div>
        <button type="submit" class="btn btn-primary">Aggiungi</button>
    </form>
</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</html>
