//package com.example.bootcamp.services;
//        import com.example.bootcamp.repos.CategoryRespository;
//        import com.example.bootcamp.repos.SellerRepository;
//        import com.example.bootcamp.repos.UserRepository;
//        import org.hibernate.PropertyNotFoundException;
//        import org.springframework.beans.factory.annotation.Autowired;
//        import org.springframework.stereotype.Service;
//
//        import java.io.NotActiveException;
//        import java.util.ArrayList;
//        import java.util.List;
//
//@Service
//public class ProductService {
//
//    @Autowired
//    private ProductRepository productRepository;
//
//    @Autowired
//    private SellerRepository sellerRepository;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private CategoryRespository categoryRepository;
//
//    Boolean sellerExist(String email){
//        return userRepository.findByEmail(email) !=null ? true : false;
//    }
//
//    public Boolean productExist(String name){
//        return productRepository.findByName(name) !=null ? true : false;
//    }
//
//    public Boolean productExistBySeller(Long id, Seller seller){
//        return productRepository.findProductByIdAndSeller(id, seller) !=null ? true : false;
//    }
//
//    public Boolean categoryExist(Long id){
//        return categoryRepository.findById(id) !=null ? true : false;
//    }
//
//
//    public void addProduct(Product product, String email, Long categoryId){
//        if(sellerExist(email)) {
//            Product product1 = new Product();
//            product1.setName(product.getName());
//            product1.setDescription(product.getDescription());
//            product1.setBrand(product.getBrand());
//            User user=userRepository.findByEmail(email);
//            Long id = user.getId();
//            Seller seller = sellerRepository.findSellerById(id);
//            product1.setSeller(seller);
//            product1.setCategory(categoryRepository.findCategoryById(categoryId));
//            product1.setCancellable(product.getCancellable());
//            product1.setReturnable(product.getReturnable());
////            product1.setActive(true);
//            product1.setDeleted(false);
//            productRepository.save(product1);
//        }
//    }
//
//    public List<Object []> getProductByCreator(Long id, String email){
//        Product product = productRepository.getById(id);
//        if (sellerExist(email) && productExist(product.getName())){
//            User user=userRepository.findByEmail(email);
//            Long sid = user.getId();
//            Seller seller = sellerRepository.findSellerById(sid);
//            List<Object []> list = productRepository.findProductByIdAndSellerAndDeletedFalseManual(id, seller);
//            return list;
//        }
//        else {
//            throw new ProductNotFoundException("Product do not exists or you are not authorized to get it");
//        }
//    }
//
//    public List<Object []> getAllProducts(String email){
//        if(sellerExist(email)){
//            User user=userRepository.findByEmail(email);
//            Long sid = user.getId();
//            Seller seller = sellerRepository.findSellerById(sid);
//            return productRepository.findAllBySeller(seller);
//        }
//        else {
//            throw new UserNotFoundException("Seller not found");
//        }
//    }
//
//    public void deleteProduct(Long id, String email){
//        if (sellerExist(email)){
//            User user=userRepository.findByEmail(email);
//            Long sid = user.getId();
//            Seller seller = sellerRepository.findSellerById(sid);
//            if(productExistBySeller(id, seller)) {
//                Product product = productRepository.findProductByIdAndSeller(id, seller);
//                productRepository.delete(product);
//            }
//            else {
//                throw new ProductNotFoundException("Product not found");
//            }
//        }
//        else {
//            throw new UserNotFoundException("Seller not found");
//        }
//    }
//
//    public void updateProduct(Long id, String email, Product product){
//        if (sellerExist(email)){
//            User user=userRepository.findByEmail(email);
//            Long sid = user.getId();
//            Seller seller = sellerRepository.findSellerById(sid);
//            if(productExistBySeller(id, seller)) {
//                Product product1 = productRepository.findProductByIdAndSeller(id, seller);
//                product1.setName(product.getName());
//                product1.setDescription(product.getDescription());
//                product1.setCancellable(product.getCancellable());
//                product1.setReturnable(product.getReturnable());
//                productRepository.save(product1);
//            }
//            else {
//                throw new ProductNotFoundException("Product not found");
//            }
//        }
//        else {
//            throw new UserNotFoundException("Seller not found");
//        }
//    }
//}