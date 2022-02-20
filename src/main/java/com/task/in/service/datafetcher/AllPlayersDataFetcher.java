package com.task.in.service.datafetcher;

import java.util.List;

import com.task.in.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.task.in.model.Player;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;



@Component
public class AllPlayersDataFetcher implements DataFetcher<List<Player>> {

  @Autowired
  private PlayerRepository playerRepository;

  @Override
  public List<Player> get(DataFetchingEnvironment environment) {
    return playerRepository.findAll();
  }


}
