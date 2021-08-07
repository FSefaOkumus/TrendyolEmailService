package com.trendyol.emailservice.config;


//import com.pcb.ProductCouchbase.User;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;

@Configuration
public class CouchBaseConfig extends AbstractCouchbaseConfiguration {


    @Override
    public String getConnectionString() {
        return "couchbase://127.0.0.1";
    }

    @Override
    public String getUserName() {
        return "myapp";
    }

    @Override
    public String getPassword() {
        return "123321";
    }

    @Override
    public String getBucketName() {
        return "customer";
    }

//    @Override
//    public void configureRepositoryOperationsMapping(RepositoryOperationsMapping mapping) {
//        mapping.mapEntity(User.class, getCouchbaseTemplate(userBucket));
//    }

//    @SneakyThrows
//    private CouchbaseTemplate getCouchbaseTemplate(String bucketName) {
//        CouchbaseTemplate template = new CouchbaseTemplate(couchbaseClientFactory(bucketName),
//                mappingCouchbaseConverter(couchbaseMappingContext(customConversions()),
//                        new CouchbaseCustomConversions(Collections.emptyList())));
//
//        template.setApplicationContext(context);
//        return template;
//    }
//
//    private CouchbaseClientFactory couchbaseClientFactory(String bucketName) {
//        return new SimpleCouchbaseClientFactory(couchbaseCluster(couchbaseClusterEnvironment()),
//                bucketName, this.getScopeName());
//    }
}