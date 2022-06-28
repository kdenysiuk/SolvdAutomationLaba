package com.solvd.automation;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.APIMethodPoller;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.automation.apikeith.GetPostMethod;
import com.solvd.automation.apikeith.PatchPostMethod;
import com.solvd.automation.apikeith.PostPostMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.atomic.AtomicInteger;

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
    public void testPostAPost(){
        PostPostMethod postPostMethod = new PostPostMethod();
        postPostMethod.callAPI();
        postPostMethod.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "Keith_Denysiuk")
    public void postPostAPostOtherWayTest() {

        PostPostMethod api = new PostPostMethod();
        api.setProperties("api/posts/post.properties");

        AtomicInteger counter = new AtomicInteger(0);

        api.callAPIWithRetry()
                .withLogStrategy(APIMethodPoller.LogStrategy.ALL)
                .peek(rs -> counter.getAndIncrement())
                .until(rs -> counter.get() == 4)
                .pollEvery(1, ChronoUnit.SECONDS)
                .stopAfter(10, ChronoUnit.SECONDS)
                .execute();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "Keith_Denysiuk")
    public void testPatchAPost(){
        PostPostMethod postPostMethod = new PostPostMethod();
        postPostMethod.callAPI();
        postPostMethod.validateResponse();
        PatchPostMethod patchPostMethod = new PatchPostMethod();
        patchPostMethod.callAPI();
        patchPostMethod.validateResponse();
    }
}
