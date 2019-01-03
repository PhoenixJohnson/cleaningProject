package com.car.cleaning.core.manager;

import com.car.cleaning.pojo.Facility;
import com.car.cleaning.pojo.Store;
import com.car.cleaning.pojo.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

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

    @Autowired
    private UserManager userManager;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {


    }

    @Test
    public void initStoreFacilityForTest() throws Exception {

        User user = new User();
        user.setPhone("1121212");
        user.setAge(35);
        user.setEmailAddress("cc@login.com");
        user.setPassword("121212");
        user.setActive(1);
        user.setGuest(false);
        user.setUserName("slink");
        user.setUserPaymentAccount("cc@alipay.com");
        user.setCreationDate(new Date());
        user.setLastModifiedDate(new Date());

        userManager.findOrCreateUser(user);

        Store testStore = new Store();
        testStore.setStorePaymentAccount("yosku@163.com");
        testStore.setStoreOwnerPhone("1223452352");
        testStore.setStoreAddress("上海市金山区xxx");
        testStore.setStoreOwnerName("Johnson");
        testStore.setRunPeriod(0);
        testStore.setLevel(1);
        testStore.setAuthAmount(1000);
        testStore.setActive(1);
        Store createdStore = storeManager.findOrUpdateStore(testStore);


        Facility testFacility = new Facility();
        testFacility.setStoreId(createdStore.getStoreId());
        testFacility.setNextMaintainDays(365);
        testFacility.setFacilityPeriod(0);
        testFacility.setEmployAmount(30);
        testFacility.setFacilityModel("GKLI-009");
        facilityManager.findOrCreateFacility(testFacility);

    }

    @Test
    public void deleteTestData() {

    }

    @Test
    public void testFindStoreBo() {


    }

}