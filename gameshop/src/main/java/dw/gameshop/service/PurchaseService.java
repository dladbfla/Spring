package dw.gameshop.service;

import dw.gameshop.exception.ResourceNotFoundException;
import dw.gameshop.model.Game;
import dw.gameshop.model.Purchase;
import dw.gameshop.model.User;
import dw.gameshop.repository.PurchaseRepository;
import dw.gameshop.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PurchaseService {
    @Autowired
    PurchaseRepository purchaseRepository;
    @Autowired
    UserRepository userRepository;

    public Purchase savePurchase(Purchase purchase){  // 생성
        //구매확정 바로 직전, 현재 시간을 저장함
        purchase.setPurchaseTime(LocalDateTime.now());
        return purchaseRepository.save(purchase);
    }

    public List<Purchase> getAllPurchases(){  //전부 조회
        return purchaseRepository.findAll();
    }

    public List<Purchase> getPurchaseListByUserId(String userId){
        // 유저아이디로 유저객체 찾기
        Optional<User> userOptional = userRepository.findByUserId(userId);
        if(userOptional.isEmpty()){
            throw new ResourceNotFoundException("User", "Id", userId);
        }else {
            return purchaseRepository.findByUser(userOptional.get());
        }
    }

    // 유저 이름으로 구매한 게임 찾기
    public List<Purchase> getGameListByUserName(String userName){
        Optional<User> userOptional = userRepository.findByUserName(userName);
        if(userOptional.isEmpty()){
            throw new ResourceNotFoundException("User", "Name", userName);
        }else {
            return purchaseRepository.findByUser(userOptional.get());
        }
    }

}
