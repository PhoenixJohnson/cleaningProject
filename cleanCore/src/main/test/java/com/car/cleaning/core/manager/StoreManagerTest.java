package com.car.cleaning.core.manager;

import com.car.cleaning.bo.StoreBo;
import com.car.cleaning.pojo.Facility;
import com.car.cleaning.pojo.Store;
import com.google.gson.Gson;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by jiangyunfan on 2019/1/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:dalBeanConfig.xml")
public class StoreManagerTest {

    @Autowired
    private StoreManager storeManager;

    @Autowired
    private FacilityManager facilityManager;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {


    }

    @Test
    public void initStoreFacilityForTest() throws Exception {
        Store testStore = new Store();
        testStore.setStoreId(1234L);
        testStore.setStorePaymentAccount("yosku@163.com");
        testStore.setStoreOwnerPhone("1223452352");
        testStore.setStoreAddress("上海市金山区xxx");
        testStore.setStoreOwnerName("Johnson");
        testStore.setRunPeriod(0);
        testStore.setLevel(1);
        testStore.setAuthAmount(1000);
        testStore.setActive(1);
        Store createdStore = storeManager.createOrUpdateStore(testStore, true);


        Facility testFacility = new Facility();
        testFacility.setStoreId(createdStore.getStoreId());
        testFacility.setFacilityId(1234L);
        testFacility.setNextMaintainDays(365);
        testFacility.setFacilityPeriod(0);
        testFacility.setEmployAmount(30);
        testFacility.setFacilityModel("GKLI-009");
        facilityManager.findOrCreateFacility(testFacility, true);

    }

    @Test
    public void deleteTestData() {
        storeManager.deleteStoreById(1234L);
        facilityManager.deleteFacilityById(1234L);
    }

    @Test
    public void testFindStoreBo() {
        Gson gson = new Gson();
        StoreBo store = storeManager.findStoreBoById(1234L);
        System.out.println(gson.toJson(store));


    }

}