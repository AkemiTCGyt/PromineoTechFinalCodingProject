package com.promineotech.ddr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.promineotech.ComponentScanMarker;

@SpringBootApplication(scanBasePackageClasses = { ComponentScanMarker.class })
public class DdrProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DdrProjectApplication.class, args);
	}

}

