package com.example.bootcamp.repos;

import com.example.bootcamp.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address,Long> {

    @Query(value = "select* from user inner join address on user.id=address.user_id where user.id= :id ",nativeQuery = true)
    List<Address> findallAddressByUserId(@Param("id") Long id);

    @Query(value = "select* from user inner join address on user.id=address.user_id where user.id= :id ",nativeQuery = true)
    Address findAddressByUserId(@Param("id") Long id);

    @Modifying
    @Query(value = "delete from Address where id= :id",nativeQuery = true)
    void deleteAddressById(@Param("id") Long id);


}
