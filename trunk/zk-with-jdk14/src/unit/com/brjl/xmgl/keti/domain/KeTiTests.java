package com.brjl.xmgl.keti.domain;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import junit.framework.TestCase;

/**
 * KeTi的测试类
 * @author 范志勇
 *
 */
public class KeTiTests extends TestCase {
	/** 变量keTi，供整个测试使用*/
	private KeTi keTi;

	/** 
	 * 设置fixture
	 * @see junit.framework.TestCase#setUp()
	 */
	//@Override
	protected void setUp() {
		keTi = new KeTi();
	}
	
    /**
     * 测试属性：课题名称
     * 边界条件：无
     */
    public void testSetAndGetKeTiName() {
    	String testKeTiName = "课题名称";
    	assertNull(keTi.getKeTiName());
    	keTi.setKeTiName(testKeTiName);
    	assertEquals(testKeTiName,keTi.getKeTiName());
    }
    /**
     * 测试属性：课题来源
     * 边界条件：无
     */
    public void testSetAndGetKeTiLaiYuan() {
    	String testKeTiLaiYuan = "课题来源";
    	assertNull(keTi.getKeTiName());
    	keTi.setKeTiLaiYuan(testKeTiLaiYuan);
    	assertEquals(testKeTiLaiYuan,keTi.getKeTiLaiYuan());
    }
    /**
     * 测试属性：负责单位
     * 边界条件：无
     */
    public void testSetAndGetFuZeDanWei() {
    	String danWeiName = "负责单位";
    	FuZeDanWei testFuZeDanWei = new FuZeDanWei();
    	testFuZeDanWei.setDanWeiName(danWeiName);
    	assertNull(keTi.getFuZeDanWei());
    	keTi.setFuZeDanWei(testFuZeDanWei);
    	assertEquals(danWeiName,keTi.getFuZeDanWei().getDanWeiName());
    }
	
    /**
     * 测试属性：配套项目
     * 边界条件：无
     */
    public void testSetAndGetPeiTaoXiangMu() {
    	String testPeiTaoXiangMu = "配套项目";
    	assertNull(keTi.getPeiTaoXiangMu());
    	keTi.setPeiTaoXiangMu(testPeiTaoXiangMu);
    	assertEquals(testPeiTaoXiangMu,keTi.getPeiTaoXiangMu());
    }
	
	/** 字段：负责人	fuZeRen */
    /**
     * 测试属性：负责人
     * 边界条件：无
     */
    public void testSetAndGetFuZeRen() {
    	String testGetFuZeRen = "负责人";
    	assertNull(keTi.getFuZeRen());
    	keTi.setFuZeRen(testGetFuZeRen);
    	assertEquals(testGetFuZeRen,keTi.getFuZeRen());
    }
	
    /**
     * 测试属性：课题经费
     * 边界条件：无
     */
    public void testSetAndGetKeTiJingFei() {
    	BigDecimal testKeTiJingFei = new BigDecimal(10000l);
    	assertNull(keTi.getKeTiJingFei());
    	keTi.setKeTiJingFei(testKeTiJingFei);
    	assertEquals(testKeTiJingFei,keTi.getKeTiJingFei());
    }

    /**
     * 测试属性：配套经费
     * 边界条件：无
     * 注：通常配套经费按课题经费的一定比例给出
     */
    public void testSetAndGetPeiTaoJingFei() {
    	BigDecimal testPeiTaoJingFei = new BigDecimal(3000l);
    	assertNull(keTi.getPeiTaoJingFei());
    	keTi.setPeiTaoJingFei(testPeiTaoJingFei);
    	assertEquals(testPeiTaoJingFei,keTi.getPeiTaoJingFei());
    }

    /**
     * 测试属性：开始时间
     * <br>边界条件：无
     */
    public void testSetAndGetStartDate() {
    	Calendar cal = Calendar.getInstance();
    	cal.set(1998, Calendar.JANUARY, 1);
    	Date testStartDate = cal.getTime();
    	assertNull(keTi.getKaiShiDate());
    	keTi.setKaiShiDate(testStartDate);
    	assertEquals(testStartDate, keTi.getKaiShiDate());
    }

	
    /**
     * 测试属性：结束时间
     * <br>边界条件：无
     */
    public void testSetAndGetEndDate() {
    	Calendar cal = Calendar.getInstance();
    	cal.set(1999, Calendar.JANUARY, 1);
    	Date testEndDate = cal.getTime();
    	assertNull(keTi.getJieShuDate());
    	keTi.setJieShuDate(testEndDate);
    	assertEquals(testEndDate, keTi.getJieShuDate());
    }
}
