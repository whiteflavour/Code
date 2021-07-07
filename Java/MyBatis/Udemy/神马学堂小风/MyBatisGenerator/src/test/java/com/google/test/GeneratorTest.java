package com.google.test;

import com.google.generator.CodeGenerator;
import org.junit.jupiter.api.Test;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;

import java.io.IOException;
import java.sql.SQLException;

public class GeneratorTest {
    @Test
    public void testGenerator() throws InterruptedException, SQLException, InvalidConfigurationException, XMLParserException, IOException {
        CodeGenerator generator = new CodeGenerator();
        generator.generate();
    }
}
