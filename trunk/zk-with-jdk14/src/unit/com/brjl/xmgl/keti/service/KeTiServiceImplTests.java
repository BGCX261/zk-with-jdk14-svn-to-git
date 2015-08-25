package com.brjl.xmgl.keti.service;

import junit.framework.TestCase;

import org.easymock.EasyMock;

import com.brjl.xmgl.keti.dao.KeTiDao;
import com.brjl.xmgl.keti.domain.KeTi;



/**
 * 使用 EasyMock 进行测试，主要是测试接口
 * @author Administrator
 *
 */
public class KeTiServiceImplTests extends TestCase {
	private KeTiServiceImpl keTiService;

	//@Override
	protected void setUp() throws Exception {
		keTiService = new KeTiServiceImpl();
	}
	
	/**
	 * 使用 EasyMock 进行模拟测试
	 */
	public void testaddKeTi() {
		//分为 5 步
		//1) 使用 EasyMock 生成 KeTiDao 的模拟对象
		KeTiDao keTiDao = EasyMock.createMock(KeTiDao.class);
		keTiService.setKeTiDao(keTiDao);
		
		//2) 为模拟对象录制一系列模拟行为
		KeTi testKeTi = new KeTi();
		EasyMock.expect(keTiDao.addKeTi(testKeTi)).andReturn(1);
		
		//3) 回放上面录制的模拟行为
		EasyMock.replay(keTiDao);
		
		//4) 对目标对象进行断言验证
		assertEquals(keTiService.addKeTi(testKeTi), 1);
		
		//5) 检查模拟对象
		EasyMock.verify(keTiDao);
	}
}
