//package com.example.bootcamp.controller;
//
//        import com.example.bootcamp.dto.ResponseDTO;
//        import com.example.bootcamp.services.ProductService;
//        import org.springframework.beans.factory.annotation.Autowired;
//        import org.springframework.http.HttpStatus;
//        import org.springframework.http.ResponseEntity;
//        import org.springframework.stereotype.Controller;
//        import org.springframework.web.bind.annotation.*;
//
//        import javax.servlet.http.HttpServletRequest;
//        import java.security.Principal;
//        import java.util.List;
//
//@RestController
//public class ProductController {
//
//    @Autowired
//    private ProductService productService;
//
//
//    @PostMapping("/addProduct/{categoryId}")
//    public ResponseDTO addProduct(@PathVariable("categoryId") Long id, @RequestBody Product product, HttpServletRequest request){
//        if(!productService.productExist(product.getName()) && productService.categoryExist(id)){
//            productService.addProduct(product, email, id);
//            return new  ResponseDTO (, HttpStatus.OK,"","Product Added Successfully");
//        }
//        else {
//            return new ResponseDTO( HttpStatus.BAD_REQUEST,"","Duplicate Product or Category is not valid",);
//        }
//    }
//
//    @GetMapping("/getProduct/{id}")
//    public List<Object []> getProduct(@PathVariable Long id, HttpServletRequest request){
//        Principal principal = request.getUserPrincipal();
//        String email = principal.getName();
//        return productService.getProductByCreator(id, email);
//    }
//
//    @GetMapping("/getAllProducts")
//    public List<Object []> getProducts(HttpServletRequest request){
//        Principal principal = request.getUserPrincipal();
//        String email = principal.getName();
//        return productService.getAllProducts(email);
//    }
//
//    @DeleteMapping("/deleteProduct/{id}")
//    public ResponseEntity<Object> deleteByid(@PathVariable Long id, HttpServletRequest request){
//        Principal principal = request.getUserPrincipal();
//        String email = principal.getName();
//        productService.deleteProduct(id, email);
//        return ResponseHandler.generateResponse("Product Deleted", HttpStatus.OK);
//    }
//
//    @PutMapping("/updateProduct/{id}")
//    public ResponseEntity<Object> updateProduct(@PathVariable Long id, @RequestBody Product product, HttpServletRequest request){
//        Principal principal = request.getUserPrincipal();
//        String email = principal.getName();
//        if(!productService.productExist(product.getName())){
//            productService.updateProduct(id, email, product);
//            return ResponseHandler.generateResponse("Product Updated Successfully", HttpStatus.OK);
//        }
//        else {
//            return ResponseHandler.generateResponse("Duplicate Product", HttpStatus.BAD_REQUEST);
//        }
//    }
//}
