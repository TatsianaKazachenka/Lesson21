package tests;

import adapters.ResourceReqresAdapter;
import objects.ResourciesList;
import objects.SingleResource;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ResourceReqresTest {

    @Test(description = "checking the amount of resources")
    public void checkCountResourceTest() {
        ResourciesList list = new ResourceReqresAdapter().getListResource();
        int countPrePage = list.getPerPage();
        int countPage = list.getPage();
        int totalPage = list.getTotalPages();
        int countResourcies = list.getData().size();
        if (totalPage > countPage) {
            Assert.assertEquals(countResourcies, countPrePage);
        } else {
            Assert.assertTrue(countResourcies >= countPrePage);
        }
    }

    @Test(description = "checking the called resource by")
    public void checkResourceByIdTest() {
        int id = 2;
        SingleResource resource = new ResourceReqresAdapter().getResource(id);
        int getResourceId = resource.getData().getId();
        Assert.assertEquals(id, getResourceId);
    }

    @Test(description = "checking resource not found")
    public void checkResourceNotFoundTest() {
        int id = 23;
        int code = 404;
        int statusCode = new ResourceReqresAdapter().resourceNotFound(id);
        Assert.assertEquals(code, statusCode);
    }
}
