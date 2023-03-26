package com.zpw.sprintboot.sprintboottemplate;

import com.zpw.sprintboot.sprintboottemplate.common.generator.CodeGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class CodeGeneratorTest {

    @Resource
    private CodeGenerator codeGenerator;

    @Test
    void generateUser() {
        String path = "src/main/java/com/zpw/sprintboot/sprintboottemplate/system/entity/";
        String entityPackage = "cn.zpw.sprintboot.sprintboottemplate.system.business.entity";
        codeGenerator.generateEntity(path, entityPackage, "system_user", "User");
    }

    @Test
    void generatePermission() {
        String basePath = "com/zpw/sprintboot/sprintboottemplate/system";
        codeGenerator.generate(basePath, "system_permission", "Permission");
    }

    @Test
    void generateRole() {
        String basePath = "com/zpw/sprintboot/sprintboottemplate/system";
        codeGenerator.generate(basePath, "system_permission", "Role");
    }
}

