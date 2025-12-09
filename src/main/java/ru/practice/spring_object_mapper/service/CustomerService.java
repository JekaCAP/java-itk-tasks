package ru.practice.spring_object_mapper.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.practice.spring_object_mapper.mapper.CustomerMapper;
import ru.practice.spring_object_mapper.model.Customer;
import ru.practice.spring_object_mapper.model.dto.CustomerRequest;
import ru.practice.spring_object_mapper.model.dto.CustomerResponse;
import ru.practice.spring_object_mapper.repository.CustomerRepository;

import java.util.List;

/**
 * CustomerService
 *
 * @author agent
 * @since 09.12.2025
 */
@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Transactional
    public CustomerResponse create(CustomerRequest request) {
        Customer c = customerMapper.toEntity(request);
        customerRepository.save(c);
        return customerMapper.toResponse(c);
    }

    @Transactional(readOnly = true)
    public CustomerResponse getById(Long id) {
        return customerMapper
                .toResponse(customerRepository
                        .getOrThrow(id));
    }

    @Transactional(readOnly = true)
    public List<CustomerResponse> getAll() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::toResponse)
                .toList();
    }

    @Transactional
    public CustomerResponse update(Long id, CustomerRequest request) {
        Customer customer = customerRepository.getOrThrow(id);
        customer.setFirstName(request.firstName());
        customer.setLastName(request.lastName());
        customer.setEmail(request.email());
        customer.setContactNumber(request.contactNumber());

        customerRepository.save(customer);

        return customerMapper.toResponse(customer);
    }

    @Transactional
    public void delete(Long id) {
        customerRepository
                .delete(customerRepository
                        .getOrThrow(id));
    }
}