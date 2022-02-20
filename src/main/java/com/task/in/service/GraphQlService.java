package com.task.in.service;

import java.io.File;
import java.io.IOException;
import javax.annotation.PostConstruct;
import com.task.in.service.datafetcher.AddPlayerDataFetcher;
import com.task.in.service.datafetcher.DeletePlayerDataFetcher;
import com.task.in.service.datafetcher.AllPlayersDataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;


@Service
public class GraphQlService {

  @Autowired
  private AllPlayersDataFetcher allPlayersDataFetcherobj;

  @Autowired
  private AddPlayerDataFetcher addPlayerDataFetcherobj;

  @Autowired
  private DeletePlayerDataFetcher deletePlayerDataFetcherobj;


  @Value("classpath:graphql/player.graphql")
  Resource resource;
  private GraphQL graphQL;


  @PostConstruct
  private void loadSchema() throws IOException {

    File file = resource.getFile();

    // Get the graphql file
    TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser().parse(file);
    RuntimeWiring runtimeWiring = buildRuntimeWiring();
    GraphQLSchema graphQLSchema
        = new SchemaGenerator().makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);
    graphQL = GraphQL.newGraphQL(graphQLSchema).build();
  }

  private RuntimeWiring buildRuntimeWiring() {
    return RuntimeWiring.newRuntimeWiring()
            .type("Query",typeWiring -> typeWiring.dataFetcher("allPlayer", allPlayersDataFetcherobj))
            .type("Mutation", typeWiring ->
                    typeWiring.dataFetcher("addPlayer", addPlayerDataFetcherobj))
            .type("Mutation", typeWiring ->
                    typeWiring.dataFetcher("deletePlayer", deletePlayerDataFetcherobj))
        .build();
  }

  public ExecutionResult executeGraphQL(String query) {
    return graphQL.execute(query);
  }

  public ExecutionResult executeGraphQLMutation(String mutation) {
    return graphQL.execute(mutation);
  }



}