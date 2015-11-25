package tn.insat.jebouquine.configuration;

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.*;

import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import com.zaxxer.hikari.HikariDataSource;
import tn.insat.jebouquine.data.access.facade.IGenericRepository;
import tn.insat.jebouquine.data.access.implementation.GenericRepository;
import tn.insat.jebouquine.data.entity.*;

@Configuration
@ComponentScan("tn.insat.jebouquine")
@EnableTransactionManagement
@PropertySource(value = { "classpath:application.properties" })
public class ApplicationContextConfig {

	@Autowired
	private Environment environment;

	@Bean(name = "viewResolver")
	public InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean(name = "dataSource")
	public HikariDataSource getDataSource() {
		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
		dataSource.setJdbcUrl(environment.getRequiredProperty("jdbc.url"));
		dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
		dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
		dataSource.setMinimumIdle(Integer.parseInt(environment.getRequiredProperty("jdbc.minPoolSize")));
		dataSource.setMaximumPoolSize(Integer.parseInt(environment.getRequiredProperty("jdbc.maxPoolSize")));
		return dataSource;
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
		return properties;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.scanPackages("tn.insat.jebouquine.data.entity");
		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}

	@Bean
	public IGenericRepository<Client> repoClient() {
		return new GenericRepository<Client>(Client.class);
	}

	@Bean
	public IGenericRepository<Auteur> repoAuteur() {
		return new GenericRepository<Auteur>(Auteur.class);
	}

	@Bean
	public IGenericRepository<Editeur> repoEditeur() {
		return new GenericRepository<Editeur>(Editeur.class);
	}

	@Bean
	public IGenericRepository<Categorie> repoCategorie() {
		return new GenericRepository<Categorie>(Categorie.class);
	}

	@Bean
	public IGenericRepository<Ouvrage> repoOuvrage() {
		return new GenericRepository<Ouvrage>(Ouvrage.class);
	}

	@Bean
	public IGenericRepository<Commande> repoCommande() {
		return new GenericRepository<Commande>(Commande.class);
	}

	@Bean
	public IGenericRepository<LigneCommande> repoLigneCommande() {
		return new GenericRepository<LigneCommande>(LigneCommande.class);
	}

	@Bean
	public IGenericRepository<Facture> repoFacture() {
		return new GenericRepository<Facture>(Facture.class);
	}

}
