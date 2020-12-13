package org.uca.iut.info.s3atdspring.service.config;

import java.util.ArrayList;
import java.util.List;

import org.uca.iut.info.s3atdspring.service.users.data.UserData;

import io.cucumber.datatable.DataTable;
import io.cucumber.datatable.TableTransformer;

public class UserTransformer implements TableTransformer<List<UserData>> {

    @Override
    public List<UserData> transform(DataTable table) throws Throwable {

        final List<UserData> users = new ArrayList<UserData>();

        table.cells()
        .stream()
        .skip(1)        // Skip header row
                .map(fields -> new UserData(Long.parseLong(fields.get(0)), fields.get(1), fields.get(2)))
        .forEach(users::add);

        return users;
    }

}
