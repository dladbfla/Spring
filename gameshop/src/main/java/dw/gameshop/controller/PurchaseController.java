package dw.gameshop.controller;

import dw.gameshop.model.Purchase;
import dw.gameshop.model.User;
import dw.gameshop.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PurchaseController {
    @Autowired
    PurchaseService purchaseService;

    @PostMapping("/products/purchase")
    public Purchase savePurchase(@RequestBody Purchase purchase){
        return purchaseService.savePurchase(purchase);
    }

    @GetMapping("/products/purchases")
    public List<Purchase> getAllPurchases(){
        return purchaseService.getAllPurchases();
    }

    @GetMapping("/products/purchase/id/{userId}")
    public List<Purchase> getPurchaseListByUserId(@PathVariable String userId){
        return purchaseService.getPurchaseListByUserId(userId);
    }

    @GetMapping("/products/purchase/name/{userName}")
    public ResponseEntity<List<Purchase>> getGameListByUserName(@PathVariable String userName){
        return new ResponseEntity<>(purchaseService.getGameListByUserName(userName), HttpStatus.OK);
    }
}
