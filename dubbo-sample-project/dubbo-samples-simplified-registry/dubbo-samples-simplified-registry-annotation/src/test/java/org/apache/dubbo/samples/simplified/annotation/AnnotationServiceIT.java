package org.apache.dubbo.samples.simplified.annotation;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.samples.simplified.annotation.action.AnnotationAction;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SimpleRegistryAnnotationConsumer.ConsumerConfiguration.class})
public class AnnotationServiceIT {
    @Autowired
    private AnnotationAction annotationAction;

    @Test
    public void verifyProvider() throws Exception {
        List<String> urls = ZkUtil.getChildren(ZkUtil.toUrlPath("providers"));
        urls.stream().map(URL::decode).forEach(System.out::println);
        Assert.assertEquals(1, urls.size());
        String url = urls.get(0);
        Assert.assertTrue(url.contains("retries"));
        Assert.assertTrue(url.contains("owner"));
        Assert.assertTrue(url.contains("timeout"));
        Assert.assertTrue(url.contains("version"));
        Assert.assertTrue(url.contains("group"));
        Assert.assertTrue(url.contains("release"));
        Assert.assertFalse(url.contains("executes"));
    }

    @Test
    public void verifyConsumer() throws Exception {
        List<String> urls = ZkUtil.getChildren(ZkUtil.toUrlPath("consumers"));
        urls.stream().map(URL::decode).forEach(System.out::println);
        Assert.assertEquals(1, urls.size());
        String url = urls.get(0);

        Assert.assertFalse(url.contains("retries"));
        Assert.assertFalse(url.contains("timeout"));
        Assert.assertFalse(url.contains("owner"));
        Assert.assertFalse(url.contains("actives"));
        Assert.assertTrue(url.contains("application"));
        Assert.assertTrue(url.contains("version"));
        Assert.assertTrue(url.contains("group"));
        Assert.assertTrue(url.contains("release"));
    }
}
