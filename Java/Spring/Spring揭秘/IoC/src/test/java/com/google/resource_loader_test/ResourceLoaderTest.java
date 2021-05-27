package com.google.resource_loader_test;

import com.google.resource_loader.ResourceLoaderDependencyClass;
import org.junit.Test;
import static org.junit.Assert.*;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.*;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

public class ResourceLoaderTest {
    @Test
    public void defaultResourceLoaderTest() {
        ResourceLoader resourceLoader = new DefaultResourceLoader();

        Resource fakeFileResource = resourceLoader.getResource("D:/fuck.txt");

        assertTrue(fakeFileResource instanceof ClassPathResource);
        assertFalse(fakeFileResource.exists());

        Resource urlResource1 = resourceLoader.getResource("file:D:/fuck.txt");
        assertTrue(urlResource1 instanceof UrlResource);

        Resource urlResource2 = resourceLoader.getResource("https://www.baidu.com");
        assertTrue(urlResource2 instanceof UrlResource);

        try {
            fakeFileResource.getFile();
            fail("no such file with path [" + fakeFileResource.getFilename() + "] exists in classpa// th");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            urlResource1.getFile();
        } catch (IOException e) {
            fail();
        }
    }

    @Test
    public void fileSystemResourceLoaderTest() {
        ResourceLoader resourceLoader = new FileSystemResourceLoader();

        Resource fileResource = resourceLoader.getResource("D:/fuck.txt");

        assertTrue(fileResource instanceof FileSystemResource);
        assertTrue(fileResource.exists());

        Resource urlResource = resourceLoader.getResource("file:D:/fuck.txt");
        assertTrue(urlResource instanceof UrlResource);
    }

    @Test
    public void pathMatchingResourcePatternResolverTest() {
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();

        Resource fileResource = resourcePatternResolver.getResource("D:/fuck.txt");

        assertTrue(fileResource instanceof ClassPathResource);
        assertFalse(fileResource.exists());

        resourcePatternResolver = new PathMatchingResourcePatternResolver(new FileSystemResourceLoader());

        fileResource = resourcePatternResolver.getResource("D:/fuck.txt");

        assertTrue(fileResource instanceof FileSystemResource);
        assertTrue(fileResource.exists());
    }

    @Test
    public void applicationContextResourceLoaderTest() {
        GenericApplicationContext context = new GenericApplicationContext();

        Resource fileResource = context.getResource("D:/fuck.txt");
        assertTrue(fileResource instanceof ClassPathResource);
        assertFalse(fileResource.exists());

        Resource urlResource = context.getResource("https://www.baidu.com");
        assertTrue(urlResource instanceof UrlResource);
    }

    @Test
    public void resourceLoaderDependencyClassTest() {
        GenericApplicationContext context = new GenericApplicationContext();
        // 将 beans.xml 中的 bean 信息注册到容器中。
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        reader.loadBeanDefinitions("beans.xml");
        context.refresh();

        ResourceLoaderDependencyClass resourceLoaderDependencyClass = (ResourceLoaderDependencyClass) context.getBean("resourceLoaderDependencyClass");
        resourceLoaderDependencyClass.showClass("D:/fuck.txt");
    }
}
