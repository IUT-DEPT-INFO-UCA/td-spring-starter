package org.uca.iut.info.s3atdspring.service.config;

import java.util.Locale;

import org.uca.iut.info.s3atdspring.service.users.data.UserData;

import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTableType;

public class UserTypeRegistryConfigurer implements TypeRegistryConfigurer {

    @Override
    public Locale locale() {
        return Locale.ENGLISH;
    }

    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry) {
        typeRegistry.defineDataTableType(new DataTableType(UserData.class, new UserTransformer()));
    }


}
