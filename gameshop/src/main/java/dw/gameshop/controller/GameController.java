package dw.gameshop.controller;

import dw.gameshop.model.Game;
import dw.gameshop.model.User;
import dw.gameshop.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController {
    GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/products/games")  // 게임 전체 조회
    public ResponseEntity<List<Game>> getAllGames(){
        return new ResponseEntity<>(gameService.getAllGames(), HttpStatus.OK) ;
    }

    @GetMapping("/products/game/{id}") // 아이디로 게임 하나 조회
    public ResponseEntity<Game> getGameById(@PathVariable long id){
        return new ResponseEntity<>(gameService.getGameById(id), HttpStatus.OK);
    }

    @PutMapping("/products/game/{id}")  //업데이트
    public ResponseEntity<Game> updateGameById(@PathVariable long id, @RequestBody Game game){
        return new ResponseEntity<>(gameService.updateGameById(id, game), HttpStatus.OK);
    }

    @PostMapping("/products/user")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        return new ResponseEntity<>(gameService.saveUser(user), HttpStatus.OK);
    }
}
