package com.task.in.service.datafetcher;

import com.task.in.exceptions.CapacityFullException;
import com.task.in.exceptions.InvalidInputException;
import com.task.in.model.Player;
import com.task.in.repository.PlayerRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class AddPlayerDataFetcher implements DataFetcher<Player> {

    @Autowired
    private PlayerRepository playerRepository;

    //Valid inputs for position
    static final String validPositions[]= {"PG","SG","SF","PF","C","Point guard","Shooting guard","Small forward",
            "Power forward","Center"};

    //max capacity for a basketball team with substitute players
    static final int maxCapacity=12;

    @Override
    public Player get(DataFetchingEnvironment dataFetchingEnvironment) {
        String name = dataFetchingEnvironment.getArgument("name");
        String surname = dataFetchingEnvironment.getArgument("surname");
        String position = dataFetchingEnvironment.getArgument("position");


        //current number of players that are registered and saved on the db
        Long size=playerRepository.count();

        //If an invalid input is given for position  exception is thrown
        if (Arrays.asList(validPositions).contains(position) == false ){
            try {
                throw new InvalidInputException();
            } catch (InvalidInputException e) {
                e.printStackTrace();
                return new Player();
            }
        }

        //If capacity is full exception is thrown
        else if (size>=maxCapacity){
            try {
                throw new CapacityFullException();
            } catch (CapacityFullException e) {
                e.printStackTrace();
                return new Player();
            }
        }

        else{
        // Save new user
        Player newPlayer =new Player();
        newPlayer.setName(name);
        newPlayer.setSurname(surname);
        newPlayer.setPosition(position);

        playerRepository.save(newPlayer);

        return  newPlayer;}
    }
}
