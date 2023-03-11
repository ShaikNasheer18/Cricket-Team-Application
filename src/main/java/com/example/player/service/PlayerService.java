package com.example.player.service;
// Don't modify the below code
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import com.example.player.model.Player;
import com.example.player.repository.PlayerRepository;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
public class PlayerService implements PlayerRepository {

    private static HashMap<Integer, Player> team = new HashMap<>();

    public PlayerService() {
        team.put(1, new Player(1, "Alexander", 5, "All-rounder"));
        team.put(2, new Player(2, "Benjamin", 3, "All-rounder"));
        team.put(3, new Player(3, "Michael", 18, "Batsman"));
        team.put(4, new Player(4, "William", 45, "Batsman"));
        team.put(5, new Player(5, "Joshua", 19, "Batsman"));
        team.put(6, new Player(6, "Daniel", 10, "Bowler"));
        team.put(7, new Player(7, "Matthew", 34, "Bowler"));
        team.put(8, new Player(8, "Samuel", 17, "Batsman"));
        team.put(9, new Player(9, "John", 1, "Bowler"));
        team.put(10, new Player(10, "Earnest", 2, "All-rounder"));
        team.put(11, new Player(11, "Bob", 25, "Batsman"));
    }

    // Don't modify the above code

    // Write your code here
    int uniquePlayerId=12;
        public ArrayList<Player> getALLPlayers(){
            Collection<Player> playerCollection = team.values();
            ArrayList<Player> allPlayers=new ArrayList<>(playerCollection);
            return allPlayers;
        }
        public Player getPlayerById(int playerId){
            Player player =team.get(playerId);
            if (player==null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
            return player;
        }
        public Player addPlayer(Player player){
            player.setplayerId(uniquePlayerId);
            team.put(uniquePlayerId,player);
            uniquePlayerId+=1;
            return player;

        }
          public void deletePlayer(int playerId){
            Player player = team.get(playerId);
            if (player ==null){
              throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            } else {
                team.remove(playerId);
                throw new ResponseStatusException(HttpStatus.NO_CONTENT);
            }
          }
          public Player updatePlayer(int playerId, Player updatedPlayer){
    Player player = team.get(playerId);
    if (player == null){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    else {
        player.setplayerId(updatedPlayer.getplayerId());
        player.setplayerName(updatedPlayer.getplayerName());
        player.setrole(updatedPlayer.getrole());
        player.setjerseyNumber(updatedPlayer.getjerseyNumber());
        return player;
    }
    }
          
}


