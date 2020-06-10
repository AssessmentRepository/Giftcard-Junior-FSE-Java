package com.giftcard.functionaltestcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.annotation.DirtiesContext.MethodMode;

import com.giftcard.entitys.GiftCardOrderDetails;
import com.giftcard.entitys.User;
import com.giftcard.repos.UserRepository;
import com.giftcard.services.UserService;
import com.giftcard.servicesImpl.UserServiceImpl;
import com.giftcard.utilityclasses.MasterData;
import com.giftcard.utilityclasses.UserData;





@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = ClassMode.AFTER_CLASS, methodMode = MethodMode.BEFORE_METHOD)
public class FunctionalTest {
	

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
	
	@Mock
	private UserService userService;
	@Mock
	private UserRepository userRepository;
	
	@Mock
	private User user;
	
	@InjectMocks
	private UserServiceImpl userServiceImpl;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}	
	@Test
	public void testSendGiftCard() throws IOException
	{
		String status = UserData.getUserDetails().getEmailId();
		 File file = new File("output_revised.txt");
		    FileUtils.write(file, "\ntestSendGiftCard="+(status==null?true:false), true); 
	}
	@Test
	public void testsaveUser() throws IOException
	{
	    String saved= UserData.getUserDetails().getUsername();	
	    File file = new File("output_revised.txt");
	    FileUtils.write(file, "\ntestsaveUser="+(saved==null?true:false), true);
	}
	@Test
	public void testgetByUsername() throws IOException
	{
		
		Optional<User> user = userServiceImpl.getByUsername(UserData.getUserDetails().getUsername());
		File file = new File("output_revised.txt");
	    FileUtils.write(file, "\ntestgetByUsername="+(user==null?true:false), true);	
	    }
   @Test
    public void testDeleteOrder() throws Exception {
	   GiftCardOrderDetails gf=new GiftCardOrderDetails();
	  boolean deleted= userServiceImpl.deleteOrderById(MasterData.getDetails().getOrderId());
	  File file = new File("output_revised.txt");
	    FileUtils.write(file, "\ntestDeleteOrder="+(deleted?true:false), true);
   }
}
