package dw.gameshop.service;

import dw.gameshop.exception.ResourceNotFoundException;
import dw.gameshop.model.Game;
import dw.gameshop.model.User;
import dw.gameshop.repository.GameRepository;
import dw.gameshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {
    GameRepository gameRepository;
    UserRepository userRepository;

    public GameService(GameRepository gameRepository, UserRepository userRepository) {
        this.gameRepository = gameRepository;
        this.userRepository = userRepository;
    }

    @Autowired


    public List<Game> getAllGames(){
        return gameRepository.findAll();
    }

    public Game getGameById(long id){
        Optional<Game> game = gameRepository.findById(id);
        if(game.isEmpty()){
            return null;
        }else {
            return game.get();
        }
    }

    public Game updateGameById(long id, Game game){
        Optional<Game> game1 = gameRepository.findById(id);
        if(game1.isEmpty()){
            throw new ResourceNotFoundException("Game", "id", id);
        }else {
            game1.get().setTitle(game.getTitle());
            game1.get().setGenre(game.getGenre());
            game1.get().setPrice(game.getPrice());
            game1.get().setImage(game.getImage());
            game1.get().setText(game.getText());
            gameRepository.save(game1.get());
            return game1.get();
        }
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }
}
