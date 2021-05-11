package kr.co.kmarket.service.admin;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.kmarket.dao.admin.AdminProductDao;
import kr.co.kmarket.vo.Cate1Vo;
import kr.co.kmarket.vo.Cate2Vo;
import kr.co.kmarket.vo.ProductVo;

@Service
public class AdminProductService {

	@Autowired
	private AdminProductDao dao;

	public void insertProduct(ProductVo vo) {
		dao.insertProduct(vo);
	}

	public List<Cate1Vo> selectCate1() {
		return dao.selectCate1();
	}

	public List<Cate2Vo> selectCate2(int code1) {
		return dao.selectCate2(code1);
	}
	
	public void selectProduct() {}
	public void selectProducts() {}
	public void updateProduct() {}
	public void deleteProduct() {}
	
	public ProductVo uploadThumb(ProductVo vo) {

		// 상품 등록 이미지 업로드
		File file = new File("src/main/resources/static/thumb/");
		String path = file.getAbsolutePath();

		MultipartFile[] files = {vo.getFile1(), vo.getFile2(), vo.getFile3(), vo.getFile4()};		

		for(int i=0 ; i<4 ; i++) {

			MultipartFile mf = files[i];

			if(!mf.isEmpty()) {
				// 파일을 첨부했을 경우
				String name = mf.getOriginalFilename();
				String ext  = name.substring(name.lastIndexOf("."));

				String uName = UUID.randomUUID().toString()+ext;
				String fullPath = path+"/"+vo.getCate1()+"/"+vo.getCate2()+"/";

				try {
					Path root = Paths.get(fullPath);
					Files.createDirectories(root);

					mf.transferTo(new File(fullPath+uName));

					if(i == 0) vo.setThumb1(uName);
					if(i == 1) vo.setThumb2(uName);
					if(i == 2) vo.setThumb3(uName);
					if(i == 3) vo.setDetail(uName);

				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		return vo;
	}

	
	
}