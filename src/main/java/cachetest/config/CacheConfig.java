package cachetest.config;

import java.util.concurrent.TimeUnit;

import javax.cache.CacheManager;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.expiry.CreatedExpiryPolicy;
import javax.cache.expiry.Duration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfig {

    private final static Logger log = LoggerFactory.getLogger(CacheConfig.class);
    
    @Bean
    public JCacheManagerCustomizer cacheManagerCustomizer() {
        return new JCacheManagerCustomizer() {

            @Override
            public void customize(CacheManager cacheManager) {
                log.info("==================================================");
                log.info("customize the cache manager : " + cacheManager.getClass().getCanonicalName());
                log.info("==================================================");
                
                cacheManager.createCache("studentNode", new MutableConfiguration<>()
                        .setExpiryPolicyFactory(CreatedExpiryPolicy.factoryOf(new Duration(TimeUnit.MINUTES, 5)))
                        .setStoreByValue(false)
                        .setStatisticsEnabled(true));

            }
        };
    }

}
