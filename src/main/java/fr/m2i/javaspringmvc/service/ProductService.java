/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.m2i.javaspringmvc.service;

import fr.m2i.javaspringmvc.exception.NotFoundException;
import fr.m2i.javaspringmvc.model.Product;
import fr.m2i.javaspringmvc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
/**
 *
 * @author RAISA
 */
@Service
public class ProductService {
        private final ProductRepository repo;
        private final UserService userService;

    @Autowired
    public ProductService(ProductRepository repo, UserService userService) {
        this.repo = repo;
        this.userService = userService;
    }
    
    // lister les produits
    
    public List<Product> findAll() { 
        return repo.findAll();
    }
    // find by id
    public Product findById(Long id) throws NotFoundException {
         Product prodFounded = repo.findById(id).orElseThrow(() -> 
         {throw new NotFoundException("Product with d: " + id + "was not found");
         })   ;
         return prodFounded;
    }
    // save
    public void saveProductValue(Long id) throws Exception{
        Product prodFounded = repo.findById(id).orElseThrow(() -> new Exception());
        repo.save(prodFounded);
    }
    
    // acheter un produit
     @Transactional
    public void buyProduct(Long id) throws Exception{
        Product prodFounded = findById(id);
         if (userService.getBalance() < prodFounded.getPrice() ){
             throw new Exception("Vous n'avez pas assez de credit");
         }
         else if(prodFounded.getQuantity()==0){
             throw new Exception("Stock insufisant !");
         }
          // On met à jour la quantité du produit que l'utilisateur vient d'acheter
        prodFounded.setQuantity(prodFounded.getQuantity() - 1);
    
         
        // On met à jour le crédit de l'utilisateur
        userService.decreaseBalance(prodFounded.getPrice());

        //On persist les nouvelles données du produit
        repo.save(prodFounded);
    }
    // -> Est ce que j'ai assez de crédit ?
    // -> Est ce que le produit existe ? il reste du stock ?
}
