package com.solvd.automation.apikeith;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

@Endpoint(url = "${base_url}/posts/101", methodType = HttpMethodType.PATCH)
@RequestTemplatePath(path = "api/posts/_patch/rq.json")
@ResponseTemplatePath(path = "api/posts/_patch/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class PatchPostMethod extends AbstractApiMethodV2 {

    public PatchPostMethod() {
        super("api/posts/_patch/rq.json", "api/posts/_patch/rs.json", "api/posts/post.properties");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
