package com.giftcard.boundarytestcases;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.giftcard.dtos.GiftCardOrderDetailsDTO;
import com.giftcard.dtos.ShippingAddressDTO;
import com.giftcard.utilityclasses.MasterData;








@RunWith(JUnitPlatform.class)
public class EntityValidationTest {
	static {
		File file = new File("output_boundary_revised.txt");
		if (file.exists()) {
			try {
				FileUtils.forceDelete(new File("output_boundary_revised.txt"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
			}
		}
	}

	private Validator validator;

	@BeforeEach
	public void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void testGiftOrdersSuccess() {
		try {
			GiftCardOrderDetailsDTO details = MasterData.getDetails();
			Set<ConstraintViolation<GiftCardOrderDetailsDTO>> violations = validator.validate(details);
			File file = new File("output_boundary_revised.txt");
			FileUtils.write(file, "\ntestGiftOrdersSuccess=" + (violations == details ? true : false), true);
			Assert.assertEquals(violations, new Integer(0));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testBuyerNameLength() throws Exception {

		GiftCardOrderDetailsDTO buyer = MasterData.getDetails();
		buyer.getBuyerFirstName();
		int maxChar = 5;
		boolean usernameLength = ((buyer.getBuyerFirstName().length()) >= maxChar);
		File file = new File("output_boundary_revised.txt");
		FileUtils.write(file, "\ntestBuyerNameLength=" + (usernameLength ? true : false), true);

	}
	
	@Test
	public void testRecipientNameLength() throws Exception {
		GiftCardOrderDetailsDTO recipient = MasterData.getDetails();
		recipient.getRecipientFirstName();
		int maxChar = 5;
		boolean usernameLength = ((recipient.getRecipientFirstName().length()) >= maxChar);
		File file = new File("output_boundary_revised.txt");
		FileUtils.write(file, "\ntestRecipientNameLength=" + (usernameLength == true ? true : false), true);

	}

	

	@Test
	public void testRecipientMobileNo() throws Exception {
		GiftCardOrderDetailsDTO recipient = MasterData.getDetails();
		recipient.getPhoneNumber();
		int phoneLength = 10;
		boolean Length = (recipient.getPhoneNumber().length() >= phoneLength);
		File file = new File("output_boundary_revised.txt");
		FileUtils.write(file, "\ntestRecipientMobileNo=" + (Length == true ? true : false), true);
	}
	@Test
	public void testGiftAmount() throws Exception {
		GiftCardOrderDetailsDTO recipient = MasterData.getDetails();
		recipient.getGiftAmount();
		double amount = 0.0;
		boolean cost = (recipient.getGiftAmount()>amount);
		File file = new File("output_boundary_revised.txt");
		FileUtils.write(file, "\ntestGiftAmount=" + (cost == true ? true : false), true);
	}
	@Test
	public void testGiftCardCategory() throws Exception {
		GiftCardOrderDetailsDTO recipient = MasterData.getDetails();
		boolean fetch=recipient.getCategory()!=null;
		
		File file = new File("output_boundary_revised.txt");
		FileUtils.write(file, "\ntestGiftCardCategory=" + (fetch == true ? true : false), true);

	}
	
	@Test
	public void testShippingId() throws Exception {
		GiftCardOrderDetailsDTO recipient = MasterData.getDetails();
		boolean value=(recipient.getShippingId()!=null);
		File file = new File("output_boundary_revised.txt");
		FileUtils.write(file, "\ntestShippingId=" + (value ? true : false), true);
	}
	}