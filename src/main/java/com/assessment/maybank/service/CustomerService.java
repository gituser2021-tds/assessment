package com.assessment.maybank.service;

import com.assessment.maybank.dto.SampleApiDto;
import com.assessment.maybank.model.Customer;
import com.assessment.maybank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository repository;

    public void saveAll(List<Customer> lists){
        repository.saveAll(lists);
    }


    public List<Customer> findAll(){
        return repository.findAll();
    }

    public List<Customer> findAll(int pageNo, int pageSize){
        Pageable pageable= PageRequest.of(pageNo,pageSize);

        Page<Customer> lists = repository.findAll(pageable);

        return lists.getContent();
    }


    public Optional<Customer> findById(Long id){
        return repository.findById(id);
    }

    public SampleApiDto screen(Long id){
        final String uri = "https://official-joke-api.appspot.com/random_joke";

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity(uri, SampleApiDto.class).getBody();
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Customer save(Customer customer){
        return repository.save(customer);
    }
}
