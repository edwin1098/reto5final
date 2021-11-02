/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutoria.domingo.servicios;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tutoria.domingo.modelo.Game;
import tutoria.domingo.repositorio.RepositorioGame;

/**
 *
 * @author USUARIO
 */
@Service
public class ServiciosGame {
     @Autowired
    private RepositorioGame metodosCrud;
    
    public List<Game> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Game> getGame(int idGame){
        return metodosCrud.getGame(idGame);
    }
    
    public Game save(Game game){
        if(game.getId()==null){
            return metodosCrud.save(game);
        }else{
            Optional<Game> evt=metodosCrud.getGame(game.getId());
            if(evt.isEmpty()){
                return metodosCrud.save(game);
            }else{
                return game;
            }
        }
    }
    public Game update(Game ortesis){
        if(ortesis.getId()!=null){
            Optional<Game> e=metodosCrud.getGame(ortesis.getId());
            if(!e.isEmpty()){
                if(ortesis.getName()!=null){
                    e.get().setName(ortesis.getName());
                }
                if(ortesis.getDeveloper()!=null){
                    e.get().setDeveloper(ortesis.getDeveloper());
                }
                if(ortesis.getYear()!=null){
                    e.get().setYear(ortesis.getYear());
                }
                if(ortesis.getDescription()!=null){
                    e.get().setDescription(ortesis.getDescription());
                }
                if(ortesis.getCategory()!=null){
                    e.get().setCategory(ortesis.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return ortesis;
            }
        }else{
            return ortesis;
        }
    }


    public boolean deleteOrtesis(int ortesisId) {
        Boolean aBoolean = getGame(ortesisId).map(ortesis -> {
            metodosCrud.delete(ortesis);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
