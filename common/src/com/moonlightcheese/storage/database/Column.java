package com.moonlightcheese.storage.database;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jarrod
 * Date: 6/7/14
 * Time: 9:17 PM
 *
 * this is the abstract column class.
 */
public abstract class Column {
    private final List m_ColumnTypes = new ArrayList<ColumnType>();
    private static String m_ColumnName;

    public Column(String columnName, List<ColumnType> types) {
        m_ColumnName = columnName;
        setColumnTypes(types);
    }

    public static String getColumnName() {
        return m_ColumnName;
    }

    /**
     *
     * @return the SQL types for this column.
     */
    public List<ColumnType> getColumnTypes() {
        /**
         * at the time of this writing... the {@link m_Columns} variable can't be null, but we
         * check just to make sure someone hasn't screwed something up.  if you are getting exceptions from here,
         * it is most certainly programmer error, and you are doing something wrong.  setup the columns...
         */
        if(m_ColumnTypes == null || m_ColumnTypes.isEmpty()) {
            throw new IllegalStateException("no column types are defined for this column.  this is a developer error.  please report to support.");
        } else {
            return m_ColumnTypes;
        }
    }

    /**
     * clear the column types and set new types.
     * @param types
     */
    public void setColumnTypes(List<ColumnType> types) {
        if(m_ColumnTypes != null) {
            if(!m_ColumnTypes.isEmpty())
                m_ColumnTypes.clear();
            m_ColumnTypes.addAll(types);
        } else {
            throw new IllegalArgumentException("no column types are defined for this column.  this is a developer error.  please report to support.");
        }
    }
}
