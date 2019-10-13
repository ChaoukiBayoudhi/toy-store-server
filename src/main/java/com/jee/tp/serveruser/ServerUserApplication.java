package com.jee.tp.serveruser;

import com.jee.tp.serveruser.Models.Customer;
import com.jee.tp.serveruser.Models.Toy;
import com.jee.tp.serveruser.Models.customerLikes;
import com.jee.tp.serveruser.Repositories.customerRepository;
import com.jee.tp.serveruser.Repositories.toyRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
@EnableTransactionManagement

public class ServerUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerUserApplication.class, args);
	}

	@Bean
	ApplicationRunner init(toyRepository toyRepos, customerRepository customerRepos){

		Customer c1=new Customer("Ahmed",LocalDate.of(2009, Month.FEBRUARY,12));
		Customer c2=new Customer("Mohamed",LocalDate.of(2012, Month.MARCH,15));
		Customer c3=new Customer("Bochra",LocalDate.of(2007, Month.DECEMBER,2));
		Customer c4=new Customer("Sarra",LocalDate.of(2011, Month.JANUARY,1));
		Customer c5=new Customer("Karim",LocalDate.of(2010, Month.JULY,23));
		Customer c6=new Customer("Ali",LocalDate.of(2013, Month.FEBRUARY,26));
		Customer c7=new Customer("Asma",LocalDate.of(2008, Month.OCTOBER,7));
		Stream.of(c1,c2,c3,c4,c5,c6,c7)
				.forEach(customerRepos::save);

		return args -> {
			Stream.of(
								new Toy("Car Toy", "Electronic", 3, 9, 15d,new customerLikes(c1),new customerLikes(c2) ),
					new Toy("Doll Toy", "other", 3, 9, 20d,new customerLikes(c1),new customerLikes(c2),new customerLikes(c3),new customerLikes(c4)),
					new Toy("Moto", "Electronic", 3, 9, 20d,new customerLikes(c1),new customerLikes(c2),new customerLikes(c3),new customerLikes(c4)),
					new Toy("Chess", "Brain", 7, 17, 25d,new customerLikes(c1),new customerLikes(c2),new customerLikes(c5),new customerLikes(c6)),
					new Toy("Ball", "Sport", 7, 17, 25d,new customerLikes(c1),new customerLikes(c7),new customerLikes(c3),new customerLikes(c4)),
					new Toy("Guitar", "Electronic", 7, 17, 25d,new customerLikes(c1),new customerLikes(c2),new customerLikes(c3),new customerLikes(c4)),
					new Toy("Plane", "Electronic", 7, 17, 25d,new customerLikes(c6),new customerLikes(c7),new customerLikes(c3),new customerLikes(c4))
			).forEach(toyRepos::save);
			//toyRepos.findAll().forEach(System.out::println);
		};
	}

//	@Bean
//	ApplicationRunner initCustomer(customerRepository customerRepos){
//
//		return args -> {
//			Stream.of(
//					new Customer("Ahmed",LocalDate.of(2009, Month.FEBRUARY,12)),
//					new Customer("Mohamed",LocalDate.of(2012, Month.MARCH,15)),
//					new Customer("Bochra",LocalDate.of(2007, Month.DECEMBER,2)),
//					new Customer("Sarra",LocalDate.of(2011, Month.JANUARY,1)),
//					new Customer("Karim",LocalDate.of(2010, Month.JULY,23)),
//					new Customer("Ali",LocalDate.of(2013, Month.FEBRUARY,26)),
//					new Customer("Asma",LocalDate.of(2008, Month.OCTOBER,7))
//
//			).forEach(customerRepos::save);
//			customerRepos.findAll().forEach(System.out::println);
//		};
//	}


	@Bean
	ApplicationRunner showAll(toyRepository repository){
		return args -> {
			repository.findAll().forEach(System.out::println);
			Sort sort= new Sort(Sort.Direction.DESC,"name");
			List<Toy> lst=repository.findByNameSorted("%l_",sort);

			Stream.of(lst)
					.forEach(System.out::println);
			System.out.println();
//			repository.findByNameAndTypeAsStream("Moto", "Electronic")
//					.forEach(System.out::println);


		};
	}
	@Bean
	ApplicationRunner ShowCustomersByPage(customerRepository custRepo)
	{
		return ars ->{
			Pageable PageWithTwoElements = PageRequest.of(0, 2);

			Pageable PageWithFourElements = PageRequest.of(1, 4);
			Page<Customer> allCustomers = custRepo.findAll(PageWithTwoElements);
			Stream.of(allCustomers.getContent())
					.forEach(System.out::println);

			Page<Customer> customersbeforeBirth =
					custRepo.findBirthDayBefore(LocalDate.of(2010,10,10), PageWithFourElements);
			//visualize page content
			System.out.println(	"List of Customers were burn before 10/10/2010 :");
			Stream.of(customersbeforeBirth.getContent())
					.forEach(System.out::println);

		};
	}

}
