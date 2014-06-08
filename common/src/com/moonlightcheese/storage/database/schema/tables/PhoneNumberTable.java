package com.moonlightcheese.storage.database.schema.tables;

import com.java.sql.ColumnTypes;
import com.moonlightcheese.storage.database.Column;
import com.moonlightcheese.storage.database.ColumnType;
import com.moonlightcheese.storage.database.Table;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: jarrod
 * Date: 6/8/14
 * Time: 1:08 AM
 * To change this template use File | Settings | File Templates.
 */
public class PhoneNumberTable extends Table {
    //COLUMN DEFINITIONS
    private static final IDColumn m_IDColumn                = new IDColumn();
    private static final AreaCodeColumn m_AreaCodeColumn    = new AreaCodeColumn();
    private static final PrefixColumn m_PrefixColumn        = new PrefixColumn();
    private static final LineColumn m_LineColumn            = new LineColumn();

    //COLUMN NAMES
    public static final String ID                   = "id";
    public static final String AREA_CODE            = "area_code";
    public static final String PREFIX               = "prefix";
    public static final String LINE                 = "line";

    /**
     * public constructor
     */
    public PhoneNumberTable() {
        super(
                "phone_numbers",
                Arrays.asList(
                        new Column[] {
                                m_IDColumn,
                                m_AreaCodeColumn,
                                m_PrefixColumn,
                                m_LineColumn
                        }
                ));
    }

    //IDColumn
    public static class IDColumn extends Column {
        private IDColumn() {
            super(
                    ID,
                    Arrays.asList(
                            new ColumnType[]{
                                    new ColumnType(ColumnTypes.INTEGER),
                                    new ColumnType(ColumnTypes.NOT_NULL)
                            }
                    )
            );
        }
    }

    public static class AreaCodeColumn extends Column {
        private AreaCodeColumn() {
            super(
                    AREA_CODE,
                    Arrays.asList(
                            new ColumnType[]{
                                    new ColumnType(ColumnTypes.INTEGER),
                                    new ColumnType(ColumnTypes.NOT_NULL)
                            }
                    )
            );
        }
    }

    public static class PrefixColumn extends Column {
        private PrefixColumn() {
            super(
                    PREFIX,
                    Arrays.asList(
                            new ColumnType[]{
                                    new ColumnType(ColumnTypes.INTEGER),
                                    new ColumnType(ColumnTypes.NOT_NULL)
                            }
                    )
            );
        }
    }

    public static class LineColumn extends Column {
        private LineColumn() {
            super(
                    LINE,
                    Arrays.asList(
                            new ColumnType[]{
                                    new ColumnType(ColumnTypes.INTEGER),
                                    new ColumnType(ColumnTypes.NOT_NULL)
                            }
                    )
            );
        }
    }
}
