/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.m2i.javaspringmvc.controller;

import fr.m2i.javaspringmvc.exception.NotFoundException;
import fr.m2i.javaspringmvc.form.ProductBuyForm;
import fr.m2i.javaspringmvc.form.UserBalanceForm;
import fr.m2i.javaspringmvc.model.Product;
import fr.m2i.javaspringmvc.service.ProductService;
import fr.m2i.javaspringmvc.service.UserService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author RAISA
 */
@Controller
public class DistributeurController {
private final UserService userService;
    private final ProductService productService;

    @Autowired
    public DistributeurController(UserService userService, ProductService productService) {
        this.userService = userService;
        this.productService = productService;
    }

    @GetMapping("/distributeur")
    public String showDistributeurPage() {
        return "distributeur";
    }
    
    //rend disponible dans le context du controleur une instance de userBalance Form
    @ModelAttribute("userBalanceForm")
    public UserBalanceForm addUserBalanceFormBean(){
        return new UserBalanceForm();
    }
    
    @ModelAttribute("productBuyForm")
    public ProductBuyForm buyProductFormBean(){
        return new ProductBuyForm();
    }
 
      @PostMapping("/addBalance")
    public String addBalance(@ModelAttribute("userBalanceForm") @Valid UserBalanceForm userBalanceForm,
            BindingResult result) {

        if (result.hasErrors()) {
            return "distributeur";
        }

        try {
            userService.addBalance(userBalanceForm.getBalance());
            return "redirect:distributeur";
        } catch (Exception e) {
            result.rejectValue("balance", null, "Une erreur est survenue lors de l'ajout de crédit");
            return "distributeur";
        }
    }
    
    @PostMapping("buyProduct")
    public  String buyProduct(@ModelAttribute("productBuyForm") @Valid ProductBuyForm productBuyForm,
            BindingResult result) throws Exception{
        
         if (result.hasErrors()) {
            return "distributeur";
        }
         try{
             productService.buyProduct(productBuyForm.getId());
             return "redirect:distributeur";
         }
         catch(NotFoundException e){
             result.rejectValue("id", null, "Une erreur est survenue lors de l'achat de produit");
             return "distributeur";
         }
    }
     @ModelAttribute("balance")
    public Double addBalanceBean() {
        try {
            return userService.getBalance();
        } catch (Exception e) {
            // log user not found
            return 0.0;
        }
    }

    @ModelAttribute("products")
    public List<Product> addProductsBean() throws Exception {
        return productService.findAll();
    }
}
