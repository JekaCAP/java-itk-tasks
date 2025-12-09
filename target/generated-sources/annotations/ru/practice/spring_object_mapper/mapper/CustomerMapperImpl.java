package ru.practice.spring_object_mapper.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.practice.spring_object_mapper.model.Customer;
import ru.practice.spring_object_mapper.model.dto.CustomerRequest;
import ru.practice.spring_object_mapper.model.dto.CustomerResponse;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-09T17:00:40+0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.5 (Amazon.com Inc.)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer toEntity(CustomerRequest request) {
        if ( request == null ) {
            return null;
        }

        Customer customer = new Customer();

        return customer;
    }

    @Override
    public CustomerResponse toResponse(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        Long customerId = null;
        String firstName = null;
        String lastName = null;
        String email = null;
        String contactNumber = null;

        CustomerResponse customerResponse = new CustomerResponse( customerId, firstName, lastName, email, contactNumber );

        return customerResponse;
    }
}
