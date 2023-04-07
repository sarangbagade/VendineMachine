package com.template.TemplateProject;

import com.template.TemplateProject.model.CashValue;
import com.template.TemplateProject.model.Product;
import com.template.TemplateProject.repository.IRepository;
import com.template.TemplateProject.repository.InMemoryRepository;
import com.template.TemplateProject.service.VendingMachineService;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TemplateProjectApplication {

	public static void main(String[] args) {
//		SpringApplication.run(TemplateProjectApplication.class, args);

		VendingMachineService service = VendingMachineService.getInstance();
		IRepository repository = InMemoryRepository.getInstance();

		Product product = Product.builder().id("10").amount(50).name("lays").build();
		repository.addProduct(product);

		service.cashInserted(CashValue.HUNDRED);
		service.numberClicked(1);
		service.numberClicked(0);
		service.enterClicked();
	}

}
