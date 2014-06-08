package com.moonlightcheese.storage.database.schema.tables;

import com.java.sql.ColumnTypes;
import com.moonlightcheese.storage.database.Column;
import com.moonlightcheese.storage.database.ColumnType;
import com.moonlightcheese.storage.database.Table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jarrod
 * Date: 6/7/14
 * Time: 9:37 PM
 *
 * the CallTable schema
 */
public class CallTable extends Table {

    //COLUMN DEFINITIONS
    private static final NumberColumn m_NumberColumn    = new NumberColumn();
    private static final IDColumn m_IDColumn            = new IDColumn();

    //COLUMN NAMES
    public static final String ID                   = "id";
    public static final String PHONE_NUMBER_ID      = "phone_id";

    private CallTable() {
        super(
                "calls",
                Arrays.asList(new Column[] {
                        m_IDColumn,
                        m_NumberColumn
                })
        );
    }

    //NumberColumn
    public static class IDColumn extends Column {
        private IDColumn() {
            super(
                    PHONE_NUMBER_ID,
                    Arrays.asList(
                            new ColumnType[] {
                                    new ColumnType(ColumnTypes.INTEGER),
                                    new ColumnType(ColumnTypes.NOT_NULL)
                            }
                    )
            );
        }
    }

    //NumberColumn
    public static class NumberColumn extends Column {
        private NumberColumn() {
            super(
                    ID,
                    Arrays.asList(
                            new ColumnType[] {
                                    new ColumnType(ColumnTypes.INTEGER),
                                    new ColumnType(ColumnTypes.NOT_NULL)
                            }
                    )
            );
        }
    }
}
