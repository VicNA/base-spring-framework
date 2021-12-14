<%@ page import="java.util.List" %>
<%@ page import="ru.geekbrains.homework.Product" %>
<html>
<body>
<h2>Product list</h2>
<%
    List<Product> list = (List<Product>) request.getAttribute("products");
    out.println("<ui>");
    for (Product product: list) {
        out.println("<li>" + product + "</li>");
    }
    out.println("</ui>");
%>
</body>
</html>
