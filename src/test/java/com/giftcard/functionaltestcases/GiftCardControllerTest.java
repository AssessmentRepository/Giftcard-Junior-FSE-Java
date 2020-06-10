package com.giftcard.functionaltestcases;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.platform.runner.JUnitPlatform;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.giftcard.controller.GiftCardController;
import com.giftcard.dtos.GiftCardOrderDetailsDTO;
import com.giftcard.services.GiftCardOrderService;
import com.giftcard.services.UserService;
import com.giftcard.utilityclasses.MasterData;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class GiftCardControllerTest {

	static {
		File file = new File("output_revised.txt");
		if (file.exists()) {
			try {
				FileUtils.forceDelete(new File("output_revised.txt"));
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

	@Test
	public void saveGiftCardDetails() throws IOException {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		when(giftCardOrderService.saveGiftCardOrderDetail(MasterData.getDetails())).thenReturn(Boolean.TRUE);
		ResponseEntity<Boolean> responseEntity = giftCardController.addGiftOrder(MasterData.getDetails());
		
	    File file = new File("output_revised.txt");
	    FileUtils.write(file, "\nsaveGiftCardDetails="+(responseEntity==null?true:false), true); 
	    Assert.assertEquals(responseEntity, true);
	}
	@Test
	public void getAllOrderDetails() throws IOException {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		when(giftCardOrderService.getAllOrderDetails()).thenReturn(null);
		ResponseEntity<List<GiftCardOrderDetailsDTO>> responseEntity = giftCardController.viewAllOrders();
		
	    File file = new File("output_revised.txt");
	    FileUtils.write(file, "\nsaveGiftCardDetails="+(responseEntity==null?true:false), true); 
	    Assert.assertEquals(responseEntity, true);
	}
	

}