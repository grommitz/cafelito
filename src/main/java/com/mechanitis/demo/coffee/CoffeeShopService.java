package com.mechanitis.demo.coffee;

import com.mongodb.MongoClient;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.assets.AssetsBundle;

public class CoffeeShopService extends Application<CoffeeShopConfiguration> {
    public static void main(String[] args) throws Exception {
        new CoffeeShopService().run(args);
    }
    
    @Override
    public void initialize(final Bootstrap<CoffeeShopConfiguration> bootstrap) {
        AssetsBundle bundle = new AssetsBundle("/html", "/");
        bootstrap.addBundle(bundle);
    }

    @Override
    public void run(final CoffeeShopConfiguration configuration, final Environment environment) throws Exception {
        MongoClient mongoClient = new MongoClient();
        environment.lifecycle().manage(new MongoClientManager(mongoClient));
        environment.jersey().register(new CoffeeShopResource(mongoClient));
    }

}
