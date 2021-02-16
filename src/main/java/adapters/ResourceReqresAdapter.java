package adapters;

import com.google.gson.Gson;
import objects.*;

public class ResourceReqresAdapter extends ReqresBaseAdapter{
    private static final String RESOURCE_LIST_URL = "unknown";

    public ResourciesList getListResource() {
        String body = get(RESOURCE_LIST_URL);
        ResourciesList list = new Gson().fromJson(body, ResourciesList.class);
        return list;
    }

    public SingleResource getResource(int id) {
        String body = get(String.format("%s/%s", RESOURCE_LIST_URL, id));
        SingleResource resource = new Gson().fromJson(body, SingleResource.class);
        return resource;
    }

    public int resourceNotFound(int id) {
        int code = getStatusCode(String.format("%s/%s", RESOURCE_LIST_URL, id));
        return code;
    }
}
