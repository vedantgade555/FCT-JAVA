package com.vedant.repository;

import com.vedant.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.smartcardio.Card;

public interface CartRepository extends JpaRepository<Cart, Long>{

}
