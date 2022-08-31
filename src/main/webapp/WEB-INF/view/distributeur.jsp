<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
    <head>
        <meta charset="UTF-8">
        <title>distributeur 2.0</title>
    </head>
    <body>
        <h2> Credit disponible </h2>
        <div>${balance} $ </div>
        <hr />
        <h2> Liste des produits disponibles </h2>
  <form  action="DistributeurControlleur" method="GET">     
        <table>
             <tr>
            <th>Numéro de produit</th>
            <th>Nom</th>
            <th>Quantité</th>
            <th>Prix</th>
            </tr>
            <c:forEach items="${ products}" var="produit">
                <tr>
                    <td><c:out value="${ produit.id }"></c:out></td>
                    <td><c:out value="${ produit.name }"></c:out></td>
                    <td><c:out value="${ produit.quantity }"></c:out></td>
                    <td><c:out value="${ produit.price}"></c:out></td>
                </tr>
            </c:forEach>
                      
        </table>
  </form>
        <hr /><!-- comment -->
        <h2> Ajouter du credit </h2>
        <form:form method="POST" action="/addBalance"  modelAttribute="userForm">
            
            <table>
                <tr>
                    <td>
                        <form:input  path="balance" type="number" />
                        <form:errors path="balance" />
                    </td>
                    <td>
                        <input type="submit" value="ajouter du credit" />
                    </td>
                </tr>
            </table> comment 
    </form:form>  
            <hr />
                   <h2> Acheter un produit </h2>
        
    </body>
</html>
