import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.poc.dto.DataTransferObject;
import com.poc.model.Image;
import com.poc.model.ImageDetails;
import com.poc.service.ImageService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springconfig/dispatcher-servlet.xml")
public class ImageTest {
	
	@Autowired
	private ImageService imageService;
	
	@After
	public void destroy() {
		imageService = null;
	}
	

	public void testFetchHQL(){
		DataTransferObject dto = new DataTransferObject();
		Image im = new Image();
		im.setId(1);
		
		DataTransferObject dtoresponse = imageService.fetchImage(dto);
		
		for(Image i : dtoresponse.getListImage()){
			System.out.println("-----image details--------");
			System.out.println(i.getId()+" "+i.getName()+" "+i.getPath());
			System.out.println("------comments-------");
			for(ImageDetails id : i.getImageDetail()){
				System.out.println(id.getId()+" "+id.getComment());
			}
			System.out.println("--end--");
		}
	}
	

	public void testFetchNative(){
		DataTransferObject dto = new DataTransferObject();
		Image im = new Image();
		im.setId(1);
		
		DataTransferObject dtoresponse = imageService.fetchImageNative(dto);
		
		for(Image i : dtoresponse.getListImage()){
			System.out.println("-----image details--------");
			System.out.println(i.getId()+" "+i.getName()+" "+i.getPath());
			System.out.println("------comments-------");
			for(ImageDetails id : i.getImageDetail()){
				System.out.println(id.getId()+" "+id.getComment());
			}
			System.out.println("--end--");
		}
	}
	

	public void testFetchHQL2(){
		DataTransferObject dto = new DataTransferObject();

		DataTransferObject dtoresponse = imageService.fetchImageDetails(dto);
		
		for(ImageDetails i : dtoresponse.getListImageDetails()){
			System.out.println(i.getComment());
		}
	}


	public void save(){
		DataTransferObject dto = new DataTransferObject();
		
		Image image = new Image();
		image.setName("JOHN REY");
		image.setPath("C DRIVE");
		
		ImageDetails imd = new ImageDetails();
		imd.setComment("comm");
		ImageDetails imd2 = new ImageDetails();
		imd2.setComment("comm2");

		
		Set<ImageDetails> setImageDetails = new HashSet<ImageDetails>();
		setImageDetails.add(imd);
		setImageDetails.add(imd2);

		
		image.setImageDetail(setImageDetails);
		
		dto.setImage(image);
		imageService.save(dto);
	}
	


	public void saveDetails(){
		DataTransferObject dto = new DataTransferObject();

		ImageDetails imd = new ImageDetails();
		imd.setComment("new Comment2");
		Image image = new Image();
		image.setId(22);
		imd.setImage(image);
		
		dto.setImageDetails(imd);
		imageService.saveDetails(dto);
	}
	

	public void delete(){
		DataTransferObject dto = new DataTransferObject();
		
		Image image = new Image();
		image.setId(15);	
		dto.setImage(image);
		imageService.delete(dto);
	}
	

	public void deleteDetails(){
		DataTransferObject dto = new DataTransferObject();

		ImageDetails imd = new ImageDetails();
		imd.setId(44);
		dto.setImageDetails(imd);
		imageService.deleteDetails(dto);
	}
	

	public void update(){
		DataTransferObject dto = new DataTransferObject();
		
		Image image = new Image();
		image.setId(22);	
		image.setPath("TAE PATH233");
		dto.setImage(image);
		imageService.update(dto);
	}
	
	@Test
	public void updateDetails(){
		DataTransferObject dto = new DataTransferObject();

		ImageDetails imd = new ImageDetails();
		imd.setId(45);
		imd.setComment("PARDZ");
		dto.setImageDetails(imd);
		imageService.updateDetails(dto);
	}
	
}
