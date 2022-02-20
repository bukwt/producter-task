package com.task.in.service.datafetcher;

import com.task.in.repository.PlayerRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class DeletePlayerDataFetcher implements DataFetcher<String> {

    @Autowired
    private PlayerRepository playerRepository;

    @Transactional
    @Override
    public String get(DataFetchingEnvironment dataFetchingEnvironment) {

        String id = dataFetchingEnvironment.getArgument("id");

        playerRepository.deleteById(Long.parseLong(id));

        return id;


    }
}
