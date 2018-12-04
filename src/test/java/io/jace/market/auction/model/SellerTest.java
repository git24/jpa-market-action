package io.jace.market.auction.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class SellerTest {

    private Validator validator;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void all_pass() {
        Seller seller = new Seller("tester", "010-0000-0000");
        Set<ConstraintViolation<Seller>> violations = validator.validate(seller);
        violations.stream().forEach(System.out::println);
        Assert.assertTrue(violations.isEmpty());
    }

    @Test
    public void cellphone_not_blank() {
        Seller seller = new Seller("tester", " ");
        Set<ConstraintViolation<Seller>> violations = validator.validate(seller);
        violations.stream().forEach(System.out::println);
        Assert.assertFalse(violations.isEmpty());
    }

    @Test
    public void nickname_not_blank() {
        Seller seller = new Seller(" ", "010-0000-0000");
        Set<ConstraintViolation<Seller>> violations = validator.validate(seller);
        Assert.assertFalse(violations.isEmpty());
    }

}
