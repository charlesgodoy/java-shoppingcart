package com.lambdaschool.javashoppingcart.controllers;//package com.lambdaschool.javashoppingcart.controllers;
//
//import com.lambdaschool.javashoppingcart.models.Order;
//import com.lambdaschool.javashoppingcart.models.Dvd;
//import com.lambdaschool.javashoppingcart.models.Store;
//import com.lambdaschool.javashoppingcart.repositories.OrderRepository;
//import com.lambdaschool.javashoppingcart.repositories.DvdRepository;
//import com.lambdaschool.javashoppingcart.repositories.StoreRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.*;
//
//import java.net.URISyntaxException;
//import java.util.List;
//import java.util.Optional;
//import java.util.Set;
//
//@RestController
//@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//public class ShopkeeperController {
//
//    @Autowired
//    StoreRepository storeRepo;
//
//    @Autowired
//    DvdRepository dvdRepo;
//
//    @Autowired
//    OrderRepository orderRepo;
//
////    @GetMapping(value = "/suppliers")
////    public List<Store> listAllSuppliers() {
////        return storeRepo.findAll();
////    }
//
////    @GetMapping(value = "/orders")
////    public List<Order> listAllOrders() {
////        return orderRepo.findAll();
////    }
//
////    @PostMapping("/product")
////    public Dvd addNewProduct(@RequestBody Dvd product) throws URISyntaxException {
////        return dvdRepo.save(product);
////    }
////
////    @PostMapping("/supplier")
////    public Store addNewSupplier(@RequestBody Store supplier) throws URISyntaxException {
////        return storeRepo.save(supplier);
////    }
//
//    @PostMapping(value = "/supplier/{supplierid}/product/{productid}")
//    public Store addProductToSupplier(@PathVariable long supplierid, @PathVariable long productid) {
//        Optional<Store> foundSupplier = storeRepo.findById(supplierid);
//        Optional<Dvd> foundProduct = dvdRepo.findById(productid);
//        if (foundSupplier.isPresent() && foundProduct.isPresent()) {
//            Store supplier = foundSupplier.get();
//            Set<Dvd> products = supplier.getDvds();
//            for (Dvd product : products) {
//                if (product.getDvdid() == productid) {
//                    return null; //Store already present for this product
//                }
//            }
//            supplier.getDvds().add(foundProduct.get());
//            return storeRepo.save(supplier);
//        } else {
//            return null; //Customer or product not found
//        }
//    }
//
//}
