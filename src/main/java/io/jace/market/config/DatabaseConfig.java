package io.jace.market.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@PropertySource({"classpath:application.properties"})
public class DatabaseConfig {

    @Configuration
    @EnableJpaRepositories(
            basePackages = "io.jace.market.auction",
            entityManagerFactoryRef = "auctionEntityManager",
            transactionManagerRef = "auctionTransactionManager"
    )
    static class Auction {

    }

    @Autowired
    private Environment env;

    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean auctionEntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(auctionDataSource());
        em.setPackagesToScan(new String[] { "io.jace.market.auction" });
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
        properties.put("hibernate.dialect", env.getProperty("spring.jpa.database-platform"));
        properties.put("hibernate.show_sql", env.getProperty("spring.jpa.show-sql"));
        em.setJpaPropertyMap(properties);
        return em;
    }

    @Primary
    @Bean
    public DataSource auctionDataSource() {
        return DataSourceBuilder.create()
                .driverClassName(env.getProperty("jdbc.driver-class-name"))
                .url(env.getProperty("jdbc.auction.url"))
                .username(env.getProperty("jdbc.auction.username"))
                .password(env.getProperty("jdbc.auction.password"))
                .build();
    }

    @Primary
    @Bean
    public PlatformTransactionManager auctionTransactionManager() {
        return new JpaTransactionManager(auctionEntityManager().getObject());
    }

}
