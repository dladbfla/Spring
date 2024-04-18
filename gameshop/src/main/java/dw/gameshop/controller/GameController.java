package dw.gameshop.controller;

import dw.gameshop.model.Game;
import dw.gameshop.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController {
    GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/api/games")  // 게임 전체 조회
    public List<Game> getAllGames(){
        return gameService.getAllGames();
    }

    @GetMapping("/api/game/{id}") // 아이디로 게임 하나 조회
    public Game getGameById(@PathVariable long id){
        return gameService.getGameById(id);
    }

    @PutMapping("/api/game/{id}")  //업데이트
    public Game updateGameById(@PathVariable long id, @RequestBody Game game){
        return gameService.updateGameById(id, game);
    }
}
