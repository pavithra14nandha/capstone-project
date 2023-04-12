package com.example.demo.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class AdminController {
@Autowired
AdminRepo adminrepo;

@PostMapping("/insert")
public Admin insert(@RequestBody Admin admin)
{
	return adminrepo.save(admin);
}

@GetMapping("/viewadmin/{name}")
public Admin viewadmin(@PathVariable String name)
{
	 return adminrepo.findbyname(name);
	 
}
}
