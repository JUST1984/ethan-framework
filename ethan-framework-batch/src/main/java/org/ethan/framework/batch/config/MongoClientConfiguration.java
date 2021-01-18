package org.ethan.framework.batch.config;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import java.util.Collections;

/**
 * MongoDB 客户端配置
 * @author Ethan Zhang
 */
@Configuration
public class MongoClientConfiguration extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName() {
        return "MongoDB";
    }

    @Override
    protected void configureClientSettings(MongoClientSettings.Builder builder) {
        builder.credential(MongoCredential.createCredential("name", "db", "pwd".toCharArray()))
                .applyToClusterSettings(settings  -> settings.hosts(Collections.singletonList(new ServerAddress("127.0.0.1", 27017))));
    }

}
