import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.poc.dto.DataTransferObject;
import com.poc.model.User;
import com.poc.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springconfig/dispatcher-servlet.xml")
public class UserTest {
	@Autowired
	private UserService userService;
	
	@After
	public void destroy() {
		userService = null;
	}
	@Test
	public void testSave(){
		DataTransferObject dto = new DataTransferObject();
		User user = new User();
		
		user.setAge("25");
		user.setName("JOHN REY");
		user.setAddress("ALABAMAhibernate2");
		dto.setUser(user);
		
		userService.save(dto);
	}
	
	public void testUpdate(){
		DataTransferObject dto = new DataTransferObject();
		User user = new User();
		user.setId(38);
		user.setAge("46");
		user.setName("JOHN REY");
		user.setAddress("ALABAMAhibernate");
		dto.setUser(user);
		
		userService.update(dto);
	}
	

	public void testDelete(){
		DataTransferObject dto = new DataTransferObject();
		User user = new User();
		user.setId(44);
		user.setAge("46");
		user.setName("JOHN REY");
		user.setAddress("ALABAMAhibernate");
		dto.setUser(user);
		
		userService.delete(dto);
	}
	

	public void testFetch(){
		DataTransferObject dto = new DataTransferObject();
		User user = new User();
		user.setId(41);
		dto.setUser(user);
		
		DataTransferObject dtoresponse = userService.fetch(dto);
		
		for(User u: dtoresponse.getListUser()){
			System.out.println(u.getAddress()+u.getAge()+u.getName());
		}
	
	}

	public void testFetchHQL(){
		DataTransferObject dto = new DataTransferObject();
		User user = new User();
		user.setAge("25");
		dto.setUser(user);
		
		DataTransferObject dtoresponse = userService.fetchViaHQL(dto);
		
		for(User u: dtoresponse.getListUser()){
			System.out.println(u.getAddress()+u.getAge()+u.getName());
		}
	}
	

	public void testUpdateHQL(){
		DataTransferObject dto = new DataTransferObject();
		User user = new User();
		user.setAge("25");
		user.setName("JAYPOGE");
		
		user.setAddress("TAGUIG");
		dto.setUser(user);
		
		userService.updateViaHQL(dto);

	}
	
	

	public void testFetchNative(){
		DataTransferObject dto = new DataTransferObject();
		User user = new User();
		user.setAge("25");
		dto.setUser(user);
		
		DataTransferObject dtoresponse = userService.fetchViaNative(dto);
		for(User u: dtoresponse.getListUser()){
			System.out.println(u.getAddress()+u.getAge()+u.getName());
		}
	}
}
