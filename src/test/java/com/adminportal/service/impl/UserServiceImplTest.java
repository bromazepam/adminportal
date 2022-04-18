package com.adminportal.service.impl;

import com.adminportal.domain.ShoppingCart;
import com.adminportal.domain.User;
import com.adminportal.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {UserServiceImpl.class})
@ExtendWith(SpringExtension.class)
class UserServiceImplTest {

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Test
    void testCreateUser() {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setEnabled(true);
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setPhone("4105551212");
        user.setShoppingCart(new ShoppingCart());
        user.setUserPaymentList(new ArrayList<>());
        user.setUserRoles(new HashSet<>());
        user.setUserShippingList(new ArrayList<>());
        user.setUsername("janedoe");

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setCartItemList(new ArrayList<>());
        shoppingCart.setGrandTotal(BigDecimal.valueOf(1L));
        shoppingCart.setId(123L);
        shoppingCart.setUser(user);

        User user2 = new User();
        user2.setEmail("jane.doe@example.org");
        user2.setEnabled(true);
        user2.setFirstName("Jane");
        user2.setId(123L);
        user2.setLastName("Doe");
        user2.setPassword("iloveyou");
        user2.setPhone("4105551212");
        user2.setShoppingCart(shoppingCart);
        user2.setUserPaymentList(new ArrayList<>());
        user2.setUserRoles(new HashSet<>());
        user2.setUserShippingList(new ArrayList<>());
        user2.setUsername("janedoe");

        when(this.userRepository.findByUsername((String) any())).thenReturn(user2);
        User actualCreateUserResult = this.userServiceImpl.createUser(user, new HashSet<>());

        assertSame(user2, actualCreateUserResult);
        assertEquals("1", actualCreateUserResult.getShoppingCart().getGrandTotal().toString());
        verify(this.userRepository).findByUsername((String) any());
    }

    @Test
    void testSave() {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setEnabled(true);
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setPhone("4105551212");
        user.setShoppingCart(new ShoppingCart());
        user.setUserPaymentList(new ArrayList<>());
        user.setUserRoles(new HashSet<>());
        user.setUserShippingList(new ArrayList<>());
        user.setUsername("janedoe");

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setCartItemList(new ArrayList<>());
        shoppingCart.setGrandTotal(BigDecimal.valueOf(1L));
        shoppingCart.setId(123L);
        shoppingCart.setUser(user);

        User user2 = new User();
        user2.setEmail("jane.doe@example.org");
        user2.setEnabled(true);
        user2.setFirstName("Jane");
        user2.setId(123L);
        user2.setLastName("Doe");
        user2.setPassword("iloveyou");
        user2.setPhone("4105551212");
        user2.setShoppingCart(shoppingCart);
        user2.setUserPaymentList(new ArrayList<>());
        user2.setUserRoles(new HashSet<>());
        user2.setUserShippingList(new ArrayList<>());
        user2.setUsername("janedoe");

        when(this.userRepository.save((User) any())).thenReturn(user2);
        User actualSaveResult = this.userServiceImpl.save(user);

        assertSame(user2, actualSaveResult);
        assertEquals("1", actualSaveResult.getShoppingCart().getGrandTotal().toString());
        verify(this.userRepository).save((User) any());
    }
}

