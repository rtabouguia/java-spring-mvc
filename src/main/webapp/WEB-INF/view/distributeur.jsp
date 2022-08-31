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
        <div>${balance}$ </div>
        <hr />
        <h2> Liste des produits disponibles </h2>
  <form  method="GET">     
        <table>
             <tr>
            <th>Numéro de produit</th>
            <th>Nom</th>
            <th>Quantité</th>
            <th>Prix</th>
            </tr>
             <c:forEach var="p" items="${products}">
                <tr>
                    <td>${p.id}</td>
                    <td>${p.name}</td>
                    <td>${p.quantity}</td>
                    <td>${p.price}</td>
                </tr>
            </c:forEach>
                      
        </table>
  </form>
        <hr /><!-- comment -->
        <h2> Ajouter du credit </h2>
        <form:form method="POST" action="/addBalance"  modelAttribute="userBalanceForm">
            
            <table>
                <tr>
                    <td>
                        <form:input  path="balance" type="number"  step="0.01"/>
                        <form:errors path="balance" />
                    </td>
                    <td>
                        <input type="submit" value="ajouter du credit" />
                    </td>
                </tr>
            </table> 
    </form:form>  
            <hr />
                   <h2> Acheter un produit </h2>
                   <label> Entrez le numéro du produit à acheter : </label>
           <form:form method="POST" action="/buyProduct"  modelAttribute="productBuyForm">
            
            <table>
                <tr>
                    <td>
                        <form:input  path="id" type="number"  />
                        <form:errors path="id" />
                    </td>
                    <td>
                        <input type="submit" value="Acheter un produit" />
                    </td>
                </tr>
            </table> 
    </form:form>  
        
    </body>
</html>
