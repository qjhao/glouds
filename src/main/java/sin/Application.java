package sin;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import sin.glouds.entity.dfdx.Store;
import sin.glouds.repository.dfdx.StoreRepository;
import sin.test.jeesite.dao.UserDao;

@SpringBootApplication
@ComponentScan(basePackages={"sin.glouds"})
public class Application {

	@Resource
	private StoreRepository storeRepository;
	@Resource
	private UserDao userDao;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("==============================");
		System.exit(0);
	}
	
	@Bean
	CommandLineRunner init() {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... arg0) throws Exception {
				System.out.println(userDao.findList().size());
			}
		};
	}
	
	public void jpaTest() {
		Pageable page = new PageRequest(1, 2);
		ExampleMatcher matcher = ExampleMatcher.matching()
				//.withMatcher("delFlag", GenericPropertyMatchers.exact())
				.withMatcher("status", GenericPropertyMatchers.exact())
				.withMatcher("type", GenericPropertyMatchers.exact())
				.withIgnoreNullValues();
		Store store = new Store();
		store.setDelFlag(false);
		Example<Store> example = Example.of(store, matcher);
		Specification<Store> specification = new Specification<Store>() {

			@Override
			public Predicate toPredicate(Root<Store> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				List<Predicate> predicates = new ArrayList<>();
				predicates.add(builder.equal(root.get("delFlag"), store.getDelFlag()));
				if(store.getStatus() != null)
					predicates.add(builder.equal(root.get("status"), store.getStatus()));
				if(store.getType() != null)
					predicates.add(builder.equal(root.get("type"), store.getType()));
				query.where(predicates.toArray(new Predicate[predicates.size()]));
				return null;
			}
			
		};
		System.out.println(storeRepository.findAllByDelFlagAndStatusAndType(false, null, null, page).getContent().size());
		System.out.println("-----------------------------------------------------------------------");
		System.out.println(storeRepository.findAll(example, page).getContent().size());
		System.out.println("-----------------------------------------------------------------------");
		System.out.println(storeRepository.findAll(specification, page));
	}
	
}
