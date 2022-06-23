package com.solvd.automation;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.automation.apikeith.GetPostMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class APIPostsTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "Keith_Denysiuk")
    public void testGetPosts(){
        GetPostMethod getPostMethod = new GetPostMethod();
        getPostMethod.callAPIExpectSuccess();
        getPostMethod.validateResponse();
        getPostMethod.validateResponseAgainstSchema("api/posts/_get/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "Keith_Denysiuk")
    public void testGetTitles(){
        GetPostMethod getPostMethod = new GetPostMethod();
        getPostMethod.callAPI();
        getPostMethod.validateResponse();
        getPostMethod.validateResponseAgainstSchema("api/posts/_get/rs.schema");
    }
}
