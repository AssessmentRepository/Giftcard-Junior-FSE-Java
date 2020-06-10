package com.giftcard.exceptiontestcases;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.giftcard.servicesImpl.UserServiceImpl;
import com.giftcard.controller.GiftCardController;
import com.giftcard.services.GiftCardOrderService;
import com.giftcard.services.UserService;
import com.giftcard.utilityclasses.MasterData;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class ExceptionTestClass {

	static {
		File file = new File("output_exception_revised.txt");
		if (file.exists()) {
			try {
				FileUtils.forceDelete(new File("output_exception_revised.txt"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
			}
		}
	}
	@InjectMocks
	GiftCardController giftCardController;

	@Mock
	GiftCardOrderService giftCardOrderService;
	
	@Mock
	UserService userService;

	@Test(expected = NullPointerException.class)
	public void saveGiftCardDetails() throws IOException {

		try {
			MockHttpServletRequest request = new MockHttpServletRequest();
			RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
			when(giftCardOrderService.saveGiftCardOrderDetail(MasterData.getDetails()))
					.thenThrow(NullPointerException.class);
			giftCardController.addGiftOrder(MasterData.getDetails());

		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			File file = new File("output_exception_revised.txt");
			FileUtils.write(file, "\nsaveGiftCardDetails=true", true);
			throw e;
		} catch (Exception e) {
			File file = new File("output_exception_revised.txt");
			FileUtils.write(file, "\nsaveGiftCardDetails=false", true);
			throw e;
		}

		File file = new File("output_exception_revised.txt");
		FileUtils.write(file, "\nsaveGiftCardDetails=false", true);
	}
	
	@Test(expected=NullPointerException.class)
	public void viewOrders() throws IOException {
		try {
		UserServiceImpl myMockedList = mock(UserServiceImpl.class); MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request)); 
		 when(giftCardOrderService.getAllOrderDetails())
				 .thenThrow(NullPointerException.class);
		 giftCardController.viewAllOrders();
	}
		catch (NullPointerException e) {
			// TODO Auto-generated catch block
			File file = new File("output_exception_revised.txt");
			FileUtils.write(file, "\nviewOrders=true", true);
			throw e;
		} catch (Exception e) {
			File file = new File("output_exception_revised.txt");
			FileUtils.write(file, "\nviewOrders=false", true);
			throw e;
		}

		File file = new File("output_exception_revised.txt");
		FileUtils.write(file, "\nviewOrders=false", true);
	}
}
